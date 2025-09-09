package ex05method;

/*
 메서드 형태2 (매개변수 X, 반환값 O)
 - 전달받는 입력값 없이 결과값을 반환하는 형태.
 - 즉, 값을 자체적으로 생산.
 */
public class E03MethodType02_1 {
	 
	/*
	 메서드 정의 시 public은 붙여도 되고, 붙이지 않아도 된다.
	 public과 같은 접근지정자는 2개 이상의 클래스를 정의할 때 필요하다.
	 */
	static int sum1To10() {
		//1~10까지의 합을 계산해 반환하는 메서드로 정의
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
		}
		//정수를 반환하고, 반환된 값은 호출한 지점으로 전달된다.
		return sum;
	}
	
	public static void main(String[] args) {
		/*
		 반환값이 있는 메서드는 주로 print()문의 일부로 사용하거나
		 변수의 할당을 위해 코드의 우측항에 기술한다.
		 */
		System.out.println("1~10까지의 합:" + sum1To10());
		
		int sum10 = sum1To10();
		System.out.printf("1에서 10까지의 합은 %d입니다.", sum10);
		
	}

}
