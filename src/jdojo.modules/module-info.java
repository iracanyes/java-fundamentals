/**
* Modules are declared in a compilation unit (set of type declaration like class, interface, enums, annotations)
* Modules are group of packages. They may contains resources like images, property files, etc.
* Modules specify the accessibility for its package to other modules and its 
* dependencies on other modules.
* 
* 3 RESTRICTION TO MODULE DECLARATION:
* 	- Module grah cannot contain a circular dependencies.
* 		=> 	2 modules can't reach each other otherwise they should be in the one module.
* 		=> 	At runtime, circular dependencies are allowed by adding readability edges programmatically
* 			or using the command-line options
* 	- Module declarations do not support module versions. Module version are manipulatilated using tools like Jar or Javac
* 	- Module system doesn't have a concept of sub-modules.
* 		=> module "jdojo.sample.person" and module "jdojo.sample.person.client" are 2 differents modules but
*  			"jdojo.sample.person.client" directory is a sub-directory of "jdojo.sample.person"
*
* TYPES OF MODULES
* JDK 9 introduced modularity but old Java programs are still compatible.
* To ease migration, JDK 9 defines 4 types of modules:
*
* 								Modules
* 								|	  |
* 					Named modules 	Unnamed modules
*					| 		  |
* 		 Explicit modules 	Automatic module
* 			|			|
* 	Normal Modules 	Open module 
* 
* Based on whether a module has a name or not, a module can be categorized as "unnamed module"
* or "named module ". 
* The name can be given automatically (implicitly) by reading Jar file on module path or explicitly in a module declaration.
* A module can be declared with "open" modifier, it will be considered open for deep reflection. 
*
* UNNAMED MODULES
* For backward compatibility, class that are not part of of a module are loaded in the "unnamed module".
* When a type is being loaded and its package is not found in any known modules,
*  the module system attempt to load the type from the class-path;
* If a type is found in the class-path, it's loaded by the class loader and added to "unnamed module".
* JAR file loaded from the class-path, are considered as automatic modules
* 
* AUTOMATIC MODULES
* Automatic modules are modules or JAR files that are loaded using the module-path
* A JAR file that is loaded using the module-path is treated as a module.
* A module is automatically defined out of a JAR.
* To assign an automatic module name for a module, 
* you have specify it in the attribute "Automatic-Module-Name" in the main section of the information file of the JAR file
* "MANIFEST.MF".
* Java will automatically generate a name and a version using the following rules:
* 	1. An hyphen (-) followed by at least one digit (and optionally one dot (.)) will be used as separator
* 		between the name and the version:
* 		Ex: com.jdojo.intro-1.0.0
* 		IMPORTANT: If no separator are found, n 
* 	2. The name doesn't contains a leading or trailing digit or dots.
* 		Ex: com.jdojo.intro.100-1.0.0.RELEASE  	=> name: com.jdojo.intro
* 												=> version: 1.0.0.RELEASE
* 	3. None alphanumeric characters are replaced by a dot and 2 dot are replaced by one dot.
*
*
* To find out the automatic name assigned to JAR file use the command:
* 	jar --describe-module -f [module-name]
*/

/* Import declaration
* Type used in import declaration may be from packages in the same module or other modules
* 
*/

/*
* Module declaration
* Structure:
*	[open] module <module.name>{
*	
*	}
* 
* 	- open : 'open' keyword allow the declare an open module
*	- module: "module" keyword allow to declare a module
*	- module.name: Must be a qualified java identifier
*
* Module-info file have restricted keyword: 
*	open, module, requires, transitive, exports, opens, to, uses, provides, with
*/
module jdojo.modules{
	/*
	* Module on which this module depends on
	* If a module wants to access packages from another module, the first module
	* must declare dependence on the second module and the second module must export
	* the package needed in order for them to be accessible to the first module
	* 
	* All 5 types of module statements are used for 2 purposes:
	*	- Express availability of types 
	*		- exports
	*		- opens
	*		- provides
	*	- Express dependence of a module to read types made available using the
	*		preceding 3 statements.
	*		- requires
	*		- uses
	*/
	/*
	* If a module reads another module, the first module needs to have a "requires" statement
	* in its declaration
	* Structure:
	*	requires [transitive] [static] <module.name>
	*
	*	- transitive: implies that a module that reads the current module implicitly also reads the module specified <module.name>
	*	- static: dependence on <module.name> is mandatory at compile-time, but optional at runtime.	
	*
	* Example: 
	*
	*/
	// Optional. Compiler add the statement "java.base" for you
	requires java.base;

	// Required at compile-time and runtime
	requires java.utils.Math;

	/* OPTIONAL MODULE AT RUNTIME
	* Optional dependency example
	* You can write code a specific module and use an optional 
	* module as fallback if the first one is not available.
	* The code for the first module must be placed before the code 
	* for the fallback module 
	*/
	// Required at compile-time but optional at run-time
	requires static  java.utils.Math.PI;

	/*
	* Optional dependency example
	* Java Runtime ignore non-existent annotation. However, module 
	* dependencies are checked at startup so that if a module is missing
	* at runtime, the application won't start.
	*/
	requires static jdojo.annotation;

	
	// Required at compile-time and run-time
	// and module using exported package from the current module 
	// can access the module specified in the "require transitive" statement
	requires transitive jdojo.sample.address;

	

	/*
	* By default, a package in a module is only accessible within the same module.
	* If a package of a module need to be accessible from outside, 
	* the module must use one of the statement below to make available module or package 
	*/

	// exports module to all other modules
	exports com.jdojo.modules.Modules;



	/*
	* exports module to specific modules or packages
	* Structure:
	*	exports <package.name> to <comma.separated.list.of.module>
	*
	* Here, we exports a package to only two modules. Using qualified exports
	* allow to make some modules accessible for use by other modules and
	*  
	*/
	exports com.jdojo.common.Address to jdojo.constructor, jdojo.classes;
	

	
	/* USE AND PROVIDES STATEMENT
	* The "use" and "provides" statement are used to express service
	* consumption and service provision respectively
	* 
	*
	*/

	/*
	* The "uses" statement is used to declare a service the service interface
	*/
	uses java.sql.Driver;

	/*
	* Provides to any module,  the class interface  "com.jdojo.util.parser.FasterCsvParser"
	* as an implementation for the service interface "com.jdojo.util.CsvParser"  
	*/
	provides com.jdojo.util.CsvParser with com.jdojo.util.parser.FasterCsvParser ;

	provides com.jdojo.common.Job with com.jdojo.modules.JobImpl;

}