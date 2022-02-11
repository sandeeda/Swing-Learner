package org.humber.binary_io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamTest {

	public static void main(String[] args) throws IOException {
		File file = new File("src/temp.dat");
		try(DataOutputStream output = new DataOutputStream(new FileOutputStream(file));
		DataInputStream input = new DataInputStream(new FileInputStream(file));){
			output.writeUTF("John");
			output.writeDouble(85.5);
			
			output.writeUTF("Jim");
			output.writeDouble(99.99);
			
			output.writeUTF("George");
			output.writeDouble(76.54);
			
			
			
			//System.out.println(input.available());
			System.out.println(input.readUTF()+" "+input.readDouble());
			System.out.println(input.readUTF()+" "+input.readDouble());
			System.out.println(input.readUTF()+" "+input.readDouble());
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
	}
}
