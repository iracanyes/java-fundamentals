/*
* Array provides methods to several routines operations such as converting, sorting, comparing, etc.
* Java provide the class java.util.Arrays which contains over 150 static methods to perform such type of array operations.
* Most of the methods have at least nine overloaded versions (one for each of the eight primitive type and one for the reference type).
* Operations can be performed on the entire array or on a range of elements that doubles the number of operations to at least 18 for one type of operation.
* Here, a presentation of only the type of operation is made, it's not an exhaustive list of methods provided by Arrays class.
* See java.util.Arrays API docs for more on array manipulation
*
* PERFORMING PARALLEL ACCUMULATION
* parallelPrefix() method allow to cumulates, in parallel, each element of an array in place using the supplied function
*
* parallelSetAll() method set all elments of the specified array, in parallel, using a generator function to compute each element.
*/
package com.jdojo.array.operation;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;

public class ParallelAccumulation{
    public static void main(String[] args) {
        // Create an array of int
        int[] nums = {4, 3, 2, 1, 1, 2, 3};
        System.out.println("Original array: " + Arrays.toString(nums));

        // Parallel accumulation
        Arrays.parallelPrefix(nums, (n1, n2) -> n1 * n2);
        System.out.println("Arrays.parallelPrefix(nums, (n1, n2) -> n1 * n2) : " + nums);

        // Define lambda function
        IntUnaryOperator g = e -> {
            if( e % 2 == 0){
                return e * e;
            }else{
                return e;
            }
        };

        // Same as
        //Arrays.parallelSetAll(nums, n ->  (n % 2 == 0) ? n * n : n);
        Arrays.parallelSetAll(nums, g);

        System.out.println("Arrays.parallelPrefix(nums, (n1, n2) -> n1 * n2) : " + nums);
    }
}
