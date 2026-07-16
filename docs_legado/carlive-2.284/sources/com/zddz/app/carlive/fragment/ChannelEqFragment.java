package com.zddz.app.carlive.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.zddz.app.carlive.OrderSet;
import com.zddz.app.carlive.adapter.WaveFilterItem;
import com.zddz.app.carlive.adapter.WaveFilterRAdapter;
import com.zddz.app.carlive.database.WaveFilterRecord;
import com.zddz.bt.Convert;
import com.zddz.ui.LeftSnapHelper;
import com.zddz.widget.ScrollLinearLayoutManager;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.litepal.LitePal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class ChannelEqFragment extends BaseFragment {
    private float mEndX = 0.0f;
    private Handler mHandler;
    private ScrollLinearLayoutManager mLayoutManager;
    private WaveFilterRAdapter mWaveFilterRAdapter;
    private RecyclerView rv_wave_filter;
    private View view_move;

    static /* synthetic */ ScrollLinearLayoutManager access$000(ChannelEqFragment channelEqFragment) {
        return channelEqFragment.mLayoutManager;
    }

    static /* synthetic */ WaveFilterRAdapter access$100(ChannelEqFragment channelEqFragment) {
        return channelEqFragment.mWaveFilterRAdapter;
    }

    static /* synthetic */ RecyclerView access$200(ChannelEqFragment channelEqFragment) {
        return channelEqFragment.rv_wave_filter;
    }

    static /* synthetic */ float access$300(ChannelEqFragment channelEqFragment) {
        return channelEqFragment.mEndX;
    }

    static /* synthetic */ float access$316(ChannelEqFragment channelEqFragment, float f) {
        float f2 = channelEqFragment.mEndX + f;
        channelEqFragment.mEndX = f2;
        return f2;
    }

    static /* synthetic */ View access$400(ChannelEqFragment channelEqFragment) {
        return channelEqFragment.view_move;
    }

    static /* synthetic */ Handler access$500(ChannelEqFragment channelEqFragment) {
        return channelEqFragment.mHandler;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(2131492933, viewGroup, false);
            this.view_move = this.mRootView.findViewById(2131297125);
            this.mHandler = new Handler(Looper.myLooper());
            this.rv_wave_filter = this.mRootView.findViewById(2131296747);
            new LeftSnapHelper().attachToRecyclerView(this.rv_wave_filter);
            ScrollLinearLayoutManager scrollLinearLayoutManager = new ScrollLinearLayoutManager(getContext());
            this.mLayoutManager = scrollLinearLayoutManager;
            scrollLinearLayoutManager.setOrientation(0);
            this.rv_wave_filter.setLayoutManager(this.mLayoutManager);
            this.rv_wave_filter.addOnScrollListener(new 1());
            this.rv_wave_filter.addOnItemTouchListener(new 2());
            RecyclerView.ItemAnimator itemAnimator = this.rv_wave_filter.getItemAnimator();
            if (itemAnimator != null) {
                ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            }
            WaveFilterRAdapter waveFilterRAdapter = new WaveFilterRAdapter();
            this.mWaveFilterRAdapter = waveFilterRAdapter;
            waveFilterRAdapter.setListener(new 3());
            this.mWaveFilterRAdapter.setHasStableIds(true);
            List find = LitePal.limit(20).find(WaveFilterRecord.class);
            if (find.size() == 20) {
                Iterator it = find.iterator();
                while (it.hasNext()) {
                    this.mWaveFilterRAdapter.getList().add(new WaveFilterItem((WaveFilterRecord) it.next()));
                }
            } else {
                for (int i = 0; i < 20; i++) {
                    WaveFilterRecord waveFilterRecord = new WaveFilterRecord(i);
                    WaveFilterItem waveFilterItem = new WaveFilterItem(waveFilterRecord);
                    waveFilterRecord.save();
                    this.mWaveFilterRAdapter.getList().add(waveFilterItem);
                }
            }
            this.mWaveFilterRAdapter.notifyDataSetChanged();
            this.rv_wave_filter.setAdapter(this.mWaveFilterRAdapter);
        }
        ViewGroup parent = this.mRootView.getParent();
        if (parent != null) {
            parent.removeView(this.mRootView);
        }
        return this.mRootView;
    }

    class 1 extends RecyclerView.OnScrollListener {
        1() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0) {
                int findFirstVisibleItemPosition = ChannelEqFragment.access$000(ChannelEqFragment.this).findFirstVisibleItemPosition();
                int findLastVisibleItemPosition = ChannelEqFragment.access$000(ChannelEqFragment.this).findLastVisibleItemPosition();
                View findViewByPosition = ChannelEqFragment.access$000(ChannelEqFragment.this).findViewByPosition(findFirstVisibleItemPosition);
                View findViewByPosition2 = ChannelEqFragment.access$000(ChannelEqFragment.this).findViewByPosition(findLastVisibleItemPosition);
                if (findViewByPosition != null) {
                    ChannelEqFragment.access$100(ChannelEqFragment.this).setFirstVisiblePosition(((WaveFilterItem) new WaveFilterRAdapter.WaveFilterItemViewHolder(findViewByPosition).itemView.getTag()).mNumber);
                }
                if (findViewByPosition2 != null) {
                    ChannelEqFragment.access$100(ChannelEqFragment.this).setLastVisiblePosition(((WaveFilterItem) new WaveFilterRAdapter.WaveFilterItemViewHolder(findViewByPosition2).itemView.getTag()).mNumber);
                }
            }
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            int computeHorizontalScrollRange = ChannelEqFragment.access$200(ChannelEqFragment.this).computeHorizontalScrollRange() - ChannelEqFragment.access$200(ChannelEqFragment.this).getMeasuredWidth();
            ChannelEqFragment.access$316(ChannelEqFragment.this, i);
            ChannelEqFragment.access$400(ChannelEqFragment.this).setTranslationX((ChannelEqFragment.access$400(ChannelEqFragment.this).getParent().getWidth() - ChannelEqFragment.access$400(ChannelEqFragment.this).getWidth()) * (ChannelEqFragment.access$300(ChannelEqFragment.this) / computeHorizontalScrollRange));
        }
    }

    class 2 implements RecyclerView.OnItemTouchListener {
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
        }

        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        }

        2() {
        }

        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            View findChildViewUnder;
            if (motionEvent != null && (findChildViewUnder = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY())) != null) {
                boolean isTouchNsv = ((WaveFilterRAdapter.WaveFilterItemViewHolder) recyclerView.getChildViewHolder(findChildViewUnder)).isTouchNsv(motionEvent.getRawX(), motionEvent.getRawY());
                recyclerView.requestDisallowInterceptTouchEvent(isTouchNsv);
                if (isTouchNsv) {
                    ChannelEqFragment.access$000(ChannelEqFragment.this).setCanHorizontalScroll(false);
                } else {
                    ChannelEqFragment.access$000(ChannelEqFragment.this).setCanHorizontalScroll(true);
                }
            }
            return false;
        }
    }

    class 3 implements WaveFilterRAdapter.OnInnerItemListener {
        3() {
        }

        public void onGainChanged(WaveFilterItem waveFilterItem) {
            byte[] bArr = OrderSet.write_twenty_wave_filter_number_q_gain;
            bArr[3] = (byte) waveFilterItem.mNumber;
            bArr[4] = (byte) waveFilterItem.mQValue;
            bArr[5] = (byte) waveFilterItem.mGain;
            ChannelEqFragment.this.mIMain.addWriteData(bArr, 200L);
        }

        class 1 implements Runnable {
            final /* synthetic */ WaveFilterItem val$pItem;
            final /* synthetic */ int val$pProgress;

            1(WaveFilterItem waveFilterItem, int i) {
                this.val$pItem = waveFilterItem;
                this.val$pProgress = i;
            }

            public void run() {
                this.val$pItem.mGainFromUser = false;
                byte[] bArr = OrderSet.write_twenty_wave_filter_number_q_gain;
                bArr[3] = (byte) this.val$pItem.mNumber;
                bArr[4] = (byte) this.val$pItem.mQValue;
                bArr[5] = (byte) (this.val$pProgress + 20);
                ChannelEqFragment.this.mIMain.writeData(bArr);
            }
        }

        public void onStopTrackingTouch(WaveFilterItem waveFilterItem, int i) {
            ChannelEqFragment.this.mIMain.clearWriteData();
            ChannelEqFragment.access$500(ChannelEqFragment.this).postDelayed(new 1(waveFilterItem, i), 200L);
        }

        public boolean OnEditorAction(WaveFilterItem waveFilterItem, TextView textView, int i, KeyEvent keyEvent) {
            if (i != 6 && i != 3 && (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 66)) {
                return false;
            }
            try {
                int parseFloat = (int) (Float.parseFloat(textView.getText().toString()) * 10.0f);
                if (parseFloat > 120) {
                    parseFloat = 120;
                } else if (parseFloat < 1) {
                    parseFloat = 1;
                }
                byte[] bArr = OrderSet.write_twenty_wave_filter_number_q_gain;
                bArr[3] = (byte) waveFilterItem.mNumber;
                bArr[4] = (byte) parseFloat;
                bArr[5] = (byte) waveFilterItem.mGain;
                ChannelEqFragment.this.mIMain.writeData(bArr);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    public void notice(String str, UUID uuid, byte[] bArr) {
        super.notice(str, uuid, bArr);
        try {
            String upperCase = Convert.bytesToHexString(bArr).toUpperCase();
            if (upperCase.startsWith(OrderSet.notice_twenty_wave_filter_number_q_gain) && upperCase.length() >= 12) {
                this.mWaveFilterRAdapter.updateItem(Integer.parseInt(upperCase.substring(6, 8), 16), Integer.parseInt(upperCase.substring(8, 10), 16), Integer.parseInt(upperCase.substring(10, 12), 16));
                return;
            }
            if (upperCase.startsWith(OrderSet.notice_twenty_wave_filter_frequency)) {
                int parseInt = Integer.parseInt(upperCase.substring(4, 6), 16);
                int parseInt2 = Integer.parseInt(upperCase.substring(6, 8), 16);
                int i = 0;
                for (int i2 = (parseInt - 1) * 8; i < 8 && i2 < parseInt2; i2++) {
                    int i3 = i * 4;
                    this.mWaveFilterRAdapter.updateItem(i2, Integer.valueOf(upperCase.substring(i3 + 8, i3 + 12), 16).intValue());
                    i++;
                }
                return;
            }
            if (upperCase.startsWith(OrderSet.notice_channel_reset)) {
                this.mWaveFilterRAdapter.reset();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
