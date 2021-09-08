package com.MyJava.CrashCourse;

public class OverloadEg {
	
	String name;
	int age;

	int  calc(int a, int b) {
		int add = a+b;
		return add;
	}
	
	private String calc(String a) {
		 name = a; 
			return name;	
	}
	
	protected int  calc(int a, int b, int c) {
		int mul = a*b*c;
		return mul;
		}
	
	
	public static void main(String[] args) {
		OverloadEg action = new OverloadEg();
		System.out.println("Code Name is => "+action.calc("The Wolf "));
		System.out.println("Addition of 2 values => "+action.calc(25, 40));
		System.out.println("Multiplication of 3 values => "+action.calc(3, 2, 5));

	}

}
