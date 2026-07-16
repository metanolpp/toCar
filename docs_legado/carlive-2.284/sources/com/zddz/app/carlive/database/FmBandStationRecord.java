package com.zddz.app.carlive.database;

import org.litepal.crud.LitePalSupport;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class FmBandStationRecord extends LitePalSupport {
    public int band;
    public int number;
    public String station;

    public FmBandStationRecord() {
    }

    public FmBandStationRecord(int i, int i2, String str) {
        this.band = i;
        this.number = i2;
        this.station = str;
    }
}
