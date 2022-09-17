package com.jdojo.address;

import java.io.Serializable;

public class Address implements Serializable, Comparable{
	private String line1;
	private String city;
	private String state;
	private String zip;

	private Address(){
		line1 = "12, Boulevard General Jacques";
		city = "JacksonVille";
		state = "Florida";
		zip = "32256";
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

	public static Address getInstance(){
		return new Address();
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
		return "[ Line1 = " + line1
			+ " ; City = " + city
			+ " ; State = " + state
			+ " ; Zip = " + zip;
	}

	@Override
	public int compareTo(Object compareTo){
		try{
			Address compareToAddress = (Address) compareTo;
			// Compare if zip code are different
			int compareZip = this.zip.compareTo(compareToAddress.getZip());
			if( compareZip > 0 ){
				return 1;
			}else if(compareZip < 0){
				return -1;
			}

			// Compare if state are different
			int compareState = this.state.compareTo(compareToAddress.getState());
			if( compareState > 0 ){
				return 1;
			}else if(compareState < 0){
				return -1;
			}

			// Compare if cities are different
			int compareCity = this.zip.compareTo(compareToAddress.getCity());
			if( compareCity > 0 ){
				return 1;
			}else if(compareCity < 0){
				return -1;
			}

			// Compare if address lines are different. If address line are equals, it's the same address
			int compareAddressLine = this.line1.compareTo(compareToAddress.getLine1());
			if( compareAddressLine > 0 ){
				return 1;
			}else if(compareAddressLine < 0){
				return -1;
			}

			return 0;
		}catch(Exception e){
			e.printStackTrace();
		}

		return 0;
	}


}
