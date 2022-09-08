/*
*
* Command:
*	Run:  java -p lib -m jdojo.io/com.jdojo.io.file.FileReaderTest
*/
/*
* FileReader class from java.io package can be used to readd data (in characters)
* from files.
* It extends the InputStreamReader class
*/

package com.jdojo.io.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.Reader;
import java.nio.charset.Charset;

public class FileReaderTest{
	public static void main(String[] args) {
		try{
			// read file
			readFile();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

	public static void readFile() throws IOException {
		FileReader fileReader = null;
		BufferedReader bReader = null;
		try{
			/*
			* FileReader will transform the path with os-path separator
			* if your OS is Windows, A linux-like filepath will be transform using Windows path separator
			* Ex: reader = new FileReader("/c/Projets/cours/language/java/bj9f/src/jdojo.io/com/jdojo/io/file/FileReader.java");
			*	will become \c\Projets\cours\language\java\bj9f\src\jdojo.io\com\jdojo\io\file\FileReader.java
			* And an error will be thrown at runtime. Filepath not found.
			*/
			fileReader = new FileReader("C:\\Projets\\cours\\language\\java\\bj9f\\src\\jdojo.io\\com\\jdojo\\io\\reader\\FileReaderTest.java");
			
			String fileEncoding = fileReader.getEncoding();
			// Get charset info
			System.out.println("Charset of FileReaderTest: " + fileEncoding);


			/*
			* You can specify the encoding of a file
			*  
			*/
			String filepath = "C:\\Projets\\cours\\language\\java\\bj9f\\src\\jdojo.io\\com\\jdojo\\io\\reader\\StringReaderTest.java";
			

			FileReader fileReader2 = new FileReader(filepath, Charset.forName("UTF8"));
			// Get charset info
			System.out.println("Charset of FileReaderTest: " + fileReader.getEncoding());
			System.out.println("------------------------------------------------------------------------");


			char[] charArray = new char[60];

			// FileReader.read(char[] array) read characters and store its in an array.
			fileReader.read(charArray);
			System.out.println("All characters stored in an array of size: " + charArray.length);
			//System.out.println(charArray);
			System.out.println("------------------------------------------------------------------------");

			/* 
			* FileReader.read(char[] array, int start, int lenght) read characters and store its in an array.
			* Reads the numbers of characters equals to 'length' from the reader
			* and stores in specified array starting from the position given in its argument. 'start'
			*/
			fileReader.read(charArray, 0, 20);
			System.out.println("All characters stored in an array of size: " + charArray.length);
			//System.out.println(charArray);
			System.out.println("------------------------------------------------------------------------");
			
			/*
			* Here, we iterate over the buffered text input in the reader one line at a time.
			* 
			*/
			String line;
			int lineNumber = 1;

			while((line = bReader.readLine()) != null){
				System.out.println(lineNumber + "# " +line);
			}
		}catch(IOException e){
			System.out.printf("An error occured during the reading of the file.\n%s", e.getMessage());
		}finally{
			if(bReader != null){
				bReader.close();
			}

			if(fileReader != null){
				fileReader.close();
			}
		}
	}
}