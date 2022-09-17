/*
* If you store the state of an object inside an array instance variable,
* you should think carefully before returning the reference of that array from any methods of the class!
* The caller of that method will have full control of object stored in that array.
*/
package com.jdojo.array;

public class ArrayAsInstanceVariable{
    private int[] myNumbers = {12, 45, 789};

    private ArrayAsInstanceVariable(){

    }

    public ArrayAsInstanceVariable getInstance(){
        return new ArrayAsInstanceVariable();
    }

    public int[] getMyNumbers(){
        /*
        * Never return the original array if contains objects' reference
        *
        * return this.myNumbers;
        */
        return (int[]) myNumbers.clone();

    }
}
