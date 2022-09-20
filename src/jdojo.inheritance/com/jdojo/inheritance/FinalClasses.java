/*
* DISABLING INHERITANCE
* You can disable inheritance of a class for futures classes by using the keyword "final"
* when defining a class.
* The "final" keyword is used for declaring constants.
* A final class cannot be subclassed.
* A final method cannot be overriden or hidden by a subclass.
*
* Ex : Security class is a final class therefore it cannot be subclassed
*
*   final class Security{
*        // code
*   }
*
*   // the statement below cause an compile-time error. Security is a final class and cannot be subclassed
*   final class CrackedSecurity extends Security{
*
*   }
*
* String class is an example of final class.
* The reasons for not allowing inheritance of class or overriding/overloading a method are :
*   - security : you don't want someone to inherit from your class and mess with the implementaiton
*   - correctness: you don't want changes in the behavior of your program
*   - performance: a final method may result in better performance at runtime
*/
package com.jdojo.inheritance;

public class FinalClasses{
    public static void main(String[] args) {
        FCSuper fcSuper = new FCSuper();
        FCSub fcSub = new FCSub();

        fcSuper.m1();
        fcSuper.m2();

        fcSub.m1();
        fcSub.m2();

        ((FCSuper)fcSub).m1();
        ((FCSuper)fcSub).m2();


        fcSuper = fcSub;
        fcSuper.m1();
        fcSuper.m2();

    }
}

class FCSuper {
    public final void m1(){
        System.out.println("Inside FCSuper.m1() method");
    }

    public void m2(){
        System.out.println("Inside FCSuper.m2() method");
    }
}

class FCSub extends FCSuper {
    // Compile-time Error m1() cannot be overridden
    // error: m1() in FCSub cannot override m1() in FCSuper
    /*
        public void m1(){
            System.out.println("Inside FCSub.m1() method");
        }
    */

    public void m2(){
        System.out.println("Inside FCSub.m2() method");
    }
}
