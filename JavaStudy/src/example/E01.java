package example;

import java.util.Scanner;

//1️⃣ 변수와 데이터 타입 문제
//문제:
//사용자로부터 이름과 나이를 입력받아 다음과 같이 출력하는 프로그램을 작성하세요.
//
//🔹 실행 예시
//
//코드 복사
//이름을 입력하세요: 홍길동  
//나이를 입력하세요: 25  
//당신의 이름은 홍길동이고, 나이는 25살입니다.

public class E01 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요: ");
		String name = scanner.nextLine();
		
		System.out.print("나이를 입력하세요: ");
		int age = scanner.nextInt();
		scanner.nextLine(); //nextInt() 남은 개행문자(\n) 제거
		
		System.out.printf("당신의 이름은 %s이고, 나이는 %d살입니다.%n", name, age);

	}

}
