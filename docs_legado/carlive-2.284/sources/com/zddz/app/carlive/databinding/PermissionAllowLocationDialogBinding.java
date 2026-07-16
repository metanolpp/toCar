package com.zddz.app.carlive.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class PermissionAllowLocationDialogBinding implements ViewBinding {
    public final TextView btConfirm;
    public final CheckBox cbNoUseLocation;
    private final LinearLayout rootView;

    private PermissionAllowLocationDialogBinding(LinearLayout linearLayout, TextView textView, CheckBox checkBox) {
        this.rootView = linearLayout;
        this.btConfirm = textView;
        this.cbNoUseLocation = checkBox;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PermissionAllowLocationDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PermissionAllowLocationDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(2131492999, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static PermissionAllowLocationDialogBinding bind(View view) {
        int i = 2131296360;
        TextView findChildViewById = ViewBindings.findChildViewById(view, 2131296360);
        if (findChildViewById != null) {
            i = 2131296380;
            CheckBox findChildViewById2 = ViewBindings.findChildViewById(view, 2131296380);
            if (findChildViewById2 != null) {
                return new PermissionAllowLocationDialogBinding((LinearLayout) view, findChildViewById, findChildViewById2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
