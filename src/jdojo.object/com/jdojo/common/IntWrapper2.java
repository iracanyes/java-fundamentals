package com.jdojo.common;

/*
* Here is an example of a class which state is externally immutable and internaly mutable.
* When the getHalfValue() method is called, it change the internal state of the object
* but the external state remains unchanged.
* The object of the class are called immutable objects as theirs external state is immutable.
*
* Another example of class which used the caching technique for the hashCode() method
* value which is computed at the first call of the method
* All other call to the hashCode() method will use the cached value.
* String are considered immutable object but their internal state change over time.
*/
public class IntWrapper2{
	private final int value;
	private int halfValue = Integer.MAX_VALUE;

	public IntWrapper2(int value){
		this.value = value;
	}

	public int getValue(){
		return this.value;
	}

	public int getHalfValue(){
		// Compute haft value if it's not computed
		if(this.halfValue == Integer.MAX_VALUE){
			// Cache the half value for future use
			this.halfValue = this.value / 2;
		}

		return this.halfValue;
	}
}