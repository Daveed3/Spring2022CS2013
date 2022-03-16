package wk07;

public class CustomString {
	char[] str;
	
	public CustomString() {
		this.str = new char[0];
	}
	public CustomString(char[] chars) {
		this.str = chars;
	}
	public CustomString(String inputStr) {
		this.str = new char[inputStr.length()];
		for (int i=0; i<inputStr.length(); i++) {
			str[i] = inputStr.charAt(i);
		}
	}
	
//	Add single letter
	public void add(char letter) {
		char[] newStr = new char[this.str.length + 1];
		
//		Add all original chars
		for (int i=0; i<this.str.length; i++) {
			newStr[i] = this.str[i];
		}
		
//		Add new letter
		newStr[this.str.length] = letter;
		
		this.str = newStr;
	}
	
//	Add multiple letters
	public void add(String letters) {
		char[] newStr = new char[this.str.length + letters.length()];
		
//		Add all original chars
		for (int i=0; i<this.str.length; i++) {
			newStr[i] = this.str[i];
		}
		
//		Add new letters
		for (int i=0; i<letters.length(); i++) {
			newStr[this.str.length + i] = letters.charAt(i);
		}
		
		this.str = newStr;
	}

//	Substring
	public char[] substring(int start, int endExclusive) {
		char[] returnStr = new char[endExclusive-start];
		
//		Index counter for returnStr - used to stay inbounds
		int rIndex =0;
		for (int i=start; i<endExclusive; i++) {
			returnStr[rIndex] = this.str[i];
			rIndex++;
		}
		
		return returnStr;
	}
	
//	Print the "string"
	public void print() {
		for (int i=0; i<this.str.length; i++) {
			System.out.print(this.str[i]);
		}
		System.out.println();
	}
	
}
