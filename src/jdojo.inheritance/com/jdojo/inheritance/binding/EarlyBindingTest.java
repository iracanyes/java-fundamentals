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
* In Early binding, the decision about which method code and field will be accessed is made
* by the compiler at compile-timem.
* For a method call, the compiler decides which method from which class will be executed when the caller is executed.
* For field access, the compiler decides which field from which class will be accessed when the caller is executed.
* Early binding is used for the following types of fields and methods of a class :
*   - All types of fields: static and non-static
*   - Static methods
*   - Non-static final methods
*
* In early binding, a method or a field is accessed based on the declared type (or compile-time type) of the variable (or expression) accessing the method the field or method.
* Example:
* If early binding is used for a method call a2.m1(), it will be only if a2 class
* has been declared of type A, the method m1() in class A will be called when a2.m1() is executed.
*
* Fields of EarlyBindingSuper and EarlyBindingSub are of the same type but have different
* value and the method returns a different message to distinguish them at runtime
*/
package com.jdojo.inheritance.binding;

public  class EarlyBindingTest{
    public static void main(String[] args) {
        //
        EarlyBindingSuper ebSuper = new EarlyBindingSuper();
        EarlyBindingSub ebSub = new EarlyBindingSub();

        /*
        * According to early binding rules, the statement:
        *   - ebSuper.str
        *   - ebSuper.count
        *   - ebSuper.print()
        * will always access "str" and "count" fields, and "print()" method of EarlyBindingSub class
        * because you have declared ebSuper of the EarlyBindingSub type.
        * Java always use early binding for fields (static and non-static) and
        * for static methods
        */
        // Will access EarlyBindingSuper.str
        System.out.println(ebSuper.str);

        // Will access EarlyBindingSuper.count
        System.out.println(ebSuper.count);

        // Will access EarlyBindingSuper.print()
        ebSuper.print();

        System.out.println("-----------------------------------------");
        /*
        * According to early binding rules, the statement:
        *   - ebSub.str
        *   - ebSub.count
        *   - ebSub.print()
        * will always access "str" and "count" fields, and "print()" method of EarlyBindingSuper class
        * because you have declared ebSuper of the EarlyBindingSuper type.
        * Java always use early binding for fields (static and non-static) and
        * for static methods
        */
        // Will access EarlyBindingSub.str
        System.out.println(ebSub.str);

        // Will access EarlyBindingSub.count
        System.out.println(ebSub.count);

        // Will access EarlyBindingSub.print()
        ebSub.print();

        System.out.println("-----------------------------------------");

        /*
        * These 3 stateents use an expression to access fields and methods.
        * When you use typecast, the compile-time type of the expression changes.
        *
        * For example, the compile-time type of ebSub is EarlyBindingSub.
        * However, the compile-time type of the expression, (EarlyBindingSuper) ebSub,
        * is EarlyBindingSuper.
        * This is the reason that all of the following expression will access fields and
        * methods from the EarlyBindingSuper class.
        */
        // Will access EarlyBindingSuper.str
        System.out.println(((EarlyBindingSuper) ebSub).str);

        // Will access EarlyBindingSuper.count
        System.out.println(((EarlyBindingSuper) ebSub).count);

        // Will access EarlyBindingSuper.print()
        ((EarlyBindingSuper) ebSub).print();

        System.out.println("-----------------------------------------");

        // Assign the ebSub to ebSuper
        ebSuper = ebSub;    // Upcasting Ok

        /*
        * Now access methods and fields using ebSuper variable,
        * which is referring to a EarlyBindingSub object.
        * Java will access fields and method of EarlyBindingSuper class after upcasting to EarlyBindingSuper class
        */
        // Will access EarlyBindingSuper.str
        System.out.println(ebSuper.str);

        // Will access EarlyBindingSuper.count
        System.out.println(ebSuper.count);

        // Will access EarlyBindingSuper.print()
        ebSuper.print();

    }
}
