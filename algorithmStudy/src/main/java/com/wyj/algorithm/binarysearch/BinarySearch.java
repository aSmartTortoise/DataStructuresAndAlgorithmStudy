package com.wyj.algorithm.binarysearch;

/**
 *  https://www.bilibili.com/video/BV1Lv4y1e7HL?p=7&spm_id_from=pageDriver&vd_source=7a19c934b34181e45c9e4b97735a0ed8
 */
public class BinarySearch {
    /**
     *
     * @param arr 待查找的升序数组
     * @param target 待查找的目标值
     * @return 找到则返回索引，找不到返回-1
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
}
