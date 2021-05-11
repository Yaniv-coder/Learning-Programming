package com.yan.study.leetcode.medium;

/**
 * LeetCode练习题.
 *
 * @author: YanJiaqi
 * @date: 2021/5/11 0011 20:44
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class TestExercises {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" "));
    }

    /**
     * 求解无重复字符的最长字串.
     * @param s 给定字符串
     */
    public static int lengthOfLongestSubstring(final String s) {
        // 遍历过的字符存放在该数组中
        final int[] lastArr = new int[128];
        final int length =  s.length();

        // 窗口起始点
        int start = 0;
        int result = 0;
        for (int i = 0; i < length; i++) {
            final char curChar = s.charAt(i);
            // 如果该字符出现过，则lastArr[curChar]等于之前出现时所处下标+1；
            // 并且如果该下标大于当前窗口起始点，则移动该窗口，即将窗口起始点设置为该下标。
            start = Math.max(start, lastArr[curChar]);
            result = Math.max(result, i - start + 1);
            lastArr[curChar] = i + 1;
        }

        return result;
    }
}
