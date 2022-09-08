/*
* Here is an example of bad immutable class definition.
* The class "IntHolderWrapper" below has no direct way to change its instances variables
* by defining a final reference variable. 
* The final reference variable doesn't allow change to the reference value
* but the content of the object can be changed using the reference value.
* Changes made to the contained object using its reference, 
* will be reflected to its external state.
* The class "IntHolderWrapper" is not immutable as its external state is mutable.
*/
package com.jdojo.common;


public class IntHolderWrapper{
	private final IntHolder holder;

	public IntHolderWrapper(int value){
		this.holder = new IntHolder(value);
	}


	/*
	* Here, we return the reference variable 
	* which allow, indirect modification of the object 
	* referenced by the reference variable.
	*/
	public IntHolder getHolder(){
		return this.holder;
	}

	public int getValue(){
		return this.holder.getValue();
	}
}