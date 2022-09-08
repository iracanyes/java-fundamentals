package com.jdojo.common;



public class CloningTest{
	public static void main(String[] args) {
		DoubleHolder dh = new DoubleHolder(5632E23d);
		// DoubleHolder.clone() return an object of type DoubleHolder
		DoubleHolder dhClone = dh.clone();

		System.out.println("Original value : " + dh.getValue());
		System.out.println("Cloned value : " + dhClone.getValue());

		dh.setValue(200.00);
		dhClone.setValue(450.32d);

		System.out.println("Original value : " + dh.getValue());
		System.out.println("Cloned value : " + dhClone.getValue());

	}
}