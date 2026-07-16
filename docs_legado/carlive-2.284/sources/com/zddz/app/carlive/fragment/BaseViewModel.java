package com.zddz.app.carlive.fragment;

import android.app.Application;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import com.zddz.app.carlive.database.ChannelRecord;
import com.zddz.app.carlive.database.EqRecord;
import com.zddz.app.carlive.database.WaveFilterRecord;
import com.zddz.bt.DeviceRecord;
import java.util.ArrayList;
import java.util.List;
import org.litepal.LitePal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class BaseViewModel extends AndroidViewModel {
    private MutableLiveData _bassValue;
    private MutableLiveData _liBangRgbValue;
    private MutableLiveData _liBangSpeechOpenValue;
    private MutableLiveData _tbeValue;
    public MutableLiveData bassValue;
    public MutableLiveData liBangRgbValue;
    public MutableLiveData liBangSpeechOpenValue;
    private List mMessageItemList;
    protected SavedStateHandle mSavedStateHandle;
    protected SharedPreferences mSharedPreferences;
    private String name_unicode_hex;
    public MutableLiveData tbeValue;

    public BaseViewModel(Application application, SavedStateHandle savedStateHandle) {
        super(application);
        MutableLiveData mutableLiveData = new MutableLiveData(0);
        this._liBangRgbValue = mutableLiveData;
        this.liBangRgbValue = mutableLiveData;
        MutableLiveData mutableLiveData2 = new MutableLiveData(false);
        this._liBangSpeechOpenValue = mutableLiveData2;
        this.liBangSpeechOpenValue = mutableLiveData2;
        MutableLiveData mutableLiveData3 = new MutableLiveData(0);
        this._tbeValue = mutableLiveData3;
        this.tbeValue = mutableLiveData3;
        MutableLiveData mutableLiveData4 = new MutableLiveData(0);
        this._bassValue = mutableLiveData4;
        this.bassValue = mutableLiveData4;
        this.name_unicode_hex = "";
        this.mMessageItemList = new ArrayList();
        this.mSavedStateHandle = savedStateHandle;
        this.mSharedPreferences = application.getSharedPreferences("config", 0);
    }

    public String getBleAddress() {
        return this.mSharedPreferences.getString("BLE_ADDRESS", "");
    }

    public void setBleAddress(String str) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putString("BLE_ADDRESS", str);
        edit.apply();
    }

    public String getManufactureData() {
        return this.mSharedPreferences.getString("MANUFACTURE_DATA", "");
    }

    public void setManufactureData(String str) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putString("MANUFACTURE_DATA", str);
        edit.apply();
    }

    public String getA2dpAddress() {
        return this.mSharedPreferences.getString("A2DP_ADDRESS", "");
    }

    public void setA2dpAddress(String str) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putString("A2DP_ADDRESS", str);
        edit.apply();
    }

    public boolean getAutoConnect() {
        return this.mSharedPreferences.getBoolean("AUTO_CONNECT", true);
    }

    public void setAutoConnect(boolean z) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putBoolean("AUTO_CONNECT", z);
        edit.apply();
    }

    public double getLongitude() {
        return Double.longBitsToDouble(this.mSharedPreferences.getLong("LONGITUDE", 0L));
    }

    public void setLongitude(double d) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putLong("LONGITUDE", Double.doubleToRawLongBits(d));
        edit.apply();
    }

    public double getLatitude() {
        return Double.longBitsToDouble(this.mSharedPreferences.getLong("LATITUDE", 0L));
    }

    public void setLatitude(double d) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putLong("LATITUDE", Double.doubleToRawLongBits(d));
        edit.apply();
    }

    public boolean getAllowLocation() {
        return this.mSharedPreferences.getBoolean("ALLOW_LOCATION", true);
    }

    public void setAllowLocation(boolean z) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putBoolean("ALLOW_LOCATION", z);
        edit.apply();
    }

    public boolean getMute() {
        return this.mSharedPreferences.getBoolean("MUTE", false);
    }

    public void setMute(boolean z) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putBoolean("MUTE", z);
        edit.apply();
    }

    public int getVolume() {
        return this.mSharedPreferences.getInt("VOLUME", 15);
    }

    public void setVolume(int i) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putInt("VOLUME", i);
        edit.apply();
    }

    public int getMaxVolume() {
        return this.mSharedPreferences.getInt("MAX_VOLUME", 32);
    }

    public void setMaxVolume(int i) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putInt("MAX_VOLUME", i);
        edit.apply();
    }

    public int getMode() {
        return this.mSharedPreferences.getInt("MODE", 0);
    }

    public void setMode(int i) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putInt("MODE", i);
        edit.apply();
    }

    public int getLightType() {
        return this.mSharedPreferences.getInt("LIGHT_TYPE", 0);
    }

    public void setLightType(int i) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putInt("LIGHT_TYPE", i);
        edit.apply();
    }

    public int getFmFrequency() {
        return this.mSharedPreferences.getInt("FM_FREQUENCY", 8750);
    }

    public void setFmFrequency(int i) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putInt("FM_FREQUENCY", i);
        edit.apply();
    }

    public int getFmBand() {
        return this.mSharedPreferences.getInt("FM_BAND", 1);
    }

    public void setFmBand(int i) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putInt("FM_BAND", i);
        edit.apply();
    }

    public String getDabFrequency() {
        return this.mSharedPreferences.getString("DAB_FREQUENCY", "");
    }

    public void setDabFrequency(String str) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putString("DAB_FREQUENCY", str);
        edit.apply();
    }

    public String getDabName() {
        return this.mSharedPreferences.getString("DAB_NAME", "");
    }

    public void setDabName(String str) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putString("DAB_NAME", str);
        edit.apply();
    }

    public int getDabStationNumber() {
        return this.mSharedPreferences.getInt("DAB_STATION_NUMBER", -1);
    }

    public void setDabStationNumber(int i) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putInt("DAB_STATION_NUMBER", i);
        edit.apply();
    }

    public boolean getMusicState() {
        return this.mSharedPreferences.getBoolean("MUSIC_STATE", false);
    }

    public void setMusicState(boolean z) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putBoolean("MUSIC_STATE", z);
        edit.apply();
    }

    public int getMusicPlayMode() {
        return this.mSharedPreferences.getInt("MUSIC_PLAY_MODE", 0);
    }

    public void setMusicPlayMode(int i) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putInt("MUSIC_PLAY_MODE", i);
        edit.apply();
    }

    public String getMusicTitle() {
        return this.mSharedPreferences.getString("MUSIC_TITLE", "");
    }

    public void setMusicTitle(String str) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putString("MUSIC_TITLE", str);
        edit.apply();
    }

    public int getMusicDuration() {
        return this.mSharedPreferences.getInt("MUSIC_DURATION", 0);
    }

    public void setMusicDuration(int i) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putInt("MUSIC_DURATION", i);
        edit.apply();
    }

    public int getMusicPosition() {
        return this.mSharedPreferences.getInt("MUSIC_POSITION", 0);
    }

    public void setMusicPosition(int i) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putInt("MUSIC_POSITION", i);
        edit.apply();
    }

    public int getMusicNumber() {
        return this.mSharedPreferences.getInt("MUSIC_NUMBER", -1);
    }

    public void setMusicNumber(int i) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putInt("MUSIC_NUMBER", i);
        edit.apply();
    }

    public int getEqType() {
        return this.mSharedPreferences.getInt("EQ_TYPE", 0);
    }

    public void setEqType(int i) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putInt("EQ_TYPE", i);
        edit.apply();
    }

    public int getEqStyle() {
        return this.mSharedPreferences.getInt("EQ_STYLE", 0);
    }

    public void setEqStyle(int i) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putInt("EQ_STYLE", i);
        edit.apply();
    }

    public int getChannelEqStyle() {
        return this.mSharedPreferences.getInt("CHANNEL_EQ_STYLE", 0);
    }

    public void setChannelEqStyle(int i) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putInt("CHANNEL_EQ_STYLE", i);
        edit.apply();
    }

    public int getDspIfx() {
        return this.mSharedPreferences.getInt("DSQ_IFX", 0);
    }

    public void setDspIfx(int i) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putInt("DSQ_IFX", i);
        edit.apply();
    }

    public int getTreble() {
        return this.mSharedPreferences.getInt("TREBLE", 7);
    }

    public void setTreble(int i) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putInt("TREBLE", i);
        edit.apply();
    }

    public int getTrebleMax() {
        return this.mSharedPreferences.getInt("TREBLE_MAX", 7);
    }

    public void setTrebleMax(int i) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putInt("TREBLE_MAX", i);
        edit.apply();
    }

    public int getBass() {
        return this.mSharedPreferences.getInt("BASS", 7);
    }

    public void setBass(int i) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putInt("BASS", i);
        edit.apply();
    }

    public int getBassMax() {
        return this.mSharedPreferences.getInt("BASS_MAX", 7);
    }

    public void setBassMax(int i) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putInt("BASS_MAX", i);
        edit.apply();
    }

    public int getBalance() {
        return this.mSharedPreferences.getInt("BALANCE", 7);
    }

    public void setBalance(int i) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putInt("BALANCE", i);
        edit.apply();
    }

    public int getBalanceMax() {
        return this.mSharedPreferences.getInt("BALANCE_MAX", 7);
    }

    public void setBalanceMax(int i) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putInt("BALANCE_MAX", i);
        edit.apply();
    }

    public int getFade() {
        return this.mSharedPreferences.getInt("FADE", 7);
    }

    public void setFade(int i) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putInt("FADE", i);
        edit.apply();
    }

    public int getFadeMax() {
        return this.mSharedPreferences.getInt("FADE_MAX", 7);
    }

    public void setFadeMax(int i) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putInt("FADE_MAX", i);
        edit.apply();
    }

    public boolean getFadeSupport() {
        return this.mSharedPreferences.getBoolean("FADE_SUPPORT", true);
    }

    public void setFadeSupport(boolean z) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putBoolean("FADE_SUPPORT", z);
        edit.apply();
    }

    public boolean getFourEqEnable() {
        return this.mSharedPreferences.getBoolean("FOUR_EQ_ENABLE", true);
    }

    public void setFourEqEnable(boolean z) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putBoolean("FOUR_EQ_ENABLE", z);
        edit.apply();
    }

    public void setEqValue(int i, int i2, String str) {
        EqRecord eqRecord = (EqRecord) LitePal.where("number =?", String.valueOf(i)).findFirst(EqRecord.class);
        if (eqRecord == null) {
            eqRecord = new EqRecord(i, i2);
        }
        if (i2 >= 0) {
            eqRecord.eq = i2;
        }
        if (!TextUtils.isEmpty(str)) {
            eqRecord.title = str;
        }
        eqRecord.save();
    }

    public void setWaveFilterQValueGain(int i, int i2, int i3) {
        WaveFilterRecord waveFilterRecord = (WaveFilterRecord) LitePal.where("number = ?", String.valueOf(i)).findFirst(WaveFilterRecord.class);
        if (waveFilterRecord == null) {
            waveFilterRecord = new WaveFilterRecord(i);
        }
        waveFilterRecord.q_value = i2;
        waveFilterRecord.gain = i3;
        waveFilterRecord.save();
    }

    public void setWaveFilterFrequency(int i, String str) {
        WaveFilterRecord waveFilterRecord = (WaveFilterRecord) LitePal.where("number = ?", String.valueOf(i)).findFirst(WaveFilterRecord.class);
        if (waveFilterRecord == null) {
            waveFilterRecord = new WaveFilterRecord(i);
        }
        waveFilterRecord.frequency = str;
        waveFilterRecord.save();
    }

    public void setChannelPhaseGain(String str, int i, int i2) {
        ChannelRecord channelRecord = (ChannelRecord) LitePal.where("number = ?", str).findFirst(ChannelRecord.class);
        if (channelRecord == null) {
            channelRecord = new ChannelRecord(str);
        }
        channelRecord.phase = i;
        channelRecord.gain = i2;
        channelRecord.save();
    }

    public void setChannelPassSwitch(String str, int i) {
        ChannelRecord channelRecord = (ChannelRecord) LitePal.where("number = ?", str).findFirst(ChannelRecord.class);
        if (channelRecord == null) {
            channelRecord = new ChannelRecord(str);
        }
        if (i == 0) {
            channelRecord.high_pass_switch = 0;
            channelRecord.low_pass_switch = 0;
        } else if (i == 1) {
            channelRecord.high_pass_switch = 1;
            channelRecord.low_pass_switch = 0;
        } else if (i == 2) {
            channelRecord.high_pass_switch = 0;
            channelRecord.low_pass_switch = 1;
        } else if (i == 3) {
            channelRecord.high_pass_switch = 1;
            channelRecord.low_pass_switch = 1;
        }
        channelRecord.save();
    }

    public void setChannelHighPassSlopeFrequency(String str, int i, int i2) {
        ChannelRecord channelRecord = (ChannelRecord) LitePal.where("number = ?", str).findFirst(ChannelRecord.class);
        if (channelRecord == null) {
            channelRecord = new ChannelRecord(str);
        }
        channelRecord.high_pass_slope = i;
        channelRecord.high_pass_frequency = i2;
        channelRecord.save();
    }

    public void setChannelLowPassSlopeFrequency(String str, int i, int i2) {
        ChannelRecord channelRecord = (ChannelRecord) LitePal.where("number = ?", str).findFirst(ChannelRecord.class);
        if (channelRecord == null) {
            channelRecord = new ChannelRecord(str);
        }
        channelRecord.low_pass_slope = i;
        channelRecord.low_pass_frequency = i2;
        channelRecord.save();
    }

    public void setChannelDelay(String str, int i) {
        ChannelRecord channelRecord = (ChannelRecord) LitePal.where("number = ?", str).findFirst(ChannelRecord.class);
        if (channelRecord == null) {
            channelRecord = new ChannelRecord(str);
        }
        channelRecord.delay = i;
        channelRecord.save();
    }

    /* JADX WARN: Removed duplicated region for block: B:341:0x07dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void notice(byte[] r17) {
        /*
            Method dump skipped, instructions count: 3420
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zddz.app.carlive.fragment.BaseViewModel.notice(byte[]):void");
    }

    public MutableLiveData getLightType0E05() {
        if (!this.mSavedStateHandle.contains("LightType0E05")) {
            this.mSavedStateHandle.set("LightType0E05", "");
        }
        return this.mSavedStateHandle.getLiveData("LightType0E05");
    }

    public void setLightType0E05(String str) {
        getLightType0E05().postValue(str);
    }

    public MutableLiveData getEqHas() {
        if (!this.mSavedStateHandle.contains("EqHas")) {
            this.mSavedStateHandle.set("EqHas", true);
        }
        return this.mSavedStateHandle.getLiveData("EqHas");
    }

    public void setEqHas(Boolean bool) {
        getEqHas().postValue(bool);
    }

    private static byte[] hexStringToByteArray(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    public MutableLiveData getLightType0E01To04() {
        if (!this.mSavedStateHandle.contains("LightType0E01To04")) {
            this.mSavedStateHandle.set("LightType0E01To04", "");
        }
        return this.mSavedStateHandle.getLiveData("LightType0E01To04");
    }

    private void setLightType0E01To04(String str) {
        getLightType0E01To04().postValue(str);
    }

    public void disconnect() {
        setMusicTitle("");
        setFmFrequency(8750);
        setEqType(0);
        setFadeSupport(true);
        setDabStationNumber(-1);
        setDabName("");
        setDabFrequency("");
        setMode(0);
    }

    public MutableLiveData getScanningLiveData() {
        if (!this.mSavedStateHandle.contains("Scanning")) {
            this.mSavedStateHandle.set("Scanning", false);
        }
        return this.mSavedStateHandle.getLiveData("Scanning");
    }

    public void deleteDeviceRecord(String str) {
        DeviceRecord deviceRecord = (DeviceRecord) LitePal.where("address = ?", str).findFirst(DeviceRecord.class);
        if (deviceRecord == null || deviceRecord.getManufacture_data() == null || deviceRecord.getManufacture_data().startsWith("5A44")) {
            return;
        }
        deviceRecord.delete();
    }

    public List getMessageItemList() {
        return this.mMessageItemList;
    }

    public void setDialog0E05And1To4ClickIndex(int i) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putInt("0E05Click", i);
        edit.apply();
    }

    public int getDialog0E05And1To4ClickIndex() {
        return this.mSharedPreferences.getInt("0E05Click", 1);
    }
}
