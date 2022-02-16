package wk03

import java.util.ArrayList;
import java.util.List;

public class Wk3Main {
	public static void main(String[] args) {
//		problem1();
		problem2();
	}
	
	public static void problem1() {
//		Say you're given various arrays with various types (but only 1 type per array. I.E. you would 
//		have an integer array, a double array, a string array...), create a single method printArray that 
//		can print all elements from the array. 
		ArrayList<Integer> intArray = new ArrayList<Integer>();
		intArray.add(6);
		intArray.add(12);
		intArray.add(1);
		intArray.add(9);
		printArray(intArray);
		
		ArrayList<String> strArray = new ArrayList<String>();
		strArray.add("sample");
		strArray.add("text");
		strArray.add("is");
		strArray.add("here");
		printArray(strArray);
	}
	
	public static <T> void printArray(T list1) {
		for (int i=0; i<((List)list1).size(); i++) {
			System.out.println(((List)list1).get(i));
		}
	}
	
	public static void problem2() {
//		Create a generic list sorting class. Here you will create a class called Sorting and a method 
//		called sort. The sort method will be generic and made to sort simple sets. The sorting algorithm 
//		can follow the pseudocode:
//			while the set is not sorted:
//			   for each item in the set:
//			      if next item > current item:
//			         swap current item and item

		ArrayList<Integer> intArray = new ArrayList<Integer>();
		intArray.add(6);
		intArray.add(12);
		intArray.add(1);
		intArray.add(9);
		sort(intArray);
		
		ArrayList<String> strArray = new ArrayList<String>();
		strArray.add("is");
		strArray.add("here");
		strArray.add("sample");
		strArray.add("text");
		sort(strArray);
		
		ArrayList<Double> dblArray = new ArrayList<Double>();
		dblArray.add(93.324);
		dblArray.add(12.4345);
		dblArray.add(25.2134);
		dblArray.add(75.21);
		sort(dblArray);
		
	}
	
	public static <T extends Comparable<T>> void sort(List<T> list1) {
		boolean isSorted = false;
		while (!isSorted) {
//			Sort the array here using Comparable's compareTo
			// > 0 means that the first element is larger, < 0 means the first element is smaller
			for (int i=0; i<list1.size()-1; i++) {
				if (list1.get(i).compareTo(list1.get(i+1)) > 0) {
					// Sorting the list with temp and replacing each other
					T temp = list1.get(i);
					list1.set(i, list1.get(i+1));
					list1.set(i+1, temp);
					
				}
			}
			
//			Condition where if the list is sorted, make the boolean say it is sorted
			// Check if all the elements are sorted
			//// If one of them is out of place, the list is not sorted
			for (int i=0; i<list1.size()-1; i++) {
				if (list1.get(i).compareTo(list1.get(i+1)) < 0) {
					if (i == list1.size()-2) {
						isSorted = true;
					}
				} else {
					break;
				}
			}
		}
		
		// Printing out the sorted list
		for (int i=0; i<list1.size(); i++) {
			System.out.println("index " + i + " element " + list1.get(i));
		}
	}

	
	
	
	
	
}
