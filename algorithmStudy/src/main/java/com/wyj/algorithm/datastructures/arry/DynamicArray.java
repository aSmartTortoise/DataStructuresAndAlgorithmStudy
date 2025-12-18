package com.wyj.algorithm.datastructures.arry;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * 动态数组
 * https://www.bilibili.com/video/BV1Lv4y1e7HL?spm_id_from=333.788.player.switch&vd_source=7a19c934b34181e45c9e4b97735a0ed8&p=23
 */
public class DynamicArray implements Iterable<Integer>{
    private int size;
    private int capacity = 8;
    private int[] array = new int[capacity];

    public void addLast(int element) {
//        array[size] = element;
//        size++;
        add(size, element);
    }

    public void add(int index, int element) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is illegal.");
        }

        checkAndGrow();

        if (index < size) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }

        array[index] = element;
        size++;
    }

    private void checkAndGrow() {
        if (size == 0) {
            array = new int[capacity];
        } else if (size == capacity) {//需要扩容 1.5、1.618、2
            capacity += capacity >> 1;//扩容为原来的1.5倍。
            int[] newArray = new int[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    public int remove(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("index is illegal.");
        }
        int removed = array[index];
        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        }
        size--;
        return removed;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("index is illegal!");
        }

        return array[index];
    }

    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(array[i]);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public Integer next() {
                return array[i++];
            }
        };
    }

    public IntStream stream() {
        return IntStream.of(Arrays.copyOfRange(array, 0, size));
    }
}
