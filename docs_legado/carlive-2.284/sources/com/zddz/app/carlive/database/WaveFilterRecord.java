package com.zddz.app.carlive.database;

import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class WaveFilterRecord extends LitePalSupport {
    public String frequency;
    public int gain;

    @Column(nullable = false, unique = true)
    public int number;
    public int q_value;

    public WaveFilterRecord() {
    }

    public WaveFilterRecord(int i) {
        this.number = i;
        this.gain = 32;
        this.q_value = 12;
        switch (i) {
            case 0:
                this.frequency = "50";
                break;
            case 1:
                this.frequency = "80";
                break;
            case 2:
                this.frequency = "100";
                break;
            case 3:
                this.frequency = "125";
                break;
            case 4:
                this.frequency = "200";
                break;
            case 5:
                this.frequency = "315";
                break;
            case 6:
                this.frequency = "500";
                break;
            case 7:
                this.frequency = "630";
                break;
            case 8:
                this.frequency = "800";
                break;
            case 9:
                this.frequency = "1000";
                break;
            case 10:
                this.frequency = "1250";
                break;
            case 11:
                this.frequency = "2000";
                break;
            case 12:
                this.frequency = "2500";
                break;
            case 13:
                this.frequency = "3150";
                break;
            case 14:
                this.frequency = "4000";
                break;
            case 15:
                this.frequency = "5000";
                break;
            case 16:
                this.frequency = "6300";
                break;
            case 17:
                this.frequency = "8000";
                break;
            case 18:
                this.frequency = "12500";
                break;
            case 19:
                this.frequency = "16000";
                break;
        }
    }
}
