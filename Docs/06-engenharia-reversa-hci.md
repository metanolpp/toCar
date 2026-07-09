# ToCar — Engenharia Reversa do CarLive via Bluetooth HCI Snoop Log

## Objetivo
Descobrir os bytes reais enviados pelo aplicativo CarLive ao Roadstar RS-2751BR Plus.

## O que o manual já confirma

- O rádio possui controle por aplicativo CarLive.
- O celular deve conectar no Bluetooth do rádio.
- O aplicativo deve conectar no dispositivo identificado como CAR KIT-APP.
- O aplicativo controla Mode, EQ, AMS, Clock, Bluetooth, Power, Next, Previous e Volume.
- O rádio possui funções USB/SD, Repeat, Random, INT, -10, +10, DIR- e DIR+.

## O que o manual não informa

- Header dos pacotes.
- Tamanho dos pacotes.
- Checksum.
- Comando de cada botão.
- Respostas do rádio.
- Se existe comando para listar arquivos/pastas.
- Se o controle de cor via aplicativo realmente funciona neste modelo.

## Captura pelo Android

### 1. Ativar HCI Snoop Log
No Android:

```text
Configurações → Opções do desenvolvedor → Ativar Bluetooth HCI Snoop Log
```

### 2. Parear com o rádio
Procurar nomes como:

```text
CAR-BT
RS-2751BR
CAR KIT-APP
```

### 3. Abrir o CarLive
Executar cada comando de forma isolada.

### 4. Roteiro de captura

Faça uma captura limpa para cada grupo:

#### Grupo 1 — Conexão
- Abrir CarLive.
- Conectar no rádio.
- Esperar 5 segundos.
- Fechar.

#### Grupo 2 — Controles básicos
- Power.
- Mode.
- Volume +.
- Volume -.
- Next.
- Previous.
- Play/Pause.

#### Grupo 3 — USB/SD
- INT.
- RPT.
- RDM.
- -10.
- +10.
- DIR-.
- DIR+.

#### Grupo 4 — Áudio
- BAS -1.
- BAS +1.
- TRE -1.
- TRE +1.
- BAL -1.
- BAL +1.
- FAD -1.
- FAD +1.
- EQ alternando presets.
- LOUD ON/OFF.

#### Grupo 5 — Rádio
- BAND.
- AMS.
- Memórias 1 a 6, se disponíveis no app.

#### Grupo 6 — Cor
- Testar somente se existir no aplicativo.
- O manual indica que RGB no app não está disponível para este modelo.

## Extração do log

Dependendo do Android, o arquivo pode ficar em locais diferentes. Caminhos comuns:

```text
/sdcard/btsnoop_hci.log
/data/misc/bluetooth/logs/btsnoop_hci.log
```

Também pode ser necessário usar:

```bash
adb bugreport
```

Depois extrair o arquivo dentro do zip do bugreport.

## Análise no Wireshark

Abrir `btsnoop_hci.log` no Wireshark.

Filtros úteis:

```text
btatt
btl2cap
btrfcomm
bluetooth
```

Como é Bluetooth clássico/SPP, procurar tráfego RFCOMM.

## Estratégia de comparação

Para cada comando:

1. Capturar antes/depois.
2. Pressionar apenas um botão.
3. Anotar horário exato.
4. Localizar pacote TX no Wireshark.
5. Copiar bytes.
6. Preencher `ProtocolMap`.
7. Testar no app ToCar com comando Raw.
8. Confirmar se o rádio executa a ação.

## Planilha/tabela de controle

| Data | Comando | Tela CarLive | TX Hex | RX Hex | Funcionou no ToCar? | Observação |
|---|---|---|---|---|---|---|
| TODO | Next | Player | TODO | TODO | Não testado | Capturar |
| TODO | Previous | Player | TODO | TODO | Não testado | Capturar |
| TODO | Volume + | Player | TODO | TODO | Não testado | Capturar |
| TODO | Mode | Main | TODO | TODO | Não testado | Capturar |

## Implementação de comando Raw para teste

```kotlin
fun String.hexToByteArray(): ByteArray {
    val clean = replace(" ", "").replace("0x", "", ignoreCase = true)
    require(clean.length % 2 == 0) { "Hex inválido" }

    return clean.chunked(2)
        .map { it.toInt(16).toByte() }
        .toByteArray()
}
```

```kotlin
viewModel.send(RadioCommand.Raw("AA 55 03 10 01 0F".hexToByteArray()))
```

## Regra de segurança
Nunca enviar pacotes aleatórios longos ou repetitivos sem saber o efeito. Começar somente replicando pacotes capturados do CarLive.
