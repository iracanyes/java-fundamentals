/*
* Visit Oracle Documentation for more info about 
* Numeric Wrapper class
*	- Boolean : https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html
*	- Byte: 	https://docs.oracle.com/javase/8/docs/api/java/lang/Byte.html
*	- Integer : https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html
*	- etc.	
*/
package com.jdojo.classes.wrapper;

public class UnsignedNumericOperation{
	public static void main(String[] args) {
		/*
		* Java 8 add support unsigned primitive integer data types.
		* The byte, short, int and long are signed data types.
		* For a signed data type, one bit is used to store the sign of the value, 
		* for the rest of the bits, half of the range of values is used for storing
		* positive numbers and half for negative numbers 
		* Ex: a byte takes 8 bits. 1 bit is used for the sign.
		* the 7 bits remaining bits are used to store the value 
		* 	2^7 = -128
		* 	2^7 - 1 = 127
		*
		* Byte, Short, Integer and Long class implements method
		* for manipulating unsigned numeric values
		* These methods below allow to convert a numeric data type into unsigned int or long
		*	- int toUnsignedInt(byte x) 
		*		- Byte.toUnsignedInt(byte x)
		*		- Short.toUnsignedInt(short x)
		*	- long toUnsignedLong(byte x)
		*		- Byte.toUnsignedLong(byte x)
		*		- Short.toUnsignedLong(short x)
		*		- Integer.toUnsignedLong(int x)
		*
		* To store a signed data type X as unsigned value in a signed data type Y,
		* the size of the data type Y needs at least twice as that of X.  
		* byte and short are converted to unsigned int (Byte.toUnsignedInt(), Short.toUnsignedInt() are available)
		* int are converted to unsigned long (Integer.toUnsignedLong())
		* long type cannot be converted they unsigned value as no bigger data type exists in Java. 

		* These method returns the same value if the parameter is zero or positive number
		* If the parameter is a negative number, a 2^n + x.
		* where n is the number of bits used to store the actual value
		* Remember that the most significant bit of unsigned value in bits is used to store the sign of the value
		* the rest of the bits are used to store the actual value 
		* In the case of unsigned value, all the bits are used to store the unsigned value
		* byte(8 bits) 		-10 => 2^8 - 10 =  246 (unsigned value)
		* short(16 bits) 	-10 => 2^16 - 10 = 65526 (unsigned short value)
		* int(32bits)		-10 => 2^32 - 10 = 4_294_967_286 (unsigned int value)
		* long(64bits)		-10 => 2^64 - 10 = 18_446_744_073_709_551_606 (unsigned long value)
		*/
		byte b = -10;
		short s = -136;
		int i = -2_126_549_871;
		long l = -9_876_453_124l;

		int iUByte  = Byte.toUnsignedInt(b);
		int iUShort = Short.toUnsignedInt(s);

		long iUByte2  = Byte.toUnsignedLong(b);
		long iUShort2 = Short.toUnsignedLong(s);
		long iUInt2 = Integer.toUnsignedLong(i);

		System.out.println( "byte " + b  + " to unsigned int : " + iUByte);
		System.out.println( "short " + s  + " to unsigned int : " + iUShort);

		System.out.println( "byte " + b  + " to unsigned long : " + iUByte2);
		System.out.println( "short " + s  + " to unsigned long: " + iUShort2);
		System.out.println( "int " + i  + " to unsigned long : " + iUInt2);

		



	}
}