package com.jdojo.common;

import java.util.Objects;
import java.util.function.Supplier;

public class ObjectsTest{
	private int i1;
	private double d1;
	private boolean b1;
	private String str;
	private String str2;

	public ObjectsTest(boolean b1, int i1, double d1, String str, String str2){
		this.b1 = b1;
		this.i1 = i1;
		this.d1 = d1;
		this.str = str;
		this.str2 = str2;
	}

	public void printString1(){
		// Generate a NullPointerException if it's null
		Objects.requireNonNull(this.str, "str1 is null!");

		System.out.println("String1 : " + this.str);
	}

	public void printString2(){
		Objects.requireNonNullElse(this.str, "My string by default!");

		System.out.println("String1 : " + this.str);
	}

	public void printStringWithSupplier(String str, Supplier<String> messageSupplier){
		Objects.requireNonNull(str, messageSupplier);

		System.out.println(str);
	}


	@Override
	public int hashCode(){
		return Objects.hash(b1, i1, d1, str, str2);
	}

}