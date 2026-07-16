package com.zddz.app.carlive.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zddz.app.carlive.OrderSet;
import com.zddz.app.carlive.adapter.ColorRgbLiBangAdapter;
import com.zddz.app.carlive.databinding.DialogLbRgbBinding;
import com.zddz.app.carlive.dialog.compoments.RgbBaseListKt;
import com.zddz.app.carlive.fragment.BaseDialog;
import com.zddz.bt.Convert;
import com.zddz.ui.RgbDataProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: RgbLBDialog.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010%\u001a\u00020#H\u0002J\b\u0010&\u001a\u00020#H\u0002J\r\u0010'\u001a\u00020#H\u0003¢\u0006\u0002\u0010(J\r\u0010)\u001a\u00020#H\u0003¢\u0006\u0002\u0010(J\b\u0010*\u001a\u00020#H\u0002J\u0010\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\nH\u0002J\b\u0010-\u001a\u00020#H\u0002J\u0010\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u00020\nH\u0002J\u0010\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020\nH\u0002J\b\u00102\u001a\u00020#H\u0016J&\u00103\u001a\u00020#2\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0010\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020\nH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/zddz/app/carlive/dialog/RgbLBDialog;", "Lcom/zddz/app/carlive/fragment/BaseDialog;", "<init>", "()V", "_binding", "Lcom/zddz/app/carlive/databinding/DialogLbRgbBinding;", "binding", "getBinding", "()Lcom/zddz/app/carlive/databinding/DialogLbRgbBinding;", "S_LED", "", "DY_LED", "COLOR_RED", "COLOR_GREEN", "COLOR_BLUE", "COLOR_YELLOW", "COLOR_CYAN", "COLOR_ZISE", "COLOR_WHITE", "COLOR_AUTO", "_rgbType", "mDevList", "", "Lcom/zddz/ui/RgbLiBandItem;", "mRgbLBAdapter", "Lcom/zddz/app/carlive/adapter/ColorRgbLiBangAdapter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initData", "initView", "shoRgbList", "(Landroidx/compose/runtime/Composer;I)V", "addBackBt", "onBack", "handleBaseColorClick", "colorType", "initRlContent", "handleRgbItemClick", "position", "handClickMenu", "click", "onDestroyView", "notice", "pAddress", "", "pNotice", "Ljava/util/UUID;", "pData", "", "refreshLight", "lightNormal", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class RgbLBDialog extends BaseDialog {
    public static final int $stable = 8;
    private final int COLOR_RED;
    private final int S_LED;
    private DialogLbRgbBinding _binding;
    private int _rgbType;
    private ColorRgbLiBangAdapter mRgbLBAdapter;
    private final int DY_LED = 1;
    private final int COLOR_GREEN = 1;
    private final int COLOR_BLUE = 2;
    private final int COLOR_YELLOW = 3;
    private final int COLOR_CYAN = 4;
    private final int COLOR_ZISE = 5;
    private final int COLOR_WHITE = 6;
    private final int COLOR_AUTO = 7;
    private List mDevList = new ArrayList();

    public static /* synthetic */ void $r8$lambda$-3aZxzmWLPo6E4l6vIPxVOVS1ps(RgbLBDialog rgbLBDialog, View view) {
        initView$lambda$10(rgbLBDialog, view);
    }

    public static /* synthetic */ Unit $r8$lambda$-s2mSz0GjNEr7VEsN5fmA9blf6I(RgbLBDialog rgbLBDialog, int i, Composer composer, int i2) {
        return shoRgbList$lambda$15(rgbLBDialog, i, composer, i2);
    }

    public static /* synthetic */ void $r8$lambda$2nR0d__77QJ9mCp_SKcLQWtFnSY(RgbLBDialog rgbLBDialog, View view) {
        initView$lambda$11(rgbLBDialog, view);
    }

    public static /* synthetic */ void $r8$lambda$6TfBAr2xa0F_T9VsUxfV7fyxuuc(RgbLBDialog rgbLBDialog, View view) {
        initView$lambda$3(rgbLBDialog, view);
    }

    public static /* synthetic */ Unit $r8$lambda$70GqZpwsV25yh-Yn10d9VKbFLkg(RgbLBDialog rgbLBDialog, int i, Composer composer, int i2) {
        return addBackBt$lambda$18(rgbLBDialog, i, composer, i2);
    }

    public static /* synthetic */ void $r8$lambda$9X_ySzz3gom02pqmBNbncMfqL4g(RgbLBDialog rgbLBDialog, View view) {
        initView$lambda$4(rgbLBDialog, view);
    }

    public static /* synthetic */ void $r8$lambda$9cqW9F1jzlrruLjOBVFmuuQUTZk(RgbLBDialog rgbLBDialog, View view) {
        initView$lambda$2(rgbLBDialog, view);
    }

    public static /* synthetic */ void $r8$lambda$Gt6wFRoSnQ3tAB29OvmbzKS2MMs(RgbLBDialog rgbLBDialog, View view) {
        initView$lambda$1(rgbLBDialog, view);
    }

    public static /* synthetic */ void $r8$lambda$Iio40klAosa9YI7rFxr7g61iPT8(RgbLBDialog rgbLBDialog, View view) {
        initView$lambda$7(rgbLBDialog, view);
    }

    public static /* synthetic */ void $r8$lambda$WJdce5zOVpeI06hBgOkuhm2KQrE(RgbLBDialog rgbLBDialog, View view) {
        initView$lambda$9(rgbLBDialog, view);
    }

    public static /* synthetic */ void $r8$lambda$Y8gJFKNjVoWttH11bQJx1Ko2bQk(RgbLBDialog rgbLBDialog, View view, int i) {
        initRlContent$lambda$20(rgbLBDialog, view, i);
    }

    public static /* synthetic */ void $r8$lambda$diI2KcnRLIiHpIVv1btLSrCulCo(RgbLBDialog rgbLBDialog, View view) {
        initView$lambda$5(rgbLBDialog, view);
    }

    public static /* synthetic */ void $r8$lambda$eNcrv5E6Zt479f5EaWj9BIG2R1M(RgbLBDialog rgbLBDialog, View view) {
        initView$lambda$6(rgbLBDialog, view);
    }

    public static /* synthetic */ Unit $r8$lambda$f021NGVGW4PTZHBvL00sISdJBP0(RgbLBDialog rgbLBDialog, String str) {
        return shoRgbList$lambda$14$lambda$13$lambda$12(rgbLBDialog, str);
    }

    public static /* synthetic */ Unit $r8$lambda$l1wEvw6Ge32yoOGx2LKWkDc4NsY(RgbLBDialog rgbLBDialog, Integer num) {
        return initData$lambda$0(rgbLBDialog, num);
    }

    public static /* synthetic */ void $r8$lambda$lhWJnK-NR-M7UcilV1YKPtA7p3E(RgbLBDialog rgbLBDialog, View view) {
        initView$lambda$8(rgbLBDialog, view);
    }

    public static /* synthetic */ Unit $r8$lambda$xnStjN9sS7pTvpLWULiqXQa-NEM(RgbLBDialog rgbLBDialog) {
        return addBackBt$lambda$17$lambda$16(rgbLBDialog);
    }

    private static final Unit addBackBt$lambda$18(RgbLBDialog rgbLBDialog, int i, Composer composer, int i2) {
        rgbLBDialog.addBackBt(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private static final Unit shoRgbList$lambda$15(RgbLBDialog rgbLBDialog, int i, Composer composer, int i2) {
        rgbLBDialog.shoRgbList(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void access$addBackBt(RgbLBDialog rgbLBDialog, Composer composer, int i) {
        rgbLBDialog.addBackBt(composer, i);
    }

    public static final /* synthetic */ void access$shoRgbList(RgbLBDialog rgbLBDialog, Composer composer, int i) {
        rgbLBDialog.shoRgbList(composer, i);
    }

    private final DialogLbRgbBinding getBinding() {
        DialogLbRgbBinding dialogLbRgbBinding = this._binding;
        Intrinsics.checkNotNull(dialogLbRgbBinding);
        return dialogLbRgbBinding;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogLbRgbBinding.inflate(inflater, container, false);
        return getBinding().getRoot();
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
    }

    private final void initData() {
        this.mBaseViewModel.liBangRgbValue.observe(getViewLifecycleOwner(), new RgbLBDialog$sam$androidx_lifecycle_Observer$0(new RgbLBDialog$$ExternalSyntheticLambda8(this)));
    }

    private static final Unit initData$lambda$0(RgbLBDialog rgbLBDialog, Integer num) {
        ColorRgbLiBangAdapter colorRgbLiBangAdapter = rgbLBDialog.mRgbLBAdapter;
        if (colorRgbLiBangAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRgbLBAdapter");
            colorRgbLiBangAdapter = null;
        }
        Intrinsics.checkNotNull(num);
        colorRgbLiBangAdapter.setSelectedPosition(num.intValue());
        return Unit.INSTANCE;
    }

    private final void initView() {
        getBinding().tvRed.setOnClickListener(new RgbLBDialog$$ExternalSyntheticLambda13(this));
        getBinding().tvGreen.setOnClickListener(new RgbLBDialog$$ExternalSyntheticLambda15(this));
        getBinding().tvBlue.setOnClickListener(new RgbLBDialog$$ExternalSyntheticLambda16(this));
        getBinding().tvYellow.setOnClickListener(new RgbLBDialog$$ExternalSyntheticLambda1(this));
        getBinding().tvSky.setOnClickListener(new RgbLBDialog$$ExternalSyntheticLambda2(this));
        getBinding().tvMagenta.setOnClickListener(new RgbLBDialog$$ExternalSyntheticLambda3(this));
        getBinding().tvWhite.setOnClickListener(new RgbLBDialog$$ExternalSyntheticLambda4(this));
        getBinding().tvAuto.setOnClickListener(new RgbLBDialog$$ExternalSyntheticLambda5(this));
        getBinding().comviewBack.setContent(ComposableLambdaKt.composableLambdaInstance(753558829, true, new 9()));
        getBinding().comviewList.setContent(ComposableLambdaKt.composableLambdaInstance(-725337450, true, new 10()));
        getBinding().llCloseZone.setOnClickListener(new RgbLBDialog$$ExternalSyntheticLambda6(this));
        getBinding().tvRgb0e05TitleOne.setOnClickListener(new RgbLBDialog$$ExternalSyntheticLambda7(this));
        getBinding().tvRgb0e05TitleTwo.setOnClickListener(new RgbLBDialog$$ExternalSyntheticLambda14(this));
        initRlContent();
    }

    private static final void initView$lambda$1(RgbLBDialog rgbLBDialog, View view) {
        rgbLBDialog.handleBaseColorClick(rgbLBDialog.COLOR_RED);
    }

    private static final void initView$lambda$2(RgbLBDialog rgbLBDialog, View view) {
        rgbLBDialog.handleBaseColorClick(rgbLBDialog.COLOR_GREEN);
    }

    private static final void initView$lambda$3(RgbLBDialog rgbLBDialog, View view) {
        rgbLBDialog.handleBaseColorClick(rgbLBDialog.COLOR_BLUE);
    }

    private static final void initView$lambda$4(RgbLBDialog rgbLBDialog, View view) {
        rgbLBDialog.handleBaseColorClick(rgbLBDialog.COLOR_YELLOW);
    }

    private static final void initView$lambda$5(RgbLBDialog rgbLBDialog, View view) {
        rgbLBDialog.handleBaseColorClick(rgbLBDialog.COLOR_CYAN);
    }

    private static final void initView$lambda$6(RgbLBDialog rgbLBDialog, View view) {
        rgbLBDialog.handleBaseColorClick(rgbLBDialog.COLOR_ZISE);
    }

    private static final void initView$lambda$7(RgbLBDialog rgbLBDialog, View view) {
        rgbLBDialog.handleBaseColorClick(rgbLBDialog.COLOR_WHITE);
    }

    /* compiled from: RgbLBDialog.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class 9 implements Function2 {
        9() {
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(753558829, i, -1, "com.zddz.app.carlive.dialog.RgbLBDialog.initView.<anonymous> (RgbLBDialog.kt:86)");
            }
            RgbLBDialog.access$addBackBt(RgbLBDialog.this, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    private static final void initView$lambda$8(RgbLBDialog rgbLBDialog, View view) {
        rgbLBDialog.handleBaseColorClick(rgbLBDialog.COLOR_AUTO);
    }

    /* compiled from: RgbLBDialog.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class 10 implements Function2 {
        10() {
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-725337450, i, -1, "com.zddz.app.carlive.dialog.RgbLBDialog.initView.<anonymous> (RgbLBDialog.kt:88)");
            }
            RgbLBDialog.access$shoRgbList(RgbLBDialog.this, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    private static final void initView$lambda$9(RgbLBDialog rgbLBDialog, View view) {
        rgbLBDialog.dismiss();
    }

    private static final void initView$lambda$10(RgbLBDialog rgbLBDialog, View view) {
        rgbLBDialog.handClickMenu(rgbLBDialog.S_LED);
    }

    private static final void initView$lambda$11(RgbLBDialog rgbLBDialog, View view) {
        rgbLBDialog.handClickMenu(rgbLBDialog.DY_LED);
    }

    private final void shoRgbList(Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-2077753747);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(this) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2077753747, i2, -1, "com.zddz.app.carlive.dialog.RgbLBDialog.shoRgbList (RgbLBDialog.kt:99)");
            }
            Modifier wrapContentSize$default = SizeKt.wrapContentSize$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getCenter(), false, 2, (Object) null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            Function3 modifierMaterializerOf = LayoutKt.modifierMaterializerOf(wrapContentSize$default);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer composer2 = Updater.constructor-impl(startRestartGroup);
            Updater.set-impl(composer2, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.box-impl(SkippableUpdater.constructor-impl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            MutableLiveData lightType0E01To04 = this.mBaseViewModel.getLightType0E01To04();
            Intrinsics.checkNotNullExpressionValue(lightType0E01To04, "getLightType0E01To04(...)");
            startRestartGroup.startReplaceableGroup(1064500733);
            boolean changedInstance = startRestartGroup.changedInstance(this);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new RgbLBDialog$$ExternalSyntheticLambda9(this);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            RgbBaseListKt.ColorSelectionDialog(lightType0E01To04, (Function1) rememberedValue, null, startRestartGroup, 0, 4);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new RgbLBDialog$$ExternalSyntheticLambda10(this, i));
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Attempt to invoke interface method 'java.util.Iterator java.util.List.iterator()' on a null object reference
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(r8-map-id-dc0d193004410705882efc9094545d3cdc927597c43a27e6ce88ac41ded4b6b3:140)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(r8-map-id-dc0d193004410705882efc9094545d3cdc927597c43a27e6ce88ac41ded4b6b3:7)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(r8-map-id-dc0d193004410705882efc9094545d3cdc927597c43a27e6ce88ac41ded4b6b3:7)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(r8-map-id-dc0d193004410705882efc9094545d3cdc927597c43a27e6ce88ac41ded4b6b3:35)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(r8-map-id-dc0d193004410705882efc9094545d3cdc927597c43a27e6ce88ac41ded4b6b3:16)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(r8-map-id-dc0d193004410705882efc9094545d3cdc927597c43a27e6ce88ac41ded4b6b3:10)
     */
    private static final Unit shoRgbList$lambda$14$lambda$13$lambda$12(RgbLBDialog rgbLBDialog, String color) {
        Intrinsics.checkNotNullParameter(color, "color");
        switch (color.hashCode()) {
            case -976943172:
                if (color.equals("purple")) {
                    rgbLBDialog.handleBaseColorClick(rgbLBDialog.COLOR_ZISE);
                    break;
                }
                break;
            case -734239628:
                if (color.equals("yellow")) {
                    rgbLBDialog.handleBaseColorClick(rgbLBDialog.COLOR_YELLOW);
                    break;
                }
                break;
            case 112785:
                if (color.equals("red")) {
                    rgbLBDialog.handleBaseColorClick(rgbLBDialog.COLOR_RED);
                    break;
                }
                break;
            case 113953:
                if (color.equals("sky")) {
                    rgbLBDialog.handleBaseColorClick(rgbLBDialog.COLOR_CYAN);
                    break;
                }
                break;
            case 3005871:
                if (color.equals("auto")) {
                    rgbLBDialog.handleBaseColorClick(rgbLBDialog.COLOR_AUTO);
                    break;
                }
                break;
            case 3027034:
                if (color.equals("blue")) {
                    rgbLBDialog.handleBaseColorClick(rgbLBDialog.COLOR_BLUE);
                    break;
                }
                break;
            case 98619139:
                if (color.equals("green")) {
                    rgbLBDialog.handleBaseColorClick(rgbLBDialog.COLOR_GREEN);
                    break;
                }
                break;
            case 113101865:
                if (color.equals("white")) {
                    rgbLBDialog.handleBaseColorClick(rgbLBDialog.COLOR_WHITE);
                    break;
                }
                break;
        }
        return Unit.INSTANCE;
    }

    private final void addBackBt(Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-2038181446);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(this) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2038181446, i2, -1, "com.zddz.app.carlive.dialog.RgbLBDialog.addBackBt (RgbLBDialog.kt:126)");
            }
            Painter painterResource = PainterResources_androidKt.painterResource(2131230944, startRestartGroup, 6);
            Modifier modifier = SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(11)), Dp.constructor-impl(20));
            startRestartGroup.startReplaceableGroup(13688407);
            boolean changedInstance = startRestartGroup.changedInstance(this);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new RgbLBDialog$$ExternalSyntheticLambda11(this);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            ImageKt.Image(painterResource, "返回按钮", ClickableKt.clickable-XHw0xAI$default(modifier, false, (String) null, (Role) null, (Function0) rememberedValue, 7, (Object) null), (Alignment) null, ContentScale.Companion.getFit(), 0.0f, (ColorFilter) null, startRestartGroup, 24624, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new RgbLBDialog$$ExternalSyntheticLambda12(this, i));
        }
    }

    private static final Unit addBackBt$lambda$17$lambda$16(RgbLBDialog rgbLBDialog) {
        rgbLBDialog.onBack();
        return Unit.INSTANCE;
    }

    private final void onBack() {
        dismiss();
    }

    private final void handleBaseColorClick(int colorType) {
        byte[] bArr = (byte[]) MapsKt.mapOf(TuplesKt.to(Integer.valueOf(this.COLOR_RED), OrderSet.write_red), TuplesKt.to(Integer.valueOf(this.COLOR_BLUE), OrderSet.write_blue), TuplesKt.to(Integer.valueOf(this.COLOR_GREEN), OrderSet.write_green), TuplesKt.to(Integer.valueOf(this.COLOR_YELLOW), OrderSet.write_yellow), TuplesKt.to(Integer.valueOf(this.COLOR_CYAN), OrderSet.write_sky), TuplesKt.to(Integer.valueOf(this.COLOR_ZISE), OrderSet.write_magenta), TuplesKt.to(Integer.valueOf(this.COLOR_WHITE), OrderSet.write_white), TuplesKt.to(Integer.valueOf(this.COLOR_AUTO), OrderSet.write_auto)).get(Integer.valueOf(colorType));
        if (bArr != null) {
            bArr[1] = (byte) this._rgbType;
            this.mIMain.writeData(bArr);
        }
    }

    private final void initRlContent() {
        this.mRgbLBAdapter = new ColorRgbLiBangAdapter();
        this.mDevList = RgbDataProvider.INSTANCE.getRgbTypeData();
        ColorRgbLiBangAdapter colorRgbLiBangAdapter = this.mRgbLBAdapter;
        ColorRgbLiBangAdapter colorRgbLiBangAdapter2 = null;
        if (colorRgbLiBangAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRgbLBAdapter");
            colorRgbLiBangAdapter = null;
        }
        colorRgbLiBangAdapter.setList(this.mDevList);
        ColorRgbLiBangAdapter colorRgbLiBangAdapter3 = this.mRgbLBAdapter;
        if (colorRgbLiBangAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRgbLBAdapter");
            colorRgbLiBangAdapter3 = null;
        }
        colorRgbLiBangAdapter3.setOnItemClickListener(new RgbLBDialog$$ExternalSyntheticLambda0(this));
        RecyclerView recyclerView = getBinding().rlRgbContent;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
        recyclerView.setItemViewCacheSize(0);
        recyclerView.getRecycledViewPool().setMaxRecycledViews(0, 0);
        ColorRgbLiBangAdapter colorRgbLiBangAdapter4 = this.mRgbLBAdapter;
        if (colorRgbLiBangAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRgbLBAdapter");
        } else {
            colorRgbLiBangAdapter2 = colorRgbLiBangAdapter4;
        }
        recyclerView.setAdapter(colorRgbLiBangAdapter2);
    }

    private static final void initRlContent$lambda$20(RgbLBDialog rgbLBDialog, View view, int i) {
        rgbLBDialog.handleRgbItemClick(i);
    }

    private final void handleRgbItemClick(int position) {
        ColorRgbLiBangAdapter colorRgbLiBangAdapter = this.mRgbLBAdapter;
        if (colorRgbLiBangAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRgbLBAdapter");
            colorRgbLiBangAdapter = null;
        }
        colorRgbLiBangAdapter.setSelectedPosition(position);
        byte[] bArr = OrderSet.LI_BANG_RGB;
        bArr[2] = (byte) position;
        this.mIMain.writeData(bArr);
    }

    private final void handClickMenu(int click) {
        getBinding().llBasergbDialog.setVisibility(click == this.S_LED ? 0 : 8);
        getBinding().comviewList.setVisibility(click == this.S_LED ? 0 : 8);
        getBinding().rlRgbContent.setVisibility(click == this.DY_LED ? 0 : 8);
        TextView textView = getBinding().tvRgb0e05TitleOne;
        if (textView != null) {
            textView.setBackgroundResource(click == this.S_LED ? 2131231092 : 0);
        }
        TextView textView2 = getBinding().tvRgb0e05TitleTwo;
        if (textView2 != null) {
            textView2.setBackgroundResource(click == this.DY_LED ? 2131231092 : 0);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }

    public void notice(String pAddress, UUID pNotice, byte[] pData) {
        super.notice(pAddress, pNotice, pData);
        try {
            String bytesToHexString = Convert.bytesToHexString(pData);
            Intrinsics.checkNotNullExpressionValue(bytesToHexString, "bytesToHexString(...)");
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String upperCase = bytesToHexString.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            String notice_no_light = OrderSet.notice_no_light;
            Intrinsics.checkNotNullExpressionValue(notice_no_light, "notice_no_light");
            if (StringsKt.startsWith$default(upperCase, notice_no_light, false, 2, (Object) null)) {
                refreshLight(0);
            } else {
                String notice_rgb = OrderSet.notice_rgb;
                Intrinsics.checkNotNullExpressionValue(notice_rgb, "notice_rgb");
                if (StringsKt.startsWith$default(upperCase, notice_rgb, false, 2, (Object) null)) {
                    refreshLight(1);
                } else {
                    String notice_rg = OrderSet.notice_rg;
                    Intrinsics.checkNotNullExpressionValue(notice_rg, "notice_rg");
                    if (StringsKt.startsWith$default(upperCase, notice_rg, false, 2, (Object) null)) {
                        refreshLight(2);
                    } else {
                        String notice_rb = OrderSet.notice_rb;
                        Intrinsics.checkNotNullExpressionValue(notice_rb, "notice_rb");
                        if (StringsKt.startsWith$default(upperCase, notice_rb, false, 2, (Object) null)) {
                            refreshLight(4);
                        } else {
                            String notice_gb = OrderSet.notice_gb;
                            Intrinsics.checkNotNullExpressionValue(notice_gb, "notice_gb");
                            if (StringsKt.startsWith$default(upperCase, notice_gb, false, 2, (Object) null)) {
                                refreshLight(3);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void refreshLight(int lightNormal) {
        this._rgbType = lightNormal;
    }
}
