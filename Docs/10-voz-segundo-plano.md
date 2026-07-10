# ToCar - Voz em segundo plano

## Objetivo

Permitir comandos de voz mesmo com o app fora da tela principal, inclusive com o celular bloqueado quando o Android permitir.

Este recurso e experimental. Se o Android ou o fabricante bloquear o microfone em segundo plano, o fluxo principal continua sendo o botao `Ouvir comando` dentro do app.

## Implementacao

Foi criado um `Foreground Service`:

```text
com.example.tocar.voice.BackgroundVoiceService
```

Ele:

- Mostra uma notificacao fixa enquanto esta ouvindo.
- Usa `SpeechRecognizer` em loop.
- Usa `TextToSpeech` para responder.
- Tenta conectar automaticamente no primeiro dispositivo pareado compativel com Roadstar.
- Reaproveita `VoiceCommandParser`, `MusicSearchEngine`, `PresetRepository` e `RadioRepository`.

## Como usar

Na tela `USB/SD`:

1. Toque em `Ouvir em segundo plano`.
2. O Android mostra uma notificacao do ToCar.
3. Diga comandos como:

```text
proxima musica
musica anterior
proxima sintonia
radio FM
USB
bluetooth
auxiliar
volume mais
loud on
cor azul
aplicar preset estrada
quero rhythm of the night
```

Para parar:

- Toque em `Parar` no app, ou
- Toque em `Parar` na notificacao.

## Permissoes

O app solicita:

- `RECORD_AUDIO`
- `POST_NOTIFICATIONS`
- `FOREGROUND_SERVICE`
- `FOREGROUND_SERVICE_MICROPHONE`
- Permissoes Bluetooth ja usadas pelo app.

No Android 13+, sem permissao de notificacao, o servico pode nao conseguir operar corretamente porque o Android exige notificacao visivel para Foreground Service.

## Limites do Android

- O Android exige notificacao visivel para microfone em segundo plano.
- Alguns fabricantes encerram servicos em segundo plano por economia de bateria.
- Em Android recente, iniciar microfone em segundo plano pode falhar se o usuario nao tiver iniciado o servico pela UI antes.
- Nao e um hotword real tipo "Ok Google"; e reconhecimento continuo por sessoes curtas reiniciadas.

## Seguranca

O servico continua obedecendo ao `CommandEncoder`. Comandos sem bytes confirmados nao enviam pacotes inventados para o radio.
