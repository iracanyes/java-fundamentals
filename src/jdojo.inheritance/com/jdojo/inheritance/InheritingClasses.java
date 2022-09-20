/*
* Inheritance is one of the core principles of OOP (Object-Oriented Programming)
* It enables to reuse code or extend an existing type.
* A class can inherit from another class (only One) and implements multiple interfaces.
* An interface can inherit from another interface.
* A class can have multiple sub-classes but it has only one superclass.
* A subclass can have its own subclasses.
* Ex: Here's all employee of a company represents in a Class hierarchy
*
*                                 Object
*                                   |
*                                Person
*                                   |
*                               Employee
*                                   |
*                   _____________________________________
*                   |                   |               |
*               Programmer            Clerk         Manager
*                |
*       _____________________________________
*       |                  |               |
*   SysAdmin            DevOps         Developers
*
* A superclass (or parent class) means an ancestor class which is one level up in the inheritance hierarchy
*
* A subclass means a descendant of a class which is one level down in the inheritance hierarchy
* If a class is a descendant of another class, it's also a descendant of the ancestor of that class.
* Ex: All descendant of Employee, are also descendant of Person and Object.
*
* Here is how you define an inheritance in the class definition
* Notation:
*   [modifier] class <subclass-name> extends <superclass-name>{
        // Constructor
*       [modifier] <subclass-name>(){
*           // Must call a constructor of the super class (also called parent class).
*           super(<argument-list>);
*       }
*   }
*
*
*
* DEFAULT SUPERCLASS AND HIERARCHICAL RELATIONSHIP
*
* A class that doesn't extend another class, extends the default super class java.lang.Object.
* All objects in Java inherits from Object class.
* The Object class declares the hashCode() and toString() methods. So all classes in Java inherits of these methods.
*
* Ex: Car class could also be written as follows:
* public class Car extends Object{
*
* }
*
* INHERITED MEMBERS
* A subclass inherits non-private members (public and protected) of its superclass.
* Constructors and Initializers (static and instance) are not members of the class, therefore they are not inherited.
* Members of a class are all members declared inside the body of class and members inherited from its superclass.
* Ex: Employee class inherits all non-private members of Person class and all non-private members of Object class
*
* ACCESS MODIFIERS AND INHERITANCE
*
* Access modifiers are public, private, protected and package-level (no access modifier keyword).
* Access modifiers determines 2 things:
*   - Who can access (or use) that class member directly
*   - Whether a subclass inherits that class member or not
*
* A "private" member of a class is only accessible inside the class that declares it.
*
* A "public" class is accessible from everywhere, provided the class itself is accessible.
* A subclass inherits all public members of its superclass.
*
* A "protected" class member is accessible in the package in which it's declared and inside the body
* of the subclass (which be can be in the same package, in other package or in other module).
* A protected member is inherited by a subclass.
* It's used when you want subclasses to access and inherit the class member
*
* Packge-level modifiers (no access modifier keyword used) is used when you want the class member
* to be accessible only inside the package that declares it.
* Package-level class members is inherited only if the superclass and subclasses are in the same package.
* If both superclass and subclasses are in different package, the subclasses don't inherit package-level members of superclass.
*
* Inheritance guarantees that a behavior present in a class will also be present in its subclasses.
* A method in a class represents a behavior of the objects of that class.
* A subclass guarantees at least the same behavior as its superclass
*
*
*/
package com.jdojo.inheritance;

import java.util.Objects;

/*
* Here we use an example of car retailer which possess different model of car each with its specific caracteristics. How does he represent all its marchandises in a program?
* Using inheritance, we define a general class Car which contains the general caracteristics of all cars (basic features and behavior).
* After we can create some specialized type of class to represents the specialized type of car (electric, armored, truck, etc.)
* These specialized type of Car will inherits the caracteristics of Car class.
*/
public class InheritingClasses {
    public static void main(String[] args) {
        Car car1 = Car.getInstance();
        ArmoredCar armoredCar1 = ArmoredCar.getInstance();
        ElectricCar elecCar = ElectricCar.getInstance();
        System.out.printf("car1: %s%n", Objects.toString(car1));
        System.out.printf("armoredCar1: %s%n", Objects.toString(armoredCar1));
        System.out.printf("electricCar1: %s%n", Objects.toString(elecCar));

        // As ArmoredCar and ElectricCar inherits from Car class
        // Their object can access public and protected instance variable and methods of Car class.
        armoredCar1.setColor("camouflage");
        car1.setColor("white");
        elecCar.setColor("carbon grey");
        String color = elecCar.getColor();

        // Up casting to parent class
        // Assignment from more specific type to a more general type
        // Since the ArmoredCar class inherits from the Car class, an object of ArmoredCar class "is-a" an object of Car class.
        Car car2 = ArmoredCar.getInstance();
        Object objCar = ElectricCar.getInstance();

        car2.setColor("blue");
        System.out.printf("car2: %s%n", Objects.toString(car2));

        /* Down casting to more specific
        * Assignment from a general type to a more specific type.
        * You must cast the more general object declared to subclass. If you forgot to cast, an compile-time error is thrown
        * At compile time, Javac checks that the type of reference variable correspond to the type cast for down casting
        * At runtime, Java checks that the object assigned Car.getInstance() is assignment-compatible with the type cast (ArmoredCar)
        * Whether downcasting from an Object type to another class type depends on the
        * downcasting rule.
        * The statement below will cause the following exception:
        *
        * Exception in thread "main" java.lang.ClassCastException: class com.jdojo.inheritance.Car cannot be cast to class com.jdojo.inheritance.ArmoredCar
        *
        */
        // ArmoredCar armCar = (ArmoredCar) Car.getInstance();
    }
}

class Car{
    private int wheels;
    private final String model;
    private String color;

    /*
    * By defining a private constructor, you prevent from extending this class if no public constructor exists for the class;
    */
    private Car(){
        this.model = "Prototype";
        this.wheels = 4;
        this.color = "white";
    }

    public Car(String model, int wheels, String color){
        this.model = model;
        this.wheels = wheels;
        this.color = color;
    }

    public static Car getInstance(){
        return new Car();
    }

    public String getModel(){
        return this.model;
    }

    public int getWheels(){
        return this.wheels;
    }

    public String getColor(){
        return this.color;
    }

    public void setColor(String color){
        this.color = color;
    }

    @Override
    public boolean equals(Object obj){
        boolean equals = false;

        if(obj instanceof Car){
            Car car = (Car) obj;

            if(
                this.model.equals(car.getModel())
                && this.color.equals(car.getColor())
                && this.wheels == car.getWheels()
            ){
                equals = true;
                return equals;
            }
        }

        return equals;
    }

    @Override
    public String toString(){
        return "{model: " + this.model + ", wheels: " + this.wheels + "}";
    }
}

/*
* To inherit from another class, the class must use the keyword "extends"
* followed by the simple name of the class (if the class is in the package or imported)
* or by the full qualified name of the class.
*/
class ArmoredCar extends Car{
    private int bulletProofWindows;
    private int antiPunctureTyres;

    private ArmoredCar(){
        super("Humvee", 4, "camouflage");
        this.bulletProofWindows = 4;
        this.antiPunctureTyres = 4;
    }

    public ArmoredCar(String model, int wheels, String color){
        super(model, wheels, color);
    }

    public static ArmoredCar getInstance(){
        return new ArmoredCar();
    }

    public void setBulletProofWindows(int bulletProofWindows){
        this.bulletProofWindows = bulletProofWindows;
    }

    @Override
    public String toString(){
        return "{model: "
            + this.getModel()
            + ", wheels: "
            + this.getWheels()
            + ", bulletProofWindows: "
            + this.bulletProofWindows
            + ", antiPunctureTyres: "
            + this.antiPunctureTyres + "}";

    }
}

class ElectricCar extends Car{
    private int electricBatteries;

    // Here we prevent from extending this class
    private ElectricCar(){
        super("Tesla", 4, "carbon grey");
        this.electricBatteries = 2;
    }

    public static ElectricCar getInstance(){
        return new ElectricCar();
    }

    public int getElectricBatteries(){
        return this.electricBatteries;
    }

    public void setElectricBatteries(int electricBatteries){
        this.electricBatteries = electricBatteries;
    }

    @Override
    public String toString(){
        return "{model: " + this.getModel() + ", wheels: " + this.getWheels() + ", electricBatteries: " + this.electricBatteries + "}";

    }
}
