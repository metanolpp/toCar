package com.zddz.app.carlive.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.zddz.ui.RgbLiBandItem;
import com.zddz.widget.rgblibang.LEDStripView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class ColorRgbLiBangAdapter extends RecyclerView.Adapter {
    private int selectedPosition = -1;
    private OnItemClickListener mListener = new 2();
    private List mList = new ArrayList();

    public interface OnItemClickListener {
        void onItemClick(View view, int i);
    }

    static /* synthetic */ OnItemClickListener access$000(ColorRgbLiBangAdapter colorRgbLiBangAdapter) {
        return colorRgbLiBangAdapter.mListener;
    }

    public void setList(List list) {
        this.mList = list;
    }

    public void updateItem(RgbLiBandItem rgbLiBandItem) {
        for (int i = 0; i < this.mList.size(); i++) {
            RgbLiBandItem rgbLiBandItem2 = (RgbLiBandItem) this.mList.get(i);
            rgbLiBandItem2.setSelect(rgbLiBandItem2.getColorTYPE() == rgbLiBandItem.getColorTYPE());
        }
        notifyDataSetChanged();
    }

    public RgbLiBandItem getItem(int i) {
        if (i < this.mList.size()) {
            return (RgbLiBandItem) this.mList.get(i);
        }
        return null;
    }

    public void clear() {
        this.mList.clear();
        notifyDataSetChanged();
    }

    public RgbLiBandItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new RgbLiBandItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2131492940, viewGroup, false));
    }

    public void onBindViewHolder(RgbLiBandItemViewHolder rgbLiBandItemViewHolder, int i) {
        RgbLiBandItem rgbLiBandItem = (RgbLiBandItem) this.mList.get(i);
        if (rgbLiBandItemViewHolder.getAdapterPosition() == this.selectedPosition) {
            rgbLiBandItemViewHolder.view_bg.setBackgroundResource(2131231201);
            rgbLiBandItem.setSelect(true);
        } else {
            rgbLiBandItemViewHolder.view_bg.setBackgroundResource(2131231200);
            rgbLiBandItem.setSelect(false);
        }
        boolean z = i == 0;
        rgbLiBandItemViewHolder.tv_title.setText(z ? "OFF" : String.valueOf(i));
        rgbLiBandItemViewHolder.tv_di.setVisibility(z ? 4 : 0);
        rgbLiBandItemViewHolder.tv_type.setVisibility(z ? 4 : 0);
        rgbLiBandItemViewHolder.ledview.setCurrentEffect(rgbLiBandItem.getColorTYPE());
        rgbLiBandItemViewHolder.itemView.setOnClickListener(new 1(rgbLiBandItemViewHolder, i));
    }

    class 1 implements View.OnClickListener {
        final /* synthetic */ RgbLiBandItemViewHolder val$holder;
        final /* synthetic */ int val$position;

        1(RgbLiBandItemViewHolder rgbLiBandItemViewHolder, int i) {
            this.val$holder = rgbLiBandItemViewHolder;
            this.val$position = i;
        }

        public void onClick(View view) {
            ColorRgbLiBangAdapter.access$000(ColorRgbLiBangAdapter.this).onItemClick(this.val$holder.itemView, this.val$position);
        }
    }

    public int getItemCount() {
        return this.mList.size();
    }

    public class RgbLiBandItemViewHolder extends RecyclerView.ViewHolder {
        public LEDStripView ledview;
        public TextView tv_di;
        public TextView tv_title;
        public TextView tv_type;
        public View view_bg;

        public RgbLiBandItemViewHolder(View view) {
            super(view);
            this.ledview = view.findViewById(2131296568);
            this.tv_title = view.findViewById(2131297049);
            this.tv_di = view.findViewById(2131296931);
            this.tv_type = view.findViewById(2131297060);
            this.view_bg = view.findViewById(2131297105);
        }
    }

    class 2 implements OnItemClickListener {
        public void onItemClick(View view, int i) {
        }

        2() {
        }
    }

    public void setSelectedPosition(int i) {
        int i2 = this.selectedPosition;
        this.selectedPosition = i;
        if (i2 != -1) {
            notifyItemChanged(i2);
        }
        int i3 = this.selectedPosition;
        if (i3 != -1) {
            notifyItemChanged(i3);
        }
    }

    public int getSelectedPosition() {
        return this.selectedPosition;
    }

    public RgbLiBandItem getSelectedItem() {
        int i = this.selectedPosition;
        if (i < 0 || i >= this.mList.size()) {
            return null;
        }
        return (RgbLiBandItem) this.mList.get(this.selectedPosition);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mListener = onItemClickListener;
    }
}
