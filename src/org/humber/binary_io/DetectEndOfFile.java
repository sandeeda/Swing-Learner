package org.humber.binary_io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DetectEndOfFile {
	public static void main(String[] args) throws IOException {
		File file = new File("src/temp.dat");
		try(DataOutputStream output = new DataOutputStream(new FileOutputStream(file));
			DataInputStream input = new DataInputStream(new FileInputStream(file));) {
			
			
			output.writeDouble(4.5);
			output.writeDouble(4.85);
			output.writeDouble(44.5);
			output.writeDouble(42.5);
			output.writeDouble(4.95);
			
			
			while(true) {
				System.out.println(input.readDouble());
			}
		} catch (EOFException e) {
			// TODO: handle exception
			System.out.println("All data is read");
		}
		catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
