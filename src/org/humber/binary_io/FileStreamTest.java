package org.humber.binary_io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		try(FileOutputStream output = new FileOutputStream("src/temp.dat", false);
				FileInputStream input = new FileInputStream("src/temp.dat");){
			for(int i =10; i>=1; i--) {
				output.write(i);
			}
			int value;
			while((value = input.read())!=-1) {
				System.out.print(value);
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Something happend");
		}
	}
}
