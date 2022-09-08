package com.jdojo.common;

public class SmartDog{
	private String name;
	private double price;

	public SmartDog(){
		/*
		* When there is no naming conflict,
		* the use of the keyword "this" to refer to instance of class is optional 
		*
		*/
		name = "Unknown";
		price = 0.0;

		System.out.println("Using SmartDog() constructor");
	}

	public SmartDog(String name, double price){
		/*
		* When there is naming conflict,
		* the use of the keyword "this" to refer to instance of class is MANDATORY 
		*
		*/
		this.name = name;
		this.price = price;

		System.out.println("Using SmartDog(String, double) constructor");
	}

	public void bark(){
		/*
		* if no identifier is the same as the instance variables of the class identifier.

		* The use of 'this' keywork is optional.
		*/
		System.out.println(name + " is barking...");
	}

	/*
	* 
	*/
	public void setName(String name){

		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public void setPrice(double price){
		this.price = price;
	}

	public double getPrice(){
		return this.price;
	}

	public void showInfo(){
		System.out.println("Name: " + name);
		if(price >  0.0){
			System.out.println("Price: " + this.price);
		}else{
			System.out.println("Price: " + price);
		}
	}


}