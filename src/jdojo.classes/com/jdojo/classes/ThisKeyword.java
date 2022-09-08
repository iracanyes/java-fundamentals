package com.jdojo.classes;

/*
* 
* Class context:
*	- class variable initialization
*	- class initializer (also called static initializer)
*	- class method (also called static method)
* Instance context:
* 	- Instance variable initialization
*	- Instance initializer
*	- Constructor
*	- Instance method (also called non-static method)
* 
* IMPORTANT:
* Class variable/methods can be used in both class and instance context
* and this keyword and instance variable/methods can only be used in an instance context 
*/
public void class ThisKeyword{
	int varA = 200;
	static int staticVarA = 500;

	/*
	* This - Reference to the current instance of a class
	*
	* It can be used only in context of an instance.
	*/
	int varB = this.varA;

	/* 
	* IMPORTANT: This keyword can NEVER be used in context of class (static method/variable);
	*/
	// Compile-time error : non-static variable 'this' cannot be referenced from a static context
	// static int staticVarAPrime = this.varA;

	/*
	* Here, we use a class variable assign 
	*/
	static int varD = staticVarA;
	static int varE = ThisKeyword.staticVarA;



	void thisKeyword(){
		
		// Here, we use the value of "myInstanceVar" for the current instance of this class
		int a = this.myInstanceVar;	
		// Same as
		int a_prime = Methods.myInstanceVar;

		// Using this with in a class context (static method/variable)
		// Compile-time error - non-static variable this cannot be referenced from a static context
		// int b = this.myStaticVar;	// Error: Here, we use 'this' to refere to a class variable (static) 
		// static int c = this.myVar;	// Error: Here we try to assign an instance variable to a static variable
	
		/*
		* 'this' is a constant (final type)
		* It can't be modified or assign to null
		*/
		// Compile-time Error
		// int this = 10;	// Cannot use "this" as identifier. 'this' is reserved keyword! 
							// you cannot use 'this' for something other thant it purpose 
		// this = null;		// Cannot assign value to a constant


	}

	void classVariables(){
		/*
		* Class Variables/method (static)
		

		*/
	}
}