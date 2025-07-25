package com.edu.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.springboot.jdbc.AddMember;
import com.edu.springboot.jdbc.ITicketService;
import com.edu.springboot.jdbc.PayDTO;
import com.edu.springboot.jdbc.TicketDTO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController {
	
	@Autowired
	ITicketService dao;
	
	@Autowired
	TransactionTemplate transactionTemplate;
	
	/*
	 * 추가작업 클래스 : 회원테이블에 구매한 회원의 이력을 입력한다.
	 * 	정의시 @Service 어노테이션을 부착한 상태이므로 자동주입이 가능하다.
	 */
	@Autowired
	AddMember addMember;
	
//====================================================
	
	@RequestMapping("/")
	public String main() {
		return "main";
	}
	
	@GetMapping("/buyTicket.do")
	public String buy1() {
		return "buy";
	}
	
	@PostMapping("/buyTicket.do")
	public String buy2(TicketDTO ticketDTO, PayDTO payDTO,
			HttpServletRequest req, Model model) {
		
		String viewPath = "success";
		
		try {
			transactionTemplate.execute(new TransactionCallbackWithoutResult() {
				
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus status) {
					
					String errFlag = req.getParameter("err_flag");
					
					//회원 정보 입력(추가작업. 클래스 외부에서 처리되는 부분)
					addMember.memberInsert(ticketDTO, errFlag);
					
					//1. DB처리1
					payDTO.setAmount(ticketDTO.getT_count() * 10000);
					int result1 = dao.payInsert(payDTO);
					if(result1 == 1) System.out.println("transaction_pay 입력성공");
					
					//2. 비즈니스로직 처리(의도적인 에러발생)
					if(errFlag!=null && errFlag.equals("1")) {
						int money = Integer.parseInt("100원");
					}
					
					//3. DB처리2 : 구매한 티켓 매수에 대한 처리로 5장 이하만 구매 가능.
					int result2 = dao.ticketInsert(ticketDTO);
					if(result2==1) System.out.println("transactino_ticket 입력성공");
					
					model.addAttribute("ticketDTO", ticketDTO);
					model.addAttribute("payDTO", payDTO);
					
					//템플릿에서는 마지막에 commit()을 실행하지 않아도 된다.
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			//작업에 오류가 있는 경우에도 별도의 rollback 실행이 필요하지 않다.
			viewPath = "error";
		}
		
		return viewPath;
	}
	
}
