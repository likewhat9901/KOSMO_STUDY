package ex12overriding;

class MyA {
	public void rideMethod() {
		System.out.println("MyA의 rideMethod");
	}
}
class MyB extends MyA {
	@Override
	public void rideMethod() {
		System.out.println("MyB의 rideMethod");
	}
}
class MyC extends MyB {
	@Override
	public void rideMethod() {
		System.out.println("MyC의 rideMethod");
	}
}

public class E03ReferenceYesNo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 부모 참조변수로 자식 인스턴스를 참조할 수 있다. 좌측은 부모, 우측은 자식이므로 모두
		 * 실행가능한 문장이다.
		 */
		MyA refNum1 = new MyB(); //MyA 참조해서 MyB() 실행
		MyA refNum2 = new MyC(); //MyA 참조해서 MyC() 실행
		MyB refNum3 = new MyC(); //MyB 참조해서 MyC() 실행
		
		//같은 타입이므로 참조가능
		MyC refMyAddr1 = new MyC();
		//MyB -> MyC타입을 참조하므로 가능
		MyB refMyAddr2 = refMyAddr1;
		//MyA -> MyC타입을 참조하므로 가능
		MyA refMyAddr3 = refMyAddr1;
		
		//MyA -> MyC를 참조하므로 가능
		MyA refId1 = new MyC();
		//MyB -> MyA를 참조하므로 불가능(자식은 부모 참조불가)
//		MyB refId2 = refId1; 
		//MyC -> MyA를 참조하므로 불가능
//		MyC refId3 = refId1;
		/*
		 * refId1은 MyC 인스턴스를 참조하지만, 원래 MyA 타입이므로 MyC타입이라 착각하면 안된다.
		 */
		
		/*
		 * 자식으로 부모인스턴스를 참조하는 것은 기본적으로 불가능하다.
		 * 하지만 다운캐스팅(강제형변환)을 하면 참조가 가능해진다.
		 * 즉, 부모타입을 자식타입으로 변경하는 것이다. 이는 클래스가 상속관계에 있기 때문에 가능하고,
		 * 방식은 기본자료형과 동일하게 소괄호를 이용하면 된다.
		 */
		MyB refId2 = (MyB) refId1; //다운캐스팅. 명시적으로 변환.
		if (refId1 instanceof MyB) {
//		    MyC refId2 = (MyC) refId1;
			System.out.println("정상적으로 MyB 타입으로 변환됨!");
		}
		
		MyC refId3 = (MyC) refId1;
		if (refId1 instanceof MyC) {
//		    MyC refId3 = (MyC) refId1;
		    System.out.println("정상적으로 MyC 타입으로 변환됨!");
		}
	}
}
