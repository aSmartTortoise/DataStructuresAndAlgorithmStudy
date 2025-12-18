package com.wyj.algorithm.datastructures.linkedlist;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 双向链表，带两个哨兵节点
 *
 * 链表中默认有两个个哨兵节点，一个是head，一个是tail。
 *
 * 双向链表中的尾哨兵是已知的。双向链表从尾部添加节点和从尾部删除节点的性能要好于单向链表。
 */
public class DoublyLinkedListSentinel implements Iterable<Integer>{

    private Node head;// 头哨兵
    private Node tail;// 尾哨兵

    /**
     *  在构造过程中初始化head，tail哨兵；
     *  head.prev = null; tail.next = null;
     *  head.next = tail; tail.prev = head;
     */
    public DoublyLinkedListSentinel() {
        head = new Node(null, -1, null);
        tail = new Node(null, -1, null);
        head.next = tail;
        tail.prev = head;
    }

    /**
     *  头部插入元素。
     *  链表为空时，head为null。
     */
    public void addFirst(int value) {
        insert(0, value);
    }

    /**
     *  尾部插入元素
     *  1 根据尾节点tail获取链表中最后一个节点last。
     *  2 构造一个新节点added，它的上一个节点指针指向last，下一个节点指针指向tail。
     *  3 last.next = added; tail.prev = added。
     */
    public void addLast(int value) {
        Node last = tail.prev;
        Node added = new Node(last, value, tail);
        last.next = added;
        tail.prev = added;
    }



    public void loop(Consumer< Integer> consumer) {
    }

    public int get(int index) {
        Node node = findNode(index);
        if (node == null) {
            throw illegalIndex(index);
        }

        return node.value;
    }

    private IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(String.format("index [%d] 不合法%n", index));
    }

    /**
     * 在指定索引插入元素
     * Throws: IllegalArgumentException - 指定索引的前一个节点不存在，抛出索引不合法异常。
     *  1 先获取上一个索引的节点perv，得到下一个索引的节点next=prev.next。
     *  2 构造一个新节点inserted，新节点的上一个节点指针指向prev节点，下一个节点指向next。
     *  3 prev的下一个节点指针指向inserted；next的上一个节点指针指向inserted。
     */
    public void insert(int index, int value) {
        Node prev = findNode(index - 1);// 先获取上一个索引的节点
        if (prev == null) {
            throw illegalIndex(index);
        }
        Node next = prev.next;
        Node inserted = new Node(prev, value, next);
        prev.next = inserted;
        next.prev = inserted;
    }

    /**
     * 头节点的索引为-1，
     * @param index
     * @return
     */
    private Node findNode(int index) {
        int i = -1;
        Node p = head;
        while (p != tail) {
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
     *  1 先根据尾哨兵获取最后一个元素removed；获取removed的上一个节点prev。
     *  2 prev.next = tail; tail.prev = prev;
     *
     *  边界场景：
     *  1 链表为空，removed == head。
     *
     */
    public void removeLast() {
        Node removed = tail.prev;
        if (removed == head) {
            throw new IllegalStateException("当前链表为空，不支持该操作");
        }
        Node prev = removed.prev;
        prev.next = tail;
        tail.prev = prev;
    }

    /**
     *  删除指定索引的元素
     * @param index-索引
     * Throws: IllegalArgumentException-抛出索引非法的异常。
     *  1 先获取上一个索引的节点prev；得到待删除的节点Node removed = prev.next；得到下一个索引的节点
     *     Node next = removed.next。
     *  2 prev的下一个节点指针指向next；next上一个节点的指针指向prev。
     *
     *  边界场景：
     *  1 prev == null；
     *  2 removed == tail；
     */
    public void remove(int index) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }

        Node removed = prev.next;
        Node next = removed.next;
        if (next == tail) {
            throw illegalIndex(index);
        }
        prev.next = next;
        next.prev = prev;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;

            @Override
            public boolean hasNext() {
                return p != tail;
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
        Node prev;// 上一个节点
        int value;//
        Node next;//下一个节点指针

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }
}
