/*
* An instance of the Offset and OffsetDateTime classes represents a time and a datetime,
* respectively, with a fixed zone offset from UTC.
*
*	OffsetTime = LocalTime + ZoneOffset
*	OffsetDateTime = LocalDateTime + ZoneOffset
*
*/
package com.jdojo.datetime.scale.human;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class OffsetTimeAndDateTime{
	public static void main(String[] args) {
		// Get the current offset time 
		OffsetTime ot1 = OffsetTime.now();

		// Create a zone offset +05:30
		ZoneOffset offset = ZoneOffset.ofHoursMinutes(5, 30);
		
		// Create an offset time (local time + zone offset)
		OffsetTime ot2 = OffsetTime.of(18,45,30, 98764, offset);

		// Get the current offset datetime
		OffsetDateTime odt1 = OffsetDateTime.now();

		// Get an offset datetime
		OffsetDateTime odt2 = OffsetDateTime.of(2022,9,1,15,58,56, 789645, offset);

		// Get local date and time from the OffsetDateTime
		LocalDate ld1  = odt1.toLocalDate();
		LocalTime lt1 = odt1.toLocalTime();

		// Get the Instant from the offset datetime
		Instant i1 = odt1.toInstant();

		// Create an OffsetDateTime from the Instant
		ZoneId euParis = ZoneId.of("Europe/Paris");
		OffsetDateTime odt3 = OffsetDateTime.ofInstant(i1, euParis);

		System.out.println("Current offset time : " + ot1);
		System.out.println("Zone offset : " + offset);
		System.out.println("Offset time : " + ot2);
		System.out.println("Offset datetime : " + odt1);
		System.out.println("An offset datetime : " + odt2);
		System.out.println("Current Local date : " + ld1);
		System.out.println("Current local time : " + lt1);
		System.out.println("Current instant : " + i1);
		System.out.println("Offset datetime from instant : " + odt3);




	}


}