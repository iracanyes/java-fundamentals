/*
*	Run with assertions enabled: 
*		java -ea -p lib -m jdojo.assertion/com.jdojo.assertion.ClassInvariants
*/
package com.jdojo.assertion;

import java.time.LocalDate;

public class ClassInvariants{
	public static void main(String[] args) {
		Account acc = new Account("John Doe", LocalDate.of(1986,12,25), LocalDate.now(), 30.00);
		System.out.println("Valid account : " + acc.toString());

		Account acc2 = new Account("John Doe", null, LocalDate.now(), 3000);
		System.out.println("If you can see this message, Assertions are disabled!");
		System.out.println("Account class invariants are not enforced : " + acc2);
	}	
}

class Account{
	private String name;
	private LocalDate birthday;
	private LocalDate startDate;
	private double balance;

	public Account(String name, LocalDate birthday, LocalDate startDate, double balance){
		this.name = name;
		this.birthday = birthday;
		this.startDate = startDate;
		this.balance = balance;

		// Ensure that the class invariants are enforced.
		assert validAccount() : "New account - Invalid class invariants: " + this.toString();
	}

	public boolean validAccount(){
		return (name != null && birthday != null && birthday.isBefore(startDate) && balance >= 0);
	}
}