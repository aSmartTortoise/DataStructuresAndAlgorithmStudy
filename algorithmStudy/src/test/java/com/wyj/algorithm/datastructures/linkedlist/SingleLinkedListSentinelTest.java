package com.wyj.algorithm.datastructures.linkedlist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SingleLinkedListSentinelTest {

    @Test
    void test1() {
        SingleLinkedListSentinel list = getLinkedList();

        assertIterableEquals(List.of(1, 2, 3, 4), list);
    }

    @Test
    @DisplayName("测试get方法")
    void test3() {
        SingleLinkedListSentinel list = getLinkedList();
        assertEquals(3, list.get(2));
        assertThrows(IllegalArgumentException.class, () -> list.get(10));
    }

    @Test
    @DisplayName("测试insert方法")
    void test4() {
        SingleLinkedListSentinel list = getLinkedList();
        list.insert(0, 5);
        assertIterableEquals(List.of(5, 1, 2, 3, 4), list);

        list = getLinkedList();
        list.insert(2, 5);
        assertIterableEquals(List.of(1, 2, 5, 3, 4), list);

        list = getLinkedList();
        list.insert(4, 5);
        assertIterableEquals(List.of(1, 2, 3, 4, 5), list);

        assertThrows(IllegalArgumentException.class, () -> getLinkedList().insert(5, 5));

        list = getLinkedList();
        list.addFirst(5);
        assertIterableEquals(List.of(5, 1, 2, 3, 4), list);

        SingleLinkedListSentinel list2 = new SingleLinkedListSentinel();
        list2.addFirst(1);
        assertIterableEquals(List.of(1), list2);
    }

    @Test
    @DisplayName("测试remove方法")
    void test5() {
        SingleLinkedListSentinel list = getLinkedList();
        list.remove(0);
        assertIterableEquals(List.of(2, 3, 4), list);

        list = getLinkedList();
        list.remove(3);
        assertIterableEquals(List.of(1, 2, 3), list);

        list = getLinkedList();
        list.remove(1);
        assertIterableEquals(List.of(1, 3, 4), list);

        assertThrows(IllegalArgumentException.class, () -> getLinkedList().remove(4));

        assertThrows(IllegalArgumentException.class, () -> getLinkedList().remove(5));

        list = getLinkedList();
        list.removeFirst();
        assertIterableEquals(List.of(2, 3, 4), list);
    }

    private static SingleLinkedListSentinel getLinkedList() {
        SingleLinkedListSentinel list = new SingleLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        return list;
    }


}