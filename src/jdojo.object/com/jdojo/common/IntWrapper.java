package com.jdojo.common;

/*
* The class is also immutable because it give no way to change the value 
* of its instance variable after its creation
*/
public class IntWrapper{
	/*
	* As the only instance variable of the class is a final instance variable
	* which means its value cannot be changed after its creation
	*/
	private final int x;

	public IntWrapper(int x){
		this.x = x;
	}

	public int getValue(){
		return this.x;
	}
}