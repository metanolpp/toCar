package com.zddz.app.carlive.database;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class ChannelItem {
    public int mDelay;
    public int mGain;
    public int mHighPassFrequency;
    public int mHighPassSlope;
    public int mHighPassSwitch;
    public int mLowPassFrequency;
    public int mLowPassSlope;
    public int mLowPassSwitch;
    public String mNumber;
    public int mPhase;

    public ChannelItem(String str) {
        this.mNumber = str;
        this.mHighPassSwitch = 0;
        this.mHighPassFrequency = 6000;
        this.mHighPassSlope = 1;
        this.mLowPassSwitch = 0;
        this.mLowPassFrequency = 400;
        this.mLowPassSlope = 1;
        this.mPhase = 0;
        this.mDelay = 0;
        this.mGain = 32;
    }

    public ChannelItem(ChannelRecord channelRecord) {
        this.mNumber = channelRecord.number;
        this.mHighPassSwitch = channelRecord.high_pass_switch;
        this.mHighPassFrequency = channelRecord.high_pass_frequency;
        this.mHighPassSlope = channelRecord.high_pass_slope;
        this.mLowPassSwitch = channelRecord.low_pass_switch;
        this.mLowPassFrequency = channelRecord.low_pass_frequency;
        this.mLowPassSlope = channelRecord.low_pass_slope;
        this.mPhase = channelRecord.phase;
        this.mDelay = channelRecord.delay;
        this.mGain = channelRecord.gain;
    }
}
