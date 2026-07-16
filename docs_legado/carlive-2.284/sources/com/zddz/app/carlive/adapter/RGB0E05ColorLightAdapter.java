package com.zddz.app.carlive.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.zddz.app.carlive.adapter.entity.Rgb0E05ColorItem;
import com.zddz.bt.BtService$$ExternalSyntheticApiModelOutline0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class RGB0E05ColorLightAdapter extends RecyclerView.Adapter {
    Context mContext;
    private OnItemClickListener mListener = new 2();
    private List mList = new ArrayList();

    public interface OnItemClickListener {
        void onItemClick(int i);
    }

    static /* synthetic */ OnItemClickListener access$000(RGB0E05ColorLightAdapter rGB0E05ColorLightAdapter) {
        return rGB0E05ColorLightAdapter.mListener;
    }

    public void setDatalist(List list) {
        this.mList = list;
    }

    public void updateItem(Rgb0E05ColorItem rgb0E05ColorItem) {
        for (Rgb0E05ColorItem rgb0E05ColorItem2 : this.mList) {
            if (rgb0E05ColorItem2.getColorName().equals(rgb0E05ColorItem.getColorName())) {
                rgb0E05ColorItem2.setSelect(true);
            } else {
                rgb0E05ColorItem2.setSelect(false);
            }
        }
        notifyDataSetChanged();
    }

    public class TabItemViewHolder extends RecyclerView.ViewHolder {
        public TextView mtv_color_name;

        public TabItemViewHolder(View view) {
            super(view);
            this.mtv_color_name = view.findViewById(2131296994);
        }
    }

    public RGB0E05ColorLightAdapter(Context context) {
        this.mContext = context;
    }

    public RGB0E05ColorLightAdapter() {
    }

    public TabItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new TabItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2131492939, viewGroup, false));
    }

    class 1 implements View.OnClickListener {
        final /* synthetic */ int val$position;

        1(int i) {
            this.val$position = i;
        }

        public void onClick(View view) {
            RGB0E05ColorLightAdapter.access$000(RGB0E05ColorLightAdapter.this).onItemClick(this.val$position);
        }
    }

    public void onBindViewHolder(TabItemViewHolder tabItemViewHolder, int i) {
        Rgb0E05ColorItem rgb0E05ColorItem = (Rgb0E05ColorItem) this.mList.get(i);
        tabItemViewHolder.itemView.setOnClickListener(new 1(i));
        if (rgb0E05ColorItem != null) {
            tabItemViewHolder.mtv_color_name.setText(rgb0E05ColorItem.getColorName());
            Drawable drawable = this.mContext.getResources().getDrawable(rgb0E05ColorItem.getColorIcon());
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable, rgb0E05ColorItem.getSelect().booleanValue() ? getBorderDrawable(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight()) : null});
            layerDrawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            tabItemViewHolder.mtv_color_name.setCompoundDrawables((Drawable) null, layerDrawable, (Drawable) null, (Drawable) null);
        }
    }

    private Drawable getBorderDrawable(int i, int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        gradientDrawable.setStroke(2, BtService$$ExternalSyntheticApiModelOutline0.m(this.mContext, 2131100402));
        gradientDrawable.setCornerRadius(100.0f);
        gradientDrawable.setBounds(0, 0, i, i2);
        return gradientDrawable;
    }

    public int getItemCount() {
        return this.mList.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mListener = onItemClickListener;
    }

    class 2 implements OnItemClickListener {
        public void onItemClick(int i) {
        }

        2() {
        }
    }
}
