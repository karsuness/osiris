package com.wjx.teemo.domain.utils.key;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author wangjinxin
 * @date 2019/9/19 15:09
 * @mail wjxScott@iCloud.com
 * @description 摘要算法工具类
 */
@Slf4j
public class SummaryAlgorithmUtils {

    /**
     * md5
     */
    private static final String MD5 = "MD5";

    /**
     * sha1
     */
    private static final String SHA1 = "SHA-1";

    /**
     * sha224
     */
    private static final String SHA224 = "SHA-224";

    /**
     * sha256
     */
    private static final String SHA256 = "SHA-256";

    /**
     * sha384
     */
    private static final String SHA384 = "SHA-384";

    /**
     * sha512
     */
    private static final String SHA512 = "SHA-512";

    /**
     * 传入文件路径计算文件的MD5值
     *
     * @param filePath 文件路径
     * @return
     */
    public static String getFileMD5Str(String filePath) {
        File file = new File(filePath);
        FileInputStream fis = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            log.info("MD5摘要长度：" + md.getDigestLength());
            fis = new FileInputStream(file);
            byte[] buffer = new byte[2048];
            int length = -1;
            log.info("开始生成摘要");
            long s = System.currentTimeMillis();
            while ((length = fis.read(buffer)) != -1) {
                md.update(buffer, 0, length);
            }
            log.info("摘要生成成功,总用时: "
                    + (System.currentTimeMillis() - s) + "ms");
            byte[] b = md.digest();
            return bytesToHexString(b);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
            return null;
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * 对一段String生成MD5加密信息
     *
     * @param message 要加密的String
     * @return 生成的MD5信息
     */
    public static String getMD5Str(String message) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            log.info("MD5摘要长度：" + md.getDigestLength());
            byte[] b = md.digest(message.getBytes());
            return bytesToHexString(b);
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取sha1摘要算法串
     *
     * @param message
     * @return
     */
    public static String getSha1Str(String message) {
        return getShaDigest(message, SHA1);
    }

    /**
     * 获取sha224摘要算法串
     *
     * @param message
     * @return
     */
    public static String getSha224Str(String message) {
        return getShaDigest(message, SHA224);
    }

    /**
     * 获取sha256摘要算法串
     *
     * @param message
     * @return
     */
    public static String getSha256Str(String message) {
        return getShaDigest(message, SHA256);
    }

    /**
     * 获取sha1摘要算法串
     *
     * @param message
     * @return
     */
    public static String getSha512Str(String message) {
        return getShaDigest(message, SHA512);
    }


    /**
     * 通过传入不同哈希算法获取对应的哈希摘要算法值
     *
     * @param content
     * @param algorithm
     * @return
     */
    private static String getShaDigest(String content, String algorithm) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(content.getBytes(StandardCharsets.UTF_8));
            return bytesToHexString(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 把byte[]数组转换成十六进制字符串表示形式
     *
     * @param bytes 要转换的byte[]
     * @return 十六进制字符串表示形式
     */
    public static String bytesToHexString(byte[] bytes) {
        StringBuffer sb = new StringBuffer(bytes.length);
        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(0xFF & bytes[i]);
            if (temp.length() < 2) {
                sb.append(0);
            }
            sb.append(temp);
        }
        return sb.toString();
    }
}
