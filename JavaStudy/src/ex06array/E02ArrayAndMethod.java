package ex06array;

import java.io.FileOutputStream;

public class E02ArrayAndMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 - 배열을 선언과 동시에 초기화. 초기값의 개수를 통해 크기를 결정.
		 - 생성된 배열 인스턴스의 주소값을 int형 배열변수인 arr에 할당.
		 */
		int[] arr = {1,2,3,4,5}; //? 배열 선언 및 정보 입력
		//배열변수 선언. 아직은 참조할 배열이 없는 상태로 정의.
		int[] ref; // ?배열만 선언
		
		//초기값 그대로인 1~5까지 출력.
		System.out.println("초기화 직후 출력");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " "); //?arr 배열 출력. 배열의 크기만큼.
		}
		System.out.println();
		
		/*
		 배열명을 인수로 전달하는 것은 배열의 참조값(주소값)을 전달하는 것으로 배열 자체가 전달되진 않는다.
		 아래 출력문에서는 배열 인스턴스의 참조값이 출력.
		 */
		System.out.println("arr 변수: "+ arr);
		/*
		 arr은 참조값이지만 7은 기본자료형인 int이므로 값 자체가 전달.
		 즉, 복사가 되어 전달된다.
		 */
		ref = addAllArray(arr,7); // ?ref 배열 정의 = 호출된 인스턴스
		
		/*
		 main에서 생성했던 배열객체의 참조값을 매개변수로 넘기고 다시 반환받았으므로
		 결국 동일한 배열을 참조하게 되어 아래 출력문에서는 동일한 결과가 2번 출력된다.
		 */
		System.out.println("메소드 호출 후 출력");
		for (int i = 0; i < ref.length; i++) {
			System.out.print(ref[i]+" ");
		}
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}
		
	}
	
	/*
	 매개변수로 전달된 배열의 참조값을 ar로 받게되므로 해당 메서드에서 동일한 배열을 참조할 수 있다.
	 즉, main 메서드에서 생성한 배열과 동일한 배열을 참조하게 된다.
	 */
	static int[] addAllArray(int[] ar, int addVal) {//?arr = int[] ar 정의, 7 = int addVal 정의
		/*
		 배열의 각 인덱스에 매개변수로 전달된 7을 더해준다.
		 즉, 각 원소들은 7씩 증가시킨다.
		 */
		for (int i = 0; i < ar.length; i++) {
			ar[i] += addVal; // ?arr배열 7 더하기 (배열의 길이만큼 선택)
		}
		return ar; //? ar 배열을 반환. ar[0]~ar[ar.length]
	}
	
	
	
	
	
}
