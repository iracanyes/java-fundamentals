
package com.jdojo.object;

import com.jdojo.person.Person;

class ObjectComparison{
	private static Object obj1;
	private static Object obj2;

	public ObjectComparison(){
		obj1 = new Object();
		obj2 = new Object();
	}

	public static void main(String[] args) {
		/*
		* All object in Java are different from other objects.
		* All object have a unique identity: the memory address at which they are stored
		* In Java, 2 objects are the same if they have the same identity (reference or memory address)
		* 
		*
		*/
		

		Object obj3 = obj1;

		if( obj1 == obj2){
			System.out.println("Object1 and Object2 are the same object");
		}else{
			System.out.println("Object1 and Object2 are the same object");
		}

		if( obj1 == obj3){
			System.out.println("Object1 and Object3 are the same object");
		}else{
			System.out.println("Object1 and Object3 are the same object");
		}


	}

	/*
	* DEFAULT IMPLEMENTATION OF THE EQUALS METHOD
	* Compare the identity (reference or memory address) of the object
	* for equals
	*	public boolean equals(Object obj){
	*		return (this == obj);
	*	}
	*
	* If you want to compare the state of the objects.
	* You must override the equals() method
	*	See com.jdojo.common.SmartPoint for equals() and hashCode() overrides
	*/	

}