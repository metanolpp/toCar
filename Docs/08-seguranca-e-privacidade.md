# ToCar - Seguranca e privacidade

## Principios aplicados

- A UI nunca envia bytes diretamente ao Bluetooth.
- `CommandEncoder` bloqueia comandos sem pacote confirmado.
- Envio Raw e limitado a 32 bytes e deve ser usado somente com captura real do CarLive.
- RGB/cor fica bloqueado porque o manual informa indisponibilidade no app para este modelo.
- Presets podem salvar cor localmente, mas o envio real da cor depende de pacote confirmado.
- Voz e processada pelo reconhecedor do Android via intent; o app recebe apenas o texto retornado.
- A voz em segundo plano usa Foreground Service com notificacao visivel enquanto o microfone esta ativo.
- O app nao declara `INTERNET`.
- O app nao usa armazenamento externo.
- O app nao pede `QUERY_ALL_PACKAGES`.

## Permissoes do ToCar

- Android 12+: `BLUETOOTH_CONNECT` e `BLUETOOTH_SCAN`.
- Android 11 ou menor: `BLUETOOTH`, `BLUETOOTH_ADMIN` e `ACCESS_FINE_LOCATION`.
- Voz: `RECORD_AUDIO`.

## Riscos conhecidos

- UUID de conexao nao define protocolo. Mesmo com UUIDs encontrados no APK CarLive, os bytes de comando precisam ser confirmados.
- Pacotes aleatorios podem travar modulo, alterar configuracoes ou produzir comportamento inesperado.
- Se o Roadstar usar BLE em vez de SPP neste modelo/lote, sera necessario implementar backend BLE separado.
- Comando direto "musica X da pasta Y" ainda e logico; nao deve ser enviado ate confirmacao no protocolo.
- `Proxima sintonia` e `sintonia anterior` sao comandos separados de `proxima musica`, pois FM pode usar bytes diferentes de USB/BT.
- A escuta continua pode consumir bateria e depende das politicas do fabricante do Android.

## Recomendacao de teste

1. Parear o radio no Android.
2. Testar conexao SPP com ToCar.
3. Capturar HCI Snoop Log usando CarLive.
4. Copiar somente pacotes TX confirmados para o campo Raw.
5. Depois de validar, preencher `ProtocolMap`.
