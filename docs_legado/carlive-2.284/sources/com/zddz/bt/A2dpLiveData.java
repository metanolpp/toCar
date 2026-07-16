package com.zddz.bt;

import androidx.lifecycle.LiveData;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class A2dpLiveData extends LiveData {
    private String mAddress = "";
    private int mA2dpState = 0;

    public void update(String str, int i) {
        this.mAddress = str;
        this.mA2dpState = i;
        postValue(this);
    }

    public String getAddress() {
        return this.mAddress;
    }

    public int getA2dpState() {
        return this.mA2dpState;
    }
}
