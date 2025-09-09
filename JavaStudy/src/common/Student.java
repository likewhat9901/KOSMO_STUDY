package common;

public class Student extends Person {

	private String stNumber;

	public Student(String name, int age, String stNumber) {
		//자식 인스턴스를 생성하기전 부모생성자를 먼저 호출해야 한다.
		super(name, age);
		this.stNumber = stNumber;
	}
	@Override
	public String toString() {
		/*
		 * 부모에 정의된 toString을 먼저 호출한 후 자식쪽의 멤버를 추가한다.
		 */
		return super.toString() + ", 학번:"+ stNumber;
	}
	
}
