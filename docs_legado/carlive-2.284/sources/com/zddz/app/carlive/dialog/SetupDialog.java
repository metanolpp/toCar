package com.zddz.app.carlive.dialog;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.zddz.app.carlive.OrderSet;
import com.zddz.app.carlive.activity.FindCarActivity;
import com.zddz.app.carlive.fragment.BaseDialog;
import com.zddz.app.carlive.fragment.BaseViewModel;
import com.zddz.app.carlive.fragment.IMain;
import com.zddz.bt.DeviceRecord;
import com.zddz.permission.AllowLocationDialog;
import com.zddz.update.AskUpdateActivity;
import com.zddz.update.PrivacyPolicyDialog;
import com.zddz.update.UpdateHelper;
import com.zddz.update.UpdateSp;
import org.litepal.LitePal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class SetupDialog extends BaseDialog {
    private TextView bt_close;
    private ImageView img_speech_open;
    private ImageView iv_update_notice;
    private LinearLayout ll_speech;
    private UpdateSp mUpdateSp;
    private Switch switch_auto_connect;
    private Switch switch_use_positioning;
    private Switch switch_use_speech;
    private TextView tv_bt_state;
    private TextView tv_find_car;
    private TextView tv_version;
    private View.OnClickListener mOnClickListener = new 1();
    private Boolean mIsSpeechOpen = false;

    static /* synthetic */ ImageView access$000(SetupDialog setupDialog) {
        return setupDialog.iv_update_notice;
    }

    static /* synthetic */ void access$100(SetupDialog setupDialog) {
        setupDialog.sendSpeechCmd();
    }

    static /* synthetic */ Switch access$1000(SetupDialog setupDialog) {
        return setupDialog.switch_use_positioning;
    }

    static /* synthetic */ BaseViewModel access$1100(SetupDialog setupDialog) {
        return setupDialog.mBaseViewModel;
    }

    static /* synthetic */ Boolean access$1202(SetupDialog setupDialog, Boolean bool) {
        setupDialog.mIsSpeechOpen = bool;
        return bool;
    }

    static /* synthetic */ void access$1300(SetupDialog setupDialog, Boolean bool) {
        setupDialog.setSpeechShow(bool);
    }

    static /* synthetic */ BaseViewModel access$200(SetupDialog setupDialog) {
        return setupDialog.mBaseViewModel;
    }

    static /* synthetic */ BaseViewModel access$300(SetupDialog setupDialog) {
        return setupDialog.mBaseViewModel;
    }

    static /* synthetic */ IMain access$400(SetupDialog setupDialog) {
        return setupDialog.mIMain;
    }

    static /* synthetic */ IMain access$500(SetupDialog setupDialog) {
        return setupDialog.mIMain;
    }

    static /* synthetic */ BaseViewModel access$600(SetupDialog setupDialog) {
        return setupDialog.mBaseViewModel;
    }

    static /* synthetic */ BaseViewModel access$700(SetupDialog setupDialog) {
        return setupDialog.mBaseViewModel;
    }

    static /* synthetic */ Switch access$800(SetupDialog setupDialog) {
        return setupDialog.switch_auto_connect;
    }

    static /* synthetic */ BaseViewModel access$900(SetupDialog setupDialog) {
        return setupDialog.mBaseViewModel;
    }

    class 1 implements View.OnClickListener {
        1() {
        }

        public void onClick(View view) {
            int id = view.getId();
            if (id == 2131296743 || id == 2131297061) {
                Intent intent = new Intent(SetupDialog.this.getContext(), AskUpdateActivity.class);
                intent.setFlags(268435456);
                intent.putExtra("SHOW_UPDATE", SetupDialog.access$000(SetupDialog.this).getVisibility() == 0);
                SetupDialog.this.getContext().startActivity(intent);
                SetupDialog.this.dismiss();
                return;
            }
            if (id == 2131296359) {
                SetupDialog.this.dismiss();
                return;
            }
            if (id == 2131296544) {
                SetupDialog.access$100(SetupDialog.this);
                return;
            }
            if (id != 2131296968) {
                if (id == 2131297021) {
                    new PrivacyPolicyDialog(SetupDialog.this.getContext()).show();
                    SetupDialog.this.dismiss();
                    return;
                }
                return;
            }
            if (!SetupDialog.access$200(SetupDialog.this).getAllowLocation()) {
                AllowLocationDialog allowLocationDialog = new AllowLocationDialog(SetupDialog.this.getContext());
                allowLocationDialog.setOnConfirmListener(new 1());
                allowLocationDialog.show();
            } else if (SetupDialog.access$600(SetupDialog.this).getLatitude() != 0.0d && SetupDialog.access$700(SetupDialog.this).getLongitude() != 0.0d) {
                new MapDialog(SetupDialog.this.getContext()).show();
            } else {
                Intent intent2 = new Intent(SetupDialog.this.getContext(), FindCarActivity.class);
                intent2.addFlags(536870912);
                SetupDialog.this.getContext().startActivity(intent2);
            }
            SetupDialog.this.dismiss();
        }

        class 1 implements AllowLocationDialog.OnConfirmListener {
            1() {
            }

            public void onConfirm(boolean z) {
                if (z && SetupDialog.access$400(SetupDialog.this).checkBle(SetupDialog.access$300(SetupDialog.this).getBleAddress())) {
                    SetupDialog.access$500(SetupDialog.this).startLocation(1200000L, 5000.0f);
                }
            }
        }
    }

    private void sendSpeechCmd() {
        this.mIMain.writeData(new byte[]{17, (byte) (!this.mIsSpeechOpen.booleanValue() ? 1 : 0)});
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(2131492927, viewGroup, false);
        return this.mRootView;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mUpdateSp = UpdateSp.getInstance(getContext());
        this.mRootView.findViewById(2131296743).setOnClickListener(this.mOnClickListener);
        this.ll_speech = this.mRootView.findViewById(2131296601);
        ImageView findViewById = this.mRootView.findViewById(2131296544);
        this.img_speech_open = findViewById;
        findViewById.setOnClickListener(this.mOnClickListener);
        TextView findViewById2 = this.mRootView.findViewById(2131297061);
        this.tv_version = findViewById2;
        findViewById2.setOnClickListener(this.mOnClickListener);
        ImageView findViewById3 = this.mRootView.findViewById(2131296563);
        this.iv_update_notice = findViewById3;
        findViewById3.setVisibility(8);
        this.tv_bt_state = this.mRootView.findViewById(2131296913);
        TextView findViewById4 = this.mRootView.findViewById(2131296359);
        this.bt_close = findViewById4;
        findViewById4.setOnClickListener(this.mOnClickListener);
        String string = getContext().getString(2131755108);
        this.tv_version.setText(string + this.mUpdateSp.getVersionName());
        TextView findViewById5 = this.mRootView.findViewById(2131296968);
        this.tv_find_car = findViewById5;
        findViewById5.setOnClickListener(this.mOnClickListener);
        this.mRootView.findViewById(2131297021).setOnClickListener(this.mOnClickListener);
        Switch findViewById6 = this.mRootView.findViewById(2131296847);
        this.switch_auto_connect = findViewById6;
        findViewById6.setChecked(this.mBaseViewModel.getAutoConnect());
        this.switch_auto_connect.setOnCheckedChangeListener(new 2());
        Switch findViewById7 = this.mRootView.findViewById(2131296851);
        this.switch_use_positioning = findViewById7;
        findViewById7.setChecked(this.mBaseViewModel.getAllowLocation());
        this.switch_use_positioning.setOnCheckedChangeListener(new 3());
        if (UpdateHelper.compareVersion(this.mUpdateSp.getVersionName(), this.mUpdateSp.getLatestVersion()) < 0) {
            this.iv_update_notice.setVisibility(0);
        } else {
            this.iv_update_notice.setVisibility(8);
        }
        if (this.mIMain.checkBle(this.mBaseViewModel.getBleAddress())) {
            this.tv_bt_state.setText(2131755126);
        } else {
            this.tv_bt_state.setText(2131755128);
        }
        initMenuShow();
    }

    class 2 implements CompoundButton.OnCheckedChangeListener {
        2() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            SetupDialog.access$900(SetupDialog.this).setAutoConnect(SetupDialog.access$800(SetupDialog.this).isChecked());
        }
    }

    class 3 implements CompoundButton.OnCheckedChangeListener {
        3() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            SetupDialog.access$1100(SetupDialog.this).setAllowLocation(SetupDialog.access$1000(SetupDialog.this).isChecked());
        }
    }

    private void initMenuShow() {
        DeviceRecord deviceRecord = (DeviceRecord) LitePal.where("address = ?", this.mBaseViewModel.getBleAddress()).findFirst(DeviceRecord.class);
        this.ll_speech.setVisibility(deviceRecord != null && deviceRecord.getManufacture_data() != null && deviceRecord.getManufacture_data().equals(OrderSet.DEV_LIBANG) ? 0 : 8);
        this.mBaseViewModel.liBangSpeechOpenValue.observe(getViewLifecycleOwner(), new 4());
    }

    class 4 implements Observer {
        4() {
        }

        public void onChanged(Boolean bool) {
            SetupDialog.access$1202(SetupDialog.this, bool);
            SetupDialog.access$1300(SetupDialog.this, bool);
        }
    }

    private void setSpeechShow(Boolean bool) {
        this.img_speech_open.setImageResource(bool.booleanValue() ? 2131231182 : 2131231181);
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
                window.setLayout(-1, -1);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.0f;
                attributes.gravity = 8388661;
                window.setAttributes(attributes);
            }
        }
        setCancelable(false);
    }
}
