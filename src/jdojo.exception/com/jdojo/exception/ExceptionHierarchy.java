package com.jdojo.exception;

import java.lang.Exception;
import java.util.InputMismatchException;

public class ExceptionHierarchy{
	public static void main(String[] args) {
		/*
		* The order of declaration of catch() block in a chained catch block
		* is very important. The exception class hierarchy may interfer with
		* the execution of a catch block
		* If a parent exception class is placed before its subtypes, 
		* the catch block which receive the parent exception class 
		* will always be executed first.
		*
		* In the example below,  catch(ArithmeticException) method will 
		* never be reached! As catch(Exception) accept as argument
		* all object which class is a subtype of Exception class
		*
		* Java will not allow the statement below.
		* Compiler generate an error:
		*	error: exception ArithmeticException has already been caught
		*/
		/*
		try{
			int x = 10;
			int y = 0;

			int z = x / y;

		}catch(Exception e){
			System.out.print("In Exception type catch block!");
		}catch(ArithmeticException e){
			System.out.print("In ArithmeticException type catch block!");
		}
		*/

		/*
		* Multiple catch blocks for a try block MUST be arranged from the 
		* most specific to the less specific 
		*/
		try{
			int x = 10;
			int y = 0;

			int z = x / y;

		// One catch block can handle multiple exception
		// the exceptions must be unrelated (not subtypes or superclass).	
		}catch(ArithmeticException | InputMismatchException e){
			System.out.print("In ArithmeticException type catch block!");
		
		}catch(RuntimeException e){

		}catch(Exception e){
			System.out.print("In Exception type catch block!");
		}
	}
}