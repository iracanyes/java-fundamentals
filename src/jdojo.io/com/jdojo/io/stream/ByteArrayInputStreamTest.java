/*
* The ByteArrayInputStream class can be used to read an array of input data (in bytes)
* It extends InputStream class.
*/
package com.jdojo.io.stream;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteArrayInputStreamTest{
	public static void main(String[] args) {
		byte[] arr = new byte[]{89,65,45,12,00,32,15,45,78,56,02,12,45};
		try(
			ByteArrayInputStream bais = new ByteArrayInputStream(arr);
			ByteArrayInputStream bais2 = new ByteArrayInputStream(arr);
		){
			byte[] data = new byte[20];

			// reads bytes from the input stream and stores in the specified array
			
			bais.read(data, 0, 5);
			System.out.printf("Data from array of bytes : \n%s\n", new String(data));

			// reads bytes from the input stream and stores in the specified array
			data = new byte[100];
			bais.read(data);
			System.out.printf("\nData from array of bytes : \n%s\n", new String(data));

			

		}catch(IOException e){
			e.printStackTrace();
		}
	}
}