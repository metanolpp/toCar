package com.zddz.app.carlive.fragment;

import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import com.hjq.toast.ToastUtils;
import com.zddz.app.carlive.OrderSet;
import com.zddz.app.carlive.dialog.ChannelDialog;
import com.zddz.app.carlive.dialog.ChannelSpeci101Dialog;
import com.zddz.app.carlive.dialog.ChooseMusicDialog;
import com.zddz.app.carlive.dialog.DspDialog;
import com.zddz.app.carlive.dialog.EightAddFourEqSpecialDialog;
import com.zddz.app.carlive.dialog.EqDialog;
import com.zddz.app.carlive.dialog.EqXbassTbeDialog;
import com.zddz.app.carlive.dialog.LoadingDialog;
import com.zddz.app.carlive.dialog.Rgb0E05And1To4Dialog;
import com.zddz.app.carlive.dialog.Rgb0E05Dialog;
import com.zddz.app.carlive.dialog.Rgb9Dialog;
import com.zddz.app.carlive.dialog.RgbDialog;
import com.zddz.app.carlive.dialog.RgbLBDialog;
import com.zddz.app.carlive.dialog.SetupDialog;
import com.zddz.app.carlive.dialog.StationDialog;
import com.zddz.app.carlive.dialog.TenEqDialog;
import com.zddz.app.carlive.dialog.TenEqSpecial1Dialog;
import com.zddz.bt.Convert;
import com.zddz.bt.DeviceRecord;
import com.zddz.update.UpdateHelper;
import com.zddz.update.UpdateSp;
import com.zddz.widget.CdView;
import com.zddz.widget.MarqueeTextView;
import com.zddz.widget.SectionSeekBar;
import com.zddz.widget.UIImageView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.litepal.LitePal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class MainFragment extends BaseFragment {
    private CdView cd_view;
    private ConstraintLayout ctl_dialog_zone;
    EditText edt_music_num;
    private ImageView img_volumn_cut;
    public boolean isBtMusicPlay;
    private ImageView iv_set_up;
    private ImageView iv_update_notice;
    private LinearLayout ll_ams;
    private LinearLayout ll_bt_list;
    private LinearLayout ll_clock;
    private LinearLayout ll_eq;
    private LinearLayout ll_item;
    private LinearLayout ll_mode;
    private LinearLayout ll_rgb;
    private AudioManager mAm;
    private AudioManager mAudioManager;
    private ChooseMusicDialog mChooseMusicDialog;
    private LoadingDialog mLoadingDialog;
    private ScheduledThreadPoolExecutor mThreadPool;
    private MarqueeTextView mtv_content;
    private MarqueeTextView mtv_dab_name;
    private SectionSeekBar section_bar_volume;
    private StationDialog tStationDialog;
    TextView tv_choose_music_tips;
    TextView tv_comfirm;
    private TextView tv_dab_frequency;
    private TextView tv_volume;
    private UIImageView uiv_clock;
    private UIImageView uiv_last;
    private UIImageView uiv_mode;
    private UIImageView uiv_next;
    private UIImageView uiv_play_pause;
    private UIImageView uiv_power;
    private UIImageView uiv_radio;
    private UIImageView uiv_sdcard;
    private UIImageView uiv_usb;
    private UIImageView uiv_volume_add;
    private UIImageView uiv_volume_sub;
    View view_empty;
    private int flash = 4;
    private boolean isHasEq = true;
    private Handler mHandler = new Handler();
    private View mHoldView = null;
    private boolean mFromUser = false;
    private boolean mBarMove = false;
    private boolean mHas0e05 = false;
    public boolean mIsLiBang = false;
    private View.OnClickListener mOnClickListener = new 1();
    private boolean mShowChooseMusicBt = false;
    private Integer mTotalMusicNum = 0;
    private Runnable mHoldRunnable = new 2();
    private final View.OnTouchListener mOnTouchListener = new 3();
    private final View.OnLongClickListener mOnLongClickListener = new 4();
    private boolean mMuteOn = false;
    private boolean isDevHasMetu = false;
    private boolean isUSB = false;
    private boolean isSDCard = false;
    private String name_unicode_hex = "";

    static /* synthetic */ void access$000(MainFragment mainFragment) {
        mainFragment.setChooseMusic();
    }

    static /* synthetic */ ConstraintLayout access$100(MainFragment mainFragment) {
        return mainFragment.ctl_dialog_zone;
    }

    static /* synthetic */ void access$1000(MainFragment mainFragment, int i) {
        mainFragment.refreshMode(i);
    }

    static /* synthetic */ boolean access$1100(MainFragment mainFragment) {
        return mainFragment.mHas0e05;
    }

    static /* synthetic */ boolean access$1102(MainFragment mainFragment, boolean z) {
        mainFragment.mHas0e05 = z;
        return z;
    }

    static /* synthetic */ LinearLayout access$1200(MainFragment mainFragment) {
        return mainFragment.ll_item;
    }

    static /* synthetic */ void access$1300(MainFragment mainFragment) {
        mainFragment.setMetu();
    }

    static /* synthetic */ StationDialog access$1400(MainFragment mainFragment) {
        return mainFragment.tStationDialog;
    }

    static /* synthetic */ StationDialog access$1402(MainFragment mainFragment, StationDialog stationDialog) {
        mainFragment.tStationDialog = stationDialog;
        return stationDialog;
    }

    static /* synthetic */ void access$1500(MainFragment mainFragment) {
        mainFragment.showChooseMusic();
    }

    static /* synthetic */ View access$1600(MainFragment mainFragment) {
        return mainFragment.mHoldView;
    }

    static /* synthetic */ View access$1602(MainFragment mainFragment, View view) {
        mainFragment.mHoldView = view;
        return view;
    }

    static /* synthetic */ UIImageView access$1700(MainFragment mainFragment) {
        return mainFragment.uiv_volume_add;
    }

    static /* synthetic */ Runnable access$1800(MainFragment mainFragment) {
        return mainFragment.mHoldRunnable;
    }

    static /* synthetic */ UIImageView access$1900(MainFragment mainFragment) {
        return mainFragment.uiv_volume_sub;
    }

    static /* synthetic */ void access$200(MainFragment mainFragment) {
        mainFragment.hideInput();
    }

    static /* synthetic */ UIImageView access$2000(MainFragment mainFragment) {
        return mainFragment.uiv_next;
    }

    static /* synthetic */ UIImageView access$2100(MainFragment mainFragment) {
        return mainFragment.uiv_last;
    }

    static /* synthetic */ boolean access$2202(MainFragment mainFragment, boolean z) {
        mainFragment.mFromUser = z;
        return z;
    }

    static /* synthetic */ TextView access$2300(MainFragment mainFragment) {
        return mainFragment.tv_volume;
    }

    static /* synthetic */ SectionSeekBar access$2400(MainFragment mainFragment) {
        return mainFragment.section_bar_volume;
    }

    static /* synthetic */ boolean access$2502(MainFragment mainFragment, boolean z) {
        mainFragment.mBarMove = z;
        return z;
    }

    static /* synthetic */ boolean access$2602(MainFragment mainFragment, boolean z) {
        mainFragment.isHasEq = z;
        return z;
    }

    static /* synthetic */ UIImageView access$2700(MainFragment mainFragment) {
        return mainFragment.uiv_play_pause;
    }

    static /* synthetic */ AudioManager access$2800(MainFragment mainFragment) {
        return mainFragment.mAm;
    }

    static /* synthetic */ LoadingDialog access$300(MainFragment mainFragment) {
        return mainFragment.mLoadingDialog;
    }

    static /* synthetic */ void access$400(MainFragment mainFragment) {
        mainFragment.OpenEqView();
    }

    static /* synthetic */ LinearLayout access$500(MainFragment mainFragment) {
        return mainFragment.ll_clock;
    }

    static /* synthetic */ UIImageView access$600(MainFragment mainFragment) {
        return mainFragment.uiv_clock;
    }

    static /* synthetic */ MarqueeTextView access$700(MainFragment mainFragment) {
        return mainFragment.mtv_content;
    }

    static /* synthetic */ int access$800(MainFragment mainFragment) {
        return mainFragment.flash;
    }

    static /* synthetic */ int access$802(MainFragment mainFragment, int i) {
        mainFragment.flash = i;
        return i;
    }

    static /* synthetic */ Handler access$900(MainFragment mainFragment) {
        return mainFragment.mHandler;
    }

    class 1 implements View.OnClickListener {
        1() {
        }

        public void onClick(View view) {
            int id = view.getId();
            if (id == 2131296545) {
                MainFragment.this.mIMain.writeData(OrderSet.write_mute);
                return;
            }
            if (id == 2131296925) {
                MainFragment.access$000(MainFragment.this);
                MainFragment.access$100(MainFragment.this).setVisibility(8);
                MainFragment.access$200(MainFragment.this);
                return;
            }
            if (id == 2131297112) {
                MainFragment.access$100(MainFragment.this).setVisibility(8);
                MainFragment.access$200(MainFragment.this);
                return;
            }
            if (id == 2131296486) {
                return;
            }
            if (id == 2131297084) {
                MainFragment.this.mIMain.writeData(OrderSet.write_power);
                return;
            }
            if (id == 2131296560) {
                new SetupDialog().show(MainFragment.this.getChildFragmentManager(), "SetupAlertDialog");
                return;
            }
            if (id == 2131296596 || id == 2131297081) {
                if (MainFragment.this.mIMain.writeData(OrderSet.write_mode)) {
                    MainFragment.access$300(MainFragment.this).show();
                    return;
                }
                return;
            }
            if (id == 2131296587 || id == 2131297079) {
                MainFragment.access$400(MainFragment.this);
                return;
            }
            if (id == 2131296577 || id == 2131297074) {
                if (!MainFragment.this.mIMain.checkBle(MainFragment.this.mBaseViewModel.getBleAddress())) {
                    ToastUtils.show(2131755105);
                    return;
                }
                int mode = MainFragment.this.mBaseViewModel.getMode();
                if (mode == 4 || mode == 7) {
                    MainFragment.this.mIMain.writeData(OrderSet.write_scan_station);
                    return;
                }
                return;
            }
            if (id == 2131296582 || id == 2131297077) {
                byte[] bArr = OrderSet.write_set_clock;
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date());
                int i = calendar.get(11);
                int i2 = calendar.get(12);
                int i3 = calendar.get(13);
                int i4 = calendar.get(1);
                int i5 = calendar.get(2) + 1;
                int i6 = calendar.get(5);
                bArr[2] = (byte) i;
                bArr[3] = (byte) i2;
                bArr[4] = (byte) i3;
                bArr[5] = (byte) (i4 - 2000);
                bArr[6] = (byte) i5;
                bArr[7] = (byte) i6;
                CharSequence format = new SimpleDateFormat("HH:mm:ss").format(new Date());
                if (MainFragment.this.mIMain.writeData(bArr)) {
                    MainFragment.access$500(MainFragment.this).setEnabled(false);
                    MainFragment.access$600(MainFragment.this).setEnabled(false);
                    String charSequence = MainFragment.access$700(MainFragment.this).getText().toString();
                    MainFragment.access$700(MainFragment.this).setVisibility(0);
                    MainFragment.access$700(MainFragment.this).setText(format);
                    MainFragment.access$802(MainFragment.this, 8);
                    MainFragment.access$900(MainFragment.this).post(new 1(charSequence));
                    return;
                }
                return;
            }
            if (id == 2131296599 || id == 2131297087) {
                int lightType = MainFragment.this.mBaseViewModel.getLightType();
                DeviceRecord deviceRecord = (DeviceRecord) LitePal.where("address = ?", MainFragment.this.mBaseViewModel.getBleAddress()).findFirst(DeviceRecord.class);
                if (!MainFragment.this.mIMain.checkBle(MainFragment.this.mBaseViewModel.getBleAddress())) {
                    ToastUtils.show(2131755105);
                    return;
                }
                if (deviceRecord != null && deviceRecord.getManufacture_data() != null && deviceRecord.getManufacture_data().equals(OrderSet.DEV_LIBANG) && MainFragment.this.mIsLiBang) {
                    new RgbLBDialog().show(MainFragment.this.getChildFragmentManager(), "RgbLBDialog");
                    return;
                }
                if (deviceRecord != null && deviceRecord.getManufacture_data() != null && deviceRecord.getManufacture_data().equals(OrderSet.SPECIAL4_EQVIEW)) {
                    new Rgb9Dialog().show(MainFragment.this.getChildFragmentManager(), "RgbDialog");
                    return;
                }
                if (MainFragment.access$1100(MainFragment.this)) {
                    if (lightType <= 0 || lightType >= 5) {
                        new Rgb0E05Dialog().show(MainFragment.this.getChildFragmentManager(), "RgbDialog");
                        return;
                    } else {
                        new Rgb0E05And1To4Dialog().show(MainFragment.this.getChildFragmentManager(), "RgbDialog");
                        return;
                    }
                }
                if (lightType != 0) {
                    new RgbDialog().show(MainFragment.this.getChildFragmentManager(), "RgbDialog");
                    MainFragment.access$1200(MainFragment.this).setVisibility(4);
                    return;
                } else {
                    ToastUtils.show(2131755365);
                    return;
                }
            }
            if (id == 2131296580 || id == 2131297076) {
                MainFragment.this.mIMain.showScanDialog();
                return;
            }
            if (id == 2131297083) {
                if (MainFragment.this.mBaseViewModel.getMusicState()) {
                    MainFragment.this.mIMain.writeData(OrderSet.write_pause);
                    return;
                } else {
                    MainFragment.this.mIMain.writeData(OrderSet.write_play);
                    return;
                }
            }
            if (id == 2131297082) {
                MainFragment.this.mIMain.writeData(OrderSet.write_next_click);
                Log.d("MainFragment", "next_click");
                return;
            }
            if (id == 2131297080) {
                MainFragment.this.mIMain.writeData(OrderSet.write_last_click);
                return;
            }
            if (id == 2131297097) {
                MainFragment.access$1300(MainFragment.this);
                if (MainFragment.this.mBaseViewModel.getVolume() < MainFragment.this.mBaseViewModel.getMaxVolume()) {
                    byte[] bArr2 = OrderSet.write_set_volume;
                    bArr2[2] = (byte) (MainFragment.this.mBaseViewModel.getVolume() + 1);
                    MainFragment.this.mIMain.writeData(bArr2);
                    return;
                }
                return;
            }
            if (id == 2131297098) {
                if (MainFragment.this.mBaseViewModel.getVolume() > 0) {
                    byte[] bArr3 = OrderSet.write_set_volume;
                    bArr3[2] = (byte) (MainFragment.this.mBaseViewModel.getVolume() - 1);
                    MainFragment.this.mIMain.writeData(bArr3);
                    return;
                }
                return;
            }
            if (id == 2131297085) {
                MainFragment.access$1402(MainFragment.this, new StationDialog());
                MainFragment.access$1400(MainFragment.this).show(MainFragment.this.getChildFragmentManager(), "StationDialog");
            } else if (id == 2131297096 || id == 2131297088) {
                MainFragment.access$1500(MainFragment.this);
            }
        }

        class 1 implements Runnable {
            final /* synthetic */ String val$content;

            1(String str) {
                this.val$content = str;
            }

            public void run() {
                if (MainFragment.access$800(MainFragment.this) % 2 == 0) {
                    MainFragment.access$700(MainFragment.this).setTextColor(0);
                } else {
                    MainFragment.access$700(MainFragment.this).setTextColor(-1);
                }
                MainFragment.access$802(MainFragment.this, MainFragment.access$800(MainFragment.this) - 1);
                if (MainFragment.access$800(MainFragment.this) > 0) {
                    MainFragment.access$900(MainFragment.this).postDelayed(this, 300L);
                    return;
                }
                MainFragment.access$500(MainFragment.this).setEnabled(true);
                MainFragment.access$600(MainFragment.this).setEnabled(true);
                MainFragment.access$700(MainFragment.this).setText(this.val$content);
                MainFragment.access$1000(MainFragment.this, MainFragment.this.mBaseViewModel.getMode());
            }
        }
    }

    private void OpenEqView() {
        String string = getString(2131755121);
        if (!this.isHasEq) {
            ToastUtils.show((CharSequence) string);
            return;
        }
        if (!this.mIMain.checkBle(this.mBaseViewModel.getBleAddress())) {
            ToastUtils.show(2131755105);
            return;
        }
        DeviceRecord deviceRecord = (DeviceRecord) LitePal.where("address = ?", this.mBaseViewModel.getBleAddress()).findFirst(DeviceRecord.class);
        if (deviceRecord != null && deviceRecord.getManufacture_data() != null && deviceRecord.getManufacture_data().equals(OrderSet.TEN_SPECIAL1)) {
            new TenEqSpecial1Dialog().show(getChildFragmentManager(), "TenEqSpecial1Dialog");
            return;
        }
        if (deviceRecord != null && deviceRecord.getManufacture_data() != null && deviceRecord.getManufacture_data().equals(OrderSet.DEV_ZD_BASS_TBE)) {
            new EqXbassTbeDialog().show(getChildFragmentManager(), "EqXbassTbeDialog");
            return;
        }
        if (deviceRecord != null && deviceRecord.getManufacture_data() != null && deviceRecord.getManufacture_data().equals(OrderSet.Eight_SPECIAL2)) {
            new EightAddFourEqSpecialDialog().show(getChildFragmentManager(), "EeightEqSpecial1Dialog");
            return;
        }
        if (deviceRecord != null && deviceRecord.getManufacture_data() != null && deviceRecord.getManufacture_data().equals(OrderSet.SPECIAL3_EQVIEW)) {
            new ChannelSpeci101Dialog().show(getChildFragmentManager(), "ChannelSpeci101Dialog");
            return;
        }
        int eqType = this.mBaseViewModel.getEqType();
        if (eqType == 0 || eqType == 8 || eqType == 4) {
            new EqDialog().show(getChildFragmentManager(), "EqDialog");
            this.ll_item.setVisibility(4);
            return;
        }
        if (eqType == 1 || eqType == 2) {
            new DspDialog().show(getChildFragmentManager(), "DspDialog");
            return;
        }
        if (eqType == 3 || eqType == 4 || eqType == 5 || eqType == 6) {
            new ChannelDialog().show(getChildFragmentManager(), "ChannelDialog");
        } else if (eqType == 7) {
            new TenEqDialog().show(getChildFragmentManager(), "TenEqDialog");
        }
    }

    private void showChooseMusic() {
        String str = getResources().getString(2131755093) + this.mTotalMusicNum;
        this.edt_music_num.setHint(str);
        this.tv_choose_music_tips.setText(str);
        this.ctl_dialog_zone.setVisibility(0);
    }

    private void hideInput() {
        ((InputMethodManager) this.edt_music_num.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.edt_music_num.getWindowToken(), 0);
    }

    private void setChooseMusic() {
        String obj = this.edt_music_num.getText().toString();
        String string = getResources().getString(2131755463);
        String string2 = getResources().getString(2131755462);
        if (obj.isEmpty()) {
            ToastUtils.show((CharSequence) string);
            return;
        }
        Integer valueOf = Integer.valueOf(obj);
        if (valueOf.intValue() == 0) {
            ToastUtils.show((CharSequence) string2);
        } else {
            this.mIMain.writeData(new byte[]{3, 5, (byte) ((valueOf.intValue() & 65280) >> 8), (byte) (valueOf.intValue() & 255)});
        }
    }

    private void setMetu() {
        if (this.isDevHasMetu && this.mMuteOn) {
            this.mIMain.writeData(OrderSet.write_mute);
        }
    }

    class 2 implements Runnable {
        2() {
        }

        public void run() {
            if (MainFragment.access$1600(MainFragment.this) != null) {
                int id = MainFragment.access$1600(MainFragment.this).getId();
                if (id == 2131297097) {
                    if (MainFragment.this.mBaseViewModel.getVolume() < MainFragment.this.mBaseViewModel.getMaxVolume()) {
                        byte[] bArr = OrderSet.write_set_volume;
                        bArr[2] = (byte) (MainFragment.this.mBaseViewModel.getVolume() + 1);
                        MainFragment.this.mIMain.writeData(bArr);
                    }
                } else if (id == 2131297098) {
                    if (MainFragment.this.mBaseViewModel.getVolume() > 0) {
                        byte[] bArr2 = OrderSet.write_set_volume;
                        bArr2[2] = (byte) (MainFragment.this.mBaseViewModel.getVolume() - 1);
                        MainFragment.this.mIMain.writeData(bArr2);
                    }
                } else if (id == 2131297082) {
                    MainFragment.this.mIMain.writeData(OrderSet.write_next_hold_continue);
                    Log.d("MainFragment", "next_hold_continue");
                } else if (id == 2131297080) {
                    MainFragment.this.mIMain.writeData(OrderSet.write_last_hold_continue);
                }
                MainFragment.access$900(MainFragment.this).postDelayed(this, 300L);
            }
        }
    }

    class 3 implements View.OnTouchListener {
        3() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 || MainFragment.access$1600(MainFragment.this) == null) {
                return false;
            }
            int id = MainFragment.access$1600(MainFragment.this).getId();
            if (id == 2131297082) {
                MainFragment.access$900(MainFragment.this).postDelayed(new 1(), 400L);
            } else if (id == 2131297080) {
                MainFragment.access$900(MainFragment.this).postDelayed(new 2(), 400L);
            }
            MainFragment.access$1602(MainFragment.this, null);
            if (view.isPressed()) {
                view.setPressed(false);
            }
            return true;
        }

        class 1 implements Runnable {
            1() {
            }

            public void run() {
                MainFragment.this.mIMain.writeData(OrderSet.write_next_hold_stop);
                Log.d("MainFragment", "next_hold_stop");
            }
        }

        class 2 implements Runnable {
            2() {
            }

            public void run() {
                MainFragment.this.mIMain.writeData(OrderSet.write_last_hold_stop);
            }
        }
    }

    class 4 implements View.OnLongClickListener {
        4() {
        }

        public boolean onLongClick(View view) {
            int id = view.getId();
            if (id == 2131296577 || id == 2131297074) {
                if (!MainFragment.this.mIMain.checkBle(MainFragment.this.mBaseViewModel.getBleAddress())) {
                    MainFragment.this.mIMain.showScanDialog();
                    return true;
                }
                int mode = MainFragment.this.mBaseViewModel.getMode();
                if ((mode != 4 && mode != 7) || !MainFragment.this.mIMain.writeData(OrderSet.write_ams)) {
                    return true;
                }
                MainFragment.access$700(MainFragment.this).setText(2131755424);
                return true;
            }
            if (id == 2131297097) {
                MainFragment mainFragment = MainFragment.this;
                MainFragment.access$1602(mainFragment, MainFragment.access$1700(mainFragment));
                MainFragment.access$900(MainFragment.this).post(MainFragment.access$1800(MainFragment.this));
                return true;
            }
            if (id == 2131297098) {
                MainFragment mainFragment2 = MainFragment.this;
                MainFragment.access$1602(mainFragment2, MainFragment.access$1900(mainFragment2));
                MainFragment.access$900(MainFragment.this).post(MainFragment.access$1800(MainFragment.this));
                return true;
            }
            if (id == 2131297082) {
                synchronized (Thread.currentThread()) {
                    try {
                        MainFragment mainFragment3 = MainFragment.this;
                        MainFragment.access$1602(mainFragment3, MainFragment.access$2000(mainFragment3));
                        MainFragment.this.mIMain.writeData(OrderSet.write_next_long_click);
                        Thread.currentThread().wait(500L);
                        MainFragment.this.mIMain.writeData(OrderSet.write_next_hold_start);
                        Thread.currentThread().wait(500L);
                        MainFragment.access$900(MainFragment.this).post(MainFragment.access$1800(MainFragment.this));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return true;
            }
            if (id != 2131297080) {
                return true;
            }
            synchronized (Thread.currentThread()) {
                try {
                    MainFragment mainFragment4 = MainFragment.this;
                    MainFragment.access$1602(mainFragment4, MainFragment.access$2100(mainFragment4));
                    MainFragment.this.mIMain.writeData(OrderSet.write_last_long_click);
                    Thread.currentThread().wait(500L);
                    MainFragment.this.mIMain.writeData(OrderSet.write_last_hold_start);
                    Thread.currentThread().wait(500L);
                    MainFragment.access$900(MainFragment.this).post(MainFragment.access$1800(MainFragment.this));
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            return true;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(2131492935, viewGroup, false);
            this.uiv_power = this.mRootView.findViewById(2131297084);
            this.ctl_dialog_zone = this.mRootView.findViewById(2131296418);
            this.tv_comfirm = this.mRootView.findViewById(2131296925);
            this.tv_choose_music_tips = this.mRootView.findViewById(2131296922);
            View findViewById = this.mRootView.findViewById(2131297112);
            this.view_empty = findViewById;
            findViewById.setOnClickListener(this.mOnClickListener);
            this.tv_comfirm.setOnClickListener(this.mOnClickListener);
            EditText findViewById2 = this.mRootView.findViewById(2131296486);
            this.edt_music_num = findViewById2;
            findViewById2.setOnClickListener(this.mOnClickListener);
            this.edt_music_num.setOnKeyListener(new 5());
            this.uiv_power.setOnClickListener(this.mOnClickListener);
            ImageView findViewById3 = this.mRootView.findViewById(2131296560);
            this.iv_set_up = findViewById3;
            findViewById3.setOnClickListener(this.mOnClickListener);
            ImageView findViewById4 = this.mRootView.findViewById(2131296563);
            this.iv_update_notice = findViewById4;
            findViewById4.setVisibility(8);
            this.cd_view = (CdView) this.mRootView.findViewById(2131296381);
            this.uiv_radio = this.mRootView.findViewById(2131297085);
            this.uiv_usb = this.mRootView.findViewById(2131297096);
            this.uiv_sdcard = this.mRootView.findViewById(2131297088);
            ImageView findViewById5 = this.mRootView.findViewById(2131296545);
            this.img_volumn_cut = findViewById5;
            findViewById5.setOnClickListener(this.mOnClickListener);
            this.uiv_radio.setVisibility(8);
            this.uiv_usb.setVisibility(8);
            this.uiv_sdcard.setVisibility(8);
            this.uiv_radio.setOnClickListener(this.mOnClickListener);
            this.uiv_usb.setOnClickListener(this.mOnClickListener);
            this.uiv_sdcard.setOnClickListener(this.mOnClickListener);
            this.mtv_content = this.mRootView.findViewById(2131296667);
            this.tv_dab_frequency = this.mRootView.findViewById(2131296929);
            this.mtv_dab_name = this.mRootView.findViewById(2131296668);
            this.ll_item = this.mRootView.findViewById(2131296592);
            LinearLayout findViewById6 = this.mRootView.findViewById(2131296596);
            this.ll_mode = findViewById6;
            findViewById6.setOnClickListener(this.mOnClickListener);
            LinearLayout findViewById7 = this.mRootView.findViewById(2131296587);
            this.ll_eq = findViewById7;
            findViewById7.setOnClickListener(this.mOnClickListener);
            LinearLayout findViewById8 = this.mRootView.findViewById(2131296577);
            this.ll_ams = findViewById8;
            findViewById8.setOnClickListener(this.mOnClickListener);
            this.ll_ams.setOnLongClickListener(this.mOnLongClickListener);
            LinearLayout findViewById9 = this.mRootView.findViewById(2131296582);
            this.ll_clock = findViewById9;
            findViewById9.setOnClickListener(this.mOnClickListener);
            LinearLayout findViewById10 = this.mRootView.findViewById(2131296599);
            this.ll_rgb = findViewById10;
            findViewById10.setOnClickListener(this.mOnClickListener);
            LinearLayout findViewById11 = this.mRootView.findViewById(2131296580);
            this.ll_bt_list = findViewById11;
            findViewById11.setOnClickListener(this.mOnClickListener);
            UIImageView findViewById12 = this.mRootView.findViewById(2131297081);
            this.uiv_mode = findViewById12;
            findViewById12.setOnClickListener(this.mOnClickListener);
            this.mRootView.findViewById(2131297079).setOnClickListener(this.mOnClickListener);
            this.mRootView.findViewById(2131297074).setOnClickListener(this.mOnClickListener);
            UIImageView findViewById13 = this.mRootView.findViewById(2131297077);
            this.uiv_clock = findViewById13;
            findViewById13.setOnClickListener(this.mOnClickListener);
            this.mRootView.findViewById(2131297087).setOnClickListener(this.mOnClickListener);
            this.mRootView.findViewById(2131297076).setOnClickListener(this.mOnClickListener);
            UIImageView findViewById14 = this.mRootView.findViewById(2131297080);
            this.uiv_last = findViewById14;
            findViewById14.setOnClickListener(this.mOnClickListener);
            this.uiv_last.setOnLongClickListener(this.mOnLongClickListener);
            this.uiv_last.setOnTouchListener(this.mOnTouchListener);
            UIImageView findViewById15 = this.mRootView.findViewById(2131297083);
            this.uiv_play_pause = findViewById15;
            findViewById15.setOnClickListener(this.mOnClickListener);
            UIImageView findViewById16 = this.mRootView.findViewById(2131297082);
            this.uiv_next = findViewById16;
            findViewById16.setOnClickListener(this.mOnClickListener);
            this.uiv_next.setOnLongClickListener(this.mOnLongClickListener);
            this.uiv_next.setOnTouchListener(this.mOnTouchListener);
            UIImageView findViewById17 = this.mRootView.findViewById(2131297098);
            this.uiv_volume_sub = findViewById17;
            findViewById17.setOnClickListener(this.mOnClickListener);
            this.uiv_volume_sub.setOnLongClickListener(this.mOnLongClickListener);
            this.uiv_volume_sub.setOnTouchListener(this.mOnTouchListener);
            UIImageView findViewById18 = this.mRootView.findViewById(2131297097);
            this.uiv_volume_add = findViewById18;
            findViewById18.setOnClickListener(this.mOnClickListener);
            this.uiv_volume_add.setOnLongClickListener(this.mOnLongClickListener);
            this.uiv_volume_add.setOnTouchListener(this.mOnTouchListener);
            this.tv_volume = this.mRootView.findViewById(2131297062);
            SectionSeekBar sectionSeekBar = (SectionSeekBar) this.mRootView.findViewById(2131296803);
            this.section_bar_volume = sectionSeekBar;
            sectionSeekBar.setOnChangeListener(new 6());
            this.mBaseViewModel.getLightType0E05().observe(getViewLifecycleOwner(), new 7());
            this.mBaseViewModel.getEqHas().observe(getViewLifecycleOwner(), new 8());
            this.mLoadingDialog = new LoadingDialog(getContext());
            this.mAudioManager = (AudioManager) getActivity().getSystemService("audio");
            refreshMode(this.mBaseViewModel.getMode());
            startListenMusicPlay();
        }
        ViewGroup parent = this.mRootView.getParent();
        if (parent != null) {
            parent.removeView(this.mRootView);
        }
        return this.mRootView;
    }

    class 5 implements View.OnKeyListener {
        5() {
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 1) {
                return false;
            }
            if (i != 3 && i != 6 && (keyEvent == null || keyEvent.getKeyCode() != 66)) {
                return false;
            }
            MainFragment.access$000(MainFragment.this);
            MainFragment.access$100(MainFragment.this).setVisibility(8);
            MainFragment.access$200(MainFragment.this);
            return true;
        }
    }

    class 6 implements SectionSeekBar.OnChangeListener {
        6() {
        }

        public void onChange(SectionSeekBar sectionSeekBar, int i, boolean z) {
            MainFragment.access$2202(MainFragment.this, z);
            MainFragment.access$2300(MainFragment.this).setText(String.valueOf(sectionSeekBar.getProgress()));
            if (z) {
                MainFragment.access$900(MainFragment.this).postDelayed(new 1(), 200L);
            }
        }

        class 1 implements Runnable {
            1() {
            }

            public void run() {
                int maxVolume = (MainFragment.this.mBaseViewModel.getMaxVolume() * MainFragment.access$2400(MainFragment.this).getProgress()) / MainFragment.access$2400(MainFragment.this).getMax();
                byte[] bArr = OrderSet.write_set_volume;
                bArr[2] = (byte) maxVolume;
                MainFragment.this.mIMain.writeData(bArr);
            }
        }

        public void onStartTrackingTouch(SectionSeekBar sectionSeekBar) {
            MainFragment.access$1300(MainFragment.this);
            MainFragment.access$2502(MainFragment.this, true);
        }

        class 2 implements Runnable {
            final /* synthetic */ SectionSeekBar val$seekBar;

            2(SectionSeekBar sectionSeekBar) {
                this.val$seekBar = sectionSeekBar;
            }

            public void run() {
                MainFragment.access$2502(MainFragment.this, false);
                int maxVolume = (MainFragment.this.mBaseViewModel.getMaxVolume() * this.val$seekBar.getProgress()) / this.val$seekBar.getMax();
                byte[] bArr = OrderSet.write_set_volume;
                bArr[2] = (byte) maxVolume;
                MainFragment.this.mIMain.writeData(bArr);
            }
        }

        public void onStopTrackingTouch(SectionSeekBar sectionSeekBar) {
            MainFragment.access$900(MainFragment.this).postDelayed(new 2(sectionSeekBar), 300L);
        }
    }

    class 7 implements Observer {
        7() {
        }

        public void onChanged(String str) {
            if (str.length() > 0) {
                MainFragment.access$1102(MainFragment.this, true);
            } else {
                MainFragment.access$1102(MainFragment.this, false);
            }
        }
    }

    class 8 implements Observer {
        8() {
        }

        public void onChanged(Boolean bool) {
            MainFragment.access$2602(MainFragment.this, bool.booleanValue());
        }
    }

    private void refreshMode(int i) {
        if (this.mRootView == null) {
            return;
        }
        this.isUSB = false;
        this.isSDCard = false;
        hideInput();
        if (i == 0) {
            this.uiv_power.getDrawable().setLevel(0);
            this.mtv_content.setVisibility(4);
            this.uiv_mode.getDrawable().setLevel(0);
            this.tv_dab_frequency.setVisibility(4);
            this.mtv_dab_name.setVisibility(4);
            this.uiv_radio.setVisibility(8);
            this.uiv_usb.setVisibility(8);
            this.uiv_sdcard.setVisibility(8);
            this.ctl_dialog_zone.setVisibility(4);
        } else {
            switch (i) {
                case 2:
                    this.isUSB = true;
                    this.uiv_power.getDrawable().setLevel(1);
                    this.uiv_mode.getDrawable().setLevel(2);
                    this.mtv_content.setVisibility(0);
                    this.tv_dab_frequency.setVisibility(4);
                    this.mtv_dab_name.setVisibility(4);
                    this.uiv_radio.setVisibility(8);
                    this.uiv_sdcard.setVisibility(8);
                    this.mtv_content.setText(this.mBaseViewModel.getMusicNumber() + "." + this.mBaseViewModel.getMusicTitle());
                    break;
                case 3:
                    this.isSDCard = true;
                    this.uiv_power.getDrawable().setLevel(1);
                    this.uiv_mode.getDrawable().setLevel(3);
                    this.mtv_content.setVisibility(0);
                    this.tv_dab_frequency.setVisibility(4);
                    this.mtv_dab_name.setVisibility(4);
                    this.uiv_radio.setVisibility(8);
                    this.uiv_usb.setVisibility(8);
                    this.mtv_content.setText(this.mBaseViewModel.getMusicNumber() + "." + this.mBaseViewModel.getMusicTitle());
                    break;
                case 4:
                    this.uiv_power.getDrawable().setLevel(1);
                    this.uiv_mode.getDrawable().setLevel(4);
                    this.mtv_content.setVisibility(0);
                    this.uiv_play_pause.getDrawable().setLevel(0);
                    this.tv_dab_frequency.setVisibility(4);
                    this.mtv_dab_name.setVisibility(4);
                    this.ctl_dialog_zone.setVisibility(4);
                    this.uiv_usb.setVisibility(8);
                    this.uiv_sdcard.setVisibility(8);
                    int eqType = this.mBaseViewModel.getEqType();
                    DeviceRecord deviceRecord = (DeviceRecord) LitePal.where("address = ?", this.mBaseViewModel.getBleAddress()).findFirst(DeviceRecord.class);
                    if (eqType == 3 || eqType == 4 || eqType == 5 || eqType == 7 || eqType == 8 || deviceRecord.getManufacture_data().equals(OrderSet.Eight_SPECIAL2)) {
                        this.uiv_radio.setVisibility(0);
                    } else {
                        this.uiv_radio.setVisibility(8);
                    }
                    int fmFrequency = this.mBaseViewModel.getFmFrequency();
                    if (fmFrequency <= 8000) {
                        if (fmFrequency > 0) {
                            this.mtv_content.setText(fmFrequency + "KHz");
                            break;
                        }
                    } else {
                        this.mtv_content.setText((fmFrequency / 100) + "." + String.valueOf(fmFrequency % 100) + "MHz");
                        break;
                    }
                    break;
                case 5:
                    this.mtv_content.setText("");
                    this.uiv_power.getDrawable().setLevel(1);
                    this.uiv_mode.getDrawable().setLevel(5);
                    this.ctl_dialog_zone.setVisibility(4);
                    this.mtv_content.setVisibility(0);
                    this.tv_dab_frequency.setVisibility(4);
                    this.mtv_dab_name.setVisibility(4);
                    if (this.mAudioManager.isMusicActive()) {
                        this.uiv_play_pause.getDrawable().setLevel(1);
                    } else {
                        this.uiv_play_pause.getDrawable().setLevel(0);
                    }
                    this.mtv_dab_name.setVisibility(4);
                    this.uiv_radio.setVisibility(8);
                    this.uiv_usb.setVisibility(8);
                    this.uiv_sdcard.setVisibility(8);
                    break;
                case 6:
                    this.uiv_power.getDrawable().setLevel(1);
                    this.uiv_mode.getDrawable().setLevel(6);
                    this.ctl_dialog_zone.setVisibility(4);
                    this.mtv_content.setVisibility(4);
                    this.uiv_play_pause.getDrawable().setLevel(0);
                    this.tv_dab_frequency.setVisibility(4);
                    this.mtv_dab_name.setVisibility(4);
                    this.uiv_radio.setVisibility(8);
                    this.uiv_usb.setVisibility(8);
                    this.uiv_sdcard.setVisibility(8);
                    break;
                case 7:
                    this.uiv_power.getDrawable().setLevel(1);
                    this.uiv_mode.getDrawable().setLevel(7);
                    this.ctl_dialog_zone.setVisibility(4);
                    this.mtv_content.setVisibility(0);
                    this.tv_dab_frequency.setVisibility(0);
                    this.mtv_dab_name.setVisibility(0);
                    this.uiv_play_pause.getDrawable().setLevel(0);
                    this.uiv_radio.setVisibility(8);
                    this.uiv_usb.setVisibility(8);
                    this.uiv_sdcard.setVisibility(8);
                    if (this.mBaseViewModel.getDabStationNumber() <= 0) {
                        this.mtv_content.setText("");
                    } else {
                        this.mtv_content.setText("CH" + this.mBaseViewModel.getDabStationNumber());
                    }
                    this.tv_dab_frequency.setText(this.mBaseViewModel.getDabFrequency());
                    this.mtv_dab_name.setText(this.mBaseViewModel.getDabName());
                    break;
                case 8:
                    this.uiv_power.getDrawable().setLevel(1);
                    this.uiv_mode.getDrawable().setLevel(8);
                    this.ctl_dialog_zone.setVisibility(4);
                    this.mtv_content.setVisibility(0);
                    this.tv_dab_frequency.setVisibility(0);
                    this.mtv_dab_name.setVisibility(0);
                    this.uiv_radio.setVisibility(8);
                    this.uiv_usb.setVisibility(8);
                    this.uiv_sdcard.setVisibility(8);
                    break;
                case 9:
                    this.uiv_power.getDrawable().setLevel(1);
                    this.uiv_mode.getDrawable().setLevel(9);
                    this.mtv_content.setVisibility(0);
                    this.ctl_dialog_zone.setVisibility(4);
                    this.tv_dab_frequency.setVisibility(0);
                    this.mtv_dab_name.setVisibility(0);
                    this.uiv_play_pause.getDrawable().setLevel(0);
                    this.uiv_radio.setVisibility(8);
                    this.uiv_usb.setVisibility(8);
                    this.uiv_sdcard.setVisibility(8);
                    break;
                case 10:
                    this.uiv_power.getDrawable().setLevel(1);
                    this.uiv_mode.getDrawable().setLevel(10);
                    this.mtv_content.setVisibility(4);
                    this.ctl_dialog_zone.setVisibility(4);
                    this.tv_dab_frequency.setVisibility(4);
                    this.mtv_dab_name.setVisibility(4);
                    this.uiv_play_pause.getDrawable().setLevel(0);
                    this.uiv_radio.setVisibility(8);
                    this.uiv_usb.setVisibility(8);
                    this.uiv_sdcard.setVisibility(8);
                    break;
                case 11:
                    this.uiv_power.getDrawable().setLevel(1);
                    this.uiv_mode.getDrawable().setLevel(11);
                    this.mtv_content.setVisibility(4);
                    this.ctl_dialog_zone.setVisibility(4);
                    this.tv_dab_frequency.setVisibility(4);
                    this.mtv_dab_name.setVisibility(4);
                    this.uiv_play_pause.getDrawable().setLevel(0);
                    this.uiv_radio.setVisibility(8);
                    this.uiv_usb.setVisibility(8);
                    this.uiv_sdcard.setVisibility(8);
                    break;
                case 12:
                    this.uiv_power.getDrawable().setLevel(1);
                    this.uiv_mode.getDrawable().setLevel(12);
                    this.mtv_content.setVisibility(4);
                    this.ctl_dialog_zone.setVisibility(4);
                    this.tv_dab_frequency.setVisibility(4);
                    this.mtv_dab_name.setVisibility(4);
                    this.uiv_play_pause.getDrawable().setLevel(0);
                    this.uiv_radio.setVisibility(8);
                    this.uiv_usb.setVisibility(8);
                    this.uiv_sdcard.setVisibility(8);
                    break;
            }
        }
        this.mLoadingDialog.dismiss();
    }

    public void notice(String str, UUID uuid, byte[] bArr) {
        super.notice(str, uuid, bArr);
        try {
            String upperCase = Convert.bytesToHexString(bArr).toUpperCase();
            Log.d("MainFragment", "notice: " + upperCase);
            if (upperCase.startsWith(OrderSet.notice_libang_rgb)) {
                this.mIsLiBang = true;
                return;
            }
            if (upperCase.startsWith(OrderSet.notice_power_off)) {
                refreshMode(0);
                return;
            }
            if (upperCase.startsWith(OrderSet.notice_mute_has)) {
                this.isDevHasMetu = true;
                this.img_volumn_cut.setVisibility(0);
                return;
            }
            if (upperCase.startsWith(OrderSet.notice_mode)) {
                refreshMode(1);
                return;
            }
            if (upperCase.startsWith(OrderSet.notice_usb)) {
                refreshMode(2);
                return;
            }
            if (upperCase.startsWith(OrderSet.notice_sd)) {
                refreshMode(3);
                return;
            }
            if (upperCase.startsWith(OrderSet.notice_fm)) {
                refreshMode(4);
                return;
            }
            if (upperCase.startsWith(OrderSet.notice_bt)) {
                refreshMode(5);
                return;
            }
            if (upperCase.startsWith(OrderSet.notice_aux)) {
                refreshMode(6);
                return;
            }
            if (upperCase.startsWith(OrderSet.notice_dab)) {
                refreshMode(7);
                return;
            }
            if (upperCase.startsWith(OrderSet.notice_disc)) {
                refreshMode(8);
                return;
            }
            if (upperCase.startsWith(OrderSet.notice_spdif)) {
                refreshMode(9);
                return;
            }
            if (upperCase.startsWith(OrderSet.notice_flash)) {
                refreshMode(10);
                return;
            }
            if (upperCase.startsWith(OrderSet.notice_free)) {
                refreshMode(11);
                return;
            }
            if (upperCase.startsWith(OrderSet.notice_am)) {
                refreshMode(12);
                return;
            }
            if (upperCase.startsWith(OrderSet.notice_play)) {
                this.uiv_play_pause.getDrawable().setLevel(1);
                return;
            }
            if (upperCase.startsWith(OrderSet.notice_pause)) {
                this.uiv_play_pause.getDrawable().setLevel(0);
                return;
            }
            if (upperCase.startsWith(OrderSet.notice_volume)) {
                int intValue = Integer.valueOf(upperCase.substring(4, 6), 16).intValue();
                this.tv_volume.setText(String.valueOf(intValue));
                if (!this.mFromUser) {
                    if (!this.mBarMove) {
                        this.section_bar_volume.setProgress(intValue);
                    }
                } else if (!this.mBarMove) {
                    this.mFromUser = false;
                }
                if (upperCase.length() >= 8) {
                    this.section_bar_volume.setMax(Integer.valueOf(upperCase.substring(6, 8), 16).intValue());
                    return;
                }
                return;
            }
            if (upperCase.startsWith(OrderSet.notice_mute_off)) {
                this.mMuteOn = false;
                this.img_volumn_cut.setBackground(getResources().getDrawable(2131230947));
                this.section_bar_volume.setProgress((this.mBaseViewModel.getVolume() * this.section_bar_volume.getMax()) / this.mBaseViewModel.getMaxVolume());
                return;
            }
            if (upperCase.startsWith(OrderSet.notice_mute_on)) {
                this.mMuteOn = true;
                this.img_volumn_cut.setBackground(getResources().getDrawable(2131230948));
                return;
            }
            if (upperCase.startsWith(OrderSet.notice_dab_frequency_station)) {
                int intValue2 = Integer.valueOf(upperCase.substring(4, 10), 16).intValue();
                if (intValue2 > 0) {
                    this.tv_dab_frequency.setText((intValue2 / 1000) + "." + (intValue2 % 1000) + "Mhz");
                }
                int intValue3 = Integer.valueOf(upperCase.substring(10, 14), 16).intValue();
                if (intValue3 >= 0) {
                    this.mtv_content.setText("CH" + intValue3);
                    return;
                }
                return;
            }
            if (upperCase.startsWith(OrderSet.notice_dab_name)) {
                byte[] bArr2 = new byte[bArr.length - 2];
                System.arraycopy(bArr, 2, bArr2, 0, bArr.length - 2);
                this.mtv_dab_name.setText(new String(bArr2));
                return;
            }
            if (upperCase.startsWith(OrderSet.notice_current_music_name_unicode_stop)) {
                String str2 = this.name_unicode_hex + upperCase.substring(8);
                this.name_unicode_hex = str2;
                String notice2unicode = Convert.notice2unicode(str2);
                if (this.mTotalMusicNum.intValue() > 0) {
                    this.mtv_content.setText(this.mBaseViewModel.getMusicNumber() + "/" + this.mTotalMusicNum + " " + Convert.unicodeToString(notice2unicode));
                } else {
                    this.mtv_content.setText(this.mBaseViewModel.getMusicNumber() + "." + Convert.unicodeToString(notice2unicode));
                }
                this.name_unicode_hex = "";
                return;
            }
            if (upperCase.startsWith(OrderSet.notice_current_music_name_unicode)) {
                this.name_unicode_hex += upperCase.substring(8);
                return;
            }
            if (upperCase.startsWith(OrderSet.notice_current_music_title_unicode_stop)) {
                CharSequence musicTitle = this.mBaseViewModel.getMusicTitle();
                if (musicTitle == null || musicTitle.isEmpty()) {
                    return;
                }
                this.mtv_content.setText(musicTitle);
                return;
            }
            if (upperCase.startsWith(OrderSet.notice_current_music)) {
                this.name_unicode_hex = "";
                if (this.mTotalMusicNum.intValue() > 0) {
                    this.mtv_content.setText(Integer.valueOf(upperCase.substring(4, 8), 16) + "/" + this.mTotalMusicNum + " " + this.mBaseViewModel.getMusicTitle());
                } else {
                    this.mtv_content.setText(Integer.valueOf(upperCase.substring(4, 8), 16) + "." + this.mBaseViewModel.getMusicTitle());
                }
                if (upperCase.length() > 8) {
                    this.mShowChooseMusicBt = true;
                    Integer valueOf = Integer.valueOf(upperCase.substring(8, 12), 16);
                    this.mTotalMusicNum = valueOf;
                    if (this.isUSB && valueOf.intValue() > 0) {
                        this.uiv_usb.setVisibility(0);
                        return;
                    } else {
                        if (!this.isSDCard || this.mTotalMusicNum.intValue() <= 0) {
                            return;
                        }
                        this.uiv_sdcard.setVisibility(0);
                        return;
                    }
                }
                return;
            }
            if (upperCase.startsWith(OrderSet.notice_fm_frequency)) {
                int intValue4 = Integer.valueOf(upperCase.substring(4, 8), 16).intValue();
                if (intValue4 > 8000) {
                    this.mtv_content.setText((intValue4 / 100) + "." + String.valueOf(intValue4 % 100) + "MHz");
                    return;
                }
                if (intValue4 > 0) {
                    this.mtv_content.setText(intValue4 + "KHz");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void refreshRedPoint() {
        UpdateSp updateSp = UpdateSp.getInstance(getContext());
        if (UpdateHelper.compareVersion(updateSp.getVersionName(), updateSp.getLatestVersion()) < 0) {
            this.iv_update_notice.setVisibility(0);
        } else {
            this.iv_update_notice.setVisibility(8);
        }
    }

    public void onStop() {
        this.cd_view.stopAnimator();
        this.ll_item.setVisibility(4);
        super.onStop();
    }

    public void onStart() {
        super.onStart();
        this.cd_view.startAnimator();
        this.ll_item.setVisibility(0);
        refreshRedPoint();
    }

    public void disconnect() {
        refreshMode(0);
    }

    public void setItemVisibility() {
        if (this.mRootView != null) {
            this.ll_item.setVisibility(0);
        }
    }

    public void setMusicPlayPauseBtShow(boolean z) {
        if (this.mBaseViewModel.getMode() == 5) {
            getActivity().runOnUiThread(new 9(z));
        }
    }

    class 9 implements Runnable {
        final /* synthetic */ boolean val$isPlay;

        9(boolean z) {
            this.val$isPlay = z;
        }

        public void run() {
            MainFragment.access$2700(MainFragment.this).getDrawable().setLevel(this.val$isPlay ? 1 : 0);
        }
    }

    private void startListenMusicPlay() {
        this.mAm = (AudioManager) getActivity().getApplicationContext().getSystemService("audio");
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        this.mThreadPool = scheduledThreadPoolExecutor;
        scheduledThreadPoolExecutor.scheduleAtFixedRate(new 10(), 0L, 1L, TimeUnit.SECONDS);
    }

    class 10 implements Runnable {
        10() {
        }

        public void run() {
            if (MainFragment.access$2800(MainFragment.this) != null) {
                MainFragment mainFragment = MainFragment.this;
                mainFragment.isBtMusicPlay = MainFragment.access$2800(mainFragment).isMusicActive();
                MainFragment mainFragment2 = MainFragment.this;
                mainFragment2.setMusicPlayPauseBtShow(mainFragment2.isBtMusicPlay);
            }
        }
    }
}
