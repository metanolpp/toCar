# Código legado do CarLive

Material extraído em 15/07/2026 do resultado JADX gerado no celular pelo aplicativo Decompile.

## Origem e conteúdo

- CarLive 2.284 (`zddz.app.carlive`, versionCode 44).
- `resources/AndroidManifest.xml`: Manifest decompilado.
- `sources/com/zddz/bt/`: 13 arquivos da infraestrutura Bluetooth.
- `sources/com/zddz/app/carlive/`: 122 arquivos do aplicativo.
- Total inicial: 136 arquivos.

O conteúdo é código decompilado para consulta. Não deve ser incluído no source set do ToCar.

## Arquivos prioritários

1. `OrderSet.java`: catálogo central com 123 constantes `write_*`, 106 prefixos `notice_*` e UUIDs FFF0/FFF1.
2. `fragment/MainFragment.java`: ligação entre botões, comandos TX e notificações RX.
3. `MainActivity.java`: conexão, sincronização, notificações e fila de escrita.
4. `bt/BtService.java`: GATT, callbacks e serialização de escritas.
5. `bt/WriteDataItem.java`, `BluetoothGattState.java`, `ConnectListHelper.java`, `ScannerLiveData.java`, `BtCallback.java` e `Convert.java`.

Diálogos de EQ, DSP, cor, estações e música também foram preservados, pois alteram buffers de `OrderSet` antes do envio.

## Comandos básicos encontrados

```text
Sincronizar       01 03
Power             01 01
Play              01 02 01
Pause             01 02 02
Anterior          03 01 00
Próxima           03 02 00
Volume -          04 01
Volume +          04 02
Volume absoluto   04 03 vv
LOUD              04 04
Modo seguinte     08 01
USB               08 02
SD                 08 03
FM                 08 04
Bluetooth         08 05
AUX                08 06
Mute              09 01
Bass               0A 01 vv
Treble             0A 02 vv
Balance            0A 03 vv
Fader              0A 04 vv
```

O rádio pode implementar apenas um subconjunto. Validar cada comando no RS-2751BR PLUS ou em captura HCI antes de habilitá-lo em produção.
