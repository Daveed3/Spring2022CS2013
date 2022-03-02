package wk05;

public class Wk5Main {
	public static void main(String[] args) {
		int[][] samples = {
			{1, 2, 3, 4, 5},
			{2, 5, 8, 1, 9},
			{},
			{1},
			{2, 4}
		};
		
		
// 		Problem 1 samples
//		boolean test1 = arrayContains(sampleArrays[0], 15);
//		System.out.println(test1);
		
		
//		Problem 2 samples
		String[][] sampleStrings = {
			{"hello hello world", "lo"},
			{"The dog went through the doghouse to get to the other side", "the"},
			{"oooooooo man", "o"},
			{"sheeeeeeeeeeesh", "sh"}
		};
		for (int sampIndex=0; sampIndex<sampleStrings.length; sampIndex++) {
			int num = substringInstances(sampleStrings[sampIndex][0], sampleStrings[sampIndex][1]);
			System.out.println("\"" + sampleStrings[sampIndex][1] + "\" shows up " + num + " time(s)");			
		}
		
		
//		Problem 3 samples
//		for (int i=0; i<samples.length; i++) {			
//			sumNeighbors(samples[i]);
//			System.out.println("End sumNeighbors sample--------------------");
//		}
		
	}
	
	// Problem 1
	public static boolean arrayContains(int[] arr, int n) {
		if (arr.length == 0) {
			return false;
		} else if (arr[0] == n) {
			return true;
		}
		
		int[] tempArr = new int[arr.length-1];
		System.arraycopy(arr, 1, tempArr, 0, arr.length-1);			
				
		return arrayContains(tempArr, n);
	}
	
	// Problem 2
	public static int substringInstances(String str, String substr) {
//		Base case where the string is empty
		if (str.length() == 0) {
			return 0;
		} else if (str.toLowerCase().charAt(0) == substr.toLowerCase().charAt(0)) {
//			Compare the current left most characters of the string and substring to see if they match
//			If they do match, use a helper method (similar logic with Problem 1) to see if the string contains the substring
			if(helperSubstring(str, substr)) {
//				If the string contains the substring, continue the recursive calls (substring.length) characters into the string
				str = str.substring(substr.length()-1, str.length());
			} else {
//				Otherwise continue the recursive calls 1 character more into the string
				return substringInstances(str.substring(1, str.length()), substr);
			}
		} else {
			return substringInstances(str.substring(1, str.length()), substr);
		}
		
		return 1 + substringInstances(str.substring(1, str.length()), substr);
	}
	
	public static boolean helperSubstring(String str, String substr) {
//		Base case: if this helper function ate up all of the substring, there was
		if (substr.length() == 0) {
			return true;
		} else if (str.length() == 0) {
//			If the string ran out of characters before the substring
			return false;
		} else if (str.toLowerCase().charAt(0) == substr.toLowerCase().charAt(0)) {
//			If the substring char is in the string
			return helperSubstring(str.substring(1, str.length()), substr.substring(1, substr.length()));
		}
//		If the characters aren't matching
		return false;
	}
	
	// Problem 3
	public static int[] sumNeighbors(int[] arr) {
//		Recursion method to add up neighboring numbers in an int array
		int[] empty = {};
		if (arr.length == 0) {
			return empty;
		} else {
			printArr(arr);
			int[] subArr = new int[arr.length - 1];
//			At this point, recursion should've been done from the previous problems and doing this for loop would be an easy way of filling the array instead of using recursion.
//			Could use a helper recursive methods with Objects, or the Arrays.copy method
			for (int i=0; i<subArr.length; i++) {
				subArr[i] = arr[i] + arr[i+1];
			}
			
			return sumNeighbors(subArr);
		}
	}
	
	public static void printArr(int[] arr) {
		for (int i=0; i< arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
