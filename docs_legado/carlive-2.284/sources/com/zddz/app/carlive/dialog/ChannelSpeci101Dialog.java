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
public class ChannelSpeci101Dialog extends BaseDialog {
    private CheckedTextView ctv_classic;
    private CheckedTextView ctv_country;
    private CheckedTextView ctv_guangchang;
    private CheckedTextView ctv_jazz;
    private CheckedTextView ctv_music;
    private CheckedTextView ctv_normal;
    private CheckedTextView ctv_popular;
    private CheckedTextView ctv_rock;
    private ChannelEqFragment mChannelTunFragment;
    private ChannelZoneFragment mChannelViewFragment;
    private ViewPager2 pager_content;
    private Switch switch_bar;
    private final View.OnClickListener mOnClickListener = new 1();
    boolean isCHCanEdit = true;

    private void refreshEqEqType(int i) {
    }

    static /* synthetic */ IMain access$000(ChannelSpeci101Dialog channelSpeci101Dialog) {
        return channelSpeci101Dialog.mIMain;
    }

    static /* synthetic */ IMain access$100(ChannelSpeci101Dialog channelSpeci101Dialog) {
        return channelSpeci101Dialog.mIMain;
    }

    static /* synthetic */ IMain access$200(ChannelSpeci101Dialog channelSpeci101Dialog) {
        return channelSpeci101Dialog.mIMain;
    }

    static /* synthetic */ IMain access$300(ChannelSpeci101Dialog channelSpeci101Dialog) {
        return channelSpeci101Dialog.mIMain;
    }

    static /* synthetic */ IMain access$400(ChannelSpeci101Dialog channelSpeci101Dialog) {
        return channelSpeci101Dialog.mIMain;
    }

    static /* synthetic */ IMain access$500(ChannelSpeci101Dialog channelSpeci101Dialog) {
        return channelSpeci101Dialog.mIMain;
    }

    static /* synthetic */ IMain access$600(ChannelSpeci101Dialog channelSpeci101Dialog) {
        return channelSpeci101Dialog.mIMain;
    }

    static /* synthetic */ IMain access$700(ChannelSpeci101Dialog channelSpeci101Dialog) {
        return channelSpeci101Dialog.mIMain;
    }

    static /* synthetic */ IMain access$800(ChannelSpeci101Dialog channelSpeci101Dialog) {
        return channelSpeci101Dialog.mIMain;
    }

    static /* synthetic */ ViewPager2 access$900(ChannelSpeci101Dialog channelSpeci101Dialog) {
        return channelSpeci101Dialog.pager_content;
    }

    class 1 implements View.OnClickListener {
        1() {
        }

        public void onClick(View view) {
            int id = view.getId();
            if (id == 2131297075) {
                ChannelSpeci101Dialog.this.dismiss();
                return;
            }
            if (id == 2131297086) {
                ChannelSpeci101Dialog.access$000(ChannelSpeci101Dialog.this).writeData(OrderSet.write_channel_reset);
                return;
            }
            if (id == 2131296431) {
                ChannelSpeci101Dialog.access$100(ChannelSpeci101Dialog.this).writeData(OrderSet.write_channel_eq_style_normal);
                return;
            }
            if (id == 2131296434) {
                ChannelSpeci101Dialog.access$200(ChannelSpeci101Dialog.this).writeData(OrderSet.write_channel_eq_style_pop);
                return;
            }
            if (id == 2131296436) {
                ChannelSpeci101Dialog.access$300(ChannelSpeci101Dialog.this).writeData(OrderSet.write_channel_eq_style_rock);
                return;
            }
            if (id == 2131296428) {
                ChannelSpeci101Dialog.access$400(ChannelSpeci101Dialog.this).writeData(OrderSet.write_channel_eq_style_jazz);
                return;
            }
            if (id == 2131296419) {
                ChannelSpeci101Dialog.access$500(ChannelSpeci101Dialog.this).writeData(OrderSet.write_channel_eq_style_classic);
                return;
            }
            if (id == 2131296420) {
                ChannelSpeci101Dialog.access$600(ChannelSpeci101Dialog.this).writeData(OrderSet.write_channel_eq_style_country);
            } else if (id == 2131296421) {
                ChannelSpeci101Dialog.access$700(ChannelSpeci101Dialog.this).writeData(OrderSet.write_channel_eq_style_guangchang);
            } else if (id == 2131296429) {
                ChannelSpeci101Dialog.access$800(ChannelSpeci101Dialog.this).writeData(OrderSet.write_channel_eq_style_music);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(2131492913, viewGroup, false);
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
        CheckedTextView findViewById6 = this.mRootView.findViewById(2131296421);
        this.ctv_guangchang = findViewById6;
        findViewById6.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById7 = this.mRootView.findViewById(2131296429);
        this.ctv_music = findViewById7;
        findViewById7.setOnClickListener(this.mOnClickListener);
        CheckedTextView findViewById8 = this.mRootView.findViewById(2131296420);
        this.ctv_country = findViewById8;
        findViewById8.setOnClickListener(this.mOnClickListener);
        ViewPager2 findViewById9 = this.mRootView.findViewById(2131296695);
        this.pager_content = findViewById9;
        findViewById9.setOffscreenPageLimit(1);
        this.pager_content.setUserInputEnabled(false);
        ArrayList arrayList = new ArrayList();
        ChannelZoneFragment channelZoneFragment = new ChannelZoneFragment();
        this.mChannelViewFragment = channelZoneFragment;
        arrayList.add(channelZoneFragment);
        ChannelEqFragment channelEqFragment = new ChannelEqFragment();
        this.mChannelTunFragment = channelEqFragment;
        arrayList.add(channelEqFragment);
        this.pager_content.setAdapter(new FragmentAdapter(getChildFragmentManager(), getLifecycle(), arrayList));
        Switch findViewById10 = this.mRootView.findViewById(2131296848);
        this.switch_bar = findViewById10;
        findViewById10.setOnCheckedChangeListener(new 2());
        refreshEqEqType(this.mBaseViewModel.getEqType());
        refreshEqStyle(this.mBaseViewModel.getChannelEqStyle());
    }

    class 2 implements CompoundButton.OnCheckedChangeListener {
        2() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                ChannelSpeci101Dialog.access$900(ChannelSpeci101Dialog.this).setCurrentItem(1);
            } else {
                ChannelSpeci101Dialog.access$900(ChannelSpeci101Dialog.this).setCurrentItem(0);
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
        this.isCHCanEdit = i != 7;
        setEditBg();
        switch (i) {
            case 0:
                this.ctv_normal.setChecked(true);
                this.ctv_popular.setChecked(false);
                this.ctv_rock.setChecked(false);
                this.ctv_jazz.setChecked(false);
                this.ctv_classic.setChecked(false);
                this.ctv_country.setChecked(false);
                this.ctv_guangchang.setChecked(false);
                this.ctv_music.setChecked(false);
                break;
            case 1:
                this.ctv_normal.setChecked(false);
                this.ctv_popular.setChecked(true);
                this.ctv_rock.setChecked(false);
                this.ctv_jazz.setChecked(false);
                this.ctv_classic.setChecked(false);
                this.ctv_country.setChecked(false);
                this.ctv_guangchang.setChecked(false);
                this.ctv_music.setChecked(false);
                break;
            case 2:
                this.ctv_normal.setChecked(false);
                this.ctv_popular.setChecked(false);
                this.ctv_rock.setChecked(true);
                this.ctv_jazz.setChecked(false);
                this.ctv_classic.setChecked(false);
                this.ctv_country.setChecked(false);
                this.ctv_guangchang.setChecked(false);
                this.ctv_music.setChecked(false);
                break;
            case 3:
                this.ctv_normal.setChecked(false);
                this.ctv_popular.setChecked(false);
                this.ctv_rock.setChecked(false);
                this.ctv_jazz.setChecked(true);
                this.ctv_classic.setChecked(false);
                this.ctv_country.setChecked(false);
                this.ctv_guangchang.setChecked(false);
                this.ctv_music.setChecked(false);
                break;
            case 4:
                this.ctv_normal.setChecked(false);
                this.ctv_popular.setChecked(false);
                this.ctv_rock.setChecked(false);
                this.ctv_jazz.setChecked(false);
                this.ctv_classic.setChecked(true);
                this.ctv_country.setChecked(false);
                this.ctv_guangchang.setChecked(false);
                this.ctv_music.setChecked(false);
                break;
            case 5:
                this.ctv_normal.setChecked(false);
                this.ctv_popular.setChecked(false);
                this.ctv_rock.setChecked(false);
                this.ctv_jazz.setChecked(false);
                this.ctv_classic.setChecked(false);
                this.ctv_country.setChecked(true);
                this.ctv_guangchang.setChecked(false);
                this.ctv_music.setChecked(false);
                break;
            case 6:
                this.ctv_normal.setChecked(false);
                this.ctv_popular.setChecked(false);
                this.ctv_rock.setChecked(false);
                this.ctv_jazz.setChecked(false);
                this.ctv_classic.setChecked(false);
                this.ctv_country.setChecked(false);
                this.ctv_guangchang.setChecked(true);
                this.ctv_music.setChecked(false);
                break;
            case 7:
                this.ctv_normal.setChecked(false);
                this.ctv_popular.setChecked(false);
                this.ctv_rock.setChecked(false);
                this.ctv_jazz.setChecked(false);
                this.ctv_classic.setChecked(false);
                this.ctv_country.setChecked(false);
                this.ctv_guangchang.setChecked(false);
                this.ctv_music.setChecked(true);
                break;
        }
    }

    public void notice(String str, UUID uuid, byte[] bArr) {
        this.mChannelViewFragment.notice(str, uuid, bArr);
        this.mChannelTunFragment.notice(str, uuid, bArr);
        try {
            String upperCase = Convert.bytesToHexString(bArr).toUpperCase();
            if (!upperCase.startsWith(OrderSet.notice_version_eq_default) && !upperCase.startsWith(OrderSet.notice_version_eq_default_six_station) && !upperCase.startsWith(OrderSet.notice_version_eq_dsp) && !upperCase.startsWith(OrderSet.notice_version_eq_aoveise) && !upperCase.startsWith(OrderSet.notice_version_eq_ten_eq)) {
                if (upperCase.startsWith(OrderSet.notice_channel_eq_style_normal)) {
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
                    refreshEqStyle(5);
                } else if (upperCase.startsWith(OrderSet.notice_channel_eq_style_guangchang)) {
                    refreshEqStyle(6);
                } else if (upperCase.startsWith(OrderSet.notice_channel_eq_style_music)) {
                    refreshEqStyle(7);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setEditBg() {
        this.mChannelViewFragment.setChBtEdit(this.isCHCanEdit);
    }
}
