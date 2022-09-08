/*
* Date-Time API provides classes for non-ISO standard calendar (non-Gregorian calendar) system such as:
* Package java.time.chrono contains all classes for non-ISO calendar.
*	- Thai Buddhist calendar
*	- Hijrah calendar
*	- Minguo calendar
*	- Japanese calendar
*
* There is an XxxChronology and XxxDate class for each of the available non-ISO calendar system;
* The XxxChronology class represents the Xxx calendar system where Xxx is the name of calendar system.
* The XxxDate class represents a date in the Xxx calendar system.
*
* Each XxxChronology contains a constant INSTANCE which represents a singleton instance of the class.
* Ex: HijrahChronology
*/
package com.jdojo.datetime;

import java.time.LocalDate;
import java.time.chrono.ThaiBuddhistChronology;
import java.time.chrono.ThaiBuddhistDate;
import java.time.chrono.HijrahChronology;
import java.time.chrono.HijrahDate;
import java.time.chrono.MinguoChronology;
import java.time.chrono.MinguoDate;
import java.time.chrono.JapaneseChronology;
import java.time.chrono.JapaneseDate;

public class NonISOCalendarSystems{
	public static void main(String[] args) {
		thaiBuddistCalendar();
		hijrahCalendar();
		minguoCalendar();
		japaneseCalendar();
	}

	public static void thaiBuddistCalendar(){
		// Get a singleton instance of thai calendar
		ThaiBuddhistChronology thaiChrono = ThaiBuddhistChronology.INSTANCE;
		
		ThaiBuddhistDate thaiChronoNow = thaiChrono.dateNow();
		
		// Create a Thai Buddist date now
		ThaiBuddhistDate thaiNow = ThaiBuddhistDate.now();
		
		// Create a ISO standard date now
		LocalDate isoNow = LocalDate.now();

		// Convert Thai Calendar date to ISO date
		LocalDate isoFromThai = LocalDate.from(thaiNow);

		System.out.println("Current time ISO : " + isoNow);
		System.out.println("Current time Thai Budddist date : " + thaiNow);
		System.out.println("Current time Thai Budddist date from calendar : " + thaiChronoNow);
		System.out.println("Thai Buddhist date to ISO date : " + isoFromThai);
	}

	public static void hijrahCalendar(){
		// Get a singleton instance of hijrah calendar
		HijrahChronology hijrahChrono = HijrahChronology.INSTANCE;
		
		HijrahDate hijrahChronoNow = hijrahChrono.dateNow();
		
		// Create a hijrah Buddist date now
		HijrahDate hijrahNow = HijrahDate.now();

		// Convert Hijrah Calendar date to ISO date
		LocalDate isoFromHijrah = LocalDate.from(hijrahNow);
		
		// Create a ISO standard date now
		LocalDate isoNow = LocalDate.now();

		System.out.println("Current time ISO : " + isoNow);
		System.out.println("Current time Hijrah Budddist date : " + hijrahNow);
		System.out.println("Current time Hijrah Budddist date from calendar : " + hijrahChronoNow);
		System.out.println("Hijrah date to ISO date : " + isoFromHijrah);

	}

	public static void minguoCalendar(){
		// Get a singleton instance of Minguo calendar
		MinguoChronology minguoChrono = MinguoChronology.INSTANCE;
		
		MinguoDate minguoChronoNow = minguoChrono.dateNow();
		
		// Create a Minguo Buddist date now
		MinguoDate minguoNow = MinguoDate.now();
		
		// Create a ISO standard date now
		LocalDate isoNow = LocalDate.now();

		// Convert Minguo Calendar date to ISO date
		LocalDate isoFromMinguo = LocalDate.from(minguoNow);

		System.out.println("Current time ISO : " + isoNow);
		System.out.println("Current time Minguo Budddist date : " + minguoNow);
		System.out.println("Current time Minguo Budddist date from calendar : " + minguoChronoNow);
		System.out.println("Minguo date to ISO date : " + isoFromMinguo);
	}

	public static void japaneseCalendar(){
		// Get a singleton instance of japanese calendar
		JapaneseChronology japaneseChrono = JapaneseChronology.INSTANCE;
		
		JapaneseDate japaneseChronoNow = japaneseChrono.dateNow();
		
		// Create a Japanese Buddist date now
		JapaneseDate japaneseNow = JapaneseDate.now();
		
		// Create a ISO standard date now
		LocalDate isoNow = LocalDate.now();

		// Convert Japanese Calendar date to ISO date
		LocalDate isoFromJapanese = LocalDate.from(japaneseNow);


		System.out.println("Current time ISO : " + isoNow);
		System.out.println("Current time Japanese Budddist date : " + japaneseNow);
		System.out.println("Current time Japanese Budddist date from calendar : " + japaneseChronoNow);
		System.out.println("Japanese date to ISO date : " + isoFromJapanese);
	}
}