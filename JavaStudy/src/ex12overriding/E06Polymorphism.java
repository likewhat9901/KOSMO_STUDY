package ex12overriding;

/*
 * 다형성(Polymorphism)
 * : 하나의 인스턴스(객체)를 여러 타입의 참조변수를 통해 참조할 때, 참조변수의 타입에 따라 다양한 형태의
 * 인스턴스를 이용할 수 있는 특성을 말한다.
 * - 부모타입의 참조변수로 자식 인스턴스를 참조
 * 1. 이경우 부모타입의 참조변수는 부모로부터 상속받은 멤버까지만 접근할 수 있다.
 * 2. 자식에서 오버라이딩한 메서드가 우선적으로 호출된다.
 * 3. 자식에서 새롭게 정의한 멤버는 접근할 수 없다.
 * 4. 이것을 이질화(Heterogeneous:헤테로지니어스)라고 표현한다.
 * 
 * - 동일한 타입의 참조변수로 인스턴스를 참조
 * 1. 인스턴스 전체를 접근할 수 있다. 즉 클래스의 일반적인 규칙을 따른다.
 * 2. 이것을 동질화(Homogeneous:호모지니어스)라고 표현한다.
 */

//부모클래스
class MyParent {
	int parentMember;
	void parentMethod() {
		System.out.println("부모의 메소드: parentMethod()");
	}
}

//자식클래스
class MyChild extends MyParent{
	//자식에서 확장한 멤버
	int childMember;
	void childMethod() {
		System.out.println("자식의메소드: childMethod()");
	}
	//부모에서 정의한 메서드를 오버라이딩해서 재정의한 메서드.
	@Override
	void parentMethod() {
		System.out.println("자식에서 Overriding한 메소드"+"parentMethod()");
	}
	/*
	 * 메서드명은 동일하지만 매개변수가 틀리므로 오버로딩으로 정의한 메서드.
	 * 따라서 자식에서 확장한 멤버가 된다.
	 */
	void parentMethod(int childMember) { //Overload
		this.childMember = childMember;
		System.out.println("Overloading: 자식에서 확장한 메소드"+ ":parentMethod(param1)");
	}
}

public class E06Polymorphism {

	public static void main(String[] args) {
		
		//동질화: 참조변수와 인스턴스의 타입이 동일
		MyChild myChild = new MyChild(); //MyChild 타입의 MyChild 클래스 객체 생성
		//동질화의 경우 인스턴스 전체를 접근할 수 있다.
		myChild.childMember = 10; //MyChild 클래스의 childMember 변수 정의
		myChild.parentMember = 100; //MyChild 클래스에서 상속받은 parentMember 변수 정의
		myChild.childMethod(); //MyChild 클래스의 childMethod 메소드 실행
		myChild.parentMethod(1000); //MyChild 클래스의 parentMethod(int childMember) 메소드 실행
		myChild.parentMethod(); //MyChild 클래스의 parentMethod 메소드 실행
		
		/*
		 * 이질화: 부모타입의 변수로 자식인스턴스를 참조하는 것을 말한다.
		 * 이경우 자식 클래스에서 새롭게 정의한 멤버는 접근할 수 없다. 접근하고 싶다면 자식타입으로
		 * 강제형변환(다운캐스팅) 해야한다.
		 */
		MyParent parent1 = myChild;
		parent1.parentMember = 1;
		//부모타입으로 자식 인스턴스에 접근할 수 없으므로 에러 발생.
//		parent1.childMember = 1; //에러. 
		//오버라이딩 한 메서드이므로 자식쪽이 호출된다.
		parent1.parentMethod();
//		parent1.childMethod();
//		parent1.parentMethod(2);
		
		//부모 참조변수로 자식 인스턴스를 참조한 두번째 인스턴스 생성
		MyParent myParent = new MyChild();
		myParent.parentMember = 1;
		myParent.parentMethod();
		
		/*
		 * 부모 참조변수로 접근하려면 강제형변환(다운캐스팅) 해야한다.
		 * 하지만 아래와 같이 기술하면 에러가 발생한다.
		 * (MyChild)myParent.childMember = 1;
		 * 소괄호를 하나 더 추가해서 myParent를 자식타입으로 형변환 후 멤버변수에 접근해야 한다.
		 */
		((MyChild)myParent).childMember = 1;
		((MyChild)myParent).childMethod();
		((MyChild)myParent).parentMethod();
		
		/*
		 * 자식타입으로 형변환 이후에 해당 참조변수를 통해 자식 멤버에 접근한다. 위와 동일한 방식임.
		 */
		MyChild child2 = (MyChild)myParent;
		child2.childMember = 1;
		child2.childMethod();
		child2.parentMethod(1);
		
		/*
		 * Java에서 생성한 모든 클래스는 Object 클래스를 상속한다. 따라서 모든 인스턴스는
		 * Object의 참조변수로 참조가 가능하다. 또한 Object 클래스에 정의된 모든 메서드를
		 * 별도의 선언없이 사용할 수 있고, 필요하다면 오버라이딩도 할 수 있다.
		 */
		Object object = new MyChild();
		((MyParent)object).parentMethod();
//		object.parentMethod();
	}
}

class MyClass {
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
}
