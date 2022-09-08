/*
* java.text.Collator performs language-sensitive (dictionary order) string comparisons.
* It take 2 strings to compare, returns 0 if the 2 string are the same.
* It returns 1 if the first string argument comes after the second.
* It returns -1 if the second string argument comes before the first.
*/
package com.jdojo.string;

import java.text.Collator;
import java.util.Locale;

public class LanguageSensitiveComparison{
	public static void main(String[] args) {
		// Create a Locale object for US
		Locale USLocale = new Locale("en", "US");

		// Get a Collator instance for US
		Collator c = Collator.getInstance(USLocale);
		String str1 = new String("Cat");
		String str2 = "Dog";

		int diff = c.compare(str1, str2);

		System.out.printf("Comparing using Collator class:  ");
		print(diff, str1, str2);

	}

	public static void print(int diff, String str1, String str2){
		if(diff > 0)
			System.out.println(str1 + " comes after " + str2);
		else if(diff < 0)
			System.out.println(str2 + " comes after " + str1);
		else 
			System.out.println(str1 + " and " + str2 + " are the same.");
		
	}
}