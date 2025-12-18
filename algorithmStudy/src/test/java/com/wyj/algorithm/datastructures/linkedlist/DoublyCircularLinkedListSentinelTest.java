package com.wyj.algorithm.datastructures.linkedlist;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class DoublyCircularLinkedListSentinelTest {

    @Test
    @DisplayName("测试addFirst")
    void addFirst() {
        DoublyCircularLinkedListSentinel list = new DoublyCircularLinkedListSentinel();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        assertIterableEquals(List.of(4, 3, 2, 1), list);
    }

    @Test
    void addLast() {
        DoublyCircularLinkedListSentinel list = getList();
        assertIterableEquals(List.of(1, 2, 3, 4), list);
    }

    private DoublyCircularLinkedListSentinel getList() {
        DoublyCircularLinkedListSentinel list = new DoublyCircularLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        return list;
    }

    @Test
    @DisplayName("测试removeFirst方法")
    void removeFirst() {
        DoublyCircularLinkedListSentinel list = getList();
        list.removeFirst();
        assertIterableEquals(List.of(2, 3, 4), list);
        list.removeFirst();
        assertIterableEquals(List.of(3, 4), list);
        list.removeFirst();
        assertIterableEquals(List.of(4), list);
        list.removeFirst();

        assertThrows(IllegalStateException.class, list::removeFirst);
    }

    @Test
    @DisplayName("测试removeLast方法")
    void removeLast() {
        DoublyCircularLinkedListSentinel list = getList();
        list.removeLast();
        assertIterableEquals(List.of(1, 2, 3), list);

        list.removeLast();
        assertIterableEquals(List.of(1, 2), list);

        list.removeLast();
        assertIterableEquals(List.of(1), list);

        list.removeLast();
        assertIterableEquals(List.of(), list);

        assertThrows(IllegalStateException.class, list::removeLast);
    }

    @Test
    @DisplayName("测试removeByValue")
    void removeByValue() {
        DoublyCircularLinkedListSentinel list = getList();
        list.removeByValue(1);
        assertIterableEquals(List.of(2, 3, 4), list);

        list.removeByValue(4);
        assertIterableEquals(List.of(2, 3), list);

    }
}