package ex04controlstatement;

public class QuPyramid04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//		문제5) 다음과 같은 모양을 출력하는 프로그램을 for문으로 작성하시오.
//		파일명 : QuPyramid04.java
//		실행결과]
//		*
//		* *
//		* * *
//		* * * *
//		* * * * *
//		* * * * 
//		* * * 
//		* * 
//		* 

		for (int a = 1; a <= 5; a++) {
			for (int b = 1; b <= a; b++) {
				System.out.print("* ");				
			}
			System.out.println();
		}
		for (int a = 1; a <= 5; a++) {
			for (int b = 1; b <= 5-a; b++) {
				System.out.print("* ");				
			}
			System.out.println();
		}
	}
}
