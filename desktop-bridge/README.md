# ToCar Desktop Bridge

Bridge TCP entre o Android Emulator e o Bluetooth LE do Windows.

## Fluxo

```text
ToCar no AVD -> TCP 10.0.2.2:8765 -> bridge Windows -> BLE FFF0/FFF1 -> rádio
```

## Executar

```powershell
dotnet run --project desktop-bridge/ToCar.DesktopBridge.csproj
```

No aplicativo, abra **Conexão**, selecione **BRIDGE PC**, toque em **Atualizar** e escolha o anúncio BLE do rádio. O serviço imprime todo TX/RX em hexadecimal.

O bridge não envia comandos sozinho. Escritas acontecem somente após uma ação explícita no ToCar.

## Protocolo TCP

- `SCAN`
- `DEVICE|nome|id-base64`
- `CONNECT|id-base64`
- `CONNECTED|nome`
- `WRITE|hex`
- `RX|hex`
- `DISCONNECT`
- `ERROR|mensagem`
