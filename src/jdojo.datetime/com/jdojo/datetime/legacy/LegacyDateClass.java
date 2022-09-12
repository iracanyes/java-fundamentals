/*
* Legacy datetime classes refers to old datetime classes before Java 8 and the Date-Time API.
* Main legacy classes are Date, Calendar, GregorianCalendar.
* All legacy datetime classes are provided in package 'java.util'
* 
* An instance of Date class represents an instant in time.
* It stores the number of milliseconds elapsed since the epoch(1/01/1970 UTC)
*
* The default constructor is used to create an instance of Date class with the current system datetime. 
*/
package com.jdojo.datetime.legacy;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.sql.Time;



public class LegacyDateClass{
	public static void main(String[] args) {
		Date currentDate = new Date();
		System.out.println("Current date : " + currentDate);

		// Get the milliseconds value of the current date
		long millis = currentDate.getTime();
		System.out.println("Current time (ms) : " + millis);

		/*
		* Date class works with 1900-based year. 
		* To set 2014 as year, you will need to pass 114 (2014-1900 = 114)
		* To get the year
		*/
		int year = currentDate.getYear();
		System.out.println("Year of the current date as integer :  " + year);
		System.out.println("Year of the current date as year format :  " + (1900 + year));

		// Set year
		// DEPRECATED. 
		// currentDate.setYear(2022);
		// System.out.println("Year of the current date set 2022 :  " + currentDate);
	}
}