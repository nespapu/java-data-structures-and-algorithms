package com.nespapu.sorting;

import java.util.Arrays;

/**
 * Merge Sort implementation for integer arrays.
 *
 * Time complexity: O(n log n)
 * Space complexity: O(n)
 */
public final class MergeSort {

    private MergeSort() {
        // Utility class
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
     * Sorts the given array in ascending order using the Merge Sort algorithm.
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

        int middle = (left + right) / 2;

        sortAscending(array, left, middle);
        sortAscending(array, middle + 1, right);
        mergeAscending(array, left, middle, right);
    }

    private static void mergeAscending(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }

        for (int i = 0; i < n2; i++) {
            rightArray[i] = array[middle + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < n1) {
            array[k++] = leftArray[i++];
        }

        while (j < n2) {
            array[k++] = rightArray[j++];
        }
    }

    /**
     * Sorts the given array in descending order using the Merge Sort algorithm.
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

        int middle = (left + right) / 2;

        sortDescending(array, left, middle);
        sortDescending(array, middle + 1, right);
        mergeDescending(array, left, middle, right);
    }

    private static void mergeDescending(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }

        for (int i = 0; i < n2; i++) {
            rightArray[i] = array[middle + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] >= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < n1) {
            array[k++] = leftArray[i++];
        }

        while (j < n2) {
            array[k++] = rightArray[j++];
        }
    }
}
