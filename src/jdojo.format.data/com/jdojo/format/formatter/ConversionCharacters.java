/*
* There are different type of conversion characters used to format values of different data types.
* The valid values of other parts of the format specifier are also determined by
* the conversion character and the data type of the argument which the format specifier refers to.
* Formatting types are classified in 4 categories:
*	- General formatting
*	- Character formatting
*	- Numeric formatting
*	- Date/time formatting
*
* The syntax for a format specifier:
*	%<argument-index$><flags><.precision><conversion>
*
* % and <conversion> are mandatory, all other part are optional.
* Here is all parts explain
*	- % : Start of a format specifier (mandatory)
*	- <argument-index> : index in the arguments given (must be followed by $)
*	- <flags> : the format of the output. The valid value of <flags> depend on the data type of the argument that the specifier refers to
*	- <width> : width is the minimum number of characters needed for writing output  
*	- <.precision> : maximum number of characters to be written to output. Or maximum number of decimal for float or double
*	- <conversion> : how the output should be formatted. Its value depends on the data type. (mandatory)
*	- %% : escape special character % for format to the literal %
*	- %n : line break 
*
*	Conversion 		Uppercase Variant 		Description
* 	- b 			B 						True or false based on the value of the argument. 
*											False for a null argument and for a boolean argument whose value is
*											false. Otherwise, it produces true.
*	- h 			H 						String that is the hash code value in hexadecimal format of the argument. 
*											If the argument is null, it produces "null".
* 	- s 			S 						String representation of the argument. If the argument is null, it produces a "null" string. 
*											If the argument implements the Formattable interface, it invokes the formatTo() method on the argument 
*											and the returned value is the result. 
*											If Formattable interface isn't implemented, toString() method is invoked on the argument to get the result
*
*
*/
package com.jdojo.format.formatter;

import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.Locale;
import java.time.Month;
import java.time.LocalDateTime;

public class ConversionCharacters{
	public static void main(String[] args) {
		/*
		* Many conversion characters have an uppercase variants. Ex: S is the uppercase of s. 
		* The uppercase variant converts the formatted output to uppercase.
		*/
		System.out.printf("%s, %<S %n", "Ken to uppercase with S format specifier");

		// Use a class which implements Formattable interface and with a custom formatter defined in formatTo()
		CustomFormatter person = new CustomFormatter("Jean", "Charles");

		System.out.printf("%s %n", person);
		System.out.printf("%#s %n", person);
		System.out.printf("%S %n", person);
		System.out.printf("%#S %n", person);

		generalFormatting();
		characterFormatting();
		numericFormatting();
		floatingPointNumberConversion();
		datetimeConversion();
	}

	public static void generalFormatting(){
		/*
		* Here we ask for a string format
		* a width of 4 which means minimum number of characters of 4 and 
		* a precision of 1 which means a maximum number of characters  
		*/
		System.out.printf("%4.1s %n", "Ken");		// Output: "   K"

		/*
		* width (minimum characters) : 1
		* precision (max characters) : 4
		*/
		System.out.printf("%1.4s", "Ken");		// Output: "Ken"

		// Boolean
		System.out.printf("%b, %5b, %.3b %n", true, false, true);
		System.out.printf("%b, %5b, %.3b %n", "John", "Rony", "Derry");
		System.out.printf("%B, %5B, %.3B %n", "John", "Rony", "Derry");
		System.out.printf("%b %n", 1987);
		System.out.printf("%b %n", new Object());

		// String conversion 
		System.out.printf("%s, %5s, %.6s %n", "John", "Rony", "Derry");
		System.out.printf("%S, %-5S, %.6S %n", "John", "Rony", "Derry");
		System.out.printf("%s %n", 1987);
		System.out.printf("%s %n", true);
		System.out.printf("%s %n", new Object());

		// Hash Code conversion
		System.out.printf("%h, %5h, %.6h %n", "John", "Rony", "Derry");
		System.out.printf("%H, %-5H, %.6H %n", "John", "Rony", "Derry");
		System.out.printf("%h %n", 1987);
		System.out.printf("%h %n", true);
		System.out.printf("%h %n", new Object());

		/*
		* Primitive values are autoboxed to their corresponding Object type. 
		* The following 2 statements are equivalent 
		*/
		System.out.printf("%h %n", 1987);
		System.out.printf("%h %n", Integer.valueOf(1987));



	}

	public static void characterFormatting(){
		/* Character conversion (c/C)
		* Character formatting is applied to the values of char primitive data type of Character objects.
		* It can also be applied to byte, Byte, short, Short, int and Integer types,
		* if values are valid Unicode code points.
		*
		* You can test if an integer represents a valid Unicode code point by using the method :
		*	 isValidCodePoint(int value)
		*
		* Flags # and precision are not supported by this character conversion
		*/
		System.out.printf("%c %n", 'a');
		System.out.printf("%C %n", 'a');
		System.out.printf("%C %n", 'a');
		System.out.printf("'%5c' %n", 'a');
		System.out.printf("'%c-5' %n", 'a');

	}

	public static void numericFormatting(){
		Locale enUs = new Locale("en", "US");
		Locale thaiTh = new Locale("th", "TH", "TH");
		Locale hindiIndia = new Locale("hi", "IN");

		/*
		* Integral number formatting
		* List of conversions applicable to byte, Byte, short, Short, int , Integer, long, Long:
		*
		* 	Conversion 		Uppercase Variant 		Description
		*	- d 									Format the argument in locale-specific decimal integer. 
		*											The # flags cannot be used with this conversion 
		* 	- o 			 						Format the argument as octal (based-8) integer without localization.
		*											If the flag # is present, the output is preceed by a prefix (0).
		*											Flags (+ and ' ') cannot be used with this conversion
		* 	- x 		 	X 						Format argument as hexadecimal (based-16) integer without localization 
		*											If the flag # is present, the output is preceed by a prefix (0x).
		*											If the uppercase variant X is present, the output begin with a prefix (0X)
		*											Flags (+ and ' ') cannot be used with this conversion and all integral number data types.
		* 											Flags (,) cannot be used with this conversion and a BigInteger data type
		*/
		System.out.println("************************ INTEGER BASED_10 DECIMAL *********************************");
		System.out.printf("%d %n", 123456789);
		System.out.printf("%-12d %n", -123456789);	
		System.out.printf("'%12d' %n", 123456789);
		System.out.printf("'%012d' %n", -123456789);
		System.out.printf("'%(-12d' %n", 123456789);
		System.out.printf("'%(d' %n", -123456789);
		System.out.printf("'% d' %n", 123456789);
		System.out.printf("'% d' %n", -123456789);
		System.out.printf("%+d %n", 123456789);
		System.out.printf("%+d %n", -123456789);
		System.out.printf(enUs, "%d %n", 123456789);
		System.out.printf(thaiTh, "%d %n", 123456789);
		System.out.printf(hindiIndia, "%d %n", 123456789);

		System.out.println("************************ INTEGER BASED_8 OCTAL *********************************");
		System.out.printf("%o %n", 123456789);
		System.out.printf("%-12o %n", -123456789);	
		System.out.printf("'%12o' %n", 123456789);
		System.out.printf("'%012o' %n", -123456789);
		System.out.printf("'%-12o' %n", 123456789);
		System.out.printf("'%o' %n", -123456789);
		System.out.printf("%#o %n", 123456789);
		System.out.printf("%#o %n", -123456789);
		System.out.printf("'%o' %n", new BigInteger("123456789132645789", 10));
		System.out.printf("'%o' %n", new BigInteger("-123456789132645789", 10));
		System.out.printf(enUs, "%o %n", 123456789);
		System.out.printf(thaiTh, "%o %n", 123456789);
		System.out.printf(hindiIndia, "%o %n", 123456789);

		// Hexadecimal
		System.out.println("************************ INTEGER BASED_16 HEXADECIMAL *********************************");
		System.out.printf("%x %n", 123456789);
		System.out.printf("%-12x %n", -123456789);	
		System.out.printf("'%12x' %n", 123456789);
		System.out.printf("'%012x' %n", -123456789);
		System.out.printf("'%-12x' %n", 123456789);
		System.out.printf("'%x' %n", -123456789);
		System.out.printf("'%#x' %n", 123456789);
		System.out.printf("'%#x' %n", -123456789);
		System.out.printf("'%x' %n", new BigInteger("123456789132645789", 10));
		System.out.printf("'%x' %n", new BigInteger("-123456789132645789", 10));
		System.out.printf(enUs, "%x %n", 123456789);
		System.out.printf(thaiTh, "%x %n", 123456789);
		System.out.printf(hindiIndia, "%x %n", 123456789);

	}

	public static void floatingPointNumberConversion(){
		/*
		* Floating point number are numbers with a whole part (integer) and fraction part ().
		*
		* List of conversions available for float, Float, double, Double, BigDecimal
		*
		* 	Conversion 		Uppercase Variant 		Description
		*	- e 			- E 					Format argument in locale-specific computerized scientific notation. Ex: 1.968354e+13
		*											Precision define the number of digits after the decimal separator
		*											The group separator flag (,) cannot be used with this conversion
		* ----------------------------------------------------------------------------------------------------------------------------------
		*	- g 			- G 					Format argument in a locale-specific general scientific notation.
		*											Depending on the value, it use 'e' notation or 'f' notation.
		*											It applies rounding to the value depending on the precision
		*											Value comprise between [10^-4 to 10^10] after conversion, 'f' notation will be used
		*											Value less than 10^-4 and greater than 10^10 will get 'e' notation.
		*											Precision define the total number of significant digits after the decimal separator 
		* 	- f 									Format the arguments in a locale-specific decimal format.
		* 											Precision define the total number of significant digits after the decimal separator
		* ----------------------------------------------------------------------------------------------------------------------------------
		* 	- a 			- A 					Format the argument in hexadecimal exponential format.
		*											Not applicable to BigDecimal
		*
		* Precision has different meaning:
		*	- For e and f conversion, the precision is the number of digits after the decimal separator
		*	- For g conversion, the precision is the total number significant of digits in the resulting magnitude after rounding. 
		*/
		System.out.println("\n************************ FLOATING POINT NUMBERS *********************************");
		System.out.printf("%%e : %e %n", 102.35);
		System.out.printf("%%f : %f %n", 102.35);
		System.out.printf("%%g : %g %n", 102.35);

		System.out.printf("%%e : %e %n", 102.0000035);
		System.out.printf("%%e : %f %n", 102.00000000035);
		System.out.printf("%%g : %g %n", 102.00200000035);
		System.out.printf("%%a : %a %n", 102.00200000035);
		System.out.printf("%%f : %f %n", Double.POSITIVE_INFINITY);
		System.out.printf("%%f : %f %n", Double.NEGATIVE_INFINITY);


		System.out.printf("%%.2e : %.2e %n", 102.00200000035);
		System.out.printf("%%.2f : %.2f %n", 102.00200000035);
		System.out.printf("%%.2g : %.2g %n", 102.00200000035);
		System.out.printf("%%.2a : %.2a %n", 102.00200000035);
		System.out.printf("%%.2f : %.2f %n", Double.POSITIVE_INFINITY);
		System.out.printf("%%.2f : %.2f %n", Double.NEGATIVE_INFINITY);

		System.out.printf("%%8.2e : %8.2e %n", 102.00200000035);
		System.out.printf("%%8.2f : %8.2f %n", 102.00200000035);
		System.out.printf("%%8.2g : %8.2g %n", 102.00200000035);
		System.out.printf("%%8.2a : %8.2a %n", 102.00200000035);
		System.out.printf("%%8.2f : %8.2f %n", Double.POSITIVE_INFINITY);
		System.out.printf("%%8.2f : %8.2f %n", Double.NEGATIVE_INFINITY);

		System.out.printf("%-8.2e %n", 102.00200000035);
		System.out.printf("%-8.2f %n", 102.00200000035);
		System.out.printf("%-8.2g %n", 102.00200000035);
		System.out.printf("%-8.2a %n", 102.00200000035);
		System.out.printf("%(8.2e %n", 102.00200000035);
		System.out.printf("%8.4e %n", new BigDecimal(123456789102.00200000035));
		System.out.printf("%8.4f %n", new BigDecimal(123456789102.00200000035));
		System.out.printf("%8.4g %n", new BigDecimal(123456789102.00200000035));
		System.out.printf("%-8.2f %n", Double.POSITIVE_INFINITY);
		System.out.printf("%-8.2f %n", Double.NEGATIVE_INFINITY);

		System.out.printf("%(8.2e %n", 102.00200000035);
		// FormatFlagsConversionMismatchException
		// System.out.printf("%(8.2f %n", 102.00200000035);		
		System.out.printf("%(8.2g %n", 102.00200000035);
		System.out.printf("%(8.2g %n", new BigDecimal(123456789102.00200000035));
		// FormatFlagsConversionMismatchException
		//System.out.printf("%8.2a %n", new BigDecimal(123456789102.00200000035));
		System.out.printf("%(8.2f %n", Double.POSITIVE_INFINITY);
		System.out.printf("%(8.2f %n", Double.NEGATIVE_INFINITY);

	}

	public static void datetimeConversion(){
		/*
		* Datetime conversion applies localization wherever it's applicable.
		* Check the following files for more details:  FormatterDateTimeConversion, FormatterDateConversion, FormatterTimeConversion
		*/
		Locale enUS = Locale.US;
		Locale hindiIndia = new Locale("hi", "IN");
		Locale thaiThailand = new Locale("th", "TH", "TH");

		// Create a local datetime
		LocalDateTime ldt = LocalDateTime.of(2014, Month.JANUARY, 28, 23, 25, 23);
		System.out.println("************************ DATETIME CONVERSION *********************************");
		System.out.printf("In default locale " + Locale.getDefault() + " : %tb, %<te, %<tY, %<tT, %<TD%n", ldt);
		System.out.printf(enUS, "In US : %tb, %<te, %<tY, %<tT, %<TD%n", ldt);
		System.out.printf(hindiIndia, "In US : %tb, %<te, %<tY, %<tT, %<TD%n", ldt);
		System.out.printf(thaiThailand, "In US : %tb, %<te, %<tY, %<tT, %<TD%n", ldt);

	}


}