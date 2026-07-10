# ToCar — Visão Geral e Roadmap

## Objetivo
Criar um aplicativo Android nativo em Kotlin + Jetpack Compose para controlar o auto-rádio Roadstar RS-2751BR Plus via Bluetooth clássico/SPP, substituindo ou complementando o aplicativo CarLive.

## Base funcional do manual
O manual confirma que o RS-2751BR Plus possui:

- Controle por aplicativo CarLive.
- Conexão Bluetooth com identificação CAR-BT ou RS-2751BR.
- No aplicativo, conexão pelo nome CAR KIT-APP.
- Modos: RADIO, USB, SD, AUX IN e BT.
- Controles de volume, próximo, anterior, ligar/desligar e configurações.
- EQ e ajustes BAS, TRE, BAL, FAD.
- Funções AMS, CLOCK e Bluetooth.
- RGB indicado no aplicativo, mas marcado no manual como não disponível para este modelo.
- No painel físico, alternância RADIO → USB → SD → AUX IN → BT → COR.
- Reprodução USB/SD de MP3/WMA com Play/Pause, INT, RPT, RDM, -10, +10, DIR- e DIR+.
- Equalizador FLAT, ROCK, POP, CLASSIC, JAZZ e EQ OFF.
- Loudness ON/OFF.
- Ajustes BAS/TRE de -07 a +07.

## Observação crítica
O manual descreve funções e comportamento, mas não informa os bytes/protocolo serial do CarLive. Portanto, o projeto deve separar:

1. Funções conhecidas pelo manual.
2. Comandos ainda desconhecidos que dependem da captura Bluetooth HCI Snoop Log.
3. Interface e arquitetura já implementáveis sem conhecer todos os bytes.

## Estado atual

Ja existe uma primeira versao Android com:

- Interface Compose com abas `Conexao`, `Controle`, `USB/SD`, `Audio` e `Log`.
- Bluetooth SPP separado da UI.
- Filtro por `CAR-BT`, `RS-2751BR` e `CAR KIT-APP`.
- Protocolo logico com `RadioCommand` e `CommandEncoder`.
- Bloqueio seguro para comandos sem bytes confirmados.
- Campo Raw limitado para testar pacotes capturados.
- Comandos de voz para fonte, volume, faixa, sintonia, EQ, LOUD, cor e presets.
- Busca de musica por voz com catalogo demonstrativo.
- Presets locais de EQ/BAS/TRE/BAL/FAD/LOUD/cor.
- Voz em segundo plano via Foreground Service, marcada como experimental.

## Achados do APK CarLive

O APK `carlive-2-284.apk` analisado localmente indica:

- Pacote: `zddz.app.carlive`.
- Versao: `2.284`.
- Uso de Bluetooth classico e BLE.
- Pacote interno relevante: `com.zddz.bt`.
- UUIDs encontrados:

```text
0000fff0-0000-1000-8000-00805f9b34fb
0000fff1-0000-1000-8000-00805f9b34fb
258eafa5-e914-47da-95ca-c5ab0dc85b11
```

Esses UUIDs ajudam na engenharia reversa, mas nao substituem a captura dos bytes de comando.

## Fases

### Fase 0 — Estrutura inicial
- Status: implementada.
- Projeto Android Kotlin criado.
- Jetpack Compose + Material 3 ativo.
- Navegacao por abas implementada.
- Camada Bluetooth desacoplada da UI.
- Camada de protocolo com comandos logicos e encoder seguro.

### Fase 1 — Bluetooth SPP
- Status: parcialmente implementada.
- Permissoes Android 13+ implementadas.
- Listagem de pareados implementada.
- Filtro por CAR-BT, RS-2751BR e CAR KIT-APP implementado.
- Conexao SPP implementada.
- Leitura/escrita por `InputStream`/`OutputStream` implementada.
- Tela de log TX/RX em hexadecimal implementada.
- Scan ativo ainda pode ser refinado.

### Fase 2 — Controles básicos
- Status: interface e comandos logicos implementados.
- Power.
- Mode.
- Volume + / Volume -.
- Play/Pause.
- Proximo/Anterior.
- Proxima sintonia / Sintonia anterior.
- Mute.
- Banda FM.
- Atender/encerrar chamada.
- Envio real depende dos bytes confirmados.

### Fase 3 — USB/SD e reprodução
- Status: interface e comandos logicos implementados.
- INT.
- RPT.
- RDM.
- -10 / +10.
- DIR- / DIR+.
- Busca por voz em catalogo demonstrativo.
- Leitura real de diretorios continua pendente.

### Fase 4 — Áudio
- Status: interface, presets e comandos logicos implementados.
- BAS.
- TRE.
- BAL.
- FAD.
- EQ.
- LOUD.
- Presets locais.
- ST ainda deve ser confirmado.

### Fase 5 — Cores
- Status: preset e comando logico implementados com cautela.
- O app permite salvar cor no preset.
- O comando `SetPanelColor` existe, mas permanece bloqueado ate captura confirmada.
- O manual indica AUTO/COR no painel, mas informa que RGB no aplicativo não está disponível para este modelo.

### Fase 6 — Voz
- Status: implementada e em expansao.
- Speech-to-Text Android por intent na UI.
- `SpeechRecognizer` em Foreground Service para segundo plano, experimental.
- Traducao de frases para `RadioCommand`.
- Busca de musica por voz.
- Aplicacao de presets por voz.
- Envio pelo `CommandEncoder`, respeitando bloqueios de seguranca.

## Resultado esperado
Um app modular onde a interface já existe e os bytes são adicionados gradualmente conforme forem descobertos.
