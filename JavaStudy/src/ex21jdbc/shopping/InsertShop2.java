package ex21jdbc.shopping;

import java.sql.SQLException;
import ex21jdbc.crud.MyConnection;

public class InsertShop2 extends MyConnection{
	
	public InsertShop2(String user, String pass) {
		super(user, pass);
	}
	
	@Override
	public void dbExecute() {
		try {
			String sql = "INSERT INTO sh_goods (goods_name, goods_price, p_code)"
					+ " values (?, ?, ?)";
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, inputValue("상품명"));
			psmt.setInt(2, Integer.parseInt(inputValue("상품가격")));
			psmt.setString(3, inputValue("상품코드"));
			
			int result = psmt.executeUpdate();
			
			if (result >= 1) {
				System.out.println("상품 등록 성공!");
				System.out.println("[psmt]"+ result + "행 입력됨");
			} else {
				System.out.println("상품 등록 실패ㅠㅠ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new InsertShop2("education", "1234").dbExecute();
	}
}
