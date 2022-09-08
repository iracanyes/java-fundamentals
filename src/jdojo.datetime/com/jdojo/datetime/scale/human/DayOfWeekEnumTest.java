/*
* Constants of DayOfWeek
* 	1.MONDAY 2.TUESDAY 3.WEDNESDAY 4.THURSDAY 5.FRIDAY 6.SATURDAY SUNDAY
*/
package com.jdojo.datetime.scale.human;

import java.time.LocalDate;
import java.time.DayOfWeek;

public class DayOfWeekEnumTest{
	public static void main(String[] args) {
		LocalDate ld1 = LocalDate.now();

		// Get DayOfWeek from LocalDate
		DayOfWeek dow1 = DayOfWeek.from(ld1); 	// Today: TUESDAY

		// Get the int value of the DayOfWeek
		int dow11 = dow1.getValue();

		// Get DayOfWeek from int
		DayOfWeek dow111 = DayOfWeek.of(dow11);
		
		// Use getter from LocalDate to get DayOfWeek
		DayOfWeek dow2 = ld1.getDayOfWeek();

		// Adding and subtracting to DayOfWeek
		DayOfWeek dow3 = dow1.plus(2);
		DayOfWeek dow4 = dow2.minus(4);

		System.out.println("ld1 - Current date: " + ld1);
		System.out.println("");
		System.out.println("dow1.getValue() : " + dow11);
		System.out.println("DayOfWeek.of(dow11) : " + dow111);
		System.out.println("ld1.getDayOfWeek()");

	}
}