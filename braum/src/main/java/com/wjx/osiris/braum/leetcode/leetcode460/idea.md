```java
public class LFUCache {

    private Map<Integer, Integer> keyToValue;

    private Map<Integer, Integer> keyToFreq;

    private Map<Integer, LinkedHashSet<Integer>> freqToKey;

    private int minFreq;

    private int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        minFreq = 0;
        keyToValue = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKey = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToValue.containsKey(key)) {
            return -1;
        }

        increaseFreq(key);
        return keyToValue.get(key);
    }

    public void put(int key, int value) {
        if (keyToValue.containsKey(key)) {
            keyToValue.put(key, value);
            increaseFreq(key);
            return;
        }

        if (keyToValue.size() == capacity) {
            removeMinFreq();
        }

        keyToValue.put(key, value);
        keyToFreq.put(key, 1);

        freqToKey.putIfAbsent(1, new LinkedHashSet<>());
        freqToKey.get(1).add(key);
        minFreq = 1;
    }

    private void increaseFreq(int key) {
        Integer freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);

        LinkedHashSet<Integer> linkedHashSet = freqToKey.get(freq);
        linkedHashSet.remove(key);

        if (linkedHashSet.isEmpty()) {
            freqToKey.remove(freq);
            if (freq == minFreq) {
                minFreq++;
            }
        }

        freqToKey.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKey.get(freq + 1).add(key);
    }

    private void removeMinFreq() {
        LinkedHashSet<Integer> linkedHashSet = freqToKey.get(minFreq);
        Integer deleteKey = linkedHashSet.iterator().next();

        linkedHashSet.remove(deleteKey);

        if (linkedHashSet.isEmpty()) {
            freqToKey.remove(minFreq);
        }

        keyToValue.remove(deleteKey);
        keyToFreq.remove(deleteKey);
    }
}
```

一定先从最简单的开始，根据 LFU 算法的逻辑，我们先列举出算法执行过程中的几个显而易见的事实：

1、调用get(key)方法时，要返回该key对应的val。

2、只要用get或者put方法访问一次某个key，该key的freq就要加一。

3、如果在容量满了的时候进行插入，则需要将freq最小的key删除，如果最小的freq对应多个key，则删除其中最旧的那一个。

好的，我们希望能够在 O(1) 的时间内解决这些需求，可以使用基本数据结构来逐个击破：

1、使用一个HashMap存储key到val的映射，就可以快速计算get(key)。

HashMap<Integer, Integer> keyToVal; 2、使用一个HashMap存储key到freq的映射，就可以快速操作key对应的freq。

HashMap<Integer, Integer> keyToFreq; 3、这个需求应该是 LFU 算法的核心，所以我们分开说。

3.1、首先，肯定是需要freq到key的映射，用来找到freq最小的key。

3.2、将freq最小的key删除，那你就得快速得到当前所有key最小的freq是多少。想要时间复杂度 O(1) 的话，肯定不能遍历一遍去找，那就用一个变量minFreq来记录当前最小的freq吧。

3.3、可能有多个key拥有相同的freq，所以 freq对key是一对多的关系，即一个freq对应一个key的列表。

3.4、希望freq对应的key的列表是存在时序的，便于快速查找并删除最旧的key。

3.5、希望能够快速删除key列表中的任何一个key，因为如果频次为freq的某个key被访问，那么它的频次就会变成freq+1，就应该从freq对应的key列表中删除，加到freq+1对应的key的列表中。

HashMap<Integer, LinkedHashSet<Integer>> freqToKeys; int minFreq = 0; 介绍一下这个LinkedHashSet，它满足我们 3.3，3.4，3.5
这几个要求。你会发现普通的链表LinkedList能够满足 3.3，3.4 这两个要求，但是由于普通链表不能快速访问链表中的某一个节点，所以无法满足 3.5 的要求。

LinkedHashSet顾名思义，是链表和哈希集合的结合体。链表不能快速访问链表节点，但是插入元素具有时序；哈希集合中的元素无序，但是可以对元素进行快速的访问和删除。

那么，它俩结合起来就兼具了哈希集合和链表的特性，既可以在 O(1) 时间内访问或删除其中的元素，又可以保持插入的时序，高效实现 3.5 这个需求。