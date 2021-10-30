package com.yan.study.leetcode.medium;

import com.yan.study.utils.CommonUtils;

/**
 * LeetCode字符串练习题——中等.
 *
 * @author: YanJiaqi
 * @date: 2021/8/15 0015 11:13
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class TestStringPractises {
    public static void main(String[] args) {
        char[] charArray = new char[] {'h', 'e', 'l', 'l', 'o'};
        CommonUtils.printCharArray(charArray);
        reverseString(charArray);
        CommonUtils.printCharArray(charArray);
    }

    /**
     * Write a function that reverses a string.The input string is given as an array of characters s.
     * @param s an array of characters
     */
    public static void reverseString(final char[] s) {
        int i = 0;
        int j = s.length - 1;
        char temp;
        while (i < j) {
           temp = s[i];
           s[i] = s[j];
           s[j] = temp;
           i++;
           j--;
        }
    }
}
