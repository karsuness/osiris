```java
public class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : stones) {
            priorityQueue.add(num);
        }

        while (priorityQueue.size() > 0) {
            if (priorityQueue.size() == 1) {
                return priorityQueue.poll();
            }

            int result = priorityQueue.poll() - priorityQueue.poll();

            if (result != 0) {
                priorityQueue.add(result);
            }
        }
        return 0;
    }
}
```

使用Java自带的堆来完成排序每次取出前两个处理，直到堆的大小为0或者只有一个为止