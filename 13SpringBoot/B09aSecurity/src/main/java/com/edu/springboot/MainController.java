package com.edu.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	//root경로 : 인증없이 누구든 접속 가능
	@GetMapping("/")
	public String main() {
		return "main";
	}
	
	//누구든 접속 가능
	@GetMapping("/guest/index.do")
	public String welcome1() {
		return "guest";
	}
	
	//Admin, user 중 하나의 권한만 있으면 접속 가능
	@GetMapping("/member/index.do")
	public String welcome2() {
		return "member";
	}
	
	//Admin 권한만 접속가능
	@GetMapping("/admin/index.do")
	public String welcome3() {
		return "admin";
	}
	
}
