package com.jdojo.intro;

/*
* ARRAY
* Declaration
* byte[] anArrayOfBytes;
* short[] anArrayOfShorts;
* long[] anArrayOfLongs;
* float[] anArrayOfFloats;
* double[] anArrayOfDoubles;
* boolean[] anArrayOfBooleans;
* char[] anArrayOfChars;
* String[] anArrayOfStrings;
*/
class ArrayDemo{
	public String[] copyFrom = {
			"Affogato", "Americano", "Cappuccino", "Corretto", "Cortado",   
            "Doppio", "Espresso", "Frappucino", "Freddo", "Lungo", "Macchiato",      
            "Marocchino", "Ristretto"
		};

	public short[] bytesArr = {
		0 , 
		-128 , 	// Short min Value 
		127, 	// Short max value
		24, 
		-79
	};
	public short[] shortArr = {
		0, 
		-32768, 	// Short Min value
		32767, 		// Short Max value
		235, 145 
	};
	public int[] intArr = {
		0, 
		-2_147_483_648, // Int Min value 
		2_147_483_647, 	// Int Max value
		4, 6_654_654, 8, 10
	};
	public long[] longArr = {
		0L, 
		-9_223_372_036_854_775_808L, 	// Long Min value
		9_223_372_036_854_775_807L, 	// Long Max value
		200L, 100L, -124525L
	};
	public float[] floatArr = {
		0.0f,
		1.4e-45f,	// Float Min value 
		3.4e38f,	// Float Max value 
	};
	public double[] doubleArr = {
		0.0,
		4.9e-324d,	// Double Min value
		1.7e308, 	// Double Max value
		1.587458e152d , 
		1.252e2,
	 };
	
	public static void main(String[] args){
		int[] table = new int[20];

		table[0] = 20;
		table[1] = 40;
		table[2] = 60;
		table[3] = 80;
		table[4] = 100;
		table[5] = 120;
		table[6] = 140;
		table[7] = 160;
		table[8] = 20000;

		for(int i = 0; i < table.length -1; i++){
			System.out.println("\nTable at index " + i +" : " + table[i]);
		}
		
	}

	public void multiDimArray(){

		int[] anArray = new int[10];
		// shortcut to initialize an array with brackets
		int[] shortcutArray = { 10, 2, 8 ,4 , 6, 0};

		String[][] names = {
			{"Mr", "Mrs.", "Ms."},
			{"Smith", "Jones", "Jane"}
		};

		System.out.println(names[0][0] + " " + names[0][1]);
	}

	/*
	* System class has an arraycopy method with this signature
	* public static void arrayCopy(Object src, int srcPos, Object dest, int destPos, int length)
	* 
	*/
	public void arrayCopy(){		

		String[] copyTo = new String[7];
		// Here we System class method arraycopy
		System.arrayCopy(copyFrom, 2, copyTo, 0, 5);

		// Java SE offer several methods for performing array manipulations
		// in java.utils.Arrays
		String[] copyTo2 = java.utils.Arrays.copyOfRange(copyFrom, 2, 9);

		for(String coffee: copyTo){
			System.out.println(coffee + " ");
		}		


	}

	public void searchInArray(){
		// Binary Search
		// BinarySearch have multiple signature for searching for specific value in an array of different type.
		// For each primitive type (byte, short, int, long, float, double, char) and Object Type, T type (unknown at definition)
		// There is 2 signature
		// 1. Simple binary search:
		// Search for value 'key' of Type in array of Type named "arr"
		// public static void binarySearch(Type[] arr, Type key)
		// 
		// 2. 
		// Search from index A to index B for value "key" of Type
		// public static void binarySearch(Type[] arr, int indexA, int indexB, Type key)

		// Integer
		// signature : public static int binarySearch(int[] a, int key)
		int index = java.utils.Arrays.binarySearch(copyFrom, );
		// 2. Search a range of the specified array of ints for the specified value
		// signature: public static int binarySearch(int[] a, int fromIndex, int toIndex, int key)
		int index = java.utils.Arrays.binarySearch(copyFrom, 0, 6, )
		String[]
	}
}