package wk01;

public abstract class Shape {
	String color;
	String name;
	
	public Shape(String name, String color) {
		this.name = name;
		this.color = color;
	}
	
	public String toString() {
		return this.name + " is " + this.color;
	}

}
