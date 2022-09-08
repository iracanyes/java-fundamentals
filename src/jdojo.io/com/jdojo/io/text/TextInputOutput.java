package com.jdojo.io.text;

import java.util.Scanner;


public class TextInputOutput{
	public static void main(String[] args) {
		// Output text to console
		// without new line. it starts where the pointer is placed
		System.out.print("My output text with System.out.print()\\n\n");

		// Output a new line to console
		System.out.println("My output text with System.out.println()");

		/* Output a formatted string to console
		* Structure:
		*	System.out.printf(String s, )
		* Formatter:
		*	- %d => integer digits (byte, short, integer, long)
		*	- %Xd => integer (X minimum of digit)
		*	- %f => floating-point numbers (float and double)
		*	- %X.Yf => floating-point numbers (X=mininum integer digits and Y=minimum decimal digit)
		*	- %c => character
		*	- %s => string
		*/
		System.out.printf("Amoun%c : %3.3f\n%s : %4d\n",'t', 2000.3232,"Year", 2022);
		System.out.printf("Amount formatted with (%%1.2f) %1.2f$\n", 2000.3232);

		
		/*
		* INPUT _ SCANNER
		*/
		Scanner stdin = new Scanner(System.in);

		System.out.println("Enter a digit : ");
		/*
		*  throws an exception if the input type is from asked 
		*	java.util.InputMismatchException
		*/
		int inputInt = stdin.nextInt();
		System.out.println("You entered the digit : " + inputInt );
	} // end of main()
} // end of class Interest