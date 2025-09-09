package ex04controlstatement;

public class QuPyramid01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


//		문제2) 다음과 같은 모양을 출력하는 프로그램을 while문으로 작성하시오.
//		파일명 : QuPyramid01.java
//		실행결과]
//		*
//		* *
//		* * *
//		* * * *
//		* * * * *
		
		int i = 1;
		
		while (i <= 5) {
			int j = 1;
			while (j <= i) {
				System.out.print("* ");	
				j++;
			}
			System.out.println();
			i++;
		}
	}
}
