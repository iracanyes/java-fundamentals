/*
* An instant is a point representing a unique moment in time on the timeline.
* An epoch is an instant on a timeline that is used as a reference point (or the origin)
* to measure other instants.
* 				
* <------------------------------------------------------------------> Timeline
*		|	|	|	|	|	|	|	|	|	|	|	|	|	|	|
*		-6	-5	-4	-3	-2	-1	0	1 	2 	3 	4 	5 	6
*			|					|						
*		 Instant			  Epoch (01-01-1970 00:00:00)
*
* An object of the Instant class represents an instant on the timeline.
* It uses a timeline to represent simplified UTC to a nanosecond precision.
* The time interval (or duration) between 2 consecutive instants on timeline is one nanosecond.
* Instant after epoch have positive value and instants before have negative values.
* Instant at the epoch is assigned a zero value.
*
* Classes like Duration and Instant are more suited to dealing with
* machine-scale time.
*/
package com.jdojo.datetime.scale.machine;

import java.time.Instant;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class DurationsAndInstants{
	public static void main(String[] args) {
		instantsAndDurations();
		divideDurationByDuration();
		toXxxMethods();
		truncateDuration();
	}

	public static void instantsAndDurations(){
		// Get the current instant
		Instant i1 = Instant.now();


		// An instant: 200000 seconds from the epoch
		Instant i2 = Instant.ofEpochSecond(200000);

		// A duration of 2 days
		Duration d1 = Duration.ofDays(-17);

		// A duration of 25 minutes
		Duration d2 = Duration.ofMinutes(25);

		/*
		* toString() method of the Instant class returns a textual representation fo the Instant in 
		* the ISO-8601 format 
		*	yyyy-MM-ddTHH:mm:ss.SSSSSSSZ
		*/
		System.out.println("Instant now : " + i1);
		System.out.println("Instant.ofEpochSecond(200000) : " + i2);

		/*
		* toString() method of the Duration returns a string representation of the Duration
		* 	Ex: PT-17S, PT1M38S
		*/

		long seconds = i1.getEpochSecond();
		int nanoSeconds = i1.getNano();
		System.out.println("i1.getEpochSecond() : " + seconds);
		System.out.println("i1.getNano() : " + nanoSeconds);

		// Compare instants
		System.out.println("i1.isBefore(i2) : " + i1.isBefore(i2));

		// Add and subtract durations to instants
		Instant i3 = i1.plus(d2);
		Instant i4 = i1.minus(d1); 
		System.out.println("i1.plus(d2) : " + i3);
		System.out.println("i1.minus(d1) : " + i4);

		// Add and subtract durations
		Duration d3 = d1.plus(d2);
		System.out.println("d1.plus(d2) : " + d3);
	}

	public static void divideDurationByDuration(){
		// Create a duration of 23 days, 3 hours, 45 minutes, and 30 second
		Duration compTime = Duration.ofDays(23)
									.plusHours(2)
									.plusMinutes(45)
									.plusSeconds(30);
		/*
		* long dividedBy(Duration divisor)
		* The dividedBy() method lets you divide a duration by another duration.
		* It returns the number of times the specific divisor occurs within the duration 
		* on which the method is called.
		*
		*
		*/
		long wholeDays = compTime.dividedBy(Duration.ofDays(1));
		long wholeWeeks = compTime.dividedBy(Duration.ofDays(7));
		long wholeHours = compTime.dividedBy(Duration.ofHours(1));

		System.out.println("compTime.dividedBy(Duration.ofDays(1) : " + wholeDays);
	}

	public static void toXxxMethods(){
		// Create a duration of 23 days, 3 hours, 45 minutes, and 30 second
		Duration compTime = Duration.ofDays(23)
									.plusHours(2)
									.plusMinutes(45)
									.plusSeconds(30);
		/*
		* Duration and Instant class contains 2 sets of methods:
		*	- toXxx()
		*	- toXxxPart()
		* Where Xxxx can be Days, Hours, Minutes, Second, Millis, Nanos.
		* toXxx() method convert the duration to the Xxx time unit
		*/
		System.out.println("toXxxMethods\nDuration: " + compTime);
		System.out.println("toDays() : " + compTime.toDays());
		System.out.println("toHours() : " + compTime.toHours());
		System.out.println("toMinutes() : " + compTime.toMinutes());
		System.out.println("toSeconds() : " + compTime.toSeconds());
		System.out.println("toMillis() : " + compTime.toMillis());
		System.out.println("toNanos() : " + compTime.toNanos());
	}

	public static void truncateDuration(){
		/*
		* Duration truncatedTo(TemporalUnit unit)
		* Returns a copy of the duration with the conceptual time units smaller than the specified unit truncated.
		* The temporal unit specified must be DAYS or smaller.
		* Specifying a temporal unit greater than DAYS such as WEEKS and YEARS throw a runtime exception.
		*
		*/
		// Create a duration of 23 days, 3 hours, 45 minutes, and 30 second
		Duration compTime = Duration.ofDays(32)
									.plusHours(23)
									.plusMinutes(45)
									.plusSeconds(30);
		System.out.println("Duration before truncate : " + compTime);
		// truncatedTo(ChronoUnit.DAYS) 
		//Returns the number of complete days in hours.
		System.out.println("Truncated to days : " + compTime.truncatedTo(ChronoUnit.DAYS));
		// truncatedTo(ChronoUnit.HOURS) 
		//Returns the number of complete hours in the duration.
		System.out.println("Truncated to hours : " + compTime.truncatedTo(ChronoUnit.HOURS));
		// truncatedTo(ChronoUnit.HOURS) 
		//Returns the number of complete minutes in the duration.
		System.out.println("Truncated to minutes : " + compTime.truncatedTo(ChronoUnit.MINUTES));
	}


}