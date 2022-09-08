module jdojo.sample.person.test{
	requires jdojo.sample.person;
	/*
	* If a module want to use implicitly or explicitly the class "Address", 
	* it must reads the module "jdojo.sample.address".
	* if the module "jdojo.sample.person" doesn't use a "requires transitive" statement which 
	* allow implicit access to package used by the exported package "com.jdojo.person",
	* you will have to make a "requires" statement for each one of package used by the exported package
	* "com.jdojo.person" from module "jdojo.sample.person"  
	*/
	requires jdojo.sample.address;
}