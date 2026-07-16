package com.zddz.app.carlive.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.Switch;
import androidx.viewpager2.widget.ViewPager2;
import com.zddz.app.carlive.OrderSet;
import com.zddz.app.carlive.fragment.BaseDialog;
import com.zddz.app.carlive.fragment.ChannelEqFragment;
import com.zddz.app.carlive.fragment.ChannelZoneFragment;
import com.zddz.app.carlive.fragment.FragmentAdapter;
import com.zddz.app.carlive.fragment.IMain;
import com.zddz.bt.Convert;
import java.util.ArrayList;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class ChannelDialog extends BaseDialog {
    private CheckedTextView ctv_classic;
    private CheckedTextView ctv_jazz;
    private CheckedTextView ctv_normal;
    private CheckedTextView ctv_popular;
    private CheckedTextView ctv_rock;
    private ChannelEqFragment mChannelTunFragment;
    private ChannelZoneFragment mChannelViewFragment;
    private final View.OnClickListener mOnClickListener = new 1();
    private ViewPager2 pager_content;
    private Switch switch_bar;

    static /* synthetic */ IMain access$000(ChannelDialog channelDialog) {
        return channelDialog.mIMain;
    }

    static /* synthetic */ IMain access$100(ChannelDialog channelDialog) {
        return channelDialog.mIMain;
    }

    static /* synthetic */ IMain access$200(ChannelDialog channelDialog) {
        return channelDialog.mIMain;
    }

    static /* synthetic */ IMain access$300(ChannelDialog channelDialog) {
        return channelDialog.mIMain;
    }

    static /* synthetic */ IMain access$400(ChannelDialog channelDialog) {
        return channelDialog.mIMain;
    }

    static /* synthetic */ IMain access$500(ChannelDialog channelDialog) {
        return channelDialog.mIMain;
    }

    static /* synthetic */ ViewPager2 access$600(ChannelDialog channelDialog) {
        return channelDialog.pager_content;
    }

    class 1 implements View.OnClickListener {
        1() {
        }

        public void onClick(View view) {
            int id = view.getId();
            if (id == 2131297075) {
                ChannelDialog.this.dismiss();
                return;
            }
            if (id == 2131297086) {
                ChannelDialog.access$000(ChannelDialog.this).writeData(OrderSet.write_channel_reset);
                return;
            }
            if (id == 2131296431) {
                ChannelDialog.access$100(ChannelDialog.this).writeData(OrderSet.write_channel_eq_style_normal);
                return;
            }
            if (id == 2131296434) {
                ChannelDialog.access$200(ChannelDialog.this).writeData(OrderSet.write_channel_eq_style_pop);
                return;
            }
            if (id == 2131296436) {
                ChannelDialog.access$300(ChannelDialog.this).writeData(OrderSet.write_channel_eq_style_rock);
            } else if (id == 2131296428) {
                ChannelDialog.access$400(ChannelDialog.this).writeData(OrderSet.write_channel_eq_style_jazz);
            } else if (id == 2131296419) {
                ChannelDialog.access$500(ChannelDialog.this).writeData(OrderSet.write_channel_eq_style_classic);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(2131492912, viewGroup, false);
        return this.mRootView;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mRootView.findViewById(2131297075).setOnClickListener(this.mOnClickListener);
        this.mRootView.findViewById(2131297086).setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById = this.mRootView.findViewById(2131296431);
        this.ctv_normal = findViewById;
        findViewById.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById2 = this.mRootView.findViewById(2131296434);
        this.ctv_popular = findViewById2;
        findViewById2.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById3 = this.mRootView.findViewById(2131296436);
        this.ctv_rock = findViewById3;
        findViewById3.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById4 = this.mRootView.findViewById(2131296428);
        this.ctv_jazz = findViewById4;
        findViewById4.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById5 = this.mRootView.findViewById(2131296419);
        this.ctv_classic = findViewById5;
        findViewById5.setOnClickListener(this.mOnClickListener);
        ViewPager2 findViewById6 = this.mRootView.findViewById(2131296695);
        this.pager_content = findViewById6;
        findViewById6.setOffscreenPageLimit(1);
        this.pager_content.setUserInputEnabled(false);
        ArrayList arrayList = new ArrayList();
        ChannelZoneFragment channelZoneFragment = new ChannelZoneFragment();
        this.mChannelViewFragment = channelZoneFragment;
        arrayList.add(channelZoneFragment);
        ChannelEqFragment channelEqFragment = new ChannelEqFragment();
        this.mChannelTunFragment = channelEqFragment;
        arrayList.add(channelEqFragment);
        this.pager_content.setAdapter(new FragmentAdapter(getChildFragmentManager(), getLifecycle(), arrayList));
        Switch findViewById7 = this.mRootView.findViewById(2131296848);
        this.switch_bar = findViewById7;
        findViewById7.setOnCheckedChangeListener(new 2());
        refreshEqEqType(this.mBaseViewModel.getEqType());
        refreshEqStyle(this.mBaseViewModel.getChannelEqStyle());
    }

    class 2 implements CompoundButton.OnCheckedChangeListener {
        2() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                ChannelDialog.access$600(ChannelDialog.this).setCurrentItem(1);
            } else {
                ChannelDialog.access$600(ChannelDialog.this).setCurrentItem(0);
            }
        }
    }

    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setLayout(-1, -1);
    }

    private void refreshEqStyle(int i) {
        if (i == 0) {
            this.ctv_normal.setChecked(true);
            this.ctv_popular.setChecked(false);
            this.ctv_rock.setChecked(false);
            this.ctv_jazz.setChecked(false);
            this.ctv_classic.setChecked(false);
            return;
        }
        if (i == 1) {
            this.ctv_normal.setChecked(false);
            this.ctv_popular.setChecked(true);
            this.ctv_rock.setChecked(false);
            this.ctv_jazz.setChecked(false);
            this.ctv_classic.setChecked(false);
            return;
        }
        if (i == 2) {
            this.ctv_normal.setChecked(false);
            this.ctv_popular.setChecked(false);
            this.ctv_rock.setChecked(true);
            this.ctv_jazz.setChecked(false);
            this.ctv_classic.setChecked(false);
            return;
        }
        if (i == 3) {
            this.ctv_normal.setChecked(false);
            this.ctv_popular.setChecked(false);
            this.ctv_rock.setChecked(false);
            this.ctv_jazz.setChecked(true);
            this.ctv_classic.setChecked(false);
            return;
        }
        if (i != 4) {
            return;
        }
        this.ctv_normal.setChecked(false);
        this.ctv_popular.setChecked(false);
        this.ctv_rock.setChecked(false);
        this.ctv_jazz.setChecked(false);
        this.ctv_classic.setChecked(true);
    }

    private void refreshEqEqType(int i) {
        if (i == 0 || i == 8) {
            new EqDialog().show(getChildFragmentManager(), "EqDialog");
            dismiss();
        } else if (i == 1 || i == 2) {
            new DspDialog().show(getChildFragmentManager(), "DspDialog");
            dismiss();
        } else if (i == 7) {
            new TenEqDialog().show(getChildFragmentManager(), "TenEqDialog");
            dismiss();
        }
    }

    public void notice(String str, UUID uuid, byte[] bArr) {
        this.mChannelViewFragment.notice(str, uuid, bArr);
        this.mChannelTunFragment.notice(str, uuid, bArr);
        try {
            String upperCase = Convert.bytesToHexString(bArr).toUpperCase();
            if (upperCase.startsWith(OrderSet.notice_version_eq_default) || upperCase.startsWith(OrderSet.notice_version_eq_default_six_station)) {
                new EqDialog().show(getChildFragmentManager(), "EqDialog");
                dismiss();
            } else if (upperCase.startsWith(OrderSet.notice_version_eq_dsp) || upperCase.startsWith(OrderSet.notice_version_eq_aoveise)) {
                new DspDialog().show(getChildFragmentManager(), "DspDialog");
                dismiss();
            } else if (upperCase.startsWith(OrderSet.notice_version_eq_ten_eq)) {
                new TenEqDialog().show(getChildFragmentManager(), "TenEqDialog");
                dismiss();
            } else if (upperCase.startsWith(OrderSet.notice_channel_eq_style_normal)) {
                refreshEqStyle(0);
            } else if (upperCase.startsWith(OrderSet.notice_channel_eq_style_pop)) {
                refreshEqStyle(1);
            } else if (upperCase.startsWith(OrderSet.notice_channel_eq_style_rock)) {
                refreshEqStyle(2);
            } else if (upperCase.startsWith(OrderSet.notice_channel_eq_style_jazz)) {
                refreshEqStyle(3);
            } else if (upperCase.startsWith(OrderSet.notice_channel_eq_style_classic)) {
                refreshEqStyle(4);
            } else if (upperCase.startsWith(OrderSet.notice_channel_eq_style_user)) {
                refreshEqStyle(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
