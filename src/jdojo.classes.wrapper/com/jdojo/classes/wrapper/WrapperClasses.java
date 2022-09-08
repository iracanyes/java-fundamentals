package com.jdojo.classes.wrapper;
/*
* This annotation suppress the warning that you use a deprecated API
*
*/
@SuppressWarnings("deprecation")
public class WrapperClasses{
	public static void main(String[] args) {
		/*
		* Primitive and reference types are not assignment compatible
		* But some part of Java only works with objects, e.c: Collection
		* You cannot create a list of primitive values!
		* You need to wrap the primitive values into objects before storing themn in a list or set.
		* Java provides immutable wrapper classes for primitive types.
		* Here is a list of primitive types wrapper classes:
		*	Primitive type 		Wrapper Class
		*		boolean 			Boolean
		*		byte				Byte
		*		short				Short
		*		char 				Character
		*		int 				Integer
		*		long 				Long
		*		float 				Float
		* 		double 				Double
		* 
		* All wrapper classes are immutable.
		* They provide 3 ways to create objects:
		*	- using constructors
		*	- using the valueOf() factory method
		*	- using parseXXX() method, where XXX is the name of the wrapper class.
		*		it's not available for Character class;
		*		Ex: Integer.parseInt(String s)
		*
		* For memory performance, using XXX.valueOf() is better than using call to constructor
		* Because, you call multiple times a constructor, each time a new object is created in memory
		* Ex: new Integer(13)
		* But by calling XXX.valueOf(XXX x) the method use a caching technique
		* which save the value given in paramater for reuse.
		* On the next call to XXX.valueOf(), the reference to same object is used
		* Calling multiple times XXX.valueOf() on the same value, the method will returns 
		* the reference to the object created at the first call.
		* 
		*/
		// Create an Integer object from integer
		// Error: Integer(int) in Integer has been deprecated and marked for removal
		// Integer intObj1 = new Integer(145);
		
		// Error: Integer(int) in Integer has been deprecated and marked for removal
		// Integer intObj2 = new Integer(0x0124E);
		
		// Integer(String) in Integer has been deprecated and marked for removal
		// because of inconsistency when using the constructor
		// Integer intObj3 = new Integer("14565");
		// Integer intObj4 = new Integer("14565");
		// System.out.println((intObj3 == intObj4)); // print: false because intObj3 and intObj4 are 2 different objects

		Integer intObj4 = Integer.valueOf(0b011110010);
		Integer intObj5 = Integer.valueOf(072);
		System.out.println("intObj4 : " + intObj4);
		Integer intObj6 = Integer.parseInt("072");
		System.out.println("intObj5 : " + intObj5);
		System.out.println("intObj5 : " + intObj6);

		Integer sameInt1 = Integer.valueOf(782);
		Integer sameInt2 = Integer.valueOf(782);
		System.out.println("sameInt1 = " + sameInt1 + ", sameInt2 = " + sameInt2);
		System.out.println("sameInt1 == sameInt2 : " + (sameInt1 == sameInt2));
		System.out.println("sameInt1.equals(sameInt2) : " + (sameInt1.equals(sameInt2)));

		// Create a Float object from string
		// Error: Float(float) in Float has been deprecated and marked for removal
		// Float 	floatObj1 = new Float("12.54E6f");
		
		// Error: Float(float) in Float has been deprecated and marked for removal
		// Float 	floatObj2 = new Float(12.54E6f);

		Float 	floatObj3 = Float.valueOf("12.5460f");
		float floatObj4 = Float.valueOf("12.5460f");
		System.out.println("floatObj3 : " + floatObj3);
		System.out.println("floatObj4 : " + floatObj4);

		Float 	floatObj5 = Float.parseFloat("12.54E22");
		float 	floatObj6 = Float.parseFloat("12.54E22");
		System.out.println("floatObj5 : " + floatObj5 + ", floatObj6 : " + floatObj6);


		// Create a Double object from string
		
		// Error: Double(double) in Double has been deprecated and marked for removal
		// Double doubleObj1 = new Double(1.123265E23);
		
		// Error: Double(String) in Double has been deprecated and marked for removal
		// Double  doubleObj1 = new Double("123256.325689");

		Double  doubleObj1 = Double.valueOf("123256.325689");
		System.out.println("doubleObj1 : " + doubleObj1);

		Double  doubleObj2 = Double.parseDouble("123256.325689");
		System.out.println("doubleObj2 : " + doubleObj2);

		// IMPORTANT: for character, you MUST USE SINGLE QUOTE

		// Error:  Character(char) in Character has been deprecated and marked for removal
		// Character charObj1 = new Character('A');
		
		Character charObj2 = Character.valueOf('D');

	}
}