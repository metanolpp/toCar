package com.zddz.app.carlive.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.zddz.app.carlive.OrderSet;
import com.zddz.app.carlive.fragment.BaseDialog;
import com.zddz.app.carlive.fragment.IMain;
import com.zddz.bt.Convert;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class RgbDialog extends BaseDialog {
    private TextView tv_auto;
    private TextView tv_blue;
    private TextView tv_green;
    private TextView tv_magenta;
    private TextView tv_red;
    private TextView tv_sky;
    private TextView tv_white;
    private TextView tv_yellow;
    private byte second = 0;
    private View.OnClickListener mOnClickListener = new 1();

    static /* synthetic */ IMain access$000(RgbDialog rgbDialog) {
        return rgbDialog.mIMain;
    }

    static /* synthetic */ byte access$100(RgbDialog rgbDialog) {
        return rgbDialog.second;
    }

    static /* synthetic */ IMain access$1000(RgbDialog rgbDialog) {
        return rgbDialog.mIMain;
    }

    static /* synthetic */ IMain access$200(RgbDialog rgbDialog) {
        return rgbDialog.mIMain;
    }

    static /* synthetic */ IMain access$300(RgbDialog rgbDialog) {
        return rgbDialog.mIMain;
    }

    static /* synthetic */ IMain access$400(RgbDialog rgbDialog) {
        return rgbDialog.mIMain;
    }

    static /* synthetic */ IMain access$500(RgbDialog rgbDialog) {
        return rgbDialog.mIMain;
    }

    static /* synthetic */ IMain access$600(RgbDialog rgbDialog) {
        return rgbDialog.mIMain;
    }

    static /* synthetic */ IMain access$700(RgbDialog rgbDialog) {
        return rgbDialog.mIMain;
    }

    static /* synthetic */ IMain access$800(RgbDialog rgbDialog) {
        return rgbDialog.mIMain;
    }

    static /* synthetic */ IMain access$900(RgbDialog rgbDialog) {
        return rgbDialog.mIMain;
    }

    class 1 implements View.OnClickListener {
        1() {
        }

        public void onClick(View view) {
            int id = view.getId();
            if (id == 2131297078) {
                RgbDialog.access$000(RgbDialog.this).setItemVisibility();
                RgbDialog.this.dismiss();
                return;
            }
            if (id == 2131297025) {
                byte[] bArr = OrderSet.write_red;
                bArr[1] = RgbDialog.access$100(RgbDialog.this);
                RgbDialog.access$200(RgbDialog.this).writeData(bArr);
                return;
            }
            if (id == 2131296912) {
                byte[] bArr2 = OrderSet.write_blue;
                bArr2[1] = RgbDialog.access$100(RgbDialog.this);
                RgbDialog.access$300(RgbDialog.this).writeData(bArr2);
                return;
            }
            if (id == 2131296987) {
                byte[] bArr3 = OrderSet.write_green;
                bArr3[1] = RgbDialog.access$100(RgbDialog.this);
                RgbDialog.access$400(RgbDialog.this).writeData(bArr3);
                return;
            }
            if (id == 2131297065) {
                byte[] bArr4 = OrderSet.write_yellow;
                bArr4[1] = RgbDialog.access$100(RgbDialog.this);
                RgbDialog.access$500(RgbDialog.this).writeData(bArr4);
                return;
            }
            if (id == 2131297030) {
                byte[] bArr5 = OrderSet.write_sky;
                bArr5[1] = RgbDialog.access$100(RgbDialog.this);
                RgbDialog.access$600(RgbDialog.this).writeData(bArr5);
                return;
            }
            if (id == 2131297003) {
                byte[] bArr6 = OrderSet.write_magenta;
                bArr6[1] = RgbDialog.access$100(RgbDialog.this);
                RgbDialog.access$700(RgbDialog.this).writeData(bArr6);
            } else if (id == 2131297063) {
                byte[] bArr7 = OrderSet.write_white;
                bArr7[1] = RgbDialog.access$100(RgbDialog.this);
                RgbDialog.access$800(RgbDialog.this).writeData(bArr7);
            } else if (id == 2131296899) {
                byte[] bArr8 = OrderSet.write_auto;
                bArr8[1] = RgbDialog.access$100(RgbDialog.this);
                RgbDialog.access$900(RgbDialog.this).writeData(bArr8);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(2131492924, viewGroup, false);
        return this.mRootView;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        TextView findViewById = this.mRootView.findViewById(2131297025);
        this.tv_red = findViewById;
        findViewById.setOnClickListener(this.mOnClickListener);
        TextView findViewById2 = this.mRootView.findViewById(2131296912);
        this.tv_blue = findViewById2;
        findViewById2.setOnClickListener(this.mOnClickListener);
        TextView findViewById3 = this.mRootView.findViewById(2131296987);
        this.tv_green = findViewById3;
        findViewById3.setOnClickListener(this.mOnClickListener);
        TextView findViewById4 = this.mRootView.findViewById(2131297003);
        this.tv_magenta = findViewById4;
        findViewById4.setOnClickListener(this.mOnClickListener);
        TextView findViewById5 = this.mRootView.findViewById(2131297065);
        this.tv_yellow = findViewById5;
        findViewById5.setOnClickListener(this.mOnClickListener);
        TextView findViewById6 = this.mRootView.findViewById(2131297030);
        this.tv_sky = findViewById6;
        findViewById6.setOnClickListener(this.mOnClickListener);
        TextView findViewById7 = this.mRootView.findViewById(2131297063);
        this.tv_white = findViewById7;
        findViewById7.setOnClickListener(this.mOnClickListener);
        TextView findViewById8 = this.mRootView.findViewById(2131296899);
        this.tv_auto = findViewById8;
        findViewById8.setOnClickListener(this.mOnClickListener);
        this.mRootView.findViewById(2131297078).setOnClickListener(this.mOnClickListener);
        refreshLight(this.mBaseViewModel.getLightType());
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
            dialog.setOnDismissListener(new 2());
        }
    }

    class 2 implements DialogInterface.OnDismissListener {
        2() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            RgbDialog.access$1000(RgbDialog.this).setItemVisibility();
        }
    }

    private void refreshLight(int i) {
        if (i == 0) {
            this.mIMain.setItemVisibility();
            dismiss();
            return;
        }
        if (i == 1) {
            this.second = (byte) 1;
            this.tv_red.setVisibility(0);
            this.tv_green.setVisibility(0);
            this.tv_blue.setVisibility(0);
            this.tv_yellow.setVisibility(0);
            this.tv_magenta.setVisibility(0);
            this.tv_sky.setVisibility(0);
            this.tv_white.setVisibility(0);
            return;
        }
        if (i == 2) {
            this.second = (byte) 2;
            this.tv_red.setVisibility(0);
            this.tv_green.setVisibility(0);
            this.tv_blue.setVisibility(4);
            this.tv_yellow.setVisibility(0);
            this.tv_magenta.setVisibility(4);
            this.tv_sky.setVisibility(4);
            this.tv_white.setVisibility(4);
            return;
        }
        if (i == 3) {
            this.second = (byte) 3;
            this.tv_red.setVisibility(0);
            this.tv_green.setVisibility(4);
            this.tv_blue.setVisibility(0);
            this.tv_yellow.setVisibility(4);
            this.tv_magenta.setVisibility(4);
            this.tv_sky.setVisibility(0);
            this.tv_white.setVisibility(4);
            return;
        }
        if (i != 4) {
            return;
        }
        this.second = (byte) 4;
        this.tv_red.setVisibility(4);
        this.tv_green.setVisibility(0);
        this.tv_blue.setVisibility(0);
        this.tv_yellow.setVisibility(4);
        this.tv_magenta.setVisibility(0);
        this.tv_sky.setVisibility(4);
        this.tv_white.setVisibility(4);
    }

    public void notice(String str, UUID uuid, byte[] bArr) {
        try {
            String upperCase = Convert.bytesToHexString(bArr).toUpperCase();
            if (upperCase.startsWith(OrderSet.notice_no_light)) {
                refreshLight(0);
            } else if (upperCase.startsWith(OrderSet.notice_rgb)) {
                refreshLight(1);
            } else if (upperCase.startsWith(OrderSet.notice_rg)) {
                refreshLight(2);
            } else if (upperCase.startsWith(OrderSet.notice_rb)) {
                refreshLight(4);
            } else if (upperCase.startsWith(OrderSet.notice_gb)) {
                refreshLight(3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
