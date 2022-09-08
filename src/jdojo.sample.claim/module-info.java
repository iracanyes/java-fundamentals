/*
* Module "jdojo.sample.policy" contains 2 packages named "com.jdojo.claim" and 
* "com.jdojo.claim.impl"
*/
module jdojo.sample.claim{
	/*
	* It reads the module "jdojo.sample.policy" which exports only one package
	* "com.jdojo.policy"
	*/
	requires jdojo.sample.policy;
}