/*
* BEST PRACTICE:
*	- A method should never throw too many exception.
*	- A package that has been already released should never throw new exception.
*		=> If a new exception is thrown, all package users' will have to update their code.
*		=> Redesign the method to catch low-level exception and rethrow only one 
*			higher-level exception. It's allow updating old package with new exception. 
*			All new exception are catched inside the package 
*/
package com.jdojo.exception;

public class ThrowingException{
	public static void main(String[] args) {
		try{
			m1();
		}catch(MyException e){
			// Default behaviour 
			e.printStackTrace();
		}catch(MultipleHandlerException e){
			e.printStackTrace();
		}
	}

	public static void m1() throws MyException, MultipleHandlerException{
		try{
			m2();
			throw new MyException("An error occured in m1() mmethod.");
		}catch(MyException e){
			// Here we hide the location of the 
			// original exception and fill in a new stack trace from this method.
			e.fillInStackTrace();

			// Here, we rethrow the exception catched
			throw e;
		}catch(MyException2 e){
			/*
			* Here we design the method to catch multiple low-level exception and rethrow only one 
			*		higher-level exception.   
			*/
			throw new MultipleHandlerException("Msg 2", e);
		}catch(MyException3 e){
			throw new MultipleHandlerException("Msg 3", e);
		}catch(MyException4 e){
			throw new MultipleHandlerException("Msg 4", e);
		}catch(MyException5 e){
			throw new MultipleHandlerException("Msg 5", e);
		}
	}

	/*
	* Before Java 7, when catch(Exception e) statement which declare in its argument
	* an exception of type Exception, catch it  and rethrow it.
	* the method that throw the exception must declare a throws clause of type Exception.
	* Since Java 7, when catch(Exception e) statement receive in its argument,
	* a subtype of Exception and rethrow it, the method that rethrow the exception can 
	* declare in its throws clause the subtype which is thrown
	*/
	public static void m2()throws MyException2, MyException3, MyException4, MyException5{
		try{
			m3();
			throw new MyException2("An error occured in m2() method.");
		}catch(Exception e){
			// Do something: log, prompt message, etc...

			// Here, we rethrow the exception catched
			throw e;
		}
	}

	public static void m3()throws MyException3, MyException4, MyException5{
		try{
			m4();
			throw new MyException3("An error occured in m3() method.");
		}catch(Exception e){
			// Do something: log, prompt message, etc...

			// Here, we rethrow the exception catched
			throw e;
		}
	}

	public static void m4()throws MyException4, MyException5{
		try{
			m5();
			throw new MyException4("An error occured in m4() method.");
		}catch(Exception e){
			// Do something: log, prompt message, etc...

			// Here, we rethrow the exception catched
			throw e;
		}
	}

	public static void m5() throws MyException5{
		throw new MyException5("An error occured in m5() method");
	}
}


/*
* An exception class must extends the class Exception and the parent constructor
* in his own constructors. 
*/
class MultipleHandlerException extends Exception{
	public MultipleHandlerException(String msg, Exception e){
		// The message for the exception is handled by the parent class Exception
		super(msg);

		/*
		* Throwable methods
		* All the methods from Throwable are accessible to Exception classes.
		*/

		/*
		* Signature: String Throwable.getCause();
		* returns the cause of the exception. 
		* If the cause of exception is not set, it returns null
		*/
		Throwable cause = e.getCause();

		System.out.println("MULTIPLEHANDLEREXCEPTION _ THROWABLE.GETCAUSE");
		/*
		* Here, Java Throwable.toString()
		* to print a short description of the Throwable object 
		*/
		System.out.println(cause);

		/*
		* Signature : String getMessage()
		* Returns the detailed message of the exception.
		* The description contains the name of the class and the detailed error message.
		*/
		String errorMsg = e.getMessage();

		System.out.println("MULTIPLEHANDLEREXCEPTION _ THROWABLE.GETMESSAGE");
		System.out.println(errorMsg);

		/*
		* Throwable.getStackTrace()
		* Returns an array of stack trace elements.
		* Each element represents one stack frame.
		* The first element represents the top of the stack.
		* The last element represents the bottom of the stack.
		* 
		*/
		StackTraceElement[] stackTrace = e.getStackTrace();

		System.out.println("MULTIPLEHANDLEREXCEPTION _ THROWABLE.GETSTACKTRACE");
		System.out.println(stackTrace);

		/*
		* Signature: Throwable initCause(Throwable cause)
		* Returns an throwable object.
		* The method allow to create an Exception from an exception.
		*/
		Throwable myThrowableOject = e.initCause(e);

		System.out.println("MULTIPLEHANDLEREXCEPTION _ THROWABLE.INITCAUSE");
		System.out.println(myThrowableOject);

		/*
		* Signature: void printStackTrace()
		* Print the stack trace on the standard error stream.
		* 
		*/

		/*
		* Signature: void printStackTrace(PrintStream ps)
		* Print the stack trace to the specified PrintStream object
		* 
		* 
		*/

		/*
		* Signature: void printStackTrace(PrintWriter pw)
		* Print the stack trace to the specified PrintWriter object
		* 
		*/



	}
}

class MyException extends Exception{
	public MyException(String msg){
		super(msg);
	}
}

class MyException2 extends Exception{
	public MyException2(String msg){
		super(msg);
	}
}

class MyException3 extends Exception{
	public MyException3(String msg){
		super(msg);
	}
}
class MyException4 extends Exception{
	public MyException4(String msg){
		super(msg);
	}
}
class MyException5 extends Exception{
	public MyException5(String msg){
		super(msg);
	}
}
