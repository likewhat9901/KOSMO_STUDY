package ex02variable;

public class E07TypeCasting {

	public static void main(String[] args) {
		
		/*
		 자동형변환
		 - 작은 자료형의 데이터를 큰 자료형에 대입할 때 자동으로 형변환이 일어난다.
		 - 자료의 손실이 없을 때만 적용.
		 - byte > short > int > long > float > double
		 */
		byte b1 = 65;
		short s1;
		// byte가 short보다 작은 자료형이므로 자동형변환 됨. byte가 short로 변환되어 입력되는 느낌.
		s1 = b1;
		System.out.printf("b1은 %d, s1은 %d%n", b1, s1);
		
		/*
		 아래 코드는 자동형변환은 아니다.
		 CPU는 int보다 작은 자료를 연산할 때, int로 간주하여 진행하고 결과로 int로 반환하기 때문.
		 따라서 이 부분은 int형에 최적화된 CPU의 특성으로 볼 여지가 있다.
		 */
		int num1 = b1 + s1;
		System.out.println("num1은 " + num1);
		
		// char형(문자)에 byte형(정수)를 대입할 수 없다. 특성이 다르므로 강제 형변환 후 대입해야 한다.
//		char ch1 = b1;
		char ch2 = (char)b1;
		System.out.println("b1=" + b1 + ", ch2=" + ch2);
		
		/*
		 명시적(강제) 형변환
		 - 큰 상자의 자료를 작은 상자의 자료형에 할당해야 할 때 사용.
		 - 단, 자료의 손실이 있을 수 있으므로 필요한 경우에만 사용 권장.
		 */
		// 만약 129를 대입하면 byte로 형변환 시 -127이 출력된다.
		short s2 = 100;
		byte b2 = (byte)s2;
		System.out.printf("데이터미손실:b2=%d, s2=%d\n", b2, s2);
		
		// 소수점 아래부분이 버려지므로 데이터 손실 발생, 흔히 원단위절삭 같은 경우 사용.
		int num3;
		double dl = 3.14159;
		num3 = (int)dl;
		System.out.printf("데이터손실:num3=%d, dl=%.2f %n", num3, dl);
		// %.2f 는 정수부는 모두 출력, 소수 이하는 2자리까지만 출력한다.
		
		/*
		 문자는 메모리에 저장 시, 아스키코드로 저장되므로
		 int형과 연산을 진행한 후 문자로 표현하고 싶다면 char형으로 강제형변환 필요.
		 */
		char ch3 = 'A', ch4;
		int num4 = 2;
		// char + int => int 이므로 char에 저장할 수 없어 에러발생.
//		ch4 = ch3 + num4;
		ch4 = (char)(ch3 + num4);
		System.out.println("ch4=" + ch4);
		
	}
}
