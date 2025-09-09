package ex21jdbc.shopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class SelectShop {

	public Connection conn;
	public Statement stmt;
	public ResultSet rs;
	
	// 오라클 DB 정보
	public static final String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
	public static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	public void dbClose() {
		try {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
			System.out.println("DB 자원 반납 완료");
		} catch (Exception e) {
			System.out.println("자원 반납 중 예외 발생");
			e.printStackTrace();
		}
	}
	
	public void searchProduct() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("검색할 상품명 입력: ");
		String searchName = scanner.nextLine();
		
		try {
			Class.forName(ORACLE_DRIVER);
			conn = DriverManager.getConnection(ORACLE_URL, "education", "1234");
			stmt = conn.createStatement();
			
			String query = "SELECT g_idx, goods_name, goods_price, regidate, p_code"
					+ " FROM sh_goods "
					+ " WHERE goods_name LIKE '%" + searchName + "%' ";
			
			//ResultSet에 stmt 실행해서 query 결과 담기
			rs = stmt.executeQuery(query);
			
			// 출력 포맷 설정
			DecimalFormat df = new DecimalFormat("#,###");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			while (rs.next()) {
				int idx = rs.getInt("g_idx");
				String name = rs.getString("goods_name");
				int price = rs.getInt("goods_price");
				String date = sdf.format(rs.getTimestamp("regidate"));
				String code = rs.getString("p_code");
				
				System.out.printf("%d | %s | ￦%s만원 | %s | %s\n",
							idx, name, df.format(price), date, code);
			}
			
		} catch (Exception e) {
			System.out.println("상품 검색 중 예외 발생");
			e.printStackTrace();
		}
		
		scanner.close();
	}
	
	public static void main(String[] args) {
		SelectShop shop = new SelectShop();
		shop.searchProduct();
		shop.dbClose();
	}
}
