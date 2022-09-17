/*
* Since Java 9, Matcher class provides a new method that returns a stream of MatchResult
*	Stream<MatchResult> results()
*
* Stream API is vast topic. It let you apply filter-map-reduce operations to a stream of data.
* See chapitre on Stream API
*
* results() method return match results in a stream whose elements are of the MatchResult type.
* You can query the MatchResult to access the match details.
* results() method doesn't reset the matcher.
* If you want to reuse the matcher don't forget to call its reset() method to reset it to a specific position;
*
* Operation like count number of matches, list of matches, or filtering on some specific groups becomes more easy with streams
*/
package com.jdojo.regex;

import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class StreamsOfMatchedResults{
	public static void main(String[] args) {
		System.out.println("Hello world");
		distinctCountryCode();
	}

	public static void distinctCountryCode(){
		String regex = "\\b+?(\\d{2,4})[/ ]?(\\d{3})(\\d{6})\\b";

		// An input string
		String source = "+32475895623, 0032/475895623, 0475 895623, 0475986523, 0032475896532";
		System.out.printf("Input: %s%n", source);

		// Create a matcher
		Matcher matcher = Pattern.compile(regex).matcher(source);

		// Format text and Collect formatted phone numbers into a list
		List<String> phones = matcher.results()
																	.map(mr -> (mr.group(1) == null) ? "" : "(" + mr.group(1) + ") " + mr.group(2) + " " + mr.group(3))
																	.collect(toList());
		System.out.printf("Phones numbers : %s%n" , phones);

		// Reset the matcher, so we can reuse it from beginning
		matcher.reset();

		// Get distinct country codes
		// use filter() to filter matchResults to remove all undefined countryCodes
		// use map() to get only countryCode from matchResults
		Set<String> countryCodes = matcher.results()
										.filter(mr -> mr.group(1) != null)
										.map(mr -> mr.group(1))
										.collect(toSet());

		System.out.printf("Distinct country code : %s%n", countryCodes );
	}
}
