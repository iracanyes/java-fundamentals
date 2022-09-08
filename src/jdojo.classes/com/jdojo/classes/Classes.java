package com.jdojo.classes;
/*
* Structure:
*	[modifiers] class <class-name>{
*		// Body of the class		
* 	}
*
*  	- [modifiers] are optional. A class may have zero or more modifiers
*	- 'class': keywork used to declare class
*
* The name of a class defines a reference type in Java.
*
* For accessing a class A defines  in a module P1 from module P2:
*	- Class A MUST be define as public. (defined using class-modifier 'public')
*	- Module P1 must export the package in which class A is defined 
*
*/
public class Classes{
	/*
	* Classes are the basic units of programming in the object-oriented paradigm.
	*/
	/*
	* Field Declaration
	*
	* Structure:
	*
	* 	[modifiers] class <class-name{
	*		// A field declaration 
	*		[modifiers] <data-type> <field-name> [ = <initial-value> ] 
	*	}
	*
	* data field initialization is optional
	*  
	* Java let you declare 2 type of fields in a class:
	*	- Class fields (class variables)
	*	 	Only one copy of the class property exists
	*	- Instance fields (instance variable) 
	*		A separated copy of instance property exists for each instance of a class
	*/
	public String myProperty = "My value";
	public float myPropertyUninit,
				mySecondPropertyUninit;
	/*
	* Static property belongs to a class itself, not to any particular instance of the class
	* Also known as class variables or static variables.
	*/
	static long myStaticProperty; 

	/*
	* To start a program, you give to java compiler a class to run.
	* Javac look for a public method which can be accessed by the class name (static method)
	* This method must be called "main" and have a return type "void" and has a String array arguments
	*/
	public static void main(String[] args){


	}

	public void creatingInstance(){
		/*
		* Structure:
		*	new <Class_Constructor>
		*
		* 
		*
		* Operator 'new' creates an instance of a class
		* by allocation of memory on heap (sur le tas).
		* If you want to access an instance of a class, 
		* you need to attach a reference to the instance (object) created.
		*
		* Here, we create a variable 'me' which store a reference to an instance of class 'Human'
		*/
		Human me = new Human();

		/*
		* To access public instance variables.
		* Structure:
		*	<instance_class>.<instance_variable>
		*/
		String name = me.name;
	}

	public void nullReferenceType(){
		/*
		* NULL REFERENCE TYPE
		* The null reference type is assignment-compatible with the other reference types.
		* 
		* It has only one value defined by Java, which is 'null' literal
		*/
		Human jack = null;		// variable is not referring to any object. Null literal is a Null reference type
								// You can assign 'null' reference type to any variable of ANY reference type.
		
		// Perfoming an operation on a Null reference type
		// Uncomment. Java throws an NullPointerException
		// String name = jack.name;

		jack = new Human();

		if(jack == null){
			// Here cannot use 'jack' reference type variable.
		}else{
			// Here, Jack is a usable reference type variable
		}

		/*
		* Java doesn't allow to mix primitive types and reference types.
		*/
		// Uncomment - Compile-time error. Mix of reference type and primitive types not allowed
		// int num = null;
		// Comparison also not allowed
		// if( num == null){}



	}

	public void accessingFieldsOfClass(){
		/*
		* DOT NOTATION TO ACCESS FIELDS OF A CLASS (INSTANCE VARIABLE & CLASS VARIABLE)
		* Dot notation 'x.y' is used to manipulate instance variables of class
		*
		* Structure:
		*	<reference_variable_name>.<instance_variable_name>
		*
		*/
		Human tony = new Human();
		/*
		* get value of instance variable gender of instance 'tony'
		*/
		String gender = tony.gender;

		/*
		* Assign value to instance variable
		*/
		tony.name = "Tony Parker";

		/*
		* ACCESS CLASS VARIABLE USING DOT NOTATION
		*
		* Structure:
		*	<class_name>.<class_variable_name>
		*
		*/
		long population = Human.count;

		Human.count = 12;

		/*
		* You can use a instance of Human type to access class variables
		*/
		jack.count = 15; 	// OK
		long populationFromJack = jack.count;	// Assign value of class variable

		System.out.println("Population: " + population);
		System.out.println("Population à partir de l'instance jack: " + populationFromJack);
	}

	public void defaultInitializationValue(){
		/*
		* Type 		Default value
		* byte			 0
		* short			 0
		* int 			 0
		* long 			 0
		* float			 0.0
		* double		 0.0
		* boolean		 false
		* String		 null
		* Human			 null
		*/
		Human person = new Human();

		System.out.println(person.age);
		System.out.println(person.child);
		System.out.println(person.id);
		System.out.println(person.weight);
		System.out.println(person.totalAccount);
		System.out.println(person.name);
		System.out.println(person.name);
		System.out.println(person.count);
	}

	public void accessLevelModifiersForClasses(){
		/*
		* ACCESS LEVEL MODIFIERS FOR CLASSES
		* Structure:
		*	[modifiers] class <class-name>{
		*		// Body of class
		*	} 
		*
		* Access level modifiers (public, private) allow the define access level
		* of the class.
		*	- public: allow access to the class definition from outside the package
		*		Ex: public class <class-name>{}
		*	- no value: (Called package level access) allow access to class definition only to class inside the package 
		*		Ex: class <class-name>{}
		*/
		/*
		* Accessing a public class from another package in the same module.
		*
		* If no import statement is defined before class definition.
		* You must use the fully qualified name of the class. Otherwise, a error is thrown
		* In this case : 
		*	Car myCar = new Car();	// Error: Cannot find symbol
		*
		* Otherwise, u can define an import statement to import all classes definition in package "com.jdojo.common"
		* and after directly use the class 'Car' like so:
		* Example:
		* 	package com.jdojo.classes;
		* 	import com.jdojo.common;
		*
		* 	public class ....{
		*		Car myCar;
		*	
		*	}
		*/
		com.jdojo.common.Car myCar = new com.jdojo.common.Car();
	}
}

/*
* Here no access level modifiers for class which means that it's a package access level 
* The class below is accessible only in the scope of the package "com.jdojo.classes".
* Which means Only classes defined in this package can access the class Human
*/
class Human{
	// Fields declaration
	short age;
	int child;
	long id;
	float weight;
	double totalAccount;
	String name;
	String gender;
	// Static variables (class variables) are not allocated memory
	// when a instance of the is created
	Static long count;

	// Class constructor
	public static void Human(){
		this.name = "Nobody";
	}

	public static void sayHello(){
		System.out.println("Hello world!");
	}

	public void sayYourName(){
		System.out.println("My name is " + this.name);
	}
}

public class Animal{
	// Class constructor
	public static void Animal(){}
}

