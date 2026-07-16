package com.zddz.app.carlive.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.zddz.widget.rgblibang.LEDStripView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class ItemRgbLibangBinding implements ViewBinding {
    public final LEDStripView ledview;
    private final ConstraintLayout rootView;
    public final TextView tvDi;
    public final TextView tvTitle;
    public final TextView tvType;
    public final View viewBg;

    private ItemRgbLibangBinding(ConstraintLayout constraintLayout, LEDStripView lEDStripView, TextView textView, TextView textView2, TextView textView3, View view) {
        this.rootView = constraintLayout;
        this.ledview = lEDStripView;
        this.tvDi = textView;
        this.tvTitle = textView2;
        this.tvType = textView3;
        this.viewBg = view;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemRgbLibangBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemRgbLibangBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(2131492940, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemRgbLibangBinding bind(View view) {
        int i = 2131296568;
        LEDStripView findChildViewById = ViewBindings.findChildViewById(view, 2131296568);
        if (findChildViewById != null) {
            i = 2131296931;
            TextView findChildViewById2 = ViewBindings.findChildViewById(view, 2131296931);
            if (findChildViewById2 != null) {
                i = 2131297049;
                TextView findChildViewById3 = ViewBindings.findChildViewById(view, 2131297049);
                if (findChildViewById3 != null) {
                    i = 2131297060;
                    TextView findChildViewById4 = ViewBindings.findChildViewById(view, 2131297060);
                    if (findChildViewById4 != null) {
                        i = 2131297105;
                        View findChildViewById5 = ViewBindings.findChildViewById(view, 2131297105);
                        if (findChildViewById5 != null) {
                            return new ItemRgbLibangBinding((ConstraintLayout) view, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, findChildViewById5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
