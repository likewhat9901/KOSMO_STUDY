package ex12inheritance;

class Point {
   	int xDot, yDot;
   	public Point(int x, int y) {
         		xDot=x;
         		yDot=y;
   	}
   	public void showPointInfo() {
         		System.out.println("[x좌표:"+xDot+", y좌표:"+yDot+"]");
   	}
}
//Point클래스를 기반으로 원(Circle) 클래스 표현하기
class Circle{	
	//멤버변수
	int radian;//반지름
	Point center;
	
	public Circle(int x, int y, int r) {
		center = new Point(x, y);
		radian = r;
	}
	
	public void showCircleInfo() {
		System.out.println("반지름: " + radian);
		center.showPointInfo();
	}
}
//원 2개를 겹쳐서 링을 표현하는 클래스
class Ring{
	//멤버변수
	Circle innerCircle;//안쪽의 원
	Circle outerCircle;//바깥쪽의 원

	public Ring(int in_x,int in_y, int in_r, int out_x, int out_y, int out_r) {
		innerCircle = new Circle(in_x, in_y, in_r);
		outerCircle = new Circle(out_x, out_y, out_r);
	}
	
	public void showRingInfo() {
		System.out.println("안쪽원의 정보: ");
		innerCircle.showCircleInfo();
		
		System.out.println("바깥쪽원의 정보: ");		
		outerCircle.showCircleInfo();
	}
	
	
}
class QuRingMake {
	public static void main(String[] args) {
		Ring c = new Ring(1,1,3,2,2,9);
		c.showRingInfo();
	}
}
