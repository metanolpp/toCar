package com.zddz.bt;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.provider.Settings;

/* compiled from: D8$$SyntheticClass */
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final /* synthetic */ class BtService$$ExternalSyntheticApiModelOutline0 {
    public static /* bridge */ /* synthetic */ int m(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i) {
        return bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic, bArr, i);
    }

    public static /* bridge */ /* synthetic */ int m(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr) {
        return bluetoothGatt.writeDescriptor(bluetoothGattDescriptor, bArr);
    }

    public static /* bridge */ /* synthetic */ int m(Context context, int i) {
        return context.getColor(i);
    }

    public static /* bridge */ /* synthetic */ BluetoothGatt m(BluetoothDevice bluetoothDevice, Context context, boolean z, BluetoothGattCallback bluetoothGattCallback, int i) {
        return bluetoothDevice.connectGatt(context, z, bluetoothGattCallback, i);
    }

    public static /* bridge */ /* synthetic */ BluetoothGatt m(BluetoothDevice bluetoothDevice, Context context, boolean z, BluetoothGattCallback bluetoothGattCallback, int i, int i2) {
        return bluetoothDevice.connectGatt(context, z, bluetoothGattCallback, i, i2);
    }

    public static /* bridge */ /* synthetic */ ScanSettings.Builder m(ScanSettings.Builder builder, int i) {
        return builder.setMatchMode(i);
    }

    public static /* bridge */ /* synthetic */ boolean m() {
        return Environment.isExternalStorageManager();
    }

    public static /* bridge */ /* synthetic */ boolean m(Context context) {
        return Settings.canDrawOverlays(context);
    }

    public static /* bridge */ /* synthetic */ boolean m(PackageManager packageManager) {
        return packageManager.canRequestPackageInstalls();
    }

    public static /* bridge */ /* synthetic */ ScanSettings.Builder m$1(ScanSettings.Builder builder, int i) {
        return builder.setCallbackType(i);
    }

    public static /* bridge */ /* synthetic */ ScanSettings.Builder m$2(ScanSettings.Builder builder, int i) {
        return builder.setNumOfMatches(i);
    }
}
