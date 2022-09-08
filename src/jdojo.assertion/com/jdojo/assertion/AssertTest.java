/*
* Assertion serve to state something in a strong, confident, and forceful way.
* In Java, it lets you assert a condition to be true at a specific point
* To enable assertion test, you need to add an option to your launch command:
* Assertion should be enabled in development and testing environments.
* In production, assertion will stop the program so it's not productive to use them.
* Assertion statement are written in 2 forms:
*	- assert booleanAssertionExpression;
*	- assert booleanAssertionExpression : errorMessageExpression;
*
* The boolean assertion expression that assert the condition you believe to be true.
* The error message expression allow to specify a custom error message 
*
* An exception is used to handle user's error and business rules implementation.
* You may recover from an exceptional conditions.
* An assertion is used to detect programming errors made by programmers.
* Assertions verify that what a programmers assume about this program at a specific point in his code is true.
* As assertions are not meant to be enabled in the production environment, you can't use them to handle a user's error
* or validating data.
*
* Command:
*	Run without assertion: 
*		java -p lib -m jdojo.assertion/com.jdojo.assertion.AssertTest
*	Run with assertion:
*		java -ea -p lib -m jdojo.assertion/com.jdojo.assertion.AssertTest
*/
package com.jdojo.assertion;

import java.util.Scanner;

public class AssertTest{
	public static void main(String[] args) {
		boolean enabledAssertion = false;

		simpleAssertion();
		assertDividerNotZero();

		assert enabledAssertion = true : "If you can see this => Assertion enabled!";
		
	}

	public static void simpleAssertion(){
		int x = 10 + 26;
		// Here, we assert that x is equal to 36
		// Signature : assert booleanAssertionExpression
		assert x == 36;	// Should throw an AssertionError

		// If the assertion is false an AssertionError is thrown
		assert x == 37;	// Should throw an AssertionError
	}

	/*
	* If you run the program without assertion disabled.
	* The below error message will be thrown:
	*	Exception in thread "main" java.lang.ArithmeticException: / by zero
    *    at jdojo.assertion/com.jdojo.assertion.AssertTest.assertDividerNotZero(AssertTest.java:43)
    *    at jdojo.assertion/com.jdojo.assertion.AssertTest.main(AssertTest.java:20)
	*
	* If you run the programs with assertion enabled.
	* The below error message will be thrown:
	* 	Exception in thread "main" java.lang.AssertionError: Divider must be greater than zero!
    *    at jdojo.assertion/com.jdojo.assertion.AssertTest.assertDividerNotZero(AssertTest.java:41)
    *    at jdojo.assertion/com.jdojo.assertion.AssertTest.main(AssertTest.java:20)
	*/
	public static void assertDividerNotZero(){
		Scanner stdin = new Scanner(System.in);
		System.out.println("Division x / y");
		System.out.println("Enter an integer x as the dividend : ");
		int x = stdin.nextInt();
		System.out.println("Enter an integer y as the divider: ");
		int y = stdin.nextInt();

		// Here we assert that the divider is not zero
		assert y != 0 : "Divider must be greater than zero! Your divider: " + y;

		int z = x / y;
		System.out.println("Result : " + z);

	}
}