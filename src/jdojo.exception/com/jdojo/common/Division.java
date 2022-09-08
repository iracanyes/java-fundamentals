package com.jdojo.common;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.ArithmeticException;

public class Division{
	public static void main(String[] args) {
		int x, y;
		double z;
		Scanner stdin = new Scanner(System.in);

		try{
			// Inputs 
			System.out.println("Enter an integer : ");
			x = stdin.nextInt();

			System.out.println("Enter another integer : ");
			y = stdin.nextInt();

			// Division
			z = (double) x / y;
			System.out.printf("Division :\n%d / %d = %f", x, y, z);
		}catch(InputMismatchException e){
			System.out.println("Your input is incorrect!");
			String message = e.getMessage();
			System.out.printf("Error : %s", message);
		}catch(ArithmeticException e){
			System.out.printf("Arithmetic Exception : %s", e.getMessage());
		}
		

	}
}