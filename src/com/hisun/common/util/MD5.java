package com.hisun.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

/**
 * 
 * @类名： MD5.java
 * 
 * @描述：MD5 @作者： PAUL @修改日期： 2016年3月30日
 *
 */
public class MD5
{

    public static String jdkMD5(String src)
    {
        String code = null;
        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md.digest(src.getBytes());
            code = Hex.encodeHexString(md5Bytes);
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return code;
    }
}
