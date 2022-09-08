/*
* Human scale time works with fields like year, month, day, hour, minutes, and second.
* ISO-8601 format : [date]T[time][zone_offset]
* Date-Time API provides multiple classes to works with such fields:
*	- LocalDate, LocalTime, LocalDateTime
*	- OffsetTime, OffsetDateTime
*	- ZonedDateTime, ZoneOffset, ZoneId
*/
package com.jdojo.datetime.scale.human;


public class HumanScaleTime{
	public static void main(String[] args) {
		ZoneOffsetTest.main(new String[5]);
		ZoneIdTest.main(new String[5]);
		ZoneRulesTest.main(new String[5]);
	}


}