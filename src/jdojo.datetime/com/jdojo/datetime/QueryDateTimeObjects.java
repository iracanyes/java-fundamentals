/*
* QUERYING DATETIME OBJECTS
* All datetime classes support queries.
* A query is a request for information
* You can obtain the components of a datetime object.
* Ex: the year of a LocalDate using the get(TemporalField) method
* of the datetime object
* 
* An instance of TemporalQuery<R> interface represents a query.
* All datetime classes provides a query() method which takes a TemporalQuery as params
* and return a result.
*
* TemporalQueries is a utility class that provides many predefined queries as static methods.
* If a datetime object doesn't provides the information requested, the query returns null.
* Chronology is an interface that is used to identify and manipulate dates in a calendar system.
*
* Here are some methods provided by TemporalQueries class
*	- TemporalQuery<Chronology> chronology() 	: A query to get the chronology
*	- TemporalQuery<LocalDate> localDate() 		: A query to get the LocalDate
*	- TemporalQuery<LocalTime> localTime() 		: A query to get the LocalTime
*	- TemporalQuery<ZoneOffset> offset() 		: A query to get the ZoneOffset
*	- TemporalQuery<TemporalUnit> precision()	: A query to get the smallest supported unit
*	- TemporalQuery<ZoneId> zone()				: A query to get the ZoneId. If the ZoneId is not found, it returns ZoneOffset, or null otherwise.
*	- TemporalQuery<ZoneId>	zoneId()			: A query to get the ZoneId. If not found it returns null.
*
*/
package com.jdojo.datetime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.ZoneOffset;
import java.time.ZoneId;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;
import java.time.temporal.TemporalUnit;

public class QueryDateTimeObjects{
	public static void main(String[] args) {
		// Get references of the precision and local date queries
		TemporalQuery<TemporalUnit> precisionQuery = TemporalQueries.precision();
		TemporalQuery<LocalDate> localDateQuery = TemporalQueries.localDate();
		TemporalQuery<LocalTime> localTimeQuery = TemporalQueries.localTime();
		TemporalQuery<ZoneOffset> offsetQuery = TemporalQueries.offset();
		TemporalQuery<ZoneId> zoneQuery = TemporalQueries.zone();
		TemporalQuery<ZoneId> zoneIdQuery = TemporalQueries.zoneId();
		/*
		* Query on a LocalDate
		*/
		LocalDate ld = LocalDate.now();
		// Query LocalDate from LocalDate
		LocalDate queryDate = ld.query(localDateQuery);
		System.out.println("LocalDate of LocalDate : " + ld);

		// Query the precision of LocalDate
		TemporalUnit precision = ld.query(precisionQuery);
		System.out.println("Precision of LocalDate : " + precision);
		
		// Query using custom query IS_FRIDAY_13
		Boolean ldIsFriday13 = ld.query(CustomTemporalQuery.IS_FRIDAY_13);
		System.out.println("CustomTemporalQuery.IS_FRIDAY_13 of LocalDate : " + ldIsFriday13);

		// Query using CustomQueries::isFriday13
		ldIsFriday13 = ld.query(CustomQueries::isFriday13);
		System.out.println("CustomQueries::isFriday13 of LocalDate : " + precision);



		/*
		* Query on a LocalTime
		*/
		LocalTime lt = LocalTime.now();
		// Query the LocalTime precision
		precision = lt.query(precisionQuery);
		// Query the LocalDate from LocalTime returns null as it's not provided by LocalTime
		queryDate = lt.query(localDateQuery);

		// Query using custom query IS_FRIDAY_13
		Boolean ltIsFriday13 = lt.query(CustomTemporalQuery.IS_FRIDAY_13);
		System.out.println("CustomTemporalQuery.IS_FRIDAY_13 of LocalTime : " + ltIsFriday13);

		// Query using CustomQueries::isFriday13
		ltIsFriday13 = lt.query(CustomQueries::isFriday13);
		System.out.println("CustomQueries::isFriday13 of LocalTime : " + ltIsFriday13);

		System.out.println("LocalTime now : " + lt);
		System.out.println("Precision of LocalTime : " + precision);
		System.out.println("LocalDate from LocalTime  :" + queryDate);

		/*
		* Query on a ZonedDateTime
		*/
		ZonedDateTime zdt = ZonedDateTime.now();
		
		// Query the ZonedDateTime precision
		precision = zdt.query(precisionQuery);
		
		// Query the LocalDate from ZonedDateTime
		queryDate = zdt.query(localDateQuery);
		
		// Query the LocalTime from ZonedDateTime
		LocalTime queryTime = zdt.query(localTimeQuery);
		
		// Query the ZoneOffset from ZonedDateTime
		ZoneOffset queryOffset = zdt.query(offsetQuery);

		// Query the ZoneId/ZoneOffset
		ZoneId queryZone = zdt.query(zoneQuery);

		// Query the ZoneId 
		ZoneId queryZoneId = zdt.query(zoneIdQuery);

		// Query using custom query IS_FRIDAY_13
		Boolean isFriday13 = zdt.query(CustomTemporalQuery.IS_FRIDAY_13);

		// Query using CustomQueries::isFriday13
		isFriday13 = zdt.query(CustomQueries::isFriday13);

		System.out.println("ZonedDateTime now : " + lt);
		System.out.println("Precision of ZonedDateTime : " + precision);
		System.out.println("LocalDate from ZonedDateTime  :" + queryDate);
		System.out.println("LocalTime from ZonedDateTime  :" + queryTime);
		System.out.println("ZoneOffset from ZonedDateTime  :" + queryOffset);
		System.out.println("ZoneId or ZoneOffset from ZonedDateTime  :" + queryZone);
		System.out.println("ZoneId from ZonedDateTime  :" + queryZoneId);

	}
}
