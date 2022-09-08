package com.jdojo.common;

/*
* A class MUST implement the interface "Cloneable" 
*/
public class SmartCat implements Cloneable{
	private String name;
	private int age;


	public SmartCat(String name, int age){
		this.name = name;
		this.age = age;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public void setAge(int age){
		this.age = age;
	}

	public int getAge(){
		return this.age;
	}

	/*
	* Reimplement the equals() method
	*/
	public boolean equals(Object obj){
		// Is the same object
		if(this == obj){
			return true;
		}

		// Is obj null reference
		if(obj == null){
			return false;
		}

		// Do they belongs to the same class
		if(this.getClass() != obj.getClass()){
			return false;
		}

		// Get the reference to obj
		SmartCat cat = (SmartCat) obj;

		boolean isSameCat = (this.name == cat.name && this.age == cat.age);

		return isSameCat;

	}

	@Override
	public int hashCode(){
		int hash = 32;

		hash = hash + this.age;

		hash = hash + (this.name == null ? 0 : name.hashCode());
		return hash;
	}

	/*
	* Since Java 5, clone method doesn't have to return an object of class Object
	*
	* When you override a method, you can drop or add throws clause to the method,
	* 
	*/
	@Override
	public SmartCat clone(){
		SmartCat sc =  null;

		try{
			// 
			/*
			* Here, we use the method clone() from parent class Object
			* Your class MUST implement the interface Cloneable 
			* for using the statement "super.clone()"
			*
			* Error:
			* java.lang.CloneNotSupportedException: com.jdojo.common.SmartCat
        	*	at java.base/java.lang.Object.clone(Native Method)
        	*	at jdojo.object/com.jdojo.common.SmartCat.clone(SmartCat.java:74)
        	*	at jdojo.object/com.jdojo.object.CloneObject.main(CloneObject.java:47)
			*	com.jdojo.common.SmartCat@231c2b
			*	
			*	Exception in thread "main" java.lang.NullPointerException: Cannot invoke "Object.toString()" because "<local4>" is null
        	*	at jdojo.object/com.jdojo.object.CloneObject.main(CloneObject.java:51)
			*/
			sc = (SmartCat) super.clone();

			
		}catch(CloneNotSupportedException e){
			e.printStackTrace() ;
		}

		return sc;
	}
}