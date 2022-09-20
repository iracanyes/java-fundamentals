/*
* A superclass and its subclasses may be in different modules.
* A subclass in module P can inherit from a superclass in module Q
* only if the subclass has been declared public and module Q exports
* the package containing the superclass to at least module P.
* You can use the fully qualified name of a class when extending a class
* Notation:
*   public class Q extends package1.P{
*
*   }
* Where package1 is the fully qualified name of the package
*/
class Cat extends com.jdojo.common.Animal{
    public Cat(){
        super("Mammals", "Carnivore", "Felidae");
    }
}
