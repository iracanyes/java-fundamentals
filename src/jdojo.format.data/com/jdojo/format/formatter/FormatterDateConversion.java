/*
* The following conversion characters are used for formatting dates:
*	'B' 	Locale-specific full month name, e.g. "January", "February".
*	'b' 	Locale-specific abbreviated month name, e.g. "Jan", "Feb".
*	'h' 	Same as 'b'.
*	'A' 	Locale-specific full name of the day of the week, e.g. "Sunday", "Monday"
*	'a' 	Locale-specific short name of the day of the week, e.g. "Sun", "Mon"
*	'C' 	Four-digit year divided by 100, formatted as two digits with leading zero as necessary, i.e. 00 - 99
*	'Y' 	Year, formatted as at least four digits with leading zeros as necessary, e.g. 0092 equals 92 CE for the Gregorian calendar.
*	'y' 	Last two digits of the year, formatted with leading zeros as necessary, i.e. 00 - 99.
*	'j' 	Day of year, formatted as three digits with leading zeros as necessary, e.g. 001 - 366 for the Gregorian calendar.
*	'm' 	Month, formatted as two digits with leading zeros as necessary, i.e. 01 - 13.
*	'd' 	Day of month, formatted as two digits with leading zeros as necessary, i.e. 01 - 31
*	'e' 	Day of month, formatted as two digits, i.e. 1 - 31.
*
*/
package com.jdojo.format.formatter;

import java.util.Formatter;
import java.util.IllegalFormatConversionException;

public final class FormatterDateConversion{
	// Prevent extension of this class
	private FormatterDateConversion(){

	}

	public static FormatterDateConversion getInstance(){
		return new FormatterDateConversion();
	}

	public static void formatMonthFull(Formatter fm, Object  date){
		try{
			fm.format("Locale-specific full month name : %tB %n",  date);
		}catch(IllegalFormatConversionException e){
			fm.format("Locale-specific full month name :\n\t\t %%tB %n%s%n", e.getMessage());
		}
	}

	public static void formatMonthShort1(Formatter fm, Object  date){
		try{
			fm.format("Locale-specific abbreviated month name : %tb %n",  date);
		}catch(IllegalFormatConversionException e){
			fm.format("Locale-specific abbreviated month name :\n\t\t %%tb %n%s%n", e.getMessage());
		}
	}

	public static void formatMonthShort2(Formatter fm, Object  date){
		try{
			fm.format("Locale-specific abbreviated month name : %th %n",  date);
		}catch(IllegalFormatConversionException e){
			fm.format("Locale-specific abbreviated month name :\n\t\t %%th %n%s%n", e.getMessage());
		}
	}

	public static void formatDayNameFull(Formatter fm, Object  date){
		try{
			fm.format("Locale-specific full name of the day of the week : %tA %n",  date);
		}catch(IllegalFormatConversionException e){
			fm.format("Locale-specific full name of the day of the week :\n\t\t %%tA %n%s%n", e.getMessage());
		}
	}

	public static void formatDayNameShort(Formatter fm, Object  date){
		try{
			fm.format("Locale-specific short name of the day of the week  : %ta %n",  date);
		}catch(IllegalFormatConversionException e){
			fm.format("Locale-specific short name of the day of the week  :\n\t\t %%ta %n%s%n", e.getMessage());
		}
	}

	public static void formatYearInCentury(Formatter fm, Object  date){
		try{
			fm.format("Four-digit year divided by 100 : %tC %n",  date);
		}catch(IllegalFormatConversionException e){
			fm.format("Four-digit year divided by 100 :\n\t\t %tC %n%s%n", e.getMessage());
		}
	}

	public static void formatYear(Formatter fm, Object  date){
		try{
			fm.format("Year : %tY %n",  date);
		}catch(IllegalFormatConversionException e){
			fm.format("Year :\n\t\t %%tY %n%s%n", e.getMessage());
		}
	}

	public static void formatYearShort(Formatter fm, Object  date){
		try{
			fm.format("Last two digits of the year : %ty %n",  date);
		}catch(IllegalFormatConversionException e){
			fm.format("Last two digits of the year :\n\t\t %%ty %n%s%n", e.getMessage());
		}
	}

	public static void formatDayOfYear(Formatter fm, Object  date){
		try{
			fm.format("Day of year : %tj %n",  date);
		}catch(IllegalFormatConversionException e){
			fm.format("Day of year :\n\t\t %%tj %n%s%n", e.getMessage());
		}
	}

	public static void formatMonth(Formatter fm, Object  date){
		try{
			fm.format("Month : %tm %n",  date);
		}catch(IllegalFormatConversionException e){
			fm.format("Month :\n\t\t %%tm %n%s%n", e.getMessage());
		}
	}

	public static void formatDayOfMonthWith0(Formatter fm, Object  date){
		try{
			fm.format("Day of month with leading zeros as necessary : %td %n",  date);
		}catch(IllegalFormatConversionException e){
			fm.format("Day of month with leading zeros as necessary :\n\t\t %%td %n%s%n", e.getMessage());
		}
	}

	public static void formatDayOfMonth(Formatter fm, Object  date){
		try{
			fm.format("Day of month : %te %n",  date);
		}catch(IllegalFormatConversionException e){
			fm.format("Day of month :\n\t\t %%te %n%s%n", e.getMessage());
		}
	}

	
}						
