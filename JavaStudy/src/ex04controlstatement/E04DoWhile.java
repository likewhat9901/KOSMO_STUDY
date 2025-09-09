package ex04controlstatement;

import java.io.IOException;
import java.util.Scanner;

/*
 do~while문
 - 반드시 한번은 실행해야 하는 경우 사용하는 반복문으로 조건검사 없이 무조건 한번은 실행된다.
 - 형식
 	반복을 위한 변수
 	do{
 		실행문장;
 		증감식;
 	}while(조건식); <= 문장 끝에 세미콜론!
 */
public class E04DoWhile {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		//누적합과 반복을 위한 변수 선언
		int sum = 0;
		int i = 1;
		//조건없이 진입해서 실행
		do {
			//증가하는 변수 i를 누적해서 sum에 더함
			sum += i;
			i++;
			//탈출의 조건을 위해 증가시킨 후 체크한다.
		} while (i<=10);
		System.out.println("1~10까지의 누적합:" + sum);
		
		int total = 0;
		int j = 1;
		do {
			//4 혹은 7의 배수인지 확인
			if(j%4==0 || j%7==0) {
				//배수 확인용 출력문장
//				System.out.println("j=" + j);
				//증가하는 j를 누적해서 더해줌.
				total += j;
			}
			j++;
			//탈출의 조건을 위해 j를 증가시킨 후 확인.
		} while (j<=1000);
		System.out.println("1~1000사이 4or7의 배수합:" + total);
		
		//사용자 입력을 위한 참조변수 생성
		Scanner scanner = new Scanner(System.in);
		//점수와 탈출문자 입력을 위한 변수 생성
		int kor, eng, math, avg;
		int exitCode;
		
		do {
			//점수를 정수로 입력받음.
			System.out.println("국어점수:");
			kor = scanner.nextInt();
			System.out.println("영어점수:");
			eng = scanner.nextInt();
			System.out.println("수학점수:");
			math = scanner.nextInt();

			//평균값 계산(switch 구간을 위해 10으로 한번 더 나눠줌.)
			avg = (kor+eng+math) / (3*10);
			switch (avg) {
			case 10: case 9:
				System.out.println("A학점");
				break;
			case 8:
				System.out.println("B학점");
				break;
			case 7:
				System.out.println("C학점");
				break;
			case 6:
				System.out.println("D학점");
				break;
			default:
				System.out.println("F학점");
				break;
			}
			System.out.println("종료하려면 x(X)를 입력하세요.");
			System.out.println("계속하려면 아무키나 입력하세요.");
			exitCode = System.in.read();
			
		} while (!(exitCode=='x' || exitCode=='X'));
		/*
		 x를 입력한 경우
		 	!(true || false) => !(true) => false
		 	따라서 반복문을 탈출한다.
		 a를 입력한 경우
		 	!(false || false) => !(false) => true
		 	반복을 위해 처음으로 복귀.
		 */
		
		System.out.println("exitCode 값:" + exitCode);
		
		/*
		퀴즈) 다음과 같은 피라미드를 출력하는 프로그램을 
			do~while문으로 작성하시오.
		 *
		 **
		 ***
		 ****
		 *****
		*/
		System.out.println();
		
		int s = 1;
		do {
			switch (s) {
			case 1:
				System.out.println('*');
				break;
			case 2:
				System.out.println("**");
				break;
			case 3:
				System.out.println("***");
				break;
			case 4:
				System.out.println("****");
				break;
			default:
				System.out.println("*****");
				break;
			}
			s++;
		} while (s<=5);
		
		System.out.println();
		
		int s1 = 1;
		do {
			int s2 = 1;
			while (s2<=s1) {
				System.out.print("*");
				s2++;
			}
			System.out.println();
			s1++;
		} while (s1<=5);
		
		System.out.println();
		
		int n1 = 1;
		int fl;
		
		System.out.println("몇층짜리 피라미드인가요?");
		fl = scanner.nextInt();

		do {
			int n2 = 1;
			while (n2<=n1) {
				System.out.print("*");
				n2++;
			}
			System.out.println();
			n1++;
		} while (n1<=fl);
		
		System.out.println();
		
		//1.행을 위한 반복문 생성
		int a = 1;
		do {
			//2.열을 위한 반복문 생성
			int b = 1;
			do {
				//3.반복문 확인
				System.out.print("*");
				b++;
			//5.행에 해당하는 a의 개수만큼만 *를 출력한다.
			} while (b<=5);
			//4.5개 출력 후 줄바꿈
			System.out.println();
			a++;
		} while (a<=5);
		
	}
}
