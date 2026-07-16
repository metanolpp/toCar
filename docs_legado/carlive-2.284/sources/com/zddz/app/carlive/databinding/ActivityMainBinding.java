package com.zddz.app.carlive.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.zddz.widget.ProgressView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class ActivityMainBinding implements ViewBinding {
    public final TextView btClose;
    public final FrameLayout flContent;
    public final FrameLayout flDialog;
    public final LinearLayout llState;
    public final ProgressView pvPrompt;
    private final RelativeLayout rootView;
    public final TextView tvPrompt;

    private ActivityMainBinding(RelativeLayout relativeLayout, TextView textView, FrameLayout frameLayout, FrameLayout frameLayout2, LinearLayout linearLayout, ProgressView progressView, TextView textView2) {
        this.rootView = relativeLayout;
        this.btClose = textView;
        this.flContent = frameLayout;
        this.flDialog = frameLayout2;
        this.llState = linearLayout;
        this.pvPrompt = progressView;
        this.tvPrompt = textView2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(2131492894, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityMainBinding bind(View view) {
        int i = 2131296359;
        TextView findChildViewById = ViewBindings.findChildViewById(view, 2131296359);
        if (findChildViewById != null) {
            i = 2131296511;
            FrameLayout findChildViewById2 = ViewBindings.findChildViewById(view, 2131296511);
            if (findChildViewById2 != null) {
                i = 2131296513;
                FrameLayout findChildViewById3 = ViewBindings.findChildViewById(view, 2131296513);
                if (findChildViewById3 != null) {
                    i = 2131296602;
                    LinearLayout findChildViewById4 = ViewBindings.findChildViewById(view, 2131296602);
                    if (findChildViewById4 != null) {
                        i = 2131296713;
                        ProgressView progressView = (ProgressView) ViewBindings.findChildViewById(view, 2131296713);
                        if (progressView != null) {
                            i = 2131297023;
                            TextView findChildViewById5 = ViewBindings.findChildViewById(view, 2131297023);
                            if (findChildViewById5 != null) {
                                return new ActivityMainBinding((RelativeLayout) view, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, progressView, findChildViewById5);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
