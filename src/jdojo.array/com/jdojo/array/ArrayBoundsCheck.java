/*
* At runtime, Java checks array bounds for every access to an array element.
* If array bounds are exceeded, a java.lang.ArrayIndexOutOfBoundsException is thrown
* At compile time, compiler checks only that all indexes are of integer type.
* 
*/
package com.jdojo.array;

public class ArrayBoundsCheck  {
    public static void main(String[] args) {
        int[] test = new int[3];

        System.out.println("Assigning 12 to the first element");
        test[0] = 12;   // Ok. Index 0 is between 0 and 2

        System.out.println("Assigning 79 to fourth element");
        try{
            // here a runtime exception will be thrown
            test[3] = 79;
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Array length is 3! Adding a fourth element not allowed!");
        }




    }
}
