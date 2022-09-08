package com.jdojo.address;

import java.io.Serializable;

public class Address implements Serializable{
	private String line1 = "12, Boulevard General Jacques";
	private String city = "JacksonVille";
	private String state = "Florida";
	private String zip = "32256";

	public Address(){

	}

	public Address(
		String line1,
		String city,
		String state,
		String zip 
	){
		this.line1 = line1;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	// Getter & Setter
	public String getLine1(){
		return this.line1;
	}

	public void setLine1(String line1){
		this.line1 = line1;
	}

	public String getCity(){
		return this.city;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getState(){
		return this.state;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getZip(){
		return this.zip;
	}

	public void setZip(String zip){
		this.zip = zip;
	}

	/**
	 * toString method return string representation of instance of this class
	 * */
	@Override
	public String toString(){
		return "Address:\nLine1 = " + line1 
			+ "\nCity = " + city 
			+ "\nState = " + state
			+ "\nZip = " + zip;
	}


}