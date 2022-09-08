package com.jdojo.common;

public class SmartPointTest{
	public static void main(String[] args) {
		SmartPoint pt1 = new SmartPoint(32,32);
		SmartPoint pt2 = new SmartPoint(32,32);
		SmartPoint pt3 = new SmartPoint(56,32);
		SmartPoint pt4 = pt1;

		System.out.println("pt1 == pt1 : " + (pt1 == pt1));
		System.out.println("pt1.equals(pt1) : " + pt1.equals(pt1));

		System.out.println("pt1 == pt2: " + (pt1 == pt2));
		System.out.println("pt1.equals(pt2): " + pt1.equals(pt2));

		System.out.println("pt1 == pt3: " + (pt1 == pt3));
		System.out.println("pt1.equals(pt3): " + pt1.equals(pt3));

		System.out.println("pt1 == pt3: " + (pt1 == pt4));
		System.out.println("pt1.equals(pt3): " + pt1.equals(pt4));

	}
}
