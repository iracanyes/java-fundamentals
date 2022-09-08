/**
 *
 */
package com.jdojo.common; 

// Import Statements

// As package 'com.jdojo.classes' is in the same module
// import com.jdojo.classes;

/*
 * 'ClassAccessTest' use a 'public' as access level modifier.
 * Therefore, it's accessible outside the package in which it has been declared 
*/
public class ClassAccessTest{
	public static void main(String[] args){
		// If import statement for package com.jdojo.classes which is in the same module
		// is defined before the class definition. Uncommenting the below will not generate error on build. 
		// Uncomment -  Compile-time Error: cannot find symbol
		// Human jack;

		/*
		* As Human class is defined in same module but in another package
		* For using the class, u've got to use the fully qualified name of the class
		* or import the class by defining an import statement with the fully qualified name
		*
		* If the the class Human is not public, another error will thrown
		*	Error: Human is not public in com.jdojo.classes
		*/
		com.jdojo.classes.Human charlie;

		/*
		* Using a class defined in the same package 
		*/
		Car myCar = new Car();




	}
}

public class Car{
	String color;
	String type;
	String model;

	public static void Car(){}
}

// This class below will not accessed from outside the package 'com.jdojo.classes'
class Truck{
	double payload;

}