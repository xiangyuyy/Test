package com.example.demo.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xiaoh
 * @description:  转化为12位字符串
 * @date 2019/11/416:10
 */
public class ShortTextUtil {
    public static void main(String[] args){
        String uuid = "W32423234234234223423SADFSDFASDF";
        System.out.println(get12Char(uuid));
    }

    /**
     * 获取短字符
     *
     * @param str
     * @return 大写
     */
    public static String get12Char(String str) {
        String arr[] = ShortText(str);
        String rst = (arr[0] + arr[1]).toUpperCase();
        return rst.substring(0, 4) + "-" + rst.substring(4, 8) + "-"
                + rst.substring(8, 12);
    }

    private static String[] ShortText(String string) {
        String key = "CXY"; // 自定义生成MD5加密字符串前的混合KEY
        String[] chars = new String[]{ // 要使用生成URL的字符
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
                "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B",
                "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
                "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        String hex = EncoderByMd5(key + string);
        int hexLen = hex.length();
        int subHexLen = hexLen / 8;
        String[] ShortStr = new String[4];

        for (int i = 0; i < subHexLen; i++) {
            String outChars = "";
            int j = i + 1;
            String subHex = hex.substring(i * 8, j * 8);
            long idx = Long.valueOf("3FFFFFFF", 16) & Long.valueOf(subHex, 16);

            for (int k = 0; k < 6; k++) {
                int index = (int) (Long.valueOf("0000003D", 16) & idx);
                outChars += chars[index];
                idx = idx >> 5;
            }
            ShortStr[i] = outChars;
        }

        return ShortStr;
    }

    private static String EncoderByMd5(String buf) {
        try {
            MessageDigest digist = MessageDigest.getInstance("MD5");
            byte[] rs = digist.digest(buf.getBytes());
            StringBuffer digestHexStr = new StringBuffer();
            for (int i = 0; i < 16; i++) {
                digestHexStr.append(byteHEX(rs[i]));
            }
            return digestHexStr.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("出现错误");
        }
        return null;

    }

    private static String byteHEX(byte ib) {
        char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};
        char[] ob = new char[2];
        ob[0] = Digit[(ib >>> 4) & 0X0F];
        ob[1] = Digit[ib & 0X0F];
        String s = new String(ob);
        return s;
    }
}
