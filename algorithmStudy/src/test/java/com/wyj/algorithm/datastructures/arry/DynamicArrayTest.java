package com.wyj.algorithm.datastructures.arry;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

import static org.junit.jupiter.api.Assertions.*;

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

}