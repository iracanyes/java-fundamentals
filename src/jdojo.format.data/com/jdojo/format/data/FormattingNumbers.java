/*
* Java provides 2 classes for formatting and parse numbers:
*	- java.text.NumberFormat
*	- java.text.DecimalFormat
*
* NumberFormat is used to format numbers with a specific locale's predefined format.
* DecimalFormat class is used to format number in a format of you choice in a given locale
*/
package com.jdojo.format.data;

import java.util.Locale;
import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.text.DecimalFormatSymbols;


public class FormattingNumbers {
	public static void main(String[] args) {
		preDefinedNumberFormats();

		// NumberFormat class testing
		printFormatted(new Locale("en", "IN"), -212.30);
		printFormatted(Locale.FRENCH, 2120.30245E5);
		printFormatted(Locale.US, 10289212.39999999);
		printFormatted(Locale.GERMAN, -10289212.39999999);
		printFormatted(Locale.JAPAN, 10289212.39999999);

		// DecimalFormat testing
		decimalFormat();

		// Parsing numbers
		parsingNumbers();

	}

	public static void preDefinedNumberFormats(){
		/*
		* getXxxInstance() method of NumberFormat class provides instance of a formatter object,
		* where Xxx can be replaced by Number, Currency, Integer, or Percent, or just getInstance().
		* These methods are overloaded. If no argument are given it return a formatter object for the default locale.
		*
		*/
		// Get a number formatter for default locale
		NumberFormat defaultFormatter = NumberFormat.getNumberInstance();

		// Get a integer formatter for default locale
		NumberFormat integerFormatter = NumberFormat.getNumberInstance();

		// Get a number formatter for locale es-SP
		NumberFormat indianPFormatter = NumberFormat.getNumberInstance();

		// Get a currency formatter for default locale
		NumberFormat euCurrencyFormatter = NumberFormat.getCurrencyInstance();

		// Get a currency formatter for default locale
		NumberFormat usCurrencyFormatter = NumberFormat.getCurrencyInstance();


		// Get a percent formatter for default locale
		NumberFormat percentFormatter = NumberFormat.getPercentInstance();

		double salary = 37200.90;
		float percent = 32.89f;
		String str = euCurrencyFormatter.format(salary);
		System.out.println("Salary in EU currency : " + str);
		str = usCurrencyFormatter.format(salary);
		System.out.println("Salary in US currency : " + str);
		str = percentFormatter.format(percent);
		System.out.println("Increase: " + str);
		str = integerFormatter.format(percent);
		System.out.println("Rounded to integer:  " + str);
		

	}

	public static void printFormatted(Locale locale, double value){
		// Get a number formatter for default locale
		NumberFormat defaultFormatter = NumberFormat.getNumberInstance();

		// Get a currency formatter for default locale
		NumberFormat integerFormatter = NumberFormat.getIntegerInstance(locale);


		// Get a number formatter for default locale
		NumberFormat esSPFormatter = NumberFormat.getNumberInstance(locale);

		// Get a currency formatter for default locale
		NumberFormat euCurrencyFormatter = NumberFormat.getCurrencyInstance(locale);

		// Get a currency formatter for default locale
		NumberFormat usCurrencyFormatter = NumberFormat.getCurrencyInstance(locale);


		// Get a percent formatter for default locale
		NumberFormat percentFormatter = NumberFormat.getPercentInstance(locale);

		System.out.println("\nFormatting " + value + " for locale : " + locale);
		System.out.println("Number (default) : " + defaultFormatter.format(value));
		System.out.println("Number (int) : " + integerFormatter.format(value));
		System.out.println("Number (en-IN) : " + esSPFormatter.format(value));
		System.out.println("Currency (US) : " + usCurrencyFormatter.format(value));
		System.out.println("Currency (EU) : " + euCurrencyFormatter.format(value));
		System.out.println("Percent : " + percentFormatter.format(value));

	}

	public static void decimalFormat(){
		/*
		* DecimalFormat class allow to perform more advanced formatting.
		* It allow to supply your own format pattern.
		* applyPattern() method allow to change format pattern.
		* You can specify different patterns for positive and negative numbers
		* 2 patterns are separated by a semicolon.
		*
		* DecimalFormat class uses a round-to-even rounding mode while formatting numbers.
		* If you set 2 digits after the decimal point in number format,
		* 25.375 and 25.365 => 25.37  
		*/
		formatDecimalNumber("##.###", -12.37585);
		formatDecimalNumber("##.##", 12.37585);
		formatDecimalNumber("0000000.000000", -12.37585);
		formatDecimalNumber("##.###;##.##", 12.37585);
		formatDecimalNumber("##.###;##.##", -12.37585);
		formatDecimalNumber("#.##;#.##", -12.37585);
		formatDecimalNumber("##.###;(#.##)", -12.37585);
		formatDecimalNumber("##.###;(#.##)", 12.37585);


	}

	public static void formatDecimalNumber(String pattern, double value){
		DecimalFormat formatter = new DecimalFormat();
		// Apply the format pattern
		formatter.applyPattern(pattern);

		// Format the number
		String formattedNumber = formatter.format(value);

		System.out.println("\nNumber: " + value + "\nPattern: " + pattern + "\nFormatted number: " + formattedNumber); 
	}

	public static void parsingNumbers(){
		// Parse a string to decimal number
		String str = "XY4,123.983DDM45";
		String pattern = "#,###.###";
		/*
		* DecimalFormat uses Locales which can result in different decimal separator and grouping separator
		* depending on the locale used.
		* setDecimalSeparator() method allow to define a character as decimal separator
		* setGroupingSeparator() method allow to define a character as grouping (thousand) separator
		*/
		DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.getDefault());
		dfs.setDecimalSeparator('.');
		dfs.setGroupingSeparator(',');
		DecimalFormat formatter = new DecimalFormat(pattern, dfs);
		
		

		// The number to parse is 4,123.983 which start at index 2 of the CharSequence 
		ParsePosition startPos = new ParsePosition(2);

		Number numberObject = formatter.parse(str, startPos);

		double value = numberObject.doubleValue();
		System.out.println("\nParsing a number\n\nText to parse : " + str + "\nPattern " + pattern + "\nFormatted number : " + value);
	}
}