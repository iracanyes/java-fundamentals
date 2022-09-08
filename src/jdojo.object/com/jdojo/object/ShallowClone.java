/*
* SHALLOW CLONING
* For an object which is composed of other object,
* there is a container object and a contained object
* When you use the default clone method of Object class "super.clone()",
* the reference to the contained objects are COPIED in the cloned container object.
* At the ends of cloning, the original object and the cloned object
* will have a reference to the same contained object.
*
*	Original object 	Cloned object 
*		  		 |			|
*				Contained object
*
* This is called shallow cloning because the reference is copied, not the content of the object
* A compound object may have multiple levels of chaining of contained objects.
* 
*/
package com.jdojo.object;

import com.jdojo.common.DoubleHolder;

public class ShallowClone implements Cloneable{
	private DoubleHolder dh = new DoubleHolder(0.0);

	public ShallowClone(Double d){
		this.dh.setValue(d);
	}

	public void setValue(double value){
		this.dh.setValue(value);
	}

	public double getValue(){
		return this.dh.getValue();
	}

	@Override
	public ShallowClone clone(){
		ShallowClone sc = null;

		try{
			sc = (ShallowClone) super.clone();
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}

		return sc;
	}
}