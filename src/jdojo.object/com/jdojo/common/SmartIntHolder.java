package com.jdojo.common;

public class SmartIntHolder{
	private int i;

	public SmartIntHolder(int i){
		this.i = i;
	}

	public void setValue(int i){
		this.i = i;
	}

	public int getValue(){
		return this.i;
	}

	@Override
	public String toString(){
		// Return all instance variable as string representation
		// To create String object from integer primitive type
		String str = String.valueOf(this.i);

		return str;
	}
}