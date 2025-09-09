package quiz;

import java.util.Random;
import java.util.Scanner;

public class QuUpDownGame {

	public static void game() {
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		
		int randomInt = rand.nextInt(100)+1;
		
		System.out.println("생성된난수:" + randomInt);
		
		for (int i = 0; i < 7; i++) {
			System.out.print("1~100사이의 정수를 입력하세요:");
			int num1 = scan.nextInt();
			
			if(num1 == randomInt) {
				System.out.println("승리하셨습니다.");
				System.out.println("게임을 다시 시작할까요?");
				System.out.println("1:게임재시작, 0:게임종료");
				int gameReset = scan.nextInt();
				
				if(gameReset == 1)
					main(null);
				else
					scan.close();
					System.exit(0);
			} else if(num1 < randomInt) {
				System.out.println("Up입니다.");
			} else {
				System.out.println("Down입니다.");			
			}
		}
		
		//7번 안에 맞추지 못했을 경우
		System.out.println("[실패]");
		System.out.println("7번 안에 맞추지 못했습니다.");
		System.out.println("게임을 다시 시작할까요?");
		System.out.println("1:게임재시작, 0:게임종료");
		int gameReset = scan.nextInt();
		
		if(gameReset == 1)
			main(null);
		else
			scan.close();
			System.exit(0);
	}
	
	public static void main(String[] args) {

		game();
		
	}
}
