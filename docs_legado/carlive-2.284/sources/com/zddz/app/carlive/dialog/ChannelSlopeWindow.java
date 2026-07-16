package com.zddz.app.carlive.dialog;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class ChannelSlopeWindow extends PopupWindow {
    private OnItemSelectListener mListener;
    private View.OnClickListener mOnClickListener;

    interface OnItemSelectListener {
        void onItemClick(int i);
    }

    static /* synthetic */ OnItemSelectListener access$000(ChannelSlopeWindow channelSlopeWindow) {
        return channelSlopeWindow.mListener;
    }

    class 1 implements View.OnClickListener {
        1() {
        }

        public void onClick(View view) {
            int id = view.getId();
            if (id == 2131297031) {
                ChannelSlopeWindow.access$000(ChannelSlopeWindow.this).onItemClick(0);
            } else if (id == 2131297032) {
                ChannelSlopeWindow.access$000(ChannelSlopeWindow.this).onItemClick(1);
            } else if (id == 2131297033) {
                ChannelSlopeWindow.access$000(ChannelSlopeWindow.this).onItemClick(2);
            } else if (id == 2131297034) {
                ChannelSlopeWindow.access$000(ChannelSlopeWindow.this).onItemClick(3);
            }
            ChannelSlopeWindow.this.dismiss();
        }
    }

    public ChannelSlopeWindow(Context context, int i) {
        super(context);
        this.mOnClickListener = new 1();
        this.mListener = new 2();
        View inflate = LayoutInflater.from(context).inflate(2131492928, (ViewGroup) null);
        setContentView(inflate);
        setWidth(i);
        inflate.findViewById(2131297031).setOnClickListener(this.mOnClickListener);
        inflate.findViewById(2131297032).setOnClickListener(this.mOnClickListener);
        inflate.findViewById(2131297033).setOnClickListener(this.mOnClickListener);
        inflate.findViewById(2131297034).setOnClickListener(this.mOnClickListener);
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setOutsideTouchable(true);
    }

    class 2 implements OnItemSelectListener {
        public void onItemClick(int i) {
        }

        2() {
        }
    }

    public void setOnItemSelectListener(OnItemSelectListener onItemSelectListener) {
        this.mListener = onItemSelectListener;
    }
}
