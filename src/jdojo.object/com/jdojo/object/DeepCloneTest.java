/*
* A deep cloning will result in independent contained objects for original and cloned object
* Result output:
* 	Original: 100.0
* 	Clone: 100.0
* 	Original: 200.0
* 	Clone: 100.0
*/
package com.jdojo.object;

public class DeepCloneTest{
	public static void main(String[] args) {
		DeepClone dh = new DeepClone(5623.3232);
		DeepClone dhClone = (DeepClone) dh.clone();

		// Print values of original and clone
		System.out.println("Original : " + dh.getValue());
		System.out.println("Clone : " + dhClone.getValue());

		dh.setValue(200.00);

		System.out.println("Original : " + dh.getValue());
		System.out.println("Clone : " + dhClone.getValue());

	}
}