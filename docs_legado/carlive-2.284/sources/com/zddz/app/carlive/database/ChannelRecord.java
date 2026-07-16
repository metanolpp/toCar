package com.zddz.app.carlive.database;

import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class ChannelRecord extends LitePalSupport {
    public int delay;
    public int gain;
    public int high_pass_frequency;
    public int high_pass_slope;
    public int high_pass_switch;
    public int low_pass_frequency;
    public int low_pass_slope;
    public int low_pass_switch;

    @Column(nullable = false, unique = true)
    public String number;
    public int phase;

    public ChannelRecord() {
    }

    public ChannelRecord(String str) {
        this.number = str;
        this.high_pass_switch = 1;
        this.high_pass_slope = 1;
        this.low_pass_switch = 1;
        this.low_pass_slope = 1;
        this.phase = 1;
        this.delay = 30;
        this.gain = 32;
    }
}
