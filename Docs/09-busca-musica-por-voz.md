# ToCar - Busca de musica por voz

## Objetivo

Permitir frases como:

```text
quero rhythm of the night
quero this is ritmym of the night
toca what is love
```

O app procura musicas parecidas em um catalogo local. Se encontrar uma unica musica, gera:

```kotlin
RadioCommand.SelectFolderTrack(folder, track)
```

Se encontrar mais de uma, responde por voz:

```text
Encontrei 3 musicas parecidas. Qual voce quer? 1...
```

A proxima resposta `1`, `2`, `3`, `primeira`, `segunda` ou `terceira` escolhe a faixa.

## Estado atual

O catalogo atual e demonstrativo e fica em `MusicSearchEngine.demoCatalog()`.

Isso existe porque ainda nao sabemos se o Roadstar/CarLive permite listar arquivos USB/SD por protocolo. Quando esse comando for descoberto, o fluxo correto sera:

```text
Radio USB/SD -> ResponseDecoder -> MusicCatalogRepository -> MusicSearchEngine -> RadioCommand.SelectFolderTrack
```

## Seguranca

Mesmo quando a busca encontra uma musica, o envio real ainda depende do pacote confirmado para `SelectFolderTrack`.

Hoje o comando e logico e fica bloqueado no `CommandEncoder`, porque enviar bytes inventados poderia causar comportamento inesperado no radio.

