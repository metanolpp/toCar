package com.zddz.app.carlive.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.hjq.toast.ToastUtils;
import com.zddz.app.carlive.OrderSet;
import com.zddz.app.carlive.fragment.BaseDialog;
import com.zddz.app.carlive.fragment.IMain;
import com.zddz.bt.Convert;
import com.zddz.widget.NoAnimateEditText;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class ChooseMusicDialog extends BaseDialog {
    private NoAnimateEditText edt_music_num;
    private View.OnClickListener mOnClickListener = new 1();
    private TextView tv_comfirm;
    private View view_empty;

    static /* synthetic */ NoAnimateEditText access$000(ChooseMusicDialog chooseMusicDialog) {
        return chooseMusicDialog.edt_music_num;
    }

    static /* synthetic */ IMain access$100(ChooseMusicDialog chooseMusicDialog) {
        return chooseMusicDialog.mIMain;
    }

    static /* synthetic */ IMain access$200(ChooseMusicDialog chooseMusicDialog) {
        return chooseMusicDialog.mIMain;
    }

    class 1 implements View.OnClickListener {
        1() {
        }

        public void onClick(View view) {
            int id = view.getId();
            if (id == 2131296486) {
                return;
            }
            if (id == 2131297112) {
                ChooseMusicDialog.this.dismiss();
                return;
            }
            if (id == 2131296925) {
                String obj = ChooseMusicDialog.access$000(ChooseMusicDialog.this).getText().toString();
                String string = ChooseMusicDialog.this.getResources().getString(2131755463);
                String string2 = ChooseMusicDialog.this.getResources().getString(2131755462);
                if (obj.isEmpty()) {
                    ToastUtils.show((CharSequence) string);
                    return;
                }
                Integer valueOf = Integer.valueOf(obj);
                if (valueOf.intValue() == 0) {
                    ToastUtils.show((CharSequence) string2);
                } else {
                    ChooseMusicDialog.access$100(ChooseMusicDialog.this).writeData(new byte[]{3, 5, (byte) ((valueOf.intValue() & 65280) >> 8), (byte) (valueOf.intValue() & 255)});
                }
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(2131492916, viewGroup, false);
        this.mRootView.clearAnimation();
        return this.mRootView;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        new Handler().postDelayed(new 2(), 110L);
        this.tv_comfirm = this.mRootView.findViewById(2131296925);
        View findViewById = this.mRootView.findViewById(2131297112);
        this.view_empty = findViewById;
        findViewById.setOnClickListener(this.mOnClickListener);
        this.tv_comfirm.setOnClickListener(this.mOnClickListener);
        NoAnimateEditText findViewById2 = this.mRootView.findViewById(2131296486);
        this.edt_music_num = findViewById2;
        findViewById2.setOnClickListener(this.mOnClickListener);
    }

    class 2 implements Runnable {
        2() {
        }

        public void run() {
            ChooseMusicDialog.access$200(ChooseMusicDialog.this).writeData(OrderSet.write_synchronize);
        }
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
                attributes.gravity = 80;
                window.setAttributes(attributes);
            }
        }
        setCancelable(false);
    }

    public void notice(String str, UUID uuid, byte[] bArr) {
        try {
            Convert.bytesToHexString(bArr).toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
