package com.MyJava.CrashCourse;

public class InhertiOverrideEg  extends InheritOverrideParent{
	
	protected void MySalary() {
		System.out.println("What is your annual income => ");
		System.out.println("Me:- Sorry I do  not share My Salary details");
		
	}

	public static void main(String[] args) {

		// Example of Inheritance 
		/*
		 * InhertiOverrideEg child = new InhertiOverrideEg(); 
		 * child.MyName();
		 * child.MySalary();
		 */
		
		//Example of Overriding with Inheritance
		
		InheritOverrideParent parent = new InhertiOverrideEg();
		parent.MyName();
		parent.MySalary();

	}

}
