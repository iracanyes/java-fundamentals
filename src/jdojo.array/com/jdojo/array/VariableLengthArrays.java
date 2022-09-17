/*
* SIMULATING VARIABLE LENGTH ARRAYS WITH ARRAYLIST
* Java libraries provides some classes whose objects act as variable length arrays.
* These classes provides method to obtain an array representation of elements.
*   - Vector
*   - ArrayList
*
* ArrayList and Vector works the same way. The difference is that Vector methods are synchronized.
* If an object list is accessed and manipulated by multiple threads simultaneously, use Vector class which will be slower but thread safe.
* Otherwise, it's better to use ArrayList class.
*
* ArrayList works only with objects, whereas array can work with primitive data type literal.
* It's a generic class which takes the type of its element as the type parameter
* If you want ArrayList to work with primitive type, you have to use one of the wrapper class for primitive type
*/
package com.jdojo.array;

import java.util.ArrayList;

public class VariableLengthArrays{
    public static void main(String[] args) {
        arrayListTest();

        // Array can be manipulate directly if passed as argument to a method
        int[] nums = {23,52};
        System.out.printf("Before swap %n#1: %s%n#2: %s%n", nums[0], nums[1]);
        VariableLengthArrays.swap(nums);
        System.out.printf("After swap %n#1: %s%n#2: %s%n", nums[0], nums[1]);
    }

    public static void arrayListTest(){
        // Create an ArrayList to work with primitive type (integer)
        ArrayList<Integer> intArrayList = new ArrayList<>();

        // Get the size of the array list
        int sizeArray = intArrayList.size();
        System.out.printf("ArrayList size is %s%n", sizeArray);
        System.out.printf("ArrayList elements are %s%n", intArrayList);

        // Add element to array
        intArrayList.add(25);   // Autoboxing will translate 25 => new Integer(25)

        // warning: [removal] Integer(int) in Integer has been deprecated and marked for removal
        // intArrayList.add(new Integer(1252));
        
        intArrayList.add(9825);   // Autoboxing will translate 9825 => new Integer(9825)
        intArrayList.add(25);   // Autoboxing will translate 25 => new Integer(25)

        // Get the size of the array list
        sizeArray = intArrayList.size();
        System.out.printf("ArrayList size is %s%n", sizeArray);
        System.out.printf("ArrayList elements are %s%n", intArrayList);

        // Get a specific element of array list
        int id = intArrayList.get(0);   // Autoboxing box the Integer object returned to int
        Integer id2 = intArrayList.get(1);
        System.out.printf("ArrayList element %s is %s%n", 0, id);

        // Check if array list contains a specific elements
        //
        boolean found = intArrayList.contains(25);
        boolean found2 = intArrayList.contains(9856);
        System.out.println("25 is"+ (found ? "": "not") +" found is array list");
        System.out.println("9856 is"+ (found2 ? "": "not") +" found is array list");

        // Iterate through all elements
        System.out.println("**** Array list members ****");
        for(int temp: intArrayList){
            System.out.println(temp);
        }
        System.out.println("**** Array list members end ****");


        // Clear array list
        intArrayList.clear();

        // Get the size of the array list
        sizeArray = intArrayList.size();
        System.out.printf("ArrayList size is %s%n", sizeArray);
        System.out.printf("ArrayList elements are %s%n", intArrayList);



    }

    /*
    * You can pass an array as a parameter to a method or a constructor.
    * Because an array is an object, the array reference is passed to the method.
    *
    */
    public static String arrayToString(int[] source){
        if( source == null){
            return null;
        }

        StringBuilder result = new StringBuilder("[");

        for(int i = 0; i < source.length; i++){
            if( i == source.length - 1){
                result.append(source[i]);
            }else{
                result.append(source[i] + ", ");
            }
        }

        result.append("]");
        return result.toString();
    }

    /*
    * The method receiving an array as argument can modify directly its content.
    */
    public static void swap(int[] source){
        if( source != null && source.length == 2){
            int temp = source[0];
            source[0] = source[1];
            source[1] = temp;
        }
    }
}
