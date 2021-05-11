```java
public class FreqStack {

    private Map<Integer, Integer> keyToFreqMap;

    private Map<Integer, Deque<Integer>> freqToStack;

    private Integer maxFreq;

    public FreqStack() {
        maxFreq = 0;
        keyToFreqMap = new HashMap<>();
        freqToStack = new HashMap<>();

    }

    public void push(int val) {
        int freq = keyToFreqMap.getOrDefault(val, 0);

        keyToFreqMap.put(val, freq + 1);


        freqToStack.putIfAbsent(freq + 1, new ArrayDeque<>());
        freqToStack.get(freq + 1).push(val);

        maxFreq = Math.max(maxFreq, freq + 1);
    }

    public int pop() {
        Deque<Integer> integerDeque = freqToStack.get(maxFreq);
        Integer value = integerDeque.pop();

        if (integerDeque.isEmpty()) {
            freqToStack.remove(maxFreq);
            maxFreq--;
        }

        Integer freq = keyToFreqMap.get(value);
        keyToFreqMap.put(value, freq - 1);
        return value;
    }
}
```

这种设计数据结构的问题，主要是要搞清楚问题的难点在哪里，然后结合各种基本数据结构的特性，高效实现题目要求的 API。

那么，我们仔细思考一下 push 和 pop 方法，难点如下：

1、每次 pop 时，必须要知道频率最高的元素是什么。

2、如果频率最高的元素有多个，还得知道哪个是最近 push 进来的元素是哪个。

为了实现上述难点，我们要做到以下几点：

1、肯定要有一个变量 maxFreq 记录当前栈中最高的频率是多少。

2、我们得知道一个频率 freq 对应的元素有哪些，且这些元素要有时间顺序。

3、随着 pop 的调用，每个 val 对应的频率会变化，所以还得维持一个映射记录每个 val 对应的 freq。

综上，我们可以先实现 FreqStack 所需的数据结构：

```java
class FreqStack {
    // 记录 FreqStack 中元素的最大频率
    int maxFreq = 0;
    // 记录 FreqStack 中每个 val 对应的出现频率，后文就称为 VF 表
    HashMap<Integer, Integer> valToFreq = new HashMap<>();
    // 记录频率 freq 对应的 val 列表，后文就称为 FV 表
    HashMap<Integer, Stack<Integer>> freqToVals = new HashMap<>();
}
```

其实这有点类似前文 LFU ，注意 freqToVals 中 val 列表用一个栈实现，如果一个 freq 对应的元素有多个，根据栈的特点，可以首先取出最近添加的元素。

注意我们在push相同的值的时候不需要删除原先freq中的栈中的元素，因为如果pop之后又会从这个栈中取出元素
