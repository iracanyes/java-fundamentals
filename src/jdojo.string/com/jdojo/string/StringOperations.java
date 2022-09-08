package com.jdojo.string;

public class StringOperations{
	public static void main(String[] args) {
		String str1 = "Hello world";

		// Get the length of string
		int len = str1.length();

		// Loop through all characters of the string and print index
		for(int i = 0; i < len; i++){
			System.out.println(str1.charAt(i) + " is at index " + i);
		}

		stringEquality();
		stringIsEmpty();
		changingCase();
		searchCharactersInString();
		representingValuesInString();
		getSubstring();
		trimWhitespacesInString();
		replacePartOfString();
		matchingStartAndEndOfString();
	}

	public static void stringEquality(){
		String s1 = "Hello";
		String s2 = "HELLo";

		if(s1.equalsIgnoreCase(s2)){
			System.out.println("Ignoring case s1 and s2 are equal.");
		}else{
			System.out.println("Ignoring case s1 and s2 are not equal.");
		}

		if(s1.equals(s2)){
			System.out.println("s1 and s2 are equals.");
		}else{
			System.out.println("s1 and s2 are not equals.");
		}
	}

	public static void stringIsEmpty(){
		String s1 = "Hello";
		String s2 = "";

		System.out.println("s1 is empty : " + s1.isEmpty());
		System.out.println("s2 is empty : " + s2.isEmpty());

		boolean empty1 = "".equals(s1);	// Returns false
		boolean empty2 = "".equals(s2);	// Returns true
		System.out.println("Empty string equals s1 : " + empty1);
		System.out.println("Empty string equals s2 : " + empty2);

		boolean empty3 = s1.length() == 0;	// Returns false
		boolean empty5 = s1.length() == 0;	// Returns true
	}

	public static void changingCase(){
		/*
		* toUpperCase() method of String class allow to change the content of a string to uppercase
		* toLowerCase() method of String class allow to change the content of a string to lowercase.
		*/
		String str1 = new String("Hello world!");
		System.out.println("Default string : " + str1);
		System.out.println("String.toLowerCase() : " + str1.toLowerCase());
		System.out.println("String.toUpperCase() : " + str1.toLowerCase());
	}

	public static void searchCharactersInString(){
		/*
		* You can get the index of a character or a string within another string using :
		*	- indexOf()
		*	- lastIndexOf()
		*/
		String str = "You can get the index of a character";

		int index = str.indexOf('t');
		System.out.println("Index of t : " + index);
		System.out.println("Index of \"index\" : " + str.indexOf("index"));
	}

	public static void representingValuesInString(){
		/*
		* String.valueOf() 
		* returns a string representation of any primitive type
		*/
		String s1 = String.valueOf('C');
		String s2 = String.valueOf("100");
		String s3 = String.valueOf(true);
		String s4 = String.valueOf(3.6589d);
	}

	public static void getSubstring(){
		/*
		* String substring(int beginIndex)
		* Get a part of a string from index to endIndex specified
		*/
		String str1 = "Get a part of a string from index".substring(8);
		System.out.println("strObj.ubstring(8) : " + str1);

		/*
		* String substring(int beginIndex)
		* Get a part of a string from index to endIndex specified
		*/
		String str2 = "Get a part of a string from index to endIndex".substring(5,12);
		System.out.println("strObj.ubstring(5,12) : " + str2);
	}

	public static void trimWhitespacesInString(){
		/*
		* stringObj.trim()
		* Remove all leading and trailing whitespaces and control characters from a string. 
		*/
		System.out.println("String before trim: \\n \\r \\tHello\\n \\r \\t".trim());
		System.out.println("\n \r \tHello\n \r \t".trim());
	}

	public static void replacePartOfString(){
		/*
		*  String class provides methods to create a new string by replacing part of an string given
		* Method replace() has 4 different signature to do so.
		*	- String replace(char oldChar, char newChar)
		*	- String replace(CharSequence target, CharSequence replacement)
		*	- String replaceAll(String regex, String replacement)
		*	- String replaceFirst(String regex, String replacement)
		* 
		*/

		/*
		* String replace(char oldChar, char newChar)
		* Replace all occurences of the oldChar with the newChar and returns a new String object
		*/
		String str1 = "tooth".replace('o','e');
		System.out.println("\"tooth\".replace('o','e') => " + str1);

		/*
		* String replace(CharSequence oldSequence, CharSequence newSequence)
		* Replace all occurence of the oldSequence with the newSequence and returns a new String object
		*/
		str1 = "tooth and too".replace("oo","ee");
		System.out.println("\"tooth\".replace(\"oo\",\"ee\") => " + str1);

		/*
		* String replace(String regex, String replacement)
		* Methods uses a regular expression in regex
		*/
		// Here we replace all digits with an *. str contains "Born Dec **, ****"
		String str2 = "Born on Dec 25, 1965".replaceAll("\\d", "*");
		System.out.println("Default string : " + "Born on Dec 25, 1965");
		System.out.println("str2.replaceAll(\"\\d\", \"*\") : " + str2 );

		/*
		* String replaceFirst(String regex, String replacement)
		* Replace only the first occurence corresponding to regex with the replacement string
		*/
		String s3 = "Born on Dec 25, 1965".replaceFirst("Dec", "Jan");
		System.out.println("Default string : " + "Born on Dec 25, 1965");
		System.out.println("str2.replaceFirst(\"\\d\", \"*\") : " + str2 );

	}

	public static void matchingStartAndEndOfString(){
		String str1 = "This is a Java string";
		/*
		* boolean startWith(String s)
		* Checks if the string start with the specified argument.
		*/
		if(str1.startsWith("This")){
			System.out.println("String start with \"This\"!");
		}else{
			System.out.println("String doesn't start with \"This\"!");

		}

		/*
		* boolean startWith(String s)
		* Checks if the string start with the specified argument.
		*/
		if(str1.endsWith("!")){
			System.out.println("String ends with \"!\".");
		}else{
			System.out.println("String doesn't ends with \"!\".");
		}	
	}

}