package com.zddz.app.carlive.fragment;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public interface IMain {
    void addWriteData(byte[] bArr, long j);

    boolean checkBle(String str);

    void clearWriteData();

    void closeScanDialog();

    void connectBle(String str, String str2, String str3);

    void disconnectBle(String str);

    void setItemVisibility();

    void showScanDialog();

    void startLocation(long j, float f);

    void startScanDevice();

    void stopScanDevice();

    boolean writeData(byte[] bArr);
}
