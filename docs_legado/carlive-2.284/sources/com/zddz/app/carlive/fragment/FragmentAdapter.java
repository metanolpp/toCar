package com.zddz.app.carlive.fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class FragmentAdapter extends FragmentStateAdapter {
    public List mList;

    public FragmentAdapter(FragmentManager fragmentManager, Lifecycle lifecycle, List list) {
        super(fragmentManager, lifecycle);
        this.mList = list;
    }

    public Fragment createFragment(int i) {
        return (Fragment) this.mList.get(i);
    }

    public int getItemCount() {
        return this.mList.size();
    }
}
