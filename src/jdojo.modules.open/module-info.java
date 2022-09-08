open module jdojo.modules.open{
	/* OPEN MODULE
	* Using reflection, you can write the code without knowing about
	* the existence of the types from the module "jdojo.modules.open" 
	* The code will not require types from the module at compile-time
	* BUT at runtime, the used types from module will be mandatory
	*
	* RULES
	* 	1. An exported package will allow access to only public types 
	* 	and theirs public/protected members at compile-time and runtime.
	*	If you do not export a package, all types in that package are inaccessible
	*	to other modules. This preserve the strong encapsulation of modules.
	*	
	* 	2. You can open a module to allow deep reflection on all types in all
	*	packages in that module at runtime. The module will be called "open module".
	*
	*	3. A module that is not open for deep reflection can have specific packages
	*	opened for deep reflection at runtime.
	*	All other packages which are not open, are strongly encapsulated.
	* 	Packages allowing deep reflection is called "open package".
	*
	*	4. If you want access to types at compile-time and allowing deep reflection at the same time,
	*	you can export and open the package. 
	*
	* STRUCTURE:
	*	1. Open module:
	*		open module <module.name>{
	*			// Module declaration body
	*		} 
	*	2. Open package:
	*		open <package.name>;
	*	3. Open packge to specific modules:
	*		open <package.name> to <comma-separated-package-or-module.name>
	*
	* When a module M opens package P for deep reflection to another module N,
	* it's possible that the module N grants deep reflective access that it has on package P
	* to another module Q.
	* The module N will need to do it programmatically using the module API.
	* Delegating reflective accesss to another module avoids opening the entire module to all other modules,
	* Look in module "jdojo.string" for an example. 
	*/
	// Here, we open package "com.jdojo.modules.open" from the current module for deep reflection
	// to any module which need public types at runtime.
	opens com.jdojo.modules.open;

	// Here, we open package "com.jdojo.modules.open" from the current module for deep reflection
	// to only specific modules which need public types at runtime.
	opens com.jdojo.modules.open to jdojo.sample.person, jdojo.sample.address;

	/*
	* CONFLICT WHEN SPLITTING PACKAGE IN DIFFERENT MODULE
	* If 2 modules A and B define the same package P, there must not exist a module Q
	* such that the package P in both M and N modules is accessible to module Q
	*
	* Example: 
	* 	Test.java
	* 	package java.util;
	*	
	*	public class Test{
	*
	*	}
	* Java allow access to package "java.util" from module "java.base" to all and it opens it
	* for deep reflection.
	* As module "java.base" is added automatically to module declaration,
	* declaring  a  package "java.util"
	* will generate a conflict as "java.base" exports a module "java.util"
	* 
	*/

}