# ToCar - Indice da documentacao

## Documentos

- `01-visao-geral-roadmap.md` - objetivo, escopo, estado atual e fases.
- `02-arquitetura-android.md` - organizacao atual do app Android.
- `03-bluetooth-spp-permissoes.md` - permissoes, SPP, BLE e nomes esperados.
- `04-protocolo-radio-command.md` - comandos logicos e mapeamento pendente.
- `05-telas-compose.md` - telas e fluxos da interface.
- `06-engenharia-reversa-hci.md` - roteiro para capturar bytes reais do CarLive.
- `07-analise-apk-carlive.md` - achados no APK CarLive 2.284.
- `08-seguranca-e-privacidade.md` - seguranca, privacidade e limites.
- `09-busca-musica-por-voz.md` - busca por nome de musica e escolha por voz.
- `10-voz-segundo-plano.md` - escuta em segundo plano via Foreground Service.
- `11-estrutura-carlive-comandos-detectados.md` - inventário verificado por ADB/HCI, transporte BLE, comandos confirmados, modos e mensagens pendentes.
- `12-emulador-bridge-windows.md` - execução no Android Emulator e acesso ao Bluetooth do notebook por meio do bridge Windows.
- `13-diagnostico-conexao-roadstar.md` - histórico do diagnóstico no rádio real, causas das falhas e parâmetros finais da conexão BLE.

## Estado atual

O app possui interface Compose, controle BLE/GATT funcional no RS-2751BR PLUS, fallback SPP para outros módulos, protocolo lógico, log Raw, comandos de voz, busca de música por voz, presets de áudio/cor e serviço experimental de voz em segundo plano.

O transporte BLE e um conjunto inicial de comandos reais já foram confirmados no rádio. Comandos ainda não capturados continuam bloqueados pelo `CommandEncoder`.
