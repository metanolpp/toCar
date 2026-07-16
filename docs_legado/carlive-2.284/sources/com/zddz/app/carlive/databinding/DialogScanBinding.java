package com.zddz.app.carlive.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.zddz.widget.UIImageView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class DialogScanBinding implements ViewBinding {
    public final TextView btClose;
    public final TextView btScan;
    public final LinearLayout llMain;
    private final RelativeLayout rootView;
    public final RecyclerView rvDevice;
    public final TextView tvTitle;
    public final UIImageView uivClose;

    private DialogScanBinding(RelativeLayout relativeLayout, TextView textView, TextView textView2, LinearLayout linearLayout, RecyclerView recyclerView, TextView textView3, UIImageView uIImageView) {
        this.rootView = relativeLayout;
        this.btClose = textView;
        this.btScan = textView2;
        this.llMain = linearLayout;
        this.rvDevice = recyclerView;
        this.tvTitle = textView3;
        this.uivClose = uIImageView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DialogScanBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogScanBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(2131492926, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogScanBinding bind(View view) {
        int i = 2131296359;
        TextView findChildViewById = ViewBindings.findChildViewById(view, 2131296359);
        if (findChildViewById != null) {
            i = 2131296365;
            TextView findChildViewById2 = ViewBindings.findChildViewById(view, 2131296365);
            if (findChildViewById2 != null) {
                i = 2131296594;
                LinearLayout findChildViewById3 = ViewBindings.findChildViewById(view, 2131296594);
                if (findChildViewById3 != null) {
                    i = 2131296746;
                    RecyclerView findChildViewById4 = ViewBindings.findChildViewById(view, 2131296746);
                    if (findChildViewById4 != null) {
                        i = 2131297049;
                        TextView findChildViewById5 = ViewBindings.findChildViewById(view, 2131297049);
                        if (findChildViewById5 != null) {
                            i = 2131297078;
                            UIImageView findChildViewById6 = ViewBindings.findChildViewById(view, 2131297078);
                            if (findChildViewById6 != null) {
                                return new DialogScanBinding((RelativeLayout) view, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, findChildViewById5, findChildViewById6);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
