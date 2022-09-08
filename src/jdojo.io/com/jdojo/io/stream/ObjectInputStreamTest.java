package com.jdojo.io.stream;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.ClassNotFoundException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import com.jdojo.person.Person;
import java.time.LocalDate;

public class ObjectInputStreamTest{
	private final static String filepath = ".\\test\\output\\objects_output.txt";

	public static void main(String[] args) {
		try(
			FileInputStream fis = new FileInputStream(filepath);
			ObjectInputStream ois = new ObjectInputStream(fis);
		){
			/*
			* ObjectInputStream must reads data from stream,
			* in the order, they are written into the stream using ObjectInputStream
			*/
			// TODO - Conflict: bytes separator or String separator
			//readArrayOfBytes(ois);

			//readIntReduced(ois);
			
			// TODO
			//readWriteChars(ois);
			
			//readPrimitiveData(ois);
			readUtf8String(ois);
			readObjects(ois);

		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public static void readArrayOfBytes(ObjectInputStream objStream) throws IOException{
			// Read an array of byte 
			byte[] byteArray = new byte[200];
			objStream.readFully(byteArray);

			// Here we create a String from byte[]
			// signature: new String(byte[] bArr)
			System.out.printf(
				"\n1. Read array of byte written using write(byte[]) : \n%s\n\n", 
				new String(byteArray)
			);
	
			/* When you create a String from byte[], 
			* you can specify the character encoding one of the 2 methods:
			*	- java.nio.charset.Charset.forName(<charset-name>)
			*	- java.nio.charset.StandardCharset.UTF_8
			*/
			objStream.read(byteArray, 0, 10);
			System.out.printf(
				"\n2. Second sentence written using write(String.getBytes(StandardCharsets.UTF_8)) :\n%s\n\n",  
				new String(byteArray, StandardCharsets.UTF_8)
			);

			byteArray = new byte[150];
			objStream.readFully(byteArray, 0,150);

			System.out.printf(
				"\n3. Third sentence written using write(String.getBytes(StandardCharsets.UTF_8)) :\n%s\n\n",  
				new String(byteArray, Charset.forName("UTF-8"))
			);

			// Here, we read output stream written using writeBytes(String s)
			byteArray = new byte[100];
			objStream.readFully(byteArray);
			System.out.println("First sentence written by ObjectOutputStream to output stream using writeBytes(String s):\n" + new String(byteArray));
	}

	public static void readWriteChars(ObjectInputStream objStream) throws IOException{
		// Here, we read input stream data written using writeChars(String s) from ObjectOutputStream.
		// writeChars() doesn't save the length of the string which is needed to read it.
		// You must write to output stream the length of the string for reading it using readChar
		// 
		int length = objStream.readInt();
		char[] charArray = new char[100];
		for(int i = 0; i < length; i++){
			charArray[i] = objStream.readChar();
		}
		String strWriteChars = new String(charArray);
		System.out.println("Reads data written to output stream using writeChars(String s) : \n" + strWriteChars);
	}

	public static void readIntReduced(ObjectInputStream objStream) throws IOException{
		// Here, we read output stream data written using write(int i)
		System.out.println("Byte written using write(int s) : " + objStream.readByte());
	}

	public static void readPrimitiveData(ObjectInputStream objStream) throws IOException{
		/*
		* Methods to read primitive data from input stream
		*/
		/*
		* Signature: boolean readBoolean()
		*/
		System.out.println("Boolean data 1 : " + objStream.readBoolean());
		/*
		* Signature: boolean readBoolean()
		*/
		System.out.println("Boolean data 2 : " + objStream.readBoolean());

		/*
		* Signature: byte readByte()
		*/
		System.out.println("Byte data 1 : " + objStream.readByte());

		/*
		* Signature: short readShort()
		*/
		System.out.println("Short data : " + objStream.readShort());

		/*
		* Signature: char readChar()
		*/
		System.out.println("Character data 1 : " + objStream.readChar());				

		/*
		* Signature: int readInt()
		*/
		System.out.println("Integer data : " + objStream.readInt());

		/*
		* Signature: long readLong()
		*/
		System.out.println("Long data : " + objStream.readLong());

		/*
		* Signature: float readFloat()
		*/
		System.out.println("Float data : " + objStream.readFloat());

		/*
		* Signature: double readDouble()
		*/
		System.out.println("Double data : " + objStream.readDouble());
	}

	/*
	*  modified UTF-8 format
	*/
	public static void readUtf8String(ObjectInputStream objStream) throws IOException{
		// Here, we read data written to output stream using writeUTF(String s)
		// Signature: String readUTF()
		String strUtf16 = objStream.readUTF();

		System.out.println("1.Reads string written to output stream using writeUTF(String s) : \n"+ strUtf16);

		// Convert to UTF8
		byte[] byteStr1 = strUtf16.getBytes(StandardCharsets.UTF_8);
		System.out.println("\n2.Reads string written to output stream using writeUTF(String s) and converted : \n"+ new String(byteStr1, StandardCharsets.UTF_8 ));

		byte[] byteStr2 = new byte[150];
		objStream.read(byteStr2);
		System.out.println("\n3.Reads string written to output stream using write(byte[]) and converted : \n"+ new String(byteStr2, StandardCharsets.UTF_8 ));

		// Read a full document in UTF-8 encoding
	}

	public static void readObjects(ObjectInputStream objStream) throws IOException, ClassNotFoundException{
		/*
		* The method readObject is used to read an object from the stream. 
		* Java's safe casting should be used to get the desired type. 
		* In Java, strings and arrays are objects and are treated as objects during serialization. 
		* When read they need to be cast to the expected type. 
		*/
		System.out.println("String Object data : " + (String) objStream.readObject());

		System.out.println("LocalDate Object data : " + (LocalDate) objStream.readObject());


		Person pers = (Person) objStream.readObject();
		System.out.println("Person Object data : " + pers);
	}
}