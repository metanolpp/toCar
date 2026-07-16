package com.zddz.app.carlive.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.zddz.widget.ScaleView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class FragmentChannelEqBinding implements ViewBinding {
    public final FrameLayout flMove;
    public final RelativeLayout llFrequency;
    public final RelativeLayout llGain;
    public final RelativeLayout llGrade;
    public final RelativeLayout llQValue;
    private final RelativeLayout rootView;
    public final RecyclerView rvWaveFilter;
    public final TextView tvFrequencyTitle;
    public final TextView tvGainTitle;
    public final TextView tvNumberTitle;
    public final TextView tvQValueTitle;
    public final View viewMove;
    public final ScaleView viewScale;

    private FragmentChannelEqBinding(RelativeLayout relativeLayout, FrameLayout frameLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view, ScaleView scaleView) {
        this.rootView = relativeLayout;
        this.flMove = frameLayout;
        this.llFrequency = relativeLayout2;
        this.llGain = relativeLayout3;
        this.llGrade = relativeLayout4;
        this.llQValue = relativeLayout5;
        this.rvWaveFilter = recyclerView;
        this.tvFrequencyTitle = textView;
        this.tvGainTitle = textView2;
        this.tvNumberTitle = textView3;
        this.tvQValueTitle = textView4;
        this.viewMove = view;
        this.viewScale = scaleView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentChannelEqBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentChannelEqBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(2131492933, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentChannelEqBinding bind(View view) {
        int i = 2131296514;
        FrameLayout findChildViewById = ViewBindings.findChildViewById(view, 2131296514);
        if (findChildViewById != null) {
            i = 2131296588;
            RelativeLayout findChildViewById2 = ViewBindings.findChildViewById(view, 2131296588);
            if (findChildViewById2 != null) {
                i = 2131296589;
                RelativeLayout findChildViewById3 = ViewBindings.findChildViewById(view, 2131296589);
                if (findChildViewById3 != null) {
                    i = 2131296590;
                    RelativeLayout findChildViewById4 = ViewBindings.findChildViewById(view, 2131296590);
                    if (findChildViewById4 != null) {
                        i = 2131296598;
                        RelativeLayout findChildViewById5 = ViewBindings.findChildViewById(view, 2131296598);
                        if (findChildViewById5 != null) {
                            i = 2131296747;
                            RecyclerView findChildViewById6 = ViewBindings.findChildViewById(view, 2131296747);
                            if (findChildViewById6 != null) {
                                i = 2131296973;
                                TextView findChildViewById7 = ViewBindings.findChildViewById(view, 2131296973);
                                if (findChildViewById7 != null) {
                                    i = 2131296983;
                                    TextView findChildViewById8 = ViewBindings.findChildViewById(view, 2131296983);
                                    if (findChildViewById8 != null) {
                                        i = 2131297009;
                                        TextView findChildViewById9 = ViewBindings.findChildViewById(view, 2131297009);
                                        if (findChildViewById9 != null) {
                                            i = 2131297024;
                                            TextView findChildViewById10 = ViewBindings.findChildViewById(view, 2131297024);
                                            if (findChildViewById10 != null) {
                                                i = 2131297125;
                                                View findChildViewById11 = ViewBindings.findChildViewById(view, 2131297125);
                                                if (findChildViewById11 != null) {
                                                    i = 2131297128;
                                                    ScaleView scaleView = (ScaleView) ViewBindings.findChildViewById(view, 2131297128);
                                                    if (scaleView != null) {
                                                        return new FragmentChannelEqBinding((RelativeLayout) view, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, findChildViewById5, findChildViewById6, findChildViewById7, findChildViewById8, findChildViewById9, findChildViewById10, findChildViewById11, scaleView);
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
