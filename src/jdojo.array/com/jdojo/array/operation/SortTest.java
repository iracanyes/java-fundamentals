/*
* Array provides methods to several routines operations such as converting, sorting, comparing, etc.
* Java provide the class java.util.Arrays which contains over 150 static methods to perform such type of array operations.
* Most of the methods have at least nine overloaded versions (one for each of the eight primitive type and one for the reference type).
* Operations can be performed on the entire array or on a range of elements that doubles the number of operations to at least 18 for one type of operation.
* Here, a presentation of only the type of operation is made, it's not an exhaustive list of methods provided by Arrays class.
* See java.util.Arrays API docs for more on array manipulation
*
* SORTING
* parallelSort() method sorts all elements or a range of elements in an array using parallel sort. Parallel sorting is suitable for bigger array of data.
*
* sort() method sorts all elements or a range of elements in array.
*/
package com.jdojo.array.operation;

import java.util.Arrays;

public class SortTest{
    public static void main(String[] args) {
        // Create an array of int
        int[] nums = {2, 4, 5, 9, 7 , 6, 3};
        System.out.println("Original array: " + Arrays.toString(nums));

        // Compute the hash code of the array
        Arrays.parallelSort(nums);
        System.out.println("Arrays.parallelSort(nums) : " + Arrays.toString(nums));

        nums = new int[]{2, 4, 5, 9, 7 , 6, 3};
        Arrays.sort(nums);
        System.out.println("Arrays.sort(nums) : " + Arrays.toString(nums));
    }
}
