package com.wjx.osiris.braum.leetcode.leetcode895;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangjinxin
 * @date 2021/5/11 23:21
 * @mail wjxScott@iCloud.com
 * @description
 */
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
