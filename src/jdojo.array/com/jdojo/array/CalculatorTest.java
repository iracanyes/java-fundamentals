/*
* If one of the character used for operator is used as alias or special character in the command-line.
* You must escape them.
* Ex: division / => // (Unix)
*               / => "/" (Windows)
* Ex: multiplication * => "*" (Windows prompt) but on Git bash no solution found. Changed operator to x
*
* java -p lib -m jdojo.array/com.jdojo.array.CalculatorTest 12 * 0
*   [12, README.md, lib, mod, src, test, 0]
* java -p lib -m jdojo.array/com.jdojo.array.CalculatorTest 12 "*" 0
    [12, .git, .gitignore, lib, mod, README.md, src, test, 0]
*/
package com.jdojo.array;

import java.util.Arrays;

public class CalculatorTest{
    public static void main(String[] args) {
        // Print the list of command-line arguments
        System.out.printf("CalculatorTest arguments: %s%n ", Arrays.toString(args));

        // Ensure to receive 3 arguments
        // the second argument must express an operator which means it must have only one character
        if(args.length < 3 && args[1].length() != 1){
            printUsage();
            return;
        }

        // Parse the 2 number operands
        double d1, d2;
        try{
            d1 = Double.parseDouble(args[0]);
            d2 = Double.parseDouble(args[2]);

            String operator = args[1];

            double result = compute(d1, d2, operator);

            System.out.printf("%f %s %f = %.4f", d1, operator, d2, result);
        }catch(NumberFormatException e){
            System.out.printf("Both operands must be a number. %nOperand #1: %s%nOperand #2: %s%n", args[0], args[2]);
        }


    }

    public static double compute(double d1, double d2, String operator){
        // Initialize the result to not-a-number
        double result = Double.NaN;

        switch(operator){
            case "+":
                result = d1 + d2;
                break;
            case "-":
                result = d1 - d2;
                break;
            case "/":
                result = d1 / d2;
                break;
            case "x":
                result = d1 * d2;
                break;
            default:
                System.out.printf("Invalid operator : %s%n", operator );
                break;
        }

        return result;
    }

    public static void printUsage(){
        System.out.println("Usage: java com.jdojo.array.CalculatorTest expr");
        System.out.println("Where expr could be: ");
        System.out.printf("n1 + n2%nn1 - n2%nn1 * n2%nn1 / n2%n");
        System.out.printf("n1 and n2 are two numbers");
    }
}
