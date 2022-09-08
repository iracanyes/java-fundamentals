package com.jdojo.constructor;


/**
 * Generic Classes
 * Is defined using formal type parameters. 
 * Formal type parameters are a list of comma-separated variable names placed in angle-brackets (<>)
 * after the class name in the class declaration.
 * T is type variable which could be of any reference type in Java, 
 * such Integer,Double,String, Test3,...
 * The formal type parameters are specified when the wrapper
 * 
 * */
public class GenericClasses{
	public static void main(String[] args) {

		Wrapper<String> stringWrapper;
		
		/*
		* formal type parameter can be a comma-separated list of type
		* that correspond to formal type parameter defined by the generic class
		*/
		Mapper<Double,String> myMapper;
		
		
		/*
		* You can create an object of the generic type by specifying the 
		* actual type parameter for the constructor.
		* Actual type parameter will be used everywhere in class where
		* formal type parameter are placed.
		*/
		stringWrapper = new Wrapper<String>("My string");

		/* 
		* Wrapper.set(T obj) will become Wrapper.set(String obj)
		*/
		stringWrapper.set("My string updated");
		String  s1 = stringWrapper.get();

		/*
		* Java allow to not specify the formal type parameter 
		* Here, the compiler use Wrapper<T> class as the type of the reference variable
		*/
		Wrapper aWrapper;

		// Compile-time error: variable not initialized
		//aWrapper.setType("Unknown");
		aWrapper = new Wrapper<String>("Unknown");
		aWrapper.set("Update aWrapper");
		
		System.out.println(aWrapper.get());

		myMapper = new Mapper<Double,String>(2145.3265, "MyMapper second formal type parameter object value");

		double y = 2 * myMapper.getObj1();

		System.out.println("2 * myMapper.getObj1() = " + y);
		System.out.println(myMapper.getObj2());
	}
}

/*
* The formal type parameter is used to declare instance variable obj of class T
* to declare a formal parameter for its constructor, the set() method
* and as a return type for get() method.
*/
class Wrapper<T>{
	String type;
	private T obj;

	public Wrapper(T obj){
		this.obj = obj;
	}

	public T get(){
		return obj;
	}

	public void set(T obj){
		this.obj = obj;
	}
}

/**
* A generic class may take more than one formal type parameter
*/
class Mapper<T, R>{
	private T obj1;
	private R obj2;

	public Mapper(T obj1, R obj2){
		this.obj1 = obj1;
		this.obj2 = obj2;
	}

	public void setObj1(T obj){
		this.obj1 = obj;
	}

	public T getObj1(){
		return this.obj1;
	}

	public void setObj2(R obj){
		this.obj2 = obj;
	}

	public R getObj2(){
		return this.obj2;
	}
}