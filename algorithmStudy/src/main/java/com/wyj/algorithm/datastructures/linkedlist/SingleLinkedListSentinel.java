package com.wyj.algorithm.datastructures.linkedlist;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 单向链表，带哨兵节点
 *
 * 链表中默认有一个哨兵节点。
 */
public class SingleLinkedListSentinel implements Iterable<Integer>{

    private Node head = new Node(-1, null);//头指针指向哨兵节点

    /**
     *  头部插入元素。
     *  链表为空时，head为null。
     */
    public void addFirst(int value) {
        insert(0, value);
    }

    /**
     *  尾部插入元素
     */
    public void addLast(int value) {
        Node last = findLast();
        last.next = new Node(value, null);
    }


    /**
     * 获取链表中的尾节点。
     */
    private Node findLast() {
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    public void loop(Consumer< Integer> consumer) {
        Node p = head.next;
        while (p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    public int get(int index) {
        Node node = findNode(index);
        if (node == null) {
            throw illegalIndex(index);
        }

        return node.value;
    }

    private static IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(String.format("index [%d] 不合法%n", index));
    }

    /**
     * 在指定索引插入元素
     * Throws: IllegalArgumentException - 指定索引的前一个节点不存在，抛出索引不合法异常。
     */
    public void insert(int index, int value) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }
        prev.next = new Node(value, prev.next);
    }

    private Node findNode(int index) {
        int i = -1;
        Node p = head;
        while (p != null) {
            if (index == i) {
                return p;
            }
            p = p.next;
            i++;
        }
        return null;
    }

    public void removeFirst() {
        remove(0);
    }

    /**
     *  删除指定索引的元素
     * @param index-索引
     * Throws: IllegalArgumentException-抛出索引非法的异常。
     */
    public void remove(int index) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }

        Node removed = prev.next;
        if (removed == null) {
            throw illegalIndex(index);
        }
        prev.next = removed.next;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;

            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public Integer next() {
                int currentValue = p.value;
                p = p.next;
                return currentValue;
            }
        };
    }


    /**
     *  节点来
     */
    private static class Node {
        int value;//
        Node next;//下一个节点指针

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
