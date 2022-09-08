package com.jdojo.common;

public class AccessLevelSample extends Parent implements Interface {
	private int n1;
	int n2;
	protected int n3;
	public int n4;

	public static int count = 1;

	

	private void m1(){
		System.out.println("Inside method 'm1': ");
		System.out.println("n1 = " + n1);
		System.out.println("n2 = " + n2);
		System.out.println("n3 = " + n3);
		System.out.println("n4 = " + n4);

	}

	void m2(){
		System.out.println("Inside method 'm2': ");
		System.out.println("n1 = " + n1);
		System.out.println("n2 = " + n2);
		System.out.println("n3 = " + n3);
		System.out.println("n4 = " + n4);
	}

	protected void m3(){
		System.out.println("Inside method 'm3': ");
		System.out.println("n1 = " + n1);
		System.out.println("n2 = " + n2);
		System.out.println("n3 = " + n3);
		System.out.println("n4 = " + n4);
	}

	public void m4(){
		System.out.println("Inside method 'm4': ");
		System.out.println("n1 = " + n1);
		System.out.println("n2 = " + n2);
		System.out.println("n3 = " + n3);
		System.out.println("n4 = " + n4);
	}

	public static void doSumthing(){
		System.out.println("Inside method 'doSumthing': ");
		System.out.println("n1 = " + n1);
		System.out.println("n2 = " + n2);
		System.out.println("n3 = " + n3);
		System.out.println("n4 = " + n4);
	}

	/*
	* You can control the usage of private property
	* by adding public accessible method that use it
	*/
	public void setN1(int n){
		this.n1 = n;
	}

	public int getN1(){
		return this.n1;
	}

}