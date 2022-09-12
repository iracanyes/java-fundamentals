/*
* Date Formatter for Legacy DateTime classes
* DateFormat class allow to format dates using a predefined format.
* It's an abstract class, You can only call a factory method  getXxxInstance() to create instance of the class.
* Where Xxx can be replaced by Date, Time, DateTime, to get the formatter object.
* The formatted text depends on 2 factors : style and locale.
*
* Use format() method to format a date and time.
* The style of formatting define how much information about date and time you will get.
* Default style is the same as MEDIUM style.
*
*	- DateFormat.DEFAULT	Mar 27, 2012
*	- DateFormat.SHORT		3/27/12
*	- DateFormat.MEDIUM		Mar 27, 2012
*	- DateFormat.LONG 		March 27, 2012
*	- DateFormat.FULL		Tuesday, March 27, 2012
* 
*
*/
package com.jdojo.format.data;

import java.util.Locale;
import java.util.Date;
import java.text.DateFormat;

public class PreDefinedLegacyDateFormatter{
	public static void main(String[] args) {
		 preDefinedDateFormats();

	}

	public static void preDefinedDateFormats(){
		/*
		* Locale class from package 'java.util' contains some common locales.
		* 	- 1th argument in lowercase letter is language code
		*	- 2nd argument in uppercase letter is country code
		*/
		Locale itLocale = new Locale("it", "IT");
		printLocaleDetails(itLocale);
		printDate(itLocale, new Date());

		Locale nlBELocale = new Locale("nl", "BE");
		printLocaleDetails(nlBELocale);
		printDate(nlBELocale, new Date());

		Locale hiINLocale = new Locale("hi", "IN");
		printLocaleDetails(hiINLocale);
		printDate(hiINLocale, new Date());
		
		Locale esSPLocale = new Locale("es", "SP");
		printLocaleDetails(esSPLocale);
		printDate(esSPLocale, new Date());

		// Default locale
		Locale defaultLocale = Locale.getDefault();
		printLocaleDetails(defaultLocale);
		printDate(defaultLocale, new Date());

		
		

		Date today = new Date();
		DateFormat formatter = DateFormat.getDateInstance(DateFormat.FULL, Locale.US);
		String formattedDate = formatter.format(today);
		System.out.println("Today : " + today);
		System.out.println("Formatted date today : " + formattedDate);
	}

	public static void printLocaleDetails(Locale locale){
		String languageCode = locale.getLanguage();
		String languageName = locale.getDisplayLanguage();
		String countryCode = locale.getCountry();
		String countryName = locale.getDisplayCountry();

		System.out.println("Language: " + languageName + "("+ languageCode + ") " + countryName + "(" + countryCode + ")");


	}

	public static void printDate(Locale locale, Date dt){
		// Format and print
		DateFormat formatter = DateFormat.getDateInstance(DateFormat.SHORT, locale);
		String formattedDate = formatter.format(dt);
		System.out.println("Formatted date (SHORT) : " + formattedDate);

		// Format and print
		formatter = DateFormat.getDateInstance(DateFormat.LONG, locale);
		formattedDate = formatter.format(dt);
		System.out.println("Formatted date (LONG) : " + formattedDate);

		System.out.println("\n");
	}
}