package com.edu.springboot;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.springboot.jdbc.IMemberService;
import com.edu.springboot.jdbc.MemberDTO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController {
	
	/*
	 * Mapper 인터페이스를 통해 XML파일에 정의된 메서드를 호출하게 되므로
	 * 자동주입 받아서 준비한다. 해당 인터페이스는 @Mapper가 부착되어 있으므로
	 * 컨테이너가 시작될 때 자동으로 빈이 생성된다.
	 */
	@Autowired
	IMemberService dao;
	
	@RequestMapping("/")
	public String main() {
		return "main";
	}
	
	//회원목록
	@RequestMapping("/list.do")
	public String member2(Model model, MemberDTO memberDTO) {
		
		System.out.println(memberDTO.getSearchField());
		System.out.println(memberDTO.getSearchKeyword());
		
		model.addAttribute("memberList", dao.select(memberDTO));
		return "list";
	}
	
	//글쓰기 페이지 진입
	@GetMapping("/regist.do")
	public String member1() {
		return "regist";
	}
	//글쓰기 처리
	@PostMapping("/regist.do")
	public String member6(HttpServletRequest req) {
		/*
		 * 전송된 폼값은 request 내장객체를 통해 개별적으로 전달받는다
		 */
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String name = req.getParameter("name");
		
		//함수 호출시에도 개별적으로 전달해야한다.
		int result = dao.insert(id, pass, name);
		if(result==1) System.out.println("입력되었습니다.");
		return "redirect:list.do";
	}
	
	//회원수정페이지 진입
	@GetMapping("/edit.do")
	public String member3(HttpServletRequest req, 
			MemberDTO memberDTO, Model model) {
		//request내장객체로 id를 받는다.
		memberDTO = dao.selectOne(req.getParameter("id"));
		model.addAttribute("dto", memberDTO);
		return "edit";
	}
	//수정처리 진행
	@PostMapping("/edit.do")
	public String member7(HttpServletRequest req) {
		//request 내장객체를 통해 폼값 받기
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String name = req.getParameter("name");
		
		//받은 폼값은 Map에 저장
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("m_id", id);
		paramMap.put("m_pass", pass);
		paramMap.put("m_name", name);
		
		//함수 호출시 Map을 인수로 전달
		int result = dao.update(paramMap);
		if(result==1) System.out.println("수정되었습니다.");
		return "redirect:list.do";
	}
	
	//회원삭제(GET방식)
	@GetMapping("/delete.do")
	public String member4(HttpServletRequest req) {
		//request 내장객체로 받은 후 전달
		String id = req.getParameter("id");
		int result = dao.delete(id);
		if(result==1) System.out.println("삭제되었습니다.");
		return "redirect:list.do";
	}
	//회원삭제(POST방식)
	@PostMapping("/delete.do")
	public String member9(HttpServletRequest req) {
		String id = req.getParameter("id");
		int result = dao.delete(id);
		if(result==1) System.out.println("삭제되었습니다.");
		return "redirect:list.do";
	}
}
