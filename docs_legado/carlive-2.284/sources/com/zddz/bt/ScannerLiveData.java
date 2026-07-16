package com.zddz.bt;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanResult;
import androidx.lifecycle.LiveData;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class ScannerLiveData extends LiveData {
    private BluetoothDevice mBluetoothDevice = null;
    private ScanResult mScanResult = null;
    private int mRssi = 0;
    private byte[] mScanRecord = null;
    private int mState = 0;

    public void update(BluetoothDevice bluetoothDevice, ScanResult scanResult, int i, byte[] bArr, int i2) {
        this.mBluetoothDevice = bluetoothDevice;
        this.mScanResult = scanResult;
        this.mRssi = i;
        this.mScanRecord = bArr;
        this.mState = i2;
        postValue(this);
    }

    public BluetoothDevice getBluetoothDevice() {
        return this.mBluetoothDevice;
    }

    public ScanResult getScanResult() {
        return this.mScanResult;
    }

    public int getRssi() {
        return this.mRssi;
    }

    public byte[] getScanRecord() {
        return this.mScanRecord;
    }

    public int getState() {
        return this.mState;
    }
}
