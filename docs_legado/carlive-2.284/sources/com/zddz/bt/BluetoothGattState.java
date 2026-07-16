package com.zddz.bt;

import android.bluetooth.BluetoothGatt;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class BluetoothGattState {
    public BluetoothGatt mBluetoothGatt;
    public int mConnectState;
    public boolean mConnected;
    public boolean mDiscoveryService;
    public String mManufactureData;
    public int mMtuCount = 20;
    public boolean mMtuSwitch;
    public String mName;

    public BluetoothGattState(BluetoothGatt bluetoothGatt, String str, String str2, int i, boolean z, boolean z2) {
        this.mConnected = false;
        this.mBluetoothGatt = bluetoothGatt;
        this.mName = str;
        this.mConnectState = i;
        this.mMtuSwitch = z;
        this.mDiscoveryService = z2;
        this.mManufactureData = str2;
        this.mConnected = i == 2;
    }
}
