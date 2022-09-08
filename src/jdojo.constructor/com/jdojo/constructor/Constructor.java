package com.jdojo.constructor;

public class Constructor{
	String title;

	public static void main(){
		/*
		* The operator new is followed by a constructor call to create a un object and initialize it
		* 
		*/
		// Compile time error: no-args constructor is private
		//Cat aCat = new Cat();
		Cat poutine = new Cat("Poutine"); 
	}	
}

class Cat{
	String name;

	/**
	* The constructor is a named block of code that is used to initialize 
	* an object of a class immediately after the object is created.
	* Structure: 
	* 	[modifiers] <constructor-name>(<parameters-list>) [throws-clause] {
	* 		// Body of constructor
	* 	}
	* 
	* 	- modifiers: can be (public, private, protected or package-level)
	* 	- constructor-name: MUST BE THE SAME AS THE SIMPLE NAME OF THE CLASS
	* 	- parameters-list: list of arguments to pass to the constructor (comma separated list)
	* 	- throws-clause: list of error throw by the method (comma separated list)
	*/
	/*
	* Method can have the same name as the simple name of the class.
	* If a method have the same name as the simple name of the class and 
	* have a return type. Java consider that method as a method declaration
	*/
	public void Cat() throws Exception {

	}

	/*
	* Constructor CANNOT HAVE A RETURN-TYPE.
	* This method have the same name as the simple name of the class and 
	* doesn't have a return type.
	* Java compiler will consider the method below as the constructor of the class 
	*/
	public Cat() throws Exception{
		
		/*
		* Body of constructs should the used to initialized the instance variables of 
		* the newly created object.
		*/

		/*
		* A constructor may call another constructor of the same class.
		*
		* Structure:
		* 	this(<parameter-list>)
		*
		* 2 rules to ensure that a constructor is called only once:
		*	- The call to another constructor MUST be the first statement in the constructor
		*	- A constructor cannot call itself 
		*/

		// If a statement is placed before a same class constructor call
		// it generate a compile time error.
		// Uncomment and compile the code: call to this must be first statement in constructor
		// int a = 23; 
		this("Missy");
		

	}

	/*
	* CLASS OVERLOADING
	* A constructor method can have multiple signature. 
	* Also called Overloaded constructors.
	* All the constructors MUST differ from the others in the number, order, or type of parameters
	*/
	protected Cat(String name){
		if(name == ""){
			/*
			* A constructor cannot have a return type in its declaration.
			* Recall: 
			* The return statement without a return expression, 
			* simply return the control to the caller without returning any value!
			*
			* Here, when the return statement is executed, the control returns to the 
			* caller, ignoring the rest of the constructor's code.
			*/
			return;
		}
		/*
		*/
		this.name = name;
	}

}

/* DEFAULT CONSTRUCTOR
* Java will generate a constructor if no construction declaration is present.
*
* Java will compile the class below as
* class NoConstructor{
*	NoConstructor(){
*		super();
*	}	
* }
*/
class NoConstructor extends AccessLevelTest3{
}	

/*
* Java will compile the class below as this
* class NoConstructor2{
*	NoConstructor2(){
*	
*	}
*	private class InnerNoConstructor{
*		private class InnerNoConstructor(){
*	
*		}
*	}
* }

*/
class NoConstructor2{
	private class InnerNoConstructor{

	}
}
