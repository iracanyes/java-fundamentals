/*
 * OBJECT CLASS
 * What is a class of an object?
 * Every object in Java belongs to a class. 
 * You define a class in a source code, 
 * which is compiled into binary representation format (a class file with .class extension)
 * Before a class is used at runtime, its binary representation is
 * loaded into JVM.
 * An object called class loader handle the loading of binary representation.
 * Java use multiple class loader to load different types of classes.
 * A class loader is an instance of the class "java.lang.ClassLoader".
 * Java use its built-in class loaders to load the types you define.
 * Java allow to create your own class loader by extending the class "java.lang.ClassLoader"
 * 
 * A class loader reads the binary format of the class definition into the JVM.
 * The binary class can be loaded from any accessible location.
 * Ex: local system, network, database, etc.
 * 
 * The class loader then create an object of type "java.lang.Class<T>"
 * which  represents the binary representation of type T in JVM.
 * the binary format of a class definition may be loaded multiple times in JVM 
 * by different class loaders.
 * A class inside the JVM is identified by:
 * 	- its class loader
 * 	- its fully qualified name	
 * 
 * An oobject of class Class<T>, as a runtime descriptor of the source code of a class
 * 
 * All Java classes extends the class Object directly or indirectly.
 * The Object class is the superclass of all classes.
 * Object class is a final class.
 */
package com.jdojo.object;

import com.jdojo.person.Person;
import com.jdojo.common.SmartCat;
import com.jdojo.common.Cat;
import com.jdojo.common.Dog;

public class Objects{
	private static Object obj;

	public static void main(String[] args) {
		/*
		* A reference variable of the Object class
		* can hold a reference of an object of any class
		*/
		Object o1 = null;

		// Assign a refenrece of an Object class
		obj = new Object();

		Person person = new Person(214,"John","Jackson");
		obj = person;

		/*
		* A reference of Object class can store a reference of any class
		* To assign the reference of an Object class to another reference of random class,
		* You must cast the reference variable to Object class to specific type of the random class
		*
		*/
		Object obj2 = new Person(355,"Jane","JacksonVille");
		Person person2 = (Person) obj2;

		/*
		* "instanceof" statement allow to verify ther type of reference variable
		* 
		*/
		if(obj2 instanceof Person){
			// Here we know that obj2 store a reference variable of type Person
		}

		/*
		* When a method receive in parameter an object without knowing its type
		*/
		unknownObject(person2);
		unknownObject(obj2);

		/*
		* RULES 2
		* Object class has predefined methods, divided in 2 categories:
		*	- Final methods which cannot be overriden:
		*		- getClass() : returns the class of an object
		*		The 3 next methods allow thread synchronization
		*		- notify()
		*		- notifyAll()
		*		- wait()
		*	- Methods with default implementation which can be overriden
		*		- toString()
		*		- equals()
		*		- hashCode()
		*		- clone()
		*		- finalize()
		*/

		/*
		* Object.getClass()
		* getClass is a final method which implemented by default 
		* Class is generic type and its formal parameter is the name of the class
		*/
		Class pCl = person2.getClass();
		/*
		* 
		* Command: 
		*	javac -p mod -d mod/jdojo.object src/jdojo.object/module-info.java src/jdojo.object/com/jdojo/common/SmartPoint* src/jdojo.object/com/jdojo/object/Object*
		*
		* modules added to compiler using module-path are member of automatic modules
		* an automatic names is given to the class.
		* In this case, Person class is given the name CAP#1
		* See package configuration to give a static name to classes
		* ERROR:
		* incompatible types: Class<CAP#1> cannot be converted to Class<Person>
        *        Class<Person> pCl2 = person2.getClass();
        *
        * Using the class-path, all classes are added to unnamed module
		*/
		//Class<Object> pCl2 = person2.getClass();		
		System.out.println("Person object class fully qualified name : " + pCl.getName());
		System.out.println("Person object class simple name: " + pCl.getSimpleName());


		/*	STRING REPRESENTATION OF AN OBJECT
		* An object is represented by its state which is the combination of values of its instance variable at a point in time.
		* The string representation of an object contains the state of an object at a point in time.
		*
		*	Object.toString()
		* Returns the state of the object in a string representation.
		* Used for debugging purpose.
		* Default implementation of the method returns a string format:
		*	<fully-qualified-class-name>@<hash-code-object-in-hexadecimal-format>	
		*
		*
		* Method can be overriden
		*	Signature:
		*		public String toString()
		*/
		String pStr = person2.toString();
		System.out.println("Person object : " + pStr);

		/*
		* Object.equals()
		* equals() is a method which is implemented by default.
		* Method can be overriden
		* Allow to compare an object with another
		*	Signature:
		*		public boolean equals(Object obj)
		*/
		boolean samePerson = person.equals(person2);
		System.out.println("Person1 is equal to person2 : " + samePerson);

		/*
		* Object.hashCode()
		* A hash code is an integer value that is computed for a piece of information 
		* using a algorithm.
		* Also known as hash sum, hash value.
		* A hash code of an object is a integer representation of the information stored in the object
		* When the object is modified, his hash code changed also.
		*
		* Hash code are used for effecient retrieval of data associated with it
		* when the data is stored in a hash base collection (or container).
		* Before data is stored in a container, his hash code is computed, 
		* and then it is stored at a location (also called bucket), 
		* which is based on its hash code.
		* In future, the hash code will be used to find the location of the data.
		* Hash code are distributed uniformly over multiple range to make them efficient 
		*
		* If you use a hash function, all elements in the container will be stored in the same bucket.
		* 
		* Java uses hash code for the same reason, to store efficiently and retrieve data from hash based collections.
		*
		* Default implementation of "hashCode()" convert the memory address of the reference variable
		* into an integer.
		*
		* 3 rules for overriding the method:
		*	1. If 2 objects are equals using equal() method, they must return the same hash code.
		*		x.equals(y) returns true, if x.hashCode() returns an integer equals
		*		to y.hashCode() returned value.
		*
		*	2. If 2 objects have the same hash code using hashCode(), 
		*		they do not have to be equals.
		*		x.hashCode() is equal to y.hashCode(), it's not necessary true that 
		*		x.equals(y) will return true.
		*	3. If the hashCode() method is called multiple times on the same object,
		*		it must always returns the same value at each call
		*
		* A mutable class cannot be used as key in a hash-based collections as 
		* each modification the class will result in modification of its hashCode;
		* the key will also change after their use and the data stored at the old key in the hash-based collection
		* will be unreachable.
		*
		* The "hashCode" method returns a integer representation (hash code) of the object
		* Method can be overriden
		*	Signature:
		*		public int hashCode()
		*/
		int hashCodePerson1 = person.hashCode();

		/*
		* 
		* Object.clone()
		* Allow to create a copy of the object.
		* The object returned is of type Object class
		* Method can be overriden
		*	Signature:
		*		protected Object clone() throws CloneNotSupportedException
		*
		*/
		Dog myDog = new Dog("Doe");
		Cat myCat = new Cat("Jane");

		/*
		* Java doesn't give an automatic mechanism to clone object
		* Object class implement the clone() method with protected access level
		* 	1. Instance of the class Object cannot call clone method because it's not public
		* 	2. Classes that extends Object class can access the clone() method,
		* 		All classes in java extends the Object class, they can access the method
		* You MUST REIMPLEMENT the clone() method for each class you create
		* 
		* Here Dog and Cat doesn't implement clone method
		* Error: clone() has protected access in Object
		*/
		// 
		// Object myClonedCat = myCat.clone();
		// Object myClonedDog = myDog.clone();

		SmartCat sc = new SmartCat("Jack", 12);
		SmartCat sc2 = sc.clone();

		System.out.println(sc);
		System.out.println(sc2);
		
		

		/*
		* Object.finalize()
		* Deprecated since Java 9
		* For backward compatibility,
		* the method is called by the garbage collector before 
		* the object is destroyed
		*/

		/*
		* Objec.notify()
		* Notify one thread in the wait queue of the object
		* 	Signature:
		*		public final void notify()
		*/

		/*
		* Objec.notifyAll()
		* Notify all thread in the wait queue of the object
		* 	Signature:
		*		public final void notifyAll()
		*/

		/*
		* Objec.wait()
		* Make a thread wait in the wait queue of the object
		* 	Signature:
		*		public final void wait() throws InterruptedException
		*/

		/*
		* Objec.wait(long)
		* Make a thread wait in the wait queue of the object,
		* with a timeout
		* 	Signature:
		*		public final void wait(long timeout) throws InterruptedException
		*/

		/*
		* Objec.wait(long, int)
		* Make a thread wait in the wait queue of the object
		* with a timeout
		* 	Signature:
		*		public final void wait(long timeout, int nanos) throws InterruptedException
		*/
		
	}

	public static void unknownObject(Object o){
		if(o instanceof Person){
			// Here we know the object type is Person
		}

		if(o instanceof String){
			// Here the object is of type String
		}


	}

	/*
	* Reimplementing a method of the Object class, you need to declare a method 
	* with the same signature.
	*/
	public String toString(){
		return "com.jdojo.object.Object to String";
	}	


}






