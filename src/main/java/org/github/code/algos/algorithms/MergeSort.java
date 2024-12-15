package org.github.code.algos.algorithms;



public class MergeSort {

    // Main method to test the algorithm
    public static void main(String[] args) {



        MergeSort ob = new MergeSort();

        int[] array = {12, 11, 13, 5, 6, 7};
        System.out.println("Given Array: " + printArray2(array));
        ob.sort(array, 0, array.length - 1);
        System.out.println("Sorted array: "+ printArray2(array));

        int[] array2 = {12, 78, 3, 51, 610, 7, 44};
        System.out.println("Given Array: " + printArray2(array2));
        ob.sort(array2, 0, array2.length - 1);
        System.out.println("Sorted array: "+ printArray2(array2));

        int[] array3 = {124, 3, 41};
        System.out.println("Given Array: " + printArray2(array3));
        ob.sort(array3, 0, array3.length - 1);
        System.out.println("Sorted array: "+ printArray2(array3));
    }

    // Method to sort the array
    void sort(int[] array, int left, int right) {


        if (left < right) {
            // Find the middle point
            int middle = left + (right - left) / 2;

            // Recursively sort the two halves
            sort(array, left, middle);
            sort(array, middle + 1, right);

            // Merge the sorted halves
            merge(array, left, middle, right);
        }
    }

    // Method to merge two subarrays
    void merge(int[] array, int left, int middle, int right) {
        // Sizes of two subarrays to be merged
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temporary arrays
        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, middle + 1, rightArray, 0, n2);

        // Initial indexes of subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray, if any
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray, if any
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Method to print the array
    static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static String printArray2(int[] arr ){
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for( int i=0; i<arr.length ; i++ ){
            sb.append(arr[i]);
            sb.append(",");
        }
        sb.append(" ]");

        return sb.toString();
    }
}
