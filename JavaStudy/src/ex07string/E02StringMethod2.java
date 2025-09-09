package ex07string;

public class E02StringMethod2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("String 클래스의 주요 메소드2");
		System.out.println();
		
		String str1 = "Welcome to java";
		String str2 = "자바야 놀자!";
		
		/*
		 codePointAt(인덱스)
		 - 문자열의 특정 인덱스의 문자를 찾은 후 아스키코드(or 유니코드)를 반환한다.
		 */
		System.out.println("### 6.codePointAt() ###");
		System.out.println("str1 첫번째 문자의 아스키코드:"+
				str1.codePointAt(0)); //W:87
		System.out.println("str2 세번째 문자의 아스키코드:"+
				str1.codePointAt(2)); //야:50556
		System.out.println();
		
		/*
		 endsWith(): 특정 문자열로 끝나면 true를 반환
		 startsWith(): 시작될때 true를 반환
		 */
		System.out.println("### 7.endsWith(), 8.startsWith() ###");
		System.out.println("www.daum.net".endsWith("net"));
		System.out.println("naver.com".startsWith("http"));
		System.out.println();
		
		/*
		 format()
		 - 출력 형식을 지정하여 문자열로 반환할 때 사용.
		 - printf()와 사용법은 동일하고, 주로 웹애플리케이션(웹사이트)을 제작할 때 사용한다.
		 */
		System.out.println("### 9.format() ###");
		System.out.printf("국어:%d,영어:%d,수학:%d\n", 81,92,100);
		
		String formatStr =
				String.format("국어:%d,영어:%d,수학:%d\n", 81,92,100);
		System.out.println(formatStr);
		
		/*
		 indexOf()
		 - 문자열에서 특정 문자열의 시작인덱스를 반환한다.
		 - 만약 존재하지 않으면, -1을 반환한다.
		 - 인덱스는 0부터 시작이므로 -1은 해당 문자열이 없다는 의미로 해석할 수 있다.
		 */
		System.out.println("### 10.indexOf() ###");
		String email1 = "hong@daum.net";
		System.out.println(str1.indexOf("ava"));
		System.out.println(str1.indexOf("J"));
		System.out.println((email1.indexOf("@")!=-1)?
				"이메일형식맞음":"이메일형식아님");
		
	
		
	}

}
