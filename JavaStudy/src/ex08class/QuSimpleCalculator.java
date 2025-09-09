package ex08class;

class CalculatorEx {
	
	int addcnt, mincnt, mulcnt, divcnt;
	
	void init() {
		addcnt = 0;
		mincnt = 0;
		mulcnt = 0;
		divcnt = 0;
	}
	public double add(int a, int b) {
		addcnt++;
		return a+b;
	}
	public double min(double a, double b) {
		mincnt++;
		return a-b;
	}
	public double mul(double a, double b) {
		mulcnt++;
		return a*b;
	}
	public double div(int a, int b) {
		if (b==0) {
			System.out.println("0으로 나눌 수 없습니다.");
			return Double.NaN;
		}
		divcnt++;
		return a/b;
	}
	public void showOpCount() {
		System.out.printf("덧셈횟수 : %d%n", addcnt);
		System.out.printf("뺄셈횟수 : %d%n", mincnt);
		System.out.printf("곱셈횟수 : %d%n", mulcnt);
		System.out.printf("나눗셈횟수 : %d%n", divcnt);
	}
}

public class QuSimpleCalculator {

	public static void main(String[] args)
	{
		CalculatorEx cal = new CalculatorEx();
		cal.init();
		System.out.println("1 + 2 = " + cal.add(1 , 2));
		System.out.println("10.5 - 5.5 = " + cal.min(10.5 , 5.5));
		System.out.println("4.0 * 5.0 = " + cal.mul(4.0 , 5.0));
		System.out.println("100 / 25 = " + cal.div(100 , 25));
		System.out.println("10.0 * 3.0 = " + cal.mul(10.0 , 3.0));
		cal.showOpCount();
	}	
	
}
