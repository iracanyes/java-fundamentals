package com.jdojo.exception;

public class FinallyBlock{
	public static void main(String[] args) {
		/*
		* A finally block is always executed non matter what happens 
		* in the try block.
		* When you want to execute a set of code 1 and no matter what happens to the set 1
		* you want that a second set of code is executed.
		* In such case, it's interesting to use a try-finally or try-catch-finally block 
		* Ex: database transaction or file input/output which can fail
		*/
		try{
			// Execute
			int x = 10,
				y = 0,
				z;
			System.out.println("Before an attempt to divide by 0 in Java");
			z = x / y;
			System.out.println("If you see this, it's a miracle.");
		}finally{
			System.out.println("Sorry the operation of division by 0 cannot be performed in Java!");
		}


		/*
		* Here, we try the code in the try block and catch exception
		* an after execute the finally block statement.
		* 
		*/
		try{
			System.out.println("INSIDE TRY BLOCK");
			// Execute
			int x = 10,
				y = 0,
				z;
			System.out.println("Before an attempt to divide by 0 in Java");
			z = x / y;
			System.out.println("If you see this, it's a miracle.");
		}catch(ArithmeticException e){
			System.out.println("INSIDE CATCH BLOCK");
			e.printStackTrace();
		}finally{
			System.out.println("INSIDE FINALLY BLOCK");
			System.out.println("Sorry the operation of division by 0 cannot be performed in Java!");
		}

		try{
			System.out.println("INSIDE TRY BLOCK");
			System.exit(0);
			System.out.println("If you see this, it's a miracle.");
		}finally{
			// This block will never be executed because the program exits in try-block
			// When an Error appears, the finally block also will never be executed.
			System.out.println("INSIDE FINALLY BLOCK");
		}
	
	}
}