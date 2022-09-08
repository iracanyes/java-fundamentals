/**
*
*/
interface Bicycle{
	public void changeCadence(int newValue);

	public void changeGear(int newValue);

	public void speedUp(int increment);

	public void applyBrakes(int decrement);
}

/*
* INTERFACE
* Object define their interaction with the outside world through their methods
* Implementing an interface allows a class to become more formal 
* about the behavior it promises to provide. 
* 	
*/
class Bicycle implements Bicycle {
	int cadence = 0;
	int speed = 0;
	int gear = 1; // braquets

	// The compiler will now require that methods
    // changeCadence, changeGear, speedUp, and applyBrakes
    // all be implemented. Compilation will fail if those
    // methods are missing from this class.

	public void changeCadence(int newValue){
		cadence = newValue;
	}

	public void changeGear(int newValue){
		gear = newValue;
	}

	public void speedUp(int increment){
		this.speed += increment;
	}

	public void applyBrakes(int decrement){
		this.speed -= decrement;
	}

	public void printStates(){
		System.out.println("Cadence: " + cadence + "\nSpeed: " + speed + "\nGear: " + gear);
	}


}

/*
* INHERITANCE
* The class "MountainBike" inherit all fields and methods of class Bicycle.
* As Bicycle implements Bicycle interface, "MountainBike" will contain methods declared in this interface
* You must take care to properly document the state and behavior that each superclass defines, 
* since that code will not appear in the source file of each subclass.
*/
class MountainBike extends Bicycle{

}




public class BicycleDemo{
	public static void main(String[] args){
		// Create 2 different object from Class Bicycle
		Bicycle bike1 = new Bicycle();
		Bicycle bike2 = new Bicycle();
		Bicycle mountainBike1 = new MountainBike();

		// Invoke methods on those objects
		bike1.changeCadence(50);
		bike1.speedUp(10);
		bike1.changeGear(2);
		System.out.println("Bike1\n=======\n");
		bike1.printStates();

		bike2.changeCadence(50);
        bike2.speedUp(10);
        bike2.changeGear(2);
        bike2.changeCadence(40);
        bike2.speedUp(10);
        bike2.changeGear(3);
        System.out.println("Bike2\n=======\n");
        bike2.printStates();

        mountainBike1.changeCadence(50);
		mountainBike1.speedUp(10);
		mountainBike1.changeGear(2);
		System.out.println("MountainBike1\n=======\n");
		mountainBike1.printStates();
	}
}