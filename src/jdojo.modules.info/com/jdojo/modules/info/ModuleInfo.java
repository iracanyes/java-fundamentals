
/**
 * Java provides a set of classes and interfaces to work with modules.
 * They are known as Module API.
 * The module API lets you query module information and modify it
 * */
 package com.jdojo.modules.info;

import java.lang.module.ModuleDescriptor;
import com.jdojo.person.Person;

public class ModuleInfo{
	public static void main(String[] args) {
		/*
		* Each type loaded in the JVM is represented by an instance of the class "java.lang.Class<T>"
		* An instance of the class "Class<T>" represents the type "T" at runtime.
		* 
		*/

		// Get the module reference		
		Class<ModuleInfo> cls = ModuleInfo.class;

		// Get module reference
		Module m = cls.getModule();

		if(m.isNamed()){
			// Here, we know it's a named module

			// Retrieve the name of the module
			String name = m.getName();

			// Retrieve module descriptor
			ModuleDescriptor md = m.getDescriptor();

			System.out.println("Module name: " + name);
			System.out.println("Module is open: " + md.isOpen());
			System.out.println("Module is automatic: " + md.isAutomatic());

		}else{
			// Here we know, it's an unnamed module
			System.out.println("It's an Unnmaed module.");
		}

		// Access module reference from instance of the class
		Person p = new Person(123321, "Tony", "Pistone");

		/*
		* Class<Person> pCls = p.getClass()
		* Compiling this will generate an error: Incompatible types
		* 
		*	Class<CAP#1> cannot be converted to Class<Person>
		*/
		Class  pCls = p.getClass();

		System.out.println("Class type name: " + pCls.getName());
	}
}