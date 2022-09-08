package com.jdojo.string;

public class StringComparison{
	public static void main(String[] args) {
		String s1 = new String("Hello");
		String s2 = new String("Hi!");
		String s3 = new String(new byte[]{72,101,108,108,111});
		String s4 = new String(new byte[]{72,105,33});

		System.out.printf("3 strings comparison:\ns1: %s\ns2: %s\ns3: %s\ns4: %s\n", s1, s2, s3, s4);

		boolean b1, b2;

		// Compare strings
		System.out.println("s1 is equals to s2 : " + s1.equals(s2));
		System.out.println("s1 is equals to s3 : " + s1.equals(s3));
		System.out.println("s2 is equals to s4 : " + s2.equals(s4));

		System.out.println("Hello is equals to new byte[]{72,101,108,108,111}? " + "Hello".equals(new String(new byte[]{72,101,108,108,111})));
	
		boolean b3 = "Hello" == new String("Hello");
		System.out.println("str1 == str2 compare reference variable for equality! Not the object's content: " + b3);
	}

	public static void sortString(){
		/*
		* compareTo() method compares 2 strings based on the unicode values of their characters 
		* The order may change from the dictionary order of characters in some other language than latin.
		*/
		int a = "abc".compareTo("abc"); // Returns 0
		int b = "abc".compareTo("xyz");	// Returns -23	(value of 'a' - 'x')
		int c = "xyz".compareTo("abc"); // Returns 23	(value of 'x' - 'a')
		System.out.println("\"abc\".compareTo(\"abc\") : " + a);
		System.out.println("\"abc\".compareTo(\"xyz\") : " + b);
		System.out.println("\"xyz\".compareTo(\"abc\") : " + c);
	}
}