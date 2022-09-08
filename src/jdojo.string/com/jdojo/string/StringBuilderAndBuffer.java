/*
* StringBuilder and StringBuffer represent a mutable sequence of characters.
* You can change the content of a StringBuilder and StringBuffer without creating a new object.
* 
* StringBuffer exists since the beginning of Java, 
* and is thread-safe.
* whereas StringBuilder was added in Java 5 and is not thread-safe.
* Most of the time, you do not need thread safety 
* and using StringBuffer in those case has a performance penalty.
* This is the reason that StringBuilder was added later.
*
* All methods and constructors from StringBuilder and StringBuffer are the same.
* All methods in StringBuffer are synchronized.
*/
package com.jdojo.string;

public class StringBuilderAndBuffer{
	public static void main(String[] args) {
		stringBuilder();
	}

	public static void stringBuilder(){
		/*
		* You can use objects of the StringBuilder class, instead of String class,
		* in situations where content changes frequently.
		* String manipulations using a String object result in many new String objects,
		* which degraded the performance.
		*
		* A StringBuilder object can be considered as a modifiable string.
		*/
		/*
		* Constructors 
		* Four constructors exists for StringBuilder:
		*	- StringBuilder()
		*	- StringBuilder(CharSequence seq)
		*	- StringBuilder(int capacity)
		*	- StringBuilder(String str)
		*/
		// StringBuilder() create an empty string
		StringBuilder sb1 = new StringBuilder();

		// Create a StringBuilder from a string
		StringBuilder sb2 = new StringBuilder("This is a string created with StringBuilder(String)");

		// Create an empty string with a capacity of 200 characters
		StringBuilder sb3  = new StringBuilder(200);

		// Add text at the end of the string
		sb3.append("Hello world!");
		
		// length of the string 
		int size = sb1.length();		// length : 12

		/*
		* Capacity of a StringBuilder is controlled by the runtime, 
		* whereas its length is controlled by the content you place in it.
		* The runtime adjusts the capacity as its content is modified.
		* You can get the content of a StringBuilder as a String by using its toString() method.
		*/
		// Maximum numbers of characters accepted by the object
		int capacity = sb1.capacity();	// capacity: 200


		// Get a String from the StringBuilder
		String str1 = sb3.toString();
		System.out.println("Content: " + str1);
		System.out.println("Length : " + size);
		System.out.println("Capacity : " + capacity);

		/*
		* void setLength(int)
		* Allow to modify the length of the content in the StringBuilder
		* If the new length is greater than existing length, extra positions are filled with null characters (\u0000)
		* If the new length is less than existing length, content is truncated to fit in the new length
		*/
		sb3.setLength(24);
		System.out.println("setLength(24) => " + sb3.toString());

		sb3.setLength(6);
		System.out.println("setLength(6) => " + sb3.toString());

	}
}