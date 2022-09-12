/*
* * Formatter class does real works of formatting for thes methods.
* A Formatter class is used to format text and the formatted text can be written to the following destinations:
*	- An Appendable (StringBuilder, StringBuffer, Writer)
*	- A File
*	- An OutputStream
*	- A PrintStream
* Formatters are not necessarily safe for multithreaded access. 
* Thread safety is optional and is the responsibility of users of methods in this class.
*
* format() method of the Formatter class and String class is orverloaded.
* They provide 2 ways of using the method: the default one and the one with locales added
*	- Formatter format(String format, Object... args)
*	- Formatter format(Locale locale, String format, Object... args)
*
* Here is a table of supported conversion.
* Conversion 	Argument Category 	Description
*	'b', 'B' 	general 			If the argument arg is null, then the result is "false". If arg is a boolean or Boolean, then the result is the string returned by String.valueOf(arg). Otherwise, the result is "true".
*	'h', 'H' 	general 			The result is obtained by invoking Integer.toHexString(arg.hashCode()).
*	's', 'S' 	general 			If arg implements Formattable, then arg.formatTo is invoked. Otherwise, the result is obtained by invoking arg.toString().
*	'c', 'C' 	character 			The result is a Unicode character
*	'd' 		integral 			The result is formatted as a decimal integer
*	'o' 		integral 			The result is formatted as an octal integer
*	'x', 'X' 	integral 			The result is formatted as a hexadecimal integer
*	'e', 'E' 	floating point 		The result is formatted as a decimal number in computerized scientific notation
*	'f' 		floating point 		The result is formatted as a decimal number
*	'g', 'G' 	floating point 		The result is formatted using computerized scientific notation or decimal format, depending on the precision and the value after rounding.
*	'a', 'A' 	floating point 		The result is formatted as a hexadecimal floating-point number with a significand and an exponent. This conversion is not supported for the BigDecimal type despite the latter's being in the floating point argument category.
*	't', 'T' 	date/time 			Prefix for date and time conversion characters. See Date/Time Conversions.
*	'%' 		percent 			The result is a literal '%' ('\u0025')
* 	'n' 		line separator 		The result is the platform-specific line separator 
*
* The general syntax for a format is as follows:
*	%<argument-index>$<flags><width><.precision><conversion>
*
*  
* % and <conversion> are mandatory, all other part are optional.
* Here is all parts explain
*	- % : Start of a format specifier (mandatory)
*	- <argument-index> : index in the arguments given (must be followed by $)
*	- <flags> : the format of the output. The valid value of <flags> depend on the data type of the argument that the specifier refers to
*	- <width> : width is the minimum number of characters needed for writing output  
*	- <.precision> : maximum number of characters to written to output. Or maximum number of decimal for float or double
*	- <conversion> : how the output should be formatted. Its value depends on the data type. (mandatory)
*	- %% : escape special character % for format to the literal %
*	- %n : line break 
*/
package com.jdojo.format.formatter;

import java.util.Date;
import java.util.Locale;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Formatter;
import java.io.File;
import java.io.FileNotFoundException;


public final class FormatterTest{
	// Prevent extension
	private FormatterTest(){

	}

	public static void main(String[] args) {
		// Create an Appendable 
		StringBuilder sBuild = new StringBuilder();
		StringBuffer sBuffer = new StringBuffer(); 

		// Create a Formatter that will store its formatted output to the StringBuilder instance
		Formatter fmStringBuild = new Formatter(sBuild);		

		// Format strings 
		formatStrings(fmStringBuild);
		// Format numbers 
		formatNumbers(fmStringBuild);

		// Create a Formatter that will store its formatted output to the StringBuffer instance
		Formatter fmStringBuff = new Formatter(sBuffer);
		
		// Format strings
		formatStrings(fmStringBuff);		
		// Format numbers 
		formatNumbers(fmStringBuff);

		// Display the entire formatted strings
		System.out.printf("StringBuilder : %s%n",sBuild.toString());
		System.out.printf("StringBuffer : %s%n",sBuffer.toString());

		/*
		* Method which create a Formatter that will store its formatted output to the File specified
		*/
		writeFormattedStringToFile();


	}

	public static void formatStrings(Formatter fm){
		// Formatting strings
		fm.format("%1$s, %2$s, %3$s, %4$s,%5$s", "first", "second", "third", "forth", "fifth");
		fm.format("%5$s, %4$s, %3$s, %2$s,%1$s", "first", "second", "third", "forth", "fifth");
	}

	public static void formatNumbers(Formatter fm){
		/*
		* Format Numbers
		*/
		// 1$Xd where X is the number of space (positive number: before, negative number: after)
		fm.format("%1$4d, %2$8d, %3$16d %n", 1, 10, 100);
		fm.format("%3$4d, %2$4d, %1$4d %n", 10, 100, 1000);
		fm.format("%1$-4d, %2$-2d, %3$-1d %n", 1, 10, 100);
		fm.format("%2$-4d, %1$-8d, %1$-16d %n", 10, 100, 1000);

		fm.format(Locale.US, "%1$.2f %n", 12.8978);
		fm.format(Locale.FRENCH, "%1$.2f %n", 12.8978);
		fm.format(Locale.JAPAN, "%1$.2f %n", 12.8978);

	}


	/*
	* 
	*/
	public static void writeFormattedStringToFile(){
		/*
		* Here, we create a file with a relative filepath 
		* which is relative to the directory path where the command will launch 
		* If the class is executed from the root directory of the project,
		* you will find the file in the directory test/output
		*/
		File file = new File(".\\test\\output\\formatter_output_to_file.txt");
		
		// Create a formatter that will write output to file specified
		try(Formatter fm = new Formatter(file)){
			// Formatting strings
			formatStrings(fm);
			// Formatting numbers
			formatNumbers(fm);
		}catch(FileNotFoundException e){
			System.out.printf("Error while writing file  : %s\n", e.getMessage());
		}
	}
}