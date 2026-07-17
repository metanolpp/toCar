package com.example.tocar.ui.app

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.speech.RecognizerIntent
import android.speech.tts.TextToSpeech
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tocar.bluetooth.AndroidBluetoothController
import com.example.tocar.bluetooth.BluetoothConnectionState
import com.example.tocar.bluetooth.BluetoothDeviceInfo
import com.example.tocar.bluetooth.BluetoothTransport
import com.example.tocar.bluetooth.ControllerBackend
import com.example.tocar.bluetooth.DemoRadioController
import com.example.tocar.bluetooth.DesktopBridgeController
import com.example.tocar.logging.PacketLogEntry
import com.example.tocar.logging.PacketLogger
import com.example.tocar.preset.AudioPreset
import com.example.tocar.preset.PresetRepository
import com.example.tocar.protocol.CommandEncoder
import com.example.tocar.protocol.EqPreset
import com.example.tocar.protocol.PanelColor
import com.example.tocar.protocol.RadioCommand
import com.example.tocar.protocol.RadioMode
import com.example.tocar.protocol.RadioRanges
import com.example.tocar.protocol.RadioState
import com.example.tocar.protocol.parseHexPacket
import com.example.tocar.repository.RadioRepository
import com.example.tocar.voice.MusicEntry
import com.example.tocar.voice.MusicSearchEngine
import com.example.tocar.voice.MusicSearchResult
import com.example.tocar.voice.PlaylistCatalog
import com.example.tocar.voice.BackgroundVoiceService
import com.example.tocar.voice.VoiceCommandParser
import com.example.tocar.ui.components.retro.RetroBottomNavigation
import com.example.tocar.ui.components.retro.RetroBluetoothSignal
import com.example.tocar.ui.components.retro.RetroButton
import com.example.tocar.ui.components.retro.RetroLevelMeter
import com.example.tocar.ui.components.retro.RetroPanel
import com.example.tocar.ui.components.retro.RetroPlayerFrame
import com.example.tocar.ui.components.retro.RetroSectionTitle
import com.example.tocar.ui.components.retro.RetroSegmentedBar
import com.example.tocar.ui.components.retro.RetroSourceButton
import com.example.tocar.ui.components.retro.RetroTransportButton
import com.example.tocar.ui.components.retro.RetroWindowHeader
import com.example.tocar.ui.theme.retro.RetroColors
import java.util.Locale

private enum class ToCarTab(val label: String) {
    Connect("Conexao"),
    Controls("Player"),
    Files("Playlist"),
    Audio("Equalizador"),
    Log("Log")
}

@Composable
fun ToCarApp() {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val logger = remember { PacketLogger() }
    val presetRepository = remember { PresetRepository(context) }
    var controllerBackend by remember { mutableStateOf(ControllerBackend.AndroidBle) }
    val androidController = remember { AndroidBluetoothController(context, scope) }
    val demoController = remember { DemoRadioController(scope) }
    val desktopBridgeController = remember { DesktopBridgeController(context, scope) }
    val bluetoothController = when (controllerBackend) {
        ControllerBackend.AndroidBle -> androidController
        ControllerBackend.DesktopBridge -> desktopBridgeController
        ControllerBackend.Demo -> demoController
    }
    val repository = remember(bluetoothController) {
        RadioRepository(
            bluetoothController = bluetoothController,
            encoder = CommandEncoder(),
            logger = logger,
            scope = scope
        )
    }
    val voiceParser = remember { VoiceCommandParser() }
    val playlistCatalog = remember { PlaylistCatalog(context) }
    val musicSearchEngine = remember(playlistCatalog) { MusicSearchEngine { playlistCatalog.entries.value } }
    var pendingMusicChoices by remember { mutableStateOf<List<MusicEntry>>(emptyList()) }
    var textToSpeech by remember { mutableStateOf<TextToSpeech?>(null) }

    DisposableEffect(bluetoothController) {
        onDispose { bluetoothController.disconnect() }
    }

    DisposableEffect(context) {
        val tts = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                textToSpeech?.language = Locale.forLanguageTag("pt-BR")
            }
        }
        textToSpeech = tts
        onDispose { tts.shutdown() }
    }

    fun speak(message: String) {
        textToSpeech?.speak(message, TextToSpeech.QUEUE_FLUSH, null, "tocar-voice")
    }

    fun playMusicEntry(entry: MusicEntry, origin: String) {
        val command = RadioCommand.SelectFolderTrack(folder = entry.folder, track = entry.track)
        logger.app("$origin: ${entry.spokenLabel} -> pasta ${entry.folder}, musica ${entry.track}")
        repository.send(command)
        speak("Tocando ${entry.spokenLabel}")
    }

    fun handleVoiceText(text: String, origin: String) {
        repository.setVoiceText(text)

        if (pendingMusicChoices.isNotEmpty()) {
            val selectedIndex = musicSearchEngine.optionFromVoice(text, pendingMusicChoices.size)
            if (selectedIndex != null) {
                val selected = pendingMusicChoices[selectedIndex]
                pendingMusicChoices = emptyList()
                playMusicEntry(selected, origin)
                return
            }
            speak("Nao entendi a opcao. Diga um numero de 1 a ${pendingMusicChoices.size}.")
            logger.blocked("$origin aguardando opcao de musica: \"$text\"")
            return
        }

        val presetName = voiceParser.parsePresetName(text)
        if (presetName != null) {
            val preset = presetRepository.presets.value.firstOrNull {
                it.name.equals(presetName, ignoreCase = true) || it.name.contains(presetName, ignoreCase = true)
            }
            if (preset != null) {
                preset.commands().forEach(repository::send)
                logger.app("$origin aplicou preset: ${preset.name}")
                speak("Preset ${preset.name} aplicado.")
            } else {
                logger.blocked("$origin preset nao encontrado: \"$presetName\"")
                speak("Nao encontrei o preset $presetName.")
            }
            return
        }

        when (val result = musicSearchEngine.searchVoiceText(text)) {
            MusicSearchResult.NoQuery -> {
                val command = voiceParser.parse(text)
                if (command != null) {
                    repository.send(command)
                    logger.app("$origin: \"$text\" -> ${commandLabel(command)}")
                } else {
                    speak("Nao encontrei esse comando.")
                    logger.blocked("$origin sem comando reconhecido: \"$text\"")
                }
            }
            is MusicSearchResult.NotFound -> {
                speak("Nao encontrei musica parecida com ${result.query}.")
                logger.blocked("$origin musica nao encontrada: \"${result.query}\"")
            }
            is MusicSearchResult.Single -> {
                playMusicEntry(result.entry, origin)
            }
            is MusicSearchResult.Multiple -> {
                pendingMusicChoices = result.entries
                val options = result.entries.mapIndexed { index, entry ->
                    "${index + 1}, ${entry.spokenLabel}"
                }.joinToString(". ")
                val message = "Encontrei ${result.entries.size} musicas parecidas. Qual voce quer? $options."
                speak(message)
                logger.app("$origin encontrou ${result.entries.size} opcoes para \"${result.query}\"")
            }
        }
    }

    val radioState by repository.radioState.collectAsState()
    val devices by bluetoothController.devices.collectAsState()
    val connectionState by bluetoothController.connectionState.collectAsState()
    val signalStrength by bluetoothController.signalStrength.collectAsState()
    val logs by logger.entries.collectAsState()
    val presets by presetRepository.presets.collectAsState()
    val playlistEntries by playlistCatalog.entries.collectAsState()
    var selectedTab by remember { mutableStateOf(ToCarTab.Controls) }
    var voiceEnabled by remember { mutableStateOf(false) }
    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) {
        bluetoothController.refreshBondedDevices()
    }

    val speechLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val text = result.data
                ?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                ?.firstOrNull()
                .orEmpty()
            handleVoiceText(text, "Voz")
        }
    }

    LaunchedEffect(bluetoothController) {
        if (bluetoothController.hasRequiredPermissions()) {
            bluetoothController.refreshBondedDevices()
        }
    }

    LaunchedEffect(connectionState) {
        when (val state = connectionState) {
            is BluetoothConnectionState.Connected -> repository.onConnectedDevice(state.device.name)
            BluetoothConnectionState.Disconnected,
            is BluetoothConnectionState.Error,
            BluetoothConnectionState.PermissionRequired,
            BluetoothConnectionState.Unsupported -> repository.onDisconnected()
            BluetoothConnectionState.Scanning,
            is BluetoothConnectionState.Connecting -> Unit
        }
    }

    Scaffold(
        bottomBar = {
            RetroBottomNavigation(
                labels = ToCarTab.entries.map { it.label },
                selectedIndex = ToCarTab.entries.indexOf(selectedTab),
                onSelected = { selectedTab = ToCarTab.entries[it] }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(padding)
        ) {
            StatusHeader(radioState, connectionState, signalStrength) { repository.send(RadioCommand.PowerToggle) }
            when (selectedTab) {
                ToCarTab.Connect -> BluetoothScreen(
                    connectionState = connectionState,
                    devices = devices,
                    onRequestPermissions = { permissionLauncher.launch(bluetoothController.requiredPermissions()) },
                    onRefresh = { bluetoothController.refreshBondedDevices() },
                    onConnect = { device ->
                        bluetoothController.connect(device) { packet -> repository.onRxPacket(packet) }
                    },
                    onDisconnect = { bluetoothController.disconnect() }
                )
                ToCarTab.Controls -> ControlsScreen(
                    radioState = radioState,
                    onCommand = repository::send,
                    onAddCurrent = {
                        val folder = radioState.currentFolder
                        val track = radioState.currentTrack
                        if (folder != null && track != null) {
                            val known = playlistEntries.firstOrNull { it.folder == folder && it.track == track }
                            playlistCatalog.add(
                                known ?: MusicEntry(
                                    title = "Faixa $track",
                                    artist = radioState.mode?.label,
                                    folder = folder,
                                    track = track
                                )
                            )
                        }
                    }
                )
                ToCarTab.Files -> FilesAndVoiceScreen(
                    radioState = radioState,
                    playlist = playlistEntries,
                    pendingMusicChoices = pendingMusicChoices,
                    voiceEnabled = voiceEnabled,
                    onCommand = repository::send,
                    onListen = {
                        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                            putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
                            putExtra(RecognizerIntent.EXTRA_LANGUAGE, "pt-BR")
                            putExtra(RecognizerIntent.EXTRA_PROMPT, "Diga uma musica ou comando")
                        }
                        speechLauncher.launch(intent)
                    },
                    onVoiceEnabledChange = { enabled ->
                        voiceEnabled = enabled
                        val intent = Intent(context, BackgroundVoiceService::class.java)
                        if (enabled) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) context.startForegroundService(intent)
                            else context.startService(intent)
                        } else {
                            context.stopService(intent)
                        }
                    },
                    onTypedVoice = { text -> handleVoiceText(text, "Texto") },
                    onAddMusic = playlistCatalog::add
                )
                ToCarTab.Audio -> AudioScreen(
                    radioState = radioState,
                    presets = presets,
                    onCommand = repository::send,
                    onSavePreset = { name -> presetRepository.saveFromState(name, radioState) },
                    onApplyPreset = { preset ->
                        preset.commands().forEach(repository::send)
                        logger.app("Preset aplicado: ${preset.name}")
                    },
                    onDeletePreset = presetRepository::delete
                )
                ToCarTab.Log -> LogScreen(logs, repository::send)
            }
        }
    }
}

@Composable
private fun StatusHeader(
    radioState: RadioState,
    connectionState: BluetoothConnectionState,
    signalStrength: Int?,
    onPowerClick: () -> Unit
) {
    RetroPlayerFrame {
      Column(Modifier.fillMaxWidth()) {
        RetroWindowHeader(
            title = "METANAMP",
            powerOn = radioState.powerOn,
            onPowerClick = onPowerClick
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(RetroColors.Background)
                .border(2.dp, RetroColors.BorderMedium)
                .padding(horizontal = 9.dp, vertical = 6.dp)
        ) {
            Column {
                Text("TOCAR // ROADSTAR PLAYER", color = RetroColors.NeonGreen, fontFamily = androidx.compose.ui.text.font.FontFamily.Monospace, fontWeight = FontWeight.Black, fontSize = 12.sp)
                Spacer(Modifier.height(2.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(if (radioState.connected) "▶" else "■", color = RetroColors.DisplayGreen, style = MaterialTheme.typography.titleLarge)
                    Spacer(Modifier.width(8.dp))
                    Text(
                        if (radioState.connected) radioState.volume.toString().padStart(2, '0') else "--:--",
                        color = RetroColors.DisplayGreen,
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Black
                    )
                    Spacer(Modifier.width(16.dp))
                    Column(Modifier.weight(1f)) {
                        if (!radioState.connected) {
                            RetroBluetoothSignal(connected = false, rssi = null)
                        } else {
                            Text((radioState.mode?.label ?: "BLUETOOTH") + " // PLAYLIST LOCAL", color = RetroColors.DisplayGreen, fontFamily = androidx.compose.ui.text.font.FontFamily.Monospace, fontWeight = FontWeight.Bold, fontSize = 11.sp)
                            RetroBluetoothSignal(connected = true, rssi = signalStrength)
                        }
                        Text("${radioState.eqPreset.label.uppercase(Locale.getDefault())} EQ    VOL ${radioState.volume}    ${if (radioState.loudness) "LOUD" else "NORMAL"}", color = RetroColors.DisplayGreen, fontSize = 8.sp)
                    }
                    RetroLevelMeter()
                }
                Spacer(Modifier.height(2.dp))
                Text(connectionLabel(connectionState).uppercase(Locale.getDefault()), color = RetroColors.TextSecondary, fontSize = 8.sp)
            }
        }
      }
    }
}

@Composable
private fun WinampTitleBar(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(27.dp)
            .background(Brush.horizontalGradient(listOf(Color(0xFF10121A), Color(0xFF55596A), Color(0xFF10121A))))
            .padding(horizontal = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("✣", color = Color(0xFFD4B96F), fontWeight = FontWeight.Black)
        Spacer(Modifier.width(8.dp))
        Box(Modifier.weight(1f).height(7.dp).background(Color(0xFFC0A45A)).border(1.dp, Color.Black))
        Text("  $title  ", color = Color(0xFFE0E0DB), fontWeight = FontWeight.Black)
        Box(Modifier.weight(1f).height(7.dp).background(Color(0xFFC0A45A)).border(1.dp, Color.Black))
        Spacer(Modifier.width(8.dp))
        Text("–  ×", color = Color(0xFFD4B96F), fontWeight = FontWeight.Black)
    }
}

@Composable
private fun LevelMeter() {
    Row(horizontalArrangement = Arrangement.spacedBy(3.dp), verticalAlignment = Alignment.Bottom) {
        listOf(12, 20, 29, 36).forEachIndexed { index, height ->
            Box(Modifier.width(7.dp).height(height.dp).background(if (index == 3) Color(0xFFC7BD38) else MaterialTheme.colorScheme.primary))
        }
    }
}

@Composable
private fun PlayerDisplay(
    radioState: RadioState,
    onCommand: (RadioCommand) -> Unit,
    onAddCurrent: () -> Unit
) {
    val sourceTitle = when (radioState.mode) {
        RadioMode.RADIO -> {
            val frequency = radioState.fmFrequencyMhz?.let { String.format(Locale.US, "%.1f FM", it) } ?: "--.- FM"
            val station = radioState.stationName?.takeIf { it.isNotBlank() } ?: "SEM RDS"
            "$frequency // $station"
        }
        RadioMode.USB -> "USB // PLAYLIST LOCAL"
        RadioMode.SD -> "SD // PLAYLIST LOCAL"
        RadioMode.BT -> "BLUETOOTH AUDIO"
        RadioMode.AUX_IN -> "AUX INPUT"
        RadioMode.COLOR -> "PAINEL RGB"
        null -> if (radioState.currentFolder != null && radioState.currentTrack != null) {
            "PASTA ${radioState.currentFolder} // FAIXA ${radioState.currentTrack}"
        } else {
            "CONTROLES DE REPRODUÇÃO"
        }
    }

    RetroPanel {
        Text(sourceTitle, color = RetroColors.NeonGreen, fontWeight = FontWeight.Black)
        Spacer(Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(5.dp), modifier = Modifier.fillMaxWidth()) {
            listOf(
                "|◀" to RadioCommand.PreviousTrack,
                "▶" to RadioCommand.PlayPause,
                "❚❚" to RadioCommand.PlayPause,
                "■" to RadioCommand.MuteToggle,
                "▶|" to RadioCommand.NextTrack
            ).forEach { (label, command) ->
                RetroTransportButton(label, Modifier.weight(1f)) { onCommand(command) }
            }
            RetroTransportButton("⇄ SHUFFLE", Modifier.weight(1.6f)) { onCommand(RadioCommand.RandomToggle) }
            RetroButton(
                label = "+",
                modifier = Modifier.weight(0.7f),
                enabled = radioState.currentFolder != null && radioState.currentTrack != null,
                height = 32.dp,
                onClick = onAddCurrent
            )
        }
    }
}

@Composable
private fun MetallicButton(label: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = modifier.height(43.dp).shadow(3.dp, RoundedCornerShape(1.dp)),
        shape = RoundedCornerShape(1.dp),
        border = BorderStroke(1.dp, Color(0xFF74777D)),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF292B2E), contentColor = MaterialTheme.colorScheme.primary),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(2.dp)
    ) { Text(label, fontWeight = FontWeight.Black) }
}

@Composable
private fun BluetoothScreen(
    connectionState: BluetoothConnectionState,
    devices: List<BluetoothDeviceInfo>,
    onRequestPermissions: () -> Unit,
    onRefresh: () -> Unit,
    onConnect: (BluetoothDeviceInfo) -> Unit,
    onDisconnect: () -> Unit
) {
    val busy = connectionState is BluetoothConnectionState.Connecting ||
        connectionState is BluetoothConnectionState.Scanning
    val connected = connectionState is BluetoothConnectionState.Connected

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(18.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            SectionTitle("Conectar ao radio")
            ControlPanel {
                Text("1. AUDIO BLUETOOTH", color = MaterialTheme.colorScheme.tertiary, fontWeight = FontWeight.Black)
                Text(
                    "Conecte primeiro o radio nas configuracoes Bluetooth do Android.",
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(Modifier.height(12.dp))
                Text("2. CONTROLE DO APLICATIVO", color = MaterialTheme.colorScheme.tertiary, fontWeight = FontWeight.Black)
                Text(
                    when (connectionState) {
                        is BluetoothConnectionState.Connected -> "Controle BLE conectado e pronto"
                        is BluetoothConnectionState.Connecting -> "Localizando RS-2751BR PLUS-APP e conectando..."
                        is BluetoothConnectionState.Error -> "Falha: ${connectionState.message}"
                        else -> "Escolha o radio na lista abaixo e toque em Conectar"
                    },
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Spacer(Modifier.height(12.dp))
            if (connected) {
                Button(onClick = onDisconnect, modifier = Modifier.fillMaxWidth()) {
                    Text("Desconectar controle")
                }
            }
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.fillMaxWidth()) {
                OutlinedButton(onClick = onRequestPermissions, enabled = !busy && !connected, modifier = Modifier.weight(1f)) {
                    Text("Permissoes")
                }
                OutlinedButton(onClick = onRefresh, enabled = !busy && !connected, modifier = Modifier.weight(1f)) {
                    Text("Atualizar lista")
                }
            }
        }
        items(devices) { device ->
            val connectingThis = (connectionState as? BluetoothConnectionState.Connecting)?.device == device
            val connectedThis = (connectionState as? BluetoothConnectionState.Connected)?.device == device
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = if (device.isLikelyRoadstar) MaterialTheme.colorScheme.primaryContainer
                    else MaterialTheme.colorScheme.surfaceContainer
                ),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(Modifier.weight(1f)) {
                        Text(device.name, fontWeight = FontWeight.SemiBold)
                        Text(device.address, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        Text(
                            when {
                                connectedThis -> "Controle conectado"
                                connectingThis -> "Tentando conectar..."
                                device.isLikelyRoadstar -> "Radio detectado"
                                else -> "Dispositivo Bluetooth pareado"
                            },
                            color = if (connectedThis) MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    Button(
                        onClick = { onConnect(device) },
                        enabled = !busy && !connected
                    ) {
                        Text(if (connectingThis) "Conectando..." else if (connectedThis) "Conectado" else "Conectar")
                    }
                }
            }
        }
        if (devices.isEmpty()) {
            item {
                EmptyState("Nenhum dispositivo pareado. Conecte o radio no Bluetooth do Android e toque em Atualizar lista.")
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ControlsScreen(
    radioState: RadioState,
    onCommand: (RadioCommand) -> Unit,
    onAddCurrent: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 4.dp, vertical = 3.dp),
        verticalArrangement = Arrangement.spacedBy(3.dp)
    ) {
        PlayerDisplay(radioState, onCommand, onAddCurrent)
        RetroSectionTitle("CONTROLES")
        RetroPanel {
            Text("COMANDOS MAPEADOS", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Black, fontSize = 12.sp)
            Text(
                "CONTROLES BÁSICOS PRESERVADOS DO CATÁLOGO LEGADO CARLIVE.",
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = 8.sp,
                maxLines = 1
            )
            Spacer(Modifier.height(4.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp), modifier = Modifier.fillMaxWidth()) {
                RetroButton("MODE", Modifier.weight(1f)) { onCommand(RadioCommand.ModeNext) }
                RetroButton("ANTERIOR", Modifier.weight(1f)) { onCommand(RadioCommand.PreviousTrack) }
                RetroButton("PRÓXIMA", Modifier.weight(1f)) { onCommand(RadioCommand.NextTrack) }
            }
        }

        RetroPanel {
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp), modifier = Modifier.fillMaxWidth()) {
                RetroButton("MUTE", Modifier.weight(1f)) { onCommand(RadioCommand.MuteToggle) }
                RetroButton("AMS", Modifier.weight(1f)) { onCommand(RadioCommand.Ams) }
                RetroButton("BAND", Modifier.weight(1f)) { onCommand(RadioCommand.Band) }
            }
        }

        RetroPanel(title = "FONTE") {
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp), modifier = Modifier.fillMaxWidth()) {
                listOf(RadioMode.RADIO, RadioMode.USB, RadioMode.SD, RadioMode.AUX_IN).forEach { mode ->
                    RetroSourceButton(mode.label, radioState.mode == mode, Modifier.weight(1f)) {
                        onCommand(RadioCommand.SetMode(mode))
                    }
                }
            }
            Spacer(Modifier.height(4.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp), modifier = Modifier.fillMaxWidth()) {
                RetroSourceButton("BLUETOOTH", radioState.mode == RadioMode.BT, Modifier.weight(2f)) {
                    onCommand(RadioCommand.SetMode(RadioMode.BT))
                }
                RetroSourceButton("COR", radioState.mode == RadioMode.COLOR, Modifier.weight(1f)) {
                    onCommand(RadioCommand.SetMode(RadioMode.COLOR))
                }
                RetroButton("CLOCK", Modifier.weight(1f), enabled = false) {}
            }
        }

        RetroPanel {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("VOLUME ${radioState.volume} / ${radioState.maxVolume}", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Black, fontSize = 12.sp, modifier = Modifier.weight(1f))
                RetroButton("−", Modifier.width(43.dp)) { onCommand(RadioCommand.VolumeDown) }
                Spacer(Modifier.width(6.dp))
                RetroButton("+", Modifier.width(43.dp)) { onCommand(RadioCommand.VolumeUp) }
            }
            RetroSegmentedBar(radioState.volume, radioState.maxVolume, Modifier.fillMaxWidth())
        }

        RetroPanel(title = "TRANSPORTE") {
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp), modifier = Modifier.fillMaxWidth()) {
                RetroButton("ANTERIOR", Modifier.weight(1f)) { onCommand(RadioCommand.PreviousTrack) }
                RetroButton("PLAY/PAUSE", Modifier.weight(1.2f)) { onCommand(RadioCommand.PlayPause) }
                RetroButton("PRÓXIMA", Modifier.weight(1f)) { onCommand(RadioCommand.NextTrack) }
            }
        }

        RetroPanel(title = "FUNÇÕES") {
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp), modifier = Modifier.fillMaxWidth()) {
                RetroButton("INT", Modifier.weight(1f)) { onCommand(RadioCommand.IntroToggle) }
                RetroButton("RPT", Modifier.weight(1f)) { onCommand(RadioCommand.RepeatToggle) }
                RetroButton("RDM", Modifier.weight(1f)) { onCommand(RadioCommand.RandomToggle) }
                RetroButton("-10", Modifier.weight(1f)) { onCommand(RadioCommand.SkipMinus10) }
            }
            Spacer(Modifier.height(4.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp), modifier = Modifier.fillMaxWidth()) {
                RetroButton("+10", Modifier.weight(1f)) { onCommand(RadioCommand.SkipPlus10) }
                RetroButton("DIR-", Modifier.weight(1f)) { onCommand(RadioCommand.DirectoryPrevious) }
                RetroButton("DIR+", Modifier.weight(1f)) { onCommand(RadioCommand.DirectoryNext) }
                RetroButton("LOUD", Modifier.weight(1f), active = radioState.loudness) { onCommand(RadioCommand.SetLoudness(!radioState.loudness)) }
            }
        }

        RetroPanel {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
                RetroButton("ATENDER  ☎", Modifier.weight(1f)) { onCommand(RadioCommand.CallAnswerOrRedial) }
                RetroButton("ENCERRAR  ☎", Modifier.weight(1f)) { onCommand(RadioCommand.CallEnd) }
            }
        }
    }
}

@Composable
private fun SourceButton(label: String, selected: Boolean, modifier: Modifier, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier.height(28.dp),
        shape = RoundedCornerShape(1.dp),
        border = BorderStroke(1.dp, if (selected) MaterialTheme.colorScheme.primary else Color(0xFF55585E)),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = if (selected) Color(0xFF416E20) else Color(0xFF202225),
            contentColor = MaterialTheme.colorScheme.primary
        ),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 2.dp)
    ) { Text(label, fontSize = 10.sp, fontWeight = FontWeight.Bold, maxLines = 1) }
}

@Composable
private fun DisplayOnlyButton(label: String, modifier: Modifier) {
    Box(
        modifier = modifier
            .height(28.dp)
            .background(Color(0xFF202225), RoundedCornerShape(1.dp))
            .border(1.dp, Color(0xFF55585E), RoundedCornerShape(1.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(label, color = MaterialTheme.colorScheme.primary, fontSize = 10.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun FilesAndVoiceScreen(
    radioState: RadioState,
    playlist: List<MusicEntry>,
    pendingMusicChoices: List<MusicEntry>,
    voiceEnabled: Boolean,
    onCommand: (RadioCommand) -> Unit,
    onListen: () -> Unit,
    onVoiceEnabledChange: (Boolean) -> Unit,
    onTypedVoice: (String) -> Unit,
    onAddMusic: (MusicEntry) -> Unit
) {
    var typedCommand by remember { mutableStateOf("quero this is ritmym of the night") }
    var newTitle by remember { mutableStateOf("") }
    var newFolder by remember { mutableStateOf("1") }
    var newTrack by remember { mutableStateOf("1") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(18.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        SectionTitle("Painel de playlist")
        ControlPanel {
            Text("WINAMP PLAYLIST // ${radioState.mode?.label?.uppercase(Locale.getDefault()) ?: "SEM FONTE"}", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Black)
            Spacer(Modifier.height(10.dp))
            if (playlist.isEmpty()) {
                Text("PLAYLIST VAZIA", color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
            playlist.forEachIndexed { index, entry ->
                Row(Modifier.fillMaxWidth().padding(vertical = 5.dp), verticalAlignment = Alignment.CenterVertically) {
                    Text("${index + 1}.", color = MaterialTheme.colorScheme.tertiary, modifier = Modifier.width(30.dp))
                    Column(Modifier.weight(1f)) {
                        Text(entry.spokenLabel, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.SemiBold)
                        Text("PASTA ${entry.folder} // FAIXA ${entry.track}", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                    OutlinedButton(onClick = { onCommand(RadioCommand.SelectFolderTrack(entry.folder, entry.track)) }) { Text("▶") }
                }
            }
            Spacer(Modifier.height(10.dp))
            OutlinedTextField(newTitle, { newTitle = it }, Modifier.fillMaxWidth(), label = { Text("Música ou nome da pasta") }, singleLine = true)
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(newFolder, { newFolder = it.filter(Char::isDigit) }, Modifier.weight(1f), label = { Text("Pasta") }, singleLine = true)
                OutlinedTextField(newTrack, { newTrack = it.filter(Char::isDigit) }, Modifier.weight(1f), label = { Text("Faixa") }, singleLine = true)
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(onClick = {
                    val folder = newFolder.toIntOrNull() ?: return@Button
                    val track = newTrack.toIntOrNull() ?: return@Button
                    if (newTitle.isNotBlank()) {
                        onAddMusic(MusicEntry(newTitle.trim(), folder = folder, track = track))
                        newTitle = ""
                    }
                }) { Text("ADD MÚSICA") }
                OutlinedButton(onClick = {
                    val folder = newFolder.toIntOrNull() ?: return@OutlinedButton
                    val title = newTitle.ifBlank { "Pasta $folder" }
                    onAddMusic(MusicEntry("[DIR] $title", folder = folder, track = 1))
                    newTitle = ""
                }) { Text("ADD PASTA") }
            }
            Text("Catálogo local. A leitura automática do USB depende de resposta compatível do rádio.", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
        ControlPanel {
            Text("Navegacao segura", fontWeight = FontWeight.SemiBold)
            Text(
                "Listagem real de pastas depende do protocolo. Por enquanto, a UI expõe DIR, saltos e um comando logico para pasta/musica.",
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(12.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Button(onClick = { onCommand(RadioCommand.DirectoryPrevious) }) { Text("DIR-") }
                Button(onClick = { onCommand(RadioCommand.DirectoryNext) }) { Text("DIR+") }
                OutlinedButton(onClick = { onCommand(RadioCommand.SkipMinus10) }) { Text("-10") }
                OutlinedButton(onClick = { onCommand(RadioCommand.SkipPlus10) }) { Text("+10") }
            }
        }

        ControlPanel {
            Text("Comando de voz", fontWeight = FontWeight.SemiBold)
            Text(
                "Exemplos: quero rhythm of the night, 1, musica 1 da pasta 4, proxima musica, modo usb, volume mais, eq rock.",
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(12.dp))
            RetroButton(
                label = if (voiceEnabled) "VOZ LIGADA" else "VOZ DESLIGADA",
                modifier = Modifier.fillMaxWidth(),
                active = voiceEnabled
            ) {
                onVoiceEnabledChange(!voiceEnabled)
            }
            Spacer(Modifier.height(8.dp))
            RetroButton(
                label = "BUSCAR MÚSICA POR VOZ",
                modifier = Modifier.fillMaxWidth(),
                enabled = voiceEnabled,
                onClick = onListen
            )
            Spacer(Modifier.height(12.dp))
            OutlinedTextField(
                value = typedCommand,
                onValueChange = { typedCommand = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Testar texto de voz") },
                singleLine = true
            )
            Spacer(Modifier.height(10.dp))
            OutlinedButton(onClick = { onTypedVoice(typedCommand) }, modifier = Modifier.fillMaxWidth(), enabled = voiceEnabled) {
                Text("Interpretar texto")
            }
            radioState.lastVoiceText?.let {
                Spacer(Modifier.height(10.dp))
                Text("Ultima voz: $it", color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }

        if (pendingMusicChoices.isNotEmpty()) {
            ControlPanel {
                Text("Escolha uma musica", fontWeight = FontWeight.SemiBold)
                Text("Responda por voz ou texto com o numero da opcao.", color = MaterialTheme.colorScheme.onSurfaceVariant)
                Spacer(Modifier.height(10.dp))
                pendingMusicChoices.forEachIndexed { index, entry ->
                    OutlinedButton(
                        onClick = { onTypedVoice("${index + 1}") },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("${index + 1}. ${entry.spokenLabel} - pasta ${entry.folder}, musica ${entry.track}")
                    }
                }
            }
        }

        ControlPanel {
            Text("Catalogo local demonstrativo", fontWeight = FontWeight.SemiBold)
            Text(
                "Este catalogo sera substituido pela lista real quando o protocolo permitir ler USB/SD.",
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(10.dp))
            playlist.take(8).forEach { entry ->
                Text("${entry.spokenLabel} - pasta ${entry.folder}, musica ${entry.track}")
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun AudioScreen(
    radioState: RadioState,
    presets: List<AudioPreset>,
    onCommand: (RadioCommand) -> Unit,
    onSavePreset: (String) -> Unit,
    onApplyPreset: (AudioPreset) -> Unit,
    onDeletePreset: (Long) -> Unit
) {
    var presetName by remember { mutableStateOf("Meu preset") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(18.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        SectionTitle("Painel de equalizador")
        ControlPanel {
            Text("Equalizador", fontWeight = FontWeight.SemiBold)
            Spacer(Modifier.height(8.dp))
            FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                EqPreset.entries.forEach { preset ->
                    FilterChip(
                        selected = radioState.eqPreset == preset,
                        onClick = { onCommand(RadioCommand.SetEq(preset)) },
                        label = { Text(preset.label) }
                    )
                }
            }
        }

        SettingSlider("BAS", radioState.bass, RadioRanges.BASS_MIN, RadioRanges.BASS_MAX) {
            onCommand(RadioCommand.SetBass(it))
        }
        SettingSlider("TRE", radioState.treble, RadioRanges.TREBLE_MIN, RadioRanges.TREBLE_MAX) {
            onCommand(RadioCommand.SetTreble(it))
        }
        SettingSlider("BAL", radioState.balance, RadioRanges.BALANCE_MIN, RadioRanges.BALANCE_MAX) {
            onCommand(RadioCommand.SetBalance(it))
        }
        SettingSlider("FAD", radioState.fader, RadioRanges.FADER_MIN, RadioRanges.FADER_MAX) {
            onCommand(RadioCommand.SetFader(it))
        }

        ControlPanel {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(Modifier.weight(1f)) {
                    Text("Loudness", fontWeight = FontWeight.SemiBold)
                    Text("ON/OFF conforme funcao do painel", color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
                Switch(
                    checked = radioState.loudness,
                    onCheckedChange = { onCommand(RadioCommand.SetLoudness(it)) }
                )
            }
        }

        ControlPanel {
            Text("Cor do painel", fontWeight = FontWeight.SemiBold)
            Text(
                "Salva no preset e gera comando logico. O envio real depende do pacote confirmado do CarLive.",
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(8.dp))
            FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                PanelColor.entries.forEach { color ->
                    FilterChip(
                        selected = radioState.panelColor == color,
                        onClick = { onCommand(RadioCommand.SetPanelColor(color)) },
                        label = {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    modifier = Modifier
                                        .size(12.dp)
                                        .clip(CircleShape)
                                        .background(color.toComposeColor())
                                )
                                Spacer(Modifier.width(6.dp))
                                Text(color.label)
                            }
                        }
                    )
                }
            }
        }

        ControlPanel {
            Text("Presets", fontWeight = FontWeight.SemiBold)
            Text(
                "Salva EQ, BAS, TRE, BAL, FAD, LOUD e cor do painel.",
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(10.dp))
            OutlinedTextField(
                value = presetName,
                onValueChange = { presetName = it },
                label = { Text("Nome do preset") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            Spacer(Modifier.height(10.dp))
            Button(
                onClick = { onSavePreset(presetName) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Salvar preset atual")
            }
            Spacer(Modifier.height(12.dp))
            presets.forEach { preset ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                ) {
                    Column(Modifier.padding(12.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(14.dp)
                                    .clip(CircleShape)
                                    .background(preset.panelColor.toComposeColor())
                            )
                            Spacer(Modifier.width(8.dp))
                            Text(preset.name, fontWeight = FontWeight.SemiBold, modifier = Modifier.weight(1f))
                            Text(if (preset.loudness) "LOUD ON" else "LOUD OFF")
                        }
                        Text(
                            "EQ ${preset.eqPreset.label} | BAS ${preset.bass.formatSigned()} | TRE ${preset.treble.formatSigned()} | ${preset.panelColor.label}",
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(Modifier.height(8.dp))
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Button(onClick = { onApplyPreset(preset) }) { Text("Aplicar") }
                            OutlinedButton(onClick = { onDeletePreset(preset.id) }) { Text("Apagar") }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun LogScreen(
    logs: List<PacketLogEntry>,
    onCommand: (RadioCommand) -> Unit
) {
    var rawHex by remember { mutableStateOf("") }
    var rawError by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        SectionTitle("Log TX/RX")
        ControlPanel {
            Text("Raw seguro", fontWeight = FontWeight.SemiBold)
            Text("Use somente bytes capturados do CarLive. Limite: ${CommandEncoder.MAX_RAW_PACKET_SIZE} bytes.", color = MaterialTheme.colorScheme.onSurfaceVariant)
            Spacer(Modifier.height(10.dp))
            OutlinedTextField(
                value = rawHex,
                onValueChange = {
                    rawHex = it
                    rawError = null
                },
                label = { Text("AA 55 03 10 01 0F") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                isError = rawError != null
            )
            rawError?.let { Text(it, color = MaterialTheme.colorScheme.error) }
            Spacer(Modifier.height(10.dp))
            Button(
                onClick = {
                    parseHexPacket(rawHex)
                        .onSuccess { onCommand(RadioCommand.Raw(it)) }
                        .onFailure { rawError = it.message }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Enviar Raw")
            }
        }

        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.weight(1f)) {
            items(logs) { entry ->
                Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainer)) {
                    Column(Modifier.padding(12.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(entry.time, style = MaterialTheme.typography.labelMedium)
                            Spacer(Modifier.width(8.dp))
                            Text(entry.direction.name, fontWeight = FontWeight.Bold)
                            Spacer(Modifier.width(8.dp))
                            Text(entry.label, modifier = Modifier.weight(1f))
                            if (entry.size > 0) Text("${entry.size} B")
                        }
                        if (entry.hex.isNotBlank()) {
                            Spacer(Modifier.height(4.dp))
                            Text(entry.hex, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                    }
                }
            }
            if (logs.isEmpty()) {
                item { EmptyState("Os comandos, bloqueios seguros e pacotes RX/TX aparecem aqui.") }
            }
        }
    }
}

@Composable
private fun SettingSlider(
    label: String,
    value: Int,
    min: Int,
    max: Int,
    onValueChange: (Int) -> Unit
) {
    ControlPanel {
        Text("$label ${value.formatSigned()}", fontWeight = FontWeight.SemiBold)
        Slider(
            value = value.toFloat(),
            onValueChange = { onValueChange(it.toInt()) },
            valueRange = min.toFloat()..max.toFloat(),
            steps = (max - min - 1).coerceAtLeast(0)
        )
    }
}

@Composable
private fun ControlPanel(content: @Composable () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(2.dp),
        color = MaterialTheme.colorScheme.surfaceContainerHigh,
        tonalElevation = 0.dp,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
    ) {
        Column(Modifier.padding(horizontal = 7.dp, vertical = 5.dp)) {
            content()
        }
    }
}

@Composable
private fun ActionButton(label: String, selected: Boolean = false, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        colors = if (selected) {
            ButtonDefaults.outlinedButtonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            )
        } else {
            ButtonDefaults.outlinedButtonColors()
        },
        shape = RoundedCornerShape(2.dp),
        border = BorderStroke(width = 1.dp, color = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline)
    ) {
        Text(label.uppercase(Locale.getDefault()), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun SectionTitle(text: String) {
    Text("[ ${text.uppercase(Locale.getDefault())} ]", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Black, color = MaterialTheme.colorScheme.primary)
}

@Composable
private fun EmptyState(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(28.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text, textAlign = TextAlign.Center, color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
}

private fun connectionLabel(state: BluetoothConnectionState): String = when (state) {
    BluetoothConnectionState.Unsupported -> "Bluetooth indisponivel neste aparelho"
    BluetoothConnectionState.PermissionRequired -> "Permissoes Bluetooth/Localizacao pendentes"
    BluetoothConnectionState.Disconnected -> "Desconectado"
    BluetoothConnectionState.Scanning -> "Buscando dispositivos"
    is BluetoothConnectionState.Connecting -> "Conectando em ${state.device.name}"
    is BluetoothConnectionState.Connected -> "Conectado em ${state.device.name}"
    is BluetoothConnectionState.Error -> "Erro: ${state.message}"
}

private val BluetoothTransport.label: String
    get() = when (this) {
        BluetoothTransport.Ble -> "BLE"
        BluetoothTransport.Classic -> "Audio"
    }

private fun Int.formatSigned(): String = String.format(Locale.US, "%+03d", this)

private fun PanelColor.toComposeColor(): Color =
    Color(android.graphics.Color.parseColor(hex))

private fun commandLabel(command: RadioCommand): String = when (command) {
    is RadioCommand.SelectFolderTrack -> "pasta ${command.folder}, musica ${command.track}"
    RadioCommand.NextStation -> "proxima sintonia"
    RadioCommand.PreviousStation -> "sintonia anterior"
    else -> command::class.simpleName ?: "RadioCommand"
}

@Composable
private fun RetroPlayerPreviewContent(state: RadioState) {
    Column(Modifier.fillMaxSize().background(RetroColors.Background)) {
        StatusHeader(
            state,
            if (state.connected) BluetoothConnectionState.Connected(BluetoothDeviceInfo("RS-2751BR PLUS", "00:00:00:00:00:00", true)) else BluetoothConnectionState.Disconnected,
            if (state.connected) -58 else null
        ) {}
        ControlsScreen(radioState = state, onCommand = {})
    }
}

@Preview(name = "Player conectado", widthDp = 360, heightDp = 900)
@Composable private fun PreviewConnected() = RetroPlayerPreviewContent(RadioState(connected = true, powerOn = true, deviceName = "RS-2751BR PLUS", mode = RadioMode.USB, volume = 12))

@Preview(name = "Player desconectado", widthDp = 360, heightDp = 900)
@Composable private fun PreviewDisconnected() = RetroPlayerPreviewContent(RadioState())

@Preview(name = "USB selecionado", widthDp = 360, heightDp = 900)
@Composable private fun PreviewUsb() = RetroPlayerPreviewContent(RadioState(mode = RadioMode.USB, volume = 24))

@Preview(name = "Bluetooth selecionado", widthDp = 360, heightDp = 900)
@Composable private fun PreviewBluetooth() = RetroPlayerPreviewContent(RadioState(mode = RadioMode.BT, volume = 24))

@Preview(name = "Reprodução ativa", widthDp = 360, heightDp = 900)
@Composable private fun PreviewPlaying() = RetroPlayerPreviewContent(RadioState(connected = true, powerOn = true, mode = RadioMode.USB, volume = 18))

@Preview(name = "Reprodução pausada", widthDp = 360, heightDp = 900)
@Composable private fun PreviewPaused() = RetroPlayerPreviewContent(RadioState(mode = RadioMode.USB, volume = 18))

@Preview(name = "Volume baixo", widthDp = 360, heightDp = 900)
@Composable private fun PreviewVolumeLow() = RetroPlayerPreviewContent(RadioState(mode = RadioMode.USB, volume = 3))

@Preview(name = "Volume médio", widthDp = 360, heightDp = 900)
@Composable private fun PreviewVolumeMedium() = RetroPlayerPreviewContent(RadioState(mode = RadioMode.USB, volume = 16))

@Preview(name = "Volume alto", widthDp = 360, heightDp = 900)
@Composable private fun PreviewVolumeHigh() = RetroPlayerPreviewContent(RadioState(mode = RadioMode.USB, volume = 31))
