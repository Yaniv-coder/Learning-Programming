# ARTS第二周打卡

1. Algorithm：每周至少做一个 leetcode 的算法题
2. Review：阅读并点评至少一篇英文技术文章
3. Tip：学习至少一个技术技巧
4. Share：分享一篇有观点和思考的技术文章



## Algorithm

[26. 删除有序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)

优化版本，即双指针法：

```java
public static int optimizationRemoveDuplicates(int[] nums) {
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
```

利用Set去重特性的版本：

```java
public static int removeDuplicates(int[] nums) {
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
```



## Review

原文地址：[Why low code software development is eating the world](https://blog.devgenius.io/why-low-code-software-development-is-eating-the-world-ca5d9644a821)
该文章主要讲了目前流行的少量代码开发网站的各方面，且越来越多的网站利用了`low-code`来开发。



## Tip
编码习惯问题：原来处理空值的时候直接返回一个`null`或者抛异常；直到我看了一篇代码优化的文章，才发现有更好的写法，就是直接返回一个空对象，如果是集合就返回一个空集合。这样不用在代码中写很多`if else`去判断空值问题了，代码就会变得更加简洁。




## Share

