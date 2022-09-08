/*
*
*/
package com.jdojo.object;


import java.util.Objects;
import java.time.Instant;
import java.util.function.Supplier;
import com.jdojo.common.ObjectsTest;
import com.jdojo.common.IntHolder;
import com.jdojo.common.IntHolderWrapper;
import com.jdojo.common.IntHolderWrapperComparator;

public class ObjectsClass{
	public static void main(String[] args) {
		/*
		* Java provides an utility class "java.util.Objects" for manipulating Objects,
		* Here are the kind of operation it performs:
		* 	- Bounds checks: Check if an index or sub-range is within the bounds of a range
		*	- Comparing objects
		*	- Computing hash code
		*	- Checking for null
		*	- Validating arguments
		*	- Obtaining string representation of objects
		*/
		/*
		* BOUNDS CHECKS
		* Methods from this category are used to check if an index or sub-range
		* is within the bounds of a range.
		* These methods are used on arrays before performing an operation that involves the array bounds.
		* Structure :
		*	- int checkFromIndexSize(int fromIndex, int size, int length)
		*	- int checkFromIndex(int fromIndex, int toIndex, int length)
		*	- int checkIndex(int index, int length)
		* 
		* All 3 methods throws a IndexOutOfBoundsException if the checked for index
		* or sub-range is not within the bounds of 0 to length of the array.

		* If a client code ask for 4 elements of an array starting at position 6 
		* from an array which length is 8.
		* 
		*/
		/*
		* Bounds checks - Objects.checkFromIndexSize
		*
		* Structure:
		* 	int checkFromIndexSize(int fromIndex, int size, int length)
		*
		*
		* Checks if the sub-range from "fromIndex" (inclusive) to "fromIndex + size"
		*is within the bounds of range from 0 to length.
		*/
		int checkFromIndexSize = Objects.checkFromIndexSize(2, 5, 10);
		System.out.println("BOUND CHECKS");
		System.out.println("CHECK FROM INDEX SIZE");
		System.out.println("Sub-range(2,5) is in range(0,10) : " + checkFromIndexSize);
		/*
		* Bounds checks - Objects.checkFromIndex
		*
		* Structure:
		* 	int checkFromIndex(int fromIndex, int toIndex, int length)
		*
		* Checks if the sub-range from "fromIndex" (inclusive) to "toIndex"
		* is within the bounds of range from 0 to length.
		*/
		System.out.println("CHECK FROM TO INDEX");
		int checkFromToIndex = Objects.checkFromToIndex(2, 5, 10);
		System.out.println("Sub-range(2,5) is in range(0,10) : " + checkFromToIndex);

		/*
		* Bounds checks - Objects.checkIndex
		*
		*  Structure:
		*	int checkIndex(int index, int length)
		*
		* Checks if the index is within the bounds of range from 0 to length.
		*/
		System.out.println("CHECK INDEX");
		int ici = 5;
		int length1 = 10;
		int checkIndex = Objects.checkIndex( ici, length1);
		System.out.println("Index " + ici + " is in range 0-" + length1 + " : " + checkIndex );
		/*
		* COMPARING OBJECTS
		* These methods are used to compare objects for sorting purposes or for equality.
		*	Structure:
		*		- <T> int compare(T a , T b, Comparator<? super T> c)
		*		- boolean deepEquals(Object a, Object b)
		*		- boolean equals(Object a, Object b)
		*/
		IntHolder ih1 = new IntHolder(12);
		IntHolder ih2 = new IntHolder(32);
		System.out.println("COMPARING OBJECTS");
		/*
		* COMPARE
		* Compare() method is used to compare 2 objects for sorting purposes.
		* It returns 1 if both arguments are identical, it returns 0 if both arguments are null
		* otherwise it returns the compare method c.compare(a, b) of the comparator object
		* A comparator class must implement the interface Comparator and overriden the method compare(T o1, T o2)
		* with your own definition for a specific class.
		* The implementation of a comparator class will help sorting your own types.
		* 
		*	Structure:
		*		- <T> int compare(T a , T b, Comparator<? super T> c)
		*/
		IntHolderWrapper ihw1 = new IntHolderWrapper(12);
		IntHolderWrapper ihw2 = new IntHolderWrapper(32);

		IntHolderWrapperComparator ihwc = new IntHolderWrapperComparator();
		int result = Objects.compare(ihw1, ihw2, ihwc);
		System.out.println("COMPARE");
		System.out.println("Compare ih1 and ih2 : " + result);

		/*
		* DEEPEQUALS
		* Check if 2 objects are deeply equals.
		* it returns TRUE if the 2 objects are identical and false otherwise.
		*
		*	Structure:
		*		- boolean deepEquals(Object a, Object b)
		*/
		/*
		* Here we use a mutable class, to show deep modification
		*/
		IntHolderWrapper ihw3 = new IntHolderWrapper(12);
		IntHolderWrapper ihw4 = new IntHolderWrapper(12);
		System.out.println("DEEPEQUALS");
		boolean isDeepEqual = Objects.deepEquals(ihw3, ihw4);
		System.out.println("Objects.deepEquals(ihw1, ihw2) = " + isDeepEqual);

		IntHolder ih = ihw3.getHolder();
		ih.setValue(65);

		boolean isDeepEqual2 = Objects.deepEquals(ihw3, ihw4);
		System.out.println("Objects.deepEquals(ihw1, ihw2) = " + isDeepEqual2);
		/*
		* EQUALS
		* Compare 2 objects for equality.
		* It returns TRUE if both arguments are equals and false otherwise.
		* If 2 arguments are null reference it returns TRUE
		* If one of the 2 arguments is a null reference it returns FALSE
		*
		*	Structure:
		*		- boolean equals(Object a, Object b)
		*/
		boolean isEqual3 = Objects.equals(ih1, ih2); 
		System.out.println("EQUALS");
		System.out.println("Objects.equals(ih1, ih2) = " + isEqual3);

		/*
		* COMPUTING HASH CODE
		* These methods are used to compute hash codes for one or more objects.
		*	Structure:
		*		- int hash(Object... values)
		*		- int hash(Object obj)
		*
		* Objects.hash() method generate a hash code for all specified objects in its arguments.
		* Objects.hash(oh1) returns a value which is different of oh1.hashCode()
		* because their implementation are different.
		* Objects.hash(null) returns 0. 
		*
		*/
		ObjectsTest ot1 = new  ObjectsTest(true,12,23.00, "Hello","World");
		ObjectsTest ot2 = new ObjectsTest(true,12,23.00, "Hello","World");
		int hashCode = Objects.hash(true,12,23.00, "Hello","World");
		System.out.println("COMPUTING HASH CODE");
		// hashCode() returned value is computed by Objects.hash()
		System.out.println("ObjectsTest 1 hash : " + ot1.hashCode());
		System.out.println("ObjectsTest 2 hash : " + ot2.hashCode());
		System.out.println("Objects.hash with same value than ObjectsTest 1 and 2 : " + hashCode);


		/*
		* CHECKING FOR NULL REFERENCE
		* These methods checks if an object is null or not.
		* Structure:
		*	- boolean isNull(Object obj)
		*	- boolean nonNull(Object obj)
		*
		* isNull() method returns TRUE if the argument is null and FALSE otherwise
		* nonNull() method returns TRUE if the argument is not null and FALSE otherwise
		*/
		System.out.println("CHECKING FOR NULL REFERENCE");
		boolean isNull1 = Objects.isNull(null);
		System.out.println("null is null : " + isNull1);
		boolean isNull2 = Objects.isNull(12);
		System.out.println("12 is null : " + isNull2);
		boolean isNull3 = Objects.nonNull(null);
		System.out.println("null is non null : " + isNull3);
		boolean isNull4 = Objects.nonNull(ot1);
		System.out.println("ot1 object is non null : " + isNull4);

		/*
		* STRING REPRESENTATION OF OBJECTS
		* These methods are use to obtain a string representation of an object
		* Structure:
		*	- String toString(Object 0)
		*	- String toString(Object 0, String defaultReturn) 
		* 
		* The first method returns a string representation of an object,
		* if a null reference is given, it returns "null" as String object
		* The second method allow a default returned string as second argument
		* if a null reference is given in its first argument, it will returned
		* the value of the second arguments
		*/
		System.out.println("Object IntHolderWrapper1 to string: " + Objects.toString(ot1));

		/*
		* VALIDATING ARGUMENTS
		* These methods are used to validate requires arguments of constructor and methods.
		* All methods throws a NullPointerException
		*  Structure:
		*	- <T> T requireNonNull(T obj)
		*	- <T> T requireNonNull(T obj, String errorMessage)
		*	- <T> T requireNonNull(T obj, Supplier<String> messageSupplier)
		*	- <T> T requireNonNullElse(T obj, T defaultObj)
		*	- <T> T requireNonNullElseGet(T obj, Supplier<? extends T> supplier)
		*
		*/
		System.out.println("VALIDATING ARGUMENTS");
		try{
			/*
			* Using lambda function to create a Supplier<String> object
			* The Supplier returns a timestamped message
			*/
			Supplier<String> supplier = () -> "A string is required. Date: " + Instant.now();
			ObjectsTest ot3 = new  ObjectsTest(true,12,23.00, "Hello",null);
			
			// Use signature: <T> T requireNonNull(T obj, String errorMessage)
			ot3.printString1();
			// Use signature: <T> T requireNonNullElse(T obj, T defaultObj)
			ot3.printString2();
			// Use Objects.requireNonNull(T obj, Supplier<String> errorMessage)
			ot3.printStringWithSupplier("A random string", supplier);
			// Use Objects.requireNonNull(T obj, Supplier<String> errorMessage)
			ot3.printStringWithSupplier(null, supplier);
		}catch(NullPointerException e){
			e.printStackTrace();
		}
	}
}