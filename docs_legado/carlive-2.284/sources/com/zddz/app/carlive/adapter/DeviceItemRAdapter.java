package com.zddz.app.carlive.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.zddz.bt.DeviceItem;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class DeviceItemRAdapter extends RecyclerView.Adapter {
    private OnItemClickListener mListener = new 2();
    private List mList = new ArrayList();

    public interface OnItemClickListener {
        void onItemClick(View view, int i);
    }

    static /* synthetic */ OnItemClickListener access$000(DeviceItemRAdapter deviceItemRAdapter) {
        return deviceItemRAdapter.mListener;
    }

    public void setList(List list) {
        this.mList = list;
    }

    public void updateItem(DeviceItem deviceItem) {
        for (int i = 0; i < this.mList.size(); i++) {
            DeviceItem deviceItem2 = (DeviceItem) this.mList.get(i);
            if (deviceItem2.mAddress.equals(deviceItem.mAddress)) {
                if (TextUtils.isEmpty(deviceItem2.mName)) {
                    deviceItem2.mName = deviceItem.mName;
                }
                deviceItem2.mState = deviceItem.mState;
                notifyItemChanged(i);
                return;
            }
        }
        if (deviceItem.mState == 2) {
            this.mList.add(0, deviceItem);
            notifyDataSetChanged();
        } else {
            this.mList.add(deviceItem);
            notifyItemChanged(this.mList.size() - 1);
        }
    }

    public void updateDeviceItem(String str, int i) {
        for (int i2 = 0; i2 < this.mList.size(); i2++) {
            DeviceItem deviceItem = (DeviceItem) this.mList.get(i2);
            if (deviceItem.mAddress.equals(str)) {
                deviceItem.mState = i;
                notifyItemChanged(i2);
                return;
            }
        }
    }

    public DeviceItem getItem(int i) {
        if (i < this.mList.size()) {
            return (DeviceItem) this.mList.get(i);
        }
        return null;
    }

    public void clear() {
        this.mList.clear();
        notifyDataSetChanged();
    }

    public DeviceItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new DeviceItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2131492938, viewGroup, false));
    }

    public void onBindViewHolder(DeviceItemViewHolder deviceItemViewHolder, int i) {
        DeviceItem deviceItem = (DeviceItem) this.mList.get(i);
        if (!TextUtils.isEmpty(deviceItem.mName)) {
            deviceItemViewHolder.ctv_name.setText(deviceItem.mName);
        }
        if (deviceItem.mState == 2) {
            deviceItemViewHolder.ctv_name.setChecked(true);
            deviceItemViewHolder.iv_state.setVisibility(0);
            deviceItemViewHolder.tv_connecting.setVisibility(8);
        } else if (deviceItem.mState == 1) {
            deviceItemViewHolder.ctv_name.setChecked(false);
            deviceItemViewHolder.tv_connecting.setVisibility(0);
            deviceItemViewHolder.iv_state.setVisibility(8);
        } else {
            deviceItemViewHolder.ctv_name.setChecked(false);
            deviceItemViewHolder.tv_connecting.setVisibility(8);
            deviceItemViewHolder.iv_state.setVisibility(8);
        }
        deviceItemViewHolder.itemView.setOnClickListener(new 1(deviceItemViewHolder, i));
    }

    class 1 implements View.OnClickListener {
        final /* synthetic */ DeviceItemViewHolder val$holder;
        final /* synthetic */ int val$position;

        1(DeviceItemViewHolder deviceItemViewHolder, int i) {
            this.val$holder = deviceItemViewHolder;
            this.val$position = i;
        }

        public void onClick(View view) {
            DeviceItemRAdapter.access$000(DeviceItemRAdapter.this).onItemClick(this.val$holder.itemView, this.val$position);
        }
    }

    public int getItemCount() {
        return this.mList.size();
    }

    public class DeviceItemViewHolder extends RecyclerView.ViewHolder {
        public CheckedTextView ctv_name;
        public ImageView iv_state;
        public TextView tv_connecting;

        public DeviceItemViewHolder(View view) {
            super(view);
            this.ctv_name = view.findViewById(2131296430);
            this.tv_connecting = view.findViewById(2131296927);
            this.iv_state = view.findViewById(2131296561);
        }
    }

    class 2 implements OnItemClickListener {
        public void onItemClick(View view, int i) {
        }

        2() {
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mListener = onItemClickListener;
    }
}
