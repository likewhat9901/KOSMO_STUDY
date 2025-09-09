package ex03operator;

public class E02BokhapOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 복합대입연산자
		 - 산술연산자와 대입연산자를 연결해놓은 형태
		 - 좌우측 값을 연산하여 좌측의 변수에 대입하는 구조.
		 - 문법구조 상, 현재의 타입을 유지하는 특성.
		 */
		double e = 3.1;
		e += 2.1;
		e *= 2;
		e += e;
		// 변수 e에 모든 연산의 결과가 누적되어 출력된다. 연산이 누적됨.
		System.out.println("e의 결과값:" + e);
		
		int n = 5;
		/*
		 정수와 실수를 연산하면 실수의 결과가 나오므로
		 정수인 n에 실수를 대입할 수 없어 에러가 발생한다.
		 */
//		n = n * 2.7;
		// 위 구문을 정상적으로 처리하기 위해선, 아래와 같은 강제형변환이 필요.
		n = (int)(n*2.7); // 13.5 -> 13(정수)
		/*
		 복합대입연산자를 사용하면 문법의 구조상 변수의 기존 자료형을 그대로 유지. 따라서 연산의 결과는 정수.
		 */
		n *= 2.7; // 13 * 2.7 = 35.1 -> 35(정수)
		System.out.println("n의 결과값:" + n);
		
	}

}
