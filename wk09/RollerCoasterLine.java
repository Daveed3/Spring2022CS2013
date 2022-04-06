package wk09;

public class RollerCoasterLine<T> {
	protected Node<T> head, tail;
	protected long size;

	public RollerCoasterLine() {
		head = null;
		tail = null;
		size = 0;
	}

	public void addFirst(T element) {
		Node<T> node = new Node<T>(element);
		addFirst(node);
	}

	public void addFirst(Node<T> node) {
		if (tail == null)
			tail = node;
		node.setNext(head);
		head = node;
		size++;
	}

	public void add(T element) {
		Node<T> node = new Node<T>(element);
		if (tail == null)
			addFirst(node);
		else
			add(node);
	}

	public void add(Node<T> nodeToAdd) {
		nodeToAdd.setNext(null);
		if (tail == null) {
			tail = nodeToAdd;
			head = nodeToAdd;
		} else
			tail.setNext(nodeToAdd);
		tail = nodeToAdd;
		size++;
	}
	
	public void addInN(T element, int n) {
		Node<T> node = new Node<T>(element);
		
		if (n == 0) {
//			If node is first, just use add first method
			addFirst(node);
		} else if (n == size-1) {
			add(node);
		} else {
			Node<T> tempCurrent = getNode(n-1);
			Node<T> tempNext = getNode(n);
			
			tempCurrent.setNext(node);
			tempCurrent = tempCurrent.getNext();
			tempCurrent.setNext(tempNext);
		}
		
		size++;
	}

	public void printNodesBySize() {
		Node<T> tempHead = head;
		for (int i=0; i<size; i++) {
			System.out.println(tempHead + ": " + tempHead.getElement());
			tempHead = tempHead.getNext();
//			if (tempHead != null) {
//				System.out.println("next is " + tempHead.getElement());
//			}
		}
	}
	
	public void printXNodes(int x) {
		Node<T> tempHead = head;
		for (int i=0; i<x; i++) {
			System.out.println(tempHead + ": " + tempHead.getElement());
			tempHead = tempHead.getNext();
		}
	}
	
	public void addNotCycleSafe(Node<T> nodeToAdd) {
		Node<T> tempHead = head;
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
		Node<T> temp = head;

		head = head.getNext();
		temp.setNext(null);
		size--;
	}

	public T get(int index) {
		Node<T> currNode = head;
		if (index >= size)
			return null;
		for (int counter = 0; counter < index; counter++)
			currNode = currNode.getNext();
		return currNode.getElement();
	}

	public Node<T> getNode(int index) {
		Node<T> currNode = head;
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

	public Node<T> getTail() {
		return tail;
	}
	
	public Node<T> getHead() {
		return head;
	}

	public boolean contains(T element) {
		if (head == null)
			return false;
		Node<T> currNode = head;
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
