package com.MyJava.CrashCourse;

public class ChildAbstractionEg extends ParentAbstractEg implements ParentInterface, ChildInterface{

	public  void CarModel() {
		System.out.println("I'm inside child class, implemented parent class using abstract class ");
	}

	public void OpenBrow() {
		System.out.println("I'm inside child class implemeneted Parent Interface using Implements keyword");

	}

	public void HitAmazonpage() {
		System.out.println("Amazon india loaded");

	}

	public static void main(String[] args) {

		ParentAbstractEg run = new ChildAbstractionEg();
		run.Vehicle();
		run.CarModel();

		ParentInterface run2 = new ChildAbstractionEg();
		run2.OpenBrow();
		run2.HitAmazonpage();
	}
}
