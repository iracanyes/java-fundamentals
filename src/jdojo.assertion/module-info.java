/*
* By default Java runtime doesn't execute Assert statements. 
* The goal in using assertion is to detect logic errors in programs.
* 
*  Commannd Enable/Disable assertions: 
*	- Enable assertion: (-ea ou -enableassertions)
*		java -ea -p lib -m jdojo.assertion/com.jdojo.assertion.AssertTest
*	- Disable assertion: (-ea ou -disableassertions):
*		java -da -p lib -m jdojo.assertion/com.jdojo.assertion.AssertTest
*	- Enable System assertions (-esa ou -enablesystemassertions):
*		java -esa -p lib -m jdojo.assertion/com.jdojo.assertion.AssertTest
*	- Disable  System assertion: (-dsa ou -disablesystemassertions):
*		java -da -p lib -m jdojo.assertion/com.jdojo.assertion.AssertTest	
* 
* You can combine the disable and enable options.
* Ex: java -ea:jdojo.assertion... -dsa -da:com.jdojo.common lib -m jdojo.assertion/com.jdojo.assertion.AssertTest
* 
* When you enable/disable assertions, you can pass an argument to control the level
* at which assertions should be enabled/disabled.
* You can enable/disable assertions in all user-defined classes, all system classes, all classes 
* in a package and its sub-packages, or just for one class.
* Command option signature:
*	-ea:<argument>
*	-da:<argument>
* System assertions cannot receive argument '-esa' and '-dsa'
*
* If no arguments are passed, assertions are disabled/enabled in all user-defined class.
*	- packageName... :
* 		If packageName... is passed as argument, it disable/enable assertions in the package 
* 		and in any of its subpackage.(Important to note the 3 dots after the package name!)
* 		The "packageName..." notation can be used to enable/disable system package. 
* 	-	... : 
*		Enable/disable assertions in the unnamed modules in the current working directory
*	- className : 
*		Enable/disable assertions in the specified class.
*		This notation can be used to enable/disable assertions for system classes
* 
* If you use an IDE as NetBeans, Jetbrains,etc to run your class, You must specify "-ea" options in your virtual machine options
* to enable assertions.  
*
* Assertions for a class are enabled/disabled when the class is loaded. 
* The assertion status for a class cannot be changed after it's set.

*/
/*
* Command: 
*	Compile:
*		javac -p mod -d mod/jdojo.assertion src/jdojo.assertion/module-info.java src/jdojo.assertion/com/jdojo/assertion/* -Xdiags:verbose -Xlint:unchecked
*	Packaging:
*		jar -cvf lib/com.jdojo.assertion.jar -C mod/jdojo.assertion .
*	Run with assertions disabled: 
*		java -p lib -m jdojo.assertion/com.jdojo.assertion.AssertTest
*	Run with assertions enabled: 
*		java -ea -p lib -m jdojo.assertion/com.jdojo.assertion.AssertTest
*/
*/
module jdojo.assertion{
	exports com.jdojo.assertion;
}