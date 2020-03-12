package com.lyf.common.utils;

public class ThreadUtil {

    private static final ThreadLocal<Object> local = new ThreadLocal<Object>();

    public static Object get() {
        return local.get();
    }

    public static void set(Object obj) {
        local.set(obj);
    }

}
