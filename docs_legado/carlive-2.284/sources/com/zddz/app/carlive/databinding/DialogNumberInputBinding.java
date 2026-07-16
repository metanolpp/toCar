package com.zddz.app.carlive.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class DialogNumberInputBinding implements ViewBinding {
    public final TextView btCancel;
    public final TextView btConfirm;
    public final EditText etValue;
    private final LinearLayout rootView;
    public final TextView tvBackspace;
    public final TextView tvClear;
    public final TextView tvEight;
    public final TextView tvFive;
    public final TextView tvFour;
    public final TextView tvMax;
    public final TextView tvMin;
    public final TextView tvNine;
    public final TextView tvOne;
    public final TextView tvPoint;
    public final TextView tvSeven;
    public final TextView tvSix;
    public final TextView tvThree;
    public final TextView tvTitle;
    public final TextView tvTwo;
    public final TextView tvZero;

    private DialogNumberInputBinding(LinearLayout linearLayout, TextView textView, TextView textView2, EditText editText, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18) {
        this.rootView = linearLayout;
        this.btCancel = textView;
        this.btConfirm = textView2;
        this.etValue = editText;
        this.tvBackspace = textView3;
        this.tvClear = textView4;
        this.tvEight = textView5;
        this.tvFive = textView6;
        this.tvFour = textView7;
        this.tvMax = textView8;
        this.tvMin = textView9;
        this.tvNine = textView10;
        this.tvOne = textView11;
        this.tvPoint = textView12;
        this.tvSeven = textView13;
        this.tvSix = textView14;
        this.tvThree = textView15;
        this.tvTitle = textView16;
        this.tvTwo = textView17;
        this.tvZero = textView18;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogNumberInputBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogNumberInputBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(2131492923, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogNumberInputBinding bind(View view) {
        int i = 2131296358;
        TextView findChildViewById = ViewBindings.findChildViewById(view, 2131296358);
        if (findChildViewById != null) {
            i = 2131296360;
            TextView findChildViewById2 = ViewBindings.findChildViewById(view, 2131296360);
            if (findChildViewById2 != null) {
                i = 2131296495;
                EditText findChildViewById3 = ViewBindings.findChildViewById(view, 2131296495);
                if (findChildViewById3 != null) {
                    i = 2131296900;
                    TextView findChildViewById4 = ViewBindings.findChildViewById(view, 2131296900);
                    if (findChildViewById4 != null) {
                        i = 2131296923;
                        TextView findChildViewById5 = ViewBindings.findChildViewById(view, 2131296923);
                        if (findChildViewById5 != null) {
                            i = 2131296933;
                            TextView findChildViewById6 = ViewBindings.findChildViewById(view, 2131296933);
                            if (findChildViewById6 != null) {
                                i = 2131296969;
                                TextView findChildViewById7 = ViewBindings.findChildViewById(view, 2131296969);
                                if (findChildViewById7 != null) {
                                    i = 2131296971;
                                    TextView findChildViewById8 = ViewBindings.findChildViewById(view, 2131296971);
                                    if (findChildViewById8 != null) {
                                        i = 2131297004;
                                        TextView findChildViewById9 = ViewBindings.findChildViewById(view, 2131297004);
                                        if (findChildViewById9 != null) {
                                            i = 2131297005;
                                            TextView findChildViewById10 = ViewBindings.findChildViewById(view, 2131297005);
                                            if (findChildViewById10 != null) {
                                                i = 2131297007;
                                                TextView findChildViewById11 = ViewBindings.findChildViewById(view, 2131297007);
                                                if (findChildViewById11 != null) {
                                                    i = 2131297011;
                                                    TextView findChildViewById12 = ViewBindings.findChildViewById(view, 2131297011);
                                                    if (findChildViewById12 != null) {
                                                        i = 2131297020;
                                                        TextView findChildViewById13 = ViewBindings.findChildViewById(view, 2131297020);
                                                        if (findChildViewById13 != null) {
                                                            i = 2131297028;
                                                            TextView findChildViewById14 = ViewBindings.findChildViewById(view, 2131297028);
                                                            if (findChildViewById14 != null) {
                                                                i = 2131297029;
                                                                TextView findChildViewById15 = ViewBindings.findChildViewById(view, 2131297029);
                                                                if (findChildViewById15 != null) {
                                                                    i = 2131297048;
                                                                    TextView findChildViewById16 = ViewBindings.findChildViewById(view, 2131297048);
                                                                    if (findChildViewById16 != null) {
                                                                        i = 2131297049;
                                                                        TextView findChildViewById17 = ViewBindings.findChildViewById(view, 2131297049);
                                                                        if (findChildViewById17 != null) {
                                                                            i = 2131297059;
                                                                            TextView findChildViewById18 = ViewBindings.findChildViewById(view, 2131297059);
                                                                            if (findChildViewById18 != null) {
                                                                                i = 2131297066;
                                                                                TextView findChildViewById19 = ViewBindings.findChildViewById(view, 2131297066);
                                                                                if (findChildViewById19 != null) {
                                                                                    return new DialogNumberInputBinding((LinearLayout) view, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, findChildViewById5, findChildViewById6, findChildViewById7, findChildViewById8, findChildViewById9, findChildViewById10, findChildViewById11, findChildViewById12, findChildViewById13, findChildViewById14, findChildViewById15, findChildViewById16, findChildViewById17, findChildViewById18, findChildViewById19);
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
