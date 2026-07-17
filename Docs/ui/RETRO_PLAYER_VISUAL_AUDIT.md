# Auditoria visual do Player retrô

## Tela e estado

- Tela atual: `ControlsScreen`, em `ui/app/ToCarApp.kt`.
- Estado consumido: `RadioState`, coletado de `RadioRepository.radioState`.
- Conexão exibida: `BluetoothConnectionState`.
- Não existe ViewModel específico para esta tela; a composição atual recebe estado e callbacks diretamente.

## Callbacks preservados

Todos os controles visuais continuam encaminhando os mesmos `RadioCommand`: modo, faixa anterior/próxima, play/pause, mute, AMS, band, fontes, volume, intro, repeat, random, saltos, diretórios, loudness e telefone. Nenhum callback será criado ou alterado na correção visual.

## Navegação e tema

- Navegação inferior: estado local `ToCarTab` em `ToCarApp.kt`.
- Tema atual: `ui/theme/Theme.kt`, `Color.kt` e `Type.kt`.
- A navegação funcional e a enumeração das abas serão preservadas; apenas a representação visual será substituída.

## Arquivos visuais previstos

- `ui/app/ToCarApp.kt`: composição da tela e integração dos novos componentes.
- `ui/components/retro/RetroComponents.kt`: molduras, painéis, botões, visor, barras e navegação.
- `ui/theme/retro/RetroColors.kt`
- `ui/theme/retro/RetroDimensions.kt`
- `ui/theme/retro/RetroShapes.kt`
- `ui/theme/retro/RetroTypography.kt`
- `ui/theme/retro/ToCarRetroTheme.kt`

## Limites

Bluetooth, BLE, SPP, repositories, protocolo, serviços, permissões, voz, persistência e regras de negócio estão fora do escopo. O caminho solicitado `docs/references/tocar_winamp_reference.png` não está presente no repositório; a imagem fornecida na conversa será usada como fonte visual nesta rodada.
