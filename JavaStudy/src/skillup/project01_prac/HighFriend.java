package skillup.project01_prac;

public class HighFriend {
	
	String name;
	String phone;
	String addr;
	String nickname;
	
	public HighFriend(String name, String phone, String addr, String nickname) {
		this.name = name;
		this.phone = phone;
		this.addr = addr;
		this.nickname = nickname;
	}
	
	public void showAllData() {
		System.out.println("==고딩친구[전체정보]==");
		System.out.print("이름:"+ name);
		System.out.print(", 전화번호:"+ phone);
		System.out.print(", 주소:"+ addr);
		System.out.println(", 별명:"+ nickname);
	}
	
	public void showBasicInfo() {
		System.out.println("고딩친구[간략정보]");
		System.out.print("별명:"+ nickname);
		System.out.println(", 전번:"+ phone);
	}
}
