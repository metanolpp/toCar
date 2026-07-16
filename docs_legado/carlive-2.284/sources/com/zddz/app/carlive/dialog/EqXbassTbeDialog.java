package com.zddz.app.carlive.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
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
public class EqXbassTbeDialog extends BaseDialog {
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
    TextView tv_bass1;
    TextView tv_bass2;
    TextView tv_bass3;
    TextView tv_bass_off;
    private TextView tv_bass_value;
    private TextView tv_fade_value;
    TextView tv_tbe1;
    TextView tv_tbe2;
    TextView tv_tbe3;
    TextView tv_tbe_off;
    private TextView tv_treble_value;
    private int TBE_OFF = 0;
    private int TBE_1 = 1;
    private int TBE_2 = 2;
    private int TBE_3 = 3;
    private int BASS_OFF = 0;
    private int BASS_1 = 1;
    private int BASS_2 = 2;
    private int BASS_3 = 3;
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

    static /* synthetic */ IMain access$000(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.mIMain;
    }

    static /* synthetic */ int access$100(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.TBE_OFF;
    }

    static /* synthetic */ int access$1000(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.BASS_3;
    }

    static /* synthetic */ IMain access$1100(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.mIMain;
    }

    static /* synthetic */ IMain access$1200(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.mIMain;
    }

    static /* synthetic */ IMain access$1300(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.mIMain;
    }

    static /* synthetic */ IMain access$1400(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.mIMain;
    }

    static /* synthetic */ IMain access$1500(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.mIMain;
    }

    static /* synthetic */ IMain access$1600(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.mIMain;
    }

    static /* synthetic */ boolean access$1700(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.mBassBarMove;
    }

    static /* synthetic */ boolean access$1702(EqXbassTbeDialog eqXbassTbeDialog, boolean z) {
        eqXbassTbeDialog.mBassBarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$1800(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.sb_bass;
    }

    static /* synthetic */ IMain access$1900(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.mIMain;
    }

    static /* synthetic */ void access$200(EqXbassTbeDialog eqXbassTbeDialog, int i) {
        eqXbassTbeDialog.sendTBEData(i);
    }

    static /* synthetic */ Handler access$2000(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.mHandler;
    }

    static /* synthetic */ boolean access$2100(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.mTrebleBarMove;
    }

    static /* synthetic */ boolean access$2102(EqXbassTbeDialog eqXbassTbeDialog, boolean z) {
        eqXbassTbeDialog.mTrebleBarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$2200(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.sb_treble;
    }

    static /* synthetic */ IMain access$2300(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.mIMain;
    }

    static /* synthetic */ boolean access$2400(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.mBalanceBarMove;
    }

    static /* synthetic */ boolean access$2402(EqXbassTbeDialog eqXbassTbeDialog, boolean z) {
        eqXbassTbeDialog.mBalanceBarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$2500(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.sb_balance;
    }

    static /* synthetic */ IMain access$2600(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.mIMain;
    }

    static /* synthetic */ boolean access$2700(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.mFadeBarMove;
    }

    static /* synthetic */ boolean access$2702(EqXbassTbeDialog eqXbassTbeDialog, boolean z) {
        eqXbassTbeDialog.mFadeBarMove = z;
        return z;
    }

    static /* synthetic */ SeekBar access$2800(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.sb_fade;
    }

    static /* synthetic */ IMain access$2900(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.mIMain;
    }

    static /* synthetic */ int access$300(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.TBE_1;
    }

    static /* synthetic */ boolean access$3002(EqXbassTbeDialog eqXbassTbeDialog, boolean z) {
        eqXbassTbeDialog.mBassFromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$3100(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.tv_bass_value;
    }

    static /* synthetic */ boolean access$3202(EqXbassTbeDialog eqXbassTbeDialog, boolean z) {
        eqXbassTbeDialog.mTrebleFromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$3300(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.tv_treble_value;
    }

    static /* synthetic */ boolean access$3402(EqXbassTbeDialog eqXbassTbeDialog, boolean z) {
        eqXbassTbeDialog.mBalanceFromUser = z;
        return z;
    }

    static /* synthetic */ BaseViewModel access$3500(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.mBaseViewModel;
    }

    static /* synthetic */ TextView access$3600(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.tv_balance_value;
    }

    static /* synthetic */ boolean access$3702(EqXbassTbeDialog eqXbassTbeDialog, boolean z) {
        eqXbassTbeDialog.mFadeFromUser = z;
        return z;
    }

    static /* synthetic */ BaseViewModel access$3800(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.mBaseViewModel;
    }

    static /* synthetic */ TextView access$3900(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.tv_fade_value;
    }

    static /* synthetic */ int access$400(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.TBE_2;
    }

    static /* synthetic */ Runnable access$4000(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.mBassRunnable;
    }

    static /* synthetic */ Runnable access$4100(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.mTrebleRunnable;
    }

    static /* synthetic */ Runnable access$4200(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.mBalanceRunnable;
    }

    static /* synthetic */ Runnable access$4300(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.mFadeRunnable;
    }

    static /* synthetic */ IMain access$4400(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.mIMain;
    }

    static /* synthetic */ IMain access$4500(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.mIMain;
    }

    static /* synthetic */ IMain access$4600(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.mIMain;
    }

    static /* synthetic */ IMain access$4700(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.mIMain;
    }

    static /* synthetic */ IMain access$4800(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.mIMain;
    }

    static /* synthetic */ int access$500(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.TBE_3;
    }

    static /* synthetic */ int access$600(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.BASS_OFF;
    }

    static /* synthetic */ void access$700(EqXbassTbeDialog eqXbassTbeDialog, int i) {
        eqXbassTbeDialog.sendBASSData(i);
    }

    static /* synthetic */ int access$800(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.BASS_1;
    }

    static /* synthetic */ int access$900(EqXbassTbeDialog eqXbassTbeDialog) {
        return eqXbassTbeDialog.BASS_2;
    }

    class 1 implements View.OnClickListener {
        1() {
        }

        public void onClick(View view) {
            int id = view.getId();
            if (id == 2131297075) {
                EqXbassTbeDialog.access$000(EqXbassTbeDialog.this).setItemVisibility();
                EqXbassTbeDialog.this.dismiss();
                return;
            }
            if (id == 2131297045) {
                EqXbassTbeDialog eqXbassTbeDialog = EqXbassTbeDialog.this;
                EqXbassTbeDialog.access$200(eqXbassTbeDialog, EqXbassTbeDialog.access$100(eqXbassTbeDialog));
                return;
            }
            if (id == 2131297042) {
                EqXbassTbeDialog eqXbassTbeDialog2 = EqXbassTbeDialog.this;
                EqXbassTbeDialog.access$200(eqXbassTbeDialog2, EqXbassTbeDialog.access$300(eqXbassTbeDialog2));
                return;
            }
            if (id == 2131297043) {
                EqXbassTbeDialog eqXbassTbeDialog3 = EqXbassTbeDialog.this;
                EqXbassTbeDialog.access$200(eqXbassTbeDialog3, EqXbassTbeDialog.access$400(eqXbassTbeDialog3));
                return;
            }
            if (id == 2131297044) {
                EqXbassTbeDialog eqXbassTbeDialog4 = EqXbassTbeDialog.this;
                EqXbassTbeDialog.access$200(eqXbassTbeDialog4, EqXbassTbeDialog.access$500(eqXbassTbeDialog4));
                return;
            }
            if (id == 2131296909) {
                EqXbassTbeDialog eqXbassTbeDialog5 = EqXbassTbeDialog.this;
                EqXbassTbeDialog.access$700(eqXbassTbeDialog5, EqXbassTbeDialog.access$600(eqXbassTbeDialog5));
                return;
            }
            if (id == 2131296906) {
                EqXbassTbeDialog eqXbassTbeDialog6 = EqXbassTbeDialog.this;
                EqXbassTbeDialog.access$700(eqXbassTbeDialog6, EqXbassTbeDialog.access$800(eqXbassTbeDialog6));
                return;
            }
            if (id == 2131296907) {
                EqXbassTbeDialog eqXbassTbeDialog7 = EqXbassTbeDialog.this;
                EqXbassTbeDialog.access$700(eqXbassTbeDialog7, EqXbassTbeDialog.access$900(eqXbassTbeDialog7));
                return;
            }
            if (id == 2131296908) {
                EqXbassTbeDialog eqXbassTbeDialog8 = EqXbassTbeDialog.this;
                EqXbassTbeDialog.access$700(eqXbassTbeDialog8, EqXbassTbeDialog.access$1000(eqXbassTbeDialog8));
                return;
            }
            if (id == 2131296431) {
                EqXbassTbeDialog.access$1100(EqXbassTbeDialog.this).writeData(OrderSet.write_eq_style_normal);
                return;
            }
            if (id == 2131296434) {
                EqXbassTbeDialog.access$1200(EqXbassTbeDialog.this).writeData(OrderSet.write_eq_style_popular);
                return;
            }
            if (id == 2131296436) {
                EqXbassTbeDialog.access$1300(EqXbassTbeDialog.this).writeData(OrderSet.write_eq_style_rock);
                return;
            }
            if (id == 2131296428) {
                EqXbassTbeDialog.access$1400(EqXbassTbeDialog.this).writeData(OrderSet.write_eq_style_jazz);
            } else if (id == 2131296419) {
                EqXbassTbeDialog.access$1500(EqXbassTbeDialog.this).writeData(OrderSet.write_eq_style_classic);
            } else if (id == 2131296420) {
                EqXbassTbeDialog.access$1600(EqXbassTbeDialog.this).writeData(OrderSet.write_eq_style_country);
            }
        }
    }

    private void sendTBEData(int i) {
        byte[] bArr = OrderSet.write_eq_tbe;
        bArr[2] = (byte) i;
        this.mIMain.writeData(bArr);
    }

    private void sendBASSData(int i) {
        byte[] bArr = OrderSet.write_eq_bass;
        bArr[2] = (byte) i;
        this.mIMain.writeData(bArr);
    }

    class 2 implements Runnable {
        2() {
        }

        public void run() {
            if (EqXbassTbeDialog.access$1700(EqXbassTbeDialog.this)) {
                byte[] bArr = OrderSet.write_bass;
                bArr[2] = (byte) EqXbassTbeDialog.access$1800(EqXbassTbeDialog.this).getProgress();
                EqXbassTbeDialog.access$1900(EqXbassTbeDialog.this).writeData(bArr);
                EqXbassTbeDialog.access$2000(EqXbassTbeDialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 3 implements Runnable {
        3() {
        }

        public void run() {
            if (EqXbassTbeDialog.access$2100(EqXbassTbeDialog.this)) {
                byte[] bArr = OrderSet.write_treble;
                bArr[2] = (byte) EqXbassTbeDialog.access$2200(EqXbassTbeDialog.this).getProgress();
                EqXbassTbeDialog.access$2300(EqXbassTbeDialog.this).writeData(bArr);
                EqXbassTbeDialog.access$2000(EqXbassTbeDialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 4 implements Runnable {
        4() {
        }

        public void run() {
            if (EqXbassTbeDialog.access$2400(EqXbassTbeDialog.this)) {
                byte[] bArr = OrderSet.write_balance;
                bArr[2] = (byte) EqXbassTbeDialog.access$2500(EqXbassTbeDialog.this).getProgress();
                EqXbassTbeDialog.access$2600(EqXbassTbeDialog.this).writeData(bArr);
                EqXbassTbeDialog.access$2000(EqXbassTbeDialog.this).postDelayed(this, 200L);
            }
        }
    }

    class 5 implements Runnable {
        5() {
        }

        public void run() {
            if (EqXbassTbeDialog.access$2700(EqXbassTbeDialog.this)) {
                byte[] bArr = OrderSet.write_fade;
                bArr[2] = (byte) EqXbassTbeDialog.access$2800(EqXbassTbeDialog.this).getProgress();
                EqXbassTbeDialog.access$2900(EqXbassTbeDialog.this).writeData(bArr);
                EqXbassTbeDialog.access$2000(EqXbassTbeDialog.this).postDelayed(this, 200L);
            }
        }
    }

    private void setTbeShow(int i) {
        if (this.tv_tbe_off == null || getActivity() == null) {
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

    private void setBassShow(int i) {
        if (this.tv_bass_off == null || getActivity() == null) {
            return;
        }
        int parseColor = Color.parseColor("#013D57");
        int parseColor2 = Color.parseColor("#ffffff");
        Drawable drawable = getResources().getDrawable(2131230907);
        Drawable drawable2 = getResources().getDrawable(2131230908);
        this.tv_bass_off.setBackground(i == this.BASS_OFF ? drawable2 : drawable);
        this.tv_bass1.setBackground(i == this.BASS_1 ? drawable2 : drawable);
        this.tv_bass2.setBackground(i == this.BASS_2 ? drawable2 : drawable);
        TextView textView = this.tv_bass3;
        if (i == this.BASS_3) {
            drawable = drawable2;
        }
        textView.setBackground(drawable);
        this.tv_bass_off.setTextColor(i == this.BASS_OFF ? parseColor : parseColor2);
        this.tv_bass1.setTextColor(i == this.BASS_1 ? parseColor : parseColor2);
        this.tv_bass2.setTextColor(i == this.BASS_2 ? parseColor : parseColor2);
        TextView textView2 = this.tv_bass3;
        if (i != this.BASS_2) {
            parseColor = parseColor2;
        }
        textView2.setTextColor(parseColor);
    }

    class 6 implements SeekBar.OnSeekBarChangeListener {
        6() {
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            int progress = seekBar.getProgress();
            int id = seekBar.getId();
            if (id == 2131296752) {
                EqXbassTbeDialog.access$3002(EqXbassTbeDialog.this, z);
                EqXbassTbeDialog.access$3100(EqXbassTbeDialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296771) {
                EqXbassTbeDialog.access$3202(EqXbassTbeDialog.this, z);
                EqXbassTbeDialog.access$3300(EqXbassTbeDialog.this).setText(String.valueOf(progress - 7));
                return;
            }
            if (id == 2131296751) {
                EqXbassTbeDialog.access$3402(EqXbassTbeDialog.this, z);
                int balanceMax = progress - EqXbassTbeDialog.access$3500(EqXbassTbeDialog.this).getBalanceMax();
                if (balanceMax < 0) {
                    EqXbassTbeDialog.access$3600(EqXbassTbeDialog.this).setText("L" + String.valueOf(balanceMax).replace("-", ""));
                    return;
                }
                EqXbassTbeDialog.access$3600(EqXbassTbeDialog.this).setText("R" + balanceMax);
                return;
            }
            if (id == 2131296769) {
                EqXbassTbeDialog.access$3702(EqXbassTbeDialog.this, z);
                int fadeMax = progress - EqXbassTbeDialog.access$3800(EqXbassTbeDialog.this).getFadeMax();
                if (fadeMax < 0) {
                    EqXbassTbeDialog.access$3900(EqXbassTbeDialog.this).setText("R" + String.valueOf(fadeMax).replace("-", ""));
                    return;
                }
                EqXbassTbeDialog.access$3900(EqXbassTbeDialog.this).setText("F" + fadeMax);
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            int id = seekBar.getId();
            if (id == 2131296752) {
                EqXbassTbeDialog.access$1702(EqXbassTbeDialog.this, true);
                EqXbassTbeDialog.access$2000(EqXbassTbeDialog.this).postDelayed(EqXbassTbeDialog.access$4000(EqXbassTbeDialog.this), 200L);
                return;
            }
            if (id == 2131296771) {
                EqXbassTbeDialog.access$2102(EqXbassTbeDialog.this, true);
                EqXbassTbeDialog.access$2000(EqXbassTbeDialog.this).postDelayed(EqXbassTbeDialog.access$4100(EqXbassTbeDialog.this), 200L);
            } else if (id == 2131296751) {
                EqXbassTbeDialog.access$2402(EqXbassTbeDialog.this, true);
                EqXbassTbeDialog.access$2000(EqXbassTbeDialog.this).postDelayed(EqXbassTbeDialog.access$4200(EqXbassTbeDialog.this), 200L);
            } else if (id == 2131296769) {
                EqXbassTbeDialog.access$2702(EqXbassTbeDialog.this, true);
                EqXbassTbeDialog.access$2000(EqXbassTbeDialog.this).postDelayed(EqXbassTbeDialog.access$4300(EqXbassTbeDialog.this), 200L);
            }
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            int id = seekBar.getId();
            if (id == 2131296752) {
                EqXbassTbeDialog.access$1702(EqXbassTbeDialog.this, false);
                try {
                    EqXbassTbeDialog.access$2000(EqXbassTbeDialog.this).removeCallbacks(EqXbassTbeDialog.access$4000(EqXbassTbeDialog.this));
                    EqXbassTbeDialog.access$2000(EqXbassTbeDialog.this).postDelayed(new 1(), 300L);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            if (id == 2131296771) {
                EqXbassTbeDialog.access$2102(EqXbassTbeDialog.this, false);
                try {
                    EqXbassTbeDialog.access$2000(EqXbassTbeDialog.this).removeCallbacks(EqXbassTbeDialog.access$4100(EqXbassTbeDialog.this));
                    EqXbassTbeDialog.access$2000(EqXbassTbeDialog.this).postDelayed(new 2(), 300L);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (id == 2131296751) {
                EqXbassTbeDialog.access$2402(EqXbassTbeDialog.this, false);
                try {
                    EqXbassTbeDialog.access$2000(EqXbassTbeDialog.this).removeCallbacks(EqXbassTbeDialog.access$4200(EqXbassTbeDialog.this));
                    EqXbassTbeDialog.access$2000(EqXbassTbeDialog.this).postDelayed(new 3(), 300L);
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            if (id == 2131296769) {
                EqXbassTbeDialog.access$2702(EqXbassTbeDialog.this, false);
                try {
                    EqXbassTbeDialog.access$2000(EqXbassTbeDialog.this).removeCallbacks(EqXbassTbeDialog.access$4300(EqXbassTbeDialog.this));
                    EqXbassTbeDialog.access$2000(EqXbassTbeDialog.this).postDelayed(new 4(), 300L);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }

        class 1 implements Runnable {
            1() {
            }

            public void run() {
                EqXbassTbeDialog.access$3002(EqXbassTbeDialog.this, false);
                byte[] bArr = OrderSet.write_bass;
                bArr[2] = (byte) EqXbassTbeDialog.access$1800(EqXbassTbeDialog.this).getProgress();
                EqXbassTbeDialog.access$4400(EqXbassTbeDialog.this).writeData(bArr);
            }
        }

        class 2 implements Runnable {
            2() {
            }

            public void run() {
                EqXbassTbeDialog.access$3202(EqXbassTbeDialog.this, false);
                byte[] bArr = OrderSet.write_treble;
                bArr[2] = (byte) EqXbassTbeDialog.access$2200(EqXbassTbeDialog.this).getProgress();
                EqXbassTbeDialog.access$4500(EqXbassTbeDialog.this).writeData(bArr);
            }
        }

        class 3 implements Runnable {
            3() {
            }

            public void run() {
                EqXbassTbeDialog.access$3402(EqXbassTbeDialog.this, false);
                byte[] bArr = OrderSet.write_balance;
                bArr[2] = (byte) EqXbassTbeDialog.access$2500(EqXbassTbeDialog.this).getProgress();
                EqXbassTbeDialog.access$4600(EqXbassTbeDialog.this).writeData(bArr);
            }
        }

        class 4 implements Runnable {
            4() {
            }

            public void run() {
                EqXbassTbeDialog.access$3702(EqXbassTbeDialog.this, false);
                byte[] bArr = OrderSet.write_fade;
                bArr[2] = (byte) EqXbassTbeDialog.access$2800(EqXbassTbeDialog.this).getProgress();
                EqXbassTbeDialog.access$4700(EqXbassTbeDialog.this).writeData(bArr);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(2131492919, viewGroup, false);
        return this.mRootView;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mHandler = new Handler(Looper.myLooper());
        this.tv_tbe_off = this.mRootView.findViewById(2131297045);
        this.tv_tbe1 = this.mRootView.findViewById(2131297042);
        this.tv_tbe2 = this.mRootView.findViewById(2131297043);
        this.tv_tbe3 = this.mRootView.findViewById(2131297044);
        this.tv_tbe1.setOnClickListener(this.mOnClickListener);
        this.tv_tbe2.setOnClickListener(this.mOnClickListener);
        this.tv_tbe3.setOnClickListener(this.mOnClickListener);
        this.tv_tbe_off.setOnClickListener(this.mOnClickListener);
        this.tv_bass_off = this.mRootView.findViewById(2131296909);
        this.tv_bass1 = this.mRootView.findViewById(2131296906);
        this.tv_bass2 = this.mRootView.findViewById(2131296907);
        this.tv_bass3 = this.mRootView.findViewById(2131296908);
        this.tv_bass1.setOnClickListener(this.mOnClickListener);
        this.tv_bass2.setOnClickListener(this.mOnClickListener);
        this.tv_bass3.setOnClickListener(this.mOnClickListener);
        this.tv_bass_off.setOnClickListener(this.mOnClickListener);
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
        this.mRootView.findViewById(2131297075).setOnClickListener(this.mOnClickListener);
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
        this.sb_bass.setMax(this.mBaseViewModel.getBassMax() * 2);
        this.sb_treble.setMax(this.mBaseViewModel.getTrebleMax() * 2);
        this.sb_balance.setMax(this.mBaseViewModel.getBalanceMax() * 2);
        this.sb_fade.setMax(this.mBaseViewModel.getFadeMax() * 2);
        refreshEqStyle(this.mBaseViewModel.getEqStyle());
        this.sb_fade.setEnabled(this.mBaseViewModel.getFadeSupport());
        initData();
    }

    private void initData() {
        this.mBaseViewModel.bassValue.observe(getViewLifecycleOwner(), new EqXbassTbeDialog$$ExternalSyntheticLambda0(this));
        this.mBaseViewModel.tbeValue.observe(getViewLifecycleOwner(), new EqXbassTbeDialog$$ExternalSyntheticLambda1(this));
    }

    /* synthetic */ void lambda$initData$0$com-zddz-app-carlive-dialog-EqXbassTbeDialog(Integer num) {
        setBassShow(num.intValue());
    }

    /* synthetic */ void lambda$initData$1$com-zddz-app-carlive-dialog-EqXbassTbeDialog(Integer num) {
        setTbeShow(num.intValue());
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
            EqXbassTbeDialog.access$4800(EqXbassTbeDialog.this).setItemVisibility();
        }
    }

    private void refreshEqType(int i) {
        if (i == 1 || i == 2) {
            new DspDialog().show(getChildFragmentManager(), "DspDialog");
            this.mIMain.setItemVisibility();
            dismiss();
        } else if (i == 3 || i == 4 || i == 5 || i == 6) {
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
                    if (upperCase.startsWith(OrderSet.notice_ten_eq_tbe)) {
                        setTbeShow(Integer.valueOf(upperCase.substring(4, 6), 16).intValue());
                        return;
                    }
                    if (upperCase.startsWith(OrderSet.notice_ten_eq_bass)) {
                        setBassShow(Integer.valueOf(upperCase.substring(4, 6), 16).intValue());
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
