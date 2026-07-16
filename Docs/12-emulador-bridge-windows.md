# Android Emulator com Bluetooth do notebook

## Objetivo

O Android Emulator não expõe um adaptador Bluetooth virtual ao aplicativo. Para testar a interface no computador e, ainda assim, comunicar com o rádio, o ToCar usa dois processos:

1. o aplicativo Android roda no AVD `ToCar_API35`;
2. o `desktop-bridge` roda no Windows, acessa o Bluetooth LE do notebook e troca mensagens com o aplicativo por TCP.

O aplicativo escolhe explicitamente a interface Ethernet virtual do AVD e acessa o computador hospedeiro em `10.0.2.2:8765`. Isso evita que o socket seja direcionado para uma interface Wi-Fi virtual sem rota.

## Componentes

- `RadioController`: contrato comum para os backends.
- `AndroidBluetoothController`: BLE direto quando o aplicativo roda em celular físico.
- `DesktopBridgeController`: cliente TCP usado no Android Emulator.
- `DemoRadioController`: simulação local para testes puramente visuais.
- `desktop-bridge`: servidor Windows que realiza descoberta, conexão GATT, notificações e escrita BLE.

O bridge procura o serviço GATT `FFF0` e a característica `FFF1`, conforme a estrutura legada detectada no CarLive.

## Pré-requisitos instalados

- Android SDK em `C:\Users\metan\AppData\Local\Android\Sdk`.
- AVD `ToCar_API35`, com imagem Google APIs x86_64 da API 35.
- JDK 17.
- .NET SDK compatível com o projeto `net6.0-windows10.0.22000.0`.
- Bluetooth ativado no Windows e rádio ligado/próximo para testes reais.

## Executar

Na raiz do projeto, inicie o emulador:

```powershell
& 'C:\Users\metan\AppData\Local\Android\Sdk\emulator\emulator.exe' '@ToCar_API35'
```

Em outro terminal, inicie o bridge:

```powershell
dotnet run --project .\desktop-bridge\ToCar.DesktopBridge.csproj
```

Compile e instale o aplicativo:

```powershell
$env:JAVA_HOME = 'C:\Program Files\Java\jdk-17'
.\gradlew.bat :app:assembleDebug
& 'C:\Users\metan\AppData\Local\Android\Sdk\platform-tools\adb.exe' -s emulator-5554 install -r '.\app\build\outputs\apk\debug\app-debug.apk'
```

Abra o aplicativo e selecione **BRIDGE PC**. Use **Atualizar** para descobrir dispositivos BLE e escolha o rádio encontrado. O modo **DEMO** permite avaliar interface, estados e comandos sem hardware.

## Protocolo entre aplicativo e bridge

O transporte TCP usa mensagens de texto terminadas por quebra de linha:

- aplicativo para bridge: `HELLO`, `SCAN`, `CONNECT|endereço`, `WRITE|hexadecimal` e `DISCONNECT`;
- bridge para aplicativo: `DEVICE`, `SCAN_DONE`, `CONNECTED`, `DISCONNECTED`, `RX` e `ERROR`.

Os pacotes do rádio continuam binários no trecho BLE. O bridge apenas converte esses bytes para hexadecimal durante o transporte TCP.

## Segurança dos testes

O bridge não conecta nem envia pacotes ao rádio automaticamente. Uma escrita BLE só ocorre após conexão escolhida pelo usuário e comando explícito do aplicativo. Antes de ampliar a tabela de comandos, confirme cada pacote nos arquivos legados ou em captura controlada; não envie sequências aleatórias ao equipamento.

## Limitações

- O Android Emulator serve para validar interface e lógica, não simula uma pilha Bluetooth Android completa.
- A descoberta depende das permissões, do adaptador e do estado do Bluetooth no Windows.
- Alguns dispositivos aparecem sem nome; a identificação pode exigir endereço e captura adicional.
- O teste atual comprovou a comunicação aplicativo/bridge. A conexão completa com o rádio depende de ele estar ligado, próximo e anunciando por BLE.
