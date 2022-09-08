/*
* Command:
*	Compile: 
*		javac -p mod -d mod/jdojo.exception src/jdojo.exception/module-info.java src/jdojo.exception/com/jdojo/exception/* src/jdojo.exception/com/jdojo/common/* -Xdiags:verbose -Xlint:unchecked
*	Packaging: 
*		jar -cvf lib/com.jdojo.exception.jar -C mod/jdojo.exception .
*	Run : 
*		java -p lib -m jdojo.exception/com.jdojo.exception.<class-name>
*/
module jdojo.exception{
	exports com.jdojo.exception;
}