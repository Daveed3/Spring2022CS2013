package wk08;
import java.util.ArrayList;
import java.util.List;

/*
1. Classic - Reverse a Linked List
Given a linked list, reverse the order of the linked list. (i.e. 1->3->6 becomes 1<-3<-6 [or 6->3->1]).
*/
/*
2. Addition (through Linked Lists)
You are given 2 linked lists where each node contains a number. Each linked list's number actually is a whole number (i.e. a linked list like 1->4->5 is actually 541 - notice that the list works from the least significant number to the most significant number). Add up the 2 linked lists and return another linked list with the result.
(i.e. 1->4->5 + 6->2->3 = 7->6->8 ------- looks like 541 + 326 = 867)
*/
/*
3. Cycles in Linked Lists
Given a Linked List class, determine if the linked list class has a cycle. (i.e. say each node value here is unique, and 1->4->3->2->4. Since each node value is unique, the 4 in the 1st index and the last index are the same exact node. That also means that after that last 4, it points to 3 which points to 2 which points to 4 ...)
*/
/*
4. Get all indices for each instance of ...
Given a Linked List and a value n, return the indices in the Linked List where the value of that node is equal to n. (i.e. 1->4->7->3->4->2->4 and n=4, the return value should be {1, 4, 6} since those indices are 4)
*/
/*
5. Subtraction (through Linked Lists)
You are given 2 linked lists where each node contains a number. Each linked list’s number actually is a whole number (i.e. linked list like 0->3->5 is actually 530 - notice that the list works from least significant number to most significant number). Subtract the 2 provided linked lists and return another linked list with the result.
(i.e. 2->7->9 - 8->4->2 = 4->2->7 ----- looks like 972 - 248 = 724)
*/
/*
6. Middle of the Linked List
Given a linked list of n elements, print the middle element(s) of the linked list (if the n is an even number, print the middle 2 elements). Do the same thing with an ArrayList and compare how you had to implement both (i.e. which was easier to figure out, which was easier to code,...)
*/
/*
7. Remove Duplicates
Given a linked list with duplicate elements, write a method that will remove the duplicates from the linked list and return the new cleaned linked list. (i.e. you have 2->7->3->5->2->3, after running the method it should look like 2->7->3->5)
*/
/*
8. Count instances of …
Given a linked list and a value n, return the number of times n shows up in the linked list. (i.e. 2->8->6->4->2->3->2 and n=2, the return value should be 3 since 2 shows up 3 times in the linked list).
*/

public class Wk8Main {
	public static <E> void main(String[] args) {
		SinglyLinkedList<Integer> sample1 = new SinglyLinkedList<Integer>();
		sample1.add(3);
		sample1.add(7);
		sample1.add(9);
		//973
		SinglyLinkedList<Integer> sample2 = new SinglyLinkedList<Integer>();
		sample2.add(5);
		sample2.add(2);
		sample2.add(3);
		//325
		//Addition result should be 1298
		//Subtraction result should be 648
		SinglyLinkedList<Integer> sample3 = new SinglyLinkedList<Integer>();
		int[] nums = {4, 7, 1, 8, 3, 7, 3, 0};
		for (int i=0; i<nums.length; i++) {
			sample3.add(nums[i]);
		}
		int[] dupNums = {1, 2, 4, 7, 1, 3, 2, 0, 1, 2, 4};
		SinglyLinkedList<Integer> sample4 = new SinglyLinkedList<Integer>();
		for (int i=0; i<dupNums.length; i++) {
			sample4.add(dupNums[i]);
		}
		
		
		/*
		sample1.printNodesBySize();
		System.out.println("-------------------");
		Node newHead = prob1(sample1);
		Node newCurrent = newHead;
		while (newCurrent != null) {			
			System.out.println(newCurrent + " " + newCurrent.getElement());
			newCurrent = newCurrent.getNext();
		}
		*/
		
		
		
//		Node prob3Return = prob2(sample1, sample2);
////		{3, 7, 9} + {5, 2, 3} = {8, 9, 2, 1}
//		while (prob3Return != null) {
//			System.out.print(prob3Return.getElement());
//			prob3Return = prob3Return.getNext();
//		}
		
//		System.out.println(prob4(sample1, 9));
		
//		prob5(sample1, sample2).printNodesBySize();
		
//		ArrayList<Node> prob6Array = prob6(sample3);
//		for (int i=0; i<prob6Array.size(); i++) {
//			System.out.println(prob6Array.get(i).getElement());
//		}
		
		SinglyLinkedList removedDups = prob7(sample4);
		Node remDupHead = removedDups.getHead();
		while (remDupHead != null) {
			System.out.println(remDupHead.getElement());
			remDupHead = remDupHead.getNext();
		}
	}
	
	public static Node prob1(SinglyLinkedList ll) {
		Node head = ll.getHead();
		Node current = head;
		Node previous = head;
		Node temp = current.getNext();
		head.setNext(null);
		while (current != null) {
//			{1->3->4->5} -> {5->4->3->1}
			if (temp == null) {				
				break;
			}
			current = temp;
			temp = current.getNext();
			current.setNext(previous);
			previous = current;
		}
		
		return current;
	}

	public static Node prob2(SinglyLinkedList ll1, SinglyLinkedList ll2) {
		Node head1 = ll1.getHead();
		Node head2 = ll2.getHead();
		
		SinglyLinkedList<Integer> returningList = new SinglyLinkedList<Integer>();
		Node current = new Node(0);
		returningList.add(current);
		while (head1 != null || head2 != null) {
			int result = (int)head1.getElement() + (int)head2.getElement() + (int)current.getElement();
			int resultCarryover = 0;
			if (result > 9) {
				resultCarryover = 1;
				result = result % 10;
			}
			current.setElement(result);
			Node carryoverNode = new Node(resultCarryover);
			returningList.add(carryoverNode);
			
			head1 = head1.getNext();
			head2 = head2.getNext();
			current = current.getNext();
		}
		return returningList.getHead();
	}

	public static boolean prob3(SinglyLinkedList ll) {
		Node tail = ll.tail;
		Node head = ll.head;

		if (tail.getNext() == head) {
			return true;
		}
		return false;
	}

	public static <E> List<Integer> prob4(SinglyLinkedList<E> eList, E item) {
		List<Integer> returningList = new ArrayList<Integer>();
		for (int i=0; i<eList.size(); i++) {
			if (_getByIndex(eList, i).equals(item)) {
				returningList.add(i);
			}
		}
		return returningList;
	}
	public static <E> E _getByIndex(SinglyLinkedList<E> eList, int index) {
		if (index >= eList.size()) {
			return null;
		}
		return eList.get(index);
	}
	
	public static SinglyLinkedList prob5(SinglyLinkedList ll1, SinglyLinkedList ll2) {
//		Here we can assume ll1 as a whole number > ll2 as a whole number
//		I.e. 900 > 899
		Node head1 = ll1.getHead();
		Node head2 = ll2.getHead();
		
		SinglyLinkedList<Integer> returningList = new SinglyLinkedList<Integer>();
		
//		Turn ll1 into an int
		String strWholeNumber1 = "";
		while (head1 != null) {
			strWholeNumber1 = head1.getElement() + strWholeNumber1;
			head1 = head1.getNext();
		}
		int wholeNum1 = 0;
		try {
			wholeNum1 = Integer.parseInt(strWholeNumber1);
		} catch(Exception e) {
			System.out.println(e);
		}
		
//		Turn ll2 into an int
		String strWholeNumber2 = "";
		while (head2 != null) {
			strWholeNumber2 = head2.getElement() + strWholeNumber2;
			head2 = head2.getNext();
		}
		int wholeNum2 = 0;
		try {
			wholeNum2 = Integer.parseInt(strWholeNumber2);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		int result = wholeNum1 - wholeNum2;
		String strResult = result+"";
		
		for (int index=0; index<strResult.length(); index++) {
			returningList.add(Integer.parseInt(strResult.charAt(index)+""));
		}
		
		return returningList;
	}
	
	public static ArrayList<Node> prob6(SinglyLinkedList ll) {
		int llSize = (int)ll.size();
		int currentNodeIndex = 0;
		Node current = ll.getNode(currentNodeIndex);
		
		ArrayList<Node> middleNodes = new ArrayList<Node>();

//		Get to the middle of the LinkedList
		while (currentNodeIndex != (llSize/2)) {
			current = current.getNext();
			currentNodeIndex++;
		}
		middleNodes.add(current);
//		If even length, grab the 2nd middle node
		if (llSize % 2 == 0) {
			middleNodes.add(current.getNext());
		}
		return middleNodes;
	}
	
	public static <E> SinglyLinkedList<E> prob7(SinglyLinkedList ll) {
		/*
		7. Remove Duplicates
		Given a linked list with duplicate elements, write a method that will remove the duplicates from the linked list and return the new cleaned linked list. (i.e. you have 2->7->3->5->2->3, after running the method it should look like 2->7->3->5)
		*/
		SinglyLinkedList<E> uniqueElementsList = new SinglyLinkedList<E>();
		Node current = ll.getHead();
		ll.printNodesBySize();
		System.out.println(current);
		System.out.println(current.getNext());
		System.out.println(current.getNext().getNext());
		
		while (current != null) {
//			If the list doesn't have the element, add it to the list
			System.out.println("current is " + current);
//			if (!uniqueElementsList.contains((E)current.getElement())) {
//				uniqueElementsList.add(current);
//				System.out.println("Added" + current.getElement());
//			}
			
			current = current.getNext();
			System.out.println("next is " + current);
		}
		System.out.println("End");
		return uniqueElementsList;
	}
	
	public static int prob8(SinglyLinkedList ll, int n) {
		/*
		8. Count instances of …
		Given a linked list and a value n, return the number of times n shows up in the linked list. (i.e. 2->8->6->4->2->3->2 and n=2, the return value should be 3 since 2 shows up 3 times in the linked list).
		*/
		Node current = ll.getHead();
		int numInstances = 0;
		
		while (current != null) {
			if ((int)current.getElement() == n) {
				numInstances++;
			}
			
			current = current.getNext();
		}
		
		return numInstances;
	}
	
	
}
