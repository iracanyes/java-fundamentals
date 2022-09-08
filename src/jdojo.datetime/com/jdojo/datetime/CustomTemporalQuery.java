/*
* CREATING A CUSTOM TEMPORAL QUERY
* You can create a custom query in 2 ways:
*	- Create a class that implements the TemporalQuery interface and use instance of the class as a query
*	- Use any method reference as a query. The method should take a TemporalAccessor and return an object.
*	 	The return type of the method defines the result type for the query!
*/
package com.jdojo.datetime;

import java.time.DayOfWeek;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;
import static java.time.temporal.ChronoField.DAY_OF_MONTH; 
import static java.time.temporal.ChronoField.DAY_OF_WEEK;
import static java.time.DayOfWeek.FRIDAY;

public class CustomTemporalQuery implements TemporalQuery<Boolean>{
	public final static CustomTemporalQuery IS_FRIDAY_13 = new CustomTemporalQuery();

	// Prevent outside code from creating object of this class
	private CustomTemporalQuery(){

	}

	@Override
	public Boolean queryFrom(TemporalAccessor temporal){
		if(temporal.isSupported(DAY_OF_MONTH) && temporal.isSupported(DAY_OF_WEEK)){
			int dayOfMonth = temporal.get(DAY_OF_MONTH);
			int weekDay = temporal.get(DAY_OF_WEEK);

			DayOfWeek dayOfWeek = DayOfWeek.of(weekDay);

			if(dayOfMonth == 13 && dayOfWeek == FRIDAY){
				return Boolean.TRUE;
			}
		}

		return Boolean.FALSE;
	}
}
