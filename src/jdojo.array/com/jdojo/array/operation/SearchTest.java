/*
* Array provides methods to several routines operations such as converting, sorting, comparing, etc.
* Java provide the class java.util.Arrays which contains over 150 static methods to perform such type of array operations.
* Most of the methods have at least nine overloaded versions (one for each of the eight primitive type and one for the reference type).
* Operations can be performed on the entire array or on a range of elements that doubles the number of operations to at least 18 for one type of operation.
* Here, a presentation of only the type of operation is made, it's not an exhaustive list of methods provided by Arrays class.
* See java.util.Arrays API docs for more on array manipulation
*
* SEARCHING
* binarySearch() method search in a sorted array using the binary search algorithm.
* It search for a key (a value) in a sorted array and returns the index of the key if found.
* If not found, it returns a negative number which is equal to
*   (-(insertion point) - 1)
* Insertion point is the index at which the key would be inserted into the array.
*
* Unsorted arrays will return "undefined".
* Search is allowed on the entire array or on a range of element
*
*/
package com.jdojo.array.operation;

import java.util.Arrays;

public class SearchTest{
    public static void main(String[] args) {
        int[] nums = {2, 4, 8, 9, 6, 7 ,1};

        System.out.printf("Original array: %n%s%n",  Arrays.toString(nums));

        // First, we must sort the array
        Arrays.sort(nums);
        System.out.printf("Array after sorting: %n%s%n", Arrays.toString(nums));

        int index = Arrays.binarySearch(nums, 1);           // 0
        System.out.println("Found index of 1: " + index);

        index = Arrays.binarySearch(nums, 3);
        System.out.println("Found index of 3: " + index);   // -3 = (-(Insertion point) - 1) => Insertion point of 3 = 2

        index = Arrays.binarySearch(nums, 12);
        System.out.println("Found index of 3: " + index);   // -8 = (-(Insertion point) - 1) => Insertion point of 12 = 7

        /* Binary search for a key using a range
        * Signature:
        *   binarySearch(T[] a, int fromIndex, int toIndex, T key)
        *
        * toIndex is exclusive.
        * Here 8 is at position 5, but toIndex which has a value of 5 is exclude from the range
        */
        index = Arrays.binarySearch(nums, 0, 5, 8);           // 0
        System.out.println("Found index of 8 between index 0 and 5: " + index);     // -6 => which means Insertion position is 5
    }


}
