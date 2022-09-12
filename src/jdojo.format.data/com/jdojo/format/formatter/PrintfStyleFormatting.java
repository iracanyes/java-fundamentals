/*
* This package presents how to format objects and values using System.out.printf style formatting.
* java.util.Formatter supports printf-style formatting, which is similar.
*
* System.out is an instance of java.io.PrintStream class, which provides println(), print().
* It provides 2 more methods for formatting output and writes them to standard output stream:
*	- format()
*	- printf()
*
* String class provides a sttic method format() which returns a formatted string.
* All 3 methods (PrintStream.format(), PrintStream.printf(), String.format())
*
* Formatter class does real works of formatting for thes methods.
* A Formatter class is used to format text and the formatted text can be written to the following destinations:
*	- An Appendable (StringBuilder, StringBuffer, Writer)
*	- A File
*	- An OutputStream
*	- A PrintStream 
*/
package com.jdojo.format.printf;

import java.util.Date;
import java.util.Locale;
import java.time.LocalDate;

public class PrintfStyleFormatting{
	public static void main(String[] args) {
		formatStrings();
		formatNumbers();
		formatDates();
	}

	public static void formatStrings(){
		/*
		* Formatting strings
		*/
		System.out.printf("%1$s, %2$s, %3$s, %4$s,%5$s", "first", "second", "third", "forth", "fifth");
		System.out.printf("%5$s, %4$s, %3$s, %2$s,%1$s", "first", "second", "third", "forth", "fifth");
		
	}

	public static void formatNumbers(){
		/*
		* Format Numbers
		*/
		System.out.printf("%1$4d, %2$4d, %3$4d %n", 1, 10, 100);
		System.out.printf("%1$4d, %2$4d, %3$4d %n", 10, 100, 1000);
		System.out.printf("%1$-4d, %2$-4d, %3$-4d %n", 1, 10, 100);
		System.out.printf("%1$-4d, %2$-4d, %3$-4d %n", 10, 100, 1000);

	}

	public static void formatDates(){
		/*
		* Format Dates
		*/
		Date dt = new Date();
		LocalDate ld = LocalDate.now();

		System.out.printf("Today is %D. %n", dt);
		System.out.printf("Today is %tf. %n", dt);
		System.out.printf("Today is %tc. %n", dt);

		System.out.printf(Locale.US, "LocalDate: Today is %D. %n", ld);
		System.out.printf(Locale.FRENCH, "LocalDate: Today is %tf. %n", ld);
		System.out.printf(Locale.CHINA, "LocalDate: Today is %tc. %n", ld);

		System.out.printf(Locale.US, "LocalDate: Today is %D. %n", ld);
		System.out.printf(Locale.FRENCH,"LocalDate: Today is %tf. %n", ld);
		System.out.printf(Locale.CHINA, "LocalDate: Today is %tc. %n", ld);

	}
}