/**
 * Description:
 * Argument passing mechanisms
 * */
package com.jdojo.classes;


public class ParameterPassing{

	public static void main(String[] args) {
		
		/*
		* PASS BY VALUE
		* When a method is called, the values of the actual parameters are copied to the formal parameters.
		* When the method execution starts, 2 copies of the value exist in memory:
		*	- one copy for the actual parameter
		*	- one copy form the formal parameter
		* Inside the method, the formal parameters operates on its own copy of the value.
		* When method execution ends, all local variables of the method are destroyed (including the formal parameters) 
		* and continue it execution with the actual parameters
		*
		* Pass by value allow to pass multiple arguments from the caller environment to the method
		* using multiple parameters BUT it lets you send back ONLY ONE VALUE
		*/
		  
		int d = 89;
		int f = 65;
		// Here, we operate on 2 parameters BUT we can only return one
		// Pass by value is applied to primitive type in Java
		// Modification made to primitive value inside the method have no effect 
		// on actual parameters "d" and "f" in the caller context  
		badSwap(d, f);

		/**
		* PASS BY CONSTANT VALUE
		* It's the same as Pass by Value with one difference that the formal parameters
		* are considered as constants (ReadOnly).
		* */
		final int MACONSTANTE = 12;
		final int MACONSTANTE2 = 987;

		// Here is an example of pass by constant
		// Compile-time error: Constant cannot be modified!
		//badSwap( MACONSTANTE, MACONSTANTE2 );

		/**
		* PASS BY REFERENCE	VALUE
		* 
		* The memory address of the actual parameters is passed and the formal parameters are mapped (associated ) 
		* with the memory of the actual parameters.
		* Multiple reference variables can be associated with the reference memory location.
		* The reference of the actual parameter is copied to the formal parameter inside the method.
		* The formal parameter uses a dereferencing mechanism to access the actual parameter
		* Modifications made to the formal paramater inside the method is immediately visible by
		* the actual parameter from the method caller environment. 
		* HOWEVER, you can change the formal parameter to refer to a different location in memory inside the method
		* which will not make the actual parameter refer to the new location in memory
		* => Once you change the reference stored in the formal parameter, any changes made to the value stored 
		* at the new location will not change the value of the actual parameter.
		*
		* Passing by reference allow a two-way communication between caller and method
		* Multiple parameters can be passed by reference and the method can modify all parameters received
		* All modification to formal parameters are reflected back to actual parameters 
		* 
		* */


		// Pass by reference value : Example 1
		// Here, we suppose that arguments are passed by reference value to show effect
		// BUT remember that JAVA pass by reference value ONLY REFERENCE VARIABLES!
		//
		// 1. x and y have same memory adress than w
		// 2. int x = 3; => assign 3 to memory address x which is the same than w and y.
		// 3. After operation, x, y and w are equal to 3
		// 4. int y = 3; => assign 5 to memory address y which is the same than x and w.
		// 4'. Here, x, y and w are equal to 5.
		// int sum = x + y; => equal to 5 + 5 = 10
		// 5. Return 10.
		int w = 100;
		int s = getNumber(w, w);  

		
		

		/* Exemple of pass by reference
		* 
		* 1. Assign 3 to variable x which memory address is the same than 'a'
		* 2. Assign 5 to variable y which memory address is the same than 'b'
		* 3. int sum = x + y; Assign 8 to sum and return the value to method caller
		* 4. int s = 8 + 3;	=> c got 11 as value 
		*/
		int a = 100;
		int b = 300;
		int c = getNumber(a, b) + a;

		/*
		* Here the variable 'a' is used in the addition before the method 'getNumber' 
		* modify it.
		* e = 10 + 8
		*/
		a = 10;
		b = 19;
		int e = a + getNumber(a, b);

		
		
		/* Important: 
		* When you create an object of a reference type, the object is created on heap and 
		* memory is allocated for all of its instance variables and they are initialized.
		*
		* All variables of reference types are reference variables in Java.
		* A reference variable can store a "null" reference, which means that it refers to nothing
		*/
		Car tesla = null;

		/*
		* Operator "new" return the reference (memory address) of the newly created object
		* In order to manipulate the objet, you need to store the reference of the object in a reference variable
		*
		*/
		tesla = new Car();
		Car tesla2 = null;

		/*
		* Here, we assign the value of the reference variable "tesla" to the reference variable "tesla2"
		* Now "tesla" and "tesla2" reference variables have the same reference (memory address) to the instance of the class Car created
		* which they can access the same instance of class Car
		*/			
		tesla2 = tesla;

		/*
		* Here we use reference variable to modify the object  on which it refers to
		*/
		tesla.model = "Model S";
		tesla.year = 2020;
		tesla.price = 32000.00;
		Car.showInfo(tesla);
		/*
		* Here, we set the reference variable "tesla" to the null reference but
		* object still exists in memory and it's not reachable 
		* until the garbage collector runs, check that the object is not use
		* and is not reachable before destroying it
		*/
		tesla = null;

		/*
		* In Java, STRING ARE IMMUTABLE REFERENCE VARIABLE
		* 
		*/
		String s1 = "Hi";
		/*
		* At the end of method's execution, String object will still be the same
		*/
		badChangeString(s1);
		Car xCar = new Car();
		xCar.model = changeString(xCar.model);
		
		 /**
		  * PASS BY CONSTANT REFERENCE VALUE
		  * Same as passing by reference value with the difference 
		  * the formal parameter is treated as a constant inside the method body;
		  * The formal parameter holds the copy of the reference held by the actual parameter
		  * during the entire execution of the method
		  * IMPORTANT: the formal parameter cannot be modified inside the body of the method to 
		  * hold reference of data other than what the actual parameter is referencing.
		  * */
		
		  /*
		  * PASS BY RESULT
		  * The value of the actual parameter is not copied to the formal parameter
		  * The formal parameter is considered an uninitialized local variable when
		  * the method execution starts.
		  * During the execution of the method, the formal parameter is assigned a value
		  * and at end of the execution, the value of the formal parameter is copied back to 
		  * the actual parameter.
		  * In pass by result:
		  *	- Formal parameters are also known as OUT parameters
		  *		because there are used to copy out a value from the method to the caller's environment
		  *	- Actual parameters are also known as IN parameters
		  */

		  /**
		   * PASS BY VALUE RESULT (also known as copy-restore)
		   * Also known as IN-OUT way of passing parameters
		   * When method is called, the value of the actual parameter is copied to the formal parameter
		   * During the execution, the formal parameter operates on its own copy of the actual parameter
		   * When execution of the method ends,  the value of the formal parameter is copied out to the actual parameter
		   * 
		   * It copies the value of the actual parameter at beginning of method's execution
		   * and restore the value of formal parameter in the actual parameter at the end of method's execution
		   * 
		   * Here, the difference is that modifications made to the actual parameter by method 
		   * will only be visible to the caller's environment at the end of method execution
		   * 
		   * A pass by value result is used to simulate a pass by reference in a distributed application.
		   * 
		   * When a remote method call which is executed on a remote machine is made, 
		   * The reference (memory address) of the actual parameter doesn't make no sense to the remote machine;
		   * The client application sends a copy of the actual parameter to the remote machine.
		   * The value copied to the formal parameter is on the remote machine.
		   * The formal parameter operates on the copy.
		   * When method's execution ends, the value of the formal parameter on the remote machine 
		   * is copied back to the actual parameter on the client machine.
		  */

		  /**
		   * PASS BY NAME
		   * The actual parameter expression is evaluated before its value or reference
		   * is passed to a method.
		   * In pass by value, the actual parameter's expression are not evaluated when a method is called.
		   * The formal parameter's name inside the body of method is substituted textually with 
		   * the expression of the corresponding actual parameter.
		   * 
		   * Actual parameters are evaluated each time they're encounterd
		   * during the execution of the method and they're EVALUATED IN THE CALLER'S CONTEXT, 
		   * not in the method's context.
		   * 
		   * Naming conflict between local variable in the method and actual parameter expression 
		   * during substitution are resolved by renaming the local variable to a unique name.
		   * 
		   * Pass by name is implemented using thunks;
		   * A thunk is a piece of code that compute and return the value of an expression in a specific context.
		   * Notation : (expression_to_evaluate)
		   * 
		   * A thunk is generated for each actual paramaters and its reference is passed to method.
		   * At each use of a formal parameter, a call to the corresponding thunks is made,
		   * which evaluates the actual parameters in the caller context
		   * 
		   * Pass by name is like a lazy evaluation. Actual parameters are not evaluated if they aren't used. 
		   * 
		   * */
		   /*
		   * squareDivide will return z = ((4 + 8) * (4 + 8) / (9 - 7) *  (9 - 7))
		   */
		   squareDivide((4 + 8), (9 - 7));

		   /**
		    * PASS BY NEED
		    * Similar to pass by name with one difference.
		    * Actual parameters are evaluated ONLY ONCE UP ON THEIR FIRST USE in the method
		   	* When a thunk for an actual parameter is called for the first time, 
		   	* it evaluates the actual parameter expression, caches the value and returns it. 
		   	* When the same thunk is called again, it simply returns the cached value, 
		   	* rather than re-evaluating the actual parameter expression.
		   */


	}
	
	/*
	* In Java, this method below to swap 2 values cannot work
	* Because Java pass primitive types by value.
	* The formal parameter of the method can be manipulate inside the method
	* without affecting the actual parameter 
	* At the ends of the method execution, actual parameter will be the same
	*/
	void badSwap(int x, int y){
		int t = x;
		x = y;
		y = t;

	}

	/** PASS BY REFERENCE
	 * Here, we suppose that argument are passed by reference to the method
	 * When the method is called:
	 * 		1. x will have the same memory address than the argument passed at that place
	 * 		2. y will have the same memory address than the argument passed at that place
	 * */
	int getNumber(int x, int y){
		/*
		* Assign 3 to memory address by x
		*
		*/
		int x = 3;

		/*
		* Assign 5 to variable y 
		* which memory address is the same as first argument received by the method
		*/
		int y = 5;

		int sum = x + y;
	}

	/*
	* PASS BY REFERENCE
	* Here is an example with reel pass by reference value
	* When the method starts executing, both actual parameters in caller context 
	* and the formal parameter inside the method refers to the same object.
	* All manipulation made inside the method will impact the object which the
	* formal parameter and the actual parameter refers to.
	*  
	*/
	void updateCar(Car car){
		/*
		* Here, we must 
		*/
		if(car == null){
			car = new Car();
		}
		
		car.model = "Model S";
		car.brand = "Tesla";
		car.year = 2022;

		Car.showInfo(car);
	}

	/*
	* Pass by reference value : Example with String Class
	* Remember that in Java, all string are instance from class String
	* 
	* STRING ARE IMMUTABLE;
	* To change a string, you need to create a new string with the new content
	* The example below show a modification made to a String object passed in argument of method
	* At the ends of execution of the method, the formal parameter inside the method
	* will be destroyed but the actual parameter in the caller context will stay unchanged!
	*/
	public void badChangeString(String s2){
		s2 =  s1 + " there";
	} 

	public void changeString(String s2){
		s2 = new String(s2 + " There");
	}

	/*
	* PASS BY RESULT VALUE
	*/
	int squareDivide(int x, int y){
		int z = x * x / y * y;
		return z;
	}

	/*
	* PASS BY CONSTANT REFERENCE VALUE
	* Allow to pass a reference to an actual parameter with a READ_ONLY access to reference
	* which means that FO variable  CANNOT BE MODIFIED
	*/
	public void test(final Car aCar){
		// Read only access 
		String model = aCar.model;
		/*
		* 
		*/
		// Compile time error: Read only access to reference variable 'aCar'
		// aCar.model = "Nissan";
		// aCar = null;
		// aCar = new Car();
	}


	
		

}


class Car {
	public String model = "Unknown";
	public String brand = "Unknown";
	public int year = 2000;
	public double price = 0.0;
	public final String CATEGORY = "4 wheels";

	public static void showInfo(Car aCar){
		System.out.println(
			"Model = " + aCar.model
			+ "\nYear = " + aCar.year
			+ "\nPrice = " + aCar.price
		);
	}


}