package com.jdojo.datetime.scale.human;

import java.time.ZoneId;
import java.time.LocalDateTime;
import java.util.Set;


public class ZoneIdTest{
	public static void main(String[] args) {
		zoneIdClass();
	}

	public static void zoneIdClass(){
		/*
		* An instance of the ZoneId class represents a combinaison of a zone offset and the rules
		* for changing the zone offset for observed Daylight Savings Time.
		* Not all time zones observe the Daylight Savings Time.
		* 
		* A ZoneId represents a variable zone offset.
		* The variation, the time in the year when the zone offset is changed, and the amount of change,
		* are all controlled by the time zone rules.
		* ZoneOffset class inherits from ZoneId class.
		*
		* A time zone has a unique textual ID, which can be specified in 3 formats:
		*	- [+-]hh:mm:ss, [+-]hh:mm, [+-]hh
		*		Ex: +06:30:45, -12:00
		*	- [GMT|UTC|UT][+-]hh:mm, [GMT|UTC|UT][+-]hh:mm, [GMT|UTC|UT][+-]hh
		*		Ex: GMT+02:30, UTC-02:00, UT-08:30 
		*	- Region/Town
		*		Ex: Pacific/Apia, America/Los_Angeles, Europe/Paris, Australia/Darwin, 
		*/

		// Get all available ZoneId 
		Set<String> zoneIds = ZoneId.getAvailableZoneIds();

		System.out.println("Available zone ids: ");
		for(String zoneId: zoneIds){
			System.out.println(zoneId);
		}
		System.out.println("---------- End available zone ids ----------");

		LocalDateTime datetime = LocalDateTime.now();

		ZoneId euParis = ZoneId.of("Europe/Brussels");
		ZoneId usChicago = ZoneId.of("America/Chicago");
		ZoneId bdDhaka = ZoneId.of("Asia/Dhaka");
		ZoneId fixedZoneId = ZoneId.of("+06:00");
	}
}