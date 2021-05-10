package com.wjx.osiris.braum.leetcode.leetcode146;

import java.util.LinkedHashMap;

/**
 * @author wangjinxin
 * @date 2021/5/10 23:39
 * @mail wjxScott@iCloud.com
 * @description
 */
public class LRUCache {

    private LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        this.makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.remove(key);
            cache.put(key, value);
            return;
        }

        if (cache.size() == capacity) {
            int deleteKey = cache.keySet().iterator().next();
            cache.remove(deleteKey);
        }
        cache.put(key, value);
    }

    private void makeRecently(int key) {
        int value = cache.get(key);
        cache.remove(key);
        cache.put(key, value);
    }
}
