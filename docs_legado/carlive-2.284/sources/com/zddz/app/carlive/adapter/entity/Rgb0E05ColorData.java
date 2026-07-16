package com.zddz.app.carlive.adapter.entity;

import android.content.Context;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class Rgb0E05ColorData {
    Integer[] mColorIconDataAll = {2131231097, 2131231107, 2131231108, 2131231109, 2131231110, 2131231111, 2131231112, 2131231113, 2131231114, 2131231098, 2131231099, 2131231100, 2131231101, 2131231102, 2131231103, 2131231104, 2131231105, 2131231106};
    private final String[] mColorNameData;
    Context mContext;

    public Rgb0E05ColorData(Context context) {
        this.mContext = context;
        this.mColorNameData = new String[]{context.getResources().getString(2131755397), this.mContext.getResources().getString(2131755170), this.mContext.getResources().getString(2131755061), this.mContext.getResources().getString(2131755481), this.mContext.getResources().getString(2131755437), this.mContext.getResources().getString(2131755392), this.mContext.getResources().getString(2131755480), this.mContext.getResources().getString(2131755049), this.mContext.getResources().getString(2131755412), this.mContext.getResources().getString(2131755414), this.mContext.getResources().getString(2131755415), this.mContext.getResources().getString(2131755416), this.mContext.getResources().getString(2131755417), this.mContext.getResources().getString(2131755418), this.mContext.getResources().getString(2131755419), this.mContext.getResources().getString(2131755420), this.mContext.getResources().getString(2131755421), this.mContext.getResources().getString(2131755413)};
    }

    public ArrayList getDefaultColorList() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < 8) {
            Rgb0E05ColorItem rgb0E05ColorItem = new Rgb0E05ColorItem();
            rgb0E05ColorItem.setColorName(this.mColorNameData[i]);
            rgb0E05ColorItem.setColorIcon(this.mColorIconDataAll[i].intValue());
            i++;
            rgb0E05ColorItem.setColorIndex(i);
            arrayList.add(rgb0E05ColorItem);
        }
        return arrayList;
    }

    public ArrayList getAllColorList() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < 18) {
            Rgb0E05ColorItem rgb0E05ColorItem = new Rgb0E05ColorItem();
            rgb0E05ColorItem.setColorName(this.mColorNameData[i]);
            rgb0E05ColorItem.setColorIcon(this.mColorIconDataAll[i].intValue());
            i++;
            rgb0E05ColorItem.setColorIndex(i);
            rgb0E05ColorItem.setSelect(false);
            arrayList.add(rgb0E05ColorItem);
        }
        return arrayList;
    }
}
