package com.jdojo.datetime.scale.human;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.LocalDateTime;
import java.time.zone.ZoneRules;
import java.time.zone.ZoneOffsetTransition;
import java.util.List;

public class ZoneRulesTest{
	public static void main(String[] args) {
		LocalDateTime date = LocalDateTime.now();
		ZoneId euParis = ZoneId.of("Europe/Brussels");
		ZoneId usChicago = ZoneId.of("America/Chicago");
		ZoneId bdDhaka = ZoneId.of("Asia/Dhaka");
		ZoneId fixedZoneId = ZoneId.of("+06:00");

		zoneRulesDetails(euParis, date);
		zoneRulesDetails(usChicago, date);
		zoneRulesDetails(bdDhaka, date);
		zoneRulesDetails(fixedZoneId, date);
	}

	public static void zoneRulesDetails(ZoneId zoneId, LocalDateTime date){
		/*
		* ZoneId object gives you access to zone rules for the time zone.
		* getRules() method of the ZoneId class to 
		*/
		System.out.println("Zone ID : " + zoneId.getId());

		ZoneRules rules = zoneId.getRules();
		boolean isFixedOffset = rules.isFixedOffset();
		System.out.println("rules.isFixedOffset() : " + isFixedOffset); 

		ZoneOffset offset = rules.getOffset(date);

		List<ZoneOffsetTransition> transitions = rules.getTransitions();
		System.out.println(transitions);
	}
}