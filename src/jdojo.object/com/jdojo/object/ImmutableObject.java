/*
* IMMUTABLE OBJECT
* An object which state cannot be changed after its creation is called an immutable object
* A class whose objects are immutable is called an immutable class.
*
*
* An object define a state:
*	- internal state: defined by the actual values of its instances variables
*	- external state: defined by the values that users see at a point in time
* In Java, immutability means external immutability.
* An immutable object can change its internal state after its creation.
* However, the change in its internal state cannot be visible to its external state.
*
* Advantages of immutable objects:
*	- Can be shared by multiple area of a programe without worrying about its state changes
*	- Testing is easy
*	- You doesn't have to worry about synchronize access to your immutable object from 
*	 	multiple threads since its state doesn't change.
*/
package com.jdojo.object;

import com.jdojo.common.IntWrapper;
import com.jdojo.common.IntWrapper2;
import com.jdojo.common.IntHolder;
import com.jdojo.common.IntHolderWrapper;
import com.jdojo.common.IntHolderWrapper2;
import com.jdojo.common.IntHolderWrapper3;

public class ImmutableObject{
	public static void main(String[] args) {
		/*
		* At this point, the "wrapper" reference variable hold an object 
		* which state is composed of only one instance variable with a value of 12.
		* the only instance variable is a final instance variable (or constant)
		* which means it cannot be changed.
		* The internal state and the external state of the class cannot be changed.
		* Therefore, the IntWrapper class is an immutable class and its object are immutable objects  
		*/
		IntWrapper wrapper = new IntWrapper(12);
		int wr1Value = wrapper.getValue(); 
		System.out.println("Wrapper 1 : " + wr1Value);


		/*
		* At this point, the "wrapper2" reference variable hold an object 
		* which state is composed of only one instance variable with a value of 65.
		*/
		IntWrapper2 wrapper2 = new IntWrapper2(65);
		int wr2Value = wrapper2.getValue();
		System.out.println("Wrapper 2 value : " + wr2Value);
		/*
		* By calling the method "getHalfValue()", the internal state of the object changed.
		* Because, the class IntWrapper use caching technique which cache the value of halfValue instance variable
		* at its first use.
		* The change in its internal state doesn't affect its external state.
		* Therefore, the class "IntWrapper2" is an immutable class
		*/
		int wr2halfValue = wrapper2.getHalfValue();
		System.out.println("Wrapper 2 halfValue : " + wr2halfValue);

		
		/*
		* BAD IMMUTABLE CLASS with reference type instance variable
		*/
		System.out.println("BAD IMMUTABLE TEST");
		IntHolderWrapper ihw = new IntHolderWrapper(45);

		int value = ihw.getValue();
		System.out.println("#1 Holder value : " + value);

		// Here, we received the reference value of the reference type instance variable of the object
		// which allow a direct access to the content of the object using the reference value (which contains the memory address of the object)
		IntHolder ih = ihw.getHolder();
		ih.setValue(6598);

		System.out.println("#2 Holder value : " + ihw.getValue());


		/*
		* CORRECT IMMUTABLE CLASS with reference type instance variable
		*
		*/
		System.out.println("CORRECT IMMUTABLE TEST");
		IntHolderWrapper2 ihw2 = new IntHolderWrapper2(45);

		value = ihw2.getValue();
		System.out.println("#1 Holder value : " + value);

		/*
		* Here, the object "ihw2" returns a copy of its reference type instance variable
		* Manipulating a copy of the reference type instance variable in the client code
		* doesn't affect the internal and external state of the object "ihw2"
		* The class of the object "ihw2" is considered immutable.
		*/
		IntHolder ih2 = ihw2.getHolder();
		ih.setValue(6598);

		System.out.println("#2 Holder value : " + ihw2.getValue());

		/*
		* Correct implementation of immutable class with 
		* a constructor which receive in its formal parameters a reference variable to store in its
		* reference type instance variable. 
		* The class copy the content of the object received not the reference (memory address).
		* By copying the content of the object instead of the reference of the object,
		* it doesn't allow any future change of its internal object by using the same reference (memory address) received in the formal parameter of the constructor 
		*/	
		IntHolder ih3 = new IntHolder(78);
		IntHolderWrapper3 ihw3 = new IntHolderWrapper3(ih3);
		System.out.println(ihw3.getValue());
		

		ih3.setValue(12);
		/*
		* Here, you can see that chances made to the object referenced
		* by the reference variable "ih3" doesn't change the internal state of 
		* object "ihw3" which store a copy of the content of the object "ih3"
		* made at its creation 
		* 
		*/
		System.out.println(ihw3.getValue());

	}
}