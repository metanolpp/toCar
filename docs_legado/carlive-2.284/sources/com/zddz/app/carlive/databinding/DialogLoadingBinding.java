package com.zddz.app.carlive.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.zddz.widget.ProgressView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class DialogLoadingBinding implements ViewBinding {
    public final ProgressView pvPrompt;
    private final RelativeLayout rootView;
    public final TextView tvPrompt;

    private DialogLoadingBinding(RelativeLayout relativeLayout, ProgressView progressView, TextView textView) {
        this.rootView = relativeLayout;
        this.pvPrompt = progressView;
        this.tvPrompt = textView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DialogLoadingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogLoadingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(2131492921, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogLoadingBinding bind(View view) {
        int i = 2131296713;
        ProgressView progressView = (ProgressView) ViewBindings.findChildViewById(view, 2131296713);
        if (progressView != null) {
            i = 2131297023;
            TextView findChildViewById = ViewBindings.findChildViewById(view, 2131297023);
            if (findChildViewById != null) {
                return new DialogLoadingBinding((RelativeLayout) view, progressView, findChildViewById);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
