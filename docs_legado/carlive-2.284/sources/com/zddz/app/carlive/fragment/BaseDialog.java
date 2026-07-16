package com.zddz.app.carlive.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class BaseDialog extends DialogFragment {
    protected BaseViewModel mBaseViewModel;
    protected IMain mIMain;
    protected View mRootView;

    public void notice(String str, UUID uuid, byte[] bArr) {
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IMain) {
            this.mIMain = (IMain) context;
        }
        this.mBaseViewModel = (BaseViewModel) new ViewModelProvider(requireActivity()).get(BaseViewModel.class);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (Build.VERSION.SDK_INT < 23 && (activity instanceof IMain)) {
            this.mIMain = (IMain) activity;
        }
        this.mBaseViewModel = (BaseViewModel) new ViewModelProvider(requireActivity()).get(BaseViewModel.class);
    }

    public void show(FragmentManager fragmentManager, String str) {
        fragmentManager.beginTransaction().remove(this).commit();
        super.show(fragmentManager, str);
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
                window.setLayout(-1, -1);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.0f;
                window.setAttributes(attributes);
            }
            dialog.setOnDismissListener(new 1());
        }
    }

    class 1 implements DialogInterface.OnDismissListener {
        1() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            BaseDialog.this.mIMain.setItemVisibility();
        }
    }
}
