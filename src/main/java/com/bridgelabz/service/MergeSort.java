package com.bridgelabz.service;

import java.util.Arrays;

public class MergeSort implements Runnable {
    public void merge(int[] array, int leftIndex, int middleIndex, int rightIndex) {
        //    VARIABLES
        int leftSize = middleIndex - leftIndex + 1;
        int rightSize = rightIndex - middleIndex;

        //    ARRAYS
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        for (int index = 0; index < leftSize; ++index)
            left[index] = array[leftIndex + index];
        for (int index = 0; index < rightSize; ++index)
            right[index] = array[middleIndex + 1 + index];

        int index1 = 0, index2 = 0;

        int temp = leftIndex;
        while (index1 < leftSize && index2 < rightSize) {
            if (left[index1] <= right[index2]) {
                array[temp] = left[index1];
                index1++;
            } else {
                array[temp] = right[index2];
                index2++;
            }
            temp++;
        }

        while (index1 < leftSize) {
            array[temp] = left[index1];
            index1++;
            temp++;
        }

        while (index2 < rightSize) {
            array[temp] = right[index2];
            index2++;
            temp++;
        }
    }

    //    SORT METHOD
    public void sort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            sort(array, left, middle);
            sort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }


    @Override
    public void run() {
        int[] array = {5, 66, 8, 5, 3, 41};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(array, 0, array.length - 1);
        System.out.println("Merge Sorted array:" + Arrays.toString(array));
    }
}
