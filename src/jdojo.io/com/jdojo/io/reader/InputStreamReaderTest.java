/*
*
* InputStreamReader class can be used to convert data in bytes into data in characters.
* It extends the abstract class Reader.
* The InputStreamReader class works with other input streams.
* It's also known as a bridge between bytes streams and characters streams;
* because it reads bytes from the input stream as characters.
*
*For example, some characters requires 2 bytes to be stored in the storage
* To reach such data we can use InputStreamReader that reads the 2 bytes together
* and convert into the corresponding character.
*/

package com.jdojo.io.reader;

import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;


public class InputStreamReaderTest{


	public static void main(String[] args) {
		try{
			read();
			manipulateEncoding();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void read(){
		String filepath = "C:\\Projets\\cours\\langage\\java\\bj9f\\src\\jdojo.io\\com\\jdojo\\io\\reader\\InputStreamReaderTest.java";
		
		/*
		* The InputStreamReader class works with other input streams.
		* InputStream class is an abstract class.
		* Here, we use FileInputStream which extends 
		*/
		try(
			FileInputStream file = new FileInputStream(filepath);
			InputStreamReader reader = new InputStreamReader(file);
		){
			/* 
			* Read 
			* Signature : int read()
			* Reads a single character from the reader.
			* Return an integer represention of the character
			* To use the 
			*/
			int firstCharAsInt = reader.read();
			char firstChar = (char) firstCharAsInt;

			System.out.println("First character received as integer representation: " + firstCharAsInt);
			System.out.println("First character received: " + firstChar);
			
			System.out.println("---------------------------------------------------");

			/*
			* 
			*/
			int oneCharAsInt;
			while((oneCharAsInt = reader.read()) != -1){
				char oneChar = (char) oneCharAsInt;
				System.out.print(oneChar);
			}
			
			/*
			* InputStreamReader.read(char[] array)
			* Reads the characters from the reader and stores it in an array.
			*/
			char[] array = new char[60];

			reader.read(array);
			System.out.println("Array of characters - size : " + array.length);
			//System.out.println(array);
		}catch(FileNotFoundException e){
			System.out.printf("File not found.\n%s", e.getMessage());
		}catch(IOException e){
			System.out.printf("Input exception.\n%s", e.getMessage());

		}
	}

	public static void manipulateEncoding(){
		String filepath = "C:\\Projets\\cours\\language\\java\\bj9f\\src\\jdojo.io\\com\\jdojo\\io\\reader\\InputStreamReaderTest.java";
		try(
			FileInputStream fileInput = new FileInputStream(filepath);
			InputStreamReader inputReader = new InputStreamReader(fileInput);
			// Here, we set the file encoding of the fileInput received
			InputStreamReader inputReader2 = new InputStreamReader(fileInput, Charset.forName("UTF8"))
		){
			// Accessing the file encoding 
			System.out.println("File encoding : " + inputReader.getEncoding());

			// Accessing the file encoding of the second reader which is set to UTF8
			System.out.println("File encoding : " + inputReader2.getEncoding());

		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
}