package com.jdojo.common;

public class AccessLevelTest1{
	public static void main(String[] args){
		AccessLevelSample al = new AccessLevelSample();

		// n1 is a private instance variable of type int in AccessLevelSample
		// int a = al.n1;	// Compile-time error. al.n1 Only accessible from the body of compile unit

		// n2 is package-level instance variable of type int
		int b = al.n2;
		// n3 is protected instance variable of type int
		int c = al.n3;
		// n4 is public instance variable of type int
		int d = al.n4;

		System.out.println(
			"a = al.n1 = error\n" 
			+ "b = al.n2 = " + b + "\n"
			+ "c = al.n3 = " + b + "\n"
			+ "d = al.n4 = " + b + "\n"
		);

		// al.m1(); 	// Compile-time error: m1 is private method of class AccessLevelSample
		al.m2();
		al.m3();
		al.m4();

		// Direct access
		// al.n1 can't be accessed as it's a private instance variable
		al.n2 = 89;
		al.n3 = 456;
		al.n4 = 987;

		System.out.println(
			"a = al.n1 = error\n" 
			+ "b = al.n2 = " + al.n2 + "\n"
			+ "c = al.n3 = " + al.n3 + "\n"
			+ "d = al.n4 = " + al.n4 + "\n"
		);

		al.m2();
		al.m3();
		al.m4();


	}
}