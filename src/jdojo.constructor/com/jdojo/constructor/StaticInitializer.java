/**
 * Description:
 * Static initializer 
 * Command:
 * 	1. Compile: 
 * 		javac -d mod/jdojo.constructor -m src/jdojo.constructor/module-info.java 
 * 			src/jdojo.constructor/com/jdojo/constructor/StaticInitializer.java
 * 	2. Run: 
 * 		java -cp mod com.jdojo.constructor.StaticInitializer
 * Result:
 * 	Inside static initializer block.
 * 	Num = 1245
 * 	Inside main().
 * 	Num = 1245
 * 	Inside main(){ StaticInitializer si; }.
 * 	Num = 1245
 * 	Inside instance initializer block.
 *	d = 46587.3265
 * 	Inside no-args constructor
 * 	Inside main(){ StaticInitializer si; new StaticInitializer(); }.
 * 	Num = 1245
 * 	Inside instance initializer block.
 * 	d = 46587.3265
 * 	Inside no-args constructor
 * 	Inside main(){ StaticInitializer si; new StaticInitializer(); new StaticInitializer(); }.
 * 	Num = 1245
 * */

package com.jdojo.constructor;

/*
* Comman
*/
class StaticInitializer{
	private static int num;
	private double d;

	{
		d = 46587.3265;
		System.out.println("Inside instance initializer block.\nd = " + d);
	}

	/**
	* STATIC INITIALIZER
	* Same as instance initializer but for initializing the class.
	* You can initialize class variables (static) inside a static initializer block.
	* IMPORTANT: Evaluation order:
	* 	1. Static initializer block 
	* 	2. Instance initializer block
	* 	3. Constructor
	*   4. Main method 
	*/
	static {
		num = 1245;
		System.out.println("Inside static initializer block.\nNum = " + num);
	}

	

	public StaticInitializer(){
		System.out.println("Inside no-args constructor");
	}

	public static void main(String[] args) {
		
		/*
		* Before the main method is executed, only static initializer block have been evaluated.
		* class variables in static initializer block have been already initialized before executing the main method.
		*/
		System.out.println("Inside main().\nNum = " + num);

		/*
		* Allocating memory for an instance of the class. 
		* Static and instance initializer block of the class will be evaluated
		*/
		StaticInitializer si;

		System.out.println("Inside main(){ StaticInitializer si; }.\nNum = " + num);

		new StaticInitializer();

		System.out.println("Inside main(){ StaticInitializer si; new StaticInitializer(); }.\nNum = " + num);

		new StaticInitializer();

		System.out.println("Inside main(){ StaticInitializer si; new StaticInitializer(); new StaticInitializer(); }.\nNum = " + num);
	

	}
}