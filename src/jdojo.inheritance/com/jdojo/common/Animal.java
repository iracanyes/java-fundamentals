package com.jdojo.common;

public class Animal {
    private String specie;
    private String feed;
    private String family;

    private Animal(){
        this.specie = "Unknown";
        this.feed = "Unknown";
        this.family = "Unknown";

    }

    public Animal(String specie, String feed, String family){
        this.specie = specie;
        this.feed = feed;
        this.family = family;
    }

    public static Animal getInstance(){
        return new Animal();
    }

    public Animal setSpecie(String specie){
        this.specie = specie;
        return this;
    }

    public String getSpecie(){
        return this.specie;
    }

    public String getFeed(){
        return this.feed;
    }

    public String getFamily(){
        return this.family;
    }

    @Override
    public String toString(){
        return "[ Specie: " + this.specie + ", Feed: " + this.feed +", Family: " + this.family +"]";
    }
}
