package ex04controlstatement;

public class QuPyramid03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		문제4) 다음과 같은 모양을 출력하는 프로그램을 for문으로 작성하시오.
//		파일명 : QuPyramid03.java
//		실행결과]
//		         *
//		       * * *
//		     * * * * *
//		   * * * * * * *
//		* * * * * * * * *
		
		
		for (int a = 1; a <= 5; a++) {
			for (int b = 1; b <= 5-a; b++) {
				System.out.print("  ");				
			}
			for (int b = 1; b <= 2*a-1; b++) {
				System.out.print("* ");				
			}
			System.out.println();
		}
	}
}
