package ex21jdbc.shopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.Scanner;

public class InsertShop{
	
	// DB 연결을 위한 멤버변수
	public Connection conn; //DB연결
	public PreparedStatement psmt; //동적 쿼리문 실행
	
	// 오라클 DB 정보
	public static final String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
	public static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	// 자원 해제용 메서드
	public void dbClose() {
		try {
			//변수를 넣는 동적 SQL문을 닫는 행위.
			if(psmt!=null) psmt.close();
			//DB 연결 객체 생성되었는지 확인하고, 생성되었으면 연결 닫기(리소스 정리)
			if(conn!=null) conn.close();
			System.out.println("DB 자원 반납 완료");
		} catch (Exception e) {
			System.out.println("DB 자원 반납 중 예외발생");
			e.printStackTrace();
		}		
	}
	
	public void inputValue() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("상품명 입력: ");
		String name = scanner.nextLine();
		
		System.out.print("상품가격 입력: ");
		int price = Integer.parseInt(scanner.nextLine());
		
		System.out.print("상품코드 입력: ");
		String code = scanner.nextLine();
		
		//동적쿼리문으로 테이블에 레코드 삽입
		int result = insertProduct(name, price, code);
		// 몇개의 행이 삽입되었는지 반환.
		System.out.println(result + "개의 행이 삽입되었습니다.");
		
		scanner.close();
	}
	
	//DB에 상품 추가하기
	public int insertProduct(String name, int price, String code) {
		
		int result = 0;
		
		try {
			//드라이버 로딩
			Class.forName(ORACLE_DRIVER); //오라클 JDBC 드라이버 로딩
			
			//DB에 연결
			conn = DriverManager.getConnection(ORACLE_URL, "education", "1234"); // 오라클 DB 서버 연결
			
			//SQL문 작성
			String sql = "INSERT INTO sh_goods (goods_name, goods_price, p_code) values (?, ?, ?)";
			psmt = conn.prepareStatement(sql);
			
			// ?에 값 넣기
			psmt.setString(1, name);
			psmt.setInt(2, price);
			psmt.setString(3, code);
			
			//실행
			result = psmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버를 찾을 수 없습니다.");
			e.printStackTrace();
		}
		catch (SQLException e) {
			System.out.println("DB연결 오류 발생");
			e.printStackTrace();
		}
		
		//삽입한 행의 개수 반환
		return result;
	}
	
	public static void main(String[] args) {
		InsertShop shop = new InsertShop();
		shop.inputValue();
		shop.dbClose();
	}
	
}
