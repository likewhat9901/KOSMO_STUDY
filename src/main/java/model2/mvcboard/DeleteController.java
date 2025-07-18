package model2.mvcboard;

import java.io.IOException;

import fileupload.FileUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import utils.JSFunction;

@WebServlet("/mvcboard/delete.do")
public class DeleteController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//로그인 확인
		/*
		 * 회원제 게시판이므로 삭제 시 작성자 본인인지 확인해야 한다.
		 * 일단 로그인된 상태인지부터 확인.
		 * request 내장객체를 통해 session 내장객체를 얻어옴.
		 */
		HttpSession session = req.getSession();
		//session 영역에 회원 인증정보가 저장되어 있는지 확인
		if(session.getAttribute("UserId")==null) {
			JSFunction.alertLocation(resp, "로그인 후 이용해주세요", "../06Session/LoginForm.jsp");
			return;
		}
		
		//게시물 얻어오기
		//로그인 된 상태라면 게시물 삭제시도.
		String idx = req.getParameter("idx");
		MVCBoardDAO dao = new MVCBoardDAO();
		//작성자 본인확인을 위해 해당게시물 열람을 위한 메서드 호출
		MVCBoardDTO dto = dao.selectView(idx);
		
		//작성자 본인 확인
		/*
		 * DB에 등록된 작성자 아이디와 session에 저장된 아이디가 같은지 확인.
		 * 즉 로그인한 사용자와 작성자가 같은지 확인한 후 일치하지 않으면
		 * 경고창을 띄우고, 뒤로 이동.
		 */
		if(!dto.getId().equals(session.getAttribute("UserId").toString())) {
			JSFunction.alertBack(resp, "작성자 본인만 삭제할 수 있습니다.");
			return;
		}
		
		//게시물 삭제
		//작성자가 확인되었다면 게시물 삭제 진행
		int result = dao.deletePost(idx);
		dao.close();
		//게시물 삭제 성공 시 첨부파일도 삭제
		/* 4. 서버 디렉토리에 올렸던 파일을 삭제하지 않으면?
			고아 파일(orphan file) 이 생김 → 사용되지도 않는데 서버 공간 차지
		 */
		if(result == 1) {
			//첨부파일도 함께 삭제한다. 저장된 파일명을 얻어온 후
			String saveFileName = dto.getSfile();
			//파일을 물리적으로 삭제한다.
			FileUtil.deleteFile(req, "/Uploads", saveFileName);
		}
		//삭제후 목록으로 이동.
		JSFunction.alertLocation(resp, "삭제되었습니다.", "../mvcboard/list.do");
	}
}
