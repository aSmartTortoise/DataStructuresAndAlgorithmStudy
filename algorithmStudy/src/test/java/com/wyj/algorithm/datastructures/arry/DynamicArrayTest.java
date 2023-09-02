package com.wyj.algorithm.datastructures.arry;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

import static org.junit.jupiter.api.Assertions.*;

/**
 *  动态数组 插入和删除的时间复杂度
 *      1 从头部插入
 *          需要移动元素的位置，O(n)
 *      2 从中间插入
 *          需要移动元素位置。O(n)
 *      3 从尾部插入
 *          不需要移动元素位置。O(1)。
 *
 */
class DynamicArrayTest {

    @Test
    public void test1() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(2);
        dynamicArray.addLast(7);
        dynamicArray.addLast(9);
        dynamicArray.addLast(15);
        dynamicArray.foreach(System.out::println);
    }

    @Test
    public void test2() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(2);
        dynamicArray.addLast(7);
        dynamicArray.addLast(9);
        dynamicArray.addLast(15);
        for (Integer element: dynamicArray) {
            System.out.println(element);
        }
    }

    @Test
    public void test3() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(2);
        dynamicArray.addLast(7);
        dynamicArray.addLast(9);
        dynamicArray.addLast(15);
        dynamicArray.stream().forEach(System.out::println);
    }

    @Test
    public void test4() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(2);
        dynamicArray.addLast(7);
        dynamicArray.addLast(9);
        dynamicArray.addLast(15);
        dynamicArray.addLast(15);
        dynamicArray.addLast(20);

        int removed = dynamicArray.remove(2);
        System.out.println(removed);
        System.out.println("----------------");
        dynamicArray.stream().forEach(System.out::println);

    }


    @Test
    @DisplayName("测试删除")
    public void test5() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(2);
        dynamicArray.addLast(7);
        dynamicArray.addLast(9);
        dynamicArray.addLast(15);
        dynamicArray.addLast(15);
        dynamicArray.addLast(20);

        int removed = dynamicArray.remove(2);
        assertEquals(9, removed);
        assertIterableEquals(List.of(2, 7, 15, 15, 20), dynamicArray);
    }

    @Test
    @DisplayName("测试扩容")
    public void test6() {
        DynamicArray dynamicArray = new DynamicArray();
        for (int i = 0; i < 9; i++) {
            dynamicArray.addLast(i + 1);
        }
        assertIterableEquals(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9), dynamicArray);
    }

}