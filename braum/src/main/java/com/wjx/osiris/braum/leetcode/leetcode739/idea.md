```java
public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[temperatures.length];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[i] >= stack.peek()) {
                stack.pop();
            }

            int maxTemp = stack.isEmpty() ? -1 : stack.peek();

            if (maxTemp == -1) {
                result[i] = 0;
            } else {
                Integer day = map.get(maxTemp);
                result[i] = day - i;
            }
            stack.push(temperatures[i]);
            map.put(temperatures[i], i);
        }
        return result;
    }
}
```

利用栈来获取到到下一个大值的方式，利用map来存放上一个值的时间，这样计算差值就是我们需要的差距天数