/*
* Here is an LateBindingSub class which inherits from LateBindingSuper class and
* Has a static field, an instance field and a static method which are the same type
* as in its superclass.
*/
package com.jdojo.inheritance.binding;

public class LateBindingSub extends LateBindingSuper{
    @Override
    public void print(){
        System.out.println("Inside LateBindingSub.print()");
    }
}
