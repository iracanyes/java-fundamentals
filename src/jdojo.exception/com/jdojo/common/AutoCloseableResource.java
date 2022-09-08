package com.jdojo.common;

public class AutoCloseableResource implements AutoCloseable{
	private int level;
	private boolean exceptionOnClose;

	public AutoCloseableResource(int level, boolean exceptionOnClose){
		this.level = level;
		this.exceptionOnClose = exceptionOnClose;
		System.out.println("Creating AutoCloseableResource. Level =" + level);
	}

	public void use(){
		if(level <= 0){
			throw new RuntimeException("Level is low.");			
		}
		level--;
		System.out.println("Using AutoCloseableResource level " + this.level);
	}

	@Override
	public void close(){
		if(exceptionOnClose){
			throw new RuntimeException("Error in closing.");
		}

		System.out.println("Closing the resource...");
	}
}