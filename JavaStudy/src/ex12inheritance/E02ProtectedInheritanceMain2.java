package ex12inheritance;

import ex12inheritance.map.Korea2;

class Seoul2 extends Korea2 {
	private String cityString;
	public Seoul2(String name, String city) {
		super(name);
//		this.city = city;
	}
	
	public void callMethod() {
		super.publicMethod("callMethod->");
		super.protectedMethod("callMethod->");
//		super.defaultMethod(); //에러
//		super.privateMethod(); //발생
	}
}

public class E02ProtectedInheritanceMain2 {

	public static void main(String[] args) {
//		Seoul seoul = new Seoul("대한민국")
	}

}
