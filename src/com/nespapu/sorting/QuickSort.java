package com.nespapu.sorting;

import java.util.Arrays;

/**
 * Quick Sort implementation for integer arrays (Lomuto partition scheme).
 *
 * Average time complexity: O(n log n)
 * Worst-case time complexity: O(n^2)
 * Space complexity: O(log n) due to recursion
 */
public final class QuickSort {

    private QuickSort() {
        // Utility class
    }

    /**
     * Sorts the given array in ascending order using the Quick Sort algorithm.
     *
     * @param array the array to be sorted; if null or length < 2, the method does nothing
     */
    public static void sortAscending(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        sortAscending(array, 0, array.length - 1);
    }

    private static void sortAscending(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotIndex = partitionAscending(array, left, right);
        sortAscending(array, left, pivotIndex - 1);
        sortAscending(array, pivotIndex + 1, right);
    }

    private static int partitionAscending(int[] array, int left, int right) {
        // The pivot selection affects the execution time.
        // This implementation uses the last element as pivot (Lomuto partition scheme).
        int pivot = array[right];
        int last = left - 1;

        for (int k = left; k < right; k++) {
            if (array[k] < pivot) {
                last++;
                swap(array, last, k);
            }
        }

        last++;
        swap(array, last, right);
        return last;
    }

    /**
     * Sorts the given array in descending order using the Quick Sort algorithm.
     *
     * @param array the array to be sorted; if null or length < 2, the method does nothing
     */
    public static void sortDescending(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        sortDescending(array, 0, array.length - 1);
    }

    private static void sortDescending(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotIndex = partitionDescending(array, left, right);
        sortDescending(array, left, pivotIndex - 1);
        sortDescending(array, pivotIndex + 1, right);
    }

    private static int partitionDescending(int[] array, int left, int right) {
        int pivot = array[right];
        int last = left - 1;

        for (int k = left; k < right; k++) {
            if (array[k] > pivot) {
                last++;
                swap(array, last, k);
            }
        }

        last++;
        swap(array, last, right);
        return last;
    }

    private static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
