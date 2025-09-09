package ex03operator;

public class E05ShortCircuitEvaluation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 SCE(Short-Circuit Evaluation)
		 - 하나의 조건검사만으로 결과를 알 수 있는 경우, Java 컴파일러가 자동적으로 뒤의 조건을 수행하지 않음.
		 - 이 경우 변수의 값이 변경되는 코드가 있다면 SCE로 인한 미실행에 주의.
		 */
		int num1 = 0, num2 = 0;
		boolean result;
		
		/*
		 논리 And의 경우 둘 중 하나만 false이면 false를 반환하므로,
		 만약 첫 번째 조건이 false이면 두 번째 조건은 검사(실행)하지 않는다.
		 */
		result = (num1 += 10) < 0 && (num2 += 10) > 0;
		// false 출력.
		System.out.println("result=" + result);
		// num2는 초기값인 0을 유지하는 것을 확인할 수 있다.
		System.out.println("num1=" + num1 + ", num2=" + num2);
		
		/*
		 논리 Or 의 경우, 둘 중 하나만 true이면 true를 반환하므로
		 첫 번째 조건이 true이면 두 번째 조건은 검사하지 않는다.
		 */
		result = (num1 += 10) > 0 || (num2 += 10) > 0;
		// true 가 출력.
		System.out.println("result=" + result);
		// num2는 여기서도 증가되지 않는다.
		System.out.println("num1=" + num1 + ", num2=" + num2);
		
		/*
		 num2의 값이 프로그램의 실행결과에 영향을 줄 수 있다면 주의해야 한다.
		 */
		
	}

}
