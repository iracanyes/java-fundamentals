/*
* the operator instanceof allow to determine whether a reference variable has a reference to an object of a class or subclass of the class at runtime.
* Notation:
*   <reference-variable> instanceof <type-name>
*
* if the reference variable refers to an object of the type <type-name> or any of its descendants,
* instanceof returns true, otherwise it returns false.
* if the reference variable is null, instanceof always return false.
*
* instanceof should be used before a downcasting to check if the reference variable you are trying to downcast is of the type you expected it to be.
*
* At compile time, the compiler checks if it's ever possible for the left hand operand
* to refer to an object of the right hand operand. As the real value will only be known at runtime.
*   Ex:
*       Manager mgr = null;
*       if(mgr instanceof Developer){}  // Compile-time error.
*
* instanceof operator is to compare the runtime type of a reference variable to a type.
* You often end up using this operator in equals() method.
* The method is defined in Object class and it inherited by all classes.
* It takes an object as argument and returns true if the argument and the object on which the method is call are considered equals.
*/
package com.jdojo.inheritance;

public class InstanceOfOperator {
    public static void main(String[] args) {
        Car aCar = Car.getInstance();
        ArmoredCar armedCar = ArmoredCar.getInstance();
        ElectricCar elecCar = ElectricCar.getInstance();
        ElectricCar elecCar2 = ElectricCar.getInstance();
        Car car2 = elecCar;

        /*
        * The statement below indicate a design flaw in a program.
        * As if you add a new subclass of Car, a test like the one below will have to be updated everywhere in you program.
        * The question to ask.
        * Will the code keep working when I add a new class to the existing class hierarchy?
        * If the response is no, you should reconsider the design of the app.
        */
        if(aCar instanceof ElectricCar){
            // Code for Manager
        }else if(aCar instanceof ArmoredCar){
            // Code for ArmoredCar
        }else if(aCar instanceof Car){
            // Code for Car
        }

        isCarInstance(armedCar);
        isCarInstance(elecCar);

        isArmoredCarInstance(armedCar);
        isArmoredCarInstance(elecCar);

        /*
        * After overriding equals() method of the object,
        * you can write your code to compare objects of the Class that declare equals() method.
        * If equals() method is not implemented, only the reference stored in reference variable is compared not the content of the object
        */
        // Compile-time error
        // incomparable types: ArmoredCar and ElectricCar
        //System.out.println("armedCar == elecCar : " + (armedCar == elecCar));
        System.out.println("armedCar.equals(elecCar) : " + armedCar.equals(elecCar));
        System.out.println("elecCar.equals(car2) : " + elecCar.equals(car2));

        // As no method equals() is declared in class ElectricCar,
        // the class use the parent method equals() to compare the electric car
        // equals() method of Car class only compare the model, wheels and color
        // As default object of ElectricCar have the same value   
        System.out.println("elecCar.equals(elecCar2) : " + elecCar.equals(elecCar2));


    }

    public static void isCarInstance(Object aCar){
        if(aCar instanceof Car){
            System.out.println(aCar.getClass().getSimpleName() + " is a subclass of Car");
        }else{
            System.out.println(aCar.getClass().getSimpleName() + " is not a subclass of Car");
        }
    }

    public static void isArmoredCarInstance(Object aCar){
        if(aCar instanceof ArmoredCar){
            System.out.println(aCar.getClass().getSimpleName() + " is a subclass of ArmoredCar");
        }else{
            System.out.println(aCar.getClass().getSimpleName() + " is not a subclass of ArmoredCar");
        }
    }
}
