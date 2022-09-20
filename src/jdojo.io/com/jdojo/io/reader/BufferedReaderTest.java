/*
* BUFFERED READER
* The BufferedReader class of java.io can be used with other readers to
* read data (in characters, arrays and lines) more efficiently.
*/
package com.jdojo.io.reader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileReader;

public class BufferedReaderTest{
	public static void main(String[] args) {
		// Here we use BufferedReader to read input from command line
		readInputCommandLine();

		// Here we use BufferedReader to read input from files
		// readInputFile();


	}

	public static void readInputCommandLine(){
		try(
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		){
			System.out.println("Enter an integer : ");
			int i1 = Integer.parseInt(bf.readLine().trim());

			System.out.println("Enter an float : ");
			int f1 = Float.parseInt(bf.readLine().trim());

			System.out.printf("Input received %nint: %d%nfloat: %f%n", i1, f1);
		}catch(IOException e){
			e.printStackTrace();
		}	


	}

	/*
	* Read input from files
	*/
	public static void readInputFile(){
		String filepath = "C:\\Projets\\cours\\language\\java\\bj9f\\src\\jdojo.io\\com\\jdojo\\io\\reader\\BufferedReaderTest.java";
		char[] charArray = new char[60];

		/*
		* The BufferedReader maintains an internal buffer of 8192 characters
		* During the read operation in BufferedReader, a chunk of characters is read
		* from the disk and stored in the internal buffer.
		* The internal buffer characters are read individually.
		*
		*/
		try(
			FileReader reader = new FileReader(filepath);
			/*
			* Default buffer is 8192 characters but
			* you can specify the size of the buffer
			* BufferedReader BufferedReader(Reader r, int size)
			*/
			BufferedReader bReader = new BufferedReader(reader, 12000)
		){
			// Check if the input is ready
			System.out.println("Input reader is ready : " + bReader.ready());

			// Reads a single character from the internal buffer of the reader
			int firstCharAsInt = bReader.read();
			char firstChar = (char) firstCharAsInt;

			System.out.println("First character : " + firstChar);
			System.out.println("First character as integer representation: " + firstCharAsInt);



			// Read a line of characters
			String firstLine = bReader.readLine();
			System.out.println("First line of the file : ");
			System.out.println(firstLine);

			// Skips the next 20 characters
			bReader.skip(20);


			// Read all characters from the reader's buffer and stores in an array
			bReader.read(charArray);

			System.out.println("Data in file: ");
			System.out.println(charArray);
			System.out.println("---------------------------------");

			// Empty the array
			charArray = new char[60];

			/*
			* BufferedReader.read(char[] array, int start, int lenght) read characters and store its in an array.
			* Reads the numbers of characters equals to 'length' from the reader
			* and stores in specified array starting from the position given in its argument. 'start'
			*/
			bReader.read(charArray, 0 , 21);
			System.out.println("Data of file from characters 0 to 21");
			System.out.println(charArray);
			System.out.println("---------------------------------");

			// Set a marker at the point in the stream to which data has been read so far.
			bReader.mark(12);

			charArray = new char[60];
			bReader.read(charArray);
			System.out.println("Data in file after 21 first characters : ");
			System.out.println(charArray);
			System.out.println("---------------------------------");

			// Returns to the point in input stream where the marker has been set before
			bReader.reset();

			charArray = new char[60];
			bReader.read(charArray, 0 , 20);
			System.out.println("Data in file after the marker ( 20 first characters ): ");
			System.out.println(charArray);
			System.out.println("---------------------------------");


		}catch(Exception e){
			System.out.printf("Error message : %s\n", e.getMessage());
			StackTraceElement[] ste = e.getStackTrace();

		}
	}
}
