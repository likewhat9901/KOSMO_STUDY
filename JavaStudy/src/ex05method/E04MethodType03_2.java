package ex05method;

import java.util.Iterator;
import java.util.Scanner;

public class E04MethodType03_2 {

	/*
	연습문제] 사용자로부터 2~9사이의 숫자중 2개를 입력받아 이에 해당하는 구구단을 출력하는 메서드를 작성하시오. 무조건 첫번째 입력받는수가 작아야한다.
	입력예]
		첫번째숫자 : 3
		두번째숫자 : 12
		3*1=3 3*2=6........
		........
		...................12*9=108
	메서드명 : inputGugudan(int sNum, int eNum)
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("[구구단 출력]");
		ask();

	}
	static void ask() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("몇단부터 출력하시겠습니까?\n첫번째 숫자: ");
		int s = scanner.nextInt();
		System.out.println("몇단까지 출력하시겠습니까?\n두번째 숫자: ");
		int e = scanner.nextInt();
		
		if (s>0 && s<=e) {
			inputGugudan(s, e);
		}else {	
			System.out.println("첫번째 숫자보다 두번째 숫자가 작습니다.\n다시입력하세요.");
			System.out.println();
			ask();
		}
	}
	
	static void inputGugudan(int sNum, int eNum) {

		for (int i = sNum; i <= eNum; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%d*%d=%-2d ", i, j, i*j);
			}
			System.out.println();
		}
		
		System.out.println();
	}
	
	
	
	//정답
	static void inputGugudan1(int sNum, int eNum) {
		int dan = sNum; 
		while(dan<=eNum) { 
			int su = 1; 
			while(su<=9) { 
				System.out.printf("%-2d*%-2d=%2d", dan, su, (dan*su));
				System.out.print(" ");
				su++;
			}
			System.out.println(); 
			dan++;
		}
	}
	
	static void inputGugudan2(int sNum, int eNum) {
		for(int dan=sNum ; dan<=eNum ; dan++) {
			for(int su=1 ; su<=9 ; su++) {
				System.out.print(dan +"*"+ su +"="+ (dan*su) +" ");
			}
			System.out.println();
		}
	}

}
