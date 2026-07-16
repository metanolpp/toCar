package com.zddz.app.carlive.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class DialogSetUpBinding implements ViewBinding {
    public final TextView btClose;
    public final ImageView imgSpeechOpen;
    public final ImageView ivUpdateNotice;
    public final LinearLayout llSpeech;
    public final RelativeLayout rlVersion;
    private final LinearLayout rootView;
    public final Switch switchAutoConnect;
    public final Switch switchUsePositioning;
    public final TextView tvBtState;
    public final TextView tvFindCar;
    public final TextView tvPrivacyPolicy;
    public final TextView tvVersion;

    private DialogSetUpBinding(LinearLayout linearLayout, TextView textView, ImageView imageView, ImageView imageView2, LinearLayout linearLayout2, RelativeLayout relativeLayout, Switch r7, Switch r8, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = linearLayout;
        this.btClose = textView;
        this.imgSpeechOpen = imageView;
        this.ivUpdateNotice = imageView2;
        this.llSpeech = linearLayout2;
        this.rlVersion = relativeLayout;
        this.switchAutoConnect = r7;
        this.switchUsePositioning = r8;
        this.tvBtState = textView2;
        this.tvFindCar = textView3;
        this.tvPrivacyPolicy = textView4;
        this.tvVersion = textView5;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogSetUpBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogSetUpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(2131492927, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogSetUpBinding bind(View view) {
        int i = 2131296359;
        TextView findChildViewById = ViewBindings.findChildViewById(view, 2131296359);
        if (findChildViewById != null) {
            i = 2131296544;
            ImageView findChildViewById2 = ViewBindings.findChildViewById(view, 2131296544);
            if (findChildViewById2 != null) {
                i = 2131296563;
                ImageView findChildViewById3 = ViewBindings.findChildViewById(view, 2131296563);
                if (findChildViewById3 != null) {
                    i = 2131296601;
                    LinearLayout findChildViewById4 = ViewBindings.findChildViewById(view, 2131296601);
                    if (findChildViewById4 != null) {
                        i = 2131296743;
                        RelativeLayout findChildViewById5 = ViewBindings.findChildViewById(view, 2131296743);
                        if (findChildViewById5 != null) {
                            i = 2131296847;
                            Switch findChildViewById6 = ViewBindings.findChildViewById(view, 2131296847);
                            if (findChildViewById6 != null) {
                                i = 2131296851;
                                Switch findChildViewById7 = ViewBindings.findChildViewById(view, 2131296851);
                                if (findChildViewById7 != null) {
                                    i = 2131296913;
                                    TextView findChildViewById8 = ViewBindings.findChildViewById(view, 2131296913);
                                    if (findChildViewById8 != null) {
                                        i = 2131296968;
                                        TextView findChildViewById9 = ViewBindings.findChildViewById(view, 2131296968);
                                        if (findChildViewById9 != null) {
                                            i = 2131297021;
                                            TextView findChildViewById10 = ViewBindings.findChildViewById(view, 2131297021);
                                            if (findChildViewById10 != null) {
                                                i = 2131297061;
                                                TextView findChildViewById11 = ViewBindings.findChildViewById(view, 2131297061);
                                                if (findChildViewById11 != null) {
                                                    return new DialogSetUpBinding((LinearLayout) view, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, findChildViewById5, findChildViewById6, findChildViewById7, findChildViewById8, findChildViewById9, findChildViewById10, findChildViewById11);
                                                }
                                            }
                                        }
                                    }
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
