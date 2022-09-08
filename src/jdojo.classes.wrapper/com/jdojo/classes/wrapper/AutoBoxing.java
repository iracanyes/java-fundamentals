/*
* Command:
*	Run: java -p lib -m jdojo.classes.wrapper/com.jdojo.classes.wrapper.AutoBoxing
*/
/*
* Autoboxing and Unboxing
* Java 5 added the support for autoboxing and unboxing.
* These techniques are used to automatically convert values between primitive data type
* and their corresponding wrapper classes.
*/
package com.jdojo.classes.wrapper;

import java.util.List;
import java.util.ArrayList;

public class AutoBoxing{
	public static void main(String[] args) {
		/*
		* Before Java 5 autoboxing and unboxing
		*/
		int a  = 145;
		int b = 155;
		int resultValue;

		// Boxing a and b into Integer objects
		Integer aObj = Integer.valueOf(a);
		Integer bObj = Integer.valueOf(b);

		// Store the returned value in an Integer
		Integer resultObj = add(aObj, bObj);

		resultValue = resultObj.intValue();

		System.out.println(a + " + " + b + " = " + resultValue);

		/*
		* Since Java 5 Autoboxing and Unboxing
		*/
		/*
		* Boxing : Wrap the primitive type value into primitive Wrapper class
		* Compiler will replace the statement below by:
		*	Integer c = Integer.valueOf(25);
		*/
		Integer c = 25;	 

		/*
		* Unboxing: Unwrap the primitive value from the primitive wrapper object 
		* Compiler replace the statement by:
		*	int d = c.intValue();
		*/
		int d = c;	

		/*
		* Using boxing and unboxing you can add() method
		* formal parameters will be automatically boxed into wrapper objects
		* and the returned wrapper object will be automatically unboxed 
		* to store the value into integer local variable.
		* 
		*/
		int resultObj2 = add(15, 25);

		/*
		* Overloaded methods and Autoboxing/Unboxing
		*
		* Rules for method invocation that used autoboxing/unboxing
		*	- If the actual argument being passed is a primitive type (ex: test(101))
		*		1. Compiler try fo find a method signature with the primitive type argument.
		*			If not found, try widening the primitive type fo find a match
		*		2. If previous step fails, box the primitive type and try to find a signature method match
		*	- If the actual argument being passed is a reference type (test(Integer.valueOf(101)))
		*		1. Compiler try to find a method signature with the reference type argument
		*			A match does not have to be exact. It should follow the subtype and supertype assignement rule
		*		2. If the previous stef fails, unbox the primitive wrapper class to the corresponding primitive type
		*			and try to find an EXACT match or widen the primitive type 
		*			and find a match.
		*
		* 
		*
		*
		*/
		/*
		* Uncomment the method test(int) at the end of the class definition
		* The error below will be thrown by the compiler because the autoboxing/unboxing
		* the 2 methods test(int) and test(Integer) means the same.
		* With autoboxing, the method test(int) can be interpreted by the compiler
		* as test(Integer).
		* With unboxing, the method test(Integer) can be interpreted by the compiler
		* as test(int).
		* Here, the compiler doesn't know which method to choose.
		*
		*  error: reference to test is ambiguous
        *        test(Integer.valueOf(101));
        *        ^
  		* both method test(int) in AutoBoxing and method test(Integer) in AutoBoxing match
		*/
		// test(101);
		
		/*
		* Uncomment test(long) 
		* Here we call test(int) method and passed an integer actual parameter
		* Compiler will search for a method signature test(int)
		* if no method match, the actual parameter which is integer primitive
		* will be widen to long primitive type.
		* Compiler will now search for a method signature test(long) which exists
		* and will use the corresponding method.
		* If the previous step, compiler autobox the primitive type 
		* and search for a method signature test(Integer)
		* * Here, the compiler finds 2 methods corresponding the 
		*
		* error: reference to test is ambiguous
        *        test(101);
        *        ^
  		* both method test(long) in AutoBoxing and method test(Integer) in AutoBoxing match
		*
		*/
		// test(101);

		/*
		* Here, the compiler finds 2 methods corresponding the 
		*
		* error: reference to test is ambiguous
        *        test(Integer.valueOf(101));
        *        ^
  		* both method test(long) in AutoBoxing and method test(Integer) in AutoBoxing match
		
		*/
		// test(Integer.valueOf(101));

		/*
		* 
		*/
		test(101);
		/*
		* Here is a tricky one, 
		* If the method test(Integer) is commented,
		* the methods test(Long) and test(Number) are defined.
		* The next call will return
		*	Number = 101
		* Compiler will widen Integer wrapper class to its super class type (parent class type) which is Number try to find a match
		* 
		* If no method match, compiler widen from Number class to the super class type (parent class type) which is Object.
		* Here, you try by commenting method test(Number),
		* Compile the code and run it
		* Here the code return 
		*	Object = 101
		* 
		*/
		test(Integer.valueOf(101));


		/*
		* COMPARISON OPERATORS 
		* Only the operator == (logical equality) can be used with both
		* primitive types and reference types.
		* All other comparison operator (<,<=,>,>=) MUST be used with primitive types
		*/
		Integer i1 = 100;
		Integer i2 = 100;

		/*
		* Here,we can see that autoboxing/unboxing allow these comparison operator to work correctly
		*/
		System.out.println("COMPARISON OPERATORS");
		System.out.println("i1 : " + i1);
		System.out.println("i1 : " + i2);
		System.out.println("i1 > i2 : " + (i1 > i2));
		System.out.println("i1 >= i2 : " + (i1 >= i2));
		System.out.println("i1 < i2 : " + (i1 < i2));
		System.out.println("i1 <= i2 : " + (i1 <= i2));

		if(i1 < Integer.valueOf(103)){
			System.out.println("i1 is less than 103");
		}

		if(100 < Integer.valueOf(103)){
			System.out.println("100 is less than 103");
		}

		if(i1 > Integer.valueOf(93)){
			System.out.println("100 is greater than 93");
		}

		/*
		* LOGICAL EQUALITY OPERATOR (==)
		* If both operands are primitive types, they are compared using value comparison.
		
		*/
		int i3 = 100;
		int i4 = 100;
		int i5 = 654;

		System.out.println("LOGICAL EQUALITY OPERATOR (==)");
		System.out.println("i3: " + i3);
		System.out.println("i4: " + i4);
		System.out.println("i5: " + i5);
		System.out.println("i3 == i4 : " + (i3 == i4));
		System.out.println("i3 == i5 : " + (i3 == i5));

		/*
		* if both operands are reference type, their references are compared for equality
		*/
		Integer iObj3 = Integer.valueOf(100);
		Integer iObj4 = Integer.valueOf(100);
		Integer iObj5 = Integer.valueOf(789);
		System.out.print("iObj3 : " + iObj3);
		System.out.print("iObj4 : " + iObj4);
		System.out.print("iObj5 : " + iObj5);

		System.out.println("iObj3 == iObj4 : " + (iObj3 == iObj4));
		System.out.println("iObj3 == iObj5 : " + (iObj3 == iObj5));

		/*
		* If one of the operand is a primitive type and the other one a reference type,
		* the reference type is unboxed to a primitive value and a value 
		* comparison is made.
		* In the example below, iObj3 and iObj4 will be unboxed to primitive type before value comparison
		*/
		System.out.println("i3 == iObj4 : " + (i3 == iObj4));
		System.out.println("i4 == iObj5 : " + (i4 == iObj5));


		/*
		* COLLECTIONS AND AUTOBOXING/UNBOXING
		* Collections works only with reference types!
		* You cannot use primitive types in collections.
		* If you want to store primitive types in collections, 
		* you must wrap the primitive values before storing it,
		* and unwrap it after retrieving.
		*/
		/*
		* 
		*/
		List<Integer> list = new ArrayList<Integer>();		
		/*
		*  Signature : void List.add(Object o)
		* 
		*/
		list.add(Integer.valueOf(123));

		/*
		* signature: Object List.get()
		* returns an object of type Object
		* You must cast the returned object based on your need
		*/
		Integer iObj6 = (Integer) list.get(0);
		int iObj6Value = iObj6.intValue();
		
		

		/*
		* The statement above can be written with autoboxing
		* Remember: List.get() returns object of type Object
		* If you store a primitive type, you have to cast the object returned
		* to your specific type
		*/
		int aValueBox = (int) list.get(0);

		/*
		* Because of autoboxing, we can write the statement below
		* The argument will be autobox to Integer before method execution
		*/
		list.add(0);

		/*
		* Unboxing doesn't work for Object type to primitive type!
		*/
		/*
		* As Number class is an abstract type. 
		* No instance of Number class can be created! 
		*/


	}

	/*
	* Before Java 5 and the introduction of autoboxing and unboxing
	* Manipulating primitive wrapper class objects, 
	* looked like this
	*/
	public static int add(Integer iObj1, Integer iObj2){

		// Unwrap primitive type
		int i1 = iObj1.intValue();
		int i2 = iObj2.intValue();
		// Do the math
		int resultValue = i1 + i2;
		// Wrap result in Wrapper class and returns it
		Integer result = Integer.valueOf(resultValue);
		return result;
	}

	/*
	* Call test(int) can be interpreted as test(long) or test(Integer)
	* Uncommenting this methods, create an ambigious reference exception 
	* as 2 methods will have the same meaning for the compiler.
	*/
	public static void test(long iValue){
		System.out.println("long = " + iValue);
	}
	
	/*
	* As a call test(int) exists in main() method
	* the method test(Integer) and test(long) cannot 
	* be defined at the same time.
	* Comment one of the two method before compiling
	*/
	public static void test(Long lObj){
		System.out.println("Long = " + lObj);
	}

	/*
	public static void test(Number nObj){
		System.out.println("Number = " + nObj);
	}
	*/

	public static void test(Object obj){
		System.out.println("Object = " + obj);
	}

	/* Because of Autoboxing/Unboxing
	* it create an error : reference to test is ambiguous
	* 2 methods match : test(int) and test(Integer)
	*
	 public static void test(int iValue){
		System.out.println("int = " + iValue);
	 }
	*/
	
	/*
	* As a call test(int) exists in main() method
	* the method test(Integer) and test(long) cannot 
	* be defined at the same time.
	* Comment one of the two method before compiling
	*/
	/*
	public static void test(Integer iObj){
		System.out.println("Integer = " + iObj);
	}
	*/
}