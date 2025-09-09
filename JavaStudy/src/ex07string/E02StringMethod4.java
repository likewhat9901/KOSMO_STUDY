package ex07string;

import java.awt.SystemTray;
import java.util.Scanner;
import java.util.concurrent.SubmissionPublisher;

public class E02StringMethod4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		시나리오1] 주민등록번호를 이용하여 성별을 판단하는
		프로그램을 charAt()을 이용해서 작성하시오.
		190419-3000000 => 남자
		190419-4000000 => 여자
		*/
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("[주민등록번호를 이용한 성별판단]");
		System.out.println("주민등록번호를 입력하세요.('-'포함)");
		String jumiNum= scanner.nextLine();
		int gender = jumiNum.charAt(7); 

		if (gender == '1' || gender == '3') {
			System.out.println("남자입니다.");
		}else if ((gender == '2') || (gender == '4')) {
			System.out.println("여자입니다.");
		}else if ((gender == '5') || (gender == '6')) {
			System.out.println("외국인입니다.");
		}else {
			System.out.println("잘못된 주민등록번호입니다.");
		}
		System.out.println();
		
		/*
		시나리오2] 해당 문자열이 이메일 형식인지 검사하는
		프로그램을 contains()를 이용해서 작성하시오.
		hong@daum.net => 이메일형식임
		not@naver => 이메일형식이아님
		*/
		//@와.이 있는지
		
		System.out.println("[이메일형식 검증]");
		System.out.println("이메일을 입력하세요.");
		String email = scanner.nextLine();
		boolean at = email.contains("@");
		boolean dat = email.contains(".");
		
		if (at && dat) {
			System.out.println("이메일형식 맞음");
		}else {
			System.out.println("이메일형식 아님");
		}
		System.out.println();

		/*
		시나리오3]주민등록번호로 성별을 구분하는 프로그램을 indexOf()와 charAt()을 
		이용해서 작성하시오.
		*/	
		
		System.out.println("[주민등록번호를 이용한 성별판단2]");
		System.out.println("주민등록번호를 입력하세요.('-'포함)");
		String juminNum2 = scanner.nextLine();
		int gNum = juminNum2.indexOf('-') + 1;
		int gender2 = juminNum2.charAt(gNum); 
		
		if ((gender2 == '1') || (gender2 == '3')) {
		System.out.println("남자입니다.");
		}else if ((gender2 == '2') || (gender2 == '4')) {
			System.out.println("여자입니다.");
		}else if ((gender2 == '5') || (gender2 == '6')) {
			System.out.println("외국인입니다.");
		}else {
			System.out.println("잘못된 입력입니다.");
		}
		System.out.println();
		

		/*
		시나리오4] 다음 파일명에서 확장자를 잘라내는 프로그램을
		작성하시오. 
		파일명 : my.file.images.jpg
		*/
		//indexOf, lastIndexOf, substring
		
		System.out.println("[파일 확장자 확인]");
		System.out.println("파일명을 작성하세요.");
		String filename = scanner.nextLine();
		int ext = filename.lastIndexOf(".");

		if (ext != -1) {
			System.out.println("확장자: "+filename.substring(ext+1));			
		}else {
			System.out.println("확장자를 찾지 못했습니다.");
		}
		
		
		//정답
//		
//		/*
//		시나리오] 주민등록번호를 이용하여 성별을 판단하는
//		프로그램을 charAt()을 이용해서 작성하시오.
//		190419-3000000 => 남자
//		190419-4000000 => 여자
//		 */
//		System.out.println("### 시나리오1 ###");
//		String juminNum = "190419-1000000";
//		/*
//		주민번호로 주어진 문자열의 8번째 문자 즉 인덱스 7에 해당하는
//		문자가 성별을 표현하므로 이를 통해 판단할수 있다. 
//		이때 문자를 비교해야 하므로 '(싱글쿼테이션)을 사용해야한다.
//		 */
//		if(juminNum.charAt(7)=='1' || juminNum.charAt(7)=='3') {
//			System.out.println("남자입니다");
//		}
//		else if(juminNum.charAt(7)=='2' || juminNum.charAt(7)=='4') {
//			System.out.println("여자입니다");
//		}
//		else if(juminNum.charAt(7)=='5' || juminNum.charAt(7)=='6') {
//			System.out.println("외국인입니다");
//		}
//		else {
//			System.out.println("주민번호가 잘못 입력되었습니다.");
//		}
//		
//		
//		
//		/*
//		시나리오2] 해당 문자열이 이메일 형식인지 검사하는
//		프로그램을 contains()를 이용해서 작성하시오.
//		hong@daum.net, aaaa@domain.co.kr => 이메일형식임
//		not@naver => 이메일형식이아님
//		*/
//		//복습시 indexOf(), split() 메서드를 이용해서도 구현해보세요.
//		System.out.println("### 시나리오3 ###");
//		String email = "not@naver.com";
//		/*
//		이메일은 아이디와 도메인을 구분하는 @(엣)과 
//		도메인 부분에 .(닷)이 동시에 포함되므로 이를 이용해서 판단한다.
//		 */
//		if(email.contains("@") && email.contains(".")) {
//			System.out.println("이메일 형식이 맞습니다.");
//		}
//		else {
//			System.out.println("이메일 형식이 아닙니다.");
//		}
//	
//
//		
//
//		/*
//		시나리오]주민등록번호로 성별을 구분하는 프로그램을 indexOf()와 
//			charAt()을 이용해서 작성하시오.
//		*/	
//		System.out.println("### 시나리오2 ###");
//		String jumin = "190419-2000000";
//		//하이픈의 인덱스를 찾은후 1을 더해 성별에 해당하는 문자의
//		//인덱스를 구한다. 
//		int index = jumin.indexOf("-") + 1;
//		//앞에서 구한 인덱스를 charAt() 인수로 전달한다.
//		if(jumin.charAt(index)=='1' || jumin.charAt(index)=='3') {
//			System.out.println("남자");
//		}
//		else if(jumin.charAt(index)=='2' || jumin.charAt(index)=='4') {
//			System.out.println("여자");
//		}
//		else if(jumin.charAt(index)=='5' || jumin.charAt(index)=='6') {
//			System.out.println("외국인");
//		}
//		
//		
//		
//		
//		/*
//		시나리오] 다음 파일명에서 확장자를 잘라내는 프로그램을
//		작성하시오. 
//		파일명 : my.file.images.jpg
//		*/
//		System.out.println("### 시나리오4 ###");
//		
//		System.out.println("방법1-lastIndexOf사용");
//		String filename = "my3545.4354343.fi4.54le.456.56.images986856.jpg";
//		int indexNum = filename.lastIndexOf(".") + 1;
//		System.out.println("내가찾은인덱스:"+ indexNum);
//		String fileExt = filename.substring(indexNum);
//		System.out.println("파일확장자:"+ fileExt);
//		
//		System.out.println("방법2-split사용");
//		//Java에서 split()메서드 사용시 .(닷)의 경우 []를 씌워야된다.
//		String[] strArr = filename.split("[.]");
//		System.out.println("배열의크기:"+ strArr.length);
//		System.out.println("파일확장자:"+ strArr[strArr.length-1]);
//		


	}

}
