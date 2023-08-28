package com.wyj.algorithm.lru;

import java.util.LinkedHashMap;

public class LRUCache2<K, V> {
    private final int capacity;
    private LinkedHashMap<K, V> cache;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>();
    }

    public V get(K key) {
        if (cache.containsKey(key)) {
            makeRecently(key);
            return cache.get(key);
        }
        return null;
    }

    public boolean put(K key, V value) {
        if (cache.containsKey(key)) {
            makeRecently(key);
            cache.put(key, value);
            return true;
        }
        if (cache.size() == capacity) {
            K next = cache.keySet().iterator().next();
            cache.remove(next);
        }
        cache.put(key, value);
        return true;
    }

    private void makeRecently(K key) {
        V value = cache.get(key);
        cache.remove(key);
        cache.put(key, value);
    }
}
