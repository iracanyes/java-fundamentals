package com.jdojo.constructor;

/*
* Instance initializer are executed in the order they appear in class declaration.
* Command: 
	1. Compile:
	 	javac -d mod/jdojo.constructor  src/jdojo.constructor/module-info.java src/jdojo.constructor/com/jdojo/constructor/InstanceInitializer.java
*	2. Run : 
		java -cp mod/jdojo.constructor com.jdojo.constructor.InstanceInitializer
* Result: 
*	Inside instance initializer 1.
*	Inside instance initializer 1.
*	Inside no-args constructor.
*/
class InstanceInitializer{
	/*
	* Instance initiliazer are simply an unamed block of code inside the body of a class
	* It's also used to initialize an object.
	* A return statement isn't allowed in a instance initializer
	* It cannot throw checked exceptionn unless ALL DECLARED CONSTRUCTORS list 
	* those checked exception in their "throws" clause.
	* Recall: Instance initializer are executed ONCE PER OBJECT
	*/
	{
		System.out.println("Inside instance initializer 1.");
	}

	{
		System.out.println("Inside instance initializer 1.");
	}

	public InstanceInitializer(){
		System.out.println("Inside no-args constructor.");
	}

	/*
	*
	*/
	public static void main(String[] args) {
		InstanceInitializer ii = new InstanceInitializer();
	}
}