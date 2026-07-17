# Diagnóstico da conexão com RS-2751BR PLUS

## Objetivo

Este documento registra por que o rádio aparecia conectado no Android, mas ToCar e CarLive não conseguiam controlar o equipamento, quais evidências foram coletadas e quais parâmetros tornaram a conexão estável.

## Distinção entre as duas conexões

O equipamento apresenta dois canais independentes:

| Função | Tecnologia | Nome observado | Endereço observado |
|---|---|---|---|
| Áudio e telefonia | Bluetooth clássico/A2DP | `RS-2751BR PLUS` | `41:42:93:88:36:D5` |
| Controle do aplicativo | BLE/GATT | `RS-2751BR PLUS-APP` | `41:42:93:88:36:80` |

O texto **conectado/ativo** nas configurações Android comprovava apenas o áudio clássico. O aplicativo ainda precisava abrir separadamente o serviço GATT `FFF0` e a característica `FFF1`.

## Sequência dos problemas encontrados

### 1. Módulo BLE do rádio travado

O rádio continuava anunciando `PLUS-APP`, mas todas as conexões BLE terminavam imediatamente ou expiravam. O mesmo acontecia no CarLive, eliminando o ToCar como causa inicial. Cortar a alimentação do rádio pela bateria do carro reinicializou o módulo; depois disso o CarLive conectou e enviou comandos.

Conclusão: desligar apenas o painel não necessariamente remove alimentação do módulo Bluetooth. Em falha persistente nos dois aplicativos, é necessário reinício elétrico completo antes de alterar software.

### 2. Endereço mascarado pelo MIUI

O callback de varredura entregou `RS-2751BR PLUS-APP` com endereço `00:00:00:00:00:00`. Logs internos da pilha mostraram posteriormente o peer real `41:42:93:88:36:80`, com tipo de endereço LE aleatório (`address type 1`).

O CarLive realizou descoberta do sistema, tentou o endereço mascarado e depois abriu o endereço real. O ToCar passou a combinar varredura BLE com descoberta do sistema e mantém um mapeamento de compatibilidade para a unidade testada.

### 3. Conexão válida encerrada por ausência do descritor 2902

O ToCar conectou GATT com `status=0`, descobriu dois serviços e encontrou `FFF1`, mas gerou o erro `Descriptor 2902 nao encontrado em FFF1`. Em seguida chamou `disconnect()` e `close()`, dando a impressão de que o rádio havia derrubado a conexão.

Na sessão CarLive bem-sucedida não houve escrita no CCCD `2902`: o app apenas chamou `setCharacteristicNotification(true)` e começou a escrever em `FFF1`. A implementação foi alterada para considerar o descritor opcional.

### 4. Falha transitória status 62

Após resolver o descritor, uma tentativa chamou `connectGatt()` cerca de 11 ms depois de parar a varredura. O Android retornou status decimal 62 (`0x3E`, falha ao estabelecer conexão LE).

O CarLive apresentava uma pausa e múltiplas tentativas. O parâmetro funcional adotado foi:

- espera após varredura: **1.200 ms**;
- máximo de tentativas para status 62: **3**;
- intervalo entre tentativas: **1.800 ms**;
- `autoConnect=false`;
- transporte `BluetoothDevice.TRANSPORT_LE`;
- timeout geral de cada conexão: **18.000 ms**.

Com esses parâmetros, a conexão manual do ToCar foi confirmada no rádio real.

## Fluxo operacional definitivo

1. Abrir as configurações Bluetooth do Android.
2. Conectar `RS-2751BR PLUS` para áudio.
3. Abrir o ToCar.
4. Conceder localização e dispositivos próximos, se solicitado.
5. Atualizar a lista, se necessário.
6. Escolher `RS-2751BR PLUS` e tocar em **Conectar**.
7. Aguardar o estado **Tentando conectar**.
8. Considerar concluído somente quando a tela mostrar **Conectado**.

Não há conexão automática ao abrir o aplicativo. Essa decisão evita tentativas concorrentes, torna o dispositivo escolhido explícito e permite distinguir atualização da lista, tentativa GATT e sessão ativa.

## Critérios de sucesso

Uma conexão só é promovida para `Connected` depois de:

1. validar que o perfil clássico do rádio está conectado;
2. localizar o anúncio `PLUS-APP`;
3. abrir GATT com sucesso;
4. descobrir `FFF0/FFF1`;
5. habilitar notificações locais;
6. aguardar 1.500 ms e enfileirar `01 03` para sincronização.

## Interpretação de falhas

| Sintoma/log | Significado | Ação |
|---|---|---|
| Rádio ativo no Android, app desconectado | Apenas A2DP está ativo | Conectar manualmente no ToCar |
| `00:00:00:00:00:00` | Endereço BLE mascarado pelo MIUI | Executar descoberta do sistema e usar associação validada |
| `BLE status 62` | Link LE não estabelecido | Aguardar e repetir de forma limitada |
| `Descriptor 2902` ausente | Limitação normal deste firmware | Continuar sem escrever CCCD |
| ToCar e CarLive falham igualmente | Possível módulo BLE travado | Reinício elétrico completo do rádio |
| `status=8` após sessão ativa | Timeout da conexão BLE | Fechar GATT, informar desconexão e permitir nova tentativa |

## Limites da evidência

Os endereços e tempos foram validados no Xiaomi M2101K6G com Android 13/MIUI 14 e nesta unidade RS-2751BR PLUS. Outro telefone, firmware ou rádio pode exigir tempos diferentes e pode apresentar outro endereço BLE. UUIDs, sequência GATT e ausência de `2902` foram observados diretamente; o fallback de endereço deve continuar isolado e documentado como específico do equipamento.
