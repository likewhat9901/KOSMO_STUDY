package homework1;

import java.util.Scanner;

public class QuFillArray {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[10];
		
		for (int i = 0 ; i < arr.length; i++) {
			System.out.printf("%d번째 정수를 입력하세요:", i+1);
			arr[i] = scan.nextInt();
		}
		
		//순서대로 입력된 결과
		System.out.println("순서대로 입력된 결과");
		for(int num : arr) {
			System.out.print(num+" ");
		}
		
		int[] result = new int[10];
		int front = 0;
		int back = arr.length -1;
		
		for(int i=0 ; i<arr.length ; i++) {
			if(arr[i]%2==0) {
				result[front] = arr[i];
				front++;
			}else {
				result[back] = arr[i];
				back--;
			}
		}
		
		System.out.println("\n홀수/짝수 구분입력결과");
		for(int num : result) {
			System.out.print(num+" ");
		}
	}

}
