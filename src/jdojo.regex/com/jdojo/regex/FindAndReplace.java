/*
* FIND AND REPLACE USING REGULAR EXPRESSION
* Matcher class provides method to make such kind of work.
* Signature:
*	Matcher appendReplacement(StringBuffer sb, String replacement)
*	Matcher appendReplacement(StringBuilder sb, String replacement)
*	StringBuffer appendTail(StringBuffer sb)
*	StringBuffer appendTail(StringBuilder sb)
*
* 
*
*
*
* 
*/
package com.jdojo.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.MatchResult;

public class FindAndReplace{
	public static void main(String[] args) {
		// Regex
		String regex = "\\b\\d+\\b";

		// Pattern
		Pattern pattern = Pattern.compile(regex);

		String text = "A train carrying 125 men and women was traveling" +
						" at the speed of 100 miles per hour. The train" +
						" fare was 75 dollars per person.";

		Matcher matcher = pattern.matcher(text);

		StringBuilder sb = new StringBuilder();

		String replacementText = "";

		// Get the matched text 
		while(matcher.find()){
			int num = Integer.parseInt(matcher.group());

			if(num == 100){
				replacementText = "a hundred";
			}else if(num < 100){
				replacementText = "less than a hundred";
			}else if(num > 100){
				replacementText = "more than a hundred";
			}

			/*
			* Here u call the appendReplacement method on the Matcher instance,
			* passing an empty StringBuilder and a replacement text as argument.
			* 
			* The methods appendReplacement() checks if there was a previous match. If not it start from the beginning of the input text
			* 	- append the text that come before the match
			*	- replace the match by replacement text and append it to sb
			*	- set the append position and search for the next match
			*	- append the text from the append position until the beginning of next match.
			*	- replace the match by replacement text and append it to sb
			*	- continue until the last match and stop.
			*	- it doesn't append the text which follow the last match, you must call appendTail(sb) to append to text that follows the last match 
			*
			*IMPORTANT: Method appendReplacement() doesn't append the text which follow the last match, you must call appendTail(sb) to append to text that follows the last match 
			*/
			matcher.appendReplacement(sb, replacementText);
		}

		/*
		*IMPORTANT: Method appendReplacement() doesn't append the text which follow the last match, you must call appendTail(sb) to append to text that follows the last match 		
		*/		
		matcher.appendTail(sb);

		System.out.printf("Original text: %s%nFormatted text: %s%n", text, sb.toString());


	}
}