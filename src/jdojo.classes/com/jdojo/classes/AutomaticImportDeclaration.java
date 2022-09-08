package com.jdojo.classes;

/*
* All types (class, interface, annotations, enum) from "java.lang.*" are loaded automatically. 
*/
import java.lang.*;		// Will be ignored because it's automatically done by compiler


public class MyClass{
	// Equal to: java.lang.String myStr;
	String myStr;
	String myCopy;

	/*
	* Here we use the class System which fully qualified name is 'java.lang.System'
	* to copy elements of array.
	* 
	* Structure: 
	*	public static void arraycopy(
	*		Object sourceArray, 
	*		int sourceStartPosition,
	*		Object destinationArray,
	*		int destinationStartPosition,
	*		int lengthToBeCopied
	*	)
	*/
	System.arrayCopy(myStr, 0, myCopy, 0, -1);
}

/*
* Using a simple name already used in java.lang.
* Compiler will search for type defined in compilation unit before looking in import declarations
*
*	package p1;
*
*	class String {
*	
*	}
*
*	class Test{
*		java.lang.String s1;	// Use java.lang.String
*		p1.String s2;			// Use p1.String
*		String s3;				// Use p1.String because it look for type defined in compilation before looking in 
*								// automatic import declaration and import declaration defined by the user
*	}


*/
