package wk01;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * First week activity for CS 2013 class Spring 2022
 * @author Daveeed
 *
 */

/*
 * 
- Create a generic shape class with fields color and name
- Create a circle and square with different colors that extends the shape class with an
 	extra field - perimeter
- Output a text file that prints "There is a {{ color }} {{ shape }} with a perimeter of 
	{{ perimeter }}" for both shapes
 */

public class Wk1Main {
	public static void main(String[] args){
		Circle c = new Circle("C", "blue", 12);
		Square s = new Square("S", "orange", 15);
		
		try {
			File myFile = new File("Week1ExampleOutput.txt");
			
			
			if (myFile.createNewFile()) {
				System.out.println("File created");
			} else {
				System.out.println("File already exists");
			}
			
			FileWriter myWriter = new FileWriter("newfile.txt");
			myWriter.write(c.toString());
			myWriter.write("\n");
			myWriter.write(s.toString());
			myWriter.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
