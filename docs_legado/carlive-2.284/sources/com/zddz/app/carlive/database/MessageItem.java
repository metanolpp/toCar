package com.zddz.app.carlive.database;

import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class MessageItem {
    public int mEnd;
    public String mMessage;
    public int mStart;
    public String mTime = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss:SSS").format(new Date());

    public MessageItem(String str, int i, int i2) {
        this.mMessage = str;
        this.mStart = i;
        this.mEnd = i2;
    }
}
