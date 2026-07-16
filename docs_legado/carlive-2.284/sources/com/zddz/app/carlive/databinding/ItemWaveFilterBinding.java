package com.zddz.app.carlive.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.zddz.widget.VerticalSeekBar;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class ItemWaveFilterBinding implements ViewBinding {
    public final EditText etQValue;
    private final LinearLayout rootView;
    public final TextView tvFrequency;
    public final TextView tvGain;
    public final TextView tvNumber;
    public final VerticalSeekBar vsbGain;

    private ItemWaveFilterBinding(LinearLayout linearLayout, EditText editText, TextView textView, TextView textView2, TextView textView3, VerticalSeekBar verticalSeekBar) {
        this.rootView = linearLayout;
        this.etQValue = editText;
        this.tvFrequency = textView;
        this.tvGain = textView2;
        this.tvNumber = textView3;
        this.vsbGain = verticalSeekBar;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemWaveFilterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemWaveFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(2131492941, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemWaveFilterBinding bind(View view) {
        int i = 2131296494;
        EditText findChildViewById = ViewBindings.findChildViewById(view, 2131296494);
        if (findChildViewById != null) {
            i = 2131296972;
            TextView findChildViewById2 = ViewBindings.findChildViewById(view, 2131296972);
            if (findChildViewById2 != null) {
                i = 2131296975;
                TextView findChildViewById3 = ViewBindings.findChildViewById(view, 2131296975);
                if (findChildViewById3 != null) {
                    i = 2131297008;
                    TextView findChildViewById4 = ViewBindings.findChildViewById(view, 2131297008);
                    if (findChildViewById4 != null) {
                        i = 2131297136;
                        VerticalSeekBar verticalSeekBar = (VerticalSeekBar) ViewBindings.findChildViewById(view, 2131297136);
                        if (verticalSeekBar != null) {
                            return new ItemWaveFilterBinding((LinearLayout) view, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, verticalSeekBar);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
