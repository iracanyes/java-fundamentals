/*	
* Command:
*	Run: java -p lib --module jdojo.object/com.jdojo.object.ObjectToString
*
*
* STRING REPRESENTATION OF AN OBJECT
* An object is represented by its state which is the combination of values of its instance variable at a point in time.
* The string representation of an object contains the state of an object at a point in time.
*
*	Object.toString()
* Returns the state of the object in a string representation.
* Used for debugging purpose.
* Default implementation of the method returns a string format:
*
* 		<fully-qualified-class-name>@<hash-code-object-in-hexadecimal-format>	
*
*
* Method can be overriden
*	Signature:
*		public String toString()
*/
package com.jdojo.object;

import com.jdojo.common.SmartIntHolder;
import com.jdojo.common.IntHolder;
import com.jdojo.common.SmartPoint;


public class ObjectToString{
	public static void main(String[] args) {
		Object obj = new Object();
		IntHolder intHolder = new IntHolder(234);

		String objStr = obj.toString();
		String intHolderStr = intHolder.toString();

		System.out.println(objStr);
		System.out.println(intHolderStr);

		SmartIntHolder sIntHolder = new SmartIntHolder(3245);
		String sIntHolderStr = sIntHolder.toString();

		System.out.println(sIntHolder);

		// Change the value int SmartIntHolder object
		sIntHolder.setValue(8765);
		sIntHolderStr = sIntHolder.toString();
		System.out.println(sIntHolderStr);


		/*
		* Java use toString() automatically in situation when he need a string representation
		* Here are some example
		*/
		SmartPoint sp = new SmartPoint(65,78);
		SmartPoint sp2 = null;
		
		String str = "My point: " + new SmartPoint(10,12);
		String str2 = "My null point: " + sp2;

		// Java use automatically toString() method of the object
		System.out.println(str);
		System.out.println("Another point: " + new SmartPoint(45,56));
		System.out.println(sp);
		System.out.println(sp.toString());
		// Java return "null" for null reference
		System.out.println(sp2);
	}
}