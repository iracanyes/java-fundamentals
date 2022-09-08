package com.jdojo.statement;

import java.util.Scanner;

public class UserInput{
	// Constructor
	// public static void UserInput(){}

	public static void main(String[] args){
		/*
		* Scan for input stream
		*/
		Scanner input = new Scanner(System.in);

		int month;

		do{
			System.out.println("Enter a month[1-12]: ");

			/* Read an input from the user
			* 
			*/
			month = input.nextInt();
		}while(month <= 1 || month >= 12); // If input isn't int or between 1 and 12. repeat action!

		System.out.println("You entered: " + month);
	}
}