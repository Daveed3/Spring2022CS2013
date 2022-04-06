package wk09;

public class DoublyLinkedList<T> {
	protected DoublyNode<T> head, tail;
	protected long size;

	public DoublyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public void addFirst(T element) {
		DoublyNode<T> node = new DoublyNode<T>(element);
		addFirst(node);
	}

	public void addFirst(DoublyNode<T> node) {
		if (tail == null)
			tail = node;
		node.setNext(head);
		head = node;
		size++;
	}

	public void add(T element) {
		DoublyNode<T> node = new DoublyNode<T>(element);
		if (tail == null)
			addFirst(node);
		else
			add(node);
	}

	public void add(DoublyNode<T> nodeToAdd) {
		nodeToAdd.setNext(null);
		if (tail == null) {
			tail = nodeToAdd;
			head = nodeToAdd;
		} else {
			tail.setNext(nodeToAdd);
			nodeToAdd.setPrevious(tail);
		}
		tail = nodeToAdd;
		size++;
	}
	
	public void addInN(T element, int n) {
		DoublyNode<T> node = new DoublyNode<T>(element);
		
		if (n == 0) {
//			If node is first, just use add first method
			addFirst(node);
		} else if (n == size-1) {
			add(node);
		} else {
			DoublyNode<T> tempCurrent = getNode(n-1);
			DoublyNode<T> tempNext = getNode(n);
			
			tempCurrent.setNext(node);
			node.setPrevious(tempCurrent);
			tempCurrent = tempCurrent.getNext();
			tempCurrent.setNext(tempNext);
			tempNext.setPrevious(tempCurrent);
		}
		
		size++;
	}

	public void printNodesBySize() {
		DoublyNode<T> tempHead = head;
		for (int i=0; i<size; i++) {
			System.out.println(tempHead + " " + tempHead.getElement());
			tempHead = tempHead.getNext();
		}
	}
	
	public void printNodesBySizeBackwards() {
		DoublyNode<T> tempTail = tail;
		for (int i=(int)size; i>0; i--) {
			System.out.println(tempTail + " " + tempTail.getElement());
			tempTail = tempTail.getPrevious();
		}
	}
	
	public void printXNodes(int x) {
		DoublyNode<T> tempHead = head;
		for (int i=0; i<x; i++) {
			System.out.println(tempHead + " " + tempHead.getElement());
			tempHead = tempHead.getNext();
		}
	}
	
	public void addNotCycleSafe(DoublyNode<T> nodeToAdd) {
		DoublyNode<T> tempHead = head;
		boolean isInList = false;
//		Checking if the node is already in the list
		while (tempHead != null && !isInList) {
//		for (int i=0;i<size;i++) {
			System.out.println(tempHead + " " + tempHead.getElement());
			if (nodeToAdd.equals(tempHead)) {
//				The node is already in the list
//				Keep the tail (don't set it to null)
				if (tempHead.getNext() == null) {
					tempHead.setNext(tempHead);
				} else {
					tail.setNext(tempHead);
				}
				tail = nodeToAdd;
				isInList = true;
			}
			
			tempHead = tempHead.getNext();
		}
		
		if (!isInList) {			
	//		If the node isn't in the list
				nodeToAdd.setNext(null);
	//		Case when there's no node in the list
				if (tail == null) {
					tail = nodeToAdd;
					head = nodeToAdd;
				} else { // Case when there is already 1+ node(s)
	//			Get the current tail and set its next value to the node we're receiving 
					tail.setNext(nodeToAdd);
				}
				tail = nodeToAdd;
				size++;
		}
	}
	
	public boolean hasCycle() {
//		May need to check on Floyd's to see what it is
//		if (getTail().getNext() != null) {
//			if (getTail().getNext().equals(head)) {
//				return true;
//			}			
//		}
		if (tail.getNext() != null) {
			return true;
		}
		return false;
	}

	public void removeFirst() {
		if (head == null)
			return;
		DoublyNode<T> temp = head;

		head = head.getNext();
		temp.setNext(null);
		size--;
	}

	public void removeLast() {
		DoublyNode<T> nodeBefore;

		if (size == 0)
			return;
		nodeBefore = head;

		for (int count = 0; count < size - 2; count++)
			nodeBefore = nodeBefore.getNext();
		nodeBefore.setNext(null);
		tail = nodeBefore;
		size--;
	}

	public void remove(T element) {
		if (size == 0)
			return;
		DoublyNode<T> currNode = head;
		do {
			if (currNode.getElement().equals(element)) {

				if (currNode == head) {
					removeFirst();
					currNode = head;
				} else if (currNode == tail) {
					removeLast();
					currNode = tail;
				} else {
					DoublyNode<T> next = currNode.getNext();
					remove(currNode);
					currNode = next;
				}
			} else
				currNode = currNode.getNext();
		} while (currNode != null);

	}

	public void remove(DoublyNode<T> nodeToRemove) {
		DoublyNode<T> nodeBefore, currentNode;
		if (size == 0)
			return;

		currentNode = head;
		if (currentNode == nodeToRemove)
			removeFirst();
		currentNode = tail;
		if (currentNode == nodeToRemove)
			removeLast();

		if (size - 2 > 0) {
			nodeBefore = head;
			currentNode = head.getNext();
			for (int count = 0; count < size - 2; count++) {
				if (currentNode == nodeToRemove) {
					nodeBefore.setNext(currentNode.getNext());
					size--;
					break;
				}

				nodeBefore = currentNode;
				currentNode = currentNode.getNext();
			}
		}
	}

	public T get(int index) {
		DoublyNode<T> currNode = head;
		if (index >= size)
			return null;
		for (int counter = 0; counter < index; counter++)
			currNode = currNode.getNext();
		return currNode.getElement();
	}

	public DoublyNode<T> getNode(int index) {
		DoublyNode<T> currNode = head;
		if (index >= size)
			return null;
		for (int counter = 0; counter < index; counter++) {
			
			currNode = currNode.getNext();
		}
		return currNode;
	}

	public long size() {
		return size;
	}

	public DoublyNode<T> getTail() {
		return tail;
	}

	public boolean contains(T element) {
		if (head == null)
			return false;
		DoublyNode<T> currNode = head;
		while (currNode.getNext() != null) {
			if (currNode.getElement().equals(element))
				return true;
			currNode = currNode.getNext();
		}
		if (currNode.getElement().equals(element))
			return true;
		return false;
	}
}
