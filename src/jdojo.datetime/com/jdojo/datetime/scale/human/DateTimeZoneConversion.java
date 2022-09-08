/*
* Converting the ZoneId of a ZonedDateTime  to another ZoneId
*/
package com.jdojo.datetime.scale.human;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.zone.ZoneRulesException;

public class DateTimeZoneConversion{
	public static void main(String[] args) {
		LocalDateTime ldt = LocalDateTime.of(2021, Month.MAY, 22,14,52);

		ZoneId euParis = ZoneId.of("Europe/Paris");
		ZonedDateTime zdt = ZonedDateTime.of(ldt, euParis);
		System.out.println("In Europe Paris time zone : " + zdt);

		ZoneId utc = ZoneId.of("Z");
		ZonedDateTime zdt1 = zdt.withZoneSameInstant(utc);
		System.out.println("In UTC Time Zone : " + zdt1);

		
		try{
			ZoneId asiaKolKata = ZoneId.of("Asia/Kolkata");
			// Conversion to another time zone
			ZonedDateTime zdt3 = zdt.withZoneSameInstant(asiaKolKata);
			System.out.println("In Asia Kolkata Time Zone : " + zdt3);
		}catch(ZoneRulesException e){
			System.out.println("Exception while Convertion to Asia Kolkata");
			e.printStackTrace();
		}

		try{
			// ZoneRulesException: Unknown time-zone ID: America/Chicaga
			//ZoneId usChicago = ZoneId.of("America/Chicaga");

			ZoneId usChicago = ZoneId.of("America/Chicago");

			// Conversion to another time zone
			ZonedDateTime zdt4 = zdt.withZoneSameInstant(usChicago);
			System.out.println("In Asia Kolkata Time Zone : " + zdt4);
		}catch(ZoneRulesException e){
			System.out.println("Exception while Convertion to America Chicago");
			e.printStackTrace();
		}

	}
}
