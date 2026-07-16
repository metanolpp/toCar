package com.zddz.app.carlive.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.zddz.widget.UIImageView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class DialogTenEqBinding implements ViewBinding {
    public final TextView btSave;
    public final CheckedTextView ctvTenEqClassic;
    public final CheckedTextView ctvTenEqCountry;
    public final CheckedTextView ctvTenEqCustom;
    public final CheckedTextView ctvTenEqJazz;
    public final CheckedTextView ctvTenEqNormal;
    public final CheckedTextView ctvTenEqPop;
    public final CheckedTextView ctvTenEqRock;
    public final ImageView ivBg;
    public final LinearLayout llStyle;
    public final RelativeLayout rlTop;
    private final RelativeLayout rootView;
    public final SeekBar sbEq0;
    public final SeekBar sbEq1;
    public final SeekBar sbEq2;
    public final SeekBar sbEq3;
    public final SeekBar sbEq4;
    public final SeekBar sbEq5;
    public final SeekBar sbEq6;
    public final SeekBar sbEq7;
    public final SeekBar sbEq8;
    public final SeekBar sbEq9;
    public final SeekBar sbEqBal;
    public final SeekBar sbEqTre;
    public final TextView tvEq0;
    public final TextView tvEq0Value;
    public final TextView tvEq1;
    public final TextView tvEq1Value;
    public final TextView tvEq2;
    public final TextView tvEq2Value;
    public final TextView tvEq3;
    public final TextView tvEq3Value;
    public final TextView tvEq4;
    public final TextView tvEq4Value;
    public final TextView tvEq5;
    public final TextView tvEq5Value;
    public final TextView tvEq6;
    public final TextView tvEq6Value;
    public final TextView tvEq7;
    public final TextView tvEq7Value;
    public final TextView tvEq8;
    public final TextView tvEq8Value;
    public final TextView tvEq9;
    public final TextView tvEq9Value;
    public final TextView tvEqBal;
    public final TextView tvEqTre;
    public final TextView tvEqbalValue;
    public final TextView tvEqtreValue;
    public final UIImageView uivBack;
    public final UIImageView uivReset;

    private DialogTenEqBinding(RelativeLayout relativeLayout, TextView textView, CheckedTextView checkedTextView, CheckedTextView checkedTextView2, CheckedTextView checkedTextView3, CheckedTextView checkedTextView4, CheckedTextView checkedTextView5, CheckedTextView checkedTextView6, CheckedTextView checkedTextView7, ImageView imageView, LinearLayout linearLayout, RelativeLayout relativeLayout2, SeekBar seekBar, SeekBar seekBar2, SeekBar seekBar3, SeekBar seekBar4, SeekBar seekBar5, SeekBar seekBar6, SeekBar seekBar7, SeekBar seekBar8, SeekBar seekBar9, SeekBar seekBar10, SeekBar seekBar11, SeekBar seekBar12, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView20, TextView textView21, TextView textView22, TextView textView23, TextView textView24, TextView textView25, UIImageView uIImageView, UIImageView uIImageView2) {
        this.rootView = relativeLayout;
        this.btSave = textView;
        this.ctvTenEqClassic = checkedTextView;
        this.ctvTenEqCountry = checkedTextView2;
        this.ctvTenEqCustom = checkedTextView3;
        this.ctvTenEqJazz = checkedTextView4;
        this.ctvTenEqNormal = checkedTextView5;
        this.ctvTenEqPop = checkedTextView6;
        this.ctvTenEqRock = checkedTextView7;
        this.ivBg = imageView;
        this.llStyle = linearLayout;
        this.rlTop = relativeLayout2;
        this.sbEq0 = seekBar;
        this.sbEq1 = seekBar2;
        this.sbEq2 = seekBar3;
        this.sbEq3 = seekBar4;
        this.sbEq4 = seekBar5;
        this.sbEq5 = seekBar6;
        this.sbEq6 = seekBar7;
        this.sbEq7 = seekBar8;
        this.sbEq8 = seekBar9;
        this.sbEq9 = seekBar10;
        this.sbEqBal = seekBar11;
        this.sbEqTre = seekBar12;
        this.tvEq0 = textView2;
        this.tvEq0Value = textView3;
        this.tvEq1 = textView4;
        this.tvEq1Value = textView5;
        this.tvEq2 = textView6;
        this.tvEq2Value = textView7;
        this.tvEq3 = textView8;
        this.tvEq3Value = textView9;
        this.tvEq4 = textView10;
        this.tvEq4Value = textView11;
        this.tvEq5 = textView12;
        this.tvEq5Value = textView13;
        this.tvEq6 = textView14;
        this.tvEq6Value = textView15;
        this.tvEq7 = textView16;
        this.tvEq7Value = textView17;
        this.tvEq8 = textView18;
        this.tvEq8Value = textView19;
        this.tvEq9 = textView20;
        this.tvEq9Value = textView21;
        this.tvEqBal = textView22;
        this.tvEqTre = textView23;
        this.tvEqbalValue = textView24;
        this.tvEqtreValue = textView25;
        this.uivBack = uIImageView;
        this.uivReset = uIImageView2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DialogTenEqBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogTenEqBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(2131492930, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogTenEqBinding bind(View view) {
        int i = 2131296364;
        TextView findChildViewById = ViewBindings.findChildViewById(view, 2131296364);
        if (findChildViewById != null) {
            i = 2131296438;
            CheckedTextView findChildViewById2 = ViewBindings.findChildViewById(view, 2131296438);
            if (findChildViewById2 != null) {
                i = 2131296439;
                CheckedTextView findChildViewById3 = ViewBindings.findChildViewById(view, 2131296439);
                if (findChildViewById3 != null) {
                    i = 2131296440;
                    CheckedTextView findChildViewById4 = ViewBindings.findChildViewById(view, 2131296440);
                    if (findChildViewById4 != null) {
                        i = 2131296441;
                        CheckedTextView findChildViewById5 = ViewBindings.findChildViewById(view, 2131296441);
                        if (findChildViewById5 != null) {
                            i = 2131296442;
                            CheckedTextView findChildViewById6 = ViewBindings.findChildViewById(view, 2131296442);
                            if (findChildViewById6 != null) {
                                i = 2131296443;
                                CheckedTextView findChildViewById7 = ViewBindings.findChildViewById(view, 2131296443);
                                if (findChildViewById7 != null) {
                                    i = 2131296445;
                                    CheckedTextView findChildViewById8 = ViewBindings.findChildViewById(view, 2131296445);
                                    if (findChildViewById8 != null) {
                                        i = 2131296556;
                                        ImageView findChildViewById9 = ViewBindings.findChildViewById(view, 2131296556);
                                        if (findChildViewById9 != null) {
                                            i = 2131296603;
                                            LinearLayout findChildViewById10 = ViewBindings.findChildViewById(view, 2131296603);
                                            if (findChildViewById10 != null) {
                                                i = 2131296742;
                                                RelativeLayout findChildViewById11 = ViewBindings.findChildViewById(view, 2131296742);
                                                if (findChildViewById11 != null) {
                                                    i = 2131296753;
                                                    SeekBar findChildViewById12 = ViewBindings.findChildViewById(view, 2131296753);
                                                    if (findChildViewById12 != null) {
                                                        i = 2131296754;
                                                        SeekBar findChildViewById13 = ViewBindings.findChildViewById(view, 2131296754);
                                                        if (findChildViewById13 != null) {
                                                            i = 2131296755;
                                                            SeekBar findChildViewById14 = ViewBindings.findChildViewById(view, 2131296755);
                                                            if (findChildViewById14 != null) {
                                                                i = 2131296756;
                                                                SeekBar findChildViewById15 = ViewBindings.findChildViewById(view, 2131296756);
                                                                if (findChildViewById15 != null) {
                                                                    i = 2131296757;
                                                                    SeekBar findChildViewById16 = ViewBindings.findChildViewById(view, 2131296757);
                                                                    if (findChildViewById16 != null) {
                                                                        i = 2131296758;
                                                                        SeekBar findChildViewById17 = ViewBindings.findChildViewById(view, 2131296758);
                                                                        if (findChildViewById17 != null) {
                                                                            i = 2131296759;
                                                                            SeekBar findChildViewById18 = ViewBindings.findChildViewById(view, 2131296759);
                                                                            if (findChildViewById18 != null) {
                                                                                i = 2131296760;
                                                                                SeekBar findChildViewById19 = ViewBindings.findChildViewById(view, 2131296760);
                                                                                if (findChildViewById19 != null) {
                                                                                    i = 2131296761;
                                                                                    SeekBar findChildViewById20 = ViewBindings.findChildViewById(view, 2131296761);
                                                                                    if (findChildViewById20 != null) {
                                                                                        i = 2131296762;
                                                                                        SeekBar findChildViewById21 = ViewBindings.findChildViewById(view, 2131296762);
                                                                                        if (findChildViewById21 != null) {
                                                                                            i = 2131296763;
                                                                                            SeekBar findChildViewById22 = ViewBindings.findChildViewById(view, 2131296763);
                                                                                            if (findChildViewById22 != null) {
                                                                                                i = 2131296766;
                                                                                                SeekBar findChildViewById23 = ViewBindings.findChildViewById(view, 2131296766);
                                                                                                if (findChildViewById23 != null) {
                                                                                                    i = 2131296934;
                                                                                                    TextView findChildViewById24 = ViewBindings.findChildViewById(view, 2131296934);
                                                                                                    if (findChildViewById24 != null) {
                                                                                                        i = 2131296935;
                                                                                                        TextView findChildViewById25 = ViewBindings.findChildViewById(view, 2131296935);
                                                                                                        if (findChildViewById25 != null) {
                                                                                                            i = 2131296936;
                                                                                                            TextView findChildViewById26 = ViewBindings.findChildViewById(view, 2131296936);
                                                                                                            if (findChildViewById26 != null) {
                                                                                                                i = 2131296937;
                                                                                                                TextView findChildViewById27 = ViewBindings.findChildViewById(view, 2131296937);
                                                                                                                if (findChildViewById27 != null) {
                                                                                                                    i = 2131296938;
                                                                                                                    TextView findChildViewById28 = ViewBindings.findChildViewById(view, 2131296938);
                                                                                                                    if (findChildViewById28 != null) {
                                                                                                                        i = 2131296939;
                                                                                                                        TextView findChildViewById29 = ViewBindings.findChildViewById(view, 2131296939);
                                                                                                                        if (findChildViewById29 != null) {
                                                                                                                            i = 2131296940;
                                                                                                                            TextView findChildViewById30 = ViewBindings.findChildViewById(view, 2131296940);
                                                                                                                            if (findChildViewById30 != null) {
                                                                                                                                i = 2131296941;
                                                                                                                                TextView findChildViewById31 = ViewBindings.findChildViewById(view, 2131296941);
                                                                                                                                if (findChildViewById31 != null) {
                                                                                                                                    i = 2131296942;
                                                                                                                                    TextView findChildViewById32 = ViewBindings.findChildViewById(view, 2131296942);
                                                                                                                                    if (findChildViewById32 != null) {
                                                                                                                                        i = 2131296943;
                                                                                                                                        TextView findChildViewById33 = ViewBindings.findChildViewById(view, 2131296943);
                                                                                                                                        if (findChildViewById33 != null) {
                                                                                                                                            i = 2131296944;
                                                                                                                                            TextView findChildViewById34 = ViewBindings.findChildViewById(view, 2131296944);
                                                                                                                                            if (findChildViewById34 != null) {
                                                                                                                                                i = 2131296945;
                                                                                                                                                TextView findChildViewById35 = ViewBindings.findChildViewById(view, 2131296945);
                                                                                                                                                if (findChildViewById35 != null) {
                                                                                                                                                    i = 2131296946;
                                                                                                                                                    TextView findChildViewById36 = ViewBindings.findChildViewById(view, 2131296946);
                                                                                                                                                    if (findChildViewById36 != null) {
                                                                                                                                                        i = 2131296947;
                                                                                                                                                        TextView findChildViewById37 = ViewBindings.findChildViewById(view, 2131296947);
                                                                                                                                                        if (findChildViewById37 != null) {
                                                                                                                                                            i = 2131296948;
                                                                                                                                                            TextView findChildViewById38 = ViewBindings.findChildViewById(view, 2131296948);
                                                                                                                                                            if (findChildViewById38 != null) {
                                                                                                                                                                i = 2131296949;
                                                                                                                                                                TextView findChildViewById39 = ViewBindings.findChildViewById(view, 2131296949);
                                                                                                                                                                if (findChildViewById39 != null) {
                                                                                                                                                                    i = 2131296950;
                                                                                                                                                                    TextView findChildViewById40 = ViewBindings.findChildViewById(view, 2131296950);
                                                                                                                                                                    if (findChildViewById40 != null) {
                                                                                                                                                                        i = 2131296951;
                                                                                                                                                                        TextView findChildViewById41 = ViewBindings.findChildViewById(view, 2131296951);
                                                                                                                                                                        if (findChildViewById41 != null) {
                                                                                                                                                                            i = 2131296952;
                                                                                                                                                                            TextView findChildViewById42 = ViewBindings.findChildViewById(view, 2131296952);
                                                                                                                                                                            if (findChildViewById42 != null) {
                                                                                                                                                                                i = 2131296953;
                                                                                                                                                                                TextView findChildViewById43 = ViewBindings.findChildViewById(view, 2131296953);
                                                                                                                                                                                if (findChildViewById43 != null) {
                                                                                                                                                                                    i = 2131296954;
                                                                                                                                                                                    TextView findChildViewById44 = ViewBindings.findChildViewById(view, 2131296954);
                                                                                                                                                                                    if (findChildViewById44 != null) {
                                                                                                                                                                                        i = 2131296959;
                                                                                                                                                                                        TextView findChildViewById45 = ViewBindings.findChildViewById(view, 2131296959);
                                                                                                                                                                                        if (findChildViewById45 != null) {
                                                                                                                                                                                            i = 2131296960;
                                                                                                                                                                                            TextView findChildViewById46 = ViewBindings.findChildViewById(view, 2131296960);
                                                                                                                                                                                            if (findChildViewById46 != null) {
                                                                                                                                                                                                i = 2131296965;
                                                                                                                                                                                                TextView findChildViewById47 = ViewBindings.findChildViewById(view, 2131296965);
                                                                                                                                                                                                if (findChildViewById47 != null) {
                                                                                                                                                                                                    i = 2131297075;
                                                                                                                                                                                                    UIImageView findChildViewById48 = ViewBindings.findChildViewById(view, 2131297075);
                                                                                                                                                                                                    if (findChildViewById48 != null) {
                                                                                                                                                                                                        i = 2131297086;
                                                                                                                                                                                                        UIImageView findChildViewById49 = ViewBindings.findChildViewById(view, 2131297086);
                                                                                                                                                                                                        if (findChildViewById49 != null) {
                                                                                                                                                                                                            return new DialogTenEqBinding((RelativeLayout) view, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, findChildViewById5, findChildViewById6, findChildViewById7, findChildViewById8, findChildViewById9, findChildViewById10, findChildViewById11, findChildViewById12, findChildViewById13, findChildViewById14, findChildViewById15, findChildViewById16, findChildViewById17, findChildViewById18, findChildViewById19, findChildViewById20, findChildViewById21, findChildViewById22, findChildViewById23, findChildViewById24, findChildViewById25, findChildViewById26, findChildViewById27, findChildViewById28, findChildViewById29, findChildViewById30, findChildViewById31, findChildViewById32, findChildViewById33, findChildViewById34, findChildViewById35, findChildViewById36, findChildViewById37, findChildViewById38, findChildViewById39, findChildViewById40, findChildViewById41, findChildViewById42, findChildViewById43, findChildViewById44, findChildViewById45, findChildViewById46, findChildViewById47, findChildViewById48, findChildViewById49);
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
