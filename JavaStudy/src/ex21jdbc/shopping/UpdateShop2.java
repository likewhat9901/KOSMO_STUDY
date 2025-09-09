package ex21jdbc.shopping;

import java.sql.SQLException;

import ex21jdbc.crud.MyConnection;

public class UpdateShop2 extends MyConnection{
	
	public static int result = 0;
	
	public UpdateShop2(String user, String pass) {
		super(user, pass);
	}
	
	@Override
	public void dbExecute() {
		try {
			String sql = "{ CALL ShopUpdateGoods(?, ?, ?, ?, ?) }";
			csmt = con.prepareCall(sql);
			
			csmt.setString(1, inputValue("상품명"));
			csmt.setInt(2, Integer.parseInt(inputValue("상품가격")));
			csmt.setString(3, inputValue("상품코드"));
			csmt.setInt(4, Integer.parseInt(inputValue("상품번호")));
			
			csmt.registerOutParameter(5, java.sql.Types.INTEGER);
			csmt.execute();
			
			result = csmt.getInt(5);
		} catch (SQLException e) {
			System.out.println("DB연결 오류 발생");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		new UpdateShop2("education", "1234").dbExecute();
		if (result >= 1) {
			System.out.println("상품 수정 성공!");
		} else {
			System.out.println("상품 수정 실패..");
		}
	}
}
