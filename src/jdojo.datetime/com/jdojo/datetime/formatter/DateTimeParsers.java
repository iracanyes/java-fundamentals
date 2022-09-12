/*
* Parsing is the process of creating date, time, and datetime object
* from a string.
* DateTimeFormatter provides methods for parsing strings.
* The same symbols used for formatting are used for parsing symbols.
* * Here is the Formatting symbols
*	Symbol 		Description 				Pattern 	Output	
*	- G 		Era 						G 			AD
*											GGGG		Anno Domini
*	- u 		Year 						uuuu 		2012
* 				positie or negative			uu 			12
*	- y 		Year						yyyy 		2015
*				positive only 				yy 			15
*	- D 		Day of year(1 - 366)		D 			235
*	- M/L 		Month of Year(1-12)			M, MM, MMM 	6, 06, Jun
*											MMMM 		June 			
* 	- d 		Day of Month 				d, dd 		5, 29
*	- g 		Modified Julian day 		g, gggg		57689, 57689 
* 	- Q/q 		Quarter of year 			Q, QQ, QQQ 	3, 03, Q3
* 	- Y 		Week-based year 			Y, YY, YYYY 2012, 12, 2012
*	- w 		Week of week-based year 	w 			51
*	- W 		Week of month				W 			4
*	- E 		Day of week 				E, EE, EEE  7, 07, Sun,
*											EEEE 		Sunday 	
*	- F 		Day of week in month 		F 			1
* 	- a 		AM/PM of day 				a 			AM, PM
*	- h 		Clock hour AM/PM (1-12) 	h 			7
*	- K 		Hour AM/PM (0-11)			K 			8
*	- k 		Clock hour (1-24)			k 			23
*   - H 		Hour of day (0-23) 			H, HH		7, 07
*	- m 		Minute of hour 				mm 			01
*	- s 		Second of minute 			ss 			08
*	- S 		Fraction of second 			SSSSSSSSS 	000000078
* 	- A 		Millisecond of day 			A 			270456351
*	- n 		Nanosecond of second 		n 			756
*   - N 		Nanosecond of day 			N 			132456789654231
*	- V 		Time zone ID 				VV 			Europe/Paris
*	- v 		Generic non-location zone 	v, vvvv		CT, Central Time
* 	- z 		Time zone name 				z			CDT
* 	- Z 		Zone offset 				Z, ZZ, ZZZ	-0500, -0500, -05:00
*											ZZZZ 		GMT-05:00
* 	- O 		Localized zone offset 		O 			GMT-5
*	- X 		Zone offset 				X, XX, XXX 	+0530, +0530, +05:30
*											XXXX, XXXXX +05:30, +05:30:45, Z
* 	- x 		Zone offset 				xx, xxxx 	-1200, -12:00, +00 		
* 	- P 		Pad next (space)			pppmm 		'   30'
*	- '			Escape for text 			'Hello'		Hello
* 	- '' 		A single quote 				'' 			'
* 	- [] 		An optional section
* 	- #, {, }	These are reserved character
*
*
* There is 2 ways to parse strings:
*	- Using parse() method of the datetime classes
*	- Using parse() method of DateTimeFormatter class
*
* A DateTimeParseException is thrown if the text cannot be parsed.
* 	- getErrorIndex() returns the index in the text where the error occured
*	- getParsedString() returns the text being parsed.
*
* Each datetime class has 2 overloaded methods parse()
* Ex: LocalDate
*	- static LocalDate parse(CharSequence text)
*		Takes only string in ISO format
*	- static LocalDate parse(CharSequence text, DateTimeFormatter formatter)
*/
package com.jdojo.datetime.formatter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAccessor;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;

public class DateTimeParsers{
	public static void main(String[] args) {
		parseLocalDate();


		/*
		* parseBest
		*/
		System.out.println("\n*************** ParseBest *****************\n");
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd['T'HH:mm:ss[Z]]");
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd['T'HH:mm:ss[ZZ]]");
		DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("yyyy-MM-dd['T'HH:mm:ss[ZZZ]]");
		DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("yyyy-MM-dd['T'HH:mm:ss[ZZZ]]");
		
		parseBest(dtf1, "2021-12-31");
		parseBest(dtf1, "1921-02-01T16:32:58");
		parseBest(dtf1, "2000-05-31T23:52:08-0500");
		parseBest(dtf1, "2000-05-31T23:52:08+0200");


		/* ISO standard datetime format: yyyy-MM-ddTHH:mm:ss.SSSZZZZ
		* Non ISO standard string format are not treated will cause an DateTimeParseException
		* The datetime string format below doesn't respect the format for zone offset.
		*/

		parseBest(dtf1, "2000-05-31T23:52:08-05:00");
		parseBest(dtf1, "2005-01-31T07:32:28UTC-06:30");
		parseBest(dtf1, "2050-12-31T16:02:58GMT+02:00");
		System.out.println(ZonedDateTime.now());

	}

	public static void parseLocalDate(){
		
		/* LocalDate.parse(CharSequence text)
		* Parse a string in ISO format to a LocalDate 
		*/
		LocalDate ld1 = LocalDate.parse("2014-01-10");
		System.out.println("ld1 : " + ld1);


		/* LocalDate.parse(CharSequence, DateTimeFormatter)
		* 
		*/
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("dd/MM/yyyy : " + ld1.parse("15/06/2015", dtf));

		/* DateTimeFormatter.parse(CharSequence text)
		* Parse a string in ISO format to a LocalDate 
		*/
		dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		System.out.println("dd-MM-yyyy : " + dtf.parse("15-06-2015"));

		/* DateTimeFormatter.parse(CharSequence text, TemporalQuery)
		* Parse a LocalDate in "En date de l'an yyyy, le dd MMMM"
		*/
		try{
			dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
			System.out.println("dd MM yyyy : " + dtf.parse("15 06 2015", LocalDate::from));
		}catch(DateTimeParseException e){
			System.out.println("dd MM yyyy error : (" + e.getErrorIndex() + ") " + e.getParsedString().substring(e.getErrorIndex()));
		}

		/* parse(CharSequence text)
		* Parse a LocalDate in "En date de l'an yyyy, le dd MMMM"
		*/
		try{
			dtf = DateTimeFormatter.ofPattern("ddpMMpyyyy");
			/*
			* The DateTimeFormatter doesn't know the type of datetime object that can be formed 
			* from strings. Therefore, most of them return a TemporalAccessor object that can query
			* to get the datetime component.
			*/
			TemporalAccessor ta = dtf.parse("15 06 2015");
			ld1 = LocalDate.from(ta);
			System.out.println("ddpMMpyyyy : " + ld1);
		}catch(DateTimeParseException e){
			System.out.println("ddpMMpyyyy error : (" + e.getErrorIndex() + ") " + e.getParsedString().substring(e.getErrorIndex()));
		}
		

		/*
		* Here, parse(CharSequence, TemporalQuery) method takes a TemporalQuery that can be used to parse the string directly
		* into a specific datetime object
		*/
		try{
			// Parse a LocalDate in "En date de l'an yyyy, le dd MMMM"
			dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			TemporalAccessor ta = LocalDate.parse("15/12/1926", dtf);
			System.out.println("ld2 : " + LocalDate.from(ta));
		}catch(DateTimeParseException e){
			System.out.println("Error parsing at index " + e.getErrorIndex() + " : " + e.getParsedString().substring(e.getErrorIndex()));
		}

		

		try{
			dtf = DateTimeFormatter.ofPattern("MM.dd.yyyy");
			LocalDate ld3 = LocalDate.parse("10.15.1926", dtf);
			System.out.println("ld3 : " + ld3);
		}catch(DateTimeParseException e){
			System.out.println("MMMMpdd','pyyyy error (" + e.getErrorIndex() + ") : " + e.getParsedString().substring(e.getErrorIndex()));
		}		
		
	}

	public static void parseBest(DateTimeFormatter dtf, String text){
		System.out.println("\nString to parse : " + text);
		/*
		* DateTimeFormatter class provides a method parseBest().
		* Parse the best he can all informations supplied,
		* and try to return an object which corresponds to ChronoField given in argument
		* Ex: yyyy-MM-dd['T'HH:mm:ss[Z]]
		* The pattern above has 2 optional section.  
		*/
		try{
			TemporalAccessor ta = dtf.parseBest(
				text,
				ZonedDateTime::from,
				OffsetDateTime::from,
				LocalDateTime::from, 
				LocalDate::from, 
				LocalTime::from 
			);
			
			if(ta instanceof ZonedDateTime){
				ZonedDateTime zdt = ZonedDateTime.from(ta);
				System.out.println("ZonedDateTime: " + zdt);
			} else if(ta instanceof OffsetDateTime){
				OffsetDateTime odt = OffsetDateTime.from(ta);
				System.out.println("OffsetDateTime: " + odt);
			} else if(ta instanceof LocalDateTime){
				LocalDateTime ldt = LocalDateTime.from(ta);
				System.out.println("LocalDateTime: " + ldt);
			} else if(ta instanceof LocalDate){
				LocalDate ld = LocalDate.from(ta);
				System.out.println("LocalDate: " + ld);
			} else if(ta instanceof LocalTime){
				LocalTime lt = LocalTime.from(ta); 
				System.out.println("LocalTime: " + lt);
			} else{
				System.out.println("Parsing returned : " + ta);
			}

		}catch(DateTimeParseException e){
			System.out.println(
				"Error index : " + e.getErrorIndex() 
				+ "\nParsed text : " + e.getParsedString().substring(e.getErrorIndex()) 
				+ "\nError message  : " + e.getMessage()
			);
		}
			
	}
}