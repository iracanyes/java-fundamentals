package com.jdojo.common;

import java.util.Comparator;

public class IntHolderWrapperComparator implements Comparator<IntHolderWrapper>{
	@Override
	public int compare(IntHolderWrapper ihw1, IntHolderWrapper ihw2){
		return Integer.compare(ihw1.getValue(), ihw2.getValue());
	}
}