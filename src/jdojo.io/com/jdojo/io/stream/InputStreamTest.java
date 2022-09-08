/*
* INPUT STREAM
* Doc: https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/io/InputStream.html
*
* Depending upon the data a stream holds, it can be of 2 types:
*	- Byte stream
*		Used to read and write a single byte (8bits) of data.
*		All byte stream class are derived from base abstract class "InputStream" and "OutputStream"
*	- Character stream
*		Used to read and write a single character of data
*		All the character stream classes are derived from base abstract classes "Reader" and "Writer"
*
* InputStream class of "java.io" is an abstract class superclass that represents an input stream of bytes.
* Its subclasses can be used to read data of bytes type:
*	- FileInputStream
*	- ByteArrayInputStream
*	- ObjectInputStream		
*/
package com.jdojo.io.stream;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputStreamTest{
	public static void main(String[] args) {
		String filepath = "C:\\Projets\\cours\\language\\java\\bj9f\\src\\jdojo.io\\com\\jdojo\\io\\stream\\InputStreamTest.java";
		/*
		* Here, we use try-with-resources statement to create resources which will be
		* automatically close at the end of execution of the statement.
		*
		* As InputStream is an abstract class, we must create a subclass of InputStream to 
		* use its methods.
		*/
		try(
			InputStream input = new FileInputStream(filepath);
		){
			// Read one byte of data from input stream 
			int oneByte = input.read();
			System.out.printf("Fisrt byte of the file : %d", oneByte);

			// Returns the number of bytes available in the input stream
			System.out.printf("Number of bytes in stream : %d\n", input.available());

			// Skips and discards the specified number of bytes from the input stream 
			input.skip(10);

			


			

			byte[] byteArray = new byte[100];
			
			// Reads bytes from the stream and stores in the specified array
			input.read(byteArray);
			System.out.printf("File as byte array: \n%s\n", byteArray);

			// boolean InputStream.markSupported()
			// Test if input stream supports the mark and reset methods.						
			if(input.markSupported()){
				// void InputStream.mark(int readLimit)
				// Marks the position to the point up to which data has been read
				input.mark(11);
			}

			// Reads all the remaining bytes
			input.readAllBytes();

			// Reads up to "length" bytes of data from the input stream and stores into an array of 
			// bytes at the "offset" given
			// byte[] InputStream.read(byte[] array, int offset, int length)
			input.read(byteArray, 0, 30);
			

		}catch(FileNotFoundException e){
			System.out.printf("File not found.\n%s", e.getMessage());
		}catch(IOException e){
			System.out.printf("I/O Exception.\n%s", e.getMessage());
		}
	}
}