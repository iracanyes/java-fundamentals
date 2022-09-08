/*
* Correct immutable class
* Here, for all reference type instance variable of the class returned by the class, we create a copy
* to avoid modification of contained objects of the container object.
* In the class below, there are no direct way to modify its instance and reference variables
* The class is considered immutable as its external state cannot be changed
*/
package com.jdojo.common;


public class IntHolderWrapper2{
	private final IntHolder holder;

	public IntHolderWrapper2(int value){
		this.holder = new IntHolder(value);
	}



	public IntHolder getHolder(){
		// Make a copy of the reference variable
		int value = this.holder.getValue();
		IntHolder copy = new IntHolder(value);

		return copy;
	}

	public int getValue(){
		return this.holder.getValue();
	}
}

