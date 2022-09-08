/*
* An instance of TemporalField interface represents a field of datetime.
* Ex: year, month-of-year, minutes-of-hour, etc.
* 
* The ChronoField enums contains a long list of constants.
* Ex: AMPM_of_DAY, CLOCK_HOUR_OF_AMPM, CLOCK_HOUR_OF_DAY, DAY_OF_MONTH,
* DAY_OF_WEEK, DAY_OF_YEAR, ERA, HOUR_OF_AMPM, HOUR_OF_DAY, INSTANT_SECONDS, 
* MINUTE_OF_HOUR, MONTH_OF_YEAR, SECOND_OF_MINUTE, YEAR and YEAR_OF_ERA. 
*
* You use a TemporalField to get the value of the field from a datetime.
* All datetime classes have a get() method that returns an int value for the specified TemporalField.
* 
*/
package com.jdojo.datetime.scale.human;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

public class ChronoFieldEnumTest{
	public static void main(String[] args) {
		LocalDateTime ldt1 = LocalDateTime.now();

		System.out.println("Current Date time : " + ldt1);
		System.out.println("Year : " + ldt1.get(ChronoField.YEAR));
		System.out.println("Month : " + ldt1.get(ChronoField.MONTH_OF_YEAR));
		System.out.println("Day : " + ldt1.get(ChronoField.DAY_OF_MONTH));
		System.out.println("Hour-of-day : " + ldt1.get(ChronoField.HOUR_OF_DAY));
		System.out.println("Hour-of-AMPM : " + ldt1.get(ChronoField.HOUR_OF_AMPM));
		System.out.println("AMPM-of-day : " + ldt1.get(ChronoField.AMPM_OF_DAY));

		LocalDate ld1 = LocalDate.now();
		boolean ySupp = ld1.isSupported(ChronoField.YEAR);
		boolean ySupp1 = ChronoField.YEAR.isSupportedBy(ld1);

		boolean hodSupp = ld1.isSupported(ChronoField.HOUR_OF_DAY);
		boolean hodSupp2 = ChronoField.HOUR_OF_DAY.isSupportedBy(ld1);

		System.out.println("Now : " + ld1);
		System.out.println("ld1.isSupported(ChronoField.YEAR) : " + ySupp);
		System.out.println("ChronoField.YEAR.isSupported(ld1) : " + ySupp1);
		System.out.println("ld1.isSupported(ChronoField.HOUR_OF_DAY) : " + hodSupp);
		System.out.println("ChronoField.HOUR_OF_DAY.isSupported(ld1) : " + hodSupp2);

	}
}