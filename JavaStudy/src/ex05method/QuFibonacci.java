package ex05method;

import java.util.Scanner;


public class QuFibonacci {
//	문제5) 파일명 : QuFibonacci.java
//	피보나치 수열은 첫항이 0, 두번째항이 1로 구성되어 이전 2개의 항을 더해서 다음 항을 만들어낸다.
//	입력한 정수의 갯수만큼 항목을 출력하도록 프로그램을 작성하시오. 
//	메서드명 : fibonacciProgression()
//	형식]
//	첫번째 항 0 / 두번째항 1
//	세번째항 : 0 + 1 = 1
//	네번째항 : 1 + 1 = 2
//	다섯번째항 : 1 + 2 = 3
//
//
//	실행결과
//	숫자를 입력하세요 : 10
//	0, 1, 1, 2, 3, 5, 8, 13, 21, 34 

	
	static void fibonacciProgression() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요: ");
		int count = scanner.nextInt();
		
		int first = 0, second = 1;

		for (int i = 1; i <= count; i++) {
			System.out.print(first);
			if (i <= count - 1) {
				System.out.print(", ");
			}
			
			int next = first + second;
			first = second;
			second = next;
		}
		scanner.close();
		
	}

	public static void main(String[] args) {

		fibonacciProgression();
		
	}

}
