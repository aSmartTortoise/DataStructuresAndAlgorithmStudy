package com.wyj.algorithm.datastructures.linkedlist;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 单向链表
 */
public class SingleLinkedList implements Iterable<Integer>{

    private Node head;

    /**
     *  头部插入元素。
     *  链表为空时，head为null。
     */
    public void addFirst(int value) {
        //链表为空
//        head = new Node(value, null);
        //链表不为空
        head = new Node(value, head);
    }

    /**
     *  尾部插入元素
     */
    public void addLast(int value) {
        Node last = findLast();
        if (last == null) {
            addFirst(value);
        } else {
            last.next = new Node(value, null);
        }
    }


    /**
     * 获取链表中的尾节点。
     */
    private Node findLast() {
        if (head == null) {
            return null;
        }

        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    public void loop(Consumer< Integer> consumer) {
        Node p = head;
        while (p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    public void loop2(Consumer<Integer> before, Consumer<Integer> after) {
        recursion(head, before, after);
    }

    private void recursion(Node node, Consumer<Integer> before, Consumer<Integer> after) {
        if (node == null) {
            return;
        }
        before.accept(node.value);
        recursion(node.next, before, after);
        after.accept(node.value);
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
        if (index == 0) {
            addFirst(value);
        } else {
            Node prev = findNode(index - 1);
            if (prev == null) {
                throw illegalIndex(index);
            }
            prev.next = new Node(value, prev.next);
        }
    }

    private Node findNode(int index) {
        int i = 0;
        Node p = head;
        while (p.next != null) {
            p = p.next;
            i++;
            if (index == i) {
                return p;
            }
        }
        return null;
    }

    public void removeFirst() {
        if (head == null) {
            throw illegalIndex(0);
        } else {
            head = head.next;
        }
    }

    /**
     *  删除指定索引的元素
     * @param index-索引
     * Throws: IllegalArgumentException-抛出索引非法的异常。
     */
    public void remove(int index) {
        if (index == 0) {
            removeFirst();
            return;
        }

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
            Node p = head;

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
