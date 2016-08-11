package com.example.scm32.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.scm32.entity.Account;
import com.example.scm32.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountAction {
	
	@Resource
	private AccountService accountService;
	
	//可以通过这样注入request 和session
	@RequestMapping("/login")
	public String login(Account account,HttpServletRequest request,HttpSession session){
		System.out.println(account.getAccLogin());
		Account ac = accountService.login(account);
		//System.out.println(ac);
		if(ac!=null){
			//放session
			session.setAttribute("userinfo", ac);
		}else{
			//提示信息
			request.setAttribute("msg", "你的用户名或密码错误呦~亲");
			//返回登陆页面
			return "forward:/login.jsp";
		}
		return "forward:/WEB-INF/main/main.jsp";
	}

}
