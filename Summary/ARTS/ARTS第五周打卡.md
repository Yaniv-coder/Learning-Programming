# ARTS第五周打卡

1. Algorithm：每周至少做一个 leetcode 的算法题
2. Review：阅读并点评至少一篇英文技术文章
3. Tip：学习至少一个技术技巧
4. Share：分享一篇有观点和思考的技术文章



## Algorithm

[350. Intersection of Two Arrays II](https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/)

哈希表版（比较复杂）：

```java
import java.util.Map.Entry;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
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
     * @param nums 需要统计的数组
     * @param num2CntMap 该函数存放统计结果的map
     */
    private void countNumOccurences(final int[] nums, final Map<Integer, Integer> num2CntMap) {
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
     * @param num2CntMapOuter 外层循环的map
     * @param num2CntMapInner 循环内层取数的map
     * @param arrLength 结果数组长度
     * @return 结果数组
     */
    private int[] generateResult(final Map<Integer, Integer> num2CntMapOuter, final Map<Integer, Integer> num2CntMapInner, final int arrLength) {
        int[] resultArr = new int[0];
        for (Entry<Integer, Integer> entry : num2CntMapOuter.entrySet()) {
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
}
```

哈希表版（精简版）：
```java
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
```

哈希表版（python实现）
由于最近刚学完python，所以拿python练练手；跟Java一对比，代码确实精炼不少，非常优雅。
```python
def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
    if len(nums1) > len(nums2):
        return self.intersect(nums2, nums1)
    
    num2_count_dict = {}
    for num in nums1:
        num2_count_dict[num] = num2_count_dict.get(num, 0) + 1
    
    intersectList = []
    for num in nums2:
        if num in num2_count_dict:
            intersectList.append(num)
            num2_count_dict[num] -= 1
            if num2_count_dict[num] == 0:
                num2_count_dict.pop(num)

    return intersectList
```

先排序，再用双指针比较两个数组中的数字。
```python
def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
    if len(nums1) > len(nums2):
        return self.intersect(nums2, nums1)
    nums1.sort()
    nums2.sort()
    
    nums1_pointer = 0
    nums2_pointer = 0
    intersect_result = []
    while (nums1_pointer < len(nums1)) and (nums2_pointer < len(nums2)):
        num1 = nums1[nums1_pointer]
        num2 = nums2[nums2_pointer]
        if num1 == num2:
            intersect_result.append(num1)
            nums1_pointer += 1
            nums2_pointer += 1
        elif num1 > num2:
            nums2_pointer += 1
        else:
            nums1_pointer += 1
    
    return intersect_result
```


## Review

原文地址：[Medium WetSite:As a tech guy, you will thank me for these websites](https://blog.devgenius.io/as-a-tech-guy-you-will-thank-me-for-these-websites-be09e86ebcef)
该文章介绍了几个好用的网站。

## Tip



## Share

