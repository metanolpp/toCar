package com.zddz.app.carlive.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class NumberInputDialog extends AlertDialog {
    private TextView bt_cancel;
    private TextView bt_confirm;
    private EditText et_value;
    private OnConfirmListener mListener;
    private float mMax;
    private float mMin;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private TextView tv_backspace;
    private TextView tv_clear;
    private TextView tv_max;
    private TextView tv_min;
    private TextView tv_title;

    public interface OnConfirmListener {
        void OnConfirm(int i);
    }

    static /* synthetic */ EditText access$000(NumberInputDialog numberInputDialog) {
        return numberInputDialog.et_value;
    }

    static /* synthetic */ boolean access$100(NumberInputDialog numberInputDialog, Editable editable) {
        return numberInputDialog.checkPoint(editable);
    }

    static /* synthetic */ float access$200(NumberInputDialog numberInputDialog) {
        return numberInputDialog.mMin;
    }

    static /* synthetic */ OnConfirmListener access$300(NumberInputDialog numberInputDialog) {
        return numberInputDialog.mListener;
    }

    static /* synthetic */ float access$400(NumberInputDialog numberInputDialog) {
        return numberInputDialog.mMax;
    }

    private boolean checkPoint(Editable editable) {
        return (editable.length() != 2 || editable.toString().contains(".")) && editable.length() != 3;
    }

    class 1 implements View.OnClickListener {
        1() {
        }

        public void onClick(View view) {
            int selectionStart = NumberInputDialog.access$000(NumberInputDialog.this).getSelectionStart();
            Editable text = NumberInputDialog.access$000(NumberInputDialog.this).getText();
            int id = view.getId();
            if (id == 2131297066) {
                if (NumberInputDialog.access$100(NumberInputDialog.this, text)) {
                    text.insert(selectionStart, "0");
                    return;
                }
                return;
            }
            if (id == 2131297011) {
                if (NumberInputDialog.access$100(NumberInputDialog.this, text)) {
                    text.insert(selectionStart, "1");
                    return;
                }
                return;
            }
            if (id == 2131297059) {
                if (NumberInputDialog.access$100(NumberInputDialog.this, text)) {
                    text.insert(selectionStart, "2");
                    return;
                }
                return;
            }
            if (id == 2131297048) {
                if (NumberInputDialog.access$100(NumberInputDialog.this, text)) {
                    text.insert(selectionStart, "3");
                    return;
                }
                return;
            }
            if (id == 2131296971) {
                if (NumberInputDialog.access$100(NumberInputDialog.this, text)) {
                    text.insert(selectionStart, "4");
                    return;
                }
                return;
            }
            if (id == 2131296969) {
                if (NumberInputDialog.access$100(NumberInputDialog.this, text)) {
                    text.insert(selectionStart, "5");
                    return;
                }
                return;
            }
            if (id == 2131297029) {
                if (NumberInputDialog.access$100(NumberInputDialog.this, text)) {
                    text.insert(selectionStart, "6");
                    return;
                }
                return;
            }
            if (id == 2131297028) {
                if (NumberInputDialog.access$100(NumberInputDialog.this, text)) {
                    text.insert(selectionStart, "7");
                    return;
                }
                return;
            }
            if (id == 2131296933) {
                if (NumberInputDialog.access$100(NumberInputDialog.this, text)) {
                    text.insert(selectionStart, "8");
                    return;
                }
                return;
            }
            if (id == 2131297007) {
                if (NumberInputDialog.access$100(NumberInputDialog.this, text)) {
                    text.insert(selectionStart, "9");
                    return;
                }
                return;
            }
            if (id == 2131297020) {
                if (NumberInputDialog.access$100(NumberInputDialog.this, text)) {
                    text.insert(selectionStart, ".");
                    return;
                }
                return;
            }
            if (id == 2131296923) {
                text.clear();
                return;
            }
            if (id == 2131296900) {
                if (selectionStart < 1) {
                    return;
                }
                text.delete(selectionStart - 1, selectionStart);
                return;
            }
            if (id == 2131296358) {
                NumberInputDialog.this.dismiss();
                return;
            }
            if (id != 2131296360 || TextUtils.isEmpty(NumberInputDialog.access$000(NumberInputDialog.this).getText())) {
                return;
            }
            try {
                int parseFloat = (int) (Float.parseFloat(NumberInputDialog.access$000(NumberInputDialog.this).getText().toString()) * 10.0f);
                float f = parseFloat;
                if (f < NumberInputDialog.access$200(NumberInputDialog.this)) {
                    NumberInputDialog.access$300(NumberInputDialog.this).OnConfirm(1);
                } else if (f > NumberInputDialog.access$400(NumberInputDialog.this)) {
                    NumberInputDialog.access$300(NumberInputDialog.this).OnConfirm(120);
                } else {
                    NumberInputDialog.access$300(NumberInputDialog.this).OnConfirm(parseFloat);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public NumberInputDialog(Context context) {
        super(context);
        this.mMin = 0.0f;
        this.mMax = Float.MAX_VALUE;
        this.mOnClickListener = new 1();
        View inflate = LayoutInflater.from(context).inflate(2131492923, (ViewGroup) null);
        this.mRootView = inflate;
        this.tv_title = inflate.findViewById(2131297049);
        this.et_value = this.mRootView.findViewById(2131296495);
        this.mRootView.findViewById(2131297011).setOnClickListener(this.mOnClickListener);
        this.mRootView.findViewById(2131297059).setOnClickListener(this.mOnClickListener);
        this.mRootView.findViewById(2131297048).setOnClickListener(this.mOnClickListener);
        this.mRootView.findViewById(2131296971).setOnClickListener(this.mOnClickListener);
        this.mRootView.findViewById(2131296969).setOnClickListener(this.mOnClickListener);
        this.mRootView.findViewById(2131297029).setOnClickListener(this.mOnClickListener);
        this.mRootView.findViewById(2131297028).setOnClickListener(this.mOnClickListener);
        this.mRootView.findViewById(2131296933).setOnClickListener(this.mOnClickListener);
        this.mRootView.findViewById(2131297007).setOnClickListener(this.mOnClickListener);
        this.mRootView.findViewById(2131297066).setOnClickListener(this.mOnClickListener);
        this.mRootView.findViewById(2131297020).setOnClickListener(this.mOnClickListener);
        TextView findViewById = this.mRootView.findViewById(2131296923);
        this.tv_clear = findViewById;
        findViewById.setOnClickListener(this.mOnClickListener);
        TextView findViewById2 = this.mRootView.findViewById(2131296900);
        this.tv_backspace = findViewById2;
        findViewById2.setOnClickListener(this.mOnClickListener);
        TextView findViewById3 = this.mRootView.findViewById(2131296358);
        this.bt_cancel = findViewById3;
        findViewById3.setOnClickListener(this.mOnClickListener);
        TextView findViewById4 = this.mRootView.findViewById(2131296360);
        this.bt_confirm = findViewById4;
        findViewById4.setOnClickListener(this.mOnClickListener);
        this.tv_min = this.mRootView.findViewById(2131297005);
        this.tv_max = this.mRootView.findViewById(2131297004);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        setContentView(this.mRootView);
    }

    public void setValue(String str) {
        this.et_value.setText(str);
    }

    public void setRange(float f, float f2, boolean z) {
        this.mMin = f;
        this.mMax = f2;
        this.tv_min.setText(f + "~");
        this.tv_max.setText("~" + f2);
        if (z) {
            this.tv_min.setVisibility(0);
            this.tv_max.setVisibility(0);
        } else {
            this.tv_min.setVisibility(8);
            this.tv_max.setVisibility(8);
        }
    }

    public void onStart() {
        super.onStart();
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
        this.et_value.requestFocus();
        EditText editText = this.et_value;
        editText.setSelection(editText.length());
    }

    public void setOnConfirmListener(OnConfirmListener onConfirmListener) {
        this.mListener = onConfirmListener;
    }
}
