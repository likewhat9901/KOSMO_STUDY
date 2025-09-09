
package ex04controlstatement;

public class E03While_prac {
	
	public static void main(String[] args) {
		
		int i = 1;
		int sum = 0;
		while (i <= 10) {
			System.out.println("변수i = " + i);
			sum += i;
			i++;
		}
		System.out.println("1~10까지의 합 sum = " + sum);
		
		
	}
}
