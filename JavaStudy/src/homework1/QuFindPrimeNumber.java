package homework1;

import java.util.Scanner;

public class QuFindPrimeNumber {

	private static boolean isPrimeNumber(int n) {
		
		if(n<2) return false; //0과1은 소수가 아님
		if(n==2) return true; //2는 소수
		if(n%2 == 0) return false; //2로 나눠지면 소수가 아님.
		
		//3부터 √n까지 홀수만 검사
		for(int j = 3 ; j <= Math.sqrt(n) ; j += 2) {
			if(n % j == 0) return false;
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num = 100;
		for(int n = 0; n < num ; n++) {
			if(isPrimeNumber(n) == true)
				System.out.println(n);
		}
	}
}
