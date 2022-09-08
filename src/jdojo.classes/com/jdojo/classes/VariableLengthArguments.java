package com.jdojo.classes;

/*
* Var-Args 
* Variable arguments lenght allow declare a method which accept an unknown number of arguments in its parameters
* Structure:
*	<data-type>... <argument-name>
*
* Compiler treat variable-length arguments as an array
*
* E.G.: void main(String... args) => void main(String[] args)
*/
public class VariableLengthArguments{
	/*
	*
	*/
	public static void main(String[] args) {
		
		// Find max between 2 numbers
		int max = MathUtil.max(12, 18);
		int max2 = MathUtil.max(12, 35, 18);

		int[] nums1 = new int[] {12,65,98,84,15,24,32};
		int max3 = MathUtil.max(nums1);
	}

	
}

public class MathUtil{
	public static int max(int x, int y){
		int max = x;
		if(y > max){
			max = y;
		}
		return max;
	}

	/*
	* Here exists 2 methods with the same name but different signature
	* 
	*/
	public static int max(int x, int y, int z){
		int max = max;
		if(y > max){
			max = y;
		}
		if(z > max){
			max = z;
		}

		return max;
	}

	/*
	* When all arguments are unknown. 
	* Before var-args adding, u had to use an array but array has a known lenght 
	*/
	public static int max(int[] nums){
		// Check if array is empty
		if(nums.length == 0){
			return 0;
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length ; i++ ) {
			if(nums[i] > max){
				max = nums[i];
			}
		}

		return max;
	}


	/*
	* Using Var-args 
	* Allow to receive an unknown number of arguments (from 0 to n)
	* Structure : 
	* 	<data-type>... <arg-identifier>
	*
	* 3 rules:
	*	- whitespace allowed before and after ellipsis "...", here are allowed declaration
	* 		<data-type> ... <arg-identifier>	// space before and after
	* 		<data-type>...<arg-identifier>		// No whitespace
	* 		<data-type>...						// whitespace and newline
	*			 <arg-identifier>
	*	- Var-args method can only have ONE variable-length arguments
	*	- variable-length argument MUST BE THE LAST DECLARED argument
	*/
	public static int max(int... nums){
		int max = Integer.MIN_VALUE;

		for(int i = 0; i < nums.length; i++){
			if(num[i] > max){
				max = num[i];
			}
		}

		return max;
	}

	/*
	* Here is an incomplete max methood. 
	* If no arguments is given, method will return Integer.MIN_VALUE: -2147483648
	*/
	public static int max2(int...nums){
		int max = Integer.MIN_VALUE;

		/*
		* here we use foreach loop
		*/
		for(int currentNumber: nums){
			if(currentNumber > max){
				max = currentNumber;
			}
		}

		return max;
	}

	/*
	* Here is the correct max method which requires a minimum of 2 integer to test 
	*/
	public static int max(int num1, int num2, int... nums){
		// Initialize max to maximum of num1 and num2
		int max = ( num1 > num2 ? num1 : num2);

		for(int currNum: nums){
			if(currNum > max){
				max = currNum;
			}
		}
		return max;
	}



}