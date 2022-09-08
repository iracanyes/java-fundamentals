/**
 * Description: 
 * Create an object of the Account class and attempts operations on it using 
 * its public methods. 
 */
package com.jdojo.common;

public class AccountTest{
	public static void main(String[] args) {
		Account ac = new Account();
		double balance = ac.getBalance();

		System.out.println("Balance = " + balance);

		// Credit and debit account
		ac.credit(654.32);
		ac.debit(23.21);

		balance = ac.getBalance();
		System.out.println("Balance = " + balance);

		// Attempt credit and debit invalid amount
		ac.credit(Double.POSITIVE_INFINITY);
		ac.debit(-234.24);

		balance = ac.getBalance();
		System.out.println("Balance = " + balance);

		// Attempt to debit more than the balance
		ac.debit(1000);

		balance = ac.getBalance();
		System.out.println("Balance = " + balance);


	}

	
}