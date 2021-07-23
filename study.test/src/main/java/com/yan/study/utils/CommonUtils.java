package com.yan.study.utils;

/**
 * 公共工具類.
 *
 * @author: YanJiaqi
 * @date: 2021/7/10 0010 11:22
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public final class CommonUtils {
    /**
     * 私有化构造器.
     */
    private CommonUtils() {
    }

    /**
     * 打印数组.
     *
     * @param array 数组
     */
    public static void printIntArray(final int[] array) {
        String str = "[";
        for (int i = 0; i < array.length; i++) {
            if (i == (array.length - 1)) {
                str += array[i] + "]\n";
            } else {
                str += array[i] + ", ";
            }
        }
        System.out.println(str);
    }
}
