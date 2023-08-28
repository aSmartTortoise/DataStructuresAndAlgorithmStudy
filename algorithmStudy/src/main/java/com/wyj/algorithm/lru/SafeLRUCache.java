package com.wyj.algorithm.lru;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SafeLRUCache<K, V> {
    private final int capacity;
    private ConcurrentHashMap<K, V> cacheMap;
    private ConcurrentLinkedDeque<K> keys;
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock readLock = lock.readLock();
    private Lock writeLock = lock.writeLock();
    private ScheduledExecutorService scheduledExecutorService;

    public SafeLRUCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new ConcurrentHashMap<>(capacity);
        keys = new ConcurrentLinkedDeque<>();
        scheduledExecutorService = Executors.newScheduledThreadPool(10);
    }

    public V get(K key) {
        readLock.lock();
        try {
            if (cacheMap.containsKey(key)) {
                keys.remove(key);
                keys.add(key);
                return cacheMap.get(key);
            }
            return null;
        } finally {
            readLock.unlock();
        }
    }

    public boolean put(K key, V value, long expireTime) {
        writeLock.lock();
        try {
            if (cacheMap.containsKey(key)) {
                keys.remove(key);
                keys.add(key);
                cacheMap.put(key, value);
                return true;
            }
            if (cacheMap.size() == capacity) {
                K firstKey = keys.poll();
                if (firstKey != null) {
                    cacheMap.remove(firstKey);
                }
            }
            keys.add(key);
            cacheMap.put(key, value);
            if (expireTime > 0) {
                removeAfterExpireTime(key, expireTime);
            }
            return true;
        } finally {
            writeLock.unlock();
        }
    }

    public boolean remove(K key) {
        writeLock.lock();
        try {
            if (cacheMap.containsKey(key)) {
                keys.remove(key);
                cacheMap.remove(key);
                return true;
            }
            return false;
        } finally {
            writeLock.unlock();
        }
    }

    private void removeAfterExpireTime(K key, long expireTime) {
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                cacheMap.remove(key);
                keys.remove(key);
            }
        }, expireTime, TimeUnit.MILLISECONDS);
    }

    public int getSize() {
        return cacheMap.size();
    }
}
