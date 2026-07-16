package com.zddz.app.carlive.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
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
public class TenEqSpecial1Dialog extends BaseDialog {
    private CheckedTextView ctv_ten_eq_classic;
    private CheckedTextView ctv_ten_eq_country;
    private CheckedTextView ctv_ten_eq_custom;
    private CheckedTextView ctv_ten_eq_jazz;
    private CheckedTextView ctv_ten_eq_normal;
    private CheckedTextView ctv_ten_eq_pop;
    private CheckedTextView ctv_ten_eq_roc;
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
    TextView tv_tbe1;
    TextView tv_tbe2;
    TextView tv_tbe3;
    TextView tv_tbe_off;
    View view_maskeq_0;
    View view_maskeq_1;
    View view_maskeq_2;
    View view_maskeq_3;
    View view_maskeq_4;
    View view_maskeq_5;
    View view_maskeq_6;
    private int TBE_OFF = 0;
    private int TBE_1 = 1;
    private int TBE_2 = 2;
    private int TBE_3 = 3;
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
    int mCuEqChoose = 0;

    private void refreshEqType(int i) {
    }

    private void setEqMaskShow(Boolean bool) {
    }

    static /* synthetic */ int access$000(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.TBE_OFF;
    }

    static /* synthetic */ void access$100(TenEqSpecial1Dialog tenEqSpecial1Dialog, int i) {
        tenEqSpecial1Dialog.sendTBEData(i);
    }

    static /* synthetic */ IMain access$1000(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mIMain;
    }

    static /* synthetic */ IMain access$10000(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mIMain;
    }

    static /* synthetic */ IMain access$1100(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mIMain;
    }

    static /* synthetic */ IMain access$1200(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mIMain;
    }

    static /* synthetic */ IMain access$1300(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mIMain;
    }

    static /* synthetic */ IMain access$1400(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mIMain;
    }

    static /* synthetic */ boolean access$1500(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mEQ0BarMove;
    }

    static /* synthetic */ boolean access$1502(TenEqSpecial1Dialog tenEqSpecial1Dialog, boolean z) {
        tenEqSpecial1Dialog.mEQ0BarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$1600(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.sb_eq0;
    }

    static /* synthetic */ IMain access$1700(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mIMain;
    }

    static /* synthetic */ Handler access$1800(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mHandler;
    }

    static /* synthetic */ boolean access$1900(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mEQ1BarMove;
    }

    static /* synthetic */ boolean access$1902(TenEqSpecial1Dialog tenEqSpecial1Dialog, boolean z) {
        tenEqSpecial1Dialog.mEQ1BarMove = z;
        return z;
    }

    static /* synthetic */ int access$200(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.TBE_1;
    }

    static /* synthetic */ SeekBar access$2000(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.sb_eq1;
    }

    static /* synthetic */ IMain access$2100(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mIMain;
    }

    static /* synthetic */ boolean access$2200(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mEQ2BarMove;
    }

    static /* synthetic */ boolean access$2202(TenEqSpecial1Dialog tenEqSpecial1Dialog, boolean z) {
        tenEqSpecial1Dialog.mEQ2BarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$2300(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.sb_eq2;
    }

    static /* synthetic */ IMain access$2400(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mIMain;
    }

    static /* synthetic */ boolean access$2500(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mEQ3BarMove;
    }

    static /* synthetic */ boolean access$2502(TenEqSpecial1Dialog tenEqSpecial1Dialog, boolean z) {
        tenEqSpecial1Dialog.mEQ3BarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$2600(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.sb_eq3;
    }

    static /* synthetic */ IMain access$2700(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mIMain;
    }

    static /* synthetic */ boolean access$2800(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mEQ4BarMove;
    }

    static /* synthetic */ boolean access$2802(TenEqSpecial1Dialog tenEqSpecial1Dialog, boolean z) {
        tenEqSpecial1Dialog.mEQ4BarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$2900(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.sb_eq4;
    }

    static /* synthetic */ int access$300(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.TBE_2;
    }

    static /* synthetic */ IMain access$3000(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mIMain;
    }

    static /* synthetic */ boolean access$3100(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mEQ5BarMove;
    }

    static /* synthetic */ boolean access$3102(TenEqSpecial1Dialog tenEqSpecial1Dialog, boolean z) {
        tenEqSpecial1Dialog.mEQ5BarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$3200(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.sb_eq5;
    }

    static /* synthetic */ IMain access$3300(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mIMain;
    }

    static /* synthetic */ boolean access$3400(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mEQ6BarMove;
    }

    static /* synthetic */ boolean access$3402(TenEqSpecial1Dialog tenEqSpecial1Dialog, boolean z) {
        tenEqSpecial1Dialog.mEQ6BarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$3500(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.sb_eq6;
    }

    static /* synthetic */ IMain access$3600(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mIMain;
    }

    static /* synthetic */ boolean access$3700(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mEQ7BarMove;
    }

    static /* synthetic */ boolean access$3702(TenEqSpecial1Dialog tenEqSpecial1Dialog, boolean z) {
        tenEqSpecial1Dialog.mEQ7BarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$3800(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.sb_eq7;
    }

    static /* synthetic */ IMain access$3900(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mIMain;
    }

    static /* synthetic */ int access$400(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.TBE_3;
    }

    static /* synthetic */ boolean access$4000(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mEQ8BarMove;
    }

    static /* synthetic */ boolean access$4002(TenEqSpecial1Dialog tenEqSpecial1Dialog, boolean z) {
        tenEqSpecial1Dialog.mEQ8BarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$4100(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.sb_eq8;
    }

    static /* synthetic */ IMain access$4200(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mIMain;
    }

    static /* synthetic */ boolean access$4300(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mEQ10BarMove;
    }

    static /* synthetic */ boolean access$4302(TenEqSpecial1Dialog tenEqSpecial1Dialog, boolean z) {
        tenEqSpecial1Dialog.mEQ10BarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$4400(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.sb_eq10;
    }

    static /* synthetic */ IMain access$4500(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mIMain;
    }

    static /* synthetic */ boolean access$4600(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mEQ11BarMove;
    }

    static /* synthetic */ boolean access$4602(TenEqSpecial1Dialog tenEqSpecial1Dialog, boolean z) {
        tenEqSpecial1Dialog.mEQ11BarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$4700(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.sb_eq11;
    }

    static /* synthetic */ IMain access$4800(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mIMain;
    }

    static /* synthetic */ SeekBar access$4900(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.sb_eq9;
    }

    static /* synthetic */ IMain access$500(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mIMain;
    }

    static /* synthetic */ IMain access$5000(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mIMain;
    }

    static /* synthetic */ boolean access$5102(TenEqSpecial1Dialog tenEqSpecial1Dialog, boolean z) {
        tenEqSpecial1Dialog.mEQ0FromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$5200(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.tv_eq0_value;
    }

    static /* synthetic */ boolean access$5302(TenEqSpecial1Dialog tenEqSpecial1Dialog, boolean z) {
        tenEqSpecial1Dialog.mEQ1FromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$5400(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.tv_eq1_value;
    }

    static /* synthetic */ boolean access$5502(TenEqSpecial1Dialog tenEqSpecial1Dialog, boolean z) {
        tenEqSpecial1Dialog.mEQ3FromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$5600(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.tv_eq2_value;
    }

    static /* synthetic */ TextView access$5700(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.tv_eq3_value;
    }

    static /* synthetic */ boolean access$5802(TenEqSpecial1Dialog tenEqSpecial1Dialog, boolean z) {
        tenEqSpecial1Dialog.mEQ4FromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$5900(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.tv_eq4_value;
    }

    static /* synthetic */ IMain access$600(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mIMain;
    }

    static /* synthetic */ boolean access$6002(TenEqSpecial1Dialog tenEqSpecial1Dialog, boolean z) {
        tenEqSpecial1Dialog.mEQ5FromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$6100(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.tv_eq5_value;
    }

    static /* synthetic */ boolean access$6202(TenEqSpecial1Dialog tenEqSpecial1Dialog, boolean z) {
        tenEqSpecial1Dialog.mEQ6FromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$6300(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.tv_eq6_value;
    }

    static /* synthetic */ boolean access$6402(TenEqSpecial1Dialog tenEqSpecial1Dialog, boolean z) {
        tenEqSpecial1Dialog.mEQ7FromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$6500(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.tv_eq7_value;
    }

    static /* synthetic */ boolean access$6602(TenEqSpecial1Dialog tenEqSpecial1Dialog, boolean z) {
        tenEqSpecial1Dialog.mEQ8FromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$6700(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.tv_eq8_value;
    }

    static /* synthetic */ boolean access$6802(TenEqSpecial1Dialog tenEqSpecial1Dialog, boolean z) {
        tenEqSpecial1Dialog.mEQ9FromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$6900(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.tv_eq9_value;
    }

    static /* synthetic */ IMain access$700(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mIMain;
    }

    static /* synthetic */ boolean access$7002(TenEqSpecial1Dialog tenEqSpecial1Dialog, boolean z) {
        tenEqSpecial1Dialog.mEQ10FromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$7100(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.tv_eq10_value;
    }

    static /* synthetic */ boolean access$7202(TenEqSpecial1Dialog tenEqSpecial1Dialog, boolean z) {
        tenEqSpecial1Dialog.mEQ11FromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$7300(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.tv_eq11_value;
    }

    static /* synthetic */ Runnable access$7400(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mEQ0Runnable;
    }

    static /* synthetic */ Runnable access$7500(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mEQ1Runnable;
    }

    static /* synthetic */ Runnable access$7600(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mEQ2Runnable;
    }

    static /* synthetic */ Runnable access$7700(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mEQ3Runnable;
    }

    static /* synthetic */ Runnable access$7800(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mEQ4Runnable;
    }

    static /* synthetic */ Runnable access$7900(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mEQ5Runnable;
    }

    static /* synthetic */ IMain access$800(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mIMain;
    }

    static /* synthetic */ Runnable access$8000(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mEQ6Runnable;
    }

    static /* synthetic */ Runnable access$8100(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mEQ7Runnable;
    }

    static /* synthetic */ Runnable access$8200(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mEQ8Runnable;
    }

    static /* synthetic */ boolean access$8302(TenEqSpecial1Dialog tenEqSpecial1Dialog, boolean z) {
        tenEqSpecial1Dialog.mEQ9BarMove = z;
        return z;
    }

    static /* synthetic */ Runnable access$8400(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mEQ9Runnable;
    }

    static /* synthetic */ Runnable access$8500(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mEQ10Runnable;
    }

    static /* synthetic */ Runnable access$8600(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mEQ11Runnable;
    }

    static /* synthetic */ IMain access$8700(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mIMain;
    }

    static /* synthetic */ IMain access$8800(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mIMain;
    }

    static /* synthetic */ IMain access$8900(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mIMain;
    }

    static /* synthetic */ IMain access$900(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mIMain;
    }

    static /* synthetic */ IMain access$9000(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mIMain;
    }

    static /* synthetic */ IMain access$9100(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mIMain;
    }

    static /* synthetic */ IMain access$9200(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mIMain;
    }

    static /* synthetic */ IMain access$9300(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mIMain;
    }

    static /* synthetic */ IMain access$9400(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mIMain;
    }

    static /* synthetic */ IMain access$9500(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mIMain;
    }

    static /* synthetic */ IMain access$9600(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mIMain;
    }

    static /* synthetic */ IMain access$9700(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mIMain;
    }

    static /* synthetic */ IMain access$9800(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mIMain;
    }

    static /* synthetic */ IMain access$9900(TenEqSpecial1Dialog tenEqSpecial1Dialog) {
        return tenEqSpecial1Dialog.mIMain;
    }

    class 1 implements View.OnClickListener {
        1() {
        }

        public void onClick(View view) {
            int id = view.getId();
            if (id == 2131297075) {
                TenEqSpecial1Dialog.this.dismiss();
                return;
            }
            if (id == 2131297045) {
                TenEqSpecial1Dialog tenEqSpecial1Dialog = TenEqSpecial1Dialog.this;
                TenEqSpecial1Dialog.access$100(tenEqSpecial1Dialog, TenEqSpecial1Dialog.access$000(tenEqSpecial1Dialog));
                return;
            }
            if (id == 2131297042) {
                TenEqSpecial1Dialog tenEqSpecial1Dialog2 = TenEqSpecial1Dialog.this;
                TenEqSpecial1Dialog.access$100(tenEqSpecial1Dialog2, TenEqSpecial1Dialog.access$200(tenEqSpecial1Dialog2));
                return;
            }
            if (id == 2131297043) {
                TenEqSpecial1Dialog tenEqSpecial1Dialog3 = TenEqSpecial1Dialog.this;
                TenEqSpecial1Dialog.access$100(tenEqSpecial1Dialog3, TenEqSpecial1Dialog.access$300(tenEqSpecial1Dialog3));
                return;
            }
            if (id == 2131297044) {
                TenEqSpecial1Dialog tenEqSpecial1Dialog4 = TenEqSpecial1Dialog.this;
                TenEqSpecial1Dialog.access$100(tenEqSpecial1Dialog4, TenEqSpecial1Dialog.access$400(tenEqSpecial1Dialog4));
                return;
            }
            if (id == 2131297086) {
                TenEqSpecial1Dialog.access$500(TenEqSpecial1Dialog.this).writeData(OrderSet.write_eq_reset);
                return;
            }
            if (id == 2131296364) {
                TenEqSpecial1Dialog.access$600(TenEqSpecial1Dialog.this).writeData(OrderSet.write_eq_save_user);
                return;
            }
            if (id == 2131296440) {
                TenEqSpecial1Dialog.access$700(TenEqSpecial1Dialog.this).writeData(OrderSet.write_eq_style_special10_user);
                return;
            }
            if (id == 2131296442) {
                TenEqSpecial1Dialog.access$800(TenEqSpecial1Dialog.this).writeData(OrderSet.write_eq_style_normal);
                return;
            }
            if (id == 2131296441) {
                TenEqSpecial1Dialog.access$900(TenEqSpecial1Dialog.this).writeData(OrderSet.write_eq_style_jazz);
                return;
            }
            if (id == 2131296443) {
                TenEqSpecial1Dialog.access$1000(TenEqSpecial1Dialog.this).writeData(OrderSet.write_eq_style_popular);
                return;
            }
            if (id == 2131296438) {
                TenEqSpecial1Dialog.access$1100(TenEqSpecial1Dialog.this).writeData(OrderSet.write_eq_style_classic);
                return;
            }
            if (id == 2131296445) {
                TenEqSpecial1Dialog.access$1200(TenEqSpecial1Dialog.this).writeData(OrderSet.write_eq_style_rock);
            } else if (id == 2131296444) {
                TenEqSpecial1Dialog.access$1300(TenEqSpecial1Dialog.this).writeData(OrderSet.write_eq_style_special10_rock);
            } else if (id == 2131296439) {
                TenEqSpecial1Dialog.access$1400(TenEqSpecial1Dialog.this).writeData(OrderSet.write_eq_style_country);
            }
        }
    }

    private void sendTBEData(int i) {
        byte[] bArr = OrderSet.write_eq_tbe;
        bArr[2] = (byte) i;
        this.mIMain.writeData(bArr);
    }

    class 2 implements Runnable {
        2() {
        }

        public void run() {
            if (TenEqSpecial1Dialog.access$1500(TenEqSpecial1Dialog.this)) {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 0;
                bArr[3] = (byte) TenEqSpecial1Dialog.access$1600(TenEqSpecial1Dialog.this).getProgress();
                TenEqSpecial1Dialog.access$1700(TenEqSpecial1Dialog.this).writeData(bArr);
                TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 3 implements Runnable {
        3() {
        }

        public void run() {
            if (TenEqSpecial1Dialog.access$1900(TenEqSpecial1Dialog.this)) {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 1;
                bArr[3] = (byte) TenEqSpecial1Dialog.access$2000(TenEqSpecial1Dialog.this).getProgress();
                TenEqSpecial1Dialog.access$2100(TenEqSpecial1Dialog.this).writeData(bArr);
                TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 4 implements Runnable {
        4() {
        }

        public void run() {
            if (TenEqSpecial1Dialog.access$2200(TenEqSpecial1Dialog.this)) {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 2;
                bArr[3] = (byte) TenEqSpecial1Dialog.access$2300(TenEqSpecial1Dialog.this).getProgress();
                TenEqSpecial1Dialog.access$2400(TenEqSpecial1Dialog.this).writeData(bArr);
                TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 5 implements Runnable {
        5() {
        }

        public void run() {
            if (TenEqSpecial1Dialog.access$2500(TenEqSpecial1Dialog.this)) {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 3;
                bArr[3] = (byte) TenEqSpecial1Dialog.access$2600(TenEqSpecial1Dialog.this).getProgress();
                TenEqSpecial1Dialog.access$2700(TenEqSpecial1Dialog.this).writeData(bArr);
                TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 6 implements Runnable {
        6() {
        }

        public void run() {
            if (TenEqSpecial1Dialog.access$2800(TenEqSpecial1Dialog.this)) {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 4;
                bArr[3] = (byte) TenEqSpecial1Dialog.access$2900(TenEqSpecial1Dialog.this).getProgress();
                TenEqSpecial1Dialog.access$3000(TenEqSpecial1Dialog.this).writeData(bArr);
                TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 7 implements Runnable {
        7() {
        }

        public void run() {
            if (TenEqSpecial1Dialog.access$3100(TenEqSpecial1Dialog.this)) {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 5;
                bArr[3] = (byte) TenEqSpecial1Dialog.access$3200(TenEqSpecial1Dialog.this).getProgress();
                TenEqSpecial1Dialog.access$3300(TenEqSpecial1Dialog.this).writeData(bArr);
                TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 8 implements Runnable {
        8() {
        }

        public void run() {
            if (TenEqSpecial1Dialog.access$3400(TenEqSpecial1Dialog.this)) {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 6;
                bArr[3] = (byte) TenEqSpecial1Dialog.access$3500(TenEqSpecial1Dialog.this).getProgress();
                TenEqSpecial1Dialog.access$3600(TenEqSpecial1Dialog.this).writeData(bArr);
                TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 9 implements Runnable {
        9() {
        }

        public void run() {
            if (TenEqSpecial1Dialog.access$3700(TenEqSpecial1Dialog.this)) {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 7;
                bArr[3] = (byte) TenEqSpecial1Dialog.access$3800(TenEqSpecial1Dialog.this).getProgress();
                TenEqSpecial1Dialog.access$3900(TenEqSpecial1Dialog.this).writeData(bArr);
                TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 10 implements Runnable {
        10() {
        }

        public void run() {
            if (TenEqSpecial1Dialog.access$4000(TenEqSpecial1Dialog.this)) {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 8;
                bArr[3] = (byte) TenEqSpecial1Dialog.access$4100(TenEqSpecial1Dialog.this).getProgress();
                TenEqSpecial1Dialog.access$4200(TenEqSpecial1Dialog.this).writeData(bArr);
                TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 11 implements Runnable {
        11() {
        }

        public void run() {
            if (TenEqSpecial1Dialog.access$4300(TenEqSpecial1Dialog.this)) {
                byte[] bArr = OrderSet.write_balance;
                bArr[2] = (byte) TenEqSpecial1Dialog.access$4400(TenEqSpecial1Dialog.this).getProgress();
                TenEqSpecial1Dialog.access$4500(TenEqSpecial1Dialog.this).writeData(bArr);
                TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 12 implements Runnable {
        12() {
        }

        public void run() {
            if (TenEqSpecial1Dialog.access$4600(TenEqSpecial1Dialog.this)) {
                byte[] bArr = OrderSet.write_fade;
                bArr[2] = (byte) TenEqSpecial1Dialog.access$4700(TenEqSpecial1Dialog.this).getProgress();
                TenEqSpecial1Dialog.access$4800(TenEqSpecial1Dialog.this).writeData(bArr);
                TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 13 implements Runnable {
        13() {
        }

        public void run() {
            if (TenEqSpecial1Dialog.access$3400(TenEqSpecial1Dialog.this)) {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 9;
                bArr[3] = (byte) TenEqSpecial1Dialog.access$4900(TenEqSpecial1Dialog.this).getProgress();
                TenEqSpecial1Dialog.access$5000(TenEqSpecial1Dialog.this).writeData(bArr);
                TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).postDelayed(this, 200L);
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
                TenEqSpecial1Dialog.access$5102(TenEqSpecial1Dialog.this, z);
                TenEqSpecial1Dialog.access$5200(TenEqSpecial1Dialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296754) {
                TenEqSpecial1Dialog.access$5302(TenEqSpecial1Dialog.this, z);
                TenEqSpecial1Dialog.access$5400(TenEqSpecial1Dialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296755) {
                TenEqSpecial1Dialog.access$5502(TenEqSpecial1Dialog.this, z);
                TenEqSpecial1Dialog.access$5600(TenEqSpecial1Dialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296756) {
                TenEqSpecial1Dialog.access$5502(TenEqSpecial1Dialog.this, z);
                TenEqSpecial1Dialog.access$5700(TenEqSpecial1Dialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296757) {
                TenEqSpecial1Dialog.access$5802(TenEqSpecial1Dialog.this, z);
                TenEqSpecial1Dialog.access$5900(TenEqSpecial1Dialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296758) {
                TenEqSpecial1Dialog.access$6002(TenEqSpecial1Dialog.this, z);
                TenEqSpecial1Dialog.access$6100(TenEqSpecial1Dialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296759) {
                TenEqSpecial1Dialog.access$6202(TenEqSpecial1Dialog.this, z);
                TenEqSpecial1Dialog.access$6300(TenEqSpecial1Dialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296760) {
                TenEqSpecial1Dialog.access$6402(TenEqSpecial1Dialog.this, z);
                TenEqSpecial1Dialog.access$6500(TenEqSpecial1Dialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296761) {
                TenEqSpecial1Dialog.access$6602(TenEqSpecial1Dialog.this, z);
                TenEqSpecial1Dialog.access$6700(TenEqSpecial1Dialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296762) {
                TenEqSpecial1Dialog.access$6802(TenEqSpecial1Dialog.this, z);
                TenEqSpecial1Dialog.access$6900(TenEqSpecial1Dialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296763) {
                TenEqSpecial1Dialog.access$7002(TenEqSpecial1Dialog.this, z);
                TenEqSpecial1Dialog.access$7100(TenEqSpecial1Dialog.this).setText("R" + String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296766) {
                TenEqSpecial1Dialog.access$7202(TenEqSpecial1Dialog.this, z);
                TenEqSpecial1Dialog.access$7300(TenEqSpecial1Dialog.this).setText("F" + String.valueOf(progress - 7));
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            int id = seekBar.getId();
            if (id == 2131296753) {
                TenEqSpecial1Dialog.access$1502(TenEqSpecial1Dialog.this, true);
                TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).postDelayed(TenEqSpecial1Dialog.access$7400(TenEqSpecial1Dialog.this), 200L);
                return;
            }
            if (id == 2131296754) {
                TenEqSpecial1Dialog.access$1902(TenEqSpecial1Dialog.this, true);
                TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).postDelayed(TenEqSpecial1Dialog.access$7500(TenEqSpecial1Dialog.this), 200L);
                return;
            }
            if (id == 2131296755) {
                TenEqSpecial1Dialog.access$2202(TenEqSpecial1Dialog.this, true);
                TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).postDelayed(TenEqSpecial1Dialog.access$7600(TenEqSpecial1Dialog.this), 200L);
                return;
            }
            if (id == 2131296756) {
                TenEqSpecial1Dialog.access$2502(TenEqSpecial1Dialog.this, true);
                TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).postDelayed(TenEqSpecial1Dialog.access$7700(TenEqSpecial1Dialog.this), 200L);
                return;
            }
            if (id == 2131296757) {
                TenEqSpecial1Dialog.access$2802(TenEqSpecial1Dialog.this, false);
                TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).postDelayed(TenEqSpecial1Dialog.access$7800(TenEqSpecial1Dialog.this), 200L);
                return;
            }
            if (id == 2131296758) {
                TenEqSpecial1Dialog.access$3102(TenEqSpecial1Dialog.this, true);
                TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).postDelayed(TenEqSpecial1Dialog.access$7900(TenEqSpecial1Dialog.this), 200L);
                return;
            }
            if (id == 2131296759) {
                TenEqSpecial1Dialog.access$3402(TenEqSpecial1Dialog.this, true);
                TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).postDelayed(TenEqSpecial1Dialog.access$8000(TenEqSpecial1Dialog.this), 200L);
                return;
            }
            if (id == 2131296760) {
                TenEqSpecial1Dialog.access$3702(TenEqSpecial1Dialog.this, true);
                TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).postDelayed(TenEqSpecial1Dialog.access$8100(TenEqSpecial1Dialog.this), 200L);
                return;
            }
            if (id == 2131296761) {
                TenEqSpecial1Dialog.access$4002(TenEqSpecial1Dialog.this, true);
                TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).postDelayed(TenEqSpecial1Dialog.access$8200(TenEqSpecial1Dialog.this), 200L);
                return;
            }
            if (id == 2131296762) {
                TenEqSpecial1Dialog.access$8302(TenEqSpecial1Dialog.this, true);
                TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).postDelayed(TenEqSpecial1Dialog.access$8400(TenEqSpecial1Dialog.this), 200L);
            } else if (id == 2131296763) {
                TenEqSpecial1Dialog.access$4302(TenEqSpecial1Dialog.this, true);
                TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).postDelayed(TenEqSpecial1Dialog.access$8500(TenEqSpecial1Dialog.this), 200L);
            } else if (id == 2131296766) {
                TenEqSpecial1Dialog.access$4602(TenEqSpecial1Dialog.this, true);
                TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).postDelayed(TenEqSpecial1Dialog.access$8600(TenEqSpecial1Dialog.this), 200L);
            }
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            int id = seekBar.getId();
            if (id == 2131296753) {
                TenEqSpecial1Dialog.access$1502(TenEqSpecial1Dialog.this, false);
                try {
                    TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).removeCallbacks(TenEqSpecial1Dialog.access$7400(TenEqSpecial1Dialog.this));
                    TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).postDelayed(new 1(), 300L);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            if (id == 2131296754) {
                TenEqSpecial1Dialog.access$1902(TenEqSpecial1Dialog.this, false);
                try {
                    TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).removeCallbacks(TenEqSpecial1Dialog.access$7500(TenEqSpecial1Dialog.this));
                    TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).postDelayed(new 2(), 300L);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (id == 2131296755) {
                TenEqSpecial1Dialog.access$2202(TenEqSpecial1Dialog.this, false);
                try {
                    TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).removeCallbacks(TenEqSpecial1Dialog.access$7600(TenEqSpecial1Dialog.this));
                    TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).postDelayed(new 3(), 300L);
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            if (id == 2131296756) {
                TenEqSpecial1Dialog.access$2502(TenEqSpecial1Dialog.this, false);
                try {
                    TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).removeCallbacks(TenEqSpecial1Dialog.access$7700(TenEqSpecial1Dialog.this));
                    TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).postDelayed(new 4(), 300L);
                    return;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
            }
            if (id == 2131296757) {
                TenEqSpecial1Dialog.access$2802(TenEqSpecial1Dialog.this, false);
                try {
                    TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).removeCallbacks(TenEqSpecial1Dialog.access$7800(TenEqSpecial1Dialog.this));
                    TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).postDelayed(new 5(), 300L);
                    return;
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return;
                }
            }
            if (id == 2131296758) {
                TenEqSpecial1Dialog.access$3102(TenEqSpecial1Dialog.this, false);
                try {
                    TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).removeCallbacks(TenEqSpecial1Dialog.access$7900(TenEqSpecial1Dialog.this));
                    TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).postDelayed(new 6(), 300L);
                    return;
                } catch (Exception e6) {
                    e6.printStackTrace();
                    return;
                }
            }
            if (id == 2131296759) {
                TenEqSpecial1Dialog.access$3402(TenEqSpecial1Dialog.this, false);
                try {
                    TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).removeCallbacks(TenEqSpecial1Dialog.access$8000(TenEqSpecial1Dialog.this));
                    TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).postDelayed(new 7(), 300L);
                    return;
                } catch (Exception e7) {
                    e7.printStackTrace();
                    return;
                }
            }
            if (id == 2131296760) {
                TenEqSpecial1Dialog.access$3702(TenEqSpecial1Dialog.this, false);
                try {
                    TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).removeCallbacks(TenEqSpecial1Dialog.access$8100(TenEqSpecial1Dialog.this));
                    TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).postDelayed(new 8(), 300L);
                    return;
                } catch (Exception e8) {
                    e8.printStackTrace();
                    return;
                }
            }
            if (id == 2131296761) {
                TenEqSpecial1Dialog.access$4002(TenEqSpecial1Dialog.this, false);
                try {
                    TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).removeCallbacks(TenEqSpecial1Dialog.access$8200(TenEqSpecial1Dialog.this));
                    TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).postDelayed(new 9(), 300L);
                    return;
                } catch (Exception e9) {
                    e9.printStackTrace();
                    return;
                }
            }
            if (id == 2131296762) {
                TenEqSpecial1Dialog.access$8302(TenEqSpecial1Dialog.this, false);
                try {
                    TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).removeCallbacks(TenEqSpecial1Dialog.access$8400(TenEqSpecial1Dialog.this));
                    TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).postDelayed(new 10(), 300L);
                    return;
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return;
                }
            }
            if (id == 2131296763) {
                TenEqSpecial1Dialog.access$4302(TenEqSpecial1Dialog.this, false);
                try {
                    TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).removeCallbacks(TenEqSpecial1Dialog.access$8500(TenEqSpecial1Dialog.this));
                    TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).postDelayed(new 11(), 300L);
                    return;
                } catch (Exception e11) {
                    e11.printStackTrace();
                    return;
                }
            }
            if (id == 2131296766) {
                TenEqSpecial1Dialog.access$4602(TenEqSpecial1Dialog.this, false);
                try {
                    TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).removeCallbacks(TenEqSpecial1Dialog.access$8600(TenEqSpecial1Dialog.this));
                    TenEqSpecial1Dialog.access$1800(TenEqSpecial1Dialog.this).postDelayed(new 12(), 300L);
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
                bArr[3] = (byte) TenEqSpecial1Dialog.access$1600(TenEqSpecial1Dialog.this).getProgress();
                TenEqSpecial1Dialog.access$8700(TenEqSpecial1Dialog.this).writeData(bArr);
            }
        }

        class 2 implements Runnable {
            2() {
            }

            public void run() {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 1;
                bArr[3] = (byte) TenEqSpecial1Dialog.access$2000(TenEqSpecial1Dialog.this).getProgress();
                TenEqSpecial1Dialog.access$8800(TenEqSpecial1Dialog.this).writeData(bArr);
            }
        }

        class 3 implements Runnable {
            3() {
            }

            public void run() {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 2;
                bArr[3] = (byte) TenEqSpecial1Dialog.access$2300(TenEqSpecial1Dialog.this).getProgress();
                TenEqSpecial1Dialog.access$8900(TenEqSpecial1Dialog.this).writeData(bArr);
            }
        }

        class 4 implements Runnable {
            4() {
            }

            public void run() {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 3;
                bArr[3] = (byte) TenEqSpecial1Dialog.access$2600(TenEqSpecial1Dialog.this).getProgress();
                TenEqSpecial1Dialog.access$9000(TenEqSpecial1Dialog.this).writeData(bArr);
            }
        }

        class 5 implements Runnable {
            5() {
            }

            public void run() {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 4;
                bArr[3] = (byte) TenEqSpecial1Dialog.access$2900(TenEqSpecial1Dialog.this).getProgress();
                TenEqSpecial1Dialog.access$9100(TenEqSpecial1Dialog.this).writeData(bArr);
            }
        }

        class 6 implements Runnable {
            6() {
            }

            public void run() {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 5;
                bArr[3] = (byte) TenEqSpecial1Dialog.access$3200(TenEqSpecial1Dialog.this).getProgress();
                TenEqSpecial1Dialog.access$9200(TenEqSpecial1Dialog.this).writeData(bArr);
            }
        }

        class 7 implements Runnable {
            7() {
            }

            public void run() {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 6;
                bArr[3] = (byte) TenEqSpecial1Dialog.access$3500(TenEqSpecial1Dialog.this).getProgress();
                TenEqSpecial1Dialog.access$9300(TenEqSpecial1Dialog.this).writeData(bArr);
            }
        }

        class 8 implements Runnable {
            8() {
            }

            public void run() {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 7;
                bArr[3] = (byte) TenEqSpecial1Dialog.access$3800(TenEqSpecial1Dialog.this).getProgress();
                TenEqSpecial1Dialog.access$9400(TenEqSpecial1Dialog.this).writeData(bArr);
            }
        }

        class 9 implements Runnable {
            9() {
            }

            public void run() {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 8;
                bArr[3] = (byte) TenEqSpecial1Dialog.access$4100(TenEqSpecial1Dialog.this).getProgress();
                TenEqSpecial1Dialog.access$9500(TenEqSpecial1Dialog.this).writeData(bArr);
            }
        }

        class 10 implements Runnable {
            10() {
            }

            public void run() {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 9;
                bArr[3] = (byte) TenEqSpecial1Dialog.access$4900(TenEqSpecial1Dialog.this).getProgress();
                TenEqSpecial1Dialog.access$9600(TenEqSpecial1Dialog.this).writeData(bArr);
            }
        }

        class 11 implements Runnable {
            11() {
            }

            public void run() {
                byte[] bArr = OrderSet.write_balance;
                bArr[2] = (byte) TenEqSpecial1Dialog.access$4400(TenEqSpecial1Dialog.this).getProgress();
                TenEqSpecial1Dialog.access$9700(TenEqSpecial1Dialog.this).writeData(bArr);
            }
        }

        class 12 implements Runnable {
            12() {
            }

            public void run() {
                byte[] bArr = OrderSet.write_fade;
                bArr[2] = (byte) TenEqSpecial1Dialog.access$4700(TenEqSpecial1Dialog.this).getProgress();
                TenEqSpecial1Dialog.access$9800(TenEqSpecial1Dialog.this).writeData(bArr);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(2131492932, viewGroup, false);
        return this.mRootView;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mHandler = new Handler(Looper.myLooper());
        this.mRootView.findViewById(2131297075).setOnClickListener(this.mOnClickListener);
        this.mRootView.findViewById(2131297086).setOnClickListener(this.mOnClickListener);
        this.mRootView.findViewById(2131296364).setOnClickListener(this.mOnClickListener);
        this.tv_tbe_off = this.mRootView.findViewById(2131297045);
        this.tv_tbe1 = this.mRootView.findViewById(2131297042);
        this.tv_tbe2 = this.mRootView.findViewById(2131297043);
        this.tv_tbe3 = this.mRootView.findViewById(2131297044);
        this.tv_tbe1.setOnClickListener(this.mOnClickListener);
        this.tv_tbe2.setOnClickListener(this.mOnClickListener);
        this.tv_tbe3.setOnClickListener(this.mOnClickListener);
        this.tv_tbe_off.setOnClickListener(this.mOnClickListener);
        View findViewById = this.mRootView.findViewById(2131297116);
        this.view_maskeq_0 = findViewById;
        findViewById.setOnClickListener(this.mOnClickListener);
        this.view_maskeq_1 = this.mRootView.findViewById(2131297117);
        this.view_maskeq_2 = this.mRootView.findViewById(2131297118);
        this.view_maskeq_3 = this.mRootView.findViewById(2131297119);
        this.view_maskeq_4 = this.mRootView.findViewById(2131297120);
        this.view_maskeq_5 = this.mRootView.findViewById(2131297121);
        this.view_maskeq_6 = this.mRootView.findViewById(2131297122);
        CheckedTextView findViewById2 = this.mRootView.findViewById(2131296442);
        this.ctv_ten_eq_normal = findViewById2;
        findViewById2.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById3 = this.mRootView.findViewById(2131296441);
        this.ctv_ten_eq_jazz = findViewById3;
        findViewById3.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById4 = this.mRootView.findViewById(2131296443);
        this.ctv_ten_eq_pop = findViewById4;
        findViewById4.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById5 = this.mRootView.findViewById(2131296438);
        this.ctv_ten_eq_classic = findViewById5;
        findViewById5.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById6 = this.mRootView.findViewById(2131296444);
        this.ctv_ten_eq_roc = findViewById6;
        findViewById6.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById7 = this.mRootView.findViewById(2131296445);
        this.ctv_ten_eq_rock = findViewById7;
        findViewById7.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById8 = this.mRootView.findViewById(2131296439);
        this.ctv_ten_eq_country = findViewById8;
        findViewById8.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById9 = this.mRootView.findViewById(2131296440);
        this.ctv_ten_eq_custom = findViewById9;
        findViewById9.setOnClickListener(this.mOnClickListener);
        SeekBar findViewById10 = this.mRootView.findViewById(2131296753);
        this.sb_eq0 = findViewById10;
        findViewById10.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById11 = this.mRootView.findViewById(2131296754);
        this.sb_eq1 = findViewById11;
        findViewById11.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById12 = this.mRootView.findViewById(2131296755);
        this.sb_eq2 = findViewById12;
        findViewById12.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById13 = this.mRootView.findViewById(2131296756);
        this.sb_eq3 = findViewById13;
        findViewById13.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById14 = this.mRootView.findViewById(2131296757);
        this.sb_eq4 = findViewById14;
        findViewById14.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById15 = this.mRootView.findViewById(2131296758);
        this.sb_eq5 = findViewById15;
        findViewById15.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById16 = this.mRootView.findViewById(2131296759);
        this.sb_eq6 = findViewById16;
        findViewById16.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById17 = this.mRootView.findViewById(2131296760);
        this.sb_eq7 = findViewById17;
        findViewById17.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById18 = this.mRootView.findViewById(2131296761);
        this.sb_eq8 = findViewById18;
        findViewById18.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById19 = this.mRootView.findViewById(2131296762);
        this.sb_eq9 = findViewById19;
        findViewById19.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById20 = this.mRootView.findViewById(2131296763);
        this.sb_eq10 = findViewById20;
        findViewById20.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById21 = this.mRootView.findViewById(2131296766);
        this.sb_eq11 = findViewById21;
        findViewById21.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
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
        this.mHandler.postDelayed(new 15(), 10L);
    }

    class 15 implements Runnable {
        15() {
        }

        public void run() {
            TenEqSpecial1Dialog.access$9900(TenEqSpecial1Dialog.this).writeData(OrderSet.write_synchronize);
        }
    }

    private void setBlaAndFad() {
        this.sb_eq11.setProgress(this.mBaseViewModel.getFade());
        this.sb_eq10.setProgress(this.mBaseViewModel.getBalance());
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
            dialog.setOnDismissListener(new 16());
        }
    }

    class 16 implements DialogInterface.OnDismissListener {
        16() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            TenEqSpecial1Dialog.access$10000(TenEqSpecial1Dialog.this).setItemVisibility();
        }
    }

    private void refreshEqStyle(int i) {
        this.mCuEqChoose = i;
        setEqMaskShow(true);
        switch (i) {
            case 0:
                this.ctv_ten_eq_normal.setChecked(true);
                this.ctv_ten_eq_pop.setChecked(false);
                this.ctv_ten_eq_rock.setChecked(false);
                this.ctv_ten_eq_roc.setChecked(false);
                this.ctv_ten_eq_jazz.setChecked(false);
                this.ctv_ten_eq_classic.setChecked(false);
                this.ctv_ten_eq_country.setChecked(false);
                this.ctv_ten_eq_custom.setChecked(false);
                setEqMaskShow(false);
                break;
            case 1:
                this.ctv_ten_eq_normal.setChecked(false);
                this.ctv_ten_eq_pop.setChecked(true);
                this.ctv_ten_eq_rock.setChecked(false);
                this.ctv_ten_eq_roc.setChecked(false);
                this.ctv_ten_eq_jazz.setChecked(false);
                this.ctv_ten_eq_classic.setChecked(false);
                this.ctv_ten_eq_country.setChecked(false);
                this.ctv_ten_eq_custom.setChecked(false);
                break;
            case 2:
                this.ctv_ten_eq_normal.setChecked(false);
                this.ctv_ten_eq_pop.setChecked(false);
                this.ctv_ten_eq_rock.setChecked(true);
                this.ctv_ten_eq_roc.setChecked(false);
                this.ctv_ten_eq_jazz.setChecked(false);
                this.ctv_ten_eq_classic.setChecked(false);
                this.ctv_ten_eq_country.setChecked(false);
                this.ctv_ten_eq_custom.setChecked(false);
                break;
            case 3:
                this.ctv_ten_eq_normal.setChecked(false);
                this.ctv_ten_eq_pop.setChecked(false);
                this.ctv_ten_eq_rock.setChecked(false);
                this.ctv_ten_eq_roc.setChecked(false);
                this.ctv_ten_eq_jazz.setChecked(true);
                this.ctv_ten_eq_classic.setChecked(false);
                this.ctv_ten_eq_country.setChecked(false);
                this.ctv_ten_eq_custom.setChecked(false);
                break;
            case 4:
                this.ctv_ten_eq_normal.setChecked(false);
                this.ctv_ten_eq_pop.setChecked(false);
                this.ctv_ten_eq_rock.setChecked(false);
                this.ctv_ten_eq_roc.setChecked(false);
                this.ctv_ten_eq_jazz.setChecked(false);
                this.ctv_ten_eq_classic.setChecked(true);
                this.ctv_ten_eq_country.setChecked(false);
                this.ctv_ten_eq_custom.setChecked(false);
                break;
            case 5:
                this.ctv_ten_eq_normal.setChecked(false);
                this.ctv_ten_eq_pop.setChecked(false);
                this.ctv_ten_eq_rock.setChecked(false);
                this.ctv_ten_eq_roc.setChecked(false);
                this.ctv_ten_eq_jazz.setChecked(false);
                this.ctv_ten_eq_classic.setChecked(false);
                this.ctv_ten_eq_country.setChecked(true);
                this.ctv_ten_eq_custom.setChecked(false);
                break;
            case 6:
                this.ctv_ten_eq_normal.setChecked(false);
                this.ctv_ten_eq_pop.setChecked(false);
                this.ctv_ten_eq_rock.setChecked(false);
                this.ctv_ten_eq_roc.setChecked(true);
                this.ctv_ten_eq_jazz.setChecked(false);
                this.ctv_ten_eq_classic.setChecked(false);
                this.ctv_ten_eq_country.setChecked(false);
                this.ctv_ten_eq_custom.setChecked(false);
                break;
            case 7:
                this.ctv_ten_eq_normal.setChecked(false);
                this.ctv_ten_eq_pop.setChecked(false);
                this.ctv_ten_eq_rock.setChecked(false);
                this.ctv_ten_eq_roc.setChecked(false);
                this.ctv_ten_eq_jazz.setChecked(false);
                this.ctv_ten_eq_classic.setChecked(false);
                this.ctv_ten_eq_country.setChecked(false);
                this.ctv_ten_eq_custom.setChecked(true);
                setEqMaskShow(false);
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:210:0x03bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void notice(java.lang.String r17, java.util.UUID r18, byte[] r19) {
        /*
            Method dump skipped, instructions count: 1830
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zddz.app.carlive.dialog.TenEqSpecial1Dialog.notice(java.lang.String, java.util.UUID, byte[]):void");
    }

    private void setTbeShow(int i) {
        if (this.tv_tbe_off == null) {
            return;
        }
        int parseColor = Color.parseColor("#013D57");
        int parseColor2 = Color.parseColor("#ffffff");
        Drawable drawable = getResources().getDrawable(2131230907);
        Drawable drawable2 = getResources().getDrawable(2131230908);
        this.tv_tbe_off.setBackground(i == this.TBE_OFF ? drawable2 : drawable);
        this.tv_tbe1.setBackground(i == this.TBE_1 ? drawable2 : drawable);
        this.tv_tbe2.setBackground(i == this.TBE_2 ? drawable2 : drawable);
        TextView textView = this.tv_tbe3;
        if (i == this.TBE_3) {
            drawable = drawable2;
        }
        textView.setBackground(drawable);
        this.tv_tbe_off.setTextColor(i == this.TBE_OFF ? parseColor : parseColor2);
        this.tv_tbe1.setTextColor(i == this.TBE_1 ? parseColor : parseColor2);
        this.tv_tbe2.setTextColor(i == this.TBE_2 ? parseColor : parseColor2);
        TextView textView2 = this.tv_tbe3;
        if (i != this.TBE_3) {
            parseColor = parseColor2;
        }
        textView2.setTextColor(parseColor);
    }
}
