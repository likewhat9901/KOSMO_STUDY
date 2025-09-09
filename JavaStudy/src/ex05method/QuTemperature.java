package ex05method;

import java.util.Scanner;

public class QuTemperature {
//	문제3) 파일명 : QuTemperature.java
//	섭씨(Celsius)를 입력받아서 화씨(Fahrenheit)로 변환하여 리턴하는 함수와 화씨를 입력받아서
//	섭씨로 변환하여 리턴하는 함수를 만들어라. 공식은 아래와 같습니다 
//	메소드명 : celsiusToFahrenheit() , fahrenheitToCelsius()
//	공식]
//	화씨 = 1.8 * 섭씨 + 32
//	섭씨 = (화씨 - 32) / 1.8

	static void celsiusToFahrenheit(int Cels) {
		
		double Fahr = Cels * 1.8 + 32;
		
		System.out.printf("화씨: %.2f", Fahr);
	}
	
	static void FahrenheitTocelsius(int Fahr) {
		
		double Cels = Fahr * 1.8 + 32;
		
		System.out.printf("섭씨: %.2f", Cels);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("[섭씨 -> 섭씨]\n섭씨를 입력하세요.");
		int c = scanner.nextInt();
		celsiusToFahrenheit(c);
		
		System.out.println();
		
		System.out.println("[화씨 -> 섭씨]\n화씨를 입력하세요.");
		int f = scanner.nextInt();
		FahrenheitTocelsius(f);
	
	}
}
