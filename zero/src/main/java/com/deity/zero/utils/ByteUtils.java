package com.deity.zero.utils;

import java.io.UnsupportedEncodingException;

/**
 * Socket内容转换
 * Created by Deity on 2016/4/7.
 */
@SuppressWarnings("ALL")
public class ByteUtils {
    private static String ENCODE_UTF8="UTF-8";
    private static String ENCODE_ISO="ISO-8859-1";

    public byte[] str2byte(String content,String encode) throws UnsupportedEncodingException {
        return content.getBytes(encode);
    }

    public byte[] str2byte4UTF(String content) throws UnsupportedEncodingException {
        return content.getBytes(ENCODE_UTF8);
    }

    public byte[] str2byte4ISO(String content) throws UnsupportedEncodingException {
        return content.getBytes(ENCODE_ISO);
    }

    /**
     * short类型转byte[2]
     * short占用2个字节
     * @param value
     * @return
     */
    public byte[] short2byte(short value){
        byte[] result = new byte[2];
        result[0]=(byte)((value>>8)&0xFF);
        result[1]=(byte)(value&0xFF);
        return result;
    }
}
