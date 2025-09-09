package homework1;

public class QuSymmetry {

	private static void rotationSymmetry() {
		int i = 0;
		while(i<4) {
			for(int j=0 ; j<4 ; j++) {
				if(j==3-i) {					
					System.out.print("1 ");
				}else {
					System.out.print("0 ");
				}
			}
			System.out.println();
			i++;
		}
	}
	
	public static void main(String[] args) {
		
		rotationSymmetry();
		
	}
}
