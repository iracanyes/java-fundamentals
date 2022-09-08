package com.jdojo.common;

public class Account{
	private double balance;

	public double getBalance(){
		return this.balance;
	}

	public int credit(double amount){
		// Check if amount is not negative, NaN, Infinity
		if(amount < 0.0 || Double.isNaN(amount) || Double.isInfinite(amout)){
			System.out.println("Invalid credit amount" + amount);
			return -1;
		}

		// Credit the amount
		System.out.println("Crediting amount: " + amount);
		this.balance += amount;
		return 1;
	}

	public int debit(double amount){
		// Check if amount is not negative, NaN, Infinity
		if(!this.isValidAmount(amount, "debit")){
			System.out.println("Invalid credit amount" + amount);
			return -1;
		}

		if(this.balance < amount){
			System.out.println("Insufficient funds. Debit attempted: " + amount);
			return -1;
		}

		System.out.println("Debiting amount: " + amount);
		this.balance -= amount;
		return 1;
	}

	private boolean isValidAmount(double amount, String operation){
		// Check if amount is not negative, NaN, Infinity
		if(amount < 0.0 || Double.isNaN(amount) || Double.isInfinite(amout)){
			System.out.println("Invalid credit amount" + amount);
			return false;
		}

		return true;
	}
}