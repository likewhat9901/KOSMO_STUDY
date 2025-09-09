package ex03operator;

public class E04LogicOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 논리연산자
		 &&
		 - 논리 And
		 - 양쪽 모두가 true 일때만 true 를 반환. 나머지는 false.
		 ||
		 - 논리 Or
		 - 한쪽만 true 이면 true 반환. 양쪽 모두 false 일때 false 반환.
		 !
		 - 논리 not
		 - 반대의 논리를 반환.
		 */
		int num1 = 10, num2 = 20;
		
		// false && true => false
		boolean result1 = (num1 == 100 && num2 == 20);
		// true || false => true
		boolean result2 = (num1 < 12 || num2 >= 30);
		
		System.out.println("result1의 결과:" + result1);
		System.out.println("result2의 결과:" + result2);
		
		// !(false) = > true 이므로 if 문의 블럭이 실행.
		if(!(num1 == num2)) {
			System.out.println("num1과 num2는 같지 않다.");
		}else {
			System.out.println("num1과 num2는 같다.");
		}
	}
}
