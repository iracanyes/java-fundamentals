package com.jdojo.sample;

import com.jdojo.common.AccessLevelSample;

public class AccessLevelTest2{
	public static void main(String[] args) {
		AccessLevelSample als = new AccessLevelSample();

		// als.n1 is private instance variable
		// int a = als.n1;		// Compile-time error. Cannot access private reference
		// int b = als.n2;		// Compile-time error. Cannot access package-level reference
		// int c = als.n3;		// Compile-time error. Cannot access protected reference
		int d = als.n4;			// OK if package com.jdojo.common is exported from module "jdojo.classes" or com.jdojo.common.AccessLevelSample
								// and the package or the class is required by the parent module of this class

		System.out.println(
			"a = al.n1 = error\n" 
			+ "b = al.n2 = error\n"
			+ "c = al.n3 = error\n"
			+ "d = al.n4 = " + d + "\n"
		);

		// als.m1();	// Compile-time error: Cannot access private method
		// als.m2();	// Compile-time error: Cannot access package-level reference
		// als.m3();	// Compile-time error: Cannot access protected reference
		als.m4();		// OK if package com.jdojo.common is exported from module "jdojo.classes" or com.jdojo.common.AccessLevelSample
						// and the package or the class is required by the parent module of this class

		/*
		*
		*/
		// als.n2 = 466;	// Compile-time error: Cannot access package-level reference
		// als.n3 = 466;	// Compile-time error: Cannot access protected reference
		als.n2 = 65466;		// OK if package com.jdojo.common is exported from module "jdojo.classes" or com.jdojo.common.AccessLevelSample
							// and the package or the class is required by the parent module of this class
		
		// als.m1();	// Compile-time error: Cannot access private method
		// als.m2();	// Compile-time error: Cannot access package-level method
		// als.m3();	// Compile-time error: Cannot access protected method
		als.m4();		// OK if package com.jdojo.common is exported from module "jdojo.classes" or com.jdojo.common.AccessLevelSample
						// and the package or the class is required by the parent module of this class


	}
}