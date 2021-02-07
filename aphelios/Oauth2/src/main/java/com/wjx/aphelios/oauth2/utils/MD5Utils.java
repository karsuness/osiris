package com.wjx.aphelios.oauth2.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密工具类
 *
 * @author WJX
 * @since 2018/5/23 16:53
 */
public class MD5Utils {
    /**
     * 获取文件的md5标签
     *
     * @param file
     * @return
     * @throws IOException
     */
    public static String getMD5String(File file) throws IOException {
        MessageDigest messagedigest = null;
        try {
            messagedigest = MessageDigest.getInstance("MD5");
            FileInputStream in = new FileInputStream(file);
            FileChannel ch = in.getChannel();
            MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            messagedigest.update(byteBuffer);
            String md5 = toHex(messagedigest.digest());
            return md5;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将字节数组转换为16进制字符串
     *
     * @param buffer
     * @return
     */
    public static String toHex(byte[] buffer) {
        StringBuffer sb = new StringBuffer(buffer.length * 2);
        for (int i = 0; i < buffer.length; i++) {
            sb.append(Character.forDigit((buffer[i] & 240) >> 4, 16));
            sb.append(Character.forDigit(buffer[i] & 15, 16));
        }

        return sb.toString();
    }

    /**
     * 获取str的md5值
     *
     * @param str 字符串
     * @return
     */
    public final static String encrypt(String str) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] strTemp = str.getBytes();
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char strArr[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                strArr[k++] = hexDigits[byte0 >>> 4 & 0xf];
                strArr[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(strArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
