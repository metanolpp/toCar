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

## Fases

### Fase 0 — Estrutura inicial
- Criar projeto Android Kotlin.
- Ativar Jetpack Compose + Material 3.
- Criar navegação entre telas.
- Criar camada Bluetooth desacoplada da UI.
- Criar camada de protocolo com comandos ainda vazios.

### Fase 1 — Bluetooth SPP
- Permissões Android 13+.
- Scan de dispositivos.
- Filtro por CAR-BT, RS-2751BR e CAR KIT-APP.
- Pareamento/conexão SPP.
- Leitura e escrita em InputStream/OutputStream.
- Tela de log TX/RX em hexadecimal.

### Fase 2 — Controles básicos
- Power.
- Mode.
- Volume + / Volume -.
- Play/Pause.
- Próximo/Anterior.
- Mute.
- Banda FM.
- Atender/encerrar chamada.

### Fase 3 — USB/SD e reprodução
- INT.
- RPT.
- RDM.
- -10 / +10.
- DIR- / DIR+.
- Leitura posterior de diretórios, se o protocolo permitir.

### Fase 4 — Áudio
- BAS.
- TRE.
- BAL.
- FAD.
- EQ.
- LOUD.
- ST.

### Fase 5 — Cores
- Implementar com cautela.
- O manual indica AUTO/COR no painel, mas informa que RGB no aplicativo não está disponível para este modelo.
- Priorizar somente comandos confirmados por captura.

### Fase 6 — Voz
- Speech-to-Text Android.
- Tradução de frases para RadioCommand.
- Envio pelo CommandEncoder.

## Resultado esperado
Um app modular onde a interface já existe e os bytes são adicionados gradualmente conforme forem descobertos.
