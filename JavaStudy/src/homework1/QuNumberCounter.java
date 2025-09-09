package homework1;

public class QuNumberCounter {

	public static void main(String[] args) {
		int[] answer = { 1,4,4,3,1,4,4,2,1,3,2  };
		int[] counter = new int[4];
		
		
		for(int i=0 ; i<counter.length ; i++) {
			for(int j=0 ; j<answer.length ; j++) {
				if(answer[j]==i+1)
					counter[i]++;
			}
			System.out.printf("counter[%d]=>%d%n",i,counter[i]);
		}
		
		System.out.println();
		counter = new int[4];
		
		for(int num : answer) {
			if(num>=1 && num <=counter.length)
				counter[num-1]++;
		}
		for(int i=0 ; i<counter.length ; i++) {
			System.out.printf("counter[%d]=>%d%n",i,counter[i]);
		}
		
		
	}
}
