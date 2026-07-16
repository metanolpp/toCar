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
import android.widget.SeekBar;
import android.widget.TextView;
import com.zddz.app.carlive.OrderSet;
import com.zddz.app.carlive.database.EqRecord;
import com.zddz.app.carlive.fragment.BaseDialog;
import com.zddz.app.carlive.fragment.IMain;
import java.util.List;
import org.litepal.LitePal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class TenEqDialog extends BaseDialog {
    private CheckedTextView ctv_ten_eq_classic;
    private CheckedTextView ctv_ten_eq_country;
    private CheckedTextView ctv_ten_eq_custom;
    private CheckedTextView ctv_ten_eq_jazz;
    private CheckedTextView ctv_ten_eq_normal;
    private CheckedTextView ctv_ten_eq_pop;
    private CheckedTextView ctv_ten_eq_rock;
    private Handler mHandler;
    private SeekBar sb_eq0;
    private SeekBar sb_eq1;
    private SeekBar sb_eq10;
    private SeekBar sb_eq11;
    private SeekBar sb_eq2;
    private SeekBar sb_eq3;
    private SeekBar sb_eq4;
    private SeekBar sb_eq5;
    private SeekBar sb_eq6;
    private SeekBar sb_eq7;
    private SeekBar sb_eq8;
    private SeekBar sb_eq9;
    private TextView tv_eq0;
    private TextView tv_eq0_value;
    private TextView tv_eq1;
    private TextView tv_eq10;
    private TextView tv_eq10_value;
    private TextView tv_eq11;
    private TextView tv_eq11_value;
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
    private TextView tv_eq7;
    private TextView tv_eq7_value;
    private TextView tv_eq8;
    private TextView tv_eq8_value;
    private TextView tv_eq9;
    private TextView tv_eq9_value;
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
    private boolean mEQ7FromUser = false;
    private boolean mEQ7BarMove = false;
    private final Runnable mEQ7Runnable = new 9();
    private boolean mEQ8FromUser = false;
    private boolean mEQ8BarMove = false;
    private final Runnable mEQ8Runnable = new 10();
    private boolean mEQ10FromUser = false;
    private boolean mEQ10BarMove = false;
    private final Runnable mEQ10Runnable = new 11();
    private boolean mEQ11FromUser = false;
    private boolean mEQ11BarMove = false;
    private final Runnable mEQ11Runnable = new 12();
    private boolean mEQ9FromUser = false;
    private boolean mEQ9BarMove = false;
    private final Runnable mEQ9Runnable = new 13();
    private SeekBar.OnSeekBarChangeListener mOnSeekBarChangeListener = new 14();

    static /* synthetic */ IMain access$000(TenEqDialog tenEqDialog) {
        return tenEqDialog.mIMain;
    }

    static /* synthetic */ IMain access$100(TenEqDialog tenEqDialog) {
        return tenEqDialog.mIMain;
    }

    static /* synthetic */ SeekBar access$1000(TenEqDialog tenEqDialog) {
        return tenEqDialog.sb_eq0;
    }

    static /* synthetic */ IMain access$1100(TenEqDialog tenEqDialog) {
        return tenEqDialog.mIMain;
    }

    static /* synthetic */ Handler access$1200(TenEqDialog tenEqDialog) {
        return tenEqDialog.mHandler;
    }

    static /* synthetic */ boolean access$1300(TenEqDialog tenEqDialog) {
        return tenEqDialog.mEQ1BarMove;
    }

    static /* synthetic */ boolean access$1302(TenEqDialog tenEqDialog, boolean z) {
        tenEqDialog.mEQ1BarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$1400(TenEqDialog tenEqDialog) {
        return tenEqDialog.sb_eq1;
    }

    static /* synthetic */ IMain access$1500(TenEqDialog tenEqDialog) {
        return tenEqDialog.mIMain;
    }

    static /* synthetic */ boolean access$1600(TenEqDialog tenEqDialog) {
        return tenEqDialog.mEQ2BarMove;
    }

    static /* synthetic */ boolean access$1602(TenEqDialog tenEqDialog, boolean z) {
        tenEqDialog.mEQ2BarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$1700(TenEqDialog tenEqDialog) {
        return tenEqDialog.sb_eq2;
    }

    static /* synthetic */ IMain access$1800(TenEqDialog tenEqDialog) {
        return tenEqDialog.mIMain;
    }

    static /* synthetic */ boolean access$1900(TenEqDialog tenEqDialog) {
        return tenEqDialog.mEQ3BarMove;
    }

    static /* synthetic */ boolean access$1902(TenEqDialog tenEqDialog, boolean z) {
        tenEqDialog.mEQ3BarMove = z;
        return z;
    }

    static /* synthetic */ IMain access$200(TenEqDialog tenEqDialog) {
        return tenEqDialog.mIMain;
    }

    static /* synthetic */ SeekBar access$2000(TenEqDialog tenEqDialog) {
        return tenEqDialog.sb_eq3;
    }

    static /* synthetic */ IMain access$2100(TenEqDialog tenEqDialog) {
        return tenEqDialog.mIMain;
    }

    static /* synthetic */ boolean access$2200(TenEqDialog tenEqDialog) {
        return tenEqDialog.mEQ4BarMove;
    }

    static /* synthetic */ boolean access$2202(TenEqDialog tenEqDialog, boolean z) {
        tenEqDialog.mEQ4BarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$2300(TenEqDialog tenEqDialog) {
        return tenEqDialog.sb_eq4;
    }

    static /* synthetic */ IMain access$2400(TenEqDialog tenEqDialog) {
        return tenEqDialog.mIMain;
    }

    static /* synthetic */ boolean access$2500(TenEqDialog tenEqDialog) {
        return tenEqDialog.mEQ5BarMove;
    }

    static /* synthetic */ boolean access$2502(TenEqDialog tenEqDialog, boolean z) {
        tenEqDialog.mEQ5BarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$2600(TenEqDialog tenEqDialog) {
        return tenEqDialog.sb_eq5;
    }

    static /* synthetic */ IMain access$2700(TenEqDialog tenEqDialog) {
        return tenEqDialog.mIMain;
    }

    static /* synthetic */ boolean access$2800(TenEqDialog tenEqDialog) {
        return tenEqDialog.mEQ6BarMove;
    }

    static /* synthetic */ boolean access$2802(TenEqDialog tenEqDialog, boolean z) {
        tenEqDialog.mEQ6BarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$2900(TenEqDialog tenEqDialog) {
        return tenEqDialog.sb_eq6;
    }

    static /* synthetic */ IMain access$300(TenEqDialog tenEqDialog) {
        return tenEqDialog.mIMain;
    }

    static /* synthetic */ IMain access$3000(TenEqDialog tenEqDialog) {
        return tenEqDialog.mIMain;
    }

    static /* synthetic */ boolean access$3100(TenEqDialog tenEqDialog) {
        return tenEqDialog.mEQ7BarMove;
    }

    static /* synthetic */ boolean access$3102(TenEqDialog tenEqDialog, boolean z) {
        tenEqDialog.mEQ7BarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$3200(TenEqDialog tenEqDialog) {
        return tenEqDialog.sb_eq7;
    }

    static /* synthetic */ IMain access$3300(TenEqDialog tenEqDialog) {
        return tenEqDialog.mIMain;
    }

    static /* synthetic */ boolean access$3400(TenEqDialog tenEqDialog) {
        return tenEqDialog.mEQ8BarMove;
    }

    static /* synthetic */ boolean access$3402(TenEqDialog tenEqDialog, boolean z) {
        tenEqDialog.mEQ8BarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$3500(TenEqDialog tenEqDialog) {
        return tenEqDialog.sb_eq8;
    }

    static /* synthetic */ IMain access$3600(TenEqDialog tenEqDialog) {
        return tenEqDialog.mIMain;
    }

    static /* synthetic */ boolean access$3700(TenEqDialog tenEqDialog) {
        return tenEqDialog.mEQ10BarMove;
    }

    static /* synthetic */ boolean access$3702(TenEqDialog tenEqDialog, boolean z) {
        tenEqDialog.mEQ10BarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$3800(TenEqDialog tenEqDialog) {
        return tenEqDialog.sb_eq10;
    }

    static /* synthetic */ IMain access$3900(TenEqDialog tenEqDialog) {
        return tenEqDialog.mIMain;
    }

    static /* synthetic */ IMain access$400(TenEqDialog tenEqDialog) {
        return tenEqDialog.mIMain;
    }

    static /* synthetic */ boolean access$4000(TenEqDialog tenEqDialog) {
        return tenEqDialog.mEQ11BarMove;
    }

    static /* synthetic */ boolean access$4002(TenEqDialog tenEqDialog, boolean z) {
        tenEqDialog.mEQ11BarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$4100(TenEqDialog tenEqDialog) {
        return tenEqDialog.sb_eq11;
    }

    static /* synthetic */ IMain access$4200(TenEqDialog tenEqDialog) {
        return tenEqDialog.mIMain;
    }

    static /* synthetic */ SeekBar access$4300(TenEqDialog tenEqDialog) {
        return tenEqDialog.sb_eq9;
    }

    static /* synthetic */ IMain access$4400(TenEqDialog tenEqDialog) {
        return tenEqDialog.mIMain;
    }

    static /* synthetic */ boolean access$4502(TenEqDialog tenEqDialog, boolean z) {
        tenEqDialog.mEQ0FromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$4600(TenEqDialog tenEqDialog) {
        return tenEqDialog.tv_eq0_value;
    }

    static /* synthetic */ boolean access$4702(TenEqDialog tenEqDialog, boolean z) {
        tenEqDialog.mEQ1FromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$4800(TenEqDialog tenEqDialog) {
        return tenEqDialog.tv_eq1_value;
    }

    static /* synthetic */ boolean access$4902(TenEqDialog tenEqDialog, boolean z) {
        tenEqDialog.mEQ3FromUser = z;
        return z;
    }

    static /* synthetic */ IMain access$500(TenEqDialog tenEqDialog) {
        return tenEqDialog.mIMain;
    }

    static /* synthetic */ TextView access$5000(TenEqDialog tenEqDialog) {
        return tenEqDialog.tv_eq2_value;
    }

    static /* synthetic */ TextView access$5100(TenEqDialog tenEqDialog) {
        return tenEqDialog.tv_eq3_value;
    }

    static /* synthetic */ boolean access$5202(TenEqDialog tenEqDialog, boolean z) {
        tenEqDialog.mEQ4FromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$5300(TenEqDialog tenEqDialog) {
        return tenEqDialog.tv_eq4_value;
    }

    static /* synthetic */ boolean access$5402(TenEqDialog tenEqDialog, boolean z) {
        tenEqDialog.mEQ5FromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$5500(TenEqDialog tenEqDialog) {
        return tenEqDialog.tv_eq5_value;
    }

    static /* synthetic */ boolean access$5602(TenEqDialog tenEqDialog, boolean z) {
        tenEqDialog.mEQ6FromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$5700(TenEqDialog tenEqDialog) {
        return tenEqDialog.tv_eq6_value;
    }

    static /* synthetic */ boolean access$5802(TenEqDialog tenEqDialog, boolean z) {
        tenEqDialog.mEQ7FromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$5900(TenEqDialog tenEqDialog) {
        return tenEqDialog.tv_eq7_value;
    }

    static /* synthetic */ IMain access$600(TenEqDialog tenEqDialog) {
        return tenEqDialog.mIMain;
    }

    static /* synthetic */ boolean access$6002(TenEqDialog tenEqDialog, boolean z) {
        tenEqDialog.mEQ8FromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$6100(TenEqDialog tenEqDialog) {
        return tenEqDialog.tv_eq8_value;
    }

    static /* synthetic */ boolean access$6202(TenEqDialog tenEqDialog, boolean z) {
        tenEqDialog.mEQ9FromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$6300(TenEqDialog tenEqDialog) {
        return tenEqDialog.tv_eq9_value;
    }

    static /* synthetic */ boolean access$6402(TenEqDialog tenEqDialog, boolean z) {
        tenEqDialog.mEQ10FromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$6500(TenEqDialog tenEqDialog) {
        return tenEqDialog.tv_eq10_value;
    }

    static /* synthetic */ boolean access$6602(TenEqDialog tenEqDialog, boolean z) {
        tenEqDialog.mEQ11FromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$6700(TenEqDialog tenEqDialog) {
        return tenEqDialog.tv_eq11_value;
    }

    static /* synthetic */ Runnable access$6800(TenEqDialog tenEqDialog) {
        return tenEqDialog.mEQ0Runnable;
    }

    static /* synthetic */ Runnable access$6900(TenEqDialog tenEqDialog) {
        return tenEqDialog.mEQ1Runnable;
    }

    static /* synthetic */ IMain access$700(TenEqDialog tenEqDialog) {
        return tenEqDialog.mIMain;
    }

    static /* synthetic */ Runnable access$7000(TenEqDialog tenEqDialog) {
        return tenEqDialog.mEQ2Runnable;
    }

    static /* synthetic */ Runnable access$7100(TenEqDialog tenEqDialog) {
        return tenEqDialog.mEQ3Runnable;
    }

    static /* synthetic */ Runnable access$7200(TenEqDialog tenEqDialog) {
        return tenEqDialog.mEQ4Runnable;
    }

    static /* synthetic */ Runnable access$7300(TenEqDialog tenEqDialog) {
        return tenEqDialog.mEQ5Runnable;
    }

    static /* synthetic */ Runnable access$7400(TenEqDialog tenEqDialog) {
        return tenEqDialog.mEQ6Runnable;
    }

    static /* synthetic */ Runnable access$7500(TenEqDialog tenEqDialog) {
        return tenEqDialog.mEQ7Runnable;
    }

    static /* synthetic */ Runnable access$7600(TenEqDialog tenEqDialog) {
        return tenEqDialog.mEQ8Runnable;
    }

    static /* synthetic */ boolean access$7702(TenEqDialog tenEqDialog, boolean z) {
        tenEqDialog.mEQ9BarMove = z;
        return z;
    }

    static /* synthetic */ Runnable access$7800(TenEqDialog tenEqDialog) {
        return tenEqDialog.mEQ9Runnable;
    }

    static /* synthetic */ Runnable access$7900(TenEqDialog tenEqDialog) {
        return tenEqDialog.mEQ10Runnable;
    }

    static /* synthetic */ IMain access$800(TenEqDialog tenEqDialog) {
        return tenEqDialog.mIMain;
    }

    static /* synthetic */ Runnable access$8000(TenEqDialog tenEqDialog) {
        return tenEqDialog.mEQ11Runnable;
    }

    static /* synthetic */ IMain access$8100(TenEqDialog tenEqDialog) {
        return tenEqDialog.mIMain;
    }

    static /* synthetic */ IMain access$8200(TenEqDialog tenEqDialog) {
        return tenEqDialog.mIMain;
    }

    static /* synthetic */ IMain access$8300(TenEqDialog tenEqDialog) {
        return tenEqDialog.mIMain;
    }

    static /* synthetic */ IMain access$8400(TenEqDialog tenEqDialog) {
        return tenEqDialog.mIMain;
    }

    static /* synthetic */ IMain access$8500(TenEqDialog tenEqDialog) {
        return tenEqDialog.mIMain;
    }

    static /* synthetic */ IMain access$8600(TenEqDialog tenEqDialog) {
        return tenEqDialog.mIMain;
    }

    static /* synthetic */ IMain access$8700(TenEqDialog tenEqDialog) {
        return tenEqDialog.mIMain;
    }

    static /* synthetic */ IMain access$8800(TenEqDialog tenEqDialog) {
        return tenEqDialog.mIMain;
    }

    static /* synthetic */ IMain access$8900(TenEqDialog tenEqDialog) {
        return tenEqDialog.mIMain;
    }

    static /* synthetic */ boolean access$900(TenEqDialog tenEqDialog) {
        return tenEqDialog.mEQ0BarMove;
    }

    static /* synthetic */ IMain access$9000(TenEqDialog tenEqDialog) {
        return tenEqDialog.mIMain;
    }

    static /* synthetic */ boolean access$902(TenEqDialog tenEqDialog, boolean z) {
        tenEqDialog.mEQ0BarMove = z;
        return z;
    }

    static /* synthetic */ IMain access$9100(TenEqDialog tenEqDialog) {
        return tenEqDialog.mIMain;
    }

    static /* synthetic */ IMain access$9200(TenEqDialog tenEqDialog) {
        return tenEqDialog.mIMain;
    }

    class 1 implements View.OnClickListener {
        1() {
        }

        public void onClick(View view) {
            int id = view.getId();
            if (id == 2131297075) {
                TenEqDialog.this.dismiss();
                return;
            }
            if (id == 2131297086) {
                TenEqDialog.access$000(TenEqDialog.this).writeData(OrderSet.write_eq_reset);
                return;
            }
            if (id == 2131296364) {
                TenEqDialog.access$100(TenEqDialog.this).writeData(OrderSet.write_eq_save_user);
                return;
            }
            if (id == 2131296440) {
                TenEqDialog.access$200(TenEqDialog.this).writeData(OrderSet.write_eq_style_custom);
                return;
            }
            if (id == 2131296442) {
                TenEqDialog.access$300(TenEqDialog.this).writeData(OrderSet.write_eq_style_normal);
                return;
            }
            if (id == 2131296441) {
                TenEqDialog.access$400(TenEqDialog.this).writeData(OrderSet.write_eq_style_jazz);
                return;
            }
            if (id == 2131296443) {
                TenEqDialog.access$500(TenEqDialog.this).writeData(OrderSet.write_eq_style_popular);
                return;
            }
            if (id == 2131296438) {
                TenEqDialog.access$600(TenEqDialog.this).writeData(OrderSet.write_eq_style_classic);
            } else if (id == 2131296445) {
                TenEqDialog.access$700(TenEqDialog.this).writeData(OrderSet.write_eq_style_rock);
            } else if (id == 2131296439) {
                TenEqDialog.access$800(TenEqDialog.this).writeData(OrderSet.write_eq_style_country);
            }
        }
    }

    class 2 implements Runnable {
        2() {
        }

        public void run() {
            if (TenEqDialog.access$900(TenEqDialog.this)) {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 0;
                bArr[3] = (byte) TenEqDialog.access$1000(TenEqDialog.this).getProgress();
                TenEqDialog.access$1100(TenEqDialog.this).writeData(bArr);
                TenEqDialog.access$1200(TenEqDialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 3 implements Runnable {
        3() {
        }

        public void run() {
            if (TenEqDialog.access$1300(TenEqDialog.this)) {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 1;
                bArr[3] = (byte) TenEqDialog.access$1400(TenEqDialog.this).getProgress();
                TenEqDialog.access$1500(TenEqDialog.this).writeData(bArr);
                TenEqDialog.access$1200(TenEqDialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 4 implements Runnable {
        4() {
        }

        public void run() {
            if (TenEqDialog.access$1600(TenEqDialog.this)) {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 2;
                bArr[3] = (byte) TenEqDialog.access$1700(TenEqDialog.this).getProgress();
                TenEqDialog.access$1800(TenEqDialog.this).writeData(bArr);
                TenEqDialog.access$1200(TenEqDialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 5 implements Runnable {
        5() {
        }

        public void run() {
            if (TenEqDialog.access$1900(TenEqDialog.this)) {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 3;
                bArr[3] = (byte) TenEqDialog.access$2000(TenEqDialog.this).getProgress();
                TenEqDialog.access$2100(TenEqDialog.this).writeData(bArr);
                TenEqDialog.access$1200(TenEqDialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 6 implements Runnable {
        6() {
        }

        public void run() {
            if (TenEqDialog.access$2200(TenEqDialog.this)) {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 4;
                bArr[3] = (byte) TenEqDialog.access$2300(TenEqDialog.this).getProgress();
                TenEqDialog.access$2400(TenEqDialog.this).writeData(bArr);
                TenEqDialog.access$1200(TenEqDialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 7 implements Runnable {
        7() {
        }

        public void run() {
            if (TenEqDialog.access$2500(TenEqDialog.this)) {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 5;
                bArr[3] = (byte) TenEqDialog.access$2600(TenEqDialog.this).getProgress();
                TenEqDialog.access$2700(TenEqDialog.this).writeData(bArr);
                TenEqDialog.access$1200(TenEqDialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 8 implements Runnable {
        8() {
        }

        public void run() {
            if (TenEqDialog.access$2800(TenEqDialog.this)) {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 6;
                bArr[3] = (byte) TenEqDialog.access$2900(TenEqDialog.this).getProgress();
                TenEqDialog.access$3000(TenEqDialog.this).writeData(bArr);
                TenEqDialog.access$1200(TenEqDialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 9 implements Runnable {
        9() {
        }

        public void run() {
            if (TenEqDialog.access$3100(TenEqDialog.this)) {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 7;
                bArr[3] = (byte) TenEqDialog.access$3200(TenEqDialog.this).getProgress();
                TenEqDialog.access$3300(TenEqDialog.this).writeData(bArr);
                TenEqDialog.access$1200(TenEqDialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 10 implements Runnable {
        10() {
        }

        public void run() {
            if (TenEqDialog.access$3400(TenEqDialog.this)) {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 8;
                bArr[3] = (byte) TenEqDialog.access$3500(TenEqDialog.this).getProgress();
                TenEqDialog.access$3600(TenEqDialog.this).writeData(bArr);
                TenEqDialog.access$1200(TenEqDialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 11 implements Runnable {
        11() {
        }

        public void run() {
            if (TenEqDialog.access$3700(TenEqDialog.this)) {
                byte[] bArr = OrderSet.write_balance;
                bArr[2] = (byte) TenEqDialog.access$3800(TenEqDialog.this).getProgress();
                TenEqDialog.access$3900(TenEqDialog.this).writeData(bArr);
                TenEqDialog.access$1200(TenEqDialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 12 implements Runnable {
        12() {
        }

        public void run() {
            if (TenEqDialog.access$4000(TenEqDialog.this)) {
                byte[] bArr = OrderSet.write_fade;
                bArr[2] = (byte) TenEqDialog.access$4100(TenEqDialog.this).getProgress();
                TenEqDialog.access$4200(TenEqDialog.this).writeData(bArr);
                TenEqDialog.access$1200(TenEqDialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 13 implements Runnable {
        13() {
        }

        public void run() {
            if (TenEqDialog.access$2800(TenEqDialog.this)) {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 9;
                bArr[3] = (byte) TenEqDialog.access$4300(TenEqDialog.this).getProgress();
                TenEqDialog.access$4400(TenEqDialog.this).writeData(bArr);
                TenEqDialog.access$1200(TenEqDialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 14 implements SeekBar.OnSeekBarChangeListener {
        14() {
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            int progress = seekBar.getProgress();
            int id = seekBar.getId();
            if (id == 2131296753) {
                TenEqDialog.access$4502(TenEqDialog.this, z);
                TenEqDialog.access$4600(TenEqDialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296754) {
                TenEqDialog.access$4702(TenEqDialog.this, z);
                TenEqDialog.access$4800(TenEqDialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296755) {
                TenEqDialog.access$4902(TenEqDialog.this, z);
                TenEqDialog.access$5000(TenEqDialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296756) {
                TenEqDialog.access$4902(TenEqDialog.this, z);
                TenEqDialog.access$5100(TenEqDialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296757) {
                TenEqDialog.access$5202(TenEqDialog.this, z);
                TenEqDialog.access$5300(TenEqDialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296758) {
                TenEqDialog.access$5402(TenEqDialog.this, z);
                TenEqDialog.access$5500(TenEqDialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296759) {
                TenEqDialog.access$5602(TenEqDialog.this, z);
                TenEqDialog.access$5700(TenEqDialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296760) {
                TenEqDialog.access$5802(TenEqDialog.this, z);
                TenEqDialog.access$5900(TenEqDialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296761) {
                TenEqDialog.access$6002(TenEqDialog.this, z);
                TenEqDialog.access$6100(TenEqDialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296762) {
                TenEqDialog.access$6202(TenEqDialog.this, z);
                TenEqDialog.access$6300(TenEqDialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296763) {
                TenEqDialog.access$6402(TenEqDialog.this, z);
                TenEqDialog.access$6500(TenEqDialog.this).setText("R" + String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296766) {
                TenEqDialog.access$6602(TenEqDialog.this, z);
                TenEqDialog.access$6700(TenEqDialog.this).setText("F" + String.valueOf(progress - 7));
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            int id = seekBar.getId();
            if (id == 2131296753) {
                TenEqDialog.access$902(TenEqDialog.this, true);
                TenEqDialog.access$1200(TenEqDialog.this).postDelayed(TenEqDialog.access$6800(TenEqDialog.this), 200L);
                return;
            }
            if (id == 2131296754) {
                TenEqDialog.access$1302(TenEqDialog.this, true);
                TenEqDialog.access$1200(TenEqDialog.this).postDelayed(TenEqDialog.access$6900(TenEqDialog.this), 200L);
                return;
            }
            if (id == 2131296755) {
                TenEqDialog.access$1602(TenEqDialog.this, true);
                TenEqDialog.access$1200(TenEqDialog.this).postDelayed(TenEqDialog.access$7000(TenEqDialog.this), 200L);
                return;
            }
            if (id == 2131296756) {
                TenEqDialog.access$1902(TenEqDialog.this, true);
                TenEqDialog.access$1200(TenEqDialog.this).postDelayed(TenEqDialog.access$7100(TenEqDialog.this), 200L);
                return;
            }
            if (id == 2131296757) {
                TenEqDialog.access$2202(TenEqDialog.this, false);
                TenEqDialog.access$1200(TenEqDialog.this).postDelayed(TenEqDialog.access$7200(TenEqDialog.this), 200L);
                return;
            }
            if (id == 2131296758) {
                TenEqDialog.access$2502(TenEqDialog.this, true);
                TenEqDialog.access$1200(TenEqDialog.this).postDelayed(TenEqDialog.access$7300(TenEqDialog.this), 200L);
                return;
            }
            if (id == 2131296759) {
                TenEqDialog.access$2802(TenEqDialog.this, true);
                TenEqDialog.access$1200(TenEqDialog.this).postDelayed(TenEqDialog.access$7400(TenEqDialog.this), 200L);
                return;
            }
            if (id == 2131296760) {
                TenEqDialog.access$3102(TenEqDialog.this, true);
                TenEqDialog.access$1200(TenEqDialog.this).postDelayed(TenEqDialog.access$7500(TenEqDialog.this), 200L);
                return;
            }
            if (id == 2131296761) {
                TenEqDialog.access$3402(TenEqDialog.this, true);
                TenEqDialog.access$1200(TenEqDialog.this).postDelayed(TenEqDialog.access$7600(TenEqDialog.this), 200L);
                return;
            }
            if (id == 2131296762) {
                TenEqDialog.access$7702(TenEqDialog.this, true);
                TenEqDialog.access$1200(TenEqDialog.this).postDelayed(TenEqDialog.access$7800(TenEqDialog.this), 200L);
            } else if (id == 2131296763) {
                TenEqDialog.access$3702(TenEqDialog.this, true);
                TenEqDialog.access$1200(TenEqDialog.this).postDelayed(TenEqDialog.access$7900(TenEqDialog.this), 200L);
            } else if (id == 2131296766) {
                TenEqDialog.access$4002(TenEqDialog.this, true);
                TenEqDialog.access$1200(TenEqDialog.this).postDelayed(TenEqDialog.access$8000(TenEqDialog.this), 200L);
            }
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            int id = seekBar.getId();
            if (id == 2131296753) {
                TenEqDialog.access$902(TenEqDialog.this, false);
                try {
                    TenEqDialog.access$1200(TenEqDialog.this).removeCallbacks(TenEqDialog.access$6800(TenEqDialog.this));
                    TenEqDialog.access$1200(TenEqDialog.this).postDelayed(new 1(), 300L);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            if (id == 2131296754) {
                TenEqDialog.access$1302(TenEqDialog.this, false);
                try {
                    TenEqDialog.access$1200(TenEqDialog.this).removeCallbacks(TenEqDialog.access$6900(TenEqDialog.this));
                    TenEqDialog.access$1200(TenEqDialog.this).postDelayed(new 2(), 300L);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (id == 2131296755) {
                TenEqDialog.access$1602(TenEqDialog.this, false);
                try {
                    TenEqDialog.access$1200(TenEqDialog.this).removeCallbacks(TenEqDialog.access$7000(TenEqDialog.this));
                    TenEqDialog.access$1200(TenEqDialog.this).postDelayed(new 3(), 300L);
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            if (id == 2131296756) {
                TenEqDialog.access$1902(TenEqDialog.this, false);
                try {
                    TenEqDialog.access$1200(TenEqDialog.this).removeCallbacks(TenEqDialog.access$7100(TenEqDialog.this));
                    TenEqDialog.access$1200(TenEqDialog.this).postDelayed(new 4(), 300L);
                    return;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
            }
            if (id == 2131296757) {
                TenEqDialog.access$2202(TenEqDialog.this, false);
                try {
                    TenEqDialog.access$1200(TenEqDialog.this).removeCallbacks(TenEqDialog.access$7200(TenEqDialog.this));
                    TenEqDialog.access$1200(TenEqDialog.this).postDelayed(new 5(), 300L);
                    return;
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return;
                }
            }
            if (id == 2131296758) {
                TenEqDialog.access$2502(TenEqDialog.this, false);
                try {
                    TenEqDialog.access$1200(TenEqDialog.this).removeCallbacks(TenEqDialog.access$7300(TenEqDialog.this));
                    TenEqDialog.access$1200(TenEqDialog.this).postDelayed(new 6(), 300L);
                    return;
                } catch (Exception e6) {
                    e6.printStackTrace();
                    return;
                }
            }
            if (id == 2131296759) {
                TenEqDialog.access$2802(TenEqDialog.this, false);
                try {
                    TenEqDialog.access$1200(TenEqDialog.this).removeCallbacks(TenEqDialog.access$7400(TenEqDialog.this));
                    TenEqDialog.access$1200(TenEqDialog.this).postDelayed(new 7(), 300L);
                    return;
                } catch (Exception e7) {
                    e7.printStackTrace();
                    return;
                }
            }
            if (id == 2131296760) {
                TenEqDialog.access$3102(TenEqDialog.this, false);
                try {
                    TenEqDialog.access$1200(TenEqDialog.this).removeCallbacks(TenEqDialog.access$7500(TenEqDialog.this));
                    TenEqDialog.access$1200(TenEqDialog.this).postDelayed(new 8(), 300L);
                    return;
                } catch (Exception e8) {
                    e8.printStackTrace();
                    return;
                }
            }
            if (id == 2131296761) {
                TenEqDialog.access$3402(TenEqDialog.this, false);
                try {
                    TenEqDialog.access$1200(TenEqDialog.this).removeCallbacks(TenEqDialog.access$7600(TenEqDialog.this));
                    TenEqDialog.access$1200(TenEqDialog.this).postDelayed(new 9(), 300L);
                    return;
                } catch (Exception e9) {
                    e9.printStackTrace();
                    return;
                }
            }
            if (id == 2131296762) {
                TenEqDialog.access$7702(TenEqDialog.this, false);
                try {
                    TenEqDialog.access$1200(TenEqDialog.this).removeCallbacks(TenEqDialog.access$7800(TenEqDialog.this));
                    TenEqDialog.access$1200(TenEqDialog.this).postDelayed(new 10(), 300L);
                    return;
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return;
                }
            }
            if (id == 2131296763) {
                TenEqDialog.access$3702(TenEqDialog.this, false);
                try {
                    TenEqDialog.access$1200(TenEqDialog.this).removeCallbacks(TenEqDialog.access$7900(TenEqDialog.this));
                    TenEqDialog.access$1200(TenEqDialog.this).postDelayed(new 11(), 300L);
                    return;
                } catch (Exception e11) {
                    e11.printStackTrace();
                    return;
                }
            }
            if (id == 2131296766) {
                TenEqDialog.access$4002(TenEqDialog.this, false);
                try {
                    TenEqDialog.access$1200(TenEqDialog.this).removeCallbacks(TenEqDialog.access$8000(TenEqDialog.this));
                    TenEqDialog.access$1200(TenEqDialog.this).postDelayed(new 12(), 300L);
                } catch (Exception e12) {
                    e12.printStackTrace();
                }
            }
        }

        class 1 implements Runnable {
            1() {
            }

            public void run() {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 0;
                bArr[3] = (byte) TenEqDialog.access$1000(TenEqDialog.this).getProgress();
                TenEqDialog.access$8100(TenEqDialog.this).writeData(bArr);
            }
        }

        class 2 implements Runnable {
            2() {
            }

            public void run() {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 1;
                bArr[3] = (byte) TenEqDialog.access$1400(TenEqDialog.this).getProgress();
                TenEqDialog.access$8200(TenEqDialog.this).writeData(bArr);
            }
        }

        class 3 implements Runnable {
            3() {
            }

            public void run() {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 2;
                bArr[3] = (byte) TenEqDialog.access$1700(TenEqDialog.this).getProgress();
                TenEqDialog.access$8300(TenEqDialog.this).writeData(bArr);
            }
        }

        class 4 implements Runnable {
            4() {
            }

            public void run() {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 3;
                bArr[3] = (byte) TenEqDialog.access$2000(TenEqDialog.this).getProgress();
                TenEqDialog.access$8400(TenEqDialog.this).writeData(bArr);
            }
        }

        class 5 implements Runnable {
            5() {
            }

            public void run() {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 4;
                bArr[3] = (byte) TenEqDialog.access$2300(TenEqDialog.this).getProgress();
                TenEqDialog.access$8500(TenEqDialog.this).writeData(bArr);
            }
        }

        class 6 implements Runnable {
            6() {
            }

            public void run() {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 5;
                bArr[3] = (byte) TenEqDialog.access$2600(TenEqDialog.this).getProgress();
                TenEqDialog.access$8600(TenEqDialog.this).writeData(bArr);
            }
        }

        class 7 implements Runnable {
            7() {
            }

            public void run() {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 6;
                bArr[3] = (byte) TenEqDialog.access$2900(TenEqDialog.this).getProgress();
                TenEqDialog.access$8700(TenEqDialog.this).writeData(bArr);
            }
        }

        class 8 implements Runnable {
            8() {
            }

            public void run() {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 7;
                bArr[3] = (byte) TenEqDialog.access$3200(TenEqDialog.this).getProgress();
                TenEqDialog.access$8800(TenEqDialog.this).writeData(bArr);
            }
        }

        class 9 implements Runnable {
            9() {
            }

            public void run() {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 8;
                bArr[3] = (byte) TenEqDialog.access$3500(TenEqDialog.this).getProgress();
                TenEqDialog.access$8900(TenEqDialog.this).writeData(bArr);
            }
        }

        class 10 implements Runnable {
            10() {
            }

            public void run() {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 9;
                bArr[3] = (byte) TenEqDialog.access$4300(TenEqDialog.this).getProgress();
                TenEqDialog.access$9000(TenEqDialog.this).writeData(bArr);
            }
        }

        class 11 implements Runnable {
            11() {
            }

            public void run() {
                byte[] bArr = OrderSet.write_balance;
                bArr[2] = (byte) TenEqDialog.access$3800(TenEqDialog.this).getProgress();
                TenEqDialog.access$9100(TenEqDialog.this).writeData(bArr);
            }
        }

        class 12 implements Runnable {
            12() {
            }

            public void run() {
                byte[] bArr = OrderSet.write_fade;
                bArr[2] = (byte) TenEqDialog.access$4100(TenEqDialog.this).getProgress();
                TenEqDialog.access$9200(TenEqDialog.this).writeData(bArr);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(2131492930, viewGroup, false);
        return this.mRootView;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mHandler = new Handler(Looper.myLooper());
        this.mRootView.findViewById(2131297075).setOnClickListener(this.mOnClickListener);
        this.mRootView.findViewById(2131297086).setOnClickListener(this.mOnClickListener);
        this.mRootView.findViewById(2131296364).setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById = this.mRootView.findViewById(2131296442);
        this.ctv_ten_eq_normal = findViewById;
        findViewById.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById2 = this.mRootView.findViewById(2131296441);
        this.ctv_ten_eq_jazz = findViewById2;
        findViewById2.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById3 = this.mRootView.findViewById(2131296443);
        this.ctv_ten_eq_pop = findViewById3;
        findViewById3.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById4 = this.mRootView.findViewById(2131296438);
        this.ctv_ten_eq_classic = findViewById4;
        findViewById4.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById5 = this.mRootView.findViewById(2131296445);
        this.ctv_ten_eq_rock = findViewById5;
        findViewById5.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById6 = this.mRootView.findViewById(2131296439);
        this.ctv_ten_eq_country = findViewById6;
        findViewById6.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById7 = this.mRootView.findViewById(2131296440);
        this.ctv_ten_eq_custom = findViewById7;
        findViewById7.setOnClickListener(this.mOnClickListener);
        SeekBar findViewById8 = this.mRootView.findViewById(2131296753);
        this.sb_eq0 = findViewById8;
        findViewById8.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById9 = this.mRootView.findViewById(2131296754);
        this.sb_eq1 = findViewById9;
        findViewById9.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById10 = this.mRootView.findViewById(2131296755);
        this.sb_eq2 = findViewById10;
        findViewById10.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById11 = this.mRootView.findViewById(2131296756);
        this.sb_eq3 = findViewById11;
        findViewById11.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById12 = this.mRootView.findViewById(2131296757);
        this.sb_eq4 = findViewById12;
        findViewById12.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById13 = this.mRootView.findViewById(2131296758);
        this.sb_eq5 = findViewById13;
        findViewById13.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById14 = this.mRootView.findViewById(2131296759);
        this.sb_eq6 = findViewById14;
        findViewById14.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById15 = this.mRootView.findViewById(2131296760);
        this.sb_eq7 = findViewById15;
        findViewById15.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById16 = this.mRootView.findViewById(2131296761);
        this.sb_eq8 = findViewById16;
        findViewById16.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById17 = this.mRootView.findViewById(2131296762);
        this.sb_eq9 = findViewById17;
        findViewById17.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById18 = this.mRootView.findViewById(2131296763);
        this.sb_eq10 = findViewById18;
        findViewById18.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById19 = this.mRootView.findViewById(2131296766);
        this.sb_eq11 = findViewById19;
        findViewById19.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        this.tv_eq0 = this.mRootView.findViewById(2131296934);
        this.tv_eq1 = this.mRootView.findViewById(2131296936);
        this.tv_eq2 = this.mRootView.findViewById(2131296938);
        this.tv_eq3 = this.mRootView.findViewById(2131296940);
        this.tv_eq4 = this.mRootView.findViewById(2131296942);
        this.tv_eq5 = this.mRootView.findViewById(2131296944);
        this.tv_eq6 = this.mRootView.findViewById(2131296946);
        this.tv_eq7 = this.mRootView.findViewById(2131296948);
        this.tv_eq8 = this.mRootView.findViewById(2131296950);
        this.tv_eq9 = this.mRootView.findViewById(2131296952);
        this.tv_eq10 = this.mRootView.findViewById(2131296954);
        this.tv_eq11 = this.mRootView.findViewById(2131296959);
        this.tv_eq0_value = this.mRootView.findViewById(2131296935);
        this.tv_eq1_value = this.mRootView.findViewById(2131296937);
        this.tv_eq2_value = this.mRootView.findViewById(2131296939);
        this.tv_eq3_value = this.mRootView.findViewById(2131296941);
        this.tv_eq4_value = this.mRootView.findViewById(2131296943);
        this.tv_eq5_value = this.mRootView.findViewById(2131296945);
        this.tv_eq6_value = this.mRootView.findViewById(2131296947);
        this.tv_eq7_value = this.mRootView.findViewById(2131296949);
        this.tv_eq8_value = this.mRootView.findViewById(2131296951);
        this.tv_eq9_value = this.mRootView.findViewById(2131296953);
        this.tv_eq10_value = this.mRootView.findViewById(2131296960);
        this.tv_eq11_value = this.mRootView.findViewById(2131296965);
        refreshEqType(this.mBaseViewModel.getEqType());
        List<EqRecord> find = LitePal.limit(10).find(EqRecord.class);
        if (find.size() == 10) {
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
                        case 7:
                            this.sb_eq7.setProgress(eqRecord.eq);
                            break;
                        case 8:
                            this.sb_eq8.setProgress(eqRecord.eq);
                            break;
                        case 9:
                            this.sb_eq9.setProgress(eqRecord.eq);
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
                        case 7:
                            this.tv_eq7.setText(eqRecord.title);
                            break;
                        case 8:
                            this.tv_eq8.setText(eqRecord.title);
                            break;
                        case 9:
                            this.tv_eq9.setText(eqRecord.title);
                            break;
                    }
                }
            }
        }
        setBlaAndFad();
        refreshEqStyle(this.mBaseViewModel.getEqStyle());
    }

    private void setBlaAndFad() {
        this.sb_eq11.setProgress(this.mBaseViewModel.getFade());
        this.sb_eq10.setProgress(this.mBaseViewModel.getBalance());
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

    private void refreshEqType(int i) {
        if (i == 0 || i == 8) {
            new EqDialog().show(getChildFragmentManager(), "EqDialog");
            dismiss();
            return;
        }
        if (i == 1 || i == 2) {
            new DspDialog().show(getChildFragmentManager(), "DspDialog");
            dismiss();
        } else if (i == 3 || i == 4 || i == 5 || i == 6) {
            new ChannelDialog().show(getChildFragmentManager(), "ChannelDialog");
            dismiss();
        }
    }

    private void refreshEqStyle(int i) {
        switch (i) {
            case 0:
                this.ctv_ten_eq_normal.setChecked(true);
                this.ctv_ten_eq_pop.setChecked(false);
                this.ctv_ten_eq_rock.setChecked(false);
                this.ctv_ten_eq_jazz.setChecked(false);
                this.ctv_ten_eq_classic.setChecked(false);
                this.ctv_ten_eq_country.setChecked(false);
                this.ctv_ten_eq_custom.setChecked(false);
                break;
            case 1:
                this.ctv_ten_eq_normal.setChecked(false);
                this.ctv_ten_eq_pop.setChecked(true);
                this.ctv_ten_eq_rock.setChecked(false);
                this.ctv_ten_eq_jazz.setChecked(false);
                this.ctv_ten_eq_classic.setChecked(false);
                this.ctv_ten_eq_country.setChecked(false);
                this.ctv_ten_eq_custom.setChecked(false);
                break;
            case 2:
                this.ctv_ten_eq_normal.setChecked(false);
                this.ctv_ten_eq_pop.setChecked(false);
                this.ctv_ten_eq_rock.setChecked(true);
                this.ctv_ten_eq_jazz.setChecked(false);
                this.ctv_ten_eq_classic.setChecked(false);
                this.ctv_ten_eq_country.setChecked(false);
                this.ctv_ten_eq_custom.setChecked(false);
                break;
            case 3:
                this.ctv_ten_eq_normal.setChecked(false);
                this.ctv_ten_eq_pop.setChecked(false);
                this.ctv_ten_eq_rock.setChecked(false);
                this.ctv_ten_eq_jazz.setChecked(true);
                this.ctv_ten_eq_classic.setChecked(false);
                this.ctv_ten_eq_country.setChecked(false);
                this.ctv_ten_eq_custom.setChecked(false);
                break;
            case 4:
                this.ctv_ten_eq_normal.setChecked(false);
                this.ctv_ten_eq_pop.setChecked(false);
                this.ctv_ten_eq_rock.setChecked(false);
                this.ctv_ten_eq_jazz.setChecked(false);
                this.ctv_ten_eq_classic.setChecked(true);
                this.ctv_ten_eq_country.setChecked(false);
                this.ctv_ten_eq_custom.setChecked(false);
                break;
            case 5:
                this.ctv_ten_eq_normal.setChecked(false);
                this.ctv_ten_eq_pop.setChecked(false);
                this.ctv_ten_eq_rock.setChecked(false);
                this.ctv_ten_eq_jazz.setChecked(false);
                this.ctv_ten_eq_classic.setChecked(false);
                this.ctv_ten_eq_country.setChecked(true);
                this.ctv_ten_eq_custom.setChecked(false);
                break;
            case 6:
                this.ctv_ten_eq_normal.setChecked(false);
                this.ctv_ten_eq_pop.setChecked(false);
                this.ctv_ten_eq_rock.setChecked(false);
                this.ctv_ten_eq_jazz.setChecked(false);
                this.ctv_ten_eq_classic.setChecked(false);
                this.ctv_ten_eq_country.setChecked(false);
                this.ctv_ten_eq_custom.setChecked(true);
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:201:0x039a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void notice(java.lang.String r17, java.util.UUID r18, byte[] r19) {
        /*
            Method dump skipped, instructions count: 1822
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zddz.app.carlive.dialog.TenEqDialog.notice(java.lang.String, java.util.UUID, byte[]):void");
    }
}
