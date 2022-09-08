/*
* Instance of DateTimeFormatter class lets you format and parse a datetime object.
* Formatting means representing a datetime object in a user-defined textual form.
* Ex: LocalDate as May 24, 2012 or 05/24/2012
*
* Formatters lets you print a textual representation of a datetime object 
* to an Appendable object such as a StringBuilder.
* 
* Parsing is the reverse of formatting. 
* It lets you construct a datetime object from a string representation of a datetime.
* Ex: Creating a LocalDate from "05/12/2013"
*
* There are different ways of formatting and parsing.
*	- Using a pre-defined standard datetime formatters
*	- Using format() method of datetime classes
*	- Using user-defined patterns
*	- Using the DateTimeFormatterBuilder class
*
* IMPORTANT: Formatting and parsing are always made using an instance of DateTimeFormatter class.
* The difference lies in how you create object, DateTimeFormatter only provide factory methods. 
* For formatting a date, time or datetime. Java provides these methods on Date, Time, and DateTime class:
*	- String format(TemporalAccessor temporal)
* 	- void formatTo(TemporalAccessor temporal, Appendable appendable)
* format() method returns the textual representation
* formatTo() method lets you write the textual representation of the object to an Appendable object (Ex: file, StringBuilder, etc.)
*
* To format a datetime object, a formatter needs :
*	- a format patterns
*	- a locale
*/
package com.jdojo.datetime;





import static java.time.format.DateTimeFormatter.ISO_DATE;

public class FormatterDateAndTime{
	public static void main(String[] args) {
		preDefinedFormatters()
	}
}