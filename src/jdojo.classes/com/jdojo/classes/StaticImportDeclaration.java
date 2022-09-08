package com.jdojo.classes;

/*
* STATIC IMPORT DECLARATION
* It allow to import static members (static variables and methods)
* of a type into a compilation unit
* Two types of static import declartion exists
*	- Single-static import
*	- Static-import-on-demand
* 
*	
*/
/*
* SINGLE-STATIC IMPORT
* Structure:
*	import static <package-name>.<type-name>.<static-member-name>;
*/
// out is static variable from package 'java.lang.System' class

import static java.lang.System.out;

/*
* STATIC-IMPORT-ON-DEMAND IMPORT
* Structure:
*	import static <package-name>.<type-name>.*;
*
* The class 'Math' in 'java.lang' package contains many utility constants and static methods.
* e.g. PI, sqrt(), ...
*
*/ 
import static java.lang.Math.*;

/*
* STATIC IMPORT / RULES 1
* If 2 static members with the same simple name are imported:
*	- one using single-static-import
*	- one using static-import-on-demand
* Single-static import are prior to static-import-on-demand
* E.G.
*	package pck;
*	
*	import p1.C1.m1;
*	import p1.C1.*;
*
*	class {
*		public static void main(String[] args){
*			m1();	// p1.C1.m1 is used
*		}
*
*	
*	}
*
*/

/*
* STATIC IMPORT / RULES 2
* IMPORTING 2 STATIC MEMBERS THAT USED THE SAME SIMPLE NAME IS NOT ALLOWED
* E.G.
*	package pck;
*	
*	import p1.C1.m1;
*	import p2.C2.m1;	// Compile-time error
*/
/*
* STATIC IMPORT / RULES 3
* IMPORTING A TYPE WITH A SIMPLE TYPE NAME ALREADY USED IN A COMPILATION UNIT
*
* Because of the resolve order:
*	- Type nested in Type declaration
*	- Automatic static import declaration
*	- Single static Import statement
*	- Static import-on-demand
* The compiler will search first in compilation unit
* before to look at  static import declaration.
* Here the Type in the compilation unit will be used 
* E.G.
* 	package p1;
*	
*	class A {
*		static MA_CONST = "Hello from p1";
*		static void m1(String el){
*			System.out.println(el);
*		}	
*	}
*	-----------------------
*	package p2;
*
*	import static p1.A.MA_CONST;
*	import static p1.A.m1;
*	
*	class B{
*		static MA_CONST = "Hello from p2";
*		
*		public static void main(String[] args){
*			m1(MA_CONST);	// Print: Hello from p2. 
*		}
*	}
*
* With times, u can create some hard-to-find bugs with static import when updating code
* ADVISE: USE STATIC IMPORTS WITH CAUTION
*/

class StaticImportDeclaration{
	public static void main(String[] args){
		double radius = 3.1;
		/*
		* Here because we used a static-import-on-demand for package 'java.lang.Math'
		* we can use 'java.lang.Math.PI' by its simple name 
		*/
		double area = PI * radius * radius;

		
		/*
		* Now, that I've imported static variable 'out' from class 'System' in package java.lang.
		* I can write the code below like this
		*/
		out.println("Hello from single-static import");

		out.println("Value of PI is: " + PI);
		out.println("Radius of circle is: " + radius);
		out.println("Area of circle is: " + area);

		/*
		* Here because we used a static-import-on-demand for package 'java.lang.Math.*'
		* we can use the static method 'java.lang.Math.sqrt()' by its simple name 
		*/
		out.println("Square of root 4.0 is: " + sqrt(4.0));


	}	
}