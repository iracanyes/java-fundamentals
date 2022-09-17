/*
* The data type of each element of an array is the same as the data type of the array.
* Ex: int[] contains only int type element.
* The value assigned to an element of an array must be assignment-compatible to its data type.
* Ex: int[] accept byte, short and char value as they are assignment-compatible
*
*/
package com.jdojo.array;

import com.jdojo.person.Person;
import com.jdojo.address.Address;
import com.jdojo.common.Dog;
import com.jdojo.common.Animal;

public class ArrayAssignmentCompatibility{
    public static void main(String[] args) {
        assignmentCompatibleArray();
        genericArray();

    }

    public static void assignmentCompatibleArray(){
        /*
        * An int array can only contains value that are assignment-compatible as byte, short, char
        */
        int[] sequence = new int[10];
        sequence[0] = (byte) 12;    // 12
        sequence[1] = (short) 12;   // 12
        sequence[2] = 'b';          // 98
        sequence[3] = 12;
        sequence[4] = '\u0012';     // 18
        sequence[5] = 0x0012;       // 18
        sequence[6] = 0012;         // 10

        System.out.printf("int[] sequence: ");
        int n= 0;
        for(int i: sequence){
            System.out.printf("sequence[%d]: %s%n", n, i);
            n++;
        }

        /*
        * Person[] can only contains Person class instance (objects)
        */
        Person[] persons = { Person.getInstance(), Person.getInstance()};

        for(Person person: persons){
            System.out.printf("%s%n", person);
        }



    }

    public static void genericArray(){
        // Create a generic array
        Object[] genericArray = new Object[10];


        /* Assignment data of different type
        * IMPORTANT: Here Autoboxing will box all objects added to the generic array to Object type.
        */
        // Same as: genericArray[0] = (Object) new String("Hello");
        genericArray[0] = new String("Hello");
        genericArray[1] = Person.getInstance();
        genericArray[2] = Address.getInstance();
        genericArray[3] = null;
        genericArray[4] = Dog.getInstance();

        // Access element of generic array.
        // Remember that all object in a generic array are of type Object.
        // You must cast them to their correct corresponding type to
        String str = (String) genericArray[0];
        Person person = (Person) genericArray[1];
        Address address = (Address) genericArray[2];
        Person person2 = (Person) genericArray[4];

        try{
            // If you cast to a wrong corresponding type, a run-time exception will be thrown
            // ClassCastException:  class com.jdojo.common.Dog cannot be cast to class com.jdojo.person.Person
            Person person3 = (Person) genericArray[4];
        }catch(Exception e){
            e.printStackTrace();
        }

        /*
        * An array reference can be assigned to another array reference of another type
        * if the former type is assignment-compatible to the latter type.
        */
        Object[] objArr = new Object[3];
        String[] strArr = new String[2];
        Person[] personArr = new Person[10];
        Dog[] dogArr = new Dog[5];
        Animal[] animalArr = new Animal[3];

        objArr = personArr;
        personArr = (Person[]) objArr;

        objArr = strArr;
        strArr = (String[]) objArr;

        animalArr = dogArr;

        //  Compile-time error: incompatible types: Animal[] cannot be converted to Dog[]
        // dogArr = animalArr;
        dogArr = (Dog[]) animalArr;
    }
}
