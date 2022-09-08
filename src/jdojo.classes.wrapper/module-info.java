/*
* Command:
*	Compile: 
*		javac -p mod -d mod/jdojo.classes.wrapper src/jdojo.classes.wrapper/module-info.java src/jdojo.classes.wrapper/com/jdojo/classes/wrapper/* src/jdojo.classes.wrapper/com/jdojo/classes/common/* -Xdiags:verbose -Xlint:unchecked
*	Packaging: 
*		jar -cvf lib/com.jdojo.classes.wrapper.jar -C mod/jdojo.classes.wrapper .
*	Run : 
*		java -p lib -m jdojo.classes.wrapper/com.jdojo.classes.wrapper.<class-name>
*/
module jdojo.classes.wrapper{
	exports com.jdojo.classes.wrapper;
}