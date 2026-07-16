package com.zddz.app.carlive.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckedTextView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.zddz.app.carlive.OrderSet;
import com.zddz.app.carlive.database.EqRecord;
import com.zddz.app.carlive.fragment.BaseDialog;
import com.zddz.app.carlive.fragment.IMain;
import com.zddz.widget.ScaleSeekBar;
import java.util.List;
import org.litepal.LitePal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class DspDialog extends BaseDialog {
    private CheckedTextView ctv_classic;
    private CheckedTextView ctv_country;
    private CheckedTextView ctv_ifx_3d_rotary;
    private CheckedTextView ctv_ifx_full_short;
    private CheckedTextView ctv_ifx_mega_bass;
    private CheckedTextView ctv_ifx_off;
    private CheckedTextView ctv_ifx_virtual;
    private CheckedTextView ctv_ifx_vocal;
    private CheckedTextView ctv_jazz;
    private CheckedTextView ctv_normal;
    private CheckedTextView ctv_popular;
    private CheckedTextView ctv_rock;
    private Handler mHandler;
    private RelativeLayout rl_ifx1;
    private RelativeLayout rl_ifx2;
    private SeekBar sb_eq0;
    private SeekBar sb_eq1;
    private SeekBar sb_eq2;
    private SeekBar sb_eq3;
    private SeekBar sb_eq4;
    private SeekBar sb_eq5;
    private SeekBar sb_eq6;
    private ScaleSeekBar ssb_balance;
    private ScaleSeekBar ssb_fade;
    private TextView tv_eq0;
    private TextView tv_eq0_value;
    private TextView tv_eq1;
    private TextView tv_eq1_value;
    private TextView tv_eq2;
    private TextView tv_eq2_value;
    private TextView tv_eq3;
    private TextView tv_eq3_value;
    private TextView tv_eq4;
    private TextView tv_eq4_value;
    private TextView tv_eq5;
    private TextView tv_eq5_value;
    private TextView tv_eq6;
    private TextView tv_eq6_value;
    private View.OnClickListener mOnClickListener = new 1();
    private boolean mEQ0FromUser = false;
    private boolean mEQ0BarMove = false;
    private final Runnable mEQ0Runnable = new 2();
    private boolean mEQ1FromUser = false;
    private boolean mEQ1BarMove = false;
    private final Runnable mEQ1Runnable = new 3();
    private boolean mEQ2FromUser = false;
    private boolean mEQ2BarMove = false;
    private final Runnable mEQ2Runnable = new 4();
    private boolean mEQ3FromUser = false;
    private boolean mEQ3BarMove = false;
    private final Runnable mEQ3Runnable = new 5();
    private boolean mEQ4FromUser = false;
    private boolean mEQ4BarMove = false;
    private final Runnable mEQ4Runnable = new 6();
    private boolean mEQ5FromUser = false;
    private boolean mEQ5BarMove = false;
    private final Runnable mEQ5Runnable = new 7();
    private boolean mEQ6FromUser = false;
    private boolean mEQ6BarMove = false;
    private final Runnable mEQ6Runnable = new 8();
    private SeekBar.OnSeekBarChangeListener mOnSeekBarChangeListener = new 9();
    private ScaleSeekBar.OnChangeListener mOnChangeListener = new 10();

    static /* synthetic */ IMain access$000(DspDialog dspDialog) {
        return dspDialog.mIMain;
    }

    static /* synthetic */ IMain access$100(DspDialog dspDialog) {
        return dspDialog.mIMain;
    }

    static /* synthetic */ IMain access$1000(DspDialog dspDialog) {
        return dspDialog.mIMain;
    }

    static /* synthetic */ IMain access$1100(DspDialog dspDialog) {
        return dspDialog.mIMain;
    }

    static /* synthetic */ boolean access$1200(DspDialog dspDialog) {
        return dspDialog.mEQ0BarMove;
    }

    static /* synthetic */ boolean access$1202(DspDialog dspDialog, boolean z) {
        dspDialog.mEQ0BarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$1300(DspDialog dspDialog) {
        return dspDialog.sb_eq0;
    }

    static /* synthetic */ IMain access$1400(DspDialog dspDialog) {
        return dspDialog.mIMain;
    }

    static /* synthetic */ Handler access$1500(DspDialog dspDialog) {
        return dspDialog.mHandler;
    }

    static /* synthetic */ boolean access$1600(DspDialog dspDialog) {
        return dspDialog.mEQ1BarMove;
    }

    static /* synthetic */ boolean access$1602(DspDialog dspDialog, boolean z) {
        dspDialog.mEQ1BarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$1700(DspDialog dspDialog) {
        return dspDialog.sb_eq1;
    }

    static /* synthetic */ boolean access$1800(DspDialog dspDialog) {
        return dspDialog.mEQ2BarMove;
    }

    static /* synthetic */ boolean access$1802(DspDialog dspDialog, boolean z) {
        dspDialog.mEQ2BarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$1900(DspDialog dspDialog) {
        return dspDialog.sb_eq2;
    }

    static /* synthetic */ IMain access$200(DspDialog dspDialog) {
        return dspDialog.mIMain;
    }

    static /* synthetic */ boolean access$2000(DspDialog dspDialog) {
        return dspDialog.mEQ3BarMove;
    }

    static /* synthetic */ boolean access$2002(DspDialog dspDialog, boolean z) {
        dspDialog.mEQ3BarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$2100(DspDialog dspDialog) {
        return dspDialog.sb_eq3;
    }

    static /* synthetic */ boolean access$2200(DspDialog dspDialog) {
        return dspDialog.mEQ4BarMove;
    }

    static /* synthetic */ boolean access$2202(DspDialog dspDialog, boolean z) {
        dspDialog.mEQ4BarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$2300(DspDialog dspDialog) {
        return dspDialog.sb_eq4;
    }

    static /* synthetic */ boolean access$2400(DspDialog dspDialog) {
        return dspDialog.mEQ5BarMove;
    }

    static /* synthetic */ boolean access$2402(DspDialog dspDialog, boolean z) {
        dspDialog.mEQ5BarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$2500(DspDialog dspDialog) {
        return dspDialog.sb_eq5;
    }

    static /* synthetic */ boolean access$2600(DspDialog dspDialog) {
        return dspDialog.mEQ6BarMove;
    }

    static /* synthetic */ boolean access$2602(DspDialog dspDialog, boolean z) {
        dspDialog.mEQ6BarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$2700(DspDialog dspDialog) {
        return dspDialog.sb_eq6;
    }

    static /* synthetic */ boolean access$2802(DspDialog dspDialog, boolean z) {
        dspDialog.mEQ0FromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$2900(DspDialog dspDialog) {
        return dspDialog.tv_eq0_value;
    }

    static /* synthetic */ IMain access$300(DspDialog dspDialog) {
        return dspDialog.mIMain;
    }

    static /* synthetic */ boolean access$3002(DspDialog dspDialog, boolean z) {
        dspDialog.mEQ1FromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$3100(DspDialog dspDialog) {
        return dspDialog.tv_eq1_value;
    }

    static /* synthetic */ boolean access$3202(DspDialog dspDialog, boolean z) {
        dspDialog.mEQ3FromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$3300(DspDialog dspDialog) {
        return dspDialog.tv_eq2_value;
    }

    static /* synthetic */ TextView access$3400(DspDialog dspDialog) {
        return dspDialog.tv_eq3_value;
    }

    static /* synthetic */ boolean access$3502(DspDialog dspDialog, boolean z) {
        dspDialog.mEQ4FromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$3600(DspDialog dspDialog) {
        return dspDialog.tv_eq4_value;
    }

    static /* synthetic */ boolean access$3702(DspDialog dspDialog, boolean z) {
        dspDialog.mEQ5FromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$3800(DspDialog dspDialog) {
        return dspDialog.tv_eq5_value;
    }

    static /* synthetic */ boolean access$3902(DspDialog dspDialog, boolean z) {
        dspDialog.mEQ6FromUser = z;
        return z;
    }

    static /* synthetic */ IMain access$400(DspDialog dspDialog) {
        return dspDialog.mIMain;
    }

    static /* synthetic */ TextView access$4000(DspDialog dspDialog) {
        return dspDialog.tv_eq6_value;
    }

    static /* synthetic */ Runnable access$4100(DspDialog dspDialog) {
        return dspDialog.mEQ0Runnable;
    }

    static /* synthetic */ Runnable access$4200(DspDialog dspDialog) {
        return dspDialog.mEQ1Runnable;
    }

    static /* synthetic */ Runnable access$4300(DspDialog dspDialog) {
        return dspDialog.mEQ2Runnable;
    }

    static /* synthetic */ Runnable access$4400(DspDialog dspDialog) {
        return dspDialog.mEQ3Runnable;
    }

    static /* synthetic */ Runnable access$4500(DspDialog dspDialog) {
        return dspDialog.mEQ4Runnable;
    }

    static /* synthetic */ Runnable access$4600(DspDialog dspDialog) {
        return dspDialog.mEQ5Runnable;
    }

    static /* synthetic */ Runnable access$4700(DspDialog dspDialog) {
        return dspDialog.mEQ6Runnable;
    }

    static /* synthetic */ IMain access$4800(DspDialog dspDialog) {
        return dspDialog.mIMain;
    }

    static /* synthetic */ IMain access$4900(DspDialog dspDialog) {
        return dspDialog.mIMain;
    }

    static /* synthetic */ IMain access$500(DspDialog dspDialog) {
        return dspDialog.mIMain;
    }

    static /* synthetic */ IMain access$5000(DspDialog dspDialog) {
        return dspDialog.mIMain;
    }

    static /* synthetic */ IMain access$5100(DspDialog dspDialog) {
        return dspDialog.mIMain;
    }

    static /* synthetic */ IMain access$5200(DspDialog dspDialog) {
        return dspDialog.mIMain;
    }

    static /* synthetic */ IMain access$5300(DspDialog dspDialog) {
        return dspDialog.mIMain;
    }

    static /* synthetic */ IMain access$5400(DspDialog dspDialog) {
        return dspDialog.mIMain;
    }

    static /* synthetic */ ScaleSeekBar access$5500(DspDialog dspDialog) {
        return dspDialog.ssb_balance;
    }

    static /* synthetic */ IMain access$5600(DspDialog dspDialog) {
        return dspDialog.mIMain;
    }

    static /* synthetic */ ScaleSeekBar access$5700(DspDialog dspDialog) {
        return dspDialog.ssb_fade;
    }

    static /* synthetic */ IMain access$5800(DspDialog dspDialog) {
        return dspDialog.mIMain;
    }

    static /* synthetic */ IMain access$600(DspDialog dspDialog) {
        return dspDialog.mIMain;
    }

    static /* synthetic */ IMain access$700(DspDialog dspDialog) {
        return dspDialog.mIMain;
    }

    static /* synthetic */ IMain access$800(DspDialog dspDialog) {
        return dspDialog.mIMain;
    }

    static /* synthetic */ IMain access$900(DspDialog dspDialog) {
        return dspDialog.mIMain;
    }

    class 1 implements View.OnClickListener {
        1() {
        }

        public void onClick(View view) {
            int id = view.getId();
            if (id == 2131296425) {
                DspDialog.access$000(DspDialog.this).writeData(OrderSet.write_dsp_ifx_off);
                return;
            }
            if (id == 2131296423) {
                DspDialog.access$100(DspDialog.this).writeData(OrderSet.write_dsp_ifx_full_short);
                return;
            }
            if (id == 2131296424) {
                DspDialog.access$200(DspDialog.this).writeData(OrderSet.write_dsp_ifx_mega_bass);
                return;
            }
            if (id == 2131296427) {
                DspDialog.access$300(DspDialog.this).writeData(OrderSet.write_dsp_ifx_vocal);
                return;
            }
            if (id == 2131296426) {
                DspDialog.access$400(DspDialog.this).writeData(OrderSet.write_dsp_ifx_virtual);
                return;
            }
            if (id == 2131296422) {
                DspDialog.access$500(DspDialog.this).writeData(OrderSet.write_dsp_ifx_3d_rotary);
                return;
            }
            if (id == 2131297075) {
                DspDialog.this.dismiss();
                return;
            }
            if (id == 2131296431) {
                DspDialog.access$600(DspDialog.this).writeData(OrderSet.write_eq_style_normal);
                return;
            }
            if (id == 2131296434) {
                DspDialog.access$700(DspDialog.this).writeData(OrderSet.write_eq_style_popular);
                return;
            }
            if (id == 2131296436) {
                DspDialog.access$800(DspDialog.this).writeData(OrderSet.write_eq_style_rock);
                return;
            }
            if (id == 2131296428) {
                DspDialog.access$900(DspDialog.this).writeData(OrderSet.write_eq_style_jazz);
            } else if (id == 2131296419) {
                DspDialog.access$1000(DspDialog.this).writeData(OrderSet.write_eq_style_classic);
            } else if (id == 2131296420) {
                DspDialog.access$1100(DspDialog.this).writeData(OrderSet.write_eq_style_country);
            }
        }
    }

    class 2 implements Runnable {
        2() {
        }

        public void run() {
            if (DspDialog.access$1200(DspDialog.this)) {
                byte[] bArr = OrderSet.write_dsp_eq;
                bArr[2] = 0;
                bArr[3] = (byte) DspDialog.access$1300(DspDialog.this).getProgress();
                DspDialog.access$1400(DspDialog.this).writeData(bArr);
                DspDialog.access$1500(DspDialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 3 implements Runnable {
        3() {
        }

        public void run() {
            if (DspDialog.access$1600(DspDialog.this)) {
                byte[] bArr = OrderSet.write_dsp_eq;
                bArr[2] = 1;
                bArr[3] = (byte) DspDialog.access$1700(DspDialog.this).getProgress();
            }
        }
    }

    class 4 implements Runnable {
        4() {
        }

        public void run() {
            if (DspDialog.access$1800(DspDialog.this)) {
                byte[] bArr = OrderSet.write_dsp_eq;
                bArr[2] = 2;
                bArr[3] = (byte) DspDialog.access$1900(DspDialog.this).getProgress();
            }
        }
    }

    class 5 implements Runnable {
        5() {
        }

        public void run() {
            if (DspDialog.access$2000(DspDialog.this)) {
                byte[] bArr = OrderSet.write_dsp_eq;
                bArr[2] = 3;
                bArr[3] = (byte) DspDialog.access$2100(DspDialog.this).getProgress();
            }
        }
    }

    class 6 implements Runnable {
        6() {
        }

        public void run() {
            if (DspDialog.access$2200(DspDialog.this)) {
                byte[] bArr = OrderSet.write_dsp_eq;
                bArr[2] = 4;
                bArr[3] = (byte) DspDialog.access$2300(DspDialog.this).getProgress();
            }
        }
    }

    class 7 implements Runnable {
        7() {
        }

        public void run() {
            if (DspDialog.access$2400(DspDialog.this)) {
                byte[] bArr = OrderSet.write_dsp_eq;
                bArr[2] = 5;
                bArr[3] = (byte) DspDialog.access$2500(DspDialog.this).getProgress();
            }
        }
    }

    class 8 implements Runnable {
        8() {
        }

        public void run() {
            if (DspDialog.access$2600(DspDialog.this)) {
                byte[] bArr = OrderSet.write_dsp_eq;
                bArr[2] = 6;
                bArr[3] = (byte) DspDialog.access$2700(DspDialog.this).getProgress();
            }
        }
    }

    class 9 implements SeekBar.OnSeekBarChangeListener {
        9() {
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            int progress = seekBar.getProgress();
            int id = seekBar.getId();
            if (id == 2131296753) {
                DspDialog.access$2802(DspDialog.this, z);
                DspDialog.access$2900(DspDialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296754) {
                DspDialog.access$3002(DspDialog.this, z);
                DspDialog.access$3100(DspDialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296755) {
                DspDialog.access$3202(DspDialog.this, z);
                DspDialog.access$3300(DspDialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296756) {
                DspDialog.access$3202(DspDialog.this, z);
                DspDialog.access$3400(DspDialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296757) {
                DspDialog.access$3502(DspDialog.this, z);
                DspDialog.access$3600(DspDialog.this).setText(String.valueOf(progress - 7));
            } else if (id == 2131296758) {
                DspDialog.access$3702(DspDialog.this, z);
                DspDialog.access$3800(DspDialog.this).setText(String.valueOf(progress - 7));
            } else if (id == 2131296759) {
                DspDialog.access$3902(DspDialog.this, z);
                DspDialog.access$4000(DspDialog.this).setText(String.valueOf(progress - 7));
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            int id = seekBar.getId();
            if (id == 2131296753) {
                DspDialog.access$1202(DspDialog.this, true);
                DspDialog.access$1500(DspDialog.this).postDelayed(DspDialog.access$4100(DspDialog.this), 200L);
                return;
            }
            if (id == 2131296754) {
                DspDialog.access$1602(DspDialog.this, true);
                DspDialog.access$1500(DspDialog.this).postDelayed(DspDialog.access$4200(DspDialog.this), 200L);
                return;
            }
            if (id == 2131296755) {
                DspDialog.access$1802(DspDialog.this, true);
                DspDialog.access$1500(DspDialog.this).postDelayed(DspDialog.access$4300(DspDialog.this), 200L);
                return;
            }
            if (id == 2131296756) {
                DspDialog.access$2002(DspDialog.this, true);
                DspDialog.access$1500(DspDialog.this).postDelayed(DspDialog.access$4400(DspDialog.this), 200L);
                return;
            }
            if (id == 2131296757) {
                DspDialog.access$2202(DspDialog.this, false);
                DspDialog.access$1500(DspDialog.this).postDelayed(DspDialog.access$4500(DspDialog.this), 200L);
            } else if (id == 2131296758) {
                DspDialog.access$2402(DspDialog.this, true);
                DspDialog.access$1500(DspDialog.this).postDelayed(DspDialog.access$4600(DspDialog.this), 200L);
            } else if (id == 2131296759) {
                DspDialog.access$2602(DspDialog.this, true);
                DspDialog.access$1500(DspDialog.this).postDelayed(DspDialog.access$4700(DspDialog.this), 200L);
            }
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            int id = seekBar.getId();
            if (id == 2131296753) {
                DspDialog.access$1202(DspDialog.this, false);
                try {
                    DspDialog.access$1500(DspDialog.this).removeCallbacks(DspDialog.access$4100(DspDialog.this));
                    DspDialog.access$1500(DspDialog.this).postDelayed(new 1(), 300L);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            if (id == 2131296754) {
                DspDialog.access$1602(DspDialog.this, false);
                try {
                    DspDialog.access$1500(DspDialog.this).removeCallbacks(DspDialog.access$4200(DspDialog.this));
                    DspDialog.access$1500(DspDialog.this).postDelayed(new 2(), 300L);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (id == 2131296755) {
                DspDialog.access$1802(DspDialog.this, false);
                try {
                    DspDialog.access$1500(DspDialog.this).removeCallbacks(DspDialog.access$4300(DspDialog.this));
                    DspDialog.access$1500(DspDialog.this).postDelayed(new 3(), 300L);
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            if (id == 2131296756) {
                DspDialog.access$2002(DspDialog.this, false);
                try {
                    DspDialog.access$1500(DspDialog.this).removeCallbacks(DspDialog.access$4400(DspDialog.this));
                    DspDialog.access$1500(DspDialog.this).postDelayed(new 4(), 300L);
                    return;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
            }
            if (id == 2131296757) {
                DspDialog.access$2202(DspDialog.this, false);
                try {
                    DspDialog.access$1500(DspDialog.this).removeCallbacks(DspDialog.access$4500(DspDialog.this));
                    DspDialog.access$1500(DspDialog.this).postDelayed(new 5(), 300L);
                    return;
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return;
                }
            }
            if (id == 2131296758) {
                DspDialog.access$2402(DspDialog.this, false);
                try {
                    DspDialog.access$1500(DspDialog.this).removeCallbacks(DspDialog.access$4600(DspDialog.this));
                    DspDialog.access$1500(DspDialog.this).postDelayed(new 6(), 300L);
                    return;
                } catch (Exception e6) {
                    e6.printStackTrace();
                    return;
                }
            }
            if (id == 2131296759) {
                DspDialog.access$2602(DspDialog.this, false);
                try {
                    DspDialog.access$1500(DspDialog.this).removeCallbacks(DspDialog.access$4700(DspDialog.this));
                    DspDialog.access$1500(DspDialog.this).postDelayed(new 7(), 300L);
                } catch (Exception e7) {
                    e7.printStackTrace();
                }
            }
        }

        class 1 implements Runnable {
            1() {
            }

            public void run() {
                byte[] bArr = OrderSet.write_dsp_eq;
                bArr[2] = 0;
                bArr[3] = (byte) DspDialog.access$1300(DspDialog.this).getProgress();
                DspDialog.access$4800(DspDialog.this).writeData(bArr);
            }
        }

        class 2 implements Runnable {
            2() {
            }

            public void run() {
                byte[] bArr = OrderSet.write_dsp_eq;
                bArr[2] = 1;
                bArr[3] = (byte) DspDialog.access$1700(DspDialog.this).getProgress();
                DspDialog.access$4900(DspDialog.this).writeData(bArr);
            }
        }

        class 3 implements Runnable {
            3() {
            }

            public void run() {
                byte[] bArr = OrderSet.write_dsp_eq;
                bArr[2] = 2;
                bArr[3] = (byte) DspDialog.access$1900(DspDialog.this).getProgress();
                DspDialog.access$5000(DspDialog.this).writeData(bArr);
            }
        }

        class 4 implements Runnable {
            4() {
            }

            public void run() {
                byte[] bArr = OrderSet.write_dsp_eq;
                bArr[2] = 3;
                bArr[3] = (byte) DspDialog.access$2100(DspDialog.this).getProgress();
                DspDialog.access$5100(DspDialog.this).writeData(bArr);
            }
        }

        class 5 implements Runnable {
            5() {
            }

            public void run() {
                byte[] bArr = OrderSet.write_dsp_eq;
                bArr[2] = 4;
                bArr[3] = (byte) DspDialog.access$2300(DspDialog.this).getProgress();
                DspDialog.access$5200(DspDialog.this).writeData(bArr);
            }
        }

        class 6 implements Runnable {
            6() {
            }

            public void run() {
                byte[] bArr = OrderSet.write_dsp_eq;
                bArr[2] = 5;
                bArr[3] = (byte) DspDialog.access$2500(DspDialog.this).getProgress();
                DspDialog.access$5300(DspDialog.this).writeData(bArr);
            }
        }

        class 7 implements Runnable {
            7() {
            }

            public void run() {
                byte[] bArr = OrderSet.write_dsp_eq;
                bArr[2] = 6;
                bArr[3] = (byte) DspDialog.access$2700(DspDialog.this).getProgress();
                DspDialog.access$5400(DspDialog.this).writeData(bArr);
            }
        }
    }

    class 10 implements ScaleSeekBar.OnChangeListener {
        10() {
        }

        public void onChange(ScaleSeekBar scaleSeekBar) {
            int id = scaleSeekBar.getId();
            if (id == 2131296833) {
                byte[] bArr = OrderSet.write_balance;
                bArr[2] = (byte) DspDialog.access$5500(DspDialog.this).getProgress();
                DspDialog.access$5600(DspDialog.this).writeData(bArr);
            } else if (id == 2131296834) {
                byte[] bArr2 = OrderSet.write_fade;
                bArr2[2] = (byte) DspDialog.access$5700(DspDialog.this).getProgress();
                DspDialog.access$5800(DspDialog.this).writeData(bArr2);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(2131492917, viewGroup, false);
        return this.mRootView;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mHandler = new Handler(Looper.myLooper());
        this.rl_ifx1 = this.mRootView.findViewById(2131296731);
        this.rl_ifx2 = this.mRootView.findViewById(2131296732);
        CheckedTextView findViewById = this.mRootView.findViewById(2131296425);
        this.ctv_ifx_off = findViewById;
        findViewById.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById2 = this.mRootView.findViewById(2131296423);
        this.ctv_ifx_full_short = findViewById2;
        findViewById2.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById3 = this.mRootView.findViewById(2131296424);
        this.ctv_ifx_mega_bass = findViewById3;
        findViewById3.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById4 = this.mRootView.findViewById(2131296427);
        this.ctv_ifx_vocal = findViewById4;
        findViewById4.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById5 = this.mRootView.findViewById(2131296426);
        this.ctv_ifx_virtual = findViewById5;
        findViewById5.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById6 = this.mRootView.findViewById(2131296422);
        this.ctv_ifx_3d_rotary = findViewById6;
        findViewById6.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById7 = this.mRootView.findViewById(2131296431);
        this.ctv_normal = findViewById7;
        findViewById7.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById8 = this.mRootView.findViewById(2131296434);
        this.ctv_popular = findViewById8;
        findViewById8.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById9 = this.mRootView.findViewById(2131296436);
        this.ctv_rock = findViewById9;
        findViewById9.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById10 = this.mRootView.findViewById(2131296428);
        this.ctv_jazz = findViewById10;
        findViewById10.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById11 = this.mRootView.findViewById(2131296419);
        this.ctv_classic = findViewById11;
        findViewById11.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById12 = this.mRootView.findViewById(2131296420);
        this.ctv_country = findViewById12;
        findViewById12.setOnClickListener(this.mOnClickListener);
        this.mRootView.findViewById(2131297075).setOnClickListener(this.mOnClickListener);
        ScaleSeekBar scaleSeekBar = (ScaleSeekBar) this.mRootView.findViewById(2131296833);
        this.ssb_balance = scaleSeekBar;
        scaleSeekBar.setOnChangeListener(this.mOnChangeListener);
        ScaleSeekBar scaleSeekBar2 = (ScaleSeekBar) this.mRootView.findViewById(2131296834);
        this.ssb_fade = scaleSeekBar2;
        scaleSeekBar2.setOnChangeListener(this.mOnChangeListener);
        SeekBar findViewById13 = this.mRootView.findViewById(2131296753);
        this.sb_eq0 = findViewById13;
        findViewById13.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById14 = this.mRootView.findViewById(2131296754);
        this.sb_eq1 = findViewById14;
        findViewById14.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById15 = this.mRootView.findViewById(2131296755);
        this.sb_eq2 = findViewById15;
        findViewById15.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById16 = this.mRootView.findViewById(2131296756);
        this.sb_eq3 = findViewById16;
        findViewById16.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById17 = this.mRootView.findViewById(2131296757);
        this.sb_eq4 = findViewById17;
        findViewById17.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById18 = this.mRootView.findViewById(2131296758);
        this.sb_eq5 = findViewById18;
        findViewById18.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById19 = this.mRootView.findViewById(2131296759);
        this.sb_eq6 = findViewById19;
        findViewById19.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        this.tv_eq0 = this.mRootView.findViewById(2131296934);
        this.tv_eq1 = this.mRootView.findViewById(2131296936);
        this.tv_eq2 = this.mRootView.findViewById(2131296938);
        this.tv_eq3 = this.mRootView.findViewById(2131296940);
        this.tv_eq4 = this.mRootView.findViewById(2131296942);
        this.tv_eq5 = this.mRootView.findViewById(2131296944);
        this.tv_eq6 = this.mRootView.findViewById(2131296946);
        this.tv_eq0_value = this.mRootView.findViewById(2131296935);
        this.tv_eq1_value = this.mRootView.findViewById(2131296937);
        this.tv_eq2_value = this.mRootView.findViewById(2131296939);
        this.tv_eq3_value = this.mRootView.findViewById(2131296941);
        this.tv_eq4_value = this.mRootView.findViewById(2131296943);
        this.tv_eq5_value = this.mRootView.findViewById(2131296945);
        this.tv_eq6_value = this.mRootView.findViewById(2131296947);
        refreshEqType(this.mBaseViewModel.getEqType());
        refreshDspIfx(this.mBaseViewModel.getDspIfx());
        this.ssb_balance.setMax(this.mBaseViewModel.getBalanceMax() * 2);
        this.ssb_balance.setProgress(this.mBaseViewModel.getBalance());
        this.ssb_fade.setMax(this.mBaseViewModel.getFadeMax() * 2);
        this.ssb_fade.setProgress(this.mBaseViewModel.getFade());
        List<EqRecord> find = LitePal.limit(7).order("number asc").find(EqRecord.class);
        if (find.size() == 7) {
            for (EqRecord eqRecord : find) {
                if (eqRecord.eq >= 0) {
                    switch (eqRecord.number) {
                        case 0:
                            this.sb_eq0.setProgress(eqRecord.eq);
                            break;
                        case 1:
                            this.sb_eq1.setProgress(eqRecord.eq);
                            break;
                        case 2:
                            this.sb_eq2.setProgress(eqRecord.eq);
                            break;
                        case 3:
                            this.sb_eq3.setProgress(eqRecord.eq);
                            break;
                        case 4:
                            this.sb_eq4.setProgress(eqRecord.eq);
                            break;
                        case 5:
                            this.sb_eq5.setProgress(eqRecord.eq);
                            break;
                        case 6:
                            this.sb_eq6.setProgress(eqRecord.eq);
                            break;
                    }
                }
                if (!TextUtils.isEmpty(eqRecord.title)) {
                    switch (eqRecord.number) {
                        case 0:
                            this.tv_eq0.setText(eqRecord.title);
                            break;
                        case 1:
                            this.tv_eq1.setText(eqRecord.title);
                            break;
                        case 2:
                            this.tv_eq2.setText(eqRecord.title);
                            break;
                        case 3:
                            this.tv_eq3.setText(eqRecord.title);
                            break;
                        case 4:
                            this.tv_eq4.setText(eqRecord.title);
                            break;
                        case 5:
                            this.tv_eq5.setText(eqRecord.title);
                            break;
                        case 6:
                            this.tv_eq6.setText(eqRecord.title);
                            break;
                    }
                }
            }
        }
        refreshEqStyle(this.mBaseViewModel.getEqStyle());
    }

    private void refreshEqType(int i) {
        if (i == 0 || i == 8) {
            new EqDialog().show(getChildFragmentManager(), "EqDialog");
            dismiss();
            return;
        }
        if (i == 3 || i == 4 || i == 5 || i == 6) {
            new ChannelDialog().show(getChildFragmentManager(), "ChannelDialog");
            dismiss();
            return;
        }
        if (i == 7) {
            new TenEqDialog().show(getChildFragmentManager(), "TenEqDialog");
            dismiss();
            return;
        }
        if (i == 1) {
            this.rl_ifx1.setVisibility(0);
            this.rl_ifx2.setVisibility(0);
            this.ctv_jazz.setVisibility(0);
            this.ctv_country.setVisibility(0);
            return;
        }
        if (i == 2) {
            this.rl_ifx1.setVisibility(8);
            this.rl_ifx2.setVisibility(8);
            this.ctv_jazz.setVisibility(8);
            this.ctv_country.setVisibility(8);
        }
    }

    private void refreshDspIfx(int i) {
        if (i == 0) {
            this.ctv_ifx_off.setChecked(true);
            this.ctv_ifx_full_short.setChecked(false);
            this.ctv_ifx_mega_bass.setChecked(false);
            this.ctv_ifx_vocal.setChecked(false);
            this.ctv_ifx_virtual.setChecked(false);
            this.ctv_ifx_3d_rotary.setChecked(false);
            return;
        }
        if (i == 1) {
            this.ctv_ifx_off.setChecked(false);
            this.ctv_ifx_full_short.setChecked(true);
            this.ctv_ifx_mega_bass.setChecked(false);
            this.ctv_ifx_vocal.setChecked(false);
            this.ctv_ifx_virtual.setChecked(false);
            this.ctv_ifx_3d_rotary.setChecked(false);
            return;
        }
        if (i == 2) {
            this.ctv_ifx_off.setChecked(false);
            this.ctv_ifx_full_short.setChecked(false);
            this.ctv_ifx_mega_bass.setChecked(true);
            this.ctv_ifx_vocal.setChecked(false);
            this.ctv_ifx_virtual.setChecked(false);
            this.ctv_ifx_3d_rotary.setChecked(false);
            return;
        }
        if (i == 3) {
            this.ctv_ifx_off.setChecked(false);
            this.ctv_ifx_full_short.setChecked(false);
            this.ctv_ifx_mega_bass.setChecked(false);
            this.ctv_ifx_vocal.setChecked(true);
            this.ctv_ifx_virtual.setChecked(false);
            this.ctv_ifx_3d_rotary.setChecked(false);
            return;
        }
        if (i == 4) {
            this.ctv_ifx_off.setChecked(false);
            this.ctv_ifx_full_short.setChecked(false);
            this.ctv_ifx_mega_bass.setChecked(false);
            this.ctv_ifx_vocal.setChecked(false);
            this.ctv_ifx_virtual.setChecked(true);
            this.ctv_ifx_3d_rotary.setChecked(false);
            return;
        }
        if (i != 5) {
            return;
        }
        this.ctv_ifx_off.setChecked(false);
        this.ctv_ifx_full_short.setChecked(false);
        this.ctv_ifx_mega_bass.setChecked(false);
        this.ctv_ifx_vocal.setChecked(false);
        this.ctv_ifx_virtual.setChecked(false);
        this.ctv_ifx_3d_rotary.setChecked(true);
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
                this.sb_eq0.setEnabled(true);
                this.sb_eq1.setEnabled(true);
                this.sb_eq2.setEnabled(true);
                this.sb_eq3.setEnabled(true);
                this.sb_eq4.setEnabled(true);
                this.sb_eq5.setEnabled(true);
                this.sb_eq6.setEnabled(true);
                break;
            case 1:
                this.ctv_normal.setChecked(false);
                this.ctv_popular.setChecked(true);
                this.ctv_rock.setChecked(false);
                this.ctv_jazz.setChecked(false);
                this.ctv_classic.setChecked(false);
                this.ctv_country.setChecked(false);
                this.sb_eq0.setEnabled(false);
                this.sb_eq1.setEnabled(false);
                this.sb_eq2.setEnabled(false);
                this.sb_eq3.setEnabled(false);
                this.sb_eq4.setEnabled(false);
                this.sb_eq5.setEnabled(false);
                this.sb_eq6.setEnabled(false);
                break;
            case 2:
                this.ctv_normal.setChecked(false);
                this.ctv_popular.setChecked(false);
                this.ctv_rock.setChecked(true);
                this.ctv_jazz.setChecked(false);
                this.ctv_classic.setChecked(false);
                this.ctv_country.setChecked(false);
                this.sb_eq0.setEnabled(false);
                this.sb_eq1.setEnabled(false);
                this.sb_eq2.setEnabled(false);
                this.sb_eq3.setEnabled(false);
                this.sb_eq4.setEnabled(false);
                this.sb_eq5.setEnabled(false);
                this.sb_eq6.setEnabled(false);
                break;
            case 3:
                this.ctv_normal.setChecked(false);
                this.ctv_popular.setChecked(false);
                this.ctv_rock.setChecked(false);
                this.ctv_jazz.setChecked(true);
                this.ctv_classic.setChecked(false);
                this.ctv_country.setChecked(false);
                this.sb_eq0.setEnabled(false);
                this.sb_eq1.setEnabled(false);
                this.sb_eq2.setEnabled(false);
                this.sb_eq3.setEnabled(false);
                this.sb_eq4.setEnabled(false);
                this.sb_eq5.setEnabled(false);
                this.sb_eq6.setEnabled(false);
                break;
            case 4:
                this.ctv_normal.setChecked(false);
                this.ctv_popular.setChecked(false);
                this.ctv_rock.setChecked(false);
                this.ctv_jazz.setChecked(false);
                this.ctv_classic.setChecked(true);
                this.ctv_country.setChecked(false);
                this.sb_eq0.setEnabled(false);
                this.sb_eq1.setEnabled(false);
                this.sb_eq2.setEnabled(false);
                this.sb_eq3.setEnabled(false);
                this.sb_eq4.setEnabled(false);
                this.sb_eq5.setEnabled(false);
                this.sb_eq6.setEnabled(false);
                break;
            case 5:
                this.ctv_normal.setChecked(false);
                this.ctv_popular.setChecked(false);
                this.ctv_rock.setChecked(false);
                this.ctv_jazz.setChecked(false);
                this.ctv_classic.setChecked(false);
                this.ctv_country.setChecked(true);
                this.sb_eq0.setEnabled(false);
                this.sb_eq1.setEnabled(false);
                this.sb_eq2.setEnabled(false);
                this.sb_eq3.setEnabled(false);
                this.sb_eq4.setEnabled(false);
                this.sb_eq5.setEnabled(false);
                this.sb_eq6.setEnabled(false);
                break;
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0219  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void notice(java.lang.String r18, java.util.UUID r19, byte[] r20) {
        /*
            Method dump skipped, instructions count: 1030
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zddz.app.carlive.dialog.DspDialog.notice(java.lang.String, java.util.UUID, byte[]):void");
    }
}
