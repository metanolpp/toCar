package com.example.tocar.voice

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.speech.tts.TextToSpeech
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.example.tocar.MainActivity
import com.example.tocar.R
import com.example.tocar.bluetooth.AndroidBluetoothController
import com.example.tocar.bluetooth.BluetoothConnectionState
import com.example.tocar.logging.PacketLogger
import com.example.tocar.preset.PresetRepository
import com.example.tocar.protocol.CommandEncoder
import com.example.tocar.protocol.RadioCommand
import com.example.tocar.repository.RadioRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import java.util.Locale

class BackgroundVoiceService : Service(), RecognitionListener {
    private val serviceScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)
    private val handler = Handler(Looper.getMainLooper())
    private val voiceParser = VoiceCommandParser()
    private val musicSearchEngine = MusicSearchEngine()
    private val logger = PacketLogger()

    private lateinit var bluetoothController: AndroidBluetoothController
    private lateinit var radioRepository: RadioRepository
    private lateinit var presetRepository: PresetRepository
    private var speechRecognizer: SpeechRecognizer? = null
    private var textToSpeech: TextToSpeech? = null
    private var pendingMusicChoices: List<MusicEntry> = emptyList()
    private var listening = false

    override fun onCreate() {
        super.onCreate()
        bluetoothController = AndroidBluetoothController(this, serviceScope)
        radioRepository = RadioRepository(
            bluetoothController = bluetoothController,
            encoder = CommandEncoder(),
            logger = logger,
            scope = serviceScope
        )
        presetRepository = PresetRepository(this)
        textToSpeech = TextToSpeech(this) { status ->
            if (status == TextToSpeech.SUCCESS) {
                textToSpeech?.language = Locale.forLanguageTag("pt-BR")
            }
        }
        createNotificationChannel()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent?.action == ACTION_STOP) {
            stopSelf()
            return START_NOT_STICKY
        }

        startForeground(NOTIFICATION_ID, buildNotification("Ouvindo comandos de voz"))
        connectLikelyRoadstar()
        startListeningLoop()
        return START_STICKY
    }

    override fun onDestroy() {
        listening = false
        handler.removeCallbacksAndMessages(null)
        speechRecognizer?.destroy()
        speechRecognizer = null
        textToSpeech?.shutdown()
        textToSpeech = null
        bluetoothController.disconnect()
        serviceScope.cancel()
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onReadyForSpeech(params: Bundle?) = Unit
    override fun onBeginningOfSpeech() = Unit
    override fun onRmsChanged(rmsdB: Float) = Unit
    override fun onBufferReceived(buffer: ByteArray?) = Unit
    override fun onEndOfSpeech() = Unit
    override fun onPartialResults(partialResults: Bundle?) = Unit
    override fun onEvent(eventType: Int, params: Bundle?) = Unit

    override fun onError(error: Int) {
        if (listening) restartListening(delayMs = 900L)
    }

    override fun onResults(results: Bundle?) {
        val text = results
            ?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
            ?.firstOrNull()
            .orEmpty()
        if (text.isNotBlank()) handleVoiceText(text)
        if (listening) restartListening(delayMs = 450L)
    }

    private fun startListeningLoop() {
        if (!hasAudioPermission() || !SpeechRecognizer.isRecognitionAvailable(this)) {
            speak("Permissao de microfone ou reconhecimento de voz indisponivel.")
            stopSelf()
            return
        }

        listening = true
        if (speechRecognizer == null) {
            speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this).also {
                it.setRecognitionListener(this)
            }
        }
        restartListening(delayMs = 200L)
    }

    private fun restartListening(delayMs: Long) {
        handler.postDelayed({
            if (!listening) return@postDelayed
            runCatching { speechRecognizer?.cancel() }
            runCatching {
                speechRecognizer?.startListening(
                    Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                        putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
                        putExtra(RecognizerIntent.EXTRA_LANGUAGE, "pt-BR")
                        putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS, false)
                        putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 3)
                    }
                )
            }
        }, delayMs)
    }

    private fun handleVoiceText(text: String) {
        radioRepository.setVoiceText(text)

        if (pendingMusicChoices.isNotEmpty()) {
            val index = musicSearchEngine.optionFromVoice(text, pendingMusicChoices.size)
            if (index != null) {
                val selected = pendingMusicChoices[index]
                pendingMusicChoices = emptyList()
                send(RadioCommand.SelectFolderTrack(selected.folder, selected.track), "Tocando ${selected.spokenLabel}")
                return
            }
            speak("Diga uma opcao de 1 a ${pendingMusicChoices.size}.")
            return
        }

        val presetName = voiceParser.parsePresetName(text)
        if (presetName != null && applyPreset(presetName)) return

        when (val result = musicSearchEngine.searchVoiceText(text)) {
            MusicSearchResult.NoQuery -> {
                val command = voiceParser.parse(text)
                if (command != null) {
                    send(command, "Comando reconhecido")
                } else {
                    speak("Nao encontrei esse comando.")
                }
            }
            is MusicSearchResult.NotFound -> speak("Nao encontrei musica parecida com ${result.query}.")
            is MusicSearchResult.Single -> send(
                RadioCommand.SelectFolderTrack(result.entry.folder, result.entry.track),
                "Tocando ${result.entry.spokenLabel}"
            )
            is MusicSearchResult.Multiple -> {
                pendingMusicChoices = result.entries
                val options = result.entries.mapIndexed { index, entry ->
                    "${index + 1}, ${entry.spokenLabel}"
                }.joinToString(". ")
                speak("Encontrei ${result.entries.size} musicas parecidas. Qual voce quer? $options.")
            }
        }
    }

    private fun applyPreset(name: String): Boolean {
        val preset = presetRepository.presets.value.firstOrNull {
            it.name.equals(name, ignoreCase = true) || it.name.contains(name, ignoreCase = true)
        } ?: run {
            speak("Nao encontrei o preset $name.")
            return true
        }

        preset.commands().forEach { radioRepository.send(it) }
        speak("Preset ${preset.name} aplicado.")
        return true
    }

    private fun send(command: RadioCommand, spokenResponse: String) {
        radioRepository.send(command)
        speak(spokenResponse)
    }

    private fun connectLikelyRoadstar() {
        if (!bluetoothController.hasRequiredPermissions()) return
        bluetoothController.refreshBondedDevices()
        val device = bluetoothController.devices.value.firstOrNull { it.isLikelyRoadstar }
            ?: bluetoothController.devices.value.firstOrNull()
            ?: return
        bluetoothController.connect(device) { packet -> radioRepository.onRxPacket(packet) }
        radioRepository.onConnectedDevice((bluetoothController.connectionState.value as? BluetoothConnectionState.Connected)?.device?.name)
    }

    private fun hasAudioPermission(): Boolean =
        ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED

    private fun speak(message: String) {
        textToSpeech?.speak(message, TextToSpeech.QUEUE_FLUSH, null, "tocar-background-voice")
        val notificationManager = getSystemService(NotificationManager::class.java)
        notificationManager.notify(NOTIFICATION_ID, buildNotification(message))
    }

    private fun buildNotification(message: String) =
        NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("ToCar ouvindo")
            .setContentText(message)
            .setOngoing(true)
            .setOnlyAlertOnce(true)
            .setContentIntent(openAppIntent())
            .addAction(0, "Parar", stopIntent())
            .build()

    private fun openAppIntent(): PendingIntent =
        PendingIntent.getActivity(
            this,
            1,
            Intent(this, MainActivity::class.java),
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

    private fun stopIntent(): PendingIntent =
        PendingIntent.getService(
            this,
            2,
            Intent(this, BackgroundVoiceService::class.java).setAction(ACTION_STOP),
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) return
        val channel = NotificationChannel(
            CHANNEL_ID,
            "Comandos de voz ToCar",
            NotificationManager.IMPORTANCE_LOW
        )
        getSystemService(NotificationManager::class.java).createNotificationChannel(channel)
    }

    companion object {
        const val ACTION_STOP = "com.example.tocar.voice.STOP"
        private const val CHANNEL_ID = "tocar_voice_service"
        private const val NOTIFICATION_ID = 2751
    }
}

