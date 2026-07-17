# Auditoria das funções do Player

Auditoria estática contra `RadioCommand`, `CommandEncoder` e o `OrderSet.java` legado. Ela confirma o pacote gerado pelo aplicativo; a confirmação elétrica no RS-2751BR ainda depende de teste real e retorno RX.

| Controle | Pacote | Situação |
|---|---:|---|
| POWER | `01 01` | Mapeado; estado visual confirmado por RX `08 xx` |
| MODE | `08 01` | Mapeado |
| MUTE | `09 01` | Mapeado |
| RADIO/USB/SD/BT/AUX | `08 04/02/03/05/06` | Mapeados |
| Volume -/+ | `04 01/02` | Mapeados |
| Volume absoluto | `04 03 VV` | Mapeado de 0 a 63 |
| Anterior/Próxima | `03 01 00` / `03 02 00` | Mapeados |
| -10/+10 | `03 03` / `03 04` | Mapeados |
| DIR-/DIR+ | `03 09` / `03 08` | Mapeados |
| INT | `04 06 01` | Mapeado como browse/intro do CarLive |
| RPT | `04 06 00` | Mapeado como loop do CarLive |
| RDM/Shuffle | `04 06 03` | Mapeado como random do CarLive |
| LOUD | `04 04` | Mapeado como toggle do CarLive |
| BAND/AMS | `07 01/02` | Mapeados |
| Selecionar pasta/faixa | `03 05 PP FF` | Mapeado; índices limitados a um byte |
| Cor do painel | `0E 00 xx` | Cores confirmadas no catálogo legado; OFF ainda pendente |
| PLAY/PAUSE | — | Pendente: legado possui pacotes distintos para play e pause, mas o estado atual não informa qual enviar |
| EQ/BAS/TRE/BAL/FAD | — | Pendente: constantes existem, mas a codificação de valores precisa ser validada antes do envio |
| CLOCK | — | Apenas visual, conforme solicitado |
| ATENDER/ENCERRAR | — | Sem constantes encontradas no catálogo CarLive; envio permanece bloqueado |
| COR como fonte | — | Abre conceito de painel, não representa fonte física no protocolo |

## RSSI Bluetooth

O indicador lê RSSI real via `BluetoothGatt.readRemoteRssi()` a cada três segundos. A leitura não altera descoberta, handshake, escrita de comandos ou reconexão.
