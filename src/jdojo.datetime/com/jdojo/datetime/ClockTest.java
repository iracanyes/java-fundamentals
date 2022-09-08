/*
* The Clock class is an abstraction for the real-world clock.
* It provides access to the current instant, date, and time in a time zone.
*/
package com.jdojo.datetime;

import java.time.Clock;
import java.time.ZoneId;
import java.time.Instant;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.LocalDate;

public class ClockTest{
	public static void main(String[] args) {
		// Get a clock for the system default time zone
		Clock clock = Clock.systemDefaultZone();

		// Get a clock for a specific time zone
		ZoneId usChicago = ZoneId.of("America/Chicago");

		// Create a clock from ZoneId
		Clock clock2 = Clock.system(usChicago);

		// Get system default clock
		Clock sysClock = Clock.systemDefaultZone();

		// Get system default zone
		ZoneId sysZone = Clock.systemDefaultZone().getZone();

		// Get the current instant of the clock
		Instant instant1 = clock.instant();

		// now() use the system default clock for the default time zone
		// Instant.now() is equivalent to Instant.now(Clock.systemDefaultZone())
		// LocalDate.now() is equivalent to LocalDate.now(Clock.systemDefaultZone())
		// ZonedDateTime.now() is equivalent to ZonedDateTime.now(Clock.systemDefaultZone())

		// Get the current instant using clock and the Instant class		
		Instant instant2 = Instant.now(clock);

		// Get locald date using the clock
		LocalDate ld1 = LocalDate.now(clock);

		// Get the zoned datetime using the clock
		ZonedDateTime zdt = ZonedDateTime.now(clock);

		System.out.println("UTC clock : " + getUTCClock().instant());
		System.out.println("Fixed clock : " + getFixedClock().instant());
		System.out.println("Clock tick 1 millisecond : " + getManipulatedClockTick().instant());
		System.out.println("Clock tick 1 millisecond : " + getManipulatedClockTick().instant());
		System.out.println("Clock tick 1 millisecond : " + getManipulatedClockTick().instant());
	}

	public static Clock getUTCClock(){
		/*
		* Clock class provides a method systemUTC() which returns a clock for the UTC time zone.
		*
		*/
		Clock clock = Clock.systemUTC();

		return clock;
	}

	public static Clock getFixedClock(){
		/*
		* Fixed clock are useful for testing purposes,
		* when you want a clock to return the same time 
		*/
		ZoneId zone = ZoneId.of("Asia/Shanghai");		

		// Create a fixed ZonedDateTime
		ZonedDateTime zdt = ZonedDateTime.of(1920,12,14,15,47,58,79856, zone);
		Instant i1 = zdt.toInstant();
		Clock fixedClock = Clock.fixed(i1, zone);

		return fixedClock;

	}

	
	public static Clock getManipulatedClockTick(){
		/*
		* tick() method lets you specify the granularity of the tick in the form of a Duration.
		* The clock returned by this method uses the clock specified as the first argument;
		* the returned clock tick in the specified duration as argument.
		* Signature: 
		*	static Clock tick(Clock baseClock, Duration tickDuration)
		*	static Clock tickMillis(ZoneId zone)
		*	static Clock tickMinutes(ZoneId zone)
		*	static Clock tickSeconds(ZoneId zone)
		*/

		// Here we create a clock that tick every 1 millisecond
		// Equals to : Clock.tickMillis(Clock.systemDefaultZone().getZone())
		Clock clock = Clock.tick(Clock.systemDefaultZone(), Duration.ofMillis(1));

		return clock;
	}
}