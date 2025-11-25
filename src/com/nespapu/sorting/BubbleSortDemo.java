package com.nespapu.sorting;

import java.util.Arrays;

public class BubbleSortDemo {

    public static void main(String[] args) {
        int[] array = {7, 2, 9, 1, 6, 3, 10, 4, 8, 5};

        System.out.println("Original:     " + Arrays.toString(array));

        int[] ascending = array.clone();
        BubbleSort.sortAscending(ascending);
        System.out.println("Ascending:    " + Arrays.toString(ascending));

        int[] descending = array.clone();
        BubbleSort.sortDescending(descending);
        System.out.println("Descending:   " + Arrays.toString(descending));
    }
}

