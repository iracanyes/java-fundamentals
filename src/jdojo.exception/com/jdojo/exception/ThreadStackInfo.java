/*
* The stack (pile mémoire) is an area of memory that is used to store temporary data.
* It use last-in, first-out method of storage.
* Each thread in Java is allocated a stack to store its temporary data.
* A thread stores the state of a method invocation onto its stack (pile).
* The state of a Java method contains: 
*	- parameters' values 
*	- local variables
*	- intermediate computed values
*
* Java consists of stack frame (trame de pile mémoire) and each frame store
* the state of one method invocation.
* A new frame is pushed into the stack when a new method is invocated.
* When the method finish executing, it popped (retirer) from the stack.
* Removing a frame from the stack is called pop operation.
* The state of a stack change constently when the program is executing.
*
* A stack trace is snapshot of the stack frame at specific time.
* To access information about a stack trace we use the class java.lang.StackTraceElement
* which provides 4 informations about the stack trace:
*	- class name
*	- file name
*	- method name
*	- line number 
* To get the stack information you have to call getStackTrace method from Throwable class or subtype
*  StackTraceElement[] getStackTrace()
*
* The first element of the array the TOP stack frame.
* The last element of the arry is the BOTTOM stack frame.
* 
* When you create an object of the Throwable class (or any exception class),
* it capture the stack of the thread that is executing
*
* When you want to capture the stack of the thread at a different time than 
* when the Throwable object was created, you can use fillInStackTrace() method
* to capture the stack of the thread at that point in time.
*/
package com.jdojo.exception;


public class ThreadStackInfo{
	public static void main(String[] args) {
		m1();
	}

	public static void m1(){
		m2();
	}

	public static void m2(){
		m3();
	}

	public static void m3(){
		/*
		* Here, we create a Throwable object that capture the stack trace
		* at this point for the thread that executes the following statement
		*/
		Throwable t = new Throwable();

		// Get the stack trace elements
		StackTraceElement[] frames = t.getStackTrace();

		// Prints details about the stack frames
		printStackDetails(frames);
	}

	public static void printStackDetails(StackTraceElement[] frames){
		System.out.printf("\nFrames count: %d\n", frames.length);

		for (var i = 0; i < frames.length ; i++ ) {
			// Get frame details
			
			int frameIndex = i; 
			System.out.printf("Frame index : %d\n", frameIndex);

			String filename = frames[i].getFileName();
			System.out.printf("File name : %s\n", filename);

			String className = frames[i].getClassName();
			System.out.printf("Class name : %s\n", className);

			String methodName = frames[i].getMethodName();
			System.out.printf("Method name : %s\n", methodName);

			int lineNumber = frames[i].getLineNumber();
			System.out.printf("Line Number : %s\n", lineNumber);
			System.out.println("------------------------------------------------------------\n");
		}
	}
}