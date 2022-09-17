/*
* Array provides methods to several routines operations such as converting, sorting, comparing, etc.
* Java provide the class java.util.Arrays which contains over 150 static methods to perform such type of array operations.
* Most of the methods have at least nine overloaded versions (one for each of the eight primitive type and one for the reference type).
* Operations can be performed on the entire array or on a range of elements that doubles the number of operations to at least 18 for one type of operation.
* Here, a presentation of only the type of operation is made, it's not an exhaustive list of methods provided by Arrays class.
* See java.util.Arrays API docs for more on array manipulation
*
* COMPUTE DEEP HASH CODE
* deepHashCode() method returns a hash code based on the "deep contents" of an array. Useful for muli-dimensional array, contents in all dimensions are included in computing the hash code
* If the passed array is null, it returns 0.
* For any 2 arrays a1 and a2 such that Arrays.equals(a1, a2) returns true ,
* it's also the cas that Arrays.heshCode(a1) == Arrays.hashCode(a2)
*/
package com.jdojo.array.operation;

import java.util.Arrays;

public class DeepHashCodeTest{
    public static void main(String[] args) {
        // Create an array of int
        int[] nums = {2, 4, 5, 9, 7 , 6, 3};
        System.out.println("Original array: " + Arrays.toString(nums));

        // Compute the hash code of the array
        int hashCode = Arrays.hashCode(nums);
        System.out.println("Hash code: " + hashCode);
    }
}
