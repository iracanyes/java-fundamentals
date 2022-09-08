/*
* Command:
*	Compile: 
*		javac -p mod -d mod/jdojo.sample.person src/jdojo.sample.person/module-info.java src/jdojo.sample.person/com/jdojo/person/*  -Xdiags:verbose -Xlint:unchecked
*	Packaging:
*		jar -cvf lib/com.jdojo.sample.person.jar -C mod/jdojo.sample.person .
*
*/
module jdojo.sample.person{
	/*
	* As all modules that reads the package "com.jdojo.person" which is exported from this module
	* will need access to module "jdojo.sample.address" to manipulation the class "com.jdojo.address.Address"
	* Using "transitive" statement ensure that all module reading "com.jdojo.person" are also allowed to read 
	* the package "com.jdojo.address" from module "jdojo.sample.address"
	*/
	requires transitive jdojo.sample.address;

	/*
	* Expose publicly package "com.jdojo.person" to all module
	*/
	exports com.jdojo.person;
}