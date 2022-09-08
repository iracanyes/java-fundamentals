package com.jdojo.common;

public class SmartDogTest{
	public static void main(String[] args) {
		// Create 2 instance using different signature for constructor
		SmartDog sd1 = new SmartDog();
		SmartDog sd2 = new SmartDog("Elon", 514.2);

		sd1.showInfo();
		sd2.showInfo();

		sd1.bark();
		sd2.bark();

		sd1.setName("Bill");
		sd1.setPrice(324.12);

		sd2.setName("Jeff");
		sd2.setPrice(456.12);

		sd1.showInfo();
		sd2.showInfo();
	}
}