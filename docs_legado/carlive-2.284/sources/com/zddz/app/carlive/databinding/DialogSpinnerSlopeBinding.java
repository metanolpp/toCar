package com.zddz.app.carlive.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class DialogSpinnerSlopeBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView tvSlope1;
    public final TextView tvSlope2;
    public final TextView tvSlope3;
    public final TextView tvSlope4;

    private DialogSpinnerSlopeBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = linearLayout;
        this.tvSlope1 = textView;
        this.tvSlope2 = textView2;
        this.tvSlope3 = textView3;
        this.tvSlope4 = textView4;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogSpinnerSlopeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogSpinnerSlopeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(2131492928, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogSpinnerSlopeBinding bind(View view) {
        int i = 2131297031;
        TextView findChildViewById = ViewBindings.findChildViewById(view, 2131297031);
        if (findChildViewById != null) {
            i = 2131297032;
            TextView findChildViewById2 = ViewBindings.findChildViewById(view, 2131297032);
            if (findChildViewById2 != null) {
                i = 2131297033;
                TextView findChildViewById3 = ViewBindings.findChildViewById(view, 2131297033);
                if (findChildViewById3 != null) {
                    i = 2131297034;
                    TextView findChildViewById4 = ViewBindings.findChildViewById(view, 2131297034);
                    if (findChildViewById4 != null) {
                        return new DialogSpinnerSlopeBinding((LinearLayout) view, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
