package com.jdojo.string;

public class StringPool{
	public static void main(String[] args) {
		/*
		* Java maintains a pool of all string literals in order to minimize the memory usage 
		* and for better performance.
		* It creates a String object in the string pool for every string literal it finds in a program.
		* When a string literal is encoutered, it looks for a string object in the string pool with the identical content.
		* 
		* If not found, it creates a new String object with that content and adds it to the string pool.
		* Finally, it replaces the string literal with the reference of the newly created String object in pool.
		* 
		* If a match is found in the string pool, it replaces the string literal with the reference of the String object found in the pool.
		*
		* In the example below, for the first assignation, Java will look for a String object that match in the pool.
		* If nothing found, it create one and add it to the pool
		* Next string literals with the same value will use the reference to the String object in the string pool.
		* String object created by a call to constructor using "new" keyword will not use reference in String pool.
		* But a new string object will be created
		*  
		*/
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		String s3 = "Hello";

		// As new operator always create a new object s1 == s2 will be false

		/*
		* As string literal are processed at compile time as constant expression and add to String pool.
		* s1 == s2 will be true.
		*/
		s1 = "Have" + "Fun";
		s2 = "HaveFun";
		System.out.println(s1 == s2);

		final String constStr = "Constant string";
		String varStr = "Mutable string";

		// All String literals and string literals resulting from compile-time constant expression are added to the string pool.
		// "Constant string is pooled" will be added to string pool
		s1 = constStr + " is pooled.";

		// Concatenated string will not be added to the string pool
		s2 = varStr + "is pooled";

		boolean constStrEquality  = "Constant string is pooled" == s1;	// Returns true as the 2 constant use the same reference to String object
		boolean varStrEquality = "Mutable string is pooled" == s2;		// Returns false as s2 reference is not added to pool

		/*
		* You can add a String object to the string pool using its "intern()" method.
		* The intern() method returns the reference of the object from the string pool if it finds a match.
		* It adds a new String object to the string pool and returns the reference of the new object.
		*/
		// Here we add 
		s2 = s2.intern();
		varStrEquality = "Mutable string is pooled" == s2;		// Returns true



	}
}