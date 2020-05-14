package com.bridgelabz.service;

import java.util.Arrays;

public class QuickSort implements Runnable {
    public int partition(int[] array, int lowIndex, int highIndex) {
        //   VARIABLES
        int pivot = array[highIndex];
        int i = (lowIndex - 1);

        for (int j = lowIndex; j < highIndex; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[highIndex];
        array[highIndex] = temp;

        return i + 1;
    }

    //    SORT METHOD
    public void sort(int[] array, int lowIndex, int highIndex) {
        if (lowIndex < highIndex) {
            int partitionIndex = partition(array, lowIndex, highIndex);
            sort(array, lowIndex, partitionIndex - 1);
            sort(array, partitionIndex + 1, highIndex);
        }
    }

    @Override
    public void run() {
        int[] array = {4, 25, 1, 5, 84, 52};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(array, 0, array.length - 1);
        System.out.println("Quick Sorted Array :" + Arrays.toString(array));
    }
}
