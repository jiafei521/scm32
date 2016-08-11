package com.example.scm32.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.scm32.entity.Goods;
import com.example.scm32.entity.Page;
import com.example.scm32.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsAction extends BaseAction{
	
	@Resource
	private GoodsService goodsService;
	
	@RequestMapping("/doAjax")
	@ResponseBody//如果返回json格式，需要这个注解，这里用来测试环境
	public Object doAjax(Goods goods){
		System.out.println("---doAjax.goods:"+goods);
		//supplier.setSupName("supName1");
		return goods;
	}
	@RequestMapping("/selectPageUseDyc")
	@ResponseBody//如果返回json格式，需要这个注解，这里用来测试环境
	public Object selectPageUseDyc(Page<Goods> page,Goods goods){
		System.out.println("page----------"+page);
		System.out.println("goods--------"+goods);
		page.setParamEntity(goods);
		page = goodsService.selectPageUseDyc(page);
		return page.getMap();
	}
	
	@RequestMapping("/deleteList")
	@ResponseBody//如果返回json格式，需要这个注解，这里用来测试环境
	public Object deleteList(String[] pks){
//		for (String string : pks) {
//			System.out.println(string);
//		}
		int i = 0;
		try {
			i = goodsService.deleteList(pks);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return i;
	}
	
	@RequestMapping(value="/insert")
	@ResponseBody//如果返回json格式，需要这个注解，这里用来测试环境
	public Object insert(Goods goods){
		System.out.println("goods--------------"+goods);
		int i = 0;
		try {
			i = goodsService.insert(goods);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	@RequestMapping("/update")
	@ResponseBody//如果返回json格式，需要这个注解，这里用来测试环境
	public Object update(Goods goods){
//		System.out.println("---doAjax.supplier:"+supplier);
//		supplier.setSupName("supName1");
		int i = 0;
		try {
			i = goodsService.update(goods);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return i;
	}

}
