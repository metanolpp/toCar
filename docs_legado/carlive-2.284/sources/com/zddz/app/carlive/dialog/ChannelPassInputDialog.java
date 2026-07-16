package com.zddz.app.carlive.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import com.zddz.app.carlive.dialog.NumberInputDialog;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class ChannelPassInputDialog extends AlertDialog {
    private EditText et_input;
    private NumberInputDialog.OnConfirmListener mListener;
    private int mMax;
    private int mMin;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private TextView tv_prompt;

    public interface OnConfirmListener {
        void OnConfirm(int i);
    }

    static /* synthetic */ EditText access$000(ChannelPassInputDialog channelPassInputDialog) {
        return channelPassInputDialog.et_input;
    }

    static /* synthetic */ int access$100(ChannelPassInputDialog channelPassInputDialog) {
        return channelPassInputDialog.mMin;
    }

    static /* synthetic */ NumberInputDialog.OnConfirmListener access$200(ChannelPassInputDialog channelPassInputDialog) {
        return channelPassInputDialog.mListener;
    }

    static /* synthetic */ int access$300(ChannelPassInputDialog channelPassInputDialog) {
        return channelPassInputDialog.mMax;
    }

    class 1 implements View.OnClickListener {
        1() {
        }

        public void onClick(View view) {
            if (view.getId() == 2131296926) {
                if (TextUtils.isEmpty(ChannelPassInputDialog.access$000(ChannelPassInputDialog.this).getText())) {
                    return;
                }
                try {
                    int parseInt = Integer.parseInt(ChannelPassInputDialog.access$000(ChannelPassInputDialog.this).getText().toString());
                    if (parseInt < ChannelPassInputDialog.access$100(ChannelPassInputDialog.this)) {
                        ChannelPassInputDialog.access$200(ChannelPassInputDialog.this).OnConfirm(ChannelPassInputDialog.access$100(ChannelPassInputDialog.this));
                    } else {
                        ChannelPassInputDialog.access$200(ChannelPassInputDialog.this).OnConfirm(Math.min(parseInt, ChannelPassInputDialog.access$300(ChannelPassInputDialog.this)));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            ChannelPassInputDialog.this.dismiss();
        }
    }

    public ChannelPassInputDialog(Context context) {
        super(context);
        this.mOnClickListener = new 1();
        this.mMin = 0;
        this.mMax = 50;
        View inflate = LayoutInflater.from(context).inflate(2131492915, (ViewGroup) null);
        this.mRootView = inflate;
        this.et_input = inflate.findViewById(2131296493);
        this.tv_prompt = this.mRootView.findViewById(2131297023);
        this.mRootView.findViewById(2131296924).setOnClickListener(this.mOnClickListener);
        this.mRootView.findViewById(2131296926).setOnClickListener(this.mOnClickListener);
    }

    public void setPrompt(int i) {
        this.tv_prompt.setText(i);
    }

    public void setRange(int i, int i2) {
        this.mMin = i;
        this.mMax = i2;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.mRootView);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-1, -1);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.0f;
            window.setAttributes(attributes);
            window.clearFlags(131072);
        }
    }

    public void setOnConfirmListener(NumberInputDialog.OnConfirmListener onConfirmListener) {
        this.mListener = onConfirmListener;
    }
}
