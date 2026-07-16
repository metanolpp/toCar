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
import com.zddz.app.carlive.database.EqRecord;
import com.zddz.app.carlive.fragment.BaseDialog;
import com.zddz.app.carlive.fragment.IMain;
import java.util.List;
import org.litepal.LitePal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class EightAddFourEqSpecialDialog extends BaseDialog {
    private CheckedTextView ctv_ten_eq_classic;
    private CheckedTextView ctv_ten_eq_country;
    private CheckedTextView ctv_ten_eq_custom;
    private CheckedTextView ctv_ten_eq_jazz;
    private CheckedTextView ctv_ten_eq_normal;
    private CheckedTextView ctv_ten_eq_pop;
    private CheckedTextView ctv_ten_eq_roc;
    private CheckedTextView ctv_ten_eq_rock;
    private Handler mHandler;
    private SeekBar sb_eq1;
    private SeekBar sb_eq2;
    private SeekBar sb_eq3;
    private SeekBar sb_eq4;
    private SeekBar sb_eq5;
    private SeekBar sb_eq6;
    private SeekBar sb_eq7;
    private SeekBar sb_eq_bal;
    private SeekBar sb_eq_bas;
    private SeekBar sb_eq_fad;
    private SeekBar sb_eq_tre;
    private SeekBar sb_eqnew8;
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
    private TextView tv_eq7;
    private TextView tv_eq7_value;
    private TextView tv_eq8;
    private TextView tv_eqbal_value;
    private TextView tv_eqbas_value;
    private TextView tv_eqfad_value;
    private TextView tv_eqnew8_value;
    private TextView tv_eqtre_value;
    private View view_mask_bas;
    View view_mask_fad;
    private View view_mask_tre;
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
    private final Runnable mEQBasRunnable = new 10();
    private boolean mEQ10FromUser = false;
    private boolean mEQ10BarMove = false;
    private final Runnable mEQBalRunnable = new 11();
    private boolean mEQ11FromUser = false;
    private boolean mEQ11BarMove = false;
    private final Runnable mEQFadRunnable = new 12();
    private boolean mEQ9FromUser = false;
    private boolean mEQ9BarMove = false;
    private final Runnable mEQTreRunnable = new 13();
    private SeekBar.OnSeekBarChangeListener mOnSeekBarChangeListener = new 14();
    int mCuEqChoose = 0;

    private void initData() {
    }

    private void refreshEqType(int i) {
    }

    static /* synthetic */ IMain access$000(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mIMain;
    }

    static /* synthetic */ IMain access$100(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mIMain;
    }

    static /* synthetic */ boolean access$1000(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mEQ0BarMove;
    }

    static /* synthetic */ boolean access$1002(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog, boolean z) {
        eightAddFourEqSpecialDialog.mEQ0BarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$1100(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.sb_eqnew8;
    }

    static /* synthetic */ IMain access$1200(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mIMain;
    }

    static /* synthetic */ Handler access$1300(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mHandler;
    }

    static /* synthetic */ boolean access$1400(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mEQ1BarMove;
    }

    static /* synthetic */ boolean access$1402(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog, boolean z) {
        eightAddFourEqSpecialDialog.mEQ1BarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$1500(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.sb_eq1;
    }

    static /* synthetic */ IMain access$1600(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mIMain;
    }

    static /* synthetic */ boolean access$1700(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mEQ2BarMove;
    }

    static /* synthetic */ boolean access$1702(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog, boolean z) {
        eightAddFourEqSpecialDialog.mEQ2BarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$1800(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.sb_eq2;
    }

    static /* synthetic */ IMain access$1900(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mIMain;
    }

    static /* synthetic */ IMain access$200(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mIMain;
    }

    static /* synthetic */ boolean access$2000(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mEQ3BarMove;
    }

    static /* synthetic */ boolean access$2002(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog, boolean z) {
        eightAddFourEqSpecialDialog.mEQ3BarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$2100(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.sb_eq3;
    }

    static /* synthetic */ IMain access$2200(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mIMain;
    }

    static /* synthetic */ boolean access$2300(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mEQ4BarMove;
    }

    static /* synthetic */ boolean access$2302(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog, boolean z) {
        eightAddFourEqSpecialDialog.mEQ4BarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$2400(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.sb_eq4;
    }

    static /* synthetic */ IMain access$2500(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mIMain;
    }

    static /* synthetic */ boolean access$2600(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mEQ5BarMove;
    }

    static /* synthetic */ boolean access$2602(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog, boolean z) {
        eightAddFourEqSpecialDialog.mEQ5BarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$2700(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.sb_eq5;
    }

    static /* synthetic */ IMain access$2800(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mIMain;
    }

    static /* synthetic */ boolean access$2900(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mEQ6BarMove;
    }

    static /* synthetic */ boolean access$2902(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog, boolean z) {
        eightAddFourEqSpecialDialog.mEQ6BarMove = z;
        return z;
    }

    static /* synthetic */ IMain access$300(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mIMain;
    }

    static /* synthetic */ SeekBar access$3000(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.sb_eq6;
    }

    static /* synthetic */ IMain access$3100(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mIMain;
    }

    static /* synthetic */ boolean access$3200(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mEQ7BarMove;
    }

    static /* synthetic */ boolean access$3202(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog, boolean z) {
        eightAddFourEqSpecialDialog.mEQ7BarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$3300(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.sb_eq7;
    }

    static /* synthetic */ IMain access$3400(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mIMain;
    }

    static /* synthetic */ boolean access$3500(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mEQ8BarMove;
    }

    static /* synthetic */ boolean access$3502(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog, boolean z) {
        eightAddFourEqSpecialDialog.mEQ8BarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$3600(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.sb_eq_bas;
    }

    static /* synthetic */ IMain access$3700(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mIMain;
    }

    static /* synthetic */ boolean access$3800(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mEQ10BarMove;
    }

    static /* synthetic */ boolean access$3802(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog, boolean z) {
        eightAddFourEqSpecialDialog.mEQ10BarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$3900(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.sb_eq_bal;
    }

    static /* synthetic */ IMain access$400(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mIMain;
    }

    static /* synthetic */ IMain access$4000(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mIMain;
    }

    static /* synthetic */ boolean access$4100(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mEQ11BarMove;
    }

    static /* synthetic */ boolean access$4102(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog, boolean z) {
        eightAddFourEqSpecialDialog.mEQ11BarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$4200(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.sb_eq_fad;
    }

    static /* synthetic */ IMain access$4300(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mIMain;
    }

    static /* synthetic */ SeekBar access$4400(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.sb_eq_tre;
    }

    static /* synthetic */ IMain access$4500(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mIMain;
    }

    static /* synthetic */ boolean access$4602(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog, boolean z) {
        eightAddFourEqSpecialDialog.mEQ0FromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$4700(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.tv_eqnew8_value;
    }

    static /* synthetic */ boolean access$4802(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog, boolean z) {
        eightAddFourEqSpecialDialog.mEQ1FromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$4900(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.tv_eq1_value;
    }

    static /* synthetic */ IMain access$500(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mIMain;
    }

    static /* synthetic */ boolean access$5002(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog, boolean z) {
        eightAddFourEqSpecialDialog.mEQ3FromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$5100(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.tv_eq2_value;
    }

    static /* synthetic */ TextView access$5200(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.tv_eq3_value;
    }

    static /* synthetic */ boolean access$5302(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog, boolean z) {
        eightAddFourEqSpecialDialog.mEQ4FromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$5400(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.tv_eq4_value;
    }

    static /* synthetic */ boolean access$5502(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog, boolean z) {
        eightAddFourEqSpecialDialog.mEQ5FromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$5600(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.tv_eq5_value;
    }

    static /* synthetic */ boolean access$5702(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog, boolean z) {
        eightAddFourEqSpecialDialog.mEQ6FromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$5800(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.tv_eq6_value;
    }

    static /* synthetic */ boolean access$5902(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog, boolean z) {
        eightAddFourEqSpecialDialog.mEQ7FromUser = z;
        return z;
    }

    static /* synthetic */ IMain access$600(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mIMain;
    }

    static /* synthetic */ TextView access$6000(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.tv_eq7_value;
    }

    static /* synthetic */ boolean access$6102(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog, boolean z) {
        eightAddFourEqSpecialDialog.mEQ8FromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$6200(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.tv_eqbas_value;
    }

    static /* synthetic */ boolean access$6302(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog, boolean z) {
        eightAddFourEqSpecialDialog.mEQ9FromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$6400(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.tv_eqtre_value;
    }

    static /* synthetic */ boolean access$6502(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog, boolean z) {
        eightAddFourEqSpecialDialog.mEQ10FromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$6600(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.tv_eqbal_value;
    }

    static /* synthetic */ boolean access$6702(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog, boolean z) {
        eightAddFourEqSpecialDialog.mEQ11FromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$6800(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.tv_eqfad_value;
    }

    static /* synthetic */ Runnable access$6900(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mEQ0Runnable;
    }

    static /* synthetic */ IMain access$700(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mIMain;
    }

    static /* synthetic */ Runnable access$7000(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mEQ1Runnable;
    }

    static /* synthetic */ Runnable access$7100(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mEQ2Runnable;
    }

    static /* synthetic */ Runnable access$7200(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mEQ3Runnable;
    }

    static /* synthetic */ Runnable access$7300(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mEQ4Runnable;
    }

    static /* synthetic */ Runnable access$7400(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mEQ5Runnable;
    }

    static /* synthetic */ Runnable access$7500(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mEQ6Runnable;
    }

    static /* synthetic */ Runnable access$7600(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mEQ7Runnable;
    }

    static /* synthetic */ Runnable access$7700(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mEQBasRunnable;
    }

    static /* synthetic */ boolean access$7802(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog, boolean z) {
        eightAddFourEqSpecialDialog.mEQ9BarMove = z;
        return z;
    }

    static /* synthetic */ Runnable access$7900(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mEQTreRunnable;
    }

    static /* synthetic */ IMain access$800(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mIMain;
    }

    static /* synthetic */ Runnable access$8000(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mEQBalRunnable;
    }

    static /* synthetic */ Runnable access$8100(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mEQFadRunnable;
    }

    static /* synthetic */ IMain access$8200(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mIMain;
    }

    static /* synthetic */ IMain access$8300(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mIMain;
    }

    static /* synthetic */ IMain access$8400(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mIMain;
    }

    static /* synthetic */ IMain access$8500(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mIMain;
    }

    static /* synthetic */ IMain access$8600(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mIMain;
    }

    static /* synthetic */ IMain access$8700(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mIMain;
    }

    static /* synthetic */ IMain access$8800(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mIMain;
    }

    static /* synthetic */ IMain access$8900(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mIMain;
    }

    static /* synthetic */ IMain access$900(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mIMain;
    }

    static /* synthetic */ IMain access$9000(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mIMain;
    }

    static /* synthetic */ IMain access$9100(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mIMain;
    }

    static /* synthetic */ IMain access$9200(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mIMain;
    }

    static /* synthetic */ IMain access$9300(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mIMain;
    }

    static /* synthetic */ IMain access$9400(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mIMain;
    }

    static /* synthetic */ IMain access$9500(EightAddFourEqSpecialDialog eightAddFourEqSpecialDialog) {
        return eightAddFourEqSpecialDialog.mIMain;
    }

    class 1 implements View.OnClickListener {
        1() {
        }

        public void onClick(View view) {
            int id = view.getId();
            if (id == 2131297075) {
                EightAddFourEqSpecialDialog.this.dismiss();
                return;
            }
            if (id == 2131297086) {
                EightAddFourEqSpecialDialog.access$000(EightAddFourEqSpecialDialog.this).writeData(OrderSet.write_eq_reset);
                return;
            }
            if (id == 2131296364) {
                EightAddFourEqSpecialDialog.access$100(EightAddFourEqSpecialDialog.this).writeData(OrderSet.write_eq_save_user);
                return;
            }
            if (id == 2131296440) {
                EightAddFourEqSpecialDialog.access$200(EightAddFourEqSpecialDialog.this).writeData(OrderSet.write_eq_style_special10_user);
                return;
            }
            if (id == 2131296442) {
                EightAddFourEqSpecialDialog.access$300(EightAddFourEqSpecialDialog.this).writeData(OrderSet.write_eq_style_normal);
                return;
            }
            if (id == 2131296441) {
                EightAddFourEqSpecialDialog.access$400(EightAddFourEqSpecialDialog.this).writeData(OrderSet.write_eq_style_jazz);
                return;
            }
            if (id == 2131296443) {
                EightAddFourEqSpecialDialog.access$500(EightAddFourEqSpecialDialog.this).writeData(OrderSet.write_eq_style_popular);
                return;
            }
            if (id == 2131296438) {
                EightAddFourEqSpecialDialog.access$600(EightAddFourEqSpecialDialog.this).writeData(OrderSet.write_eq_style_classic);
                return;
            }
            if (id == 2131296445) {
                EightAddFourEqSpecialDialog.access$700(EightAddFourEqSpecialDialog.this).writeData(OrderSet.write_eq_style_rock);
            } else if (id == 2131296444) {
                EightAddFourEqSpecialDialog.access$800(EightAddFourEqSpecialDialog.this).writeData(OrderSet.write_eq_style_special10_rock);
            } else if (id == 2131296439) {
                EightAddFourEqSpecialDialog.access$900(EightAddFourEqSpecialDialog.this).writeData(OrderSet.write_eq_style_country);
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
            if (EightAddFourEqSpecialDialog.access$1000(EightAddFourEqSpecialDialog.this)) {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 7;
                bArr[3] = (byte) EightAddFourEqSpecialDialog.access$1100(EightAddFourEqSpecialDialog.this).getProgress();
                EightAddFourEqSpecialDialog.access$1200(EightAddFourEqSpecialDialog.this).writeData(bArr);
                EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 3 implements Runnable {
        3() {
        }

        public void run() {
            if (EightAddFourEqSpecialDialog.access$1400(EightAddFourEqSpecialDialog.this)) {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 0;
                bArr[3] = (byte) EightAddFourEqSpecialDialog.access$1500(EightAddFourEqSpecialDialog.this).getProgress();
                EightAddFourEqSpecialDialog.access$1600(EightAddFourEqSpecialDialog.this).writeData(bArr);
                EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 4 implements Runnable {
        4() {
        }

        public void run() {
            if (EightAddFourEqSpecialDialog.access$1700(EightAddFourEqSpecialDialog.this)) {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 1;
                bArr[3] = (byte) EightAddFourEqSpecialDialog.access$1800(EightAddFourEqSpecialDialog.this).getProgress();
                EightAddFourEqSpecialDialog.access$1900(EightAddFourEqSpecialDialog.this).writeData(bArr);
                EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 5 implements Runnable {
        5() {
        }

        public void run() {
            if (EightAddFourEqSpecialDialog.access$2000(EightAddFourEqSpecialDialog.this)) {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 2;
                bArr[3] = (byte) EightAddFourEqSpecialDialog.access$2100(EightAddFourEqSpecialDialog.this).getProgress();
                EightAddFourEqSpecialDialog.access$2200(EightAddFourEqSpecialDialog.this).writeData(bArr);
                EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 6 implements Runnable {
        6() {
        }

        public void run() {
            if (EightAddFourEqSpecialDialog.access$2300(EightAddFourEqSpecialDialog.this)) {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 3;
                bArr[3] = (byte) EightAddFourEqSpecialDialog.access$2400(EightAddFourEqSpecialDialog.this).getProgress();
                EightAddFourEqSpecialDialog.access$2500(EightAddFourEqSpecialDialog.this).writeData(bArr);
                EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 7 implements Runnable {
        7() {
        }

        public void run() {
            if (EightAddFourEqSpecialDialog.access$2600(EightAddFourEqSpecialDialog.this)) {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 4;
                bArr[3] = (byte) EightAddFourEqSpecialDialog.access$2700(EightAddFourEqSpecialDialog.this).getProgress();
                EightAddFourEqSpecialDialog.access$2800(EightAddFourEqSpecialDialog.this).writeData(bArr);
                EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 8 implements Runnable {
        8() {
        }

        public void run() {
            if (EightAddFourEqSpecialDialog.access$2900(EightAddFourEqSpecialDialog.this)) {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 5;
                bArr[3] = (byte) EightAddFourEqSpecialDialog.access$3000(EightAddFourEqSpecialDialog.this).getProgress();
                EightAddFourEqSpecialDialog.access$3100(EightAddFourEqSpecialDialog.this).writeData(bArr);
                EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 9 implements Runnable {
        9() {
        }

        public void run() {
            if (EightAddFourEqSpecialDialog.access$3200(EightAddFourEqSpecialDialog.this)) {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 6;
                bArr[3] = (byte) EightAddFourEqSpecialDialog.access$3300(EightAddFourEqSpecialDialog.this).getProgress();
                EightAddFourEqSpecialDialog.access$3400(EightAddFourEqSpecialDialog.this).writeData(bArr);
                EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 10 implements Runnable {
        10() {
        }

        public void run() {
            if (EightAddFourEqSpecialDialog.access$3500(EightAddFourEqSpecialDialog.this)) {
                byte[] bArr = OrderSet.write_bass;
                bArr[2] = (byte) EightAddFourEqSpecialDialog.access$3600(EightAddFourEqSpecialDialog.this).getProgress();
                EightAddFourEqSpecialDialog.access$3700(EightAddFourEqSpecialDialog.this).writeData(bArr);
                EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 11 implements Runnable {
        11() {
        }

        public void run() {
            if (EightAddFourEqSpecialDialog.access$3800(EightAddFourEqSpecialDialog.this)) {
                byte[] bArr = OrderSet.write_balance;
                bArr[2] = (byte) EightAddFourEqSpecialDialog.access$3900(EightAddFourEqSpecialDialog.this).getProgress();
                EightAddFourEqSpecialDialog.access$4000(EightAddFourEqSpecialDialog.this).writeData(bArr);
                EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 12 implements Runnable {
        12() {
        }

        public void run() {
            if (EightAddFourEqSpecialDialog.access$4100(EightAddFourEqSpecialDialog.this)) {
                byte[] bArr = OrderSet.write_fade;
                bArr[2] = (byte) EightAddFourEqSpecialDialog.access$4200(EightAddFourEqSpecialDialog.this).getProgress();
                EightAddFourEqSpecialDialog.access$4300(EightAddFourEqSpecialDialog.this).writeData(bArr);
                EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 13 implements Runnable {
        13() {
        }

        public void run() {
            if (EightAddFourEqSpecialDialog.access$2900(EightAddFourEqSpecialDialog.this)) {
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 9;
                bArr[3] = (byte) EightAddFourEqSpecialDialog.access$4400(EightAddFourEqSpecialDialog.this).getProgress();
                EightAddFourEqSpecialDialog.access$4500(EightAddFourEqSpecialDialog.this).writeData(bArr);
                EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 14 implements SeekBar.OnSeekBarChangeListener {
        14() {
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            int progress = seekBar.getProgress();
            int id = seekBar.getId();
            if (id == 2131296768) {
                EightAddFourEqSpecialDialog.access$4602(EightAddFourEqSpecialDialog.this, z);
                EightAddFourEqSpecialDialog.access$4700(EightAddFourEqSpecialDialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296754) {
                EightAddFourEqSpecialDialog.access$4802(EightAddFourEqSpecialDialog.this, z);
                EightAddFourEqSpecialDialog.access$4900(EightAddFourEqSpecialDialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296755) {
                EightAddFourEqSpecialDialog.access$5002(EightAddFourEqSpecialDialog.this, z);
                EightAddFourEqSpecialDialog.access$5100(EightAddFourEqSpecialDialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296756) {
                EightAddFourEqSpecialDialog.access$5002(EightAddFourEqSpecialDialog.this, z);
                EightAddFourEqSpecialDialog.access$5200(EightAddFourEqSpecialDialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296757) {
                EightAddFourEqSpecialDialog.access$5302(EightAddFourEqSpecialDialog.this, z);
                EightAddFourEqSpecialDialog.access$5400(EightAddFourEqSpecialDialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296758) {
                EightAddFourEqSpecialDialog.access$5502(EightAddFourEqSpecialDialog.this, z);
                EightAddFourEqSpecialDialog.access$5600(EightAddFourEqSpecialDialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296759) {
                EightAddFourEqSpecialDialog.access$5702(EightAddFourEqSpecialDialog.this, z);
                EightAddFourEqSpecialDialog.access$5800(EightAddFourEqSpecialDialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296767) {
                EightAddFourEqSpecialDialog.access$5902(EightAddFourEqSpecialDialog.this, z);
                EightAddFourEqSpecialDialog.access$6000(EightAddFourEqSpecialDialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296764) {
                EightAddFourEqSpecialDialog.access$6102(EightAddFourEqSpecialDialog.this, z);
                EightAddFourEqSpecialDialog.access$6200(EightAddFourEqSpecialDialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296766) {
                EightAddFourEqSpecialDialog.access$6302(EightAddFourEqSpecialDialog.this, z);
                EightAddFourEqSpecialDialog.access$6400(EightAddFourEqSpecialDialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296763) {
                EightAddFourEqSpecialDialog.access$6502(EightAddFourEqSpecialDialog.this, z);
                EightAddFourEqSpecialDialog.access$6600(EightAddFourEqSpecialDialog.this).setText("R" + String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296765) {
                EightAddFourEqSpecialDialog.access$6702(EightAddFourEqSpecialDialog.this, z);
                EightAddFourEqSpecialDialog.access$6800(EightAddFourEqSpecialDialog.this).setText("F" + String.valueOf(progress - 7));
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            int id = seekBar.getId();
            if (id == 2131296768) {
                EightAddFourEqSpecialDialog.access$1002(EightAddFourEqSpecialDialog.this, true);
                EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).postDelayed(EightAddFourEqSpecialDialog.access$6900(EightAddFourEqSpecialDialog.this), 200L);
                return;
            }
            if (id == 2131296754) {
                EightAddFourEqSpecialDialog.access$1402(EightAddFourEqSpecialDialog.this, true);
                EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).postDelayed(EightAddFourEqSpecialDialog.access$7000(EightAddFourEqSpecialDialog.this), 200L);
                return;
            }
            if (id == 2131296755) {
                EightAddFourEqSpecialDialog.access$1702(EightAddFourEqSpecialDialog.this, true);
                EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).postDelayed(EightAddFourEqSpecialDialog.access$7100(EightAddFourEqSpecialDialog.this), 200L);
                return;
            }
            if (id == 2131296756) {
                EightAddFourEqSpecialDialog.access$2002(EightAddFourEqSpecialDialog.this, true);
                EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).postDelayed(EightAddFourEqSpecialDialog.access$7200(EightAddFourEqSpecialDialog.this), 200L);
                return;
            }
            if (id == 2131296757) {
                EightAddFourEqSpecialDialog.access$2302(EightAddFourEqSpecialDialog.this, false);
                EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).postDelayed(EightAddFourEqSpecialDialog.access$7300(EightAddFourEqSpecialDialog.this), 200L);
                return;
            }
            if (id == 2131296758) {
                EightAddFourEqSpecialDialog.access$2602(EightAddFourEqSpecialDialog.this, true);
                EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).postDelayed(EightAddFourEqSpecialDialog.access$7400(EightAddFourEqSpecialDialog.this), 200L);
                return;
            }
            if (id == 2131296759) {
                EightAddFourEqSpecialDialog.access$2902(EightAddFourEqSpecialDialog.this, true);
                EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).postDelayed(EightAddFourEqSpecialDialog.access$7500(EightAddFourEqSpecialDialog.this), 200L);
                return;
            }
            if (id == 2131296767) {
                EightAddFourEqSpecialDialog.access$3202(EightAddFourEqSpecialDialog.this, true);
                EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).postDelayed(EightAddFourEqSpecialDialog.access$7600(EightAddFourEqSpecialDialog.this), 200L);
                return;
            }
            if (id == 2131296764) {
                EightAddFourEqSpecialDialog.access$3502(EightAddFourEqSpecialDialog.this, true);
                EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).postDelayed(EightAddFourEqSpecialDialog.access$7700(EightAddFourEqSpecialDialog.this), 200L);
                return;
            }
            if (id == 2131296766) {
                EightAddFourEqSpecialDialog.access$7802(EightAddFourEqSpecialDialog.this, true);
                EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).postDelayed(EightAddFourEqSpecialDialog.access$7900(EightAddFourEqSpecialDialog.this), 200L);
            } else if (id == 2131296763) {
                EightAddFourEqSpecialDialog.access$3802(EightAddFourEqSpecialDialog.this, true);
                EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).postDelayed(EightAddFourEqSpecialDialog.access$8000(EightAddFourEqSpecialDialog.this), 200L);
            } else if (id == 2131296765) {
                EightAddFourEqSpecialDialog.access$4102(EightAddFourEqSpecialDialog.this, true);
                EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).postDelayed(EightAddFourEqSpecialDialog.access$8100(EightAddFourEqSpecialDialog.this), 200L);
            }
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            int id = seekBar.getId();
            if (id == 2131296768) {
                try {
                    EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).removeCallbacks(EightAddFourEqSpecialDialog.access$6900(EightAddFourEqSpecialDialog.this));
                    EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).postDelayed(new 1(), 1000L);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            if (id == 2131296754) {
                try {
                    EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).removeCallbacks(EightAddFourEqSpecialDialog.access$7000(EightAddFourEqSpecialDialog.this));
                    EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).postDelayed(new 2(), 1000L);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (id == 2131296755) {
                try {
                    EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).removeCallbacks(EightAddFourEqSpecialDialog.access$7100(EightAddFourEqSpecialDialog.this));
                    EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).postDelayed(new 3(), 1000L);
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            if (id == 2131296756) {
                try {
                    EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).removeCallbacks(EightAddFourEqSpecialDialog.access$7200(EightAddFourEqSpecialDialog.this));
                    EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).postDelayed(new 4(), 1000L);
                    return;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
            }
            if (id == 2131296757) {
                try {
                    EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).removeCallbacks(EightAddFourEqSpecialDialog.access$7300(EightAddFourEqSpecialDialog.this));
                    EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).postDelayed(new 5(), 1000L);
                    return;
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return;
                }
            }
            if (id == 2131296758) {
                try {
                    EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).removeCallbacks(EightAddFourEqSpecialDialog.access$7400(EightAddFourEqSpecialDialog.this));
                    EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).postDelayed(new 6(), 1000L);
                    return;
                } catch (Exception e6) {
                    e6.printStackTrace();
                    return;
                }
            }
            if (id == 2131296759) {
                try {
                    EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).removeCallbacks(EightAddFourEqSpecialDialog.access$7500(EightAddFourEqSpecialDialog.this));
                    EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).postDelayed(new 7(), 1000L);
                    return;
                } catch (Exception e7) {
                    e7.printStackTrace();
                    return;
                }
            }
            if (id == 2131296767) {
                try {
                    EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).removeCallbacks(EightAddFourEqSpecialDialog.access$7600(EightAddFourEqSpecialDialog.this));
                    EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).postDelayed(new 8(), 1000L);
                    return;
                } catch (Exception e8) {
                    e8.printStackTrace();
                    return;
                }
            }
            if (id == 2131296764) {
                try {
                    EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).removeCallbacks(EightAddFourEqSpecialDialog.access$7700(EightAddFourEqSpecialDialog.this));
                    EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).postDelayed(new 9(), 1000L);
                    return;
                } catch (Exception e9) {
                    e9.printStackTrace();
                    return;
                }
            }
            if (id == 2131296766) {
                try {
                    EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).removeCallbacks(EightAddFourEqSpecialDialog.access$7900(EightAddFourEqSpecialDialog.this));
                    EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).postDelayed(new 10(), 1000L);
                    return;
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return;
                }
            }
            if (id == 2131296763) {
                try {
                    EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).removeCallbacks(EightAddFourEqSpecialDialog.access$8000(EightAddFourEqSpecialDialog.this));
                    EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).postDelayed(new 11(), 1000L);
                    return;
                } catch (Exception e11) {
                    e11.printStackTrace();
                    return;
                }
            }
            if (id == 2131296765) {
                try {
                    EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).removeCallbacks(EightAddFourEqSpecialDialog.access$8100(EightAddFourEqSpecialDialog.this));
                    EightAddFourEqSpecialDialog.access$1300(EightAddFourEqSpecialDialog.this).postDelayed(new 12(), 1000L);
                } catch (Exception e12) {
                    e12.printStackTrace();
                }
            }
        }

        class 1 implements Runnable {
            1() {
            }

            public void run() {
                EightAddFourEqSpecialDialog.access$1002(EightAddFourEqSpecialDialog.this, false);
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 7;
                bArr[3] = (byte) EightAddFourEqSpecialDialog.access$1100(EightAddFourEqSpecialDialog.this).getProgress();
                EightAddFourEqSpecialDialog.access$8200(EightAddFourEqSpecialDialog.this).writeData(bArr);
            }
        }

        class 2 implements Runnable {
            2() {
            }

            public void run() {
                EightAddFourEqSpecialDialog.access$1402(EightAddFourEqSpecialDialog.this, false);
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 0;
                bArr[3] = (byte) EightAddFourEqSpecialDialog.access$1500(EightAddFourEqSpecialDialog.this).getProgress();
                EightAddFourEqSpecialDialog.access$8300(EightAddFourEqSpecialDialog.this).writeData(bArr);
            }
        }

        class 3 implements Runnable {
            3() {
            }

            public void run() {
                EightAddFourEqSpecialDialog.access$1702(EightAddFourEqSpecialDialog.this, false);
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 1;
                bArr[3] = (byte) EightAddFourEqSpecialDialog.access$1800(EightAddFourEqSpecialDialog.this).getProgress();
                EightAddFourEqSpecialDialog.access$8400(EightAddFourEqSpecialDialog.this).writeData(bArr);
            }
        }

        class 4 implements Runnable {
            4() {
            }

            public void run() {
                EightAddFourEqSpecialDialog.access$2002(EightAddFourEqSpecialDialog.this, false);
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 2;
                bArr[3] = (byte) EightAddFourEqSpecialDialog.access$2100(EightAddFourEqSpecialDialog.this).getProgress();
                EightAddFourEqSpecialDialog.access$8500(EightAddFourEqSpecialDialog.this).writeData(bArr);
            }
        }

        class 5 implements Runnable {
            5() {
            }

            public void run() {
                EightAddFourEqSpecialDialog.access$2302(EightAddFourEqSpecialDialog.this, false);
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 3;
                bArr[3] = (byte) EightAddFourEqSpecialDialog.access$2400(EightAddFourEqSpecialDialog.this).getProgress();
                EightAddFourEqSpecialDialog.access$8600(EightAddFourEqSpecialDialog.this).writeData(bArr);
            }
        }

        class 6 implements Runnable {
            6() {
            }

            public void run() {
                EightAddFourEqSpecialDialog.access$2602(EightAddFourEqSpecialDialog.this, false);
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 4;
                bArr[3] = (byte) EightAddFourEqSpecialDialog.access$2700(EightAddFourEqSpecialDialog.this).getProgress();
                EightAddFourEqSpecialDialog.access$8700(EightAddFourEqSpecialDialog.this).writeData(bArr);
            }
        }

        class 7 implements Runnable {
            7() {
            }

            public void run() {
                EightAddFourEqSpecialDialog.access$2902(EightAddFourEqSpecialDialog.this, false);
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 5;
                bArr[3] = (byte) EightAddFourEqSpecialDialog.access$3000(EightAddFourEqSpecialDialog.this).getProgress();
                EightAddFourEqSpecialDialog.access$8800(EightAddFourEqSpecialDialog.this).writeData(bArr);
            }
        }

        class 8 implements Runnable {
            8() {
            }

            public void run() {
                EightAddFourEqSpecialDialog.access$3202(EightAddFourEqSpecialDialog.this, false);
                byte[] bArr = OrderSet.write_eq_value;
                bArr[2] = 6;
                bArr[3] = (byte) EightAddFourEqSpecialDialog.access$3300(EightAddFourEqSpecialDialog.this).getProgress();
                EightAddFourEqSpecialDialog.access$8900(EightAddFourEqSpecialDialog.this).writeData(bArr);
            }
        }

        class 9 implements Runnable {
            9() {
            }

            public void run() {
                EightAddFourEqSpecialDialog.access$3502(EightAddFourEqSpecialDialog.this, false);
                byte[] bArr = OrderSet.write_bass;
                bArr[2] = (byte) EightAddFourEqSpecialDialog.access$3600(EightAddFourEqSpecialDialog.this).getProgress();
                EightAddFourEqSpecialDialog.access$9000(EightAddFourEqSpecialDialog.this).writeData(bArr);
            }
        }

        class 10 implements Runnable {
            10() {
            }

            public void run() {
                EightAddFourEqSpecialDialog.access$7802(EightAddFourEqSpecialDialog.this, false);
                byte[] bArr = OrderSet.write_treble;
                bArr[2] = (byte) EightAddFourEqSpecialDialog.access$4400(EightAddFourEqSpecialDialog.this).getProgress();
                EightAddFourEqSpecialDialog.access$9100(EightAddFourEqSpecialDialog.this).writeData(bArr);
            }
        }

        class 11 implements Runnable {
            11() {
            }

            public void run() {
                EightAddFourEqSpecialDialog.access$3802(EightAddFourEqSpecialDialog.this, false);
                byte[] bArr = OrderSet.write_balance;
                bArr[2] = (byte) EightAddFourEqSpecialDialog.access$3900(EightAddFourEqSpecialDialog.this).getProgress();
                EightAddFourEqSpecialDialog.access$9200(EightAddFourEqSpecialDialog.this).writeData(bArr);
            }
        }

        class 12 implements Runnable {
            12() {
            }

            public void run() {
                EightAddFourEqSpecialDialog.access$4102(EightAddFourEqSpecialDialog.this, false);
                byte[] bArr = OrderSet.write_fade;
                bArr[2] = (byte) EightAddFourEqSpecialDialog.access$4200(EightAddFourEqSpecialDialog.this).getProgress();
                EightAddFourEqSpecialDialog.access$9300(EightAddFourEqSpecialDialog.this).writeData(bArr);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(2131492931, viewGroup, false);
        return this.mRootView;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mHandler = new Handler(Looper.myLooper());
        initView();
        initData();
        refreshEqType(this.mBaseViewModel.getEqType());
        List<EqRecord> find = LitePal.limit(10).find(EqRecord.class);
        if (find.size() == 10) {
            for (EqRecord eqRecord : find) {
                if (eqRecord.eq >= 0) {
                    switch (eqRecord.number) {
                        case 0:
                            this.sb_eq1.setProgress(eqRecord.eq);
                            break;
                        case 1:
                            this.sb_eq2.setProgress(eqRecord.eq);
                            break;
                        case 2:
                            this.sb_eq3.setProgress(eqRecord.eq);
                            break;
                        case 3:
                            this.sb_eq4.setProgress(eqRecord.eq);
                            break;
                        case 4:
                            this.sb_eq5.setProgress(eqRecord.eq);
                            break;
                        case 5:
                            this.sb_eq6.setProgress(eqRecord.eq);
                            break;
                        case 6:
                            this.sb_eq7.setProgress(eqRecord.eq);
                            break;
                        case 7:
                            this.sb_eqnew8.setProgress(eqRecord.eq);
                            break;
                        case 8:
                            this.sb_eq_bas.setProgress(eqRecord.eq);
                            break;
                        case 9:
                            this.sb_eq_tre.setProgress(eqRecord.eq);
                            break;
                        case 10:
                            this.sb_eq_bal.setProgress(eqRecord.eq);
                            break;
                        case 11:
                            this.sb_eq_fad.setProgress(eqRecord.eq);
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
            EightAddFourEqSpecialDialog.access$9400(EightAddFourEqSpecialDialog.this).writeData(OrderSet.write_synchronize);
        }
    }

    private void initView() {
        this.mRootView.findViewById(2131297075).setOnClickListener(this.mOnClickListener);
        this.mRootView.findViewById(2131297086).setOnClickListener(this.mOnClickListener);
        this.mRootView.findViewById(2131296364).setOnClickListener(this.mOnClickListener);
        this.view_mask_fad = this.mRootView.findViewById(2131297114);
        this.view_maskeq_0 = this.mRootView.findViewById(2131297116);
        this.view_maskeq_1 = this.mRootView.findViewById(2131297117);
        this.view_maskeq_2 = this.mRootView.findViewById(2131297118);
        this.view_maskeq_3 = this.mRootView.findViewById(2131297119);
        this.view_maskeq_4 = this.mRootView.findViewById(2131297120);
        this.view_maskeq_5 = this.mRootView.findViewById(2131297121);
        this.view_maskeq_6 = this.mRootView.findViewById(2131297122);
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
        CheckedTextView findViewById5 = this.mRootView.findViewById(2131296444);
        this.ctv_ten_eq_roc = findViewById5;
        findViewById5.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById6 = this.mRootView.findViewById(2131296445);
        this.ctv_ten_eq_rock = findViewById6;
        findViewById6.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById7 = this.mRootView.findViewById(2131296439);
        this.ctv_ten_eq_country = findViewById7;
        findViewById7.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById8 = this.mRootView.findViewById(2131296440);
        this.ctv_ten_eq_custom = findViewById8;
        findViewById8.setOnClickListener(this.mOnClickListener);
        SeekBar findViewById9 = this.mRootView.findViewById(2131296768);
        this.sb_eqnew8 = findViewById9;
        findViewById9.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById10 = this.mRootView.findViewById(2131296754);
        this.sb_eq1 = findViewById10;
        findViewById10.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById11 = this.mRootView.findViewById(2131296755);
        this.sb_eq2 = findViewById11;
        findViewById11.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById12 = this.mRootView.findViewById(2131296756);
        this.sb_eq3 = findViewById12;
        findViewById12.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById13 = this.mRootView.findViewById(2131296757);
        this.sb_eq4 = findViewById13;
        findViewById13.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById14 = this.mRootView.findViewById(2131296758);
        this.sb_eq5 = findViewById14;
        findViewById14.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById15 = this.mRootView.findViewById(2131296759);
        this.sb_eq6 = findViewById15;
        findViewById15.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById16 = this.mRootView.findViewById(2131296767);
        this.sb_eq7 = findViewById16;
        findViewById16.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById17 = this.mRootView.findViewById(2131296764);
        this.sb_eq_bas = findViewById17;
        findViewById17.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById18 = this.mRootView.findViewById(2131296766);
        this.sb_eq_tre = findViewById18;
        findViewById18.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById19 = this.mRootView.findViewById(2131296763);
        this.sb_eq_bal = findViewById19;
        findViewById19.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        SeekBar findViewById20 = this.mRootView.findViewById(2131296765);
        this.sb_eq_fad = findViewById20;
        findViewById20.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        this.tv_eq8 = this.mRootView.findViewById(2131296958);
        this.tv_eq1 = this.mRootView.findViewById(2131296936);
        this.tv_eq2 = this.mRootView.findViewById(2131296938);
        this.tv_eq3 = this.mRootView.findViewById(2131296940);
        this.tv_eq4 = this.mRootView.findViewById(2131296942);
        this.tv_eq5 = this.mRootView.findViewById(2131296944);
        this.tv_eq6 = this.mRootView.findViewById(2131296946);
        this.tv_eq7 = this.mRootView.findViewById(2131296957);
        View findViewById21 = this.mRootView.findViewById(2131297113);
        this.view_mask_bas = findViewById21;
        findViewById21.setOnClickListener(this.mOnClickListener);
        View findViewById22 = this.mRootView.findViewById(2131297115);
        this.view_mask_tre = findViewById22;
        findViewById22.setOnClickListener(this.mOnClickListener);
        this.tv_eqnew8_value = this.mRootView.findViewById(2131296964);
        this.tv_eq1_value = this.mRootView.findViewById(2131296937);
        this.tv_eq2_value = this.mRootView.findViewById(2131296939);
        this.tv_eq3_value = this.mRootView.findViewById(2131296941);
        this.tv_eq4_value = this.mRootView.findViewById(2131296943);
        this.tv_eq5_value = this.mRootView.findViewById(2131296945);
        this.tv_eq6_value = this.mRootView.findViewById(2131296947);
        this.tv_eq7_value = this.mRootView.findViewById(2131296963);
        this.tv_eqbas_value = this.mRootView.findViewById(2131296961);
        this.tv_eqtre_value = this.mRootView.findViewById(2131296965);
        this.tv_eqbal_value = this.mRootView.findViewById(2131296960);
        this.tv_eqfad_value = this.mRootView.findViewById(2131296962);
    }

    private void setBlaAndFad() {
        this.sb_eq_fad.setProgress(this.mBaseViewModel.getFade());
        this.sb_eq_bal.setProgress(this.mBaseViewModel.getBalance());
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
            EightAddFourEqSpecialDialog.access$9500(EightAddFourEqSpecialDialog.this).setItemVisibility();
        }
    }

    private void setBASTREMaskShow() {
        this.view_mask_bas.setVisibility(0);
        this.view_mask_tre.setVisibility(0);
        this.sb_eq_bas.setEnabled(false);
        this.sb_eq_tre.setEnabled(false);
    }

    private void setBASTREMaskHide() {
        this.view_mask_bas.setVisibility(8);
        this.view_mask_tre.setVisibility(8);
        this.sb_eq_bas.setEnabled(true);
        this.sb_eq_tre.setEnabled(true);
    }

    private void refreshEqStyle(int i) {
        this.mCuEqChoose = i;
        setEqMaskShow(true);
        setBASTREMaskShow();
        switch (i) {
            case 0:
                setBASTREMaskHide();
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

    private void setFadMaskShow() {
        View view = this.view_mask_fad;
        if (view == null) {
            return;
        }
        view.setVisibility(0);
        this.sb_eq_fad.setEnabled(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:172:0x0311  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void notice(java.lang.String r13, java.util.UUID r14, byte[] r15) {
        /*
            Method dump skipped, instructions count: 1634
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zddz.app.carlive.dialog.EightAddFourEqSpecialDialog.notice(java.lang.String, java.util.UUID, byte[]):void");
    }

    private void setEqMaskShow(Boolean bool) {
        View view = this.view_maskeq_0;
        if (view == null) {
            return;
        }
        view.setVisibility(bool.booleanValue() ? 0 : 4);
        this.view_maskeq_1.setVisibility(bool.booleanValue() ? 0 : 4);
        this.view_maskeq_2.setVisibility(bool.booleanValue() ? 0 : 4);
        this.view_maskeq_3.setVisibility(bool.booleanValue() ? 0 : 4);
        this.view_maskeq_4.setVisibility(bool.booleanValue() ? 0 : 4);
        this.view_maskeq_5.setVisibility(bool.booleanValue() ? 0 : 4);
        this.view_maskeq_6.setVisibility(bool.booleanValue() ? 0 : 4);
        this.sb_eqnew8.setEnabled(!bool.booleanValue());
        this.sb_eq1.setEnabled(!bool.booleanValue());
        this.sb_eq2.setEnabled(!bool.booleanValue());
        this.sb_eq3.setEnabled(!bool.booleanValue());
        this.sb_eq4.setEnabled(!bool.booleanValue());
        this.sb_eq5.setEnabled(!bool.booleanValue());
        this.sb_eq6.setEnabled(!bool.booleanValue());
        int i = this.mCuEqChoose;
        if (i == 0 || i == 7) {
            return;
        }
        this.sb_eqnew8.setProgress(7);
        this.sb_eq1.setProgress(7);
        this.sb_eq2.setProgress(7);
        this.sb_eq3.setProgress(7);
        this.sb_eq4.setProgress(7);
        this.sb_eq5.setProgress(7);
        this.sb_eq6.setProgress(7);
    }
}
