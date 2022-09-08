package com.jdojo.operator;

public class BitwiseOperators{
	/*
	* A bitwise operator is an operator that performs an action on its integer operands using their bit patterns
	*
	* Operators 			Meaning 						Type 	Usage 	Result
	* 	& 					Bitwise AND 					Binary 	25 & 24 	24
	*	| 					Bitwise OR 						Binary 	25 | 2 		27
	*	^ 					Bitwise XOR 					Binary 	25 ^ 2 		27
	*	~ 					Bitwise NOT (1's complement) 	Unary 	~25 		-26
	*	<< 					Left shift 						Binary 	25 << 2 	100
	*	>> 					Signed right shift 				Binary 	25 >> 2 	6
	*	>>> 				Unsigned right shift 			Binary 	25 >>> 2 	6
	*	&=, !=, ^=, <<=,	Compound assignment bitwise 	Binary
	*	>>=, >>>=			operators
	*	
	* All bitwise operators work with integers
	*	
	
	*/
	public void andBitwiseOperator(){
		/*
		* The bitwise AND (&) operator operates on corresponding bits of its two operands and 
		* returns 1 if both bits are 1 and otherwise 0.
		* Note that the bitwise AND (&) operates on each bit of the respective operands, not on the operands as a whole.
		* Result :
		* 	1 & 1 = 1
		*	1 & 0 = 0
		*	0 & 1 = 0
		*	0 & 0 = 0
		*/

		/*
		* 13 		00000000 00000000 00000000 00001101
		* 3 		00000000 00000000 00000000 00000011
		* ----------------------------------------------
		* 13 & 3 - 	00000000 00000000 00000000 00000001 (Equal to decimal 1)
		*/
		int i = 13 & 3;		// i equal 1



	}

	public void orBitwiseOperator(){
		/*
		* operand1 | operand2
		* The bitwise OR (|) operates on corresponding bits of its operands and 
		* returns 1 if either or both bit is 1, and 0 otherwise. 
		* The following is the result of all bit combination using the bitwise OR (|) operator.
		*	1 | 1 = 1
		*	1 | 0 = 1
		*	0 | 1 = 1
		*	0 | 0 = 0
		*/

		/*
		* 	13 		00000000 00000000 00000000 00001101
		*	3 		00000000 00000000 00000000 00000011
		*	--------------------------------------------
		*	13 | 3 	00000000 00000000 00000000 00001111 (Equal to decimal 15)
		*/
		int i = 13 | 3;		// Result: 15
	}

	public void xorBitwiseOperator(){
		/*
		* The bitwise XOR (^) operates on corresponding bits of its operands and returns 1 if only one of the
		* bits is 1. Otherwise, it returns 0. The following is the result of all bit combinations using the bitwise XOR (^)
		* operator.
		* 	1 ^ 1 = 0
		* 	1 ^ 0 = 1
		* 	0 ^ 1 = 1
		*	0 ^ 0 = 0
		*/
		/*
		* 	13 		00000000 00000000 00000000 00001101
		*	3 		00000000 00000000 00000000 00000011
		*	-------------------------------------------
		*	13 ^ 3 	00000000 00000000 00000000 00001110 (Equal to decimal 14)
		*/
		int i = 13 ^ 3;
	}

	public void notBitwiseOperator(){
		/*
		* The bitwise NOT (~) 
		* Operates on each bit of its operand. It inverts the bits, that is, 1 is changed to 0 and 0
		* is changed to 1. It is also called a bitwise complement operator. It computes 1's complement of its operand.
		* Following is the result of all bit combinations using the bitwise NOT (~) operator.
		* 	~1 = 0
		* 	~0 = 1
		*/
		/*
		* 	13 		00000000 00000000 00000000 00001101
		* 	------------------------------------------
		*	~13 	11111111 11111111 11111111 11110010 (Equal to decimal -14)
		*/
		int i = ~13;
	}

	public void leftShiftBitwiseOperator(){
		/*
		* The bitwise left shift operator (<<) shifts all the bits to the left by the number of bits specified as its
		* right-hand operand.
		* It inserts zeros at the lower order bits
		* The effect of shifting 1 bit to the right is the same as multiplying the number by 2.
		* Ex: 
		* 	9 << 1 = 18
		*	9 << 2 = 36
		*	13 << 1 = 26 
		*	13 << 2 = 52	
		*	13 << 3 = 104
		*   13 << 4 = 208
		*	13				|00000000	00000000	00000000	00001101|
		*					|											|
		*	13 << 4 	0000|00000000	00000000	00000000	11010000|
		*				 ^		<------------------------------      ^
		*				 |		All bits shifted 4 bits to left		 |
		*			4 bits ignored								four 0 bits added 
		*/
		
		/*
		* As 13 is an int literal (32bits), u can only shift left by a maximum of 31 bits!
		*
		* If the operand1 of bitwise left shift (<<) is INT, 
		* only five lower order bits value of the operand2 is used as the number to shift.
		* Ex: 13 << 35
		* 	35 in binary: 00000000 00000000 00000000 00100011
		*												----- Only the five lower order bits considered
		*	00011 = 3
		*	13 << 35 is equivalent to 13 << 3
		* For int, to know the number of left-shift executed u can use modulus of 32.
		* The result will be the number of left-shift applied for a given number
		* Memo: 
		*	35 % 32 = 3; 
		*	31 % 32 = 31;
		*/
		int i  = 9 << 1;	// Result = 18
		i = 9 << 1;			// Result = 18
		i = 9 << 2;			// Result = 36
		i = 13 << 1;		// Result = 26 
		i = 13 << 2;		// Result = 52	
		i = 13 << 3;		// Result = 104		
		i = 13 << 4;		// Result = 208
		i = 13 << 35;		// Result = 104
		i = 13 << 36;		// Result = 208

		/* operand1 << operand2
		* If the operand1 is a LONG,
		* The first 6 lower order bits value of the operand2 are considered as the numbers of bits to shift
		*/
		long l1 = 13;
		long res;

		/*
		* Ex: 13 << 35
		* 	35 in binary: 00000000 00000000 00000000 00100011
		*											   ------ Only the five lower order bits considered
		*	100011 = 35
		*	13 << 35 
		*	13				|00000000	00000000	00000000	00000000|00000000	00000000	00000000	00001101|
		*					|											|
		*	13 << 35 	0000|00000000	00000000	00000000	01101000|00000000	00000000	00000000	00000000|
		*				 ^		<------------------------------      	 ^
		*				 |		All bits shifted 35 bits to left		 |
		*			35 bits ignored								35 0 bits added
		*/
		res = l1 << 35; 	// Result: 446_676_598_784


	}

	public void bitwiseSignedRightShiftOperator(){
		/*
		* operand1 >> operand2
		*
		* Shift all the bits to the right by the number specified as 
		* its right-hand operand
		* 
		* If the most significant digit of the left-hand operator is 0 (positive number),
		* all higher order bits are filled with 0s after shift operation
		* 
		*
		*	13		|00000000 00000000 00000000 00001101|
		* 	13 >> 4 |00000000 00000000 00000000 00000000| 11010000
		*	------------------------------------------------
		*	0 		|00000000 00000000 00000000 00000000|
		*
		* If the most significant digit of the left-hand operator is 1 (negative number),
		* all higher order bits are filled with 1s after shift operation. 
		*
		*	13		 |00000000 00000000 00000000 00000000|
		* 	-13 >> 4 |11111111 11111111 11111111 11111111|0011  
		* 	--------------------------------------------------
		*	-1		 |11111111 11111111 11111111 11111111|
		*
		* Because the sign bit after the right-shift operation (>>) remains the same.
		* It's called Signed right shift operation
		*/
		int i = 13 >> 4;	// Result : 0
		i = -13 >> 4;		// Result: -1
	}

	public void unsignedRightShiftOperation(){
		/*
		* operand1 >>> operand2
		* The unsigned right shift operation works the same as the signed one.
		* except that it will fill the higher order bits with zero.
		*
		* 
		*
		*	13		 |00000000 00000000 00000000 00001101|
		* 	13 >>> 4 |00000000 00000000 00000000 00000000| 11010000
		*	------------------------------------------------
		*	0 		 |00000000 00000000 00000000 00000000|
		*
		*
		*	13		 	|00000000 00000000 00000000 00000000|
		* 	-13 >>> 4 	|11111111 11111111 11111111 11111111|0011  
		* 	--------------------------------------------------
		*	268435455	|00001111 11111111 11111111 11111111|
		*
		*/
		int i = 13 >> 4;	// Result : 0
		i = -13 >> 4;		// Result: 268435455
	}


	public void compoundBitwiseOperator(){
		/*
		* schema: operand1 op= operand2
		*			operand1 = (Type of operand1) (operand1 op operand2)
		* 
		* Here, 'op' is one the following bitwise operator [&,|,^,<<,>>,>>>]
		* Operand MUST be of integer data type, where operand1 MUST is a variable.
		*
		* 	Expression 		Is Equivalent To
		*	  i &= j 		i = i & j
		*	  i |= j 		i = i | j
		*	  i ^= j 		i = i ^ j
		*	  i <<= j 		i = i << j
		*	  i >>= j 		i = i >> j
		*	  i >>>= j 		i = i >>> j
		*/
		int i = 13;

		i = 13;
		i &= 3;		// i equal 1

		i = 13;
		i |= 3;		// Result: 15

		int i = 13;
		i ^= 3;		// Result = 14

		int i  = 9;
		i <<= 1;	// Result = 18

		i = 9;
		i <<= 2;			// Result = 36
		i = 13;
		i <<= 1;		// Result = 26 
		i = 13;
		i <<= 2;		// Result = 52	
		i = 13;
		i <<= 3;		// Result = 104		
		i = 13;
		i <<= 4;		// Result = 208
		i = 13;
		i <<= 35;		// Result = 104
		i = 13;
		i <<= 36;		// Result = 208
		
		i = 13
		i <<= 35; 	// Result: 446_676_598_784

		i = 13;
		i >>= 4;	// Result : 0
		
		i = -13;
		i >>= 4;		// Result: -1
		
		i >>= 4;		// Result : 0
		i = -13;
		i >>= 4;		// Result: 268435455
	}
}