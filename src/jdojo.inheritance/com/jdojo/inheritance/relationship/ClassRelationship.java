/*
* A software application designed based on object-oriented paradigm, consists of interacting class.
* Objects of one class may be related to objects of another class in some ways.
* The 3 commonly used relationship are:
*   - "Is a" relationship is used with inheritance. Ex : ArmoredCar is a Car
*   - "Has a" relationship is used when object contains another object. (aggregation)
*       Ex: Person has an Address
*   - "Part-of" relationship is used . Ex:
*
* Is-a relationship
* Object which inherits from another object. It's called inheritance
*
* Has-a relationship
* Object contains another object. It's called aggregation
*
* Part-of relationship
* It's called composition when one object (the whole) controls the life cycle  of
* another object (the part).
* The whole controls the creation/destruction of the part.
* The part cannot exist by itself.
* Rather, the part is created and destroyed as part of the whole.
* The existence of the part make no sense outside of the whole
* The owned object must have an owner object!
* An owner can pass the owned object to another owner object before its destruction.
*/
public class ClassRelationship{
    public static void main(String[] args) {
        
    }
}


/*
* HAS_A RELATIONSHIP
*/
class Address{

}

class Person{
    // Person has-a Address
    private Address addr;

    public Person(Address addr){
        this.addr = addr;
    }

    public void setAddress(Address addr){
        this.addr = addr;
    }
}

/*
* PART_OF RELATIONSHIP (Owner-owned relationship)
*/
class Computer{
    // CPU part-of Computer class
    private CPU cpu = new CPU();
    // Another way to implement part-of relationship using inner class
    private class Motherboard{

    }
    // The code for the Computer
}

class CPU{

}

/*
* An example of misuse of inheritance and composition is java.util.Stack and java.util.Vector
* Stack class inherits from Vector class.
* A Vector is a list of objects.
* A Stack is a list of objects, but is not simply a list.
* A Stack is supposed to allow you to add an object to its top and remove an object from its top.
* However, Vector class allow to add/remove an object at any position of the list.
* Since, Stack inherits from Vector, it also inherits the methods that let you add/remove
* an object at any position, which are wrong operation for a stack.
* Stack should have used composition instead of inheritance, to use a Vector object as
* its internal representation rather than inheriting from it.
* Here is an example of a better definition of a Stack class
*/
class Stack{
    private Vector items = new Vector();
}
