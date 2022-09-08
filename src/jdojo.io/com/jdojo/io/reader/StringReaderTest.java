package com.jdojo.io.reader;

import java.io.StringReader;
import java.io.IOException;
import java.io.BufferedReader;

public class StringReaderTest{
	public static void main(String[] args) {
		/*
		* The StringReader class can be used to read data (in characters) from strings
		* The specified string acts as a source from where characters are read individually.
		*/
		readString();
	}

	public static void readString(){
		String data = "This the string provided to StringReader";
		System.out.printf("Original data: \n%s\n", data);
		// Create a character array
		char[] charArray = new char[100];

		try(StringReader reader = new StringReader(data)){
			/*
			* Check if the reader is ready
			*/
			System.out.println(
				(reader.ready()) 
					? "StringReader ready!"
					: "StringReady not ready"
			);

			/*
			* StringReader.skip(long n)
			* Allow to discard and skip characters
			*/
			int charSkipped = 5;
			reader.skip(charSkipped);


			/*
			* StringReader.read(String s)
			* Reads an array of characters from the reader and stores in the specified array
			* given in its arguments
			*/
			reader.read(charArray);
			System.out.printf("Data read from the string after skipping %d characters\n", charSkipped);
			System.out.println(charArray);

			// Mark the position in the stream
			int readAheadLimit = 10;
			reader.mark(readAheadLimit);
			System.out.printf("Position of Reader pointer : ", readAheadLimit);

		}catch(IOException e){
			// Do something 
			StackTraceElement[] ste = e.getStackTrace();

			System.out.println("An error occured :\n" + e.getMessage());
			
		}
	}


}