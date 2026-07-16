package com.zddz.app.carlive.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.zddz.widget.UIImageView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class PermissionWebviewDialogBinding implements ViewBinding {
    public final FrameLayout flCustomViewContainer;
    public final FrameLayout flWebViewContainer;
    public final RelativeLayout rlTop;
    private final LinearLayout rootView;
    public final TextView tvTitle;
    public final UIImageView uivBack;

    private PermissionWebviewDialogBinding(LinearLayout linearLayout, FrameLayout frameLayout, FrameLayout frameLayout2, RelativeLayout relativeLayout, TextView textView, UIImageView uIImageView) {
        this.rootView = linearLayout;
        this.flCustomViewContainer = frameLayout;
        this.flWebViewContainer = frameLayout2;
        this.rlTop = relativeLayout;
        this.tvTitle = textView;
        this.uivBack = uIImageView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PermissionWebviewDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PermissionWebviewDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(2131493002, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static PermissionWebviewDialogBinding bind(View view) {
        int i = 2131296512;
        FrameLayout findChildViewById = ViewBindings.findChildViewById(view, 2131296512);
        if (findChildViewById != null) {
            i = 2131296515;
            FrameLayout findChildViewById2 = ViewBindings.findChildViewById(view, 2131296515);
            if (findChildViewById2 != null) {
                i = 2131296742;
                RelativeLayout findChildViewById3 = ViewBindings.findChildViewById(view, 2131296742);
                if (findChildViewById3 != null) {
                    i = 2131297049;
                    TextView findChildViewById4 = ViewBindings.findChildViewById(view, 2131297049);
                    if (findChildViewById4 != null) {
                        i = 2131297075;
                        UIImageView findChildViewById5 = ViewBindings.findChildViewById(view, 2131297075);
                        if (findChildViewById5 != null) {
                            return new PermissionWebviewDialogBinding((LinearLayout) view, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, findChildViewById5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
