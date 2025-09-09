package ex04controlstatement;

public class QuPyramid02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		문제3) 다음과 같은 모양을 출력하는 프로그램을 do~while문으로 작성하시오.
//		파일명 : QuPyramid02.java
//		실행결과]
//		* * * * *
//		* * * *
//		* * *
//		* *
//		*

		int i = 1;
		
		do {
			int j = 1;
			do {
				System.out.printf("* ");	
				j++;
			} while (j<=6-i);
			System.out.println();
			i++;
		} while (i<=5);
	}
}
