/*
* DEEP CLONE
*
* When the contained objects of an object are CLONED, 
* it called Deep clonning.
* You must clone all the objects referenced by all reference variables of the object
* Deep cloning may be hard to accomplish:
*	- A contained object may not support deep cloning
*	- A contained object may be composed of other contained object which doesn't support deep cloning
* When you accomplish a deep cloning:
*	- Immutable object doesn't need to be cloned. You can copy the reference to it.
* 
* The advantage of using Immutable objects is that their references can shared by multiple objects
* without any side effects.
*/
package com.jdojo.object;

import com.jdojo.common.DoubleHolder;

public class DeepClone implements Cloneable{
	private DoubleHolder holder = new DoubleHolder(0.0);

	public DeepClone(double d){
		this.holder.setValue(d);
	}

	public void setValue(double d){
		this.holder.setValue(d);
	}

	public double getValue(){
		return this.holder.getValue();
	}

	public void setHolder(DoubleHolder dh){
		this.holder = dh;
	}

	public DoubleHolder getHolder(){
		return this.holder;
	}

	/*
	* Before accomplishing a deep cloning, you must make a shallow cloning of the object
	* Then you need to write the code to clone all objects referenced by all reference instance variable of an object.
	*/
	@Override 
	public Object clone(){
		DeepClone copy = null;

		try{
			// first, we make a shallow copy of the object
			copy = (DeepClone) super.clone();

			// Clone all referenced variables of the object
			// Here, there is only one
			copy.setHolder((DoubleHolder) this.holder.clone());

			/*
			* If the class is not cloneable,
			* the same statement as above will write as follow:
			*
			* 	DoubleHolder dh = new DoubleHolder(this.dh.getValue());
			* 	copy.setHolder(new DoubleHolder(this.dh.getValue()));
			*/

		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}

		return copy;
	}
}