/*
* Operators Precedence:
*	Level 		Operator Symbol 	Action Performed
*	1 				++ 				Pre-or-post increment
*					-- 				Pre-or-post decrement
*					+, - 			Unary plus, unary minus
*					~ 				Bitwise Not 1s complement
*					! 				Logical NOT
*					(type) 			Cast
*	2 				*, /, % 		Multiplication, division, remainder
*	3 				+, - 			Addition, subtraction
*					+ 				String concatenation
*	4 				<< 				Left shift
*					>> 				Signed right shift
*					>>> 			Unsigned right shift
*	5 				< 				Less than
*					<= 				Less than or equal
*					> 				Greater than
*					>= 				Greater than or equal
*					instanceof 		Type comparison
*	6 				== 				Equal in value
*					!= 				Not equal to
*	7 				& 				Bitwise AND
*					& 				Logical AND
*	8 				^ 				Bitwise XOR
*					^ 				Logical XOR
*	9 				| 				Bitwise OR
*					| 				Logical OR
*	10 				&& 				Logical short-circuit AND
*	11 				|| 				Logical short-circuit OR
*	12 				?: 				Ternary operator
*	13 				= 				Assignment
*					+=, -=, *=, /=, %=,
*					<<=, >>=, >>>=,
*					&=, |=, ^=
*
*/
package com.jdojo.intro;


public class Operators{
	
	/*
	* Constructor
	*/
	public Operators(){

	}

	public void addition(){
		/* Operand1 + operand2
		* Every expression involving the addition, operator has a data type.
		* The data type is determined according to one of four rules:
		*	- If one the operands is DOUBLE, the other operand is converted to DOUBLE
		*	- If one the operands is FLOAT, the other operand is converted to FLOAT
		*	- If one the operands is LONG, the other operand is converted to LONG
		*	- If none of the provided rules applies, all operands are converted to INT
		*	
		*/
		byte b1 = 5;	// Ok
		byte b2 = 2;
		byte b2prim = 2 + 5;		// Ok. Value of Integer literal known at compile-time
									// If the result's in the range of byte type. Operation allowed.
		byte b3 = b1 + b2;			// Error: b1 and b2 are converted to Int
		byte b4 = (byte) b1 + b2;	// Error: b2 is Int and b1 will be converted to Int
		byte b4 = (byte) (b1 + b2);	// OK. First b1 et b2 are promoted to Int.
									// Result is cast to Byte

		short s1 = 120;
		int i = 654789;
		int j = 124;
		long l1 = 654987654L;
		float f1 = 0.25f;
		double d1 = 0.124578E7d;

		b1 = 15 + 111;		// Ok. In range of byte type -128 to 127
		b1 = i + 5;			// Error. i and 5 promoted to int 
		b1 = (byte) (i + 5)	// OK. i and 5 promoted to int. result is int and converted to byte
		b1 = s1 + 2; 		// Error. s1 and 2 promoted to int. 
		b1 = f1 + b2;		// Error. b2 promoted to float. result is float
		b1 = f1 + d1;		// Error. f1 promoted to double. result is double
		f1 = i + f1;		// OK. i promoted to float. result is float
		f1 = i +d1;			// Error. i promoted to double. result is double
		f1 = (float)(i + d1);	// OK. i promoted to double. result is double and converted to float	
		f1 = 2.0 + 3.2;			// Error. All real number literal are considered as double. result is double
		f1 = 2.0f + 3.2F;		// Ok. operands are float and result is float
		d1 = f1 + j;			// OK. j promoted to float. result is float. float can be stored in double



	}

	public void subtraction(){
		/*
		* operand1 - operand2
		* All rules about numeric data conversion of operands and the determination of the data type
		* applied to addition operator are also applicable to expression involving subtraction operator
		*/
		byte b1 = 5;
		int i = 100;
		float f1 = 2.5F;
		double d1 = 15.45;
		// OK. 200 - 173 will be replaced by 27.
		// b1 = 27 is OK because 27 is in the range -128 and 127
		b1 = 200 - 173;
		// An error. i - 27 is of the type int. int to byte assignment is not allowed
		b1 = i - 27;
		b1 = (byte)(i - 27); // OK. Assigns 73 to b1
		d1 = f1 - i; // OK. Assigns -97.5 to d1
	}

	public void multiplication(){
		/*
		* operand1 * operand2
		* All rules about numeric data conversion of operands and the determination of the data type
		* applied to addition operator are also applicable to expression involving subtraction operator
		*/
		byte b1 = 5;
		int i = 10;
		float f1 = 2.5F;
		double d1 = 15.45;
		// OK. 20 * 6 will be replaced by 120
		// b1 = 120 is OK because 120 is in the range -128 and 127
		b1 = 20 * 6;
		// An error. i * 12 is of the type int. int to byte assignment is not allowed
		b1 = i * 12;
		b1 = (byte)(i * 12); // OK. Assigns 120 to b1
		// OK. i * b1 is of the type int. int to float assignment is allowed
		f1 = i * b1;
		// An error. d1 * i is of type double. double to float assignment is not allowed
		f1 = d1 * i;
		f1 = (float)(d1 * i); // OK. Assigns 154.5 to f1
	}

	public void division(){
		/*
		* operand1 * operand2
		* All rules about numeric data conversion of operands and the determination of the data type
		* applied to addition operator are also applicable to expression involving subtraction operator
		*/

		/*
		* INTEGER DIVISION
		* If all operands are integer (byte, short, char, int, long), the result returned will be an integer
		* The division operation is made and the result is truncated toward 0 to represent a integer.
		* Ex: 5/2 = 2.5. the fractional part 0.5 is ignored and result return is 2 
		*/
		int num;
		num = 5/2; // Assigns 2 to num
		num = 5/3; // Assigns 1 to num
		num = 5/4; // Assigns 1 to num
		num = 5/5; // Assigns 1 to num
		num = 5/6; // Assigns 0 to num
		num = 5/7; // Assigns 0 to num

		/*
		* FLOATING-POINT DIVISION
		* If either or both operands of the division are FLOAT or DOUBLE
		* a floating-point division is performed and the result isn't truncanted
		*/
		float f1;
		f1 = 15.0F/4.0F;	// OK. operand are float. result (3.75F) is float
		f1 = 15/4.0F;		// Ok. 15 is Int promoted to float. result (3.75F) is float
		f1 = 15.0/4.0F;		// Error. 15.0 is double, 4.0F is promoted to double. result (3.75D) is double
		f1 = (float)(15.0/4.0F);	// OK. result (3.75D) is converted to float
		f1 = 15/4;					// Ok. operands are integers so result is int. int can be assigned to float

		/*
		* DIVISION BY ZERO
		* Integer division => runtime error
		* Floating-point division => Positive infinity Or Negative infinity (one operand is negative)
		*/
		int i = 1;
		int zero = 0;
		float f1 = 2.5F;
		double d1 = 5.4;

		int j = i / zero;	// Runtime error
		i = zero / zero; 	// Runtime error.

		f1 = 5.0F/0.0F;		// Float.POSITIVE_INFINITY
		f1 = -5.0F/0.0F;		// Float.NEGATIVE_INFINITY
		f1 = -5.0F/-0.0F;		// Float.POSITIVE_INFINITY
		f1 = 5.0F/-0.0F;		// Float.NEGATIVE_INFINITY
		f1 = 5.0/0.0;		// Double.POSITIVE_INFINITY
		f1 = -5.0/0.0;		// Double.NEGATIVE_INFINITY
		f1 = 5.0/-0.0;		// Double.NEGATIVE_INFINITY
		f1 = -5.0/-0.0;		// Double.POSITIVE_INFINITY

		f1 = 5.0F/0;		// 5.0F is float, 0 is int promoted to float. result is float
							// Float.POSITIVE_INFINITY

		f1 = 5.0F/0.0;		// 0.0 is double, 5.0F is promoted to double. result is double
							// Error: double can't be assigned to float
		f1 =(float)(5.0F/0.0);	// Ok. result is double converted to float before assignment
								// Float.POSITIVE_INFINITY

		f1 = 0.0f / 0.0f;	// Float.NaN
		f1 = 0.0 / 0.0; 	// Error. result is double
		d1 = 0.0 / 0.0;		// Double.NaN
		d1 = -0.0 / 0.0;	// Double.NaN
	}

	public void modulus(){
		// Perform a division on left-hand operand by it right-hand operand
		// and returns the remainder of the division
		/*
		* operand1 % operand2
		* All rules about numeric data conversion of operands and the determination of the data type
		* applied to addition operator are also applicable to expression involving subtraction operator
		*/
		// INTEGER MODULUS
		int i;
		
		i = 78 % 0;		// Runtime error. right-hand operand can't be zero

		// The sign of the result is equal to the sign of the left-hand operand
		i = 15 % 6;		// Assign 3
		i = -15 % 6;	// Assign -3
		i = 15 % -6;	// Assign 3
		i = -15 % -6;	// Assign -3
		i = 5 % 7;		// Assign 5
		i = 0 % 7;		// Assign 0


		// FLOATING-POINT MODULUS
		// If one of the operand is a floating-point number, Here is the rules
		// 1. Operation never result in an error
		// 2. the result is NaN if either operand is NaN
		float f1;
		double d1;
		f1 = Float.NaN % 80.5F;		// Assign Float.NaN
		f1 = 54.5F % Float.NaN;		// Assign Float.NaN
		f1 = Float.NaN % Float.NaN;	// Assign Float.NaN

		f1 = Float.NaN % Double.NaN;	// Error. Double can't be assigned to float
		d1 = Float.NaN % Double.NaN;	// Assign Double.NaN

		// 3. if the right-hand operand is zero, result is NaN
		f1 = 15.0F % 0.0F;		// Float.NaN

		//4. If the left-hand is infinity, result is NaN
		f1 = Float.POSITIVE_INFINITY % 2.0F;	// Float.NaN
		
		//5. If none of the previous rules apply, the modulus operator returns the remainder of the division of the lefthand
		// operand and the right-hand operand. The sign of the result is the same as the sign of the left-hand
		// operand.
		f1 = 15.5F % 6.5F;	// Assign 2.5
		d1 = 5.5 % 16.65;	// Assign 5.5 to d1. 
		d1 = 0.0 % 2.78;	// Assign 0.0 to d1
		d1 = 87.0 % Double.POSITIVE_INFINITY;	// Assign 87.0 to d1
		d1 = -87.0 % Double.POSITIVE_INFINITY;	// Assign -87.0 to d1
		d1 = 87.0 % Double.NEGATIVE_INFINITY;	// Assign 87.0 to d1
		d1 = -87.0 % Double.NEGATIVE_INFINITY;	// Assign -87.0 to d1
	}

	/*
	* Unary Plus operator
	* Ex: +operand
	*/
	public void unaryPlusOperator(){
		/* +operand
		* The operand MUST be a primitive type.
		* If the operand is byte, short or char, is promoted to int.
		*/
		byte b1 = 10;
		byte b2 = 12;

		b1 = b2;
		b1 = +b2;	// Error. b2 is byte, is promoted to int
		b1 = (byte) +b2;	// Ok. result convert to byte

	}

	public void unaryMinusOperator(){
		/*
		* -operand
		* It negates the value of its operand. The operand MUST be à primitive type.
		* If the operand is byte, short or char, it's promoted to int
		*/
		byte b1 = 14;
		byte b2 = -124;

		b1 = b2;	// Ok. byte to byte assignment

		b1 = -b2;	// Error. b2 promoted to int
		b1 = (byte) -b2;	// Ok. b2 is converted to int and negates
	}

	/**
	 *  schema: operand1 operator= operand2
	 */
	public void compoundArithmeticAssignmentOperators(){
		int i = 111;
		byte b1 = -23;
		float f1 = 10.25f;

		/*
		* all 5 basic arithmetic operators have a compound
		* arithmetic assignment operator.
		* 	- Addition: 		+=
		*	- Subtraction: 		-=
		*	- Multiplication: 	*=
		*	- Division: 		/=
		*	- Modulus:			%=
		* Compound arithmetic operation automatically promoted the result of operation
		* to the type of destination's variable
		* Ex: b1 = (byte)(b1 + i) is equivalent to b1 += i
		*
		* Advantage:
		*	- b1 is evaluated once.
		*	- result cast to destionation varible type
		*/
		b1 = (byte)(b1 + i);	// result 88 is int and cast to byte

		i += 5.50;			// Equivalent to : i = (int) (i + 5.50)
							// result (116.50) is double and cast to int (116)

		i += 10.2f;			// result (126.20f) is float and cast to int (126)
		/*
		* 
		*/
		i = 126;
		i /= 2.2f;			// result (57.272724) is float and cast to int (57)
		i = 126;
		i /= 2.2;			// result (57.272727272727266) is double and cast to int (57)
		i /= 0;				// Runtime Error. Integer division by zero
		f1 /= 0.0;			// Assign Float.POSITIVE_INFINITY

		/* operand1(String) += operand2(any primitive type)
		* Compound assignment operator '+=' can also be applied to String variable.
		* 	- operand1 must be a STRING
		* 	- operand2 can be of any type of primitive type
		*/
		String str1 = "Hello";	
		int i = 116;
		byte b1 = 88;
		str1 += 100;			// "Hello100"
		str1 += true;			// "Hello100true"
		str1 += i;				// "Hello100true116"
		str1 += b1;				// "Hello100true11688"


	}


	public void incrementAndDecrement(){
		/*
		*	operand-- => decrement after use of operand
		*	operand++ => increment after use of operand
		*	--operand => decrement before use of operand
		*	++operand => increment before use of operand
		*	
		*/
		int i1 = 10;
		int j
		// More complex operations
		int j = i1++ + 15;		// Assign 27 to j and increments after i1 of 1, i1 become 13
		i = 10;
		i = ++i + i++;			// Operation: 11 + 10. 
								// Result is 22 and i is increment of 1, i is equal to 11. 
								// Assign 22 to i

		
	}

	/* String Concatenation
	*
	* 	Data type 		Value 						Representation
	*---------------------------------------------------------------
	*	int, short,		1678 						"1678"
	*	byte, long  	0 							"0"
	*	char 			'A' 						"A"
	*					'\u0041'					"A"
	*					(Unicode escape sequence)
	*	boolean 		true 						"true"	
	*					false 						"false" 
	*	
	*	float 			2.5 						"2.5"
	*					0.0F 						"0.0"
	*					-0.0F 						"-0.0"
	*					Float.POSITIVE_INFINITY 	"Infinity"
	*					Float.NEGATIVE_INFINITY 	"-Infinity"
	*					Float.NaN 					"NaN"
	*	double 			89.12 						"89.12"
	*					0.0 						"0.0"
	*					-0.0 						"-0.0"
	*					Double.POSITIVE_INFINITY 	"Infinity"
	*					Double.NEGATIVE_INFINITY 	"-Infinity"
	*					Double.NaN 					"NaN"
	*   null 										"null"
	*/
	public void stringConcatenation(){
		int nb1 = 10;
		float f1 = 0.21245E-3f;
		float f2 = Float.POSITIVE_INFINITY;
		float f3 = Float.NaN;
		double d1 = 0.2457E13d;
		double d2 = Double.NEGATIVE_INFINITY;
		String st1 = "Hello";
		boolean bol = false;

		/*
		* Operations are evaluated from left -> right unless overridden by using parentheses.
		* 	- Addition: 15 + 30  => 45
		*	- String concatenation: 45 + "Hello" => "45Hello"
		*/
		System.out.println(15 + 30 + "Hello");		// Result: 45Hello

		/*
		* Operation order
		* 	- String concatenation: "" + 15 	=> "15"
		*	- String concatenation: "15" + 30 	=> "1530"
		*	- String concatenation: "1530" + "Hello" => "1530Hello"
		*/
		System.out.println("" + 15 + 30 + "Hello");	// Result: 1530Hello

		/*
		* String concatenation operator (+)
		* either operand MUST BE A STRING
		* 
		*/
		System.out.println(
			"Increment before using nb1 : " 
			+ (++nb1)
			+"\nDecrement the value shown before before using it : "
			+ (--nb1)
			+"\nIncrement the value shown before after showing it"
			+ (nb++)
			+"\nShow value incremented: "
			+nb1 
		);

		
	}


}