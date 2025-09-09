package com.edu.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.springboot.jdbc.IMemberService;
import com.edu.springboot.jdbc.MemberDTO;

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
	public String member2(Model model) {
		/*
		 * dao.select()를 통해 인터페이스의 추상메서드를 호출한다.
		 * 그러면 인터페이스와 연결된 Mapper에 정의된 특정 엘리먼트가 호출되어
		 * 쿼리문이 실행되고 결과를 반환한다.
		 */
		model.addAttribute("memberList", dao.select());
		return "list";
	}
	
	//글쓰기 페이지 진입
	@GetMapping("/regist.do")
	public String member1() {
		return "regist";
	}
	//글쓰기 처리
	@PostMapping("/regist.do")
	public String member6(MemberDTO memberDTO) {
		int result = dao.insert(memberDTO);
		if(result==1) System.out.println("입력되었습니다.");
		return "redirect:list.do";
	}
	
	//회원수정페이지 진입
	@GetMapping("/edit.do")
	public String member3(MemberDTO memberDTO, Model model) {
		memberDTO = dao.selectOne(memberDTO);
		model.addAttribute("dto", memberDTO);
		return "edit";
	}
	//수정처리 진행
	@PostMapping("/edit.do")
	public String member7(MemberDTO memberDTO) {
		int result = dao.update(memberDTO);
		if(result==1) System.out.println("수정되었습니다.");
		return "redirect:list.do";
	}
	
	//회원삭제(GET방식)
	@GetMapping("/delete.do")
	public String member4(MemberDTO memberDTO) {
		int result = dao.delete(memberDTO);
		if(result==1) System.out.println("삭제되었습니다.");
		return "redirect:list.do";
	}
	//회원삭제(POST방식)
	@PostMapping("/delete.do")
	public String member9(MemberDTO memberDTO) {
		int result = dao.delete(memberDTO);
		if(result==1) System.out.println("삭제되었습니다.");
		return "redirect:list.do";
	}
}
