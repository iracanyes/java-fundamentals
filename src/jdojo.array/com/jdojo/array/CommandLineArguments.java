/*
* Java application can be launch from command prompt (Windows) or shell prompt (UNIX).
* Command line arguments are passed to the JVM by the OS.
* The OS may directly interpret the arguments passed or return a modified list of arguments to the JVM.
* The JVM parses the argument lists using a space as separator. It create an array of String of same length than the list of arguments.
* It populate the String array with the items in the arguments list sequentially.
* Finally, the JVM passes this String array to main() mmethod of the class.
*
* If no argument are given, the JVM create an String array of zero length and passes it to main() method
*
* You can enclose your argument string between double quotes ""
* To avoid OS interpretation of special characters, you can enclose them in double quotes.
*/
package com.jdojo.array;

public class CommandLineArguments{
    public static void main(String[] args) {
        System.out.printf("Total arguments: %d%n", args.length);

        // Display all arguments
        for(int i = 0; i < args.length; i++){
            System.out.printf("Argument #%d : %s%n", i, args[i]);
        }
    }
}
