package ex12inheritance;

//직사각형을 표현한 클래스
class Rectangle {
	private int width, height;
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	public void showAreaInfo() {
		System.out.printf("직사각형 면적: %d%n", (width*height));
	}
	
} 
//정사각형을 표현한 클래스(정사각형은 직사각형의 일종)
class Square extends Rectangle {
	public Square(int side) {
		super(side, side);
	}
} 

class QuRectangleMain {
	public static void main(String[] args) {
	       	Rectangle rec = new Rectangle(4, 3);
	       	rec.showAreaInfo();

     		Square sqr = new Square(7);
	       	sqr.showAreaInfo();
 	}
}
