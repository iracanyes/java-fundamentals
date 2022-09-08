package com.jdojo.string;

public class StringAndSwitchStatement{
	public static void main(String[] args) {
		stringInSwitchStatement("On");
		stringInSwitchStatement("Off");
		stringInSwitchStatement("ON");
		stringInSwitchStatement("OFF");
		stringInSwitchStatement("on");
		stringInSwitchStatement("off");
	}

	public static void stringInSwitchStatement(String status){
		/*
		* The switch expression uses a String type.
		* If the switch expression is null, a NullPointerException is thrown.
		* The case labels expression MUST be String literals.
		* You cannot use String variable in case labels.
		*
		* The "switch" statement for strings compares the switch expression with case labels 
		* with case-sensitive.
		*
		* Before using switch statement with String, you need to checks:
		*	- switch expression is null. Do not execute the switch statement.
		*	- Do to a case insensitive comparison in a switch statement,
				you need to convert the switch expression to lowercase or uppercase
		*/
		if(status == null){
			System.out.println("Status cannot be null");
			return;
		}

		switch(status){
			case "on":
				System.out.println("Status : Turn on");
				break; 
			case "off":
				System.out.println("Status : Turn off");
				break;	
			case "On":
				System.out.println("Status : Turn On");
				break;
			case "Off":
				System.out.println("Status : Turn Off");
				break;
			default:
				System.out.println("Unknown status");
				break;
		}

		switch(status.toLowerCase()){
			case "on":
				System.out.println("Status to Lowercase : Turn On");
				break;
			case "off":
				System.out.println("Status to Lowercase : Turn On");
				break;
			default:
				System.out.println("Unknown status to toLowerCase");
				break;
		}
	}
}
