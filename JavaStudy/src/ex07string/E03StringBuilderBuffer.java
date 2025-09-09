package ex07string;

/*
 StringBuffer 클래스
 - String 클래스는 기존 문자열에 새로운 문자열을 추가하면 새롭게 생성된 메모리에 문자열을 저장한다.
 - 기존 메모리가 소멸되고 새로운 메모리가 생성되는 낭비를 막기위해, 문자열의 변경이 많은 경우
   StringBuffer 를 사용하는 것이 좋다.
 - 이 클래스는 기존 메모리에 문자열을 추가(혹은 변경) 하는 방식으로 동작한다.
 */
public class E03StringBuilderBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 append(): 문자열 끝에 새로운 문자열을 추가
		 insert(): 지정한 인덱스에 문자열을 삽입
		 */
		StringBuffer strBuf = new StringBuffer("AB"); //? 문자열 변경 시 메모리활용에 유용.
		System.out.println("strBuf= "+ strBuf);
		//문자열 연결(정수, boolean 등 모두 가능)
		strBuf.append(25);
		strBuf.append("Y").append(true);
		System.out.println("strBuf= "+ strBuf);
		//인덱스 2에 false 삽입
		strBuf.insert(2, false);
		//문자열의 길이를 통해 마지막 부분에 추가 => append 와 같은 결과
		strBuf.insert(strBuf.length(), 'Z');
		System.out.println("strBuf= "+ strBuf);
		
		System.out.println();
		
		System.out.println("String 과 StringBuffer의 "
				+ "참조값 비교");
		// "(double quotation)을 통해 정의했으므로 동일한 참조값을 가짐.
		String str1 = "Java&JSP"; //? "(double quotation) 사용시 문자열 같은 경우, 동일한 주소 사용.
		String str2 = "Java&JSP"; //? 즉, 새로운 메모리 할당X. 주로 사용하는 방법
		if (str1==str2) {
			System.out.println("연결전:주소값동일"); //출력
		}else {
			System.out.println("연결전:주소값다름");		
		}
		
		//String은 문자열의 변경이 있는 경우, 기존 메모리를 소멸하고 새로운 메모리를 할당한다.
		str1 = str1 + "&Spring"; //? 새로운 주소에 다시 만듬.
		if (str1==str2) {
			System.out.println("연결후:주소값동일");
		}else {
			System.out.println("연결후:주소값다름"); //출력			
		}
		
		System.out.println();
		
		/*
		 StringBuffer는 문자열 저장을 위해 기본 메모리를 16으로 할당한다.
		 추후 저장공간이 부족해지면 자동으로 확장.
		 16->34->추가한만큼
		 */
		StringBuffer buf = new StringBuffer();
		System.out.println("buf= "+ buf);
		System.out.println("저장된 문자열크기: "+ buf.length());
		System.out.println("기본버퍼크기: "+ buf.capacity());
		
		buf.append("Java 공부중..");
		System.out.println("buf= "+ buf);
		System.out.println("저장된 문자열크기:"+ buf.length());
		System.out.println("기본버퍼크기: "+ buf.capacity());
		
		buf.append("금일은 StringBuffer 학습중..!!");
		System.out.println("buf= "+ buf);
		System.out.println("저장된 문자열크기:"+ buf.length());
		System.out.println("기본버퍼크기: "+ buf.capacity());
		
	}

}
