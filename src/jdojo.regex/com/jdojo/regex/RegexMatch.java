/*
* A regular expression si a way to describe a pattern in a sequence of characters;
* The pattern may be used to:
*	- validate the sequence of characters
*	- search throught the sequence
*	- replace the sequence that match the pattern with other sequence of characters
*
* 
*
*/
package com.jdojo.regex;

public class RegexMatch{
	public static void main(String[] args) {
		// Regex pattern
		// Here we search for 
		String regex = ".@.";

		// try matching strings against regex pattern
		RegexMatch.matchIt("qsdfa@kpn.com", regex);
		RegexMatch.matchIt("admin@jdojo.com", regex);
		RegexMatch.matchIt("webmaster@gmail.com", regex);
		RegexMatch.matchIt("webmaster@gmail.com", regex);
		RegexMatch.matchIt("a%N", regex);
		RegexMatch.matchIt("webmaster@gmail.com", regex);
	}

	public static void matchIt(String str, String regex){
		// Test if pattern match
		boolean matched = str.matches(regex);
		System.out.printf("%s matched %s = %b%n", str, regex);
	}
}