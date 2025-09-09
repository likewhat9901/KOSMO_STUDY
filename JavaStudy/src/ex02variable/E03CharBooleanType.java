package ex02variable;

public class E03CharBooleanType {
	
	public static void main(String[] args) {
		/*
		 char형: 하나의 문자를 저장할 수 있는 자료형으로 값을 저장할때 '(Single quotation)으로 감싸서 표현한다.
		 		만약 "(Double quotation)으로 감싸면 문자열로 인식하므로 String으로 선언해야 한다.
		 */
		char ch1 = '가';
		//char chStr ='가나다라';
		//에러발생. 문자열이므로 char로 선언불가. String으로 선언해야함.
		String chStr = "가나다라";
		System.out.println("ch1="+ ch1);
		System.out.println("chStr="+ chStr);
		
		/*
		 아스키코드
		 - 1byte로 표현할 수 있는 문자로 영어, 숫자를 십진수로 정의한 것을 말한다.
		 - ex. A => 65, a => 97
		 유니코드
		 - 1byte로 표현할 수 없는 문자로 영어, 숫자를 제외한 모든 문자를 2byte로 표현.
		 - 보통 큰 숫자이므로 16진수로 표현한다.
		 */
		char ch2 = 'A'; // 메모리에 65로 저장됨.
		int num1 = 2;
		//문자 + 정수 => 아스키코드로 저장되므로 연산 가능.
		int num2 = ch2 + num1; //실제 연산이 이뤄짐.
		System.out.println("num2="+ num2);
		//정수로 표현하면 67
		System.out.println("(char)num2="+ (char)num2);
		//문자로 출력하면 C.
		
		//char형으로 강제 형변환 후 출력.
		char ch3 = (char)(ch2 + num1);
		System.out.println("ch3(문자출력)=>"+ ch3);
		//int형으로 강제 형변환 후 출력.
		System.out.println("ch3(아스키코드출력)=>"+ (int)ch3);
		
		//'(Single quotation)으로 감쌌으므로 문자 1(아스키코드: 49)
		char ch4 = '1';
		//연산결과는 50이므로 이에 해당하는 문자는 '2'
		char ch4_1 = '1' + 1;
		//문자 '2'와 정수 50으로 출력됨.
		System.out.println("ch4="+ ch4 + ", ch4_1="+ ch4_1 + ", ch4_1=" + (int)ch4_1);
		
		/*
		 boolean타입 : true 혹은 false 두가지의 값만 가질 수 있는 자료형으로 산술연산(+,-), 비교연산(<, <=)
		 에서는 사용할 수 없고, 논리연산에서만 사용할 수 있다.
		 */
		boolean bn1 = true;
		boolean bn2 = false;
		System.out.println("bn1=" + bn1 + ", bn2=" + bn2);
		
		/*
		 &&: 논리 And로 양쪽 모두 true 일때만 true를 반환
		 ||: 논리 Or로 둘 중 하나만 true 여도 true를 반환
		 */
		// T && F => false를 반환
		boolean bn3 = bn1 && bn2;
		System.out.println("bn3(And)=" + bn3);
		// T||F => true를 반환
		bn3 = bn1 || bn2;
		System.out.println("bn3(Or)=" + bn3);
		
		// 문자 '가'는 유니코드 44032이므로 true 를 반환한다.
		bn3 = '가' > 30000;
		System.out.println("bn3=" + bn3);
		
	}
}
