/*
* Legacy datetime classes refers to old datetime classes before Java 8 and the Date-Time API.
* Main legacy classes are Date, Calendar, GregorianCalendar.
* All legacy datetime classes are provided in package 'java.util'
* 
* Calendar is an abstract class.
* GregorianCalendar extends Calendar class.
* Calendar class declares some final static fields to represent date fields. Ex: JANUARY
* The GregorianCalendar has a default constructor, which creates an object to represent the current datetime.
* Anothers constructors allow to create an object to represent a specific  date or a date with a time zone.
*
* The default constructor is used to create an instance of Date class with the current system datetime. 
* Month part of a date ranges from 0 to 11. That is, January is 0, February is 1, and December is 11.
* It's easier to use constants provides by the Calendar class than the integer values.
*
* Date interpretation can be lenient or not lenient.
* By default, date interpretation is lenient which a date like March 35 2003 => April 05, 2003
* If lenient interpretation is disabled, the date above would cause an error. 
*

*/
package com.jdojo.datetime.legacy;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;


public class LegacyCalendarClass{
	public static void main(String[] args) {
		// Get the current date in the system default time zone
		GregorianCalendar currentDate = new GregorianCalendar();
		System.out.println("GregorianCalendar");
		System.out.println("Current datetime : " + currentDate);

		// Get GregorianCalendar object representing (April 1th, 2023, 15,30,45)
		GregorianCalendar aDate = new GregorianCalendar(2023, Calendar.APRIL, 1, 15, 30, 45);
	
		// Get Indian time zone, which is GMT+05:30
		TimeZone indianTZ = TimeZone.getTimeZone("GMT+05:30");
		TimeZone californiaTZ = TimeZone.getTimeZone("GMT+02:00");
		TimeZone moscowTZ = TimeZone.getTimeZone("GMT+03:30");


		// Get current date in India time zone
		GregorianCalendar indianDate = new GregorianCalendar(indianTZ);

		// Get current date in Europe/Paris time zone
		GregorianCalendar californiaDate = new GregorianCalendar(californiaTZ);

		// Get current date in Moscow time zone
		GregorianCalendar moscowDate = new GregorianCalendar(moscowTZ);

		System.out.println("Current date in India : " + indianDate);
		System.out.println("Current date in California : " + moscowTZ);
		System.out.println("Current date in Moscow : " + californiaTZ);


		gregorianCalendarComponent();
	}

	/*
	*
	*/
	public static void gregorianCalendarComponent(){
		// Create a GregorianCalendar object
		GregorianCalendar gc = new GregorianCalendar();

		// Get the year
		int year = gc.get(Calendar.YEAR);

		// Get the month
		int month = gc.get(Calendar.MONTH);

		// Get the day
		int day = gc.get(Calendar.DAY_OF_MONTH);

		// Get the hour
		int hour = gc.get(Calendar.HOUR);

		// Get the minutes
		int minute = gc.get(Calendar.MINUTE);

		// Get the second
		int second = gc.get(Calendar.SECOND);

		System.out.println("GregorianCalendar : " + gc);
		System.out.println("Year: " + year);
		System.out.println("Year: " + month);
		System.out.println("Year: " + day);
		System.out.println("Year: " + hour);
		System.out.println("Year: " + minute);
		System.out.println("Year: " + second);

		calendarAddMethod(gc, 6);

	}

	public static void calendarAddMethod(GregorianCalendar gc, int amount){
		/*
		* add() method allow to add an amount of time to a specific field in a date.
		* The amount of time can be positive/negative.
		* If after an addition of an amount of time, the resulting time doesn't fit 
		* in the calendar system. the date is automatically 
		*/
		gc.add(Calendar.YEAR, amount);
		System.out.println("Date after adjustment of 6 years : " + gc);

		gc.add(Calendar.MONTH, amount);
		System.out.println("Date after adjustment of 6 months : " + gc);

		gc.add(Calendar.DAY_OF_MONTH, amount);
		System.out.println("Date after adjustment of 6 days : " + gc);

		gc.add(Calendar.HOUR, amount);
		System.out.println("Date after adjustment of 6 hours : " + gc);

		gc.add(Calendar.MINUTE, amount);
		System.out.println("Date after adjustment of 6 minutes : " + gc);

		gc.add(Calendar.SECOND, amount);
		System.out.println("Date after adjustment of 6 seconds : " + gc);
	}

	public static void rollMethod(){
		/*
		* roll() method works as the add() method, except it does not change a larger field when the field being changed overflows.
		* It may adjust the smaller field to make a date a valid date.
		*	- void roll(int field, int amount)
		*	- void roll(int field, boolean up)
		*
		* The second method roll up/down the specified field by a single unit of time.
		* Whereas, roll(int, int) method roll up/down by the specified amount of time
		*  
		*
		*/
	}
}