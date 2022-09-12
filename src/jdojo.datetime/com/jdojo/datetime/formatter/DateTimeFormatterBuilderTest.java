/*
*
*/
package com.jdojo.datetime.formatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeFormatter;
import java.time.DateTimeException;
import static java.time.format.TextStyle.FULL_STANDALONE;
import static java.time.temporal.ChronoField.DAY_OF_WEEK;
import static java.time.temporal.ChronoField.YEAR;


public class DateTimeFormatterBuilderTest{
	public static void main(String[] args) {
		DateTimeFormatter formatter = new DateTimeFormatterBuilder()
										.appendLiteral("Christmas in ")
										.appendValue(YEAR)
										.appendLiteral(" is on ")
										.appendText(DAY_OF_WEEK, FULL_STANDALONE)
										.toFormatter();
		LocalDate ld = LocalDate.of(2022,12,25);

		try{
			String str = ld.format(formatter);
			System.out.println(str);
		}catch(DateTimeException e){
			System.out.println("Error formatting " + ld + " : " + e.getMessage());
		}

		// Equivalent to 
		String pattern = "'Christmas in' yyyy 'is on' EEEE";
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern(pattern);

		ld = LocalDate.of(2023, 12, 25);
		try{
			String str = ld.format(formatter2);
			System.out.println(str);
		}catch(DateTimeException e){
			System.out.println("Error formatting " + ld + " : " + e.getMessage());
		}
	}
}