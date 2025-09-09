package skillup.project01;

import java.util.Scanner;

/*
 * 주소록관리프로그램에서 기능을 담당하는 핸들러 클래스 정의.
 * main 메서드는 프로그램의 출발점의 역할만 담당하고, 모든 기능은 핸들러 클래스에서 구현한다.
 */
public class FriendInfoHandler {
	/*
	 * 연락처를 저장하기 위한 인스턴스형 배열을 생성. 고딩/대딩 각각의 배열이 필요하고, 카운트를 위한
	 * 변수도 생성한다.
	 */
	private HighFriend[] highFriends;
	private int numOfhighFriend;
	private UnivFriend[] univFriends;
	private int numOfunivFriend;
	private final Scanner scan = new Scanner(System.in);
	
	//생성자: 배열의 크기를 결정할 값을 매개변수로 받음
	public FriendInfoHandler(int num) {
		//num의 크기로 배열이 생성된다.
		highFriends = new HighFriend[num];
		//입력된 정보의 개수(or 인덱스) 카운트를 위한 변수
		numOfhighFriend = 0;
		univFriends = new UnivFriend[num];
		numOfunivFriend = 0;
	}
	
	//연락처 정보 추가
	public void addFriend(int choice) {
//		Scanner scan = new Scanner(System.in);
		//입력값을 저장할 변수 생성
		String iName, iPhone, iAddr, iNickname, iMajor;
		//공통정보 3가지 입력
		System.out.print("이름:"); iName = scan.nextLine();
		System.out.print("전화번호:"); iPhone = scan.nextLine();
		System.out.print("주소:"); iAddr = scan.nextLine();
		
		if(choice==1) {
			//고딩인 경우 별명을 추가로 입력
			System.out.print("별명:"); iNickname = scan.nextLine();
			//고딩 인스턴스 생성 후 참조값을 변수에 저장
			HighFriend high = new HighFriend(iName, iPhone, iAddr, iNickname);
			/*
			 * 인스턴스 참조값을 배열에 추가. 카운트용 변수를 후위증가 시켜 0번 인덱스에 먼저 입력된 후
			 * 1 증가하게 된다.
			 */
			highFriends[numOfhighFriend++] = high;
		}else if(choice==2) {
			//대딩인 경우 전공을 추가로 입력
			System.out.print("전공:"); iMajor = scan.nextLine();
			//대딩 인스턴스 생성과 동시에 배열에 추가
			univFriends[numOfunivFriend++] =
					new UnivFriend(iName, iPhone, iAddr, iMajor);
		}
		System.out.println("##친구정보 입력이 완료되었습니다##");
	}
	
	public void showAllData() {
		//System.out.println("## showAllData 호출됨 ##");
		//고딩친구 반복: 저장된 정보의 개수만큼 반복해서 전체정보를 출력한다.
		for(int i=0 ; i<numOfhighFriend ; i++) {
			highFriends[i].showAllData();
		}
		//대딩친구 반복
		for(int i=0 ; i<numOfunivFriend ; i++) {
			univFriends[i].showAllData();
		}
		System.out.println("##전체정보가 출력되었습니다##");
	}
	
	public void showSimpleData() {
		//System.out.println("## showSimpleData 호출됨 ##");
		//고딩친구 반복: 간략한 정보 2개만 출력한다.
		for(int i=0 ; i<numOfhighFriend ; i++) {
			highFriends[i].showBasicInfo();
		}
		//대딩친구 반복
		for(int i=0 ; i<numOfunivFriend ; i++) {
			univFriends[i].showBasicInfo();
		}
		System.out.println("##간략정보가 출력되었습니다##");
	}
	
	//이름으로 정보검색
	public void searchInfo() {
		//System.out.println("searchInfo 호출됨");
		boolean isFind = false;
//		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요:");
		String searchName = scan.nextLine();
		
		//고딩친구 반복
		for(int i=0 ; i<numOfhighFriend ; i++) {
			/*
			 * 문자열 비교를 위한 메서드 중 compareTo()를 사용해서 검색 기능 구현.
			 * "문자열1.compareTo(문자열2)"형식으로 사용하고 일치하는 경우 0을 반환한다.
			 */
			if(searchName.compareTo(highFriends[i].name)==0) {
				//검색할 이름과 일치하다면 전체 정보를 출력
				highFriends[i].showAllData();
				System.out.println("##귀하가 요청하는 정보를 찾았습니다.##");
				//정보를 찾았으므로 true로 변경
				isFind = true;
			}
		}
		//대딩친구 반복(고딩과 로직 동일)
		for(int i=0 ; i<numOfunivFriend ; i++) {
			if(searchName.equals(univFriends[i].name)==true) {
				univFriends[i].showAllData();
				System.out.println("##귀하가 요청하는 정보를 찾았습니다.##");
				isFind = true;
			}
		}
		
		//만약 검색결과가 없다면 아래와 같이 출력
		if(isFind==false)
			System.out.println("##찾는 정보가 없습니다.##");
	}
	
	public void deleteInfo() {
//		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = scan.nextLine();
		
	}
	
}
