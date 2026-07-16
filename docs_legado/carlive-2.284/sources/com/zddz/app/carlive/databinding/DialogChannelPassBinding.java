package com.zddz.app.carlive.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.zddz.widget.UIImageView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class DialogChannelPassBinding implements ViewBinding {
    public final CheckedTextView ctvPhaseNormal;
    public final CheckedTextView ctvPhaseReverse;
    public final ImageView ivHighSlope;
    public final ImageView ivLowSlope;
    public final LinearLayout llDelay;
    public final LinearLayout llHighFrequency;
    public final LinearLayout llLowFrequency;
    public final RelativeLayout rlHighSlope;
    public final RelativeLayout rlLowSlope;
    public final RelativeLayout rlTop;
    private final LinearLayout rootView;
    public final SeekBar sbGain;
    public final Switch switchHighPass;
    public final Switch switchLowPass;
    public final TextView tvChannel;
    public final TextView tvDelayed;
    public final TextView tvGainValue;
    public final TextView tvHighFrequency;
    public final TextView tvHighFrequencyRange;
    public final TextView tvHighFrequencyValue;
    public final TextView tvHighPass;
    public final TextView tvHighSlope;
    public final TextView tvHighSlopeValue;
    public final TextView tvLowFrequency;
    public final TextView tvLowFrequencyRange;
    public final TextView tvLowFrequencyValue;
    public final TextView tvLowPass;
    public final TextView tvLowSlope;
    public final TextView tvLowSlopeValue;
    public final UIImageView uivBack;
    public final UIImageView uivReset;

    private DialogChannelPassBinding(LinearLayout linearLayout, CheckedTextView checkedTextView, CheckedTextView checkedTextView2, ImageView imageView, ImageView imageView2, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, SeekBar seekBar, Switch r15, Switch r16, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, UIImageView uIImageView, UIImageView uIImageView2) {
        this.rootView = linearLayout;
        this.ctvPhaseNormal = checkedTextView;
        this.ctvPhaseReverse = checkedTextView2;
        this.ivHighSlope = imageView;
        this.ivLowSlope = imageView2;
        this.llDelay = linearLayout2;
        this.llHighFrequency = linearLayout3;
        this.llLowFrequency = linearLayout4;
        this.rlHighSlope = relativeLayout;
        this.rlLowSlope = relativeLayout2;
        this.rlTop = relativeLayout3;
        this.sbGain = seekBar;
        this.switchHighPass = r15;
        this.switchLowPass = r16;
        this.tvChannel = textView;
        this.tvDelayed = textView2;
        this.tvGainValue = textView3;
        this.tvHighFrequency = textView4;
        this.tvHighFrequencyRange = textView5;
        this.tvHighFrequencyValue = textView6;
        this.tvHighPass = textView7;
        this.tvHighSlope = textView8;
        this.tvHighSlopeValue = textView9;
        this.tvLowFrequency = textView10;
        this.tvLowFrequencyRange = textView11;
        this.tvLowFrequencyValue = textView12;
        this.tvLowPass = textView13;
        this.tvLowSlope = textView14;
        this.tvLowSlopeValue = textView15;
        this.uivBack = uIImageView;
        this.uivReset = uIImageView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogChannelPassBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogChannelPassBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(2131492914, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogChannelPassBinding bind(View view) {
        int i = 2131296432;
        CheckedTextView findChildViewById = ViewBindings.findChildViewById(view, 2131296432);
        if (findChildViewById != null) {
            i = 2131296433;
            CheckedTextView findChildViewById2 = ViewBindings.findChildViewById(view, 2131296433);
            if (findChildViewById2 != null) {
                i = 2131296558;
                ImageView findChildViewById3 = ViewBindings.findChildViewById(view, 2131296558);
                if (findChildViewById3 != null) {
                    i = 2131296559;
                    ImageView findChildViewById4 = ViewBindings.findChildViewById(view, 2131296559);
                    if (findChildViewById4 != null) {
                        i = 2131296585;
                        LinearLayout findChildViewById5 = ViewBindings.findChildViewById(view, 2131296585);
                        if (findChildViewById5 != null) {
                            i = 2131296591;
                            LinearLayout findChildViewById6 = ViewBindings.findChildViewById(view, 2131296591);
                            if (findChildViewById6 != null) {
                                i = 2131296593;
                                LinearLayout findChildViewById7 = ViewBindings.findChildViewById(view, 2131296593);
                                if (findChildViewById7 != null) {
                                    i = 2131296730;
                                    RelativeLayout findChildViewById8 = ViewBindings.findChildViewById(view, 2131296730);
                                    if (findChildViewById8 != null) {
                                        i = 2131296733;
                                        RelativeLayout findChildViewById9 = ViewBindings.findChildViewById(view, 2131296733);
                                        if (findChildViewById9 != null) {
                                            i = 2131296742;
                                            RelativeLayout findChildViewById10 = ViewBindings.findChildViewById(view, 2131296742);
                                            if (findChildViewById10 != null) {
                                                i = 2131296770;
                                                SeekBar findChildViewById11 = ViewBindings.findChildViewById(view, 2131296770);
                                                if (findChildViewById11 != null) {
                                                    i = 2131296849;
                                                    Switch findChildViewById12 = ViewBindings.findChildViewById(view, 2131296849);
                                                    if (findChildViewById12 != null) {
                                                        i = 2131296850;
                                                        Switch findChildViewById13 = ViewBindings.findChildViewById(view, 2131296850);
                                                        if (findChildViewById13 != null) {
                                                            i = 2131296921;
                                                            TextView findChildViewById14 = ViewBindings.findChildViewById(view, 2131296921);
                                                            if (findChildViewById14 != null) {
                                                                i = 2131296930;
                                                                TextView findChildViewById15 = ViewBindings.findChildViewById(view, 2131296930);
                                                                if (findChildViewById15 != null) {
                                                                    i = 2131296984;
                                                                    TextView findChildViewById16 = ViewBindings.findChildViewById(view, 2131296984);
                                                                    if (findChildViewById16 != null) {
                                                                        i = 2131296988;
                                                                        TextView findChildViewById17 = ViewBindings.findChildViewById(view, 2131296988);
                                                                        if (findChildViewById17 != null) {
                                                                            i = 2131296989;
                                                                            TextView findChildViewById18 = ViewBindings.findChildViewById(view, 2131296989);
                                                                            if (findChildViewById18 != null) {
                                                                                i = 2131296990;
                                                                                TextView findChildViewById19 = ViewBindings.findChildViewById(view, 2131296990);
                                                                                if (findChildViewById19 != null) {
                                                                                    i = 2131296991;
                                                                                    TextView findChildViewById20 = ViewBindings.findChildViewById(view, 2131296991);
                                                                                    if (findChildViewById20 != null) {
                                                                                        i = 2131296992;
                                                                                        TextView findChildViewById21 = ViewBindings.findChildViewById(view, 2131296992);
                                                                                        if (findChildViewById21 != null) {
                                                                                            i = 2131296993;
                                                                                            TextView findChildViewById22 = ViewBindings.findChildViewById(view, 2131296993);
                                                                                            if (findChildViewById22 != null) {
                                                                                                i = 2131296997;
                                                                                                TextView findChildViewById23 = ViewBindings.findChildViewById(view, 2131296997);
                                                                                                if (findChildViewById23 != null) {
                                                                                                    i = 2131296998;
                                                                                                    TextView findChildViewById24 = ViewBindings.findChildViewById(view, 2131296998);
                                                                                                    if (findChildViewById24 != null) {
                                                                                                        i = 2131296999;
                                                                                                        TextView findChildViewById25 = ViewBindings.findChildViewById(view, 2131296999);
                                                                                                        if (findChildViewById25 != null) {
                                                                                                            i = 2131297000;
                                                                                                            TextView findChildViewById26 = ViewBindings.findChildViewById(view, 2131297000);
                                                                                                            if (findChildViewById26 != null) {
                                                                                                                i = 2131297001;
                                                                                                                TextView findChildViewById27 = ViewBindings.findChildViewById(view, 2131297001);
                                                                                                                if (findChildViewById27 != null) {
                                                                                                                    i = 2131297002;
                                                                                                                    TextView findChildViewById28 = ViewBindings.findChildViewById(view, 2131297002);
                                                                                                                    if (findChildViewById28 != null) {
                                                                                                                        i = 2131297075;
                                                                                                                        UIImageView findChildViewById29 = ViewBindings.findChildViewById(view, 2131297075);
                                                                                                                        if (findChildViewById29 != null) {
                                                                                                                            i = 2131297086;
                                                                                                                            UIImageView findChildViewById30 = ViewBindings.findChildViewById(view, 2131297086);
                                                                                                                            if (findChildViewById30 != null) {
                                                                                                                                return new DialogChannelPassBinding((LinearLayout) view, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, findChildViewById5, findChildViewById6, findChildViewById7, findChildViewById8, findChildViewById9, findChildViewById10, findChildViewById11, findChildViewById12, findChildViewById13, findChildViewById14, findChildViewById15, findChildViewById16, findChildViewById17, findChildViewById18, findChildViewById19, findChildViewById20, findChildViewById21, findChildViewById22, findChildViewById23, findChildViewById24, findChildViewById25, findChildViewById26, findChildViewById27, findChildViewById28, findChildViewById29, findChildViewById30);
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
