/* GROUP AND BACK REFERENCING
* Characters can be treated as group. 
* A group is created by enclosing one or more characters inside parentheses ()
* Each group in a regex has a group number which starts from 1.
* The group 0 is a special default group which refers to the entire regular expression.
* Group 0 will always be defined even if no explicit group are defined in the regular expression.
* It's always refers to the entire regular expression.
* Ex: 	ABXY	=>	group 0 : ABXY
*		AB(XY) => 	group 0 : AB(XY), 
*					group 1: (XY)
*		(AB)(XY) => group 0 : (AB)(XY), 
*					group 1: (AB), 
*					group 2: (XY) 
*		((A)((X)(Y))) => 	group 0 : ((A)((X)(Y))),  
*							group 1 : ((A)((X)(Y)))
*							group 2 : (A)
* 							group 3 : ((X)(Y))
*							grôup 4 : (X)
*							grôup 4 : (Y)
*
*
* Matcher class provides a method which returns the number of group present in a regular expression; 
* The group 0 is not reported by groupCount() of Matcher class .
*
* BACK REFERENCING
* You can back reference group numbers in a regular expression 
* using following notation "\x" where x is the number of the group
* Ex: 	(ab)xy\1 => where \1 refers to (ab). the result is abxyab
*		(ab)xy\12 => the result is abxyab2
*
* You can also use back referencing in the replacement text when using 
* methods replaceFirst and replaceAll of classes String and Matcher
* The notation used is "$x" where x is the number of the group 
*
*/
package com.jdojo.regex;

import java.util.regex.Matcher;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;


public class GroupAndBackReferencing{
	public static void main(String[] args) {
		GroupAndBackReferencing.matcherReplaceFirst(
			"+32475895623, 0032/475895623, 0475 895623, 0475986523, 0032475896532", 
			"($1) $2-$3", 
			"\\b+?(\\d{1,4})[/ ]?(\\d{3})(\\d{6})\\b"
		);
		GroupAndBackReferencing.matcherReplaceAll(
			"+32475895623, 0032/475895623, 0475 895623, 0475986523, 0032475896532", 
			"($1) $2-$3", 
			"\\b+?(\\d{1,4})[/ ]?(\\d{3})(\\d{6})\\b"
		);
		
	}

	public static void stringReplaceFirst(String original, String replacement, String regex){
		String formattedString;

		try{
			//
			formattedString = original.replaceFirst(regex, replacement);

			System.out.printf("Original text: %s%nRegex: %s%nFormatted text: %s%n", original, regex, formattedString);

			
		}catch(Exception e){
			System.err.printf(e.getMessage());
		}	
		

	}

	public static void matcherReplaceFirst(String original, String replacement, String regex){
		try{
			Pattern pattern = Pattern.compile(regex);

			Matcher matcher = pattern.matcher(original);

			String formattedOriginal = matcher.replaceFirst(replacement);

			System.out.printf("Original text: %s%nRegex: %s%nFormatted text: %s%n", original, regex, formattedOriginal);

			// here we print text for each group
			int nGroup = matcher.groupCount();
			for(int x = 1; x < nGroup + 1; x++){
				String groupText = matcher.group(x);
				System.out.printf("Group num : %d%nGroup Text : %s%n", x, groupText);
			}
		}catch(Exception e){
			System.err.printf(e.getMessage());
		}

	}

	public static void matcherReplaceAll(String original, String replacement, String regex){
		String formattedString;
		try{
			Pattern pattern = Pattern.compile(regex);

			Matcher matcher = pattern.matcher(original);

			formattedString = matcher.replaceAll(replacement);

			System.out.printf("Original text: %s%nRegex: %s%nFormatted text: %s%n", original, regex, formattedString);
			
			// reset the matcher the search throught the string again
			matcher.reset();
			// here we print text for each group
			int nGroup = matcher.groupCount();
			while(matcher.find()){
				for(int x = 1; x < nGroup + 1; x++){
					String groupText = matcher.group(x);
					System.out.printf("Group num : %d%nGroup Text : %s%n", x, groupText);
				}
			}			
			
		}catch(Exception e){
			System.err.printf(e.getMessage());
		}

		try{

			/*
			* The other version takes as argument a  Function 
			* which takes as argument a MatchResult and returns a replacement string
			* It allow to use your custom logic inside the Function instance to get the replacement string
			* Signature:
			* 	String replaceFirst(Function<MatchResult,String> replacer)
			*/
			formattedString = original.replaceAll(regex, replacement);
			System.out.printf("Original text: %s%nRegex: %s%nFormatted text: %s%n", original, regex, formattedString);


		}catch(Exception e){
			e.printStackTrace();
		}


	}

	
	/*
	* Here, a custom replacer for formatting the replacement text using group number 
	*/
	public static String customReplacer(MatchResult result){
		String replacementText = "($1) $2-$3";

		String countryCode = result.group(1);
		if("0032".equals(countryCode)){
			replacementText = "(***) / *** ** ** **";
		}

		return replacementText;
	}


}