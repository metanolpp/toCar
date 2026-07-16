package com.zddz.app.carlive.dialog.compoments;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RgbBaseList.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t\u001a=\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u00112\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0003¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"ColorSelectionDialog", "", "lightTypeLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "onColorSelected", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/lifecycle/MutableLiveData;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ColorOptionItem", "iconRes", "", "isSelected", "", "textRes", "onClick", "Lkotlin/Function0;", "(IZILkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "app_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class RgbBaseListKt {
    public static /* synthetic */ Unit $r8$lambda$-NieX9CDxL2g7siPiSmaysMtZl0(Function1 function1) {
        return ColorSelectionDialog$lambda$20$lambda$19$lambda$12$lambda$11(function1);
    }

    public static /* synthetic */ Unit $r8$lambda$AEw_kwTXd3hFoWQOsokkIlBAmmI(Function1 function1) {
        return ColorSelectionDialog$lambda$20$lambda$19$lambda$18$lambda$17(function1);
    }

    public static /* synthetic */ Unit $r8$lambda$HOtxYnE6JJ1So-flroFH-9_lyow(Function1 function1) {
        return ColorSelectionDialog$lambda$20$lambda$19$lambda$16$lambda$15(function1);
    }

    public static /* synthetic */ Unit $r8$lambda$UIHPE7JFCiwWvRD25Vyvvrs6oiI(int i, boolean z, int i2, Function0 function0, Modifier modifier, int i3, int i4, Composer composer, int i5) {
        return ColorOptionItem$lambda$24(i, z, i2, function0, modifier, i3, i4, composer, i5);
    }

    public static /* synthetic */ Unit $r8$lambda$US_Kcaw7fHAYFCUGg_2nBHxJM5Y(Function1 function1) {
        return ColorSelectionDialog$lambda$20$lambda$10$lambda$7$lambda$6(function1);
    }

    public static /* synthetic */ Unit $r8$lambda$W_coL73_qhkFKrX-O5ONxjB0SDQ(MutableLiveData mutableLiveData, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        return ColorSelectionDialog$lambda$21(mutableLiveData, function1, modifier, i, i2, composer, i3);
    }

    public static /* synthetic */ Unit $r8$lambda$Xrrpjt2cqKuucAjkUxdSv0nMsO4(String str) {
        return ColorSelectionDialog$lambda$1$lambda$0(str);
    }

    public static /* synthetic */ Unit $r8$lambda$XtgV1Du8jldlg1ytf_d6ylI3e4A(Function1 function1) {
        return ColorSelectionDialog$lambda$20$lambda$10$lambda$5$lambda$4(function1);
    }

    public static /* synthetic */ Unit $r8$lambda$djRUnhuvRyPm4QLbBTTtH-ucvYs(Function1 function1) {
        return ColorSelectionDialog$lambda$20$lambda$19$lambda$14$lambda$13(function1);
    }

    public static /* synthetic */ Unit $r8$lambda$m27OorDkfb0n7oYvUgJp05Jkbdc(Function1 function1) {
        return ColorSelectionDialog$lambda$20$lambda$10$lambda$3$lambda$2(function1);
    }

    public static /* synthetic */ Unit $r8$lambda$qqPLeDWdpjPc-JeKZGOlNRPFILw(Function1 function1) {
        return ColorSelectionDialog$lambda$20$lambda$10$lambda$9$lambda$8(function1);
    }

    private static final Unit ColorOptionItem$lambda$24(int i, boolean z, int i2, Function0 function0, Modifier modifier, int i3, int i4, Composer composer, int i5) {
        ColorOptionItem(i, z, i2, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    private static final Unit ColorSelectionDialog$lambda$21(MutableLiveData mutableLiveData, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ColorSelectionDialog(mutableLiveData, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private static final Unit ColorSelectionDialog$lambda$1$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x049d  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x04db  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0519  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x056b  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x052a  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x051b  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x04ec  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x04dd  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x04ae  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x046e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0575  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x03e7  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x045d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void ColorSelectionDialog(androidx.lifecycle.MutableLiveData r26, kotlin.jvm.functions.Function1 r27, androidx.compose.ui.Modifier r28, androidx.compose.runtime.Composer r29, int r30, int r31) {
        /*
            Method dump skipped, instructions count: 1414
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zddz.app.carlive.dialog.compoments.RgbBaseListKt.ColorSelectionDialog(androidx.lifecycle.MutableLiveData, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final Unit ColorSelectionDialog$lambda$20$lambda$10$lambda$3$lambda$2(Function1 function1) {
        function1.invoke("red");
        return Unit.INSTANCE;
    }

    private static final Unit ColorSelectionDialog$lambda$20$lambda$10$lambda$5$lambda$4(Function1 function1) {
        function1.invoke("green");
        return Unit.INSTANCE;
    }

    private static final Unit ColorSelectionDialog$lambda$20$lambda$10$lambda$7$lambda$6(Function1 function1) {
        function1.invoke("blue");
        return Unit.INSTANCE;
    }

    private static final Unit ColorSelectionDialog$lambda$20$lambda$10$lambda$9$lambda$8(Function1 function1) {
        function1.invoke("yellow");
        return Unit.INSTANCE;
    }

    private static final Unit ColorSelectionDialog$lambda$20$lambda$19$lambda$12$lambda$11(Function1 function1) {
        function1.invoke("sky");
        return Unit.INSTANCE;
    }

    private static final Unit ColorSelectionDialog$lambda$20$lambda$19$lambda$14$lambda$13(Function1 function1) {
        function1.invoke("purple");
        return Unit.INSTANCE;
    }

    private static final Unit ColorSelectionDialog$lambda$20$lambda$19$lambda$16$lambda$15(Function1 function1) {
        function1.invoke("white");
        return Unit.INSTANCE;
    }

    private static final Unit ColorSelectionDialog$lambda$20$lambda$19$lambda$18$lambda$17(Function1 function1) {
        function1.invoke("auto");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void ColorOptionItem(int r33, boolean r34, int r35, kotlin.jvm.functions.Function0 r36, androidx.compose.ui.Modifier r37, androidx.compose.runtime.Composer r38, int r39, int r40) {
        /*
            Method dump skipped, instructions count: 635
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zddz.app.carlive.dialog.compoments.RgbBaseListKt.ColorOptionItem(int, boolean, int, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }
}
