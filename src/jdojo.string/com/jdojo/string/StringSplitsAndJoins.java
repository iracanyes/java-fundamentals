package com.jdojo.string;

public class StringSplitsAndJoins{
	public static void main(String[] args) {
		
	}

	public static void splitString(){
		String str1 = "BE,FR,NL,EN,ES";

		/*
		* String[] split(String separator)
		* Split a string into multiple strings using the delimiter given in argument
		*/
		String[] parts = str1.split(",");

		System.out.println(str1);
		System.out.println("str1 array: \n" + parts);


	}

	public static void joinStringArray(){
		/*
		* String join(CharSequence delimiter, CharSequence... elements)
		* Static Method takes a delimiter and a sequence of strings to be joined.
		*/
		String str = String.join(",", "BE", "FR", "EN", "NL", "ES");
		System.out.println("String.join(\",\", \"BE\", \"FR\", \"EN\", \"NL\", \"ES\") :\n" + str);
	}
}