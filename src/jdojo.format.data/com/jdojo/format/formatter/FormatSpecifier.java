/*
*
*/
package com.jdojo.format.formatter;

public class FormatSpecifier{
	public static void main(String[] args) {
		referencingAnArgument();
		flags();
	}

	public static void referencingAnArgument(){
		// Ordinary indexing
		// Here we use the order in which we define argument
		// no argument-index are specified
		System.out.printf("Ordinary indexing : %n%d, %d, %d\n", 2, 4, 8);


		// If a format specifier refers to non-existent argument, a MissingFormatArgument is thrown
		// System.out.printf("Ordinary indexing : %n%d, %d, %d\n", 2, 4, 8, 10);

		/*
		* Signature:
		* 	format(String, Object...)
		*	printf(String, Object...)	
		* As the second argument of format is var-args argument.
		* You can also pass an array of var-args arguments. 	
		* The size of the array must be the same as the number of format specifier defined in the pattern
		*/
		String[] names = {"Matt", "Denzel", "Tom"};
		// cast to Object[] for a non-varargs call and to suppress this warning
		System.out.printf("Ordinary indexing : %n%s, %s, %s\n", (Object[]) names);

		// 
		// Explicit indexing
		// Here we refers to the argument by the index in which they're given
		// %1$d => refers to the first digit
		// %3$	=> refers to the third digit
		System.out.println("Explicit indexing ( 2, 4.3f, 8 , 4.5, 5.33, 9 ) : ");
		System.out.printf("%3$d, %4$.2f, %1$d, %6$d, %5$.3f, %4$.4f%n", 2, 4.3f, 8 , 4.5, 5.33, 9);

		/* Relative indexing
		* A format specifier "<" used to refers to the previous format specifier used
		* "%1$s, %<s, %<s" 
		* Here, the first %<s refers to the previous format specifier given which is "%1$s"
		* The second relative format specifier "%<s" refers to the previous format specifier 
		* which refers to first format specifier given. The second relative format specifier "%<s" refers to "%1$s"
		*/
		System.out.printf("Original order : %s, %s, %s, %s, %s%n", "John", "Jane", "Harry", "Elizabeth", "Charles");
		System.out.printf("Relative order : %3$s, %<s, %s %<s, %4$s, %<s, %2$s, %s, %s ", "John", "Jane", "Harry", "Elizabeth", "Charles");


	}

	public static void flags(){
		System.out.println("\n*************** FLAGS ******************************\n");
		// (-)
		// Minumum number of characters needed. Space will be left justified 	%-5s => '  Ken'
		// If the flag is not present the space is right justifier				%5s  => 'Ken  ' 
		System.out.printf("[%-5s,%5s]", "Ken", "Ken");

		/*
		* (#)
		* The argument is formatted in an altenate form.
		* 
		* Here, %x will output the resulting hexadecimal value of 6270185
		* %#x will add the prefix (0x) used for hexadecimal value
		*/
		System.out.printf("Hexadecimal: %x ==> %#x %n", 6270185, 6270185);
		System.out.printf("%f, %#.2f, %1$#.3f %n", 23.564f, 2456.658987f, 125.235689f);

		/*
		* (+)
		* The result contains (+) sign for positive value.
		* Apply only to numeric values.
		*/
		System.out.printf("%+d, %+d, %+d %n", -125, 25, -150);

		/*
		* (' ') A space
		* The result contains a leading space for positive values.
		* Apply only to numeric values.
		*/
		System.out.printf("%d,% d,%d,% d,%d,% d %n", 12, 25, -89, -4, -10, 87 );

		/*
		* (o)
		* The empty space is filled with 0 if the word is smaller than minimum number of character needed.
		* Apply only to numeric values.
		* For integer, zeros are added at the left  ex: 00125
		* For decimal number, zeros are added at the right ex: 12.2500 		
		*/
		System.out.printf("%07d, %07d, %07f, %07f %n", 154, 2547, 12.32, 12.32);

		/*
		* "("
		* The result is inclosed in parentheses for a negative number
		* Apply only to numeric values.
		*/
		System.out.printf("%(d, %(d \n", -23, 23);

		/*
		* (<)
		* The argument used the previous format specifier used 	
		*/
		System.out.printf("%2d, %<d, %<d, %1d, %<s %n", 125, 56);

	} 
}