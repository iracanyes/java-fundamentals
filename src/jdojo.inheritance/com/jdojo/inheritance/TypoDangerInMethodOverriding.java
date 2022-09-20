/*
* Sometimes it's easy to get it wrong when you try to override a method.
* The intent was that m1() method in class C2 overrides the m1() method of class C1.
* However, it a case of method overloading, not method overriding.
* The m1() method of class C2 is overloaded.
* m1(double num) is inherited from class C1 and m1(int num) is declared in C2
*/
package com.jdojo.inheritance;

public class TypoDangerInMethodOverriding{
    public static void main(String[] args) {
        C1 c = new C2();
        C1 c3 = new C3();
        /*
        * It found that the compile-time type of c is C1
        * It look for a method m1() in C1 which takes an int as argument
        * As nothing is found, it tries type-widening to double for the argument,
        * and looks for m1(double) in C1 and found C1.m1(double).
        * the compiler binds the method signature to the method call.
        * The method code is bound at runtime because m1() is an instance method.
        * The compile code is :
        *   12: invokevirtual #14; // Method com/jdojo/inheritance /C1.m1:(D)V
        * V means void method. D means double argument
        * You can see that the method is bound as C1.m1
        * The JVM will look for a method
        *   void m1(double)
        * It starts at the runtime type of c which is C2, C2 doesn't declare a method
        *  m1(double). the JVM goes one level up in C1 and found a method m1.double()
        */
        c.m1(10);   // Inside C1.m1(): 10.0
        c3.m1(10);
    }
}

class C1{
    public void m1(double num){
        System.out.println("Inside C1.m1(): " + num);
    }
}

class C2 extends C1{
    public void m1(int num){
        System.out.println("Inside C2.m1(): " + num);
    }
}

class C3 extends C1{
    /*
    * The compiler will make sure that the method using the annotation really overrides a method
    * in its superclass or throw an error.
    * The code below generate an error
        @Override
        public void m1(int num){
            System.out.println("Inside C2.m2(): " + num);
        }
    * The code above cause the following error:
    * error: method does not override or implement a method from a supertype
    */
    @Override
    public void m1(double num){
        System.out.println("Inside C3.m1(): " + num);
    }
}

class C4 extends C2{
    /*
    * The compiler will make sure that the method using the annotation really overrides a method
    * in its superclass or throw an error.
    *
    * Here an error is thrown:
    * error: method does not override or implement a method from a supertype
    */
    @Override
    public void m1(int num){
        System.out.println("Inside C4.m1(): " + num);
    }
}
