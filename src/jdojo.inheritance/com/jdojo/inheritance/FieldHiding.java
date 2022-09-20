/*
* A field declaration (static or non-static) in a class hides the inherited field with the same name in its superclass.
* IMPORTANT: The type of the field and its access level are not considered in the case of field hiding.
* Field hiding occurs solely based on the field name.
* Early binding is used for field access.
* The compile-time type of the class is used to bind the field access.
*/
package com.jdojo.inheritance;

public class FieldHiding{
    public static void main(String[] args) {
        FHSuper fhSuper = new FHSuper();
        FHSub fhSub = new FHSub();

        System.out.printf("fhSuper.x : %s%n", fhSuper.x);
        System.out.printf("fhSuper.str :  %s%n", fhSuper.str);
        System.out.printf("fhSuper.y :  %s%n", fhSuper.y);

        // Here you can see that field are hidden based on their name, not their type or access level
        System.out.printf("fhSub.x : %s%n", fhSub.x);
        System.out.printf("fhSub.str :  %s%n", fhSub.str);
        System.out.printf("fhSub.y :  %s%n", fhSub.y);
        fhSub.print();

        System.out.printf("((FHSuper)fhSub).x : %s%n", ((FHSuper)fhSub).x);
        System.out.printf("((FHSuper)fhSub).str :  %s%n", ((FHSuper)fhSub).str);
        System.out.printf("((FHSuper)fhSub).y :  %s%n", ((FHSuper)fhSub).y);

        fhSuper = fhSub;

        System.out.printf("fhSuper.x : %s%n", fhSuper.x);
        System.out.printf("fhSuper.str :  %s%n", fhSuper.str);
        System.out.printf("fhSuper.y :  %s%n", fhSuper.y);

    }
}

class FHSuper{
    protected int x = 100;
    protected String str = "Hello from FHSuper";
    protected double y = 22.1;

}

class FHSub extends FHSuper{
    public int str = 10;                        // Hides str in FHSuper, no matter the type of str
    protected String x = "Hello from FHSub";    // Hides x in FHSuper
    double y = 2.21;                            // Hides y in FHSuper

    public void print(){
        // Access superclass field hidden, you can use the keyword "super".
        System.out.println("x : " + x);
        System.out.println("super.x : " + super.x);

        System.out.println("str : " + str);
        System.out.println("super.str : " + super.str);

        System.out.println("y : " + y);
        System.out.println("super.y : " + super.y);
    }
}
