package com.zddz.bt;

import org.litepal.crud.LitePalSupport;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class DeviceRecord extends LitePalSupport {
    public String address;
    public boolean auto_connect;
    private String manufacture_data;
    public String name;

    public DeviceRecord() {
        this.manufacture_data = "";
    }

    public DeviceRecord(String str, String str2, String str3) {
        this.manufacture_data = "";
        this.address = str;
        this.name = str2;
        if (str3.isEmpty()) {
            return;
        }
        this.manufacture_data = str3;
    }

    public String getManufacture_data() {
        return this.manufacture_data;
    }

    public void setManufacture_data(String str) {
        this.manufacture_data = str;
    }

    public int delete() {
        return super.delete();
    }
}
