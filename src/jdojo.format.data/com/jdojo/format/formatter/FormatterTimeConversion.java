/*
* The following conversion characters are used for formatting times:
*	'H' 	Hour of the day for the 24-hour clock, formatted as two digits with a leading zero as necessary i.e. 00 - 23.
*	'I' 	Hour for the 12-hour clock, formatted as two digits with a leading zero as necessary, i.e. 01 - 12.
*	'k' 	Hour of the day for the 24-hour clock, i.e. 0 - 23.
*	'l' 	Hour for the 12-hour clock, i.e. 1 - 12.
*	'M' 	Minute within the hour formatted as two digits with a leading zero as necessary, i.e. 00 - 59.
*	'S' 	Seconds within the minute, formatted as two digits with a leading zero as necessary, i.e. 00 - 60 ("60" is a special value required to support leap seconds).
*	'L' 	Millisecond within the second formatted as three digits with leading zeros as necessary, i.e. 000 - 999.
*	'N' 	Nanosecond within the second, formatted as nine digits with leading zeros as necessary, i.e. 000000000 - 999999999.
*	'p' 	Locale-specific morning or afternoon marker in lower case, e.g."am" or "pm". Use of the conversion prefix 'T' forces this output to upper case.
*	'z' 	RFC 822 style numeric time zone offset from GMT, e.g. -0800. This value will be adjusted as necessary for Daylight Saving Time. For long, Long, and Date the time zone used is the default time zone for this instance of the Java virtual machine.
*	'Z' 	A string representing the abbreviation for the time zone. This value will be adjusted as necessary for Daylight Saving Time. For long, Long, and Date the time zone used is the default time zone for this instance of the Java virtual machine. The Formatter's locale will supersede the locale of the argument (if any).
*	's' 	Seconds since the beginning of the epoch starting at 1 January 1970 00:00:00 UTC, i.e. Long.MIN_VALUE/1000 to Long.MAX_VALUE/1000.
*	'Q' 	Milliseconds since the beginning of the epoch starting at 1 January 1970 00:00:00 UTC, i.e. Long.MIN_VALUE to Long.MAX_VALUE.
*/
package com.jdojo.format.formatter;

import java.util.Formatter;
import java.util.IllegalFormatConversionException;

public final class FormatterTimeConversion{
	// Prevent extension of this class
	private FormatterTimeConversion(){

	}

	public static FormatterTimeConversion getInstance(){
		return new FormatterTimeConversion();
	}

	public static void formatHour1To24(Formatter fm, Object time){
		try{
			fm.format("Hour of the day for the 24-hour clock : %tH %n", time);
		}catch(IllegalFormatConversionException e){
			fm.format("Hour for the 12-hour clock :\n\t\t%%tH %n%s%n", e.getMessage());
		}
	}

	public static void formatHour0To11(Formatter fm, Object time){
		try{
			fm.format("Hour for the 12-hour clock, formatted as two digits : %tI %n", time);
		}catch(IllegalFormatConversionException e){
			fm.format("Hour for the 12-hour clock, formatted as two digits :\n\t\t%%tI %n%s%n", e.getMessage());
		}
	}

	public static void formatHour0To23(Formatter fm, Object time){
		try{
			fm.format("Hour of the day for the 24-hour clock, i.e. 0 - 23 : %tk %n", time);
		}catch(IllegalFormatConversionException e){
			fm.format("Hour of the day for the 24-hour clock, i.e. 0 - 23 :\n\t\t %%tk %n%s%n", e.getMessage());
		}
	}

	public static void formatHour1To12(Formatter fm, Object time){
		try{
			fm.format("Hour for the 12-hour clock, i.e. 1 - 12. : %tl %n", time);
		}catch(IllegalFormatConversionException e){
			fm.format("Hour for the 12-hour clock, i.e. 1 - 12. :\n\t\t %%tl %n%s%n", e.getMessage());
		}
	}

	public static void formatMinutes(Formatter fm, Object time){
		try{
			fm.format("Minute within the hour  : %tM %n", time);
		}catch(IllegalFormatConversionException e){
			fm.format("Minute within the hour  :\n\t\t %%tM %n%s%n", e.getMessage());
		}
	}

	public static void formatSeconds(Formatter fm, Object time){
		try{
			fm.format("Seconds within the minute : %tS %n", time);
		}catch(IllegalFormatConversionException e){
			fm.format("Seconds within the minute :\n\t\t %%tS %n%s%n", e.getMessage());
		}
	}

	public static void formatMillis(Formatter fm, Object time){
		try{
			fm.format("Millisecond within the second : %tL %n", time);
		}catch(IllegalFormatConversionException e){
			fm.format("Millisecond within the second :\n\t\t %%tL %n%s%n", e.getMessage());
		}
	}

	public static void formatNanos(Formatter fm, Object time){
		try{
			fm.format("Nanosecond within the second : %tN %n", time);
		}catch(IllegalFormatConversionException e){
			fm.format("Nanosecond within the second :\n\t\t %%tN %n%s%n", e.getMessage());
		}
	}

	public static void formatAMPM(Formatter fm, Object time){
		try{
			fm.format("Locale-specific morning (AM) or afternoon (PM) : %tp %n", time);
		}catch(IllegalFormatConversionException e){
			fm.format("Locale-specific morning (AM) or afternoon (PM) :\n\t\t %%tp %n%s%n", e.getMessage());
		}
	}

	public static void formatTimeZoneNumber(Formatter fm, Object time){
		try{
			fm.format("RFC 822 style numeric time zone offset from GMT : %tz %n", time);
		}catch(IllegalFormatConversionException e){
			fm.format("RFC 822 style numeric time zone offset from GMT :\n\t\t %%tz %n%s%n", e.getMessage());
		}
	}

	public static void formatTimeZoneShort(Formatter fm, Object time){
		try{
			fm.format("A string representing the abbreviation for the time zone : %tZ %n", time);
		}catch(IllegalFormatConversionException e){
			fm.format("A string representing the abbreviation for the time zone :\n\t\t %%tZ %n%s%n", e.getMessage());
		}
	}

	public static void formatSecondSinceEpoch(Formatter fm, Object time){
		try{
			fm.format("Seconds since the beginning of the epoch : %ts %n", time);
		}catch(IllegalFormatConversionException e){
			fm.format("Seconds since the beginning of the epoch :\n\t\t %%ts %n%s%n", e.getMessage());
		}
	}

	public static void formatMillisSinceEpoch(Formatter fm, Object time){
		try{
			fm.format("Milliseconds since the beginning of the epoch : %tQ %n", time);
		}catch(IllegalFormatConversionException e){
			fm.format("Milliseconds since the beginning of the epoch :\n\t\t %%tQ %n%s%n", e.getMessage());
		}
	}
}						