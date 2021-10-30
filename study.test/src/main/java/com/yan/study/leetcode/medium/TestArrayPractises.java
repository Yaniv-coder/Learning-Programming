package com.yan.study.leetcode.medium;

import com.yan.study.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode数组练习题——中等.
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
        int[] nums = new int[]{1, 2};

//        rotateUseAnotherArr(nums, 2);
//        rotateUseCycleWithLowPerformance(nums, 2);
//        rotateUseCycle(nums, 10);
        rotate(nums, 10);
        CommonUtils.printIntArray(nums);
    }

    /**
     * 3.无重复字符的最长子串（最优解）.
     *
     * @param s 给定字符串
     * @return 最长子串长度
     */
    public static int lengthOfLongestSubstring(final String s) {
        // 遍历过的字符存放在该数组中
        final int[] lastArr = new int[128];
        final int length = s.length();

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
     *
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
     * 189. 旋转数组（使用额外的数组）
     * <p>
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * <p>
     * 进阶：
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rotate-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums 给定的数组
     * @param k    给定需要移动的步长
     */
    public static void rotateUseAnotherArr(int[] nums, int k) {
        if (1 >= nums.length) {
            return;
        }

        final int[] localNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            localNums[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = localNums[i];
        }
    }

    /**
     * 189. 旋转数组（环形链表依次交换，低性能版）
     * <p>
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * <p>
     * 进阶：
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rotate-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums 给定的数组
     * @param k    给定需要移动的步长
     */
    public static void rotateUseCycleWithLowPerformance(int[] nums, int k) {
        if (1 >= nums.length) {
            return;
        }

        int n = nums.length;
        k = k % n;
        int count = 0;
        int i = 0;
        int temp = nums[0];
        // 被访问过的元素下标
        List visited = new ArrayList();

        // 当前下标走了指定步数后，将走完步数后位置的值替换为原来位置的值（存放在临时变量中），
        // 而该处的值则放入临时变量中；
        // 直到总共走了数组大小的次数停止。
        while (count < n) {
            // 走指定步数后的下标，也是下一次循环将要使用的下标
            int nextIndex = (i + k) % n;
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

    /**
     * 189. 旋转数组（环形链表依次交换）
     * <p>
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * <p>
     * 进阶：
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rotate-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * 思路：
     * 1. 先将给定的步长k与数组长度求余；
     * 2. 利用中间变量，开始时将中间变量值设为第一个元素的值，每次将上一个间隔k长度的元素值替换到当前元素，并把当前元素的值存入中间变量；
     * 3. 一轮循环按步长走的话（当然，k不为0或负数时），肯定不能遍历到所有的元素，因此需要计算出需要循环几次（这个需要有数学功底，推导出数学公式）；
     * 或者加入一个计数器，记录当前总共遍历了几个元素，当计数器的数量等于数组的长度时，停止循环。
     * 4. 循环结束，此时数组就是想要的结果了。
     *
     * @param nums 给定的数组
     * @param k    给定需要移动的步长
     */
    public static void rotateUseCycle(int[] nums, int k) {
        final int n = nums.length;
        if ((1 >= n) || (0 >= k)) {
            return;
        }

        k %= n;
        // 遍历元素计数器，当其等于数组长度时，停止遍历
        int count = 0;
        int preNum = nums[0];
        int temp;
        int j;
        for (int i = 0; i < n; i++) {
            j = i;
            preNum = nums[i];
            do {
                // 保证第一个元素能被正常替换
                j = (j + k) % n;
                temp = preNum;
                preNum = nums[j];
                nums[j] = temp;
                ++count;
            } while (j != i);

            // 其元素计数器等于数组长度时，停止遍历
            if (count == n) {
                break;
            }
        }
    }

    /**
     * 189. 旋转数组（数组反转法）
     * <p>
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * <p>
     * 进阶：
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rotate-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * 思路：
     * 1. 因为走k个步长，数组尾部k个元素肯定都会移到数组头部，所以，先将数组整个反转过来，让尾部的元素到头部；
     * 2. 然后，让反转后的数组头部k个元素再次进行反转，变为原来的顺序；
     * 3. 再然后，让剩下的n-k个元素进行反转，完成。
     * （这个反转的顺序对结果没有影响。）
     *
     * @param nums 给定的数组
     * @param k    给定需要移动的步长
     */
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        if ((0 >= k) || (1 >= n)) {
            return;
        }

        // 反转全部
        reverse(nums, 0, n - 1);
        // 反转前k个
        reverse(nums, 0, k % n - 1);
        // 反转剩余的
        reverse(nums, k % n, n - 1);
    }

    /**
     * 反转指定的一段数组.
     *
     * @param nums  需要反转的数组
     * @param start 反转区间的起点
     * @param end   反转区间的终点
     */
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            nums[start] ^= nums[end];
            nums[end] ^= nums[start];
            nums[start] ^= nums[end];
            ++start;
            --end;
        }
    }
}
