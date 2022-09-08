/*
* A sequence of zero or more characters is known as a string.
* String in Java are represented by an object of type java.lang.String.
* The String class is immutable.
* The contents of a String object cannot be modified after it has been created.
* String class have 2 companion class java.lang.StringBuilder and java.lang.StringBuffer.
* Those classes are mutable. 
* You should use them when the contents of your string can be modified.
*
* Before Java 9, String class implementation use an array of char 
* using 2 bytes for each character in a string.
* As many String object contains Latin-1 characters (stored on 1 bytes),
* most of time, half of space is unused.
*
* Since Java 9, String class implementation use an array of bytes, 
* to store the contents of the string and an encoding flag to indicate if 
* each character takes one or two bytes. 
*/
package com.jdojo.string;

public class StringTest{
	public static void main(String[] args) {	
		stringLiterals();
		unicodeEscapesCharacters();

		
		
	}

	public static void stringLiterals(){
		String s1 = "";	// An empty string
		String s2 = "Hello world";

		// Multiple string literals can be used to compose one string literal
		// Use "+" plus to combine multiple string literals
		String s3 = "Hello world"
					+ "Just another string literal";

		String s4 = "A sequence of zero or more characters is known as a string." +
				"String in Java are represented by an object of type java.lang.String."
				+ "The String class is immutable.";
	}

	public static void unicodeEscapesCharacters(){
		/*
		* UNICODE ESCAPES IN A STRING
		* A character can also be represented as a Unicode escape.
		* Form: '\\uxxxx' where x is an hexadecimal digit (0-9 or A-F)
		* Ex: 'A' can be replaced by '\u0041' 
		* 	 => "\u0041pple" and "Apple" are treated the same in Java
		*/
		System.out.println("Line feed as unicode escapes character : \nAnd Carriage return : \r");		
		
		/*
		* Because Unicode characters are processed at the very beginning of the compilation,
		* '\u000A' and '\u000D' will be converted into real fine feed '\n' and carriage return '\n'
		* resulting in line feed and carriage return proceeded when string literal is processed later
		* Ex: "Hello\u000AWorld" => "Hello
									World"
		* Which violates one rule: A string literal cannot continue in 2 lines.
		* Unicodes characters in comments are also processed. 
		* So a carriage return or line feed inside single line comment will break the line of comment into 2 lines 
		*/ 
		/*
		* System.out.println("You cannot use unicode escapes character to embeed line feed or carriage return in a string literals : \u000A And Carriage return : \000D");
		*/
	} 

	public static void creatingStringObjects(){
		/*
		* A CharSequence is an interface in the java.lang package.
		* CharSequence objects represents a readable sequence of characters.
		* String, StringBuilder, StringBuffer implement the CharSequence interface.
		* It provides read-only methods to read some properties and the content of 
		* the sequence of characters.
		*/
		/*
		* CREATING STRING OBJECT
		* String class contains many constructors that can be used to create a String object.
		*/
		String emptyStringObject = new String();
		String s1 = new String(emptyStringObject);	// Passing a String object
		String s2 = new String("");					// Passing empty string literal
		String s3 = new String("Creating string object from string literal");	// Passing string literal
		byte[] byteArray = new byte[]{124,01,89,65,101,45};
		String s4 = new String(byteArray);
		System.out.println("Sequence of characters created from byte[] : " + s4);
		
		/*
		* LENGTH OF STRING
		* Method "length()" from String class allow string object to returns the size of a String
		* which is the number of characters.
		*/
		int s1Length = s1.length();
		int s2Length = s2.length();

		// String literals are String objects
		int hwSize = "Hello World".length();
		System.out.println("Size of Hello world : " + hwSize);
	}

	public static void stringAreImmutable(){
		String s1;
		/*
		* String object are immutable. 
		* You cannot modify the content of a string object after its creation.		
		*/
		s1 = new String("");

		/*
		* But the reference variable which store a reference to the String objects
		* can be modify.
		* You can assign a new String object to the reference variable
		*/
		s1 = new String("Just a string.");

		/*
		* If you want the reference variable that cannot be modify after its 
		* initialization, you can use final keyword to declare a constant STring object 
		*/
		final String s2;
		s2 = new String("");

		// Compile-time error:
		// s2 = new String("Cannot modify a final constant reference variable");

	}

	public static void stringConcatenation(){
		/*
		* strObj.concat(String)
		* Takes a string as argument, which means you can use it to concatenate strings only.
		*/
		String s1 = new String("world!");
		String s2 = "Hello ".concat(s1);

		System.out.println(s2);

		/*
		* '+' operator
		* 
		*/
		String s3 = s2 + "How u doing?";
		System.out.println(s3);

		/*
		* StringBuilder and StringBuffer
		*/
		String s4 = new StringBuffer(s3).append("Me, I'm fine").append("!").toString(); 
		System.out.println(s4);
	}

}	