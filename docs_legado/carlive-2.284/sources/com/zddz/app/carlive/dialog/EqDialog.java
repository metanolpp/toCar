package com.zddz.app.carlive.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckedTextView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.zddz.app.carlive.OrderSet;
import com.zddz.app.carlive.fragment.BaseDialog;
import com.zddz.app.carlive.fragment.BaseViewModel;
import com.zddz.app.carlive.fragment.IMain;
import com.zddz.bt.Convert;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class EqDialog extends BaseDialog {
    private CheckedTextView ctv_classic;
    private CheckedTextView ctv_country;
    private CheckedTextView ctv_jazz;
    private CheckedTextView ctv_normal;
    private CheckedTextView ctv_popular;
    private CheckedTextView ctv_rock;
    private Handler mHandler;
    private SeekBar sb_balance;
    private SeekBar sb_bass;
    private SeekBar sb_fade;
    private SeekBar sb_treble;
    private TextView tv_balance_value;
    private TextView tv_bass_value;
    private TextView tv_fade_value;
    private TextView tv_treble_value;
    private View.OnClickListener mOnClickListener = new 1();
    private boolean mBassFromUser = false;
    private boolean mBassBarMove = false;
    private final Runnable mBassRunnable = new 2();
    private boolean mTrebleFromUser = false;
    private boolean mTrebleBarMove = false;
    private final Runnable mTrebleRunnable = new 3();
    private boolean mBalanceFromUser = false;
    private boolean mBalanceBarMove = false;
    private final Runnable mBalanceRunnable = new 4();
    private boolean mFadeFromUser = false;
    private boolean mFadeBarMove = false;
    private final Runnable mFadeRunnable = new 5();
    private SeekBar.OnSeekBarChangeListener mOnSeekBarChangeListener = new 6();

    static /* synthetic */ IMain access$000(EqDialog eqDialog) {
        return eqDialog.mIMain;
    }

    static /* synthetic */ IMain access$100(EqDialog eqDialog) {
        return eqDialog.mIMain;
    }

    static /* synthetic */ Handler access$1000(EqDialog eqDialog) {
        return eqDialog.mHandler;
    }

    static /* synthetic */ boolean access$1100(EqDialog eqDialog) {
        return eqDialog.mTrebleBarMove;
    }

    static /* synthetic */ boolean access$1102(EqDialog eqDialog, boolean z) {
        eqDialog.mTrebleBarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$1200(EqDialog eqDialog) {
        return eqDialog.sb_treble;
    }

    static /* synthetic */ IMain access$1300(EqDialog eqDialog) {
        return eqDialog.mIMain;
    }

    static /* synthetic */ boolean access$1400(EqDialog eqDialog) {
        return eqDialog.mBalanceBarMove;
    }

    static /* synthetic */ boolean access$1402(EqDialog eqDialog, boolean z) {
        eqDialog.mBalanceBarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$1500(EqDialog eqDialog) {
        return eqDialog.sb_balance;
    }

    static /* synthetic */ IMain access$1600(EqDialog eqDialog) {
        return eqDialog.mIMain;
    }

    static /* synthetic */ boolean access$1700(EqDialog eqDialog) {
        return eqDialog.mFadeBarMove;
    }

    static /* synthetic */ boolean access$1702(EqDialog eqDialog, boolean z) {
        eqDialog.mFadeBarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$1800(EqDialog eqDialog) {
        return eqDialog.sb_fade;
    }

    static /* synthetic */ IMain access$1900(EqDialog eqDialog) {
        return eqDialog.mIMain;
    }

    static /* synthetic */ IMain access$200(EqDialog eqDialog) {
        return eqDialog.mIMain;
    }

    static /* synthetic */ boolean access$2002(EqDialog eqDialog, boolean z) {
        eqDialog.mBassFromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$2100(EqDialog eqDialog) {
        return eqDialog.tv_bass_value;
    }

    static /* synthetic */ boolean access$2202(EqDialog eqDialog, boolean z) {
        eqDialog.mTrebleFromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$2300(EqDialog eqDialog) {
        return eqDialog.tv_treble_value;
    }

    static /* synthetic */ boolean access$2402(EqDialog eqDialog, boolean z) {
        eqDialog.mBalanceFromUser = z;
        return z;
    }

    static /* synthetic */ BaseViewModel access$2500(EqDialog eqDialog) {
        return eqDialog.mBaseViewModel;
    }

    static /* synthetic */ TextView access$2600(EqDialog eqDialog) {
        return eqDialog.tv_balance_value;
    }

    static /* synthetic */ boolean access$2702(EqDialog eqDialog, boolean z) {
        eqDialog.mFadeFromUser = z;
        return z;
    }

    static /* synthetic */ BaseViewModel access$2800(EqDialog eqDialog) {
        return eqDialog.mBaseViewModel;
    }

    static /* synthetic */ TextView access$2900(EqDialog eqDialog) {
        return eqDialog.tv_fade_value;
    }

    static /* synthetic */ IMain access$300(EqDialog eqDialog) {
        return eqDialog.mIMain;
    }

    static /* synthetic */ Runnable access$3000(EqDialog eqDialog) {
        return eqDialog.mBassRunnable;
    }

    static /* synthetic */ Runnable access$3100(EqDialog eqDialog) {
        return eqDialog.mTrebleRunnable;
    }

    static /* synthetic */ Runnable access$3200(EqDialog eqDialog) {
        return eqDialog.mBalanceRunnable;
    }

    static /* synthetic */ Runnable access$3300(EqDialog eqDialog) {
        return eqDialog.mFadeRunnable;
    }

    static /* synthetic */ IMain access$3400(EqDialog eqDialog) {
        return eqDialog.mIMain;
    }

    static /* synthetic */ IMain access$3500(EqDialog eqDialog) {
        return eqDialog.mIMain;
    }

    static /* synthetic */ IMain access$3600(EqDialog eqDialog) {
        return eqDialog.mIMain;
    }

    static /* synthetic */ IMain access$3700(EqDialog eqDialog) {
        return eqDialog.mIMain;
    }

    static /* synthetic */ IMain access$3800(EqDialog eqDialog) {
        return eqDialog.mIMain;
    }

    static /* synthetic */ IMain access$400(EqDialog eqDialog) {
        return eqDialog.mIMain;
    }

    static /* synthetic */ IMain access$500(EqDialog eqDialog) {
        return eqDialog.mIMain;
    }

    static /* synthetic */ IMain access$600(EqDialog eqDialog) {
        return eqDialog.mIMain;
    }

    static /* synthetic */ boolean access$700(EqDialog eqDialog) {
        return eqDialog.mBassBarMove;
    }

    static /* synthetic */ boolean access$702(EqDialog eqDialog, boolean z) {
        eqDialog.mBassBarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$800(EqDialog eqDialog) {
        return eqDialog.sb_bass;
    }

    static /* synthetic */ IMain access$900(EqDialog eqDialog) {
        return eqDialog.mIMain;
    }

    class 1 implements View.OnClickListener {
        1() {
        }

        public void onClick(View view) {
            int id = view.getId();
            if (id == 2131297078) {
                EqDialog.access$000(EqDialog.this).setItemVisibility();
                EqDialog.this.dismiss();
                return;
            }
            if (id == 2131296431) {
                EqDialog.access$100(EqDialog.this).writeData(OrderSet.write_eq_style_normal);
                return;
            }
            if (id == 2131296434) {
                EqDialog.access$200(EqDialog.this).writeData(OrderSet.write_eq_style_popular);
                return;
            }
            if (id == 2131296436) {
                EqDialog.access$300(EqDialog.this).writeData(OrderSet.write_eq_style_rock);
                return;
            }
            if (id == 2131296428) {
                EqDialog.access$400(EqDialog.this).writeData(OrderSet.write_eq_style_jazz);
            } else if (id == 2131296419) {
                EqDialog.access$500(EqDialog.this).writeData(OrderSet.write_eq_style_classic);
            } else if (id == 2131296420) {
                EqDialog.access$600(EqDialog.this).writeData(OrderSet.write_eq_style_country);
            }
        }
    }

    class 2 implements Runnable {
        2() {
        }

        public void run() {
            if (EqDialog.access$700(EqDialog.this)) {
                byte[] bArr = OrderSet.write_bass;
                bArr[2] = (byte) EqDialog.access$800(EqDialog.this).getProgress();
                EqDialog.access$900(EqDialog.this).writeData(bArr);
                EqDialog.access$1000(EqDialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 3 implements Runnable {
        3() {
        }

        public void run() {
            if (EqDialog.access$1100(EqDialog.this)) {
                byte[] bArr = OrderSet.write_treble;
                bArr[2] = (byte) EqDialog.access$1200(EqDialog.this).getProgress();
                EqDialog.access$1300(EqDialog.this).writeData(bArr);
                EqDialog.access$1000(EqDialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 4 implements Runnable {
        4() {
        }

        public void run() {
            if (EqDialog.access$1400(EqDialog.this)) {
                byte[] bArr = OrderSet.write_balance;
                bArr[2] = (byte) EqDialog.access$1500(EqDialog.this).getProgress();
                EqDialog.access$1600(EqDialog.this).writeData(bArr);
                EqDialog.access$1000(EqDialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 5 implements Runnable {
        5() {
        }

        public void run() {
            if (EqDialog.access$1700(EqDialog.this)) {
                byte[] bArr = OrderSet.write_fade;
                bArr[2] = (byte) EqDialog.access$1800(EqDialog.this).getProgress();
                EqDialog.access$1900(EqDialog.this).writeData(bArr);
                EqDialog.access$1000(EqDialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 6 implements SeekBar.OnSeekBarChangeListener {
        6() {
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            int progress = seekBar.getProgress();
            int id = seekBar.getId();
            if (id == 2131296752) {
                EqDialog.access$2002(EqDialog.this, z);
                EqDialog.access$2100(EqDialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296771) {
                EqDialog.access$2202(EqDialog.this, z);
                EqDialog.access$2300(EqDialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296751) {
                EqDialog.access$2402(EqDialog.this, z);
                int balanceMax = progress - EqDialog.access$2500(EqDialog.this).getBalanceMax();
                if (balanceMax < 0) {
                    EqDialog.access$2600(EqDialog.this).setText("L" + String.valueOf(balanceMax).replace("-", ""));
                    return;
                }
                EqDialog.access$2600(EqDialog.this).setText("R" + balanceMax);
                return;
            }
            if (id == 2131296769) {
                EqDialog.access$2702(EqDialog.this, z);
                int fadeMax = progress - EqDialog.access$2800(EqDialog.this).getFadeMax();
                if (fadeMax < 0) {
                    EqDialog.access$2900(EqDialog.this).setText("R" + String.valueOf(fadeMax).replace("-", ""));
                    return;
                }
                EqDialog.access$2900(EqDialog.this).setText("F" + fadeMax);
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            int id = seekBar.getId();
            if (id == 2131296752) {
                EqDialog.access$702(EqDialog.this, true);
                EqDialog.access$1000(EqDialog.this).postDelayed(EqDialog.access$3000(EqDialog.this), 200L);
                return;
            }
            if (id == 2131296771) {
                EqDialog.access$1102(EqDialog.this, true);
                EqDialog.access$1000(EqDialog.this).postDelayed(EqDialog.access$3100(EqDialog.this), 200L);
            } else if (id == 2131296751) {
                EqDialog.access$1402(EqDialog.this, true);
                EqDialog.access$1000(EqDialog.this).postDelayed(EqDialog.access$3200(EqDialog.this), 200L);
            } else if (id == 2131296769) {
                EqDialog.access$1702(EqDialog.this, true);
                EqDialog.access$1000(EqDialog.this).postDelayed(EqDialog.access$3300(EqDialog.this), 200L);
            }
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            int id = seekBar.getId();
            if (id == 2131296752) {
                EqDialog.access$702(EqDialog.this, false);
                try {
                    EqDialog.access$1000(EqDialog.this).removeCallbacks(EqDialog.access$3000(EqDialog.this));
                    EqDialog.access$1000(EqDialog.this).postDelayed(new 1(), 300L);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            if (id == 2131296771) {
                EqDialog.access$1102(EqDialog.this, false);
                try {
                    EqDialog.access$1000(EqDialog.this).removeCallbacks(EqDialog.access$3100(EqDialog.this));
                    EqDialog.access$1000(EqDialog.this).postDelayed(new 2(), 300L);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (id == 2131296751) {
                EqDialog.access$1402(EqDialog.this, false);
                try {
                    EqDialog.access$1000(EqDialog.this).removeCallbacks(EqDialog.access$3200(EqDialog.this));
                    EqDialog.access$1000(EqDialog.this).postDelayed(new 3(), 300L);
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            if (id == 2131296769) {
                EqDialog.access$1702(EqDialog.this, false);
                try {
                    EqDialog.access$1000(EqDialog.this).removeCallbacks(EqDialog.access$3300(EqDialog.this));
                    EqDialog.access$1000(EqDialog.this).postDelayed(new 4(), 300L);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }

        class 1 implements Runnable {
            1() {
            }

            public void run() {
                EqDialog.access$2002(EqDialog.this, false);
                byte[] bArr = OrderSet.write_bass;
                bArr[2] = (byte) EqDialog.access$800(EqDialog.this).getProgress();
                EqDialog.access$3400(EqDialog.this).writeData(bArr);
            }
        }

        class 2 implements Runnable {
            2() {
            }

            public void run() {
                EqDialog.access$2202(EqDialog.this, false);
                byte[] bArr = OrderSet.write_treble;
                bArr[2] = (byte) EqDialog.access$1200(EqDialog.this).getProgress();
                EqDialog.access$3500(EqDialog.this).writeData(bArr);
            }
        }

        class 3 implements Runnable {
            3() {
            }

            public void run() {
                EqDialog.access$2402(EqDialog.this, false);
                byte[] bArr = OrderSet.write_balance;
                bArr[2] = (byte) EqDialog.access$1500(EqDialog.this).getProgress();
                EqDialog.access$3600(EqDialog.this).writeData(bArr);
            }
        }

        class 4 implements Runnable {
            4() {
            }

            public void run() {
                EqDialog.access$2702(EqDialog.this, false);
                byte[] bArr = OrderSet.write_fade;
                bArr[2] = (byte) EqDialog.access$1800(EqDialog.this).getProgress();
                EqDialog.access$3700(EqDialog.this).writeData(bArr);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(2131492918, viewGroup, false);
        return this.mRootView;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mHandler = new Handler(Looper.myLooper());
        CheckedTextView findViewById = this.mRootView.findViewById(2131296431);
        this.ctv_normal = findViewById;
        findViewById.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById2 = this.mRootView.findViewById(2131296434);
        this.ctv_popular = findViewById2;
        findViewById2.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById3 = this.mRootView.findViewById(2131296436);
        this.ctv_rock = findViewById3;
        findViewById3.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById4 = this.mRootView.findViewById(2131296428);
        this.ctv_jazz = findViewById4;
        findViewById4.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById5 = this.mRootView.findViewById(2131296419);
        this.ctv_classic = findViewById5;
        findViewById5.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById6 = this.mRootView.findViewById(2131296420);
        this.ctv_country = findViewById6;
        findViewById6.setOnClickListener(this.mOnClickListener);
        this.mRootView.findViewById(2131297078).setOnClickListener(this.mOnClickListener);
        SeekBar findViewById7 = this.mRootView.findViewById(2131296752);
        this.sb_bass = findViewById7;
        findViewById7.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById8 = this.mRootView.findViewById(2131296771);
        this.sb_treble = findViewById8;
        findViewById8.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById9 = this.mRootView.findViewById(2131296751);
        this.sb_balance = findViewById9;
        findViewById9.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById10 = this.mRootView.findViewById(2131296769);
        this.sb_fade = findViewById10;
        findViewById10.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        this.tv_bass_value = this.mRootView.findViewById(2131296911);
        this.tv_treble_value = this.mRootView.findViewById(2131297058);
        this.tv_balance_value = this.mRootView.findViewById(2131296904);
        this.tv_fade_value = this.mRootView.findViewById(2131296967);
        refreshEqType(this.mBaseViewModel.getEqType());
        this.sb_bass.setMax(this.mBaseViewModel.getBassMax() * 2);
        this.sb_treble.setMax(this.mBaseViewModel.getTrebleMax() * 2);
        this.sb_balance.setMax(this.mBaseViewModel.getBalanceMax() * 2);
        this.sb_fade.setMax(this.mBaseViewModel.getFadeMax() * 2);
        refreshEqStyle(this.mBaseViewModel.getEqStyle());
        this.sb_fade.setEnabled(this.mBaseViewModel.getFadeSupport());
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
                window.setLayout(-1, -1);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.0f;
                window.setAttributes(attributes);
            }
            dialog.setOnDismissListener(new 7());
        }
    }

    class 7 implements DialogInterface.OnDismissListener {
        7() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            EqDialog.access$3800(EqDialog.this).setItemVisibility();
        }
    }

    private void refreshEqType(int i) {
        if (i == 1 || i == 2) {
            new DspDialog().show(getChildFragmentManager(), "DspDialog");
            this.mIMain.setItemVisibility();
            dismiss();
        } else if (i == 3 || i == 5 || i == 6) {
            new ChannelDialog().show(getChildFragmentManager(), "ChannelDialog");
            this.mIMain.setItemVisibility();
            dismiss();
        } else if (i == 7) {
            new TenEqDialog().show(getChildFragmentManager(), "TenEqDialog");
            this.mIMain.setItemVisibility();
            dismiss();
        }
    }

    private void refreshEqStyle(int i) {
        switch (i) {
            case 0:
            case 6:
                this.ctv_normal.setChecked(true);
                this.ctv_popular.setChecked(false);
                this.ctv_rock.setChecked(false);
                this.ctv_jazz.setChecked(false);
                this.ctv_classic.setChecked(false);
                this.ctv_country.setChecked(false);
                this.sb_bass.setEnabled(true);
                this.sb_treble.setEnabled(true);
                this.sb_bass.setProgress(this.mBaseViewModel.getBass());
                this.sb_treble.setProgress(this.mBaseViewModel.getTreble());
                break;
            case 1:
                this.ctv_normal.setChecked(false);
                this.ctv_popular.setChecked(true);
                this.ctv_rock.setChecked(false);
                this.ctv_jazz.setChecked(false);
                this.ctv_classic.setChecked(false);
                this.ctv_country.setChecked(false);
                this.sb_bass.setProgress(4);
                this.sb_treble.setProgress(9);
                if (this.mBaseViewModel.getFourEqEnable()) {
                    this.sb_bass.setEnabled(true);
                    this.sb_treble.setEnabled(true);
                    break;
                } else {
                    this.sb_bass.setEnabled(false);
                    this.sb_treble.setEnabled(false);
                    break;
                }
            case 2:
                this.ctv_normal.setChecked(false);
                this.ctv_popular.setChecked(false);
                this.ctv_rock.setChecked(true);
                this.ctv_jazz.setChecked(false);
                this.ctv_classic.setChecked(false);
                this.ctv_country.setChecked(false);
                this.sb_bass.setProgress(9);
                this.sb_treble.setProgress(9);
                if (this.mBaseViewModel.getFourEqEnable()) {
                    this.sb_bass.setEnabled(true);
                    this.sb_treble.setEnabled(true);
                    break;
                } else {
                    this.sb_bass.setEnabled(false);
                    this.sb_treble.setEnabled(false);
                    break;
                }
            case 3:
                this.ctv_normal.setChecked(false);
                this.ctv_popular.setChecked(false);
                this.ctv_rock.setChecked(false);
                this.ctv_jazz.setChecked(true);
                this.ctv_classic.setChecked(false);
                this.ctv_country.setChecked(false);
                this.sb_bass.setProgress(11);
                this.sb_treble.setProgress(10);
                if (this.mBaseViewModel.getFourEqEnable()) {
                    this.sb_bass.setEnabled(true);
                    this.sb_treble.setEnabled(true);
                    break;
                } else {
                    this.sb_bass.setEnabled(false);
                    this.sb_treble.setEnabled(false);
                    break;
                }
            case 4:
                this.ctv_normal.setChecked(false);
                this.ctv_popular.setChecked(false);
                this.ctv_rock.setChecked(false);
                this.ctv_jazz.setChecked(false);
                this.ctv_classic.setChecked(true);
                this.ctv_country.setChecked(false);
                this.sb_bass.setProgress(14);
                this.sb_treble.setProgress(8);
                if (this.mBaseViewModel.getFourEqEnable()) {
                    this.sb_bass.setEnabled(true);
                    this.sb_treble.setEnabled(true);
                    break;
                } else {
                    this.sb_bass.setEnabled(false);
                    this.sb_treble.setEnabled(false);
                    break;
                }
            case 5:
                this.ctv_normal.setChecked(false);
                this.ctv_popular.setChecked(false);
                this.ctv_rock.setChecked(false);
                this.ctv_jazz.setChecked(false);
                this.ctv_classic.setChecked(false);
                this.ctv_country.setChecked(true);
                this.sb_bass.setProgress(8);
                this.sb_treble.setProgress(9);
                if (this.mBaseViewModel.getFourEqEnable()) {
                    this.sb_bass.setEnabled(true);
                    this.sb_treble.setEnabled(true);
                    break;
                } else {
                    this.sb_bass.setEnabled(false);
                    this.sb_treble.setEnabled(false);
                    break;
                }
        }
    }

    public void notice(String str, UUID uuid, byte[] bArr) {
        try {
            String upperCase = Convert.bytesToHexString(bArr).toUpperCase();
            if (!upperCase.startsWith(OrderSet.notice_version_eq_dsp) && !upperCase.startsWith(OrderSet.notice_version_eq_aoveise)) {
                if (!upperCase.startsWith(OrderSet.notice_version_eq_channel) && !upperCase.startsWith(OrderSet.notice_version_location) && !upperCase.startsWith(OrderSet.notice_version_eq_five_channel) && !upperCase.startsWith(OrderSet.notice_version_eq_six_channel)) {
                    if (upperCase.startsWith(OrderSet.notice_version_eq_ten_eq)) {
                        new TenEqDialog().show(getChildFragmentManager(), "TenEqDialog");
                        this.mIMain.setItemVisibility();
                        dismiss();
                        return;
                    }
                    if (upperCase.startsWith(OrderSet.notice_eq_style_normal)) {
                        refreshEqStyle(0);
                        return;
                    }
                    if (upperCase.startsWith(OrderSet.notice_eq_style_popular)) {
                        refreshEqStyle(1);
                        if (upperCase.length() >= 6) {
                            this.sb_bass.setEnabled(upperCase.substring(4, 6).equals("01"));
                            this.sb_treble.setEnabled(upperCase.substring(4, 6).equals("01"));
                            return;
                        } else {
                            this.sb_bass.setEnabled(false);
                            this.sb_treble.setEnabled(false);
                            return;
                        }
                    }
                    if (upperCase.startsWith(OrderSet.notice_eq_style_rock)) {
                        refreshEqStyle(2);
                        if (upperCase.length() >= 6) {
                            this.sb_bass.setEnabled(upperCase.substring(4, 6).equals("01"));
                            this.sb_treble.setEnabled(upperCase.substring(4, 6).equals("01"));
                            return;
                        } else {
                            this.sb_bass.setEnabled(false);
                            this.sb_treble.setEnabled(false);
                            return;
                        }
                    }
                    if (upperCase.startsWith(OrderSet.notice_eq_style_jazz)) {
                        refreshEqStyle(3);
                        if (upperCase.length() >= 6) {
                            this.sb_bass.setEnabled(upperCase.substring(4, 6).equals("01"));
                            this.sb_treble.setEnabled(upperCase.substring(4, 6).equals("01"));
                            return;
                        } else {
                            this.sb_bass.setEnabled(false);
                            this.sb_treble.setEnabled(false);
                            return;
                        }
                    }
                    if (upperCase.startsWith(OrderSet.notice_eq_style_classic)) {
                        refreshEqStyle(4);
                        if (upperCase.length() >= 6) {
                            this.sb_bass.setEnabled(upperCase.substring(4, 6).equals("01"));
                            this.sb_treble.setEnabled(upperCase.substring(4, 6).equals("01"));
                            return;
                        } else {
                            this.sb_bass.setEnabled(false);
                            this.sb_treble.setEnabled(false);
                            return;
                        }
                    }
                    if (upperCase.startsWith(OrderSet.notice_eq_style_country)) {
                        refreshEqStyle(5);
                        if (upperCase.length() >= 6) {
                            this.sb_bass.setEnabled(upperCase.substring(4, 6).equals("01"));
                            this.sb_treble.setEnabled(upperCase.substring(4, 6).equals("01"));
                            return;
                        } else {
                            this.sb_bass.setEnabled(false);
                            this.sb_treble.setEnabled(false);
                            return;
                        }
                    }
                    if (upperCase.startsWith(OrderSet.notice_eq_style_user)) {
                        refreshEqStyle(6);
                        return;
                    }
                    if (upperCase.startsWith(OrderSet.notice_bass)) {
                        if (upperCase.length() >= 8) {
                            this.sb_bass.setMax(Integer.valueOf(upperCase.substring(6, 8), 16).intValue() * 2);
                        }
                        int intValue = Integer.valueOf(upperCase.substring(4, 6), 16).intValue();
                        if (!this.mBassFromUser) {
                            if (this.mBassBarMove || this.sb_bass.getProgress() == intValue) {
                                return;
                            }
                            this.sb_bass.setProgress(intValue);
                            return;
                        }
                        if (this.mBassBarMove) {
                            return;
                        }
                        this.mBassFromUser = false;
                        return;
                    }
                    if (upperCase.startsWith(OrderSet.notice_treble)) {
                        if (upperCase.length() >= 8) {
                            this.sb_treble.setMax(Integer.valueOf(upperCase.substring(6, 8), 16).intValue() * 2);
                        }
                        int intValue2 = Integer.valueOf(upperCase.substring(4, 6), 16).intValue();
                        if (!this.mTrebleFromUser) {
                            if (this.mTrebleBarMove || this.sb_treble.getProgress() == intValue2) {
                                return;
                            }
                            this.sb_treble.setProgress(intValue2);
                            return;
                        }
                        if (this.mTrebleBarMove) {
                            return;
                        }
                        this.mTrebleFromUser = false;
                        return;
                    }
                    if (upperCase.startsWith(OrderSet.notice_balance)) {
                        if (upperCase.length() >= 8) {
                            this.sb_balance.setMax(Integer.valueOf(upperCase.substring(6, 8), 16).intValue() * 2);
                        }
                        int intValue3 = Integer.valueOf(upperCase.substring(4, 6), 16).intValue();
                        if (!this.mBalanceFromUser) {
                            if (this.mBalanceBarMove || this.sb_balance.getProgress() == intValue3) {
                                return;
                            }
                            this.sb_balance.setProgress(intValue3);
                            return;
                        }
                        if (this.mBalanceBarMove) {
                            return;
                        }
                        this.mBalanceFromUser = false;
                        return;
                    }
                    if (upperCase.startsWith(OrderSet.notice_fade)) {
                        if (upperCase.length() >= 8) {
                            this.sb_fade.setMax(Integer.valueOf(upperCase.substring(6, 8), 16).intValue() * 2);
                        }
                        int intValue4 = Integer.valueOf(upperCase.substring(4, 6), 16).intValue();
                        if (!this.mFadeFromUser) {
                            if (this.mFadeBarMove || this.sb_fade.getProgress() == intValue4) {
                                return;
                            }
                            this.sb_fade.setProgress(intValue4);
                            return;
                        }
                        if (this.mFadeBarMove) {
                            return;
                        }
                        this.mFadeFromUser = false;
                        return;
                    }
                    if (upperCase.startsWith(OrderSet.notice_not_support_fad)) {
                        this.sb_fade.setEnabled(false);
                        return;
                    }
                    return;
                }
                new ChannelDialog().show(getChildFragmentManager(), "ChannelDialog");
                this.mIMain.setItemVisibility();
                dismiss();
                return;
            }
            new DspDialog().show(getChildFragmentManager(), "DspDialog");
            this.mIMain.setItemVisibility();
            dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
