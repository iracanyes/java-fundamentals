package com.jdojo.constructor;



class FinalKeyword{
	/*
	* Final keyword
	* The construct with the final keyword is associated does not allow modifying
	* or replacing the original value or definition of the construct
	*/
	/*
	* A blank final instance variable can be declared without initialization
	* It must be initialized when the object is created.
	* Rules:
	*	- It must be initialized in one of the instance initializer or all constructors
	*	- If it's initialized in an instance initializer, it can't be initialized in any
	*	  other instance initializer or constructors.
	*	- If it's not initialized in any instance initializers, the compiler ensure that it's
	* 	  initialized only once, by any of the constructors.
	*	  => If a constructor call another constructor, to avoid conflicts it's better
		  to initialize blank final instance variable outside of constructors.
	*/
	final int n;
	final int m = 100;
	public static final String MSG;
	final AccessLevelTest3 alt;
	
	{
		// final local variable
		final double d;

		/*
		* A blank instance variable MUST be initialized when an object is created
		*/
		n = 3;
		d = 456987.235698;

		/*
		* a final instance variables which value is known at compile-time is replaced
		* by its value.
		* n = n * m; will be replaced by n = 3 * 100
		* 
		* IMPORTANT:
		* Therefore when you update a constant in a class definition, you must
		* recompile all class that use the constant to ensure that the new value
		* is used in all compiled files that use the final instance variable. 
		*/
		n = n * m;
		
		System.out.println("n = " + n + "\nd = " + d);
	}




	{
		/*
		 * Final reference variable
		 * 
		 * */
		alt = new AccessLevelTest3();

		/*
		* Final reference variable cannot modify it value which the reference 
		* to object stored in memory.
		* But the object in memory can be manipulate as you want
		*/
		alt.title = "Inside instance initializer. Final reference variable initialized";
		alt.d = 9.23568E2;
		alt.d = 2.00;
		alt.d = Double.POSITIVE_INFINITY;

		// the statement below generate a compile time error
		// because we want to assign null reference to a constant reference variable which is already set
		// alt = null;
	}

	
	static {
		// final class variable MUST be initialized before it's used.
		MSG = "Hello from static initializer block aft MSG initialized";
		System.out.println("Message = " + MSG);
	}
	

	/*
	* final keyword can be used with formal parameters. 
	* Formal parameters are initialized automatically
	*/
	public static void test(final double d){
		int x = 65;
		final int y = 256;
		final int z;

		x = x + y;

		// Add some code
		// initialise constant after it declaration
		z =  97;

		x = x + y + z;


	}

	FinalKeyword(){
		
	}
}