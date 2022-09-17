/*
* An array is a fixed-length data structure that is used to hold multiple values of the same data type.
* You can declare an array of primitive type or reference type.
* Notation:
*   type[] var-name
*   type var-name[]
*
* Arrays are objects in Java. Every object belongs to a class; so does every array object.
* You can create an array object using "new" operator:
* Notation:
*   new <array-data-type>[<array-length>]
* The name of the constructor called is the same as the class's name.
* The size of the array is enclosed between brackets []
* Ex: new int[5]  => array of type int and size 5
*
* An array can have multiple dimension. An array with more than one dimension is calle multi-dimensional array.
* Ex new int[3][5] => array of 2 dimensions, first dimension has a size of 3, the second dimension has a size of 5
*
*
*
*
*/
package com.jdojo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import com.jdojo.person.Person;

public class ArrayTest{
  private int[] intArray = new int[3];

  public ArrayTest(){
    // Display the initial value for elements of the instance variables
    for(int i : intArray){
      System.out.println("intArray["+ i + "] = " + intArray[i]) ;
    }
  }

  public static void main(String[] args) {

    declareAndInitialize();
    copyArray();
    // Here we initialize array

  }

  public static void declareAndInitialize(){
    // Here are 2 valid notation of array of type int.
    int[] intArray;
    int intArray2[];
    Person[] persons;
    Person persons2[];

    // The size of an array must be known at its initialization
    // Memory space allocation must be known at its initialization
    // Here the expression create an array in memory and the new operator
    // returns the reference to the object.
    int size = 10;
    intArray = new int[size];       // Array of 10 integers
    intArray2 = new int[size * 5]; // Array of 50 integers filled of 0

    // Array are initialized automatically
    // Primitive types are replaced by their default value.
    // Reference type are replaced by null value.
    // Array of 2 boolean filled with false
    boolean[] bArray = new boolean[2]; // {false, false}

    // Numeric primitive type are filled with 0
    // Array of 3 integer filled with 0
    int[] intArray3 = new int[3];           // {0, 0, 0}
    double[] doubleArray = new double[3];   // { 0.0, 0.0, 0.0}

    // Array of 3 characters filled with '\u0000'
    char[] charArray = new char[3];         // {'\u0000', '\u0000', '\u0000'}

    // Array of object of type Person filled with null
    persons = new Person[3];                // { null, null, null }

    // Explicit array initialization
    // Allow to initialize array at its declaration
    // Create an array of int of length 5
    int[] explicitIntArray = {1, 2, 3, 4, 5};

    // Alternative explicit array initialization
    // You cannot specify the length of the array when you provide the array initialization list.
    explicitIntArray = new int[]{1, 2, 3, 4, 5};

    // Define an empty array
    int[] emptyArray = {};

    // String object can be initialized using literals
    String[] names = {"Sarah", "Lisa"};

    // Explicit initialization of reference type array.
    persons = new Person[]{Person.getInstance(), Person.getInstance()};

    // As array are objects, the following declaration is true
    Object obj = intArray;

    // If you have a reference of an array in a reference variable of Object type.
    // you must cast it to the appropriate array type before you can assign it
    // to an array of reference variable or access its elements by index.
    int[] intArrayBis = (int[]) obj;

    /*
    * ACCESSING ARRAY ELEMENTS
    * Unlike class member variables (instance and static variables), arrays are not initialized by default.
    * They must be initialized before its first use.
    * You can refer to each individual element of the array using an element's index enclosed in brackets.
    * Ex: intArray[0] => elment of index 0 in array "intArray"
    *
    * Refering to non-existing element of array, will cause a runtime exception!
    * Reference type arrays when declared without initialization are filled with null reference.
    * You must initialize objects in such array before using them.
    */
    // Set a value
    intArray[0] = 2505;
    intArray[1] = 2500;
    intArray[2] = 125;
    intArray[3] = 250;
    intArray[4] = 25;

    // Get a value from an array by its index
    int i0 = intArray[0];

    /*
    * ARRAY LENGTH
    * Array object have a public final instance variable named length, which contains the number of elements in the array can hold.
    * length is a final instance variable. it's immutable.
    */
    int[] benefits = new int[100];
    size = benefits.length;     // size = 100

    // Using the length of array, we can loop through the array to access each element
    // Array object use a zero-based index.
    for(int x = 0; x < intArray.length; x++){
      benefits[x] = (int) (1000 * 2.103) + 50;
    }



  }

  public static void copyArray(){
      String[] names = {"Sarah", "Lisa"};
      /*
      * LIMITATIONS WITH ARRAYS
      * You cannot expand or shrunk the size of the array after its creation.
      * The only solution is to create a new array with the desired length append content to it.
      * You can copy array elements from one array to another using 2 ways:
      *   - Using a loop
      *   - Using the static method arrayCopy() of java.lang.System
      *         static void arrayCopy(
      *                 Object source,
      *                 int sourceStartPosition,
      *                 Object destinationArray,
      *                 int destinationStartPosition,
      *                 int lengthToBeCopied
      *         )
      *   - Using method copyOf() provided by class java.util.Arrays
      */
      String[] namesBis = new String[6];

      // Here we use a for-loop to copy content of names array to namesBis array
      for(int i = 0; i < names.length; i++){
          namesBis[i] = names[i];
      }
      System.out.printf("Original names : %s%nCopied names : %s%n", names, namesBis);

      /*
      * Another way is to use System.arrayCopy method
      * Using the static method arrayCopy() of java.lang.System
      *         static void arrayCopy(
      *                 Object sourceArray,
      *                 int sourceStartPosition,
      *                 Object destinationArray,
      *                 int destinationStartPosition,
      *                 int lengthToBeCopied
      *         )
      *
      * Where:
      *     - sourceArray               : the reference ot the source array
      *     - sourceStartPosition       : The starting index position in the sourceArray
      *                                   from where the copying will start
      *     - destinationArray          : the reference to the destination array
      *     - destinationStartPosition  : The starting index position in the destinationArray
      *                                     from where new elements will be copied.
      *     - lengthToBeCopied          : the number of elements to be copied from sourceArray to destinationArray
      */
      namesBis = new String[6];
      System.arraycopy(names, 0, namesBis, 0, names.length);
      System.out.println("System.arrayCopy(names, 0, namesBis, 0, names.length)");
      System.out.printf("Original names : %s%nCopied names : %s%n", names, namesBis);

      /*
      * You can also use copyOf() method of class java.util.Arrays.
      * The method is overloaded
      *     - boolean[] copyOf(boolean[] original, int newLength)
      *     - byte[] copyOf(byte[] original, int newLength)
      *     - short[] copyOf(short[] original, int newLength)
      *     - char[] copyOf(char[] original, int newLength)
      *     - int[] copyOf(int[] original, int newLength)
      *     - float[] copyOf(float[] original, int newLength)
      *     - long[] copyOf(long[] original, int newLength)
      *     - double[] copyOf(double[] original, int newLength)
      *     - <T> T[] copyOf(T[] original, int newLength)
      *
      * copyOf() method accepts as arguments the original array and the new length desired.
      * If the new length is less than the length of the original array,
      * content of the original array will be truncated to fit the size given.
      * If the new length is greater than the the length of the original array, the returned array is fill with extra elements containing the default values.
      * If the new length is equal to the length of the original array, the returned array contain the number of elements as the source array.
      */

      /*
      * Arrays class provides a method to copy a range of elements from an array to another.
      *     Arrays.copyOfRange()
      * the method is overloaded as copyOf() for each primitive type and reference type
      */



  }
}
