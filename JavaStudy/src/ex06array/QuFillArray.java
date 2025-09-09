package ex06array;

import java.util.Scanner;

//문제3) 홀수/짝수 구분하여 배열채우기
//파일명 : QuFillArray.java
//길이가 10인 배열을 선언한 후 총 10개의 정수를 입력받아 순서대로 저장한다. (첫번째배열)
//그리고 순서대로 저장된 숫자들을 홀수는 배열의 앞에서부터 채워나가고 짝수는 배열의 끝에서부터 채워나간다.(두번째배열)
//
//실행결과]
//1번째 정수를 입력하세요:2
//2번째 정수를 입력하세요:4
//3번째 정수를 입력하세요:5
//4번째 정수를 입력하세요:3
//5번째 정수를 입력하세요:2
//6번째 정수를 입력하세요:9
//7번째 정수를 입력하세요:7
//8번째 정수를 입력하세요:8
//9번째 정수를 입력하세요:5
//10번째 정수를 입력하세요:1
//순서대로입력된결과
//2 4 5 3 2 9 7 8 5 1 
//홀수/짝수 구분입력결과
//5 3 9 7 5 1 8 2 4 2 


public class QuFillArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = new int[10];
		
		Scanner scanner = new Scanner(System.in);
		
		for (int i = 0; i < a.length; i++) {
			
			System.out.printf("%d번째 정수를 입력하세요: ", i+1);
			a[i] = scanner.nextInt();
		}

		System.out.println("순서대로 입력된 결과");
		
		for (int i : a) {
			System.out.print(i+" ");
		}
		
		System.out.println();
		System.out.println("홀수/짝수 구분입력결과");
		
		int[] a2 = new int[a.length];
		
		int j = 0;
		for (int i = 0 ; i < a.length ; i++) {
			if (a[i]%2!=0) {
				a2[j++] = a[i];
			}
		}
		
		int k = a.length-1;
		for (int i = 0 ; i < a.length ; i++) {
			if (a[i]%2==0) {
				a2[k--] = a[i]; 
			}
		}
		
		for (int i : a2) {
			System.out.print(i+" ");
		}
		
		scanner.close();

	}

}
