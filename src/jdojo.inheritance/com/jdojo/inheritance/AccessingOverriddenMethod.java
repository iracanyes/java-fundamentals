/*
* A subclass can use the keyword "super" as a qualifier to call the overridden method of the superclass.
* Object is the highest class in the class hierarchy in Java, it has no superclass.
*/
package com.jdojo.inheritance;

public class AccessingOverriddenMethod{
    public static void main(String[] args) {
        AOSub aoSub = new AOSub();
        aoSub.print();
        /*
        * There is no way to directly call an instance method of the superclass.
        * Only the immediate ancestor can call the overriden method of the superclass using the keyword "super" inside its class definition.
        */
        aoSub.callOverridenPrint();

        AOSubSub aoSubSub = new AOSubSub();
        aoSubSub.useAOSuperMethodPrint();
    }
}

class AOSuper{
    public void print(){
        System.out.println("Inside AOSuper.print()");
    }

}

class AOSub extends AOSuper{
    @Override
    public void print(){
        // Call print() method of AOSuper class
        super.print();

        // Print a message
        System.out.println("Inside AOSuper.print()");
    }

    public void callOverridenPrint(){
        // Call print() method of AOSuper class
        super.print();
    }

}

class AOSubSub extends AOSub{
    /*
    * Inherits AOSub.print() method from AOSub.
    * As the keyword "super" only refers to the direct ancestor of the class using it
    * AOSubSub cannot call a method of class AOSuper directly. Ex: AOSuper.print().
    * But AOSubSub can call a method of class AOSuper which use the method
    * from AOSuper  
    */
    public void useAOSuperMethodPrint(){
        super.callOverridenPrint();
    }
}
