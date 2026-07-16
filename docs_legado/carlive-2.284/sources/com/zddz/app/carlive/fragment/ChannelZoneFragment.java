package com.zddz.app.carlive.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zddz.app.carlive.OrderSet;
import com.zddz.app.carlive.database.ChannelRecord;
import com.zddz.app.carlive.dialog.ChannelPassDialog;
import com.zddz.bt.Convert;
import com.zddz.ui.DisplayUtil;
import com.zddz.widget.UIImageView;
import java.util.List;
import java.util.UUID;
import org.litepal.LitePal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class ChannelZoneFragment extends BaseFragment {
    private TextView bt_set_up_adc_l;
    private TextView bt_set_up_adc_r;
    private TextView bt_set_up_d1;
    private TextView bt_set_up_d1_l;
    private TextView bt_set_up_d1_r;
    private TextView bt_set_up_d2_l;
    private TextView bt_set_up_d2_r;
    private ImageView iv_car;
    private RelativeLayout rl_adc_l;
    private RelativeLayout rl_adc_r;
    private RelativeLayout rl_d1;
    private RelativeLayout rl_d1_l;
    private RelativeLayout rl_d1_r;
    private RelativeLayout rl_d2_l;
    private RelativeLayout rl_d2_r;
    private TextView tv_gain_adc_l;
    private TextView tv_gain_adc_r;
    private TextView tv_gain_d1;
    private TextView tv_gain_d1_l;
    private TextView tv_gain_d1_r;
    private TextView tv_gain_d2_l;
    private TextView tv_gain_d2_r;
    private TextView tv_phase_adc_l;
    private TextView tv_phase_adc_r;
    private TextView tv_phase_d1;
    private TextView tv_phase_d1_l;
    private TextView tv_phase_d1_r;
    private TextView tv_phase_d2_l;
    private TextView tv_phase_d2_r;
    private UIImageView uiv_add_adc_l;
    private UIImageView uiv_add_adc_r;
    private UIImageView uiv_add_d1;
    private UIImageView uiv_add_d1_l;
    private UIImageView uiv_add_d1_r;
    private UIImageView uiv_add_d2_l;
    private UIImageView uiv_add_d2_r;
    private UIImageView uiv_sub_adc_l;
    private UIImageView uiv_sub_adc_r;
    private UIImageView uiv_sub_d1;
    private UIImageView uiv_sub_d1_l;
    private UIImageView uiv_sub_d1_r;
    private UIImageView uiv_sub_d2_l;
    private UIImageView uiv_sub_d2_r;
    private int mGainOutStart = -32;
    private int mGainOutMax = 32;
    private final View.OnClickListener mOnClickListener = new 1();
    private Handler mHandler = new Handler();
    private View mHoldView = null;
    private final Runnable mHoldRunnable = new 2();
    private final View.OnLongClickListener mOnLongClickListener = new 3();
    private final View.OnTouchListener mOnTouchListener = new 4();
    boolean canEditGain = true;

    static /* synthetic */ int access$000(ChannelZoneFragment channelZoneFragment) {
        return channelZoneFragment.mGainOutMax;
    }

    static /* synthetic */ View access$100(ChannelZoneFragment channelZoneFragment) {
        return channelZoneFragment.mHoldView;
    }

    static /* synthetic */ UIImageView access$1000(ChannelZoneFragment channelZoneFragment) {
        return channelZoneFragment.uiv_add_d1_r;
    }

    static /* synthetic */ View access$102(ChannelZoneFragment channelZoneFragment, View view) {
        channelZoneFragment.mHoldView = view;
        return view;
    }

    static /* synthetic */ UIImageView access$1100(ChannelZoneFragment channelZoneFragment) {
        return channelZoneFragment.uiv_sub_d1_r;
    }

    static /* synthetic */ UIImageView access$1200(ChannelZoneFragment channelZoneFragment) {
        return channelZoneFragment.uiv_add_d1;
    }

    static /* synthetic */ UIImageView access$1300(ChannelZoneFragment channelZoneFragment) {
        return channelZoneFragment.uiv_sub_d1;
    }

    static /* synthetic */ UIImageView access$1400(ChannelZoneFragment channelZoneFragment) {
        return channelZoneFragment.uiv_add_d2_l;
    }

    static /* synthetic */ UIImageView access$1500(ChannelZoneFragment channelZoneFragment) {
        return channelZoneFragment.uiv_sub_d2_l;
    }

    static /* synthetic */ UIImageView access$1600(ChannelZoneFragment channelZoneFragment) {
        return channelZoneFragment.uiv_add_d2_r;
    }

    static /* synthetic */ UIImageView access$1700(ChannelZoneFragment channelZoneFragment) {
        return channelZoneFragment.uiv_sub_d2_r;
    }

    static /* synthetic */ ImageView access$1800(ChannelZoneFragment channelZoneFragment) {
        return channelZoneFragment.iv_car;
    }

    static /* synthetic */ RelativeLayout access$1900(ChannelZoneFragment channelZoneFragment) {
        return channelZoneFragment.rl_adc_l;
    }

    static /* synthetic */ Handler access$200(ChannelZoneFragment channelZoneFragment) {
        return channelZoneFragment.mHandler;
    }

    static /* synthetic */ RelativeLayout access$2000(ChannelZoneFragment channelZoneFragment) {
        return channelZoneFragment.rl_adc_r;
    }

    static /* synthetic */ RelativeLayout access$2100(ChannelZoneFragment channelZoneFragment) {
        return channelZoneFragment.rl_d2_l;
    }

    static /* synthetic */ RelativeLayout access$2200(ChannelZoneFragment channelZoneFragment) {
        return channelZoneFragment.rl_d2_r;
    }

    static /* synthetic */ UIImageView access$300(ChannelZoneFragment channelZoneFragment) {
        return channelZoneFragment.uiv_add_adc_l;
    }

    static /* synthetic */ Runnable access$400(ChannelZoneFragment channelZoneFragment) {
        return channelZoneFragment.mHoldRunnable;
    }

    static /* synthetic */ UIImageView access$500(ChannelZoneFragment channelZoneFragment) {
        return channelZoneFragment.uiv_sub_adc_l;
    }

    static /* synthetic */ UIImageView access$600(ChannelZoneFragment channelZoneFragment) {
        return channelZoneFragment.uiv_add_adc_r;
    }

    static /* synthetic */ UIImageView access$700(ChannelZoneFragment channelZoneFragment) {
        return channelZoneFragment.uiv_sub_adc_r;
    }

    static /* synthetic */ UIImageView access$800(ChannelZoneFragment channelZoneFragment) {
        return channelZoneFragment.uiv_add_d1_l;
    }

    static /* synthetic */ UIImageView access$900(ChannelZoneFragment channelZoneFragment) {
        return channelZoneFragment.uiv_sub_d1_l;
    }

    class 1 implements View.OnClickListener {
        1() {
        }

        public void onClick(View view) {
            ChannelRecord channelRecord;
            int id = view.getId();
            if (id == 2131296366) {
                ChannelPassDialog channelPassDialog = new ChannelPassDialog();
                channelPassDialog.setCanEditGain(ChannelZoneFragment.this.canEditGain);
                Bundle bundle = new Bundle();
                bundle.putSerializable("CurrentChannel", "1");
                channelPassDialog.setArguments(bundle);
                channelPassDialog.show(ChannelZoneFragment.this.getChildFragmentManager(), "ChannelPassDialog");
                return;
            }
            if (id == 2131297067) {
                ChannelRecord channelRecord2 = (ChannelRecord) LitePal.where("number = 1").findFirst(ChannelRecord.class);
                if (channelRecord2 == null || channelRecord2.gain >= ChannelZoneFragment.access$000(ChannelZoneFragment.this)) {
                    return;
                }
                byte[] bArr = OrderSet.write_channel_phase_gain;
                bArr[2] = 1;
                bArr[3] = (byte) channelRecord2.phase;
                bArr[4] = (byte) (channelRecord2.gain + 1);
                ChannelZoneFragment.this.mIMain.writeData(bArr);
                return;
            }
            if (id == 2131297089) {
                ChannelRecord channelRecord3 = (ChannelRecord) LitePal.where("number = 1").findFirst(ChannelRecord.class);
                if (channelRecord3 == null || channelRecord3.gain <= 0) {
                    return;
                }
                byte[] bArr2 = OrderSet.write_channel_phase_gain;
                bArr2[2] = 1;
                bArr2[3] = (byte) channelRecord3.phase;
                bArr2[4] = (byte) (channelRecord3.gain - 1);
                ChannelZoneFragment.this.mIMain.writeData(bArr2);
                return;
            }
            if (id == 2131296367) {
                ChannelPassDialog channelPassDialog2 = new ChannelPassDialog();
                channelPassDialog2.setCanEditGain(ChannelZoneFragment.this.canEditGain);
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("CurrentChannel", "2");
                channelPassDialog2.setArguments(bundle2);
                channelPassDialog2.show(ChannelZoneFragment.this.getChildFragmentManager(), "ChannelPassDialog");
                return;
            }
            if (id == 2131297068) {
                ChannelRecord channelRecord4 = (ChannelRecord) LitePal.where("number = 2").findFirst(ChannelRecord.class);
                if (channelRecord4 == null || channelRecord4.gain >= ChannelZoneFragment.access$000(ChannelZoneFragment.this)) {
                    return;
                }
                byte[] bArr3 = OrderSet.write_channel_phase_gain;
                bArr3[2] = 2;
                bArr3[3] = (byte) channelRecord4.phase;
                bArr3[4] = (byte) (channelRecord4.gain + 1);
                ChannelZoneFragment.this.mIMain.writeData(bArr3);
                return;
            }
            if (id == 2131297090) {
                ChannelRecord channelRecord5 = (ChannelRecord) LitePal.where("number = 2").findFirst(ChannelRecord.class);
                if (channelRecord5 == null || channelRecord5.gain <= 0) {
                    return;
                }
                byte[] bArr4 = OrderSet.write_channel_phase_gain;
                bArr4[2] = 2;
                bArr4[3] = (byte) channelRecord5.phase;
                bArr4[4] = (byte) (channelRecord5.gain - 1);
                ChannelZoneFragment.this.mIMain.writeData(bArr4);
                return;
            }
            if (id == 2131296369) {
                ChannelPassDialog channelPassDialog3 = new ChannelPassDialog();
                channelPassDialog3.setCanEditGain(ChannelZoneFragment.this.canEditGain);
                Bundle bundle3 = new Bundle();
                bundle3.putSerializable("CurrentChannel", "3");
                channelPassDialog3.setArguments(bundle3);
                channelPassDialog3.show(ChannelZoneFragment.this.getChildFragmentManager(), "ChannelPassDialog");
                return;
            }
            if (id == 2131297070) {
                ChannelRecord channelRecord6 = (ChannelRecord) LitePal.where("number = 3").findFirst(ChannelRecord.class);
                if (channelRecord6 == null || channelRecord6.gain >= ChannelZoneFragment.access$000(ChannelZoneFragment.this)) {
                    return;
                }
                byte[] bArr5 = OrderSet.write_channel_phase_gain;
                bArr5[2] = 3;
                bArr5[3] = (byte) channelRecord6.phase;
                bArr5[4] = (byte) (channelRecord6.gain + 1);
                ChannelZoneFragment.this.mIMain.writeData(bArr5);
                return;
            }
            if (id == 2131297092) {
                ChannelRecord channelRecord7 = (ChannelRecord) LitePal.where("number = 2").findFirst(ChannelRecord.class);
                if (channelRecord7 == null || channelRecord7.gain <= 0) {
                    return;
                }
                byte[] bArr6 = OrderSet.write_channel_phase_gain;
                bArr6[2] = 3;
                bArr6[3] = (byte) channelRecord7.phase;
                bArr6[4] = (byte) (channelRecord7.gain - 1);
                ChannelZoneFragment.this.mIMain.writeData(bArr6);
                return;
            }
            if (id == 2131296370 || id == 2131296368) {
                ChannelPassDialog channelPassDialog4 = new ChannelPassDialog();
                channelPassDialog4.setCanEditGain(ChannelZoneFragment.this.canEditGain);
                Bundle bundle4 = new Bundle();
                bundle4.putSerializable("CurrentChannel", "4");
                channelPassDialog4.setArguments(bundle4);
                channelPassDialog4.show(ChannelZoneFragment.this.getChildFragmentManager(), "ChannelPassDialog");
                return;
            }
            if (id == 2131297071 || id == 2131297069) {
                ChannelRecord channelRecord8 = (ChannelRecord) LitePal.where("number = 4").findFirst(ChannelRecord.class);
                if (channelRecord8 == null || channelRecord8.gain >= ChannelZoneFragment.access$000(ChannelZoneFragment.this)) {
                    return;
                }
                byte[] bArr7 = OrderSet.write_channel_phase_gain;
                bArr7[2] = 4;
                bArr7[3] = (byte) channelRecord8.phase;
                bArr7[4] = (byte) (channelRecord8.gain + 1);
                ChannelZoneFragment.this.mIMain.writeData(bArr7);
                return;
            }
            if (id == 2131297093 || id == 2131297091) {
                ChannelRecord channelRecord9 = (ChannelRecord) LitePal.where("number = 4").findFirst(ChannelRecord.class);
                if (channelRecord9 == null || channelRecord9.gain <= 0) {
                    return;
                }
                byte[] bArr8 = OrderSet.write_channel_phase_gain;
                bArr8[2] = 4;
                bArr8[3] = (byte) channelRecord9.phase;
                bArr8[4] = (byte) (channelRecord9.gain - 1);
                ChannelZoneFragment.this.mIMain.writeData(bArr8);
                return;
            }
            if (id == 2131296371) {
                ChannelPassDialog channelPassDialog5 = new ChannelPassDialog();
                channelPassDialog5.setCanEditGain(ChannelZoneFragment.this.canEditGain);
                Bundle bundle5 = new Bundle();
                bundle5.putSerializable("CurrentChannel", "5");
                channelPassDialog5.setArguments(bundle5);
                channelPassDialog5.show(ChannelZoneFragment.this.getChildFragmentManager(), "ChannelPassDialog");
                return;
            }
            if (id == 2131297072) {
                ChannelRecord channelRecord10 = (ChannelRecord) LitePal.where("number = 5").findFirst(ChannelRecord.class);
                if (channelRecord10 == null || channelRecord10.gain >= ChannelZoneFragment.access$000(ChannelZoneFragment.this)) {
                    return;
                }
                byte[] bArr9 = OrderSet.write_channel_phase_gain;
                bArr9[2] = 5;
                bArr9[3] = (byte) channelRecord10.phase;
                bArr9[4] = (byte) (channelRecord10.gain + 1);
                ChannelZoneFragment.this.mIMain.writeData(bArr9);
                return;
            }
            if (id == 2131297094) {
                ChannelRecord channelRecord11 = (ChannelRecord) LitePal.where("number = 5").findFirst(ChannelRecord.class);
                if (channelRecord11 == null || channelRecord11.gain <= 0) {
                    return;
                }
                byte[] bArr10 = OrderSet.write_channel_phase_gain;
                bArr10[2] = 5;
                bArr10[3] = (byte) channelRecord11.phase;
                bArr10[4] = (byte) (channelRecord11.gain - 1);
                ChannelZoneFragment.this.mIMain.writeData(bArr10);
                return;
            }
            if (id == 2131296372) {
                ChannelPassDialog channelPassDialog6 = new ChannelPassDialog();
                channelPassDialog6.setCanEditGain(ChannelZoneFragment.this.canEditGain);
                Bundle bundle6 = new Bundle();
                bundle6.putSerializable("CurrentChannel", "6");
                channelPassDialog6.setArguments(bundle6);
                channelPassDialog6.show(ChannelZoneFragment.this.getChildFragmentManager(), "ChannelPassDialog");
                return;
            }
            if (id == 2131297073) {
                ChannelRecord channelRecord12 = (ChannelRecord) LitePal.where("number = 6").findFirst(ChannelRecord.class);
                if (channelRecord12 == null || channelRecord12.gain >= ChannelZoneFragment.access$000(ChannelZoneFragment.this)) {
                    return;
                }
                byte[] bArr11 = OrderSet.write_channel_phase_gain;
                bArr11[2] = 6;
                bArr11[3] = (byte) channelRecord12.phase;
                bArr11[4] = (byte) (channelRecord12.gain + 1);
                ChannelZoneFragment.this.mIMain.writeData(bArr11);
                return;
            }
            if (id != 2131297095 || (channelRecord = (ChannelRecord) LitePal.where("number = 6").findFirst(ChannelRecord.class)) == null || channelRecord.gain <= 0) {
                return;
            }
            byte[] bArr12 = OrderSet.write_channel_phase_gain;
            bArr12[2] = 6;
            bArr12[3] = (byte) channelRecord.phase;
            bArr12[4] = (byte) (channelRecord.gain - 1);
            ChannelZoneFragment.this.mIMain.writeData(bArr12);
        }
    }

    class 2 implements Runnable {
        2() {
        }

        public void run() {
            ChannelRecord channelRecord;
            if (ChannelZoneFragment.access$100(ChannelZoneFragment.this) != null) {
                int id = ChannelZoneFragment.access$100(ChannelZoneFragment.this).getId();
                if (id == 2131297067) {
                    ChannelRecord channelRecord2 = (ChannelRecord) LitePal.where("number = 1").findFirst(ChannelRecord.class);
                    if (channelRecord2 != null && channelRecord2.gain < ChannelZoneFragment.access$000(ChannelZoneFragment.this)) {
                        byte[] bArr = OrderSet.write_channel_phase_gain;
                        bArr[2] = 1;
                        bArr[3] = (byte) channelRecord2.phase;
                        bArr[4] = (byte) (channelRecord2.gain + 1);
                        ChannelZoneFragment.this.mIMain.writeData(bArr);
                    }
                } else if (id == 2131297089) {
                    ChannelRecord channelRecord3 = (ChannelRecord) LitePal.where("number = 1").findFirst(ChannelRecord.class);
                    if (channelRecord3 != null && channelRecord3.gain > 0) {
                        byte[] bArr2 = OrderSet.write_channel_phase_gain;
                        bArr2[2] = 1;
                        bArr2[3] = (byte) channelRecord3.phase;
                        bArr2[4] = (byte) (channelRecord3.gain - 1);
                        ChannelZoneFragment.this.mIMain.writeData(bArr2);
                    }
                } else if (id == 2131297068) {
                    ChannelRecord channelRecord4 = (ChannelRecord) LitePal.where("number = 2").findFirst(ChannelRecord.class);
                    if (channelRecord4 != null && channelRecord4.gain < ChannelZoneFragment.access$000(ChannelZoneFragment.this)) {
                        byte[] bArr3 = OrderSet.write_channel_phase_gain;
                        bArr3[2] = 2;
                        bArr3[3] = (byte) channelRecord4.phase;
                        bArr3[4] = (byte) (channelRecord4.gain + 1);
                        ChannelZoneFragment.this.mIMain.writeData(bArr3);
                    }
                } else if (id == 2131297090) {
                    ChannelRecord channelRecord5 = (ChannelRecord) LitePal.where("number = 2").findFirst(ChannelRecord.class);
                    if (channelRecord5 != null && channelRecord5.gain > 0) {
                        byte[] bArr4 = OrderSet.write_channel_phase_gain;
                        bArr4[2] = 2;
                        bArr4[3] = (byte) channelRecord5.phase;
                        bArr4[4] = (byte) (channelRecord5.gain - 1);
                        ChannelZoneFragment.this.mIMain.writeData(bArr4);
                    }
                } else if (id == 2131297070) {
                    ChannelRecord channelRecord6 = (ChannelRecord) LitePal.where("number = 3").findFirst(ChannelRecord.class);
                    if (channelRecord6 != null && channelRecord6.gain < ChannelZoneFragment.access$000(ChannelZoneFragment.this)) {
                        byte[] bArr5 = OrderSet.write_channel_phase_gain;
                        bArr5[2] = 3;
                        bArr5[3] = (byte) channelRecord6.phase;
                        bArr5[4] = (byte) (channelRecord6.gain + 1);
                        ChannelZoneFragment.this.mIMain.writeData(bArr5);
                    }
                } else if (id == 2131297092) {
                    ChannelRecord channelRecord7 = (ChannelRecord) LitePal.where("number = 3").findFirst(ChannelRecord.class);
                    if (channelRecord7 != null && channelRecord7.gain > 0) {
                        byte[] bArr6 = OrderSet.write_channel_phase_gain;
                        bArr6[2] = 3;
                        bArr6[3] = (byte) channelRecord7.phase;
                        bArr6[4] = (byte) (channelRecord7.gain - 1);
                        ChannelZoneFragment.this.mIMain.writeData(bArr6);
                    }
                } else if (id == 2131297071 || id == 2131297069) {
                    ChannelRecord channelRecord8 = (ChannelRecord) LitePal.where("number = 4").findFirst(ChannelRecord.class);
                    if (channelRecord8 != null && channelRecord8.gain < ChannelZoneFragment.access$000(ChannelZoneFragment.this)) {
                        byte[] bArr7 = OrderSet.write_channel_phase_gain;
                        bArr7[2] = 4;
                        bArr7[3] = (byte) channelRecord8.phase;
                        bArr7[4] = (byte) (channelRecord8.gain + 1);
                        ChannelZoneFragment.this.mIMain.writeData(bArr7);
                    }
                } else if (id == 2131297093 || id == 2131297091) {
                    ChannelRecord channelRecord9 = (ChannelRecord) LitePal.where("number = 4").findFirst(ChannelRecord.class);
                    if (channelRecord9 != null && channelRecord9.gain > 0) {
                        byte[] bArr8 = OrderSet.write_channel_phase_gain;
                        bArr8[2] = 4;
                        bArr8[3] = (byte) channelRecord9.phase;
                        bArr8[4] = (byte) (channelRecord9.gain - 1);
                        ChannelZoneFragment.this.mIMain.writeData(bArr8);
                    }
                } else if (id == 2131297072) {
                    ChannelRecord channelRecord10 = (ChannelRecord) LitePal.where("number = 5").findFirst(ChannelRecord.class);
                    if (channelRecord10 != null && channelRecord10.gain < ChannelZoneFragment.access$000(ChannelZoneFragment.this)) {
                        byte[] bArr9 = OrderSet.write_channel_phase_gain;
                        bArr9[2] = 5;
                        bArr9[3] = (byte) channelRecord10.phase;
                        bArr9[4] = (byte) (channelRecord10.gain + 1);
                        ChannelZoneFragment.this.mIMain.writeData(bArr9);
                    }
                } else if (id == 2131297094) {
                    ChannelRecord channelRecord11 = (ChannelRecord) LitePal.where("number = 5").findFirst(ChannelRecord.class);
                    if (channelRecord11 != null && channelRecord11.gain > 0) {
                        byte[] bArr10 = OrderSet.write_channel_phase_gain;
                        bArr10[2] = 5;
                        bArr10[3] = (byte) channelRecord11.phase;
                        bArr10[4] = (byte) (channelRecord11.gain - 1);
                        ChannelZoneFragment.this.mIMain.writeData(bArr10);
                    }
                } else if (id == 2131297073) {
                    ChannelRecord channelRecord12 = (ChannelRecord) LitePal.where("number = 6").findFirst(ChannelRecord.class);
                    if (channelRecord12 != null && channelRecord12.gain < ChannelZoneFragment.access$000(ChannelZoneFragment.this)) {
                        byte[] bArr11 = OrderSet.write_channel_phase_gain;
                        bArr11[2] = 6;
                        bArr11[3] = (byte) channelRecord12.phase;
                        bArr11[4] = (byte) (channelRecord12.gain + 1);
                        ChannelZoneFragment.this.mIMain.writeData(bArr11);
                    }
                } else if (id == 2131297095 && (channelRecord = (ChannelRecord) LitePal.where("number = 6").findFirst(ChannelRecord.class)) != null && channelRecord.gain > 0) {
                    byte[] bArr12 = OrderSet.write_channel_phase_gain;
                    bArr12[2] = 6;
                    bArr12[3] = (byte) channelRecord.phase;
                    bArr12[4] = (byte) (channelRecord.gain - 1);
                    ChannelZoneFragment.this.mIMain.writeData(bArr12);
                }
                ChannelZoneFragment.access$200(ChannelZoneFragment.this).postDelayed(this, 200L);
            }
        }
    }

    class 3 implements View.OnLongClickListener {
        3() {
        }

        public boolean onLongClick(View view) {
            int id = view.getId();
            if (id == 2131297067) {
                ChannelZoneFragment channelZoneFragment = ChannelZoneFragment.this;
                ChannelZoneFragment.access$102(channelZoneFragment, ChannelZoneFragment.access$300(channelZoneFragment));
                ChannelZoneFragment.access$200(ChannelZoneFragment.this).post(ChannelZoneFragment.access$400(ChannelZoneFragment.this));
                return true;
            }
            if (id == 2131297089) {
                ChannelZoneFragment channelZoneFragment2 = ChannelZoneFragment.this;
                ChannelZoneFragment.access$102(channelZoneFragment2, ChannelZoneFragment.access$500(channelZoneFragment2));
                ChannelZoneFragment.access$200(ChannelZoneFragment.this).post(ChannelZoneFragment.access$400(ChannelZoneFragment.this));
                return true;
            }
            if (id == 2131297068) {
                ChannelZoneFragment channelZoneFragment3 = ChannelZoneFragment.this;
                ChannelZoneFragment.access$102(channelZoneFragment3, ChannelZoneFragment.access$600(channelZoneFragment3));
                ChannelZoneFragment.access$200(ChannelZoneFragment.this).post(ChannelZoneFragment.access$400(ChannelZoneFragment.this));
                return true;
            }
            if (id == 2131297090) {
                ChannelZoneFragment channelZoneFragment4 = ChannelZoneFragment.this;
                ChannelZoneFragment.access$102(channelZoneFragment4, ChannelZoneFragment.access$700(channelZoneFragment4));
                ChannelZoneFragment.access$200(ChannelZoneFragment.this).post(ChannelZoneFragment.access$400(ChannelZoneFragment.this));
                return true;
            }
            if (id == 2131297070) {
                ChannelZoneFragment channelZoneFragment5 = ChannelZoneFragment.this;
                ChannelZoneFragment.access$102(channelZoneFragment5, ChannelZoneFragment.access$800(channelZoneFragment5));
                ChannelZoneFragment.access$200(ChannelZoneFragment.this).post(ChannelZoneFragment.access$400(ChannelZoneFragment.this));
                return true;
            }
            if (id == 2131297092) {
                ChannelZoneFragment channelZoneFragment6 = ChannelZoneFragment.this;
                ChannelZoneFragment.access$102(channelZoneFragment6, ChannelZoneFragment.access$900(channelZoneFragment6));
                ChannelZoneFragment.access$200(ChannelZoneFragment.this).post(ChannelZoneFragment.access$400(ChannelZoneFragment.this));
                return true;
            }
            if (id == 2131297071) {
                ChannelZoneFragment channelZoneFragment7 = ChannelZoneFragment.this;
                ChannelZoneFragment.access$102(channelZoneFragment7, ChannelZoneFragment.access$1000(channelZoneFragment7));
                ChannelZoneFragment.access$200(ChannelZoneFragment.this).post(ChannelZoneFragment.access$400(ChannelZoneFragment.this));
                return true;
            }
            if (id == 2131297093) {
                ChannelZoneFragment channelZoneFragment8 = ChannelZoneFragment.this;
                ChannelZoneFragment.access$102(channelZoneFragment8, ChannelZoneFragment.access$1100(channelZoneFragment8));
                ChannelZoneFragment.access$200(ChannelZoneFragment.this).post(ChannelZoneFragment.access$400(ChannelZoneFragment.this));
                return true;
            }
            if (id == 2131297069) {
                ChannelZoneFragment channelZoneFragment9 = ChannelZoneFragment.this;
                ChannelZoneFragment.access$102(channelZoneFragment9, ChannelZoneFragment.access$1200(channelZoneFragment9));
                ChannelZoneFragment.access$200(ChannelZoneFragment.this).post(ChannelZoneFragment.access$400(ChannelZoneFragment.this));
                return true;
            }
            if (id == 2131297091) {
                ChannelZoneFragment channelZoneFragment10 = ChannelZoneFragment.this;
                ChannelZoneFragment.access$102(channelZoneFragment10, ChannelZoneFragment.access$1300(channelZoneFragment10));
                ChannelZoneFragment.access$200(ChannelZoneFragment.this).post(ChannelZoneFragment.access$400(ChannelZoneFragment.this));
                return true;
            }
            if (id == 2131297072) {
                ChannelZoneFragment channelZoneFragment11 = ChannelZoneFragment.this;
                ChannelZoneFragment.access$102(channelZoneFragment11, ChannelZoneFragment.access$1400(channelZoneFragment11));
                ChannelZoneFragment.access$200(ChannelZoneFragment.this).post(ChannelZoneFragment.access$400(ChannelZoneFragment.this));
                return true;
            }
            if (id == 2131297094) {
                ChannelZoneFragment channelZoneFragment12 = ChannelZoneFragment.this;
                ChannelZoneFragment.access$102(channelZoneFragment12, ChannelZoneFragment.access$1500(channelZoneFragment12));
                ChannelZoneFragment.access$200(ChannelZoneFragment.this).post(ChannelZoneFragment.access$400(ChannelZoneFragment.this));
                return true;
            }
            if (id == 2131297073) {
                ChannelZoneFragment channelZoneFragment13 = ChannelZoneFragment.this;
                ChannelZoneFragment.access$102(channelZoneFragment13, ChannelZoneFragment.access$1600(channelZoneFragment13));
                ChannelZoneFragment.access$200(ChannelZoneFragment.this).post(ChannelZoneFragment.access$400(ChannelZoneFragment.this));
                return true;
            }
            if (id != 2131297095) {
                return true;
            }
            ChannelZoneFragment channelZoneFragment14 = ChannelZoneFragment.this;
            ChannelZoneFragment.access$102(channelZoneFragment14, ChannelZoneFragment.access$1700(channelZoneFragment14));
            ChannelZoneFragment.access$200(ChannelZoneFragment.this).post(ChannelZoneFragment.access$400(ChannelZoneFragment.this));
            return true;
        }
    }

    class 4 implements View.OnTouchListener {
        4() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 || ChannelZoneFragment.access$100(ChannelZoneFragment.this) == null) {
                return false;
            }
            ChannelZoneFragment.access$102(ChannelZoneFragment.this, null);
            if (view.isPressed()) {
                view.setPressed(false);
            }
            return true;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(2131492934, viewGroup, false);
            this.iv_car = this.mRootView.findViewById(2131296557);
            this.rl_adc_l = this.mRootView.findViewById(2131296723);
            this.tv_gain_adc_l = this.mRootView.findViewById(2131296976);
            this.tv_phase_adc_l = this.mRootView.findViewById(2131297013);
            TextView findViewById = this.mRootView.findViewById(2131296366);
            this.bt_set_up_adc_l = findViewById;
            findViewById.setOnClickListener(this.mOnClickListener);
            UIImageView findViewById2 = this.mRootView.findViewById(2131297067);
            this.uiv_add_adc_l = findViewById2;
            findViewById2.setOnClickListener(this.mOnClickListener);
            this.uiv_add_adc_l.setOnLongClickListener(this.mOnLongClickListener);
            this.uiv_add_adc_l.setOnTouchListener(this.mOnTouchListener);
            UIImageView findViewById3 = this.mRootView.findViewById(2131297089);
            this.uiv_sub_adc_l = findViewById3;
            findViewById3.setOnClickListener(this.mOnClickListener);
            this.uiv_sub_adc_l.setOnLongClickListener(this.mOnLongClickListener);
            this.uiv_sub_adc_l.setOnTouchListener(this.mOnTouchListener);
            this.rl_adc_r = this.mRootView.findViewById(2131296724);
            this.tv_gain_adc_r = this.mRootView.findViewById(2131296977);
            this.tv_phase_adc_r = this.mRootView.findViewById(2131297014);
            TextView findViewById4 = this.mRootView.findViewById(2131296367);
            this.bt_set_up_adc_r = findViewById4;
            findViewById4.setOnClickListener(this.mOnClickListener);
            UIImageView findViewById5 = this.mRootView.findViewById(2131297068);
            this.uiv_add_adc_r = findViewById5;
            findViewById5.setOnClickListener(this.mOnClickListener);
            this.uiv_add_adc_r.setOnLongClickListener(this.mOnLongClickListener);
            this.uiv_add_adc_r.setOnTouchListener(this.mOnTouchListener);
            UIImageView findViewById6 = this.mRootView.findViewById(2131297090);
            this.uiv_sub_adc_r = findViewById6;
            findViewById6.setOnClickListener(this.mOnClickListener);
            this.uiv_sub_adc_r.setOnLongClickListener(this.mOnLongClickListener);
            this.uiv_sub_adc_r.setOnTouchListener(this.mOnTouchListener);
            this.rl_d1 = this.mRootView.findViewById(2131296725);
            this.tv_gain_d1 = this.mRootView.findViewById(2131296978);
            this.tv_phase_d1 = this.mRootView.findViewById(2131297015);
            TextView findViewById7 = this.mRootView.findViewById(2131296368);
            this.bt_set_up_d1 = findViewById7;
            findViewById7.setOnClickListener(this.mOnClickListener);
            UIImageView findViewById8 = this.mRootView.findViewById(2131297069);
            this.uiv_add_d1 = findViewById8;
            findViewById8.setOnClickListener(this.mOnClickListener);
            this.uiv_add_d1.setOnLongClickListener(this.mOnLongClickListener);
            this.uiv_add_d1.setOnTouchListener(this.mOnTouchListener);
            UIImageView findViewById9 = this.mRootView.findViewById(2131297091);
            this.uiv_sub_d1 = findViewById9;
            findViewById9.setOnClickListener(this.mOnClickListener);
            this.uiv_sub_d1.setOnLongClickListener(this.mOnLongClickListener);
            this.uiv_sub_d1.setOnTouchListener(this.mOnTouchListener);
            this.rl_d1_l = this.mRootView.findViewById(2131296726);
            this.tv_gain_d1_l = this.mRootView.findViewById(2131296979);
            this.tv_phase_d1_l = this.mRootView.findViewById(2131297016);
            TextView findViewById10 = this.mRootView.findViewById(2131296369);
            this.bt_set_up_d1_l = findViewById10;
            findViewById10.setOnClickListener(this.mOnClickListener);
            UIImageView findViewById11 = this.mRootView.findViewById(2131297070);
            this.uiv_add_d1_l = findViewById11;
            findViewById11.setOnClickListener(this.mOnClickListener);
            this.uiv_add_d1_l.setOnLongClickListener(this.mOnLongClickListener);
            this.uiv_add_d1_l.setOnTouchListener(this.mOnTouchListener);
            UIImageView findViewById12 = this.mRootView.findViewById(2131297092);
            this.uiv_sub_d1_l = findViewById12;
            findViewById12.setOnClickListener(this.mOnClickListener);
            this.uiv_sub_d1_l.setOnLongClickListener(this.mOnLongClickListener);
            this.uiv_sub_d1_l.setOnTouchListener(this.mOnTouchListener);
            this.rl_d1_r = this.mRootView.findViewById(2131296727);
            this.tv_gain_d1_r = this.mRootView.findViewById(2131296980);
            this.tv_phase_d1_r = this.mRootView.findViewById(2131297017);
            TextView findViewById13 = this.mRootView.findViewById(2131296370);
            this.bt_set_up_d1_r = findViewById13;
            findViewById13.setOnClickListener(this.mOnClickListener);
            UIImageView findViewById14 = this.mRootView.findViewById(2131297071);
            this.uiv_add_d1_r = findViewById14;
            findViewById14.setOnClickListener(this.mOnClickListener);
            this.uiv_add_d1_r.setOnLongClickListener(this.mOnLongClickListener);
            this.uiv_add_d1_r.setOnTouchListener(this.mOnTouchListener);
            UIImageView findViewById15 = this.mRootView.findViewById(2131297093);
            this.uiv_sub_d1_r = findViewById15;
            findViewById15.setOnClickListener(this.mOnClickListener);
            this.uiv_sub_d1_r.setOnLongClickListener(this.mOnLongClickListener);
            this.uiv_sub_d1_r.setOnTouchListener(this.mOnTouchListener);
            this.rl_d2_l = this.mRootView.findViewById(2131296728);
            this.tv_gain_d2_l = this.mRootView.findViewById(2131296981);
            this.tv_phase_d2_l = this.mRootView.findViewById(2131297018);
            TextView findViewById16 = this.mRootView.findViewById(2131296371);
            this.bt_set_up_d2_l = findViewById16;
            findViewById16.setOnClickListener(this.mOnClickListener);
            UIImageView findViewById17 = this.mRootView.findViewById(2131297072);
            this.uiv_add_d2_l = findViewById17;
            findViewById17.setOnClickListener(this.mOnClickListener);
            this.uiv_add_d2_l.setOnLongClickListener(this.mOnLongClickListener);
            this.uiv_add_d2_l.setOnTouchListener(this.mOnTouchListener);
            UIImageView findViewById18 = this.mRootView.findViewById(2131297094);
            this.uiv_sub_d2_l = findViewById18;
            findViewById18.setOnClickListener(this.mOnClickListener);
            this.uiv_sub_d2_l.setOnLongClickListener(this.mOnLongClickListener);
            this.uiv_sub_d2_l.setOnTouchListener(this.mOnTouchListener);
            this.rl_d2_r = this.mRootView.findViewById(2131296729);
            this.tv_gain_d2_r = this.mRootView.findViewById(2131296982);
            this.tv_phase_d2_r = this.mRootView.findViewById(2131297019);
            TextView findViewById19 = this.mRootView.findViewById(2131296372);
            this.bt_set_up_d2_r = findViewById19;
            findViewById19.setOnClickListener(this.mOnClickListener);
            UIImageView findViewById20 = this.mRootView.findViewById(2131297073);
            this.uiv_add_d2_r = findViewById20;
            findViewById20.setOnClickListener(this.mOnClickListener);
            this.uiv_add_d2_r.setOnLongClickListener(this.mOnLongClickListener);
            this.uiv_add_d2_r.setOnTouchListener(this.mOnTouchListener);
            UIImageView findViewById21 = this.mRootView.findViewById(2131297095);
            this.uiv_sub_d2_r = findViewById21;
            findViewById21.setOnClickListener(this.mOnClickListener);
            this.uiv_sub_d2_r.setOnLongClickListener(this.mOnLongClickListener);
            this.uiv_sub_d2_r.setOnTouchListener(this.mOnTouchListener);
            List<ChannelRecord> findAll = LitePal.findAll(ChannelRecord.class, new long[0]);
            if (findAll.size() < 5) {
                for (int i = 1; i <= 6; i++) {
                    ChannelRecord channelRecord = new ChannelRecord(String.valueOf(i));
                    channelRecord.gain = 0;
                    channelRecord.phase = 0;
                    channelRecord.high_pass_switch = 0;
                    channelRecord.high_pass_frequency = 6000;
                    channelRecord.high_pass_slope = 1;
                    channelRecord.low_pass_switch = 0;
                    channelRecord.low_pass_frequency = 400;
                    channelRecord.low_pass_slope = 1;
                    channelRecord.save();
                }
            }
            for (ChannelRecord channelRecord2 : findAll) {
                String str = channelRecord2.number;
                str.hashCode();
                switch (str) {
                    case "1":
                        if (channelRecord2.phase == 0) {
                            this.tv_phase_adc_l.setText(2131755367);
                        } else {
                            this.tv_phase_adc_l.setText(2131755405);
                        }
                        this.tv_gain_adc_l.setText((channelRecord2.gain + this.mGainOutStart) + "db");
                        break;
                    case "2":
                        if (channelRecord2.phase == 0) {
                            this.tv_phase_adc_r.setText(2131755367);
                        } else {
                            this.tv_phase_adc_r.setText(2131755405);
                        }
                        this.tv_gain_adc_r.setText((channelRecord2.gain + this.mGainOutStart) + "db");
                        break;
                    case "3":
                        if (channelRecord2.phase == 0) {
                            this.tv_phase_d1_l.setText(2131755367);
                        } else {
                            this.tv_phase_d1_l.setText(2131755405);
                        }
                        this.tv_gain_d1_l.setText((channelRecord2.gain + this.mGainOutStart) + "db");
                        break;
                    case "4":
                        if (channelRecord2.phase == 0) {
                            this.tv_phase_d1.setText(2131755367);
                            this.tv_phase_d1_r.setText(2131755367);
                        } else {
                            this.tv_phase_d1.setText(2131755405);
                            this.tv_phase_d1_r.setText(2131755405);
                        }
                        this.tv_gain_d1.setText((channelRecord2.gain + this.mGainOutStart) + "db");
                        this.tv_gain_d1_r.setText((channelRecord2.gain + this.mGainOutStart) + "db");
                        break;
                    case "5":
                        if (channelRecord2.phase == 0) {
                            this.tv_phase_d2_l.setText(2131755367);
                        } else {
                            this.tv_phase_d2_l.setText(2131755405);
                        }
                        this.tv_gain_d2_l.setText((channelRecord2.gain + this.mGainOutStart) + "db");
                        break;
                    case "6":
                        if (channelRecord2.phase == 0) {
                            this.tv_phase_d2_r.setText(2131755367);
                        } else {
                            this.tv_phase_d2_r.setText(2131755405);
                        }
                        this.tv_gain_d2_r.setText((channelRecord2.gain + this.mGainOutStart) + "db");
                        break;
                }
            }
            refreshEqEqType(this.mBaseViewModel.getEqType());
            this.mRootView.getViewTreeObserver().addOnGlobalLayoutListener(new 5());
        }
        ViewGroup parent = this.mRootView.getParent();
        if (parent != null) {
            parent.removeView(this.mRootView);
        }
        return this.mRootView;
    }

    class 5 implements ViewTreeObserver.OnGlobalLayoutListener {
        5() {
        }

        public void onGlobalLayout() {
            int dpToPx = DisplayUtil.dpToPx(ChannelZoneFragment.this.getContext(), 25);
            if (ChannelZoneFragment.access$1800(ChannelZoneFragment.this).getTop() < dpToPx) {
                dpToPx = ChannelZoneFragment.access$1800(ChannelZoneFragment.this).getTop();
            }
            RelativeLayout.LayoutParams layoutParams = ChannelZoneFragment.access$1900(ChannelZoneFragment.this).getLayoutParams();
            int i = dpToPx * (-1);
            layoutParams.topMargin = i;
            ChannelZoneFragment.access$1900(ChannelZoneFragment.this).setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = ChannelZoneFragment.access$2000(ChannelZoneFragment.this).getLayoutParams();
            layoutParams2.topMargin = i;
            ChannelZoneFragment.access$2000(ChannelZoneFragment.this).setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = ChannelZoneFragment.access$2100(ChannelZoneFragment.this).getLayoutParams();
            layoutParams3.bottomMargin = i;
            ChannelZoneFragment.access$2100(ChannelZoneFragment.this).setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = ChannelZoneFragment.access$2200(ChannelZoneFragment.this).getLayoutParams();
            layoutParams4.bottomMargin = i;
            ChannelZoneFragment.access$2200(ChannelZoneFragment.this).setLayoutParams(layoutParams4);
        }
    }

    private void refreshEqEqType(int i) {
        if (i == 6) {
            this.iv_car.getDrawable().setLevel(1);
            this.rl_d1_l.setVisibility(0);
            this.rl_d1_r.setVisibility(0);
            this.rl_d1.setVisibility(4);
        } else {
            this.iv_car.getDrawable().setLevel(0);
            this.rl_d1_l.setVisibility(4);
            this.rl_d1_r.setVisibility(4);
            this.rl_d1.setVisibility(0);
        }
        if (i == 5) {
            this.mGainOutMax = 32;
        } else {
            this.mGainOutMax = 44;
        }
    }

    public void notice(String str, UUID uuid, byte[] bArr) {
        String upperCase;
        super.notice(str, uuid, bArr);
        try {
            upperCase = Convert.bytesToHexString(bArr).toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        if (upperCase.startsWith(OrderSet.notice_version_eq_six_channel)) {
            refreshEqEqType(6);
            return;
        }
        if (upperCase.startsWith(OrderSet.notice_version_eq_channel)) {
            refreshEqEqType(3);
            return;
        }
        if (upperCase.startsWith(OrderSet.notice_version_location)) {
            refreshEqEqType(4);
            return;
        }
        if (upperCase.startsWith(OrderSet.notice_version_eq_five_channel)) {
            refreshEqEqType(5);
            return;
        }
        if (upperCase.startsWith(OrderSet.notice_channel_phase_gain)) {
            int parseInt = Integer.parseInt(upperCase.substring(4, 6), 16);
            int parseInt2 = Integer.parseInt(upperCase.substring(6, 8), 16);
            int parseInt3 = Integer.parseInt(upperCase.substring(8, 10), 16);
            switch (parseInt) {
                case 1:
                    if (parseInt2 == 0) {
                        this.tv_phase_adc_l.setText(2131755367);
                    } else {
                        this.tv_phase_adc_l.setText(2131755405);
                    }
                    this.tv_gain_adc_l.setText((parseInt3 + this.mGainOutStart) + "db");
                    break;
                case 2:
                    if (parseInt2 == 0) {
                        this.tv_phase_adc_r.setText(2131755367);
                    } else {
                        this.tv_phase_adc_r.setText(2131755405);
                    }
                    this.tv_gain_adc_r.setText((parseInt3 + this.mGainOutStart) + "db");
                    break;
                case 3:
                    if (parseInt2 == 0) {
                        this.tv_phase_d1_l.setText(2131755367);
                    } else {
                        this.tv_phase_d1_l.setText(2131755405);
                    }
                    this.tv_gain_d1_l.setText((parseInt3 + this.mGainOutStart) + "db");
                    break;
                case 4:
                    if (parseInt2 == 0) {
                        this.tv_phase_d1.setText(2131755367);
                        this.tv_phase_d1_r.setText(2131755367);
                    } else {
                        this.tv_phase_d1.setText(2131755405);
                        this.tv_phase_d1_r.setText(2131755405);
                    }
                    this.tv_gain_d1.setText((this.mGainOutStart + parseInt3) + "db");
                    this.tv_gain_d1_r.setText((parseInt3 + this.mGainOutStart) + "db");
                    break;
                case 5:
                    if (parseInt2 == 0) {
                        this.tv_phase_d2_l.setText(2131755367);
                    } else {
                        this.tv_phase_d2_l.setText(2131755405);
                    }
                    this.tv_gain_d2_l.setText((parseInt3 + this.mGainOutStart) + "db");
                    break;
                case 6:
                    if (parseInt2 == 0) {
                        this.tv_phase_d2_r.setText(2131755367);
                    } else {
                        this.tv_phase_d2_r.setText(2131755405);
                    }
                    this.tv_gain_d2_r.setText((parseInt3 + this.mGainOutStart) + "db");
                    break;
            }
            return;
        }
        if (upperCase.startsWith(OrderSet.notice_channel_reset)) {
            this.tv_phase_adc_l.setText(2131755367);
            this.tv_phase_adc_r.setText(2131755367);
            this.tv_phase_d1_l.setText(2131755367);
            this.tv_phase_d1.setText(2131755367);
            this.tv_phase_d1_r.setText(2131755367);
            this.tv_phase_d2_l.setText(2131755367);
            this.tv_phase_d2_r.setText(2131755367);
            this.tv_gain_adc_l.setText("0db");
            this.tv_gain_adc_r.setText("0db");
            this.tv_gain_d1_l.setText("0db");
            this.tv_gain_d1.setText("0db");
            this.tv_gain_d1_r.setText("0db");
            this.tv_gain_d2_l.setText("0db");
            this.tv_gain_d2_r.setText("0db");
        }
    }

    public void setChBtEdit(boolean z) {
        this.canEditGain = z;
        if (getActivity() == null) {
            return;
        }
        Drawable drawable = getActivity().getResources().getDrawable(2131230891);
        Drawable drawable2 = getActivity().getResources().getDrawable(2131230892);
        this.bt_set_up_adc_l.setBackground(z ? drawable : drawable2);
        this.bt_set_up_adc_r.setBackground(z ? drawable : drawable2);
        this.bt_set_up_d1.setBackground(z ? drawable : drawable2);
        this.bt_set_up_d2_l.setBackground(z ? drawable : drawable2);
        TextView textView = this.bt_set_up_d2_r;
        if (!z) {
            drawable = drawable2;
        }
        textView.setBackground(drawable);
    }
}
