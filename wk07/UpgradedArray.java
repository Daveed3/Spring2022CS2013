package wk07;

public class UpgradedArray {
	String[] arr;
	int size;
	
	public UpgradedArray() {
		this.size = 0;
		this.arr = new String[this.size];
	}
	
	public void add(String n) {
		this.size++;
		System.out.println(this.size);
		if (this.size > this.arr.length) {
			String[] temp = new String[this.size*2];
			for (int i=0; i<this.size-1; i++) {
				temp[i] = this.arr[i];
			}
			this.arr = temp;
		}
		this.arr[this.size-1] = n;
	}
	public void remove(String n) {
		boolean removeIndex = false;
		for (int i=0; i<this.size; i++) {
			if (n.equals(this.arr[i])) {
				removeIndex = true;
			}
			if (removeIndex && i+1 < size) {
				this.arr[i] = this.arr[i+1];
			}
		}
		if (removeIndex) {
			this.arr[this.size-1] = "";
		}
	}
	public int length() {
		return this.size;
	}
	
	public void _printArr() {
		for (int i=0; i<this.size; i++) {
			System.out.print(this.arr[i] + " ");
		}
		System.out.println();
	}
}
