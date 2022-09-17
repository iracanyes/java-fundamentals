/*
* Commands:
*	Compile:
* 		javac -p mod -d mod/jdojo.array src/jdojo.array/module-info.java src/jdojo.array/com/jdojo/array/*.java src/jdojo.array/com/jdojo/common/* src/jdojo.array/com/jdojo/array/operation/*  -Xdiags:verbose -Xlint:unchecked 
*	Package:
*		jar -cvf lib/com.jdojo.array.jar -C mod/jdojo.array .
*	Run:
*		java -p lib -m jdojo.array/com.jdojo.array.<class-name>
*/
module jdojo.array{
  requires jdojo.sample.person;
  requires jdojo.sample.address;

  exports com.jdojo.array;
}
