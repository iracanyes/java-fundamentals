/*
* Array provides methods to several routines operations such as converting, sorting, comparing, etc.
* Java provide the class java.util.Arrays which contains over 150 static methods to perform such type of array operations.
* Most of the methods have at least nine overloaded versions (one for each of the eight primitive type and one for the reference type).
* Operations can be performed on the entire array or on a range of elements that doubles the number of operations to at least 18 for one type of operation.
* Here, a presentation of only the type of operation is made, it's not an exhaustive list of methods provided by Arrays class.
* See java.util.Arrays API docs for more on array manipulation
*
* SPLIT ARRAY
* spliterator() method returns a Spliterator including all or a range of elements in an array
* Spliterator can be used for traversing and partioning sequences.
* It's a base utility for Streams, especially for parallel ones.
*
* tryAdvance() is main method for stepping through a sequence.
* The method takes a Consumer that's used to consume elements of the Spliterator one by one sequentially and returns false if there's no elements to be traversed.
*
* trySplit() method attempt to split into 2 parts. then the caller process each element
*/
package com.jdojo.array.operation;

import java.util.Arrays;
import java.util.Spliterator;

public class SpliteratorTest{
    public static void main(String[] args) {
        // Create an array of int
        int[] nums = {2, 4, 5, 9, 7 , 6, 3};
        System.out.println("Original array: " + Arrays.toString(nums));

        Spliterator<Integer> s1 = Arrays.spliterator(nums);

        // tryAdvance
        int current = 0;
        while(s1.tryAdvance(a -> a + 1)){
            current++;
        }

        System.out.println("Spliterator 1 : ");
        s1.forEachRemaining(System.out::println);

        // Try to split array
        Spliterator<Integer> s2 = s1.trySplit();

        System.out.println("Spliterator 1 : ");
        s1.forEachRemaining(System.out::println);

        System.out.println("Spliterator 2 : ");
        s2.forEachRemaining(System.out::println);
    }
}
