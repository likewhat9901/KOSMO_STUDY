package com.edu.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 이 클래스를 컨트롤러로 설정
@Controller
public class AuthController {
	/*
	 * 퀴즈
	 */
	//GetMapping으로 요청명 매핑
	@GetMapping("/memberRegist.do")
	public String memberRegist() {
		//View 경로를 반환하여 JSP로 포워드
		return "member/regist";
	}
	//로그인페이지
	@GetMapping("/memberLogin.do")
	public String memberLogin() {	
		return "member/login";
	}
	
	@PostMapping("/registProcess.do")
	public String registProcess(MemberDTO memberDTO) {

		return "member/registProcess";
	}
	//로그인 처리
//	@PostMapping("/loginProcess.do")
//	public String loginProcess(@RequestParam("id") String id,
//			@RequestParam("passwd") String passwd, Model model) {
//		
//		model.addAttribute("id", id);
//		model.addAttribute("passwd", passwd);
//		
//		return "member/loginProcess";
//	}
	@PostMapping("/loginProcess.do")
	public String loginProcess(MemberDTO memberDTO) {
		//모든 폼값은 커맨드객체인 DTO를 통해 한번에 받는다.
		return "member/loginProcess";
	}

}
