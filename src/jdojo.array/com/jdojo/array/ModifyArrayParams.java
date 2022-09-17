/*
* Because an array is an object, a copy of its reference is passed to a method.
* If the method change the array parameter, the actual parameter is not affected.
*/
package com.jdojo.array;

import java.util.Arrays;

public  class ModifyArrayParams{
    public static void main(String[] args) {
        int[] origin = {104, 125, 321, 785};
        System.out.printf("Before method call: %s%n", Arrays.toString(origin));

        // Pass array to method
        tryArrayChange(origin);

        System.out.printf("After method call: %s%n" ,Arrays.toString(origin));
    }

    /*
    * Array passed as argument are copied (primitive type and references to objects)
    * Modification made to formal parameter of the method doesn't affect the actual parameter in the caller context
    */
    public static void tryArrayChange(int[] nums){
        System.out.println("Inside method-1: " + Arrays.toString(nums));

        // Create and store a new int array reference in nums reference variable 
        // doesn't affect the original array in the caller context
        nums = new int[]{987,654,312};

        System.out.println("Inside method-2: " + Arrays.toString(nums));

    }

    /*
    * To avoid any changes in array inside the method, you have to declare the parameter as final (constant)
    */
    public static void avoidArrayChange(final int[] nums){
        System.out.println("Inside method-1: " + Arrays.toString(nums));

        // Create and store a new int array in num
        // Exception: final variable cannot be change after initialization
        // nums = new int[]{987,654,312};

        System.out.println("Inside method-2: " + Arrays.toString(nums));
    }
}
