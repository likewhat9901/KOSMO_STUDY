package ex08class;

public class E02HumanMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 1.클래스를 통해 인스턴스를 생성.
		 - 참조변수(인스턴스형 변수)는 스택에, 인스턴스는 힙에 생성된다.
		 */
		Human human = new Human();
		
		/*
		 2.인스턴스 초기화
		 - 멤버변수를 통해 .(dat)으로 접근하여 초기값을 할당한다.
		 */
		human.name = "마이클";
		human.age = 28;
		human.energy = 4;
		
		human.showState(); //? 이름, 나이, 에너지 출력
		human.eating(); //? eat 멤버메서드 출력. 에너지 +2
		human.walking(); //? walking 멤버메서드 출력. 에너지 -1
		human.thinking(); //? thinking 멤버메서드 출력. 에너지 -2
		
		human.showState(); // -> 멤버메서드 호출 후 객체의 상태 확인
		// 에너지가 3으로 출력된다.
		
		/*
		 4.반복문을 통해 멤버메서드를 여러번 호출한다.
		 - 시나리오에서 제시한 조건들이 정확히 구현되었는지 확인한다.
		 */
		for(int i=1 ; i<=20 ; i++) { //? walking 20번 반복.
			human.walking();
		}
		human.showState();		
		for(int i=1 ; i<=20 ; i++) {
			human.eating();
		}
		human.showState();
	}

}
