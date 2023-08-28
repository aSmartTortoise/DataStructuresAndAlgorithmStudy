package com.wyj.algorithm.lru;

public class LRUTest {
    public static void main(String[] args) throws InterruptedException{
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("get(1):" + cache.get(1));
        cache.put(3, 3);
        System.out.println("get(2):" + cache.get(2));
        cache.put(4, 4);
        System.out.println("get(1):" + cache.get(1));
        System.out.println("----------------");
        SafeLRUCache<Integer, String> safeCache = new SafeLRUCache<>(10);
        safeCache.put(1, "Java", 1000);
        safeCache.put(2, "C++", 2000);
        safeCache.put(3, "Java", 3000);
        System.out.println("safeCache size:" + safeCache.getSize());
        Thread.sleep(2000);
        System.out.println("after 2s, safeCache size:" + safeCache.getSize());
    }
}