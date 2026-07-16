package com.zddz.app.carlive.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class DialogChannelPassInputBinding implements ViewBinding {
    public final EditText etInput;
    private final RelativeLayout rootView;
    public final TextView tvClose;
    public final TextView tvConfirm;
    public final TextView tvPrompt;

    private DialogChannelPassInputBinding(RelativeLayout relativeLayout, EditText editText, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = relativeLayout;
        this.etInput = editText;
        this.tvClose = textView;
        this.tvConfirm = textView2;
        this.tvPrompt = textView3;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DialogChannelPassInputBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogChannelPassInputBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(2131492915, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogChannelPassInputBinding bind(View view) {
        int i = 2131296493;
        EditText findChildViewById = ViewBindings.findChildViewById(view, 2131296493);
        if (findChildViewById != null) {
            i = 2131296924;
            TextView findChildViewById2 = ViewBindings.findChildViewById(view, 2131296924);
            if (findChildViewById2 != null) {
                i = 2131296926;
                TextView findChildViewById3 = ViewBindings.findChildViewById(view, 2131296926);
                if (findChildViewById3 != null) {
                    i = 2131297023;
                    TextView findChildViewById4 = ViewBindings.findChildViewById(view, 2131297023);
                    if (findChildViewById4 != null) {
                        return new DialogChannelPassInputBinding((RelativeLayout) view, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
