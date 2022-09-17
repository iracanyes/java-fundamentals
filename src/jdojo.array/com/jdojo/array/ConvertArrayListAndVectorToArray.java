/*
* An ArrayList/Vector can be used when the number of elements of the list are unknown.
* Once the number of elements is fixed, you want to convert your ArrayList or Vector into arrays.
* Ex: you want to store user input in an array but the number of input is unknown.
*   You can record user input in an ArrayList and at the end convert it to array.
*
* ArrayList and Vector have an overloaded method toArray() to convert them to array.
* They copy all elments contained to an array
* if there is enough space and returns the same array.
* If there isn't enough space, an new array is created, filled with the data and returned.
*
* The first method returns the elements of ArrayList as an array of Object.
* Signature:
*   Object[] toArray()
*
* The second method takes an array of any type as argument and
* copy all elements of ArrayList to the passed array
*
* Signature:
*   <T> T[] toArray(T[] a)
*/
package com.jdojo.array;

import java.util.ArrayList;
import java.util.Arrays;

public class ConvertArrayListAndVectorToArray{
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        // Add element to array list
        al.add("Cat");
        al.add("Dog");
        al.add("Rabbit");

        System.out.println("ArrayList : " + al);

        // Create an array which length is greater or equals to the length of the ArrayList
        String[] sArr = new String[al.size()];

        // Copy the ArrayList elements to array
        // sArr has enough space to copy all ArrayList elements
        // al.toArray(sArr) return sArr itself
        String[] sArr2 = al.toArray(sArr);

        System.out.println("sArr == sArr2: " + (sArr == sArr2));
        System.out.println("sArr: " + Arrays.toString(sArr));
        System.out.println("sArr2: " + Arrays.toString(sArr2));

        // Create an array of only 2 elements
        sArr = new String[2];
        sArr[0] = "Hello";

        /*
        * Since sArr doesn't have enough space to copy all elements of ArrayList,
        * a new array is created with the length of ArrayList and all elements of ArrayList are copied to the new array before it isreturned.
        */
        sArr2 = al.toArray(sArr);

        /*
        * As sArr remain unchanged and sArr2 contains all elements of ArrayList,
        * the comparison return false
        */
        System.out.println("sArr == sArr2: " + (sArr == sArr2));
        System.out.println("sArr: " + Arrays.toString(sArr));
        System.out.println("sArr2: " + Arrays.toString(sArr2));


    }
}
