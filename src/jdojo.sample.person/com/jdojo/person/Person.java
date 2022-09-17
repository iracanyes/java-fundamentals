/**
 *
 * Command :
 * 		Compile: javac -p mod -d mod/jdojo.sample.person src/jdojo.sample.person/module-info.java src/jdojo.sample.person/com/jdojo/person/Person.java
 * */
package com.jdojo.person;

import com.jdojo.address.Address;

import java.io.Serializable;

/*
* To compile this class, you must to include module "jdojo.sample.address"
* in the module path.
* As the 2 modules are part of the same project no extra-step are needed
* but if 2 modules are part of different project, you need to include those libraries
* in the project libraries of your IDE (if you use an IDE or in the module path)
*
*
*/
public class Person implements Serializable, Comparable{
	private long personId;
	private String firstName;
	private String lastName;
	private Address address = Address.getInstance();

	private Person(){
		this.personId = 00;
		this.firstName = "John";
		this.lastName = "Doe";

	}

	public static Person getInstance(){
		return new Person();
	}

	public Person(
		long 	personId,
		String 	firstName,
		String	lastName
	){
		this.personId = personId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void setPersonId(long personId){
		this.personId = personId;
	}

	public long getPersonId(){
		return this.personId;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return this.firstName;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return this.lastName;
	}

	public void setAddress(Address address){
		this.address = address;
	}

	public Address getAddress(){
		return this.address;
	}

	@Override
	public String toString(){
		return "[PersonId: " + personId
			+ ", firstName: " + firstName
			+ ", lastName: " + lastName
			+ ", address: " + address + "]";
	}

	/*
	* Comparable interface allow non-primitive object to be compared. Arrays method for comparison will call this method to compare Person instance.
	*/
	@Override
	public int compareTo(Object compareTo){
		try{
			Person compareToPerson = (Person) compareTo;

			// Compare the firstname
			int compareFirstName = this.firstName.compareTo(compareToPerson.getFirstName());
			if( compareFirstName > 0 ){
				return 1;
			}else if(compareFirstName < 0){
				return -1;
			}

			// Compare the firstname
			int compareLastName = this.lastName.compareTo(compareToPerson.getLastName());
			if( compareLastName > 0 ){
				return 1;
			}else if(compareLastName < 0){
				return -1;
			}

			return 0;
		}catch(Exception e){
			e.printStackTrace();
		}

		return 0;
	}

}
