package com.jd.jmi.order.canal.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by IntelliJ IDEA.
 * User: liqing(yfliqing@360buy.com)
 * Date: 2011-3-8
 * Time: 11:41:46
 */
public class MD5Util {
    public final static String DEFAULT_CHARSET = "UTF-8";

    private MD5Util() {
    }

    static MessageDigest getDigest() {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
        }
        return md;
    }

    public static byte[] md5(byte data[]) {
        return getDigest().digest(data);
    }

    public static byte[] md5(String data, String charset) {
        if (null == charset) {
            charset = DEFAULT_CHARSET;
        }
        try {
            return md5(data.getBytes(charset));
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }


    public static String md5Hex(byte data[]) {
        return HexUtil.toHexString(md5(data));
    }

    public static String md5Hex(String data, String charset) {
        return HexUtil.toHexString(md5(data, charset));
    }
}

