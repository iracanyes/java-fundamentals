package com.jdojo.classes.wrapper;

public class BooleanWrapperClass{
	public static void main(String[] args) {
		// Using constructor is deprecated
		// Error: Boolean(String) in Boolean has been deprecated and marked for removal
		// Boolean b11True = new Boolean(true);
		// Error: Boolean(String) in Boolean has been deprecated and marked for removal
		//Boolean b12True = new Boolean("true");

		// Using factory methods
		Boolean b21True = Boolean.valueOf(true);
		Boolean b22True = Boolean.valueOf("true");	
		Boolean b23True = Boolean.valueOf("tRue");
		Boolean b24False = Boolean.valueOf(false);
		Boolean b25False = Boolean.valueOf("false or true");
		Boolean b26False = Boolean.valueOf("false");

		System.out.println("Boolean.valueOf(true) : " + b21True);
		System.out.println("Boolean.valueOf(\"true\") : " + b22True);
		System.out.println("Boolean.valueOf(\"tRue\") : " + b23True);
		System.out.println("Boolean.valueOf(false) : " + b24False);
		System.out.println("Boolean.valueOf(\"false or true\") : " + b25False);
		System.out.println("Boolean.valueOf(\"false\") : " + b26False);


		// Get boolean from a Boolean object
		boolean bb1True = b21True.booleanValue();

		// Parsing strings to boolean values
		boolean bTrue = Boolean.parseBoolean("true");
		boolean bFalse = Boolean.parseBoolean("This string is evaluate to false");
		System.out.println("Boolean.parseBoolean(\"true\") : " + bTrue);
		System.out.println("Boolean.parseBoolean(\"This string is evaluate to false\") : " + bFalse);

		// Using Constant
		System.out.println("bcTrue = " + Boolean.TRUE);
		System.out.println("bcFalse = " + Boolean.FALSE);

	}
}