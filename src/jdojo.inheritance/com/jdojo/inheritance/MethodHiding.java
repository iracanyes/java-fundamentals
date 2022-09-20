/*
* A class also inherits all non-private static methods from its superclass.
* Redefining an inherited static method in a class is known as method hiding.
* The redefined static methods in a subclass is said to hide the static methods of its superclass
*  All rules about method overriding are applicable with method hiding.
*   - name
*   - access level
*   - return types
*   - exception
* One difference is the binding rule.
* Early binding is used for static methods. Based on the compile-time of the expression,
* the compiler determines what code will be executed at runtime for a static mehtod call.
* Recall that you can use the class name (Class.method()) or the reference variable (var.method()) to invoke a static method.
*
* When a static method is invoked, The compiler binds the static method that is defined (or redefined) in the class.
* If no defined or redefined static method is found in the class,
* the compiler binds the method that the class inherits from its superclass.
* If the compiler doesn't find a defined/redefined/inherited method in the class, it throw an error.
*
* Recall :
*   - a static method cannot hide an instance method of its superclass.
*   - You can always invoke a hidden method inside a class by using the simple or full qualified name of its superclass  
*/
package com.jdojo.inheritance;

public class MethodHiding{
    public static void main(String[] args) {
        MHidingSuper mhSuper = new MHidingSuper();
        MHidingSub mhSub = new MHidingSub();

        System.out.println("#1");

        // Call to static method using the class name
        MHidingSuper.print();                   // Inside MHidingSuper.print()
        // Call to static method using the reference variable
        mhSuper.print();                        // Inside MHidingSuper.print()

        System.out.println("#2");
        MHidingSub.print();                     // Inside MHidingSub.print()
        mhSub.print();                          // Inside MHidingSub.print()
        /*
        * The compile-time type of mbSub is MHidingSub.
        * When using typecast (MHidingSuper), you want mbSub to behave like MHidingSuper reference variable.
        * the compile-time type of the expression ((MHidingSuper) mhSub) change to becomes
        * MHidingSuper.
        * When you invoke print() static method, the compiler binds it to its compile-time type, which is MHidingSuper.
        */
        ((MHidingSuper) mhSub).print();         // Inside MHidingSuper.print()

        System.out.println("#3");
        // Assign a reference of MHidingSub object to a reference variable of type MHidingSuper.
        // At runtime, mhSuper variable refers to an object of type MHidingSub class
        // At compile-time, the compiler binds mhSuper to the type MHidingSuper.
        mhSuper = mhSub;
        // At compile-time, the compiler binds the call mhSuper.print() to the method print()
        // of MHidingSuper
        // When the static method print() is invoked, the JVM looks for the compile-type of mhSuper which is MHidingSuper and call MHidingSuper.print()
        mhSuper.print();                        // Inside MHidingSuper.print()
        // At compile-time, the compile-type of the expression will be MHidingSub.
        // the expression ((MHidingSub) mhSuper).print() will be bound to MHidingSub.print() method
        ((MHidingSub) mhSuper).print();         // Inside MHidingSub.print()
    }
}

class MHidingSuper {
    public static void print(){
        System.out.println("Inside MHidingSuper.print()");
    }
}

class MHidingSub extends MHidingSuper {
    // Here we hide the static method from
    public static void print(){
        System.out.println("Inside MHidingSub.print()");
    }

    public static void callHiddenMethod(){
        // To access a hidden method of a superclass
        // You need to qualify the method with the superclass name
        MHidingSuper.print();
    }
}
