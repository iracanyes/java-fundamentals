/*
* Classes of Date-Time API do not provide public constructors.
* They provide static factory methods of(), ofXXX(), and from() methods to create their objects.
* Date-Time API has 80 classes and about 1000 methods.
* Classes from Date-Time API use naming convention for methods.
* They use the simplified UTC where leap seconds are ignored, 
* making all days have the same number of 86400 seconds.
*
* Daylight Savings Time is used to make better use of the daylight in evening by moving the clocks
* forward (usually by one hour) in spring.
* Clocks are set back of one hour in fall. 
*
* Date-Time API have extensive support for the ISO-8601 standards. 
* It provides classes whose objects directly represent most of the concepts of ISO-8601:
* date, time, datetime, instant, duration, time interval, period, etc.
* The string representation of datetime consists of three components : date, time, zone offset
* The time is represented as follow:
*	[date]T[time][zone_offset] 
*
* A date component is represented textually as follow:
*	year-month-day
* ISO-8601 allow ommitting parts in date only from the right end.
* Ex: day, or month and day.
*
* A time component is textually represented as follow:
* 	hour:minute:second
* ISO-8601 allow ommitting parts in date only from the right end.
* Ex: second or second and minute
*
* Zone offset represents a fixed difference between a local time and UTC.
* When zone offset is ommitted, it's considered a local (date, time, datetime, etc).
* It starts with a plus or minus (+/-) followed by hour and minute elements separated by a colon.
* Ex: +05:30, -06:00, +10:00, Z( represent UTC time)
*
* Here is an example of a full datetime representation:
* T is the time designator
*	2012-05-01T06:30:00-06:00, 2012-05-01T06:30:00Z
*
* Duration are represented using P which is a duration designator followed by the duration.
* T is the time designator 
* Ex:	P12Y2MT30M: A duration of 12 years, 2 months and 30 minutes
*		PT15h30S	: A duration of 15 hours and 30 seconds.
*
* Date-Time API provides multiple packages:
* 	-  java.time : 
*		contains frequently used classes. 
* 		Ex: LocalDate, LocalTime, LocalDateTime, ZonedDateTime, Period, Duration, Instant
*	- java.time.chrono: 
*		classes supporting non-ISO calendar systems
*		Ex: Hijrah calendar, Thai Buddhist calendar, etc.
*	- java.time.format: 
*		Classes for formatting and parsing dates and times
*	- java.time.temporal:
*		Classes for accessing components of dates and times, classes that acts like datetime adjusters
*	- java.time.zone:
*		Classes supporting time zones and zone rules
*
*
*
*/
package com.jdojo.datetime;

import java.time.Year;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.Duration;

public class DateTimeTest{
	public static void main(String[] args) {
		createDateTime();
		ofXxxMethods();
		from();
		withXXXMethods();
		getXxxMethods();
		toXxxMethods();
		atXxxMethods();
		plusXxxMethods();
		multipliedBy();
		dividedBy();
		negated();
	}

	public static void createDateTime(){
		/*
		* LocalDate and LocalTime are also called partials, as they do not represent an instant on the timeline.
		* they are not aware of Daylight Savings Time.
		* Ex: Adding 1 day to a LocalDate object will give you
		* a LocalDate object irrespective of time and location.  
		*/
		// LocalDate represents a local date without a time.
		LocalDate dateOnly = LocalDate.now();
		System.out.println("Current Date only : " + dateOnly);

		LocalDate dateOnly2 = LocalDate.of(1956, Month.DECEMBER, 12);
		System.out.println("Date only : " + dateOnly2);

		// LocalTime represents a local time without a date
		LocalTime timeOnly = LocalTime.now();
		System.out.println("Current Time only : " + timeOnly);


		// LocalDateTime represents a local date and time
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println("Current Date and time : " + dateTime);

		/*
		* ZonedDateTime represents an point in time with a given zone,
		* that can be converted to an instant on the timeline, because
		* it is aware of Daylight Savings Time.
		* Ex: Add 5 hours to a ZonedDateTime object representing 1 AM, Dec 25,1925
		* in Greenwich/London time zone, will returns an object representing
		* 6 AM, Dec 25, 1925
		*/
		// ZonedDateTime represents a date and time with time zone.
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		System.out.println("Current Zoned Date and time : " + zonedDateTime);

	}

	/*
	* Next methods explain the method naming convention in Date-Time API.
	* The methods exists most of the classes, 
	*
	*/
	public static void ofXxxMethods(){
		/*
		* Date-Time API doesn't provide public constructors for their classes, 
		* it provide static factory methods to create objects
		*/
		LocalDate aDate = LocalDate.of(1982,Month.DECEMBER,31);		
		LocalDate aDate2 = LocalDate.of(2012,05,04);
		// Local date from epoch day (January 1, 1970 UTC 00:00:00 )
		// The epoch days is the number of days from 1970-01-01
		// A date before 1970-01-01 returns a negative number		
		LocalDate aDate3 = LocalDate.ofEpochDay(20012);
		// Local date from a year and day
		LocalDate aDate4 = LocalDate.ofYearDay(2012, 40);


		System.out.println("LocalDate.of(1982,MONTH.DECEMBER,31) : " + aDate);
		System.out.println("LocalDate.of(2012,05,04) : " + aDate2);
		System.out.println("LocalDate.ofEpochDay(20012) : " + aDate3);
		System.out.println("LocalDate.ofYearDay(2012, 40) : " + aDate4);


		LocalTime aTime = LocalTime.of(23,00,31);		
		LocalTime aTime2 = LocalTime.of(12,05,04);
		LocalTime lt3 = LocalTime.of(1908,32,24,6589);

		System.out.println("LocalTime.of(23,00,31) : " + aTime);
		System.out.println("LocalTime.of(12,05,04) : " + aTime2);
		System.out.println("LocalTime.of(08,32,24,6589) : " + lt3);

		/*
		* 
		*
		*
		*
		* See doc:
		*	- https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/time/LocalDateTime.html
		* 	- https://docs.oracle.com/javase/8/docs/api/java/time/LocalDateTime.html
		*/
		LocalDateTime aDateTime = LocalDateTime.of(1982,Month.DECEMBER,31,23,51);		
		LocalDateTime aDateTime2 = LocalDateTime.of(2012,05,04,12,45);
		// Get a Local DateTime from epoch day (January 1, 1970 UTC 00:00:00 )
		LocalDateTime aDateTime3 = LocalDateTime.ofEpochSecond(2000012l, 1000, ZoneOffset.of("GMT+2"));

		System.out.println("LocalDateTime.of(1982,Month.DECEMBER,31,23,51) : " + aDateTime);
		System.out.println("LocalDateTime.of(2012,05,04,12,45) : " + aDateTime2);
		System.out.println("LocalDateTime.ofEpochDay(2000012) : " + aDateTime3);

		/*
		* ZonedDateTime uses zone ids to identify a specific time-zone.
		* There are 2 types of ID:
		*	- Fixed offsets: fully resolved offset from UTC/Greenwich that uses the same offset for all local date-times
		*		represented by ZoneOffset class Ex: Z, +01:00 
		*	- Geographical regions
		*
		*  This method parses the ID producing a ZoneId or ZoneOffset. A ZoneOffset is returned if the ID is 'Z', or starts with '+' or '-'. The result will always be a valid ID for which ZoneRules can be obtained.
		*
		* Parsing matches the zone ID step by step as follows.
		*    - If the zone ID equals 'Z', the result is ZoneOffset.UTC.
		*    - If the zone ID consists of a single letter, the zone ID is invalid and DateTimeException is thrown.
		*    - If the zone ID starts with '+' or '-', the ID is parsed as a ZoneOffset using ZoneOffset.of(String).
		*    - If the zone ID equals 'GMT', 'UTC' or 'UT' then the result is a ZoneId with the same ID and rules equivalent to ZoneOffset.UTC.
		*    - If the zone ID starts with 'UTC+', 'UTC-', 'GMT+', 'GMT-', 'UT+' or 'UT-' then the ID is a prefixed offset-based ID.
		*    	The ID is split in two, with a two or three letter prefix and a suffix starting with the sign. The suffix is parsed as a ZoneOffset. 
		*    	The result will be a ZoneId with the specified UTC/GMT/UT prefix and the normalized offset ID as per ZoneOffset.getId().
		*    	The rules of the returned ZoneId will be equivalent to the parsed ZoneOffset.
		*    - All other IDs are parsed as region-based zone IDs. 
		*    	Region IDs must match the regular expression [A-Za-z][A-Za-z0-9~/._+-]+ otherwise a DateTimeException is thrown. 
		*    	If the zone ID is not in the configured set of IDs, ZoneRulesException is thrown. 
		*    	The detailed format of the region ID depends on the group supplying the data. 
		*    	The default set of data is supplied by the IANA Time Zone Database (TZDB). 
		*    	This has region IDs of the form '{area}/{city}', such as 'Europe/Paris' or 'America/New_York'. 
		*    	This is compatible with most IDs from TimeZone. 
		* 
		* See doc: https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/time/ZonedDateTime.html
		*		
		*/
		ZonedDateTime zonedDateTime = ZonedDateTime.of(1982,12,31,23,51, 0, 25, ZoneId.of("Europe/Paris"));		
		ZonedDateTime zonedDateTime2 = ZonedDateTime.of(aDate, aTime, ZoneId.of("ECT"));	
		ZonedDateTime zonedDateTime3 = ZonedDateTime.of(aDateTime, ZoneId.of("GMT+2"));

		System.out.println("LocalDateTime.of(1982,Month.DECEMBER,31,23,51) : " + zonedDateTime);
		System.out.println("LocalDateTime.of(2012,05,04,12,45) : " + zonedDateTime2);
		System.out.println("LocalDateTime.ofEpochDay(20012) : " + zonedDateTime3);
	}

	public static void from(){
		/*
		* from() method is a static factory method, similar to of() method.
		* It's used to derive a datetime object from the specified argument.
		*/
		LocalDateTime ldt = LocalDateTime.of(2012, 3, 15, 23, 45);
		
		// Here we derived 
		LocalDate ld = LocalDate.from(ldt);
		
		// Here we derived a LocalTime object from a LocalDateTime object
		LocalTime lt = LocalTime.from(ldt);

		System.out.println("LocalDate.from(ldt) : " + ld);
		System.out.println("LocalDate.from(ldt) : " + lt);
	}


	public static void withXXXMethods(){
		/*
		* Most classes in Date-Time API are immutable.
		* withXxxMethod() where Xxx can be replaced by Year, Month, Day, Hour, Minute, Second
		* are methods that allow to change fields of objects and return a new object
		* with the specified field changed.
		*/
		LocalDate ld1 = LocalDate.of(2020,04,01);						// 
		LocalDate ld2 = ld1.withYear(1965)
							.withMonth(3)
							.withDayOfMonth(1);		// 1965-03-01
		System.out.println("LocalDate.of(2020,04,01) : " + ld1);
		System.out.println("ld1.withYear(1965).withMonth(3).withDayOfMonth(1) : \n" + ld1 );

		LocalTime lt1 = LocalTime.of(23,12,56);
		LocalTime lt2 = lt1.withHour(15)
							.withMinute(32)
							.withSecond(51);
	}

	public static void getXxxMethods(){
		/*
		* getXxx() methodd returns the specified element of the object
		*/
		LocalDate ld1 = LocalDate.of(2020,04,01);
		int year = ld1.getYear();
		Month month = ld1.getMonth();	// Month.APRIL
		int day = ld1.getDayOfMonth();

		LocalTime lt1 = LocalTime.of(23,12,56);
		int hour = lt1.getHour();
		int minute = lt1.getMinute();
		int second = lt1.getSecond();
	}

	public static void toXxxMethods(){
		/*
		* toXxx() method converts an object to a related Xxx type.
		*/
		LocalDate ld1 = LocalDate.of(2020,4,1);

		// Convert the date to epoch days.
		// The epoch days is the number of days from 1970-01-01
		// A date before 1970-01-01 returns a negative number
		long epochDays = ld1.toEpochDay();

		LocalDateTime ldt = LocalDateTime.of(2113,8,9,2,12,12);
		LocalDate ld = ldt.toLocalDate();
		LocalTime lt = ldt.toLocalTime();
	}

	public static void atXxxMethods(){
		/*
		* atXxx() method lets you build a new datetime object from an existing datetime object
		* by supplying some additional pieces of information
		*/
		LocalDate ld = LocalDate.of(2001,12,14);
		LocalDateTime ldt1 = ld.atStartOfDay();
		LocalDateTime ldt2 = ld.atTime(12, 33);

		System.out.println("\natXxxMethods() methods: " + ld);
		System.out.println("ld.atStartOfDay() : " + ldt1);
		System.out.println("ld.atTime(12, 33) : " + ldt2);

		/*
		* Using a builder pattern to build a date 
		*/
		LocalDate d1  = Year.of(1877).atMonth(5).atDay(22);
	}

	public static void plusXxxMethods(){
		/*
		* plusXxx() Methods returns a copy of object by adding a specified value.
		*/
		LocalDate ld1 = LocalDate.of(1615,9,1);

		LocalDate ld2 = ld1.plusDays(5)
							.plusMonths(1);

		/*
		* minusXxx() Methods returns a copy of object by subtracting a specified value.
		*/
		LocalDate ld3 = ld1.minusYears(10).minusMonths(3);
		LocalTime lt1 = LocalTime.of(13,55,00);

		System.out.println("plusXxxMethods and minusXxx :");
		System.out.println(ld1);
		System.out.println(ld2);
		System.out.println(ld3);

	}

	/*
	* The methods below (multipliedBy, dividedBy and negate) are provided by
	* classes whose content is an amount of time such as Duration, Period,  
	*/
	public static void multipliedBy(){
		Duration d1 = Duration.ofSeconds(200);	// PT3M20S ( 3 minutes 20 seconds )
		Duration d2 = d1.multipliedBy(2);		// PT6M40S ( 6 minutes 40 seconds )
		System.out.println("Duration : " + d1);
		System.out.println("Duration multiplied by " + d2);

	}

	public static void dividedBy(){
		Duration d1 = Duration.ofSeconds(200);	// PT3M20S ( 3 minutes 20 seconds )
		/*
		* Duration dividedBy(long)
		* 
		*/
		Duration d2 = d1.dividedBy(2l);		// PT6M40S ( 1 minutes 40 seconds )
		
		System.out.println("Duration : " + d1);
		System.out.println(" d1.dividedBy(2l) : " + d2);

		// incompatible types: long cannot be converted to Duration
		//Duration d3 = d2.dividedBy(d1);
		//System.out.println(" d2.dividedBy(d1) : " + d3);
	}

	public static void negated(){
		Duration d1 = Duration.ofSeconds(200);	// PT3M20S ( 3 minutes 20 seconds )
		Duration d2 = d1.negated();				// PT6M40S ( -3 minutes 40 seconds )
		
		System.out.println("Duration : " + d1);
		System.out.println("Duration multiplied by " + d2);
	}





}