package ex12overriding;

class Burger {
	//멤버변수
	/* 버거명, 가격, 패티, 소스, 야체을 표현 */
	private String name, patty, sauce, vegetable;
	private int price;
	
	//인자생성자
	public Burger(String name, int price, String patty, String sauce, String vegetable) {
		this.name = name;
		this.price = price;
		this.patty = patty;
		this.sauce = sauce;
		this.vegetable = vegetable;
	}
	
	//getter : price만 필요
	public int getPrice() {
		return price;
	}
	
	//햄버거 정보 출력
	/* 버거명, 가격, 식재료 출력*/
	public void showBurgerInfo() {
		System.out.println(name);
		System.out.println("가격:"+price);
		System.out.println("식재료: " + patty + ", " + sauce + ", " + vegetable);
	}
}
//햄버거의 기본가격 추상화 
class HamburgerPrice {
	//멤버변수
	/* 햄버거종류, 음료, 프렌치프라이 */
	Burger burger;
	final int COKE = 1000;
	final int POTATO = 1500;

	//인자생성자
	public HamburgerPrice(Burger burger) {
		this.burger = burger;
	}

	//기본가격계산
	public int calculatePrice() {
		return burger.getPrice() + COKE + POTATO;
	}
	
	//햄버거와 결제금액 출력
	public void showPrice() {
		burger.showBurgerInfo();
		System.out.println("결제금액: " + calculatePrice());
		System.out.println("============================");
	}
}
//세트가격을 추상화(기본가격을 상속)
class SetPrice extends HamburgerPrice {	
	//인자생성자
	public SetPrice(Burger burger) {
		super(burger);
	}

	//세트가격계산(오버라이딩)
	@Override
	public int calculatePrice() {
		return super.calculatePrice() - 500;
	}
	
	//햄버거와 세트결제금액 출력(오버라이딩)	
	@Override
	public void showPrice() {
		burger.showBurgerInfo();
		System.out.println("세트결제금액: " + calculatePrice());
		System.out.println("============================");
	}
}

public class QuBuyHamburger {

	public static void main(String[] args) {
		
		//치즈버거 객체 생성
		Burger burger1 = new Burger("치즈버거", 2000, "쇠고기패티", "케챱", "피클");
		//치킨버거 객체 생성
		Burger burger2 = new Burger("치킨버거", 3000, "닭고기패티", "마요네즈", "양상치");
		
		//치즈버거를 기본가격으로 구매
		HamburgerPrice price1 = new HamburgerPrice(burger1); 
		price1.showPrice();	// 4500원	
		
		//치킨버거를 세트가격으로 구매
		HamburgerPrice price2 = new SetPrice(burger2); 
		price2.showPrice();	// 5000원
	}
}
