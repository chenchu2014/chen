package cn.edu.bit.util;

/**
 * @author 初
 */
public class DataTypeConverter {
    /**
     * @param h short的高8位
     * @param l short的低8位
     * @return 将c语言中的unsigned short转化为java中的int
     */
    public static int convertUnsignedShort2Int(byte h, byte l) {
        int result = 0;
        byte index = 0x01;
        for (int i = 0; i < 8; i++) {
            if ((h & index) != 0) {
                result += Math.pow(2, i + 8);
            }
            index <<= 1;
        }
        index = 0x01;
        for (int i = 0; i < 8; i++) {
            if ((l & index) != 0) {
                result += Math.pow(2, i);
            }
            index <<= 1;
        }
        return result;
    }

    /**
     * @param h short的高8位
     * @param l short的低8位
     * @return 将c语言中的short转化为java中的int
     */
    public static int convertSignedShort2Int(byte h, byte l) {

        if ((h & 0x80) == 0) {
            return convertUnsignedShort2Int(h, l);
        } else {
            h = (byte) ~h;
            l = (byte) ~l;
            int flag1 = l & 0x80;
            l += 1;
            int flag2 = l & 0x80;
            if (flag1 != 0 && flag2 == 0) {
                h += 1;
            }
            int result = convertUnsignedShort2Int(h, l);
            result = -result;
            return result;
        }
    }

    /**
     * @param h
     * @param l
     * @return 此方法废弃
     */
    @Deprecated
    public static char convertByte2Char(byte h, byte l) {
        char result = 0x0000;
        byte index = 0x01;
        char a;
        for (int i = 0; i < 8; i++) {
            if ((h & index) != 0) {
                a = 0x0001;
                result |= a <<= (i + 8);
            }
            index <<= 1;
        }
        index = 0x01;
        for (int i = 0; i < 8; i++) {
            if ((l & index) != 0) {
                a = 0x0001;
                result |= a <<= i;
            }
            index <<= 1;
        }
        return result;
    }
}
