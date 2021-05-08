```java
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int arg1 = target - nums[i];
            if (map.get(arg1) != null && map.get(arg1) != i) {
                result[0] = i;
                result[1] = map.get(arg1);
                break;
            }
        }
        return result;
    }
}
```

先将数组循环一次将数组的坐标和值存放到map中，之后遍历数组，计算目标target与数组元素的差值，如果这个差值在map中那么就可以直接返回，否则再次进行下一个元素的计算，这个要注意返回的下标不能相同，所以要判断map中的结果与目前坐标是否相等。

优化方案：
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null) {
                result[0] = index;
                result[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }
}
```

将第一次的循环和后面的判断合并，当算出来结果不存在于map中时存入map，主要减少了最开始的一次循环