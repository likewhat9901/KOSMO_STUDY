package ex05method;

public class QuFindPrimeNumber {

//	문제4) 파일명 : QuFindPrimeNumber.java 
//	전달된 값이 소수인지 아닌지를 판단하여 소수인 경우 true를 아니면 false를 반환하는 메소드를 정의하고,
//	이를 이용해서 1부터 100사이의 소수를 전부 출력하는 main메소드를 정의하자.
//	메소드명 : isPrimeNumber()
//	소수란 : 특정 정수를 나눌수 있는것이 1과 자기 자신밖에 없는 수.
//	실행결과]
//			2
//			3
//			5
//			……중략……
//			97

	
	static void isPrimeNumber(int num) {
		
//		Scanner scanner = new Scanner(System.in);
//		int num = scanner.nextInt();

		//true 기본값 세팅
		boolean isPrime = true;
		
		if (num < 2) {
			//2미만 숫자 소수 아님.
			isPrime = false;
		}else { //2 이상인 경우
			for (int i = 2; i < num; i++) { //2~num-1까지 반복비교
				if (num%i == 0) {
					//num을 2~num-1 중 나누어 떨어지면 소수아님.
					isPrime = false;
					break; //exit
				}
			}
		}
		//isPrime = true 일때 숫자 출력
		if (isPrime) {
			System.out.println(num);
		}
	}


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 1; i <= 100; i++) {
			
			isPrimeNumber(i);
		}
	}

}
