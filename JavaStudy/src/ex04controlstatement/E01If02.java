package ex04controlstatement;

public class E01If02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//120을 2로 나누면 나머지가 0이므로 짝수로 판단.
		int num = 120;
		if (num%2 == 0) {
			System.out.println("짝수입니다.");
		}else {
			System.out.println("홀수입니다.");
		}
		
		/*
		 삼항연산자(조건연산자)
		 - if else문과 동일하지만 짧은 코드로 표현이 가능. 실무에서 자주 사용
		 - 변수 = (조건식) ? true일 때 : false일 때;
		 */
		String numberResult = (num%2 == 0) ? "짝수임." : "홀수임.";
		System.out.println("숫자 " + num + "은 " + numberResult);
		
		int num2 = 120;
		// 중첩된 if문. 여러 조건을 추가할 수 있다.
		if (num2%2 == 0) {
			if (num2 >= 100) {
				System.out.println("짝수이면서 100이상");
			}else {
				System.out.println("짝수이면서 100미만");
			}
		}else {
			if (num2 >= 100) 
				System.out.println("홀수이면서 100이상");
			else 
				System.out.println("홀수이면서 100미만");
		}
	}
}
