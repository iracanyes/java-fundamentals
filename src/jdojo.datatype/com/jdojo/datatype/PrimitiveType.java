/*
* Description: 
* Primitive types:
*   boolean			  
*		Object Type: 	Boolean
*  	    Memory space: 	1 byte (8-bits) (smallest adressable memory space)  
*		Value: 			true(1)|false(0)
*		Example: 		true, false
* 	byte			  
*		Object Type: 	Byte	  		  
*		Memory space: 	1 byte (8-bits)  
*		Value: 			-128 (-2^7) à 127 (2^7 - 1)
*		Example: 		-2, 11
*   char			  
*		Object Type: 	Character	      
*		Memory space: 	2 byte (16-bits unsigned)   
*		Value: 			unicode (65536 caractères possibles)
*		Example: 		'A', '8', '#', '\u0000'
*   short			  
*		Object Type: 	Short           
*		Memory space: 	2 bytes (16-bits)  
*		Value: 			-32768(-2^15) à 32767(2^15 - 1)
*		Example: 		-3, 45, 127
*   int				  
*		Object Type: 	Integer 		  
*		Memory space: 	4 bytes	(32-bits)	   
*		Value: 			-2 147 483 648(-2^31) à 2 147 483 647(2^31 - 1)
*		Example: 		1960, -30, 23
*   long			  
*		Object Type: 	Long			  
*		Memory space: 	8 bytes (64-bits)         
*		Value: 			-2^63 à 2^63-1
*		Example: 		1000L, 20L, 2_000_000L
*   float			  
*		Object Type: 	Float 		  
*		Memory space: 	4 bytes	(32-bits)	   
*		Value: 			1.4*10^-45 à 3.4*10^38
*		Example: 		14.24F, 9_214.142_001F
*		
*   double			  
*		Object Type: 	Double		  
*		Memory space: 	8 bytes  (64-bits)		   
*		Value: 			4.9*10^-324 à 1.7*10^308
*		Example: 		14.24, 9_214.234_001
*
* 2 scope for numeric value: 14874 
* Number with separtor (after 3 number): 14_874
* 
* Prefix d'identification d'une base numérique
* 	décimale (10 => 0 à 9) 		=> aucun prefix  Ex: 755
* 	binaire (2 => 0 à 1)		=> 0b, 0B			 Ex: 0b1011110011
*	octale	(8 => 0 à 7)   		=> 0 			 Ex: 0755
*	! Number starting with 0 and followed by 2 digit will be considered octal. Ex: octal (021) equal 7 in decimal
*	hexadécimale (16 => 0-7 et A-F)  => 0x, 0X			 Ex: 0x2F3, 0X0A2E
* 
* num1 = 51966; // Decimal format
* num1 = 0145376; // Octal format, starts with a zero
* num1 = 0xCAFE; // Hexadecimal format, starts with 0x
* num1 = 0b1100101011111110; // Binary format starts with 0b
*
* Special character:
*	'\n': new line
*	'\t': tabulation
*	'\r': return (charriot)
*	'\b': return back
*	'\f': new page
*
* 
*/
package com.jdojo.intro;

public class PrimitiveType{
	public PrimitiveType(){
		System.out.println("\tPrimitive types - constructor!\n");
		//variableAndConstante();
	}

	/*
	* Definition de variable: 
	*	- pas de caractère speciaux, pas d'espaces
	* 	- commence par lettre ou underscore(_)
	*	- camelCase, PascalCase, snake_case
	*/
	private void variableAndConstante(){
		// variable, value are unknown at compile-time. 
		// Java compare the type of this variables.
		// firstValue = PiasDouble OK but warning of memory loss
		// when you assign a 64bit variable to a 32bits variable.
		// Only the 32 least bits will be assigned to the variable
		int firstValue = 0;
		double PIasDouble = 3.14;
		// constante, value of this constant variable are known at 
		// compile-time. 

		final int MACONSTANTE = 15;
		final	float PI = 3.14F;
		final float  = 

		System.out.println(
			"Variables and constantes\nShow first value:"
			+firstValue
			+"\nPi constante: "
			+PI
			+"\nMa constante: "
			+MACONSTANTE
		);

	}

	public void integerType(){
		int val,
			valBin,
			valOctal
			valHexa;
		// Integer literal can be assigned by 4 ways:
		//	- literal
		//	- Octal => start with 0
		//  - Hexadecimal => start with 0x or 0X
		//  - Binary 	=> start with 0b or 0B
		// Here is the same number in all different formats
		val = 51966;
		valOctal = 0145376;
		valHexa = 0xCAFE;
		valBinary = 0b1100101011111110;

		// the class Integer define 2 constant
		// Integer.MIN_VALUE = minimum int value (-2^15)
		// Integer.MAX_VALUE = maximum int value  (2^15 - 1)
		final int INTMIN = Integer.MIN_VALUE;
		final int INTMAX = Integer.MAX_VALUE;

		System.out.println("\nMinimum integer : " + INTMIN);
		System.out.println("\nMinimum integer : " + INTMAX);
	}

	// Long : 64bits signed 
	public void longType(){
		// Exist 2 constant for min|max value of long type
		long minLong = Long.MIN_VALUE;	// - 2^63 => -9,223,372,036,854,775,808
		long maxLong = Long.MAX_VALUE;	// 2^63 - 1 => 9,223,372,036,854,775,807

		// Integer literals of long type can also be expressed in octal, hexadecimal, binaire
		int valInt;
		long val,		// Here n represent a number literal
			valBinary, // Ex: 0bnnnL, 0BnnnL
			valDeci,	// Ex: nnL
			valOctal,	// Ex: 0nnL
			valHexa;	// Ex: 0xnnnL, 0XnnnL

		// Decimal format
		valDeci = 25L;
		// Octal format
		valOctal = 031L;
		// Hexadecimal format
		valHexa = 0x19L; 
		valHexa = 0X19L;
		// Binary format
		valBinary = 0b11001L;
		valBinary = 0B11001L;

		

		// Value stored in integer variable can be stored in long variable without memory-loss
		// and preserve the sign of the value
		valInt = 35;
		val = valInt;

		// When you assign a value of a smaller type to a variable of bigger type (e.g., int to long), Java
		// performs an automatic widening conversion to fill the higher order bits in the destination with zero, preserving
		// the sign bit of the source.

		// Long literal assigned to Long variable. the compiler check the value
		// assigned and makes sure that it's in the range
		// Here a compile-time error is generated. Number not in the range:
		// long numError = 9223372036854775808L;

		// Storing an integer literal of long type in an integer variable
		// At compile-time, integer literal are known by the compiler
		// As a result, a compile-time error will be generated if the integer literal
		// exceed the range of long type
		long numLong = -987564321654987L; // OK
		long numLongExceed = 9223372036854775808L; // Error
		
		// At compile-time, value of long variable are unknown by the compiler but
		// their type and memory space are known 

		// Storing long variable in a int variable will result in compile-time error
		// Even if the value is in the range of long type
		
		lon numlong = -987564321654987L;
		int numInt = val;	// Error

		// Cast a data type on assignement to allow Long the be used as Int
		// Important: The long value must not exceed the integer range or it will result in memory-loss.
		// only 32 least bits of the 64 bits signed long variable will be kepted and assigned to integer variable
		valInt = (int) val;

		System.out.println("\nMinimum long integer : " + minLong);
		System.out.println("\nMinimum long integer : " + maxLong);
	}

	// byte: 8 bits signed -128(- 2^7) => 127 (2^7)
	public void byteType(){
		byte b1 = 125;
		byte b2 = -124;

		// Store int variable which range is in -128 to 127.
		// the value of this variable is unkown by the compiler at compile-time		
		int i1 = 456;
		int i2 = -124;

		// Using 'final' allow to create constant that are known by the compiler 
		// at compile-time
		final int MACONSTANTE = 521;
		final int MACONSTBYTERANGE = 217;

		// Compile-time error if no cast is used.
		// Compiler compare the memory space used by int 32bits and byte 8 bits
		// detect the potential loss of data and throw an error
		// (Uncomment the following line and compile will throw an error)
		// b1 = i1;	// Error: memory loss

		// Using constant which values are known at compile-time
		// (Uncomment the following line and compile will throw an error)
		// b1 = MACONSTANTE; // Error: value out of bound
		
		// But using an integer variable which value is known by the compiler at compile-time
		// and which is in the range of byte type (-128 to 127) 
		b1 = MACONSTBYTERANGE; // OK

		// Casting a variable to byte type
		// If the value of the variable is within the range of byte type it's ok
		b1 = i2; // OK i2 is a constant which value is known and -124 is in the range

		/*
		*
		*
		*/
		// b1 = (byte) i1;

		// Constant Max & Min
		byte max = Byte.MAX_VALUE;
		byte min = Byte.MIN_VALUE;
	}

	/*
		Short data type (16bits signed) range: -32768 to 32767 (or -2^15 to
2^15 - 1)

	*/
	public void shortDataType(){
		short s1 = 32452;

		// Store a variable which memory space is smaller than short type is ok
		byte b1 = 124;
		s1 = b1;

		/*
			Store a variable which memory space is bigger than short 
			Here the same rule as explain for int, long are applied
		*/
		int i1 = 30546;
		int i2 = 40555;
		long l1 = -32164L;
		long l2 = -321645789654L;


		// Error: memory-loss
		// s1 = i1;

		// Using cast	 
		// If the value is in the range of short type. No memory loss.
		s1 = (short) i1;
		// If the value is out of range, only the 16 least bits of the 32 bits integer variable are kepted
		s1 = (short) i2;
		// If the value is in the range of short type. No memory loss.
		s1 = (short) l1;
		// If the value is out of range, only the 16 least bits of the 64 bits long variable are kepted
		s1 = (short) l2;

		// Short constant Min & Max
		short min = Short.MIN_VALUE;
		short max = Short.MAX_VALUE;
	}

	/**
	 * Char data type (16-bit unsigned)
	 * Its value represents a Unicode character. Range: 0 - 65535
	 * A character literal represents a value of the char data type.
	 * A character literal can be expressed in the following formats:
	 * 	- character enclosed in single quotes ''
	 * 	- character escaped sequence \n
	 * 	- Unicode escape sequence
	 * 	- Octal escape sequence
	 */
	public void charDataType(){
		char c1 = 'A';

		// Character in a single quote
		char c1 = 'A';
		char c3 = 'AV'; // Error: A character literal must contain only one character
		char c2 = "A"; // Error: String object cannot be assigned to character data type
		String st1 = 'A'; // Error Char data type cannot be assigned to object String
		String st2 = "ABC"; // Ok

		/*
		* Character escape sequence 
		* Exist 8 predefined character escape sequence
		*	- '\n'	=> new line
		*	- '\r'	=> carriage return
		*	- '\f'	=> form feed
		*	- '\b'	=> backspace
		* 	- '\t'	=> tabulation
		*	- '\\'	=> backslash
		*	- '\"'	=> double-quote
		*	- '\''	=> single-quote
		*
		* A character literal expressed in the form of a character escape sequence, consists of:
		*	- one backslash
		*	- one character
		*/

		char ces1 = '\n'; // Assigns a linefeed to ces1
		char ces2 = '\"'; // Assigns double quote to ces2
		// Error : Invalid character escape sequence

		/* Unicode character escape sequence
		* 
		* Form: '\uxxxx'
		* 	- \u mark the start of a unicode character escape sequence of 4 digits.
		*	- xxxx: represents the 4 digits allow for the sequence
		* Here ues1 is equal to ues2
		*/
		char ues1 = '\u0041';
		char ues2 = 'A';

		/* Octal Character Escape Sequence
		* Form : '\xxx'
		* Range: '\000' to '\377'
		* The octal number 377 is the same as the decimal number 255.
		* Using octal escape sequence, you can only represent characters whose 
		* Unicode code range from 0 to 255 decimal integers
		* The octal escape sequences exist to represent characters for compatibility with other languages
		* that use 8-bit unsigned chars to represent a character. Unlike a Unicode escape sequence, where you are
		* always required to use four hexadecimal digits, in an octal escape sequence you can use one, two, or three
		* octal digits. Therefore, an octal escape sequence may take on the form '\n', '\nn', or '\nnn', where n is one
		* of the octal digits 0, 1, 2, 3, 4, 5, 6, and 7.
		*/
		char c1 = '\52';
		char c2 = '\141';
		// A compile-time error. Octal 400 is out of range
		// char c3 = '\400'; 
		char c4 = '\42';
		char c5 = '\10'; // Same as '\n'

		/*
		* The decimal value 97 is represented as 141 in octal and 61 in hexadecimal.
		* You can represent the Unicode character 'a' in different forms in Java: 'a','\141' and '\u0061'.
		*/
		char c1 = 97; // Assign 'a' to c1
		char c2 = 'a'; // Assign 'a' to c2
		char c3 = '\141'; // Assign 'a' to c3
		char c4 = '\u0061'; // Assign 'a' to c4
		

		/*
		* Char are unsigned when u store 
		*/
		byte b1 = 10;
		byte b2 = -15;
		int num1 = 150;
		long num2 = 20L;
		char c1 = 'A';

		
		/*
		* A byte variable takes 8 bits and a char variable takes 16 bits. Even if the byte data type has a smaller
		* range than the char data type, you cannot assign a value stored in a byte variable to a char variable. The
		* reason is that byte is a signed data type, whereas char is an unsigned data type. If the byte variable has
		* a negative value, say -15, it cannot be stored in a char variable without losing the precision.
		*/	
		// byte and char
		// Error: b1 = c1;	
		b1 = (byte) c1;	// Ok	
		// Error: c1 = b1;	
		c1 = (char) b1;

		// short and char
		// An error: s1 = c1; 
		s1 = (short)c1; // OK
		// An error: c1 = s1; 
		c1 = (char)s1; // OK

		// int and char
		num1 = c1; // OK
		num1 = (int)c1; // OK. But cast is not required. Use num1 = c1
		// An error: c1 = num1; 
		c1 = (char)num1; // OK
		c1 = 255; // OK. 255 is in the range of 0-65535
		// An error. 70000 is out of range 0-65535
		// c1 = 70000; 
		c1 = (char)70000; // OK. But will lose the original value

		// long and char
		num2 = c1; // OK
		num2 = (long)c1; // OK. But cast is not required. Use num2 = c1
		// An Error: c1 = num2; 
		c1 = (char)num2; // OK
		// An error. 255L is a long literal
		// c1 = 255L; 
		c1 = (char)255L; // OK. But use c1 = 255 instead


	}

	public void booleanDataType(){
		// Boolean has only TWO VALID VALUE: true or false!
		boolean done = true;

		boolean toDo = false;
		// You cannot assign any other values to a boolean variable other than true
		// and false.
		// O and 1 are not treated as boolean

		/* IMPORTANT
		* boolean variable cannot be cast to any other data type and vice
		* versa. Java does not specify the size of the boolean data type. Its size is left up to the JVM implementation.
		* Typically, a value of a boolean data type is mapped by the compiler to int and boolean arrays are encoded
		* as byte arrays.
		*/

	}

	/*
	* Float (32-bit) to store a floating-point number in the IEEE 754 standard format.
	* Single precision floating-point number.
	* Range: 1.4 * 10^-45 to 3.4 * 10^38
	*/
	public void floatDataType(){
		// floating literals are real numbers that end with 'f' or 'F'
		// Most floating-point numbers are approximations of their corresponding real numbers
		float f1 = 3.14f;
		float f2 = 8.F;
		float f3 = 0.0F;

		// Real numbers can also be written using exponential forms
		// 3.25 => 32.5 * 10^-1
		float f4 = 32.5E-1F;
		// 3.25 => 0.325 * 10^1
		float f5 = 0.325E1f;
		// 3.25 => 0.0325 * 10^2
		float f6 = 0.0325e2f;
		// 3.25 => 3.25 * 10^0
		float f7 = 3.25e0f;

		/*
		* Float Data type define 2 zero :
		*	- +0.0F
		*	- -0.0F
		* For comparison reason, these 2 variable are équal.	
		*/

		/*
		* DEFINED CONSTANT
		*/
		// Positive infinity Ex: 2.5 / 0.0 
		float fPosInfinite = Float.POSITIVE_INFINITY;
		
		//		2.5 / -0.0 = negative infinity
		float fNegInfinite = Float.NEGATIVE_INFINITY;
		
		// 0.0F / 0.0F = indeterminate
		// Indeterminate result are represente by Float.NaN
		float fIndeterminate = Float.NaN;

		// Max & Min
		// 1.4 x 10^-45
		float fMin = Float.MIN_VALUE;
		// 3.4 x 10^38 (approx.)
		float fMax = Float.MAX_VALUE;

		// Value of all integral type (byte, short, char, int, long) can be stored in a float type
		float f8 = +0.0F;
		byte  b1 = 124;		
		short s1 = 32012;		
		int num1 = 65000;
		long l1 = 32659878L;
		char myChar = 'D';

		f8 = b1;		// Ok
		f8 = s1;		// Ok
		f8 = 'A';		// Ok. Char literal
		f8 = myChar;	// OK. Char variable
		f8 = 124578L;	// OK. Long literal
		f8 = l1;		// OK. Long variable

		/*
		* Floating number MUST BE CAST before to be stored in an integral variable (byte, short, char, int, long)
		* Because integral variable can't store the fraction part of the floating number,
		* Java warns you of a possible loss of data
		*/
		num1 = 10;
		float money = 10.2F;
		// Error
		// num1 = money; 
		num1 = (float) money;	// warns of possible loss of data. num1 = 10

		/*
		* CONVERSION INTEGER TO FLOAT MAY RESULT IN PRECISION LOSS
		*/
		num1 =  1012345678;
		f8 = num1;			// Here a conversion to 1.01234566E9 is made by compiler
		int num3 = num1;	// Here num3 = 1012345664
		int diff = num3 - num1;	// -14

	}

	public void doubleDataType(){
		/*
		* Double data type use 64-bit to store a floating-point numbeer in the IEEE 754 standard format.
		* Double precision floating-point
		* Range: 4.9E-324 to 1.7E308
		*/
		double dMax = Double.MAX_VALUE;	// 1.7E308 (approx.)
		double dMin = Double.MIN_VALUE;	// 4.9E-324

		// Positive & Negative infinity
		// 2.5 / 0
		double dPosInfinite = Double.POSITIVE_INFINITY;
		// -2.5 / 0
		double dNegInfinite = Double.NEGATIVE_INFINITY;

		// Indeterminate
		// 0 / 0
		double dIndeterminate = Double.NaN;

		// All real numbers are called double literals.
		double d2 = 8.;
		double d3 = 78.6598;

		// double end with 'd/D'
		double d4 =  78.6598d;

		// Real numbers can also be written using exponential forms
		// 3.25 => 32.5 * 10^-1
		double d5 = 32.5E-1D;
		// 3.25 => 0.325 * 10^1
		d5 = 0.325E1d;
		// 3.25 => 0.0325 * 10^2
		d5 = 0.0325e2D;
		// 3.25 => 3.25 * 10^0
		d5 = 3.25e0d;

		// The value of all integer type (byte, short, char, int, long) and float
		// can be assigned to double type without memory loss
		

		int i1 = 15000;
		double result = i1;
		d1 = 0.23f;
		d2 = 456798312L;	// Long literal to double
		d3 = 'A';			// Assign '65.0' to d3

		/*
		* Double MUST BE CAST to be stored in integer variable
		*/
		int i2 = 456;
		long l2 = 64587312l;
		i2 = (int) d3;
		l2 = (long) d3;


	}

	public void underscoreNumericLiteral(){
		
		/*
		* An underscore can used between 2 digits in numeric literals.
		* Not allowed: 
		*	- at start and end of the digit
		*	- next to a prefix '0x' or '0b'
		* 		For octal, 0 is considered a digit, not a prefix
		*	- next to a point in floating and double	
		*
		*/
		int x1 = 1_969; // Underscore in decimal format
		int x2 = 1__969; // Multiple consecutive underscores
		int x3 = 03_661; // Underscore in octal literal
		int x4 = 0b0111_1011_0001; // Underscores in binary literal
		int x5 = 0x7_B_1; // Underscores in hexadecimal literal
		byte b1 = 1_2_7; // Underscores in decimal format
		double d1 = 1_969.09_19; // Underscores in double literal
	}