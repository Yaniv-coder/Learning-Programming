# ARTS第三周打卡

1. Algorithm：每周至少做一个 leetcode 的算法题
2. Review：阅读并点评至少一篇英文技术文章
3. Tip：学习至少一个技术技巧
4. Share：分享一篇有观点和思考的技术文章



## Algorithm

[122.买卖股票的最佳时机 II](https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2zsx1/)

贪心算法版：

```java
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
```



## Review

原文地址：[]()



## Tip



## Share

