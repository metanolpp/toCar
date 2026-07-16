package com.zddz.app.carlive.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class ActivityCrashBinding implements ViewBinding {
    public final Button btExit;
    private final RelativeLayout rootView;
    public final TextView tvPrompt;

    private ActivityCrashBinding(RelativeLayout relativeLayout, Button button, TextView textView) {
        this.rootView = relativeLayout;
        this.btExit = button;
        this.tvPrompt = textView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityCrashBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityCrashBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(2131492892, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityCrashBinding bind(View view) {
        int i = 2131296362;
        Button findChildViewById = ViewBindings.findChildViewById(view, 2131296362);
        if (findChildViewById != null) {
            i = 2131297023;
            TextView findChildViewById2 = ViewBindings.findChildViewById(view, 2131297023);
            if (findChildViewById2 != null) {
                return new ActivityCrashBinding((RelativeLayout) view, findChildViewById, findChildViewById2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
