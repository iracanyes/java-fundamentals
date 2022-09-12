/*
* Command:
*	Compile:
*		javac -p mod -d mod/jdojo.format.data src/jdojo.format.data/module-info.java src/jdojo.format.data/com/jdojo/format/data/* src/jdojo.format.data/com/jdojo/format/formatter/*  -Xdiags:verbose -Xlint:unchecked 
*	Packaging:
*		jar -cvf lib/com.jdojo.format.data.jar -C mod/jdojo.format.data .
*	Run:
*		java -p lib -m jdojo.format.data/com.jdojo.format.data.<class-name>
*
*/
module jdojo.format.data{
	exports com.jdojo.format.data;
}