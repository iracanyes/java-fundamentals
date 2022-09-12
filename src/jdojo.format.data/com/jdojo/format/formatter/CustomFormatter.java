/*
* Formatter class supports custom formatter through s (string) ans S (string to uppercase) conversions.
* If the argument implements java.util.Formattable interface, 
* the s conversion calls the format() method on the argument to get the formatted output.
* 
* formatTo() method is passed the following references:
*	- an instance of the Formatter class
*	- integer object representing the flag
*	- integer object representing the width
*	- integer object representing the precision 
*
* Flags are passed in as an int as BITMASK.
* To check if a flag was passed, you use the bitwise operator &.
* The operands to be used in the bitwise & operation are defined by constant in java.util.FormattableFlags
*
* Here is a class which implements Formattable interface.
* We define custom way to format the string represention of all instance of this class. 
*/
package com.jdojo.format.formatter;

import java.util.Formattable;
import java.util.Formatter;
import java.util.FormattableFlags;

public class CustomFormatter implements Formattable {
	private String firstName = "Unknown";
	private String lastName = "Unknown";

	public CustomFormatter(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstname(){
		return this.firstName;
	}

	public void setFirstName(String firstname){
		this.firstName = firstName;
	}

	public String getLastname(){
		return this.lastName;
	}

	public void setLastName(String lastname){
		this.lastName = lastName;
	}

	@Override
	public void formatTo(Formatter fm, int flags, int width, int precision){

		String str = this.firstName + " " + this.lastName;

		/*
		* Here we check for alternate flag (#).
		* If this flag is used in the format specifier, the output is "lastname firstname"
		* If the flag is not present, the output is the default one "firstname lastname"
		* Here, flags uses a binary representation (BITMASK) for keeping track of flags used
		* Ex : 0100 0000 & 01100010 = 0100 0000
		* flags has a value 01100010 
		* FormattableFlags.ALTERNATE has a value of 0100 0000
		* The result of bitwise & operation will be the same as FormattableFlags.ALTERNATE if the flag is present in the bitmask
		* Otherwise it returns 00000000 = false
		*/
		int alternateFlagValue = FormattableFlags.ALTERNATE & flags;
		if(alternateFlagValue == FormattableFlags.ALTERNATE){
			str = this.lastName + " " + this.firstName;
		}

		/* 
		*Check if uppercase variant of the conversion (S) is being used 
		*/
		int upperFlagValue = FormattableFlags.UPPERCASE & flags;
		if(upperFlagValue == FormattableFlags.UPPERCASE){
			str = str.toUpperCase();
		}

		// Call the format() method of formatter argument
		// store our result in it and the caller will get it
		fm.format(str);
	}


}