/*
* PARTIALS
* Partial class represents a date, time or datetime that does not fully specify an instant on a timeline.
* but still makes sense to humans. 
* Ex: December 25th, January 1st
*
* IMPORTANT: To identify an instant uniquely on a timeline, 
* you must have a date, time and time zone!
*
* If you have some, but not all, of the 3 informations, you have a Partial.
* You cannot derive a Instant from a Partial without supplying the missing informations.
*
* LocalDate, LocalTime, LocalDateTime, Offset, Year, YearMonth, MonthDay inherits from Partial classes
* OffsetDateTime and ZonedDateTime are not partials, they can identify an instant on the timeline uniquely.
*/
package com.jdojo.datetime;

import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Partials{
	public static void main(String[] args) {
		// Use Year
		Year y1 = Year.of(2015);
		Year y2 = y1.minusYears(1);
		Year y3 = y1.plusYears(1);
		Year y4 = Year.now();

		if(y1.isLeap()){
			System.out.println(y1 + " is a leap year.");
		}else{
			System.out.println(y1 + " is not a leap year.");
		}

		// Use YearMonth
		YearMonth ym1 = YearMonth.of(2021, Month.MAY);

		int monthLength = ym1.lengthOfMonth();
		System.out.println("Days in month in " + ym1 + " : " + monthLength);

		// Get
		MonthDay md1 = MonthDay.of(12,25);
		MonthDay md2 = MonthDay.of(Month.JANUARY, 1);

		if(md2.isValidYear(2009)){
			System.out.println(md2 + " occured in 2009");
		}else{
			System.out.println(md2 + " did not occured in 2009");
		}

		combineYearAndMonthDay();
	}

	public static void combineYearAndMonthDay(){
		MonthDay dec25 = MonthDay.of(Month.DECEMBER, 25);
		Year yNow = Year.now();

		// 
		for(int i = 0; i < 5; i++){
			LocalDate ld = yNow.plusYears(i).atMonthDay(dec25);

			int year = ld.getYear();
			String weekDay = ld.getDayOfWeek()
								.getDisplayName(TextStyle.FULL, Locale.getDefault());

			System.out.printf("Christmas in %d is on %s.\n", year, weekDay);


		}
	}

	/*
	* Here you can see that we obtain the same result with a different way
	*/
	public static void combineYearAndMonthDay2(){
		LocalDate ldXmas = LocalDate.of(Year.now().getValue(), Month.DECEMBER, 25);

		for(int i = 0; i < 5; i++){
			LocalDate ld = ldXmas.withYear((ldXmas.getYear() + 1));

			int yr = ld.getYear();

			String weekDay = ld.getDayOfWeek()
								.getDisplayName(TextStyle.FULL, Locale.getDefault());
			System.out.printf("Christmas in %d is on %s.%n", yr, weekDay);
		}
		
	}


}