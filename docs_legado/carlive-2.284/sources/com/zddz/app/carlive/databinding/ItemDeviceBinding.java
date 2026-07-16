package com.zddz.app.carlive.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class ItemDeviceBinding implements ViewBinding {
    public final CheckedTextView ctvName;
    public final ImageView ivState;
    private final RelativeLayout rootView;
    public final TextView tvConnecting;

    private ItemDeviceBinding(RelativeLayout relativeLayout, CheckedTextView checkedTextView, ImageView imageView, TextView textView) {
        this.rootView = relativeLayout;
        this.ctvName = checkedTextView;
        this.ivState = imageView;
        this.tvConnecting = textView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ItemDeviceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemDeviceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(2131492938, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemDeviceBinding bind(View view) {
        int i = 2131296430;
        CheckedTextView findChildViewById = ViewBindings.findChildViewById(view, 2131296430);
        if (findChildViewById != null) {
            i = 2131296561;
            ImageView findChildViewById2 = ViewBindings.findChildViewById(view, 2131296561);
            if (findChildViewById2 != null) {
                i = 2131296927;
                TextView findChildViewById3 = ViewBindings.findChildViewById(view, 2131296927);
                if (findChildViewById3 != null) {
                    return new ItemDeviceBinding((RelativeLayout) view, findChildViewById, findChildViewById2, findChildViewById3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
