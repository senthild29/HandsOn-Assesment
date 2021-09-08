package com.MyJava.CrashCourse;

public class ConditionStatEg {

	static String Myname = "Tom Cruise";


	public static void cond() {

		switch ("Tom Cruise") {
		case "Tom Cruise":
			System.out.println("Your name is Tom Cruise");
			break;
		case "Will Smith":
			System.out.println("Your name is Will Smith");
			break;
		case "Brad Pitt":
			System.out.println("Your name is Brad Pitt");
			break;
		case "Paul Walker":
			System.out.println("Your name is Paul Walker");
			break;
		default:
			System.out.println("Sorry not able to guess your name");
			break;
		}
	}
	public static void main(String[] args) {

		cond();
	}

}
