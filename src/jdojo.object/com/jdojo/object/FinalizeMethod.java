/*
* Java provides a way to perform resource release (cleanup), 
* when an object is about to be destroyed.
* In Java you can create objects, but you cannot destroy them.
* Java run a low-priority special task calle garbage collector
* to destroy all objects that are no longer referenced.
* The garbage collector allow to execute your cleanup code before the object is destroyed.
* The Object class provides a finalize() method.
*
*	Structure:
*		protected void finalize() throws Throwable{}
*
* The finalize() method of Object class do nothing.
* You must override the method to execute some cleanup logic.
* The garbage collector will call the finalize() method of each object 
* before destroying it.
*/
package com.jdojo.object;

public class FinalizeMethod{
	private int x;

	public FinalizeMethod(int x){
		this.x = x;
	}

	/*
	* Since Java 9, finalize() method is deprecated 
	* because using finalize() method to cleanup ressources is inherently problematic;
	* They are better ways to use cleanup resources:
	*	- try-with-resources
	*	- try-finally
	*
	* ERROR: FinalizeMethod.java uses or overrides a deprecated API
	*/
	//@Override
	/*
	public void finalize(){
		System.out.println("Start Finalizing instance of GarbageCollector class");
		
		// Here goes the cleanup code
	}
	*/
}