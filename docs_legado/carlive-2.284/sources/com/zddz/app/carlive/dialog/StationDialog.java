package com.zddz.app.carlive.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zddz.app.carlive.OrderSet;
import com.zddz.app.carlive.database.FmBandStationRecord;
import com.zddz.app.carlive.fragment.BaseDialog;
import com.zddz.app.carlive.fragment.IMain;
import com.zddz.bt.Convert;
import java.util.UUID;
import org.litepal.LitePal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class StationDialog extends BaseDialog {
    private View.OnClickListener mOnClickListener = new 1();
    private View.OnLongClickListener mOnLongClickListener = new 2();
    private TextView tv_dialog_station_band;
    private TextView tv_fm_msg;
    private TextView tv_station1;
    private TextView tv_station2;
    private TextView tv_station3;
    private TextView tv_station4;
    private TextView tv_station5;
    private TextView tv_station6;
    private View view_empty;

    static /* synthetic */ IMain access$000(StationDialog stationDialog) {
        return stationDialog.mIMain;
    }

    static /* synthetic */ IMain access$100(StationDialog stationDialog) {
        return stationDialog.mIMain;
    }

    static /* synthetic */ IMain access$1000(StationDialog stationDialog) {
        return stationDialog.mIMain;
    }

    static /* synthetic */ IMain access$1100(StationDialog stationDialog) {
        return stationDialog.mIMain;
    }

    static /* synthetic */ IMain access$1200(StationDialog stationDialog) {
        return stationDialog.mIMain;
    }

    static /* synthetic */ IMain access$1300(StationDialog stationDialog) {
        return stationDialog.mIMain;
    }

    static /* synthetic */ IMain access$1400(StationDialog stationDialog) {
        return stationDialog.mIMain;
    }

    static /* synthetic */ IMain access$200(StationDialog stationDialog) {
        return stationDialog.mIMain;
    }

    static /* synthetic */ IMain access$300(StationDialog stationDialog) {
        return stationDialog.mIMain;
    }

    static /* synthetic */ IMain access$400(StationDialog stationDialog) {
        return stationDialog.mIMain;
    }

    static /* synthetic */ IMain access$500(StationDialog stationDialog) {
        return stationDialog.mIMain;
    }

    static /* synthetic */ IMain access$600(StationDialog stationDialog) {
        return stationDialog.mIMain;
    }

    static /* synthetic */ IMain access$700(StationDialog stationDialog) {
        return stationDialog.mIMain;
    }

    static /* synthetic */ IMain access$800(StationDialog stationDialog) {
        return stationDialog.mIMain;
    }

    static /* synthetic */ IMain access$900(StationDialog stationDialog) {
        return stationDialog.mIMain;
    }

    class 1 implements View.OnClickListener {
        1() {
        }

        public void onClick(View view) {
            int id = view.getId();
            if (id == 2131296736) {
                StationDialog.access$000(StationDialog.this).writeData(OrderSet.write_fm_station1);
                return;
            }
            if (id == 2131296737) {
                StationDialog.access$100(StationDialog.this).writeData(OrderSet.write_fm_station2);
                return;
            }
            if (id == 2131296738) {
                StationDialog.access$200(StationDialog.this).writeData(OrderSet.write_fm_station3);
                return;
            }
            if (id == 2131296739) {
                StationDialog.access$300(StationDialog.this).writeData(OrderSet.write_fm_station4);
                return;
            }
            if (id == 2131296740) {
                StationDialog.access$400(StationDialog.this).writeData(OrderSet.write_fm_station5);
                return;
            }
            if (id == 2131296741) {
                StationDialog.access$500(StationDialog.this).writeData(OrderSet.write_fm_station6);
            } else if (id == 2131297112) {
                StationDialog.this.dismiss();
            } else if (id == 2131296932) {
                StationDialog.access$600(StationDialog.this).writeData(OrderSet.write_band);
            }
        }
    }

    class 2 implements View.OnLongClickListener {
        2() {
        }

        public boolean onLongClick(View view) {
            int id = view.getId();
            if (id == 2131296736) {
                StationDialog.access$700(StationDialog.this).writeData(OrderSet.write_save_fm_station1);
                return true;
            }
            if (id == 2131296737) {
                StationDialog.access$800(StationDialog.this).writeData(OrderSet.write_save_fm_station2);
                return true;
            }
            if (id == 2131296738) {
                StationDialog.access$900(StationDialog.this).writeData(OrderSet.write_save_fm_station3);
                return true;
            }
            if (id == 2131296739) {
                StationDialog.access$1000(StationDialog.this).writeData(OrderSet.write_save_fm_station4);
                return true;
            }
            if (id == 2131296740) {
                StationDialog.access$1100(StationDialog.this).writeData(OrderSet.write_save_fm_station5);
                return true;
            }
            if (id == 2131296741) {
                StationDialog.access$1200(StationDialog.this).writeData(OrderSet.write_save_fm_station6);
                return true;
            }
            if (id != 2131296932) {
                return true;
            }
            StationDialog.access$1300(StationDialog.this).writeData(OrderSet.write_ams);
            return true;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(2131492929, viewGroup, false);
        return this.mRootView;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        new Handler().postDelayed(new 3(), 110L);
        this.tv_station1 = this.mRootView.findViewById(2131297035);
        this.tv_fm_msg = this.mRootView.findViewById(2131296970);
        TextView findViewById = this.mRootView.findViewById(2131296932);
        this.tv_dialog_station_band = findViewById;
        findViewById.setOnClickListener(this.mOnClickListener);
        View findViewById2 = this.mRootView.findViewById(2131297112);
        this.view_empty = findViewById2;
        findViewById2.setOnClickListener(this.mOnClickListener);
        RelativeLayout findViewById3 = this.mRootView.findViewById(2131296736);
        findViewById3.setOnClickListener(this.mOnClickListener);
        findViewById3.setOnLongClickListener(this.mOnLongClickListener);
        this.tv_station2 = this.mRootView.findViewById(2131297036);
        RelativeLayout findViewById4 = this.mRootView.findViewById(2131296737);
        findViewById4.setOnClickListener(this.mOnClickListener);
        findViewById4.setOnLongClickListener(this.mOnLongClickListener);
        this.tv_station3 = this.mRootView.findViewById(2131297037);
        RelativeLayout findViewById5 = this.mRootView.findViewById(2131296738);
        findViewById5.setOnClickListener(this.mOnClickListener);
        findViewById5.setOnLongClickListener(this.mOnLongClickListener);
        this.tv_station4 = this.mRootView.findViewById(2131297038);
        RelativeLayout findViewById6 = this.mRootView.findViewById(2131296739);
        findViewById6.setOnClickListener(this.mOnClickListener);
        findViewById6.setOnLongClickListener(this.mOnLongClickListener);
        this.tv_station5 = this.mRootView.findViewById(2131297039);
        RelativeLayout findViewById7 = this.mRootView.findViewById(2131296740);
        findViewById7.setOnClickListener(this.mOnClickListener);
        findViewById7.setOnLongClickListener(this.mOnLongClickListener);
        this.tv_station6 = this.mRootView.findViewById(2131297040);
        RelativeLayout findViewById8 = this.mRootView.findViewById(2131296741);
        findViewById8.setOnClickListener(this.mOnClickListener);
        findViewById8.setOnLongClickListener(this.mOnLongClickListener);
        if (this.mBaseViewModel.getMode() != 4) {
            dismiss();
        }
        initFmBand();
    }

    class 3 implements Runnable {
        3() {
        }

        public void run() {
            StationDialog.access$1400(StationDialog.this).writeData(OrderSet.write_synchronize);
        }
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
                window.setLayout(-1, -1);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.0f;
                attributes.gravity = 80;
                window.setAttributes(attributes);
            }
        }
        setCancelable(false);
    }

    private void initFmBand() {
        FmBandStationRecord fmBandStationRecord = (FmBandStationRecord) LitePal.where("band =? and number=?", "1", "0").findFirst(FmBandStationRecord.class);
        if (fmBandStationRecord == null) {
            this.tv_station1.setText("87.5");
        } else {
            this.tv_station1.setText(fmBandStationRecord.station);
        }
        FmBandStationRecord fmBandStationRecord2 = (FmBandStationRecord) LitePal.where("band =? and number=?", "1", "1").findFirst(FmBandStationRecord.class);
        if (fmBandStationRecord2 == null) {
            this.tv_station2.setText("87.5");
        } else {
            this.tv_station2.setText(fmBandStationRecord2.station);
        }
        FmBandStationRecord fmBandStationRecord3 = (FmBandStationRecord) LitePal.where("band =? and number=?", "1", "2").findFirst(FmBandStationRecord.class);
        if (fmBandStationRecord3 == null) {
            this.tv_station3.setText("87.5");
        } else {
            this.tv_station3.setText(fmBandStationRecord3.station);
        }
        FmBandStationRecord fmBandStationRecord4 = (FmBandStationRecord) LitePal.where("band =? and number=?", "1", "3").findFirst(FmBandStationRecord.class);
        if (fmBandStationRecord4 == null) {
            this.tv_station4.setText("87.5");
        } else {
            this.tv_station4.setText(fmBandStationRecord4.station);
        }
        FmBandStationRecord fmBandStationRecord5 = (FmBandStationRecord) LitePal.where("band =? and number=?", "1", "4").findFirst(FmBandStationRecord.class);
        if (fmBandStationRecord5 == null) {
            this.tv_station5.setText("87.5");
        } else {
            this.tv_station5.setText(fmBandStationRecord5.station);
        }
        FmBandStationRecord fmBandStationRecord6 = (FmBandStationRecord) LitePal.where("band =? and number=?", "1", "5").findFirst(FmBandStationRecord.class);
        if (fmBandStationRecord6 == null) {
            this.tv_station6.setText("87.5");
        } else {
            this.tv_station6.setText(fmBandStationRecord6.station);
        }
    }

    public void notice(String str, UUID uuid, byte[] bArr) {
        String concat;
        try {
            String upperCase = Convert.bytesToHexString(bArr).toUpperCase();
            if (!upperCase.startsWith(OrderSet.notice_power_off) && !upperCase.startsWith(OrderSet.notice_mode) && !upperCase.startsWith(OrderSet.notice_usb) && !upperCase.startsWith(OrderSet.notice_sd) && !upperCase.startsWith(OrderSet.notice_bt) && !upperCase.startsWith(OrderSet.notice_aux) && !upperCase.startsWith(OrderSet.notice_dab) && !upperCase.startsWith(OrderSet.notice_disc) && !upperCase.startsWith(OrderSet.notice_spdif) && !upperCase.startsWith(OrderSet.notice_flash) && !upperCase.startsWith(OrderSet.notice_free) && !upperCase.startsWith(OrderSet.notice_am)) {
                if (!upperCase.startsWith(OrderSet.notice_version_eq_default) && !upperCase.startsWith(OrderSet.notice_version_eq_dsp) && !upperCase.startsWith(OrderSet.notice_version_eq_aoveise) && !upperCase.startsWith(OrderSet.notice_version_eq_six_channel)) {
                    if (upperCase.startsWith(OrderSet.notice_fm_band_station_array)) {
                        int parseInt = Integer.parseInt(upperCase.substring(5, 6), 16);
                        if (parseInt < 4) {
                            concat = "FM" + parseInt;
                        } else {
                            concat = "AM".concat(parseInt == 4 ? "1" : "2");
                        }
                        this.tv_fm_msg.setText(concat);
                        if (concat.contains("FM")) {
                            this.tv_station1.setText(String.format("%.2f", new Object[]{Float.valueOf(Integer.parseInt(upperCase.substring(8, 10) + upperCase.substring(6, 8), 16) / 100.0f)}));
                            this.tv_station2.setText(String.format("%.2f", new Object[]{Float.valueOf(Integer.parseInt(upperCase.substring(12, 14) + upperCase.substring(10, 12), 16) / 100.0f)}));
                            this.tv_station3.setText(String.format("%.2f", new Object[]{Float.valueOf(Integer.parseInt(upperCase.substring(16, 18) + upperCase.substring(14, 16), 16) / 100.0f)}));
                            this.tv_station4.setText(String.format("%.2f", new Object[]{Float.valueOf(Integer.parseInt(upperCase.substring(20, 22) + upperCase.substring(18, 20), 16) / 100.0f)}));
                            this.tv_station5.setText(String.format("%.2f", new Object[]{Float.valueOf(Integer.parseInt(upperCase.substring(24, 26) + upperCase.substring(22, 24), 16) / 100.0f)}));
                            this.tv_station6.setText(String.format("%.2f", new Object[]{Float.valueOf(Integer.parseInt(upperCase.substring(28, 30) + upperCase.substring(26, 28), 16) / 100.0f)}));
                            return;
                        }
                        TextView textView = this.tv_station1;
                        StringBuilder sb = new StringBuilder("");
                        sb.append(Integer.parseInt(upperCase.substring(8, 10) + upperCase.substring(6, 8), 16));
                        textView.setText(sb.toString());
                        TextView textView2 = this.tv_station2;
                        StringBuilder sb2 = new StringBuilder("");
                        sb2.append(Integer.parseInt(upperCase.substring(12, 14) + upperCase.substring(10, 12), 16));
                        textView2.setText(sb2.toString());
                        TextView textView3 = this.tv_station3;
                        StringBuilder sb3 = new StringBuilder("");
                        sb3.append(Integer.parseInt(upperCase.substring(16, 18) + upperCase.substring(14, 16), 16));
                        textView3.setText(sb3.toString());
                        TextView textView4 = this.tv_station4;
                        StringBuilder sb4 = new StringBuilder("");
                        sb4.append(Integer.parseInt(upperCase.substring(20, 22) + upperCase.substring(18, 20), 16));
                        textView4.setText(sb4.toString());
                        TextView textView5 = this.tv_station5;
                        StringBuilder sb5 = new StringBuilder("");
                        sb5.append(Integer.parseInt(upperCase.substring(24, 26) + upperCase.substring(22, 24), 16));
                        textView5.setText(sb5.toString());
                        TextView textView6 = this.tv_station6;
                        StringBuilder sb6 = new StringBuilder("");
                        sb6.append(Integer.parseInt(upperCase.substring(28, 30) + upperCase.substring(26, 28), 16));
                        textView6.setText(sb6.toString());
                        return;
                    }
                    return;
                }
                dismiss();
                return;
            }
            dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
