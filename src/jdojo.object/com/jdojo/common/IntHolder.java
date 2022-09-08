package com.jdojo.common;

public class IntHolder{
	private int i;

	public IntHolder(int i){
		this.i = i;
	}

	public void setValue(int i){
		this.i = i;
	}

	public int getValue(){
		return this.i;
	}
}