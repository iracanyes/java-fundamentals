package com.jdojo.object;

public class FinalizeMethodTest{
	public static void main(String[] args) {
		// Here we define
		FinalizeMethod[] fmArray = new FinalizeMethod[10];

		for(int i = 0; i < 1000; i++){
			/*
			* Here, each object created is not referenced by any reference variable
			* As object exists in memory but no reference variable in use is associated with
			*  GarbageCollector
			*/
			new FinalizeMethod(i);
		}
	}
}