package com.jdojo.operator;

/*
* Operators 	Meaning 					Type 	Usage 			Result
* 	! 			Logical NOT 				Unary 	!true 			false
* 	&& 			Short-circuit AND 			Binary 	true && true 	true
* 	& 			Logical AND 				Binary 	true & true 	true
* 	||		 	Short-circuit OR 			Binary 	true || false 	true
* 	| 			Logical OR 					Binary 	true | false 	true
* 	^ 			Logical XOR (Exclusive OR) 	Binary 	true ^ true 	false
* 	&= 			AND assignment 				Binary 	test &= true
* 	|= 			OR assignment 				Binary 	test |= true
* 	^= 			XOR assignment 				Binary 	test ^= true
*/
public class BooleanLogicalOperators{
	public static BooleanLogicalOperators(){}

	public void notLogicalOperator(){
		/*
		* Logical NOT (!)
		* returns true if operand is false, and false if the operand is true.
		*/
		boolean b;
		b = !true; // Assigns false to b
		b = !false; // Assigns true to b
		int i = 10;
		int j = 15;
		boolean b1 = true;
		b = !b1; // Assigns false to b
		b = !(i > j); // Assigns true to b, because i > j returns false

		b = !b; // Assigns true to b if it was false and false if it was true

	}

	public void shortCircuitAndLogicalOperator(){
		/*
		* operand1 && operand2
		* Returns true if both operands are true or false,
		* If either operand is false, it returns false.
		* It's a short-circuit because if left-hand operand is false, it returns false without evaluating the right-hand operand
		*/
		int i = 10;
		int j = 25;
		boolean b = ( i < 20 && j > 25);	// False

		int i = 10;
		int j = 10;
		boolean b = (i > 5 && ((j = 20) > 15));
		System.out.println("b = " + b);
		System.out.println("i = " + i);
		System.out.println("j = " + j);

		int i = 10;
		int j = 10;
		boolean b = (i > 5 && ((j = 20) > 15));
		System.out.println("b = " + b);
		System.out.println("i = " + i);
		System.out.println("j = " + j);
		System.out.println ("j = " + j); // Will print j = 10
	}

	public void andLogicalOperator(){
		/*
		* operand1 & operand2
		* Returns true if both operands are true.
		* If either operand is false, it returns false.
		* IMPORTANT: It's evaluate the right-hand operand even if the left-hand is false
		*/
		int i = 10;
		int j = 15;
		boolean b;
		b = (i > 5 & j > 10); // Assigns true to b
		b = (i > 25 & ((j = 20) > 15)); // ((j = 20) > 5) is evaluated even if i > 25 returns false
		System.out.println ("b = " + b);
		System.out.println ("i = " + i);
		System.out.println ("j = " + j); // Will print j = 20

	}

	public void shortCircuitOrLogicalOperator(){
		/*
		* operand1 || operand2
		*
		* Returns true if either operand is true. 
		* If both operands are false, it returns false
		* It's called short-circuit OR because if operand1 is evaluated to true, the second operand is not evaluated
		* 
		*/
		int i = 10;
		int j = 15;
		boolean b = (i > 5 || j > 10); // Assigns true to b. j is not evaluated

		int i = 10;
		int j = 15;
		boolean b = (i > 20 || j > 10); // Assigns true to b
	}

	public void orLogicalOperator(){
		/*
		* operand1 | operand2
		* Returns true if either operands is true. 
		* If both operands are false, it returns false.
		* IMPORTANT: If operand1 is true, operand2 will also be evaluated
		*/
		int i = 10;
		int j = 15;
		boolean b = (i > 5 | j > 10); // Assigns true to b. 
									  // Even if if i > 5 is true, j > 10 will be evaluated

	}

	public void xorLogicalOperator(){
		/*
		* operand1 ^ operand2
		* 
		* Returns true if operans1 and operand2 are different.
		* Returns true if one of the operands is true, BUT NOT BOTH
		*/
		int i = 10;
		boolean b;
		b = true ^ true; // Assigns false to b
		b = true ^ false; // Assigns true to b
		b = false ^ true; // Assigns true to b
		b = false ^ false; // Assigns false to b
		b = (i > 5 ^ i < 15); // Assigns false to b
	}

	public void compoundBooleanLogicalAssigmentOperators(){
		/*
		* 	Expression 					Is Equivalent To
		* 	operand1 &= operand2 		operand1 = operand1 & operand2
		* 	operand1 |= operand2 		operand1 = operand1 | operand2
		* 	operand1 ^= operand2 		operand1 = operand1 ^ operand2
		*/

		// If both operands evaluate to true, &= returns true. Otherwise, it returns false.
		boolean b = true;
		b &= true; // Assigns true to b
		b &= false; // Assigns false to b

		// If either operand evaluates to true, |= returns true. 
		// Otherwise, it returns false.
		boolean b = false;
		b |= true; // Assigns true to b
		b |= false; // Assigns false to b
		
		// If both operands evaluate to different values, that is, one of the operands is true but not both, ^= returns
		// true. Otherwise, it returns false.
		boolean b = true;
		b ^= true; // Assigns false to b
		b ^= false; // Assigns true to b



	}

	public void ternaryOperator(){
		/*
		* boolean-expression ? statement1 : statement2 
		* If the boolean-expression is evaluated to true, it evaluate the statement1
		* If the boolean-expression is evaluated to false, it evaluate the statement2
		*/
		int num1 = 50;
		int num2 = 25;
		// Assigns num2 to minNum, because num2 is less than num1
		int minNum = (num1 < num2 ? num1 : num2);

	}