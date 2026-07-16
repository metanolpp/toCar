package com.zddz.app.carlive.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class UpdateAskDialogBinding implements ViewBinding {
    public final ProgressBar barPrompt;
    public final TextView btApply;
    public final TextView btCancel;
    public final TextView btExit;
    public final TextView btUpdate;
    public final CheckBox cbNoPrompt;
    public final LinearLayout llProgress;
    private final RelativeLayout rootView;
    public final TextView tvContent;
    public final TextView tvProgress;
    public final TextView tvPrompt;

    private UpdateAskDialogBinding(RelativeLayout relativeLayout, ProgressBar progressBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, CheckBox checkBox, LinearLayout linearLayout, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = relativeLayout;
        this.barPrompt = progressBar;
        this.btApply = textView;
        this.btCancel = textView2;
        this.btExit = textView3;
        this.btUpdate = textView4;
        this.cbNoPrompt = checkBox;
        this.llProgress = linearLayout;
        this.tvContent = textView5;
        this.tvProgress = textView6;
        this.tvPrompt = textView7;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static UpdateAskDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static UpdateAskDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(2131493008, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static UpdateAskDialogBinding bind(View view) {
        int i = 2131296344;
        ProgressBar findChildViewById = ViewBindings.findChildViewById(view, 2131296344);
        if (findChildViewById != null) {
            i = 2131296357;
            TextView findChildViewById2 = ViewBindings.findChildViewById(view, 2131296357);
            if (findChildViewById2 != null) {
                i = 2131296358;
                TextView findChildViewById3 = ViewBindings.findChildViewById(view, 2131296358);
                if (findChildViewById3 != null) {
                    i = 2131296362;
                    TextView findChildViewById4 = ViewBindings.findChildViewById(view, 2131296362);
                    if (findChildViewById4 != null) {
                        i = 2131296373;
                        TextView findChildViewById5 = ViewBindings.findChildViewById(view, 2131296373);
                        if (findChildViewById5 != null) {
                            i = 2131296379;
                            CheckBox findChildViewById6 = ViewBindings.findChildViewById(view, 2131296379);
                            if (findChildViewById6 != null) {
                                i = 2131296597;
                                LinearLayout findChildViewById7 = ViewBindings.findChildViewById(view, 2131296597);
                                if (findChildViewById7 != null) {
                                    i = 2131296928;
                                    TextView findChildViewById8 = ViewBindings.findChildViewById(view, 2131296928);
                                    if (findChildViewById8 != null) {
                                        i = 2131297022;
                                        TextView findChildViewById9 = ViewBindings.findChildViewById(view, 2131297022);
                                        if (findChildViewById9 != null) {
                                            i = 2131297023;
                                            TextView findChildViewById10 = ViewBindings.findChildViewById(view, 2131297023);
                                            if (findChildViewById10 != null) {
                                                return new UpdateAskDialogBinding((RelativeLayout) view, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, findChildViewById5, findChildViewById6, findChildViewById7, findChildViewById8, findChildViewById9, findChildViewById10);
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
