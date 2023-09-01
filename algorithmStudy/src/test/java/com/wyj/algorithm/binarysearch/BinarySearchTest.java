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

    @Test
    public void binarySearchAlternative() {
        int[] arr = new int[]{7, 13, 21, 30, 38, 44, 52, 53};
        assertEquals(0, BinarySearch.binarySearchAlternative(arr, 7));
        assertEquals(1, BinarySearch.binarySearchAlternative(arr, 13));
        assertEquals(2, BinarySearch.binarySearchAlternative(arr, 21));
        assertEquals(3, BinarySearch.binarySearchAlternative(arr, 30));
        assertEquals(4, BinarySearch.binarySearchAlternative(arr, 38));
        assertEquals(5, BinarySearch.binarySearchAlternative(arr, 44));
        assertEquals(6, BinarySearch.binarySearchAlternative(arr, 52));
        assertEquals(7, BinarySearch.binarySearchAlternative(arr, 53));
    }

    @Test
    public void binarySearchBasicLeftMost() {
        int[] arr = new int[]{7, 13, 21, 21, 30, 38, 44, 52, 53};
        assertEquals(0, BinarySearch.binarySearchBasicLeftMost(arr, 7));
        assertEquals(1, BinarySearch.binarySearchBasicLeftMost(arr, 13));
        assertEquals(2, BinarySearch.binarySearchBasicLeftMost(arr, 21));
//        assertEquals(3, BinarySearch.binarySearchBasicLeftMost(arr, 30));
//        assertEquals(4, BinarySearch.binarySearchBasicLeftMost(arr, 38));
//        assertEquals(5, BinarySearch.binarySearchBasicLeftMost(arr, 44));
//        assertEquals(6, BinarySearch.binarySearchBasicLeftMost(arr, 52));
//        assertEquals(7, BinarySearch.binarySearchAlternative(arr, 53));
    }
}