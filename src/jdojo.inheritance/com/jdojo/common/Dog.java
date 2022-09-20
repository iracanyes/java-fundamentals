/*
* 
*/
package com.jdojo.common;

public class Dog extends Animal{
    private String name;
    private int age;

    private Dog(){
        super("Mammals", "Carnivore", "Canine");
        this.name = "Boule";
        this.age = 5;
    }

    public Dog(String name, int age){
        super("Mammals", "Carnivore", "Canine");
        this.name = name;
        this.age = age;
    }

    public static Dog getInstance(){
        return new Dog();
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "[ Specie: " + this.getSpecie() + ", Feed: " + this.getFeed() +", Family: " + this.getFamily() +", Name: "+ this.name + ", Age: " + this.age +"]";
    }
}
