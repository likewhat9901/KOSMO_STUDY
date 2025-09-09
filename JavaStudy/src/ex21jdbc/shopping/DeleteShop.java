package ex21jdbc.shopping;

import java.sql.*;
import java.util.Scanner;


public class DeleteShop {

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
	
	public void deleteProduct() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("삭제할 상품의 일련번호 입력: ");
		int no = Integer.parseInt(scanner.nextLine());
		
		try {
			Class.forName(ORACLE_DRIVER);
			conn = DriverManager.getConnection(ORACLE_URL, "education", "1234");
			
			//프로시저 호출
			csmt = conn.prepareCall("{ CALL ShopDeleteGoods(?, ?) }");
			
			//in파라미터 설정
			csmt.setInt(1, no);
			
			//out파라미터 설정
			csmt.registerOutParameter(2, java.sql.Types.INTEGER);
			
			//실행
			csmt.execute();
			
			int result = csmt.getInt(2);
			
			if (result == 1) {
				System.out.println("상품이 성공적으로 삭제되었습니다.");
			} else {
				System.out.println("삭제할 상품이 없습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
	}
	
	public static void main(String[] args) {
		DeleteShop shop = new DeleteShop();
		shop.deleteProduct();
		
	}
}
