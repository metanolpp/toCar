package com.zddz.app.carlive.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.zddz.widget.CdView;
import com.zddz.widget.MarqueeTextView;
import com.zddz.widget.NoAnimateEditText;
import com.zddz.widget.SectionSeekBar;
import com.zddz.widget.UIImageView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class FragmentMainBinding implements ViewBinding {
    public final CdView cdView;
    public final ConstraintLayout ctlBottomZone;
    public final ConstraintLayout ctlDialogZone;
    public final NoAnimateEditText edtMusicNum;
    public final ImageView imgVolumnCut;
    public final ImageView ivSetUp;
    public final ImageView ivTop;
    public final ImageView ivUpdateNotice;
    public final LinearLayout llAms;
    public final LinearLayout llBottom;
    public final LinearLayout llBtList;
    public final LinearLayout llClock;
    public final LinearLayout llContent;
    public final LinearLayout llEq;
    public final LinearLayout llItem;
    public final LinearLayout llMode;
    public final LinearLayout llRgb;
    public final LinearLayout llTop;
    public final LinearLayout llVolBox;
    public final MarqueeTextView mtvContent;
    public final MarqueeTextView mtvDabName;
    private final ConstraintLayout rootView;
    public final SectionSeekBar sectionBarVolume;
    public final TextView tvChooseMusicTips;
    public final TextView tvComfirm;
    public final TextView tvDabFrequency;
    public final TextView tvVolume;
    public final UIImageView uivAms;
    public final UIImageView uivBtList;
    public final UIImageView uivClock;
    public final UIImageView uivEq;
    public final UIImageView uivLast;
    public final UIImageView uivMode;
    public final UIImageView uivNext;
    public final UIImageView uivPlayPause;
    public final UIImageView uivPower;
    public final UIImageView uivRadio;
    public final UIImageView uivRgb;
    public final UIImageView uivSdcard;
    public final UIImageView uivUsb;
    public final UIImageView uivVolumeAdd;
    public final UIImageView uivVolumeSub;
    public final View viewEmpty;

    private FragmentMainBinding(ConstraintLayout constraintLayout, CdView cdView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, NoAnimateEditText noAnimateEditText, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, LinearLayout linearLayout8, LinearLayout linearLayout9, LinearLayout linearLayout10, LinearLayout linearLayout11, MarqueeTextView marqueeTextView, MarqueeTextView marqueeTextView2, SectionSeekBar sectionSeekBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, UIImageView uIImageView, UIImageView uIImageView2, UIImageView uIImageView3, UIImageView uIImageView4, UIImageView uIImageView5, UIImageView uIImageView6, UIImageView uIImageView7, UIImageView uIImageView8, UIImageView uIImageView9, UIImageView uIImageView10, UIImageView uIImageView11, UIImageView uIImageView12, UIImageView uIImageView13, UIImageView uIImageView14, UIImageView uIImageView15, View view) {
        this.rootView = constraintLayout;
        this.cdView = cdView;
        this.ctlBottomZone = constraintLayout2;
        this.ctlDialogZone = constraintLayout3;
        this.edtMusicNum = noAnimateEditText;
        this.imgVolumnCut = imageView;
        this.ivSetUp = imageView2;
        this.ivTop = imageView3;
        this.ivUpdateNotice = imageView4;
        this.llAms = linearLayout;
        this.llBottom = linearLayout2;
        this.llBtList = linearLayout3;
        this.llClock = linearLayout4;
        this.llContent = linearLayout5;
        this.llEq = linearLayout6;
        this.llItem = linearLayout7;
        this.llMode = linearLayout8;
        this.llRgb = linearLayout9;
        this.llTop = linearLayout10;
        this.llVolBox = linearLayout11;
        this.mtvContent = marqueeTextView;
        this.mtvDabName = marqueeTextView2;
        this.sectionBarVolume = sectionSeekBar;
        this.tvChooseMusicTips = textView;
        this.tvComfirm = textView2;
        this.tvDabFrequency = textView3;
        this.tvVolume = textView4;
        this.uivAms = uIImageView;
        this.uivBtList = uIImageView2;
        this.uivClock = uIImageView3;
        this.uivEq = uIImageView4;
        this.uivLast = uIImageView5;
        this.uivMode = uIImageView6;
        this.uivNext = uIImageView7;
        this.uivPlayPause = uIImageView8;
        this.uivPower = uIImageView9;
        this.uivRadio = uIImageView10;
        this.uivRgb = uIImageView11;
        this.uivSdcard = uIImageView12;
        this.uivUsb = uIImageView13;
        this.uivVolumeAdd = uIImageView14;
        this.uivVolumeSub = uIImageView15;
        this.viewEmpty = view;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(2131492935, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentMainBinding bind(View view) {
        int i = 2131296381;
        CdView cdView = (CdView) ViewBindings.findChildViewById(view, 2131296381);
        if (cdView != null) {
            i = 2131296416;
            ConstraintLayout findChildViewById = ViewBindings.findChildViewById(view, 2131296416);
            if (findChildViewById != null) {
                i = 2131296418;
                ConstraintLayout findChildViewById2 = ViewBindings.findChildViewById(view, 2131296418);
                if (findChildViewById2 != null) {
                    i = 2131296486;
                    NoAnimateEditText findChildViewById3 = ViewBindings.findChildViewById(view, 2131296486);
                    if (findChildViewById3 != null) {
                        i = 2131296545;
                        ImageView findChildViewById4 = ViewBindings.findChildViewById(view, 2131296545);
                        if (findChildViewById4 != null) {
                            i = 2131296560;
                            ImageView findChildViewById5 = ViewBindings.findChildViewById(view, 2131296560);
                            if (findChildViewById5 != null) {
                                i = 2131296562;
                                ImageView findChildViewById6 = ViewBindings.findChildViewById(view, 2131296562);
                                if (findChildViewById6 != null) {
                                    i = 2131296563;
                                    ImageView findChildViewById7 = ViewBindings.findChildViewById(view, 2131296563);
                                    if (findChildViewById7 != null) {
                                        i = 2131296577;
                                        LinearLayout findChildViewById8 = ViewBindings.findChildViewById(view, 2131296577);
                                        if (findChildViewById8 != null) {
                                            i = 2131296579;
                                            LinearLayout findChildViewById9 = ViewBindings.findChildViewById(view, 2131296579);
                                            if (findChildViewById9 != null) {
                                                i = 2131296580;
                                                LinearLayout findChildViewById10 = ViewBindings.findChildViewById(view, 2131296580);
                                                if (findChildViewById10 != null) {
                                                    i = 2131296582;
                                                    LinearLayout findChildViewById11 = ViewBindings.findChildViewById(view, 2131296582);
                                                    if (findChildViewById11 != null) {
                                                        i = 2131296584;
                                                        LinearLayout findChildViewById12 = ViewBindings.findChildViewById(view, 2131296584);
                                                        if (findChildViewById12 != null) {
                                                            i = 2131296587;
                                                            LinearLayout findChildViewById13 = ViewBindings.findChildViewById(view, 2131296587);
                                                            if (findChildViewById13 != null) {
                                                                i = 2131296592;
                                                                LinearLayout findChildViewById14 = ViewBindings.findChildViewById(view, 2131296592);
                                                                if (findChildViewById14 != null) {
                                                                    i = 2131296596;
                                                                    LinearLayout findChildViewById15 = ViewBindings.findChildViewById(view, 2131296596);
                                                                    if (findChildViewById15 != null) {
                                                                        i = 2131296599;
                                                                        LinearLayout findChildViewById16 = ViewBindings.findChildViewById(view, 2131296599);
                                                                        if (findChildViewById16 != null) {
                                                                            i = 2131296605;
                                                                            LinearLayout findChildViewById17 = ViewBindings.findChildViewById(view, 2131296605);
                                                                            if (findChildViewById17 != null) {
                                                                                i = 2131296606;
                                                                                LinearLayout findChildViewById18 = ViewBindings.findChildViewById(view, 2131296606);
                                                                                if (findChildViewById18 != null) {
                                                                                    i = 2131296667;
                                                                                    MarqueeTextView findChildViewById19 = ViewBindings.findChildViewById(view, 2131296667);
                                                                                    if (findChildViewById19 != null) {
                                                                                        i = 2131296668;
                                                                                        MarqueeTextView findChildViewById20 = ViewBindings.findChildViewById(view, 2131296668);
                                                                                        if (findChildViewById20 != null) {
                                                                                            i = 2131296803;
                                                                                            SectionSeekBar sectionSeekBar = (SectionSeekBar) ViewBindings.findChildViewById(view, 2131296803);
                                                                                            if (sectionSeekBar != null) {
                                                                                                i = 2131296922;
                                                                                                TextView findChildViewById21 = ViewBindings.findChildViewById(view, 2131296922);
                                                                                                if (findChildViewById21 != null) {
                                                                                                    i = 2131296925;
                                                                                                    TextView findChildViewById22 = ViewBindings.findChildViewById(view, 2131296925);
                                                                                                    if (findChildViewById22 != null) {
                                                                                                        i = 2131296929;
                                                                                                        TextView findChildViewById23 = ViewBindings.findChildViewById(view, 2131296929);
                                                                                                        if (findChildViewById23 != null) {
                                                                                                            i = 2131297062;
                                                                                                            TextView findChildViewById24 = ViewBindings.findChildViewById(view, 2131297062);
                                                                                                            if (findChildViewById24 != null) {
                                                                                                                i = 2131297074;
                                                                                                                UIImageView findChildViewById25 = ViewBindings.findChildViewById(view, 2131297074);
                                                                                                                if (findChildViewById25 != null) {
                                                                                                                    i = 2131297076;
                                                                                                                    UIImageView findChildViewById26 = ViewBindings.findChildViewById(view, 2131297076);
                                                                                                                    if (findChildViewById26 != null) {
                                                                                                                        i = 2131297077;
                                                                                                                        UIImageView findChildViewById27 = ViewBindings.findChildViewById(view, 2131297077);
                                                                                                                        if (findChildViewById27 != null) {
                                                                                                                            i = 2131297079;
                                                                                                                            UIImageView findChildViewById28 = ViewBindings.findChildViewById(view, 2131297079);
                                                                                                                            if (findChildViewById28 != null) {
                                                                                                                                i = 2131297080;
                                                                                                                                UIImageView findChildViewById29 = ViewBindings.findChildViewById(view, 2131297080);
                                                                                                                                if (findChildViewById29 != null) {
                                                                                                                                    i = 2131297081;
                                                                                                                                    UIImageView findChildViewById30 = ViewBindings.findChildViewById(view, 2131297081);
                                                                                                                                    if (findChildViewById30 != null) {
                                                                                                                                        i = 2131297082;
                                                                                                                                        UIImageView findChildViewById31 = ViewBindings.findChildViewById(view, 2131297082);
                                                                                                                                        if (findChildViewById31 != null) {
                                                                                                                                            i = 2131297083;
                                                                                                                                            UIImageView findChildViewById32 = ViewBindings.findChildViewById(view, 2131297083);
                                                                                                                                            if (findChildViewById32 != null) {
                                                                                                                                                i = 2131297084;
                                                                                                                                                UIImageView findChildViewById33 = ViewBindings.findChildViewById(view, 2131297084);
                                                                                                                                                if (findChildViewById33 != null) {
                                                                                                                                                    i = 2131297085;
                                                                                                                                                    UIImageView findChildViewById34 = ViewBindings.findChildViewById(view, 2131297085);
                                                                                                                                                    if (findChildViewById34 != null) {
                                                                                                                                                        i = 2131297087;
                                                                                                                                                        UIImageView findChildViewById35 = ViewBindings.findChildViewById(view, 2131297087);
                                                                                                                                                        if (findChildViewById35 != null) {
                                                                                                                                                            i = 2131297088;
                                                                                                                                                            UIImageView findChildViewById36 = ViewBindings.findChildViewById(view, 2131297088);
                                                                                                                                                            if (findChildViewById36 != null) {
                                                                                                                                                                i = 2131297096;
                                                                                                                                                                UIImageView findChildViewById37 = ViewBindings.findChildViewById(view, 2131297096);
                                                                                                                                                                if (findChildViewById37 != null) {
                                                                                                                                                                    i = 2131297097;
                                                                                                                                                                    UIImageView findChildViewById38 = ViewBindings.findChildViewById(view, 2131297097);
                                                                                                                                                                    if (findChildViewById38 != null) {
                                                                                                                                                                        i = 2131297098;
                                                                                                                                                                        UIImageView findChildViewById39 = ViewBindings.findChildViewById(view, 2131297098);
                                                                                                                                                                        if (findChildViewById39 != null) {
                                                                                                                                                                            i = 2131297112;
                                                                                                                                                                            View findChildViewById40 = ViewBindings.findChildViewById(view, 2131297112);
                                                                                                                                                                            if (findChildViewById40 != null) {
                                                                                                                                                                                return new FragmentMainBinding((ConstraintLayout) view, cdView, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, findChildViewById5, findChildViewById6, findChildViewById7, findChildViewById8, findChildViewById9, findChildViewById10, findChildViewById11, findChildViewById12, findChildViewById13, findChildViewById14, findChildViewById15, findChildViewById16, findChildViewById17, findChildViewById18, findChildViewById19, findChildViewById20, sectionSeekBar, findChildViewById21, findChildViewById22, findChildViewById23, findChildViewById24, findChildViewById25, findChildViewById26, findChildViewById27, findChildViewById28, findChildViewById29, findChildViewById30, findChildViewById31, findChildViewById32, findChildViewById33, findChildViewById34, findChildViewById35, findChildViewById36, findChildViewById37, findChildViewById38, findChildViewById39, findChildViewById40);
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
