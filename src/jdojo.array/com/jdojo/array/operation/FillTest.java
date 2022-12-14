/*
* Array provides methods to several routines operations such as converting, sorting, comparing, etc.
* Java provide the class java.util.Arrays which contains over 150 static methods to perform such type of array operations.
* Most of the methods have at least nine overloaded versions (one for each of the eight primitive type and one for the reference type).
* Operations can be performed on the entire array or on a range of elements that doubles the number of operations to at least 18 for one type of operation.
* Here, a presentation of only the type of operation is made, it's not an exhaustive list of methods provided by Arrays class.
* See java.util.Arrays API docs for more on array manipulation
*
* CONVERSION
* For converting an array here is the list of type of operation provided by Arrays class:
*   - fill()    : Assign the same value to all element or to a range of elements in an array
*   - setAll()  : same as fill(). The values are generated by a generator function
*
*/
package com.jdojo.array.operation;

import java.util.Arrays;

public class FillTest{
    public static void main(String[] args) {
        // Create an array of int
        int[] nums = {2, 4, 5, 9, 7 , 6, 3};
        System.out.println("Original array: " + Arrays.toString(nums));

        // Fill elements of the array with 10
        Arrays.fill(nums, 10);
        System.out.println("Arrays.fill(nums, 10) : " + Arrays.toString(nums));

        // Fill elements of the array with with 10
        // setAll() method allow to set values for all elements in array using a function.
        // The function is passed the index of the array an it return the value made from that index.
        Arrays.setAll(nums, index -> ( index + 1 ) * 10);
        System.out.println("Arrays.setAll(nums, index -> ( index + 1 ) * 10) : " + Arrays.toString(nums));
    }
}
