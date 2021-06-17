# ARTS第四周打卡

1. Algorithm：每周至少做一个 leetcode 的算法题
2. Review：阅读并点评至少一篇英文技术文章
3. Tip：学习至少一个技术技巧
4. Share：分享一篇有观点和思考的技术文章



## Algorithm

[189. 旋转数组](https://leetcode-cn.com/problems/rotate-array)

使用额外的数组版：

```java
public void rotateUseAnotherArr(int[] nums, int k) {
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
```

环形链表依次交换，低性能版：

```java
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

```

环形链表依次交换版：

```java
/**
* 189. 旋转数组（环形链表依次交换）
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

```

数组反转版：

```java
/**
* 189. 旋转数组（数组反转法）
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
```



## Review

原文地址：[]()



## Tip



## Share

