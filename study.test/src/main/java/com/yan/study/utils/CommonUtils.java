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


    /**
     * 打印数组.
     *
     * @param array 数组
     */
    public static void printCharArray(final char[] array) {
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

    /**
     * 打印矩阵.
     * @param matrix 矩阵
     */
    public static void printMatrix(final int[][] matrix) {
        String str = "[\n";
        for (int i = 0; i < matrix.length; i++) {
            str += "[";
            for (int j = 0; j < matrix[i].length; j++) {
                str += matrix[i][j] + ", ";
            }
            str += "]\n";
        }
        str += "]";
        System.out.println(str);
    }
}
