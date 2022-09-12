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
import java.time.temporal.UnsupportedTemporalTypeException;
import static java.time.format.DateTimeFormatter.BASIC_ISO_DATE;
import static java.time.format.DateTimeFormatter.ISO_DATE;
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

		System.out.println("ld : " + ld);		
		System.out.println("lt : " + lt);		
		System.out.println("ldt : " + ldt);		
		System.out.println("odt : " + odt);		
		System.out.println("zdt : " + zdt);	

		// If the datetime object being formatted given in argument doesn't contains the component
		//  a UnsupportedTemporalTypeException is thrown
		try{
			String strResult = BASIC_ISO_DATE.format(LocalTime.now());
			System.out.println("BASIC_ISO_DATE.format(LocalTime.now()) : " + strResult );
		}catch(UnsupportedTemporalTypeException e){
			System.out.println("BASIC_ISO_DATE.format(LocalTime.now())  : " + e.getMessage() );
		}	


		/* BASIC_ISO_DATE
		* Format and parse a date withour using a separator
		* Ex: 20140612, 202203211256
		*/
		String strResult = BASIC_ISO_DATE.format(ld);
		System.out.println("BASIC_ISO_DATE.format(ld) : " + strResult );

		/* ISO_DATE
		* Format and parse a date using a separator (-)
		* Ex: 2014-06-12, 2022-03-21-12:56
		*/
		strResult  = ISO_DATE.format(ld);
		System.out.println("ISODATE.format(ld) : " + strResult );

		/* ISO_TIME
		* Format and parse a date using a separator (-)
		* Ex: 2014-06-12, 2022-03-21-12:56
		*/
		strResult  = ISO_TIME.format(lt);
		System.out.println("ISO_TIME.format(lt) : " + strResult );

		/* ISO_DATE_TIME
		* Format and parse a date using a separator (-)
		* Ex: 2014-06-12, 2022-03-21-12:56
		*/
		strResult  = ISO_DATE_TIME.format(ldt);
		System.out.println("ISO_DATE_TIME.format(ldt) : " + strResult );

		/* ISO_INSTANT
		* Format and parse a date using a separator (-)
		* Ex: 2014-06-12, 2022-03-21-12:56
		*/
		strResult  = ISO_INSTANT.format(zdt);
		System.out.println("ISO_INSTANT.format(ldt) : " + strResult );

		/* ISO_LOCAL_DATE
		* Format and parse a date without an offset using an ISO separator (-)
		* Ex: 2014-06-12, 2022-03-21-12:56
		*/
		strResult  = ISO_LOCAL_DATE.format(ld);
		System.out.println("ISO_LOCAL_DATE.format(ld) : " + strResult );

		/* ISO_LOCAL_TIME
		* Format and parse a time  without an offset using an ISO separator (-)
		* Ex: 2014-06-12, 2022-03-21-12:56
		*/
		strResult  = ISO_LOCAL_TIME.format(lt);
		System.out.println("ISO_LOCAL_TIME.format(lt) : " + strResult );

		/* ISO_LOCAL_DATE_TIME
		* Format and parse a datetime without an offset using an ISO separator (-)
		* Ex: 2014-06-12, 2022-03-21-12:56
		*/
		strResult  = ISO_LOCAL_DATE_TIME.format(ldt);
		System.out.println("ISO_LOCAL_DATE_TIME.format(ldt) : " + strResult );

		/* ISO_OFFSET_DATE
		* Format and parse a date with an offset using an ISO separator (-)
		* Ex: 2014-06-12, 2022-03-21-12:56
		*/
		strResult  = ISO_OFFSET_DATE.format(odt);
		System.out.println("ISO_OFFSET_DATE.format(odt) : " + strResult );

		/* ISO_OFFSET_TIME
		* Format and parse a time  with an offset using an ISO separator (-)
		* Ex: 2014-06-12, 2022-03-21-12:56
		*/
		strResult  = ISO_OFFSET_TIME.format(odt);
		System.out.println("ISO_OFFSET_TIME.format(odt) : " + strResult );

		/* ISO_OFFSET_DATE_TIME
		* Format and parse a datetime with an offset using a separator (-)
		* Ex: 2014-06-12, 2022-03-21-12:56
		*/
		strResult  = ISO_OFFSET_DATE_TIME.format(odt);
		System.out.println("ISO_OFFSET_DATE_TIME.format(odt) : " + strResult );

		/* ISO_ZONED_DATE_TIME
		* Format and parse a date with an offset and a zoneId( if available) using a separator (-)
		* Ex: 2014-06-12, 2022-03-21-12:56
		*/
		strResult  = ISO_ZONED_DATE_TIME.format(zdt);
		System.out.println("IISO_ZONED_DATE_TIME.format(zdt) : " + strResult );

		/* ISO_ORDINAL_DATE
		* Format and parse a date using a separator (-)
		* Ex: 2014-06-12, 2022-03-21-12:56
		*/
		strResult  = ISO_ORDINAL_DATE.format(ld);
		System.out.println("ISO_ORDINAL_DATE.format(ld) : " + strResult );

		/* ISO_WEEK_DATE
		* Format and parse a date using a separator (-)
		* Ex: 2014-06-12, 2022-03-21-12:56
		*/
		strResult = ISO_WEEK_DATE.format(ld);
		System.out.println("ISO_WEEK_DATE.format(ld) : " + strResult);

		/* RFC_1123_DATE_TIME
		* Format and parse a date using a separator (-)
		* Ex: 2014-06-12, 2022-03-21-12:56
		*/
		strResult = RFC_1123_DATE_TIME.format(zdt);
		System.out.println("RFC_1123_DATE_TIME.format(zdt) : " + strResult);

	}
	
}