package quiz;

import java.math.BigInteger;

public class QuUpgradeGuGu {

	public static void main(String[] args) {

		//2단부터 9단까지 반복
		for (int dan = 2; dan <= 9; dan++) {
			BigInteger result = BigInteger.ONE; //곱셈결과 저장변수
			//9번 반복
			for (int times = 1; times <= 9; times++) {
//				result *= dan; //기존결과에 dan을 계속 곱하기
				result = result.multiply(BigInteger.valueOf(dan));
				
				StringBuilder output = new StringBuilder(); //출력형식
				
				//첫번째 줄
				if (times == 1) {
					output.append(dan).append(" X 1 = ").append(dan);
				}else {
					for (int i = 0; i < times; i++) {
						if (i>0) output.append(" X ");
						output.append(dan);
					}
					output.append(" = ").append(result);
				}
				System.out.println(output);
			}//times for문
		}//dan for문
	}//main 메서드
}
