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

## Estado atual

O app ja possui interface Compose, camada Bluetooth SPP, protocolo logico, log Raw, comandos de voz, busca de musica por voz, presets de audio/cor e um servico experimental de voz em segundo plano.

Os bytes reais do Roadstar ainda nao estao mapeados. Comandos sem pacote confirmado sao bloqueados pelo `CommandEncoder`.
