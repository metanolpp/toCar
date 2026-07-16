package com.zddz.app.carlive.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.zddz.location.CoordinateUtil;
import com.zddz.location.LatLng;
import com.zddz.location.LocationHelper;
import com.zddz.permission.PermissionSp;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class MapDialog extends AlertDialog {
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private TextView tv_prompt;

    class 1 implements View.OnClickListener {
        1() {
        }

        public void onClick(View view) {
            String string = MapDialog.this.getContext().getString(2131755083);
            PermissionSp permissionSp = PermissionSp.getInstance(MapDialog.this.getContext());
            LatLng latLng = new LatLng(permissionSp.getLatitude(), permissionSp.getLongitude());
            int id = view.getId();
            if (id == 2131297047) {
                LatLng transformFromWGSToGCJ = CoordinateUtil.transformFromWGSToGCJ(latLng);
                LocationHelper.skipTencentMap(MapDialog.this.getContext(), string, transformFromWGSToGCJ.longitude, transformFromWGSToGCJ.latitude);
                MapDialog.this.dismiss();
                return;
            }
            if (id == 2131296985) {
                LatLng transformFromWGSToGCJ2 = CoordinateUtil.transformFromWGSToGCJ(latLng);
                LocationHelper.skipGaudMap(MapDialog.this.getContext(), string, transformFromWGSToGCJ2.longitude, transformFromWGSToGCJ2.latitude);
                MapDialog.this.dismiss();
            } else if (id == 2131296901) {
                LatLng transformFromGCJ02ToBD09 = CoordinateUtil.transformFromGCJ02ToBD09(CoordinateUtil.transformFromWGSToGCJ(latLng));
                LocationHelper.skipBaiduMap(MapDialog.this.getContext(), string, transformFromGCJ02ToBD09.longitude, transformFromGCJ02ToBD09.latitude);
                MapDialog.this.dismiss();
            } else if (id == 2131296986) {
                LatLng transformFromWGSToGCJ3 = CoordinateUtil.transformFromWGSToGCJ(latLng);
                LocationHelper.skipGoogleMap(MapDialog.this.getContext(), string, transformFromWGSToGCJ3.longitude, transformFromWGSToGCJ3.latitude);
                MapDialog.this.dismiss();
            } else if (id == 2131296914) {
                MapDialog.this.dismiss();
            }
        }
    }

    public MapDialog(Context context) {
        super(context);
        this.mOnClickListener = new 1();
        View inflate = LayoutInflater.from(context).inflate(2131492922, (ViewGroup) null);
        this.mRootView = inflate;
        this.tv_prompt = inflate.findViewById(2131297023);
        TextView findViewById = this.mRootView.findViewById(2131297047);
        TextView findViewById2 = this.mRootView.findViewById(2131296985);
        TextView findViewById3 = this.mRootView.findViewById(2131296901);
        TextView findViewById4 = this.mRootView.findViewById(2131296986);
        findViewById.setOnClickListener(this.mOnClickListener);
        findViewById2.setOnClickListener(this.mOnClickListener);
        findViewById3.setOnClickListener(this.mOnClickListener);
        findViewById4.setOnClickListener(this.mOnClickListener);
        if (LocationHelper.isAppInstalled(getContext(), "com.tencent.map")) {
            findViewById.setVisibility(0);
            findViewById.setEnabled(true);
            this.tv_prompt.setVisibility(8);
        } else {
            findViewById.setVisibility(8);
            findViewById.setEnabled(false);
        }
        if (LocationHelper.isAppInstalled(getContext(), "com.autonavi.minimap")) {
            findViewById2.setVisibility(0);
            findViewById2.setEnabled(true);
            this.tv_prompt.setVisibility(8);
        } else {
            findViewById2.setVisibility(8);
            findViewById2.setEnabled(false);
        }
        if (LocationHelper.isAppInstalled(getContext(), "com.baidu.BaiduMap")) {
            findViewById3.setVisibility(0);
            findViewById3.setEnabled(true);
            this.tv_prompt.setVisibility(8);
        } else {
            findViewById3.setVisibility(8);
            findViewById3.setEnabled(false);
        }
        if (LocationHelper.isAppInstalled(getContext(), "com.google.android.apps.maps")) {
            findViewById4.setVisibility(0);
            findViewById4.setEnabled(true);
            this.tv_prompt.setVisibility(8);
        } else {
            findViewById4.setVisibility(8);
            findViewById4.setEnabled(false);
        }
        if (findViewById.getVisibility() != 0 && findViewById2.getVisibility() != 0 && findViewById3.getVisibility() != 0 && findViewById4.getVisibility() != 0) {
            this.tv_prompt.setVisibility(0);
            findViewById.setVisibility(0);
            findViewById2.setVisibility(0);
            findViewById3.setVisibility(0);
            findViewById4.setVisibility(0);
        }
        this.mRootView.findViewById(2131296914).setOnClickListener(this.mOnClickListener);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.mRootView);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-1, -2);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.0f;
            attributes.gravity = 80;
            window.setAttributes(attributes);
        }
    }
}
