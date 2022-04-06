package wk09;

public class DoublyNode<T> {
	// instance variables
		private T element;
		private DoublyNode<T> next;
		private DoublyNode<T> previous;

		// constructor first
		public DoublyNode() {
			this(null, null);
		}
		
		public DoublyNode(T element) {
			this.element = element;
		}

		public DoublyNode(T element, DoublyNode<T> next) {
			this.element = element;
			this.next = next;
		}

		public T getElement() {
			return element;
		}

		public DoublyNode<T> getNext() {
			return next;
		}

		public DoublyNode<T> getPrevious() {
			return previous;
		}
		
		public void setElement(T element) {
			this.element = element;
		}

		public void setNext(DoublyNode<T> next) {
			this.next = next;
		}
		
		public void setPrevious(DoublyNode<T> previous) {
			this.previous = previous;
		}
}
