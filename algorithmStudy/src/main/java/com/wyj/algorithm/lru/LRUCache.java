package com.wyj.algorithm.lru;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *  设计或构建一个“最近最少使用的缓存”，缓存从键映射到值，并在初始化时指定容量，当缓存被填满时，它
 *  应该删除最近最少使用的项目，它支持以下操作：获取数据的get和写入数据的put。
 *  思路：使用LinkedList + HashMap。LinkedList用来保存key的访问情况，最近访问的key放置到链表的最尾端。
 *      获取数据get：如果key在缓存中存在，则获取HashMap中key映射的value，LinkedList将key放置到链表的最尾端。如果key在缓存中
 *      不存在，则返回默认值。
 *      写入数据put：如果key在缓存中存在，则获取HashMap中key映射的value，LinkedList将key放置到链表的最尾端。如果key在缓存中
 *      不存在，判断链表大小是否超过容量，如果超过，则移除链表第一个元素，移除HashMap中指定的key-value对；LinkedList将新key
 *      添加到链表的最尾端，HashMap写入新的key-value对。
 *
 *  https://www.cnblogs.com/helloworldcode/p/13383856.html
 */
public class LRUCache {
    private HashMap<Integer, Integer> hashMap = null;
    private LinkedList<Integer> list = null;
    private int capacity;

    public LRUCache(int capacity) {
        hashMap = new HashMap<>(capacity);
        list = new LinkedList<>();
        this.capacity = capacity;
    }

    public Integer get(int key) {
        if (hashMap.containsKey(key)) {
            list.remove((Object)key);
            list.addLast(key);
            return hashMap.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (list.contains(key)) {
            list.remove((Object)key);
            list.addLast(key);
            hashMap.put(key, value);
            return;
        }
        if (list.size() == capacity) {
            Integer firstElement = list.get(0);
            list.remove(0);
            hashMap.remove((Object)firstElement);
        }
        list.addLast(key);
        hashMap.put(key, value);
    }
}
