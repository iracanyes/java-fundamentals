package com.jdojo.datetime.scale.human;

import java.time.ZoneOffset;

public class ZoneOffsetTest{
	public static void main(String[] args) {
		zoneOffsetClass();
	}

	public static void zoneOffsetClass(){
		/*
		* An instance of ZoneOffset class represents a fixed zone offset from UTC time zone.
		* Ex: +05:30,-06:00
		* It's a period of time that a time zone differs from UTC.
		* A ZoneOffset is not aware of the changes in zone offset because of the observed Daylight Savings Time.
		*
		*/
		// ZoneOffset constants
		// Time zone constant for UTC
		System.out.println("ZoneOffset.UTC: " + ZoneOffset.UTC);
		// Max zone offset: +18:00. ISO-8601  is +14h:00
		System.out.println("ZoneOffset.MAX : " + ZoneOffset.MAX);
		// Min zone offset: -18:00. But for now ISO-8601 is -12:00
		System.out.println("ZoneOffset.MIN : " + ZoneOffset.MIN);

		/*
		* ZoneOffset provides methods to create its instances using a combination 
		* of hours, minutes, and second.
		*/
		// Create a zone offset from hours (-06:00)
		ZoneOffset zofs1 = ZoneOffset.ofHours(-6);
		ZoneOffset zofs2 = ZoneOffset.ofHoursMinutes(5,30);
		/*
		* ISO-8601 standards allow only hours and minutes for representing zone offset.
		* But Date-Time API provides 
		*/
		ZoneOffset zofs3 = ZoneOffset.ofHoursMinutesSeconds(8, 30, 45);

		System.out.println("1. ZoneOffset.ofHours(-6) : " + zofs1);
		System.out.println("2. ZoneOffset.ofHoursMinutes(5,30) : " + zofs2);
		System.out.println("3. ZoneOffset.ofHoursMinutesSeconds(8, 30, 45) : " + zofs3);

		ZoneOffset zofs4 = ZoneOffset.of("-08:00");
		ZoneOffset zofs5 = ZoneOffset.of("Z");

		System.out.println("4. ZoneOffset.of(\"-08:00\") : " + zofs4);
		System.out.println("5. ZoneOffset.of(\"Z\") : " + zofs5);

		System.out.println("zofs2.compareTo(zofs3) : " + zofs2.compareTo(zofs3));
		System.out.println("zofs5.compareTo(zofs1) : " + zofs5.compareTo(zofs1));
	}
}