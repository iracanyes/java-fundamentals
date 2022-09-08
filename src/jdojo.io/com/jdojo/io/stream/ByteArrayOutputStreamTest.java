/*
* The ByteArrayOutputStream class of the java.io package can be used to write an array of output data (in bytes).
* It extends the OutputStream abstract class.
*/
package com.jdojo.io.stream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamTest{
	public static void main(String[] args) {
		String data = "The ByteArrayOutputStream class of the java.io package can be used to write an array of output data (in bytes).";
		/*
		* Default size of array of bytes : 32 bytes.
		* You can change it with the first argument of the constructor
		*/
		try(
			ByteArrayOutputStream baos = new ByteArrayOutputStream(100);
		){
			byte[] strArr = data.getBytes();

			// write(byte[]) 
			// Writes data to the output stream
			baos.write(strArr);

			// write(byte[] bAr, int offset, int length)
			// writes the number of bytes equal to length to the output stream from an array starting from the position start


			// writeTo(ByteArrayOutputStream out1) 
			// writes the entire data of the current output stream to the specified output stream

			// Retrieves data from the output stream in string format
			String streamData = baos.toString();
			System.out.printf("Output stream: %s", streamData);

			// Retrieve an array of bytes
			int sizeArr = baos.size();
			byte[] byteData = baos.toByteArray();
			for(int i = 0; i < byteData.length; i++){
				char ch = (char) byteData[i];

			}

			// Clear the output stream
			baos.flush();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}