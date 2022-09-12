/*
* SimpleDateFormat class provides method to create a custom pattern.
* SimpleDateFormat is locale-sensitive.
* The default constructor creates a formatter with the default locale and default date format for the locale.
* Other constructors allow to specify your own locale and date format
* List of symbols used for formatting:
*
*	LETTER 		DATE OR TIME COMPONENT 		PRESENTATION 		EXAMPLES
*	- G 		Era designator 				Text 				AD
*	- y 		Year						Year 				2013, 22
*	- Y 		Week-based year 			Year 				2003, 05
*	- M 		Month in year 				Month 				March, Mar, 03
*	- w 		Week in year 				Number 				27
*	- W 		Week in month 				Number 				3
*	- D 		Day in year 				Number 				255
*	- d 		Day in month 				Number 				28
*	- F 		Day of week in month 		Number 				6
*	- E 		Day in week 				Text 				Tuesday, Tue
*	- a 		AM/PM marker 				Text 				AM, PM
*	- H 		Hour in day (0-23)			Number 				23
*	- k 		Hour in day (1-24)			Number 				24
*	- K 		Hour in AM/PM (0-11) 		Number 				11
*	- h 		Hour in AM/PM (1-12)		Number 				12
*	- m 		Minute in hour 				Number 				59
*	- s 		Second in minute 			Number  			58
*	- S 		Millisecond 				Number 				798
*	- z 		Time zone 					General Time Zone 	Pacific Standard Time; PST; GMT-08:00
*	- Z 		Time zone 					RFC 822 time zone  	-0800

*/
package com.jdojo.format.data;

import java.text.SimpleDateFormat;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Calendar;


public class CustomLegacyDateFormatter{
	public static void main(String[] args) {
		simpleformatter();
		parsingDates();
		parseComplexString();
	}

	public static void simpleformatter(){
		// Create a formatter with a pattern dd/MM/YYYY
		SimpleDateFormat simpleFormatter = new SimpleDateFormat("dd/MM/yyyy");

		// Get the current date
		Date today = new Date();

		// Format the current date
		String formattedDate = simpleFormatter.format(today);
		System.out.println("Today (dd/MM/yyyy) :" + formattedDate);

		// Change the date format
		simpleFormatter.applyPattern("MMMM dd, yyyy");
		// Format the current date
		formattedDate = simpleFormatter.format(today);
		System.out.println("Today (MMMM dd, yyyy) :" + formattedDate);

		/*
		* You can embeed literals inside formatted dates. 
		* You cannot use letters, such as [a-zA-Z], as literals inside a date pattern
		* literals must be placed inside single quote and if you want to use a single quote in the literals,
		* you must escape the single quote with another single quote ('')
		*/
		simpleFormatter.applyPattern("'En l''an de grâce' yyyy 'le' dd', du mois' MMMMM");
		// Format the current date
		formattedDate = simpleFormatter.format(today);
		System.out.println("Today ('En l''an de grâce' yyyy' le dd, du mois 'MMMMM) :" + formattedDate);

		// Get Calendar instance 
		Calendar cal = Calendar.getInstance();


		// Set the date 
		cal.setTime(new Date());

		// Print component
		System.out.println("Hour: " + cal.get(Calendar.HOUR));
		System.out.println("Minute: " + cal.get(Calendar.MINUTE));
		System.out.println("Second: " + cal.get(Calendar.SECOND));
		System.out.println("Millisecond: " + cal.get(Calendar.MILLISECOND));

	}

	public static void parsingDates(){
		/*
		* SimpleDateFormat provides a method parse() for converting text into Date objects
		* Signature : 
		*	Date parse(String text, ParsePosition startPosition)
		* 1th argument is the text to parse
		* 2nd argumant is the starting position of the character in the text from where you want to extract the date
		*
		* Ex: 
		* Because the parser doesn't know from where to start parsing the date, you must provide it to access the second date
		* Parser cannot reads literal so you must skip literals by moving the ParsePosition after literals and just at the start 
		* You can tell it by using ParsePosition class which keep track of the parsing position.
		*
		* ParsePosition has only one constructor which an integer as argument for the starting position.
		* ParsePosition index is set to the index of the last character of the date text used plus one 
		*/
		// text to parse
		String text = "I'm born 01/01/1986. Moved to this city on 01/02/2001 and lived here since here 25/04/1991";

		// Create a pattern for the date
		String pattern = "dd/MM/yyyy";

		// Create a SimpleDateFormat object to represent this pattern
		SimpleDateFormat simpleFormatter = new SimpleDateFormat(pattern);

		// ParsePosition for 1th date (8)
		ParsePosition startPos = new ParsePosition(8);

		// Parse text
		Date parsedDate  = simpleFormatter.parse(text, startPos);
		System.out.println("Text: " + text);
		System.out.println("Parsed date : " + parsedDate);

		// Here the ParsePosition will be set to the last character parsed of a date plus one
		System.out.println("ParsePosition index: " + startPos.getIndex());

		int nextPosition = (startPos.getIndex() + 62);
		startPos.setIndex(nextPosition);

		parsedDate = simpleFormatter.parse(text, startPos);
		System.out.println("ParsePosition : " + nextPosition);
		System.out.println("Text start position : " + text.substring(nextPosition));
		System.out.println("Parsed date : " + parsedDate);
	}

	public static void parseComplexString(){
		String text = "XX01/01/1965XX30/12/2051XX";
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		
		System.out.println("\n******************* Parse Complex String **************************");
		System.out.println("Text : " + text);
		System.out.println("Pattern : " + pattern);

		ParsePosition startPos = new ParsePosition(2);
		Date parsedDate = formatter.parse(text, startPos);
		System.out.println("First date : " + parsedDate);

		startPos.setIndex((startPos.getIndex() + 2));
		parsedDate = formatter.parse(text, startPos);
		System.out.println("Second date : " + parsedDate);
	}
}