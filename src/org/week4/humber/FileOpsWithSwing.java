package org.week4.humber;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileOpsWithSwing {

	public static void main(String[] args) {
		File currentDirectory = new File("");
		System.out.println("Current Directory is "+ currentDirectory.getAbsolutePath());
		
		File directory = new File("src/org/week4/humber/abc.txt");
		System.out.println("Does the directory exis?" + directory.exists());
		System.out.println("The Directory has "+directory.length()+" Bytes");
		System.out.println("Is the directory a dircetory in the system? " + directory.isDirectory());
		System.out.println("Is the directory a file in the system? "+directory.isFile());
		
		
		String id [] = new String[20];
		int counter = 0; 
	
		
		try {
			Scanner sc = new Scanner(directory);
			while(sc.hasNextLine())
				{
				
					String [] details = sc.nextLine().split(",");
					//id[counter] = Integer.valueOf(details[0]);
					//System.out.println(details[0]);
					id[counter] = (details[0]);
					counter++;
				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		for (int i =0; i<id.length ; i++)
		{
			System.out.println(id[i]);
		}
		
	}
}
