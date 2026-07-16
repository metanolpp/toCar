package com.zddz.app.carlive.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class ActivityFindCarBinding implements ViewBinding {
    public final TextView btCancel;
    public final TextView btConfirm;
    private final RelativeLayout rootView;
    public final TextView tvLocation;

    private ActivityFindCarBinding(RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = relativeLayout;
        this.btCancel = textView;
        this.btConfirm = textView2;
        this.tvLocation = textView3;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityFindCarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityFindCarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(2131492893, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityFindCarBinding bind(View view) {
        int i = 2131296358;
        TextView findChildViewById = ViewBindings.findChildViewById(view, 2131296358);
        if (findChildViewById != null) {
            i = 2131296360;
            TextView findChildViewById2 = ViewBindings.findChildViewById(view, 2131296360);
            if (findChildViewById2 != null) {
                i = 2131296995;
                TextView findChildViewById3 = ViewBindings.findChildViewById(view, 2131296995);
                if (findChildViewById3 != null) {
                    return new ActivityFindCarBinding((RelativeLayout) view, findChildViewById, findChildViewById2, findChildViewById3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
