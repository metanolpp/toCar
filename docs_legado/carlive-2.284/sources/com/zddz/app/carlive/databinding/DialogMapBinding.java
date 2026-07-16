package com.zddz.app.carlive.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class DialogMapBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final TextView tvBaiduMap;
    public final TextView tvCancel;
    public final TextView tvGaudMap;
    public final TextView tvGoogleMap;
    public final TextView tvPrompt;
    public final TextView tvTencentMap;

    private DialogMapBinding(RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = relativeLayout;
        this.tvBaiduMap = textView;
        this.tvCancel = textView2;
        this.tvGaudMap = textView3;
        this.tvGoogleMap = textView4;
        this.tvPrompt = textView5;
        this.tvTencentMap = textView6;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DialogMapBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogMapBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(2131492922, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogMapBinding bind(View view) {
        int i = 2131296901;
        TextView findChildViewById = ViewBindings.findChildViewById(view, 2131296901);
        if (findChildViewById != null) {
            i = 2131296914;
            TextView findChildViewById2 = ViewBindings.findChildViewById(view, 2131296914);
            if (findChildViewById2 != null) {
                i = 2131296985;
                TextView findChildViewById3 = ViewBindings.findChildViewById(view, 2131296985);
                if (findChildViewById3 != null) {
                    i = 2131296986;
                    TextView findChildViewById4 = ViewBindings.findChildViewById(view, 2131296986);
                    if (findChildViewById4 != null) {
                        i = 2131297023;
                        TextView findChildViewById5 = ViewBindings.findChildViewById(view, 2131297023);
                        if (findChildViewById5 != null) {
                            i = 2131297047;
                            TextView findChildViewById6 = ViewBindings.findChildViewById(view, 2131297047);
                            if (findChildViewById6 != null) {
                                return new DialogMapBinding((RelativeLayout) view, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, findChildViewById5, findChildViewById6);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
