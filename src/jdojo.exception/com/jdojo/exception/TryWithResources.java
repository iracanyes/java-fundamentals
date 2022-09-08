/*
* When you work with resources, such as file, database transactions, etc.
* you had to use a finally block with some boilerplate code to close the resources.
* See jdojo.io/com.jdojo.io.file.FileReaderTest
*
* Using try-with-resources statement, you only need to create the resource
* in the try block statement, the resource will be closed automatically at the end 
* of execution of the try-with-resources statement
* Signature:
*	try(AnyResource aRes = [create_a_resource]; AnyResource aRes2 = [create_resource_2]){
*		// use the resource aRes
*	}
* 
* Resources declared in a try-with-resources statement are final.
* Modification are not allowed. 
* The resources must be of type java.lang.AutoCloseable
* AutoCloseable interface contains a close() method. 
* When a program finish executing a try-with-resources statement,
* the close() method of all resources is called automatically.
* In case of multiple resources, the close() method is called 
* in the reserve order in which the resources are specified.
*/

package com.jdojo.exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import com.jdojo.common.AutoCloseableResource;

public class TryWithResources{
	public static void main(String[] args) {
		readFile();

		try{
			readFile("C:\\Projets\\cours\\language\\java\\bj9f\\src\\jdojo.exception\\com\\jdojo\\exception\\TryWithResources.java");
		}catch(IOException e){

		}

		// Use our own made AutoCloseable Resources
		// its close() method will be automatically called.
		try(AutoCloseableResource acr = new AutoCloseableResource(3, true)){
			acr.use();
			acr.use();
			acr.use();
		}catch(RuntimeException e){
			System.out.println("Error while using our custom AutoCloseableResource.");
			System.out.println(e.getMessage());
		}
	}

	public static void readFile(){
		try(
			Reader reader = new FileReader("C:\\Projets\\cours\\language\\java\\bj9f\\src\\jdojo.exception\\com\\jdojo\\exception\\TryWithResources.java");
			BufferedReader bReader = new BufferedReader(reader)
		){
					

			String line;
			while((line = bReader.readLine()) != null){
				System.out.println(line);
			}
		}catch(IOException e){
			System.out.println("An error occured while reading the file");
		}
	}

	public static void readFile(String path) throws IOException{
		try(Reader reader = new FileReader(path); BufferedReader bReader = new BufferedReader(reader)){
			

			String line;
			while((line = bReader.readLine()) != null){
				System.out.println(line);
			}
		}
	}

	public static void m1(AutoCloseableResource acr, final AutoCloseableResource acr2){
		/*
		* In Java 7 & 8, a resource must be declared in 
		* the try-with-resources statement to be used inside block.
		* The statement like the one below result in 
		* a compile-time error
		* try(acr){
		*	
		* }
		* 
		* You must declare fresh variable inside the block.
		*
		* try(AutoCloseableResource acResource = acr){
		*
		* }
		*
		*
		* Since Java 9, a FINAL or effectively final reference variable of type AutoCloseable can be used 
		* inside a try-with-resources
		*/
		try(acr2){

		}

		// For multiple resources
		final AutoCloseableResource acr3 = new AutoCloseableResource(1, true);
		final AutoCloseableResource acr4 = new AutoCloseableResource(3, false);

		try(acr2; acr3; AutoCloseableResource acr5 = new AutoCloseableResource(1, false)){
			acr2.use();
			acr3.use();
			acr4.use();
		}
		
	}
}