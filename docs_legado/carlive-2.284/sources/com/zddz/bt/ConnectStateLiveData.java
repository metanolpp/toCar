package com.zddz.bt;

import androidx.lifecycle.LiveData;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class ConnectStateLiveData extends LiveData {
    private String mAddress;
    private int mState;

    public void update(String str, int i) {
        this.mAddress = str;
        this.mState = i;
        postValue(this);
    }

    public String getAddress() {
        return this.mAddress;
    }

    public int getState() {
        return this.mState;
    }
}
