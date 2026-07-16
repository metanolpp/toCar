package com.zddz.app.carlive.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.zddz.widget.UIImageView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class Dialog0e05RgbBinding implements ViewBinding {
    public final LinearLayout llCloseZone;
    public final LinearLayout llDialog;
    public final LinearLayout llRgb0e05TitleView;
    public final RecyclerView rlRgb0e05Dialog;
    private final ConstraintLayout rootView;
    public final TextView tvRgb0e05TitleOne;
    public final TextView tvRgb0e05TitleTwo;
    public final UIImageView uivClose;

    private Dialog0e05RgbBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, RecyclerView recyclerView, TextView textView, TextView textView2, UIImageView uIImageView) {
        this.rootView = constraintLayout;
        this.llCloseZone = linearLayout;
        this.llDialog = linearLayout2;
        this.llRgb0e05TitleView = linearLayout3;
        this.rlRgb0e05Dialog = recyclerView;
        this.tvRgb0e05TitleOne = textView;
        this.tvRgb0e05TitleTwo = textView2;
        this.uivClose = uIImageView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static Dialog0e05RgbBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static Dialog0e05RgbBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(2131492911, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Dialog0e05RgbBinding bind(View view) {
        int i = 2131296583;
        LinearLayout findChildViewById = ViewBindings.findChildViewById(view, 2131296583);
        if (findChildViewById != null) {
            i = 2131296586;
            LinearLayout findChildViewById2 = ViewBindings.findChildViewById(view, 2131296586);
            if (findChildViewById2 != null) {
                i = 2131296600;
                LinearLayout findChildViewById3 = ViewBindings.findChildViewById(view, 2131296600);
                if (findChildViewById3 != null) {
                    i = 2131296734;
                    RecyclerView findChildViewById4 = ViewBindings.findChildViewById(view, 2131296734);
                    if (findChildViewById4 != null) {
                        i = 2131297026;
                        TextView findChildViewById5 = ViewBindings.findChildViewById(view, 2131297026);
                        if (findChildViewById5 != null) {
                            i = 2131297027;
                            TextView findChildViewById6 = ViewBindings.findChildViewById(view, 2131297027);
                            if (findChildViewById6 != null) {
                                i = 2131297078;
                                UIImageView findChildViewById7 = ViewBindings.findChildViewById(view, 2131297078);
                                if (findChildViewById7 != null) {
                                    return new Dialog0e05RgbBinding((ConstraintLayout) view, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, findChildViewById5, findChildViewById6, findChildViewById7);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
