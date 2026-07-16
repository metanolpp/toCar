package com.zddz.app.carlive.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class PermissionDialogBinding implements ViewBinding {
    public final TextView btApply;
    public final TextView btCancel;
    public final TextView btPrivacyPolicy;
    public final CheckBox cbNoUseLocation;
    public final ListView lvPermission;
    private final RelativeLayout rootView;
    public final TextView tvAllFileAccess;
    public final TextView tvLocationService;
    public final TextView tvNetwork;
    public final TextView tvSystemAlertWindow;
    public final TextView tvTitle;
    public final TextView tvWifi;

    private PermissionDialogBinding(RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, CheckBox checkBox, ListView listView, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        this.rootView = relativeLayout;
        this.btApply = textView;
        this.btCancel = textView2;
        this.btPrivacyPolicy = textView3;
        this.cbNoUseLocation = checkBox;
        this.lvPermission = listView;
        this.tvAllFileAccess = textView4;
        this.tvLocationService = textView5;
        this.tvNetwork = textView6;
        this.tvSystemAlertWindow = textView7;
        this.tvTitle = textView8;
        this.tvWifi = textView9;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static PermissionDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PermissionDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(2131493000, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static PermissionDialogBinding bind(View view) {
        int i = 2131296357;
        TextView findChildViewById = ViewBindings.findChildViewById(view, 2131296357);
        if (findChildViewById != null) {
            i = 2131296358;
            TextView findChildViewById2 = ViewBindings.findChildViewById(view, 2131296358);
            if (findChildViewById2 != null) {
                i = 2131296363;
                TextView findChildViewById3 = ViewBindings.findChildViewById(view, 2131296363);
                if (findChildViewById3 != null) {
                    i = 2131296380;
                    CheckBox findChildViewById4 = ViewBindings.findChildViewById(view, 2131296380);
                    if (findChildViewById4 != null) {
                        i = 2131296607;
                        ListView findChildViewById5 = ViewBindings.findChildViewById(view, 2131296607);
                        if (findChildViewById5 != null) {
                            i = 2131296898;
                            TextView findChildViewById6 = ViewBindings.findChildViewById(view, 2131296898);
                            if (findChildViewById6 != null) {
                                i = 2131296996;
                                TextView findChildViewById7 = ViewBindings.findChildViewById(view, 2131296996);
                                if (findChildViewById7 != null) {
                                    i = 2131297006;
                                    TextView findChildViewById8 = ViewBindings.findChildViewById(view, 2131297006);
                                    if (findChildViewById8 != null) {
                                        i = 2131297041;
                                        TextView findChildViewById9 = ViewBindings.findChildViewById(view, 2131297041);
                                        if (findChildViewById9 != null) {
                                            i = 2131297049;
                                            TextView findChildViewById10 = ViewBindings.findChildViewById(view, 2131297049);
                                            if (findChildViewById10 != null) {
                                                i = 2131297064;
                                                TextView findChildViewById11 = ViewBindings.findChildViewById(view, 2131297064);
                                                if (findChildViewById11 != null) {
                                                    return new PermissionDialogBinding((RelativeLayout) view, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, findChildViewById5, findChildViewById6, findChildViewById7, findChildViewById8, findChildViewById9, findChildViewById10, findChildViewById11);
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
