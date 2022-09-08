package com.jdojo.classes.p1;

/*
* AccessLevel2 class has no-access-level modifier which means it has a package-level access
* Package-level access allow only the code within the package (com.jdojo.common) to access "AccessLevel2" class
* The code in package "com.jdojo.common.p1" is NOT allowed to access class "AccessLevel2" and therefore
* it can't access its static variable 'n1'
* 
*/
import com.jdojo.common.AccessLevel2;

public class AccessLevelTest3{
	public static void main(String[] args) {
		/*
		* Compile-time Error: Cannot access "AccessLevel2" class
		*/
		// int a = AccessLevel2.n1;
	}

}