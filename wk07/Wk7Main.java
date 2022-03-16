package wk07;
import java.util.ArrayList;

public class Wk7Main {
	public static void main(String[] args) {
		int[] sample1 = {5, 2, 7, 9, 3, 4};
		int[] sample2 = {1, 2, 3, 4};
		int[] sample3 = {9, 9, 9, 9};
		int[] sample4 = {1, 5, 7, 1, 8 ,4};
		String[] sample5 = {"Rock", "Roll", "Mix", "Classic", "New", "Alternative"};
		ArrayList<String> sample5Lis = new ArrayList<String>();
		for (int i=0; i<sample5.length; i++) {
			sample5Lis.add(sample5[i]);
		}
		String sample6 = "That new store has that new game that came out";
		
//		_printArr(sample1);
//		_printArr(prob1(sample1, 5));
		
//		_printArr(prob2(sample3));
		
//		prob3();
		
//		_printArr(prob4(sample4));
		
//		prob5();
		
//		prob6();
		
//		System.out.println(prob7("hello there", 'l'));
		
//		_printArr(prob8Prim(sample5));
//		prob8ArrLis(sample5Lis);
		
		prob9(sample6);
	}
	
	public static void _printArr(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " " );
		}
		System.out.println();
	}
	public static void _printArr(String[] arr) {
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " " );
		}
		System.out.println();
	}

	public static int[] _nTwoSort(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			for (int j=i; j<arr.length; j++) {
				if (arr[j]  < arr[i]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}
	
	/*
	1. Classic - Two Sum
	Given an array of integers, and an int n, return indices of 2 numbers in the array that add up to n. What is the runtime of the solution you've came up with?
	(i.e the array is {1, 6, 9, 3} and n=4. The result should return the indices of the elements 1 and 3 (0th index and 3rd index respectively))
	*/
	public static int[] prob1(int[] arr, int n) {
		int[] CANNOTFIND = {-1, -1};
//		sort the array first
//		{6, 21, 8, 21, 98,}
//		{8, 21, 21, 98} n = 421 result = 98+98 = 196 <421
		_nTwoSort(arr);		
		
//		then do binary searching
		int lowIndex = 0;
		int highIndex = arr.length-1;
//		if it gets to last and last is too small, number cant be made 
		if (arr[highIndex] + arr[highIndex] < n) {
			return CANNOTFIND;
		}

//		if the indicies pass each other, then the number can't be made with the numbers provided
		while (lowIndex > highIndex) {
//		if first and last is too big, make last smaller
			if (arr[lowIndex] + arr[highIndex] > n) {
//				{6, 21, 21} n = 46 result = 6+98 = 104 > 46
				highIndex = highIndex-1;
			}
//		if first and last is too small, increase first
			else if (arr[lowIndex] + arr[highIndex] < n) {
//				{21, 21, 98} n = 214 result = 21+98 = 104 < 214
				lowIndex = lowIndex + 1;
			}
			
						
			if (arr[lowIndex] + arr[highIndex] == n) {
				int[] retIndicies = {lowIndex, highIndex};
				return retIndicies;
			}
		}
//		If it wasn't found in the while loop it should be null
		return CANNOTFIND;
	}
	/*
	2. Off by One
	Say you've factored some code that get a number n and splits each number into an element in an array (i.e. 1234 becomes {1, 2, 3, 4}). But then you realize the number was off by 1 because of an indexing issue. Convert the array back to a number, add 1, then convert the number back to an array. 
	(Simpler terms - given an array of ints, convert the ints into a whole number, add 1, then convert the whole number back to the array of ints)
	(i.e. {1, 2, 3, 4} becomes 1234, then add 1 to make it 1235, and finally return it to {1, 2, 3, 5})
	*/
	public static int[] prob2(int[] arr) {
//		Someone went about this by adding 1 to the last element unless it was 9
		String numAsString = "";
		for (int i=0; i<arr.length; i++) {
			numAsString += arr[i];
		}
		int mainInt = Integer.parseInt(numAsString);
		mainInt += 1;
		int[] returnInt = new int[(mainInt+"").length()];
		for (int i=0; i<returnInt.length; i++) {
			returnInt[i] = Integer.parseInt((mainInt+"").charAt(i)+"");
		}
		return returnInt;
	}	
	/*
	3. Primitive vs Modern
	**For the activity purpose you can just implement the arrays with strings as the data type**
	Using a primitive array (String[]) create a class that can use the array, add to the array (increase the size if needed), remove from the array, and returning the length of the array.
	Test this by adding and removing a couple of strings to this class. Then do the same thing with ArrayList<String>
	(i.e your class called UpgradedArray and it has .add, .remove methods.
	We have strings "test", "these", "strings" and we'll call the UpgradedArray.add("test"), .add("these"), .add("strings")
	Then we'll remove "these" from the array
	Lastly we'll do the same thing with the ArrayList
	ArrayList.add("test"), .add("these"), .add("strings")
	And remove "these" from the ArrayList
	)
	*/
	public static void prob3() {
		String one = "test";
		String two = "these";
		String three = "strings";
		
		UpgradedArray testArr1 = new UpgradedArray();
		testArr1.add(one);
		testArr1.add(two);
		testArr1.add(three);
		testArr1._printArr();
		testArr1.remove(two);
		testArr1._printArr();
		
		ArrayList<String> testArr2 = new ArrayList<String>();
		testArr2.add(one);
		testArr2.add(two);
		testArr2.add(three);
		System.out.println(testArr2.toString());
		testArr2.remove(two);
		System.out.println(testArr2.toString());
		
		
	}
	/*
	4.  Unique numbers
	Given an array of integers (containing duplicate ints), return a list of integers where the first elements are unique (not a duplicate). Determine the runtime of your solution; did you implement your solution with 1 array or multiple arrays?
	(i.e. the array is {6, 9, 1, 4, 1, 8, 4, 6, 9} so a valid result would be {6, 9, 1, 4, 8})
	*/
	public static int[] prob4(int[] arr) {
		int[] uniqueNums = new int[arr.length];
		int numOfUnique = 0;
		
		for (int i=0; i<arr.length; i++) {
			boolean inList = false;
			for (int j=0; j<uniqueNums.length; j++) {
				if (arr[i] == uniqueNums[j]) {
					inList = true;
					break;
				}
			}
			if (!inList) {
				uniqueNums[numOfUnique] = arr[i];
				numOfUnique++;
			}
		}
		
//		Optional - return ONLY the unique numbers
		int[] temp = new int[numOfUnique];
		for (int i=0; i<numOfUnique; i++) {
			temp[i] = uniqueNums[i];
		}
		
		return temp;
	}
	/*
	5. Deconstructing a string into chars (Making your own string)
	Create your own class to mimic some of the functionalities of the String class. For this exercise, use an array of chars to work in place of a string and implement methods to accommodate for:
	Appending to the “string” 
	(i.e. char[] {‘h’, ‘e’, ‘l’, ‘l’, ‘o’} + String “world” => char[] {‘h’, ‘e’, ‘l’, ‘l’, ‘o’, ‘w’ ‘o’, ‘r’, ‘l’, ‘d’})
	Substringing the “string”
	(i.e. char[] {‘h’, ‘e’, ‘l’, ‘l’, ‘o’} .substring(3, 5) => char[] {‘l’, ‘o’}) 
	Printing out the entire “string”
	(i.e. char[] {‘h’, ‘e’, ‘l’, ‘l’, ‘o’, ‘w’ ‘o’, ‘r’, ‘l’, ‘d’} => helloworld)
	*/
	public static void prob5() {
		CustomString newStr = new CustomString("hello");
		newStr.print();
		newStr.add('h');
		newStr.print();
		newStr = new CustomString(newStr.substring(0, 5));
		newStr.print();
		newStr.add(" world");
		newStr.print();
	}
	/*
	6. Creating another version of an ArrayList (Linked List)
	For this ArrayList, the main focus is going to be on being able to add elements to an object (or Node) and associate them with each other. Here you will implement a class that will have data fields for itself and a value (i.e.
	class NewNode {
		NewNode next;
		Int value;
	}
	)
	The idea is that, if you want to add another value to this “ArrayList”, you will create an new object, fill in that value, and make the previous object’s “next” be the current next
	(i.e. using above, you create NewNode with value 10. Then you create another NewNode with value 12 and you want to add it to the “ArrayList”, the NewNode with value 10 will have next = NewNode with the value 12. Then the same concept happens when we want to add another NewNode, say with the value 14, to the list. Then your “ArrayList” should look like 10 -> 12 -> 14)
	An example of implementing the code could look like
	NewNode node1 = NewNode(10)
	NewNode node2 = NewNode(12)
	node1.next = node2
	NewNode node3 = NewNode(14)
	node2.next = node3
	This way it resembles the 10 -> 12 -> 14
	*/
	public static void prob6() {
		CustomNode n1 = new CustomNode(10);
		CustomNode n2 = new CustomNode(12);
		CustomNode n3 = new CustomNode(14);
		n1.next = n2;
		n2.next = n3;
		
		CustomNode node = n1;
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
	/*
	7. Deleting from an ArrayList, but it’s a string
	In this exercise, you will take a string and turn that string into an array of chars. Given another letter, you will search the char array and remove this letter from the char array (note in the case where there are multiple repeating letters you can remove the first, middle, OR last one. Just remove 1 instance of that letter, NOT ALL letters). Return the char array as a string.
	*Don’t just use removes that directly replace or remove the char directly from the string
	*/
	public static char[] prob7(String str, char letterToRemove) {
//		Turn string into char array
		char[] chars = new char[str.length()];
		for (int i=0; i<str.length(); i++) {
			chars[i] = str.charAt(i);
		}
		
//		New array assuming the letter is in there
		char[] returningChars = new char[chars.length-1];
		int rIndex = 0;
		boolean letterFound = false;
		for (int i=0; i<chars.length; i++) {
			if (chars[i] == letterToRemove && !letterFound) {
				letterFound = true;
				continue;
			}
			else if (rIndex == chars.length) {
//				The letterToRemove was not found in the array. Break out of loop before loop breaks the program
				break;
			}
			returningChars[rIndex] = chars[i];
			rIndex++;
		}
		
		if (letterFound) {
			return returningChars;
		}
		return null;
	}
	/*
	8. Music Bot’s Shuffle
	Taking a list of strings (String[]) create a method that will shuffle the strings around. Do the same thing with ArrayList<String>. Compare the difficulty of implementing the method for both of these types (i.e. which seemed easier to work with, which seemed like it had more work…). 
	*Don’t just use methods that already shuffle the values around - the idea is to practice on manipulating the data in the array in a random order 
	*/
	public static String[] prob8Prim(String[] arr) {
//		Array to generate random positions
		int[] randNums = new int[arr.length];
		randNums[arr.length-1] = -1;
		int rIndex = 0;
		
		while(randNums[arr.length-1] == -1) {
			int randNum = (int)(Math.random() * arr.length);
			boolean alreadyInList = false;
			
			for (int i=0; i<randNums.length; i++) {
				if (randNum == randNums[i]) {
					alreadyInList = true;
					break;
				}
			}
			if (!alreadyInList) {
				randNums[rIndex] = randNum;
				rIndex++;
			}
		}
		
		String[] shuffledArr = new String[arr.length];
		for (int i=0; i<shuffledArr.length; i++) {
			shuffledArr[i] = arr[randNums[i]];
		}
		
		return shuffledArr;
	}
	public static void prob8ArrLis(ArrayList<String> arr) {
		ArrayList<Integer> randNums = new ArrayList<Integer>();
		
		while (randNums.size() != arr.size()) {
			int randNum = (int)(Math.random() * arr.size());
			if (!randNums.contains(randNum)) {
				randNums.add(randNum);
			}
		}
		
		ArrayList<String> shuffledArr = new ArrayList<String>();
		for (int i=0; i<arr.size(); i++) {
			shuffledArr.add(arr.get(randNums.get(i)));
		}
		
		System.out.println(shuffledArr);
	}
	/*
	9. Bag of Words and frequency
	Create an algorithm that you are able to take sentences as input and determine the frequency of words in that sentence. For example if you give the sentence 
	“That new store has that new game that came out”
	Your frequency should look something like
	That: 3
	New: 2
	Store: 1
	Has: 1
	Game: 1
	Came: 1
	Out: 1 
	 */
	public static void prob9(String sentence) {
		String[] words = new String[sentence.length()];
		int[] counters = new int[sentence.length()];
		
		String[] splitWords = sentence.split(" ");
		int numNewWords = 0;
//		First for loop to go through all words in the sentence
		for (int wordIndex=0; wordIndex<splitWords.length; wordIndex++) {
			String currWord = splitWords[wordIndex];
//			Check if word is in the words list
			boolean isInWordsList = false;
			for (int wordCheckIndex = 0; wordCheckIndex<numNewWords; wordCheckIndex++) {
				if (words[wordCheckIndex].toLowerCase().equals(currWord.toLowerCase())) {
					isInWordsList = true;
					counters[wordCheckIndex]++;
					break;
				}
			}
			
//			If not in the list, add to list and add a counter
			if (!isInWordsList) {
				words[numNewWords] = currWord;
				counters[numNewWords] = 1;		
				numNewWords++;
			}
				
		}
		
//		Create new arrays so there isn't a lot of nulls - can avoid with ArrayLists
		String[] returnWords = new String[numNewWords];
		int[] returnCounters = new int[numNewWords];			
		
		for (int i=0; i<returnWords.length; i++) {
			returnWords[i] = words[i];
			returnCounters[i] = counters[i];
			System.out.println(returnWords[i] +": "+ returnCounters[i]);
		}
		
//		_printArr(returnWords);
//		_printArr(returnCounters);
	}
}
