package ex12overriding;

public class DeParent {
	//멤버변수 : 정보은닉을 위해 private으로 정의
	private String name;
	private int age;
	
	//생성자 : 디폴트와 인자생성자 정의
	public DeParent() {}
	public DeParent(String name, int age) { //생성자 오버로딩
		this.name = name;
		this.age = age;
	}
	//getter메서드 : private 멤버를 클래스외부로 반환.
	public String getName() { //public, 이름 출력
		return name;
	}
	
	/*
	 * 아래 정의된 멤버메서드는 4가지 접근지정자를 통해 선언. 차후 자식클래스에서 접근 가능여부를
	 * 판단할 예정.
	 */
	private void eat() { //private, 상속불가
		System.out.println("부모님이 드신다");
	}
	String sleep() { //default, 상속불가
		System.out.println("부모님이 주무신다.");
		return null;
	}
	protected void walk() { //protected, 상속가능
		System.out.println("부모님이 산책하신다.");
	}
	public void exercise() { //public, 상속가능
		System.out.println("부모님이 운동하신다.");
	}
	
	//정보출력용 메서드로 멤버변수를 출력
	public void printParent() { //public, 상속가능
		System.out.printf("성함:%s, 연세:%d", name, age);
	}
	
	//static으로 선언된 정적메서드
	public static void staticMethod() { //static, 오버라이딩 불가
		System.out.println("부모님의 정적메소드");
	}
}
