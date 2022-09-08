package com.jdojo.constructor.p1;

import com.jdojo.constructor.AccessLevelTest3;

public class Test1 extends AccessLevelTest3{
	String title;
	double d;

	/*
	* Private access modifier
	* Allow only access to the constructor to other element of compilation unit (class)
	* 
	*/
	private Test1(String title){
		/*
		* Here, we call a protected constructor AccessLevelTest3(double) of parent class  
		* in "com.jdojo.constructor.AccessLevelTest3"
		* Only class that extends AccessLevelTest3 class and class from same package
		* can access the protected constructor
		*/
		super(0.2158);
		this.title = title;
		
	}

	/*
	* Public access modifier
	* Can be accessed by any part of the application provided the class itself is accessible.
	* To be accessible outside of the module, the module must export the class' package or the class itself.
	*/
	public Test1(){
		Test1 t1 = new Test1("Test1");
	}

	/*
	* Protected access modifier
	* Allow access only to other element of the same package and to descendant package
	* like package 'com.jdojo.'
	*/
	protected Test1(double d){
		this.d = d;
	}

	/*
	* Package
	*/
	Test1(String title, double d){
		this.title = title;
		this.d = d;
	}
}