package com.wyj.algorithm.binarysearch;

import java.util.Arrays;

/**
 *  https://www.bilibili.com/video/BV1Lv4y1e7HL?p=7&spm_id_from=pageDriver&vd_source=7a19c934b34181e45c9e4b97735a0ed8
 */
public class BinarySearch {
    /**
     *
     * @param arr 待查找的升序数组
     * @param target 待查找的目标值
     * @return 找到则返回索引，找不到返回-1
     *
     * 时间复杂度为 O(logn)，空间复杂度为O(1)
     */
    public static int binarySearchBasic(int[] arr, int target) {
        int i = 0, j = arr.length - 1 ;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (arr[m] > target) {
                j = m - 1;
            } else if (arr[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    /**
     *  定义的右指针j初始位置为arr.length，不只想数组中的元素，这样两个指针定义了一个左闭右开的查找范围。
     */
    public static int binarySearchAlternative(int[] arr, int target) {
        int i = 0, j = arr.length ;
        while (i < j) {
            int m = (i + j) >>> 1;
            if (target < arr[m]) {
                j = m;
            } else if (arr[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    /**
     *  改进版的二分查找算法。
     *  时间复杂度为O(logn)，
     */
    public static int binarySearch3(int[] arr, int target) {
        int i = 0, j = arr.length;
        while (j - i > 1) {
            int m = (i + j) >>> 1;
            if (target < arr[m]) {
                j = m;
            } else {
                i = m;
            }
        }

        if (arr[i] == target) {
            return i;
        } else {
            return -1;
        }
    }

    /**
     *   Java 核心类库中的Arrays定义了二分查找算法。
     */
    public static int binarySearch4(int[] arr, int target) {
        int result = Arrays.binarySearch(arr, target);
        return result;
    }

    /**
     *  数组中有相等元素的情况，获取数组中目标元素在数组中的最小索引。
     */
    public static int binarySearchBasicLeftMost(int[] arr, int target) {
        int i = 0, j = arr.length - 1 ;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (arr[m] > target) {
                j = m - 1;
            } else if (arr[m] < target) {
                i = m + 1;
            } else {
                candidate = m;
                j = m - 1;
            }
        }
        return candidate;
    }

    /**
     *  数组中有相等元素的情况，获取数组中目标元素在数组中的最大索引。
     */
    public static int binarySearchBasicRightMost(int[] arr, int target) {
        int i = 0, j = arr.length - 1 ;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (arr[m] > target) {
                j = m - 1;
            } else if (arr[m] < target) {
                i = m + 1;
            } else {
                candidate = m;
                i = m + 1;
            }
        }
        return candidate;
    }

    /**
     *  查找数组中大于等于目标元素的最小的索引
     *  用于获取指定元素的排名、前任、后任、最近邻居
     */
    public static int binarySearchBasicLeftMost1(int[] arr, int target) {
        int i = 0, j = arr.length - 1 ;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (arr[m] >= target) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i;
    }

    /**
     *  查找数组中小于等于目标元素的最大的索引
     *  用于获取指定元素的排名、前任、后任、最近邻居
     */
    public static int binarySearchBasicRightMost1(int[] arr, int target) {
        int i = 0, j = arr.length - 1 ;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (arr[m] > target) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i - 1;
    }
}
