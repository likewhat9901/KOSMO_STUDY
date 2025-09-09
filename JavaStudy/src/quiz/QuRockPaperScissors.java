package quiz;

import java.util.Scanner;

public class QuRockPaperScissors {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int user, end_game;
		int gameCount = 0;

		while (true) {
			if (gameCount >= 5) {
				System.out.println("5번의 게임이 끝났습니다. 게임을 계속하시겠습니까? 재시작(1), 종료(0): ");
				end_game = sc.nextInt();
				if(end_game == 0) {
					sc.close();
					System.out.println("게임이 종료됩니다.");
					System.exit(0);
				} else if(end_game == 1){
					gameCount = 0;
				} else {
					System.out.println("잘못된 입력입니다.");
					continue;
				}
			}
			
			System.out.print("무엇을 내겠습니까?(1:가위, 2:바위, 3:보) :");
			user = sc.nextInt();
			
			if(user < 1 || user > 3) {
				System.out.println("가위바위보 할 줄 모르세요? 제대로 내세요^^;");
				continue;
			}
			
			result(user);
			gameCount++;
		}
		
		
	}
	
	static void result(int user){
		int computer = (int) (Math.random() * 3 + 1);
		
		String[] choices = {"가위", "바위", "보"};
	
		
		System.out.println("사용자 : " + choices[user - 1] + ", 컴퓨터 : " + choices[computer - 1]);
		
		if (user == computer) {
			System.out.println("비겼습니다.");
	    } else if ((user == 1 && computer == 3) || 
	               (user == 2 && computer == 1) || 
	               (user == 3 && computer == 2)) {
	    	System.out.println("이겼습니다!");
	    } else {
	        System.out.println("졌습니다...");
	    }
	}
}
