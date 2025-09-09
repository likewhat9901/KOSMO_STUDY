package model2.mvcboard;

import java.io.IOException;
import java.util.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 이 컨트롤러(서블릿)의 매핑은 web.xml에서 정의한다.
public class ListController extends HttpServlet {
	
	//게시판에서 목록은 메뉴를 클릭해서 진입하므로 GET방식의 요청임
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		//DAO 생성 및 DBCP를 통한 오라클 연결
		MVCBoardDAO dao = new MVCBoardDAO();
		
		//뷰에 전달할 매개변수 저장용 맵 생성
		Map<String, Object> map = new HashMap<String, Object>();
		
		//검색을 위한 파라미터를 받음
		String searchField = req.getParameter("searchField");
		String searchWord = req.getParameter("searchWord");
		//검색어가 있는 경우에는 Map 인스턴스에 저장
		if (searchWord != null) {
			//쿼리스트링으로 전달받은 매개변수 중 검색어가 있다면 map에 저장
			map.put("searchField", searchField);
			map.put("searchWord", searchWord);
		}
		//게시물의 개수 카운트를 위한 메서드 실행
		int totalCount = dao.selectCount(map);
		map.put("totalCount", totalCount);
		
		//목록에 출력할 레코드 인출을 위한 메서드 실행
		List<MVCBoardDTO> boardLists = dao.selectList(map);
		dao.close();
		
		//View로 전달할 데이터를 request 영역에 저장
		req.setAttribute("boardLists", boardLists);
		req.setAttribute("map", map);
		//View인 List.jsp로 포워드해서 request 영역에 저장된 데이터를 공유
		req.getRequestDispatcher("/14MVCBoard/List.jsp")
			.forward(req, resp);
		
	}
}
