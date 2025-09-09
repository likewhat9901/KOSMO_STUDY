package ex12inheritance.map;

public class Korea2 {
	private String name;
	public Korea2(String name) {
		this.name = name;
	}
	public void publicMethod(String loc) {
		System.out.println(loc +"publicMethod() 호출");
		defaultMethod("publicMethod->");
	}
	protected void protectedMethod(String loc) {
		System.out.println(loc+"protectedMethod() 호출");
		privateMethod("protectedMethod->");
	}
	void defaultMethod(String loc) {
		System.out.println(loc +"defaultMethod() 호출");
	}
	private void privateMethod(String loc) {
		System.out.println(loc +"privateMethod() 호출");
	}
}
