package com.jdojo.common;

public class DoubleHolder implements Cloneable{
	private double holder;

	public DoubleHolder(double d){
		this.holder = d;
	}

	public void setValue(double d){
		this.holder = d;
	}

	public double getValue(){
		return this.holder;
	}

	/*
	* Overriding a method allow to drop or add throws clause
	* Here we return a DoubleHolder type, which means we cast the object of Object type returned by method super.clone()
	* to the type of the current class
	* We can now write a clone statement like this:
	*	DoubleHolder dhClone = dh.clone();
	*/
	@Override
	public DoubleHolder clone(){
		DoubleHolder dh = null;

		try{
			// Call the clone() method of Object class,
			// Copy bit by bit of the object using bitwise	
			// We cast the new object to type DoubleHolder		
			dh = (DoubleHolder) super.clone();
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}

		return dh;
	}
}