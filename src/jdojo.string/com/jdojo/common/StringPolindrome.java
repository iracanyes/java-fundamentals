package com.jdojo.common;

import java.util.Objects;

public class StringPolindrome{
	public static void main(String[] args) {
		boolean b1 = isPolindrome("1991");
		boolean b2 = isPolindrome("Able was I ere I saw Elba");
		if(b1) 
			System.out.println("\"1991\" is a polindrome!");
		else 
			System.out.println("\"1991\" is not a polindrome!");
		
		if(b2) 
			System.out.println("\"Able was I ere I saw Elba\" is a polindrome!");
		else
			System.out.println("\"Able was I ere I saw Elba\" is not a polindrome!");
	}		

	public static boolean isPolindrome(String s){
		Objects.requireNonNull(s, "String cannot be null");

		// Get size of string
		int size = s.length();
		boolean result = true;

		/*
		* In case empty string and one character, returns true
		*/
		if(size <= 1){
			return true;
		}

		/*
		* Convert the string into uppercase, so we can make the comparisons case insensitive
		*/
		String newStr = s.toUpperCase();

		// Get number of comparison to be done
		int counter = size / 2;

		// Do the comparison
		for(int i = 0; i < counter; i++){
			if(newStr.charAt(i) != newStr.charAt(size - 1 - i)){
				// It's not a palindrome
				result = false;

				// Exit the loop
				break;
			}
		}

		return result;

	} 
}