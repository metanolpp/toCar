# ToCar - Analise inicial do APK CarLive 2.284

## Arquivo analisado

- Caminho recebido: `C:\Downloads\carlive-2-284.apk`
- Pacote Android: `zddz.app.carlive`
- Nome do app: `CarLive`
- Versao: `2.284`
- Version code: `44`
- Target SDK: `35`
- Activity inicial: `com.zddz.app.carlive.MainActivity`

## Permissoes observadas

O APK declara:

- `BLUETOOTH`
- `BLUETOOTH_ADMIN`
- `BLUETOOTH_CONNECT`
- `BLUETOOTH_SCAN`
- `BLUETOOTH_ADVERTISE`
- `ACCESS_COARSE_LOCATION`
- `ACCESS_FINE_LOCATION`
- `INTERNET`
- `WAKE_LOCK`
- `ACCESS_WIFI_STATE`
- `CHANGE_WIFI_STATE`
- `READ_EXTERNAL_STORAGE`
- `WRITE_EXTERNAL_STORAGE`
- `QUERY_ALL_PACKAGES`

## Recursos Bluetooth observados

O APK declara suporte a:

- `android.hardware.bluetooth`
- `android.hardware.bluetooth_le`

Isso sugere que o CarLive pode usar Bluetooth classico e BLE, dependendo do aparelho/modulo.

## Classes/pacotes relevantes encontrados

Foram encontrados nomes como:

- `com.zddz.bt.BtService`
- `com.zddz.bt.BtMethod`
- `com.zddz.bt.BtCallback`
- `com.zddz.bt.BluetoothGattState`
- `com.zddz.bt.ConnectListHelper`
- `com.zddz.bt.ScannerLiveData`
- `com.zddz.bt.WriteDataItem`
- `com.zddz.app.carlive.dialog.ChooseMusicDialog`
- `com.zddz.app.carlive.dialog.EqDialog`
- `com.zddz.app.carlive.dialog.TenEqDialog`
- `com.zddz.app.carlive.database.EqRecord`
- `com.zddz.app.carlive.database.FmBandStationRecord`

## UUIDs encontrados nos DEX

```text
0000fff0-0000-1000-8000-00805f9b34fb
0000fff1-0000-1000-8000-00805f9b34fb
258eafa5-e914-47da-95ca-c5ab0dc85b11
```

Interpretação cautelosa:

- `0000FFF0` parece um UUID de servico BLE.
- `0000FFF1` parece um UUID de caracteristica/notificacao BLE.
- O APK tambem contem a string `com.zddz.bt.extra.BLE_NOTICE_UUID`.
- O UUID SPP classico `00001101-0000-1000-8000-00805F9B34FB` continua relevante para Bluetooth serial classico, conforme a premissa do projeto.

## Impacto na arquitetura ToCar

O app ToCar deve manter:

1. Camada SPP, porque o manual e o roadmap citam Bluetooth classico/SPP.
2. Constantes BLE do CarLive, porque o APK mostra uso de BLE.
3. `CommandEncoder` seguro, sem enviar bytes desconhecidos.
4. Tela de log Raw para testar somente pacotes capturados do CarLive.
5. Futuro backend BLE separado do SPP, caso o Roadstar exponha `FFF0/FFF1`.

## O que ainda falta

Esta analise nao prova os bytes de comandos como Play, Volume ou EQ. Para isso ainda e necessario:

- Decompilar com jadx/apktool ou analisar smali.
- Capturar Bluetooth HCI Snoop Log usando o CarLive real conectado ao Roadstar.
- Comparar TX/RX por comando.
- Preencher `ProtocolMap` somente com pacotes confirmados.

