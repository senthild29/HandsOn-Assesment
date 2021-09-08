package com.MyJava.CrashCourse;

public class LoopingStat {

	// Execute the statement 5 times using for loop
	public void forLoop() {

		for(int count = 0; count<4; count++) {
			System.out.println("I'm inside a for loop");
	}
		System.out.println("\n");

	}
// Exeucte statement using whil loop
	public void whileloop() {
		int i=0;
		while (i<3) {
			System.out.println("I'm inside a while loop");
			i++;
			}
		System.out.println("\n");
	}
	
	//Execute the statement using do while loop
	public void dowhileloop() {
		int i =5;
		do {
			System.out.println("I'm inside a do while loop");
			i++;
		} while (i<2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoopingStat loop = new LoopingStat();
		loop.forLoop();
		loop.whileloop();
		loop.dowhileloop();
	}

}
