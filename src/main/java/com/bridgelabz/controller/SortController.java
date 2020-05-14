package com.bridgelabz.controller;

import com.bridgelabz.service.MergeSort;
import com.bridgelabz.service.QuickSort;

public class SortController {
    public static void main(String[] args) {
        //   MERGE SORT RUNNABLE OBJECT
        MergeSort merge = new MergeSort();
        Thread mergeSort = new Thread(merge);
        //   QUICK SORT RUNNABLE OBJECT
        QuickSort quick = new QuickSort();
        Thread quickSort = new Thread(quick);
        mergeSort.start();
        quickSort.start();
    }
}

