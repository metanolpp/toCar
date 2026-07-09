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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.tocar.bluetooth.AndroidBluetoothController
import com.example.tocar.bluetooth.BluetoothConnectionState
import com.example.tocar.bluetooth.BluetoothDeviceInfo
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
import com.example.tocar.protocol.hexToByteArraySafe
import com.example.tocar.repository.RadioRepository
import com.example.tocar.voice.MusicEntry
import com.example.tocar.voice.MusicSearchEngine
import com.example.tocar.voice.MusicSearchResult
import com.example.tocar.voice.BackgroundVoiceService
import com.example.tocar.voice.VoiceCommandParser
import java.util.Locale

private enum class ToCarTab(val label: String) {
    Connect("Conexao"),
    Controls("Controle"),
    Files("USB/SD"),
    Audio("Audio"),
    Log("Log")
}

@Composable
fun ToCarApp() {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val logger = remember { PacketLogger() }
    val presetRepository = remember { PresetRepository(context) }
    val bluetoothController = remember { AndroidBluetoothController(context, scope) }
    val repository = remember {
        RadioRepository(
            bluetoothController = bluetoothController,
            encoder = CommandEncoder(),
            logger = logger,
            scope = scope
        )
    }
    val voiceParser = remember { VoiceCommandParser() }
    val musicSearchEngine = remember { MusicSearchEngine() }
    var pendingMusicChoices by remember { mutableStateOf<List<MusicEntry>>(emptyList()) }
    var textToSpeech by remember { mutableStateOf<TextToSpeech?>(null) }

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
    val logs by logger.entries.collectAsState()
    val presets by presetRepository.presets.collectAsState()
    var selectedTab by remember { mutableStateOf(ToCarTab.Controls) }

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

    LaunchedEffect(Unit) {
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
            NavigationBar {
                ToCarTab.entries.forEach { tab ->
                    NavigationBarItem(
                        selected = selectedTab == tab,
                        onClick = { selectedTab = tab },
                        icon = { Text(tab.label.take(1), fontWeight = FontWeight.Bold) },
                        label = { Text(tab.label) }
                    )
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(padding)
        ) {
            StatusHeader(radioState, connectionState)
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
                ToCarTab.Controls -> ControlsScreen(radioState, repository::send)
                ToCarTab.Files -> FilesAndVoiceScreen(
                    radioState = radioState,
                    catalogPreview = musicSearchEngine.catalogPreview(),
                    pendingMusicChoices = pendingMusicChoices,
                    onCommand = repository::send,
                    onListen = {
                        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                            putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
                            putExtra(RecognizerIntent.EXTRA_LANGUAGE, "pt-BR")
                            putExtra(RecognizerIntent.EXTRA_PROMPT, "Diga uma musica ou comando")
                        }
                        speechLauncher.launch(intent)
                    },
                    onStartBackgroundVoice = {
                        val intent = Intent(context, BackgroundVoiceService::class.java)
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            context.startForegroundService(intent)
                        } else {
                            context.startService(intent)
                        }
                    },
                    onStopBackgroundVoice = {
                        context.stopService(Intent(context, BackgroundVoiceService::class.java))
                    },
                    onTypedVoice = { text -> handleVoiceText(text, "Texto") }
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
    connectionState: BluetoothConnectionState
) {
    Surface(color = MaterialTheme.colorScheme.surfaceContainer, tonalElevation = 1.dp) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .clip(CircleShape)
                    .background(if (radioState.connected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error)
            )
            Spacer(Modifier.width(12.dp))
            Column(Modifier.weight(1f)) {
                Text("ToCar Roadstar RS-2751BR Plus", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
                Text(connectionLabel(connectionState), style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
            AssistChip(
                onClick = {},
                label = { Text(radioState.mode?.label ?: "Sem modo") }
            )
        }
    }
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
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(18.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            SectionTitle("Bluetooth SPP")
            Text(
                "Conecte em dispositivos pareados com nome CAR-BT, RS-2751BR ou CAR KIT-APP. O envio de comandos fica bloqueado ate o protocolo real ser mapeado.",
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(12.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Button(onClick = onRequestPermissions) { Text("Permissoes") }
                OutlinedButton(onClick = onRefresh) { Text("Atualizar") }
                if (connectionState is BluetoothConnectionState.Connected) {
                    OutlinedButton(onClick = onDisconnect) { Text("Desconectar") }
                }
            }
        }
        items(devices) { device ->
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = if (device.isLikelyRoadstar) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceContainer
                ),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(Modifier.weight(1f)) {
                        Text(device.name, fontWeight = FontWeight.SemiBold)
                        Text(device.address, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        if (device.isLikelyRoadstar) Text("Compativel com os nomes do manual", color = MaterialTheme.colorScheme.primary)
                    }
                    Button(onClick = { onConnect(device) }) { Text("Conectar") }
                }
            }
        }
        if (devices.isEmpty()) {
            item {
                EmptyState("Nenhum pareado listado. Pareie o radio nas configuracoes Android e toque em Atualizar.")
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ControlsScreen(
    radioState: RadioState,
    onCommand: (RadioCommand) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(18.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        SectionTitle("Controle principal")
        ControlPanel {
            FlowRow(horizontalArrangement = Arrangement.spacedBy(10.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                ActionButton("Power") { onCommand(RadioCommand.PowerToggle) }
                ActionButton("Mode") { onCommand(RadioCommand.ModeNext) }
                ActionButton("Mute") { onCommand(RadioCommand.MuteToggle) }
                ActionButton("AMS") { onCommand(RadioCommand.Ams) }
                ActionButton("Band") { onCommand(RadioCommand.Band) }
            }
        }

        ControlPanel {
            Text("Fonte", fontWeight = FontWeight.SemiBold)
            Spacer(Modifier.height(8.dp))
            FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                RadioMode.entries.forEach { mode ->
                    FilterChip(
                        selected = radioState.mode == mode,
                        onClick = { onCommand(RadioCommand.SetMode(mode)) },
                        label = { Text(mode.label) }
                    )
                }
            }
        }

        ControlPanel {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Volume ${radioState.volume}", fontWeight = FontWeight.SemiBold, modifier = Modifier.weight(1f))
                OutlinedButton(onClick = { onCommand(RadioCommand.VolumeDown) }) { Text("-") }
                Spacer(Modifier.width(8.dp))
                OutlinedButton(onClick = { onCommand(RadioCommand.VolumeUp) }) { Text("+") }
            }
            Slider(
                value = radioState.volume.toFloat(),
                onValueChange = { onCommand(RadioCommand.SetVolume(it.toInt())) },
                valueRange = 0f..40f,
                steps = 39
            )
        }

        ControlPanel {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ElevatedButton(onClick = { onCommand(RadioCommand.PreviousTrack) }) { Text("Anterior") }
                Button(onClick = { onCommand(RadioCommand.PlayPause) }) { Text("Play/Pause") }
                ElevatedButton(onClick = { onCommand(RadioCommand.NextTrack) }) { Text("Proxima") }
            }
        }

        ControlPanel {
            FlowRow(horizontalArrangement = Arrangement.spacedBy(10.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                ActionButton("INT") { onCommand(RadioCommand.IntroToggle) }
                ActionButton("RPT") { onCommand(RadioCommand.RepeatToggle) }
                ActionButton("RDM") { onCommand(RadioCommand.RandomToggle) }
                ActionButton("-10") { onCommand(RadioCommand.SkipMinus10) }
                ActionButton("+10") { onCommand(RadioCommand.SkipPlus10) }
                ActionButton("DIR-") { onCommand(RadioCommand.DirectoryPrevious) }
                ActionButton("DIR+") { onCommand(RadioCommand.DirectoryNext) }
            }
        }

        ControlPanel {
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                OutlinedButton(onClick = { onCommand(RadioCommand.CallAnswerOrRedial) }) { Text("Atender") }
                OutlinedButton(onClick = { onCommand(RadioCommand.CallEnd) }) { Text("Encerrar") }
            }
        }
    }
}

@Composable
private fun FilesAndVoiceScreen(
    radioState: RadioState,
    catalogPreview: List<MusicEntry>,
    pendingMusicChoices: List<MusicEntry>,
    onCommand: (RadioCommand) -> Unit,
    onListen: () -> Unit,
    onStartBackgroundVoice: () -> Unit,
    onStopBackgroundVoice: () -> Unit,
    onTypedVoice: (String) -> Unit
) {
    var typedCommand by remember { mutableStateOf("quero this is ritmym of the night") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(18.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        SectionTitle("USB/SD e voz")
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
            Button(onClick = onListen, modifier = Modifier.fillMaxWidth()) { Text("Ouvir comando") }
            Spacer(Modifier.height(10.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Button(onClick = onStartBackgroundVoice, modifier = Modifier.weight(1f)) {
                    Text("Ouvir em segundo plano")
                }
                OutlinedButton(onClick = onStopBackgroundVoice, modifier = Modifier.weight(1f)) {
                    Text("Parar")
                }
            }
            Spacer(Modifier.height(12.dp))
            OutlinedTextField(
                value = typedCommand,
                onValueChange = { typedCommand = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Testar texto de voz") },
                singleLine = true
            )
            Spacer(Modifier.height(10.dp))
            OutlinedButton(onClick = { onTypedVoice(typedCommand) }, modifier = Modifier.fillMaxWidth()) {
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
            catalogPreview.forEach { entry ->
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
        SectionTitle("Audio")
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
                    rawHex.hexToByteArraySafe()
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
        shape = RoundedCornerShape(8.dp),
        color = MaterialTheme.colorScheme.surfaceContainer,
        tonalElevation = 1.dp,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
    ) {
        Column(Modifier.padding(14.dp)) {
            content()
        }
    }
}

@Composable
private fun ActionButton(label: String, onClick: () -> Unit) {
    OutlinedButton(onClick = onClick) {
        Text(label, textAlign = TextAlign.Center)
    }
}

@Composable
private fun SectionTitle(text: String) {
    Text(text, style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
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
    BluetoothConnectionState.PermissionRequired -> "Permissoes Bluetooth e microfone pendentes"
    BluetoothConnectionState.Disconnected -> "Desconectado"
    BluetoothConnectionState.Scanning -> "Buscando dispositivos"
    is BluetoothConnectionState.Connecting -> "Conectando em ${state.device.name}"
    is BluetoothConnectionState.Connected -> "Conectado em ${state.device.name}"
    is BluetoothConnectionState.Error -> "Erro: ${state.message}"
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
