package com.jdojo.common;

public class AmbigiousVarArgs{
	/*
	*
	*/
	public static void main(String[] args) {
		/*
		* both method accept call without arguments:
		*	- int max(int...num)	=> int max()
		*	- int max(double...num)	=> int max()
		* Compiler will throw an error because a call to MathUtil.max() without arguments
		* will create a conflict with 2 method signature
		*/
		// MathUtil.max();		 
	}
}

public class MathUtil{
	public static int max(int...num){

	}

	public static int max(double...nums){

	}
}