package wk08;

//adapted from http://.com/a-simple-singly-linked-list-implementation-in-java/
public class Node<T> {
	// instance variables
	private T element;
	private Node<T> next;

	// constructor first
	public Node() {
		this(null, null);
	}
	public Node(T element) {
		this.element = element;
	}
	public Node(T element, Node<T> next) {
		this.element = element;
		this.next = next;
	}
	public T getElement() {
		return element;
	}
	public Node<T> getNext() {
		return next;
	}
	public void setElement(T element) {
		this.element = element;
	}
	public void setNext(Node<T> next) {
		this.next = next;
	}
}
