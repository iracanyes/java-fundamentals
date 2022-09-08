package com.jdojo.common;

import com.jdojo.exception.InitializersAndCheckedException;

public class InitializersAndCheckedExceptionTest{
	public static void main(String[] args) {
		try{
			InitializersAndCheckedException iace = new InitializersAndCheckedException();
		}catch(ArithmeticException e){
			System.out.printf("Error catched in main() method : %s\n", e.getMessage());
		}
	}
}