/*
* Command:
*	Compile: 
*		javac -p mod -d mod/jdojo.io src/jdojo.io/module-info.java src/jdojo.io/com/jdojo/io/text/* src/jdojo.io/com/jdojo/io/common/* src/jdojo.io/com/jdojo/io/reader/* src/jdojo.io/com/jdojo/io/stream/* -Xdiags:verbose -Xlint:unchecked
*	Packaging: 
*		jar -cvf lib/com.jdojo.io.jar -C mod/jdojo.io .
*	Run : 
*		java -p lib -m jdojo.io/com.jdojo.io.<class-name>
*/
module jdojo.io{
	requires jdojo.sample.person;
}