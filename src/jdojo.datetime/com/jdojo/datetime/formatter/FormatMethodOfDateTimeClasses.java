package com.jdojo.datetime.formatter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.OffsetDateTime;
import java.time.Instant;
import com.jdojo.datetime.formatter.PreDefinedFormatters;
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

public class FormatMethodOfDateTimeClasses{
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
			String strResult = ld.format(BASIC_ISO_DATE);
			System.out.println("lt.format(BASIC_ISO_DATE) : " + strResult );
		}catch(UnsupportedTemporalTypeException e){
			System.out.println("lt.format(BASIC_ISO_DATE)  : " + e.getMessage() );
		}	


		/* LocalDate.format(BASIC_ISO_DATE)
		* Format and parse a date without using a separator
		* Ex: 20140612, 202203211256
		*/
		String strResult = ld.format(BASIC_ISO_DATE);
		System.out.println("ld.format(BASIC_ISO_DATE) : " + strResult );

		/* LocalDate.format(ISO_DATE)
		* Format and parse a date using a separator (-)
		* Ex: 2014-06-12, 2022-03
		*/
		strResult  = ld.format(ISO_DATE);
		System.out.println("ld.format(ISO_DATE) : " + strResult );

		/* LocalTime.format(ISO_TIME)
		* Format and parse a date using a separator (-)
		* Ex: 20:24:56.568, 12:56
		*/
		strResult  = lt.format(ISO_TIME);
		System.out.println("lt.format(ISO_TIME) : " + strResult );

		/* LocalDateTime.format(ISO_DATE_TIME)
		* Format and parse a date using a separator (-)
		* Ex: 2014-06-12, 2022-03-21-12:56
		*/
		strResult  = ldt.format(ISO_DATE_TIME);
		System.out.println("ldt.format(ISO_DATE_TIME) : " + strResult );

		/* ZonedDateTime.format(ISO_INSTANT)
		* Format and parse a datetime object representing an instant (like ZonedDateTime) 
		* using an ISO separator (-)
		* Ex: 2022-03-21T12:56:36:870Z
		*/
		strResult  = zdt.format(ISO_INSTANT);
		System.out.println("zdt.format(ISO_INSTANT) : " + strResult );

		/* OffsetDateTime.format(ISO_OFFSET_DATE)
		* Format and parse a date using a separator (-)
		* Ex: 2014-06-12, 2022-03-21-12:56
		*/
		strResult  = odt.format(ISO_OFFSET_DATE);
		System.out.println("odt.format(ISO_OFFSET_DATE) : " + strResult );

		/* OffsetDateTime.format(ISO_OFFSET_TIME)
		* Format and parse a date using a separator (-)
		* Ex: 2014-06-12, 2022-03-21-12:56
		*/
		strResult  = odt.format(ISO_OFFSET_TIME);
		System.out.println("odt.format(ISO_OFFSET_TIME) : " + strResult );

		/* ISO_OFFSET_DATE_TIME
		* Format and parse a date using a separator (-)
		* Ex: 2014-06-12, 2022-03-21-12:56
		*/
		strResult  = odt.format(ISO_OFFSET_DATE_TIME);
		System.out.println("odt.format(ISO_OFFSET_DATE_TIME) : " + strResult );

		/* ISO_ZONED_DATE_TIME
		* Format and parse a date using a separator (-)
		* Ex: 2014-06-12, 2022-03-21-12:56
		*/
		strResult  = zdt.format(ISO_ZONED_DATE_TIME);
		System.out.println("zdt.format(ISO_ZONED_DATE_TIME) : " + strResult );

		/* LocalDate.format(ISO_ORDINAL_DATE)
		* Format and parse a date using a separator (-)
		* Ex: 2014-06-12, 2022-03-21-12:56
		*/
		strResult  = ld.format(ISO_ORDINAL_DATE);
		System.out.println("ld.format(ISO_ORDINAL_DATE) : " + strResult );

		/* ISO_WEEK_DATE
		* Format and parse a date using a separator (-)
		* Ex: 2014-06-12, 2022-03-21-12:56
		*/
		strResult = ld.format(ISO_WEEK_DATE);
		System.out.println("ld.format(ISO_WEEK_DATE) : " + strResult);

		/* RFC_1123_DATE_TIME
		* Format and parse a date using a separator (-)
		* Ex: 2014-06-12, 2022-03-21-12:56
		*/
		strResult = zdt.format(RFC_1123_DATE_TIME);
		System.out.println("zdt.format(RFC_1123_DATE_TIME) : " + strResult);

	}
}