/*
*
* Command :
*	Compile all:
*		javac -p mod -d mod/jdojo.object src/jdojo.object/module-info.java src/jdojo.object/com/jdojo/common/* src/jdojo.object/com/jdojo/object/*
*	Packaging:
*		jar -cvf lib/com.jdojo.object.jar -C mod/jdojo.object . --module-path mod
*/
module jdojo.object{
	requires jdojo.sample.person;


	exports com.jdojo.object;
}