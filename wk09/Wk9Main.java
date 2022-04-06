package wk09;

/*
1. Merging Sorted Linked Lists
Given 2 sorted linked lists, provide a method that would return a single linked list of all the elements in a sorted order
i.e. You're given 1->3->5 and 2->4->6. You should return
1->2->3->4->5->6
*/
/*
2. Insert into nth index
Given a linked list, you realize you're missing an element in the middle of the linked list. Provide a method within the SinglyLinkedList class to be able to add an element into index n. (Don't forget to keep the rest of the list intact)
i.e. You have 1->3->4->5 and you forgot 2. Create a method so that you can add 2 after 1 (and before 3) to result in
1->2->3->4->5
i.e. You have "This" -> "is" -> "a" -> "test" but want to add in "hard" before the word "test". So your method should return
"This" -> "is" -> "a" -> "hard" -> "test"
 */
/*
3. Doubly Linked List
Use the code from the SinglyLinkedList as your base in another class for a DoublyLinkedList. The idea is that you want to be able to reference a next and a previous node from the current node. So SinglyLinkedList like 1->3->7 would look like 1<->3<->7 in a DoublyLinkedList.
(Bonus, complete this with the method from #2).
 */
/*
4. Stacks of Plates and Rollercoaster lines
Provide 2 additional classes similar to SinglyLinkedList (or DoublyLinkedList if you have that completed). You can name one Plates and the other RollerCoasterLine. 
For Plates ONLY keep the remove method that removes that last element. For RollerCoasterLine ONLY keep the remove method that removes the first element.
Test out adding a couple of elements to each new class and use their remove methods.
*/
/*
5. Check if a linked list is palindrome
Given a linked liked, write a method that will return whether that linked list is a palindrome. (i.e. Given 1->4->1, the method will return true. Given 1-4->5, the method will return false)
*/
/*
6. Delete from Linked List
Given a linked list and an element n, delete n if it is in the linked list. Be sure to print out the list to check whether your linked list is still intact or not.
*/
/*
7. Rotate a Linked List
Given a linked list and int k, rotate the linked list clockwise by k nodes. (i.e. your linked list is 5->10->15, and k=1, the linked list should look like 15->5->10 OR your linked list is 5->10->15->20->25->30 and k=4, the linked list should look like 15->20->25->30->5->10)
*/

public class Wk9Main {
	public static void main(String[] args) {
		SinglyLinkedList<Integer> sample1 = new SinglyLinkedList<Integer>();
		sample1.add(3);
		sample1.add(7);
		sample1.add(9);
		//973
		SinglyLinkedList<Integer> sample2 = new SinglyLinkedList<Integer>();
		sample2.add(2);
		sample2.add(3);
		sample2.add(5);
		//532
		SinglyLinkedList<Integer> palindromeSample = new SinglyLinkedList<Integer>();
		int[][] palindromeSamples = {
				{1, 3, 1},
				{1, 2, 3, 4, 3, 2, 1},
				{6, 1, 8, 4, 4, 8, 1, 6},
				{9, 2, 6, 3, 3, 6, 2, 9}
		};
		int pSampleNum = 3;
		for (int i=0; i<palindromeSamples[pSampleNum].length; i++) {
			palindromeSample.add(palindromeSamples[pSampleNum][i]);
		}
				
//		Node prob1Result = prob1(sample1, sample2);
//		while (prob1Result != null) {
//			System.out.print(prob1Result.getElement() + " " );
//			prob1Result = prob1Result.getNext();
//		}
		
		
//		prob2(sample1);
		
		
//		DoublyLinkedList<Integer> sample3 = new DoublyLinkedList<Integer>();
//		sample3.add(2);
//		sample3.add(6);
//		sample3.add(1);
//		sample3.add(5);
//		sample3.add(9);
//		prob3(sample3);
		
//		prob4();
		
//		System.out.println(prob5(sample1));
		
//		SinglyLinkedList llWithDelete = prob6(palindromeSample, 3);
//		llWithDelete.printNodesBySize();
		
//		SinglyLinkedList rotatedList = prob7(palindromeSample, 1);
//		rotatedList.printNodesBySize();
		
	}
	
	public static Node prob1(SinglyLinkedList ll1, SinglyLinkedList ll2) {
		Node head1 = ll1.getNode(0);
		Node head2 = ll2.getNode(0);
		
		Node result = new Node(-1);
		Node current = result;
		boolean firstValue = true;
		
		while ((head1 != null || head2 != null)) {
			if (head1 != null && head2 != null) {
				if ((int)head1.getElement() <= (int)head2.getElement()) {
					if (firstValue) {
						Node newHead = new Node(head1.getElement());
						result = newHead;
						current = newHead;
						firstValue = false;
					} else {
						Node head1Copy = new Node(head1.getElement());
						current.setNext(head1Copy);
						current = current.getNext();
					}
					head1 = head1.getNext();
				} else if ((int)head1.getElement() >= (int)head2.getElement()) {
					if (firstValue) {
						Node newHead = new Node(head2.getElement());
						result = newHead;
						current = newHead;
						firstValue = false;
					} else {
						Node head2Copy = new Node(head2.getElement());
						current.setNext(head2Copy);
						current = current.getNext();
					}
					head2 = head2.getNext();
				}	
			} else {
				if (head2 == null) {
					if (firstValue) {
						Node newHead = new Node(head1.getElement());
						result = newHead;
						current = newHead;
						firstValue = false;
					} else {
						Node head1Copy = new Node(head1.getElement());
						current.setNext(head1Copy);
						current = current.getNext();
					}
					head1 = head1.getNext();
				} else if (head1 == null) {
					if (firstValue) {
						Node newHead = new Node(head2.getElement());
						result = newHead;
						current = newHead;
						firstValue = false;
					} else {
						Node head2Copy = new Node(head2.getElement());
						current.setNext(head2Copy);
						current = current.getNext();
					}
					head2 = head2.getNext();
				}
			}
		}
		
		return result;
	}
	
	public static void prob2(SinglyLinkedList sample) {
		sample.printNodesBySize();
		sample.addInN(4, 1);	
		sample.printNodesBySize();
		
	}
	
	public static void prob3(DoublyLinkedList sample) {
		System.out.println("Forward------------");
		sample.printNodesBySize();
		System.out.println("Backward------------");
		sample.printNodesBySizeBackwards();
	}

	public static void prob4() {
		/* 4. Stacks of Plates and Rollercoaster lines
		Provide 2 additional classes similar to SinglyLinkedList (or DoublyLinkedList if you have that completed). You can name one Plates and the other RollerCoasterLine. 
		For Plates ONLY keep the remove method that removes that last element. For RollerCoasterLine ONLY keep the remove method that removes the first element.
		Test out adding a couple of elements to each new class and use their remove methods.
		*/
		int[] sampleNums = {4, 1, 6, 3};
		Plates stack = new Plates();
		RollerCoasterLine queue = new RollerCoasterLine();
		
		for (int i=0; i<sampleNums.length; i++) {
			stack.add(sampleNums[i]);
			queue.add(sampleNums[i]);
		}
		
		System.out.println("Before removing");
		System.out.println("Stack");
		stack.printNodesBySize();
		System.out.println("Queue");
		queue.printNodesBySize();
		
		System.out.println("After removing");
		stack.removeLast();
		queue.removeFirst();
		System.out.println("Stack");
		stack.printNodesBySize();
		System.out.println("Queue");
		queue.printNodesBySize();
		
		
	}

	public static boolean prob5(SinglyLinkedList ll) {
		/*
		5. Check if a linked list is palindrome
		Given a linked liked, write a method that will return whether that linked list is a palindrome. (i.e. Given 1->4->1, the method will return true. Given 1-4->5, the method will return false)
		*/
		Node current = ll.getHead();
//		Check to see if the number is an odd length
//		If it is, we can ignore the middle number (since you should be checking if itself matches itself)
		boolean oddLength = ll.size % 2 == 1;
		boolean addingToFirstHalf = true;
		
		int firstHalfSize = (int)Math.ceil(ll.size/2);
		int[] firstHalf = new int[firstHalfSize];
		int firstHalfLength = 0;
		
		
		while (current != null) {
			if (addingToFirstHalf && firstHalfLength < firstHalf.length) {
//				Add the first half of elements to a list to check for later
				firstHalf[firstHalfLength] = (int) current.getElement();
				firstHalfLength++;
//				System.out.println("Adding to the list" + current.getElement());
			}
			else if (addingToFirstHalf && oddLength) {
				addingToFirstHalf = false;
			}
			else {
//				Modifying some flags to escape the if statement
				addingToFirstHalf = false;
				firstHalfLength--;
//				Check if the opposite pairs are matching
//				If they're not, return false - that the number is not a palindrome
//				System.out.println("Checking " + (int) current.getElement() + " and " + firstHalf[firstHalfLength]);
				if ((int)current.getElement() != firstHalf[firstHalfLength]) {
					return false;
				}
			}
			
			current = current.getNext();
		}
		
		return true;
	}
	
	public static SinglyLinkedList prob6(SinglyLinkedList ll, int n) {
		/*
		6. Delete from Linked List
		Given a linked list and an element n, delete n if it is in the linked list. Be sure to print out the list to check whether your linked list is still intact or not.
		*/
		
		// By creating a new LinkedList
		// Also removing all instances
//		SinglyLinkedList ll2 = new SinglyLinkedList();
//		Node current = ll.getHead();
//		while (current != null) {
//			if ((int) current.getElement() != n) {
//				ll2.add(current.getElement());
//			}
//			
//			current = current.getNext();
//		}
		
		
		// By modifying current LinkedList
		// Also only removing 1 instance
		Node current2 = ll.getHead();
		Node prev2 = null;
		while (current2 != null) {
			// Special case if the node to remove is the first node
			if (prev2 == null && (int) current2.getElement() == n) {
				if (ll.head == null)
					break;
				Node temp = ll.head;

				ll.head = ll.head.getNext();
				temp.setNext(null);
				ll.size--;

				break;
			}
			else if ((int) current2.getElement() == n) {
				prev2.setNext(current2.getNext());
				current2.setNext(null);
				ll.size--;
				break;
			}
			
			prev2 = current2;
			current2 = current2.getNext();
		}
		ll.printNodesBySize();
		return ll;
	}

	public static SinglyLinkedList prob7(SinglyLinkedList ll, int k) {
		/*
		7. Rotate a Linked List
		Given a linked list and int k, rotate the linked list clockwise by k nodes. (i.e. your linked list is 5->10->15, and k=1, the linked list should look like 15->5->10 OR your linked list is 5->10->15->20->25->30 and k=4, the linked list should look like 15->20->25->30->5->10)
		*/
		// Could do
		// Make the tail point to the head
		// move the head k nodes
		// remove the k-1 .next pointer to be null
		// make the k-1 node to be the tail
		ll.getTail().setNext(ll.getHead());
		
		Node kMinus1 = ll.getHead();
		Node newHead = ll.getHead();
		for (int i=0; i<k; i++) {
			// This will set kMinus1 to be 1 node behind the new head
			if (i != 0) {
				kMinus1 = kMinus1.getNext();
			}
			newHead = newHead.getNext();
		}
		ll.head = newHead;
		kMinus1.setNext(null);
		ll.tail = kMinus1;
		
		return ll;
	}
	
}
