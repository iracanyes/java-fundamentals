/*
* How will you get all dates in a specific year that fall on Sunday?
* How will you get all dates in next five years that fall on the 13th of the month
* and fall on friday?
*
* 
* Stream<LocalDate> datesUntil(LocalDate endExclusive)
* Stream<LocalDate> datesUntil(LocalDate endExclusive, Period step)
*
* 
*/
package com.jdojo.datetime.scale.human;

import java.time.LocalDate;
import java.time.DayOfWeek;
import java.util.stream.Stream;

public class SequentialOrderedStreamOfLocalDates{
	public static void main(String[] args) {
		/**/	
		getAllDateOfSpecificDayOfWeek();
		getAllDatesFromIntervalOfSpecificDayOfMonthAndDayOfWeek();
	}

	public static void getAllDateOfSpecificDayOfWeek(){
		LocalDate startDate = LocalDate.of(2023,1,1);
		LocalDate endDateExclusive = LocalDate.of(2024,1,1);

		/*
		* Stream is A sequence of elements supporting sequential and parallel aggregate operations. 
		*/	
		Stream<LocalDate> stDates2023 = startDate.datesUntil(endDateExclusive);


		Stream<LocalDate> stSundays2023 = stDates2023.filter(ld -> ld.getDayOfWeek() == DayOfWeek.SATURDAY);

		// Number of sundays in 2023
		long saturdaysIn2023 = stSundays2023.count();

		System.out.println("Number of Saturdays in 2023 : " + saturdaysIn2023);
	}

	public static void getAllDatesFromIntervalOfSpecificDayOfMonthAndDayOfWeek(){
		/*
		* All fridays that fall on 13th of the month between 2022-2024
		*/
		System.out.println("All fridays that fall on 13th of the month between 2022-2024");

		LocalDate.of(2022,1,1)
				 .datesUntil(LocalDate.of(2024,1,1))
				 .filter(ld -> ld.getDayOfMonth() == 13 && ld.getDayOfWeek() == DayOfWeek.FRIDAY)
				 .forEach(System.out::println);
	}	
}