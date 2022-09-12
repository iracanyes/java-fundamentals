/*
* The following conversion characters are used for formatting common date/time compositions.
*	'R' 	Time formatted for the 24-hour clock as "%tH:%tM"
*	'T' 	Time formatted for the 24-hour clock as "%tH:%tM:%tS".
*	'r' 	Time formatted for the 12-hour clock as "%tI:%tM:%tS %Tp". The location of the morning or afternoon marker ('%Tp') may be locale-dependent.
*	'D' 	Date formatted as "%tm/%td/%ty".
*	'F' 	ISO 8601 complete date formatted as "%tY-%tm-%td".
*	'c' 	Date and time formatted as "%ta %tb %td %tT %tZ %tY", e.g. "Sun Jul 20 16:17:00 EDT 1969". 

*/
package com.jdojo.format.formatter;

import java.util.Formatter;
import java.util.IllegalFormatConversionException;

public class FormatterDateTimeConversion{
	private FormatterDateTimeConversion(){

	}

	public static FormatterDateTimeConversion getInstance(){
		return new FormatterDateTimeConversion();
	}

	public static void formatTime24Hour(Formatter fm, Object  datetime){
		try{
			fm.format("Time formatted for the 24-hour clock as %%tH:%%tM : %tR %n",  datetime);
		}catch(IllegalFormatConversionException e){
			fm.format("\nTime formatted for the 24-hour clock as %%tH:%%tM :\n\t %tR %n%s%n", e.getMessage());
		}
	}

	public static void formatTime24Hour2(Formatter fm, Object  datetime){
		try{
			fm.format("Time formatted for the 24-hour clock as %%tH:%%tM:%%tS : %tT %n",  datetime);
		}catch(IllegalFormatConversionException e){
			fm.format("Time formatted for the 24-hour clock as %%tH:%%tM:%%tS :\n\t\t%%tT %n%s%n", e.getMessage());
		}
	}

	public static void formatTime12Hour(Formatter fm, Object  datetime){
		try{
			fm.format("Time formatted for the 12-hour clock as %%tI:%%tM:%%tS %%Tp : %tr %n",  datetime);
		}catch(IllegalFormatConversionException e){
			fm.format("Time formatted for the 12-hour clock as %%tI:%%tM:%%tS %Tp :\n\t\t%%tr %n%s%n", e.getMessage());
		}
	}

	public static void formatDate(Formatter fm, Object  datetime){
		try{
			fm.format("Date formatted as %%tm/%%td/%%ty : %tD %n",  datetime);
		}catch(IllegalFormatConversionException e){
			fm.format("Date formatted as %%tm/%%td/%%ty :\n\t\t%%tD %n%s%n", e.getMessage());
		}
	}

	public static void formatDateISO(Formatter fm, Object  datetime){
		try{
			fm.format("ISO 8601 complete date formatted as %%tY-%%tm-%%td  : %tF %n",  datetime);
		}catch(IllegalFormatConversionException e){
			fm.format("ISO 8601 complete date formatted as %%tY-%%tm-%%td  :\n\t\t%%tF %n%s%n", e.getMessage());
		}
	}

	public static void formatDateTimeISO(Formatter fm, Object datetime){
		try{
			fm.format("Date and time formatted as %%ta %%tb %%td %%tT %%tZ %%tY : %tL %n",  datetime);
		}catch(IllegalFormatConversionException e){
			fm.format("Date and time formatted as %%ta %%tb %%td %%tT %%tZ %%tY :\n\t\t%%tL %n%s%n", e.getMessage());
		}
	}
}