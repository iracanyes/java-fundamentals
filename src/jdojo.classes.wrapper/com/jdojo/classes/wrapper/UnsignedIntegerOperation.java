/*
* Unsigned Integer Operation:
* These methods allow the support of unsigned operation:
*	- int compareUnsigned(int x, int y)
*	- int divideUnsigned(int divided, int divisor)
*	- int parseUnsignedInt(String unsignedIntString)
*	- int parseUnsignedInt(String unsignedIntString, int radix)
*	- int remainderUnsigned(int dividend, int divisor)
*	- long toUnsignedLong(int x)
*	- String toUnsignedString(int i)
*	- String toUnsignedString(int i, int radix)
*
*/
package com.jdojo.classes.wrapper;

public class UnsignedIntegerOperation{
	public static void main(String[] args) {
		int x = -20;
		int y = -10;



		System.out.println("x = " + x + " , y = " + y);
		System.out.println("(x/y) : " + (x/y));

		// Here we convert the integer in an unsigned long
		long ux = Integer.toUnsignedLong(x);
		long uy = Integer.toUnsignedLong(y);
		System.out.println("Unsigned " + x + " using Integer.toUnsignedLong(x) : " + ux);
		System.out.println("Unsigned " + y + " using Integer.toUnsignedLong(y) : " + uy);
		
		
		/*
		* int Integer.dividedUnsigned(int unsignedInt1, int unsignedInt2)
		*/
		long uQuotient = Long.divideUnsigned(ux, uy);
		System.out.println("Integer.divideUnsigned(ux, uy) : " + uQuotient);


		/*
		*
		*/

		/*
		* int Integer.parseUnsignedInt(String unsignedIntString) 
		* Receive in parameter an unsigned integer string and returns a signed integer
		* If the value of the integer string is signed integer an error is thrown
		*/
		// Error: Exception in thread "main" java.lang.NumberFormatException: Illegal leading minus sign on unsigned string -20
		//System.out.println("Integer.parseUnsignedInt(x) : " + Integer.parseUnsignedInt("-20"));
		
		System.out.println("Integer.parseUnsignedInt(\"10\") : " + Integer.parseUnsignedInt("10"));

		/* 
		* int Integer.parseUnsignedInt(String unsignedIntString, int radix) 
		* Methods to convert to unsigned string representation
		*/
		System.out.println("Integer.parseUnsignedInt(\"10\", 2) : " + Integer.parseUnsignedInt("10", 2));
		System.out.println("Integer.parseUnsignedInt(\"10\", 8) : " + Integer.parseUnsignedInt("10", 8));
		System.out.println("Integer.parseUnsignedInt(\"10\", 16) : " + Integer.parseUnsignedInt("10", 16));


		/* 
		* int Integer.toUnsignedString(String unsignedIntString, int radix) 
		* Methods to convert to unsigned string representation
		*/
		System.out.println( "int " + x  + " to unsigned integer values in radix 2 (binary format)  : " + Integer.toUnsignedString(x, 2));
		System.out.println( "int " + x  + " to unsigned integer values in radix 8 (octal format) : " + Integer.toUnsignedString(x, 8));
		System.out.println( "int " + y  + " to unsigned integer values in radix 16 (hexadecimal format) : " + Integer.toUnsignedString(y, 16));


		

		/*
		* Integer.toUnsignedString(int x)
		* Returns a string representation as an unsigned decimal value
		*/
		System.out.println( "int " + x  + " to unsigned string : " + Integer.toUnsignedString(x));
		System.out.println( "int " + 20  + " to unsigned string : " + Integer.toUnsignedString(20));
		System.out.println( "int " + y  + " to unsigned string : " + Integer.toUnsignedString(y));
		System.out.println( "int " + 10  + " to unsigned string : " + Integer.toUnsignedString(10));
		
		/*
		* int Integer.compareUnsigned(int x, int y)
		*/
		int result = Integer.compareUnsigned(x, y);
		int result2 = Integer.compareUnsigned(20, 10);
		
		System.out.println("Integer.compareUnsigned(" + x + " , "+ y + " ) : " + result);
		System.out.println("Integer.compareUnsigned( 20, 10 ) : " + result2);
		
	}
}