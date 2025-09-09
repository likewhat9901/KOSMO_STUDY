package ex02variable;


public class E01JunsuType {
	/*/
	 정수자료형
	 - byte, short, int, long 타입 등이 있다.
	 - 각 자료형의 표현범위는 교안을 참조.
	 - 일반적으로 CPU는 정수형 연산을 가장 빠르게 처리한다. 즉, int에 최적화.
	 - 따라서 정수형 변수를 사용할 때는 대부분 int를 우선 사용.
	 */

	public static void main(String[] args) {

		//int형 변수를 선언 후 초기값을 할당
		int int1 = 100;
		int int2 = 200;
		//300의 결과가 result1에 할당
		int result1 = int1 + int2;
		System.out.println("int1 + int2 = " + result1);

		/*
		 100/200의 결과는 0이 나오게 된다. Java에서는 정수와 정수를 연산하면 정수의 결과가 반환. 만약 실수의 결과를
		 반환받고 싶다면 형변환(Type casting)을 해야한다.
		 */
		result1 = int1 / int2;
		System.out.println("int1 / int2 = " + result1);

		/*
		 - 동일한 타입의 변수를 2개 이상 선언하는 경우에는 컴마를 사용할 수 있다.
		 - int형보다 작은 자료형을 연산하면 CPU가 자동적으로 int형으로 변환하여 계산한다.(Java의 특징)
		 - CPU는 정수의 연산인 경우, int형에 최적화되어 있기 때문.
		 */
		byte byte1 = 50, byte2 = 55;
		//byte의 연산결과로 int가 반환.
		int result2 = byte1 + byte2;
		System.out.println("byte1 + byte2 = " + result2);

		short short1 = 60, short2 = 70;
		//short의 연산결과로 int가 반환.
		int result3 = short1 + short2;
		System.out.println("short1 + short2 = " + result3);

		/*
		 - 동일 자료형끼리의 연산은 동일자료형이 되는 것이 기본원칙.
		 - 하지만 큰 자료형과 작은 자료형을 연산하면 큰 자료형으로 자동 형변환. 이유는 데이터 손실(오차)이 있을 수 있기 때문.
		 - 단, byte 와 short는 예외적인 상황으로 생각하면 된다. CPU가 int형의 연산에 최적화되어 있기 때문.
		 */
		long long1 = 1000, long2 = 2000;
		//따라서 int + long => long
		long result4 = int1 + long1;
		System.out.println("long1 + long2 = " + result4);

		//long끼리의 연산은 기본규칙을 따름.
		result4 = long1 + long2;
		System.out.println("long1 + long2 = " + result4);
		
		/*
		 자바는 정수형 상수를 기본적으로 int형으로 간주하기 때문에 아래 정수를 메모리에 로드하는 순간 에러가 발생된다.
		 이때 접미사(L or ㅣ)을 붙여서 int형의 자료가 아닌 long형 자료임을 표시해야 한다.
		 이와 같이 입력되는 숫자도 자료형을 기반으로 메모리에 로드되는데, 이를 가리켜 리터럴(Literal)이라고 한다.
		 */
		//long long3 = 2200000000;//에러발생
		long long4 = 2200000000L;
		long long5 = 2200000000l;

		System.out.println("long4 =" + long4);

	}

}
