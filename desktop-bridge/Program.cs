using System.Net;
using System.Net.Sockets;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Text;
using Windows.Devices.Bluetooth;
using Windows.Devices.Bluetooth.GenericAttributeProfile;
using Windows.Devices.Enumeration;
using Windows.Storage.Streams;

const int Port = 8765;
var bridge = new BleBridge();
var listener = new TcpListener(IPAddress.Any, Port);
listener.Start();
Console.WriteLine($"ToCar Desktop Bridge ouvindo em 0.0.0.0:{Port}");
Console.WriteLine("O rádio só recebe dados depois de CONNECT e WRITE enviados pelo aplicativo.");

while (true)
{
    var client = await listener.AcceptTcpClientAsync();
    Console.WriteLine($"Cliente conectado: {client.Client.RemoteEndPoint}");
    _ = HandleClientAsync(client, bridge);
}

static async Task HandleClientAsync(TcpClient client, BleBridge bridge)
{
    using (client)
    using (var reader = new StreamReader(client.GetStream(), Encoding.UTF8))
    using (var writer = new StreamWriter(client.GetStream(), new UTF8Encoding(false)) { AutoFlush = true })
    {
        bridge.SetEventSink(line => SafeWriteAsync(writer, line));
        try
        {
            string? line;
            while ((line = await reader.ReadLineAsync()) != null)
            {
                Console.WriteLine($"> {line}");
                var split = line.Split('|', 2);
                switch (split[0])
                {
                    case "HELLO": await writer.WriteLineAsync("HELLO|TOCAR_WINDOWS_BRIDGE|1"); break;
                    case "SCAN": await bridge.ScanAsync(writer); break;
                    case "CONNECT" when split.Length == 2: await bridge.ConnectAsync(split[1], writer); break;
                    case "WRITE" when split.Length == 2: await bridge.WriteAsync(split[1], writer); break;
                    case "DISCONNECT": bridge.Disconnect(); await writer.WriteLineAsync("DISCONNECTED"); break;
                    default: await writer.WriteLineAsync("ERROR|Comando desconhecido"); break;
                }
            }
        }
        catch (Exception error)
        {
            Console.WriteLine($"Cliente terminou: {error.Message}");
        }
        finally
        {
            bridge.Disconnect();
            bridge.SetEventSink(null);
        }
    }
}

static Task SafeWriteAsync(StreamWriter writer, string line)
{
    try { return writer.WriteLineAsync(line); }
    catch { return Task.CompletedTask; }
}

sealed class BleBridge
{
    private static readonly Guid ServiceUuid = Guid.Parse("0000FFF0-0000-1000-8000-00805F9B34FB");
    private static readonly Guid CharacteristicUuid = Guid.Parse("0000FFF1-0000-1000-8000-00805F9B34FB");
    private BluetoothLEDevice? device;
    private GattCharacteristic? characteristic;
    private Func<string, Task>? eventSink;

    public void SetEventSink(Func<string, Task>? sink) => eventSink = sink;

    public async Task ScanAsync(StreamWriter writer)
    {
        try
        {
            var selector = BluetoothLEDevice.GetDeviceSelector();
            var devices = await DeviceInformation.FindAllAsync(selector);
            foreach (var item in devices.OrderBy(item => item.Name))
            {
                var id = Convert.ToBase64String(Encoding.UTF8.GetBytes(item.Id));
                var displayName = string.IsNullOrWhiteSpace(item.Name) ? "BLE sem nome" : item.Name;
                await writer.WriteLineAsync($"DEVICE|{Sanitize(displayName)}|{id}");
            }
            await writer.WriteLineAsync("SCAN_DONE");
            Console.WriteLine($"Scan Windows retornou {devices.Count} dispositivos BLE conhecidos.");
        }
        catch (Exception error) { await writer.WriteLineAsync($"ERROR|Scan: {Sanitize(error.Message)}"); }
    }

    public async Task ConnectAsync(string encodedId, StreamWriter writer)
    {
        try
        {
            Disconnect();
            var id = Encoding.UTF8.GetString(Convert.FromBase64String(encodedId));
            device = await BluetoothLEDevice.FromIdAsync(id) ?? throw new InvalidOperationException("Dispositivo BLE indisponível");
            var serviceResult = await device.GetGattServicesForUuidAsync(ServiceUuid, BluetoothCacheMode.Uncached);
            if (serviceResult.Status != GattCommunicationStatus.Success || serviceResult.Services.Count == 0)
                throw new InvalidOperationException($"Serviço FFF0 não encontrado ({serviceResult.Status})");
            var characteristicResult = await serviceResult.Services[0].GetCharacteristicsForUuidAsync(CharacteristicUuid, BluetoothCacheMode.Uncached);
            if (characteristicResult.Status != GattCommunicationStatus.Success || characteristicResult.Characteristics.Count == 0)
                throw new InvalidOperationException($"Característica FFF1 não encontrada ({characteristicResult.Status})");
            characteristic = characteristicResult.Characteristics[0];
            characteristic.ValueChanged += OnValueChanged;
            var notifyStatus = await characteristic.WriteClientCharacteristicConfigurationDescriptorAsync(
                GattClientCharacteristicConfigurationDescriptorValue.Notify);
            if (notifyStatus != GattCommunicationStatus.Success)
                throw new InvalidOperationException($"Falha habilitando notificações ({notifyStatus})");
            await writer.WriteLineAsync($"CONNECTED|{Sanitize(device.Name)}");
            Console.WriteLine($"BLE conectado: {device.Name} / FFF0 / FFF1");
        }
        catch (Exception error) { await writer.WriteLineAsync($"ERROR|Connect: {Sanitize(error.Message)}"); Disconnect(); }
    }

    public async Task WriteAsync(string hex, StreamWriter writer)
    {
        try
        {
            var target = characteristic ?? throw new InvalidOperationException("Rádio não conectado");
            var bytes = Convert.FromHexString(hex.Replace(" ", ""));
            var result = await target.WriteValueWithResultAsync(bytes.AsBuffer(), GattWriteOption.WriteWithResponse);
            if (result.Status != GattCommunicationStatus.Success)
                throw new InvalidOperationException($"GATT write {result.Status}");
            Console.WriteLine($"TX {Convert.ToHexString(bytes)}");
            await writer.WriteLineAsync($"TX_OK|{Convert.ToHexString(bytes)}");
        }
        catch (Exception error) { await writer.WriteLineAsync($"ERROR|Write: {Sanitize(error.Message)}"); }
    }

    public void Disconnect()
    {
        if (characteristic != null) characteristic.ValueChanged -= OnValueChanged;
        characteristic = null;
        device?.Dispose();
        device = null;
    }

    private async void OnValueChanged(GattCharacteristic sender, GattValueChangedEventArgs args)
    {
        var reader = DataReader.FromBuffer(args.CharacteristicValue);
        var bytes = new byte[reader.UnconsumedBufferLength];
        reader.ReadBytes(bytes);
        var hex = Convert.ToHexString(bytes);
        Console.WriteLine($"RX {hex}");
        if (eventSink != null) await eventSink($"RX|{hex}");
    }

    private static string Sanitize(string value) => value.Replace('|', '/').Replace('\r', ' ').Replace('\n', ' ');
}
