/*
*  The following date and time conversion suffix characters are defined for the 't' and 'T' conversions. The types are similar to but not completely identical to those defined by GNU date and POSIX strftime(3c). Additional conversion types are provided to access Java-specific functionality (e.g. 'L' for milliseconds within the second).
*
* The general syntax for a format is as follows:
*	%<argument-index>$<flags><width><.precision><conversion>	
*/
package com.jdojo.format.formatter;


import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.temporal.Temporal;
import java.util.Formatter;
import static java.time.Month.*;

public class FormatterDateAndTimeConversion {
	public static void main(String[] args) {
		StringBuffer sBuffer = new StringBuffer();

		// Legacy classes
		Date legacyToday = new Date();
		Calendar cal = Calendar.getInstance();
		GregorianCalendar gc = new GregorianCalendar();

		// Date-Time API classes
		LocalDate ld = LocalDate.now();
		LocalTime lt = LocalTime.now();
		LocalDateTime ldt = LocalDateTime.of(1923, JUNE, 15, 16, 23, 30);
		OffsetDateTime odt = OffsetDateTime.now();
		ZonedDateTime zdt = ZonedDateTime.now();

		// Formatter
		Formatter formatter = new Formatter(sBuffer);

		// Format time
		formatter.format("\n******************** FORMAT TIME *****************************\n");
		
		formatter.format("\nLegacy date : ", legacyToday);
		formatTime(formatter, legacyToday);

		formatter.format("\nLocal time : %s%n", lt);
		formatTime(formatter, lt);

		formatter.format("\nLocal datetime : %s%n", ldt);
		formatTime(formatter, ldt);

		formatter.format("\nZoned datetime : %s%n", zdt);
		formatTime(formatter, zdt);

		// Format dates
		formatter.format("\n******************** FORMAT DATES *****************************\n");
		
		formatter.format("\nLegacy date : ", legacyToday);
		formatDate(formatter, legacyToday);

		formatter.format("\nLocal datetime : ", ldt);
		formatDate(formatter, ldt);

		formatter.format("\nOffset datetime : %s%n", odt);
		formatDate(formatter, odt);

		formatter.format("\nZoned datetime : %s%n", zdt);
		formatDate(formatter, zdt);


		// Format date/time
		formatter.format("\n******************** FORMAT DATETIME *****************************\n");
		
		formatter.format("\nLegacy date : ", legacyToday);
		formatDateTime(formatter, legacyToday);

		formatter.format("\nLocal datetime : ", ldt);
		formatDateTime(formatter, ldt);

		formatter.format("\nOffset datetime : %s%n", odt);
		formatDateTime(formatter, odt);

		formatter.format("\nZoned datetime : %s%n", zdt);
		formatDateTime(formatter, zdt);

		// Print build text
		System.out.println(sBuffer.toString());

	}

	public static void formatTime(Formatter fm, Object time){
		FormatterTimeConversion ftc = FormatterTimeConversion.getInstance();

		ftc.formatHour1To24(fm, time);
		ftc.formatHour0To11(fm, time);
		ftc.formatHour0To23(fm, time);
		ftc.formatHour1To12(fm, time);
		ftc.formatMinutes(fm, time);
		ftc.formatSeconds(fm, time);
		ftc.formatMillis(fm, time);
		ftc.formatNanos(fm, time);
		ftc.formatAMPM(fm, time);
		ftc.formatTimeZoneNumber(fm, time);
		ftc.formatTimeZoneShort(fm, time);
		ftc.formatSecondSinceEpoch(fm, time);
		ftc.formatMillisSinceEpoch(fm, time);

	}

	public static void formatDate(Formatter fm, Object date){
		FormatterDateConversion fdc = FormatterDateConversion.getInstance();

		fdc.formatMonthFull(fm, date);
		fdc.formatMonthShort1(fm, date);
		fdc.formatMonthShort2(fm, date);
		fdc.formatDayNameFull(fm, date);
		fdc.formatDayNameShort(fm, date);
		fdc.formatYearInCentury(fm, date);
		fdc.formatYear(fm, date);
		fdc.formatDayOfYear(fm, date);
		fdc.formatMonth(fm, date);
		fdc.formatDayOfMonthWith0(fm, date);
		fdc.formatDayOfMonth(fm, date);


	}

	public static void formatDateTime(Formatter fm, Object datetime){
		FormatterDateTimeConversion fdtc = FormatterDateTimeConversion.getInstance();

		fdtc.formatTime24Hour(fm, datetime);
		fdtc.formatTime24Hour2(fm, datetime);
		fdtc.formatTime12Hour(fm, datetime);
		fdtc.formatDate(fm, datetime);
		fdtc.formatDateISO(fm, datetime);
		fdtc.formatDateTimeISO(fm, datetime);

		

	}
}