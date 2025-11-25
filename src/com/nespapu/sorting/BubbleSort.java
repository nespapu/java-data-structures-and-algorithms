package com.nespapu.sorting;

import java.util.Arrays;

/**
 * Utility class that provides a Bubble Sort implementation for integer arrays.
 *
 * Time complexity (worst/average): O(n^2)
 * Space complexity: O(1)
 */
public final class BubbleSort {

    private BubbleSort() {
        // Utility class: prevent instantiation
    }

    public static void main(String[] args) {
        int[] array = {7, 2, 9, 1, 6, 3, 10, 4, 8, 5};

        // Print unsorted array
        System.out.println("Unsorted: " + Arrays.toString(array));

        sortDescending(array);
        // sortAscending(array);

        // Print sorted array
        System.out.println("Sorted:   " + Arrays.toString(array));
    }

    /**
     * Sorts the given array in descending order using the Bubble Sort algorithm.
     *
     * @param array the array to be sorted; if null or length < 2, the method does nothing
     */
    public static void sortDescending(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        boolean swapped;
        int temp;

        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;

            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) { // The array is already sorted
                break;
            }
        }
    }

    /**
     * Sorts the given array in ascending order using the Bubble Sort algorithm.
     *
     * @param array the array to be sorted; if null or length < 2, the method does nothing
     */
    public static void sortAscending(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        boolean swapped;
        int temp;

        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;

            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) { // The array is already sorted
                break;
            }
        }
    }
}