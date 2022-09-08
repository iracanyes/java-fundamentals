/*
* The FileOutputStream class of the java.io package can be used to write data (in bytes)
* It extends OutputStream class.
*
* 
*
*
*/

package com.jdojo.io.stream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;

public class FileOutputStreamTest{
	public static void main(String[] args) {
		String filepath = ".\\test\\output\\file_output.txt";
		File file = new File(filepath);
		try(
			// Here we delete the existing content of the file
			FileOutputStream fos = new FileOutputStream(filepath);
			// Second argument indicates that we want to append data to existing data in file
			FileOutputStream fos2 = new FileOutputStream(filepath, true);
			FileOutputStream fos3 = new FileOutputStream(file, true);
		){
			String str1 = "The FileOutputStream class of the java.io package can be used to write data (in bytes).\n";

			// write to output stream
			fos.write(str1.getBytes());
			fos2.write("Second sentence appended to file by second FileOutputStream(byte[], boolean).\n".getBytes());

			fos3.write("Third sentence appended to file by second FileOutputStream(File, boolean).\n".getBytes());

			/*
			* write(byte[] array, int start, int length) 
			* writes the number of bytes equal to length to the output stream from an array starting from the position start
			*/

			// Clear the output stream
			fos.flush();
			fos2.flush();
			fos3.flush();

			/*
			* getChannel()
			* returns the object of FileChannel associated with the output stream
			*/
			
			/*
			* getFD()
			* returns the file descriptor associated with the output stream
			*/

		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}