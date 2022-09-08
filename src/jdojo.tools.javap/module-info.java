module jdojo.tools.javap{
	/*
	* JAVAP	- Disassemble package tool
	*
	* Allow to manipulate compiled package information
	*
	*/
	/*
	* Disassemble .class file
	* Allow to read info about compiled class file.
	* Command : 
	*	Using class path with dependencies:
	*		javap --module-path lib --module jdojo.intro com.jdojo.intro.Welcome
	*	Using JAR URL scheme : 
	*		- On Windows: 
	*			javap jar:file:libcom.jdojo.intro.jar!/module-info.class
	*		- Unix : ?
	*		 
	*/
	/*
	* Disassemble system module
	* System module like java.base or java.sql 
	* can be disassemble to read .class file info
	* 	Command:
	*		- Accessing module declaration
	*			javap --module java.base java.lang.Object
	*			javap jrt:/java.sql/module-info.class
	*		- Accessing system class using JRT scheme:
	*			javap jrt:/java.se/java.lang.Object
	*/
}