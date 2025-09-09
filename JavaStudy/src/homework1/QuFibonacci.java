package homework1;

import java.util.Scanner;

public class QuFibonacci {

	private static void fibonacciProgression(Scanner scan) {
		
		while(true) {
			System.out.println("[피보나치 수열 출력]");
			int count;
			while(true) {
				System.out.print("숫자를 입력하세요:");
				if(scan.hasNextInt()) {
					count = scan.nextInt();
					scan.nextLine();
					break;
				}
				else {
					scan.nextLine();
				}
			}
			
			if(count < 1) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
			
			System.out.print("결과: ");
			int first = 0, second = 1;
			
			for(int i = 0; i < count ; i++) {
				int temp = first + second;
				System.out.print((i==0) ? first : ", " + first);
				first = second;
				second = temp;
			}
			System.out.println();
			
			while(true) {
				System.out.print("재시작하시겠습니까?(1.예, 2.아니오):");
				int choice = scan.nextInt();
				if(choice == 1)
					break;
				if(choice == 2) {
					System.out.println("프로그램을 종료합니다.");
					return;
				}
				else {
					System.out.println("잘못된 입력입니다.");
					scan.nextLine();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		fibonacciProgression(scan);
		scan.close();
		
	}
}
