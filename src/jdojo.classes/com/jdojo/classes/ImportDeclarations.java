/**
*
*/
/*
* PACKAGE DECLARATION
*/
package com.jdojo.classes;

/*
* IMPORT DECLARATION
* An  import declaration is used to import any type ( annotation, class, interface, enum) into a compilation unit
* from outside the package of the compilation unit.
* Java compiler use the import declaration for resolving the simple name of a type to a fully qualified type name
* and replace it.
*
* If I want to use a class without calling it with it fully qualified name
* I need to make an import declaration of the package in which it's defined
* 
* 2 Types of import declaration:
*	- Single-type import declaration
*	- Import-on-demand declaration
*
* It's better to use single type import declaration for readability and ease of debugging
*/
/*
* SIMPLE-TYPE IMPORT DECLARATION
*
* A single type import declaration is used to import one single type (e.g.: enum, interface, annotation, class)
* from a packatge. 
* Structure:
*	import <fully-qualified-package-name>.<Type-name>;
*
* Ex: import package-name.Class-name
*/
import com.jdojo.common.Car;

/*
* IMPORT-ON-DEMAND DECLARATION
* It's used to import multiple types from the same package with one import declaration.
* Java '.*' for dec
* Structure:
*	import <fully-qualified-package-name>.*;
*
* IMPORTANT:
* If package 'p1' contains other package (sub-package) like 'p1.p2'.
* Using a import declaration like 'p1.*' will only import types defined by p1 like 'p1.C1'
* BUT it will not import types contains in package 'p1.p2' like 'p1.p1.C1' 
*/
import com.jdojo.common.*;

/*
* 
*/
// Uncomment - Compile-time Error. Structure of import declaration not correct
// import com.jdojo.*.*;

/*
* TYPES DECLARATION
*/
public class ImportDeclarations{
	/* Also valid
	*  
	*/
	/*
	* Here, Java goes through all import declaration to resolve the simple name to 
	* a fully qualified name.
	* If no fully qualified type name is found, Java throw an error!
	*
	* Here, Java compiler will replace the simple name by a fully qualified type name
	* e.g.: com.jdojo.common.Car  tesla = new com.jdojo.common.Car();
	*/
	Car tesla = new Car();

	/*
	* TYPE SEARCH ORDER
	* Java compiler resolve the simple name of type to its fully qualified name during the compilation process
	* It searches for a type referenced in a program in the following order:
	*	- Types nested in Type declaration (Annotations, Enums)
	*	- The current compilation unit (Java source file. Here, ImportDeclarations.java)
	*	- Single-type import declarations
	*	- Types declared in the same package
	*	- Import-on-demand declarations
	*/
	Truck damler = new Truck();


}

class A {

}

class B {
	A variableA;
}