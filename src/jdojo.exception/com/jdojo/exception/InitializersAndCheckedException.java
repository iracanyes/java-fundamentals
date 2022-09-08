package com.jdojo.exception;

public class InitializersAndCheckedException{
	/*
	* You cannot throw a checked exception from a static initializer.
	* If a checked exception is thrown inside the static initializer,
	* it must be handled inside a try-catch block inside the static initializer
	*/
	static {
		System.out.println("INSIDE STATIC INITIALIZER");
		// MUST USE A TRY-CATCH BLOCK HANDLE CHECKED EXCEPTION
		try{
			int x = 45;
			int y = 0;
			double z = (double) x / y;
		}catch(ArithmeticException e){
			System.out.printf("Arithmetic error : %s", e.getMessage());
		}
	}

	/*
	* As instance initializer are part of a constructor invocation for the class
	* it may throws checked exception from instance initializer but
	* all the exception thrown by instance initializer MUST be declared in the throws clause 
	* of all the constructors of the object
	* of 
	*/
	{
		int x = 78;
		int y = 0;

		double z = (double) x / y;
	}

	/*
	* If a constructor throws an exception , this exception must be handled 
	* at the creation of objects of this class.
	* See: jdojo.exception/com.jdojo.common.InitializersAndCheckedExceptionTest
	*
	*/
	public InitializersAndCheckedException() throws ArithmeticException{

	}
}

