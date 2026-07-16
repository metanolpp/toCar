package com.zddz.bt;

import android.app.Service;
import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.provider.Settings;
import androidx.core.app.ActivityCompat;
import com.zddz.permission.PermissionHelper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class BtService extends Service {
    public static int BLE_NEED_BLUETOOTH_ENABLE = 2;
    public static int BLE_NEED_BLUETOOTH_PERMISSION = 1;
    public static int BLE_NEED_LOCATION_PERMISSION = 3;
    public static int BLE_NEED_LOCATION_SERVICE = 4;
    public static int BLE_NEED_OK = 0;
    private static long HONEY_CMD_TIMEOUT = 2000;
    private A2dpLiveData mA2dpLiveData;
    protected BluetoothAdapter mBluetoothAdapter;
    private BluetoothLeScanner mBluetoothLeScanner;
    protected BluetoothManager mBluetoothManager;
    protected ConnectListHelper mConnectListHelper;
    private LocationListener mGpsLocationListener;
    private Handler mHandler;
    private BluetoothAdapter.LeScanCallback mLeScanCallback;
    private LocationManager mLocationManager;
    private Messenger mMessenger;
    private LocationListener mNetworkLocationListener;
    private ScanCallback mScanCallback;
    private ScannerLiveData mScannerLiveData;
    private BluetoothGattCallback mGattCallback = null;
    private boolean mScanning = false;
    private BluetoothA2dp mBluetoothA2dp = null;
    private long mLastUse = 0;
    private long mBusyTime = 0;
    private Queue mWriteDataQueue = new ConcurrentLinkedQueue();
    private Runnable mWriteDataRunnable = new 12();
    private BtBinder mBinder = new BtBinder();

    static /* synthetic */ void access$000(BtService btService, String str, int i) {
        btService.sendConnectedState(str, i);
    }

    static /* synthetic */ BluetoothA2dp access$100(BtService btService) {
        return btService.mBluetoothA2dp;
    }

    static /* synthetic */ BluetoothA2dp access$102(BtService btService, BluetoothA2dp bluetoothA2dp) {
        btService.mBluetoothA2dp = bluetoothA2dp;
        return bluetoothA2dp;
    }

    static /* synthetic */ A2dpLiveData access$200(BtService btService) {
        return btService.mA2dpLiveData;
    }

    static /* synthetic */ Messenger access$300(BtService btService) {
        return btService.mMessenger;
    }

    static /* synthetic */ ScannerLiveData access$400(BtService btService) {
        return btService.mScannerLiveData;
    }

    static /* synthetic */ Queue access$500(BtService btService) {
        return btService.mWriteDataQueue;
    }

    static /* synthetic */ long access$600(BtService btService) {
        return btService.mBusyTime;
    }

    static /* synthetic */ long access$602(BtService btService, long j) {
        btService.mBusyTime = j;
        return j;
    }

    static /* synthetic */ long access$700(BtService btService) {
        return btService.mLastUse;
    }

    static /* synthetic */ long access$702(BtService btService, long j) {
        btService.mLastUse = j;
        return j;
    }

    static /* synthetic */ Handler access$800(BtService btService) {
        return btService.mHandler;
    }

    public boolean checkConnected(String str) {
        return this.mConnectListHelper.checkConnected(str);
    }

    private boolean checkConnecting(String str) {
        return this.mConnectListHelper.checkConnecting(str);
    }

    class 1 implements Runnable {
        final /* synthetic */ String val$pAddress;

        1(String str) {
            this.val$pAddress = str;
        }

        public void run() {
            if (BtService.this.mConnectListHelper.checkConnectTimeout(this.val$pAddress)) {
                BtService.access$000(BtService.this, this.val$pAddress, 4);
            }
        }
    }

    private void connectTimeOut(String str) {
        this.mHandler.postDelayed(new 1(str), 30000L);
    }

    private void sendConnectedState(String str, int i) {
        try {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = str;
            obtain.arg1 = i;
            this.mMessenger.send(obtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized int connectBle(String str, String str2, String str3) {
        if (Build.VERSION.SDK_INT >= 31 && ActivityCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_CONNECT") != 0) {
            return BLE_NEED_BLUETOOTH_PERMISSION;
        }
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        if (bluetoothAdapter != null && bluetoothAdapter.isEnabled()) {
            if (checkConnected(str)) {
                sendConnectedState(str, 2);
                return BLE_NEED_OK;
            }
            if (checkConnecting(str)) {
                return BLE_NEED_OK;
            }
            if (BluetoothAdapter.checkBluetoothAddress(str)) {
                BluetoothDevice remoteDevice = this.mBluetoothAdapter.getRemoteDevice(str);
                if (Build.VERSION.SDK_INT >= 26) {
                    BluetoothGatt m = BtService$$ExternalSyntheticApiModelOutline0.m(remoteDevice, this, false, this.mGattCallback, 2, 1);
                    if (m != null) {
                        this.mConnectListHelper.updateBluetoothGattConnectState(m, str2, str3, 1);
                        sendConnectedState(str, 1);
                        connectTimeOut(str);
                    }
                } else if (Build.VERSION.SDK_INT >= 23) {
                    BluetoothGatt m2 = BtService$$ExternalSyntheticApiModelOutline0.m(remoteDevice, this, false, this.mGattCallback, 2);
                    if (m2 != null) {
                        this.mConnectListHelper.updateBluetoothGattConnectState(m2, str2, str3, 1);
                        sendConnectedState(str, 1);
                        connectTimeOut(str);
                    }
                } else {
                    BluetoothGatt connectGatt = remoteDevice.connectGatt(this, false, this.mGattCallback);
                    if (connectGatt != null) {
                        this.mConnectListHelper.updateBluetoothGattConnectState(connectGatt, str2, str3, 1);
                        sendConnectedState(str, 1);
                        connectTimeOut(str);
                    }
                }
            }
            return BLE_NEED_OK;
        }
        return BLE_NEED_BLUETOOTH_ENABLE;
    }

    public void disconnectBle(String str) {
        BluetoothGatt connectGatt;
        if (!this.mConnectListHelper.disconnectBle(str)) {
            if (this.mBluetoothAdapter.isEnabled() && BluetoothAdapter.checkBluetoothAddress(str)) {
                BluetoothDevice remoteDevice = this.mBluetoothAdapter.getRemoteDevice(str);
                if (Build.VERSION.SDK_INT >= 26) {
                    connectGatt = BtService$$ExternalSyntheticApiModelOutline0.m(remoteDevice, this, false, new 2(), 2, 1);
                } else if (Build.VERSION.SDK_INT >= 23) {
                    connectGatt = BtService$$ExternalSyntheticApiModelOutline0.m(remoteDevice, this, false, new 3(), 2);
                } else {
                    connectGatt = remoteDevice.connectGatt(this, false, new 4());
                }
                if (connectGatt != null) {
                    connectGatt.disconnect();
                    connectGatt.close();
                    this.mConnectListHelper.updateBluetoothGattConnected(str, false);
                    sendConnectedState(str, 0);
                    return;
                }
                return;
            }
            return;
        }
        if (this.mBluetoothAdapter.isEnabled()) {
            return;
        }
        this.mConnectListHelper.updateBluetoothGattConnected(str, false);
        sendConnectedState(str, 0);
    }

    class 2 extends BluetoothGattCallback {
        2() {
        }
    }

    class 3 extends BluetoothGattCallback {
        3() {
        }
    }

    class 4 extends BluetoothGattCallback {
        4() {
        }
    }

    public void disconnectOther(String str) {
        this.mConnectListHelper.disconnectOther(str);
    }

    public void closeAllBle() {
        this.mConnectListHelper.closeAllBle();
    }

    public boolean requestMtu(String str, int i) {
        return this.mConnectListHelper.requestMtu(str, i);
    }

    public boolean discoverServices(String str) {
        return this.mConnectListHelper.discoverServices(str);
    }

    public boolean setCharacteristicNotification(BluetoothGatt bluetoothGatt, UUID uuid, UUID uuid2, boolean z) {
        List<BluetoothGattDescriptor> descriptors;
        try {
            BluetoothGattCharacteristic characteristic = bluetoothGatt.getService(uuid).getCharacteristic(uuid2);
            boolean characteristicNotification = bluetoothGatt.setCharacteristicNotification(characteristic, z);
            if (characteristicNotification && (descriptors = characteristic.getDescriptors()) != null && descriptors.size() > 0) {
                for (BluetoothGattDescriptor bluetoothGattDescriptor : descriptors) {
                    if ((characteristic.getProperties() & 16) != 0) {
                        if (Build.VERSION.SDK_INT >= 33) {
                            BtService$$ExternalSyntheticApiModelOutline0.m(bluetoothGatt, bluetoothGattDescriptor, BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                        } else {
                            bluetoothGattDescriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                            bluetoothGatt.writeDescriptor(bluetoothGattDescriptor);
                        }
                    } else if ((characteristic.getProperties() & 32) != 0) {
                        if (Build.VERSION.SDK_INT >= 33) {
                            BtService$$ExternalSyntheticApiModelOutline0.m(bluetoothGatt, bluetoothGattDescriptor, BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);
                        } else {
                            bluetoothGattDescriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                            bluetoothGatt.writeDescriptor(bluetoothGattDescriptor);
                        }
                    }
                }
            }
            return characteristicNotification;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean isDeviceBusy(BluetoothGatt bluetoothGatt) {
        try {
            return ((Boolean) readField(bluetoothGatt, "mDeviceBusy")).booleanValue();
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Object readField(Object obj, String str) throws IllegalAccessException, NoSuchFieldException {
        Field declaredField = obj.getClass().getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    public int writeCharacteristic(BluetoothGatt bluetoothGatt, UUID uuid, UUID uuid2, byte[] bArr) {
        if (Build.VERSION.SDK_INT < 33) {
            long currentTimeMillis = System.currentTimeMillis();
            while (System.currentTimeMillis() - currentTimeMillis < HONEY_CMD_TIMEOUT && isDeviceBusy(bluetoothGatt)) {
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            BluetoothGattCharacteristic characteristic = bluetoothGatt.getService(uuid).getCharacteristic(uuid2);
            if (Build.VERSION.SDK_INT >= 33) {
                return BtService$$ExternalSyntheticApiModelOutline0.m(bluetoothGatt, characteristic, bArr, characteristic.getWriteType());
            }
            characteristic.setValue(bArr);
            return bluetoothGatt.writeCharacteristic(characteristic) ? 0 : 257;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 257;
        }
    }

    public boolean setCharacteristicNotification(String str, UUID uuid, UUID uuid2, boolean z) {
        BluetoothGatt bluetoothGatt = this.mConnectListHelper.getBluetoothGatt(str);
        if (bluetoothGatt != null) {
            return setCharacteristicNotification(bluetoothGatt, uuid, uuid2, z);
        }
        return false;
    }

    public int writeCharacteristic(String str, UUID uuid, UUID uuid2, byte[] bArr) {
        BluetoothGatt bluetoothGatt = this.mConnectListHelper.getBluetoothGatt(str);
        if (bluetoothGatt != null) {
            return writeCharacteristic(bluetoothGatt, uuid, uuid2, bArr);
        }
        return 257;
    }

    private synchronized void setScanning(boolean z) {
        this.mScanning = z;
        try {
            Message obtain = Message.obtain();
            obtain.what = 8;
            obtain.obj = Boolean.valueOf(z);
            this.mMessenger.send(obtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ScanSettings buildScanSettings() {
        ScanSettings.Builder builder = new ScanSettings.Builder();
        builder.setScanMode(2);
        builder.setReportDelay(0L);
        if (Build.VERSION.SDK_INT >= 23) {
            BtService$$ExternalSyntheticApiModelOutline0.m(builder, 1);
            BtService$$ExternalSyntheticApiModelOutline0.m$1(builder, 1);
            BtService$$ExternalSyntheticApiModelOutline0.m$2(builder, 1);
        }
        return builder.build();
    }

    private List buildScanFilters(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ScanFilter.Builder builder = new ScanFilter.Builder();
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].length() >= 4) {
                builder.setManufacturerData(Integer.valueOf(strArr[i].substring(2, 4) + strArr[i].substring(0, 2), 16).intValue(), Convert.hexStringToBytes(strArr[i].substring(4)));
                arrayList.add(i, builder.build());
            }
        }
        return arrayList;
    }

    public int startScanDevice(String[] strArr) {
        if (Build.VERSION.SDK_INT >= 31 && ActivityCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_SCAN") != 0) {
            return BLE_NEED_BLUETOOTH_PERMISSION;
        }
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            return BLE_NEED_BLUETOOTH_ENABLE;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (Settings.Secure.getInt(getContentResolver(), "location_mode", 0) == 0) {
                return BLE_NEED_LOCATION_SERVICE;
            }
            if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
                return BLE_NEED_LOCATION_PERMISSION;
            }
        }
        if (!this.mScanning) {
            setScanning(true);
            try {
                Iterator it = this.mBluetoothManager.getConnectedDevices(7).iterator();
                while (it.hasNext()) {
                    this.mScannerLiveData.update((BluetoothDevice) it.next(), null, 0, null, 2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            new Handler().postDelayed(new 5(), 10000L);
            if (this.mBluetoothLeScanner == null) {
                this.mBluetoothLeScanner = this.mBluetoothAdapter.getBluetoothLeScanner();
            }
            this.mBluetoothLeScanner.startScan(buildScanFilters(strArr), buildScanSettings(), this.mScanCallback);
        }
        return BLE_NEED_OK;
    }

    class 5 implements Runnable {
        5() {
        }

        public void run() {
            BtService.this.stopScanDevice();
        }
    }

    public void stopScanDevice() {
        BluetoothAdapter bluetoothAdapter;
        setScanning(false);
        if ((Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_SCAN") == 0) && (bluetoothAdapter = this.mBluetoothAdapter) != null && bluetoothAdapter.isEnabled()) {
            if (this.mBluetoothLeScanner == null) {
                this.mBluetoothLeScanner = this.mBluetoothAdapter.getBluetoothLeScanner();
            }
            this.mBluetoothLeScanner.stopScan(this.mScanCallback);
            this.mBluetoothLeScanner = null;
            if (this.mBluetoothAdapter.isDiscovering()) {
                this.mBluetoothAdapter.cancelDiscovery();
            }
        }
    }

    public BluetoothDevice getBluetoothDevice(String str) {
        BluetoothGatt bluetoothGatt = this.mConnectListHelper.getBluetoothGatt(str);
        if (bluetoothGatt != null) {
            return bluetoothGatt.getDevice();
        }
        return this.mBluetoothAdapter.getRemoteDevice(str);
    }

    class 6 implements BluetoothProfile.ServiceListener {
        6() {
        }

        public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
            if (i == 2 && bluetoothProfile != null) {
                BtService.access$102(BtService.this, (BluetoothA2dp) bluetoothProfile);
                if (BtService.access$100(BtService.this).getConnectedDevices().size() > 0) {
                    BtService.access$200(BtService.this).update(((BluetoothDevice) BtService.access$100(BtService.this).getConnectedDevices().get(0)).getAddress(), 2);
                } else {
                    BtService.access$200(BtService.this).update("", 0);
                }
            }
            BtService.this.mBluetoothAdapter.closeProfileProxy(2, BtService.access$100(BtService.this));
        }

        public void onServiceDisconnected(int i) {
            if (i == 2) {
                BtService.access$102(BtService.this, null);
            }
        }
    }

    public synchronized void checkA2dpConnected() {
        try {
            this.mBluetoothAdapter.getProfileProxy(this, new 6(), 2);
        } catch (Exception e) {
            e.printStackTrace();
            this.mA2dpLiveData.update("", 0);
        }
    }

    class 7 implements BluetoothProfile.ServiceListener {
        final /* synthetic */ BluetoothDevice val$pDevice;

        7(BluetoothDevice bluetoothDevice) {
            this.val$pDevice = bluetoothDevice;
        }

        public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
            if (bluetoothProfile != null) {
                BtService.access$102(BtService.this, (BluetoothA2dp) bluetoothProfile);
                List connectedDevices = BtService.access$100(BtService.this).getConnectedDevices();
                for (int i2 = 0; i2 < connectedDevices.size(); i2++) {
                    BluetoothDevice bluetoothDevice = (BluetoothDevice) connectedDevices.get(i2);
                    if (this.val$pDevice.equals(bluetoothDevice)) {
                        BtService.access$200(BtService.this).update(bluetoothDevice.getAddress(), 6);
                        return;
                    }
                }
                try {
                    Method declaredMethod = BtService.access$100(BtService.this).getClass().getDeclaredMethod("connect", new Class[]{BluetoothDevice.class});
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(bluetoothProfile, new Object[]{this.val$pDevice});
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public void onServiceDisconnected(int i) {
            if (i == 2) {
                BtService.access$102(BtService.this, null);
            }
        }
    }

    public void pair2connectA2dp(Context context, BluetoothDevice bluetoothDevice) {
        this.mBluetoothAdapter.getProfileProxy(context, new 7(bluetoothDevice), 2);
    }

    public void connectA2dp(Context context, String str, boolean z) {
        if (z) {
            if (this.mBluetoothAdapter.isDiscovering()) {
                this.mBluetoothAdapter.cancelDiscovery();
            }
            for (BluetoothDevice bluetoothDevice : this.mBluetoothAdapter.getBondedDevices()) {
                if (bluetoothDevice.getAddress().equals(str)) {
                    pair2connectA2dp(context, bluetoothDevice);
                    return;
                }
            }
            this.mBluetoothAdapter.startDiscovery();
            new Thread(new 8()).start();
            return;
        }
        BluetoothDevice remoteDevice = this.mBluetoothAdapter.getRemoteDevice(str);
        if (remoteDevice.getBondState() != 12) {
            BtMethod.createBond(remoteDevice);
        } else {
            pair2connectA2dp(context, remoteDevice);
        }
    }

    class 8 implements Runnable {
        8() {
        }

        public void run() {
            try {
                Thread.sleep(10000L);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (BtService.this.mBluetoothAdapter.isDiscovering()) {
                BtService.this.mBluetoothAdapter.cancelDiscovery();
            }
        }
    }

    public ScannerLiveData getScannerLiveData() {
        return this.mScannerLiveData;
    }

    public A2dpLiveData getA2dpLiveData() {
        return this.mA2dpLiveData;
    }

    private void initBluetoothSetting() {
        this.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        this.mHandler = new Handler();
        this.mGattCallback = new 9();
        this.mScanCallback = new 10();
    }

    class 9 extends BluetoothGattCallback {
        9() {
        }

        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            String address = bluetoothGatt.getDevice().getAddress();
            if (i == 133) {
                BtMethod.refreshGatt(bluetoothGatt);
                bluetoothGatt.close();
                BtService.this.mConnectListHelper.updateBluetoothGattConnected(address, false);
                BtService.access$000(BtService.this, address, 3);
                return;
            }
            if (i != 0) {
                if (i2 == 0) {
                    BtService.this.mConnectListHelper.updateBluetoothGattConnected(address, false);
                    BtService.access$000(BtService.this, address, 0);
                    BtMethod.refreshGatt(bluetoothGatt);
                    bluetoothGatt.close();
                    return;
                }
                return;
            }
            if (i2 == 2) {
                BtService.this.mConnectListHelper.updateBluetoothGattConnected(address, true);
                BtService.access$000(BtService.this, address, 2);
            } else if (i2 == 0) {
                BtService.this.mConnectListHelper.updateBluetoothGattConnected(address, false);
                BtService.access$000(BtService.this, address, 0);
                BtMethod.refreshGatt(bluetoothGatt);
                bluetoothGatt.close();
            }
        }

        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            if (i == 0) {
                BtService.this.mConnectListHelper.updateBluetoothGattStateDiscoveryService(bluetoothGatt, true);
            } else {
                BtService.this.mConnectListHelper.updateBluetoothGattStateDiscoveryService(bluetoothGatt, false);
                bluetoothGatt.disconnect();
            }
            try {
                Message obtain = Message.obtain();
                obtain.what = 3;
                obtain.obj = bluetoothGatt.getDevice().getAddress();
                if (i == 0) {
                    obtain.arg1 = 1;
                } else {
                    obtain.arg1 = 0;
                }
                BtService.access$300(BtService.this).send(obtain);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
            try {
                Message obtain = Message.obtain();
                obtain.what = 4;
                obtain.obj = bluetoothGatt.getDevice().getAddress();
                Bundle bundle = new Bundle();
                bundle.putString("com.zddz.bt.extra.BLE_DEVICE_ADDRESS", bluetoothGatt.getDevice().getAddress());
                bundle.putSerializable("com.zddz.bt.extra.BLE_NOTICE_UUID", bluetoothGattCharacteristic.getUuid());
                bundle.putByteArray("com.zddz.bt.extra.BLE_VALUE", bluetoothGattCharacteristic.getValue());
                obtain.setData(bundle);
                BtService.access$300(BtService.this).send(obtain);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            super.onMtuChanged(bluetoothGatt, i, i2);
            if (i2 == 0) {
                BtService.this.mConnectListHelper.updateBluetoothGattStateMtuSwitch(bluetoothGatt, i, true);
            } else {
                BtService.this.mConnectListHelper.updateBluetoothGattStateMtuSwitch(bluetoothGatt, i, false);
            }
            try {
                Message obtain = Message.obtain();
                obtain.what = 2;
                obtain.obj = bluetoothGatt.getDevice().getAddress();
                if (i2 == 0) {
                    obtain.arg1 = 1;
                } else {
                    obtain.arg1 = 0;
                }
                obtain.arg2 = i;
                BtService.access$300(BtService.this).send(obtain);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class 10 extends ScanCallback {
        10() {
        }

        public void onScanResult(int i, ScanResult scanResult) {
            super.onScanResult(i, scanResult);
            BtService.access$400(BtService.this).update(null, scanResult, 0, null, 0);
        }
    }

    class 11 implements BluetoothAdapter.LeScanCallback {
        11() {
        }

        public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            BtService.access$400(BtService.this).update(bluetoothDevice, null, i, bArr, 0);
        }
    }

    public void setMessenger(Messenger messenger) {
        this.mMessenger = messenger;
    }

    class 12 implements Runnable {
        12() {
        }

        public void run() {
            if (!BtService.access$500(BtService.this).isEmpty()) {
                WriteDataItem writeDataItem = (WriteDataItem) BtService.access$500(BtService.this).poll();
                if (writeDataItem != null) {
                    if (writeDataItem.mData != null) {
                        BtService.this.writeCharacteristic(writeDataItem.mAddress, writeDataItem.mService, writeDataItem.mWrite, writeDataItem.mData);
                    }
                    BtService btService = BtService.this;
                    BtService.access$602(btService, (BtService.access$600(btService) + writeDataItem.mTimeUse) - BtService.access$700(BtService.this));
                    BtService.access$702(BtService.this, writeDataItem.mTimeUse);
                    BtService.access$800(BtService.this).postDelayed(this, writeDataItem.mTimeUse);
                    return;
                }
                return;
            }
            BtService btService2 = BtService.this;
            BtService.access$602(btService2, BtService.access$600(btService2) - BtService.access$700(BtService.this));
            BtService.access$702(BtService.this, 0L);
        }
    }

    public void addWriteData(WriteDataItem writeDataItem) {
        if (this.mWriteDataQueue.isEmpty()) {
            this.mWriteDataQueue.offer(writeDataItem);
            this.mHandler.postDelayed(this.mWriteDataRunnable, this.mBusyTime);
        } else {
            this.mWriteDataQueue.offer(writeDataItem);
        }
    }

    public void clearWriteData() {
        this.mWriteDataQueue.clear();
        this.mLastUse = 0L;
        this.mBusyTime = 0L;
    }

    public boolean startGpsLocation(long j, float f) {
        BluetoothAdapter bluetoothAdapter;
        boolean checkWifiStatus = PermissionHelper.checkWifiStatus(this);
        boolean checkGPS = PermissionHelper.checkGPS(this);
        List arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 23) {
            if (Build.VERSION.SDK_INT >= 31) {
                arrayList = PermissionHelper.checkPermissions(this, new String[]{"android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_SCAN"});
            }
            if (arrayList.size() == 0) {
                this.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            }
            if (!PermissionHelper.checkPermission(this, "android.permission.ACCESS_COARSE_LOCATION")) {
                arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
            }
            if (!PermissionHelper.checkPermission(this, "android.permission.ACCESS_FINE_LOCATION")) {
                arrayList.add("android.permission.ACCESS_FINE_LOCATION");
            }
        }
        if (!checkWifiStatus || !checkGPS || (bluetoothAdapter = this.mBluetoothAdapter) == null || !bluetoothAdapter.isEnabled() || arrayList.size() > 0 || !this.mLocationManager.getAllProviders().contains("gps") || !this.mLocationManager.isProviderEnabled("gps")) {
            return false;
        }
        13 r9 = new 13();
        this.mGpsLocationListener = r9;
        this.mLocationManager.requestLocationUpdates("gps", j, f, r9);
        return true;
    }

    class 13 implements LocationListener {
        public void onProviderDisabled(String str) {
        }

        public void onProviderEnabled(String str) {
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
        }

        13() {
        }

        public void onLocationChanged(Location location) {
            try {
                Message obtain = Message.obtain();
                obtain.what = 9;
                obtain.obj = location;
                BtService.access$300(BtService.this).send(obtain);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean startNetworkLocation(long j, float f) {
        boolean checkNetworkAvailable = PermissionHelper.checkNetworkAvailable(this);
        List arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 23) {
            if (Build.VERSION.SDK_INT >= 31) {
                arrayList = PermissionHelper.checkPermissions(this, new String[]{"android.permission.INTERNET"});
            }
            if (!PermissionHelper.checkPermission(this, "android.permission.ACCESS_COARSE_LOCATION")) {
                arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
            }
            if (!PermissionHelper.checkPermission(this, "android.permission.ACCESS_FINE_LOCATION")) {
                arrayList.add("android.permission.ACCESS_FINE_LOCATION");
            }
        }
        if (!checkNetworkAvailable || arrayList.size() > 0 || !this.mLocationManager.getAllProviders().contains("network") || !this.mLocationManager.isProviderEnabled("network")) {
            return false;
        }
        14 r8 = new 14();
        this.mNetworkLocationListener = r8;
        this.mLocationManager.requestLocationUpdates("network", j, f, r8);
        return true;
    }

    class 14 implements LocationListener {
        public void onProviderDisabled(String str) {
        }

        public void onProviderEnabled(String str) {
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
        }

        14() {
        }

        public void onLocationChanged(Location location) {
            try {
                Message obtain = Message.obtain();
                obtain.what = 9;
                obtain.obj = location;
                BtService.access$300(BtService.this).send(obtain);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void stopNetworkLocation() {
        LocationListener locationListener = this.mNetworkLocationListener;
        if (locationListener != null) {
            this.mLocationManager.removeUpdates(locationListener);
            this.mNetworkLocationListener = null;
        }
    }

    public void stopGpsLocation() {
        LocationListener locationListener = this.mGpsLocationListener;
        if (locationListener != null) {
            this.mLocationManager.removeUpdates(locationListener);
            this.mGpsLocationListener = null;
        }
    }

    public void onCreate() {
        super.onCreate();
        this.mConnectListHelper = new ConnectListHelper();
        this.mScannerLiveData = new ScannerLiveData();
        this.mA2dpLiveData = new A2dpLiveData();
        BluetoothManager bluetoothManager = (BluetoothManager) getSystemService("bluetooth");
        this.mBluetoothManager = bluetoothManager;
        if (bluetoothManager != null) {
            initBluetoothSetting();
        }
        this.mLocationManager = (LocationManager) getSystemService("location");
    }

    public void onDestroy() {
        closeAllBle();
        stopGpsLocation();
        stopNetworkLocation();
        super.onDestroy();
    }

    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    public class BtBinder extends Binder {
        public BtBinder() {
        }

        public BtService getService() {
            return BtService.this;
        }
    }
}
