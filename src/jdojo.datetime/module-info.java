/*
* The Date-Time API makes a distinction between how dates and times are used by machines and humans.
* It has a separate set of classes to deal with machine-based time and
* calendar-based human time.
* It lets you convert machinde-based time to human-based time and vice versa.
*
* When you write new code, use the new Date-Time API classes.
* When you receive objects of legacy classes as input, convert the legacy objects
* into new datetime objects, and use the new Date-Time API.
* 
* The new Date-Time API consists of mostly immutable classes.
* The new Date-Time API is extensible, you're advised to create immutable classes, if possible, to extend the API.
* Operations on datetime objects creates a new datetime object,
* which allow the chaining of methods.
* Classes of Date-Time API do not provide constructors;
* 
*/
/*
* Command:
*	Compile:
*		javac -p mod -d mod/jdojo.datetime src/jdojo.datetime/module-info.java src/jdojo.datetime/com/jdojo/datetime/scale/human/* src/jdojo.datetime/com/jdojo/datetime/scale/machine/* src/jdojo.datetime/com/jdojo/datetime/*.java  -Xdiags:verbose -Xlint:unchecked 
*	Packaging:
*		jar -cvf lib/com.jdojo.datetime.jar -C mod/jdojo.datetime .
*	Run:
*		java -p lib -m jdojo.datetime/com.jdojo.datetime.<class-name>
*/
module jdojo.datetime{
	exports com.jdojo.datetime;
}