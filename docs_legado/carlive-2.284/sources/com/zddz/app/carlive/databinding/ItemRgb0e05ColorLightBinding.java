package com.zddz.app.carlive.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class ItemRgb0e05ColorLightBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvItemText;

    private ItemRgb0e05ColorLightBinding(ConstraintLayout constraintLayout, TextView textView) {
        this.rootView = constraintLayout;
        this.tvItemText = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemRgb0e05ColorLightBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemRgb0e05ColorLightBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(2131492939, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemRgb0e05ColorLightBinding bind(View view) {
        TextView findChildViewById = ViewBindings.findChildViewById(view, 2131296994);
        if (findChildViewById != null) {
            return new ItemRgb0e05ColorLightBinding((ConstraintLayout) view, findChildViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(2131296994)));
    }
}
