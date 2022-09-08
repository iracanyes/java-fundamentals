package com.jdojo.classes;
/*
* Class access level : 
*	- public 
*		- public only within the defining module (anywhere in the module)
*		  	=> public class modifier but no module export declaration
*		- public only to specific module and within the defining module
*			=> public class modifier but module use qualified export declaration
*		- public to every module
*			=> public class modifier and module export the package of the class
*	- package-level(default => no access modifier)
*/
public class AccessLevelClassMembers{
	/*
	* ACCESS LEVEL CLASS MEMBERS
	*
	* Access level modifiers can be specified for both instance and class members of a class;
	*
	* There is 4 access level for class members:
	*	
	*	Access level 				Access level modifier
	*		public 						public
	*		private						private
	*		protected					protected
	*		package-level(default)		no access modifier
	*
	* Structure:
	* 	<access-level-class-member> <static-modifier> <data-type> <identifier>;
	*
	*/
	/*
	* Public Access
	* Class member can be accessed from anywhere, provided the class itself is accessible
	*/
	public String publicVar;
	/*
	* Private Access modifier
	* Can only be used within the body of the declaring class, and nowhere else.
	*/
	private String onlyAccessFromClassBody;
	/*
	* Protected Access modifier
	* Can only be accessed from same package or descendant class
	*/
	protected String accessFromSamePackageOrDescedentClass;

	/*
	* Package level modifier (no modifier)
	* Can only be accessed from same package 
	*/
	String accessFromSamePackage;
}