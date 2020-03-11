package com.lyf.common.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5Util {

    public static String encode(String str) {
        return DigestUtils.md5Hex(str.getBytes());
    }

}
