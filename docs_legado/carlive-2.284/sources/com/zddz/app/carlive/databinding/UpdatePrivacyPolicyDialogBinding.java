package com.zddz.app.carlive.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.zddz.widget.UIImageView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class UpdatePrivacyPolicyDialogBinding implements ViewBinding {
    public final CheckedTextView ctvPrivacyPolicy;
    public final CheckedTextView ctvServiceAgreement;
    public final LinearLayout rlTop;
    private final LinearLayout rootView;
    public final TextView tvContent;
    public final UIImageView uivBack;

    private UpdatePrivacyPolicyDialogBinding(LinearLayout linearLayout, CheckedTextView checkedTextView, CheckedTextView checkedTextView2, LinearLayout linearLayout2, TextView textView, UIImageView uIImageView) {
        this.rootView = linearLayout;
        this.ctvPrivacyPolicy = checkedTextView;
        this.ctvServiceAgreement = checkedTextView2;
        this.rlTop = linearLayout2;
        this.tvContent = textView;
        this.uivBack = uIImageView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static UpdatePrivacyPolicyDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static UpdatePrivacyPolicyDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(2131493009, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static UpdatePrivacyPolicyDialogBinding bind(View view) {
        int i = 2131296435;
        CheckedTextView findChildViewById = ViewBindings.findChildViewById(view, 2131296435);
        if (findChildViewById != null) {
            i = 2131296437;
            CheckedTextView findChildViewById2 = ViewBindings.findChildViewById(view, 2131296437);
            if (findChildViewById2 != null) {
                i = 2131296742;
                LinearLayout findChildViewById3 = ViewBindings.findChildViewById(view, 2131296742);
                if (findChildViewById3 != null) {
                    i = 2131296928;
                    TextView findChildViewById4 = ViewBindings.findChildViewById(view, 2131296928);
                    if (findChildViewById4 != null) {
                        i = 2131297075;
                        UIImageView findChildViewById5 = ViewBindings.findChildViewById(view, 2131297075);
                        if (findChildViewById5 != null) {
                            return new UpdatePrivacyPolicyDialogBinding((LinearLayout) view, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, findChildViewById5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
