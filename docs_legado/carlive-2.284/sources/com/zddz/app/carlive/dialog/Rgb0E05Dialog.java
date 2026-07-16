package com.zddz.app.carlive.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zddz.app.carlive.OrderSet;
import com.zddz.app.carlive.adapter.RGB0E05ColorLightAdapter;
import com.zddz.app.carlive.adapter.entity.Rgb0E05ColorData;
import com.zddz.app.carlive.adapter.entity.Rgb0E05ColorItem;
import com.zddz.app.carlive.fragment.BaseDialog;
import com.zddz.app.carlive.fragment.IMain;
import com.zddz.bt.Convert;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class Rgb0E05Dialog extends BaseDialog {
    LinearLayout ll_rgb_0e05_title_view;
    RGB0E05ColorLightAdapter mAdapter;
    private List mAllDatalist;
    private Rgb0E05ColorData mDataManager;
    private List mDefaultDatalist;
    RecyclerView rl_rgb_0e05_dialog;
    TextView tv_rgb_0e05_title_one;
    TextView tv_rgb_0e05_title_two;
    private byte second = 0;
    String[] mColorNameData = new String[0];
    private int SHOW_ALL_COLOR = 2;
    private int SHOW_DEFAULT_COLOR = 1;
    private int mCuColorType = 1;
    private int mCuChoose = 0;
    private int mTotalRgbNum = 8;
    private View.OnClickListener mOnClickListener = new 1();

    static /* synthetic */ IMain access$000(Rgb0E05Dialog rgb0E05Dialog) {
        return rgb0E05Dialog.mIMain;
    }

    static /* synthetic */ int access$102(Rgb0E05Dialog rgb0E05Dialog, int i) {
        rgb0E05Dialog.mTotalRgbNum = i;
        return i;
    }

    static /* synthetic */ int access$202(Rgb0E05Dialog rgb0E05Dialog, int i) {
        rgb0E05Dialog.mCuColorType = i;
        return i;
    }

    static /* synthetic */ int access$300(Rgb0E05Dialog rgb0E05Dialog) {
        return rgb0E05Dialog.SHOW_DEFAULT_COLOR;
    }

    static /* synthetic */ void access$400(Rgb0E05Dialog rgb0E05Dialog, int i) {
        rgb0E05Dialog.initData(i);
    }

    static /* synthetic */ int access$500(Rgb0E05Dialog rgb0E05Dialog) {
        return rgb0E05Dialog.SHOW_ALL_COLOR;
    }

    static /* synthetic */ int access$602(Rgb0E05Dialog rgb0E05Dialog, int i) {
        rgb0E05Dialog.mCuChoose = i;
        return i;
    }

    static /* synthetic */ List access$700(Rgb0E05Dialog rgb0E05Dialog) {
        return rgb0E05Dialog.mAllDatalist;
    }

    static /* synthetic */ IMain access$800(Rgb0E05Dialog rgb0E05Dialog) {
        return rgb0E05Dialog.mIMain;
    }

    static /* synthetic */ IMain access$900(Rgb0E05Dialog rgb0E05Dialog) {
        return rgb0E05Dialog.mIMain;
    }

    class 1 implements View.OnClickListener {
        1() {
        }

        public void onClick(View view) {
            int id = view.getId();
            if (id == 2131296583) {
                Rgb0E05Dialog.access$000(Rgb0E05Dialog.this).setItemVisibility();
                Rgb0E05Dialog.this.dismiss();
                return;
            }
            if (id == 2131297026) {
                Rgb0E05Dialog.access$102(Rgb0E05Dialog.this, 8);
                Rgb0E05Dialog rgb0E05Dialog = Rgb0E05Dialog.this;
                Rgb0E05Dialog.access$202(rgb0E05Dialog, Rgb0E05Dialog.access$300(rgb0E05Dialog));
                Rgb0E05Dialog rgb0E05Dialog2 = Rgb0E05Dialog.this;
                Rgb0E05Dialog.access$400(rgb0E05Dialog2, Rgb0E05Dialog.access$300(rgb0E05Dialog2));
                return;
            }
            if (id == 2131297027) {
                Rgb0E05Dialog rgb0E05Dialog3 = Rgb0E05Dialog.this;
                Rgb0E05Dialog.access$202(rgb0E05Dialog3, Rgb0E05Dialog.access$500(rgb0E05Dialog3));
                Rgb0E05Dialog.access$102(Rgb0E05Dialog.this, 18);
                Rgb0E05Dialog rgb0E05Dialog4 = Rgb0E05Dialog.this;
                Rgb0E05Dialog.access$400(rgb0E05Dialog4, Rgb0E05Dialog.access$500(rgb0E05Dialog4));
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(2131492911, viewGroup, false);
        return this.mRootView;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mIMain.writeData(OrderSet.write_synchronize);
        this.mBaseViewModel.getLightType0E05().observe(getViewLifecycleOwner(), new 2());
        this.mRootView.findViewById(2131296583).setOnClickListener(this.mOnClickListener);
        this.rl_rgb_0e05_dialog = this.mRootView.findViewById(2131296734);
        this.tv_rgb_0e05_title_one = this.mRootView.findViewById(2131297026);
        this.tv_rgb_0e05_title_two = this.mRootView.findViewById(2131297027);
        this.tv_rgb_0e05_title_one.setOnClickListener(this.mOnClickListener);
        this.tv_rgb_0e05_title_two.setOnClickListener(this.mOnClickListener);
        this.rl_rgb_0e05_dialog.setLayoutManager(new GridLayoutManager(getContext(), 4));
        RGB0E05ColorLightAdapter rGB0E05ColorLightAdapter = new RGB0E05ColorLightAdapter(getContext());
        this.mAdapter = rGB0E05ColorLightAdapter;
        rGB0E05ColorLightAdapter.setOnItemClickListener(new 3());
        this.rl_rgb_0e05_dialog.setAdapter(this.mAdapter);
    }

    class 2 implements Observer {
        2() {
        }

        public void onChanged(String str) {
            if (str.length() >= 8) {
                Rgb0E05Dialog.access$602(Rgb0E05Dialog.this, Integer.valueOf(str.substring(4, 6), 16).intValue());
                Rgb0E05Dialog.access$102(Rgb0E05Dialog.this, Integer.valueOf(str.substring(6, 8), 16).intValue());
                Rgb0E05Dialog.access$400(Rgb0E05Dialog.this, 3);
            }
        }
    }

    class 3 implements RGB0E05ColorLightAdapter.OnItemClickListener {
        3() {
        }

        public void onItemClick(int i) {
            Rgb0E05ColorItem rgb0E05ColorItem = (Rgb0E05ColorItem) Rgb0E05Dialog.access$700(Rgb0E05Dialog.this).get(i);
            rgb0E05ColorItem.setSelect(true);
            Rgb0E05Dialog.this.mAdapter.updateItem(rgb0E05ColorItem);
            Rgb0E05Dialog.access$800(Rgb0E05Dialog.this).writeData(new byte[]{14, 5, (byte) rgb0E05ColorItem.getColorIndex()});
        }
    }

    private void initData(int i) {
        if (this.mDataManager == null || this.mDefaultDatalist == null || this.mAllDatalist == null) {
            this.mDataManager = new Rgb0E05ColorData(getContext());
            this.mDefaultDatalist = new ArrayList();
            this.mAllDatalist = new ArrayList();
        }
        if (this.mAllDatalist.size() == 0) {
            this.mAllDatalist = this.mDataManager.getAllColorList();
        }
        setItemChoose();
        Drawable drawable = getResources().getDrawable(2131231092);
        this.tv_rgb_0e05_title_one.setBackground(i == this.SHOW_DEFAULT_COLOR ? drawable : null);
        TextView textView = this.tv_rgb_0e05_title_two;
        if (i != this.SHOW_ALL_COLOR) {
            drawable = null;
        }
        textView.setBackground(drawable);
        this.mAdapter.setDatalist(this.mAllDatalist.subList(0, this.mTotalRgbNum));
        this.mAdapter.notifyDataSetChanged();
    }

    private void setItemChoose() {
        if (this.mCuChoose < 0) {
            return;
        }
        for (Rgb0E05ColorItem rgb0E05ColorItem : this.mAllDatalist) {
            if (this.mCuChoose == rgb0E05ColorItem.getColorIndex()) {
                rgb0E05ColorItem.setSelect(true);
            } else {
                rgb0E05ColorItem.setSelect(false);
            }
        }
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
            dialog.setOnDismissListener(new 4());
        }
    }

    class 4 implements DialogInterface.OnDismissListener {
        4() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            Rgb0E05Dialog.access$900(Rgb0E05Dialog.this).setItemVisibility();
        }
    }

    public void notice(String str, UUID uuid, byte[] bArr) {
        try {
            String upperCase = Convert.bytesToHexString(bArr).toUpperCase();
            if (!upperCase.startsWith(OrderSet.notice_no_light) && !upperCase.startsWith(OrderSet.notice_rgb) && !upperCase.startsWith(OrderSet.notice_rg) && !upperCase.startsWith(OrderSet.notice_rb)) {
                upperCase.startsWith(OrderSet.notice_gb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
