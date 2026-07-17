# ToCar - Telas Jetpack Compose

## Navegacao atual

```text
ToCarTab.Connect  -> Conexao
ToCarTab.Controls -> Controle
ToCarTab.Files    -> USB/SD
ToCarTab.Audio    -> Audio
ToCarTab.Log      -> Log
```

## Conexao

Funcoes:

- Pedir permissoes Bluetooth, microfone e notificacao.
- Exibir todos os dispositivos pareados para seleção manual.
- Destacar nomes compatíveis com o Roadstar sem ocultar os demais.
- Não conectar automaticamente ao abrir a tela.
- Exibir `Tentando conectar...` durante varredura e negociação GATT.
- Exibir `Conectado` somente após serviço `FFF0`, característica `FFF1` e sincronização inicial.
- Bloquear `Atualizar lista` durante tentativa ou conexão ativa.
- Desconectar.
- Mostrar estado de conexao.

Fluxo esperado: conectar o áudio nas configurações Android, abrir o ToCar, escolher o rádio, tocar em **Conectar** e acompanhar a mudança explícita de estado.

## Controle

Funcoes:

- Power.
- Mode.
- Fontes diretas: RADIO, USB, SD, AUX, BT, COR.
- Volume.
- Play/Pause.
- Proxima/Anterior.
- Mute.
- AMS.
- Band.
- RPT/RDM/INT.
- -10/+10.
- DIR-/DIR+.
- Atender/encerrar chamada.

Todos os botoes chamam `RadioRepository.send(RadioCommand)`.

## USB/SD e voz

Funcoes:

- DIR-.
- DIR+.
- -10.
- +10.
- Botao `Ouvir comando`.
- Botao `Ouvir em segundo plano`.
- Botao `Parar`.
- Campo para testar texto como se fosse voz.
- Busca de musica por voz em catalogo demonstrativo.
- Escolha por numero quando ha varias musicas parecidas.

Funcoes futuras:

- Solicitar lista real de diretorios.
- Interpretar resposta do radio.
- Alimentar o catalogo real do buscador por voz.
- Executar arquivo selecionado por indice real.

## Audio

Funcoes:

- BAS -07 a +07.
- TRE -07 a +07.
- BAL.
- FAD.
- EQ.
- LOUD.
- Cor do painel com cautela.
- Salvar preset local.
- Aplicar preset salvo.
- Apagar preset salvo.

Preset local salva:

- EQ.
- BAS.
- TRE.
- BAL.
- FAD.
- LOUD ON/OFF.
- Cor do painel.

## Log

Objetivo:

- Ajudar na engenharia reversa.

Exibe:

- Timestamp.
- Direcao: TX, RX, APP ou BLOCKED.
- Nome logico do comando.
- Bytes em hexadecimal.
- Tamanho do pacote.

Tambem possui campo Raw seguro:

- Aceita hexadecimal.
- Limite de 32 bytes.
- Deve ser usado somente com pacotes capturados do CarLive.

## BackgroundVoiceService

Funcoes:

- Escutar comandos com o app fora da tela principal.
- Mostrar notificacao fixa enquanto o microfone esta ativo.
- Responder usando Text-to-Speech.
- Reutilizar comandos, busca de musica e presets.

Status:

- Experimental.
- Pode ser limitado pelo Android ou pelo fabricante, especialmente com tela bloqueada.
