package ex05method;

import java.util.Scanner;

public class QuCircleCalculator {
	
	static void circleArea(double a) {
		
		double area = 3.14 * a * a ;
		
		System.out.printf("원의 넓이(%s) : %.2f", a, area);
	}
	static void circleRound(double a) {
		
		double round = 2 * 3.14 * a ;
		
		System.out.printf("원의 둘레(%s) : %.2f", a, round);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("반지름을 입력하세요.");
		double half = scanner.nextDouble();
		
		circleArea(half);
		System.out.println();
		circleRound(half);

	}

}
