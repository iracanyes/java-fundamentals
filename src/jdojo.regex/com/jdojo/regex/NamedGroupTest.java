/*
* Java also supports named groups. 
*	- You can name a group
*	- get the matched text using the group name
*	- Use back referencing group with group names
*	- Use back referencing groups names with replacement text 
* 
* Notation: 
*	(?<group-name>pattern)
*
* Ex: +?(?<countryCode>\d{2,4})[/ ]?(?<areaCode>\\d{3})(?<phoneNumber>\\d{5});
*
* You can use back reference the group named using the following notation
* Ex: groupName => \k<groupName>
*
* You can also use back reference inside replacement text using the following notation:
* 	${groupName}
*
*
*/
package com.jdojo.regex;

import java.util.regex.Matcher;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class NamedGroupTest {
	public static void main(String[] args) {
		/*
		* Here, we use back reference with the regular expression pattern to find 2 phone numbers which followed 
		*/
		System.out.println("NamedGroupTest.stringMatches");
		NamedGroupTest.stringMatches(
			"+32475895623, 0032/475895623, 0475 895623, 0475986523, 0032475896532", 
			"\\b+?(?<countryCode>\\d{2,4})[/ ]?(?<prefix>\\d{3})(?<lineNumber>\\d{6})\\b, \\b+?\\k<countryCode>[/ ]?\\k<prefix>\\k<lineNumber>\\b"
		);
		NamedGroupTest.stringReplaceFirst(
			"+32475895623, 0032/475895623, 0475 895623, 0475986523, 0032475896532", 
			"${countryCode} / ${prefix} ${lineNumber}", 
			"\\b+?(?<countryCode>\\d{2,4})[/ ]?(?<prefix>\\d{3})(?<lineNumber>\\d{6})\\b"
		);
		NamedGroupTest.stringReplaceAll(
			"+32475895623, 0032/475895623, 0475 895623, 0475986523, 0032475896532", 
			"${countryCode} / ${prefix} ${lineNumber}", 
			"\\b+?(?<countryCode>\\d{2,4})[/ ]?(?<prefix>\\d{3})(?<lineNumber>\\d{6})\\b"
		);

		NamedGroupTest.matcherReplaceFirst(
			"+32475895623, 0032/475895623, 0475 895623, 0475986523, 0032475896532", 
			"${countryCode} / ${prefix} ${lineNumber}", 
			"\\b+?(?<countryCode>\\d{2,4})[/ ]?(?<prefix>\\d{3})(?<lineNumber>\\d{6})\\b"
		);

		
		NamedGroupTest.matcherReplaceAll(
			"+32475895623, 0032/475895623, 0475 895623, 0475986523, 0032475896532", 
			"${countryCode} / ${prefix} ${lineNumber}", 
			"\\b+?(?<countryCode>\\d{2,4})[/ ]?(?<prefix>\\d{3})(?<lineNumber>\\d{6})\\b"
		);

		
		NamedGroupTest.matcherReplaceFirstWithCustomReplacer(
			"+32475895623, 0032/475895623, 0475 895623, 0475986523, 0032475896532", 
			"\\b+?(?<countryCode>\\d{2,4})[/ ]?(?<prefix>\\d{3})(?<lineNumber>\\d{6})\\b"
		);

		NamedGroupTest.matcherReplaceAllWithCustomReplacer(
			"+32475895623, 0032/475895623, 0475 895623, 0475986523, 0032475896532", 
			"\\b+?(?<countryCode>\\d{2,4})[/ ]?(?<prefix>\\d{3})(?<lineNumber>\\d{6})\\b"
		);
		
	}

	public static void stringMatches(String original, String regex){
		
		boolean foundText = original.matches(regex);
		System.out.printf("Original text: %s%nRegex : %s%nFound text : %s%n", original, regex, Boolean.toString(foundText));
	}

	public static void stringReplaceFirst(String original, String replacement, String regex){
		
		//
		String formattedString = original.replaceFirst(regex, replacement);
		System.out.printf("Original string: %s%nFormatted string: %s%n", original, formattedString);
	}

	public static void stringReplaceAll(String original, String replacement, String regex){
		
		//
		String formattedString = original.replaceAll(regex, replacement);
		System.out.printf("Original string: %s%nFormatted string: %s%n", original, formattedString);
	}

	public static void matcherReplaceFirst(String original, String replacement, String regex){
		String formattedString;

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(original);

		formattedString = matcher.replaceFirst(replacement);

		System.out.printf(
				"Original string: %s%nFormatted string: %s%n",
				original,
				formattedString
		);

		NamedGroupTest.printGroupDetail(matcher);
	}

	public static void matcherReplaceAll(String original, String replacement, String regex){
		String formattedString;

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(original);

		formattedString = matcher.replaceAll(replacement);

		System.out.printf(
				"Original string: %s%nFormatted string: %s%n",
				original,
				formattedString
		);

		NamedGroupTest.printGroupDetail(matcher);
	}

	public static void matcherReplaceFirstWithCustomReplacer(String original, String regex){
		String countryCode, prefix, lineNumber, formattedString;

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(original);

		formattedString = matcher.replaceFirst(NamedGroupTest::customReplacer);

		System.out.printf(
				"Original string: %s%nFormatted string: %s%n",
				original,
				formattedString
		);

		NamedGroupTest.printGroupDetail(matcher);
	}

	public static void matcherReplaceAllWithCustomReplacer(String original, String regex){
		String formattedString;

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(original);

		formattedString = matcher.replaceAll(NamedGroupTest::customReplacer);
		System.out.printf(
				"Original string: %s%nFormatted string: %s%n",
				original,
				formattedString
		);

		NamedGroupTest.printGroupDetail(matcher);
	}

	/*
	* Here, a custom replacer for formatting the replacement text using group number 
	*/
	public static String customReplacer(MatchResult result){
		String replacementText = "($1) $2 $3, ";

		String countryCode = result.group(1);
		if("0032".equals(countryCode)){
			replacementText = "(***) / *** ** ** **";
		}

		return replacementText;
	}

	public static void printGroupDetail(Matcher matcher){
		String countryCode, prefix, lineNumber;

		matcher.reset();
		while(matcher.find()){
			//MatchResult result = matcher.toMatchResult();
			/*
			* Same as:
			* String countryCode = original.substring(matcher.start("countryCode"), matcher.end("countryCode"));
			*/
			countryCode = matcher.group("countryCode");

			/*
			* Same as:
			* String prefix = original.substring(matcher.start("prefix"), matcher.end("prefix"));
			*/
			prefix = matcher.group("prefix");

			/*
			* Same as:
			* String lineNumber = original.substring(matcher.start("lineNumber"), matcher.end("lineNumber"));
			*/
			lineNumber = matcher.group("lineNumber");
			
			System.out.printf(
				"%nCountry code: %s%nPrefix: %s%nLine number: %s%n",
				countryCode,
				prefix,
				lineNumber
			);

		}
		
	}


}