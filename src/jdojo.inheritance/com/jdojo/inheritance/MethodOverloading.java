/*
* Overloading a method is defining multiple method with the same name in the same class.
* Methods with same name in a class can originate from :
*   - declared methods
*   - inherited methods
*   - combination of both
*
* Overloaded methods MUST have different number of parameter, or different types of parameters or both.
*
* Return type, access level and throws clause are not considered in overloaded methods.
*
* Overloading has nothing to do with inheritance!
* Overloading involves only one class.
*
* It occurs when a class defines more than one method with the same name.
* All methods with the same name, must differ at least in the number of parameters, their types or their order.
*
* Any method (static or non-static) can be overloaded!
*
*/
package com.jdojo.inheritance;

public class MethodOverloading{
    public static void main(String[] args) {
        MethodOverloading mo = new MethodOverloading();

        short s1 = 127;
        short s2 = -128;
        int i1 = 12;
        int i2 = 25;
        double d1 = 23.3562;
        double d2 = 2.003214556E10;
        float f1 = 123.3f;
        float f2 = 1.2f;

        Car car = Car.getInstance();
        ArmoredCar armCar = ArmoredCar.getInstance();
        // here compiler widen short type to int
        mo.add(s1, s2);
        // here compiler widen short type to int
        mo.add(s1, i2);
        // here compiler widen short and float type to double
        mo.add(s1, f2);
        // here compiler widen short type to double
        mo.add(s1, d2);
        mo.add(i1, i2);
        // here compiler widen short type to int
        mo.add(s1, s2);
        // here compiler widen float type to double
        mo.add(f1, f2);
        mo.add(d1, d2);

        mo.test(car);
        mo.test(armCar);

        car = armCar;
        /*
        * Here, the JVM will use test(Car) as reference variable is of type Car even if it stores an object of type ArmoredCar
        */
        mo.test(car);


    }

    public double add(int a, int b){
        System.out.println("Inside add(int a, int b)");
        double s = a + b;
        return s;
    }

    public double add(double a, double b){
        System.out.println("Inside add(double a, double b)");
        return a + b;
    }

    public void test(Car car){
        System.out.println("Inside test(Car car)");
    }

    public void test(ArmoredCar armCar){
        System.out.println("Inside test(ArmoredCar armCar)");
    }
}
