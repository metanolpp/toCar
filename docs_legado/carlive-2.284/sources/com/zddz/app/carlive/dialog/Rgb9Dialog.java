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
public class Rgb9Dialog extends BaseDialog {
    private TextView tv_auto;
    private TextView tv_blue;
    private TextView tv_green;
    private TextView tv_magenta;
    private TextView tv_red;
    private TextView tv_sky;
    private TextView tv_white;
    private TextView tv_yellow;
    private View view_org;
    private byte second = 0;
    private View.OnClickListener mOnClickListener = new 1();

    private void refreshLight(int i) {
    }

    static /* synthetic */ IMain access$000(Rgb9Dialog rgb9Dialog) {
        return rgb9Dialog.mIMain;
    }

    static /* synthetic */ IMain access$100(Rgb9Dialog rgb9Dialog) {
        return rgb9Dialog.mIMain;
    }

    static /* synthetic */ IMain access$1000(Rgb9Dialog rgb9Dialog) {
        return rgb9Dialog.mIMain;
    }

    static /* synthetic */ IMain access$200(Rgb9Dialog rgb9Dialog) {
        return rgb9Dialog.mIMain;
    }

    static /* synthetic */ IMain access$300(Rgb9Dialog rgb9Dialog) {
        return rgb9Dialog.mIMain;
    }

    static /* synthetic */ IMain access$400(Rgb9Dialog rgb9Dialog) {
        return rgb9Dialog.mIMain;
    }

    static /* synthetic */ IMain access$500(Rgb9Dialog rgb9Dialog) {
        return rgb9Dialog.mIMain;
    }

    static /* synthetic */ IMain access$600(Rgb9Dialog rgb9Dialog) {
        return rgb9Dialog.mIMain;
    }

    static /* synthetic */ IMain access$700(Rgb9Dialog rgb9Dialog) {
        return rgb9Dialog.mIMain;
    }

    static /* synthetic */ IMain access$800(Rgb9Dialog rgb9Dialog) {
        return rgb9Dialog.mIMain;
    }

    static /* synthetic */ IMain access$900(Rgb9Dialog rgb9Dialog) {
        return rgb9Dialog.mIMain;
    }

    class 1 implements View.OnClickListener {
        1() {
        }

        public void onClick(View view) {
            int id = view.getId();
            if (id == 2131297078) {
                Rgb9Dialog.access$000(Rgb9Dialog.this).setItemVisibility();
                Rgb9Dialog.this.dismiss();
                return;
            }
            if (id == 2131297025) {
                Rgb9Dialog.access$100(Rgb9Dialog.this).writeData(OrderSet.write_201red);
                return;
            }
            if (id == 2131296912) {
                Rgb9Dialog.access$200(Rgb9Dialog.this).writeData(OrderSet.write_201blue);
                return;
            }
            if (id == 2131297127) {
                Rgb9Dialog.access$300(Rgb9Dialog.this).writeData(OrderSet.write_201org);
                return;
            }
            if (id == 2131296987) {
                Rgb9Dialog.access$400(Rgb9Dialog.this).writeData(OrderSet.write_201green);
                return;
            }
            if (id == 2131297065) {
                Rgb9Dialog.access$500(Rgb9Dialog.this).writeData(OrderSet.write_201yellow);
                return;
            }
            if (id == 2131297030) {
                Rgb9Dialog.access$600(Rgb9Dialog.this).writeData(OrderSet.write_201sky);
                return;
            }
            if (id == 2131297003) {
                Rgb9Dialog.access$700(Rgb9Dialog.this).writeData(OrderSet.write_201magenta);
            } else if (id == 2131297063) {
                Rgb9Dialog.access$800(Rgb9Dialog.this).writeData(OrderSet.write_201white);
            } else if (id == 2131296899) {
                Rgb9Dialog.access$900(Rgb9Dialog.this).writeData(OrderSet.write_201auto);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(2131492925, viewGroup, false);
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
        this.tv_auto = this.mRootView.findViewById(2131296899);
        View findViewById8 = this.mRootView.findViewById(2131297127);
        this.view_org = findViewById8;
        findViewById8.setOnClickListener(this.mOnClickListener);
        this.tv_auto.setOnClickListener(this.mOnClickListener);
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
            Rgb9Dialog.access$1000(Rgb9Dialog.this).setItemVisibility();
        }
    }

    public void notice(String str, UUID uuid, byte[] bArr) {
        try {
            Convert.bytesToHexString(bArr).toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
