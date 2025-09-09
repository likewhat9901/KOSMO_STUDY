package ex07string;

public class E02StringMethod1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("String 클래스의 주요 메소드1");
		System.out.println();
		
		String str1 = "Welcome to java";
		String str2 = "자바야 놀자!";

		// length(): 문자열의 길이를 반환.
		System.out.println("### 1. length() ###");
		System.out.println("str1의 길이:"+ str1.length());
		System.out.println("str2의 길이:"+ str2.length());
		System.out.println();
		
		/*
		 charAt(인덱스)
		 - 문자열에서 특정 index에 해당하는 문자 하나를 반환한다.
		 - index는 배열과 같이 0부터 시작한다.
		 */
		System.out.println("### 2.charAt(인덱스) ###");
		System.out.println("str1의 두번째 문자:"+ str1.charAt(1));
		System.out.println("str2의 두번째 문자:"+ str2.charAt(1));
		System.out.println();
		
		/*
		 compareTo()
		 - 2개의 문자열의 첫번째 문자부터 순차적으로 비교하면서
		   앞문자의 아스키코드가 크면 양수를 반환하고, 뒷문자의 아스키코드가 크면 음수를 반환한다.
		 - 두 문자열이 같을땐 0을 반환한다.
		 */
		System.out.println("### 3.compareTo() ###");
		//A라는 문자를 "(double quotation)으로 감쌌으므로 문자열로 선언된다.
		String str3 = "A";
		String str4 = "B";
		System.out.println(str3.compareTo(str4));
		System.out.println(str4.compareTo(str3));
		System.out.println("ABC".compareTo("ABC")==0 ?
				"문자열이 같다." : "문자열이 다르다.");
		System.out.println();
		
		/*
		 concat()
		 - 두 개의 문자열을 연결할때 사용.
		 - print문에서 +와 같은 역할.
		 */
		System.out.println("### 4.concat() ###");
		System.out.println("JAVA".concat(" WORLD").concat(" Go"));
		System.out.println("JAVA"+" WORLD"+" Go");
		System.out.println();
		
		/*
		 contains()
		 - 문자열에 특정 문자열이 포함된 경우, true를 반환한다.
		 */
		System.out.println("### 5.contains() ###");
		System.out.println(str1.contains("To"));
		System.out.println(str1.contains("to"));
		
		
		
		
	}

}
