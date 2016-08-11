package com.example.scm32.action;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/base")
public class BaseAction {
	@Resource
	public ServletContext application;
	
//	@RequestMapping()
//	public String goURL(String filedir,String fileName){
//		return "forward:/WEB-INF/"+filedir+"/"+fileName;
//	}
//	
	//方法参数folder通过@PathVariable指定其值可以从@RequestMapping的{folder}获取，同理file也一样
	@RequestMapping("/goURL/{folder}/{file}")
	public String goURL(@PathVariable String folder,@PathVariable String file) {
		System.out.println("goURL.folder|file===" + folder+"/"+file);
		return "forward:/WEB-INF/"+folder+"/"+file+".jsp";
	}

}
