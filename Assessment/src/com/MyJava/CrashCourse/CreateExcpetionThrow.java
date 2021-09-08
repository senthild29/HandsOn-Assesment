package com.MyJava.CrashCourse;

public class CreateExcpetionThrow {
	
	 static int age;
	 
	public static void CheckAge(int getAge) {
		
		if(getAge < 18) {
		
			// Created customized message using throw
		throw new ArithmeticException("Sorry entry restricted");
		}
		else {
			System.out.println("Access granted");
		}
	}

	public static void main(String[] args) {
		CheckAge(15);
	}
}
