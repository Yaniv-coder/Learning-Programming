package com.yan.study.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode练习题——中等.
 *
 * @author: YanJiaqi
 * @date: 2021/5/11 0011 20:44
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class TestArrayPractises {
    public static void main(String[] args) {
        System.out.println("lengthOfLongestSubstring: " + lengthOfLongestSubstring("abcbcvfbs"));
        System.out.println("forceLengthOfLongestSubstring: " + forceLengthOfLongestSubstring("abcbcvfbs"));
        int[] nums = new int[]{8, 2, 0, 4, 1, 4, 2, 1, 0, 6, 6, 2, 5, 6, 6, 2, 7, 9, 4,
                1, 3, 9, 6, 5, 4, 8, 7, 8, 9, 2, 5, 5, 8, 3, 0, 5, 2, 5, 3, 9, 8, 5, 8, 8, 6,
                3, 0, 2, 8, 1, 8, 4, 6, 4, 1, 6, 4, 3, 7, 9, 3, 0, 3, 9, 3, 3, 2, 1, 3, 2, 8,
                7, 7, 7, 2, 0, 3, 1, 2, 1, 7, 7, 2, 8, 4, 0, 4, 3, 1, 9, 1, 5, 9, 8, 5, 6, 4,
                2, 8, 0, 9, 6, 5, 7, 2, 6, 3, 1, 2, 1, 0, 6, 9, 7, 5, 3, 9, 8, 2, 6, 1, 8, 6,
                6, 4, 4, 7, 3, 3, 5, 3, 2, 2, 9, 2, 7, 5, 2, 8, 5, 8, 7, 5, 3, 6, 0, 4, 1, 0
        };
        rotate(nums, 2);
        printIntArray(nums);
    }

    /**
     * 打印数组.
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
     * 3.无重复字符的最长子串（最优解）.
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
     * 189. 旋转数组（原地算法）
     *
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     *
     * 进阶：
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rotate-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums 给定的数组
     * @param k 给定需要移动的步长
     */
    public static void rotate(int[] nums, int k) {
        if (1 >= nums.length) {
            return;
        }

        List visited = new ArrayList();
        int count = 0;
        int i = 0;
        int temp = nums[0];
        // 当前下标走了指定步数后，将走完步数后位置的值替换为原来位置的值（存放在临时变量中），
        // 而该处的值则放入临时变量中；
        // 直到总共走了数组大小的次数停止。
        while (count < nums.length) {
            // 走指定步数后的下标，也是下一次循环将要使用的下标
            int nextIndex = (i + k) % nums.length;
            if (visited.contains(nextIndex)) {
                ++nextIndex;
                temp = nums[nextIndex];
            } else {
                // 交换
                temp = temp ^ nums[nextIndex];
                nums[nextIndex] = temp ^ nums[nextIndex];
                temp = temp ^ nums[nextIndex];

                visited.add(nextIndex);
                ++count;
            }

            i = nextIndex;
        }
    }
}
