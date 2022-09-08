/**
* Rules for reimplementing equals() and hashCode() method of Object class
* 	- Reflexivity: 
* 		An object must be equal to itself.
* 		x.equals(x) must return TRUE
* 	- Symmetry : 
* 		If x is equal to y. y is equal to x
* 		x.equals(y) is true, y.equals(x) is true
* 	- Transitivity: 
* 		If x is equal y and y is equal to z, x must be equal to z
* 		x.equals(y) is true, y.equals(z) is true, so x.equals(z) is true
* 	- Consistency: 
* 		If x.equals(y) is true, it should be true until
* 		the modification is made to the state of one of the two object
* 	- Comparison with null reference : 
* 		An object of any class SHOULD NOT BE EQUAL TO NULL REFERENCE
* 		x.equals(null) MUST ALWAYS RETURN FALSE
* 	- Relationship with hashCode() method:
* 		If 2 objects are equals using equals() method, they must return 
* 		the same value for hashCode().
* 		BUT if 2 objects have the same hashCode() return value
* 		that doesn't imply that they are equals!
* 
* Important: Always use the same instance variable in equals() and hashCode().
* If change are made to instance & reference variable  used in one of the method
* you must also update the other method
* 		 
*/
package com.jdojo.common;

public class SmartPoint{
	private int x;
	private int y;

	public SmartPoint(int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj){
		/*
		* First, we check that the object passed is the same as the object
		* on which the method is called.
		* 
		*/
		if(this == obj){
			return true;
		}

		/* If object is null reference it cannot be the same.
		* because the method cannot be called on a SmartPoint type reference variable 
		* which store a null reference
		*/
		if(obj == null){
			return false;
		}

		/*
		* As the method accept any object, we need to compare
		* the class of the object with the class of method caller
		*/
		if(this.getClass() != obj.getClass()){
			return false;
		}

		// Check value of instance variable
		SmartPoint sPt = (SmartPoint) obj;

		boolean samePoint = (sPt.x == this.x && sPt.y == this.y);

		return samePoint;
	}

	@Override
	public int hashCode(){
		return (this.x + this.y);
	}

	@Override
	public String toString(){
		String str = "( " + this.x + ", " + this.y + ")";
		return str;
	}
}