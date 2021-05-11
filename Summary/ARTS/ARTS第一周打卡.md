# ARTS第一周打卡

1. Algorithm：每周至少做一个 leetcode 的算法题
2. Review：阅读并点评至少一篇英文技术文章
3. Tip：学习至少一个技术技巧
4. Share：分享一篇有观点和思考的技术文章



## Algorithm

[3. 无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)

很久没有做算法题了，感觉很生疏，解题比较慢，一开始就想到了最笨的办法，直接通过两层for循环去查找最长子串，提交后耗时比较长，124ms；于是去查看高人们的代码思路，学到了一个让人眼前一亮的方法，不由感叹该方法之妙。

优化版本：

```java
/**
 * 求解无重复字符的最长字串.
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
```

暴力求解版本：

```java
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
```



## Review

原文地址：[Teach Yourself Programming in Ten Years (norvig.com)](http://norvig.com/21-days.html)

这篇文章主要阐述了一个观点：要想学好学精一种技术，需要有十年磨一剑的决心。

当今社会充斥着各种各样的速成书及培训，这种俗称只能让你学一个皮毛，可能连入门都算不上。

作者也给出了几点对学习编程有意义的方法，长期按作者给出的方法来学习编程，一定会有所成长。

