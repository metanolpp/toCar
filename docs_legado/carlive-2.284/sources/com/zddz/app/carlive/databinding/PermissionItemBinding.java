package com.zddz.app.carlive.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class PermissionItemBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView tvFunction;

    private PermissionItemBinding(LinearLayout linearLayout, TextView textView) {
        this.rootView = linearLayout;
        this.tvFunction = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PermissionItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PermissionItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(2131493001, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static PermissionItemBinding bind(View view) {
        TextView findChildViewById = ViewBindings.findChildViewById(view, 2131296974);
        if (findChildViewById != null) {
            return new PermissionItemBinding((LinearLayout) view, findChildViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(2131296974)));
    }
}
