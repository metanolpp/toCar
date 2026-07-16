package com.zddz.bt;

import android.bluetooth.BluetoothGatt;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.litepal.LitePal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class ConnectListHelper {
    protected List mGattStateList = new ArrayList();

    public void updateBluetoothGattConnected(String str, boolean z) {
        for (BluetoothGattState bluetoothGattState : this.mGattStateList) {
            if (bluetoothGattState.mBluetoothGatt.getDevice().getAddress().equals(str)) {
                bluetoothGattState.mConnected = z;
                if (z) {
                    bluetoothGattState.mConnectState = 2;
                    DeviceRecord deviceRecord = (DeviceRecord) LitePal.where("address = ?", str).findFirst(DeviceRecord.class);
                    if (deviceRecord == null) {
                        deviceRecord = new DeviceRecord(str, bluetoothGattState.mName, bluetoothGattState.mManufactureData);
                    } else {
                        deviceRecord.name = bluetoothGattState.mName;
                    }
                    deviceRecord.save();
                } else {
                    bluetoothGattState.mConnectState = 0;
                }
            }
        }
    }

    public void updateBluetoothGattConnectState(BluetoothGatt bluetoothGatt, String str, String str2, int i) {
        String address = bluetoothGatt.getDevice().getAddress();
        for (BluetoothGattState bluetoothGattState : this.mGattStateList) {
            if (bluetoothGattState.mBluetoothGatt.getDevice().getAddress().equals(address)) {
                bluetoothGattState.mConnectState = i;
                if (TextUtils.isEmpty(bluetoothGattState.mManufactureData) && !TextUtils.isEmpty(str2)) {
                    bluetoothGattState.mManufactureData = str2;
                }
                bluetoothGattState.mConnected = i == 2;
                if (bluetoothGattState.mConnected) {
                    DeviceRecord deviceRecord = (DeviceRecord) LitePal.where("address = ?", address).findFirst(DeviceRecord.class);
                    if (deviceRecord == null) {
                        deviceRecord = new DeviceRecord(address, bluetoothGattState.mName, bluetoothGattState.mManufactureData);
                    } else {
                        deviceRecord.name = bluetoothGattState.mName;
                    }
                    deviceRecord.save();
                    return;
                }
                return;
            }
        }
        this.mGattStateList.add(new BluetoothGattState(bluetoothGatt, str, str2, i, false, false));
    }

    public synchronized void updateBluetoothGattStateMtuSwitch(BluetoothGatt bluetoothGatt, int i, boolean z) {
        String address = bluetoothGatt.getDevice().getAddress();
        for (BluetoothGattState bluetoothGattState : this.mGattStateList) {
            if (bluetoothGattState.mBluetoothGatt.getDevice().getAddress().equals(address)) {
                bluetoothGattState.mMtuSwitch = z;
                bluetoothGattState.mMtuCount = i;
                return;
            }
        }
    }

    public synchronized void updateBluetoothGattStateDiscoveryService(BluetoothGatt bluetoothGatt, boolean z) {
        String address = bluetoothGatt.getDevice().getAddress();
        for (BluetoothGattState bluetoothGattState : this.mGattStateList) {
            if (bluetoothGattState.mBluetoothGatt.getDevice().getAddress().equals(address)) {
                bluetoothGattState.mDiscoveryService = z;
                return;
            }
        }
    }

    public BluetoothGattState getBluetoothGattState(String str) {
        for (BluetoothGattState bluetoothGattState : this.mGattStateList) {
            if (bluetoothGattState.mBluetoothGatt.getDevice().getAddress().equals(str)) {
                return bluetoothGattState;
            }
        }
        return null;
    }

    public BluetoothGatt getBluetoothGatt(String str) {
        for (BluetoothGattState bluetoothGattState : this.mGattStateList) {
            if (bluetoothGattState.mBluetoothGatt.getDevice().getAddress().equals(str)) {
                return bluetoothGattState.mBluetoothGatt;
            }
        }
        return null;
    }

    public boolean checkConnected(String str) {
        Iterator it = this.mGattStateList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            BluetoothGattState bluetoothGattState = (BluetoothGattState) it.next();
            if (bluetoothGattState.mBluetoothGatt.getDevice().getAddress().equals(str)) {
                if (bluetoothGattState.mConnected) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkConnecting(String str) {
        Iterator it = this.mGattStateList.iterator();
        while (it.hasNext()) {
            if (((BluetoothGattState) it.next()).mBluetoothGatt.getDevice().getAddress().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkConnectTimeout(String str) {
        Iterator it = this.mGattStateList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            BluetoothGattState bluetoothGattState = (BluetoothGattState) it.next();
            if (bluetoothGattState.mBluetoothGatt.getDevice().getAddress().equals(str)) {
                if (bluetoothGattState.mConnected) {
                    return false;
                }
                it.remove();
                bluetoothGattState.mBluetoothGatt.close();
            }
        }
        return true;
    }

    public boolean checkConnected4ManufactureData(String str) {
        Iterator it = this.mGattStateList.iterator();
        while (it.hasNext()) {
            if (((BluetoothGattState) it.next()).mManufactureData.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean disconnectBle(String str) {
        Iterator it = this.mGattStateList.iterator();
        while (it.hasNext()) {
            BluetoothGattState bluetoothGattState = (BluetoothGattState) it.next();
            if (bluetoothGattState.mBluetoothGatt.getDevice().getAddress().equals(str)) {
                it.remove();
                bluetoothGattState.mBluetoothGatt.disconnect();
                return true;
            }
        }
        return false;
    }

    public void disconnectOther(String str) {
        Iterator it = this.mGattStateList.iterator();
        while (it.hasNext()) {
            BluetoothGattState bluetoothGattState = (BluetoothGattState) it.next();
            if (!bluetoothGattState.mBluetoothGatt.getDevice().getAddress().equals(str)) {
                it.remove();
                bluetoothGattState.mBluetoothGatt.disconnect();
                BtMethod.refreshGatt(bluetoothGattState.mBluetoothGatt);
                bluetoothGattState.mBluetoothGatt.close();
            }
        }
    }

    public void closeAllBle() {
        Iterator it = this.mGattStateList.iterator();
        while (it.hasNext()) {
            BluetoothGattState bluetoothGattState = (BluetoothGattState) it.next();
            it.remove();
            bluetoothGattState.mBluetoothGatt.disconnect();
            BtMethod.refreshGatt(bluetoothGattState.mBluetoothGatt);
            bluetoothGattState.mBluetoothGatt.close();
        }
    }

    public boolean requestMtu(String str, int i) {
        for (BluetoothGattState bluetoothGattState : this.mGattStateList) {
            if (bluetoothGattState.mBluetoothGatt.getDevice().getAddress().equals(str)) {
                return bluetoothGattState.mBluetoothGatt.requestMtu(i);
            }
        }
        return false;
    }

    public boolean discoverServices(String str) {
        for (BluetoothGattState bluetoothGattState : this.mGattStateList) {
            if (bluetoothGattState.mBluetoothGatt.getDevice().getAddress().equals(str)) {
                return bluetoothGattState.mBluetoothGatt.discoverServices();
            }
        }
        return false;
    }

    public int getConnectedSize() {
        Iterator it = this.mGattStateList.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (((BluetoothGattState) it.next()).mConnected) {
                i++;
            }
        }
        return i;
    }

    public List getGattStateList() {
        return this.mGattStateList;
    }
}
