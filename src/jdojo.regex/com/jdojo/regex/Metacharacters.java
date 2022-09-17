/*
* Metacharacters are characters with a special meanings. 
* The special characters meanings depends of the context. 
* They can be treated as ordinary characters or as metacharacters depending on the context they are used
* Here are the metacharacters:
*	- ][
*	- )(
*	- }{
*	- ^ (caret)
*	- $
*	- |
* 	- ?
*	- *
*	- +
*	- .
*	- <
* 	- >
*	- *
*	- - (a hyphen)
*	- =
*	- ! 
*	- \ 
*
* The metacharacters ][ are used to specify a character class inside a regular expression.
* A character class is a set of characters. character class has no relation with a class constructor or class file.
* Regex engine will attempt to match one character from the set.
* Ex: 	[ABC] will match A, B, or C.
*		[ABC]@. will "A@B", "C@V" but not "H@V"
*
*
*
* The metacharacter - (hyphen) is used to specify a range of characters using a character class.
* Ex:  [a-z] => range 'a' to 'Z'
*		[A-Z] => range 'A' to Z
*		[0-9] => range 0 to 9 
*
* The metacharacter ^ (caret) is used to complement or negate a character or a range if it's used at the beginning
* If it's used anywhere else, it's treated as an ordinary character
* Ex: 	[^xyz] => all characters except x, y, z 
*		[^A-Z] => all characters except uppercase characters
*		[ABC^] => A, B, C and ^
*		[a-z&&[^aeuio]] => substact all vowels of range a-z
*
* You can make an union of multiple ranges.
* Ex: [a-df-ir-w] => union (or) of 3 ranges a-d f-i r-w
* 
* You can also make an intersection between to range
* Ex: [0-9&&[4-8]] => intersection (and) of 2 ranges 0-9 and 4-8= 4-8
*
* You can also make a substraction between 2 ranges using ^ (complement or negation) character
* Ex: [a-z&&[^aeuio]] => substact all vowels of range a-z
*
*
* PREDEFINED CHARACTER CLASSES
* 	- . (a dot) 		Any character (may or may not match line terminator). See docs java.util.regex.Pattern section line terminators
*	- \d 				A digit. Same as [0-9]
*	- \D 				A non-digit. Same as [^0-9]
* 	- \s 				A whitespace character. Same as [\t\n\x0B\f\r]
* 	- \S 				A non-whitespace character. Same as [^\s]
* 	- \w 				A word character. Same as [a-zA-Z_0-9]
*	- \W 				A non-word character. Same as [^\w]
*
* QUANTIFIER IN REGEX
* A quantifier must follow a character or character class for which it specifies the quantify
* Ex: 	\\d+ => one or more digits
*		[a-z]{2,3} => 2 or 3 character between a and z
*
* Here is the list of quantifier and their meanings
*
*	- * 				Zero or more times
* 	- + 				One or more times
*	- ? 				One or nothing
*	- {x}				Exactly x times
*	- {x, } 			At least  times 
*	- {x, y}			Comprise between x times and  y times
*
* MATCHING BOUNDARIES
* Concentrate on the location of the pattern 
*
* 	- ^ 		The beginning of a line (match the beginning of each line in a multiline input)
* 	- $ 		The end of a line
*	- \b 		A word boundary
* 	- \B 		A non-word boundary
* 	- \A 		The beginning of the input 
* 	- \G 		The end of previous match
*	- \Z 		The end of the input but for the final terminator, if any
* 	- \z 		The end of the input
*
* In Java, a word character is defined by [a-zA-Z_0-9].
* A word boundary is a zero-width match that can match :
* 	- between a word character and a non-word character
*	- Start of the string and a word character
* 	- A word character and the end of the string
* 	
* A non-word boundary is also a zero-width match and it's the opposite of the word boundary.
* 	- an empty string
*	- between 2 word characters
* 	- between 2 non-word characters
* 	- between a non-word character and the start or the end of the string
*
* Using a word boundary, you specify your pattern to distinguish between "apple" and "pinapple"
* Ex: \\bapple\\b
*
* GROUP AND BACK REFERENCING
* () parenthese are used to group multiple characters. 
* Each group in a regex has a group number which start by 1.
* Ex: (this(is(me))) create 3 groups of occurence. First group will  
*/
package com.jdojo.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.MatchResult;


public class Metacharacters{
	public static void main(String[] args) {
		/* BEWARE OF BACKSLASHES
		* As backslash(\) is used for escape characters even in the code's comments, you must escape them to use
		* special characters in regex (\d => \\d)
		* You can also nullify the meanings of special predefined characters by escaping them. 
		* Ex: (\d => \\\\d) and ([] => \\[\\])
		*/
		Metacharacters.matchIt("azer@azer.com", "\\b\\w+@\\w+.com\\b");
		Metacharacters.matchIt("qsdféà@&uyi", "\\b\\w*@\\w*.com\\b");
		Metacharacters.matchIt("azer@azer.com, azer@qear@qsdf.com, aze@aze.com", "\\b\\w{1,3}@\\w.[(com)(be)(fr)]\\b");

		Metacharacters.matchIt("azer@azer.com", "\\b\\w+@\\w+.com\\b");
		Metacharacters.matchIt("qsdféà@&uyi", "\\b\\w*@\\w*.com\\b");
		Metacharacters.matchIt("azer@azer.com, azer@qear@qsdf.com, aze@aze.com", "\\b\\w{1,3}@\\w.[(com)(be)(fr)]\\b");

		/*
		* Here, we want to search throught phone numbers to find the area code and the phone numbers
		*/
		String pattern = "\\b(\\d{2,4})[/ ]?(\\d+{3})(\\d{6})\\b";

		/*
		* we can use the back referencing  a Group inside a replacement text 
		* String class methods (replaceFirst, replaceAll) and Matcher class methods (replaceAll)
		*/
		String replacement = "($1) $2/$3";
		String phoneNumbers = "+32475895623, 0032/475895623, 0475 895623, 0475986523, 0032475896532";
		Metacharacters.matchIt(phoneNumbers, pattern);
		Metacharacters.stringReplaceFirst(phoneNumbers, replacement, pattern);
		Metacharacters.stringReplaceAll(phoneNumbers, replacement, pattern);
		Metacharacters.matcherReplaceFirst(phoneNumbers, replacement, pattern);
		Metacharacters.matcherReplaceAll(phoneNumbers, replacement, pattern);
		

	}

	public static void matchIt(String str, String regex){
		// Test if pattern match
		boolean matched = str.matches(regex);
		System.out.printf("%s matched %s = %b%n", str, regex, matched);
	}


	public static void stringReplaceFirst(String original, String replacement, String regex){
		/* find and replace a pattern by another string
		* 	- String replaceFirst(String regex, String replacementString)
		*	
		*/
		String newStr = original.replaceFirst(replacement, regex);
		System.out.printf("\"%s\" replace first occurence %s : %n%s%n", original, regex, newStr);

	}

	public static void stringReplaceAll(String original, String replacement, String regex){
		/* find and replace all occurence of the pattern 
		* 	- String replaceAll(String regex, String replacementString)
		*/
		String newStr = original.replaceAll(regex, replacement);
		System.out.printf("\"%s\" replace all occurence of pattern %s = %n%s%n", original, regex, newStr);
	}

	public static void matcherReplaceAll(String original, String replacement, String regex){
		// Compile the regex for improved performance
		Pattern pattern = Pattern.compile(regex);

		// Matcher from original string
		Matcher matcher = pattern.matcher(original);
		
		// Replace all occurence of the 
		String formattedString = matcher.replaceAll(replacement);
		System.out.printf("\"%s\" replace all occurence of pattern %s = %s%n", original, regex, formattedString);

	}

	public static void matcherReplaceFirst(String original, String replacement, String regex){
		// Compile the regex for improved performance
		Pattern pattern = Pattern.compile(regex);

		// Matcher from original string
		Matcher matcher = pattern.matcher(original);
		
		// Replace all occurence of the 
		String formattedString = matcher.replaceFirst(replacement);
		System.out.printf("\"%s\" replace all occurence of pattern %s = %s%n", original, regex, formattedString);

	}

}