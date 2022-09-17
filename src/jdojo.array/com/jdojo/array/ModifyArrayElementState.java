package com.jdojo.array;

import com.jdojo.common.Dog;

public class ModifyArrayElementState{
    public static void main(String[] args) {
        Dog[] myDogs = {Dog.getInstance(), Dog.getInstance()};

        System.out.println("Before method call #1: " + myDogs[0]);
        System.out.println("Before method call #2: " + myDogs[1]);

        tryChangeState(myDogs);

        System.out.println("After method call #1: " + myDogs[0]);
        System.out.println("After method call #2: " + myDogs[1]);
    }

    public static void tryChangeState(Dog[] dogs){
        if(dogs != null && dogs.length > 0){
            dogs[0].setName("Max");
        }
    }
}
