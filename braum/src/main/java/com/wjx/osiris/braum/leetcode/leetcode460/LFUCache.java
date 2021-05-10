package com.wjx.osiris.braum.leetcode.leetcode460;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author wangjinxin
 * @date 2021/5/11 00:31
 * @mail wjxScott@iCloud.com
 * @description
 */
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
