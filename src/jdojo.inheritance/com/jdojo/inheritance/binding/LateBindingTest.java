/*
* BINDING
* Binding is the process of identifying the accessed field or method's code which
* will be used when the code is executed.
* Binding is a process of making decision, which method's code or field will be accessed.
*
* When the binding occurs at compile-time, it's called "early binding".
* It's also known as "static binding or compile-time binding".
*
* When the binding occurs at runtime, it's called "late binding"
* It's also known as "dynamic binding" or "runtime binding"
*
* Late binding is used for the following elements of a class
*   - All non-static methods
*   - All non-final methods
*
* If a code accesses a non-static method which is not declared final,
* the decision as to which version of the method is called is made at runtime.
* The version of the method that will be called depends on the runtime type of the object on which the method call is made, not on its compile-time type.
*
* At runtime, the JVM decides which print() method should be called.
* JVM get the runtime type of lbSuper which is LateBindingSub.
* the JVM traverse up the class hierarchy tree starting from the runtime type which is LateBindingSub, looking for until it find the method signature.
* LateBindingSub declares a method signature corresponding to the one wanted by JVM. it will use it.
* If no method is found in LateBindingSub, JVM moves one level up in the hierarchy, to LateBindingSuper class and look for the method signature.
* Once the JVM find a match, it binds the call to that method and stop the search.
* Recall that Object class is always at the top of all class hierarchies in Java.
* The JVM continue it search for a method definition up to the Object class.
* If it doesn't find a match in Object class, it throw a runtime exception
*
*/
package com.jdojo.inheritance.binding;

public  class LateBindingTest{
    public static void main(String[] args) {
        //
        LateBindingSuper lbSuper = new LateBindingSuper();
        LateBindingSub lbSub = new LateBindingSub();


        /*
        *  The compiler performs only one check, it makes sure that the declared type of lbSuper, which is LateBindingSuper, has a method called print().
        * It detects that the method found is not static or final.
        * And leaves the binding to the runtime.
        *
        * At runtime, JVM decides which method print()  should be called.
        * it depends on the object to which lbSuper variable is referring to at that point in time.
        *
        * Recall that a reference variable of a class type may also refer to an object
        * of any of its descendant.
        *
        * The JVM looks for the method print() in the runtime type which is LateBindingSuper. it find it and binds it to the call and stop searching.
        */
        // Will access LateBindingSuper.print()
        lbSuper.print();

        System.out.println("-----------------------------------------");


        // Will access LateBindingSub.print()
        lbSub.print();

        System.out.println("-----------------------------------------");

        /*
        * When you use a typecast such as the statement below, the object which
        * lbSub refers to at runtime does not change.
        * Using a typecast, all you say is that you want to use the object to which lbSub variable
        * refers as an Object of LateBindingSuper type.
        * However, the object itself never change.

        */
        // Will access LateBindingSuper.print()
        ((LateBindingSuper) lbSub).print();

        // Here, we can see that when Upcasting, the object never change.
        // We only say that we want to use it as it was an object of the LateBindingSuper class.
        String s1 = lbSub.getClass().getName();
        String s2 = ((LateBindingSuper)lbSub).getClass().getName();
        System.out.printf("lbSub.getClass().getName() : %s%n", s1);
        System.out.printf("((LateBindingSuper)lbsub).getClass().getName() : %s%n", s2);


        System.out.println("-----------------------------------------");
        /*
        * When this statement is executed, the reference variable lbSuper starts
        * referring to an object of LateBindingSub object.
        *
        */
        // Assign the lbSub to lbSuper
        lbSuper = lbSub;    // Upcasting Ok

        /*
        * When the statement is executed, the reference variable lbSuper refers to
        * an object of type LateBindingSub. JVM starts looking for the method print()
        * in the class LateBindingSub moves up if nothing found.
        * If it find the method signature corresponding to print() method, it bind the method to the call and stop searching.
        */
        // Will access LateBindingSuper.print()
        lbSuper.print();

    }
}
