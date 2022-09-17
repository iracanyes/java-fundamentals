/*
* A data that is identified using more than one dimension, can be represented in a multi-dimensional array.
* Ex: Point(x, y) represented in a 2-dimension space.
*
* Data in a table are also identified by 2 dimension (row and column).
* You can a multi-dimensional array of 2 dimension using a pair of brackets [][]
* Ex: int[][] points
*
* Java does not support multi-dimensional array. It supports an array of arrays or array of reference to object of type Array.
* You can achieve multi-dimensional arrays with arrays of arrays.
*
*/
package com.jdojo.array;

public class MultiDimensionalArray {
    public static void main(String[] args) {
        raggedArray();
    }

    public static void raggedArray()  {
        // Create a 2-dimension array
        // Here memory is allocated only for the reference variable "table", not for array elements
        // Same as: int raggedArray[][];
        // Same as: int[] raggedArray[];
        int[][] raggedArray;

        /*
        * memory is allocated for an array of 3 elements, each element of the array
        * is a one-dimension array of integer.
        * The data type of each element is int array.
        * You must specify at least the dimension of the first level array at the time you create a multi-dimensional array.
        * The statement just create the first level of the array.
        * The value of each element is null as no assignment has been made
        */
        raggedArray = new int[3][];

        /*
        * You can also create a 2 dimensional array with different number of columns for each row
        */
        // Add 3 columns to the first row
        raggedArray[0] = new int[3];
        // Add 3 columns to the second row
        raggedArray[1] = new int[3];
        // Add 3 columns to the third row
        raggedArray[2] = new int[3];

        // Assign values to all elements
        raggedArray[0][0] = 1;
        raggedArray[0][1] = 2;
        raggedArray[0][2] = 3;
        raggedArray[1][0] = 4;
        raggedArray[1][1] = 5;
        raggedArray[1][2] = 6;
        raggedArray[2][0] = 7;
        raggedArray[2][1] = 8;
        raggedArray[2][2] = 9;

        // Here is an example of multi-dimensional array with second level array of different size
        int[][] ra = {{1, 2, 3}, {9, 8, 7, 6, 5}, {4,0}};

        // Access elements of multi-dimensional array using for loop
        for(int i = 0; i < raggedArray.length;  i++){
            for(int j = 0; j < raggedArray[i].length; j++){
                System.out.printf("%s\t", raggedArray[i][j] );
            }
            System.out.printf("%n");
        }

        // Access elements of multi-dimensional array using for-each loop
        // You cannot access the index of each elemnt using for-each loop
        for(int[] firstLevel: ra){
            for(int secondLevel : firstLevel){
                System.out.printf("%s\t", secondLevel);
            }
            System.out.printf("%n");
        }


    }

}
