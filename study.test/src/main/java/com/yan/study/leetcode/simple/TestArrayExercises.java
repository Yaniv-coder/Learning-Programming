package com.yan.study.leetcode.simple;

import java.util.Set;
import java.util.TreeSet;

/**
 * LeetCode练习题——简单.
 *
 * @author: YanJiaqi
 * @date: 2021/5/11 0011 20:44
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class TestArrayExercises {
    public static void main(String[] args) {
        System.out.println("removeDuplicates: " + removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
        System.out.println("optimizationRemoveDuplicates: " + optimizationRemoveDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
        System.out.println("maxProfit: " + maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    /**
     * 26.删除排序数组中的重复项.
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
    public static int removeDuplicates(final int[] nums) {
        // 用来判断元素是否已经出现过
        final Set<Integer> lastIntSet = new TreeSet<>();

        for (final int num : nums) {
            lastIntSet.add(num);
        }
        final Object[] array = lastIntSet.toArray();
        for (int i = 0; i < array.length; i++) {
            nums[i] = (int) array[i];
        }

        return array.length;
    }

    /**
     * 26.删除排序数组中的重复项（双指针法，最优解）.
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
    public static int optimizationRemoveDuplicates(final int[] nums) {
        final int n = nums.length;
        // 指向最后一个已排好的元素
        int j = 0;
        // i指针遍历数组，以找到与j指针所指元素不同的元素
        for (int i = 0; i < n; i++) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }
        }

        return j + 1;
    }

    /**
     * 122.买卖股票的最佳时机 II（贪心算法）.
     *
     * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2zsx1/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param prices 给定几天的股票价格
     * @return 最大收益
     */
    public static int maxProfit(final int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length - 1 ; i++) {
//            if (prices[i + 1] > prices[i]) {
//                result += prices[i + 1] - prices[i];
//            }
            result += Math.max(0, prices[i + 1] - prices[i]);
        }

        return result;
    }
}
