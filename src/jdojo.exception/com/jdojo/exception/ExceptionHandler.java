/*
* Command:
*	Run: javac -p mod -d mod/jdojo.exception src/jdojo.exception/module-info.java src/jdojo.exception/com/jdojo/exception/* -Xdiags:verbose -Xlint:unchecked
*/
/*
* EXCEPTION 
* An exception is a condition that may arise during the execution of a Java programe,
* when a normal path of execution is not defined.
* e.g: catch(Object 0) will generate a compile time exception!
*  
* Exception hierarchy: 
*	Object => Throwable => Error => VirtualMachineError => OutOfMemoryError
*						=> Exception => RuntimeException => ArithmeticException, ,etc.
*									 => IOException => InputMisMatchException
*
* The exception class hierarchy start with Throwable class.
* If a exception is thrown, it MUST be an object of the Throwable class.
* The catch() method accept only objects of the class Throwable or its subtypes.
*
* 
* All Error class object cannot be handled in the code.
* Java runtime print the error message and halt the application
* 	Ex: OutOfMemoryError
* All the Exception class objects  can be handled by the code.
* The different type of exception:
*	- Checked exception: The runtime check if the exception are handled (Compiler warns you of their existence)
*	- Unchecked exception: The runtime doesn't check if they are handled (Error, RuntimeException and their subtypes which appears at runtime)
*
* Checked exception must be caught or declared to be thrown.
* The compiler will not allow compiling if a checked exception is unhandled or not declared in a throws clause
* The compiler even warns you if try to catch an exception that is not thrown from a try block.
*
* Unchecked exception appears during the runtime of the application.
*/
package com.jdojo.exception;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.IOException;

public class ExceptionHandler{
	public static void main(String[] args) {
		/*
		* 
		*
		* Ex: Dividing a integer by zero
		* As the result of such operation is not defined in Java,
		* The condition defined by Java is:
		*	An exception is thrown when a Java program attempts to divide an integer by zero 
		*/
		int  x = 10;
		int y = 0;
		int z = 0;

		// Error : java.lang.ArithmeticException: / by zero
		// z = x / y;

		if( y == 0){
			// Handle the exception
		}else{
			z = x / y;
		}


		/*
		* TRY-CATCH STATEMENT
		* 
		* The code that handle the actions is in the try block,
		* it may throw an exception
		* The code that handle exception is in the catch block,
		* it catch exception thrown from try block
		* 
		* The code that handles the exception is called exception handler.
		*
		* When an exception occurs, Java creates an object with all piece of information
		* about the exception (e.g. type of exception, line number in the code where the exception occured, etc. )
		* and passed it to the appropriate exception handler.
		* Throwing an exception means 3 things:
		*	- Occurence of an exceptional condition
		*	- Creation of a Java object to represent the exceptional condition
		*	- Throwing (or passing) the exception object to the exception handler
		*
		* A catch statement is a method which accept a reference of  the exception object in its argument
		* and take the appropriate actions and returns nothing.
		* It's called an exception handler.
		*/
		Scanner stdin = new Scanner(System.in);

		System.out.println("Enter an integer : ");
		/*
		* Here, Scanner.nextInt() throws an error when an unexpected input is given
		*  	Exception in thread "main" java.util.InputMismatchException
		* 		at java.base/java.util.Scanner.throwFor(Scanner.java:939)
        *		at java.base/java.util.Scanner.next(Scanner.java:1594)
        *		at java.base/java.util.Scanner.nextInt(Scanner.java:2258)
        *		at java.base/java.util.Scanner.nextInt(Scanner.java:2212)
        *		at jdojo.exception/com.jdojo.exception.Exception.main(Exception.java:62)
		*
		*
		* An exception contains the following information:
		*	- the threads in which it occurs 
		*	- the type of the exception that has occured.
		*		It indicated by the name of the class of the exception.
		*		Java create an object of the exception class and pass the reference
		*		to the exception handler
		*	- A message to describe the exceptional condition in the code that caused the error;
		*		As the exception is thrown after an input, you know that 
		*		the error is caused by the input so here no location is given
		*	- the location where the exception occured. 
		*		
		* 
		*
		* the solution to handle the exception is to make the statement into a try-catch statement
		*
		*/
		//int intValue = stdin.nextInt();

		try{

			int inValue = stdin.nextInt();
		}catch(InputMismatchException e){
			/* Here goes the code for handling the exception 
			* we print to console to exception object catched as string 
			*
			* Exception object that are not handled by any exception handler
			* are catched by Java runtime which print  the error stack
			* to the standard error output which is the console.
			* Exception object unhandled are called uncaught exception.
			* Java runtime halt the application after managing with uncaught exception.
			* Here by catching the exception and printing the error stack to standard error output
			* we allow the program to continue 
			*/
			e.printStackTrace();
		}

		/*
		* To allow a retry of the try block statement in case of exception thrown
		* when make a try-catch statement inside a loop (for, while, doWhile etc.)
		*
		* When an exception object is thrown from try block
		* Java runtime check catch methods signature to see if it can pass
		* the object to the corresponding catch() method signature.
		* 
		* Here, if an ArithmeticException type object is thrown,
		* Java runtime search for a catch() method signature corresponding catch(ArithmeticException)
		* If the signature doesn't correspond, it pass to next one in the chain
		* If non catch() method signature correspond. the exception object is 
		* passed to the parent caller context
		*/

		do{
			stdin.reset();
			try{
				System.out.println("Enter a float : ");
				float floatValue = Float.valueOf(stdin.nextFloat());

				System.out.println("Enter a float2 : ");
				float floatValue2 = Float.valueOf(stdin.nextFloat());

				// If no exception is thrown, the statement will executed
				// Here we know that the input is correct
				System.out.printf("Your input is : %1.2f\n", floatValue );
				System.out.println("Correct input!");
				stdin.close();		

			}catch(InputMismatchException e){

				System.out.println("Your input is not correct! Please retry.");
				// the scanner search and wait for another correct input
				stdin.next();
			}catch(ArithmeticException e){

			// As Exception is the superclass of all exception class
			// the catch block below will catch all exception,
			// including RuntimeException and all its subtypes.
			// Exception can therefore handle runtime exception and compile time exception	
			}catch(Exception e){

			}

			System.out.println("stdin.hasNextFloat() : " + stdin.hasNextFloat());
			

		}while(!stdin.hasNextFloat());	


		/*
		* Here, we call a method that throw an exception of type IOException
		*/	
		try{
			throwAnException(101);
		}catch(IOException e){
			System.out.println("IOException from method throwAnException has been catched!");
		}
		



		/*
		try{
			// Accept integer input
			int intValue2 = stdin.nextInt();

			// Connect to database

			// Fetch employee record
		
			// Update employee salary

			// Commit the changes
		
		}catch(InputMismatchException e){
			// Here we handle DB Connection error
		}catch(EmployeeNotFoundException e){
			// Here we handle Fetch emplo
		}catch(EmployeeUpdateException e){
			// Here we hange Employee update error
		}catch(CommitFailedException e){

		}
		*/

	}

	/*
	* If a method throws a checked exception that isn't handled by any exception handler inside the method
	* the compiler will not allow that.
	* The following error will be thrown
	*	unreported exception: class java.io.IOException; must be caught or declared to be thrown
	*
	*
	* The method can indicate that the exception will be handled in the method's caller context 
	* by using a throws clause
	* Structure:
	*	[modifiers] <return-type> <method-name>([parameters])[throws <list-of-comma-separated-exceptions>]
	*/
	public static void methodThrowException() throws ArithmeticException, IOException{
		int x = 20;
		int y = System.in.read();;
		double z = (double) x / y;


	}

	public static void throwAnException(int a) throws IOException{
		if(a < 100){
			/*
			* Throwing statement
			* Allow to throw an instance of Throwable class or subtypes to the caller context
			*/
			IOException e = new IOException("ThrowAnException() Argument mismatch");
			throw e;
		}
	}

}