package com.jdojo.regex;

public class EmailValidation{
	public static void main(String[] args) {
		EmailValidation.validateEmail("azer@azer.com");
	}

	public static boolean validateEmail(String email){
		String regex = "([a-zA-Z0-9]+[\\w\\-.]*)@([a-zA-Z0-9]+\\.[a-zA-Z0-9\\-.]+)";

		boolean matched = email.matches(regex);
		if(matched){
			System.out.printf("Email: %s is valid!", email);
		} 

		return matched;
	}
}