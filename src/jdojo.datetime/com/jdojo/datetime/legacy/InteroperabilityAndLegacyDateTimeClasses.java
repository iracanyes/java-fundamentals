/*
* Date-Time API provides methods to convert legacy datetime objects to new datetime objects anv vice versa. 
* Legacy classes are:
*	- java.util.Date
*	- java.util.Calendar
*	- java.util.GregorianCalendar
*	- java.util.TimeZone
*	- java.sql.Date
*	- java.sql.Time
*	- java.sql.TimeStamp
*	- java.nio.file.attribute.FileTime
*
* Here are the list of legacy datetime classes and their Date-Time API counterparts.
* 
* All legacy classes provides 2-way conversion, except the Calendar class.
*
* 	Legacy class 			New Methods in Legacy class 		Equivalent in Date-Time API
*------------------------------------------------------------------------------------------
*	- java.util.Date 		from(), toInstant()					Instant
*	- Calendar 				toInstant()							None
* 	- GregorianCalendar		from(), toZonedDateTime() 			ZonedDateTime
*	- TimeZone 				getTimeZone(), toZoneId() 			ZoneId
*	- java.sql.Date 		valueOf(), toLocalDate() 			LocalDate
* 	- java.sql.Time 		valueOf(), toLocalTime() 			LocalTime
*	- TimeStamp 			from(), toInstant() 				Instant
*							valueOf(), toLocalDateTime() 		LocalDateTime
*	- FileTime 				from(), toInstant() 				Instant

* toXxx() methods are instance methods which returns an object of the datetime classes of Date-Time API
* The others methods are static, and they accept an object of the new datetime classses as arguments and returns an object of the legacy class.
*
* GregorianCalendar is used to store date, time, and datetime.
* You can convert it to ZonedDateTime which can be converted to any other Date-Time API datetime class.
*/
package com.jdojo.datetime.legacy;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.OffsetTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.Date;
import java.util.Calendar;

public class InteroperabilityAndLegacyDateTimeClasses{
	public static void main(String[] args) {
		convertDateToInstant();
		gregorianCalendarToDateTimeClass();
	}

	public static void convertDateToInstant(){
		// Get the current date
		Date dt = new Date();
		System.out.println("Date : " + dt);

		// Convert to instant
		Instant i1 = dt.toInstant();
		System.out.println("Instant 1 : " + i1);

		// Convert from Instant to Legacy date
		Date dt11 = Date.from(i1);
		System.out.println("Date 1: " + dt11 );


	}

	public static void gregorianCalendarToDateTimeClass(){
		// Convert Legacy Date to Instant, Instant to LocalDate
		Date date = new Date();
		LocalDate ldDate = date.toInstant()
								.atZone(ZoneId.systemDefault())
								.toLocalDate();

		LocalDate ldDate2 = LocalDate.ofInstant(date.toInstant(), ZoneId.systemDefault());

		// Create a Gregorian Calendar for the default time zone
		GregorianCalendar gc = new GregorianCalendar(2014, Calendar.JUNE, 12, 15, 58,56);
		System.out.println("Gregorian Calendar: " + gc);

		// Convert GC to LocalDate
		LocalDate ld1 = gc.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate ld2 = LocalDate.ofInstant(gc.toInstant(), ZoneId.systemDefault());
		System.out.println("gc.toLocalDate() : " + ld1);
		System.out.println("LocalDate.from(gc) : " + ld1);

		// Convert GC to LocalTime
		LocalTime lt1 = gc.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
		LocalTime lt2 = LocalTime.ofInstant(gc.toInstant(), ZoneId.systemDefault());
		System.out.println("gc.toLocalTime() : " + lt1);
		System.out.println("LocalTime.from(gc) : " + lt2);

		// Convert GC to LocalDateTime
		LocalDateTime ldt1 = gc.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		LocalDateTime ldt2 = LocalDateTime.ofInstant(gc.toInstant(), ZoneId.systemDefault());
		System.out.println("gc.toLocalDateTime() : " + ldt1);
		System.out.println("LocalDateTime.from(gc) : " + ldt2);

		// Convert GC to OffsetTime
		OffsetTime ot1 = gc.toZonedDateTime().toOffsetDateTime().toOffsetTime();
		OffsetTime ot2 = OffsetTime.ofInstant(gc.toInstant(), ZoneId.systemDefault());
		System.out.println("gc.toOffsetTime() : " + ot1);
		System.out.println("OffsetTime.from(gc) : " + ot2);

		// Convert GC to OffsetDateTime
		OffsetDateTime odt1 = gc.toZonedDateTime().toOffsetDateTime();
		OffsetDateTime odt2 = OffsetDateTime.ofInstant(gc.toInstant(), ZoneId.systemDefault());
		System.out.println("gc.toOffsetDateTime() : " + odt1);
		System.out.println("OffsetDateTime.from(gc) : " + odt2);

		// Convert GC to ZonedDateTime
		ZonedDateTime zdt1 = gc.toInstant().atZone(ZoneId.systemDefault());
		ZonedDateTime zdt2 = ZonedDateTime.from(gc.toInstant().atZone(ZoneId.systemDefault()));
		System.out.println("gc.toZonedDateTime() : " + zdt1);
		System.out.println("ZonedDateTime.from(gc) : " + zdt2);

		// Convert ZoneId to legacy TimeZone
		ZoneId zone = zdt1.getZone();
		TimeZone timeZone = TimeZone.getTimeZone(zone);
		System.out.println("Zone ID: " + zone);
		System.out.println("Legacy Time Zone ID : " + timeZone);

		// Converts ZonedDateTime to GC
		GregorianCalendar gc2 = GregorianCalendar.from(zdt1);


	}
}