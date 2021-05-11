```java
public class MedianFinder {

    private PriorityQueue<Integer> maxQueue;
    private PriorityQueue<Integer> minQueue;

    public MedianFinder() {
        maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        minQueue = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxQueue.size() > minQueue.size()) {
            maxQueue.offer(num);
            Integer poll = maxQueue.poll();
            minQueue.offer(poll);
        } else {
            minQueue.offer(num);
            Integer poll = minQueue.poll();
            maxQueue.offer(poll);
        }
    }

    public double findMedian() {
        if (maxQueue.size() == minQueue.size()) {
            return (double) (maxQueue.peek() + minQueue.peek()) / 2;
        } else if (maxQueue.size() > minQueue.size()) {
            return (double) maxQueue.peek();
        } else {
            return (double) minQueue.peek();
        }
    }
}

```

这里用了两个优先队列（堆），一个是大根堆、一个是小根堆。我们把数据中的较大值放到小根堆中反之较小的数据放到大根堆中，这样中间的两个堆顶的数据就是中间的数