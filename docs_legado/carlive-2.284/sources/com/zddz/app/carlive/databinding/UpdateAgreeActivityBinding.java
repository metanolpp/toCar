package com.zddz.app.carlive.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class UpdateAgreeActivityBinding implements ViewBinding {
    public final TextView btAgree;
    public final TextView btDisagree;
    public final CheckedTextView ctvPrivacyPolicy;
    public final CheckedTextView ctvServiceAgreement;
    public final LinearLayout llBottom;
    public final LinearLayout llTap;
    private final RelativeLayout rootView;
    public final TextView tvContent;

    private UpdateAgreeActivityBinding(RelativeLayout relativeLayout, TextView textView, TextView textView2, CheckedTextView checkedTextView, CheckedTextView checkedTextView2, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView3) {
        this.rootView = relativeLayout;
        this.btAgree = textView;
        this.btDisagree = textView2;
        this.ctvPrivacyPolicy = checkedTextView;
        this.ctvServiceAgreement = checkedTextView2;
        this.llBottom = linearLayout;
        this.llTap = linearLayout2;
        this.tvContent = textView3;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static UpdateAgreeActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static UpdateAgreeActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(2131493007, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static UpdateAgreeActivityBinding bind(View view) {
        int i = 2131296356;
        TextView findChildViewById = ViewBindings.findChildViewById(view, 2131296356);
        if (findChildViewById != null) {
            i = 2131296361;
            TextView findChildViewById2 = ViewBindings.findChildViewById(view, 2131296361);
            if (findChildViewById2 != null) {
                i = 2131296435;
                CheckedTextView findChildViewById3 = ViewBindings.findChildViewById(view, 2131296435);
                if (findChildViewById3 != null) {
                    i = 2131296437;
                    CheckedTextView findChildViewById4 = ViewBindings.findChildViewById(view, 2131296437);
                    if (findChildViewById4 != null) {
                        i = 2131296579;
                        LinearLayout findChildViewById5 = ViewBindings.findChildViewById(view, 2131296579);
                        if (findChildViewById5 != null) {
                            i = 2131296604;
                            LinearLayout findChildViewById6 = ViewBindings.findChildViewById(view, 2131296604);
                            if (findChildViewById6 != null) {
                                i = 2131296928;
                                TextView findChildViewById7 = ViewBindings.findChildViewById(view, 2131296928);
                                if (findChildViewById7 != null) {
                                    return new UpdateAgreeActivityBinding((RelativeLayout) view, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, findChildViewById5, findChildViewById6, findChildViewById7);
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
