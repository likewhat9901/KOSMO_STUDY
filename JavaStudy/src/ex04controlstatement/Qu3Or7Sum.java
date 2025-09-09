package ex04controlstatement;

import java.util.Iterator;

public class Qu3Or7Sum {

	public static void main(String[] args) {

//		문제1) 1~100까지의 숫자중 3의배수 이거나 7의배수인 숫자의 합을 구하는 프로그램을
//		while, do~while, for문으로 각각 작성하시오. 단, 3과 7의 공배수인 경우 합에서 제외해야 한다.
//		출력의 결과는 누적되는 모든 수를 콘솔에 print한다. 하나의 파일에 한꺼번에 작성하므로 동일한 결과가 3번 출력됩니다. 

		//while문
		System.out.println("[while문]");
		int num = 1;
		int sum = 0;
		
		while (num <= 100) {
			// 3과7의 공배수 건너뛰기
			if(num%3==0 && num%7==0) {
				num++;
				continue;
			}
			if (num%3==0 || num%7==0) {
				sum += num;
				System.out.println("누적합: "+ sum);
			}
			num++;
		}
		
		System.out.println();
		
		//do~while문
		System.out.println("[do while문]");
		num = 1;
		sum = 0;
		do {		
			// 3과7의 공배수 건너뛰기
			if(num%3==0 && num%7==0) {
				num++;
				continue;
			}
			if (num%3==0 || num%7==0) {
				sum += num;
				System.out.println("누적합: "+ sum);
			}
			num++;
		} while (num<=100);
		
		System.out.println();
		//for문
		System.out.println("[for문]");
		
		num = 1;
		sum = 0;
		for (num = 1; num <= 100; num++) {
			// 3과7의 공배수 건너뛰기
			if(num%3==0 && num%7==0) {
				num++;
				continue;
			}
			if (num%3==0 || num%7==0) {
				sum += num;
				System.out.println("누적합: "+ sum);
			}
		}
	}
}
