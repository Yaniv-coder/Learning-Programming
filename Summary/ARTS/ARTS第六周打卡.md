# ARTS第六周打卡

1. Algorithm：每周至少做一个 leetcode 的算法题
2. Review：阅读并点评至少一篇英文技术文章
3. Tip：学习至少一个技术技巧
4. Share：分享一篇有观点和思考的技术文章



## Algorithm

[1. Two Sum](https://leetcode-cn.com/problems/two-sum/)

暴力版：

```java
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

```

哈希表版（精简版）：
```java
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
```


## Review

原文地址：[]()


## Tip
Oracle数据库中，一个中文是占3个字节的。


## Share

