package com.wyj.algorithm.datastructures.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

class SingleLinkedListTest {

    @Test
    void loop() {
        SingleLinkedList list = new SingleLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.loop(integer -> System.out.println(integer));
    }

    @Test
    void testLoop() {
        SingleLinkedList list = new SingleLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        list.forEach(integer -> System.out.println(integer));
    }

    @Test
    void test2() {
        SingleLinkedList list = new SingleLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        assertIterableEquals(List.of(1, 2, 3, 4), list);
    }

    @Test
    void test3() {
        SingleLinkedList list = new SingleLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        int value = list.get(10);
        System.out.println(value);
    }

    @Test
    void test4() {
        SingleLinkedList list = new SingleLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.insert(2, 5);
        for (Integer value: list) {
            System.out.println(value);
        }
    }
}