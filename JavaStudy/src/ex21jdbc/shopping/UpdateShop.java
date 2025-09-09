package ex21jdbc.shopping;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateShop {

	public Connection conn;
	public CallableStatement csmt;
	
	// 오라클 DB 정보
	public static final String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
	public static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	public void dbClose() {
		try {
			//자원 반납
			if(csmt != null) csmt.close();
			if(conn != null) conn.close();
			System.out.println("DB 자원 반납 완료");
		} catch (Exception e) {
			System.out.println("자원 반납 중 예외 발생");
			e.printStackTrace();
		}
	}
	
	public void inputValue() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("수정할 상품의 일련번호 입력: ");
		int no = Integer.parseInt(scanner.nextLine());
		
		System.out.print("새로운 상품명 입력: ");
		String name = scanner.nextLine();
		
		System.out.print("새로운 상품가격 입력: ");
		int price = Integer.parseInt(scanner.nextLine());
		
		System.out.print("새로운 상품코드 입력: ");
		String code = scanner.nextLine();
		
		int result = updateProduct(name, price, code, no);
		
		if (result == 1) {
			System.out.println("상품 수정 성공!");
		} else {
			System.out.println("상품 수정 실패..");
		}
		
		dbClose();
	}
	
	public int updateProduct(String name, int price, String code, int no) {
		int result = 0;
		
		try {
			Class.forName(ORACLE_DRIVER);
			conn = DriverManager.getConnection(ORACLE_URL, "education", "1234");
			
			// 프로시저 호출
			String sql = "{ CALL ShopUpdateGoods(?, ?, ?, ?, ?) }";
			csmt = conn.prepareCall(sql);
			
			csmt.setString(1, name);
			csmt.setInt(2, price);
			csmt.setString(3, code);
			csmt.setInt(4, no);
			
			//out파라미터
			csmt.registerOutParameter(5, java.sql.Types.INTEGER);
			
			//프로시저 실행
			csmt.execute();
			
			result = csmt.getInt(5);
			
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버를 찾을 수 없습니다.");
			e.printStackTrace();
		}
		catch (SQLException e) {
			System.out.println("DB연결 오류 발생");
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		UpdateShop shop = new UpdateShop();
		shop.inputValue();
		
	}
}
