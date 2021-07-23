package com.yan.study.leetcode.simple;

import com.yan.study.utils.CommonUtils;

import java.util.*;

/**
 * LeetCode练习题——简单.
 *
 * @author: YanJiaqi
 * @date: 2021/5/11 0011 20:44
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class TestArrayPractices {
    public static void main(String[] args) {
        System.out.println("removeDuplicates: " + removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
        System.out.println("optimizationRemoveDuplicates: " + optimizationRemoveDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
        System.out.println("maxProfit: " + maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        final int[] intersectResult1 = intersectWithHashMapComplicate(new int[]{0, 1, 1, 2, 5, 6, 6}, new int[]{0, 0, 1, 2, 2, 5, 6, 6, 6});
        CommonUtils.printIntArray(intersectResult1);
        final int[] intersectResult2 = intersectWithHashMap(new int[]{0, 1, 1, 2, 5, 6, 6}, new int[]{0, 0, 1, 2, 2, 5, 6, 6, 6});
        CommonUtils.printIntArray(intersectResult2);
        final int[] indicesWithViolent = twoSumWithViolent(new int[] {2,7,11,15}, 9);
        CommonUtils.printIntArray(indicesWithViolent);
        final int[] indices = twoSum(new int[] {2,7,11,15}, 9);
        CommonUtils.printIntArray(indices);
    }

    /**
     * 26.删除排序数组中的重复项.
     * <p>
     * 题目：给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * <p>
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
     * <p>
     * 题目：给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * <p>
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
     * <p>
     * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * <p>
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
        for (int i = 0; i < prices.length - 1; i++) {
//            if (prices[i + 1] > prices[i]) {
//                result += prices[i + 1] - prices[i];
//            }
            result += Math.max(0, prices[i + 1] - prices[i]);
        }

        return result;
    }

    /**
     * 350. 两个数组的交集 II（哈希表方法；这一版第一次思考写出的，很多不必要的步骤。）.
     * <p>
     * 给定两个数组，编写一个函数来计算它们的交集。
     * 说明：
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
     * 我们可以不考虑输出结果的顺序。
     * 进阶：
     * 如果给定的数组已经排好序呢？你将如何优化你的算法？
     * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
     * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums1 取交集的数组之一
     * @param nums2 取交集的数组之一
     * @return 交集
     */
    public static int[] intersectWithHashMapComplicate(int[] nums1, int[] nums2) {
        // 用来统计第一个数组（nums1）中所有数字出现的次数
        final Map<Integer, Integer> num2CntMapNums1 = new HashMap<Integer, Integer>();
        // 用来统计第二个数组（nums2）中所有数字出现的次数
        final Map<Integer, Integer> num2CntMapNums2 = new HashMap<Integer, Integer>();

        // ==========================================
        // 1. 先统计出来两个数组中各个数字出现的次数
        // ==========================================
        countNumOccurences(nums1, num2CntMapNums1);
        countNumOccurences(nums2, num2CntMapNums2);

        // ==========================================
        // 2. 再遍历内容少的map，并查看另一个map中是否有相同的key（即数字），
        // 如果有则看哪个value（即出现次数）小，最终在结果数组中数字的个数
        // 就等于出现次数少的这个次数。
        // ==========================================
        // 结果数组
        int[] resultArr;
        int arrLength = Math.max(nums1.length, nums2.length);
        if (num2CntMapNums1.size() <= num2CntMapNums2.size()) {
            resultArr = generateResult(num2CntMapNums1, num2CntMapNums2, arrLength);
        } else {
            resultArr = generateResult(num2CntMapNums2, num2CntMapNums1, arrLength);
        }
        return resultArr;
    }

    /**
     * 统计给出的数组中各个数字出现的次数.
     *
     * @param nums       需要统计的数组
     * @param num2CntMap 该函数存放统计结果的map
     */
    private static void countNumOccurences(final int[] nums, final Map<Integer, Integer> num2CntMap) {
        for (int i = 0; i < nums.length; i++) {
            Integer cnt = num2CntMap.get(nums[i]);
            if (null == cnt) {
                cnt = 1;
            } else {
                cnt++;
            }
            num2CntMap.put(nums[i], cnt);
        }
    }

    /**
     * 生成结果.
     *
     * @param num2CntMapOuter 外层循环的map
     * @param num2CntMapInner 循环内层取数的map
     * @param arrLength       结果数组长度
     * @return 结果数组
     */
    private static int[] generateResult(final Map<Integer, Integer> num2CntMapOuter, final Map<Integer, Integer> num2CntMapInner, final int arrLength) {
        int[] resultArr = new int[0];
        for (Map.Entry<Integer, Integer> entry : num2CntMapOuter.entrySet()) {
            final Integer num = entry.getKey();
            final Integer cnt1 = entry.getValue();

            final Integer cnt2 = num2CntMapInner.get(num);
            // 如果该数字在另一个数组中存在，才生成
            if (null != cnt2) {
                int cnt = 0;
                // 选择出现次数少的那个次数
                if (cnt1 <= cnt2) {
                    cnt = cnt1;
                } else {
                    cnt = cnt2;
                }

                // 根据最小出现次数来生成数字
                for (int i = 0; i < cnt; i++) {
                    final int lastIndex = resultArr.length;
                    resultArr = Arrays.copyOf(resultArr, lastIndex + 1);
                    resultArr[lastIndex] = num;
                }
            }
        }
        return resultArr;
    }

    /**
     * 350. 两个数组的交集 II（哈希表方法：精简版）.
     * <p>
     * 给定两个数组，编写一个函数来计算它们的交集。
     * 说明：
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
     * 我们可以不考虑输出结果的顺序。
     * 进阶：
     * 如果给定的数组已经排好序呢？你将如何优化你的算法？
     * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
     * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * 思路：
     * 先对长度小的数组中数字及其出现次数收集为map；然后遍历长度大的数组，取出每个数字在刚刚收集的map中对应的次数，
     * 如果不存在或者出现次数变为0了就说明没有交集，否则就是有交集；且在取出一次以后，map相对应的数字出现次数就要减一。
     *
     * @param nums1 取交集的数组之一
     * @param nums2 取交集的数组之一
     * @return 交集
     */
    public static int[] intersectWithHashMap(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersectWithHashMap(nums2, nums1);
        }

        int[] result = new int[nums1.length];
        final Map<Integer, Integer> num2CountMapOfNums1 = new HashMap<>();

        // 对长度相对小的数组遍历，并将各个元素出现的次数收集到map中
        for (int i = 0; i < nums1.length; i++) {
            final Integer count = num2CountMapOfNums1.getOrDefault(nums1[i], 0);
            num2CountMapOfNums1.put(nums1[i], count + 1);
        }

        final int RUN_OUT_OF_TIMES = 0;
        int finalIndex = 0;
        for (int j = 0; j < nums2.length; j++) {
            final Integer count = num2CountMapOfNums1.get(nums2[j]);
            if (num2CountMapOfNums1.containsKey(nums2[j])) {
                result[finalIndex] = nums2[j];
                finalIndex++;
                // 次数用完就删除
                if (RUN_OUT_OF_TIMES == count - 1) {
                    num2CountMapOfNums1.remove(nums2[j]);
                } else {
                    num2CountMapOfNums1.put(nums2[j], count - 1);
                }
            }
        }

        result = Arrays.copyOfRange(result, 0, finalIndex);
        return result;
    }

    /**
     * 两数之和（暴力版）.
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * You can return the answer in any order.
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2jrse/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumWithViolent(int[] nums, int target) {
        final int[] result = new int[2];
        final int length = nums.length;
        int pointer = 0;
        for (int i = 0; i < length; i++) {
            pointer = i + 1;
            while (pointer < length) {
                if (nums[i] + nums[pointer] == target) {
                    result[0] = i;
                    result[1] = pointer;
                    return result;
                }
                pointer++;
            }
        }

        return result;
    }

    /**
     * 两数之和（哈希表版）.
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * You can return the answer in any order.
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2jrse/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        final Map<Integer, Integer> result2IndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (result2IndexMap.containsKey(nums[i])) {
                return new int[] {result2IndexMap.get(nums[i]), i};
            }
            result2IndexMap.put(target - nums[i], i);
        }

        return new int[0];
    }
}
