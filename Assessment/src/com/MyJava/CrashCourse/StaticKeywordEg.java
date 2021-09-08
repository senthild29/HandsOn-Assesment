package com.MyJava.CrashCourse;

import org.apache.commons.math3.analysis.function.Add;

public class StaticKeywordEg {
	
	//Static variabe
	static Integer a; 
	static Integer b;
	
	// static method 
	public static int add(int getA, int getB) {
		a=getA;
		b=getB;
	int calc = 	getA+getB;
	return calc;
		
	}
	
	// Static block of code
	static void blockofcode() {
		System.out.println("inside block of code");
	}

	public static void main(String[] args) {
		
		/*
		 * StaticKeywordEg key = new StaticKeywordEg(); // key.add(5, 15);
		 * System.out.println("Addition of 2 values => "+key.add(5, 6));
		 */
		
		System.out.println("Addition of 2 values => "+add(5, 7));
		blockofcode();
	}

}
