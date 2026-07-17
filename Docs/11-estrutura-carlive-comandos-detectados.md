# CarLive — estrutura básica e comandos detectados

## Escopo e data da verificação

Levantamento realizado em 15/07/2026 a partir de:

- aparelho acessado por ADB;
- CarLive 2.284 instalado no aparelho;
- APK `carlive-2-284.apk` disponível em `C:\Users\metan\Downloads`;
- capturas HCI em `Captures/FS` e `Captures/clean-commands/FS`;
- relatório decodificado `Captures/clean-commands/att-analysis.txt`;
- implementação e documentos atuais do ToCar.

Este documento distingue **confirmado**, **inferido** e **pendente**. Um pacote só deve entrar no mapa de produção quando sua ação tiver sido repetida e observada no rádio.

## Ambiente confirmado por ADB

| Item | Valor |
|---|---|
| Aparelho | Xiaomi M2101K6G (Redmi Note 10 Pro) |
| Android | 13 |
| Pacote CarLive | `zddz.app.carlive` |
| Versão | 2.284 (`versionCode` 44) |
| SDK | mínimo 21; alvo 35 |
| Activity inicial | `com.zddz.app.carlive.MainActivity` |
| Pacote ToCar | `com.example.tocar` |
| Rádio pareado clássico | `RS-2751BR PLUS` |
| Endereço clássico observado | `41:42:93:88:36:D5` |
| Codec de áudio observado | SBC, 44,1 kHz, 16 bits, estéreo |

Nomes de dispositivos/anúncios encontrados no histórico Bluetooth:

- `RS-2751BR PLUS`;
- `CAR KIT BLE`;
- `CAR APP`;
- `CAR-BT APP`;
- `RS-2751BR PLUS-APP`.

O endereço BLE observado e reconfirmado em conexão real foi `41:42:93:88:36:80`. No MIUI, o anúncio apareceu inicialmente como `00:00:00:00:00:00` e só foi associado ao endereço real após descoberta do sistema. O valor conhecido é usado como compatibilidade para o rádio testado, mas não deve ser presumido para toda unidade.

## Permissões do CarLive

Permissões Bluetooth em tempo de execução estavam concedidas: `BLUETOOTH_CONNECT`, `BLUETOOTH_SCAN` e `BLUETOOTH_ADVERTISE`. Localização precisa estava negada e localização aproximada concedida. O app abriu mostrando sua tela própria de consentimento para varredura/localização; nenhum consentimento foi aceito durante este levantamento.

O APK também solicita Internet, estado/alteração de Wi-Fi, wake lock, consulta de pacotes e permissões antigas de armazenamento. Essas permissões não provam que sejam necessárias para o protocolo do rádio. Para o ToCar, deve ser mantido o princípio de solicitar somente o necessário.

## Transporte realmente observado

O controle do rádio foi observado via **BLE/GATT**:

```text
Serviço:        0000FFF0-0000-1000-8000-00805F9B34FB
Característica: 0000FFF1-0000-1000-8000-00805F9B34FB
Handle ATT:     0x0009 na captura analisada
Propriedades:   write + notify (observadas)
```

Fluxo básico detectado:

1. Varredura BLE e seleção do anúncio compatível.
2. Conexão GATT usando transporte LE.
3. Descoberta do serviço `FFF0`.
4. Descoberta da característica `FFF1`.
5. Ativação de notificações na característica.
6. Escrita de comandos em `FFF1` com resposta GATT.
7. Recepção de estado e metadados também por `FFF1`.
8. Escrita inicial `01 03`, usada como consulta/sincronização inicial.
9. Escrita `01 01`, definida pelo CarLive como Power; troca de modo usa `08 01`.

O rádio também usa Bluetooth clássico para áudio/telefonia (A2DP e possivelmente HFP/AVRCP). Isso é separado do canal BLE de controle. Não foi observado RFCOMM/SPP nos logs analisados; portanto, **BLE deve ser o backend primário de controle para este modelo**, mantendo SPP apenas como alternativa não confirmada para outros módulos.

O handle `0x0009` é atribuído pelo servidor GATT e não deve ser codificado. O aplicativo deve localizar serviço e característica pelos UUIDs.

O firmware observado não expõe o descritor CCCD `2902` em `FFF1`. O CarLive chama `setCharacteristicNotification(true)` e continua sem escrever esse descritor. Exigir `2902` fez o ToCar encerrar uma conexão válida; portanto ele é opcional neste modelo.

## Estrutura funcional encontrada no APK

Classes/pacotes identificados na análise estática inicial:

```text
com.zddz.app.carlive.MainActivity
com.zddz.bt.BtService
com.zddz.bt.BtMethod
com.zddz.bt.BtCallback
com.zddz.bt.BluetoothGattState
com.zddz.bt.ConnectListHelper
com.zddz.bt.ScannerLiveData
com.zddz.bt.WriteDataItem
com.zddz.app.carlive.dialog.ChooseMusicDialog
com.zddz.app.carlive.dialog.EqDialog
com.zddz.app.carlive.dialog.TenEqDialog
com.zddz.app.carlive.database.EqRecord
com.zddz.app.carlive.database.FmBandStationRecord
```

Isso indica camadas de varredura/conexão BLE, fila de escrita, callbacks, seleção de música, equalização e persistência de estações FM/EQ. Nesta árvore do projeto não foi encontrada uma saída completa do JADX ou árvore smali do CarLive; a evidência local disponível é o APK, a análise estática anterior e os logs HCI. Portanto, nomes de métodos e constantes internas adicionais ainda precisam ser extraídos numa decompilação completa.

## Comandos TX confirmados

| Função | TX hexadecimal | Evidência | Estado no ToCar |
|---|---|---|---|
| Sincronizar/consultar estado | `01 03` | enviado após conexão; seguido por notificações de estado | ainda não modelado |
| Power | `01 01` | constante `write_power` no `OrderSet.java`; antes estava rotulado incorretamente como modo | requer correção no projeto |
| Próximo modo | `08 01` | constante `write_mode` no `OrderSet.java` | requer correção no projeto |
| Próxima faixa | `03 02 00` | captura isolada e eco/atualização de faixa | implementado |
| Faixa anterior | `03 01 00` | captura isolada e eco/atualização de faixa | implementado |

Os comandos acima são mensagens completas; não há header global, tamanho ou checksum adicional visível nesses pacotes.

## Modos detectados

O protocolo usa notificações `08 xx` para modo/estado da fonte. Foram observados:

```text
08 00
08 02
08 04
08 05
```

A associação exata de todos os valores ainda precisa de uma captura rotulada. Pelos eventos próximos:

- `08 02` aparece antes de metadados e navegação de faixas, sendo forte candidato a USB/SD;
- `08 04` aparece junto de frequência `0D 01 1D B0`, sendo forte candidato a rádio FM;
- `08 00` aparece no início/fim de sessões e ainda não deve receber rótulo definitivo;
- `08 05` foi observado, mas permanece sem rótulo.

Modos funcionais que devem existir no modelo do projeto, com base no manual e no app atual:

```text
RADIO → USB → SD → AUX IN → BT → COR
```

O catálogo decompilado define troca sequencial como `08 01` e seleção direta USB/SD/FM/BT/AUX como `08 02` a `08 06`. Validar o subconjunto suportado pelo RS-2751BR PLUS antes de habilitar seleção direta.

## Demais mensagens TX observadas, ainda sem rótulo definitivo

| TX | Ocorrências na captura limpa | Hipótese/observação |
|---|---:|---|
| `08 01` | 6 | consulta de estado/fonte |
| `07 04` | 6 | ação da tela FM; possivelmente estação/preset/consulta |
| `04 03 0E` a `04 03 11` | várias | volume absoluto; respostas incluem o limite do aparelho |
| `04 03 0A` a `04 03 0D` | 1 cada | mesma família de volume absoluto |
| `0E 01 07` | 3 | consulta/ajuste cujo valor atual é 7 |
| `0B 01`, `0B 02`, `0B 03` | 2/1/1 | seleção de opção ou preset |
| `01 02 01`, `01 02 02` | 1 cada | estado play/pause ou seleção binária |
| `06 02 17 37 11 1A 07 09` | 1 | data/hora: 23:55:17 em 09/07/2026 |
| `06 02 00 0A 1E 1A 07 0A` | 1 | outra escrita de relógio/data |

A sequência `04 03 nn` define volume absoluto. Na notificação `04 03 vv mm`, o CarLive atualiza o volume com `vv` e o máximo do controle com `mm`; por isso o ToCar usa o limite informado pelo dispositivo e mantém 32 apenas como fallback inicial.

## Mensagens RX e modelo de estado

Famílias identificadas:

| Prefixo/formato | Conteúdo provável |
|---|---|
| `0F 01` + ASCII | identificação; foi recebido `HEXING` |
| `08 xx` | fonte/modo atual |
| `04 03 vv mm` | volume atual `vv` e limite do dispositivo `mm` |
| `09 01 xx` | flag de estado |
| `0A ...` | estado de áudio/EQ ainda não rotulado |
| `0D 01 hi lo` | frequência FM; valor big-endian escalado |
| `03 05 00 nn` | número/índice da faixa atual |
| `01 02 xx` | estado binário do player |
| `0C 01 00 01` + UTF-16LE | fragmentos de título/metadados da música |
| `06 03` | confirmação de relógio/data |

Exemplo FM: `0D 01 1D B0` contém `0x1DB0 = 7600`; interpretado em centésimos resulta em 76,00 MHz. Também foram observados `0x2328` (90,00), `0x2648` (98,00), `0x2968` (106,00) e `0x2A30` (108,00), o que sustenta essa interpretação.

Metadados chegam fragmentados em UTF-16LE. O decoder deve acumular fragmentos consecutivos `0C 01 00 01`, decodificar pares little-endian e definir limite/término por mudança de tipo, timeout curto ou novo cabeçalho lógico.

## Conjunto básico a modelar no ToCar

### Conexão

- verificar suporte e permissões BLE;
- escanear e filtrar pelos nomes conhecidos, sem depender somente do nome;
- permitir seleção manual;
- conectar GATT em `TRANSPORT_LE`;
- descobrir `FFF0/FFF1`;
- habilitar notificações;
- serializar escritas: uma operação GATT por vez;
- enviar `01 03` e aguardar estado inicial;
- manter timeout, desconexão, reconexão limitada e fechamento correto do GATT.
- aguardar 1.200 ms entre o fim da varredura e `connectGatt()`;
- repetir até 3 vezes somente a falha transitória status 62, com intervalo de 1.800 ms;
- manter seleção manual e estado visual `Connecting` até a inicialização completa.

### Comandos de primeira fase

- sincronizar estado (`01 03`);
- power (`01 01`);
- próximo modo (`08 01`);
- próxima faixa (`03 02 00`);
- faixa anterior (`03 01 00`);
- parser RX para modo, faixa, play/pause, metadados, frequência e ajustes;
- comando Raw restrito a pacotes capturados.

### Comandos funcionais que continuam pendentes

- power e mute;
- play/pause;
- volume absoluto e volume +/−;
- seleção direta de modo;
- busca/sintonia, BAND, AMS e presets FM;
- EQ, bass, treble, balance, fader e loudness;
- INT, repeat, random, ±10 e diretórios;
- relógio;
- cor do painel;
- comandos de chamada;
- seleção direta de pasta/faixa.

## Regras de implementação

1. Não enviar combinações inferidas ao rádio.
2. Manter TX e RX separados e registrar horário, hexadecimal e ação do usuário.
3. Tratar `01`, `03`, `04`, etc. como famílias de mensagem, não como comprimento garantido.
4. Não fixar MAC BLE nem handle ATT.
5. Não supor que o eco RX seja apenas confirmação; ele pode carregar estado atualizado.
6. Preservar Bluetooth clássico para áudio/telefonia e BLE para controle.
7. Só promover um comando a “confirmado” após pelo menos duas repetições isoladas com resultado observado.

## Próxima captura recomendada

Executar uma ação por vez e anotar o segundo exato:

1. conexão sem tocar em controles;
2. percorrer todos os modos e anotar o texto do painel;
3. volume 10 → 11 → 10;
4. play → pause → play;
5. cada preset de EQ;
6. bass/treble/balance/fader em três valores conhecidos;
7. rádio: BAND, seek −/+, AMS e presets 1–6;
8. USB/SD: INT, RPT, RDM, −10, +10 e mudança de diretório;
9. power, mute e relógio.

Com essa rodada será possível rotular as famílias já presentes na captura sem adivinhação e ampliar com segurança o `ProtocolMap`.
