package com.wyj.algorithm.sort;

import java.util.Arrays;

/**
 *  https://www.bilibili.com/video/BV1Lv4y1e7HL?spm_id_from=333.788.videopod.episodes&vd_source=7a19c934b34181e45c9e4b97735a0ed8&p=48
 *
 *  https://www.bilibili.com/video/BV1td4y1g7Fy/?spm_id_from=333.337.search-card.all.click&vd_source=7a19c934b34181e45c9e4b97735a0ed8
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     *  冒泡排序思路
     *
     *  排序过程中数组分成未排序的部分和已排序的部分。
     *  每一轮冒泡操作：
     *  遍历未排序的部分，比较当前索引的元素和后一个索引的元素大小，如果当前索引元素比后一个元素大，则交换两个元素的位置。
     *  这样处理后，就会将最大的元素放到未排序部分的末尾，已排序部分的头部。
     *  未排序部分个数减一，已排序部分个数加一。
     *
     *  重复对未排序部分进行冒泡操作，直到未排序部分个数为1。
     *
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
