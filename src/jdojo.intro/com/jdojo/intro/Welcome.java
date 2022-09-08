/**
 * This is a documentation comment. javadoc generates documentation from such comments.
 * Description:
 * Author: 
 * Date: 
 */
/* Multi-line comment
  A package is divided into several compilation units.
  A compilation unit must contains :
   - one package declaration
   - zeo or more import declaration
   - zero or more type declarations ( class, interface, enum, annotations)
*/
// package declaration
package com.jdojo.intro;

// import declaration 
import java.util.*;


// types declarations - class, interface, enum, annotations
public class Welcome{
  // Fields declarations


  // Initializers : Static initializer and instance initializer
  public static void main(String[] args){
    // Using arguments passed on runtime.
    // The command below throw an error if no arguments are given 
    // java --module-path lib --module jdojo.intro/com.jdojo.intro.Welcome
    // Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
    System.out.println("Welcome, " + args[0] + " to Beginning Java Fundamentals");
    
  }

  // Constructors

  
  // Method declarations
}
