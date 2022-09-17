package com.jdojo.array;

import java.util.Arrays;

public class ArraysStream {
    public static void main(String[] args) {
        String[] copyFrom = {
            "Affogato", "Americano", "Cappuccino", "Corretto", "Cortado",
            "Doppio", "Espresso", "Frappucino", "Freddo", "Lungo", "Macchiato",
            "Marocchino", "Ristretto" };
        /*
        * Create a stream that uses an arrays as its source.  allow to manipulate easily arrays.
        */
        Arrays.stream(copyFrom)
                .map(coffee -> coffee + " ")
                .forEach(System.out::print);
    }
}
