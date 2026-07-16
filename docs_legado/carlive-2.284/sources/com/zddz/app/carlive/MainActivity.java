package com.zddz.app.carlive;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.ScanResult;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.hjq.toast.ToastUtils;
import com.zddz.app.carlive.fragment.BaseViewModel;
import com.zddz.app.carlive.fragment.IMain;
import com.zddz.app.carlive.fragment.MainFragment;
import com.zddz.app.carlive.fragment.ScanFragment;
import com.zddz.bt.A2dpLiveData;
import com.zddz.bt.BtService;
import com.zddz.bt.Convert;
import com.zddz.bt.DeviceItem;
import com.zddz.bt.DeviceRecord;
import com.zddz.bt.ScannerLiveData;
import com.zddz.bt.WriteDataItem;
import com.zddz.permission.PermissionActivity;
import com.zddz.permission.PermissionHelper;
import com.zddz.permission.PermissionItem;
import com.zddz.permission.PermissionRepository;
import com.zddz.ui.StatusBarUtil;
import com.zddz.ui.WhiteFilletToastStyle;
import com.zddz.update.UpdateActivity;
import com.zddz.widget.ProgressView;
import java.util.UUID;
import org.litepal.LitePal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class MainActivity extends UpdateActivity implements IMain {
    private TextView bt_close;
    private LinearLayout ll_state;
    private BaseViewModel mBaseViewModel;
    private BroadcastReceiver mBroadcastReceiver;
    private BtService mBtService;
    private Handler mHandler;
    private MainFragment mMainFragment;
    private PermissionRepository mPermissionRepository;
    private ScanFragment mScanFragment;
    private ProgressView pv_prompt;
    private TextView tv_prompt;
    private final ServiceConnection mBtServiceConnection = new 5();
    private boolean mHasFocus = false;
    private boolean mNeedLocation = false;

    static /* synthetic */ BaseViewModel access$000(MainActivity mainActivity) {
        return mainActivity.mBaseViewModel;
    }

    static /* synthetic */ BtService access$100(MainActivity mainActivity) {
        return mainActivity.mBtService;
    }

    static /* synthetic */ void access$1000(MainActivity mainActivity) {
        mainActivity.initBleCallbackReceiver();
    }

    static /* synthetic */ BtService access$102(MainActivity mainActivity, BtService btService) {
        mainActivity.mBtService = btService;
        return btService;
    }

    static /* synthetic */ boolean access$1100(MainActivity mainActivity) {
        return mainActivity.mHasFocus;
    }

    static /* synthetic */ BroadcastReceiver access$1200(MainActivity mainActivity) {
        return mainActivity.mBroadcastReceiver;
    }

    static /* synthetic */ void access$1300(MainActivity mainActivity) {
        mainActivity.checkUpdate();
    }

    static /* synthetic */ boolean access$200(MainActivity mainActivity) {
        return mainActivity.mNeedLocation;
    }

    static /* synthetic */ boolean access$202(MainActivity mainActivity, boolean z) {
        mainActivity.mNeedLocation = z;
        return z;
    }

    static /* synthetic */ ScanFragment access$300(MainActivity mainActivity) {
        return mainActivity.mScanFragment;
    }

    static /* synthetic */ MainFragment access$400(MainActivity mainActivity) {
        return mainActivity.mMainFragment;
    }

    static /* synthetic */ LinearLayout access$500(MainActivity mainActivity) {
        return mainActivity.ll_state;
    }

    static /* synthetic */ Handler access$600(MainActivity mainActivity) {
        return mainActivity.mHandler;
    }

    static /* synthetic */ TextView access$700(MainActivity mainActivity) {
        return mainActivity.tv_prompt;
    }

    static /* synthetic */ ProgressView access$800(MainActivity mainActivity) {
        return mainActivity.pv_prompt;
    }

    static /* synthetic */ TextView access$900(MainActivity mainActivity) {
        return mainActivity.bt_close;
    }

    class 1 extends BroadcastReceiver {
        1() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
                String bleAddress = MainActivity.access$000(MainActivity.this).getBleAddress();
                if (12 == intExtra) {
                    MainActivity.this.startScanDevice();
                    return;
                } else {
                    if (MainActivity.access$100(MainActivity.this) == null || !MainActivity.access$100(MainActivity.this).checkConnected(bleAddress)) {
                        return;
                    }
                    MainActivity.access$100(MainActivity.this).disconnectBle(bleAddress);
                    return;
                }
            }
            if ("android.bluetooth.a2dp.profile.action.PLAYING_STATE_CHANGED".equals(action)) {
                intent.getIntExtra("android.bluetooth.profile.extra.STATE", 11);
                MainActivity.access$000(MainActivity.this).getMode();
                return;
            }
            if ("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED".equals(action)) {
                BluetoothDevice parcelableExtra = intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                int intExtra2 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
                if (intExtra2 == 2) {
                    MainActivity.access$100(MainActivity.this).getA2dpLiveData().update(parcelableExtra.getAddress(), 2);
                    return;
                } else if (intExtra2 == 0) {
                    MainActivity.access$100(MainActivity.this).getA2dpLiveData().update(parcelableExtra.getAddress(), 0);
                    return;
                } else {
                    if (intExtra2 == 1) {
                        MainActivity.access$100(MainActivity.this).getA2dpLiveData().update(parcelableExtra.getAddress(), 1);
                        return;
                    }
                    return;
                }
            }
            if ("android.net.wifi.WIFI_STATE_CHANGED".equals(action)) {
                if (3 == intent.getIntExtra("wifi_state", 1) && MainActivity.access$200(MainActivity.this)) {
                    MainActivity.access$100(MainActivity.this).startGpsLocation(1200000L, 5000.0f);
                    return;
                }
                return;
            }
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) && PermissionHelper.checkNetworkAvailable(MainActivity.this) && MainActivity.access$200(MainActivity.this)) {
                MainActivity.access$100(MainActivity.this).startNetworkLocation(1200000L, 5000.0f);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initBleCallbackReceiver() {
        this.mBroadcastReceiver = new 1();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.a2dp.profile.action.PLAYING_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(this.mBroadcastReceiver, intentFilter);
        this.mBtService.getA2dpLiveData().observe(this, new 2());
        this.mBtService.getScannerLiveData().observe(this, new 3());
        this.mHandler = new 4(Looper.myLooper());
    }

    class 2 implements Observer {
        2() {
        }

        public void onChanged(A2dpLiveData a2dpLiveData) {
            if (a2dpLiveData.getA2dpState() == 2 || MainActivity.access$000(MainActivity.this).getMode() != 5) {
                return;
            }
            Intent intent = new Intent("android.settings.BLUETOOTH_SETTINGS");
            intent.addFlags(536870912);
            MainActivity.this.startActivity(intent);
            ToastUtils.show(2131755384);
        }
    }

    class 3 implements Observer {
        3() {
        }

        public void onChanged(ScannerLiveData scannerLiveData) {
            DeviceRecord deviceRecord;
            if (scannerLiveData.getBluetoothDevice() != null) {
                DeviceItem deviceItem = new DeviceItem(scannerLiveData.getBluetoothDevice(), "", scannerLiveData.getState());
                if (TextUtils.isEmpty(deviceItem.mName) && (deviceRecord = (DeviceRecord) LitePal.where("address = ?", deviceItem.mAddress).findFirst(DeviceRecord.class)) != null) {
                    deviceItem.mName = deviceRecord.name;
                    deviceItem.mManufactureData = deviceRecord.getManufacture_data();
                }
                MainActivity.access$300(MainActivity.this).updateDeviceItem(deviceItem);
                if (MainActivity.access$000(MainActivity.this).getBleAddress().equals(deviceItem.mAddress) && MainActivity.access$000(MainActivity.this).getAutoConnect() && !MainActivity.access$100(MainActivity.this).checkConnected(deviceItem.mAddress)) {
                    MainActivity.this.connectBle(deviceItem.mAddress, deviceItem.mName, MainActivity.access$000(MainActivity.this).getManufactureData());
                    return;
                }
                return;
            }
            if (scannerLiveData.getScanResult() != null) {
                ScanResult scanResult = scannerLiveData.getScanResult();
                String deviceName = scanResult.getScanRecord().getDeviceName();
                if (!TextUtils.isEmpty(deviceName)) {
                    String address = scanResult.getDevice().getAddress();
                    DeviceRecord deviceRecord2 = (DeviceRecord) LitePal.where("address = ?", address).findFirst(DeviceRecord.class);
                    String upperCase = Convert.bytesToHexString(scanResult.getScanRecord().getBytes()).substring(10, 22).toUpperCase();
                    if (upperCase.startsWith("5A44")) {
                        if (deviceRecord2 == null) {
                            deviceRecord2 = new DeviceRecord(address, deviceName, upperCase);
                        }
                        deviceRecord2.name = deviceName;
                        deviceRecord2.setManufacture_data(upperCase);
                        deviceRecord2.save();
                    }
                }
                DeviceItem deviceItem2 = new DeviceItem(scanResult.getDevice(), deviceName, 0);
                if (TextUtils.isEmpty(deviceItem2.mName)) {
                    return;
                }
                MainActivity.access$000(MainActivity.this).deleteDeviceRecord(deviceItem2.mAddress);
                MainActivity.access$300(MainActivity.this).updateDeviceItem(deviceItem2);
            }
        }
    }

    class 4 extends Handler {
        4(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            Location location;
            try {
                if (message.what == 1) {
                    String str = (String) message.obj;
                    MainActivity.access$400(MainActivity.this).mIsLiBang = false;
                    if (2 == message.arg1) {
                        MainActivity.access$100(MainActivity.this).discoverServices(str);
                        MainActivity.access$100(MainActivity.this).disconnectOther(str);
                        MainActivity.access$300(MainActivity.this).updateDeviceItem(new DeviceItem(MainActivity.access$100(MainActivity.this).getBluetoothDevice(str), "", 2));
                        MainActivity.access$600(MainActivity.this).postDelayed(new 1(), 2000L);
                        MainActivity.access$000(MainActivity.this).setLatitude(0.0d);
                        MainActivity.access$000(MainActivity.this).setLongitude(0.0d);
                        if (MainActivity.access$000(MainActivity.this).getAllowLocation()) {
                            MainActivity.this.startLocation(1200000L, 5000.0f);
                            return;
                        } else {
                            ToastUtils.show(2131755200);
                            return;
                        }
                    }
                    if (1 == message.arg1) {
                        MainActivity.access$300(MainActivity.this).updateDeviceItem(new DeviceItem(MainActivity.access$100(MainActivity.this).getBluetoothDevice(str), "", 1));
                        if (MainActivity.this.getSupportFragmentManager().findFragmentByTag("ScanFragment") == null) {
                            MainActivity.access$700(MainActivity.this).setText(2131755127);
                            MainActivity.access$800(MainActivity.this).setVisibility(0);
                            MainActivity.access$800(MainActivity.this).start();
                            MainActivity.access$900(MainActivity.this).setText(2131755082);
                            MainActivity.access$500(MainActivity.this).setVisibility(0);
                            return;
                        }
                        return;
                    }
                    if (message.arg1 == 0 || 4 == message.arg1) {
                        MainActivity.access$300(MainActivity.this).updateDeviceItem(new DeviceItem(MainActivity.access$100(MainActivity.this).getBluetoothDevice(str), "", 0));
                        if (TextUtils.isEmpty(MainActivity.access$000(MainActivity.this).getBleAddress()) || MainActivity.access$000(MainActivity.this).getBleAddress().equals(str)) {
                            MainActivity.access$000(MainActivity.this).disconnect();
                            MainActivity.access$400(MainActivity.this).disconnect();
                        }
                        if (MainActivity.this.getSupportFragmentManager().findFragmentByTag("ScanFragment") == null && MainActivity.access$000(MainActivity.this).getAutoConnect() && MainActivity.access$000(MainActivity.this).getBleAddress().equals(str)) {
                            MainActivity.access$700(MainActivity.this).setText(2131755128);
                            MainActivity.access$800(MainActivity.this).setVisibility(8);
                            MainActivity.access$900(MainActivity.this).setText(2131755104);
                            MainActivity.access$500(MainActivity.this).setVisibility(0);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (message.what == 3) {
                    String str2 = (String) message.obj;
                    if (message.arg1 == 1 && MainActivity.access$100(MainActivity.this).setCharacteristicNotification(str2, OrderSet.FFF0, OrderSet.FFF1, true)) {
                        MainActivity.access$600(MainActivity.this).postDelayed(new 2(str2), 1500L);
                        return;
                    }
                    return;
                }
                if (message.what == 4) {
                    Bundle data = message.getData();
                    String string = data.getString("com.zddz.bt.extra.BLE_DEVICE_ADDRESS", "");
                    UUID serializable = data.getSerializable("com.zddz.bt.extra.BLE_NOTICE_UUID");
                    byte[] byteArray = data.getByteArray("com.zddz.bt.extra.BLE_VALUE");
                    MainActivity.access$000(MainActivity.this).notice(byteArray);
                    MainActivity.access$400(MainActivity.this).notice(string, serializable, byteArray);
                    String upperCase = Convert.bytesToHexString(byteArray).toUpperCase();
                    if (upperCase.startsWith(OrderSet.notice_bt)) {
                        MainActivity.access$100(MainActivity.this).checkA2dpConnected();
                        return;
                    } else {
                        if (upperCase.startsWith(OrderSet.notice_update_location)) {
                            MainActivity.this.startLocation(1200000L, 5000.0f);
                            return;
                        }
                        return;
                    }
                }
                if (message.what == 8) {
                    Boolean bool = (Boolean) message.obj;
                    bool.booleanValue();
                    MainActivity.access$000(MainActivity.this).getScanningLiveData().postValue(bool);
                } else {
                    if (message.what != 9 || (location = (Location) message.obj) == null) {
                        return;
                    }
                    if (location.getProvider().equals("network")) {
                        MainActivity.access$100(MainActivity.this).stopNetworkLocation();
                    } else if (location.getProvider().equals("gps")) {
                        MainActivity.access$100(MainActivity.this).stopGpsLocation();
                    }
                    MainActivity.access$000(MainActivity.this).setLongitude(location.getLongitude());
                    MainActivity.access$000(MainActivity.this).setLatitude(location.getLatitude());
                    if (MainActivity.access$200(MainActivity.this)) {
                        ToastUtils.show(2131755085);
                        MainActivity.access$400(MainActivity.this).refreshRedPoint();
                        MainActivity.access$202(MainActivity.this, false);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        class 1 implements Runnable {
            1() {
            }

            public void run() {
                MainActivity.access$500(MainActivity.this).setVisibility(8);
            }
        }

        class 2 implements Runnable {
            final /* synthetic */ String val$tDiscoveryAddress;

            2(String str) {
                this.val$tDiscoveryAddress = str;
            }

            public void run() {
                MainActivity.access$100(MainActivity.this).writeCharacteristic(this.val$tDiscoveryAddress, OrderSet.FFF0, OrderSet.FFF1, OrderSet.write_synchronize);
            }
        }
    }

    class 5 implements ServiceConnection {
        5() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MainActivity.access$102(MainActivity.this, ((BtService.BtBinder) iBinder).getService());
            MainActivity.access$1000(MainActivity.this);
            MainActivity.access$100(MainActivity.this).setMessenger(new Messenger(MainActivity.access$600(MainActivity.this)));
            String bleAddress = MainActivity.access$000(MainActivity.this).getBleAddress();
            if (MainActivity.access$1100(MainActivity.this) && MainActivity.access$000(MainActivity.this).getAutoConnect() && !TextUtils.isEmpty(bleAddress)) {
                MainActivity.this.connectBle(bleAddress, "", "");
            } else {
                MainActivity.this.showScanDialog();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            try {
                MainActivity mainActivity = MainActivity.this;
                mainActivity.unregisterReceiver(MainActivity.access$1200(mainActivity));
                MainActivity.access$100(MainActivity.this).getScannerLiveData().removeObservers(MainActivity.this);
            } catch (Exception e) {
                e.printStackTrace();
            }
            MainActivity.access$102(MainActivity.this, null);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(128, 128);
        setContentView(2131492894);
        StatusBarUtil.setTranslucentStatus(this);
        StatusBarUtil.setStatusBarColor(this, Color.rgb(12, 77, 125));
        ToastUtils.setStyle(new WhiteFilletToastStyle());
        BluetoothManager bluetoothManager = (BluetoothManager) getSystemService("bluetooth");
        if (!getPackageManager().hasSystemFeature("android.hardware.bluetooth_le") || bluetoothManager == null) {
            ToastUtils.show(2131755045);
            finish();
        }
        if (checkAgree()) {
            isAgree();
        }
    }

    class 6 implements Runnable {
        6() {
        }

        public void run() {
            if (MainActivity.access$400(MainActivity.this) != null) {
                MainActivity.access$400(MainActivity.this).refreshRedPoint();
            }
        }
    }

    protected void canUpdate() {
        runOnUiThread(new 6());
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void isAgree() {
        this.mBaseViewModel = (BaseViewModel) new ViewModelProvider(this).get(BaseViewModel.class);
        PermissionRepository permissionRepository = PermissionRepository.getInstance();
        this.mPermissionRepository = permissionRepository;
        permissionRepository.getLocationServiceNeedListData().observe(this, new 7());
        this.mPermissionRepository.getOpenPermissionLiveData().observe(this, new 8());
        if (Build.VERSION.SDK_INT >= 31 && !PermissionHelper.checkPermission(this, "android.permission.INTERNET")) {
            PermissionItem permissionItem = new PermissionItem(new String[]{"android.permission.INTERNET"});
            permissionItem.setPermissionId(this);
            this.mPermissionRepository.addPermissionItem(permissionItem);
            Intent intent = new Intent(this, PermissionActivity.class);
            intent.setFlags(67108864);
            startActivity(intent);
        } else {
            checkUpdate();
        }
        this.mBaseViewModel.disconnect();
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        MainFragment mainFragment = new MainFragment();
        this.mMainFragment = mainFragment;
        beginTransaction.add(2131296511, mainFragment, "MainFragment");
        beginTransaction.addToBackStack(null);
        beginTransaction.commitAllowingStateLoss();
        this.mScanFragment = new ScanFragment();
        LinearLayout findViewById = findViewById(2131296602);
        this.ll_state = findViewById;
        findViewById.setVisibility(8);
        this.tv_prompt = findViewById(2131297023);
        this.pv_prompt = (ProgressView) findViewById(2131296713);
        TextView findViewById2 = findViewById(2131296359);
        this.bt_close = findViewById2;
        findViewById2.setOnClickListener(new 9());
        Intent intent2 = new Intent(this, BtService.class);
        intent2.setPackage(getPackageName());
        bindService(intent2, this.mBtServiceConnection, 1);
    }

    class 7 implements Observer {
        7() {
        }

        public void onChanged(Boolean bool) {
            if (bool.booleanValue()) {
                Intent intent = new Intent(MainActivity.this, PermissionActivity.class);
                intent.setFlags(67108864);
                MainActivity.this.startActivity(intent);
            } else if (MainActivity.access$100(MainActivity.this) != null) {
                if (MainActivity.access$200(MainActivity.this)) {
                    MainActivity.this.startLocation(1200000L, 5000.0f);
                } else {
                    MainActivity.this.startScanDevice();
                }
            }
        }
    }

    class 8 implements Observer {
        8() {
        }

        public void onChanged(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 31) {
                if ("android.permission.INTERNET".equals(str)) {
                    MainActivity.access$1300(MainActivity.this);
                }
                if ("android.permission.BLUETOOTH_CONNECT".equals(str) || "android.permission.BLUETOOTH_SCAN".equals(str) || "android.permission.BLUETOOTH_ADVERTISE".equals(str)) {
                    String bleAddress = MainActivity.access$000(MainActivity.this).getBleAddress();
                    if (!TextUtils.isEmpty(bleAddress) && MainActivity.access$000(MainActivity.this).getAutoConnect()) {
                        MainActivity mainActivity = MainActivity.this;
                        mainActivity.connectBle(bleAddress, "", MainActivity.access$000(mainActivity).getManufactureData());
                    } else {
                        MainActivity.this.startScanDevice();
                    }
                }
            }
            if ("android.permission.ACCESS_FINE_LOCATION".equals(str)) {
                if (MainActivity.access$200(MainActivity.this)) {
                    MainActivity.this.startLocation(1200000L, 5000.0f);
                } else {
                    MainActivity.this.startScanDevice();
                }
            }
        }
    }

    class 9 implements View.OnClickListener {
        9() {
        }

        public void onClick(View view) {
            if (MainActivity.access$800(MainActivity.this).getVisibility() == 0) {
                MainActivity.access$000(MainActivity.this).setAutoConnect(false);
                if (MainActivity.access$100(MainActivity.this) != null) {
                    MainActivity.access$100(MainActivity.this).disconnectBle(MainActivity.access$000(MainActivity.this).getBleAddress());
                    MainActivity.access$000(MainActivity.this).setBleAddress("");
                }
            }
            MainActivity.access$500(MainActivity.this).setVisibility(8);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.mHasFocus = z;
        if (z && this.mBtService != null && this.mBaseViewModel.getAutoConnect()) {
            String bleAddress = this.mBaseViewModel.getBleAddress();
            if (TextUtils.isEmpty(bleAddress) || this.mBtService.checkConnected(bleAddress)) {
                return;
            }
            connectBle(this.mBaseViewModel.getBleAddress(), "", "");
        }
    }

    public void onDestroy() {
        try {
            if (this.mBtService != null) {
                unbindService(this.mBtServiceConnection);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onDestroy();
    }

    public void onBackPressed() {
        if (this.ll_state.getVisibility() == 0) {
            if (this.pv_prompt.getVisibility() == 0) {
                this.mBaseViewModel.setAutoConnect(false);
                if (this.mBtService != null) {
                    disconnectBle(this.mBaseViewModel.getBleAddress());
                }
            }
            this.ll_state.setVisibility(8);
            return;
        }
        moveTaskToBack(true);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return false;
        }
        if (this.ll_state.getVisibility() == 0) {
            if (this.pv_prompt.getVisibility() == 0) {
                this.mBaseViewModel.setAutoConnect(false);
                if (this.mBtService != null) {
                    disconnectBle(this.mBaseViewModel.getBleAddress());
                }
            }
            this.ll_state.setVisibility(8);
        } else {
            moveTaskToBack(true);
        }
        return true;
    }

    private void checkBleNeed(int i) {
        if (BtService.BLE_NEED_LOCATION_SERVICE == i) {
            this.mPermissionRepository.getLocationServiceNeedListData().postValue(true);
            return;
        }
        if (BtService.BLE_NEED_BLUETOOTH_PERMISSION == i) {
            PermissionItem permissionItem = new PermissionItem(new String[]{"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_ADVERTISE"});
            permissionItem.setPermissionId(this);
            this.mPermissionRepository.addPermissionItem(permissionItem);
            Intent intent = new Intent(this, PermissionActivity.class);
            intent.setFlags(67108864);
            startActivity(intent);
            return;
        }
        if (BtService.BLE_NEED_LOCATION_PERMISSION == i) {
            PermissionItem permissionItem2 = new PermissionItem(new String[]{"android.permission.ACCESS_FINE_LOCATION"});
            permissionItem2.setPermissionId(this);
            this.mPermissionRepository.addPermissionItem(permissionItem2);
            Intent intent2 = new Intent(this, PermissionActivity.class);
            intent2.setFlags(67108864);
            startActivity(intent2);
            return;
        }
        if (BtService.BLE_NEED_BLUETOOTH_ENABLE == i) {
            Intent intent3 = new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE");
            intent3.addFlags(67108864);
            if (Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_CONNECT") == 0) {
                startActivity(intent3);
            }
        }
    }

    public boolean checkBle(String str) {
        BtService btService = this.mBtService;
        if (btService != null) {
            return btService.checkConnected(str);
        }
        return false;
    }

    public void startScanDevice() {
        BtService btService = this.mBtService;
        if (btService != null) {
            checkBleNeed(btService.startScanDevice(null));
        }
    }

    public void stopScanDevice() {
        BtService btService = this.mBtService;
        if (btService != null) {
            btService.stopScanDevice();
        }
    }

    public void showScanDialog() {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.add(2131296513, this.mScanFragment, "ScanFragment");
        beginTransaction.setTransition(4097);
        beginTransaction.addToBackStack(null);
        beginTransaction.commitAllowingStateLoss();
    }

    public void closeScanDialog() {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        if (getSupportFragmentManager().findFragmentByTag("ScanFragment") instanceof ScanFragment) {
            beginTransaction.remove(this.mScanFragment);
        }
        beginTransaction.setTransition(4097);
        beginTransaction.addToBackStack(null);
        beginTransaction.commitAllowingStateLoss();
    }

    public void disconnectBle(String str) {
        this.mBaseViewModel.setEqHas(true);
        if (this.mBtService != null) {
            this.mBaseViewModel.setLightType0E05("");
            this.mBtService.disconnectBle(str);
        }
    }

    public void connectBle(String str, String str2, String str3) {
        BtService btService = this.mBtService;
        if (btService != null) {
            checkBleNeed(btService.connectBle(str, str2, str3));
        }
    }

    public boolean writeData(byte[] bArr) {
        BtService btService = this.mBtService;
        if (btService != null && btService.checkConnected(this.mBaseViewModel.getBleAddress())) {
            return this.mBtService.writeCharacteristic(this.mBaseViewModel.getBleAddress(), OrderSet.FFF0, OrderSet.FFF1, bArr) == 0;
        }
        ToastUtils.show(2131755105);
        return false;
    }

    public void addWriteData(byte[] bArr, long j) {
        BtService btService = this.mBtService;
        if (btService != null && btService.checkConnected(this.mBaseViewModel.getBleAddress())) {
            this.mBtService.addWriteData(new WriteDataItem(this.mBaseViewModel.getBleAddress(), OrderSet.FFF0, OrderSet.FFF1, bArr, j));
        } else {
            ToastUtils.show(2131755105);
        }
    }

    public void clearWriteData() {
        BtService btService = this.mBtService;
        if (btService != null) {
            btService.clearWriteData();
        }
    }

    public void startLocation(long j, float f) {
        this.mNeedLocation = true;
        boolean isLocationServiceEnabled = PermissionHelper.isLocationServiceEnabled(this);
        boolean checkWifiStatus = PermissionHelper.checkWifiStatus(this);
        boolean checkNetworkAvailable = PermissionHelper.checkNetworkAvailable(this);
        if (isLocationServiceEnabled && checkNetworkAvailable) {
            this.mBtService.startNetworkLocation(j, f);
        }
        if (isLocationServiceEnabled && checkWifiStatus) {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null && defaultAdapter.isEnabled()) {
                this.mBtService.startGpsLocation(j, f);
            } else {
                Intent intent = new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE");
                intent.addFlags(67108864);
                if (Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_CONNECT") == 0) {
                    startActivity(intent);
                }
            }
        }
        if (checkNetworkAvailable || isLocationServiceEnabled || checkWifiStatus) {
            if (!checkNetworkAvailable) {
                this.mPermissionRepository.getNetworkNeedListData().postValue(Boolean.valueOf(!checkNetworkAvailable));
            }
            if (!isLocationServiceEnabled) {
                this.mPermissionRepository.getLocationServiceNeedListData().postValue(Boolean.valueOf(!isLocationServiceEnabled));
                this.mPermissionRepository.getLocationServicePromptListData().postValue(getString(2131755195));
            }
            if (!checkWifiStatus) {
                this.mPermissionRepository.getWifiNeedListData().setValue(Boolean.valueOf(!checkWifiStatus));
                this.mPermissionRepository.getWifiPromptListData().setValue(getString(2131755197));
            }
            Intent intent2 = new Intent(this, PermissionActivity.class);
            intent2.setFlags(67108864);
            startActivity(intent2);
        }
    }

    public void setItemVisibility() {
        this.mMainFragment.setItemVisibility();
    }
}
