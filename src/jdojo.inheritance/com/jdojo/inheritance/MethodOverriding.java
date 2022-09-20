/*
* METHOD OVERRIDING
* Redefining an instance method in a class, which is inherited from the superclass,
* is called "overriding".
* When a class overrides a method, it affects the class itself and its descendants.
*
* METHOD OVERRIDING RULES
*   #1 The method must be an instance method.Overriding does not apply to static methods.
*   #2 The overriding method must have the same name as the overridden method.
*   #3 The overriding method must have the same number of parameters of the same type in the same order as the overridden method.
*       The name of the arguments doesn't matter.
*       If a generic type in the method arguments, JVM doesn't consider it when comparing method to if one overrides another.
*   #4 Before Java 5, the return type of the overriding method and the overridden method must be the same.
*       In Java 5, the rule remains the same for the return type of primitive data types.
*        For returns type of reference data types, the return type of the overriding method must be assignment-compatible with the return type of the overridden method.
*       Ex: a class has a method definition of R1 m1() which is overridden by a method definition R2 m1().
*           this method overriding is allowed only if an instance of R2 is assignment-compatible to a variable of R1 type without any typecast
*   #5 The access level of the overridding method must be the at least the same or more relaxed than that of the overridden method.
*       The list from the most relaxed to the most strict is public > protected > package-level.
*       Racall that private members are not inherited.
*           Overridden method access level          Allowed Overriding method access level
*           - public                                public
*           - protected                             public, protected
*           - package-level                         public, protected, package-level
*
*   #6 A method may include a list of checked exceptions in its "throws" clause.
*       The overriding method cannot add a new exception to the list of exceptions in the overridden method.
*       It allowed to remove one or all exception. It's also allowed to replace an exception by one of its descendant.
*
* To summarize the rules of overriding :
*   - Name of the method
*   - Number of parameters
*   - Type of parameters
*   - Order of parameters
*   - Return type of the method
*   - Access level
*   - List of checked exceptions in the throws clause
*
*/
package com.jdojo.inheritance;

public class MethodOverriding{
    public static void main(String[] args) {
        A a = new A();
        a.print();      // will print A

        a = new B();
        a.print();      // will print B

        a = new C();
        a.print();      // will print B

        a = new D();
        a.print();      // will print B

        a = new E();
        a.print();      // will print E

        a = new F();
        a.print();      // will print E
    }
}

class A{
    public void print(){
        System.out.println("A");
    }
}

class B extends A{
    /*
    * Class B inherits the print() method from its superclass A and redefines it.
    * It's said that the print() method in class B overrides the print() method of class A.
    *
    */
    @Override
    public void print(){
        System.out.println("B");
    }
}

class C extends B{
    // C inherits B.print() through B
}

class D extends C{
    // D inherits B.print() through C
}

class E extends D{
    // E uses its own version of print() method
    @Override
    public void print(){
        System.out.println("B");
    }
}

class F extends E{
    // F inherits E.print() through E

    /*
    * Here, we overloads the method print() without overriding print() method of its superclass.
    * Now, class E contains 2 methods print()
    *   - one inherited from its superclass, which takes no argument
    *   - one declared in it, which takes a String argument
    */
    public void print(String msg){
        System.out.println(msg);
    }
}
