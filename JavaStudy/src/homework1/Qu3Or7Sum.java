package homework1;

public class Qu3Or7Sum {

	public static void main(String[] args) {

		System.out.println("[1.while문]");
		int num1 = 1;
		int sum1 = 0;
		while(num1<=100){
			if(num1 % 3 == 0 && num1 % 7 == 0) {
			} else if(num1 % 3 == 0 || num1 % 7 == 0) {
				sum1 += num1;
				System.out.println("num1="+num1+"sum1="+sum1);
			}
			num1++;
		}
		
		System.out.println("[2.do while문]");
		int num2 = 1;
		int sum2 = 0;
		do {
			if(num2 % 3 == 0 && num2 % 7 == 0) {
			} else if(num2 % 3 == 0 || num2 % 7 == 0) {
				sum2 += num2;
				System.out.println("num2="+num2+"sum2="+sum2);
			}
			num2++;
		} while (num2<=100);
		
		
		System.out.println("[3.for문]");
		int sum3 = 0;
		for(int num3=0 ; num3<100 ; num3++) {
			if(num3 % 3 == 0 && num3 % 7 == 0) {
			} else if(num3 % 3 == 0 || num3 % 7 == 0) {
				sum3 += num3;
				System.out.println("num3="+num3+"sum3="+sum3);
			}
		}
	}
}
