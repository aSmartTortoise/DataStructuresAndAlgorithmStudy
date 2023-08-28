package com.wyj.algorithm.binarysearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void binarySearchBasic() {
        int[] arr = new int[]{7, 13, 21, 30, 38, 44, 52, 53};
        assertEquals(0, BinarySearch.binarySearchBasic(arr, 7));
        assertEquals(1, BinarySearch.binarySearchBasic(arr, 13));
        assertEquals(2, BinarySearch.binarySearchBasic(arr, 21));
        assertEquals(3, BinarySearch.binarySearchBasic(arr, 30));
        assertEquals(4, BinarySearch.binarySearchBasic(arr, 38));
        assertEquals(5, BinarySearch.binarySearchBasic(arr, 44));
        assertEquals(6, BinarySearch.binarySearchBasic(arr, 52));
        assertEquals(7, BinarySearch.binarySearchBasic(arr, 53));
    }
}