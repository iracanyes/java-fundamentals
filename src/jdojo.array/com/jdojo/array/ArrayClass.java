/*
* Arrays are objects.
* The class name of an array starts with left bracket ([).
*   Array type                      Class name
*   - byte[]                        [B
*   - short[]                       [S
*   - int[]                         [I
*   - long[]                        [J
*   - char[]                        [C
*   - float[]                       [F
*   - double[]                      [D
*   - boolean[]                     [Z
*   - com.jdojo.person.Person[]     [Lcom.jdojo.person.Person;
*
* The syntax of array class name cannot be used inside your code.
*/
package com.jdojo.array;

public class ArrayClass {
    public static void main(String[] args) {
        int[] iArr = new int[2];
        int[][] iiArr = new int[2][2];
        int[][][] iiiArr = new int[2][2][2];

        String[] sArr = {"A", "B"};
        String[][] ssArr = {{"AA"},{"BB"}};
        String[][][] sssArr = {};             // 3D empty array

        System.out.println("int[]: " + getClassName(iArr));             //  [I
        System.out.println("int[][]: " + getClassName(iiArr));          //  [[I
        System.out.println("int[][][]: " + getClassName(iiiArr));       //  [[[I
        System.out.println("String[]: " + getClassName(sArr));          //  [Ljava.lang.String;
        System.out.println("String[][]: " + getClassName(ssArr));       // [[Ljava.lang.String;
        System.out.println("String[][][]: " + getClassName(sssArr));    // [[Ljava.lang.String;



    }

    /*
    * Any Java object can be passed to getClassName() method
    */
    public static String getClassName(Object o){
        // Get the reference of its class
        Class<?> c = o.getClass();

        // Get the name of the class
        String className = c.getName();
        return className;

    }
}
