/*
* Array provides methods to several routines operations such as converting, sorting, comparing, etc.
* Java provide the class java.util.Arrays which contains over 150 static methods to perform such type of array operations.
* Most of the methods have at least nine overloaded versions (one for each of the eight primitive type and one for the reference type).
* Operations can be performed on the entire array or on a range of elements that doubles the number of operations to at least 18 for one type of operation.
* Here, a presentation of only the type of operation is made, it's not an exhaustive list of methods provided by Arrays class.
* See java.util.Arrays API docs for more on array manipulation
*
* COMPARE
* For converting an array here is the list of type of operation provided by Arrays class:
*   - compare()         : Compare 2 arrays lexicographically.
*                         Returns 0 if the 2 arrays contains the same elements in the same order.
*                          Returns a negative number if the first array is lexicographically *                          lesser than the second or returns a positive number in the other case.
*   - compareUnsigned() : same as compare(), numerically treating elements as unsigned.
*   - deepEquals()      : Returns true if the 2 arrays are deeply equals and false if not.
*   - equals()          : Returns true if primitive arrays are equals. Otherwise, false.
*                         Returns true if reference arrays contains the same reference to object. Otherwise, false.
*   - mismatch()        : Find and return the index of the first mismatch between 2 arrays.
*                           Otherwise, returns -1 if no mismatch is found. Entire and range  comparison possible.

*
*/
package com.jdojo.array.operation;

import java.util.Arrays;

public class CompareTest{
    public static void main(String[] args) {
        int[] a1 = { 1 , 2, 3, 4, 5, 6};
        int[] a2 = { 1 , 2, 8, 7, 5, 6};
        int[] a3 = { 1 , 2, 3, 4, 5, 6};

        // Print original arrays
        System.out.println("3 arrays:");
        System.out.printf("a1: %s%n", Arrays.toString(a1));
        System.out.printf("a2: %s%n", Arrays.toString( a2));
        System.out.printf("a3: %s%n",  Arrays.toString(a3));

        /* Compare arrays for equality
        * Signature:
        *   boolean Arrays.equals(T[] arr1, T[] arr2)
        *   boolean Arrays.equals(T[] arr1, int startPosArr1, T[] arr2, int startPosArr2, int range)
        */
        System.out.println("\nComparing arrays for equality using equals() method: ");
        System.out.println("Arrays.equals(a1, a2): " + Arrays.equals(a1, a2));
        System.out.println("Arrays.equals(a1, a3): " + Arrays.equals(a1, a3));
        System.out.println("Arrays.equals(a1, 0, 2, a2, 0, 2): " + Arrays.equals(a1, 0, 2, a2, 0, 2));

        /*
        * Compare arrays lexicographically
        * Signature:
        *   int Arrays.compare(T[] arr1, T[] arr2)
        *   int Arrays.compare(T[] arr1, int startPosArr1, T[] arr2, int startPosArr2, int range)
        */
        System.out.println("\nComparing arrays lexicographically using compare() method: ");
        System.out.println("Arrays.compare(a1, a2): " + Arrays.compare(a1, a2));
        System.out.println("Arrays.compare(a1, a3): " + Arrays.compare(a1, a3));
        System.out.println("Arrays.compare(a1, 0, 2, a2, 0, 2): " + Arrays.compare(a1, 0, 2, a2, 0, 2));

        /*
        * Find the mismatched index in arrays
        * Signature:
        *   int Arrays.mismatch(T[] arr1, T[] arr2)
        *   int Arrays.mismatch(T[] arr1, int startPosArr1, int endPosArr1, T[] arr2, int startPosArr2, int endPosArr2)
        *
        * Returns -1, all elements are equals
        * Returns 0, if all elements are mismatching
        * Returns a positive number equals to the number of mismatch found.
        */
        System.out.println("\nFind mismatch in arrays using mismatch() method: ");
        System.out.println("Arrays.mismatch(a1, a2): " + Arrays.mismatch(a1, a2));
        System.out.println("Arrays.mismatch(a1, a3): " + Arrays.mismatch(a1, a3));
        System.out.println("Arrays.mismatch(a1, 0, 2, a2, 0, 2): " + Arrays.mismatch(a1, 0, 2, a2, 0, 2));
        System.out.println("Arrays.mismatch(a1, 2, 4, a2, 2, 4): " + Arrays.mismatch(a1, 2, 4, a2, 2, 4));

    }
}
