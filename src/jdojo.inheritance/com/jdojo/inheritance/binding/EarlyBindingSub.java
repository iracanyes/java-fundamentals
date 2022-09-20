/*
* Here is an EarlyBindingSub class which inherits from EarlyBindingSuper class and
* Has a static field, an instance field and a static method which are the same type
* as in its superclass.
*/
package com.jdojo.inheritance.binding;

public class EarlyBindingSub extends EarlyBindingSuper{
    // Instance variable
    public String str = "Early Binding Sub";

    // Static variable
    public static int count = 200;

    public static void print(){
        System.out.println("Inside EarlyBindingSub.print()");
    }
}
