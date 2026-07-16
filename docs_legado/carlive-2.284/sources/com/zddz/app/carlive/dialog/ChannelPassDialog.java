package com.zddz.app.carlive.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import com.hjq.toast.ToastUtils;
import com.zddz.app.carlive.OrderSet;
import com.zddz.app.carlive.database.ChannelItem;
import com.zddz.app.carlive.database.ChannelRecord;
import com.zddz.app.carlive.dialog.ChannelSlopeWindow;
import com.zddz.app.carlive.dialog.NumberInputDialog;
import com.zddz.app.carlive.fragment.BaseDialog;
import com.zddz.app.carlive.fragment.IMain;
import com.zddz.bt.Convert;
import java.util.UUID;
import org.litepal.LitePal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class ChannelPassDialog extends BaseDialog {
    private CheckedTextView ctv_phase_normal;
    private CheckedTextView ctv_phase_reverse;
    private ImageView iv_high_slope;
    private ImageView iv_low_slope;
    private ChannelItem mCurrentChannelItem;
    private Handler mHandler;
    private String[] mSlope;
    private RelativeLayout rl_high_slope;
    private RelativeLayout rl_low_slope;
    private SeekBar sb_gain;
    private Switch switch_high_pass;
    private Switch switch_low_pass;
    private TextView tv_channel;
    private TextView tv_delayed;
    private TextView tv_gain_value;
    private TextView tv_high_frequency_value;
    private TextView tv_high_slope_value;
    private TextView tv_low_frequency_value;
    private TextView tv_low_slope_value;
    private boolean mSwitchHighCutFromUser = false;
    private boolean mSwitchLowCutFromUser = false;
    private final View.OnClickListener mOnClickListener = new 1();
    private boolean mGainFromUser = false;
    private boolean mGainMove = false;
    private final Runnable mGainOutRunnable = new 2();
    private final CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener = new 3();
    private boolean mCanEditGain = true;

    static /* synthetic */ ChannelItem access$000(ChannelPassDialog channelPassDialog) {
        return channelPassDialog.mCurrentChannelItem;
    }

    static /* synthetic */ SeekBar access$100(ChannelPassDialog channelPassDialog) {
        return channelPassDialog.sb_gain;
    }

    static /* synthetic */ TextView access$1000(ChannelPassDialog channelPassDialog) {
        return channelPassDialog.tv_delayed;
    }

    static /* synthetic */ IMain access$1100(ChannelPassDialog channelPassDialog) {
        return channelPassDialog.mIMain;
    }

    static /* synthetic */ RelativeLayout access$1200(ChannelPassDialog channelPassDialog) {
        return channelPassDialog.rl_high_slope;
    }

    static /* synthetic */ String[] access$1300(ChannelPassDialog channelPassDialog) {
        return channelPassDialog.mSlope;
    }

    static /* synthetic */ TextView access$1400(ChannelPassDialog channelPassDialog) {
        return channelPassDialog.tv_high_slope_value;
    }

    static /* synthetic */ IMain access$1500(ChannelPassDialog channelPassDialog) {
        return channelPassDialog.mIMain;
    }

    static /* synthetic */ ImageView access$1600(ChannelPassDialog channelPassDialog) {
        return channelPassDialog.iv_high_slope;
    }

    static /* synthetic */ RelativeLayout access$1700(ChannelPassDialog channelPassDialog) {
        return channelPassDialog.rl_low_slope;
    }

    static /* synthetic */ TextView access$1800(ChannelPassDialog channelPassDialog) {
        return channelPassDialog.tv_low_slope_value;
    }

    static /* synthetic */ IMain access$1900(ChannelPassDialog channelPassDialog) {
        return channelPassDialog.mIMain;
    }

    static /* synthetic */ IMain access$200(ChannelPassDialog channelPassDialog) {
        return channelPassDialog.mIMain;
    }

    static /* synthetic */ ImageView access$2000(ChannelPassDialog channelPassDialog) {
        return channelPassDialog.iv_low_slope;
    }

    static /* synthetic */ IMain access$2100(ChannelPassDialog channelPassDialog) {
        return channelPassDialog.mIMain;
    }

    static /* synthetic */ IMain access$2200(ChannelPassDialog channelPassDialog) {
        return channelPassDialog.mIMain;
    }

    static /* synthetic */ IMain access$2300(ChannelPassDialog channelPassDialog) {
        return channelPassDialog.mIMain;
    }

    static /* synthetic */ IMain access$2400(ChannelPassDialog channelPassDialog) {
        return channelPassDialog.mIMain;
    }

    static /* synthetic */ boolean access$2500(ChannelPassDialog channelPassDialog) {
        return channelPassDialog.mGainMove;
    }

    static /* synthetic */ boolean access$2502(ChannelPassDialog channelPassDialog, boolean z) {
        channelPassDialog.mGainMove = z;
        return z;
    }

    static /* synthetic */ CheckedTextView access$2600(ChannelPassDialog channelPassDialog) {
        return channelPassDialog.ctv_phase_reverse;
    }

    static /* synthetic */ IMain access$2700(ChannelPassDialog channelPassDialog) {
        return channelPassDialog.mIMain;
    }

    static /* synthetic */ Handler access$2800(ChannelPassDialog channelPassDialog) {
        return channelPassDialog.mHandler;
    }

    static /* synthetic */ boolean access$2900(ChannelPassDialog channelPassDialog) {
        return channelPassDialog.mSwitchHighCutFromUser;
    }

    static /* synthetic */ boolean access$2902(ChannelPassDialog channelPassDialog, boolean z) {
        channelPassDialog.mSwitchHighCutFromUser = z;
        return z;
    }

    static /* synthetic */ IMain access$300(ChannelPassDialog channelPassDialog) {
        return channelPassDialog.mIMain;
    }

    static /* synthetic */ boolean access$3000(ChannelPassDialog channelPassDialog) {
        return channelPassDialog.mSwitchLowCutFromUser;
    }

    static /* synthetic */ boolean access$3002(ChannelPassDialog channelPassDialog, boolean z) {
        channelPassDialog.mSwitchLowCutFromUser = z;
        return z;
    }

    static /* synthetic */ IMain access$3100(ChannelPassDialog channelPassDialog) {
        return channelPassDialog.mIMain;
    }

    static /* synthetic */ TextView access$3200(ChannelPassDialog channelPassDialog) {
        return channelPassDialog.tv_gain_value;
    }

    static /* synthetic */ boolean access$3302(ChannelPassDialog channelPassDialog, boolean z) {
        channelPassDialog.mGainFromUser = z;
        return z;
    }

    static /* synthetic */ Runnable access$3400(ChannelPassDialog channelPassDialog) {
        return channelPassDialog.mGainOutRunnable;
    }

    static /* synthetic */ IMain access$3500(ChannelPassDialog channelPassDialog) {
        return channelPassDialog.mIMain;
    }

    static /* synthetic */ Switch access$400(ChannelPassDialog channelPassDialog) {
        return channelPassDialog.switch_high_pass;
    }

    static /* synthetic */ TextView access$500(ChannelPassDialog channelPassDialog) {
        return channelPassDialog.tv_high_frequency_value;
    }

    static /* synthetic */ IMain access$600(ChannelPassDialog channelPassDialog) {
        return channelPassDialog.mIMain;
    }

    static /* synthetic */ Switch access$700(ChannelPassDialog channelPassDialog) {
        return channelPassDialog.switch_low_pass;
    }

    static /* synthetic */ TextView access$800(ChannelPassDialog channelPassDialog) {
        return channelPassDialog.tv_low_frequency_value;
    }

    static /* synthetic */ IMain access$900(ChannelPassDialog channelPassDialog) {
        return channelPassDialog.mIMain;
    }

    class 1 implements View.OnClickListener {
        1() {
        }

        public void onClick(View view) {
            int id = view.getId();
            if (id == 2131297075) {
                ChannelPassDialog.this.dismiss();
                return;
            }
            if (id == 2131296432) {
                byte[] bArr = OrderSet.write_channel_phase_gain;
                bArr[2] = Byte.parseByte(ChannelPassDialog.access$000(ChannelPassDialog.this).mNumber);
                bArr[3] = 0;
                bArr[4] = (byte) ChannelPassDialog.access$100(ChannelPassDialog.this).getProgress();
                ChannelPassDialog.access$200(ChannelPassDialog.this).writeData(bArr);
                return;
            }
            if (id == 2131296433) {
                byte[] bArr2 = OrderSet.write_channel_phase_gain;
                bArr2[2] = Byte.parseByte(ChannelPassDialog.access$000(ChannelPassDialog.this).mNumber);
                bArr2[3] = 1;
                bArr2[4] = (byte) ChannelPassDialog.access$100(ChannelPassDialog.this).getProgress();
                ChannelPassDialog.access$300(ChannelPassDialog.this).writeData(bArr2);
                return;
            }
            if (id == 2131296591) {
                if (!ChannelPassDialog.access$400(ChannelPassDialog.this).isChecked()) {
                    ToastUtils.show(2131755467);
                    return;
                }
                ChannelPassInputDialog channelPassInputDialog = new ChannelPassInputDialog(ChannelPassDialog.this.getContext());
                channelPassInputDialog.setRange(1, 20000);
                channelPassInputDialog.setPrompt(2131755182);
                channelPassInputDialog.setOnConfirmListener(new 1());
                channelPassInputDialog.show();
                return;
            }
            if (id == 2131296593) {
                if (!ChannelPassDialog.access$700(ChannelPassDialog.this).isChecked()) {
                    ToastUtils.show(2131755467);
                    return;
                }
                ChannelPassInputDialog channelPassInputDialog2 = new ChannelPassInputDialog(ChannelPassDialog.this.getContext());
                channelPassInputDialog2.setRange(1, 20000);
                channelPassInputDialog2.setPrompt(2131755182);
                channelPassInputDialog2.setOnConfirmListener(new 2());
                channelPassInputDialog2.show();
                return;
            }
            if (id == 2131296930) {
                ChannelPassInputDialog channelPassInputDialog3 = new ChannelPassInputDialog(ChannelPassDialog.this.getContext());
                channelPassInputDialog3.setOnConfirmListener(new 3());
                channelPassInputDialog3.show();
                return;
            }
            if (id == 2131296730) {
                if (!ChannelPassDialog.access$400(ChannelPassDialog.this).isChecked()) {
                    ToastUtils.show(2131755467);
                    return;
                }
                ChannelSlopeWindow channelSlopeWindow = new ChannelSlopeWindow(ChannelPassDialog.this.getContext(), ChannelPassDialog.access$1200(ChannelPassDialog.this).getWidth());
                channelSlopeWindow.setOnItemSelectListener(new 4());
                ChannelPassDialog.access$1200(ChannelPassDialog.this).setEnabled(false);
                ChannelPassDialog.access$1600(ChannelPassDialog.this).getDrawable().setLevel(1);
                ChannelPassDialog.access$1200(ChannelPassDialog.this).getBackground().setLevel(1);
                channelSlopeWindow.setOnDismissListener(new 5());
                channelSlopeWindow.showAsDropDown(ChannelPassDialog.access$1200(ChannelPassDialog.this));
                return;
            }
            if (id == 2131296733) {
                if (!ChannelPassDialog.access$700(ChannelPassDialog.this).isChecked()) {
                    ToastUtils.show(2131755467);
                    return;
                }
                ChannelSlopeWindow channelSlopeWindow2 = new ChannelSlopeWindow(ChannelPassDialog.this.getContext(), ChannelPassDialog.access$1700(ChannelPassDialog.this).getWidth());
                channelSlopeWindow2.setOnItemSelectListener(new 6());
                ChannelPassDialog.access$2000(ChannelPassDialog.this).getDrawable().setLevel(1);
                ChannelPassDialog.access$1700(ChannelPassDialog.this).setEnabled(false);
                ChannelPassDialog.access$1700(ChannelPassDialog.this).getBackground().setLevel(1);
                channelSlopeWindow2.setOnDismissListener(new 7());
                channelSlopeWindow2.showAsDropDown(ChannelPassDialog.access$1700(ChannelPassDialog.this));
                return;
            }
            if (id == 2131297086) {
                byte[] bArr3 = OrderSet.write_channel_high_pass_slope_frequency;
                bArr3[2] = Byte.parseByte(ChannelPassDialog.access$000(ChannelPassDialog.this).mNumber);
                bArr3[3] = 1;
                byte[] intToBytes4HighLow = Convert.intToBytes4HighLow(6000);
                bArr3[4] = intToBytes4HighLow[2];
                bArr3[5] = intToBytes4HighLow[3];
                ChannelPassDialog.access$2100(ChannelPassDialog.this).writeData(bArr3);
                byte[] bArr4 = OrderSet.write_channel_low_pass_slope_frequency;
                bArr4[2] = Byte.parseByte(ChannelPassDialog.access$000(ChannelPassDialog.this).mNumber);
                bArr4[3] = 1;
                byte[] intToBytes4HighLow2 = Convert.intToBytes4HighLow(400);
                bArr4[4] = intToBytes4HighLow2[2];
                bArr4[5] = intToBytes4HighLow2[3];
                ChannelPassDialog.access$2200(ChannelPassDialog.this).writeData(bArr4);
                byte[] bArr5 = OrderSet.write_channel_phase_gain;
                bArr5[2] = Byte.parseByte(ChannelPassDialog.access$000(ChannelPassDialog.this).mNumber);
                bArr5[3] = 0;
                bArr5[4] = 0;
                ChannelPassDialog.access$2300(ChannelPassDialog.this).writeData(bArr5);
                byte[] bArr6 = OrderSet.write_channel_pass_switch;
                bArr6[2] = Byte.parseByte(ChannelPassDialog.access$000(ChannelPassDialog.this).mNumber);
                ChannelPassDialog.access$2400(ChannelPassDialog.this).writeData(bArr6);
            }
        }

        class 1 implements NumberInputDialog.OnConfirmListener {
            1() {
            }

            public void OnConfirm(int i) {
                try {
                    ChannelPassDialog.access$500(ChannelPassDialog.this).setText(i + "Hz");
                    byte[] bArr = OrderSet.write_channel_high_pass_slope_frequency;
                    bArr[2] = Byte.parseByte(ChannelPassDialog.access$000(ChannelPassDialog.this).mNumber);
                    bArr[3] = (byte) ChannelPassDialog.access$000(ChannelPassDialog.this).mHighPassSlope;
                    byte[] intToBytes4HighLow = Convert.intToBytes4HighLow(i);
                    bArr[4] = intToBytes4HighLow[2];
                    bArr[5] = intToBytes4HighLow[3];
                    ChannelPassDialog.access$600(ChannelPassDialog.this).writeData(bArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    ChannelPassDialog.access$500(ChannelPassDialog.this).setText(ChannelPassDialog.access$000(ChannelPassDialog.this).mHighPassFrequency + "Hz");
                }
            }
        }

        class 2 implements NumberInputDialog.OnConfirmListener {
            2() {
            }

            public void OnConfirm(int i) {
                try {
                    ChannelPassDialog.access$800(ChannelPassDialog.this).setText(i + "Hz");
                    byte[] bArr = OrderSet.write_channel_low_pass_slope_frequency;
                    bArr[2] = Byte.parseByte(ChannelPassDialog.access$000(ChannelPassDialog.this).mNumber);
                    bArr[3] = (byte) (ChannelPassDialog.access$000(ChannelPassDialog.this).mLowPassSlope + 1);
                    byte[] intToBytes4HighLow = Convert.intToBytes4HighLow(i);
                    bArr[4] = intToBytes4HighLow[2];
                    bArr[5] = intToBytes4HighLow[3];
                    ChannelPassDialog.access$900(ChannelPassDialog.this).writeData(bArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    ChannelPassDialog.access$800(ChannelPassDialog.this).setText(ChannelPassDialog.access$000(ChannelPassDialog.this).mLowPassFrequency + "Hz");
                }
            }
        }

        class 3 implements NumberInputDialog.OnConfirmListener {
            3() {
            }

            public void OnConfirm(int i) {
                try {
                    ChannelPassDialog.access$1000(ChannelPassDialog.this).setText(i + "ms");
                    byte[] bArr = OrderSet.write_channel_delay;
                    bArr[2] = Byte.parseByte(ChannelPassDialog.access$000(ChannelPassDialog.this).mNumber);
                    bArr[3] = (byte) i;
                    ChannelPassDialog.access$1100(ChannelPassDialog.this).writeData(bArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    ChannelPassDialog.access$1000(ChannelPassDialog.this).setText(ChannelPassDialog.access$000(ChannelPassDialog.this).mDelay + "ms");
                }
            }
        }

        class 4 implements ChannelSlopeWindow.OnItemSelectListener {
            4() {
            }

            public void onItemClick(int i) {
                ChannelPassDialog.access$1400(ChannelPassDialog.this).setText(ChannelPassDialog.access$1300(ChannelPassDialog.this)[i]);
                byte[] bArr = OrderSet.write_channel_high_pass_slope_frequency;
                bArr[2] = Byte.parseByte(ChannelPassDialog.access$000(ChannelPassDialog.this).mNumber);
                bArr[3] = (byte) (i + 1);
                byte[] intToBytes4HighLow = Convert.intToBytes4HighLow(ChannelPassDialog.access$000(ChannelPassDialog.this).mHighPassFrequency);
                bArr[4] = intToBytes4HighLow[2];
                bArr[5] = intToBytes4HighLow[3];
                ChannelPassDialog.access$1500(ChannelPassDialog.this).writeData(bArr);
            }
        }

        class 5 implements PopupWindow.OnDismissListener {
            5() {
            }

            public void onDismiss() {
                ChannelPassDialog.access$1600(ChannelPassDialog.this).getDrawable().setLevel(0);
                ChannelPassDialog.access$1200(ChannelPassDialog.this).getBackground().setLevel(0);
                ChannelPassDialog.access$1200(ChannelPassDialog.this).setEnabled(true);
            }
        }

        class 6 implements ChannelSlopeWindow.OnItemSelectListener {
            6() {
            }

            public void onItemClick(int i) {
                ChannelPassDialog.access$1800(ChannelPassDialog.this).setText(ChannelPassDialog.access$1300(ChannelPassDialog.this)[i]);
                byte[] bArr = OrderSet.write_channel_low_pass_slope_frequency;
                bArr[2] = Byte.parseByte(ChannelPassDialog.access$000(ChannelPassDialog.this).mNumber);
                bArr[3] = (byte) (i + 1);
                byte[] intToBytes4HighLow = Convert.intToBytes4HighLow(ChannelPassDialog.access$000(ChannelPassDialog.this).mLowPassFrequency);
                bArr[4] = intToBytes4HighLow[2];
                bArr[5] = intToBytes4HighLow[3];
                ChannelPassDialog.access$1900(ChannelPassDialog.this).writeData(bArr);
            }
        }

        class 7 implements PopupWindow.OnDismissListener {
            7() {
            }

            public void onDismiss() {
                ChannelPassDialog.access$2000(ChannelPassDialog.this).getDrawable().setLevel(0);
                ChannelPassDialog.access$1700(ChannelPassDialog.this).getBackground().setLevel(0);
                ChannelPassDialog.access$1700(ChannelPassDialog.this).setEnabled(true);
            }
        }
    }

    class 2 implements Runnable {
        2() {
        }

        public void run() {
            if (ChannelPassDialog.access$2500(ChannelPassDialog.this)) {
                byte[] bArr = OrderSet.write_channel_phase_gain;
                bArr[2] = Byte.parseByte(ChannelPassDialog.access$000(ChannelPassDialog.this).mNumber);
                if (ChannelPassDialog.access$2600(ChannelPassDialog.this).isChecked()) {
                    bArr[3] = 1;
                } else {
                    bArr[3] = 0;
                }
                bArr[4] = (byte) ChannelPassDialog.access$100(ChannelPassDialog.this).getProgress();
                ChannelPassDialog.access$2700(ChannelPassDialog.this).writeData(bArr);
                ChannelPassDialog.access$2800(ChannelPassDialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 3 implements CompoundButton.OnCheckedChangeListener {
        3() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (ChannelPassDialog.access$2900(ChannelPassDialog.this) || ChannelPassDialog.access$3000(ChannelPassDialog.this)) {
                byte[] bArr = OrderSet.write_channel_pass_switch;
                bArr[2] = Byte.parseByte(ChannelPassDialog.access$000(ChannelPassDialog.this).mNumber);
                if (ChannelPassDialog.access$400(ChannelPassDialog.this).isChecked() && ChannelPassDialog.access$700(ChannelPassDialog.this).isChecked()) {
                    bArr[3] = 3;
                } else if (ChannelPassDialog.access$700(ChannelPassDialog.this).isChecked()) {
                    bArr[3] = 2;
                } else if (ChannelPassDialog.access$400(ChannelPassDialog.this).isChecked()) {
                    bArr[3] = 1;
                } else {
                    bArr[3] = 0;
                }
                ChannelPassDialog.access$3100(ChannelPassDialog.this).writeData(bArr);
            }
            ChannelPassDialog.access$2902(ChannelPassDialog.this, true);
            ChannelPassDialog.access$3002(ChannelPassDialog.this, true);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(2131492914, viewGroup, false);
        return this.mRootView;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mHandler = new Handler(Looper.myLooper());
        this.mRootView.findViewById(2131297075).setOnClickListener(this.mOnClickListener);
        this.tv_channel = this.mRootView.findViewById(2131296921);
        this.mRootView.findViewById(2131297086).setOnClickListener(this.mOnClickListener);
        Switch findViewById = this.mRootView.findViewById(2131296849);
        this.switch_high_pass = findViewById;
        findViewById.setOnCheckedChangeListener(this.mOnCheckedChangeListener);
        this.tv_high_frequency_value = this.mRootView.findViewById(2131296990);
        this.mRootView.findViewById(2131296591).setOnClickListener(this.mOnClickListener);
        this.tv_high_slope_value = this.mRootView.findViewById(2131296993);
        this.iv_high_slope = this.mRootView.findViewById(2131296558);
        this.rl_high_slope = this.mRootView.findViewById(2131296730);
        Switch findViewById2 = this.mRootView.findViewById(2131296850);
        this.switch_low_pass = findViewById2;
        findViewById2.setOnCheckedChangeListener(this.mOnCheckedChangeListener);
        this.tv_low_frequency_value = this.mRootView.findViewById(2131296999);
        this.mRootView.findViewById(2131296593).setOnClickListener(this.mOnClickListener);
        this.tv_low_slope_value = this.mRootView.findViewById(2131297002);
        this.iv_low_slope = this.mRootView.findViewById(2131296559);
        this.rl_low_slope = this.mRootView.findViewById(2131296733);
        SeekBar findViewById3 = this.mRootView.findViewById(2131296770);
        this.sb_gain = findViewById3;
        boolean z = this.mCanEditGain;
        if (!z) {
            findViewById3.setEnabled(z);
            Drawable drawable = getActivity().getResources().getDrawable(2131230876);
            Drawable drawable2 = getActivity().getResources().getDrawable(2131230877);
            SeekBar seekBar = this.sb_gain;
            if (!this.mCanEditGain) {
                drawable = drawable2;
            }
            seekBar.setProgressDrawable(drawable);
        }
        this.tv_gain_value = this.mRootView.findViewById(2131296984);
        this.ctv_phase_normal = this.mRootView.findViewById(2131296432);
        this.ctv_phase_reverse = this.mRootView.findViewById(2131296433);
        TextView findViewById4 = this.mRootView.findViewById(2131296930);
        this.tv_delayed = findViewById4;
        findViewById4.setOnClickListener(this.mOnClickListener);
        this.sb_gain.setOnSeekBarChangeListener(new 4());
        this.mSlope = getContext().getResources().getStringArray(2130903040);
        this.ctv_phase_normal.setOnClickListener(this.mOnClickListener);
        this.ctv_phase_reverse.setOnClickListener(this.mOnClickListener);
        this.rl_high_slope.setOnClickListener(this.mOnClickListener);
        this.rl_low_slope.setOnClickListener(this.mOnClickListener);
        String string = getArguments() != null ? getArguments().getString("CurrentChannel", "1") : "1";
        this.mCurrentChannelItem = new ChannelItem(string);
        init(string);
        refreshEqEqType(this.mBaseViewModel.getEqType());
    }

    class 4 implements SeekBar.OnSeekBarChangeListener {
        4() {
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            TextView access$3200 = ChannelPassDialog.access$3200(ChannelPassDialog.this);
            StringBuilder sb = new StringBuilder();
            sb.append(i - 32);
            sb.append("db");
            access$3200.setText(sb.toString());
            ChannelPassDialog.access$3302(ChannelPassDialog.this, z);
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            ChannelPassDialog.access$2502(ChannelPassDialog.this, true);
            ChannelPassDialog.access$2800(ChannelPassDialog.this).postDelayed(ChannelPassDialog.access$3400(ChannelPassDialog.this), 200L);
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            ChannelPassDialog.access$2502(ChannelPassDialog.this, false);
            try {
                ChannelPassDialog.access$2800(ChannelPassDialog.this).removeCallbacks(ChannelPassDialog.access$3400(ChannelPassDialog.this));
                ChannelPassDialog.access$2800(ChannelPassDialog.this).postDelayed(new 1(seekBar), 300L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        class 1 implements Runnable {
            final /* synthetic */ SeekBar val$seekBar;

            1(SeekBar seekBar) {
                this.val$seekBar = seekBar;
            }

            public void run() {
                ChannelPassDialog.access$3302(ChannelPassDialog.this, false);
                byte[] bArr = OrderSet.write_channel_phase_gain;
                bArr[2] = Byte.parseByte(ChannelPassDialog.access$000(ChannelPassDialog.this).mNumber);
                if (ChannelPassDialog.access$2600(ChannelPassDialog.this).isChecked()) {
                    bArr[3] = 1;
                } else {
                    bArr[3] = 0;
                }
                bArr[4] = (byte) this.val$seekBar.getProgress();
                ChannelPassDialog.access$3500(ChannelPassDialog.this).writeData(bArr);
            }
        }
    }

    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setLayout(-1, -1);
    }

    private void refreshEqEqType(int i) {
        if (i == 0 || i == 8) {
            dismiss();
            return;
        }
        if (i == 1 || i == 2) {
            dismiss();
            return;
        }
        if (i == 7) {
            dismiss();
            return;
        }
        if (i == 5) {
            this.sb_gain.setMax(32);
            if (this.mCurrentChannelItem.mNumber.equals("4")) {
                this.tv_channel.setText(2131755111);
                return;
            }
            return;
        }
        this.sb_gain.setMax(44);
    }

    private void init(String str) {
        ChannelRecord channelRecord = (ChannelRecord) LitePal.where("number = ?", str).findFirst(ChannelRecord.class);
        if (channelRecord != null) {
            String str2 = channelRecord.number;
            str2.hashCode();
            switch (str2) {
                case "1":
                    this.tv_channel.setText(2131755035);
                    break;
                case "2":
                    this.tv_channel.setText(2131755036);
                    break;
                case "3":
                    this.tv_channel.setText(2131755112);
                    break;
                case "4":
                    this.tv_channel.setText(2131755113);
                    break;
                case "5":
                    this.tv_channel.setText(2131755114);
                    break;
                case "6":
                    this.tv_channel.setText(2131755115);
                    break;
            }
            if (channelRecord.high_pass_switch == 0) {
                this.mSwitchHighCutFromUser = false;
                this.mSwitchLowCutFromUser = false;
                this.switch_high_pass.setChecked(false);
            } else {
                this.mSwitchHighCutFromUser = false;
                this.mSwitchLowCutFromUser = false;
                this.switch_high_pass.setChecked(true);
            }
            if (channelRecord.low_pass_switch == 0) {
                this.mSwitchHighCutFromUser = false;
                this.mSwitchLowCutFromUser = false;
                this.switch_low_pass.setChecked(false);
            } else {
                this.mSwitchHighCutFromUser = false;
                this.mSwitchLowCutFromUser = false;
                this.switch_low_pass.setChecked(true);
            }
            this.tv_high_frequency_value.setText(channelRecord.high_pass_frequency + "Hz");
            this.tv_low_frequency_value.setText(channelRecord.low_pass_frequency + "Hz");
            if (channelRecord.phase == 0) {
                this.ctv_phase_normal.setChecked(true);
                this.ctv_phase_reverse.setChecked(false);
            } else {
                this.ctv_phase_normal.setChecked(false);
                this.ctv_phase_reverse.setChecked(true);
            }
            this.tv_delayed.setText(channelRecord.delay + "ms");
            this.tv_gain_value.setText((channelRecord.gain + (-32)) + "db");
            if (!this.mGainFromUser) {
                if (!this.mGainMove && this.sb_gain.getProgress() != channelRecord.gain) {
                    this.sb_gain.setProgress(channelRecord.gain);
                }
            } else if (!this.mGainMove) {
                this.mGainFromUser = false;
            }
            this.tv_high_slope_value.setText(this.mSlope[channelRecord.high_pass_slope - 1]);
            this.tv_low_slope_value.setText(this.mSlope[channelRecord.low_pass_slope - 1]);
            this.mCurrentChannelItem = new ChannelItem(channelRecord);
        }
    }

    public void notice(String str, UUID uuid, byte[] bArr) {
        try {
            String upperCase = Convert.bytesToHexString(bArr).toUpperCase();
            if (!upperCase.startsWith(OrderSet.notice_version_eq_default) && !upperCase.startsWith(OrderSet.notice_version_eq_default_six_station)) {
                if (!upperCase.startsWith(OrderSet.notice_version_eq_dsp) && !upperCase.startsWith(OrderSet.notice_version_eq_aoveise)) {
                    if (upperCase.startsWith(OrderSet.notice_version_eq_ten_eq)) {
                        dismiss();
                        return;
                    }
                    if (upperCase.startsWith(OrderSet.notice_channel_phase_gain)) {
                        if (String.valueOf(Integer.parseInt(upperCase.substring(4, 6), 16)).equals(this.mCurrentChannelItem.mNumber)) {
                            if (Integer.parseInt(upperCase.substring(6, 8), 16) == 0) {
                                this.ctv_phase_normal.setChecked(true);
                                this.ctv_phase_reverse.setChecked(false);
                            } else {
                                this.ctv_phase_normal.setChecked(false);
                                this.ctv_phase_reverse.setChecked(true);
                            }
                            int parseInt = Integer.parseInt(upperCase.substring(8, 10), 16);
                            if (!this.mGainFromUser) {
                                if (this.mGainMove || this.sb_gain.getProgress() == parseInt) {
                                    return;
                                }
                                this.sb_gain.setProgress(parseInt);
                                return;
                            }
                            if (this.mGainMove) {
                                return;
                            }
                            this.mGainFromUser = false;
                            return;
                        }
                        return;
                    }
                    if (upperCase.startsWith(OrderSet.notice_channel_pass_switch)) {
                        if (String.valueOf(Integer.parseInt(upperCase.substring(4, 6), 16)).equals(this.mCurrentChannelItem.mNumber)) {
                            this.mCurrentChannelItem.mHighPassSwitch = Integer.parseInt(upperCase.substring(6, 8), 16);
                            this.mSwitchHighCutFromUser = false;
                            this.mSwitchLowCutFromUser = false;
                            int i = this.mCurrentChannelItem.mHighPassSwitch;
                            if (i == 0) {
                                this.switch_high_pass.setChecked(false);
                                this.switch_low_pass.setChecked(false);
                            } else if (i == 1) {
                                this.switch_high_pass.setChecked(true);
                                this.switch_low_pass.setChecked(false);
                            } else if (i == 2) {
                                this.switch_high_pass.setChecked(false);
                                this.switch_low_pass.setChecked(true);
                            } else if (i == 3) {
                                this.switch_high_pass.setChecked(true);
                                this.switch_low_pass.setChecked(true);
                            }
                            this.mSwitchHighCutFromUser = true;
                            this.mSwitchLowCutFromUser = true;
                            return;
                        }
                        return;
                    }
                    if (upperCase.startsWith(OrderSet.notice_channel_high_pass_slope_frequency)) {
                        if (String.valueOf(Integer.parseInt(upperCase.substring(4, 6), 16)).equals(this.mCurrentChannelItem.mNumber)) {
                            this.mCurrentChannelItem.mHighPassSlope = Integer.parseInt(upperCase.substring(6, 8), 16);
                            this.tv_high_slope_value.setText(this.mSlope[this.mCurrentChannelItem.mHighPassSlope - 1]);
                            this.mCurrentChannelItem.mHighPassFrequency = Integer.valueOf(upperCase.substring(8, 12), 16).intValue();
                            this.tv_high_frequency_value.setText(this.mCurrentChannelItem.mHighPassFrequency + "Hz");
                            return;
                        }
                        return;
                    }
                    if (upperCase.startsWith(OrderSet.notice_channel_low_pass_slope_frequency)) {
                        if (String.valueOf(Integer.parseInt(upperCase.substring(4, 6), 16)).equals(this.mCurrentChannelItem.mNumber)) {
                            this.mCurrentChannelItem.mLowPassSlope = Integer.parseInt(upperCase.substring(6, 8), 16);
                            this.tv_low_slope_value.setText(this.mSlope[this.mCurrentChannelItem.mLowPassSlope - 1]);
                            this.mCurrentChannelItem.mLowPassFrequency = Integer.valueOf(upperCase.substring(8, 12), 16).intValue();
                            this.tv_low_frequency_value.setText(this.mCurrentChannelItem.mLowPassFrequency + "Hz");
                            return;
                        }
                        return;
                    }
                    if (upperCase.startsWith(OrderSet.notice_channel_delay)) {
                        if (String.valueOf(Integer.parseInt(upperCase.substring(4, 6), 16)).equals(this.mCurrentChannelItem.mNumber)) {
                            this.mCurrentChannelItem.mDelay = Integer.parseInt(upperCase.substring(6, 8), 16);
                            this.tv_delayed.setText(this.mCurrentChannelItem.mDelay + "ms");
                            return;
                        }
                        return;
                    }
                    if (upperCase.startsWith(OrderSet.notice_channel_reset)) {
                        this.mSwitchHighCutFromUser = false;
                        this.mSwitchLowCutFromUser = false;
                        this.switch_high_pass.setChecked(false);
                        this.tv_high_frequency_value.setEnabled(false);
                        this.tv_high_slope_value.setEnabled(false);
                        this.mSwitchHighCutFromUser = false;
                        this.mSwitchLowCutFromUser = false;
                        this.switch_low_pass.setChecked(false);
                        this.tv_low_frequency_value.setEnabled(false);
                        this.tv_low_slope_value.setEnabled(false);
                        this.tv_high_frequency_value.setText("6000Hz");
                        this.tv_low_frequency_value.setText("400Hz");
                        this.ctv_phase_normal.setChecked(true);
                        this.ctv_phase_reverse.setChecked(false);
                        this.sb_gain.setProgress(32);
                        return;
                    }
                    return;
                }
                dismiss();
                return;
            }
            dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setCanEditGain(boolean z) {
        this.mCanEditGain = z;
    }
}
