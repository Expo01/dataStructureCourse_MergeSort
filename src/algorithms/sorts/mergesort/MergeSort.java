package algorithms.sorts.mergesort;

import java.util.Arrays;

public class MergeSort {

    public static int[] merge(int[] array1, int[] array2) { // this method is used after an array is broken into single
        // component arrays, and we will recursively call the method combining chunks until new whole created
        int[] combined = new int[array1.length + array2.length]; // blank array created with combined length of two chunks
        int index = 0;
        int i = 0; // 'i' is the variable used to traverse array1
        int j = 0; // 'j' is the variable used to traverse array2
        while (i < array1.length && j < array2.length) { //this accounts for if either array1 or array2 were empty or reached end of array
            if (array1[i] < array2[j]) { //compares first item of the two arrays to see if array 1 has the lower item
                combined[index] = array1[i]; //then adds to the combined array copy
                index++; // increments the index for combined to add the next value with next loop
                i++; // since 'i' had lower value under this criteria, incremenet the indeex to check its next value against 'j' of second
                // array which is still at its first value
            } else {
                combined[index] = array2[j]; // this is circumstance 2 where array 2 had the lower value
                index++;
                j++;
            }
        }
        // the next section applies to when one of the chunks has no moore indexes to check, but the other does since one
        // array chunk had the lower value items
        while (i < array1.length) { // if 'i' is fully incremented to length-1 of the array, it means that all its items
            // were already copied. if not this runs and loops through remaining values in the array chunk and adds them
            // to the combined copy
            combined[index] = array1[i];
            index++;
            i++;
        }
        while (j < array2.length) { // same thing but array chunk 2
            combined[index] = array2[j];
            index++;
            j++;
        }
        return combined; // now both 'i' and 'j' are at max indexes within bounds of their array chunks and all values
        // have been added to the combined copy --> returned
    }


    public static int[] mergeSort(int[] array) { // will break array in half until base case found then add back together
        if (array.length == 1) return array; // if length is 1, that means it has been by definition sorted as a single
        // item array (recursion was called on a single value), which is the base case, then returned to the left or right variable

        int midIndex = array.length/2; //finds mid point of array. if odd number, its an int, so drops the decimal for
        // the index value
        // next lines break array in half and assign smaller array chunks as the halves, which eventually will get to base case
        // as recursion takes place and merge sort calls are added to call stack
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
        int[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));

        return merge(left, right); //this runs once base case reached afteer X # of splits, then merge sort call popped
        // from call stack and returns the merger to either left or right variables, and continues to go pop off until
        // call stack empty and all code has run. Since left is written before right, this means the first base case
        // will always be index 0 and second base case will be index 1. the values are returned and merged such that
        // the whole first half of the array will be sorted before the second half since the first recursion took place
        // on the left half of the original array and will complete before right half calls any recursion to reach its
        // base cases
    }
}