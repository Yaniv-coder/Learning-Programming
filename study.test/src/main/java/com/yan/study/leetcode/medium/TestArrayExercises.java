package com.yan.study.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * LeetCode练习题.
 *
 * @author: YanJiaqi
 * @date: 2021/5/11 0011 20:44
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class TestArrayExercises {
    public static void main(String[] args) {
//        System.out.println("lengthOfLongestSubstring: " + lengthOfLongestSubstring("abcbcvfbs"));
//        System.out.println("forceLengthOfLongestSubstring: " + forceLengthOfLongestSubstring("abcbcvfbs"));
        System.out.println("removeDuplicates: " + removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
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

    /**
     * 删除排序数组中的重复项.
     *
     * 题目：给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2gy9m/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums 一个有序数组 nums
     * @return 删除重复元素后数组的新长度
     */
    public static int removeDuplicates(int[] nums) {
        // 用来判断元素是否已经出现过
        final Set<Integer> lastIntSet = new TreeSet<>();
        // 存放第一次出现的元素的下标
        final List<Integer> removeArrIndexList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            final int num = nums[i];
            lastIntSet.add(num);
        }
        final Object[] array = (Object[]) lastIntSet.toArray();
        for (int i = 0; i < array.length; i++) {
            nums[i] = (int) array[i];
        }

        return array.length;
    }
}
