package com.zddz.app.carlive.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.zddz.app.carlive.adapter.DeviceItemRAdapter;
import com.zddz.bt.DeviceItem;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class ScanFragment extends BaseFragment {
    private TextView bt_close;
    private TextView bt_scan;
    private DeviceItemRAdapter mDeviceItemRAdapter;
    private RecyclerView rv_device;
    private boolean mScanning = false;
    private View.OnClickListener mOnClickListener = new 1();
    private Observer mScanningObserver = new 2();

    static /* synthetic */ boolean access$000(ScanFragment scanFragment) {
        return scanFragment.mScanning;
    }

    static /* synthetic */ boolean access$002(ScanFragment scanFragment, boolean z) {
        scanFragment.mScanning = z;
        return z;
    }

    static /* synthetic */ DeviceItemRAdapter access$100(ScanFragment scanFragment) {
        return scanFragment.mDeviceItemRAdapter;
    }

    static /* synthetic */ TextView access$200(ScanFragment scanFragment) {
        return scanFragment.bt_scan;
    }

    class 1 implements View.OnClickListener {
        1() {
        }

        public void onClick(View view) {
            int id = view.getId();
            if (id != 2131296365) {
                if (id == 2131297078 || id == 2131296359) {
                    ScanFragment.this.mIMain.closeScanDialog();
                    return;
                }
                return;
            }
            if (ScanFragment.access$000(ScanFragment.this)) {
                ScanFragment.this.mIMain.stopScanDevice();
            } else {
                ScanFragment.access$100(ScanFragment.this).clear();
                ScanFragment.this.mIMain.startScanDevice();
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(2131492926, viewGroup, false);
            this.mRootView.findViewById(2131297078).setOnClickListener(this.mOnClickListener);
            TextView findViewById = this.mRootView.findViewById(2131296365);
            this.bt_scan = findViewById;
            findViewById.setOnClickListener(this.mOnClickListener);
            TextView findViewById2 = this.mRootView.findViewById(2131296359);
            this.bt_close = findViewById2;
            findViewById2.setOnClickListener(this.mOnClickListener);
            RecyclerView findViewById3 = this.mRootView.findViewById(2131296746);
            this.rv_device = findViewById3;
            findViewById3.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
            RecyclerView.ItemAnimator itemAnimator = this.rv_device.getItemAnimator();
            if (itemAnimator instanceof SimpleItemAnimator) {
                ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            }
            this.rv_device.getItemAnimator().setChangeDuration(0L);
            DeviceItemRAdapter deviceItemRAdapter = new DeviceItemRAdapter();
            this.mDeviceItemRAdapter = deviceItemRAdapter;
            this.rv_device.setAdapter(deviceItemRAdapter);
            this.mDeviceItemRAdapter.setOnItemClickListener(new ScanFragment$$ExternalSyntheticLambda0(this));
        }
        ViewGroup parent = this.mRootView.getParent();
        if (parent != null) {
            parent.removeView(this.mRootView);
        }
        return this.mRootView;
    }

    /* synthetic */ void lambda$onCreateView$0$com-zddz-app-carlive-fragment-ScanFragment(View view, int i) {
        DeviceItem item = this.mDeviceItemRAdapter.getItem(i);
        if (item.mState == 2) {
            this.mIMain.disconnectBle(item.mAddress);
            if (item.mAddress.equals(this.mBaseViewModel.getBleAddress())) {
                this.mBaseViewModel.setAutoConnect(false);
                this.mBaseViewModel.setBleAddress("");
                return;
            }
            return;
        }
        this.mIMain.stopScanDevice();
        this.mIMain.disconnectBle(this.mBaseViewModel.getBleAddress());
        item.mState = 1;
        this.mDeviceItemRAdapter.updateItem(item);
        this.mBaseViewModel.setBleAddress(item.mAddress);
        this.mBaseViewModel.setAutoConnect(true);
        this.mIMain.connectBle(item.mAddress, item.mName, item.mManufactureData);
    }

    class 2 implements Observer {
        2() {
        }

        public void onChanged(Boolean bool) {
            ScanFragment.access$002(ScanFragment.this, bool.booleanValue());
            if (bool.booleanValue()) {
                ScanFragment.access$200(ScanFragment.this).setText(2131755441);
            } else {
                ScanFragment.access$200(ScanFragment.this).setText(2131755411);
            }
        }
    }

    public void onStart() {
        super.onStart();
        this.mBaseViewModel.getScanningLiveData().observe(getViewLifecycleOwner(), this.mScanningObserver);
        if (this.mScanning) {
            return;
        }
        this.mDeviceItemRAdapter.clear();
        this.mIMain.startScanDevice();
    }

    public void onStop() {
        super.onStop();
        this.mBaseViewModel.getScanningLiveData().removeObserver(this.mScanningObserver);
        this.mIMain.stopScanDevice();
    }

    public void updateDeviceItem(DeviceItem deviceItem) {
        DeviceItemRAdapter deviceItemRAdapter = this.mDeviceItemRAdapter;
        if (deviceItemRAdapter != null) {
            deviceItemRAdapter.updateItem(deviceItem);
        }
    }
}
