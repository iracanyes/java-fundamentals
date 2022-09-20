/*
* Abstract class and mehods allow to represent a concept rather than represent objects.
* Java lets you create a class whose object objects cannot be created.
* Its purpose is to represent an idea, which is common to objects of other classes.
* Such classes are called "abstract" class. You can define them using the keyword "abstract"
* A "concrete" class are class whose objects can be created.
*
* An abstract class may have concrete methods, abstract methods.
* An abstract method is an incomplete method.
* It cannot be used unless the class extending the abstract class redefine it.
* The compiler will throw an error if an abstract method isn't redefined by the class
* extending the abstract class.
*
* Abstract classes guarantees the use of inheritance, at least theorically.
* Rules for abstract class:
*   #1 Abstract class cannot be declared final
*   #2 Abstract class should not declare all constructors private
*   #3 Abstract method cannot be declared static or private
*   #4 Abstract method cannot be declared native, strictfp or synchronized
*       - native keyword denotes that a method is implemented a native code (opposed to Java code).
*       - strictfp keyword denotes that the code inside a method use FP-strict rules for floating-point computations.
*       - synchronized keyword denotes that the object on which the method is invoked must be locked by the thread before
*           it can execute method's code.
*   #5 An abstract method in a class can override an abstract method in its superclass without providing an implementation.
*       the subclass may refine the return type or exception list of the overriden abstract method.
*        Ex:
*        public abstract class A{
*            public abstract void m1() throws CE1, CE2;
*        }
*
*        public abstract class A{
*            public abstract void m1() throws CE1;
*        }
*
*        public abstract class A{
*            public void m1(){
*                // Code goes here
*            }
*        }
*   #6 A concrete instance method may be overriden by an abstract instance method.
*       This can be done to force subclasses to provide implementation of that method.
*       Ex: Force subclasses to re-implement methods hashCode(), equals(), toString()
*       public abstract class CA{
*           protected abstract int hashCode();
*           protected abstract String toString();
*           protected abstract boolean equals(Object obj);
*       }
*/
package com.jdojo.inheritance;

public class AbstractClassesAndMethods {
    public static void main(String[] args) {
        Square sq1 = new Square("Square", 12, 12);
        Rectangle rect1 = new Rectangle("Rectangle", 12, 5);

        rect1.draw();
        sq1.draw();

        Shape sh1 = new Square("Square", 12, 12);

        // You cannot create an object of abstract class
        // Shape sh2 = new Shape();
    }
}

/*
* Abstract class can declare public constructor even thought it cannot be called
*/
abstract class Shape{
    private String name;

    public Shape(){
        this.name = "Unknown shape";
    }

    public Shape(String name){
        System.out.println("Inside Shape constructor.");
        // Add the code for your constructor
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    // If a class declare or inherite an abstract method and doesn't redefine it,
    // the class must be declared abstract
    // The body of an abstract method is declared using ; (semicolon)
    // All classes that extends this class, must implement the method draw();
    // Compiler will throw an error if a subclass doesn't implement the method
    public abstract void draw();

    public abstract double getArea();

    public abstract double getPerimeter();
}

/*
* If the Rectangle class doesn't implement the abstract method draw() an error is thrown by the compiler
* error:  Rectangle is not abstract and does not override abstract method draw() in Shape
*
* Rectangle class must override all abstract methods of abstract class Shape
* in order to be considered a concrete class whose objects can be created.
* Otherwise, it's considered as an incomplete class which means an abstract class
* and therefore must be declared abstract.
*/
class Rectangle extends Shape{
    private double width;
    private double height;

    public Rectangle(String name, double width, double height){
        this.setName(name);
        this.width = width;
        this.height = height;
    }

    public double getWidth(){
        return this.width;
    }

    public void setWidth(){
        this.width = width;
    }

    public double getHeight(){
        return this.height;
    }

    public void setHeight(double height){
        this.height = height;
    }

    @Override
    public void draw(){
        System.out.println("Inside Rectangle.draw() method.");
        for(int i = 0; i < width; i++){
            System.out.printf("_");
        }
        System.out.println();
        for(int k = 0; k < ((int) height / 2); k++){
            System.out.printf("|");
            for(int j = 0; j < width; j++){
                System.out.printf(" ");
            }
            System.out.printf("|\n");
        }
        for(int i = 0; i < width; i++){
            System.out.printf("_");
        }
        System.out.println();
    }

    @Override
    public double getArea(){
        double result = 0;
        result = width * height;
        return result;
    }

    @Override
    public double getPerimeter(){
        double result = 0;
        result = (width + height) * 2;
        return result;
    }
}

/*
* If the Square doesn't implement the abstract method draw() an error is thrown by the compiler
* error: Square is not abstract and does not override abstract method draw() in Shape
*/
class Square extends Rectangle{
    public Square(String name, double width, double height){
        super(name, width, height);
    }
}
