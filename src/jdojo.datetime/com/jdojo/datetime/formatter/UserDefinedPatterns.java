/*
* User defined patterns
* DateTimeFormatter class provides method ofPattern() which
* allow users to defined they own patterns for formatting the datetime object
* Letters A-Z a-z are reserved characters for the pattern
* Ex: "dd MM yyyy", 
* Ex: Not allowed : "Le dd  MM de l'an yyyy"
* Here is the Formatting symbols
*	Symbol 		Description 				Pattern 	Output	
*	- G 		Era 						G 			AD
*											GGGG		Anno Domini
*	- u 		Year 						uuuu 		2012
* 				positie or negative			uu 			12
*	- y 		Year						yyyy 		2015
*				positive only 				yy 			15
*	- D 		Day of year(1 - 366)		D 			235
*	- M/L 		Month of Year(1-120)		M, MM, MMM 	6, 06, Jun
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
*/
package com.jdojo.datetime.formatter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.time.temporal.Temporal;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.time.format.DateTimeFormatter;

public class UserDefinedPatterns {
	public static void main(String[] args) {
		LocalDate ld = LocalDate.now();
		LocalTime lt = LocalTime.now();
		LocalDateTime ldt = LocalDateTime.now();
		OffsetDateTime odt = OffsetDateTime.now();
		ZonedDateTime zdt = ZonedDateTime.now();

		String pattern1 = "dd/MM/yyyy['at' HH:mm:ss]";
		String pattern2 = "'Le' EEEE dd MMMM 'de l''an' yyyy à HH:mm:ss.SSSSSSSS ";

		DateTimeFormatter dtfDefault = DateTimeFormatter.ofPattern(pattern2);
		// withLocale(Locale) 
		// Allow to change the locale of the datetime formatter
		DateTimeFormatter dtfFr = dtfDefault.withLocale(Locale.FRENCH);

		

		// Get the Locale used by DateTimeFormatter instance
		Locale defaultLocale = dtfDefault.getLocale();

		System.out.println("ld : " + ld);		
		formatUS(ld, "M/d/yyyy");
		formatUS(ld, "MM/dd/yyyy");
		formatUS(ld, "EEEE, MMMM dd, yyyy");
		formatUS(ld, "'Month' q 'in' QQQQ");
		formatUS(ld, "[dd-MM-yyyy][' at' HH:mm:ss]");
		formatUS(ld, "'Le' EEEE dd MMMM 'de l''an' yyyy à HH:mm:ss.SSSSSSSS ");	

		System.out.println("lt : " + lt);
		formatUS(lt, "M/d/yyyy");
		formatUS(lt, "MM/dd/yyyy");
		formatUS(lt, "EEEE, MMMM dd, yyyy");
		formatUS(lt, "'Month' q 'in' QQQQ");
		formatUS(lt, "[dd-MM-yyyy][' at' HH:mm:ss]");
		formatUS(lt, "'Le' EEEE dd MMMM 'de l''an' yyyy à HH:mm:ss.SSSSSSSS ");

		System.out.println("ldt : " + ldt);		
		formatDU(ldt, "M/d/yyyy");
		formatDU(ldt, "MM/dd/yyyy");
		formatDU(ldt, "EEEE, MMMM dd, yyyy");
		formatDU(ldt, "'Month' q 'in' QQQQ");
		formatDU(ldt, "[dd-MM-yyyy][' at' HH:mm:ss]");
		formatDU(ldt, "'Le' EEEE dd MMMM 'de l''an' yyyy à HH:mm:ss.SSSSSSSS ");


		System.out.println("odt : " + odt);		
		formatFR(odt, "M/d/yyyy");
		formatFR(odt, "MM/dd/yyyy");
		formatFR(odt, "EEEE, MMMM dd, yyyy");
		formatFR(odt, "'Month' q 'in' QQQQ");
		formatFR(odt, "[dd-MM-yyyy][' at' HH:mm:ss]");
		formatFR(odt, "'Le' EEEE dd MMMM 'de l''an' yyyy à HH:mm:ss.SSSSSSSS ");

		System.out.println("zdt : " + zdt);	
		formatFR(zdt, "M/d/yyyy");
		formatFR(zdt, "MM/dd/yyyy");
		formatFR(zdt, "EEEE, MMMM dd, yyyy");
		formatFR(zdt, "'Month' q 'in' QQQQ");
		formatFR(zdt, "[dd-MM-yyyy][' at' HH:mm:ss]");
		formatFR(zdt, "'Le' EEEE dd MMMM 'de l''an' yyyy à HH:mm:ss.SSSSSSSS ");
		


	}

	public static void formatUS(Temporal tempComponent, String pattern){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.US);
		try{
			String str = formatter.format(tempComponent);
			System.out.println("" + pattern + " : " + str);
		}catch(UnsupportedTemporalTypeException e){
			System.out.println("temporal not supported : " + tempComponent);
		}
	}

	public static void formatFR(Temporal tempComponent, String pattern){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.FRENCH);
		try{
			String str = formatter.format(tempComponent);
			System.out.println(pattern + " : " + str);
		}catch(UnsupportedTemporalTypeException e){
			System.out.println("temporal not supported : " + tempComponent);
		}
	}

	public static void formatDU(Temporal tempComponent, String pattern){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.GERMAN);
		try{
			String str = formatter.format(tempComponent);
			System.out.println(pattern + " : " + str);
		}catch(UnsupportedTemporalTypeException e){
			System.out.println("temporal not supported : " + tempComponent);
		}
	}
}