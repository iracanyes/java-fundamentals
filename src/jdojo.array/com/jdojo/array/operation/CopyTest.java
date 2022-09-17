/*
* Array provides methods to several routines operations such as converting, sorting, comparing, etc.
* Java provide the class java.util.Arrays which contains over 150 static methods to perform such type of array operations.
* Most of the methods have at least nine overloaded versions (one for each of the eight primitive type and one for the reference type).
* Operations can be performed on the entire array or on a range of elements that doubles the number of operations to at least 18 for one type of operation.
* Here, a presentation of only the type of operation is made, it's not an exhaustive list of methods provided by Arrays class.
* See java.util.Arrays API docs for more on array manipulation
*
* COPYING
* For converting an array here is the list of type of operation provided by Arrays class:
*   - copyOf()          : Copies an array to another array. The length of the new array is specified.
*                           If the length of the new array is bigger than the length of the copied array,
*                           all empty element of the new array is filled with default value.
*                           If the length of the new array is lesser than the length of the copied array
*                           A shunked copy of the array is returned with a length corresponding to the length given in argument.
*   - copyOfRange()     : Copies a range of elements from one array to another.
*
*/
package com.jdojo.array.operation;

import java.util.Arrays;

public class CopyTest{
    public static void main(String[] args) {
        // Create an array of int
        int[] nums = {2, 4, 5, 9, 7 , 6, 3};
        System.out.println("Original array: " + Arrays.toString(nums));

        // Copy a truncated array of the original by giving a smaller length for the array
        int[] nums2 = Arrays.copyOf(nums, 4);
        System.out.println("Truncated array to length 4: " + Arrays.toString(nums2));

        // Copy a extended array of the original by giving a greater length for the array
        int[] nums3 = Arrays.copyOf(nums, 10);
        System.out.println("Truncated array to length 4: " + Arrays.toString(nums3));

        // Copy a ranged of the original
        int[] nums4= Arrays.copyOfRange(nums, 2, 6);
        System.out.println("Arrays.copyOfRange(nums, 2, 6): " + Arrays.toString(nums4));
    }


}
