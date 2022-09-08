package com.jdojo.io.text;

import java.io.IOException;

public class SystemIn{
	public static void main(String[] args) {
		
	}

	
	public static char readChar(){
		char c = '\u0000';
		try{
			
			/*
			* INPUT - USING SYSTEM.IN
			*/
			System.out.println("Enter byte type digit [0-255] : ");
			/*
			* Reads byte number from standard input. 
			* it returns the value of the byte as an int between 0 and 255.
			*/
			int input = System.in.read();
			System.out.printf("Byte input : %d", input);

			if(input != -1){
				c = (char) input;
			}
			

		}catch(IOException e){
			System.out.printf("%s\n%s\n", e.getMessage(), e.getStackTrace());
		}catch(Exception e){
			System.out.printf("Unhandled exception.\n%s", e.getMessage());
		}

		return c;
	}
}