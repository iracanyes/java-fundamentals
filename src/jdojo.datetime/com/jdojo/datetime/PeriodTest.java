/*
* Periods
* A period is an amount of time defined in terms of calendar fields (years, months, days).
* A Duration is also an amount of time measured in seconds and nanoseconds.
* Negative periods are supported.
*
* The difference is that a period represents an inexact amount of time,
* whereas a Duration represents an exact amount of time.
*
* Periods are used for humans whereas Duration are used at machine scale.
*/
package com.jdojo.datetime;

import java.time.Period;
import java.time.ZoneId;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.Duration;
import java.time.Month;

import java.util.ArrayList;


public class PeriodTest{
	public static void main(String[] args) {
		ArrayList<Period> periods = new ArrayList<Period>();
		periods = createPeriods();

		manipulatePeriods(periods.get(0), periods.get(1));

	}

	public static ArrayList<Period> createPeriods(){
		ArrayList<Period> periods = new ArrayList<Period>();

		/*
		* static Period of(int years, int months, int days)
		*/
		Period p1 = Period.of(1989,6,3);
		periods.add(p1);

		/*
		* static Period of(int days)
		* Create a period of days
		*/
		Period p2 = Period.ofDays(35);
		periods.add(p2);
		/*
		* static Period ofYears(int years)
		*/
		Period p3 = Period.ofYears(25);
		periods.add(p3);
		/*
		* static Period ofMonths(int months)
		*/
		Period p4 = Period.ofMonths(18);
		periods.add(p4);

		/*
		* static Period ofDays(int days)
		*/
		Period p5 = Period.ofWeeks(180);
		periods.add(p5);

		Period p6 = Period.ofYears(3).ofMonths(5).ofDays(24);
		periods.add(p6);

		System.out.println("Period.of(1989,6,3) : " + p1);
		System.out.println("Period.ofDays(35) : " + p2);
		System.out.println("Period.ofYears(25) : " + p3);
		System.out.println("Period.ofMonths(18) : " + p4);
		System.out.println("Period.ofWeeks(180) : " + p5);
		System.out.println("Period.ofYears(3).ofMonths(5).ofDays(24) : " + p6);
		
		return periods;		
	}

	public static void manipulatePeriods(Period period1, Period period2){
		System.out.println("period1 : " + period1);
		System.out.println("period2 : " + period2);

		Duration duration = Duration.ofHours(24);
		System.out.println("duratiion : " + duration);

		System.out.println("period1.plusDays(180) : " + period1.plusDays(180));
		System.out.println("period2.minusDays(35) : " + period2.minusDays(35));
		System.out.println("period1.plus(period2) : " + period1.plus(period2));
		System.out.println("period1.plus(period2).normalized() : " + period1.plus(period2).normalized());
		System.out.println("period1.negated() : " + period1.negated());
		System.out.println("period1.multipliedBy(2) : " + period1.multipliedBy(2));

	}

	/*
	* There is a difference in the way Java computes periods and duration.
	* Add/subtract a period of 1 day of period will modify only the day field 
	* of ZonedDateTime without interaction with the time.
	* Using a Duration of 24hours, it will add 24 hours to ZonedDateTime
	* knowing that the hours 02:00 to 03:00 doesn't exist
	*/
	public static void inexactPeriod(){
		ZoneId euParis = ZoneId.of("Europe/Paris");
		LocalDateTime ldt1 = LocalDateTime.of(2022, Month.MARCH, 27, 8,45);
		ZonedDateTime zdt1 = ZonedDateTime.of(ldt1, euParis);
	
		Period p1 = Period.ofDays(1);
		Duration d1 = Duration.ofHours(24);

		ZonedDateTime zdt2 = zdt1.plus(p1);
		ZonedDateTime zdt3  = zdt1.plus(d1);

		System.out.println("Start Datetime  " + zdt1);
		System.out.println("After 1 Day period : " + zdt2);
		System.out.println("After 24 hours duration: " + zdt3);


	}

}