package com.zddz.app.carlive.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.zddz.widget.ProgressView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class LoadingDialog extends AlertDialog {
    private View mRootView;
    private ProgressView pv_prompt;
    private TextView tv_prompt;

    static /* synthetic */ ProgressView access$000(LoadingDialog loadingDialog) {
        return loadingDialog.pv_prompt;
    }

    public LoadingDialog(Context context) {
        super(context);
        View inflate = LayoutInflater.from(context).inflate(2131492921, (ViewGroup) null);
        this.mRootView = inflate;
        this.pv_prompt = (ProgressView) inflate.findViewById(2131296713);
        this.tv_prompt = this.mRootView.findViewById(2131297023);
        this.pv_prompt.setMainColor(Color.parseColor("#81FFFF"));
        this.pv_prompt.start();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.mRootView);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-2, -2);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.0f;
            attributes.gravity = 17;
            window.setAttributes(attributes);
        }
    }

    class 1 implements Runnable {
        1() {
        }

        public void run() {
            LoadingDialog.access$000(LoadingDialog.this).stop();
            LoadingDialog.this.dismiss();
        }
    }

    public void onStart() {
        super.onStart();
        new Handler().postDelayed(new 1(), 5000L);
    }

    public void setColor(int i) {
        this.tv_prompt.setTextColor(i);
        this.pv_prompt.setMainColor(i);
    }
}
