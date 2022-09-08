package com.jdojo.constructor;

import com.jdojo.constructor.p1.Test1;

public class AccessLevelTest3{
	String title;
	double d;
	
	/*
	* Private access modifier
	* Allow only access to the constructor to other element of compilation unit (class)
	* 
	*/
	private AccessLevelTest3(String title){
		this.title = title;
	}

	/*
	* Public access modifier
	* Can be accessed by any part of the application provided the class itself is accessible.
	* To be accessible outside of the module, the module must export the class' package or the class itself.
	*/
	public AccessLevelTest3(){
		// Test1 is in another package 
		//Test1 t1 = new Test1("Test1");
	}

	/*
	* Protected access modifier
	* Allow access only to other element of the same package and to descendant class
	* in any other package.
	* Descendant class are package that extends this class
	*/
	protected AccessLevelTest3(double d){
		this.d = d;
	}

	/*
	* Package-level access modifiers
	* 
	*/
	AccessLevelTest3(String title, double d){
		this.title = title;
		this.d = d;
	}
}