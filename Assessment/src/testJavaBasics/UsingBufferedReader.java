package testJavaBasics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UsingBufferedReader {

	public static void main(String[] args) throws IOException {

		String FileLoc = "C:\\Users\\Senthil\\Downloads\\Java_ReadFile.txt";

		FileReader getFile = new FileReader(FileLoc);

		BufferedReader readFile = new BufferedReader(getFile);

		String readdata;

		while ((readdata = readFile.readLine())!=null) {
			System.out.println(readdata);
		}

	}

}
