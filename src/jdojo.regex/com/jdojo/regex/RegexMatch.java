/*
* A regular expression si a way to describe a pattern in a sequence of characters;
* The pattern may be used to:
*	- validate the sequence of characters
*	- search throught the sequence
*	- replace the sequence that match the pattern with other sequence of characters
*
* String class provides methods to work with regex:
*	- String matches(String regex)
*	- String replaceFirst(String regex, String replacement)
*	- String replaceAll(String regex, String replacement)
*
*
*/
package com.jdojo.regex;

public class RegexMatch{
	public static void main(String[] args) {
		/*
		* Regex pattern
		* "." dot character is a placeholder for one character in regular expression.
		*
		* String.matches() matches pattern in the regular expression (regex) against the entire string.
		* It returns false if part of string doesn't match the pattern. 
		* Ex: all valid email address matches partially the pattern but not entirely.
		*/ 
		String regex = ".@.";

		/* Escape character
		* If you want your regex to match a special character (like dot "."), you need to escape them with "\\"
		* A regex like ".\.." will match any string composed of one character followed by a dot and one character
		*/
		String regex2 = ".\\..";

		// try matching strings against regex pattern
		RegexMatch.matchIt("qsdfa@kpn.com", regex);
		RegexMatch.matchIt("a@k", regex);
		RegexMatch.matchIt("admin@jdojo.com", regex);
		RegexMatch.matchIt("n@j", regex);
		RegexMatch.matchIt("webmaster@gmail.com", regex);
		RegexMatch.matchIt("webmaster@gmail.com", regex);
		RegexMatch.matchIt("a%N", regex);
		
		RegexMatch.matchIt("D@Q, admin@jdojo.com, webmaster@gmail.com", regex);
		RegexMatch.matchIt("E@A, admin@jdojo.com, webmaster@gmail.com", regex);

		// find and replace
		RegexMatch.searchAndReplace("qsdfa@kpn.com, admin@jdojo.com, webmaster@gmail.com", "***", regex);
		RegexMatch.searchAndReplace("webmaster@gmail.com", "***",  regex);
		RegexMatch.searchAndReplace("webmaster@gmail.com", "***",  regex);

		// find and replace
		RegexMatch.searchAndReplaceAll("qsdfa@kpn.com, admin@jdojo.com, webmaster@gmail.com", "***", regex);
		RegexMatch.searchAndReplaceAll("webmaster@gmail.com", "***",  regex);
		RegexMatch.searchAndReplaceAll("webmaster@gmail.com", "***",  regex);

		
	}

	public static void matchIt(String str, String regex){
		// Test if pattern match
		boolean matched = str.matches(regex);
		System.out.printf("%s matched %s = %b%n", str, regex, matched);
	}

	public static void searchAndReplace(String original, String replacement, String regex){
		/* find and replace a pattern by another string
		* 	- String replaceFirst(String regex, String replacementString)
		*	
		*/
		String newStr = original.replaceFirst(replacement, regex);
		System.out.printf("\"%s\" replace first occurence %s = %n%s%n", original, regex, newStr);

	}

	public static void searchAndReplaceAll(String original, String replacement, String regex){
		/* find and replace all occurence of the pattern 
		* 	- String replaceAll(String regex, String replacementString)
		*/
		String newStr = original.replaceAll(regex, replacement);
		System.out.printf("\"%s\" replace all occurence of pattern %s = %n%s%n", original, regex, newStr);
	}


}