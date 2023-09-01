package com.wyj.algorithm.datastructures.arry;

public class DynamicArray {
    private int size;
    private int capacity;
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

        if (index < size) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }

        array[index] = element;
        size++;
    }
}
