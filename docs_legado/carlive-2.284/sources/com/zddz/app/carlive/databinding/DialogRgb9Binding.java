package com.zddz.app.carlive.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.zddz.widget.UIImageView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class DialogRgb9Binding implements ViewBinding {
    public final LinearLayout llDialog;
    private final RelativeLayout rootView;
    public final TextView tvAuto;
    public final TextView tvBlue;
    public final TextView tvGreen;
    public final TextView tvMagenta;
    public final TextView tvOrg;
    public final TextView tvRed;
    public final TextView tvSky;
    public final TextView tvWhite;
    public final TextView tvYellow;
    public final UIImageView uivClose;
    public final View viewOrg;

    private DialogRgb9Binding(RelativeLayout relativeLayout, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, UIImageView uIImageView, View view) {
        this.rootView = relativeLayout;
        this.llDialog = linearLayout;
        this.tvAuto = textView;
        this.tvBlue = textView2;
        this.tvGreen = textView3;
        this.tvMagenta = textView4;
        this.tvOrg = textView5;
        this.tvRed = textView6;
        this.tvSky = textView7;
        this.tvWhite = textView8;
        this.tvYellow = textView9;
        this.uivClose = uIImageView;
        this.viewOrg = view;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DialogRgb9Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogRgb9Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(2131492925, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogRgb9Binding bind(View view) {
        int i = 2131296586;
        LinearLayout findChildViewById = ViewBindings.findChildViewById(view, 2131296586);
        if (findChildViewById != null) {
            i = 2131296899;
            TextView findChildViewById2 = ViewBindings.findChildViewById(view, 2131296899);
            if (findChildViewById2 != null) {
                i = 2131296912;
                TextView findChildViewById3 = ViewBindings.findChildViewById(view, 2131296912);
                if (findChildViewById3 != null) {
                    i = 2131296987;
                    TextView findChildViewById4 = ViewBindings.findChildViewById(view, 2131296987);
                    if (findChildViewById4 != null) {
                        i = 2131297003;
                        TextView findChildViewById5 = ViewBindings.findChildViewById(view, 2131297003);
                        if (findChildViewById5 != null) {
                            i = 2131297012;
                            TextView findChildViewById6 = ViewBindings.findChildViewById(view, 2131297012);
                            if (findChildViewById6 != null) {
                                i = 2131297025;
                                TextView findChildViewById7 = ViewBindings.findChildViewById(view, 2131297025);
                                if (findChildViewById7 != null) {
                                    i = 2131297030;
                                    TextView findChildViewById8 = ViewBindings.findChildViewById(view, 2131297030);
                                    if (findChildViewById8 != null) {
                                        i = 2131297063;
                                        TextView findChildViewById9 = ViewBindings.findChildViewById(view, 2131297063);
                                        if (findChildViewById9 != null) {
                                            i = 2131297065;
                                            TextView findChildViewById10 = ViewBindings.findChildViewById(view, 2131297065);
                                            if (findChildViewById10 != null) {
                                                i = 2131297078;
                                                UIImageView findChildViewById11 = ViewBindings.findChildViewById(view, 2131297078);
                                                if (findChildViewById11 != null) {
                                                    i = 2131297127;
                                                    View findChildViewById12 = ViewBindings.findChildViewById(view, 2131297127);
                                                    if (findChildViewById12 != null) {
                                                        return new DialogRgb9Binding((RelativeLayout) view, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, findChildViewById5, findChildViewById6, findChildViewById7, findChildViewById8, findChildViewById9, findChildViewById10, findChildViewById11, findChildViewById12);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
