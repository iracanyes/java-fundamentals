/*
* In Java 8, the LocalDateTime class contained a static method named ofInstant(Instan)
*/
package com.jdojo.datetime.scale.human;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.ZoneId;

public class ConvertInstantToLocalDateTime{
	public static void main(String[] args) {
		// Get an instant
		Instant now = Instant.now();

		// Get the system default time zone
		ZoneId zone = ZoneId.systemDefault();

		java8Convert(now, zone);
		java9PlusConvert(now, zone);

	}

	public static void java8Convert(Instant now, ZoneId zone){	
		// Convert the Instant to a ZonedDateTime
		ZonedDateTime zdt = now.atZone(zone);

		// Get the LocalDate from the ZonedDateTime
		LocalDate ld1 = zdt.toLocalDate();

		// Get the LocalTime from ZonedDateTime
		LocalTime lt1 = zdt.toLocalTime();

		System.out.println("In Java 8");
		System.out.println("Instant : " + now);
		System.out.println("Local date : " + ld1);
		System.out.println("Local time : " + lt1);

	}

	public static void java9PlusConvert(Instant now, ZoneId zone){

		// Get a LocalDate from the Instant
		LocalDate ld1 = LocalDate.ofInstant(now, zone);

		// Get Localtime from the Instant
		LocalTime lt1 = LocalTime.ofInstant(now, zone); 

		System.out.println("\nIn Java 9");
		System.out.println("Instant : " + now);
		System.out.println("Local date : " + ld1);
		System.out.println("Local time : " + lt1);
	}
}