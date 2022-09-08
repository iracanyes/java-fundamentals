/*
* Command:
*	Run :  java -p lib -m jdojo.classes.wrapper/com.jdojo.classes.wrapper.NumericWrapperClasses
*/
package com.jdojo.classes.wrapper;

public class NumericWrapperClasses{
	public static void main(String[] args) {
		/*
		* Numeric wrapper classes (Byte, Short, Integer, Long, Float, Double )
		* inherits from the abstract class Number.
		* You cannot create an object of the class Number as its an abstract class
		* You can declare a reference variable of Number class type.
		* You can assign an object reference of any of the 6 numeric wrapper classes
		* to a reference of the Number class.
		* Number class contains 6 methods:
		*	- byte byteValue(Byte bObj)
		*	- short shortValue(Short sObj)
		*	- int intValue(Integer intObj)
		*	- long longValue(Long longObj)
		*	- float floatValue(Float floatObj)
		*	- double doubleValue(Double doubleObj)
		*/
		Integer  intObj1 = Integer.valueOf(3256);
		System.out.println("intObj1 : " + intObj1);

		// Get byte from Integer
		byte b = intObj1.byteValue();
		System.out.println("intObj1.byteValue() : " + b);

		// Get short from Integer
		System.out.println("intObj1.shortValue()" + intObj1.shortValue());

		// Get long from Integer
		System.out.println("intObj1.longValue()" + intObj1.longValue());

		// Gets double from Integer
		double d1 = intObj1.doubleValue();
		System.out.println("intObj1.doubleValue() : " + d1);

		// Create a Double object
		Double doubleObj1 = Double.valueOf("321.654");

		// Get different types of primitive values from Double
		double d2 = doubleObj1.doubleValue();
		float f1 = doubleObj1.floatValue();
		int i1 = doubleObj1.intValue();
		long l1 = doubleObj1.longValue();

		System.out.println("doubleObj1 = " + doubleObj1);
		System.out.println("double from doubleObj1 : " + d2);
		System.out.println("float from doubleObj1 : " + f1);
		System.out.println("int from doubleObj1 : " + i1);
		System.out.println("long from doubleObj1 : " + l1);

		/*
		* Integer, Long, Float, Double wrapper classes have some specific
		* methods for operations on numeric primitive or numeric wrapper 
		*	- sum
		*/
		Integer intObj2 = Integer.valueOf(126598);
		System.out.println("intObj1 = " + intObj1 + ", intObj2 =  " + intObj2);
		// Integer.max(int i1, int i2) returns maximum 
		System.out.println("Maximum between intObj1 and intObj2 : " + Integer.max(intObj1, intObj2));
		System.out.println("Maximum between intObj1 and 23 : " + Integer.max(intObj1, 23));
		System.out.println("Maximum between intObj1 and 0b010111101011010101 : " + Integer.max(intObj1, 0b010111101011010101));
		
		System.out.println("0x9f5bb32f : " + Integer.valueOf(0x9f5bb32f));
		System.out.println("Maximum between intObj1 and 0xE9f5bb32 : " + Integer.max(intObj1, 0x9f5bb32f));
		
		System.out.println("0x0f5bb32f : " + Integer.valueOf(0x0f5bb32f));
		System.out.println("Maximum between intObj1 and 0x0f5bb32f : " + Integer.max(intObj1, 0x0f5bb32f));

		System.out.println("Minimum between intObj1 and intObj2 : " + Integer.min(intObj1, intObj2));
		System.out.println("Minimum between intObj1 and 077 : " + Integer.min(intObj1, 077));
		System.out.println("Sum of intObj1 and intObj2 : " + Integer.sum(intObj1, intObj2));
		System.out.println("Sum of intObj1 and 0xE9f5bb : " + Integer.sum(intObj1, 0xE9f5bb));


		/*
		* Java provides methods for Integer and Long classes to parse
		* string whose contents are not all integers:
		*	- int parseInt(CharSequence s, int beginIndex, int endIndex, int radix)
		*	- int parseUnsignedInt(CharSequence s, int beginIndex, int endIndex, int radix)
		*	- int parseUnsignedInt(String s)
		*	- int parseUnsignedInt(String s, int radix)
		*/
		String str1 = "0110101101";
		int radix = 3;

		// Creates an Integer object from the string
		Integer intObj3 = Integer.valueOf(str1, radix);

		// Create an integer value from the string
		int intValue3 = Integer.parseInt(str1, 4);
		System.out.println("String str1 : " + str1);
		System.out.println("intObj3 : " + intObj3);
		System.out.println("intValue3 : " + intValue3);

		String dateStr = "2022-08-14";
		int year = Integer.parseInt(dateStr, 0, 4, 10);
		int month = Integer.parseInt(dateStr, 5, 7, 10);
		int day = Integer.parseInt(dateStr, 9, 10, 10);

		/*
		* All numeric wrapper classes contains several constants:
		* The first category is shared by all numeric type
		*	- BYTES : number of bytes used to represent a specific numeric type
		*	- MIN_VALUE: 
		*		constant holding the smallest non-zero value of the specified type
		*	- MAX_VALUE: 
		*		constant holding the largest positive finite value of the type
		*	- NAN: 
		*		A constant holding a Not-a-Number(NaN) value of specified type
		*	- SIZE: 
		*		the number of bits used to represent the type
		*	- TYPE: 
		*		Class instance representing the primitive type
		* The second category is shared by floating-point number wrapper class (Float or Double)
		*	- MIN_NORMAL: 
		*		A constant holding the smallest positive normal value of type (Double[2^-1022] or Float[2^-128])
		*	- NEGATIVE_INFINITY:
		*		A constant holding the negative infinity of specified type (Float or Double)
		*	- POSITIVE_INFINITY: 
		*		A constant holding the negative infinity of specified type (Float or Double)
		*	- MIN_EXPONENT: 
		*		minimum exponent a finite double variable may have
		*	- MAX_EXPONENT: 
		*		maximum exponent a finite double variable may have
		
		*/
		convertDouble("3265.123"); // valid double		

		convertDouble("3265H.97"); // Invalid double



	}

	/*
	* When you treated string received from outside the code,
	* you must handle the error thrown if the conversion is not possible
	*/
	public static void convertDouble(String s){
		try{
			double d = Double.parseDouble(s);
			System.out.println("Parsing completed : " + d);
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
	}
}