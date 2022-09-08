package com.jdojo.object;

public class ShallowCloneTest{
	public static void main(String[] args) {
		ShallowClone sc = new ShallowClone(3265.2321E10);
		ShallowClone scClone = (ShallowClone) sc.clone();

		System.out.println("Original: " + sc.getValue());
		System.out.println("Clone: " + scClone.getValue());

		/*
		* As the orinal object and the cloned object refers to the same contained object
		* change made the contained object will be reflected by the original container object and the cloned container object
		*/
		sc.setValue(2200.32);

		/*
		*
		*/
		System.out.println("Original: " + sc.getValue());
		System.out.println("Clone: " + scClone.getValue());
	}
}