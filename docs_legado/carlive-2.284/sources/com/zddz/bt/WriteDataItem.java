package com.zddz.bt;

import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class WriteDataItem {
    public String mAddress;
    public byte[] mData;
    public UUID mService;
    public long mTimeUse;
    public UUID mWrite;

    public WriteDataItem() {
    }

    public WriteDataItem(String str, UUID uuid, UUID uuid2, byte[] bArr, long j) {
        this.mAddress = str;
        this.mService = uuid;
        this.mWrite = uuid2;
        this.mData = bArr;
        this.mTimeUse = j;
    }
}
