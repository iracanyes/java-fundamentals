/*
* Java 5 introduced the concept of generic types.
* Java 5 lets you declare generic methods.
* When the code with generic types is compiled,
* the generic type are transformed into raw types.
* The process used to transform the generic type parameters information
* is known as type erasure.
*
* The rules for checking for override equivalent method signature is that if a method
* use generic parameters, you need to compare its erasure, not the generic version of its declaration.
*/
package com.jdojo.inheritance;

public class MethodOverridingAndGenericMethodSignatures {
    public static void main(String[] args) {
        GenericSuper gSuper = new GenericSuper();
        GenericSub gSub = new GenericSub();

        
    }
}

/*
When the GenericSuper class is compiled, the erasure transforms the code during the compilation to the resulting following code :
public class GenericSuper{
    public void m1(Object a){

    }

    public void m2(Car a){

    }
}
*/
class GenericSuper<T>{
    // m1() uses the generic type T as its parameter type.
    public void m1(T a){

    }

    public <P extends Car> void m2(P a){

    }
}

class GenericSub extends GenericSuper{
    @Override
    public void m1(Object a){

    }

    @Override
    public void m2(Car a){

    }
}
