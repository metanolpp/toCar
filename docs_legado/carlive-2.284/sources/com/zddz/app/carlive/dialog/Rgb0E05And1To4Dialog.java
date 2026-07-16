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
import com.zddz.app.carlive.fragment.BaseViewModel;
import com.zddz.app.carlive.fragment.IMain;
import com.zddz.bt.Convert;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class Rgb0E05And1To4Dialog extends BaseDialog {
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
    private int m0E05CuChoose = 0;
    private int m0E01To04CuChoose = 0;
    private int mTotalRgbNum = 8;
    private View.OnClickListener mOnClickListener = new 1();

    static /* synthetic */ IMain access$000(Rgb0E05And1To4Dialog rgb0E05And1To4Dialog) {
        return rgb0E05And1To4Dialog.mIMain;
    }

    static /* synthetic */ int access$100(Rgb0E05And1To4Dialog rgb0E05And1To4Dialog) {
        return rgb0E05And1To4Dialog.mCuColorType;
    }

    static /* synthetic */ BaseViewModel access$1000(Rgb0E05And1To4Dialog rgb0E05And1To4Dialog) {
        return rgb0E05And1To4Dialog.mBaseViewModel;
    }

    static /* synthetic */ int access$102(Rgb0E05And1To4Dialog rgb0E05And1To4Dialog, int i) {
        rgb0E05And1To4Dialog.mCuColorType = i;
        return i;
    }

    static /* synthetic */ IMain access$1100(Rgb0E05And1To4Dialog rgb0E05And1To4Dialog) {
        return rgb0E05And1To4Dialog.mIMain;
    }

    static /* synthetic */ IMain access$1200(Rgb0E05And1To4Dialog rgb0E05And1To4Dialog) {
        return rgb0E05And1To4Dialog.mIMain;
    }

    static /* synthetic */ BaseViewModel access$200(Rgb0E05And1To4Dialog rgb0E05And1To4Dialog) {
        return rgb0E05And1To4Dialog.mBaseViewModel;
    }

    static /* synthetic */ int access$300(Rgb0E05And1To4Dialog rgb0E05And1To4Dialog) {
        return rgb0E05And1To4Dialog.SHOW_DEFAULT_COLOR;
    }

    static /* synthetic */ void access$400(Rgb0E05And1To4Dialog rgb0E05And1To4Dialog, int i) {
        rgb0E05And1To4Dialog.initData(i);
    }

    static /* synthetic */ int access$500(Rgb0E05And1To4Dialog rgb0E05And1To4Dialog) {
        return rgb0E05And1To4Dialog.SHOW_ALL_COLOR;
    }

    static /* synthetic */ int access$602(Rgb0E05And1To4Dialog rgb0E05And1To4Dialog, int i) {
        rgb0E05And1To4Dialog.m0E01To04CuChoose = i;
        return i;
    }

    static /* synthetic */ int access$702(Rgb0E05And1To4Dialog rgb0E05And1To4Dialog, int i) {
        rgb0E05And1To4Dialog.m0E05CuChoose = i;
        return i;
    }

    static /* synthetic */ int access$802(Rgb0E05And1To4Dialog rgb0E05And1To4Dialog, int i) {
        rgb0E05And1To4Dialog.mTotalRgbNum = i;
        return i;
    }

    static /* synthetic */ List access$900(Rgb0E05And1To4Dialog rgb0E05And1To4Dialog) {
        return rgb0E05And1To4Dialog.mAllDatalist;
    }

    class 1 implements View.OnClickListener {
        1() {
        }

        public void onClick(View view) {
            int id = view.getId();
            if (id == 2131296583) {
                Rgb0E05And1To4Dialog.access$000(Rgb0E05And1To4Dialog.this).setItemVisibility();
                Rgb0E05And1To4Dialog.access$200(Rgb0E05And1To4Dialog.this).setDialog0E05And1To4ClickIndex(Rgb0E05And1To4Dialog.access$100(Rgb0E05And1To4Dialog.this));
                Rgb0E05And1To4Dialog.this.dismiss();
            } else {
                if (id == 2131297026) {
                    Rgb0E05And1To4Dialog rgb0E05And1To4Dialog = Rgb0E05And1To4Dialog.this;
                    Rgb0E05And1To4Dialog.access$102(rgb0E05And1To4Dialog, Rgb0E05And1To4Dialog.access$300(rgb0E05And1To4Dialog));
                    Rgb0E05And1To4Dialog rgb0E05And1To4Dialog2 = Rgb0E05And1To4Dialog.this;
                    Rgb0E05And1To4Dialog.access$400(rgb0E05And1To4Dialog2, Rgb0E05And1To4Dialog.access$300(rgb0E05And1To4Dialog2));
                    return;
                }
                if (id == 2131297027) {
                    Rgb0E05And1To4Dialog rgb0E05And1To4Dialog3 = Rgb0E05And1To4Dialog.this;
                    Rgb0E05And1To4Dialog.access$102(rgb0E05And1To4Dialog3, Rgb0E05And1To4Dialog.access$500(rgb0E05And1To4Dialog3));
                    Rgb0E05And1To4Dialog rgb0E05And1To4Dialog4 = Rgb0E05And1To4Dialog.this;
                    Rgb0E05And1To4Dialog.access$400(rgb0E05And1To4Dialog4, Rgb0E05And1To4Dialog.access$500(rgb0E05And1To4Dialog4));
                }
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
        this.mBaseViewModel.getLightType0E01To04().observe(getViewLifecycleOwner(), new 2());
        this.mBaseViewModel.getLightType0E05().observe(getViewLifecycleOwner(), new 3());
        this.mRootView.findViewById(2131296583).setOnClickListener(this.mOnClickListener);
        this.rl_rgb_0e05_dialog = this.mRootView.findViewById(2131296734);
        LinearLayout findViewById = this.mRootView.findViewById(2131296600);
        this.ll_rgb_0e05_title_view = findViewById;
        findViewById.setVisibility(0);
        this.tv_rgb_0e05_title_one = this.mRootView.findViewById(2131297026);
        this.tv_rgb_0e05_title_two = this.mRootView.findViewById(2131297027);
        this.tv_rgb_0e05_title_one.setOnClickListener(this.mOnClickListener);
        this.tv_rgb_0e05_title_two.setOnClickListener(this.mOnClickListener);
        this.rl_rgb_0e05_dialog.setLayoutManager(new GridLayoutManager(getContext(), 4));
        RGB0E05ColorLightAdapter rGB0E05ColorLightAdapter = new RGB0E05ColorLightAdapter(getContext());
        this.mAdapter = rGB0E05ColorLightAdapter;
        rGB0E05ColorLightAdapter.setOnItemClickListener(new 4());
        int dialog0E05And1To4ClickIndex = this.mBaseViewModel.getDialog0E05And1To4ClickIndex();
        this.mCuColorType = dialog0E05And1To4ClickIndex;
        initData(dialog0E05And1To4ClickIndex);
        this.rl_rgb_0e05_dialog.setAdapter(this.mAdapter);
    }

    class 2 implements Observer {
        2() {
        }

        public void onChanged(String str) {
            if (str.length() >= 6) {
                Rgb0E05And1To4Dialog.access$602(Rgb0E05And1To4Dialog.this, Integer.valueOf(str.substring(4, 6), 16).intValue());
                if (Rgb0E05And1To4Dialog.access$100(Rgb0E05And1To4Dialog.this) == Rgb0E05And1To4Dialog.access$300(Rgb0E05And1To4Dialog.this)) {
                    Rgb0E05And1To4Dialog rgb0E05And1To4Dialog = Rgb0E05And1To4Dialog.this;
                    Rgb0E05And1To4Dialog.access$400(rgb0E05And1To4Dialog, Rgb0E05And1To4Dialog.access$300(rgb0E05And1To4Dialog));
                }
            }
        }
    }

    class 3 implements Observer {
        3() {
        }

        public void onChanged(String str) {
            if (str.length() >= 8) {
                Rgb0E05And1To4Dialog.access$702(Rgb0E05And1To4Dialog.this, Integer.valueOf(str.substring(4, 6), 16).intValue());
                Rgb0E05And1To4Dialog.access$802(Rgb0E05And1To4Dialog.this, Integer.valueOf(str.substring(6, 8), 16).intValue());
                if (Rgb0E05And1To4Dialog.access$100(Rgb0E05And1To4Dialog.this) == Rgb0E05And1To4Dialog.access$500(Rgb0E05And1To4Dialog.this)) {
                    Rgb0E05And1To4Dialog rgb0E05And1To4Dialog = Rgb0E05And1To4Dialog.this;
                    Rgb0E05And1To4Dialog.access$400(rgb0E05And1To4Dialog, Rgb0E05And1To4Dialog.access$500(rgb0E05And1To4Dialog));
                }
            }
        }
    }

    class 4 implements RGB0E05ColorLightAdapter.OnItemClickListener {
        4() {
        }

        public void onItemClick(int i) {
            Rgb0E05ColorItem rgb0E05ColorItem = (Rgb0E05ColorItem) Rgb0E05And1To4Dialog.access$900(Rgb0E05And1To4Dialog.this).get(i);
            rgb0E05ColorItem.setSelect(true);
            Rgb0E05And1To4Dialog.this.mAdapter.updateItem(rgb0E05ColorItem);
            byte[] bArr = new byte[3];
            bArr[0] = 14;
            if (Rgb0E05And1To4Dialog.access$100(Rgb0E05And1To4Dialog.this) == Rgb0E05And1To4Dialog.access$300(Rgb0E05And1To4Dialog.this)) {
                bArr[1] = (byte) Rgb0E05And1To4Dialog.access$1000(Rgb0E05And1To4Dialog.this).getLightType();
            } else {
                bArr[1] = 5;
            }
            bArr[2] = (byte) rgb0E05ColorItem.getColorIndex();
            Rgb0E05And1To4Dialog.access$1100(Rgb0E05And1To4Dialog.this).writeData(bArr);
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
        if (this.mCuColorType == this.SHOW_DEFAULT_COLOR) {
            setItem1Choose();
        } else {
            setItem2Choose();
        }
        Drawable drawable = getResources().getDrawable(2131231092);
        this.tv_rgb_0e05_title_one.setBackground(i == this.SHOW_DEFAULT_COLOR ? drawable : null);
        TextView textView = this.tv_rgb_0e05_title_two;
        if (i != this.SHOW_ALL_COLOR) {
            drawable = null;
        }
        textView.setBackground(drawable);
        this.mAdapter.setDatalist(this.mAllDatalist.subList(0, this.mCuColorType == this.SHOW_DEFAULT_COLOR ? 8 : this.mTotalRgbNum));
        this.mAdapter.notifyDataSetChanged();
    }

    private void setItem2Choose() {
        int i = this.m0E05CuChoose;
        if (i < 0) {
            return;
        }
        for (Rgb0E05ColorItem rgb0E05ColorItem : this.mAllDatalist) {
            if (i == rgb0E05ColorItem.getColorIndex()) {
                rgb0E05ColorItem.setSelect(true);
            } else {
                rgb0E05ColorItem.setSelect(false);
            }
        }
    }

    private void setItem1Choose() {
        if (this.m0E01To04CuChoose < 0) {
            return;
        }
        for (Rgb0E05ColorItem rgb0E05ColorItem : this.mAllDatalist) {
            if (this.m0E01To04CuChoose == rgb0E05ColorItem.getColorIndex()) {
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
            dialog.setOnDismissListener(new 5());
        }
    }

    class 5 implements DialogInterface.OnDismissListener {
        5() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            Rgb0E05And1To4Dialog.access$1200(Rgb0E05And1To4Dialog.this).setItemVisibility();
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
