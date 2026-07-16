package com.zddz.app.carlive.adapter;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.zddz.widget.VerticalSeekBar;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class WaveFilterRAdapter extends RecyclerView.Adapter {
    private int mFirstVisiblePosition = 0;
    private int mLastVisiblePosition = 5;
    private OnInnerItemListener mListener = new 4();
    private List mList = new ArrayList();

    public interface OnInnerItemListener {
        boolean OnEditorAction(WaveFilterItem waveFilterItem, TextView textView, int i, KeyEvent keyEvent);

        void onGainChanged(WaveFilterItem waveFilterItem);

        void onStopTrackingTouch(WaveFilterItem waveFilterItem, int i);
    }

    public long getItemId(int i) {
        return i;
    }

    static /* synthetic */ OnInnerItemListener access$000(WaveFilterRAdapter waveFilterRAdapter) {
        return waveFilterRAdapter.mListener;
    }

    public int getFirstVisiblePosition() {
        return this.mFirstVisiblePosition;
    }

    public void setFirstVisiblePosition(int i) {
        this.mFirstVisiblePosition = i;
    }

    public int getLastVisiblePosition() {
        return this.mLastVisiblePosition;
    }

    public void setLastVisiblePosition(int i) {
        this.mLastVisiblePosition = i;
    }

    public void updateItem(int i) {
        int i2 = this.mFirstVisiblePosition;
        if (i < i2 || i > this.mLastVisiblePosition) {
            return;
        }
        notifyItemRangeChanged(i2, 7);
    }

    public WaveFilterItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        WaveFilterItemViewHolder waveFilterItemViewHolder = new WaveFilterItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2131492941, viewGroup, false));
        waveFilterItemViewHolder.itemView.getLayoutParams().width = viewGroup.getMeasuredWidth() / 6;
        return waveFilterItemViewHolder;
    }

    public void onBindViewHolder(WaveFilterItemViewHolder waveFilterItemViewHolder, int i) {
        WaveFilterItem waveFilterItem = (WaveFilterItem) this.mList.get(i);
        waveFilterItemViewHolder.tv_number.setText(String.valueOf(waveFilterItem.mNumber + 1));
        waveFilterItemViewHolder.tv_frequency.setText(waveFilterItem.mFrequency);
        waveFilterItemViewHolder.et_q_value.setText(String.format("%.1f", new Object[]{Float.valueOf(waveFilterItem.mQValue / 10.0f)}));
        waveFilterItemViewHolder.tv_gain.setText(String.valueOf(waveFilterItem.mGain - 32));
        waveFilterItemViewHolder.et_q_value.setOnFocusChangeListener(new 1(waveFilterItemViewHolder, waveFilterItem));
        waveFilterItemViewHolder.et_q_value.setOnEditorActionListener(new 2(waveFilterItem));
        waveFilterItemViewHolder.vsb_gain.setOnChangedListener(new 3(waveFilterItem, waveFilterItemViewHolder));
        if (!waveFilterItem.mGainFromUser) {
            if (!waveFilterItem.mGainMove) {
                waveFilterItemViewHolder.vsb_gain.setProgress(waveFilterItem.mGain - 20);
            }
        } else if (!waveFilterItem.mGainMove) {
            waveFilterItem.mGainFromUser = false;
        }
        waveFilterItemViewHolder.itemView.setTag(waveFilterItem);
    }

    class 1 implements View.OnFocusChangeListener {
        final /* synthetic */ WaveFilterItemViewHolder val$holder;
        final /* synthetic */ WaveFilterItem val$tItem;

        1(WaveFilterItemViewHolder waveFilterItemViewHolder, WaveFilterItem waveFilterItem) {
            this.val$holder = waveFilterItemViewHolder;
            this.val$tItem = waveFilterItem;
        }

        public void onFocusChange(View view, boolean z) {
            this.val$holder.et_q_value.setText(String.format("%.1f", new Object[]{Float.valueOf(this.val$tItem.mQValue / 10.0f)}));
        }
    }

    class 2 implements TextView.OnEditorActionListener {
        final /* synthetic */ WaveFilterItem val$tItem;

        2(WaveFilterItem waveFilterItem) {
            this.val$tItem = waveFilterItem;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            return WaveFilterRAdapter.access$000(WaveFilterRAdapter.this).OnEditorAction(this.val$tItem, textView, i, keyEvent);
        }
    }

    class 3 implements VerticalSeekBar.OnChangedListener {
        final /* synthetic */ WaveFilterItemViewHolder val$holder;
        final /* synthetic */ WaveFilterItem val$tItem;

        3(WaveFilterItem waveFilterItem, WaveFilterItemViewHolder waveFilterItemViewHolder) {
            this.val$tItem = waveFilterItem;
            this.val$holder = waveFilterItemViewHolder;
        }

        public void onProgressChanged(VerticalSeekBar verticalSeekBar, boolean z) {
            this.val$tItem.mGainFromUser = z;
            this.val$holder.tv_gain.setText(String.valueOf(verticalSeekBar.getProgress() - 12));
            if (z) {
                this.val$tItem.mGain = verticalSeekBar.getProgress() + 20;
                WaveFilterRAdapter.access$000(WaveFilterRAdapter.this).onGainChanged(this.val$tItem);
            }
        }

        public void onStartTrackingTouch(VerticalSeekBar verticalSeekBar) {
            this.val$tItem.mGainMove = true;
        }

        public void onStopTrackingTouch(VerticalSeekBar verticalSeekBar) {
            this.val$tItem.mGainMove = false;
            WaveFilterRAdapter.access$000(WaveFilterRAdapter.this).onStopTrackingTouch(this.val$tItem, verticalSeekBar.getProgress());
        }
    }

    public void onViewAttachedToWindow(WaveFilterItemViewHolder waveFilterItemViewHolder) {
        if (waveFilterItemViewHolder.itemView.getTag() != null) {
            WaveFilterItem waveFilterItem = (WaveFilterItem) waveFilterItemViewHolder.itemView.getTag();
            waveFilterItemViewHolder.tv_number.setText(String.valueOf(waveFilterItem.mNumber + 1));
            waveFilterItemViewHolder.tv_frequency.setText(waveFilterItem.mFrequency);
            waveFilterItemViewHolder.et_q_value.setText(String.format("%.1f", new Object[]{Float.valueOf(waveFilterItem.mQValue / 10.0f)}));
            waveFilterItemViewHolder.tv_gain.setText(String.valueOf(waveFilterItem.mGain - 32));
            if (!waveFilterItem.mGainFromUser) {
                if (waveFilterItem.mGainMove) {
                    return;
                }
                waveFilterItemViewHolder.vsb_gain.setProgress(waveFilterItem.mGain - 20);
            } else {
                if (waveFilterItem.mGainMove) {
                    return;
                }
                waveFilterItem.mGainFromUser = false;
            }
        }
    }

    public int getItemCount() {
        return this.mList.size();
    }

    public static class WaveFilterItemViewHolder extends RecyclerView.ViewHolder {
        public EditText et_q_value;
        public TextView tv_frequency;
        public TextView tv_gain;
        public TextView tv_number;
        public VerticalSeekBar vsb_gain;

        public WaveFilterItemViewHolder(View view) {
            super(view);
            this.tv_number = view.findViewById(2131297008);
            this.tv_frequency = view.findViewById(2131296972);
            this.tv_gain = view.findViewById(2131296975);
            this.et_q_value = view.findViewById(2131296494);
            this.vsb_gain = (VerticalSeekBar) view.findViewById(2131297136);
        }

        public boolean isTouchNsv(float f, float f2) {
            int[] iArr = new int[2];
            this.vsb_gain.getLocationOnScreen(iArr);
            int measuredWidth = this.vsb_gain.getMeasuredWidth();
            int measuredHeight = this.vsb_gain.getMeasuredHeight();
            if (f < iArr[0] || f > r4 + measuredWidth) {
                return false;
            }
            int i = iArr[1];
            return f2 >= ((float) i) && f2 <= ((float) (i + measuredHeight));
        }
    }

    class 4 implements OnInnerItemListener {
        public boolean OnEditorAction(WaveFilterItem waveFilterItem, TextView textView, int i, KeyEvent keyEvent) {
            return false;
        }

        public void onGainChanged(WaveFilterItem waveFilterItem) {
        }

        public void onStopTrackingTouch(WaveFilterItem waveFilterItem, int i) {
        }

        4() {
        }
    }

    public void setListener(OnInnerItemListener onInnerItemListener) {
        this.mListener = onInnerItemListener;
    }

    public void setList(List list) {
        this.mList = list;
        notifyDataSetChanged();
        this.mFirstVisiblePosition = 0;
        this.mLastVisiblePosition = 5;
    }

    public List getList() {
        return this.mList;
    }

    public void updateItem(int i, int i2, int i3) {
        for (int i4 = 0; i4 < this.mList.size(); i4++) {
            WaveFilterItem waveFilterItem = (WaveFilterItem) this.mList.get(i4);
            if (waveFilterItem.mNumber == i) {
                waveFilterItem.mQValue = i2;
                waveFilterItem.mGain = i3;
                updateItem(i4);
                return;
            }
        }
    }

    public void updateItem(int i, int i2) {
        for (int i3 = 0; i3 < this.mList.size(); i3++) {
            WaveFilterItem waveFilterItem = (WaveFilterItem) this.mList.get(i3);
            if (waveFilterItem.mNumber == i) {
                waveFilterItem.mFrequency = String.valueOf(i2);
                updateItem(i3);
                return;
            }
        }
    }

    public void reset() {
        for (WaveFilterItem waveFilterItem : this.mList) {
            waveFilterItem.mQValue = 12;
            waveFilterItem.mGain = 32;
        }
        notifyDataSetChanged();
    }
}
