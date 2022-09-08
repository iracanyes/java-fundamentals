/*
* PREDEFINED FORMATTERS
* Pre-defined formatters are defined as constants of DateTimeFormatter class.
* 
*/
package com.jdojo.datetime.formatter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.OffsetDateTime;
import static java.time.format.DateTimeFormatter.BASIC_ISO_DATE;
import static java.time.format.DateTimeFormatter.ISO_TIME;
import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;
import static java.time.format.DateTimeFormatter.ISO_INSTANT;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_TIME;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;
import static java.time.format.DateTimeFormatter.ISO_OFFSET_DATE;
import static java.time.format.DateTimeFormatter.ISO_OFFSET_TIME;
import static java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME;
import static java.time.format.DateTimeFormatter.ISO_ZONED_DATE_TIME;
import static java.time.format.DateTimeFormatter.ISO_ORDINAL_DATE;
import static java.time.format.DateTimeFormatter.ISO_WEEK_DATE;
import static java.time.format.DateTimeFormatter.RFC_1123_DATE_TIME;


public class PreDefinedFormatters{
	public static void main(String[] args) {
		LocalDate ld = LocalDate.now();
		LocalTime lt = LocalTime.now();
		LocalDateTime ldt = LocalDateTime.now();
		OffsetDateTime odt = OffsetDateTime.now();
		ZonedDateTime zdt = ZonedDateTime.now();		

		/* BASIC_ISO_DATE
		* Format and parse a date withour using a separator
		* Ex: 20140612, 202203211256
		*/
		String strResult = BASIC_ISO_DATE.format(lt);
		System.out.println("BASIC_ISO_DATE.format(lt) : " + ldBasicStr);

		/* ISO_DATE
		* Format and parse a date using a separator (-)
		* Ex: 2014-06-12, 2022-03-21-12:56
		*/
		strResult  = ISO_DATE.format(ld);
		System.out.println("ISODATE.format(LocalDate.now()) : "+ strResult );

		/* ISO_TIME
		* Format and parse a date using a separator (-)
		* Ex: 2014-06-12, 2022-03-21-12:56
		*/
		strResult  = ISO_TIME.format(lt);
		System.out.println("ISO_TIME.format(lt) : "+ strResult );

		/* ISO_DATE_TIME
		* Format and parse a date using a separator (-)
		* Ex: 2014-06-12, 2022-03-21-12:56
		*/
		strResult  = ISO_DATE_TIME.format(ldt);
		System.out.println("ISO_DATE_TIME.format(ldt) : "+ strResult );

		/* ISO_OFFSET_DATE
		* Format and parse a date using a separator (-)
		* Ex: 2014-06-12, 2022-03-21-12:56
		*/
		strResult  = ISO_OFFSET_DATE.format(odt);
		System.out.println("ISO_OFFSET_DATE.format(odt) : "+ strResult );

		/* ISO_OFFSET_TIME
		* Format and parse a date using a separator (-)
		* Ex: 2014-06-12, 2022-03-21-12:56
		*/
		strResult  = ISO_OFFSET_TIME.format(odt);
		System.out.println("ISO_OFFSET_TIME.format(odt) : "+ strResult );

		/* ISO_OFFSET_DATE_TIME
		* Format and parse a date using a separator (-)
		* Ex: 2014-06-12, 2022-03-21-12:56
		*/
		strResult  = ISO_OFFSET_DATE_TIME.format(odt);
		System.out.println("ISO_OFFSET_DATE_TIME.format(odt) : "+ strResult );

		/* ISO_ZONED_DATE_TIME
		* Format and parse a date using a separator (-)
		* Ex: 2014-06-12, 2022-03-21-12:56
		*/
		strResult  = ISO_ZONED_DATE_TIME.format(zdt);
		System.out.println("IISO_ZONED_DATE_TIME.format(zdt) : "+ strResult );

		/* ISO_ORDINAL_DATE
		* Format and parse a date using a separator (-)
		* Ex: 2014-06-12, 2022-03-21-12:56
		*/
		strResult  = ISO_ORDINAL_DATE.format(ld);
		System.out.println("ISO_ORDINAL_DATE.format(ld) : ": strResult );

		/* ISO_WEEK_DATE
		* Format and parse a date using a separator (-)
		* Ex: 2014-06-12, 2022-03-21-12:56
		*/
		String ldStr = ISO_WEEK_DATE.format(ld);
		System.out.println("ISO_WEEK_DATE.format(ld) : ": ldStr);

		/* RFC_1123_DATE_TIME
		* Format and parse a date using a separator (-)
		* Ex: 2014-06-12, 2022-03-21-12:56
		*/
		String ldStr = RFC_1123_DATE_TIME.format(zdt);
		System.out.println("RFC_1123_DATE_TIME.format(zdt) : ": ldStr);

	}
	
}