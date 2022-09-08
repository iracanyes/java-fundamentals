/*
* To adjust a date and time to have a particular characteristic,
* ex: 1th Monday of the month, the next friday, etc.
* You can perform an adjustment to a date and time using instance
* of TemporalAdjuster interface.
*
* Date-Time API provides many commonly used adjusters and you can create your own.
* A TemporalAdjusters class provides all static methods that return different types
* of method.
*/
package com.jdojo.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalAdjuster;


public class AdjustingDates{
	public static void main(String[] args) {
		LocalDate ld1 = LocalDate.of(2013, Month.JANUARY, 1 );
		/*
		* next(DayOfWeek)
		* Here we adjust the date to be the first specified day of the week
		* after the date being adjusted
		*/
		LocalDate ld2 = ld1.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		/*
		* nextOrSame(DayOfWeek)
		* Adjust the date to the first specified day of week.
		* If the date being adjusted is already on the specified day of week,
		* it returns the same date
		*/
		LocalDate ld3 = ld1.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
		
		/*
		* previous(DayOfWeek)
		* Here we adjust the date to be the last specified day of the week
		* after the date being adjusted
		*/
		LocalDate ld4 = ld1.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));

		/*
		* previousOrSame(DayOfWeek)
		* Here we adjust the date to be the last specified day of the week
		* after the date being adjusted
		*/
		LocalDate ld5 = ld1.with(TemporalAdjusters.previousOrSame(DayOfWeek.TUESDAY));

		/*
		* firstInMonth(DayOfWeek)
		* Here we adjust the date to be the first specified day of the week
		* in the month after the date being adjusted
		*/
		LocalDate ld6 = ld1.with(TemporalAdjusters.firstInMonth(DayOfWeek.TUESDAY));

		/*
		* lastInMonth(DayOfWeek)
		* Here we adjust the date to be the last specified day of the week
		* in the month after the date being adjusted
		*/
		LocalDate ld7 = ld1.with(TemporalAdjusters.lastInMonth(DayOfWeek.TUESDAY));

		/*
		* dayOfWeekInMonth(int ordinal, DayOfWeek dayOfWeek)
		* Returns a adjuster that adjusts the date to be the 
		* specified ordinal day of week in the month represented by
		* the date being adjusted
		*
		* Here we adjust to the 3rd Thursday of the month
		*/
		LocalDate ld8 = ld1.with(TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.THURSDAY));

		/*
		* firstDayOfMonth()
		* Adjusts the date to the first day of the month
		*/
		LocalDate ld9 = ld1.with(TemporalAdjusters.firstDayOfMonth());

		/*
		* lastDayOfMonth()
		* Adjusts the date to the last day of the month
		*/
		LocalDate ld10 = ld1.with(TemporalAdjusters.lastDayOfMonth());
		
		/*
		* firstDayOfYear()
		* Adjusts the date to the first day of the year
		*/
		LocalDate ld11 = ld1.with(TemporalAdjusters.firstDayOfYear());
		
		/*
		* lastDayOfYear()
		* Adjusts the date to the first day of the year
		*/
		LocalDate ld12 = ld1.with(TemporalAdjusters.lastDayOfYear());

		/*
		* firstDayOfNextMonth()
		* Adjusts the date to the first day of the next month
		*/
		LocalDate ld13 = ld1.with(TemporalAdjusters.firstDayOfNextMonth());
		
		/*
		* firstDayOfNextYear()
		* Adjusts the date to the first day of the next year
		*/
		LocalDate ld14 = ld1.with(TemporalAdjusters.firstDayOfNextYear());

		// sample of methods chaining
		LocalDate ld15 = LocalDate.now()
								  .plusMonths(3)
								  .plusDays(15)
								  .with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.FRIDAY));

		/*
		* ofDateAdjuster(UnaryOperator<LocalDate> dateBasedAdjusters)
		* A convenience method for devs to write their own LocalDate-based adjusters
		*/
		TemporalAdjuster adjuster = 
			TemporalAdjusters.ofDateAdjuster((LocalDate date) -> date.plusMonths(3).plusDays(2));

		// Use the adjuster
		LocalDate today = LocalDate.now();
		LocalDate dateAdjusted = today.with(adjuster);


		/*
		* Custom Adjuster
		* Week day without week-end days and friday 13th
		*/
		LocalDate ldCustom = LocalDate.now().with(CustomAdjusters.WEEKDAYS_WITHOUT_WEEKEND_AND_NO_FRIDAY_13);

		System.out.println("ld1 : " + ld1);
		System.out.println("Next monday : " + ld2);
		System.out.println("Next or same friday : " + ld3);
		System.out.println("Previous friday : " + ld4);
		System.out.println("Previous or same Tuesday : " + ld5);
		System.out.println("Fist in month (day of week) : " + ld6);
		System.out.println("lastInMonth (day of week) : " + ld7);
		System.out.println("Nth day of week (3rd Thursday of month) : " + ld8);
		System.out.println("First day of month : " + ld9);
		System.out.println("Last day of month : " + ld10);
		System.out.println("First day of year : " + ld11);
		System.out.println("First day of year : " + ld12);
		System.out.println("First day of next month : " + ld13);
		System.out.println("First day of next year : " + ld14);
		System.out.println("Today plus 3 months and 15 days adjusted to second friday of the month : " + ld15);
		System.out.println("Today plus 3 months and 2 days : " + dateAdjusted);
		System.out.println("Custom adjuster - no weekend day and friday 13 : " + ldCustom);
		/*
		* adjustInto() method that takes Temporal and returns a Temporal.
		*
		*/


	}
}