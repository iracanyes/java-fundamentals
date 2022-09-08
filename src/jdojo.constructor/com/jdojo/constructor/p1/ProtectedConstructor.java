package com.jdojo.constructor.p1;

import com.jdojo.constructor.AccessLevelTest3;

class ProtectedConstructor extends AccessLevelTest3{
	private ProtectedConstructor(){
		// Call parent class constructor Test3()
		// Here it's going to call the protected constructor of class Test3
		super(0.01);
	}
}