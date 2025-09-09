package homework1;

public class QuArray1To10 {
	public static void main(String[] args) {
		int[] array = new int[10];
		
		for(int i=0 ; i<array.length ; i++) {
			array[i] = i+1;
		}
		for(int num : array) {
			System.out.println(num + " ");
		}
		
		System.out.println();
		
		int sum = 0;
		for(int num : array) {
			sum += num;
		}
		System.out.println("배열전체요소의 합: " + sum);
	}
}
