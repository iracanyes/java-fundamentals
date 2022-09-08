package com.jdojo.datetime.scale.human;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;


public class LocalDateTimeTest{
	public static void main(String[] args) {
		// Create a local date and time
		LocalTime lt1 = LocalTime.of(8,32,65,9856);
		LocalDate ld1 = LocalDate.of(1698,12,28);

		System.out.println("Date : " + ld1);
		System.out.println("Time : " + lt1);
		System.out.println("Date is leap year : " + ld1.isLeapYear());

		// Create a local datetime from date and time
		LocalDateTime ldt1 = LocalDateTime.of(ld1, lt1);

		System.out.println("ldt1. Date and time : " + ldt1);

		// Add 2 months and subtracts 3 hours
		LocalDateTime ldt2 = ldt1.plusMonths(2).plusDays(555).minusHours(3);

		System.out.println("ldt2. ldt1.plusMonth(2).minusHours(3) : " + ldt2);

		// Get LocalDate or LocalTime from LocalDateTime
		LocalDate ld2 = LocalDate.from(ldt2);
		LocalTime lt2 = LocalTime.from(ldt2); 

		System.out.println("ld2. LocalDate.from(ldt2) : " + ld2);
		System.out.println("lt2. LocalTime.from(ldt2) : " + lt2);

		// 
		LocalDate ld3 = ld2.plusMonths(25).minusYears(55);

		LocalTime lt3 = lt2.minusSeconds(8900).plusHours(24);


		
	}


}