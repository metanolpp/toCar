package com.zddz.bt;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanResult;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class DeviceItem implements Parcelable {
    public static final Parcelable.Creator CREATOR = new 1();
    public static final int ConnectBonded = 6;
    public static final int ConnectBonding = 5;
    public static final int ConnectError = 3;
    public static final int ConnectTimeout = 4;
    public static final int Connected = 2;
    public static final int Connecting = 1;
    public static final int Disconnect = 0;
    public static final int Paired = 7;
    public String mAddress;
    public String mManufactureData = "";
    public String mName;
    public int mRssi;
    public int mState;

    public int describeContents() {
        return 0;
    }

    public DeviceItem(BluetoothDevice bluetoothDevice, String str, int i) {
        this.mState = 0;
        if (TextUtils.isEmpty(str)) {
            this.mName = bluetoothDevice.getName();
        } else {
            this.mName = str;
        }
        this.mAddress = bluetoothDevice.getAddress();
        this.mState = i;
    }

    protected DeviceItem(Parcel parcel) {
        this.mState = 0;
        this.mName = parcel.readString();
        this.mAddress = parcel.readString();
        this.mState = parcel.readInt();
    }

    class 1 implements Parcelable.Creator {
        1() {
        }

        public DeviceItem createFromParcel(Parcel parcel) {
            return new DeviceItem(parcel);
        }

        public DeviceItem[] newArray(int i) {
            return new DeviceItem[i];
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mName);
        parcel.writeString(this.mAddress);
        parcel.writeInt(this.mState);
    }

    public boolean matches(ScanResult scanResult) {
        return this.mAddress.equals(scanResult.getDevice().getAddress());
    }
}
