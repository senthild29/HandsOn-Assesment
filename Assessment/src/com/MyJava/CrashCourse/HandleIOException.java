package com.MyJava.CrashCourse;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HandleIOException {
	
	FileReader read;
	BufferedReader buffread;

	public void ReadFile() {
		try {
			read = new FileReader("F:\\Senthil\\Testing\\Tutorials\\Log Files\\logs.txt");

			buffread = new BufferedReader(read);

			String readfile;

			while((readfile = buffread.readLine())!=null) {
				System.out.println(readfile);
			}

			
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("Handled IO exception");
		}
		// Example of finally {} having try {} and Catch {}
		finally {
			try {
				buffread.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		HandleIOException excep = new HandleIOException();
		excep.ReadFile();

	}

}
