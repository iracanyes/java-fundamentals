/*
* DateTimeFormatter class has methods that returns a DateTimeFormatter 
* with a predefined human-readable formatting pattern.
* Use them to get the reference to those formatters.
*	- DateTimeFormatter ofLocalizedDate(FormatStyle dateStyle)
*	- DateTimeFormatter ofLocalizedTime(FormatStyle timeStyle)
*	- DateTimeFormatter ofLocalizedDateTime(FormatStyle dateTimeStyle)
*	- DateTimeFormatter ofLocalizedDateTime(FormatStyle dateStyle, FormatStyle timeStyle)
*
* FormStyle enum has 4 constants : SHORT, MEDIUM, LONG and FULL.
* These constants are used to output formatted date and time with different level of information.
* These methods uses the system default locale.
* withLocale() method allow to change the locale used by these methods
*/
package com.jdojo.datetime.formatter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.Month;
import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;
import static java.time.format.FormatStyle.FULL;
import static java.time.format.FormatStyle.LONG;
import static java.time.format.FormatStyle.MEDIUM;
import static java.time.format.FormatStyle.SHORT;
import java.util.Locale;

public class LocaleFormatters{
	
	public static void main(String[] args) {
		LocalDate ld = LocalDate.of(2021, Month.JUNE, 25);
		LocalTime lt = LocalTime.of(15,23,30);
		LocalDateTime ldt = LocalDateTime.of(ld, lt);
		OffsetDateTime odt = OffsetDateTime.now();
		ZonedDateTime zdt = ZonedDateTime.now();

		
		ofLocalizedLocalDate(ld);
		ofLocalizedLocalTime(lt);
		ofLocalizedLocalDateTime(ldt);
		ofLocalizedOffsetDateTime(odt);
		ofLocalizedZonedDateTime(zdt);

	}

	public static void ofLocalizedLocalDate(LocalDate ld){
		DateTimeFormatter dtf1 = DateTimeFormatter.ofLocalizedDate(SHORT);
		DateTimeFormatter dtf2 = DateTimeFormatter.ofLocalizedDate(MEDIUM);
		DateTimeFormatter dtf3 = DateTimeFormatter.ofLocalizedDate(LONG);
		DateTimeFormatter dtf4 = DateTimeFormatter.ofLocalizedDate(FULL);

		System.out.println("Formatter Default locale : " + dtf1.getLocale());
		// LocalDate
		System.out.println("\nld : " + ld);
		System.out.println("Short date : " + dtf1.format(ld));
		System.out.println("Medium date : " + dtf2.format(ld));
		System.out.println("Long date : " + dtf3.format(ld));
		System.out.println("FULL date : " + dtf4.format(ld));
	}

	public static void ofLocalizedLocalTime(LocalTime lt){
		DateTimeFormatter dtf1 = DateTimeFormatter.ofLocalizedTime(SHORT);
		DateTimeFormatter dtf2 = DateTimeFormatter.ofLocalizedTime(MEDIUM);
		DateTimeFormatter dtf3 = DateTimeFormatter.ofLocalizedTime(LONG);
		DateTimeFormatter dtf4 = DateTimeFormatter.ofLocalizedTime(FULL);

		// LocalTime
		System.out.println("\nlt : " + lt);
		System.out.println("Short time : " + dtf1.format(lt));
		System.out.println("Medium time : " + dtf2.format(lt));

		try{
			System.out.println("Long time : " + dtf3.format(lt));
		}catch(DateTimeException e){
			System.out.println("Long time : " + e.getMessage());
		}

		try{
			System.out.println("FULL time : " + dtf4.format(lt));
		}catch(DateTimeException e){
			System.out.println("FULL time : " + e.getMessage());
		}
		
		
	}

	public static void ofLocalizedLocalDateTime(LocalDateTime ldt){
		DateTimeFormatter dtf1 = DateTimeFormatter.ofLocalizedDateTime(SHORT);
		DateTimeFormatter dtf2 = DateTimeFormatter.ofLocalizedDateTime(MEDIUM);
		DateTimeFormatter dtf3 = DateTimeFormatter.ofLocalizedDateTime(LONG);
		DateTimeFormatter dtf4 = DateTimeFormatter.ofLocalizedDateTime(FULL);

		// LocalDateTime
		System.out.println("\nldt: " + ldt);
		System.out.println("Short datetime : " + dtf1.format(ldt));
		System.out.println("Medium datetime : " + dtf2.format(ldt));
		try{
			System.out.println("Long datetime : " + dtf3.format(ldt));
		}catch(DateTimeException e){
			System.out.println("Long datetime : " + e.getMessage());
		}
		
		try{
			System.out.println("FULL datetime : " + dtf4.format(ldt));
		}catch(DateTimeException e){
			System.out.println("FULL datetime : " + e.getMessage());
		}
		
	}

	public static void ofLocalizedOffsetDateTime(OffsetDateTime odt){
		DateTimeFormatter dtf1 = DateTimeFormatter.ofLocalizedDateTime(SHORT, LONG).withLocale(new Locale("en", "UK"));
		DateTimeFormatter dtf2 = DateTimeFormatter.ofLocalizedDateTime(MEDIUM, MEDIUM).withLocale(new Locale("en", "IN"));
		DateTimeFormatter dtf3 = DateTimeFormatter.ofLocalizedDateTime(LONG, SHORT).withLocale(new Locale("en", "US"));
		DateTimeFormatter dtf4 = DateTimeFormatter.ofLocalizedDateTime(FULL, MEDIUM).withLocale(Locale.GERMAN);
		// OffsetDateTime
		System.out.println("\nodt: " + odt);

		try{
			System.out.println("Offset datetime (Short Date & Long Time) : " + dtf1.format(odt));
		}catch(DateTimeException e){
			System.out.println("Offset datetime (Short Date & Long Time) : " + e.getMessage());
		}

		try{
			System.out.println("Offset datetime (Medium Date & Medium Time) : " + dtf2.format(odt));
		}catch(DateTimeException e){
			System.out.println("Offset datetime (Medium Date & Medium Time) : " + e.getMessage());
		}
		
		System.out.println("Offset datetime (Medium Date & Medium Time) : " + dtf2.format(odt));
		
		

		try{
			System.out.println("Offset datetime (Long Date & Short Time) : " + dtf3.format(odt));
		}catch(DateTimeException e){
			System.out.println("Offset datetime (Long Date & Short Time) : " + e.getMessage());
		}
		
		try{
			System.out.println("Offset datetime (Full Date & Short Time) : " + dtf4.format(odt));
		}catch(DateTimeException e){
			System.out.println("Offset datetime (Full Date & Medium Time) : " + e.getMessage());
		}
	}

	public static void ofLocalizedZonedDateTime(ZonedDateTime zdt){
		DateTimeFormatter dtf1 = DateTimeFormatter.ofLocalizedDateTime(SHORT, SHORT)
													.withLocale(Locale.GERMAN);
		DateTimeFormatter dtf2 = DateTimeFormatter.ofLocalizedDateTime(MEDIUM, MEDIUM)
													.withLocale(Locale.JAPANESE);
		DateTimeFormatter dtf3 = DateTimeFormatter.ofLocalizedDateTime(LONG, MEDIUM)
													.withLocale(Locale.ITALIAN);
		DateTimeFormatter dtf4 = DateTimeFormatter.ofLocalizedDateTime(FULL, SHORT)
													.withLocale(Locale.GERMAN);
		// ZonedDateTime
		System.out.println("\nzdt : " + zdt);
		System.out.println("Short zoned datetime : " + dtf1.format(zdt));
		System.out.println("Medium zoned datetime : " + dtf2.format(zdt));
		System.out.println("Long zoned datetime : " + dtf3.format(zdt));
		System.out.println("FULL zoned datetime : " + dtf4.format(zdt));
	}
}