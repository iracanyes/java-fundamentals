/*
* An instance of the ZonedDateTime class represents a datetime with time zone rules.
* The time zone rules include a zone offset and rules for its variation because
* of Daylight Savings Time.
*	ZonedDateTime = LocalDateTime + ZoneId
*
* Some combination of LocalDateTime and ZoneId result in a valid ZonedDateTime.
* Because of Daylight Savings Time, when the clock move forward of one hour, 
* it creates a gap of one hour, the hour doesn't exist on the timeline.
* Ex: At 03:00, the clock move to 04:00, the gap 03:00 to 03:59 doesn't exists
*
* When the clock move backward of one hour, the hours exist twice.
* It's called an Overlap.
*
* Here is how Java treats a datetime that falls into a gap or an overlap:
* 	- A gap : the time is moved forward by the same amount as the gap.
*		Ex: 02:30 => 03:30
*	- An Overlap: the time is valid.
*/
package com.jdojo.datetime.scale.human;

import java.time.ZonedDateTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.Month;
import java.time.ZoneOffset;
import java.time.Instant;
import java.time.OffsetDateTime;

public class ZonedDateTimeTest{
	public static void main(String[] args) {
		// Now
		ZonedDateTime zdt1 = ZonedDateTime.now();
		// Create the ZoneId
		ZoneId euParis = ZoneId.of("Europe/Paris");

		// Get LocalDateTime
		LocalDateTime ldt1 = LocalDateTime.of(2022, Month.MARCH,28, 7, 30);

		// Create a ZonedDateTime from LocalDateTime and Zone
		ZonedDateTime zdt2 = ZonedDateTime.of(ldt1, euParis);

		LocalDateTime ldt2 = LocalDateTime.of(2011, Month.OCTOBER, 30, 02, 11, 11);
		ZonedDateTime zdt3= ZonedDateTime.of(ldt2, euParis);

		System.out.println("Zone id : " + euParis);
		System.out.println("Local datetime : " + ldt1);
		System.out.println("Zoned datetime : " + zdt2);

		// Get Offset and ZoneId from ZonedDateTime
		ZoneOffset offset = zdt2.getOffset();
		ZoneId zone = zdt2.getZone();

		// Subtract 10 hours. Zone-offset changes from +01:00 to +02:00
		ZonedDateTime zdt4 = zdt2.minusHours(11);
		System.out.println("Subtract 10 hours : " + zdt4);


		System.out.println("zdt1.withLaterOffsetAtOverlap() :" + zdt1.withLaterOffsetAtOverlap());
		System.out.println("zdt2.withEarlierOffsetAtOverlap() : " + zdt2.withEarlierOffsetAtOverlap());

		// Perform some conversions on zoned date time
		// LocalDateTime from ZonedDateTime
		LocalDateTime ldt3 = zdt4.toLocalDateTime();

		// OffsetDateTime from ZonedDateTime
		OffsetDateTime odt3 = zdt4.toOffsetDateTime();

		// Instant from ZonedDateTime
		Instant i1 = zdt3.toInstant();

		System.out.println("ZonedDateTime conversion");
		System.out.println("To Local datetime : " + ldt3);
		System.out.println("To Offset datetime: " + odt3);
		System.out.println("To instant : " + i1);


	}

	public static void ofLocalMethod(){
		/*
		* ofLocal(LocalDateTime, ZoneId, ZoneOffset)
		* Create a ZonedDateTime by specifying the preferred zone offset in case there are 2 zone offsets available
		* for the local tiem in the specified zone
		*/
		ZoneId usChicago = ZoneId.of("America/Chicago");
		ZoneOffset offset5 = ZoneOffset.of("-05:00");
		ZoneOffset offset6 = ZoneOffset.of("-06:00");
		ZoneOffset offset7 = ZoneOffset.of("-07:00");

		LocalDateTime ldt1 = LocalDateTime.of(2020,Month.FEBRUARY,11, 5, 30);
		ZonedDateTime zdt5 = ZonedDateTime.ofLocal(ldt1, usChicago, offset5);
		ZonedDateTime zdt6 = ZonedDateTime.ofLocal(ldt1, usChicago, offset6);
		ZonedDateTime zdt7 = ZonedDateTime.ofLocal(ldt1, usChicago, offset7);

		System.out.println("With offset " + offset5 + " : " + zdt5);
		System.out.println("With offset " + offset6 + " : " + zdt6);
		System.out.println("With offset " + offset7 + " : " + zdt7);


	}
}