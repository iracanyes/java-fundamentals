package com.jdojo.datetime.scale.human;

import java.time.LocalDate;
import java.time.Month;

public class MonthEnumTest{
	public static void main(String[] args) {
		LocalDate ld1 = LocalDate.of(2012, Month.JULY, 1);

		// Derive a Month
		Month m1 = Month.from(ld1);

		// Create a Month from an integer
		Month m2 = Month.of(2);

		// Get next month
		Month m3 = m2.plus(1);

		// Get Month from LocalDate
		Month m4 = ld1.getMonth();

		// Convert an enum constant to an int 
		int m5 = m2.getValue();

		System.out.println("LocalDate.of(2012, Month.JULY, 1) : " + ld1);
		System.out.println("m1. Month.from(ld1) : " + m1);
		System.out.println("m2. Month.of(2) : " + m2);
		System.out.println("m3. m2.plus(1) : " + m3);
		System.out.println("m4. ld1.getMonth() : " + m4);
		System.out.println("m5. m2.getValue() : " + m5);
	}
}