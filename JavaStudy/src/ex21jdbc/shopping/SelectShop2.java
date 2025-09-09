package ex21jdbc.shopping;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import ex21jdbc.crud.MyConnection;

public class SelectShop2 extends MyConnection{

	public SelectShop2(String user, String pass) {
		super(user, pass);
	}
	
	@Override
	public void dbExecute() {
		try {
			stmt = con.createStatement();
			
			String sql = "SELECT * FROM sh_goods "
					+ " WHERE goods_name LIKE '%" + inputValue("검색할 상품명") + "%' ";
			
			rs = stmt.executeQuery(sql);
			
			// 출력 포맷 설정
			DecimalFormat df = new DecimalFormat("#,###");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			while(rs.next()) {
				int idx = rs.getInt("g_idx");
				String name = rs.getString("goods_name");
				int price = rs.getInt("goods_price");
				String date = sdf.format(rs.getTimestamp("regidate"));
				String code = rs.getString("p_code");
				
				System.out.println("상품번호 | 상품이름 | 상품가격 | 입고날짜 | 상품코드");
				System.out.printf("%d번 | %s | ￦ %s만원 | %s | %s\n",
						idx, name, df.format(price), date, code);
			}
		} catch (Exception e) {
			System.out.println("상품 검색 중 예외 발생");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new SelectShop2("education", "1234").dbExecute();;
	}
}
