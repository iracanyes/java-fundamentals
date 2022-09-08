package com.jdojo.common;

/*
* SAME SIMPLE NAME CONFLICT FOR IMPORT DECLARATION
*
* When 2 packages with the same simple name are used in the same compilation unit
* it result in compilation error.
* E.G.: simple name 'A' already used in the compilation unit
*	package p1;
*	
*	import p2.A;
*
*	class B {
*		A var;			// Compile-time error => Compiler doesn't know if you want to use p1.A or p2.A
*		p2.A myProp;	// Here, OK because compiler know which one of the 2 types to use		
*	}
*
*	class A {
*		
*	}
*
* In order to solve the conflict, you need to use the fully qualified type name 
* of the imported class in the conflict.
* 
* If 2 packages are imported with the same simple name. 
* In order to resolve the conflict, you MUST use the fully qualified name of 
* the 2 types imported
* E.G.
*	package pkg;
*
*	class C1 {
*	 	p1.A myProp1;
*		p2.A myProp2;
*	}
*/
import com.jdojo.classes.A;

class B {
	/*
	* 
	*/
	com.jdojo.common.A myVar;
	A var2;
}

class A{

}



/*
* RULES FOR IMPORT ON DEMAND
*
* 1. Single-type import declaration are prior to import-on-demand declaration.
* When the compiler is searching for fully qualified name based on a simple name.
* If a single-type import declaration is found, the search stop without looking in import-on-demand declarations
*
* 	import p1.A;
*	import p2.*;
*
*	class B {
*		A myProp; // Here p1.A will be used without looking in p2.*
*	}
*
*/

/*
* When 2 packages use the same simple name, there is 3 ways to resolve the conflict 
* 	- Use one single-type import declaration and a fully qualified name for the other
*
* 		import p1.A;
*
*		class B {
*			A myProp; 		// Here p1.A will be used
*			p2.A myProp2;	// Here p2.A
*		}
*	- Use one single-type import declaration and one import-on-demand
*		=> single-type import are always prior to import-on-demand
*
* 		import p1.A;
*		import p2.*;
*
*		class B {
*			A myProp; // Here p1.A will be used without looking in p2.*
*		}
*
*	- Use fully qualified name for both classes:
*
*		class B {
*			p1.A myProp;
*			p2.A myProp 
*		}
*
*/

/*
* DUPLICATE SINGLE_TYPE IMPORT AND IMPORT_ON_DEMAND ARE IGNORED
*
* 	import p1.A;
*	import p1.A;	// Ignored
*	import p2.*;
*	import p2.*;	// Ignored
*
* 	class B{}
*/

/*
* IMPORT CLASSES FROM THE SAME PACKAGE USING SINGLE_TYPE IMPORT DECLARATION
* E.G.
* 	package p5;
*
*	import p5.F; // Will be ignored
*	import p5.*; // Will be ignored
*
*	class E {
*		// Code goes here
*	}
*/

