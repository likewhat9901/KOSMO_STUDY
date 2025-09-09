package quiz;
import java.util.Random;
import java.util.Scanner;

public class QuUpDownGame2 {

	public static void playGame(Scanner scan) {
		Random rand = new Random();
		
		System.out.print("[1~100사이의 숫자 맞추기 게임]");
		System.out.println("- 기회는 7번입니다");
		System.out.println("1~100사이의 랜덤한 숫자를 생성합니다.");
		int randomInt = rand.nextInt(100)+1;
		
		System.out.println("생성된난수:" + randomInt);
		
		for (int i = 0; i < 7; i++) {
			System.out.printf("[%d번째]1~100사이의 정수를 입력하세요:", i+1);
			int num1 = scan.nextInt();
			
			if(num1 == randomInt) {
				System.out.println("승리하셨습니다.");
				return;
			} else if(num1 < randomInt) {
				System.out.println("Up입니다.");
			} else {
				System.out.println("Down입니다.");			
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		while (true) {
			playGame(scan);
			
			while (true){
				//실패 or 성공으로 게임이 끝났을 경우
				System.out.println("게임을 다시 시작할까요?");
				System.out.println("1:게임재시작, 0:게임종료");
				
				try {
					int gameReset = scan.nextInt();
					
					if(gameReset == 1) {
						System.out.println("게임을 재시작합니다.");
						break;
					} else if(gameReset == 0) {
						System.out.println("게임을 종료합니다.");
						System.exit(0);
					} else {
						System.out.println("잘못 입력하셨습니다.");
					}
				} catch (Exception e) {
					System.out.println("숫자만 입력해주세요.");
					scan.nextLine();
				}
			}
		}
	}
}
