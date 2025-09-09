package homework1;

import java.util.Scanner;

public class QuTemperature {

	public static double celsiusToFahrenheit(Scanner scan) {
		
		System.out.println("[섭씨->화씨 변환]");
		System.out.print("섭씨를 입력하세요:");
		double cel = scan.nextDouble();
		
		return (cel * 1.8) + 32;
	}
	
	public static double fahrenheitToCelsius(Scanner scan) {
		
		System.out.println("[화씨->섭씨 변환]");
		System.out.print("화씨를 입력하세요:");
		double fah = scan.nextDouble();
		
		return (fah - 32.0) / 1.8;
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.printf("%.2f도%n", celsiusToFahrenheit(scan));
		System.out.println();
		System.out.printf("%.2f도%n", fahrenheitToCelsius(scan));
		
		scan.close();
	}
}
