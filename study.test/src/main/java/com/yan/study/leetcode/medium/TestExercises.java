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
        System.out.println("lengthOfLongestSubstring: " + lengthOfLongestSubstring("abcbcvfbs"));
        System.out.println("forceLengthOfLongestSubstring: " + forceLengthOfLongestSubstring("abcbcvfbs"));
    }

    /**
     * 最优解 3.无重复字符的最长子串.
     * @param s 给定字符串
     * @return 最长子串长度
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

    /**
     * 暴力求解（代码复杂，且耗时长） 3.无重复字符的最长字串.
     * @param s 给定字符串
     * @return 最长子串长度
     */
    public static int forceLengthOfLongestSubstring(final String s) {
        int maxSubLength = 0;
        int curSubLength = 0;
        char[] lastChar = new char[s.length()];
        final char[] chars = s.toCharArray();
        int k = 1;
        for (int i = 0; i < chars.length; i++) {
            char curChar = chars[i];
            // 与该轮历史遍历过的字符中查找有无重复
            for (int j = 0; j < curSubLength; j++) {
                // 如果存在重复字符，则与目前最大子串长度比较
                if (curChar == lastChar[j]) {
                    if (maxSubLength < curSubLength) {
                        maxSubLength = curSubLength;
                    }
                    curSubLength = 0;
                    // 如果遍历到中间的子串出现重复字符，则回到该子串首字符的下一个字符继续遍历
                    i = k;
                    ++k;
                    curChar = chars[i];
                    break;
                }
            }
            // 将遍历过的字符存入历史数组中
            lastChar[curSubLength] = curChar;
            ++curSubLength;
        }
        if (maxSubLength < curSubLength) {
            maxSubLength = curSubLength;
        }

        return maxSubLength;
    }
}
