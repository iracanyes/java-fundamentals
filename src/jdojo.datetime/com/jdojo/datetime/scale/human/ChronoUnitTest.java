/*
* The ChronoUnit contains constants for unit of time:
* CENTURIES, DAYS, DECADES, ERAS, FOREVER, HALF_OF_DAYS, HOURS, MICROS, 
* MILLENNIA, MILLIS, MINUTES, MONTHS, NANOS, SECONDS, WEEKS and YEARS
*/
package com.jdojo.datetime.scale.human;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class ChronoUnitTest{
	public static void main(String[] args) {
		LocalDateTime ldt1 = LocalDateTime.now();

		// Get the date time 4 days ago
		LocalDateTime ldt2 = ldt1.minus(4, ChronoUnit.DAYS);

		// Use the minusDays() method to get 4 days ago
		LocalDateTime ldt3 = ldt1.minusDays(4);

		// Get date and time 4 hours later
		LocalDateTime ldt4 = ldt1.plus(4, ChronoUnit.HOURS);

		// Use the plusDays() method to the same result
		LocalDateTime ldt5 = ldt1.plusHours(4);

		System.out.println("Current time : " + ldt1);
		System.out.println("4 days ago : " + ldt2);
		System.out.println("4 days ago : " + ldt3);
		System.out.println("4 hours later : " + ldt4);
		System.out.println("4 hours later : " + ldt5);


	}


}