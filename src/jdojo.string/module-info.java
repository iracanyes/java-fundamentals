/*
* Command:
*	Compile: 
*		javac -p mod -d mod/jdojo.string src/jdojo.string/module-info.java src/jdojo.string/com/jdojo/string/* -Xdiags:verbose -Xlint:unchecked
*	Packaging:
*		jar -cvf lib/com.jdojo.string.jar -C mod/jdojo.string .
*	Run:
*		java -p lib -m jdojo.string/com.jdojo.string.<class-name>
*/
module jdojo.string{
	exports com.jdojo.string;
}