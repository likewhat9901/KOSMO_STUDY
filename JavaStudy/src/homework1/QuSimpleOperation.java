package homework1;

import java.util.Scanner;

public class QuSimpleOperation {
	
	public static void arithmetic(Scanner scan) {
		
		System.out.println("[정수 단순계산]");
		System.out.print("첫번째 숫자를 입력하세요:");
		int int1 = scan.nextInt();
		System.out.print("두번째 숫자를 입력하세요:");
		int int2 = scan.nextInt();
		
		int plus = int1 + int2;
		int minus = int1 - int2;
		int mult = int1 * int2;
		int div_q = int1 / int2;
		int div_r = int1 % int2;
		
		System.out.printf("덧셈결과-> %d%n", plus);
		System.out.printf("뺄셈결과-> %d%n", minus);
		System.out.printf("곱셈결과-> %d%n", mult);
		System.out.printf("나눗셈 몫-> %d%n", div_q);
		System.out.printf("나눗셈 나머지-> %d%n", div_r);
	}
	

	public static void circlecalc(Scanner scan) {
		
		System.out.println("[원의 넓이, 둘레]");
		System.out.print("원의 반지름을 입력하세요:");
		double radius = scan.nextDouble();
		circleArea(radius);
		circleRound(radius);
	}
	
	public static void circleArea(double radius) {
		
		double area = 3.14 * radius * radius;
		System.out.printf("원의 둘레(%.2f): %.2f%n", radius, area);
		
	}
	
	public static void circleRound(double radius) {
		
		double round = 2 * 3.14 * radius;
		System.out.printf("원의 둘레(%.2f): %.2f", radius, round);
		
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		arithmetic(scan);
		circlecalc(scan);
		
		

	}

}
