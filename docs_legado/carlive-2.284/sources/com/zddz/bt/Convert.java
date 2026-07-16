package com.zddz.bt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class Convert {
    public static String bytesToHexString(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                stringBuffer.append("0");
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString();
    }

    public static byte[] hexStringToBytes(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        if (str.length() % 2 != 0) {
            str = "0" + str;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (charToByte(charArray[i2 + 1]) | (charToByte(charArray[i2]) << 4));
        }
        return bArr;
    }

    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    public static String bytesToShowHexString(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                stringBuffer.append("0");
            }
            stringBuffer.append(hexString + " ");
        }
        return stringBuffer.toString();
    }

    public static String unitFormat(int i) {
        if (i >= 0 && i < 10) {
            return "0" + Integer.toString(i);
        }
        return "" + i;
    }

    public static String second2MMSS(int i) {
        return unitFormat(i / 60) + ":" + unitFormat(i % 60);
    }

    public static byte[] intToBytes4Big(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static byte[] intToBytes4Little(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)};
    }

    public static int bytesToIntBig(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public static int bytesToIntLittle(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static String bytesToBinaryInts(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(String.valueOf((b >> 7) & 1));
            stringBuffer.append(String.valueOf((b >> 6) & 1));
            stringBuffer.append(String.valueOf((b >> 5) & 1));
            stringBuffer.append(String.valueOf((b >> 4) & 1));
            stringBuffer.append(String.valueOf((b >> 3) & 1));
            stringBuffer.append(String.valueOf((b >> 2) & 1));
            stringBuffer.append(String.valueOf((b >> 1) & 1));
            stringBuffer.append(String.valueOf(b & 1));
        }
        return stringBuffer.toString();
    }

    public static String hexString2binaryString(String str) {
        return bytesToBinaryInts(hexStringToBytes(str));
    }

    public static byte[] password2bytes(String str) {
        byte[] bArr = new byte[str.length()];
        int i = 0;
        while (i < str.length()) {
            int i2 = i + 1;
            bArr[0] = Byte.valueOf(str.substring(i, i2)).byteValue();
            i = i2;
        }
        return bArr;
    }

    public static String notice2unicode(String str) {
        String replaceAll = str.replaceAll("0+$", "");
        int length = replaceAll.length() % 4;
        for (int i = 0; i < length; i++) {
            replaceAll = replaceAll + "0";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 2; i2 < replaceAll.length(); i2 += 4) {
            stringBuffer.append("\\u");
            stringBuffer.append(replaceAll.substring(i2, i2 + 2));
            stringBuffer.append(replaceAll.substring(i2 - 2, i2));
        }
        return stringBuffer.toString();
    }

    public static String unicodeToString(String str) {
        Matcher matcher = Pattern.compile("(\\\\u(\\p{XDigit}{4}))").matcher(str);
        while (matcher.find()) {
            char parseInt = (char) Integer.parseInt(matcher.group(2), 16);
            str = str.replace(matcher.group(1), parseInt + "");
        }
        return str;
    }

    public static byte[] intToBytes4LowHigh(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)};
    }

    public static byte[] intToBytes4HighLow(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static int bytes4ToIntLowHigh(byte[] bArr) {
        if (bArr.length != 4) {
            return 0;
        }
        int i = bArr[3] & 255;
        int i2 = (bArr[2] & 255) << 8;
        return ((bArr[0] & 255) << 24) | i | i2 | ((bArr[1] & 255) << 16);
    }

    public static int bytes4ToIntHighLow(byte[] bArr) {
        if (bArr.length != 4) {
            return 0;
        }
        int i = (bArr[0] & 255) << 24;
        int i2 = (bArr[1] & 255) << 16;
        return (bArr[3] & 255) | i | i2 | ((bArr[2] & 255) << 8);
    }
}
