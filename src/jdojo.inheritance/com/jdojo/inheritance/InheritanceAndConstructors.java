/*
* An object has 2 things : state (instance variable) and behavior (instance methods).
* Each object maintain its own state.
* When an object is created, memory is allocated for all instance variables declared in the class of that object and all its ancestors instance variables at all level.
*
* Constructors are not members of a class therefore there are not inherited.
* They serve to initialize instance variables of the class and of the class ancestors.
*
* For creating an object of a class, we call a constructor of that class.
* Before a call to the constructor of a class is executed, a call to all its ancestor's constructor is made.
* Because when an object is created, memory is allocated for all instance variables in all its ancestor classes.
* Instance variables for all classes must be initialized by calling their constructors.
*
* CONSTRUCTOR INJECTION
* Compiler inject the call to the immediate ancestor's no-args constructor as the first statement
* in every constructor you add to your class.
* The keyword "super" refers to the immediate ancestor of a class.
* super() is call to the immediate ancestor (superclass) constructor.
* If a superclass constructor accepts parameters, you can pass a list of parameters within
*
* Every clas must call the constructor of its superclass from its constructor explicitly or implicitly.
* If the superclass doesn't provide a no-args constructor, you must call any other constructors of the superclass explicitly
*
* CONSTRUCTOR ACCESS LEVEL
* When using classes from other packages and modules, the class and their constructor must be
* accessible if they are in the same module (public, protected or package-level access).
* If the classes are in different modules, the classes and their constructors must be publicly
* accessible (public and protected access level) and the classes or their corresponding packages must be exported from their module.
* The module of the class using those classes must require these modules or those classes explicitly in the module-info.java file  in order to use those classes
*
*/
package com.jdojo.inheritance;

public class InheritanceAndConstructors{
    public static void main(String[] args) {
        /*
        * When the call to the constructor of CSubSub is executed,
        * a call to all its ancestor's constructor CSuper and CSub is made first,
        * and only after the call to the ancestor's constructor of CSubSub are executed,
        * the constructor of CSubSub.
        * The compiler add a default no-args constructor
        * Here the call succeed,
        */
        CSub2 cSub2 = new CSub2();

        CSub2bis cSub2bis = new CSub2bis();

        /*
        * The call to the constructor of the immediate ancestor of CSub4 requires an argument.
        * Here cannot add the default no-args constructor so the call will throw an error.
        *  error: constructor CSub3 in class CSub3 cannot be applied to given types;
        *   public CSub4(){
        *          ^
        *   required: String
        *   found:    no arguments
        *   reason: actual and formal argument lists differ in length
        */
        // CSub4 cSub4 = new CSub4();

         CSub5 cSub5 = new CSub5();
    }
}

class CSuper{
    public CSuper(){
        System.out.println("Inside CSuper() constructor.");
    }
}

class CSub extends CSuper{
    public CSub(){
        // Compiler add automatically a default no-args constructor when compiling.
        // If the superclass constructor requires argument, the compiler will throw an error.
        // super();
        System.out.println("Inside CSub() constructor.");
    }
}

class CSub2 extends CSub{
    public CSub2(){
        // Compiler add automatically a default no-args constructor when compiling.
        // If the superclass constructor requires argument, the compiler will throw an error.
        // super();
        System.out.println("Inside CSub2() constructor.");
    }
}

class CSub2bis extends CSub2{
    /*
    * Here the compiler inject a default constructor with a default no-args superclass constructor call
    *   public CSub2bis(){
    *        super();
    *   }
    */

}

class CSub3 extends CSub2{
    private String name = "Unknown";
    public CSub3(String name){
        System.out.println("Inside CSub3() constructor.");
        this.name = name;
    }

}

/*
* Compiler add automatically a default no-args constructor when compiling.
* If the superclass constructor requires argument, the compiler will throw an error.
* Here as CSub3 constructor requires a String argument. an error is thrown
*
*     error: constructor CSub3 in class CSub3 cannot be applied to given types;
*        public CSub4(){
*                      ^
*      required: String
*      found:    no arguments
*      reason: actual and formal argument lists differ in length
*
* To avoid this error, you have multiple way to solve this:
*   - add a no-args constructor inside CSub3
*   - add a call to superclass constructor
*/
/* These 2 classes will never compile
*   class CSub4 extends CSub3{
*       public CSub4(){
*           // defaut no-args constructor injected by compiler
*           // super();
*           System.out.println("Inside CSub3() constructor.");
*       }
*   }
*
*   class CSub5 extends CSub4{
*
*        // Here the compiler add a default constructor for the class
*        // with a default no-args constructor for the superclass
*        // public CSub5(){
*        //    super();
*        // }
*        //
*
*   }
*/
class CSub4 extends CSub3{
    public CSub4(){
        // You must explicitly call the superclass constructor with the corresponding argument
        // if a no-args constructor isn't declared in superclass
        super("Hello");
        System.out.println("Inside CSub4() constructor.");
    }

    public CSub4(String name){
        super(name);
        System.out.println("Inside CSub4() constructor.");
    }
}

class CSub5 extends CSub4{

}

/*
*
*/
