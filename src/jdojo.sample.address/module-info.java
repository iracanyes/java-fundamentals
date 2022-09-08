/*
* Command:
*	Compile: 
*		javac -p mod -d mod/jdojo.sample.address src/jdojo.sample.address/module-info.java src/jdojo.sample.address/com/jdojo/address/*  -Xdiags:verbose -Xlint:unchecked
*	Packaging:
*		jar -cvf lib/com.jdojo.sample.address.jar -C mod/jdojo.sample.address .
*
*/
module jdojo.sample.address{
	// expose publicly com.jdojo.address package to all module
	exports com.jdojo.address;
}