package algorithms.sorts.mergesort;

import java.util.Arrays;

import static algorithms.sorts.mergesort.MergeSort.merge;
import static algorithms.sorts.mergesort.MergeSort.mergeSort;

public class Main {
    public static void main(String[] args) {

        int[] originalArray = {3,1,4,2};

        int [] sortedArray = mergeSort(originalArray); //merge sort returns a copy, does not mutate the original array
        // which decreases space efficiency for improved time efficiency compared to other sorting algorithms like
        // insertion sort O(n^2)

        System.out.println( "\nOriginal Array: " + Arrays.toString( originalArray ) );

        System.out.println( "\nSorted Array: " + Arrays.toString( sortedArray ) );
    }
}