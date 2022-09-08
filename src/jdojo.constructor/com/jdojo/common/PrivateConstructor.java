package com.jdojo.common;

public class PrivateConstructor{
	public static void main(String[] args) {
		/*
		* Here, t1 and t2 refer to same instance of the class T2
		*/
		T2 t1 = T2.getInstance();
		T2 t2 = T2.getInstance();
	}
}

/*
* Private constructors allow to have full control on how object are created.
* For instance, you can how much object of that class are created.
* In the example below, we create only one instance of the class
* and use a static method to return the unique instance of the class.
* Class with only one instance are also calle "singleton pattern"
*/
class Test{
	private static T2 instance = new T2();

	private T2(){
		/*
		* the constructor will be called after the creation of the object to initialize it
		*/
	}

	public static T2 getInstance(){
		return T2.instance;
	}

}
