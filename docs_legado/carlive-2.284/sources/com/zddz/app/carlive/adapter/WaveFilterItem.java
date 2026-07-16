package com.zddz.app.carlive.adapter;

import com.zddz.app.carlive.database.WaveFilterRecord;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class WaveFilterItem {
    public String mFrequency;
    public int mGain;
    public boolean mGainFromUser = false;
    public boolean mGainMove = false;
    public int mNumber;
    public int mQValue;

    public WaveFilterItem(WaveFilterRecord waveFilterRecord) {
        this.mNumber = waveFilterRecord.number;
        this.mFrequency = waveFilterRecord.frequency;
        this.mGain = waveFilterRecord.gain;
        this.mQValue = waveFilterRecord.q_value;
    }
}
