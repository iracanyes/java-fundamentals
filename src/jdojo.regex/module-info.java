/*
* A regular expression si a way to describe a pattern in a sequence of characters;
* The pattern may be used to:
*	- validate the sequence of characters
*	- search throught the sequence
*	- replace the sequence that match the pattern with other sequence of characters
*
*
* Commands:
*	Compile:
* 		javac -p mod -d mod/jdojo.regex src/jdojo.regex/module-info.java src/jdojo.regex/com/jdojo/regex/*  -Xdiags:verbose -Xlint:unchecked 
*	Package:
*
*	Run:
*
*/
module jdojo.regex{
	exports com.jdojo.regex;
}