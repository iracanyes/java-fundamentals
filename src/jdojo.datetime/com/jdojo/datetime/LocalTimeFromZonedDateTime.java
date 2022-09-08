/*
* Date-Time API provides multiple ways to access LocalTime from ZonedDateTime
*/
package com.jdojo.datetime;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalQueries;
import java.time.LocalTime;

public class LocalTimeFromZonedDateTime{
	public static void main(String[] args) {
		ZonedDateTime zdt = ZonedDateTime.now();

		LocalTime lt1 = zdt.toLocalTime();

		LocalTime lt2 = LocalTime.from(zdt);

		LocalTime lt3 = zdt.query(TemporalQueries.localTime());

		LocalTime lt4 = zdt.query(LocalTime::from);

		// Construct a LocalTime from all component
		int hours = zdt.getHour();
		int minutes = zdt.getMinute();
		int seconds = zdt.getSecond();
		int nanos = zdt.getNano();
		LocalTime lt5 = LocalTime.of(hours, minutes, seconds, nanos);

		System.out.println("zdt : " + zdt);
		System.out.println("lt1 : " + lt1);
		System.out.println("lt2 : " + lt2);
		System.out.println("lt3 : " + lt3);
		System.out.println("lt4 : " + lt4);
		System.out.println("lt5 : " + lt5);

	}
}


