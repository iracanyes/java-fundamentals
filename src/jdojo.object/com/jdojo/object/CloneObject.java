/*
* Command:
*	Compile:
*		javac -p mod -d mod/jdojo.object src/jdojo.object/module-info.java src/jdojo.object/com/jdojo/object/*
*	Run: 
*		java -p ib --module jdojo.object/com.jdojo.object.CloneObject
*
*
* JAVA DOESN'T GIVE AN AUTOMATIC MECHANISM TO COPY OBJET
* Remember: Assign a reference variable to an another reference variable, 
* only the reference of the object is copied, not the content of the object
*
* To clone an object, you MUST REIMPLEMENT THE CLONE() METHOD OF THE CLASS
* 
*/
package com.jdojo.object;

import com.jdojo.common.SmartCat;
import com.jdojo.common.Cat;

public class CloneObject{
	public static void main(String[] args) {
		/*
		* Object class implements a clone() method which is accessible
		* to all classes that extends it.
		* Clone method is declared protected.  
		* You cannot call the method in an instance of Object class!
		*/
		Object obj = new Object();

		// Compile-time Error: clone is declared protected on Object class
		// Object obj2 = obj.clone();

		
		Cat c = new Cat("jack", 10);

		// Cat class does'nt reimplement clone() method
		// Compile-time error: clone() has protected access in Object
		//Cat c2 = (Cat) c.clone();

		/*
		* Only class that extends Object class which means all classes in Java
		* can access and reimplement the method
		* Clone method returns an object of type Object class
		*/
		SmartCat sc = new SmartCat("Jack", 12);		
		SmartCat sc2 = (SmartCat) sc.clone();
		

		System.out.println("SmartCat 1 :" + sc.toString());
		System.out.println("SmartCat 2 :" + sc2.toString());


		sc.setAge(13);
		sc2.setAge(13);

		System.out.println("SmartCat 1 :" + sc.toString());
		System.out.println("SmartCat 2 :" + sc2.toString());

		sc.setAge(13);
		sc2.setAge(14);

		System.out.println("SmartCat 1 :" + sc.toString());
		System.out.println("SmartCat 2 :" + sc2.toString());




	}
}

