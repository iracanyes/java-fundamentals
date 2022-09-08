package com.jdojo.person;

import com.jdojo.address.Address;

/*
* Command:
*	- Compile jdojo.sample.address: 
*	 	javac -d mod/jdojo.sample.address src/jdojo.sample.address/module-info.java src/jdojo.sample.address/com/jdojo/address/Address.java
*	- Compile jdojo.sample.person:
*	 	javac -d mod/jdojo.sample.person --module-path mod/jdojo.sample.address src/jdojo.sample.person/module-info.java src/jdojo.sample.person/com/jdojo/person/Person.java src/jdojo.sample.person/com/jdojo/person/Main.java	
*	- Packaging "jdojo.sample.address" into JAR files:
*		jar -cvf lib/com.jdojo.sample.address.jar -C mod/jdojo.sample.address .
*	- Packaging "jdojo.sample.person" into JAR files:
*		jar -c -f lib/com.jdojo.sample.person.jar -e com.jdojo.person.Main  -C mod/jdojo.sample.person .
*	- Run app using only modules: 
*		 java -p mod -m jdojo.sample.person/com.jdojo.person.Main
*	- Run app using JAR files:
*		java -p lib -m jdojo.sample.person/com.jdojo.person.Main
*/
public class Main{
	public static void main(String[] args) {
		Person john = new Person(2002, "John", "Jackson");

		String firstName = john.getFirstName();
		String lastName = john.getLastName();
		Address addr = john.getAddress();

		System.out.printf("%s %s%n", firstName, lastName);
		System.out.printf("%s%n", addr.getLine1());
		System.out.printf("%s%n", addr.getCity());
		System.out.printf(
			"%s, %s %s%n", 
			addr.getCity(), 
			addr.getState(), 
			addr.getZip()
		);
	}
}