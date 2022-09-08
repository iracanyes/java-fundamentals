/*
* Command:
*	Run: java -p lib -m jdojo.io/com.jdojo.io.common.Interest
*/
package com.jdojo.io.common;

import java.util.Scanner;
import java.lang.Math;

public class Interest{

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		double principal = 0.0;
		float interestRate = 0.0f;
		double interest = 0.0;

		System.out.println("Interest Calculation");
		
		System.out.println("Enter the initial investment : ");
		principal = stdin.nextDouble();

		System.out.println("Enter the interest rate : ");
		interestRate = stdin.nextFloat();

		// Check if number has a fractional 
		// Here we use modulo % 1 which return the rest of the division by 1
		// if 
		// by comparison 
		if(interestRate % 1 == 0.00f){
			interestRate /= 100;
		}

		interest = principal * interestRate;
		System.out.printf("Your interest will be : %1.2f", interest);
	}
}