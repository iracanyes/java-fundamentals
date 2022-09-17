/*
* LIMITATIONS WITH ARRAYS
* You cannot expand or shrunk the size of the array after its creation.
* The only solution is to create a new array with the desired length append content to it.
* You can copy array elements from one array to another using 2 ways:
*   - Using clone() of Array
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
package com.jdojo.array;

import java.util.Arrays;
import java.util.ArrayList;
import com.jdojo.common.Animal;
import com.jdojo.common.Dog;
import com.jdojo.person.Person;
import com.jdojo.address.Address;


public class ArrayCopyTest {
    private static final String[] names = {"Sarah", "Lisa", "Katty", "Kelly","Jeanne"};
    public static void main(String[] args) {
        arrayShallowClone();

        // Here if a wrong size is given an error will be thrown
        ArrayCopyTest.copyWithLoop(names, 4);
        // systemArraycopy takes care of any overlapping, it can copy content from one area of array to another in the same array
        ArrayCopyTest.systemArraycopy(names);

        // Here we expand the array by giving the greater size
        ArrayCopyTest.arraysCopyOf(names, 8);
        // Here we truncate the array by giving the lesser size
        ArrayCopyTest.arraysCopyOf(names, 4);

        // Copy a range of data
        ArrayCopyTest.arraysCopyOfRange(names, 1, 3);
        ArrayCopyTest.arraysCopyOfRange(names, 2, 4);

        //
        ArrayCopyTest.arraysCopyOfRangeAndChangeType();
    }

    public static void arrayShallowClone(){
        /*
        * When clone() method is used to make a quick copy of an object.
        * It performs a shallow copying of the object.
        * For primitive type, the cloned array will have a true copy of the original array.
        * For reference type contains in the array, the reference of object in memory is copied
        * to the corresponding element of the cloned array.
        * In case of shallow copying both arrays, the original and the cloned array, refer to the same object in memory.
        * You can modify the object in memory using the reference stored in the cloned array.
        * To avoid unwanted modification of contents of array, you need to perform a deep cloning
        *
        * In the example below, both names and namesBis array contains reference to the same String object in memory. As Strings are immutable it has no consequence.
        */
        String[] namesBis = names.clone();
        System.out.println("Names cloned :");
        for(String name: names){
            System.out.println(name);
        }

        /*
        * The example below show how a clone array can manipulate the inner object of the original array by only using its own reference to these object
        */
        Person[] persons = {Person.getInstance(), Person.getInstance()};
        System.out.printf("Persons: %s%n", Arrays.toString(persons));
        Person[] personsBis = persons.clone();
        Person person = personsBis[0];
        // Here we use the reference to Address object of the cloned array to directly access the object in memory and manipulate it .
        // the original array will also be alterated as it refer to the same object in memory
        person.setAddress(new Address("15, Boulevard du midi", "Paris", "île de France", "75004"));
        System.out.printf("Persons: %s%n", Arrays.toString(persons));
    }

    public static void copyWithLoop(String[] names, int newLength){
        /*
        *
        */
        String[] namesBis = new String[newLength];

        // Here we use a for-loop to copy content of names array to namesBis array
        for(int i = 0; i < (names.length < newLength ? names.length : newLength); i++){
            namesBis[i] = names[i];
        }
        System.out.printf("Original names : %s%nCopied names : %s%n", Arrays.toString(names), Arrays.toString(namesBis));

    }

    public static void systemArraycopy(String[] names){
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
        String[] namesBis = new String[6];
        System.arraycopy(names, 0, namesBis, 0, names.length);
        System.out.println("System.arrayCopy(names, 0, namesBis, 0, names.length)");
        System.out.printf("Original names : %s%nCopied names : %s%n", Arrays.toString(names),  Arrays.toString(namesBis));
    }

    public static void arraysCopyOf(String[] names, int newLength){
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
        String[] namesBis = Arrays.copyOf(names, newLength);
        System.out.printf("Original array: %s%nCopied array: %s%n", Arrays.toString(names), Arrays.toString(namesBis));
    }

    public static void arraysCopyOfRange(String[] names, int startPos, int endPos){
        /*
        * Arrays class provides a method to copy a range of elements from an array to another.
        *     - boolean[] copyOfRange(boolean[] original, int start, int stop)
        *     - byte[] copyOfRange(byte[] original, int start, int stop)
        *     - short[] copyOfRange(short[] original, int start, int stop)
        *     - char[] copyOfRange(char[] original, int start, int stop)
        *     - int[] copyOfRange(int[] original, int start, int stop)
        *     - float[] copyOfRange(float[] , int start, int stop)
        *     - long[] copyOfRange(long[] original, int start, int stop)
        *     - double[] copyOfRange(double[] original, int start, int stop)
        *     - <T> T[] copyOfRange(T[] original, int start, int stop)
        * the method is overloaded as copyOfRange() for each primitive type and reference type
        */
        String[] namesBis = Arrays.copyOfRange(names, startPos, endPos);
        System.out.printf("Original array : %s%nCopied array from range %s to %s  : %s%n" , Arrays.toString(names), startPos, endPos,  Arrays.toString(namesBis));
    }

    public static void arraysCopyOfRangeAndChangeType(){
        Dog[] dogs = new Dog[]{Dog.getInstance(), Dog.getInstance(), Dog.getInstance(), Dog.getInstance()};
        Animal[] animals = new Animal[10];

        animals = Arrays.copyOfRange(dogs, 0, 2, Animal[].class);
        System.out.printf("Original array (dogs) : %s%nCopied array (animals): %s%n", Arrays.toString(dogs), Arrays.toString(animals)  );
    }
}
