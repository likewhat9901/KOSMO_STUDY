package homework1;

import java.util.Scanner;

public class QuValidateId {

	private static boolean idValidate(String inputId) {
		
		if(inputId.length() < 8 && inputId.length() > 12) {
			System.out.println("8~12자 이내로 입력해주세요.");
			return false;			
		}
		
		for(int i=0 ; i<inputId.length() ; i++) {
			char idChar = inputId.charAt(i);
			if(!((idChar >= '0' && idChar <= '9')
				|| (idChar >= 'a' && idChar <= 'z')
				|| (idChar >= 'A' && idChar <= 'Z')))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("아이디를 입력하세요");
		String id = scan.nextLine();
		
		boolean isValid = idValidate(id);
	}
}
