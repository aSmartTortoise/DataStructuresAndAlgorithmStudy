package com.wyj.algorithm.datastructures.linkedlist;

import java.util.Iterator;

/**
 *  双向环形链表。
 *  默认有一个哨兵节点sentinel。sentinel节点既是头，也是尾。
 *
 */
public class DoublyCircularLinkedListSentinel implements Iterable<Integer> {

    private Node sentinel;


    /**
     *  构造过程中，初始化sentinel
     *  sentinel.prev = sentinel; sentinel.next = sentinel;
     */
    public DoublyCircularLinkedListSentinel() {
        sentinel = new Node(null, -1, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    static class Node {
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 头部插入元素
     * 1 根据sentinel获取上一个节点prev和下一个节点next。
     * 2 钩爪一个新节点added，added.prev = prev, added.next = next。
     * 3 prev.next = added; next.prev = added。
     *
     */
    public void addFirst(int value) {
        Node prev = sentinel;
        Node next = sentinel.next;
        Node added = new Node(prev, value, next);
        prev.next = added;
        next.prev = added;
    }

    /**
     *  尾部插入元素
     *  1 根据sentinel，获取上一个节点prev，和下一个节点next。
     *  2 构造一个新节点added，added.prev = prev; added.next = next。
     *  3 prev.next = added; next.prev = added。
     * @param value
     */
    public void addLast(int value) {
        Node prev = sentinel.prev;
        Node next = sentinel;
        Node added = new Node(prev, value, next);
        prev.next = added;
        next.prev = added;
    }

    /**
     *  1 根据sentinel获取第一个元素removed，上一个节点prev，下一个节点next。
     *  2 prev.next = next; next.prev = prev。
     *  边界场景：
     *  1 链表为空，removed == sentinel
     */
    public void removeFirst() {
        Node removed = sentinel.next;
        if (removed == sentinel) {
            throw new IllegalStateException("链表为空，不支持该操作。");
        }
        Node prev = sentinel;
        Node next = removed.next;
        prev.next = next;
        next.prev = prev;
    }

    /**
     *  删除最后一个节点
     *  1 根据sentinel获取最后一个节点removed；获取下一个节点next，上一个节点prev。
     *  2 prev.next = next; next.prev = prev;
     */
    public void removeLast() {
        Node removed = sentinel.prev;
        if (removed == sentinel) {
            throw new IllegalStateException("链表为空，不支持该操作。");
        }
        Node prev = removed.prev;
        Node next = removed.next;
        prev.next = next;
        next.prev = prev;
    }

    /**
     * 1 先遍历链表，找到指定value的节点removed；上一个节点prev，下一个节点next。
     * @param value
     */
    public void removeByValue(int value) {
        Node removed = findNodeByValue(value);
        if (removed == null) {
            return;
        }
        Node prev = removed.prev;
        Node next = removed.next;
        prev.next = next;
        next.prev = prev;
    }


    private Node findNodeByValue(int value) {
        Node p = sentinel.next;
        while (p != sentinel) {
            if (p.value == value) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            Node p = sentinel.next;
            @Override
            public boolean hasNext() {
                return p != sentinel ;
            }

            @Override
            public Integer next() {
                int currentValue = p.value;
                p = p.next;
                return currentValue;
            }
        };
    }


}
