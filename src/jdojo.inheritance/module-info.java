/* INHERITANCE
*
* Inheritance
* When the same functionality are need by different class of your application,
* inheritance will allow a class to inherit of the same functionality of the another class.
* A class will be able to share its functionality with other classes.
*
* The class that inherit of the functionality of the other class is called a subclass
* and the other is called the parent class (also called super class or base class).
* The relation between super class and subclass is called "is-a" relationship.
*
* In order to know if an object of class Q should inherit of an object of class P
* The question to ask is:
*   - "Is an object Q also an object of P?"
*   - Does an object of class Q behaves like an object of class P?
* Command:
*   Compile:
*       javac -p mod -d mod/jdojo.inheritance src/jdojo.inheritance/module-info.java src/jdojo.inheritance/com/jdojo/inheritance/* src/jdojo.inheritance/com/jdojo/common/* -Xdiags:verbose -Xlint:unchecked
*   Packaging:
*       jar -cvf lib/com.jdojo.inheritance.jar -C mod/jdojo.inheritance .
*   Run:
*       java -p lib -m jdojo.inheritance/com.jdojo.inheritance.<class-name>
*/
module jdojo.inheritance{
    exports com.jdojo.inheritance;
}
