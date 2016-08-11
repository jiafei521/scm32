package com.example.scm32.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.scm32.entity.Page;
import com.example.scm32.entity.Supplier;
import com.example.scm32.service.SupplierService;

@Controller
@RequestMapping("/supplier")
public class SupplierAction extends BaseAction {
	@Resource
	private SupplierService supplierService;
	
	@RequestMapping(value="/insert")
	@ResponseBody//如果返回json格式，需要这个注解，这里用来测试环境
	public Object insert(Supplier supplier){
		//System.out.println("---action.supplier:"+supplier);
		int i = 0;
		try {
			i = supplierService.insert(supplier);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	@RequestMapping("/doAjax")
	@ResponseBody//如果返回json格式，需要这个注解，这里用来测试环境
	public Object doAjax(Supplier supplier){
		System.out.println("---doAjax.supplier:"+supplier);
		supplier.setSupName("supName1");
		return supplier;
	}
	@RequestMapping("/update")
	@ResponseBody//如果返回json格式，需要这个注解，这里用来测试环境
	public Object update(Supplier supplier){
//		System.out.println("---doAjax.supplier:"+supplier);
//		supplier.setSupName("supName1");
		int i = 0;
		try {
			i = supplierService.update(supplier);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return i;
	}
	@RequestMapping("/deleteList")
	@ResponseBody//如果返回json格式，需要这个注解，这里用来测试环境
	public Object deleteList(String[] pks){
//		for (String string : pks) {
//			System.out.println(string);
//		}
		int i = 0;
		try {
			i = supplierService.deleteList(pks);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return i;
	}
	
//	@RequestMapping("/selectPage")
//	@ResponseBody//如果返回json格式，需要这个注解，这里用来测试环境
//	public Object selectPage(Page<Supplier> page){
//		page = supplierService.selectPage(page);
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("total", page.getTotalRecord());
//		map.put("rows",page.getList());
//		return map;
//	}
	
	@RequestMapping("/selectPageUseDyc")
	@ResponseBody//如果返回json格式，需要这个注解，这里用来测试环境
	public Object selectPageUseDyc(Page<Supplier> page,Supplier supplier){
		System.out.println("supplier--------"+supplier);
		//System.out.println("page-------------"+page);
		page.setParamEntity(supplier);
		page = supplierService.selectPageUseDyc(page);
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("total", page.getTotalRecord());
//		map.put("rows",page.getList());
		return page.getMap();
	}
	


}
