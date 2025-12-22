package com.wyj.algorithm.datastructures.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

class SingleLinkedListTest {

    @Test
    void loop() {
        SingleLinkedList list = getList();
        list.loop(integer -> System.out.println(integer));
    }

    @Test
    void testLoop() {
        SingleLinkedList list = getList();
        list.forEach(integer -> System.out.println(integer));
    }

    @Test
    void test2() {
        SingleLinkedList list = getList();
        assertIterableEquals(List.of(1, 2, 3, 4), list);
    }

    @Test
    void test3() {
        SingleLinkedList list = getList();
        int value = list.get(10);
        System.out.println(value);
    }

    @Test
    void test4() {
        SingleLinkedList list = getList();

        list.insert(2, 5);
        for (Integer value: list) {
            System.out.println(value);
        }
    }

    private static SingleLinkedList getList() {
        SingleLinkedList list = new SingleLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        return list;
    }

    @Test
    void test5() {
        SingleLinkedList list = getList();
        list.loop2(value -> System.out.println("before:" + value),
                value -> System.out.println("after:" + value));
    }
}