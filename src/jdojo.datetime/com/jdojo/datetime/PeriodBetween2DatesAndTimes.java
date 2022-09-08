package com.jdojo.datetime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.HOURS;
import static java.time.temporal.ChronoUnit.MINUTES;

public class PeriodBetween2DatesAndTimes{
	public static void main(String[] args) {
		LocalDate ld1 = LocalDate.of(2012, Month.MAY, 14);
		LocalDate ld2 = LocalDate.of(2012, Month.MAY, 14);
		LocalTime lt1 = LocalTime.of(12,45,30);
		LocalTime lt2 = LocalTime.of(19,45,30);

		System.out.printf("ld1 : %s\nld2 : %s\nlt1 : %s\nlt2 : %s\n", ld1, ld2, lt1, lt2);
		/*
		* Date-Time API provides methods to compute an amount of time elapsed between 2 dates, times, and datetimes.
		* Signature:
		*	- between() method on one of the constants in the ChronoUnit enum.
		*	- until() method on one of the datime-related classes (LocalDateTime, LocalDate, LocalTime, ZonedDateTime, etc.)
		*/

		/*
		* ChronoUnit enum has a between() method, which takes 2 datetime objects and returns a value of long type.
		* between() returns the amount of time elapsed from the first date given in arguments
		* to the second date given as second arguments.
		* If the second argument occurs before the first one, it returns a negative amount.
		*/

		long days = DAYS.between(ld1, ld2);
		
		long hours = HOURS.between(lt1, lt2);
		long minutes = MINUTES.between(lt1, lt2);

		System.out.println("DAYS.between(ld1, ld2) : " + days + " days.");
		System.out.println("HOURS.between(lt1, lt2) : " + hours + " hours.");
		System.out.println("MINUTES.between(lt1, lt2) : " + minutes + " minutes.");


		/*
		* Using the until() method
		*/
		long days2 = ld1.until(ld2, DAYS);

		/*
		* You cannot compare the number of hours between a LocalDate and a LocalDateTime, 
		* as a LocalDate  doesn't store a time component.
		* A runtime exception will be thrown.
		*/
		long hours2 = lt1.until(lt2, HOURS);
		long minutes2 = lt1.until(lt2, MINUTES);

		System.out.println("DAYS.between(ld1, ld2) : " + days2 + " days.");
		System.out.println("HOURS.between(lt1, lt2) : " + hours2 + " hours.");
		System.out.println("MINUTES.between(lt1, lt2) : " + minutes2 + " minutes.");


	}


}