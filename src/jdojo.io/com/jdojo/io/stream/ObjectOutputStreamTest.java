/*
* The ObjectOutputStream class can be used to write primitive type and graphs of reference type (Java object)
* to an OutputStream.
* The objects can be read by ObjectInputStream.
* Persistent storage of objects can be accomplished by using a file for a stream.
* If the stream is a network socket stream, the objects can be reconstitued
* Multiple objects or primitives can be written to the stream. 
* IMPORTANT: The objects must be read back from the corresponding ObjectInputstream 
* with the same types and in the same order as they were written. 
*
*
* Basically, The ObjectOutputStream encodes Java objects using the class name
* and object values. And, hence generates corresponding streams.
* This process is known as "serialization"
* Those converted streams can be stored in files and can be exchanged through networks.
* IMPORTANT: The ObjectOutputStream class only writes those objects that implement the "Serializable" interface
* because objects need to be serialized while writing to the stream.
* 
*/
package com.jdojo.io.stream;

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.jdojo.person.Person;
import com.jdojo.address.Address;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

public class ObjectOutputStreamTest{
	private final static String filepath = ".\\test\\output\\objects_output.txt";

	public static void main(String[] args) {
		try(
			FileOutputStream fos = new FileOutputStream(filepath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
		){
			//writeArrayOfBytes(oos);
			//writeByteFromInt(oos);
			//writePrimitiveData(oos);
			//writeChars(oos);
			writeUtf8String(oos);
			writeObjects(oos);
			
			// objStream.flush()
			// clears all the data from the output stream
		
			// objStream.drain()
			// puts all the buffered data in the output stream
		
			// objStream.close()
			// closes the output stream
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/*
	* Primitive data, excluding serializable fields and externalizable data, 
	* is written to the ObjectOutputStream in block-data records. 
	* A block data record is composed of a header and data. 
	* The block data header consists of a marker and the number of bytes to follow the header. 
	* Consecutive primitive data writes are merged into one block-data record. 
	* The blocking factor used for a block-data record will be 1024 bytes. 
	* Each block-data record will be filled up to 1024 bytes, or be written whenever there is a termination of block-data mode.
	* Calls to the ObjectOutputStream methods writeObject, defaultWriteObject and writeFields initially terminate any existing block-data record. 
	*/
	public static void writeArrayOfBytes(ObjectOutputStream objStream) throws IOException{
		String firstSentence = "First sentence written in bytes using write(byte[]).\n";
		/*
		* write(byte[] b)
		* Writes an array of bytes to the output stream
		*/
		objStream.write(firstSentence.getBytes());


		/*
		* write(byte[] b, int offset, int lenght)
		* Writes 'length' bytes from array "b" starting from "offset", in order, to the output stream
		*
		*/
		objStream.write("\nSecond sentence written using write(byte[], int, int)\n".getBytes(), 0, 10);
		objStream.write("\nThird sentence written (écrit) using write(byte[], int, int).\nMax 2 bytes per character (Ex: UTF-8 is 4 bytes).\n".getBytes(StandardCharsets.UTF_8), 0, 120);

		/*
		* writeBytes(String s)
		* Writes a string to the output stream
		*/
		objStream.writeBytes("\nFourth sentence written using writeBytes(String).\n");
	}

	public static void writeByteFromInt(ObjectOutputStream objStream) throws IOException{
		/*
		* write(int b)
		* Writes to output stream the eight low-order bits of the argument 'b'
		*/
		objStream.write(3264);
	}

	public static void writePrimitiveData(ObjectOutputStream objStream) throws IOException{
		/*
		* Primitive data type can be written to the stream using the appropriate methods of 
		* DataOutput class.
		*/

		/*
		* writeBoolean(boolean b)
		* Writes data in boolean form
		*/
		objStream.writeBoolean(true);
		objStream.writeBoolean(false);

		/*
		* writeByte(int v)
		* Writes to output stream the eight low-order bits (byte size) of the argument "v"
		* If argument exceed the size of the data type only the bits for bytes size 
		* are considered.
		*/
		objStream.writeByte(127);

		/*
		* writeShort(short s)
		* Writes a short value, which is comprised of 2 bytes (16bits) to output stream
		*/
		objStream.writeShort(32767);


		/*
		* writeChar()
		* Writes a char value, which is comprised of 2 bytes to the output stream
		* Special characters are not allowed as they use more than 2bytes 
		* ex: UTF-8 uses 1 to 4 bytes per character, depending on the Unicode symbol. 
		* Ex: objStream.writeChar('ù') will generate 2 error:
		*	- unclosed character literal
		*	- illegal character: '\u00b9'
		*/
		objStream.writeChar('A');

		/*
		* writeInt()
		* Writes a long value, which is comprised of 4 bytes (32bits) to output stream
		*/
		objStream.writeInt(326589);

		/*
		* writeLong()
		* Writes a long value, which is comprised of 8 bytes (64bits) to output stream
		*/
		objStream.writeLong(3_658_265_890_006L);

		/*
		* writeFloat(float f)
		* Writes a float value, which is comprised of 4 bytes (32bits) to output stream
		*/
		objStream.writeFloat(3.26589f);

		/*
		* writeDouble(double d)
		* Writes a double value, which is comprised of 8 bytes (64bits) to output stream
		*/
		objStream.writeDouble(32.6589E-21);
	}

	public static void writeChars(ObjectOutputStream objStream) throws IOException{
		/*
		* writeChars(String s)
		* Writes every character in the string s, to output stream,
		* in order, 2 bytes per character
		*
		* writeChars writes text as a sequence of 2-bytes chars with no length. To read it, 
		* we should use readChar method and we need to know how many chars were written.
		*/
		String strWriteChars = "\nString écrit via writeChars(String s). UTF8 encoding n'est pas accepté!";
		int length = strWriteChars.length();
		objStream.writeInt(length);
		objStream.writeChars(strWriteChars);
	}

	public static void writeUtf8String(ObjectOutputStream objStream) throws IOException{
		/*
			* writeUTF(String s)
			* Primitive data write of this String in modified UTF-8 format. 
			* Note that there is a significant difference between writing a String into the stream as primitive data or as an Object. 
			* A String instance written by writeObject is written into the stream as a String initially. Future writeObject() calls write references to the string into the stream.
			*
			*  writes text in UTF-8 format encoding preceeded with text length, 
			*  so readUTF knows how many characters to read from stream. 
			*/
			objStream.writeUTF("\nString écrit via writeUTF(String s). UTF8 encoding n'est pas accepté!");

			byte[] byteStr = "\nString écrit via writeUTF(String s). UTF8 encoding n'est pas accepté!".getBytes(StandardCharsets.UTF_8);
			objStream.write(byteStr);

	}		


	public static void writeObjects(ObjectOutputStream objStream) throws IOException, ClassNotFoundException{
		/*
		* writeObject()
		* Writes object to the output stream
		* Any object, including String and arrays is written using writeObject()
		*/
		objStream.writeObject("\nSentence passed to output stream using writeObject(String).\n");

		LocalDate date = LocalDate.now();
		objStream.writeObject(date);

		/*
		* Arrays are also written to output stream using writeObject
		*/

		
		Person person = new Person(1254, "John", "Doe");
		Address addr = person.getAddress();
		
		addr.setLine1("Rue neuve, 9");
		addr.setCity("Bruxelles");
		addr.setState("Bruxelles");
		addr.setZip("1000");

		person.setAddress(addr);

		// The class of the object MUST implements the interface "java.io.Serializable"
		objStream.writeObject(person);
	}
}