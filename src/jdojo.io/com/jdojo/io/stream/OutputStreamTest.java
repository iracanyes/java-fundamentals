/*
* The "OutputStream" class is an abstract superclass that represents 
* an output of bytes.
* We must use one of its subclasses if we want access its functionality.
*	- FileOutputStream
*	- ByteArrayOutputStream
*	- ObjectOutputStream
*
* The OutputStream class provides different methods that are implemented
* by its subclasses. Here are some of the methods:
*	- write()
*	- write(byte[] array)
*	- flush()
*	- close()
*/
package com.jdojo.io.stream;

import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class OutputStreamTest{
	public static void main(String[] args) {
		try{
			output("Text computed into OutputStreamTest.java file by executing the command below :\n\tjava -p lib -m jdojo.io/com.jdojo.io.stream.OutputStreamTestls  ");
			readFile();
		}catch(Exception e){
			System.out.printf("An error occured.\n%s", e.getMessage());
		}
	}

	public static void output(String data)throws IOException{
		String filepath = "output.txt";
		/*
		* Here we create an OutputStream of type FileOutputStream and
		* link the output stream to the file "output.txt".
		* The file will created in the directory in which you launch the command
		* If you want to create the fill in another directory you must set the path to the file
		*
		* By using a try-with-resources statement, we don't have to 
		* call the close() method for cleaning the resources after usage.
		*/
		try(
			OutputStream out = new FileOutputStream(filepath);
		){
			// Convert the string into bytes
			byte[] dataBytes = data.getBytes();

			// write data to the output stream
			out.write(dataBytes);
			System.out.println("Data is written to the file.");

		}
	}

	public static void output(String data, String filepath)throws IOException{
		/*
		* Here we create an OutputStream of type FileOutputStream and
		* link the output stream to the file "output.txt".
		* By using a try-with-resources statement, we don't have to 
		* call the close() method for cleaning the resources after usage.
		*/
		try(
			OutputStream out = new FileOutputStream(filepath);
		){
			// Convert the string into bytes
			byte[] dataBytes = data.getBytes();

			// write data to the output stream
			out.write(dataBytes);
			System.out.println("Data is written to the file.");


		}
	}

	public static void readFile(){
		String filepath = "output.txt";
		try(
			FileReader fReader = new FileReader(filepath);
			BufferedReader bReader = new BufferedReader(fReader);
		){
			String line;
			int lineNumber = 1;

			while((line = bReader.readLine()) != null){
				System.out.printf("%d# %s", lineNumber, line);
			}
		}catch(FileNotFoundException e){
			System.out.printf("Sorry, file not found.\n%s\n", e.getMessage());
		}catch(IOException e){
			System.out.println("An I/O error occured.\n" + e.getMessage());
		}
	}

	public static void readFile(String filepath){
		try(
			FileReader fReader = new FileReader(filepath);
			BufferedReader bReader = new BufferedReader(fReader);
		){
			String line;
			int lineNumber = 1;

			while((line = bReader.readLine()) != null){
				System.out.printf("%d# %s", lineNumber, line);
			}
		}catch(FileNotFoundException e){
			System.out.printf("Sorry, file not found.\n%s\n", e.getMessage());
		}catch(IOException e){
			System.out.println("An I/O error occured.\n" + e.getMessage());
		}
	}
}