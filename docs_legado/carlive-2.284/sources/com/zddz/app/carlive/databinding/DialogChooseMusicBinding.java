package com.zddz.app.carlive.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.zddz.widget.NoAnimateEditText;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class DialogChooseMusicBinding implements ViewBinding {
    public final ConstraintLayout ctlBottomZone;
    public final NoAnimateEditText edtMusicNum;
    private final ConstraintLayout rootView;
    public final TextView tvComfirm;
    public final View viewEmpty;

    private DialogChooseMusicBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, NoAnimateEditText noAnimateEditText, TextView textView, View view) {
        this.rootView = constraintLayout;
        this.ctlBottomZone = constraintLayout2;
        this.edtMusicNum = noAnimateEditText;
        this.tvComfirm = textView;
        this.viewEmpty = view;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DialogChooseMusicBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogChooseMusicBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(2131492916, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogChooseMusicBinding bind(View view) {
        int i = 2131296416;
        ConstraintLayout findChildViewById = ViewBindings.findChildViewById(view, 2131296416);
        if (findChildViewById != null) {
            i = 2131296486;
            NoAnimateEditText findChildViewById2 = ViewBindings.findChildViewById(view, 2131296486);
            if (findChildViewById2 != null) {
                i = 2131296925;
                TextView findChildViewById3 = ViewBindings.findChildViewById(view, 2131296925);
                if (findChildViewById3 != null) {
                    i = 2131297112;
                    View findChildViewById4 = ViewBindings.findChildViewById(view, 2131297112);
                    if (findChildViewById4 != null) {
                        return new DialogChooseMusicBinding((ConstraintLayout) view, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
