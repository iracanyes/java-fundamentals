/*
* Package java.util.regex provides classes to support the full version of regular expression.
*	- Pattern
*	- Matcher
*	- PatternSyntaxException
*
* A Pattern holds the compiled form of the regular expression.
* The compiled form of a regular expression is its specialized in-memory representations for faster string matching
* It's immutable, it can be shared.
* It provides a static factory method compile() which returns a Pattern instance object.
*	static Pattern compile(String regex)
*	static Pattern compile(String regex, int flags)
*
* FLAGS
* Second version of compile() method specify a flag that modify the way the pattern is matched.
*
* List of flags defined in the Pattern class
*		Flag 							Description
* 	- Pattern.CANON_EQ 					Enables canonical equivalence. 
*										If the flag is set, 2 characters match only if their canonical decompositions match
* ------------------------------------------------------------------------------------------------------------------------
*	- Pattern.CASE_INSENSITIVE 			Enables case-insensitive matching. 
*										This flag sets the case-insensitive matching only for US-ASCII charset!
*										For case-insensitive Unicode charset, the flag Pattern.UNICODE_CASE should also be set in conjunction with this flag.
* ----------------------------------------------------------------------------------------------------------------------------------------------------
* 	- Pattern.COMMENTS 					Permits whitespace and comments in pattern. When this flag is set, whitespace is ignored and embedded comments 
* ----------------------------------------------------------------------------------------------------------------------------------------------
* 	- Pattern.DOTALL 					Enables dotall mode. By default, the expression '.' (dot) doesn't match line terminators.
*										When enabled, the expression '.' match any character, including line terminators.
* ------------------------------------------------------------------------------------------------------------------------------
*	- Pattern.LITERAL 					Enables literal parsing of the pattern. Characters in the regex are treated literally. 
*										Metacharacters and escape sequence have no special meanings.
* -----------------------------------------------------------------------------------------------------------------------------------
*	- Pattern.MULTILINE 				Enables multiline mode. By default, ^ and $ match the beginning and the end of the entire input sequence.
*										They match just after and just before the line terminator or the end of the input sequence
* --------------------------------------------------------------------------------------------------------------------------------------------
*	- Pattern.UNICODE_CASE 				Enables Unicode-aware case folding. 
*										If used wih CASE_INSENSITIVE flag, the case-insensitive matching is performed according to Unicode standard.
* --------------------------------------------------------------------------------------------------------------------------------------------
* 	- Pattern.UNICODE_CHARACTER_CLASS 	Enablels the Unicode version of predefined character classes and POSIX character classes.
*										When enabled, the Predefined character classes ( US-ASCII only ) and POSIX character classes are in conformance with Unicode Technical Standard
* --------------------------------------------------------------------------------------------------------------------------------------------
* 	- Pattern.UNIX_LINES 				Enables UNIX lines mode. When enabled, only the "\n" character is recognized as line-terminator
*
* A Matcher performs the actual match by interpreting the compiled pattern  instance the string to be matched
* A PatternSyntaxException is thrown in case of a malformed regex.
*/
package com.jdojo.regex;

import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PatternClassTest{
	public static void main(String[] args) {
		// Regex
		String regex = "[a-z]@.";
		
		// Compile the regular expression into a Pattern object
		Pattern pattern = Pattern.compile(regex);

		/*
		 * Using the flags
		 */
		Pattern pattern2 = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.DOTALL );


		PatternClassTest.matchingPattern("azer@azer.com, aazere_@_qsdf.com, qsdféà@&uyi", "[a-zA-Z]@.");

		/*
		* Here, we want to search throught phone numbers to find the area code and the phone numbers
		*/		
		PatternClassTest.matchPhoneNumbers("+32475895623, 0032/475895623, 0475 895623, 0475986523, 0032475896532");
	}



	public static void matchingPattern(String str, String regex){
		Pattern pattern = Pattern.compile(regex);
		/*
		 * Creating a Matcher instance using Pattern object "pattern"
		 */
		Matcher matcher = pattern.matcher(str);

		boolean found = false;

		/*
		* Matcher class provides methods to perform the match on inputs:
		*	- find()
		*	- start()
		*	- end()
		*	- group()
		*
		*
		* Method find() is used to find a match for the pattern in the input. 
		* It returns True, if the search succeeds. Otherwise, it returns false.
		* The first call of to this method start the search at the beginning of the input.
		* If the previous call to this method was successful, the next call to this method will starts
		* the search after the previous match.  
		* Usually, you will use the method find() in a while-loop to find all occurence of the matches.
		* It's an overloaded method. 
		*	- find()
		*	- find(int offset)
		*
		* start() method returns the start index of the previous match found when the matcher.find() was called.
		* 
		* end() returns the end index of the previous match found when the matcher.find() was called.
		* The difference between returned value from start() and end() give you the length
		* 
		* group() method returns the found string by the previous successful find() method call.
		* The second version of the method group(int) alllow to specify which group you refers to.
		* Ex: (A)(B)(C) => 6 groups are reported. With group 0 refering to the entire regex "(A)(B)(C)"
		*
		* groupCount() returns the number of groups in the pattern associated with the Matcher instance.
		* There is a special group 0 which it refers to the entire regular expression. 
		* the group 0 is not reportted by groupCount()
		*
		*
		* You can refers to a group in a pattern by its index with a backslash.
		*	Ex: abxyab can modify to (ab)xy\1 => Here \1 refers to group (ab)
		*
		*
		*		
		*/
		// If a match is found
		while(matcher.find()){
			// str is the string we are looking into
			// Equivalent : String found = str.substring(matcher.start(), matcher.end());
			String foundText = matcher.group();
			
			// text found start index			
			int startIndex = matcher.start();
			
			// text found end index
			int endIndex = matcher.end();

			/*
			* Returns the number of groups in the pattern associated with the Matcher instance.
			*/
			int foundLength = matcher.groupCount();

			System.out.println("Found string is : " + foundText);
			System.out.printf("Matched text: %s, Start: %s, End: %s%n, Length: %d", foundText, startIndex, endIndex, foundLength);
			
			// If found is not set to true, set found to true
			if(!found){
				found = true;
			}


		}

		if(!found){
			System.out.println("Nothing found!");
		}

	}

	public static void matchResultClass(Matcher matcher){
		/*
		* MatchResult class represents the matched result and provides the following methods for the matched result:
		*	- int end() 
		*	- int end(int group)
		*	- int start()
		*	- int start(int group)
		*	- int groupCount()
		*	- String group()
		*	- String group(int group)
		*	
		* Advantages of using MatchResult class instead of Matcher methods
		*	- toMatchResult() of Matcher returns a copy of the match state
		*		which means any future change in the match state of Matcher instance will not affect the 
		*		MatchResult instance.
		*	- MatchResult is immutable. You can safely pass MatchResult instance to those processors.
		*	  Passing Matcher instance isn't safe because the processor may accidently modify the matcher, 
		*	  which will affect your program in an unintentional way.		
		*/
		while(matcher.find()){
			// Get the MatchResult instance
			MatchResult result = matcher.toMatchResult();

		}
	}


	public static void matchPhoneNumbers(String str){
		String regex = "\\b+?(\\d{2,4})[/ ]?(\\d{3})(\\d{6})\\b";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);

		while(matcher.find()){
			System.out.printf(
				"Phone: %s, Formatted phone: (%s) (%s-%s)%n", 
				matcher.group(), 
				matcher.group(1), 
				matcher.group(2), 
				matcher.group(3));
		}
	}
}