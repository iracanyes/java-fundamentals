package com.jdojo.classes;

class Methods {
	
	int myInstanceVar = 10;				// instance variable
	static long myStaticVar = 1000001;	// class variable

	/*
	* SIGNATURE OF METHOD
	* Defines a behaviour for the instance of this class (objects).
	* Structure:
	*	[modifiers] <return-type> <method-name>(<parameters-list>) [throws-clause]{
	*		// Body of the method
	*	}
	*
	*	- Modifiers: 		Optional list of modifiers of the method (public, static)
	*	- Return type: 		Data type of the value returned by the method
	*	- Method name: 		Name of the method (valid java identifier)
	*	- Parameters' list: Optional list of comma separated parameters accepted by the method. 
	* 	- Throws clause: 	List of types of exceptions thrown from the method
	*/
	int add( int a, int b){

		int sum = a + b;
		/*
		* RETURN STATEMENT
		* Expression returned by return statement must be evaluate to existing data type (primitive or reference type) 
		* which is assignment compatible with the specified return type of the method
		* Structure:
		*	- Return data type:
		*		return <expression>;
		*	- Return void type (no return statement is ok too);
		*		return;
		*/
		return sum;		// 
	}
	/*
	*  
	* A method has a signature, which uniquely identifies the method in a particular context.
	* The signature of method is composed of:
	*	- Name of the method
	*	- Number of parameters
	*	- Types of parameters
	*	- Orders of parameters
	*
	* Modifiers, return types, parameters' name, and the throw clauses are not part of the 
	* method signature.
	* Example:
	*	Method declaration 											Method signature
	*	-----------------------------------------------------------------------------
	*	int add(int n1, int n2)									 |	add(int, int)
	*	int add(int n3, int n4)									 |	add(int, int)
	*	public int add(int n1, int n2)							 |	add(int, int)
	*	public int add(int n1, int n2) throws OutOfRangeException|	add(int, int)
	*	void process(int n)										 |  process(int)
	*	double add(int n1, double d1)							 |	add(int, double)
	*	double add(double d1, int n1)							 |  add(double, int)
	*
	* IMPORTANT: COMPILER DOESN'T ALLOW TO 2 METHODS WITH THE SAME SIGNATURE IN A CLASS
	*	
	*/
	/*
	*
	* THE SIGNATURE ALREADY USED - Compile time error
	* int add(int var1, int var2){
	*	int sum = var1 + var2;
	*	return sum;	
	* }
	*/
	/*
	* VOID RETURN TYPE
	*/
	void sayHello(){
		System.out.println("Hello world");
		// Return statement is optional for void return type
		// return;
	}


	void localVariables(){
		/*
		* LOCAL VARIABLE
		* A local variable exists only during the execution of the method in which it's defined.
		* Parameters of method are also treated as local variable
		*
		* Rule 1
		* Local variables are not initialized by default
		*/
		int sum;	// No default value  assigned by compiler in method

		/* Rules 2
		* Local variable CAN'T be used before any value is assigned to it
		*/

		// Compile-time error: Cannot read sum because no value assigned
		//System.out.println(sum);

		sum = 1 + 2;
		System.out.println(sum);	// Ok. Value assigned to sum

		/*
		* Rules 3
		*
		* A local variable hides the names of an instance variable and a class variable.
		* E.g. instance variable 'myInstanceVar' and class variable 'myStaticVar' defined at the beginning of this class definition
		* If a local variable use the same name as a class field (instance/class variable)
		* It will hide the class field
		*/
		int myInstanceVar = 20;		// myInstanceVar already exists in the scope of the class so it will be hidden

		System.out.println(myInstanceVar);	// Show 20. Because local variable 'myInstanceVar' hide the instance variable 'myInstanceVar'
	}

	/*
	* INSTANCE METHODS AND CLASS METHODS
	*/
	/*
	* INSTANCE METHODS
	* Used to implement behavior of instances (objects) of the class;
	* Instance methods can ONLY be invoked in a context of an instance of the class 
	* Remember: Each instance of a class has his own copy of each instance method
	*/
	void anInstanceMethod(){
		/*
		* Non-static method can access both instance variable and class variable
		*/
		System.out.println(myInstanceVar);	// OK

		/*
		* Class variable/methods can be used without Class Initiliazation
		*/
		Human.sayHello();	
	}

	/*
	* CLASS METHODS
	* Used to implement the behaviour of the class itself.
	* A class methods can ONLY be invoked in a context of a class
	* 'static' modifier is used to define a class method.
	* Remember: One copy of a class method exists. 
	*/
	static void aClassMethod(){
		/*
		* IMPORTANT: 
		* But Instance variable can't be used in a static method because they may not be initiliazed
		*/
		// Uncomment - Compile time error: Static method try to access non-static variable
		// System.out.println(myInstanceVar);
	}

	void methodInvokation(){
		/*
		* METHOD INVOCATION
		* Structure:
		*	<instance-reference-name>.<instance-method-name>(<actual-parameters>);
		*/
		/* 
		* INVOKING INSTANCE METHODS
		* Before calling a instance  method, you MUST have an instance of reference type initialized
		*/
		Human man = new Human();
		man.sayYourName();

		
		/*
		* INVOKING CLASS METHODS
		* As class methods can be used without initializing the class in use,
		* Class methods cannot use instance variables because they are initialized at constructor call
		* 
		*/
		Human.sayHello();
		man.sayHello();
	}


	

}