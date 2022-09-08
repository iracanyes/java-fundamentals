/**
* An aggregator module is a module which collects and exports types from others modules.
* It allow to regroup types from multiple modules which have the same purpose into one modules.
* Other modules will only need to declare one modules to used all the types necessary for that purpose.
* Example of aggregator modules : "java.se", "java.se.ee"
*/
module jdojo.modules.aggregator{
	requires transitive jdojo.sample.person;
	requires transitive jdojo.sample.policy;
	requires transitive jdojo.sample.claim; 	
}