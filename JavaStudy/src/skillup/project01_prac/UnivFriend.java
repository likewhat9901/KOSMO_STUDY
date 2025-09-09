package skillup.project01_prac;

public class UnivFriend {

	String name;
	String phone;
	String addr;
	String major;
	
	public void showAllData() {
		System.out.println("대딩친구[전체정보]");
		System.out.print("이름:"+ name);
		System.out.print(", 전화번호:"+ phone);
		System.out.print(", 주소:"+ addr);
		System.out.println(", 전공:"+ major);
	}
	public void showBasicInfo() {
		System.out.println("대딩친구[간략정보]");
		System.out.print("이름:"+ name);
		System.out.print(", 전공:"+ major);
		System.out.println(", 전화번호:"+ phone);
	}
}
