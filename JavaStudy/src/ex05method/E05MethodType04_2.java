package ex05method;

import java.util.Scanner;

public class E05MethodType04_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int maxValue1 = returnMaxNumber(4);
		System.out.println("최대값1: "+ maxValue1);
//		int maxValue2 = returnMaxNumber(6);
		System.out.println("최대값2: "+ returnMaxNumber(6));
		
	}

	/*
	 main()에서 전달한 인수의 크기만큼 반복해서 정수를 입력받은 후
	 최대값을 찾아서 반환해주는 메서드 정의.
	 */
	static int returnMaxNumber(int numberCnt) {
		
		Scanner scanner = new Scanner(System.in);
		//최대값 저장 변수 선언.
		int maxVal = 0;
		//매개변수 인수의 크기만큼 반복
		for (int i = 1; i <= numberCnt; i++) {
			System.out.print("정수를 입력하세요: ");
			int inputNum = scanner.nextInt();
			
			if (i==1) {
				/*
				 입력받은 정수 중 최대값을 찾는 것이 목표.
				 첫번째 입력값을 비교를 위한 기준값으로 설정.
				 */
				maxVal = inputNum;
			}else if (maxVal < inputNum) {
				/*
				 두번째 입력값부터는 기존의 최대값과 비교.
				 더 큰 값이 있을 때만 교체한다. 작은 값은 무시.
				 */
				maxVal = inputNum;
			}
		}
		/*
		 즉, 새로운 값이 입력되면 기존값과 비교한 뒤 큰 경우 지속교체하여 최대값을 찾는다.
		 이 값을 호출한 지점으로 반환.
		 */
		return maxVal;
	}
}
