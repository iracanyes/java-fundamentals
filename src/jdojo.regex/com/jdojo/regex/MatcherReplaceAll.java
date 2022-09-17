package com.jdojo.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherReplaceAll{
	public static void main(String[] args) {
		MatcherReplaceAll.matchAndReplaceAll();


	}
	
	public static void matchAndReplaceAll(){
		// Prepare the regular expression
		String regex = "\\b(\\d{1,4})(\\d{3})(\\d{6})";
		String replacement = "($1) $2-$3";
		String source = "+32475895623, 0032/475895623, 0475 895623, 0475986523, 0032475896532";

		// Compile the regexd
		Pattern pattern = Pattern.compile(regex);
		
		// Get Matcher
		Matcher matcher = pattern.matcher(source);

		String formattedSource = matcher.replaceAll(replacement);

		System.out.printf("Text: %s%n", source);
		System.out.printf("Formatted text: %s%n", formattedSource);
	}
}