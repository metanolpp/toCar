package com.zddz.app.carlive.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.zddz.widget.UIImageView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class DialogEqBinding implements ViewBinding {
    public final CheckedTextView ctvClassic;
    public final CheckedTextView ctvCountry;
    public final CheckedTextView ctvJazz;
    public final CheckedTextView ctvNormal;
    public final CheckedTextView ctvPopular;
    public final CheckedTextView ctvRock;
    public final LinearLayout llDialog;
    private final RelativeLayout rootView;
    public final SeekBar sbBalance;
    public final SeekBar sbBass;
    public final SeekBar sbFade;
    public final SeekBar sbTreble;
    public final TextView tvBalance;
    public final TextView tvBalanceValue;
    public final TextView tvBass;
    public final TextView tvBassValue;
    public final TextView tvFade;
    public final TextView tvFadeValue;
    public final TextView tvTreble;
    public final TextView tvTrebleValue;
    public final UIImageView uivClose;

    private DialogEqBinding(RelativeLayout relativeLayout, CheckedTextView checkedTextView, CheckedTextView checkedTextView2, CheckedTextView checkedTextView3, CheckedTextView checkedTextView4, CheckedTextView checkedTextView5, CheckedTextView checkedTextView6, LinearLayout linearLayout, SeekBar seekBar, SeekBar seekBar2, SeekBar seekBar3, SeekBar seekBar4, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, UIImageView uIImageView) {
        this.rootView = relativeLayout;
        this.ctvClassic = checkedTextView;
        this.ctvCountry = checkedTextView2;
        this.ctvJazz = checkedTextView3;
        this.ctvNormal = checkedTextView4;
        this.ctvPopular = checkedTextView5;
        this.ctvRock = checkedTextView6;
        this.llDialog = linearLayout;
        this.sbBalance = seekBar;
        this.sbBass = seekBar2;
        this.sbFade = seekBar3;
        this.sbTreble = seekBar4;
        this.tvBalance = textView;
        this.tvBalanceValue = textView2;
        this.tvBass = textView3;
        this.tvBassValue = textView4;
        this.tvFade = textView5;
        this.tvFadeValue = textView6;
        this.tvTreble = textView7;
        this.tvTrebleValue = textView8;
        this.uivClose = uIImageView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DialogEqBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogEqBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(2131492918, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogEqBinding bind(View view) {
        int i = 2131296419;
        CheckedTextView findChildViewById = ViewBindings.findChildViewById(view, 2131296419);
        if (findChildViewById != null) {
            i = 2131296420;
            CheckedTextView findChildViewById2 = ViewBindings.findChildViewById(view, 2131296420);
            if (findChildViewById2 != null) {
                i = 2131296428;
                CheckedTextView findChildViewById3 = ViewBindings.findChildViewById(view, 2131296428);
                if (findChildViewById3 != null) {
                    i = 2131296431;
                    CheckedTextView findChildViewById4 = ViewBindings.findChildViewById(view, 2131296431);
                    if (findChildViewById4 != null) {
                        i = 2131296434;
                        CheckedTextView findChildViewById5 = ViewBindings.findChildViewById(view, 2131296434);
                        if (findChildViewById5 != null) {
                            i = 2131296436;
                            CheckedTextView findChildViewById6 = ViewBindings.findChildViewById(view, 2131296436);
                            if (findChildViewById6 != null) {
                                i = 2131296586;
                                LinearLayout findChildViewById7 = ViewBindings.findChildViewById(view, 2131296586);
                                if (findChildViewById7 != null) {
                                    i = 2131296751;
                                    SeekBar findChildViewById8 = ViewBindings.findChildViewById(view, 2131296751);
                                    if (findChildViewById8 != null) {
                                        i = 2131296752;
                                        SeekBar findChildViewById9 = ViewBindings.findChildViewById(view, 2131296752);
                                        if (findChildViewById9 != null) {
                                            i = 2131296769;
                                            SeekBar findChildViewById10 = ViewBindings.findChildViewById(view, 2131296769);
                                            if (findChildViewById10 != null) {
                                                i = 2131296771;
                                                SeekBar findChildViewById11 = ViewBindings.findChildViewById(view, 2131296771);
                                                if (findChildViewById11 != null) {
                                                    i = 2131296903;
                                                    TextView findChildViewById12 = ViewBindings.findChildViewById(view, 2131296903);
                                                    if (findChildViewById12 != null) {
                                                        i = 2131296904;
                                                        TextView findChildViewById13 = ViewBindings.findChildViewById(view, 2131296904);
                                                        if (findChildViewById13 != null) {
                                                            i = 2131296905;
                                                            TextView findChildViewById14 = ViewBindings.findChildViewById(view, 2131296905);
                                                            if (findChildViewById14 != null) {
                                                                i = 2131296911;
                                                                TextView findChildViewById15 = ViewBindings.findChildViewById(view, 2131296911);
                                                                if (findChildViewById15 != null) {
                                                                    i = 2131296966;
                                                                    TextView findChildViewById16 = ViewBindings.findChildViewById(view, 2131296966);
                                                                    if (findChildViewById16 != null) {
                                                                        i = 2131296967;
                                                                        TextView findChildViewById17 = ViewBindings.findChildViewById(view, 2131296967);
                                                                        if (findChildViewById17 != null) {
                                                                            i = 2131297057;
                                                                            TextView findChildViewById18 = ViewBindings.findChildViewById(view, 2131297057);
                                                                            if (findChildViewById18 != null) {
                                                                                i = 2131297058;
                                                                                TextView findChildViewById19 = ViewBindings.findChildViewById(view, 2131297058);
                                                                                if (findChildViewById19 != null) {
                                                                                    i = 2131297078;
                                                                                    UIImageView findChildViewById20 = ViewBindings.findChildViewById(view, 2131297078);
                                                                                    if (findChildViewById20 != null) {
                                                                                        return new DialogEqBinding((RelativeLayout) view, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, findChildViewById5, findChildViewById6, findChildViewById7, findChildViewById8, findChildViewById9, findChildViewById10, findChildViewById11, findChildViewById12, findChildViewById13, findChildViewById14, findChildViewById15, findChildViewById16, findChildViewById17, findChildViewById18, findChildViewById19, findChildViewById20);
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
