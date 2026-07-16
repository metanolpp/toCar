package com.zddz.app.carlive.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.zddz.app.carlive.dialog.MapDialog;
import com.zddz.crash.CrashBaseActivity;
import com.zddz.permission.PermissionSp;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class FindCarActivity extends CrashBaseActivity {
    private View.OnClickListener mOnClickListener = new 1();
    private PermissionSp mPermissionSp;

    static /* synthetic */ PermissionSp access$000(FindCarActivity findCarActivity) {
        return findCarActivity.mPermissionSp;
    }

    class 1 implements View.OnClickListener {
        1() {
        }

        public void onClick(View view) {
            int id = view.getId();
            if (id == 2131296358) {
                FindCarActivity.this.finish();
            } else if (id == 2131296360) {
                if (FindCarActivity.access$000(FindCarActivity.this).getLatitude() != 0.0d && FindCarActivity.access$000(FindCarActivity.this).getLongitude() != 0.0d) {
                    new MapDialog(FindCarActivity.this).show();
                }
                FindCarActivity.this.finish();
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131492893);
        this.mPermissionSp = PermissionSp.getInstance(this);
        TextView findViewById = findViewById(2131296995);
        findViewById(2131296358).setOnClickListener(this.mOnClickListener);
        TextView findViewById2 = findViewById(2131296360);
        findViewById2.setOnClickListener(this.mOnClickListener);
        if (this.mPermissionSp.getLatitude() == 0.0d || this.mPermissionSp.getLongitude() == 0.0d) {
            findViewById.setText(2131755084);
            findViewById2.setEnabled(false);
        } else {
            findViewById.setText(2131755085);
            findViewById2.setEnabled(true);
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(2130771997, 0);
    }
}
