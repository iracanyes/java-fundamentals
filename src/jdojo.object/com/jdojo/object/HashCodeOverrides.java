/**
 * ADVISE FOR MAKING A HASH CODE
 * Here is a simple sample of hash code implementation.
 * They are better implementation of hash function out there.
 * If your class is not used as key in hash based collection, and 
 * does not reimplement equals() method, you doesn't to worry about hashCode()
 * reimplementation.
 * IMPORTANT: Re-implementing one of the method hashCode() or equals(),
 * force you to reimplements the other method for hash based collection for 
 * work properly.
 * No errors will be prompted by the compiler if an error exists inside these methods
 * but your hash based collection will have some strange behaviour
 * */
package com.jdojo.object;

import com.jdojo.person.Person;

/*
 * 
 */
class HashCodeOverrides{
	boolean bol1;
	byte b1;
	short s1;
	char c1;
	int i1;
	long l1;
	float f1;
	double d1;
	String st1;
	Person person;

	public HashCodeOverrides() {
		bol1 = false;
		b1 = 12;
		s1 = 128;
		i1 = 88;
		l1 = 1245653256l;
		f1 = -0.2E-13f;
		d1 = 0.2356987E-20d;
		st1 = "HelloWorld";
		person = new Person(213265,"John","Doe");
	}

	@Override
	public int hashCode(){
		/*
		* 
		*/
		int code;
		// Start with a random small integer
		int hash = 26;

		/*
		* STEP 2. 
		* Compute the Hash code for each significant instance variable 
		* of primitive type of the class separately.
		*
		* 
		* IMPORTANT: 
		* You need to use same instance variables in the hash code computation,
		* which are also used in "equals()" method logic.	
		*
		* For byte, short, char and int, you can use the integer value as 
		* 	code = (int) byte;
		*	code = (int) short;
		*	code = (int) char;
		*	code = integer;
		* 
		* For long data type, use XOR function for 2 halves of 64-bits
		*	code = (int) (value ^ (value >>> 32))
		*
		* For float data type, convert its floating-point values to an equivalent integer.
		*	code = Float.floatToIntBits(value)
		*
		* For double data type:
		*	1. convert it floating-point value to long 
		*	   using Double.doubleToLongBits()
		*		long longsBits = Double.doubleToLongBits(value);
		*	2. convert long to int representation
		*		code = (int) (longBits ^ (longBits >>> 32))
		*	
		* For reference variable, use zero if the reference is null otherwise
		* use the hashCode() method of the object
		*
		*/
		/*
		* BOOLEAN INSTANCE VARIABLE
		*/
		hash = hash + 9 + (bol1 ? 1 : 0);

		/* 
		* For byte, short, int , char 
		* you can use the integer value of the data
		*/
		/*
		* BYTE INSTANCE VARIABLE
		*/
		code = (int) b1;

		// We compute the hash code of the instance variable
		// We use a random number as salt
		hash = hash + 9 + code;

		/* 
		* SHORT INSTANCE VARIABLE
		*/
		code = (int) s1;

		// We compute the hash code of the instance variable
		// We use a random number as salt
		hash = hash + 9 + code;

		/* 
		* CHAR INSTANCE VARIABLE
		*/
		code = (int) c1;

		// We compute the hash code of the instance variable
		// We use a random number as salt
		hash = hash + 9 + code;

		/* 
		* INTEGER INSTANCE VARIABLE
		*/
		// We compute the hash code of the instance variable
		// We use a random number as salt
		hash = hash + 9 + i1;


		/*
		* LONG INSTANCE VARIABLE
		* Structure:
		*	code = (int) (value ^ (value >>> 32))
		*/
		code = (int) (l1 ^ (l1 >>> 32));
		// We use a random number as salt
		hash = hash + 9 + code;

		/*
		* FLOAT INSTANCE VARIABLE
		* Use the integer bits representation of the value
		*/
		code = Float.floatToIntBits(f1);
		// We compute the hash code of the 
		hash = hash + 9 + code;

		/*
		* DOUBLE INSTANCE VARIABLE
		* Use the bits representation of the value which is long type
		* and convert long value to its integer representation
		*/
		long longBits = Double.doubleToLongBits(d1);
		code = (int) (longBits ^ (longBits >>> 32));

		hash = hash + 9 + code;

		/*
		* REFERENCE VARIABLE
		* Use zero if the object is null otherwise use the hashCode() value
		*/

		code = hash + 9 + (st1 == null ? 0 : st1.hashCode());
		hash = hash + 9 + code;

		code = hash + 9 + (person == null ? 0 : person.hashCode()); 
		hash = hash + 9 + code;

		// At the end, return the hash value 
		return hash;


	}

}