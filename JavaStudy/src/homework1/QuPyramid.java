package homework1;

public class QuPyramid {

	public static void main(String[] args) {

		System.out.println("[QuPyramid01]");
		int i = 1;
		while(i<=5) {
			int j=1;
			while(j<=i) {
				System.out.print("* ");
				j++;
			}
			System.out.println();
			i++;
		}
		
		System.out.println("[QuPyramid02]");
		i = 1;
		do {
			int j = 1;
			while(j<=6-i) {
				System.out.print("* ");
				j++;
			}
			System.out.println();
			i++;
		} while(i<=5);
		
		System.out.println("[QuPyramid03]");
		for(int x=0 ; x<5 ; x++) {
			for(int y=0 ; y<4-x ; y++) {
				System.out.print("  ");
			}
			for (int z = 0; z < 2*x+1; z++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		System.out.println("[QuPyramid04]");
		for(int x=1 ; x<=5 ; x++) {
			for(int y=0 ; y<x ; y++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		for(int x=1 ; x<=5 ; x++) {
			for(int y=0 ; y<5-x ; y++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}
