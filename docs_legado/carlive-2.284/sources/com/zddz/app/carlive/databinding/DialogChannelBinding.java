package com.zddz.app.carlive.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.zddz.widget.UIImageView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class DialogChannelBinding implements ViewBinding {
    public final CheckedTextView ctvClassic;
    public final CheckedTextView ctvJazz;
    public final CheckedTextView ctvNormal;
    public final CheckedTextView ctvPopular;
    public final CheckedTextView ctvRock;
    public final FrameLayout flBottom;
    public final LinearLayout llButton;
    public final ViewPager2 pagerContent;
    public final RelativeLayout rlTop;
    private final RelativeLayout rootView;
    public final Switch switchBar;
    public final TextView tvOff;
    public final TextView tvTitle;
    public final UIImageView uivBack;
    public final UIImageView uivReset;
    public final ImageView viewBg;

    private DialogChannelBinding(RelativeLayout relativeLayout, CheckedTextView checkedTextView, CheckedTextView checkedTextView2, CheckedTextView checkedTextView3, CheckedTextView checkedTextView4, CheckedTextView checkedTextView5, FrameLayout frameLayout, LinearLayout linearLayout, ViewPager2 viewPager2, RelativeLayout relativeLayout2, Switch r13, TextView textView, TextView textView2, UIImageView uIImageView, UIImageView uIImageView2, ImageView imageView) {
        this.rootView = relativeLayout;
        this.ctvClassic = checkedTextView;
        this.ctvJazz = checkedTextView2;
        this.ctvNormal = checkedTextView3;
        this.ctvPopular = checkedTextView4;
        this.ctvRock = checkedTextView5;
        this.flBottom = frameLayout;
        this.llButton = linearLayout;
        this.pagerContent = viewPager2;
        this.rlTop = relativeLayout2;
        this.switchBar = r13;
        this.tvOff = textView;
        this.tvTitle = textView2;
        this.uivBack = uIImageView;
        this.uivReset = uIImageView2;
        this.viewBg = imageView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DialogChannelBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogChannelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(2131492912, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogChannelBinding bind(View view) {
        int i = 2131296419;
        CheckedTextView findChildViewById = ViewBindings.findChildViewById(view, 2131296419);
        if (findChildViewById != null) {
            i = 2131296428;
            CheckedTextView findChildViewById2 = ViewBindings.findChildViewById(view, 2131296428);
            if (findChildViewById2 != null) {
                i = 2131296431;
                CheckedTextView findChildViewById3 = ViewBindings.findChildViewById(view, 2131296431);
                if (findChildViewById3 != null) {
                    i = 2131296434;
                    CheckedTextView findChildViewById4 = ViewBindings.findChildViewById(view, 2131296434);
                    if (findChildViewById4 != null) {
                        i = 2131296436;
                        CheckedTextView findChildViewById5 = ViewBindings.findChildViewById(view, 2131296436);
                        if (findChildViewById5 != null) {
                            i = 2131296510;
                            FrameLayout findChildViewById6 = ViewBindings.findChildViewById(view, 2131296510);
                            if (findChildViewById6 != null) {
                                i = 2131296581;
                                LinearLayout findChildViewById7 = ViewBindings.findChildViewById(view, 2131296581);
                                if (findChildViewById7 != null) {
                                    i = 2131296695;
                                    ViewPager2 findChildViewById8 = ViewBindings.findChildViewById(view, 2131296695);
                                    if (findChildViewById8 != null) {
                                        i = 2131296742;
                                        RelativeLayout findChildViewById9 = ViewBindings.findChildViewById(view, 2131296742);
                                        if (findChildViewById9 != null) {
                                            i = 2131296848;
                                            Switch findChildViewById10 = ViewBindings.findChildViewById(view, 2131296848);
                                            if (findChildViewById10 != null) {
                                                i = 2131297010;
                                                TextView findChildViewById11 = ViewBindings.findChildViewById(view, 2131297010);
                                                if (findChildViewById11 != null) {
                                                    i = 2131297049;
                                                    TextView findChildViewById12 = ViewBindings.findChildViewById(view, 2131297049);
                                                    if (findChildViewById12 != null) {
                                                        i = 2131297075;
                                                        UIImageView findChildViewById13 = ViewBindings.findChildViewById(view, 2131297075);
                                                        if (findChildViewById13 != null) {
                                                            i = 2131297086;
                                                            UIImageView findChildViewById14 = ViewBindings.findChildViewById(view, 2131297086);
                                                            if (findChildViewById14 != null) {
                                                                i = 2131297105;
                                                                ImageView findChildViewById15 = ViewBindings.findChildViewById(view, 2131297105);
                                                                if (findChildViewById15 != null) {
                                                                    return new DialogChannelBinding((RelativeLayout) view, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, findChildViewById5, findChildViewById6, findChildViewById7, findChildViewById8, findChildViewById9, findChildViewById10, findChildViewById11, findChildViewById12, findChildViewById13, findChildViewById14, findChildViewById15);
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
