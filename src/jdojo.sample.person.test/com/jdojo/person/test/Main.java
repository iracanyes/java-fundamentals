package com.jdojo.person.test;

import com.jdojo.person.Person;
/*
* Commmand:
*	Compile:
*		javac -d mod/jdojo.sample.person.test src/jdojo.sample.person.test/module-info.java src/jdojo.sample.person.test/com/jdojo/person/test/Main.java -p mod
* 	Archive:
*		jar -c -v -f lib/com.jdojo.sample.person.test.jar -e com.jdojo.person.test.Main -C mod/jdojo.sample.person.test .
*	Run:
*		java -p lib -m jdojo.sample.person.test/com.jdojo.person.test.Main
*/
class Main{
	public static void main(String[] args) {
		Person john = new Person(1010,"John", "Jackson");

		String city = john.getAddress().getCity();
		System.out.printf("John lives in %s%n", city);
	}
}