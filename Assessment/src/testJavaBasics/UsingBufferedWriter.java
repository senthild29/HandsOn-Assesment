package testJavaBasics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingBufferedWriter {

	public static void main(String[] args) throws IOException {

		String FileLoc = "C:\\Users\\Senthil\\Downloads\\Java_WriteFile.txt";

		String FileContent = "Content of this file is created using BufferedWrtier class in Java";

		FileWriter getFile = new FileWriter(FileLoc);

		BufferedWriter FileWrit = new BufferedWriter(getFile);

		FileWrit.write(FileContent);
		FileWrit.close();
	
	}

}
