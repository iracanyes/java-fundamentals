/*
* Custom Adjuster
* If a date fall on weekends or friday 13th, it returns the next monday. Otherwise, it returns the original date
*/
package com.jdojo.datetime;

import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalAdjuster;
import java.time.LocalDate;


public class CustomAdjusters{
	public final static  TemporalAdjuster WEEKDAYS_WITHOUT_WEEKEND_AND_NO_FRIDAY_13 =
		TemporalAdjusters.ofDateAdjuster(CustomAdjusters::getDayWithoutWeekendsAndFriday13);

	private CustomAdjusters(){

	}

	private static LocalDate getDayWithoutWeekendsAndFriday13(LocalDate date){
		// Copy the parameter received
		LocalDate localDate = date;

		DayOfWeek day = date.getDayOfWeek();

		if(day == DayOfWeek.SATURDAY 
			|| day == DayOfWeek.SUNDAY 
			|| (day == DayOfWeek.FRIDAY && localDate.getDayOfMonth() == 13)
		){
			// Return next monday
			localDate = localDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		}

		return localDate;
	}
}