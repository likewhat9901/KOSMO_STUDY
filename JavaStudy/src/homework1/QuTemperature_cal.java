package homework1;

import java.util.Scanner;

public class QuTemperature_cal {

	public static double celsiusToFahrenheit(Scanner scan) {
		
		System.out.println("\n[섭씨->화씨 변환]");
		System.out.print("섭씨를 입력하세요:");
		double cel = scan.nextDouble();
		
		return (cel * 1.8) + 32;
	}
	
	public static double fahrenheitToCelsius(Scanner scan) {
		
		System.out.println("\n[화씨->섭씨 변환]");
		System.out.print("화씨를 입력하세요:");
		double fah = scan.nextDouble();
		
		return (fah - 32.0) / 1.8;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n===== 온도 변환기 =====");
			System.out.println("1.섭씨 -> 화씨");
			System.out.println("2.화씨 -> 섭씨");
			System.out.println("3.종료");
			System.out.print("선택하세요(1~3): ");
			
			int choice = scan.nextInt();
			
			switch (choice) {
			case 1:
				System.out.printf("%.2f도%n", celsiusToFahrenheit(scan));
				break;
			case 2:
				System.out.printf("%.2f도%n", fahrenheitToCelsius(scan));
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				scan.close();
				return;
			default:
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
}
