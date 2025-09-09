package com.edu.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.springboot.jdbc.ITicketService;
import com.edu.springboot.jdbc.PayDTO;
import com.edu.springboot.jdbc.TicketDTO;

import jakarta.servlet.http.HttpServletRequest;
import oracle.jdbc.internal.OracleConnection.TransactionState;

@Controller
public class MainController {
	
	//Mybatis 사용을 위한 인터페이스 자동주입
	@Autowired
	ITicketService dao;
	
	/*
	 * 트랜젝션 처리를 위한 빈 자동주입. 별도의 설정 없이 스프링 컨테이너가
	 * 미리 생성해둔 것을 즉시 주입받아 사용할 수 있다.
	 */
	@Autowired
	PlatformTransactionManager transactionManager;
	
	@Autowired
	TransactionDefinition definition;
	
	@RequestMapping("/")
	public String main() {
		return "main";
	}
	
	@GetMapping("/buyTicket.do")
	public String buy1() {
		return "buy";
	}
	
	/*
	 * 폼값을 받기 위한 DTO객체와 request내장객체, Model객체로 매개변수 선언
	 */
	@PostMapping("/buyTicket.do")
	public String buy2(TicketDTO ticketDTO, PayDTO payDTO,
			HttpServletRequest req, Model model) {
		
		//구매에 성공한 경우 포워드할 jsp 경로.
		String viewPath = "success";
		/*
		 * 자동주입된 빈을 통해 Status 인스턴스를 생성한다. 이를 통해 트랜젝션 처리를
		 * 할 수 있다. 전체 작업에 대해 성공이면 commit, 실패라면 rollback 처리를 하게 됨.
		 */
		TransactionStatus status = transactionManager.getTransaction(definition);
		try {
			//1. DB처리1 : 구매금액에 관련된 입금처리. 티켓매수 * 10000원
			payDTO.setAmount(ticketDTO.getT_count() * 10000);
			int result1 = dao.payInsert(payDTO);
			if(result1 == 1) System.out.println("transaction_pay 입력성공");
			
			//2. 비즈니스로직 처리(의도적인 에러발생)
			String errFlag = req.getParameter("err_flag");
			if(errFlag!=null) {
				/*
				 * 구매페이지에서 체크박스에 체크한 경우 이 코드가 실행되어 예외가 발생.
				 * 문자는 정수로 변환할 수 없으므로 NumberFormatException이 발생된다.
				 */
				int money = Integer.parseInt("100원");
			}
			
			//3. DB처리2 : 구매한 티켓 매수에 대한 처리로 5장 이하만 구매 가능.
			int result2 = dao.ticketInsert(ticketDTO);
			/*
			 * check 제약조건에 의해 5장을 초과하면 DB에러가 발생된다.
			 * insert에 성공 시 로그 출력.
			 */
			if(result2==1) System.out.println("transactino_ticket 입력성공");
			
			model.addAttribute("ticketDTO", ticketDTO);
			model.addAttribute("payDTO", payDTO);
			
			//모든 작업이 정상적으로 처리되면 commit 메서드를 실행.
			transactionManager.commit(status);
		} catch (Exception e) {
			e.printStackTrace();
			//3개의 작업 중 1개라도 문제가 생기면 error페이지로 포워드
			viewPath = "error";
			//전체 작업을 rollback해서 초기화한다.
			transactionManager.rollback(status);
		}
		
		return viewPath;
	}
	
	
	
}
