/*
* Command:
*	Run:
*		java -p lib -m jdojo.classes.wrapper/com.jdojo.classes.wrapper.CharacterWrapperClass
*/
package com.jdojo.classes.wrapper;

public class CharacterWrapperClass{
	public static void main(String[] args) {
		/*
		* An object of the Character class wraps a char value
		* The class contains several constants:
		*	- BYTES: number of bytes used to represent a char type
		*	- TYPE: Class instance representing the primitive type
		*	- SIZE: the number of bits used to represent the type
		*	- MIN_VALUE: constant holding the smallest non-zero value of the specified type
		*	- MAX_VALUE: constant holding the largest positive finite value of the type
		*	- UPPERCASE_LETTER
		* 	- LOWERCASE_LETTER 
		*	- TITLECASE_LETTER
		*	- COMBINING_SPACING_MARK
		*	- CONNECTOR_PUNCTUATION
		*	- CONTROL
		*	- CURRENCY_SYMBOL
		*	- DASH_PUNCTUATION
		*	- DECIMAL_DIGIT_NUMBER
		*	- 
		*/
		// Using the factory method
		Character charObj = Character.valueOf('A');
		Character charObj2 = Character.valueOf('2');
		Character charObj3 = Character.valueOf('\u00b1');

		char cc1 = charObj.charValue();
		char cc2 = charObj2.charValue();
		char cc3 = charObj3.charValue();

		System.out.println("cc1 = " + cc1);
		System.out.println("cc2 = " + cc2);
		System.out.println("cc3 = " + cc3);

		// Using some Character class methods on c1
		System.out.println("Character.isLowerCase(cc1) : " + Character.isLowerCase(cc1));
		System.out.println("Character.isDigit(cc1) : " + Character.isDigit(cc1));
		System.out.println("Character.isLetter(cc1) : " + Character.isLetter(cc1));
		System.out.println("Lowercase of cc1 : " + Character.toLowerCase(cc1));
		System.out.println("Uppercase of cc1 : " + Character.toUpperCase(cc1));
		

		// Using some Character class methods on c2
		System.out.println("Character.isLowerCase(cc2) : " + Character.isLowerCase(cc2));
		System.out.println("Character.isDigit(cc2) : " + Character.isDigit(cc2));
		System.out.println("Character.isLetter(cc2) : " + Character.isLetter(cc2));
		System.out.println("Lowercase of cc2 : " + Character.toLowerCase(cc2));
		System.out.println("Uppercase of cc2 : " + Character.toUpperCase(cc2));
		
		System.out.println("Character.TYPE: " + Character.TYPE);
		System.out.println("Character.SIZE : " + Character.SIZE);
		System.out.println("Character.BYTES : " + Character.BYTES);
		System.out.println("Character.MIN_VALUE : " + Character.MIN_VALUE);
		System.out.println("Character.MAX_VALUE : " + Character.MAX_VALUE);





		System.out.println("Character : " + charObj);
	}
}