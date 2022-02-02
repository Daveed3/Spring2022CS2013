package wk01;

public class Square extends Shape {
	int perimeter;
	
	public Square(String name, String color, int perimeter) {
		super(name, color);
		
		this.perimeter = perimeter;
	}
	
	public String toString() {
		return this.name + " is " + this.color + " and has perimeter " + this.perimeter ;
	}

}
