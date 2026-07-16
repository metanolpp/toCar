package com.zddz.app.carlive.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class BaseFragment extends Fragment {
    protected BaseViewModel mBaseViewModel;
    protected IMain mIMain;
    protected View mRootView;

    public void notice(String str, UUID uuid, byte[] bArr) {
        for (Fragment fragment : getChildFragmentManager().getFragments()) {
            if (fragment instanceof BaseDialog) {
                ((BaseDialog) fragment).notice(str, uuid, bArr);
            }
        }
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
}
