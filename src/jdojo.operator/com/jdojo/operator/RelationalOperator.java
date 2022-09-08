package com.jdojo.operator;

public class RelationalOperator{
	public void equalityOperator(){
		/*
		* Equity comparator
		*	- both operands must be either primitive type or reference type. 
		*	  Mixed operands types is not allowed
		*	- For primitive operands, returns true if both operands represent the same value;
		*	  otherwise, it returns false. 
		*	  	- Both operands MUST be either numeric or boolean.
		*		  A mix of numeric and boolean types is not allowed
		*/			 
					
		int i,j,k;
		i = j = k = 15;
		// Uncomment 
		//boolean bol = (i == j == k);	//  Error. i == j is true but true == k is not allowed	

		// 1. Both negative zero(-0.0) and positive zero(0.0) are equal
		double d1 = 0.0;
		double d2 = -0.0;
		boolean bZero = (d1 == d2);		// True

		// 2. Positive and negative infinities are unequal
		double d1 = Double.POSITIVE_INFINITY;
		double d2 = Double.NEGATIVE_INFINITY;
		boolean b = (d1 == d2); // Assigns false to b

		// 3. If either operand is NaN, the equality test returns false
		double d1 = Double.NaN;
		double d2 = 3.5;
		boolean b = (d1 == d2); // Assigns false to b

		// To test if a variable is NaN.
		// Float and Double class have an method isNaN(), which accept
		b = Double.isNaN(d1);	// Return true
		float f1 = 3.5f;
		b = Float.isNaN(f1);	// True. 

		/*4. NEVER test to String for equality
		* The operator 'new' always create new object into memory. 
		* Therefore, str1 and str2 are two different object.
		*/
		String str1 = new String("Hello");
		String str2 = new String("Hello");
		boolean b;
		b = (str1 == str2); // Assigns false to b 

		// To compare 2 object of type String for equality. 
		// Each object String created, has a method .equals(String str) to compare to other String objects
		b = str1.equals(str2);	// True

		/* IMPORTANT: FLOAT ARE NOT EQUAL TO DOUBLE OF SAME VALUE
		*	d1 == d1 return false
		*	d1 != d1 return true
		*/
		b = 2.2f == 2.2d;	// False! 
		b = -2.2f == -2.2d;	// False! 


	}


	public void inequalityOperator(){
		/*
		* operand1 != operand2
		*
		* The rules for equality operator are also applied for inequality
		* Returns TRUE if operand1 and operand2 are not equal. Otherwise, returns FALSE
		*/
		int i = 25;
		int j = 15;
		int k = 15;
		boolean b;

		b = (i != j);	// True
		b = (i != k);	// True
		b = (j != k);	// False
		b = (true != true);	// False
		b = (true != false);	// True

		/*
		* For float and double,
		* If either operand is NaN, the inequality operator returns true.
		*/
		float fn = FLoat.NaN;
		float f1 = 2.2f;
		double d1 = 2.2d;

		b = (fn != f1);		// True

		/* IMPORTANT: FLOAT ARE NOT EQUAL TO DOUBLE OF SAME VALUE
		* If d1 is a floating-point variable
		*	d1 == d1 return false
		*	d1 != d1 return true
		*	-d1 != -d
		*/
		b = 2.2f != 2.2d;	// True! (approx numbers)
		b = -2.2f != -2.2d;	// False! (negative numbers are exact)
	}

	public void greaterThanOperator(){
		/*
		* operand1 > operand2
		* Returns true if the operand1 is greater than operand2
		*
		*/
		int i = 10;
		int j = 15;
		double d1 = 2.2d;
		double dn = Double.NaN;
		boolean b;

		b = (i > j);	// False
		b = (j > i);	// True
		b = (d1 > Double.NaN);	// False

		/*
		* Reference type cannot be compared by operator ">, <, <=, >="
		*/
		String str1 = "Hello";
		String str2 = "HelloWorld";
		
		// Compile-time Error
		// b = (str1 > str2);	
		
		/*
		* To test the length of string, use method 'length()' of class String
		* which returns the number of character of the String object
		*/
		int i = str1.length();					// Assign 5 to i.
		b = (str1.length() > str2.length());	// False
		b = (str2.length() > str1.length());	// True

	}

	public void greaterThanOrEqualOperator(){
		/*
		* operand1 >= operand2
		*
		* Greater than or equal to operator return true if operand1 is greater or equal to operand2
		* Otherwise, it returns false.
		* 
		*/
		// It can be applied to primitive numeric types. 
		int i = 10;
		int j = 10;
		boolean b;
		b = (i >= j); // Assigns true to b
		b = (j >= i); // Assigns true to b

		// If either operands is NaN, operator returns false
		b = (2.2f >= Float.NaN);	// False
	}

	public void lessThanOperator(){
		/*
		* operand1 < operand2
		* Less than operator return true if operand1 is less than operand2
		* The operator can be used ONLY with primitive numeric data types.
		*/
		int i = 10;
		int j = 15;
		double d1 = Double.NaN;
		boolean b;
		b = (i < j); // Assigns true to b
		b = (j < i); // Assigns false to b
		// A compile-time error. < cannot be used with boolean operands
		// b = (true < false);
		b = (d1 < Double.NaN); // Assigns false to b
	}

	public void lessThanOrEqualOperator(){
		/*
		* schema: operand1 <= operand2
		* Returns true if the value of operand1 is less than or equal to value of operand2, otherwise returns false.
		* Operator can be used ONLY with primitive numeric data type.

		*/
		int i = 10;
		int j = 10;
		int k = 15;
		boolean b;
		b = (i <= j); // Assigns true to b
		b = (j <= i); // Assigns true to b
		b = (j <= k); // Assigns true to b
		b = (k <= j); // Assigns false to b

		// If either of the operands is NaN (float or double), 
		// the less than or equal to operator returns false
		b = 2.2f <= Float.NaN;	// False
	}
}