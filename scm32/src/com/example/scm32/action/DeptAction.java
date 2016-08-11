package com.example.scm32.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.scm32.entity.Dept;
import com.example.scm32.service.DeptService;

@Controller
@RequestMapping(value="/dept")
public class DeptAction {
	@Resource
	private DeptService deptService;
	
	@RequestMapping(value="/insert")
	public String insert(Dept dept){
		System.out.println("---action.dept:"+dept);
		try {
			deptService.insertDept(dept);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "forward:/jsp/main.jsp";
	}
}


