package com.zddz.bt;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import java.lang.reflect.Method;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class BtMethod {
    public static boolean refreshGatt(BluetoothGatt bluetoothGatt) {
        if (bluetoothGatt != null) {
            try {
                Method method = bluetoothGatt.getClass().getMethod("refresh", (Class[]) null);
                if (method != null) {
                    return ((Boolean) method.invoke(bluetoothGatt, (Object[]) null)).booleanValue();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean createBond(BluetoothDevice bluetoothDevice) {
        try {
            setPin(bluetoothDevice, "0000");
            return ((Boolean) bluetoothDevice.getClass().getMethod("createBond", (Class[]) null).invoke(bluetoothDevice, (Object[]) null)).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean removeBond(BluetoothDevice bluetoothDevice) {
        try {
            return ((Boolean) bluetoothDevice.getClass().getMethod("removeBond", (Class[]) null).invoke(bluetoothDevice, (Object[]) null)).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean cancelBondProcess(BluetoothDevice bluetoothDevice) {
        try {
            return ((Boolean) bluetoothDevice.getClass().getMethod("cancelBondProcess", (Class[]) null).invoke(bluetoothDevice, (Object[]) null)).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean cancelPairingUserInput(BluetoothDevice bluetoothDevice) {
        try {
            return ((Boolean) bluetoothDevice.getClass().getMethod("cancelPairingUserInput", (Class[]) null).invoke(bluetoothDevice, (Object[]) null)).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean setPin(BluetoothDevice bluetoothDevice, String str) {
        try {
            return ((Boolean) bluetoothDevice.getClass().getDeclaredMethod("setPin", new Class[]{byte[].class}).invoke(bluetoothDevice, new Object[]{str.getBytes()})).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean setPassKey(BluetoothDevice bluetoothDevice, String str) throws Exception {
        try {
            return ((Boolean) bluetoothDevice.getClass().getDeclaredMethod("setPasskey", new Class[]{byte[].class}).invoke(bluetoothDevice, new Object[]{str.getBytes()})).booleanValue();
        } catch (SecurityException e) {
            e.printStackTrace();
            return false;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return false;
        } catch (Exception e3) {
            e3.printStackTrace();
            return false;
        }
    }
}
