/*
* Array provides methods to several routines operations such as converting, sorting, comparing, etc.
* Java provide the class java.util.Arrays which contains over 150 static methods to perform such type of array operations.
* Most of the methods have at least nine overloaded versions (one for each of the eight primitive type and one for the reference type).
* Operations can be performed on the entire array or on a range of elements that doubles the number of operations to at least 18 for one type of operation.
* Here, a presentation of only the type of operation is made, it's not an exhaustive list of methods provided by Arrays class.
* See java.util.Arrays API docs for more on array manipulation
*
* CONVERSION
* For converting an array here is the list of type of operation provided by Arrays class:
*   - asList()          : fixed-size list. Only one version of this method.
*   - stream()          : sequential stream of an array for all elements or a range of elements.
*   - toString()        : string representation of the contents of the specified array.
*   - deepToString()    : string representation of the "deep contents" of an array. Useful for multi-dimensional array

*
*/
package com.jdojo.array.operation;

import java.util.Arrays;
import java.util.List;
import com.jdojo.person.Person;
import com.jdojo.common.Dog;

public class ConversionTest{
    public static void main(String[] args) {
        String[] animals = {"Rat", "Dog", "Cat"};

        // Convert the array to List
        List<String> animalList = Arrays.asList(animals);
        System.out.printf("Arrays.asList(animals) : %n%s%n", animalList);

        // Convert the array to String
        String str = Arrays.toString(animals);
        System.out.printf("%nArrays.toString(animals) : %n%s%n", str);

        // Convert the array to Stream and sort elements in Stream
        System.out.println("\nArrays.stream(animals).sorted().forEach(System.out::println) : ");
        Arrays.stream(animals)
            .sorted()
            .forEach(System.out::println);

        Person[] persons = { Person.getInstance(), Person.getInstance() };

        // Convert the array to List
        List<Person> personList = Arrays.asList(persons);
        System.out.printf("%nArrays.asList(persons) : %n%s%n", personList);

        // Convert the array of Person to String
        str = Arrays.toString(persons);
        System.out.printf("%nArrays.toString(persons) :%n%s%n", str);

        System.out.println("\nArrays.stream(persons).sorted().forEach(System.out::println) : ");
        persons[1].setFirstName("Jane");

        Arrays.stream(persons)
            .sorted()
            .forEach(System.out::println);

        Dog[] myDogs = { Dog.getInstance(), Dog.getInstance()};
        str = Arrays.toString(myDogs);
        System.out.printf("%nArrays.toString(myDogs) : %n%s%n", str);
        str = Arrays.deepToString(myDogs);
        System.out.printf("%nArrays.deepToString(myDogs) : %n%s%n", str);
     }

}
